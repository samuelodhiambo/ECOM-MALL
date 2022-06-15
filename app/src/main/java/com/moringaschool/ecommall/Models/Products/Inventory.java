
package com.moringaschool.ecommall.Models.Products;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inventory implements Serializable
{

    @SerializedName("managed")
    @Expose
    private Boolean managed;
    @SerializedName("available")
    @Expose
    private Integer available;
    private final static long serialVersionUID = 7661750103387610940L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Inventory() {
    }

    /**
     * 
     * @param managed
     * @param available
     */
    public Inventory(Boolean managed, Integer available) {
        super();
        this.managed = managed;
        this.available = available;
    }

    public Boolean getManaged() {
        return managed;
    }

    public void setManaged(Boolean managed) {
        this.managed = managed;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Inventory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("managed");
        sb.append('=');
        sb.append(((this.managed == null)?"<null>":this.managed));
        sb.append(',');
        sb.append("available");
        sb.append('=');
        sb.append(((this.available == null)?"<null>":this.available));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.available == null)? 0 :this.available.hashCode()));
        result = ((result* 31)+((this.managed == null)? 0 :this.managed.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Inventory) == false) {
            return false;
        }
        Inventory rhs = ((Inventory) other);
        return (((this.available == rhs.available)||((this.available!= null)&&this.available.equals(rhs.available)))&&((this.managed == rhs.managed)||((this.managed!= null)&&this.managed.equals(rhs.managed))));
    }

}
