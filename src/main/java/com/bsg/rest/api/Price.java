package com.bsg.rest.api;

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
    "type",
    "country",
    "country_name",
    "mcc",
    "price",
    "currency"
})
public class Price {

    @JsonProperty("type")
    private String type;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("mcc")
    private String mcc;
    @JsonProperty("price")
    private String price;
    @JsonProperty("currency")
    private String currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public Price() {
    }

    /**
     * Get the request type
     *
     * @return request type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Sets the request type
     *
     * @param type request type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the country A2 code
     *
     * @return country A2 code
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country A2 code
     *
     * @param country country A2 code
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the country name
     *
     * @return country name
     */
    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the country name
     *
     * @param countryName country name
     */
    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return
     */
    @JsonProperty("mcc")
    public String getMcc() {
        return mcc;
    }

    /**
     * Get the MCC
     *
     * @param mcc MCC
     */
    @JsonProperty("mcc")
    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    /**
     * Sets the MCC
     *
     * @return MCC
     */
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    /**
     * Sets the request costs
     *
     * @param price request costs
     */
    @JsonProperty("price")
    public void setPrice(String price) {
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
