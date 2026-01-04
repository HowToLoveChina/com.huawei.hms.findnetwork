package com.huawei.android.remotecontrol.offlinelocate.bean;

/* loaded from: classes4.dex */
public class TrustCircleInfo {
    private final boolean isJoinTrustCircle;
    private int mkVersion;

    public TrustCircleInfo(boolean z10, int i10) {
        this.isJoinTrustCircle = z10;
        this.mkVersion = i10;
    }

    public int getMkVersion() {
        return this.mkVersion;
    }

    public boolean isJoinTrustCircle() {
        return this.isJoinTrustCircle;
    }
}
