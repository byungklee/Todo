package com.example.test.ui.product.category;

public class ProductCategory {
    private int productId;
    private String productCategoryName;
    private String imageUrl;

    public ProductCategory(final int productId, final String productCategoryName, final String imageUrl) {
        this.productId = productId;
        this.productCategoryName = productCategoryName;
        this.imageUrl = imageUrl;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
