package com.huawei.cloud.pay.model;

import com.google.gson.Gson;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class GradePicture implements Serializable {
    private static final long serialVersionUID = -2336907900532689257L;
    private String hash;
    private String pictureType;
    private String resolution;
    private String url;

    public String getHash() {
        return this.hash;
    }

    public String getPictureType() {
        return this.pictureType;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setPictureType(String str) {
        this.pictureType = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
