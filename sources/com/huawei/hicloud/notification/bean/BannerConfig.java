package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.util.ArrayList;
import p015ak.C0209d;

/* loaded from: classes6.dex */
public class BannerConfig {
    private static final String TAG = "BannerConfig";
    private BannerConfigObject[] configurations;
    private String date;

    @SerializedName("device_type")
    private String deviceType;

    /* renamed from: id */
    private String f22622id;
    private String version;

    public void deleteInvalidConfig() {
        NotifyLogger.m29915i(TAG, "deleteInvalidConfig");
        BannerConfigObject[] bannerConfigObjectArr = this.configurations;
        if (bannerConfigObjectArr == null || bannerConfigObjectArr.length == 0) {
            NotifyLogger.m29915i(TAG, "deleteInvalidConfig configurations null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BannerConfigObject bannerConfigObject : this.configurations) {
            if (bannerConfigObject != null && C0209d.m1238b2(bannerConfigObject.getBeginTime(), bannerConfigObject.getEndTime())) {
                arrayList.add(bannerConfigObject);
            }
        }
        BannerConfigObject[] bannerConfigObjectArr2 = new BannerConfigObject[arrayList.size()];
        arrayList.toArray(bannerConfigObjectArr2);
        this.configurations = bannerConfigObjectArr2;
    }

    public BannerConfigObject[] getConfigurations() {
        BannerConfigObject[] bannerConfigObjectArr = this.configurations;
        return bannerConfigObjectArr != null ? (BannerConfigObject[]) bannerConfigObjectArr.clone() : new BannerConfigObject[0];
    }

    public String getDate() {
        return this.date;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getId() {
        return this.f22622id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfigurations(BannerConfigObject[] bannerConfigObjectArr) {
        if (bannerConfigObjectArr == null || bannerConfigObjectArr.length == 0) {
            this.configurations = null;
        } else {
            this.configurations = (BannerConfigObject[]) bannerConfigObjectArr.clone();
        }
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setId(String str) {
        this.f22622id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
