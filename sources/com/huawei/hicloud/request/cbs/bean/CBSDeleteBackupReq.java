package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSDeleteBackupReq extends CBSBaseReq {
    private String devId;
    private int deviceType;
    private List<String> typeList;

    public CBSDeleteBackupReq(String str, int i10, List<String> list, int i11, String str2) {
        super(i11, str2);
        this.devId = str;
        this.deviceType = i10;
        this.typeList = list;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public List<String> getTypeList() {
        return this.typeList;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setTypeList(List<String> list) {
        this.typeList = list;
    }
}
