package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class FlowControl {
    int fcRatio = 0;
    long fcEndTime = 0;

    /* renamed from: a */
    public int m40165a() {
        return this.fcRatio;
    }

    /* renamed from: b */
    public long m40168b() {
        return this.fcEndTime;
    }

    /* renamed from: a */
    public void m40166a(int i10) {
        this.fcRatio = i10;
    }

    /* renamed from: a */
    public void m40167a(long j10) {
        this.fcEndTime = j10;
    }
}
