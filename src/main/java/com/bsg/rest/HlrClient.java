/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsg.rest;

import com.bsg.rest.api.hlr.HlrData;
import com.bsg.rest.api.hlr.HlrInfo;
import com.bsg.rest.api.PricesData;
import com.bsg.rest.api.hlr.HlrRequest;
import java.io.Closeable;
import java.util.ArrayList;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Client to work with BSG HLR API.
 *
 * @author BSG
 */
public class HlrClient extends RestClient implements Closeable {

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     */
    public HlrClient(String apiKey) {
        super(apiKey);
    }

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     * @param serviceUrl the service URL
     */
    public HlrClient(String apiKey, String serviceUrl) {
        super(apiKey, serviceUrl);
    }

    /**
     * Create a new HLR.
     *
     * @param msisdn phone number
     * @param reference external id
     * @param tariff tariff number. An integer from 0 to 9. Set null for default
     * @param callbackUrl URL for service response
     * @return created HLR data
     */
    public HlrData createHlr(String msisdn, String reference, Integer tariff, String callbackUrl) {
        return createHlr(new HlrRequest(msisdn, reference, tariff, callbackUrl));
    }

    /**
     * Create a new HLR.
     *
     * @param hlrRequest HLR request
     * @return created HLR data
     */
    public HlrData createHlr(HlrRequest hlrRequest) {
        List<HlrRequest> hlrRequests = new ArrayList<>();
        hlrRequests.add(hlrRequest);
        return createHlr(hlrRequests);
    }

    /**
     * Create a new HLR.
     *
     * @param hlrRequests List of HLR requests
     * @return created HLR data
     */
    public HlrData createHlr(List<HlrRequest> hlrRequests) {
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(HLR_CREATE_METHOD);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.MULTIPART_FORM_DATA).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.put(Entity.entity(hlrRequests, MediaType.APPLICATION_JSON));
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        HlrData hlrData = response.readEntity(HlrData.class);
        response.close();
        return hlrData;
    }

    /**
     * Retrieve the prices of default HLR tariff.
     *
     * @return HLR prices
     */
    public PricesData getHlrPrices() {
        return getHlrPrices(null);
    }

    /**
     * Retrieve the prices of specific HLR tariff.
     *
     * @param tariff tariff number. An integer from 0 to 9. Set null for default
     * @return HLR prices
     */
    public PricesData getHlrPrices(Integer tariff) {
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(HLR_GET_PRICES_METHOD);
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

    /**
     * Retrieve the information of specific HLR.
     *
     * @param id created HLR id from response
     * @return HLR info
     */
    public HlrInfo getHlrInfo(String id) {
        if (id == null) {
            throw new NullPointerException("Request ID is null");
        }
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(HLR_GET_INFO_BY_ID_METHOD).path(id);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        HlrInfo hlrInfo = response.readEntity(HlrInfo.class);
        response.close();
        return hlrInfo;
    }

    /**
     * Retrieve the information of specific HLR by Reference.
     *
     * @param reference external id from request
     * @return HLR info
     */
    public HlrInfo getHlrInfoByReference(String reference) {
        if (reference == null) {
            throw new NullPointerException("Request ID is null");
        }
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(HLR_GET_INFO_BY_REFERENCE_METHOD).path(reference);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        HlrInfo hlrInfo = response.readEntity(HlrInfo.class);
        response.close();
        return hlrInfo;
    }

    private static final String HLR_CREATE_METHOD = "hlr/create";
    private static final String HLR_GET_PRICES_METHOD = "hlr/prices";
    private static final String HLR_GET_INFO_BY_ID_METHOD = "hlr/";
    private static final String HLR_GET_INFO_BY_REFERENCE_METHOD = "hlr/reference";

}
