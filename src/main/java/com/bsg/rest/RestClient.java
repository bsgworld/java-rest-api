/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsg.rest;

import com.bsg.rest.api.Balance;
import java.io.Closeable;
import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Client to work with BSG REST API. Only balance method.
 *
 * @author BSG
 */
public abstract class RestClient implements Closeable {

    private Client client;
    private String serviceUrl = DEFAULT_SERVICE_URL;
    private String apiKey;

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     */
    public RestClient(String apiKey) {
        this.client = ClientBuilder.newClient();
        this.apiKey = apiKey;
    }

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     * @param serviceUrl the service URL
     */
    public RestClient(String apiKey, String serviceUrl) {
        this.client = ClientBuilder.newClient();
        this.serviceUrl = serviceUrl;
        this.apiKey = apiKey;
    }

    /**
     * Sets the service URL
     *
     * @param serviceUrl the service URL
     */
    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    /**
     * Sets the X-API-KEY
     *
     * @param apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Get the service URL
     *
     * @return
     */
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * Get the X-API-KEY
     *
     * @return
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Retrieve balance amount.
     *
     * @return your balance data
     */
    public Balance getBalance() {
        WebTarget webTarget = client.target(serviceUrl).path(GET_BALANCE_METHOD);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", apiKey);
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        Balance balance = response.readEntity(Balance.class);
        response.close();
        return balance;
    }

    @Override
    public void close() throws IOException {
        client.close();
    }

    /**
     * Get the jersey client to enable logging, set timeouts etc.
     *
     * @return the jersey client
     */
    public Client getJerseyClient() {
        return client;
    }

    private static final String DEFAULT_SERVICE_URL = "https://app.bsg.hk/rest";

    private static final String GET_BALANCE_METHOD = "common/balance";

}
