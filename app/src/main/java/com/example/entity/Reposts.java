
package com.example.entity;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Reposts {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("user_reposted")
    @Expose
    private Integer userReposted;

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
     *     The userReposted
     */
    public Integer getUserReposted() {
        return userReposted;
    }

    /**
     * 
     * @param userReposted
     *     The user_reposted
     */
    public void setUserReposted(Integer userReposted) {
        this.userReposted = userReposted;
    }

}
