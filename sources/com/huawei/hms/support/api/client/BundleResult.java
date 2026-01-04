package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class BundleResult {

    /* renamed from: a */
    private int f29775a;

    /* renamed from: b */
    private Bundle f29776b;

    public BundleResult(int i10, Bundle bundle) {
        this.f29775a = i10;
        this.f29776b = bundle;
    }

    public int getResultCode() {
        return this.f29775a;
    }

    public Bundle getRspBody() {
        return this.f29776b;
    }

    public void setResultCode(int i10) {
        this.f29775a = i10;
    }

    public void setRspBody(Bundle bundle) {
        this.f29776b = bundle;
    }
}
