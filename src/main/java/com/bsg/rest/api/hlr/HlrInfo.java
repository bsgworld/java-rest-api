package com.bsg.rest.api.hlr;

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
    "name_ru",
    "name_en",
    "brand",
    "name",
    "msisdn",
    "id",
    "reference",
    "network",
    "status",
    "details",
    "createdDatetime",
    "statusDatetime"
})
public class HlrInfo {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("errorDescription")
    private String errorDescription;
    @JsonProperty("name_ru")
    private String nameRu;
    @JsonProperty("name_en")
    private String nameEn;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("name")
    private String name;
    @JsonProperty("msisdn")
    private String msisdn;
    @JsonProperty("id")
    private String id;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("network")
    private String network;
    @JsonProperty("status")
    private String status;
    @JsonProperty("details")
    private HlrInfoDetails details;
    @JsonProperty("createdDatetime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private Date createdDatetime;
    @JsonProperty("statusDatetime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private Date statusDatetime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public HlrInfo() {
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
     * Get the country name in Russian
     *
     * @return country name in Russian
     */
    @JsonProperty("name_ru")
    public String getNameRu() {
        return nameRu;
    }

    /**
     * Sets the country name in Russian
     *
     * @param nameRu country name in Russian
     */
    @JsonProperty("name_ru")
    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    /**
     * Get the country name in English
     *
     * @return country name in English
     */
    @JsonProperty("name_en")
    public String getNameEn() {
        return nameEn;
    }

    /**
     * Sets the country name in English
     *
     * @param nameEn country name in English
     */
    @JsonProperty("name_en")
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     *
     * @return
     */
    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
     * Get the phone mccmnc
     *
     * @return phone mccmnc
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Sets the phone mccmnc
     *
     * @param network phone mccmnc
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * Get the request status. Possible values: sent, absent, active, unknown,
     * failed
     *
     * @return request status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Sets the request status. Possible values: sent, absent, active, unknown,
     * failed
     *
     * @param status request status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the request datails
     *
     * @return request datails
     */
    @JsonProperty("details")
    public HlrInfoDetails getDetails() {
        return details;
    }

    /**
     * Sets the request datails
     *
     * @param details request datails
     */
    @JsonProperty("details")
    public void setDetails(HlrInfoDetails details) {
        this.details = details;
    }

    /**
     *
     * @return
     */
    @JsonProperty("createdDatetime")
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    /**
     *
     * @param createdDatetime
     */
    @JsonProperty("createdDatetime")
    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    /**
     *
     * @return
     */
    @JsonProperty("statusDatetime")
    public Date getStatusDatetime() {
        return statusDatetime;
    }

    /**
     *
     * @param statusDatetime
     */
    @JsonProperty("statusDatetime")
    public void setStatusDatetime(Date statusDatetime) {
        this.statusDatetime = statusDatetime;
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
