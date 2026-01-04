package com.huawei.cloud.pay.model;

import com.google.gson.Gson;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class PayActivityInfo implements Serializable {
    private static final long serialVersionUID = -8919663595068564078L;
    private String adId;
    private String cId;
    private int cType;
    private CampaignStatus campaignStatus;
    private long capacity;
    private String durationName;
    private String gradeName;
    private String productName;

    public String getAdId() {
        return this.adId;
    }

    public CampaignStatus getCampaignStatus() {
        return this.campaignStatus;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public String getDurationName() {
        return this.durationName;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getcId() {
        return this.cId;
    }

    public int getcType() {
        return this.cType;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setCampaignStatus(CampaignStatus campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setDurationName(String str) {
        this.durationName = str;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setcId(String str) {
        this.cId = str;
    }

    public void setcType(int i10) {
        this.cType = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
