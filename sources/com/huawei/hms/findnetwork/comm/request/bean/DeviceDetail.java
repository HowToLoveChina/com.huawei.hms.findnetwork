package com.huawei.hms.findnetwork.comm.request.bean;

import com.huawei.hms.findnetwork.comm.util.MaskUtil;

/* loaded from: classes8.dex */
public class DeviceDetail {
    public static final String CAP_KEY_BLE_MEASURE_DISTANCE = "Ble_Measure_Distance";
    public static final String CAP_KEY_LOST_NEAR_LINK_NAVIGATION = "Near_Link_Navigation";
    public static final String CAP_KEY_LOST_REMINDER_FAST = "Fast_Lost_Reminder";
    public static final String CAP_KEY_LOST_REMINDER_NORMAL = "Normal_Lost_Reminder";
    public static final String CAP_KEY_RING = "Ring";
    public static final String CAP_KEY_ULTRA_SOUND = "Ultrasound";
    public static final int INVALID_BATTERY_LEVEL = -1;
    private String accessoryCapabilities;
    private int batteryLevel;
    private int batteryType;
    private int componentType;
    private String deviceSn;
    private String deviceType;
    private String extendData;
    private String firmwareVersion;
    private String productId;
    private int sequence;

    /* renamed from: sn */
    private String f24733sn;
    private String subProductId;

    public DeviceDetail() {
    }

    public DeviceDetail(String str, String str2, String str3, String str4) {
        this.f24733sn = str;
        this.deviceType = str2;
        this.accessoryCapabilities = str3;
        this.firmwareVersion = str4;
    }

    public String getAccessoryCapabilities() {
        return this.accessoryCapabilities;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public int getBatteryType() {
        return this.batteryType;
    }

    public int getComponentType() {
        return this.componentType;
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

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String getSn() {
        return this.f24733sn;
    }

    public String getSubProductId() {
        return this.subProductId;
    }

    public void setAccessoryCapabilities(String str) {
        this.accessoryCapabilities = str;
    }

    public void setBatteryLevel(int i10) {
        this.batteryLevel = i10;
    }

    public void setBatteryType(int i10) {
        this.batteryType = i10;
    }

    public void setComponentType(int i10) {
        this.componentType = i10;
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

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setSequence(int i10) {
        this.sequence = i10;
    }

    public void setSn(String str) {
        this.f24733sn = str;
    }

    public void setSubProductId(String str) {
        this.subProductId = str;
    }

    public String toString() {
        return "DeviceDetail{sn='" + MaskUtil.maskSn(this.f24733sn) + "', productId='" + this.productId + "', accessoryCapabilities='" + this.accessoryCapabilities + "', firmwareVersion='" + this.firmwareVersion + "', batteryLevel=" + this.batteryLevel + ", componentType=" + this.componentType + ", deviceSn='" + MaskUtil.maskSn(this.deviceSn) + "', sequence=" + this.sequence + ", deviceType=" + this.deviceType + '}';
    }

    public DeviceDetail(String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11) {
        this.f24733sn = str;
        this.deviceType = str2;
        this.productId = str3;
        this.subProductId = str4;
        this.accessoryCapabilities = str5;
        this.firmwareVersion = str6;
        this.batteryType = i10;
        this.batteryLevel = i11;
        this.componentType = 0;
        this.deviceSn = null;
        this.sequence = 0;
    }
}
