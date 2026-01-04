package com.huawei.android.hicloud.cloudspace.campaign.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class ReqDispatchEvent {

    @SerializedName("activate_app")
    private ReqDispatchActivateApp activateApp;

    @SerializedName("download_app")
    private ReqDispatchDownloadApp downloadApp;

    @SerializedName("feature_enable")
    private ReqDispatchFeatureEnable featureEnable;

    /* renamed from: id */
    private String f11832id;
    private String type;

    @SerializedName("upload_file")
    private ReqDispatchUploadFile uploadFile;

    public ReqDispatchActivateApp getActivateApp() {
        return this.activateApp;
    }

    public ReqDispatchDownloadApp getDownloadApp() {
        return this.downloadApp;
    }

    public ReqDispatchFeatureEnable getFeatureEnable() {
        return this.featureEnable;
    }

    public String getId() {
        return this.f11832id;
    }

    public String getType() {
        return this.type;
    }

    public ReqDispatchUploadFile getUploadFile() {
        return this.uploadFile;
    }

    public void setActivateApp(ReqDispatchActivateApp reqDispatchActivateApp) {
        this.activateApp = reqDispatchActivateApp;
    }

    public void setDownloadApp(ReqDispatchDownloadApp reqDispatchDownloadApp) {
        this.downloadApp = reqDispatchDownloadApp;
    }

    public void setFeatureEnable(ReqDispatchFeatureEnable reqDispatchFeatureEnable) {
        this.featureEnable = reqDispatchFeatureEnable;
    }

    public void setId(String str) {
        this.f11832id = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUploadFile(ReqDispatchUploadFile reqDispatchUploadFile) {
        this.uploadFile = reqDispatchUploadFile;
    }
}
