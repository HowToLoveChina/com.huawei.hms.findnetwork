package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;

/* loaded from: classes6.dex */
public class QuestBean {
    private String appSource;

    @SerializedName("attributes")
    private QuestAttributes attributes;

    @SerializedName("button_create")
    private String buttonCreate;

    @SerializedName("detail")
    private String detail;
    private Object hiCloudNativeAd;
    private String hiCloudNativeAdId;

    /* renamed from: id */
    @SerializedName("id")
    private String f22241id;

    @SerializedName("name")
    private String name;

    @SerializedName("picture")
    private CommonPicture picture;
    private Integer[] quotas;

    @SerializedName("type")
    private String type;

    public String getAppSource() {
        return this.appSource;
    }

    public QuestAttributes getAttributes() {
        return this.attributes;
    }

    public String getButtonCreate() {
        return this.buttonCreate;
    }

    public String getDetail() {
        return this.detail;
    }

    public Object getHiCloudNativeAd() {
        return this.hiCloudNativeAd;
    }

    public String getHiCloudNativeAdId() {
        return this.hiCloudNativeAdId;
    }

    public String getId() {
        return this.f22241id;
    }

    public String getName() {
        return this.name;
    }

    public CommonPicture getPicture() {
        return this.picture;
    }

    public Integer[] getQuotas() {
        return this.quotas;
    }

    public String getType() {
        return this.type;
    }

    public void setAppSource(String str) {
        this.appSource = str;
    }

    public void setAttributes(QuestAttributes questAttributes) {
        this.attributes = questAttributes;
    }

    public void setButtonCreate(String str) {
        this.buttonCreate = str;
    }

    public void setDetail(String str) {
        this.detail = str;
    }

    public void setHiCloudNativeAd(Object obj) {
        this.hiCloudNativeAd = obj;
    }

    public void setHiCloudNativeAdId(String str) {
        this.hiCloudNativeAdId = str;
    }

    public void setId(String str) {
        this.f22241id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPicture(CommonPicture commonPicture) {
        this.picture = commonPicture;
    }

    public void setQuotas(Integer[] numArr) {
        this.quotas = numArr;
    }

    public void setType(String str) {
        this.type = str;
    }
}
