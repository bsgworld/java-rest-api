package com.bsg.rest.api;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;

/**
 *
 * @author BSG Company
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "error",
    "errorDescription",
    "id",
    "msisdn",
    "reference",
    "time_in",
    "time_sent",
    "time_dr",
    "status",
    "price",
    "currency"
})
public class MessageInfo {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("errorDescription")
    private String errorDescription;
    @JsonProperty("id")
    private String id;
    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("time_in")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeIn;
    @JsonProperty("time_sent")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeSent;
    @JsonProperty("time_dr")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeDr;
    @JsonProperty("status")
    private String status;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("currency")
    private String currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public MessageInfo() {
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
     * Sets error description
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
     *
     * @return
     */
    @JsonProperty("time_in")
    public Date getTimeIn() {
        return timeIn;
    }

    /**
     *
     * @param timeIn
     */
    @JsonProperty("time_in")
    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    /**
     *
     * @return
     */
    @JsonProperty("time_sent")
    public Date getTimeSent() {
        return timeSent;
    }

    /**
     *
     * @param timeSent
     */
    @JsonProperty("time_sent")
    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    /**
     *
     * @return
     */
    @JsonProperty("time_dr")
    public Date getTimeDr() {
        return timeDr;
    }

    /**
     *
     * @param timeDr
     */
    @JsonProperty("time_dr")
    public void setTimeDr(Date timeDr) {
        this.timeDr = timeDr;
    }

    /**
     * Get the request status
     *
     * @return request status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Sets the request status
     *
     * @param status request status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
     * Sets the request costs
     *
     * @param price request costs
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
