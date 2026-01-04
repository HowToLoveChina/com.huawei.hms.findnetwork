package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class PairingResultBean {
    private long customTimestamp;
    private String displayName;
    private String mac;
    private String productId;
    private int rssi;

    /* renamed from: sn */
    private String f24741sn;
    private String tagManufacturer;
    private String tagName;
    private String tagType;

    public PairingResultBean() {
        this.f24741sn = "";
        this.mac = null;
        this.tagName = null;
        this.productId = "";
        this.rssi = 999;
        this.customTimestamp = 0L;
        this.tagType = "";
        this.tagManufacturer = "";
        this.displayName = "";
    }

    public long getCustomTimestamp() {
        return this.customTimestamp;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getMac() {
        return this.mac;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSn() {
        return this.f24741sn;
    }

    public String getTagManufacturer() {
        return this.tagManufacturer;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getTagType() {
        return this.tagType;
    }

    public void setCustomTimestamp(long j10) {
        this.customTimestamp = j10;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setRssi(int i10) {
        this.rssi = i10;
    }

    public void setSn(String str) {
        this.f24741sn = str;
    }

    public void setTagManufacturer(String str) {
        this.tagManufacturer = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public void setTagType(String str) {
        this.tagType = str;
    }

    public PairingResultBean(String str, String str2, int i10, long j10) {
        this.tagName = null;
        this.productId = "";
        this.tagType = "";
        this.tagManufacturer = "";
        this.displayName = "";
        this.f24741sn = str;
        this.mac = str2;
        this.rssi = i10;
        this.customTimestamp = j10;
    }

    public PairingResultBean(String str, String str2, int i10, long j10, String str3, String str4) {
        this.productId = "";
        this.tagType = "";
        this.tagManufacturer = "";
        this.f24741sn = str;
        this.mac = str2;
        this.rssi = i10;
        this.customTimestamp = j10;
        this.tagName = str3;
        this.displayName = str4;
    }
}
