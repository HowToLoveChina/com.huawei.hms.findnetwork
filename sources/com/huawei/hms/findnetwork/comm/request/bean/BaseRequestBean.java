package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class BaseRequestBean {
    public String appId;
    public String cpAppVersion;
    public String mSrcTranId;
    public String pkgName;
    public String region;
    public int uid;

    public String getAppId() {
        return this.appId;
    }

    public String getCpAppVersion() {
        return this.cpAppVersion;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getRegion() {
        return this.region;
    }

    public String getSrcTranId() {
        return this.mSrcTranId;
    }

    public int getUid() {
        return this.uid;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCpAppVersion(String str) {
        this.cpAppVersion = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setSrcTranId(String str) {
        this.mSrcTranId = str;
    }

    public void setUid(int i10) {
        this.uid = i10;
    }
}
