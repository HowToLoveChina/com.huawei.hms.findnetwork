package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;

/* loaded from: classes6.dex */
public class Award {

    /* renamed from: id */
    @SerializedName("id")
    private String f22236id;

    @SerializedName("name")
    private String name;

    @SerializedName("picture")
    private CommonPicture picture;

    @SerializedName("quota")
    private int quota;

    public String getId() {
        return this.f22236id;
    }

    public String getName() {
        return this.name;
    }

    public CommonPicture getPicture() {
        return this.picture;
    }

    public int getQuota() {
        return this.quota;
    }

    public void setId(String str) {
        this.f22236id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPicture(CommonPicture commonPicture) {
        this.picture = commonPicture;
    }

    public void setQuota(int i10) {
        this.quota = i10;
    }
}
