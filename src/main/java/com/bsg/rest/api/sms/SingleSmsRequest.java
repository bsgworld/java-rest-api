/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsg.rest.api.sms;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 *
 * @author BSG Company
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destination",
    "originator",
    "body",
    "msisdn",
    "reference",
    "validity",
    "tariff"
})
public class SingleSmsRequest {

    @JsonProperty("destination")
    private String destination = "phone";
    @JsonProperty("originator")
    private String originator;
    @JsonProperty("body")
    private String body;
    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("validity")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer validity;
    @JsonProperty("tariff")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer tariff;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public SingleSmsRequest() {
    }

    /**
     *
     * @param originator
     * @param body
     * @param msisdn phone number
     * @param reference external id
     * @param validity
     * @param tariff tariff number. An integer from 0 to 9. Leave it or set null
     * for default
     */
    public SingleSmsRequest(String originator, String body, String msisdn, String reference, Integer validity, Integer tariff) {
        this.originator = originator;
        this.body = body;
        this.msisdn = msisdn;
        this.reference = reference;
        this.validity = validity;
        this.tariff = tariff;
    }

    /**
     * Get the request type
     *
     * @return request type
     */
    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    /**
     * Get the sender name
     *
     * @return sender name
     */
    @JsonProperty("originator")
    public String getOriginator() {
        return originator;
    }

    /**
     * Sets the sender name
     *
     * @param originator sender name
     */
    @JsonProperty("originator")
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    /**
     * Get the SMS text
     *
     * @return SMS text
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * Sets the SMS text
     *
     * @param body SMS text
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
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
     * Get the validity period. The period must be between 0 and 72 hours
     *
     * @return validity period
     */
    @JsonProperty("validity")
    public Integer getValidity() {
        return validity;
    }

    /**
     * Sets the validity period. The period must be between 0 and 72 hours
     *
     * @param validity validity period
     */
    @JsonProperty("validity")
    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    /**
     * Get request tariff number. The value between 0 and 9
     *
     * @return request tariff number
     */
    @JsonProperty("tariff")
    public Integer getTariff() {
        return tariff;
    }

    /**
     * Sets the tariff number. An integer from 0 to 9
     *
     * @param tariff tariff number. An integer from 0 to 9. Leave it or set null
     * for default
     */
    @JsonProperty("tariff")
    public void setTariff(Integer tariff) {
        this.tariff = tariff;
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

}
