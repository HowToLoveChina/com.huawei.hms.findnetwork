package com.huawei.openalliance.p169ad.views.viewpager;

import android.database.DataSetObserver;

/* renamed from: com.huawei.openalliance.ad.views.viewpager.g */
/* loaded from: classes2.dex */
class C8162g extends DataSetObserver {

    /* renamed from: a */
    private C8160e f38252a;

    public C8162g(C8160e c8160e) {
        this.f38252a = c8160e;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f38252a.m50581a();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f38252a.m50581a();
    }
}
