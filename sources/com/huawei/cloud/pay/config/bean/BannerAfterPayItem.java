package com.huawei.cloud.pay.config.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class BannerAfterPayItem {

    @SerializedName("goto")
    private BannerAfterPayGoto bannerAfterPayGoto;
    private long bannerId;
    private String bannerName;
    private String beginTime;
    private String endTime;
    private ArrayList<BannerAfterPayRealtePackage> realtePackages;

    @SerializedName("userGroupExtIDs")
    private List<String> userGroupExtIDs;
    private ArrayList<BannerAfterPayPicturesItem> pictures = new ArrayList<>();
    private float percentage = -1.0f;

    public BannerAfterPayGoto getBannerAfterPayGoto() {
        return this.bannerAfterPayGoto;
    }

    public long getBannerId() {
        return this.bannerId;
    }

    public String getBannerName() {
        return this.bannerName;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public ArrayList<BannerAfterPayPicturesItem> getPictures() {
        return this.pictures;
    }

    public ArrayList<BannerAfterPayRealtePackage> getRealtePackages() {
        return this.realtePackages;
    }

    public List<String> getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public void setBannerAfterPayGoto(BannerAfterPayGoto bannerAfterPayGoto) {
        this.bannerAfterPayGoto = bannerAfterPayGoto;
    }

    public void setBannerId(long j10) {
        this.bannerId = j10;
    }

    public void setBannerName(String str) {
        this.bannerName = str;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setPercentage(float f10) {
        this.percentage = f10;
    }

    public void setPictures(ArrayList<BannerAfterPayPicturesItem> arrayList) {
        this.pictures = arrayList;
    }

    public void setRealtePackages(ArrayList<BannerAfterPayRealtePackage> arrayList) {
        this.realtePackages = arrayList;
    }

    public void setUserGroupExtIDs(List<String> list) {
        this.userGroupExtIDs = list;
    }
}
