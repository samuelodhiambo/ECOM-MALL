
package com.moringaschool.ecommall.Models.Products;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price implements Serializable
{

    @SerializedName("raw")
    @Expose
    private Integer raw;
    @SerializedName("formatted")
    @Expose
    private String formatted;
    @SerializedName("formatted_with_symbol")
    @Expose
    private String formattedWithSymbol;
    @SerializedName("formatted_with_code")
    @Expose
    private String formattedWithCode;
    private final static long serialVersionUID = 7314521383399451165L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Price() {
    }

    /**
     * 
     * @param formattedWithCode
     * @param formatted
     * @param raw
     * @param formattedWithSymbol
     */
    public Price(Integer raw, String formatted, String formattedWithSymbol, String formattedWithCode) {
        super();
        this.raw = raw;
        this.formatted = formatted;
        this.formattedWithSymbol = formattedWithSymbol;
        this.formattedWithCode = formattedWithCode;
    }

    public Integer getRaw() {
        return raw;
    }

    public void setRaw(Integer raw) {
        this.raw = raw;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public String getFormattedWithSymbol() {
        return formattedWithSymbol;
    }

    public void setFormattedWithSymbol(String formattedWithSymbol) {
        this.formattedWithSymbol = formattedWithSymbol;
    }

    public String getFormattedWithCode() {
        return formattedWithCode;
    }

    public void setFormattedWithCode(String formattedWithCode) {
        this.formattedWithCode = formattedWithCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Price.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("raw");
        sb.append('=');
        sb.append(((this.raw == null)?"<null>":this.raw));
        sb.append(',');
        sb.append("formatted");
        sb.append('=');
        sb.append(((this.formatted == null)?"<null>":this.formatted));
        sb.append(',');
        sb.append("formattedWithSymbol");
        sb.append('=');
        sb.append(((this.formattedWithSymbol == null)?"<null>":this.formattedWithSymbol));
        sb.append(',');
        sb.append("formattedWithCode");
        sb.append('=');
        sb.append(((this.formattedWithCode == null)?"<null>":this.formattedWithCode));
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
        result = ((result* 31)+((this.raw == null)? 0 :this.raw.hashCode()));
        result = ((result* 31)+((this.formattedWithCode == null)? 0 :this.formattedWithCode.hashCode()));
        result = ((result* 31)+((this.formattedWithSymbol == null)? 0 :this.formattedWithSymbol.hashCode()));
        result = ((result* 31)+((this.formatted == null)? 0 :this.formatted.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Price) == false) {
            return false;
        }
        Price rhs = ((Price) other);
        return (((((this.raw == rhs.raw)||((this.raw!= null)&&this.raw.equals(rhs.raw)))&&((this.formattedWithCode == rhs.formattedWithCode)||((this.formattedWithCode!= null)&&this.formattedWithCode.equals(rhs.formattedWithCode))))&&((this.formattedWithSymbol == rhs.formattedWithSymbol)||((this.formattedWithSymbol!= null)&&this.formattedWithSymbol.equals(rhs.formattedWithSymbol))))&&((this.formatted == rhs.formatted)||((this.formatted!= null)&&this.formatted.equals(rhs.formatted))));
    }

}
