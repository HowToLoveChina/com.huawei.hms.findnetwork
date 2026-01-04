package com.huawei.hicloud.request.basic.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class VisionDeviceInfo {
    private String deviceAliasName;
    private String deviceCategory;
    private String deviceId;
    private int deviceType;
    private BasicDeviceImageUrlHostResp imageUrlHosts;
    private List<BasicDeviceProdImageResp> prodImageList;
    private String terminalType;
    private String wiseDevType;
    private String wiseProdId;

    public String getDeviceAliasName() {
        return this.deviceAliasName;
    }

    public String getDeviceCategory() {
        return this.deviceCategory;
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public BasicDeviceImageUrlHostResp getImageUrlHosts() {
        return this.imageUrlHosts;
    }

    public List<BasicDeviceProdImageResp> getProdImageList() {
        return this.prodImageList;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public String getWiseDevType() {
        return this.wiseDevType;
    }

    public String getWiseProdId() {
        return this.wiseProdId;
    }

    public void setDeviceAliasName(String str) {
        this.deviceAliasName = str;
    }

    public void setDeviceCategory(String str) {
        this.deviceCategory = str;
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setImageUrlHosts(BasicDeviceImageUrlHostResp basicDeviceImageUrlHostResp) {
        this.imageUrlHosts = basicDeviceImageUrlHostResp;
    }

    public void setProdImageList(List<BasicDeviceProdImageResp> list) {
        this.prodImageList = list;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public void setWiseDevType(String str) {
        this.wiseDevType = str;
    }

    public void setWiseProdId(String str) {
        this.wiseProdId = str;
    }
}
