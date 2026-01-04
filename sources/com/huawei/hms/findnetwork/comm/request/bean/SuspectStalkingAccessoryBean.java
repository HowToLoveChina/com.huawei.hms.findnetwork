package com.huawei.hms.findnetwork.comm.request.bean;

import java.util.Objects;

/* loaded from: classes8.dex */
public class SuspectStalkingAccessoryBean {
    private String accessoryCapabilities;
    private Integer componentType;
    private String deviceTypeId;
    private boolean isTrust;
    private String mStandbyDevice;
    private String macAddress;
    private String manufacturerId;
    private String prodId;
    private Integer sequence;

    /* renamed from: sn */
    private String f24743sn;
    private String subProId;

    public SuspectStalkingAccessoryBean() {
    }

    public SuspectStalkingAccessoryBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, String str8, Integer num) {
        this.macAddress = str;
        this.prodId = str2;
        this.subProId = str3;
        this.deviceTypeId = str4;
        this.manufacturerId = str5;
        this.accessoryCapabilities = str6;
        this.f24743sn = str7;
        this.isTrust = z10;
        this.mStandbyDevice = str8;
        this.componentType = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f24743sn.equals(((SuspectStalkingAccessoryBean) obj).f24743sn);
    }

    public String getAccessoryCapabilities() {
        return this.accessoryCapabilities;
    }

    public Integer getComponentType() {
        return this.componentType;
    }

    public String getDeviceTypeId() {
        return this.deviceTypeId;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getManufacturerId() {
        return this.manufacturerId;
    }

    public String getProdId() {
        return this.prodId;
    }

    public Integer getSequence() {
        return this.sequence;
    }

    public String getSn() {
        return this.f24743sn;
    }

    public String getStandbyDevice() {
        return this.mStandbyDevice;
    }

    public String getSubProId() {
        return this.subProId;
    }

    public int hashCode() {
        return Objects.hash(this.f24743sn);
    }

    public boolean isTrust() {
        return this.isTrust;
    }

    public void setAccessoryCapabilities(String str) {
        this.accessoryCapabilities = str;
    }

    public void setComponentType(Integer num) {
        this.componentType = num;
    }

    public void setDeviceTypeId(String str) {
        this.deviceTypeId = str;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setManufacturerId(String str) {
        this.manufacturerId = str;
    }

    public void setProdId(String str) {
        this.prodId = str;
    }

    public void setSequence(Integer num) {
        this.sequence = num;
    }

    public void setSn(String str) {
        this.f24743sn = str;
    }

    public void setStandbyDevice(String str) {
        this.mStandbyDevice = str;
    }

    public void setSubProId(String str) {
        this.subProId = str;
    }

    public void setTrust(boolean z10) {
        this.isTrust = z10;
    }
}
