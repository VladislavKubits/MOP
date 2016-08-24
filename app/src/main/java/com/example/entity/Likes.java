
package com.example.entity;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Likes {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("user_likes")
    @Expose
    private Integer userLikes;
    @SerializedName("can_like")
    @Expose
    private Integer canLike;
    @SerializedName("can_publish")
    @Expose
    private Integer canPublish;

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
     *     The userLikes
     */
    public Integer getUserLikes() {
        return userLikes;
    }

    /**
     * 
     * @param userLikes
     *     The user_likes
     */
    public void setUserLikes(Integer userLikes) {
        this.userLikes = userLikes;
    }

    /**
     * 
     * @return
     *     The canLike
     */
    public Integer getCanLike() {
        return canLike;
    }

    /**
     * 
     * @param canLike
     *     The can_like
     */
    public void setCanLike(Integer canLike) {
        this.canLike = canLike;
    }

    /**
     * 
     * @return
     *     The canPublish
     */
    public Integer getCanPublish() {
        return canPublish;
    }

    /**
     * 
     * @param canPublish
     *     The can_publish
     */
    public void setCanPublish(Integer canPublish) {
        this.canPublish = canPublish;
    }

}
