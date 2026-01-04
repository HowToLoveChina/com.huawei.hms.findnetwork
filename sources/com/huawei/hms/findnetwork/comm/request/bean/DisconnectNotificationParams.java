package com.huawei.hms.findnetwork.comm.request.bean;

import com.huawei.hms.findnetwork.comm.util.MaskUtil;

/* loaded from: classes8.dex */
public class DisconnectNotificationParams extends SnRequestBean {
    public static final int DEFAULT_NORMAL_ADV_DURATION = 1800;
    public static final int DEFAULT_NORMAL_INTERVAL = 800;
    private static final int DEFAULT_RING_DURATION = 0;
    public static final int DEFAULT_TURBO_NEAR_DURATION = 15;
    public static final int DEFAULT_TURBO_NEAR_INTERVAL = 16;
    public static final int DEFAULT_TURBO_SEPARATE_DURATION = 0;
    public static final int DEFAULT_TURBO_SEPARATE_INTERVAL = 0;

    @DisconnectMode
    private int mode;
    private int duration = 0;
    private int nearbyInterval = 800;
    private int nearbyDuration = DEFAULT_NORMAL_ADV_DURATION;
    private int ringDuration = 0;
    private int separateInterval = 800;
    private int separateDuration = DEFAULT_NORMAL_ADV_DURATION;

    public int getDuration() {
        return this.duration;
    }

    public int getMode() {
        return this.mode;
    }

    public int getNearbyDuration() {
        return this.nearbyDuration;
    }

    public int getNearbyInterval() {
        return this.nearbyInterval;
    }

    public int getRingDuration() {
        return this.ringDuration;
    }

    public int getSeparateDuration() {
        return this.separateDuration;
    }

    public int getSeparateInterval() {
        return this.separateInterval;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setMode(@DisconnectMode int i10) {
        this.mode = i10;
    }

    public void setNearbyDuration(int i10) {
        this.nearbyDuration = i10;
    }

    public void setNearbyInterval(int i10) {
        this.nearbyInterval = i10;
    }

    public void setRingDuration(int i10) {
        this.ringDuration = i10;
    }

    public void setSeparateDuration(int i10) {
        this.separateDuration = i10;
    }

    public void setSeparateInterval(int i10) {
        this.separateInterval = i10;
    }

    public String toString() {
        return "DisconnectNotificationParams{mode=" + this.mode + ", duration=" + this.duration + ", nearbyInterval=" + this.nearbyInterval + ", nearbyDuration=" + this.nearbyDuration + ", ringDuration=" + this.ringDuration + ", separateInterval=" + this.separateInterval + ", separateDuration=" + this.separateDuration + ", connectTagSn='" + MaskUtil.maskSn(this.connectTagSn) + "'}";
    }
}
