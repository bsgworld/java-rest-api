package com.bsg.rest.api.viber;

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
    "viber"
})
public class Options {

    @JsonProperty("viber")
    private SenderViber senderViber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public Options() {
    }

    /**
     *
     * @param senderViber
     */
    public Options(SenderViber senderViber) {
        this.senderViber = senderViber;
    }

    /**
     *
     * @return
     */
    @JsonProperty("viber")
    public SenderViber getSenderViber() {
        return senderViber;
    }

    /**
     *
     * @param senderViber
     */
    @JsonProperty("viber")
    public void setSenderViber(SenderViber senderViber) {
        this.senderViber = senderViber;
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
