
package com.example.entity;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Comments {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("can_post")
    @Expose
    private Integer canPost;

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The canPost
     */
    public Integer getCanPost() {
        return canPost;
    }

    /**
     * 
     * @param canPost
     *     The can_post
     */
    public void setCanPost(Integer canPost) {
        this.canPost = canPost;
    }

}
