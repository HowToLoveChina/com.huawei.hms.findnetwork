package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.network.NetworkKit;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.ik */
/* loaded from: classes8.dex */
public class C7217ik {

    /* renamed from: a */
    private static Context f33208a;

    /* renamed from: b */
    private static boolean f33209b;

    /* renamed from: c */
    private static InterfaceC7320iu f33210c;

    /* renamed from: a */
    public static InterfaceC7320iu m43939a() {
        return f33210c;
    }

    /* renamed from: b */
    private static void m43941b(Context context) {
        if (!AbstractC7741ao.m47594p(context) || !AbstractC7741ao.m47579f()) {
            f33209b = false;
            AbstractC7185ho.m43820b("MediaCacheFactory", "not enable user info, skip init.");
            return;
        }
        try {
            AbstractC7185ho.m43820b("MediaCacheFactory", "initNetowrkKit");
            NetworkKit.init(context, null);
            f33210c = new C7220in(8, 5000, 30000);
        } catch (Throwable th2) {
            f33209b = false;
            AbstractC7185ho.m43824c("MediaCacheFactory", "init networkKit error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m43940a(Context context) {
        if (f33209b) {
            AbstractC7185ho.m43817a("MediaCacheFactory", "SdkFactory already initialized.");
            return;
        }
        AbstractC7185ho.m43820b("MediaCacheFactory", "init");
        f33209b = true;
        Context applicationContext = context.getApplicationContext();
        f33208a = applicationContext;
        m43941b(applicationContext);
    }
}
