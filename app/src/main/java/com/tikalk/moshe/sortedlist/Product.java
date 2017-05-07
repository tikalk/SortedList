package com.tikalk.moshe.sortedlist;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Product item.
 *
 * @author Moshe Waisberg
 */
public class Product {

    @SerializedName("_id")
    private String id;
    @SerializedName("sku")
    private String stockKeepingUnit;
    @SerializedName("brand")
    private String brand;
    @SerializedName("currentPrice")
    private double currentPrice;
    @SerializedName("safetyTag")
    private String safetyTag;
    @SerializedName("size")
    private String size;
    @SerializedName("category")
    private int category;
    @SerializedName("title")
    private String title;
    @SerializedName("colour")
    private String colour;
    @SerializedName("inStock")
    private boolean stocked;
    @SerializedName("basePrice")
    private double basePrice;
    @SerializedName("productImageUrls")
    private List<String> imageUrls;
    @SerializedName("productId")
    private String productId;

    @SerializedName("rank")
    private int rank;

    public Product() {
    }

    public Product(String id, String stockKeepingUnit, String brand, double currentPrice, String safetyTag, String size, int category, String title, String colour, boolean stocked, double basePrice, List<String> imageUrls, String productId, int rank) {
        this.id = id;
        this.stockKeepingUnit = stockKeepingUnit;
        this.brand = brand;
        this.currentPrice = currentPrice;
        this.safetyTag = safetyTag;
        this.size = size;
        this.category = category;
        this.title = title;
        this.colour = colour;
        this.stocked = stocked;
        this.basePrice = basePrice;
        this.imageUrls = imageUrls;
        this.productId = productId;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getStockKeepingUnit() {
        return stockKeepingUnit;
    }

    public String getBrand() {
        return brand;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getSafetyTag() {
        return safetyTag;
    }

    public String getSize() {
        return size;
    }

    public int getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getColour() {
        return colour;
    }

    public boolean isStocked() {
        return stocked;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @NonNull
    public List<String> getImageUrls() {
        if (imageUrls == null) {
            imageUrls = new ArrayList<>();
        }
        return imageUrls;
    }

    public String getProductId() {
        return productId;
    }

    /**
     * Get the relevant image path.
     *
     * @return the path.
     */
    public String getImageUrl() {
        return imageUrls.get(0);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Increment the ranking.
     */
    public void incrementRank() {
        setRank(getRank() + 1);
    }
}
