package com.huawei.android.remotecontrol.locate;

import com.huawei.android.remotecontrol.config.ParamConfig;

/* loaded from: classes4.dex */
public class PassiveLocateParam {
    private String deviceId;
    private int gpsCount = ParamConfig.getInstance().getGpsMaxPassiveTimes();
    private int networkCount = ParamConfig.getInstance().getNetworkMaxPassiveTimes();
    private long gpsLastTime = System.currentTimeMillis();
    private long networkLastTime = System.currentTimeMillis();

    public PassiveLocateParam(String str) {
        this.deviceId = str;
    }

    public int getGpsCount() {
        return this.gpsCount;
    }

    public long getGpsLastTime() {
        return this.gpsLastTime;
    }

    public int getNetworkCount() {
        return this.networkCount;
    }

    public long getNetworkLastTime() {
        return this.networkLastTime;
    }

    public String getPassiveDeviceId() {
        return this.deviceId;
    }

    public void setGpsCount(int i10) {
        this.gpsCount = i10;
    }

    public void setGpsLastTime(long j10) {
        this.gpsLastTime = j10;
    }

    public void setNetworkCount(int i10) {
        this.networkCount = i10;
    }

    public void setNetworkLastTime(long j10) {
        this.networkLastTime = j10;
    }
}
