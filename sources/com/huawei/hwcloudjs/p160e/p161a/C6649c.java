package com.huawei.hwcloudjs.p160e.p161a;

import com.huawei.hwcloudjs.p164f.C6659d;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.huawei.hwcloudjs.e.a.c */
/* loaded from: classes8.dex */
public final class C6649c {

    /* renamed from: a */
    private static final String f30864a = "CacheManager";

    /* renamed from: b */
    private static final C6649c f30865b = new C6649c();

    /* renamed from: c */
    private static HashMap<String, C6645a> f30866c = new C6648b(100);

    /* renamed from: d */
    private long f30867d = 10000000;

    /* renamed from: e */
    private long f30868e = 0;

    private C6649c() {
    }

    /* renamed from: a */
    public synchronized void m37856a() {
        f30866c.clear();
        this.f30868e = 0L;
    }

    /* renamed from: b */
    public synchronized int m37860b() {
        return f30866c.size();
    }

    /* renamed from: c */
    public synchronized long m37862c() {
        return this.f30868e;
    }

    /* renamed from: d */
    public synchronized C6645a m37864d(String str) {
        StringBuilder sb2;
        C6645a c6645aM37863c = m37863c(str);
        if (c6645aM37863c == null) {
            c6645aM37863c = null;
        }
        if (c6645aM37863c != null) {
            C6659d.m37882c("CacheManager", "getCacheInfo success!", true);
            return c6645aM37863c;
        }
        try {
            URL url = new URL(str);
            if (url.getPath().isEmpty() || url.getPath().equalsIgnoreCase("/")) {
                sb2 = new StringBuilder();
                sb2.append(url.getProtocol());
                sb2.append("://");
                sb2.append(url.getAuthority());
            } else {
                sb2 = new StringBuilder();
                sb2.append(url.getProtocol());
                sb2.append("://");
                sb2.append(url.getAuthority());
                sb2.append(url.getPath());
            }
            C6645a c6645aM37863c2 = m37863c(sb2.toString());
            if (c6645aM37863c2 != null) {
                c6645aM37863c = c6645aM37863c2;
            } else {
                C6659d.m37882c("CacheManager", "getCacheInfo(urlPath) is not Cache type", true);
            }
            return c6645aM37863c;
        } catch (MalformedURLException unused) {
            C6659d.m37881b("CacheManager", "MalformedURLException", true);
            return null;
        }
    }

    /* renamed from: e */
    public long m37865e() {
        return this.f30867d;
    }

    /* renamed from: d */
    public static C6649c m37855d() {
        return f30865b;
    }

    /* renamed from: a */
    public void m37857a(long j10) {
        this.f30867d = j10;
    }

    /* renamed from: b */
    public synchronized C6645a m37861b(String str) {
        C6645a c6645a;
        c6645a = f30866c.get(str);
        if (c6645a != null) {
            return c6645a;
        }
        return null;
    }

    /* renamed from: c */
    public synchronized C6645a m37863c(String str) {
        if (!m37866e(str)) {
            return null;
        }
        C6645a c6645aM37861b = m37861b(str);
        if (c6645aM37861b != null && c6645aM37861b.m37849b() == 0) {
            this.f30868e -= c6645aM37861b.m37852d();
            f30866c.remove(str);
        }
        return c6645aM37861b;
    }

    /* renamed from: e */
    public synchronized boolean m37866e(String str) {
        return f30866c.containsKey(str);
    }

    /* renamed from: a */
    public synchronized void m37858a(String str) {
        try {
            if (m37861b(str) != null) {
                this.f30868e -= r0.m37852d();
            }
            f30866c.remove(str);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m37859a(String str, C6645a c6645a) {
        try {
            if (f30866c.get(str) != null) {
                this.f30868e -= r0.m37852d();
            }
            f30866c.put(str, c6645a);
            long jM37852d = this.f30868e + c6645a.m37852d();
            this.f30868e = jM37852d;
            if (jM37852d > this.f30867d) {
                Iterator<Map.Entry<String, C6645a>> it = f30866c.entrySet().iterator();
                while (it.hasNext()) {
                    m37858a(it.next().getKey());
                    if (this.f30868e < this.f30867d / 2) {
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
