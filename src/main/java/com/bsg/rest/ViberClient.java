/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsg.rest;

import com.bsg.rest.api.MessageInfo;
import com.bsg.rest.api.PricesData;
import com.bsg.rest.api.viber.ViberMessageData;
import com.bsg.rest.api.viber.ViberMessageRequest;
import java.io.Closeable;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Client to work with BSG Viber API.
 *
 * @author BSG
 */
public class ViberClient extends RestClient implements Closeable {

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     */
    public ViberClient(String apiKey) {
        super(apiKey);
    }

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     * @param serviceUrl the service URL
     */
    public ViberClient(String apiKey, String serviceUrl) {
        super(apiKey, serviceUrl);
    }

    /**
     * Create a new Viber message.
     *
     * @param viberMessageRequest
     * @return created Viber Message data
     */
    public ViberMessageData createViberMessage(ViberMessageRequest viberMessageRequest) {
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(VIBER_CREATE_METHOD);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.MULTIPART_FORM_DATA).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.put(Entity.entity(viberMessageRequest, MediaType.APPLICATION_JSON));
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        ViberMessageData viberMessageData = response.readEntity(ViberMessageData.class);
        response.close();
        return viberMessageData;
    }

    /**
     * Retrieve the information of specific Viber.
     *
     * @param id created Viber message id from response
     * @return Viber message info
     */
    public MessageInfo getViberMessageInfo(String id) {
        if (id == null) {
            throw new NullPointerException("Request ID is null");
        }
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(VIBER_GET_INFO_BY_ID_METHOD).path(id);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        MessageInfo messageInfo = response.readEntity(MessageInfo.class);
        response.close();
        return messageInfo;
    }

    /**
     * Retrieve the information of specific Viber by reference.
     *
     * @param reference external id from request
     * @return Viber message info
     */
    public MessageInfo getViberMessageInfoByReference(String reference) {
        if (reference == null) {
            throw new NullPointerException("Request ID is null");
        }
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(VIBER_GET_INFO_BY_REFERENCE_METHOD).path(reference);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        MessageInfo messageInfo = response.readEntity(MessageInfo.class);
        response.close();
        return messageInfo;
    }

    /**
     * Retrieve the prices of your default Viber tariff.
     *
     * @return Viber prices
     */
    public PricesData getViberPrices() {
        return getViberPrices(null);
    }

    /**
     * Retrieve the prices of specific Viber tariff.
     *
     * @param tariff tariff number. An integer from 0 to 9. Set null for default
     * @return Viber prices
     */
    public PricesData getViberPrices(Integer tariff) {
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(VIBER_GET_PRICES_METHOD);
        if (tariff != null) {
            webTarget = webTarget.path(tariff.toString());
        }
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        PricesData pricesData = response.readEntity(PricesData.class);
        response.close();
        return pricesData;
    }

    private static final String VIBER_CREATE_METHOD = "viber/create";
    private static final String VIBER_GET_PRICES_METHOD = "viber/prices";
    private static final String VIBER_GET_INFO_BY_ID_METHOD = "viber/";
    private static final String VIBER_GET_INFO_BY_REFERENCE_METHOD = "viber/reference";

}
