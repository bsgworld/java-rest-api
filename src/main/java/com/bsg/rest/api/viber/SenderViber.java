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
    "img",
    "caption",
    "action"
})
public class SenderViber {

    @JsonProperty("img")
    private String img;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("action")
    private String action;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public SenderViber() {
    }

    /**
     *
     * @param img
     * @param caption
     * @param action
     */
    public SenderViber(String img, String caption, String action) {
        this.img = img;
        this.caption = caption;
        this.action = action;
    }

    /**
     *
     * @return
     */
    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    /**
     *
     * @param img
     */
    @JsonProperty("img")
    public void setImg(String img) {
        this.img = img;
    }

    /**
     *
     * @return
     */
    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption
     */
    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     *
     * @return
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     *
     * @param action
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
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
