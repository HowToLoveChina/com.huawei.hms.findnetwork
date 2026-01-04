package com.huawei.hicloud.request.cbs.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CBSCreateAppBackupRecordReq extends CBSBaseReq {
    private List<CBSAppInfo> appIdInfos = new ArrayList();
    private String backupId;
    private String deviceId;
    private int deviceType;

    public CBSCreateAppBackupRecordReq() {
    }

    public void addAppIdInfos(CBSAppInfo cBSAppInfo) {
        this.appIdInfos.add(cBSAppInfo);
    }

    public List<CBSAppInfo> getAppIdInfos() {
        return this.appIdInfos;
    }

    public String getBackupId() {
        return this.backupId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setAppIdInfos(List<CBSAppInfo> list) {
        this.appIdInfos = list;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public CBSCreateAppBackupRecordReq(String str, String str2, int i10) {
        this.cmd = 26;
        this.info = "CreateAppBackupRecordReq";
        this.backupId = str;
        this.deviceId = str2;
        this.deviceType = i10;
    }
}
