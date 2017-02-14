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
    "to",
    "text",
    "alpha_name",
    "is_promotional",
    "options"
})
public class Message {

    @JsonProperty("to")
    private List<Recipient> recipients = null;
    @JsonProperty("text")
    private String text;
    @JsonProperty("alpha_name")
    private String alphaName;
    @JsonProperty("is_promotional")
    private Boolean isPromotional;
    @JsonProperty("options")
    private Options options;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Create a new instance.
     *
     */
    @JsonCreator
    public Message() {
    }

    /**
     * Get the recipient list
     *
     * @return recipient list
     */
    @JsonProperty("to")
    public List<Recipient> getRecipients() {
        return recipients;
    }

    /**
     * Sets the recipient list
     *
     * @param recipients recipient list
     */
    @JsonProperty("to")
    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

    /**
     * Get the message text
     *
     * @return message text
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * Sets the message text
     *
     * @param text message text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get the sender name
     *
     * @return sender name
     */
    @JsonProperty("alpha_name")
    public String getAlphaName() {
        return alphaName;
    }

    /**
     * Sets the sender name
     *
     * @param alphaName sender name
     */
    @JsonProperty("alpha_name")
    public void setAlphaName(String alphaName) {
        this.alphaName = alphaName;
    }

    /**
     * Get the promotional attribute
     *
     * @return promotional attribute
     */
    @JsonProperty("is_promotional")
    public Boolean getIsPromotional() {
        return isPromotional;
    }

    /**
     * Sets the promotional attribute
     *
     * @param isPromotional promotional attribute
     */
    @JsonProperty("is_promotional")
    public void setIsPromotional(Boolean isPromotional) {
        this.isPromotional = isPromotional;
    }

    /**
     * Get the additional options
     *
     * @return additional options
     */
    @JsonProperty("options")
    public Options getOptions() {
        return options;
    }

    /**
     * Sets the additional options
     *
     * @param options additional options
     */
    @JsonProperty("options")
    public void setOptions(Options options) {
        this.options = options;
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
