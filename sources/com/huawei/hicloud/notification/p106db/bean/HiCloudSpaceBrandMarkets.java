package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;

/* loaded from: classes6.dex */
public class HiCloudSpaceBrandMarkets {

    @SerializedName("brandMarkets")
    private BrandMarkets brandMarkets;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22649id;

    @SerializedName("version")
    private String version;

    public BrandMarkets getBrandMarkets() {
        return this.brandMarkets;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22649id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBrandMarkets(BrandMarkets brandMarkets) {
        this.brandMarkets = brandMarkets;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22649id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
