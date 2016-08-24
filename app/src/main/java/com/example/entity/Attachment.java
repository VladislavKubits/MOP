
package com.example.entity;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Attachment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("link")
    @Expose
    private Link link;

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The link
     */
    public Link getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(Link link) {
        this.link = link;
    }

}
