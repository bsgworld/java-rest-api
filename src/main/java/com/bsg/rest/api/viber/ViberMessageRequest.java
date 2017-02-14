package com.bsg.rest.api.viber;

import java.util.HashMap;
import java.util.List;
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
    "tariff",
    "validity",
    "messages"
})
public class ViberMessageRequest {

    @JsonProperty("tariff")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer tariff;
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty("validity")
    private Integer validity;
    @JsonProperty("messages")
    private List<Message> messages = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public ViberMessageRequest() {
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
     *
     * @return
     */
    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     */
    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
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
