package com.huawei.openalliance.p169ad.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.views.gif.C8101b;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.utils.ay */
/* loaded from: classes2.dex */
public class C7751ay {

    /* renamed from: b */
    private static final String f35902b = "ay";

    /* renamed from: c */
    private static C7751ay f35903c;

    /* renamed from: d */
    private static final byte[] f35904d = new byte[0];

    /* renamed from: a */
    LruCache<String, WeakReference<Drawable>> f35905a;

    private C7751ay() {
        m47679b();
    }

    /* renamed from: b */
    private void m47679b() {
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        this.f35905a = new LruCache<String, WeakReference<Drawable>>(Math.min(31457280, iMaxMemory > 0 ? iMaxMemory / 4 : 31457280)) { // from class: com.huawei.openalliance.ad.utils.ay.1
            @Override // android.util.LruCache
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, WeakReference<Drawable> weakReference) {
                Drawable drawable;
                if (weakReference == null || (drawable = weakReference.get()) == null) {
                    return 1;
                }
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof C8101b) {
                        return ((C8101b) drawable).m50250c();
                    }
                    return 1;
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    return bitmap.getByteCount();
                }
                return 1;
            }
        };
    }

    /* renamed from: a */
    public Drawable m47680a(String str) {
        try {
            WeakReference<Drawable> weakReference = this.f35905a.get(str);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(f35902b, "get cache encounter: " + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public static C7751ay m47678a() {
        C7751ay c7751ay;
        synchronized (f35904d) {
            try {
                if (f35903c == null) {
                    f35903c = new C7751ay();
                }
                c7751ay = f35903c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7751ay;
    }

    /* renamed from: a */
    public void m47681a(String str, Drawable drawable) {
        try {
            this.f35905a.put(str, new WeakReference<>(drawable));
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(f35902b, "put cache encounter: " + th2.getClass().getSimpleName());
        }
    }
}
