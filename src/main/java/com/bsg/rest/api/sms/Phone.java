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

/**
 *
 * @author BSG Company
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "msisdn",
    "reference"
})
public class Phone {

    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("reference")
    private String reference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public Phone() {
    }

    /**
     *
     * @param msisdn phone number
     * @param reference external id
     */
    public Phone(String msisdn, String reference) {
        this.msisdn = msisdn;
        this.reference = reference;
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
