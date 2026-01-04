package com.huawei.hicloud.base.bean;

import androidx.annotation.Keep;
import p586qp.InterfaceC12382a;
import p714vp.AbstractC13477b;

@Keep
@InterfaceC12382a(name = "BatteryOptimizationInfo")
/* loaded from: classes6.dex */
public class BatteryOptimizationInfo extends AbstractC13477b {
    private boolean result;

    /* renamed from: ts */
    private long f22135ts;

    public long getTs() {
        return this.f22135ts;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean z10) {
        this.result = z10;
    }

    public void setTs(long j10) {
        this.f22135ts = j10;
    }
}
