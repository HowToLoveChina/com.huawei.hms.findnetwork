package com.huawei.openalliance.p169ad.utils;

import android.util.LruCache;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.inter.data.PermissionEntity;
import java.lang.ref.SoftReference;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.cc */
/* loaded from: classes2.dex */
public class C7783cc {

    /* renamed from: a */
    private static final String f35972a = "cc";

    /* renamed from: b */
    private static final byte[] f35973b = new byte[0];

    /* renamed from: c */
    private static C7783cc f35974c;

    /* renamed from: d */
    private SoftReference<LruCache<String, List<PermissionEntity>>> f35975d;

    /* renamed from: a */
    public static C7783cc m47879a() {
        C7783cc c7783cc;
        synchronized (f35973b) {
            try {
                if (f35974c == null) {
                    f35974c = new C7783cc();
                }
                c7783cc = f35974c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7783cc;
    }

    /* renamed from: b */
    private LruCache<String, List<PermissionEntity>> m47880b() {
        SoftReference<LruCache<String, List<PermissionEntity>>> softReference = this.f35975d;
        LruCache<String, List<PermissionEntity>> lruCache = softReference != null ? softReference.get() : null;
        if (lruCache != null) {
            return lruCache;
        }
        LruCache<String, List<PermissionEntity>> lruCache2 = new LruCache<>(5);
        this.f35975d = new SoftReference<>(lruCache2);
        return lruCache2;
    }

    /* renamed from: a */
    public List<PermissionEntity> m47881a(String str) {
        try {
            return m47880b().get(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(f35972a, "get cache encounter: " + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public void m47882a(String str, List<PermissionEntity> list) {
        try {
            m47880b().put(str, list);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(f35972a, "put cache encounter: " + th2.getClass().getSimpleName());
        }
    }
}
