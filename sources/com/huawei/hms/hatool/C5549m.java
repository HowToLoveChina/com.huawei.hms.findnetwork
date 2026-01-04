package com.huawei.hms.hatool;

import android.content.Context;

/* renamed from: com.huawei.hms.hatool.m */
/* loaded from: classes8.dex */
public final class C5549m {

    /* renamed from: b */
    private static C5549m f25253b;

    /* renamed from: c */
    private static final Object f25254c = new Object();

    /* renamed from: a */
    private Context f25255a;

    private C5549m() {
    }

    /* renamed from: a */
    public static C5549m m32633a() {
        if (f25253b == null) {
            m32634b();
        }
        return f25253b;
    }

    /* renamed from: b */
    private static synchronized void m32634b() {
        if (f25253b == null) {
            f25253b = new C5549m();
        }
    }

    /* renamed from: a */
    public void m32635a(Context context) {
        synchronized (f25254c) {
            try {
                if (this.f25255a != null) {
                    C5571v.m32797f("hmsSdk", "DataManager already initialized.");
                    return;
                }
                this.f25255a = context;
                C5565s.m32733c().m32738b().m32523a(this.f25255a);
                C5565s.m32733c().m32738b().m32542j(context.getPackageName());
                C5540j.m32576a().m32579a(context);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m32636a(String str) {
        C5571v.m32786a("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f25255a;
        if (context == null) {
            C5571v.m32796e("hmsSdk", "sdk is not init");
        } else {
            C5565s.m32733c().m32738b().m32540i(C5527e1.m32503a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
