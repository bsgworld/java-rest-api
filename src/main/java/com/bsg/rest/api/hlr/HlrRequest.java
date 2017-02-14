package com.bsg.rest.api.hlr;

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
    "msisdn",
    "reference",
    "tariff",
    "callback_url"
})
public class HlrRequest {

    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("tariff")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer tariff;
    @JsonProperty("callback_url")
    private String callbackUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public HlrRequest() {
    }

    /**
     *
     * @param msisdn phone number
     * @param reference external id
     * @param tariff tariff number. An integer from 0 to 9
     * @param callbackUrl URL for service response
     */
    public HlrRequest(String msisdn, String reference, Integer tariff, String callbackUrl) {
        this.msisdn = msisdn;
        this.reference = reference;
        this.tariff = tariff;
        this.callbackUrl = callbackUrl;
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
     * Get the tariff number. An integer from 0 to 9
     *
     * @return tariff number. An integer from 0 to 9. Leave it or set null for
     * default
     */
    @JsonProperty("tariff")
    public Integer getTariff() {
        return tariff;
    }

    /**
     * Sets the tariff number. An integer from 0 to 9
     *
     * @param tariff tariff number. An integer from 0 to 9
     */
    @JsonProperty("tariff")
    public void setTariff(Integer tariff) {
        this.tariff = tariff;
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
