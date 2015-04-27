package com.moneyforward.mfblogsmple.loader;

import com.google.gson.annotations.SerializedName;

/**
 * Created by maeda on 15/04/27.
 */
public class Tiqav {

    @SerializedName("id")
    private String id;

    @SerializedName("ext")
    private String ext;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @SerializedName("source_url")
    private String sourceUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
