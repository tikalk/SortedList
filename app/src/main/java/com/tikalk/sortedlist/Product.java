/*
 * BSD 3-Clause License
 *
 * Copyright (c) 2017, Tikal Knowledge, Ltd.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of the copyright holder nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.tikalk.sortedlist;

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

    @SerializedName("id")
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
    @SerializedName("imageUrls")
    private List<String> imageUrls;
    @SerializedName("rank")
    private int rank;

    public Product() {
    }

    public Product(String id, String stockKeepingUnit, String brand, double currentPrice, String safetyTag, String size, int category, String title, String colour, boolean stocked, double basePrice, List<String> imageUrls, int rank) {
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
