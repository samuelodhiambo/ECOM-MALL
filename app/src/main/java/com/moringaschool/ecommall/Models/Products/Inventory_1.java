
package com.moringaschool.ecommall.Models.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Inventory_1 implements Serializable
{

    @SerializedName("managed")
    @Expose
    private Boolean managed;
    @SerializedName("available")
    @Expose
    private Long available;
    private final static long serialVersionUID = 7661750103387610940L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Inventory_1() {
    }

    /**
     *
     * @param managed
     * @param available
     */
    public Inventory_1(Boolean managed, Long available) {
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

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Inventory_1.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof Inventory_1) == false) {
            return false;
        }
        Inventory_1 rhs = ((Inventory_1) other);
        return (((this.available == rhs.available)||((this.available!= null)&&this.available.equals(rhs.available)))&&((this.managed == rhs.managed)||((this.managed!= null)&&this.managed.equals(rhs.managed))));
    }

}
