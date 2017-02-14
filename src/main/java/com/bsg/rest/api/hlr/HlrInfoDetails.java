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

/**
 *
 * @author BSG Company
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imsi",
    "location_msc",
    "ported",
    "roaming"
})
public class HlrInfoDetails {

    @JsonProperty("imsi")
    private String imsi;
    @JsonProperty("location_msc")
    private String locationMsc;
    @JsonProperty("ported")
    private Integer ported;
    @JsonProperty("roaming")
    private Integer roaming;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public HlrInfoDetails() {
    }

    /**
     *
     * @return
     */
    @JsonProperty("imsi")
    public String getImsi() {
        return imsi;
    }

    /**
     *
     * @param imsi
     */
    @JsonProperty("imsi")
    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    /**
     *
     * @return
     */
    @JsonProperty("location_msc")
    public String getLocationMsc() {
        return locationMsc;
    }

    /**
     *
     * @param locationMsc
     */
    @JsonProperty("location_msc")
    public void setLocationMsc(String locationMsc) {
        this.locationMsc = locationMsc;
    }

    /**
     *
     * @return
     */
    @JsonProperty("ported")
    public Integer getPorted() {
        return ported;
    }

    /**
     *
     * @param ported
     */
    @JsonProperty("ported")
    public void setPorted(Integer ported) {
        this.ported = ported;
    }

    /**
     *
     * @return
     */
    @JsonProperty("roaming")
    public Integer getRoaming() {
        return roaming;
    }

    /**
     *
     * @param roaming
     */
    @JsonProperty("roaming")
    public void setRoaming(Integer roaming) {
        this.roaming = roaming;
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
