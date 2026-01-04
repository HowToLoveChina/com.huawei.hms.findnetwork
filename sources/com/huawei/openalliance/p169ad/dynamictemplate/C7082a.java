package com.huawei.openalliance.p169ad.dynamictemplate;

import android.util.LruCache;

/* renamed from: com.huawei.openalliance.ad.dynamictemplate.a */
/* loaded from: classes2.dex */
public class C7082a {

    /* renamed from: a */
    private static C7082a f32619a;

    /* renamed from: b */
    private static final byte[] f32620b = new byte[0];

    /* renamed from: c */
    private IImageLoader f32621c;

    /* renamed from: d */
    private final LruCache<String, String> f32622d = new LruCache<>(100);

    /* renamed from: a */
    public static C7082a m42807a() {
        C7082a c7082a;
        synchronized (f32620b) {
            try {
                if (f32619a == null) {
                    f32619a = new C7082a();
                }
                c7082a = f32619a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7082a;
    }

    /* renamed from: a */
    public void m42808a(IImageLoader iImageLoader) {
        this.f32621c = iImageLoader;
    }
}
