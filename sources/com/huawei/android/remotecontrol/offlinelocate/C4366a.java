package com.huawei.android.remotecontrol.offlinelocate;

import android.content.Intent;
import com.huawei.trustcircle.EnhancedCircleManager;
import p015ak.C0213f;
import p521og.C11873f;
import p521og.C11877j;
import p664u0.C13108a;

/* renamed from: com.huawei.android.remotecontrol.offlinelocate.a */
/* loaded from: classes4.dex */
public class C4366a {

    /* renamed from: c */
    public static final Object f19983c = new Object();

    /* renamed from: d */
    public static C4366a f19984d;

    /* renamed from: a */
    public volatile int f19985a = -2;

    /* renamed from: b */
    public EnhancedCircleManager f19986b = EnhancedCircleManager.getInstance(C11873f.m71178f().m71181c());

    /* renamed from: b */
    public static C4366a m26382b() {
        C4366a c4366a;
        synchronized (f19983c) {
            try {
                if (f19984d == null) {
                    f19984d = new C4366a();
                }
                c4366a = f19984d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c4366a;
    }

    /* renamed from: a */
    public int m26383a() {
        if (this.f19985a == -2) {
            this.f19985a = C11877j.m71279k0(C0213f.m1377a());
        }
        return this.f19985a;
    }

    /* renamed from: c */
    public boolean m26384c() {
        return this.f19986b.isFeatureSupported();
    }

    /* renamed from: d */
    public void m26385d(int i10) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.remotecontrol.intent.TRUST_CIRCLE_RESULT");
        intent.putExtra("exeResult", i10);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: e */
    public void m26386e(int i10) {
        this.f19985a = i10;
        C11877j.m71304s1(C0213f.m1377a(), i10);
    }
}
