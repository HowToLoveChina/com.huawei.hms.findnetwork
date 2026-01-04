package com.huawei.android.remotecontrol.bluetooth;

import android.util.SparseArray;
import android.util.SparseIntArray;

/* loaded from: classes4.dex */
public class AlsDeviceInfo {
    public static final int LEFT_DEVICE = 0;
    public static final int RIGHT_DEVICE = 1;
    private SparseIntArray battery;
    private SparseIntArray connectStatus;
    private String deviceId;
    private SparseArray<String> direction;
    private SparseArray<String> distances;
    private String perDeviceType;

    public SparseIntArray getBattery() {
        return this.battery;
    }

    public SparseIntArray getConnectStatus() {
        return this.connectStatus;
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public SparseArray<String> getDirection() {
        return this.direction;
    }

    public SparseArray<String> getDistances() {
        return this.distances;
    }

    public String getPerDeviceType() {
        return this.perDeviceType;
    }

    public void setBattery(SparseIntArray sparseIntArray) {
        this.battery = sparseIntArray;
    }

    public void setConnectStatus(SparseIntArray sparseIntArray) {
        this.connectStatus = sparseIntArray;
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setDirection(SparseArray<String> sparseArray) {
        this.direction = sparseArray;
    }

    public void setDistances(SparseArray<String> sparseArray) {
        this.distances = sparseArray;
    }

    public void setPerDeviceType(String str) {
        this.perDeviceType = str;
    }
}
