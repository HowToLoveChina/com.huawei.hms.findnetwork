package com.huawei.hms.findnetwork.comm.request.bean;

import com.huawei.hms.findnetwork.comm.util.MaskUtil;

/* loaded from: classes8.dex */
public class PairedDeviceInfo {
    private String accessoryCapabilities;
    private int componentType;
    private String deviceName;
    private String deviceSn;
    private String deviceType;
    private String extendData;
    private String goodsType;
    private String productId;
    private int sequence;

    /* renamed from: sn */
    private String f24740sn;
    private String subProductId;
    private int syncResult;

    public PairedDeviceInfo(String str, String str2, int i10, int i11) {
        this.f24740sn = str;
        this.productId = str2;
        this.componentType = i10;
        this.syncResult = i11;
    }

    public String getAccessoryCapabilities() {
        return this.accessoryCapabilities;
    }

    public int getComponentType() {
        return this.componentType;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceSn() {
        return this.deviceSn;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getExtendData() {
        return this.extendData;
    }

    public String getGoodsType() {
        return this.goodsType;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String getSn() {
        return this.f24740sn;
    }

    public String getSubProductId() {
        return this.subProductId;
    }

    public int getSyncResult() {
        return this.syncResult;
    }

    public void setAccessoryCapabilities(String str) {
        this.accessoryCapabilities = str;
    }

    public void setComponentType(int i10) {
        this.componentType = i10;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceSn(String str) {
        this.deviceSn = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setExtendData(String str) {
        this.extendData = str;
    }

    public void setGoodsType(String str) {
        this.goodsType = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setSequence(int i10) {
        this.sequence = i10;
    }

    public void setSn(String str) {
        this.f24740sn = str;
    }

    public void setSubProductId(String str) {
        this.subProductId = str;
    }

    public void setSyncResult(int i10) {
        this.syncResult = i10;
    }

    public String toString() {
        return "PairedDeviceInfo{fid='" + MaskUtil.maskSn(this.f24740sn) + "', productId='" + this.productId + "', componentType=" + this.componentType + ", sequence=" + this.sequence + ", accessoryCapabilities='" + this.accessoryCapabilities + "'}";
    }

    public PairedDeviceInfo(String str, String str2, String str3, String str4) {
        this.f24740sn = str;
        this.deviceType = str2;
        this.deviceName = str3;
        this.goodsType = str4;
    }
}
