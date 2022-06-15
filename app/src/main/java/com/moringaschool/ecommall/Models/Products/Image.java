
package com.moringaschool.ecommall.Models.Products;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("is_image")
    @Expose
    private Boolean isImage;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("file_size")
    @Expose
    private Integer fileSize;
    @SerializedName("file_extension")
    @Expose
    private String fileExtension;
    @SerializedName("image_dimensions")
    @Expose
    private ImageDimensions imageDimensions;
    @SerializedName("meta")
    @Expose
    private List<Object> meta = null;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("updated_at")
    @Expose
    private Integer updatedAt;
    private final static long serialVersionUID = -7333228040820687866L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param createdAt
     * @param isImage
     * @param filename
     * @param imageDimensions
     * @param fileSize
     * @param fileExtension
     * @param meta
     * @param description
     * @param id
     * @param url
     * @param updatedAt
     */
    public Image(String id, String url, Object description, Boolean isImage, String filename, Integer fileSize, String fileExtension, ImageDimensions imageDimensions, List<Object> meta, Integer createdAt, Integer updatedAt) {
        super();
        this.id = id;
        this.url = url;
        this.description = description;
        this.isImage = isImage;
        this.filename = filename;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
        this.imageDimensions = imageDimensions;
        this.meta = meta;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Boolean getIsImage() {
        return isImage;
    }

    public void setIsImage(Boolean isImage) {
        this.isImage = isImage;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public ImageDimensions getImageDimensions() {
        return imageDimensions;
    }

    public void setImageDimensions(ImageDimensions imageDimensions) {
        this.imageDimensions = imageDimensions;
    }

    public List<Object> getMeta() {
        return meta;
    }

    public void setMeta(List<Object> meta) {
        this.meta = meta;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Image.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("isImage");
        sb.append('=');
        sb.append(((this.isImage == null)?"<null>":this.isImage));
        sb.append(',');
        sb.append("filename");
        sb.append('=');
        sb.append(((this.filename == null)?"<null>":this.filename));
        sb.append(',');
        sb.append("fileSize");
        sb.append('=');
        sb.append(((this.fileSize == null)?"<null>":this.fileSize));
        sb.append(',');
        sb.append("fileExtension");
        sb.append('=');
        sb.append(((this.fileExtension == null)?"<null>":this.fileExtension));
        sb.append(',');
        sb.append("imageDimensions");
        sb.append('=');
        sb.append(((this.imageDimensions == null)?"<null>":this.imageDimensions));
        sb.append(',');
        sb.append("meta");
        sb.append('=');
        sb.append(((this.meta == null)?"<null>":this.meta));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
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
        result = ((result* 31)+((this.createdAt == null)? 0 :this.createdAt.hashCode()));
        result = ((result* 31)+((this.isImage == null)? 0 :this.isImage.hashCode()));
        result = ((result* 31)+((this.filename == null)? 0 :this.filename.hashCode()));
        result = ((result* 31)+((this.imageDimensions == null)? 0 :this.imageDimensions.hashCode()));
        result = ((result* 31)+((this.fileSize == null)? 0 :this.fileSize.hashCode()));
        result = ((result* 31)+((this.fileExtension == null)? 0 :this.fileExtension.hashCode()));
        result = ((result* 31)+((this.meta == null)? 0 :this.meta.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.updatedAt == null)? 0 :this.updatedAt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Image) == false) {
            return false;
        }
        Image rhs = ((Image) other);
        return ((((((((((((this.createdAt == rhs.createdAt)||((this.createdAt!= null)&&this.createdAt.equals(rhs.createdAt)))&&((this.isImage == rhs.isImage)||((this.isImage!= null)&&this.isImage.equals(rhs.isImage))))&&((this.filename == rhs.filename)||((this.filename!= null)&&this.filename.equals(rhs.filename))))&&((this.imageDimensions == rhs.imageDimensions)||((this.imageDimensions!= null)&&this.imageDimensions.equals(rhs.imageDimensions))))&&((this.fileSize == rhs.fileSize)||((this.fileSize!= null)&&this.fileSize.equals(rhs.fileSize))))&&((this.fileExtension == rhs.fileExtension)||((this.fileExtension!= null)&&this.fileExtension.equals(rhs.fileExtension))))&&((this.meta == rhs.meta)||((this.meta!= null)&&this.meta.equals(rhs.meta))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.updatedAt == rhs.updatedAt)||((this.updatedAt!= null)&&this.updatedAt.equals(rhs.updatedAt))));
    }

}
