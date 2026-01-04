package com.huawei.wearengine;

import com.huawei.wearengine.C8887d;
import java.lang.ref.WeakReference;
import p558pu.InterfaceC12228c;
import su.C12860b;

/* renamed from: com.huawei.wearengine.c */
/* loaded from: classes9.dex */
public class C8885c<T extends InterfaceC12228c> implements C8887d.b {

    /* renamed from: a */
    public WeakReference<T> f45271a;

    public C8885c(WeakReference<T> weakReference) {
        this.f45271a = weakReference;
    }

    @Override // com.huawei.wearengine.C8887d.b
    /* renamed from: a */
    public void mo56499a() {
        WeakReference<T> weakReference = this.f45271a;
        if (weakReference == null) {
            C12860b.m77197a("WearEngineReleaseConnectCallback", "onReleaseConnection mWeakReference is null");
            return;
        }
        T t10 = weakReference.get();
        if (t10 != null) {
            t10.mo73422g();
        }
    }
}
