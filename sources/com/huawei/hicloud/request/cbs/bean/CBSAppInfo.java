package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSAppInfo {
    private String apkPath;
    private CBSResource apkRes;
    private int apkType;
    private String apkUrl;
    private String appId;
    private long createTime;
    private int cursor;
    private String extend;
    private List<CBSFileInfo> fileInfos;
    private String iconPath;
    private CBSResource iconRes;
    private String iconUrl;
    private int runtimeType;
    private long size;
    private String unstrDataVer;
    private String unstrGuid;

    private <T> T commonSetFunction(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public String getApkPath() {
        return (String) commonSetFunction(this.apkPath);
    }

    public CBSResource getApkRes() {
        return this.apkRes;
    }

    public int getApkType() {
        return ((Integer) commonSetFunction(Integer.valueOf(this.apkType))).intValue();
    }

    public String getApkUrl() {
        return (String) commonSetFunction(this.apkUrl);
    }

    public String getAppId() {
        return (String) commonSetFunction(this.appId);
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getCursor() {
        return this.cursor;
    }

    public String getExtend() {
        return (String) commonSetFunction(this.extend);
    }

    public List<CBSFileInfo> getFileInfos() {
        return (List) commonSetFunction(this.fileInfos);
    }

    public String getFsize() {
        return String.valueOf(getSize());
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public CBSResource getIconRes() {
        return this.iconRes;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getRuntimeType() {
        return this.runtimeType;
    }

    public long getSize() {
        return ((Long) commonSetFunction(Long.valueOf(this.size))).longValue();
    }

    public String getUnstrDataVer() {
        return this.unstrDataVer;
    }

    public String getUnstrGuid() {
        return this.unstrGuid;
    }

    public void setApkPath(String str) {
        this.apkPath = str;
    }

    public void setApkRes(CBSResource cBSResource) {
        this.apkRes = cBSResource;
    }

    public void setApkType(int i10) {
        this.apkType = i10;
    }

    public void setApkUrl(String str) {
        this.apkUrl = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setCursor(int i10) {
        this.cursor = i10;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setFileInfos(List<CBSFileInfo> list) {
        this.fileInfos = list;
    }

    public void setIconPath(String str) {
        this.iconPath = str;
    }

    public void setIconRes(CBSResource cBSResource) {
        this.iconRes = cBSResource;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setRuntimeType(int i10) {
        this.runtimeType = i10;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setUnstrDataVer(String str) {
        this.unstrDataVer = str;
    }

    public void setUnstrGuid(String str) {
        this.unstrGuid = str;
    }
}
