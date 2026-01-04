package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSCountByDeviceReq extends CBSBaseReq {
    private List<CBSDevice> deviceList;
    private String type;

    public CBSCountByDeviceReq(String str, int i10, String str2) {
        super(i10, str2);
        this.type = str;
    }

    public List<CBSDevice> getDeviceList() {
        return this.deviceList;
    }

    public String getType() {
        return this.type;
    }

    public void setDeviceList(List<CBSDevice> list) {
        this.deviceList = list;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CBSCountByDeviceReq(String str, int i10, String str2, List<CBSDevice> list) {
        super(i10, str2);
        this.type = str;
        this.deviceList = list;
    }
}
