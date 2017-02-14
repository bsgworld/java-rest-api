/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsg.rest.api.hlr;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author BSG Company
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "error",
    "msisdn",
    "reference",
    "tariff_code",
    "price",
    "currency",
    "id",
    "callback_url",
    "errorDescription"
})
public class Hlr {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("tariff_code")
    private String tariffCode;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("id")
    private String id;
    @JsonProperty("callback_url")
    private String callbackUrl;
    @JsonProperty("errorDescription")
    private String errorDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public Hlr() {
    }

    /**
     ** Get the error code
     *
     * @return error code
     */
    @JsonProperty("error")
    public Integer getError() {
        return error;
    }

    /**
     ** Sets the error code
     *
     * @param error
     */
    @JsonProperty("error")
    public void setError(Integer error) {
        this.error = error;
    }

    /**
     * Get the phone number
     *
     * @return phone number
     */
    @JsonProperty("msisdn")
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * Sets the phone number
     *
     * @param msisdn phone number
     */
    @JsonProperty("msisdn")
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * Get the external id
     *
     * @return external id
     */
    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    /**
     * Sets the external id
     *
     * @param reference external id
     */
    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Get the tariff number. An integer from 0 to 9.
     *
     * @return tariff number. An integer from 0 to 9.
     */
    @JsonProperty("tariff_code")
    public String getTariffCode() {
        return tariffCode;
    }

    /**
     * Sets the tariff number. An integer from 0 to 9
     *
     * @param tariffCode tariff number. An integer from 0 to 9
     */
    @JsonProperty("tariff_code")
    public void setTariffCode(String tariffCode) {
        this.tariffCode = tariffCode;
    }

    /**
     * Get the request costs
     *
     * @return request costs
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the procedure costs
     *
     * @param price procedure costs
     */
    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Get the currency name
     *
     * @return currency name
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Get the currency name
     *
     * @param currency currency name
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Get the service internal id
     *
     * @return service internal id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Sets the service internal id
     *
     * @param id service internal id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the URL for service response
     *
     * @return URL for service response
     */
    @JsonProperty("callback_url")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * Sets the URL for service response
     *
     * @param callbackUrl URL for service response
     */
    @JsonProperty("callback_url")
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * Get error description
     *
     * @return error description
     */
    @JsonProperty("errorDescription")
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets error description
     *
     * @param errorDescription error description
     */
    @JsonProperty("errorDescription")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    /**
     * Method for backward compatibility
     *
     * @return
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Method for backward compatibility
     *
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    /**
     * Check response for errors. True if service response has errors. False if
     * service response has no errors
     *
     * @return error &gt; 0
     */
    public boolean isError() {
        if (error != null) {
            return error > 0;
        }
        throw new NullPointerException("No response from service");
    }
}
