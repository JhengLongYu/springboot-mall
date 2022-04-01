package com.leoyu.springbootmall.model;

import com.leoyu.springbootmall.constant.ProductCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description="商品")
public class Product {
    @ApiModelProperty(value = "商品序號", required = true)
    private Integer productId;

    @ApiModelProperty(value = "名稱", required = true)
    private String productName;

    @ApiModelProperty(value = "種類", required = true)
    private ProductCategory category;

    @ApiModelProperty(value = "圖片", required = true)
    private String imageUrl;

    @ApiModelProperty(value = "價格", required = true)
    private Integer price;

    @ApiModelProperty(value = "庫存", required = true)
    private Integer stock;

    @ApiModelProperty(value = "商品描述", required = true)
    private String description;

    @ApiModelProperty(value = "建立時間", required = true)
    private Date createdDate;

    @ApiModelProperty(value = "修改時間", required = true)
    private Date lastModifiedDate;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer product_id) {
        this.productId = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product_name) {
        this.productName = product_name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
