/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsg.rest;

import com.bsg.rest.api.Balance;
import com.bsg.rest.api.MessageInfo;
import com.bsg.rest.api.hlr.HlrData;
import com.bsg.rest.api.hlr.HlrInfo;
import com.bsg.rest.api.PricesData;
import com.bsg.rest.api.hlr.HlrRequest;
import com.bsg.rest.api.sms.MultipleSmsData;
import com.bsg.rest.api.sms.MultipleSmsRequest;
import com.bsg.rest.api.sms.SingleSmsData;
import com.bsg.rest.api.sms.SingleSmsRequest;
import com.bsg.rest.api.sms.SmsTaskInfo;
import com.bsg.rest.api.viber.ViberMessageData;
import com.bsg.rest.api.viber.ViberMessageRequest;
import java.io.Closeable;
import java.util.ArrayList;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Client to work with BSG SMS API.
 *
 * @author BSG
 */
public class SmsClient extends RestClient implements Closeable {

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     */
    public SmsClient(String apiKey) {
        super(apiKey);
    }

    /**
     * Create a new instance.
     *
     * @param apiKey the X-API-KEY
     * @param serviceUrl the service URL
     */
    public SmsClient(String apiKey, String serviceUrl) {
        super(apiKey, serviceUrl);
    }

    /**
     * Create a new SMS.
     *
     * @param originator sender name
     * @param body SMS text
     * @param msisdn phone number
     * @param reference external id
     * @param validity validity period. The period must be between 0 and 72
     * hours
     * @param tariff tariff number. An integer from 0 to 9. Set null for default
     * @return created SMS data
     */
    public SingleSmsData createSms(String originator, String body, String msisdn, String reference, Integer validity, Integer tariff) {
        return createSms(new SingleSmsRequest(originator, body, msisdn, reference, validity, tariff));
    }

    /**
     * Create a new SMS.
     *
     * @param smsRequest
     * @return created SMS data
     */
    public SingleSmsData createSms(SingleSmsRequest smsRequest) {
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(SMS_CREATE_METHOD);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.MULTIPART_FORM_DATA).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.put(Entity.entity(smsRequest, MediaType.APPLICATION_JSON));
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        SingleSmsData smsData = response.readEntity(SingleSmsData.class);
        response.close();
        return smsData;
    }

    /**
     * Create a new SMS.
     *
     * @param smsRequest
     * @return created SMS data
     */
    public MultipleSmsData createSms(MultipleSmsRequest smsRequest) {
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(SMS_CREATE_METHOD);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.MULTIPART_FORM_DATA).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.put(Entity.entity(smsRequest, MediaType.APPLICATION_JSON));
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        MultipleSmsData smsData = response.readEntity(MultipleSmsData.class);
        response.close();
        return smsData;
    }

    /**
     * Retrieve the information of specific SMS.
     *
     * @param id created SMS id from response
     * @return SMS info
     */
    public MessageInfo getSmsInfo(String id) {
        if (id == null) {
            throw new NullPointerException("Request ID is null");
        }
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(SMS_GET_INFO_BY_ID_METHOD).path(id);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        MessageInfo messageInfo = response.readEntity(MessageInfo.class);
        response.close();
        return messageInfo;
    }

    /**
     * Retrieve the information of specific SMS by reference.
     *
     * @param reference external id from request
     * @return SMS info
     */
    public MessageInfo getSmsInfoByReference(String reference) {
        if (reference == null) {
            throw new NullPointerException("Request ID is null");
        }
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(SMS_GET_INFO_BY_REFERENCE_METHOD).path(reference);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        MessageInfo messageInfo = response.readEntity(MessageInfo.class);
        response.close();
        return messageInfo;
    }

    /**
     * Retrieve the information of specific SMS task.
     *
     * @param taskId created SMS task id from response
     * @return SMS task info
     */
    public SmsTaskInfo getSmsTaskInfo(String taskId) {
        if (taskId == null) {
            throw new NullPointerException("Request task ID is null");
        }
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(SMS_GET_TASK_INFO_BY_ID_METHOD).path(taskId);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("X-API-KEY", getApiKey());
        Response response = invocationBuilder.get();
        response.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON);
        SmsTaskInfo smsTaskInfo = response.readEntity(SmsTaskInfo.class);
        response.close();
        return smsTaskInfo;
    }

    /**
     * Retrieve the prices of default SMS tariff.
     *
     * @return SMS prices
     */
    public PricesData getSmsPrices() {
        return getSmsPrices(null);
    }

    /**
     * Retrieve the prices of specific SMS tariff.
     *
     * @param tariff tariff number. An integer from 0 to 9. Set null for default
     * @return SMS prices
     */
    public PricesData getSmsPrices(Integer tariff) {
        WebTarget webTarget = getJerseyClient().target(getServiceUrl()).path(SMS_GET_PRICES_METHOD);
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

    private static final String SMS_CREATE_METHOD = "sms/create";
    private static final String SMS_GET_PRICES_METHOD = "sms/prices";
    private static final String SMS_GET_INFO_BY_ID_METHOD = "sms/";
    private static final String SMS_GET_TASK_INFO_BY_ID_METHOD = "sms/task";
    private static final String SMS_GET_INFO_BY_REFERENCE_METHOD = "sms/reference";

}
