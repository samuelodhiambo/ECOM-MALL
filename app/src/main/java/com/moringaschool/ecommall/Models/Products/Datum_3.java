
package com.moringaschool.ecommall.Models.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Datum_3 implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("quantity")
    @Expose
    private Long quantity;
    @SerializedName("updated")
    @Expose
    private Long updated;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Price__1 price;
    @SerializedName("inventory")
    @Expose
    private Inventory_1 inventory;
    @SerializedName("checkout_url")
    @Expose
    private CheckoutUrl checkoutUrl;
    @SerializedName("variant_groups")
    @Expose
    private List<VariantGroup> variantGroups = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("image")
    @Expose
    private Image__1 image;
    @SerializedName("related_products")
    @Expose
    private List<RelatedProduct> relatedProducts = null;
    private final static long serialVersionUID = 4941703278877201159L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum_3() {
    }

    /**
     *  @param id
     * @param created
     * @param quantity
     * @param updated
     * @param active
     * @param permalink
     * @param name
     * @param description
     * @param price
     * @param inventory
     * @param checkoutUrl
     * @param variantGroups
     * @param categories
     * @param image
     * @param relatedProducts
     */
    public Datum_3(String id, Long created, Long quantity, Long updated, Boolean active, String permalink, String name, String description, Price__1 price, Inventory_1 inventory, CheckoutUrl checkoutUrl, List<VariantGroup> variantGroups, List<Category> categories, Image__1 image, List<RelatedProduct> relatedProducts) {
        super();
        this.id = id;
        this.created = created;
        this.quantity = quantity;
        this.updated = updated;
        this.active = active;
        this.permalink = permalink;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
        this.checkoutUrl = checkoutUrl;
        this.variantGroups = variantGroups;
        this.categories = categories;
        this.image = image;
        this.relatedProducts = relatedProducts;
    }

    public Datum_3(String id, Long created, Long updated, Boolean active, String permalink, String name, String description, Price__1 price, Inventory_1 inventory, CheckoutUrl checkoutUrl, List<VariantGroup> variantGroups, List<Category> categories, Image__1 image, List<RelatedProduct> relatedProducts) {
        super();
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.active = active;
        this.permalink = permalink;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
        this.checkoutUrl = checkoutUrl;
        this.variantGroups = variantGroups;
        this.categories = categories;
        this.image = image;
        this.relatedProducts = relatedProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price__1 getPrice() {
        return price;
    }

    public void setPrice(Price__1 price) {
        this.price = price;
    }

    public Inventory_1 getInventory() {
        return inventory;
    }

    public void setInventory(Inventory_1 inventory) {
        this.inventory = inventory;
    }

    public CheckoutUrl getCheckoutUrl() {
        return checkoutUrl;
    }

    public void setCheckoutUrl(CheckoutUrl checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
    }

    public List<VariantGroup> getVariantGroups() {
        return variantGroups;
    }

    public void setVariantGroups(List<VariantGroup> variantGroups) {
        this.variantGroups = variantGroups;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Image__1 getImage() {
        return image;
    }

    public void setImage(Image__1 image) {
        this.image = image;
    }

    public List<RelatedProduct> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(List<RelatedProduct> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Datum_3.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null)?"<null>":this.created));
        sb.append(',');
        sb.append("quantity");
        sb.append('=');
        sb.append(((this.quantity == null)?"<null>":this.quantity));
        sb.append(',');
        sb.append("updated");
        sb.append('=');
        sb.append(((this.updated == null)?"<null>":this.updated));
        sb.append(',');
        sb.append("active");
        sb.append('=');
        sb.append(((this.active == null)?"<null>":this.active));
        sb.append(',');
        sb.append("permalink");
        sb.append('=');
        sb.append(((this.permalink == null)?"<null>":this.permalink));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null)?"<null>":this.price));
        sb.append(',');
        sb.append("inventory");
        sb.append('=');
        sb.append(((this.inventory == null)?"<null>":this.inventory));
        sb.append(',');
        sb.append("checkoutUrl");
        sb.append('=');
        sb.append(((this.checkoutUrl == null)?"<null>":this.checkoutUrl));
        sb.append(',');
        sb.append("variantGroups");
        sb.append('=');
        sb.append(((this.variantGroups == null)?"<null>":this.variantGroups));
        sb.append(',');
        sb.append("categories");
        sb.append('=');
        sb.append(((this.categories == null)?"<null>":this.categories));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("relatedProducts");
        sb.append('=');
        sb.append(((this.relatedProducts == null)?"<null>":this.relatedProducts));
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
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.created == null)? 0 :this.created.hashCode()));
        result = ((result* 31)+((this.relatedProducts == null)? 0 :this.relatedProducts.hashCode()));
        result = ((result* 31)+((this.active == null)? 0 :this.active.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.variantGroups == null)? 0 :this.variantGroups.hashCode()));
        result = ((result* 31)+((this.inventory == null)? 0 :this.inventory.hashCode()));
        result = ((result* 31)+((this.checkoutUrl == null)? 0 :this.checkoutUrl.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.categories == null)? 0 :this.categories.hashCode()));
        result = ((result* 31)+((this.permalink == null)? 0 :this.permalink.hashCode()));
        result = ((result* 31)+((this.updated == null)? 0 :this.updated.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Datum_3) == false) {
            return false;
        }
        Datum_3 rhs = ((Datum_3) other);
        return (((((((((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this.created == rhs.created)||((this.created!= null)&&this.created.equals(rhs.created))))&&((this.relatedProducts == rhs.relatedProducts)||((this.relatedProducts!= null)&&this.relatedProducts.equals(rhs.relatedProducts))))&&((this.active == rhs.active)||((this.active!= null)&&this.active.equals(rhs.active))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.variantGroups == rhs.variantGroups)||((this.variantGroups!= null)&&this.variantGroups.equals(rhs.variantGroups))))&&((this.inventory == rhs.inventory)||((this.inventory!= null)&&this.inventory.equals(rhs.inventory))))&&((this.checkoutUrl == rhs.checkoutUrl)||((this.checkoutUrl!= null)&&this.checkoutUrl.equals(rhs.checkoutUrl))))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.categories == rhs.categories)||((this.categories!= null)&&this.categories.equals(rhs.categories))))&&((this.permalink == rhs.permalink)||((this.permalink!= null)&&this.permalink.equals(rhs.permalink))))&&((this.updated == rhs.updated)||((this.updated!= null)&&this.updated.equals(rhs.updated))));
    }

}