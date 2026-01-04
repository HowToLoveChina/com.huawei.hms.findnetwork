package com.huawei.hms.videokit.player;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.huawei.hms.videokit.player.b */
/* loaded from: classes8.dex */
public class C6543b {

    /* renamed from: c */
    private static final Object f30307c = new Object();

    /* renamed from: d */
    private static volatile C6543b f30308d;

    /* renamed from: a */
    private Map<String, C6560h> f30309a = new HashMap();

    /* renamed from: b */
    private LinkedList<String> f30310b = new LinkedList<>();

    /* renamed from: b */
    public static C6543b m37207b() {
        if (f30308d == null) {
            synchronized (f30307c) {
                try {
                    if (f30308d == null) {
                        f30308d = new C6543b();
                    }
                } finally {
                }
            }
        }
        return f30308d;
    }

    /* renamed from: a */
    public void m37208a() {
        C6550c1.m37264c("AuthCacheManager", "clear all cache");
        this.f30310b.clear();
        this.f30309a.clear();
    }

    /* renamed from: a */
    public void m37209a(String str) {
        C6550c1.m37256a("AuthCacheManager", "delete cache key :" + str);
        this.f30310b.remove(str);
        this.f30309a.remove(str);
    }

    /* renamed from: b */
    public synchronized C6560h m37211b(String str) {
        C6560h c6560h = this.f30309a.get(str);
        if (c6560h == null) {
            return new C6560h();
        }
        if (System.currentTimeMillis() - c6560h.m37372a() >= 600000) {
            m37209a(str);
            return new C6560h();
        }
        if (c6560h.m37378d()) {
            return c6560h;
        }
        return new C6560h();
    }

    /* renamed from: a */
    public synchronized void m37210a(String str, C6560h c6560h) {
        try {
            if (!TextUtils.isEmpty(str) && c6560h.m37378d()) {
                c6560h.m37373a(System.currentTimeMillis());
                if (this.f30309a.size() >= 10000) {
                    String strRemoveFirst = this.f30310b.removeFirst();
                    C6550c1.m37256a("AuthCacheManager", "delete cache playParam");
                    this.f30309a.remove(strRemoveFirst);
                }
                this.f30309a.put(str, c6560h);
                this.f30310b.add(str);
                return;
            }
            C6550c1.m37265d("AuthCacheManager", "cache param empty");
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
