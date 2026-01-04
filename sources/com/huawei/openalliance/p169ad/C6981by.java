package com.huawei.openalliance.p169ad;

import android.content.Context;

/* renamed from: com.huawei.openalliance.ad.by */
/* loaded from: classes8.dex */
public class C6981by {

    /* renamed from: a */
    private static C6981by f32090a;

    /* renamed from: b */
    private static final byte[] f32091b = new byte[0];

    /* renamed from: c */
    private Context f32092c;

    private C6981by(Context context) {
        this.f32092c = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C6981by m41146a(Context context) {
        C6981by c6981by;
        synchronized (f32091b) {
            try {
                if (f32090a == null) {
                    f32090a = new C6981by(context);
                }
                c6981by = f32090a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c6981by;
    }

    /* renamed from: a */
    public InterfaceC7612qn m41147a(int i10, int i11) {
        AbstractC7185ho.m43818a("AppDataCollectionManager", "get processor type : %s", Integer.valueOf(i10));
        if (i10 != 1) {
            return null;
        }
        return new C7546on(this.f32092c, i11);
    }
}
