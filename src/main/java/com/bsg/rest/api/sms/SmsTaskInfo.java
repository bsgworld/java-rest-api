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
    "error",
    "errorDescription",
    "originator",
    "body",
    "validity",
    "totalprice",
    "currency",
    "sent",
    "delivered",
    "expired",
    "undeliverable",
    "unknown"
})
public class SmsTaskInfo {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("errorDescription")
    private String errorDescription;
    @JsonProperty("originator")
    private String originator;
    @JsonProperty("body")
    private String body;
    @JsonProperty("validity")
    private Integer validity;
    @JsonProperty("totalprice")
    private Double totalprice;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("sent")
    private Integer sent;
    @JsonProperty("delivered")
    private Integer delivered;
    @JsonProperty("expired")
    private Integer expired;
    @JsonProperty("undeliverable")
    private Integer undeliverable;
    @JsonProperty("unknown")
    private Integer unknown;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public SmsTaskInfo() {
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
     * Get the total request costs
     *
     * @return total request costs
     */
    @JsonProperty("totalprice")
    public Double getTotalprice() {
        return totalprice;
    }

    /**
     * Sets the total request costs
     *
     * @param totalprice total request costs
     */
    @JsonProperty("totalprice")
    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
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
     * Get the sended messaged count
     *
     * @return sended messaged count
     */
    @JsonProperty("sent")
    public Integer getSent() {
        return sent;
    }

    /**
     * Sets the sended messaged count
     *
     * @param sent sended messaged count
     */
    @JsonProperty("sent")
    public void setSent(Integer sent) {
        this.sent = sent;
    }

    /**
     * Get the delivered messaged count
     *
     * @return delivered messaged count
     */
    @JsonProperty("delivered")
    public Integer getDelivered() {
        return delivered;
    }

    /**
     * Sets the delivered messaged count
     *
     * @param delivered delivered messaged count
     */
    @JsonProperty("delivered")
    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    /**
     * Get the expired messaged count
     *
     * @return expired messaged count
     */
    @JsonProperty("expired")
    public Integer getExpired() {
        return expired;
    }

    /**
     * Sets the expired messaged count
     *
     * @param expired expired messaged count
     */
    @JsonProperty("expired")
    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    /**
     * Get the undeliverable messaged count
     *
     * @return undeliverable messaged count
     */
    @JsonProperty("undeliverable")
    public Integer getUndeliverable() {
        return undeliverable;
    }

    /**
     * Sets the undeliverable messaged count
     *
     * @param undeliverable undeliverable messaged count
     */
    @JsonProperty("undeliverable")
    public void setUndeliverable(Integer undeliverable) {
        this.undeliverable = undeliverable;
    }

    /**
     * Get the messaged count with unknown status
     *
     * @return messaged count with unknown status
     */
    @JsonProperty("unknown")
    public Integer getUnknown() {
        return unknown;
    }

    /**
     * Sets the messaged count with unknown status
     *
     * @param unknown messaged count with unknown status
     */
    @JsonProperty("unknown")
    public void setUnknown(Integer unknown) {
        this.unknown = unknown;
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
