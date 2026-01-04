package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class FrequencyItem {

    @SerializedName("frequencyList")
    private FrequencyBean[] frequencyList;

    @SerializedName("itemType")
    private String itemType;

    @SerializedName("purpose")
    private String purpose;

    @SerializedName("way")
    private String way;

    public FrequencyBean[] getFrequencyList() {
        return this.frequencyList;
    }

    public String getItemType() {
        return this.itemType;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public String getWay() {
        return this.way;
    }

    public void setFrequencyList(FrequencyBean[] frequencyBeanArr) {
        this.frequencyList = frequencyBeanArr;
    }

    public void setItemType(String str) {
        this.itemType = str;
    }

    public void setPurpose(String str) {
        this.purpose = str;
    }

    public void setWay(String str) {
        this.way = str;
    }
}
