
package com.moringaschool.ecommall.Models.Products;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckoutUrl implements Serializable
{

    @SerializedName("checkout")
    @Expose
    private String checkout;
    @SerializedName("display")
    @Expose
    private String display;
    private final static long serialVersionUID = -6452445944195659443L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CheckoutUrl() {
    }

    /**
     * 
     * @param display
     * @param checkout
     */
    public CheckoutUrl(String checkout, String display) {
        super();
        this.checkout = checkout;
        this.display = display;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CheckoutUrl.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("checkout");
        sb.append('=');
        sb.append(((this.checkout == null)?"<null>":this.checkout));
        sb.append(',');
        sb.append("display");
        sb.append('=');
        sb.append(((this.display == null)?"<null>":this.display));
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
        result = ((result* 31)+((this.checkout == null)? 0 :this.checkout.hashCode()));
        result = ((result* 31)+((this.display == null)? 0 :this.display.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CheckoutUrl) == false) {
            return false;
        }
        CheckoutUrl rhs = ((CheckoutUrl) other);
        return (((this.checkout == rhs.checkout)||((this.checkout!= null)&&this.checkout.equals(rhs.checkout)))&&((this.display == rhs.display)||((this.display!= null)&&this.display.equals(rhs.display))));
    }

}
