package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;

/* loaded from: classes2.dex */
public class ExtParams {

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName(StartDownloadV2IPCRequest.KEY_DEVICE_ID_TYPE)
    private String deviceIdType;

    @SerializedName("minorModel")
    private String minorModel;

    @SerializedName("serviceMode")
    private String serviceMode;

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }

    public String getMinorModel() {
        return this.minorModel;
    }

    public String getServiceMode() {
        return this.serviceMode;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceIdType(String str) {
        this.deviceIdType = str;
    }

    public void setMinorModel(String str) {
        this.minorModel = str;
    }

    public void setServiceMode(String str) {
        this.serviceMode = str;
    }
}
