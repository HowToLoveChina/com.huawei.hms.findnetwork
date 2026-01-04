package com.huawei.openalliance.p169ad;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.ji */
/* loaded from: classes8.dex */
public class C7335ji {

    /* renamed from: a */
    private static C7335ji f34181a;

    /* renamed from: b */
    private static final byte[] f34182b = new byte[0];

    /* renamed from: c */
    private final byte[] f34183c = new byte[0];

    /* renamed from: d */
    private final Map<String, Set<a>> f34184d = new HashMap();

    /* renamed from: com.huawei.openalliance.ad.ji$a */
    public interface a {
        /* renamed from: a */
        void mo38588a(String str, Intent intent);
    }

    private C7335ji() {
    }

    /* renamed from: a */
    public static C7335ji m45308a() {
        C7335ji c7335ji;
        synchronized (f34182b) {
            try {
                if (f34181a == null) {
                    f34181a = new C7335ji();
                }
                c7335ji = f34181a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7335ji;
    }

    /* renamed from: b */
    public void m45311b(String str, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        synchronized (this.f34183c) {
            try {
                Set<a> set = this.f34184d.get(str);
                if (set != null) {
                    set.remove(aVar);
                    if (set.isEmpty()) {
                        this.f34184d.remove(str);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m45309a(final String str, final Intent intent) {
        synchronized (this.f34183c) {
            try {
                Set<a> set = this.f34184d.get(str);
                if (set != null) {
                    for (final a aVar : set) {
                        if (aVar != null) {
                            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ji.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.mo38588a(str, intent);
                                }
                            });
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m45310a(String str, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        synchronized (this.f34183c) {
            try {
                Set<a> hashSet = this.f34184d.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.f34184d.put(str, hashSet);
                }
                hashSet.add(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
