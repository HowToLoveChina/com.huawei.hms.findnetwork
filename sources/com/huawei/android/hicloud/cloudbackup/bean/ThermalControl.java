package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class ThermalControl extends AbsThermalControl {
    private static final String TAG = "ThermalControl";
    List<String> effectDevice;
    int startLevel = -1;
    int stopLevel = -1;

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public boolean checkIllegalArgument() {
        int i10;
        int i11 = this.startLevel;
        return i11 < 0 || (i10 = this.stopLevel) < 0 || i11 > i10 || this.thermalRetryInteval < 0 || this.blowoutThreshold < 0 || this.blowoutDuration < 0;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public int getBlowoutDuration() {
        return this.blowoutDuration;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public int getBlowoutThreshold() {
        return this.blowoutThreshold;
    }

    public List<String> getEffectDevice() {
        return this.effectDevice;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public int getStartLevel() {
        return this.startLevel;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public int getStopLevel() {
        return this.stopLevel;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public int getThermalRetryInteval() {
        return this.thermalRetryInteval;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public boolean isCurrentDeviceMatched() {
        return super.isCurrentDeviceMatched(this.effectDevice);
    }

    public void setBlowoutDuration(int i10) {
        this.blowoutDuration = i10;
    }

    public void setBlowoutThreshold(int i10) {
        this.blowoutThreshold = i10;
    }

    public void setEffectDevice(List<String> list) {
        this.effectDevice = list;
    }

    public void setStartLevel(int i10) {
        this.startLevel = i10;
    }

    public void setStopLevel(int i10) {
        this.stopLevel = i10;
    }

    public void setThermalRetryInteval(int i10) {
        this.thermalRetryInteval = i10;
    }

    public String toString() {
        return "ThermalControl{effectDevice=" + this.effectDevice + ", startLevel=" + this.startLevel + ", stopLevel=" + this.stopLevel + ", thermalRetryInteval=" + this.thermalRetryInteval + ", blowoutThreshold=" + this.blowoutThreshold + ", blowoutDuration=" + this.blowoutDuration + '}';
    }
}
