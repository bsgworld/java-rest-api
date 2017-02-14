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

/**
 *
 * @author BSG Company
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "error",
    "errorDescription",
    "result",
    "currency",
    "total_price"
})
public class ViberMessageData {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("errorDescription")
    private String errorDescription;
    @JsonProperty("result")
    private List<ViberMessage> viberMessages = null;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("total_price")
    private Double totalPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public ViberMessageData() {
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
     * Get error description
     *
     * @return error description
     */
    @JsonProperty("errorDescription")
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the error description
     *
     * @param errorDescription error description
     */
    @JsonProperty("errorDescription")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
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

    /**
     *
     * @return
     */
    @JsonProperty("result")
    public List<ViberMessage> getViberMessages() {
        return viberMessages;
    }

    /**
     *
     * @param viberMessages
     */
    @JsonProperty("result")
    public void setViberMessages(List<ViberMessage> viberMessages) {
        this.viberMessages = viberMessages;
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
     * Get the total request costs
     *
     * @return total request costs
     */
    @JsonProperty("total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total request costs
     *
     * @param totalPrice total request costs
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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
