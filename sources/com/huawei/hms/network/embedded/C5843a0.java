package com.huawei.hms.network.embedded;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.inner.DomainManager;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.a0 */
/* loaded from: classes8.dex */
public class C5843a0 {

    /* renamed from: a */
    public static final String f26295a = "CacheManager";

    /* renamed from: c */
    public static final int f26297c = 300000;

    /* renamed from: b */
    public static final C5885d0<C6003m0> f26296b = new C5885d0<>();

    /* renamed from: d */
    public static long f26298d = 0;

    /* renamed from: a */
    public static C6003m0 m33733a(String str) {
        C6003m0 c6003m0M34095b = f26296b.m34095b(str);
        if (c6003m0M34095b == null) {
            return null;
        }
        Logger.m32143v(f26295a, "Memory Cache host:" + str);
        c6003m0M34095b.m34737a(1);
        int iM34752g = c6003m0M34095b.m34752g();
        if (iM34752g == 0) {
            return c6003m0M34095b;
        }
        if (iM34752g != 1) {
            m33740c(str);
            return null;
        }
        C5925g0.m34278a(str, "dns_lazy_update", C6093t.m35329m().m35367k() ? 3 : 2);
        return c6003m0M34095b;
    }

    /* renamed from: b */
    public static C6003m0 m33737b(String str) {
        return C5871c0.m34002a(str);
    }

    /* renamed from: c */
    public static Map<String, C6003m0> m33739c() {
        return f26296b.m34096b();
    }

    /* renamed from: d */
    public static void m33741d() {
        Logger.m32143v(f26295a, "enter loadFileCacheToMemeory");
        try {
            for (Map.Entry<String, C6003m0> entry : C5871c0.m34006b().entrySet()) {
                Logger.m32144v(f26295a, "Load a record from File, host:%s, value:%s", entry.getKey(), entry.getValue());
                f26296b.m34094a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e10) {
            Logger.m32145w(f26295a, "loadFileCacheToMemeory error:" + e10.getMessage());
        }
    }

    /* renamed from: e */
    public static void m33742e() {
        Map<String, C6003m0> mapM33739c = m33739c();
        if (mapM33739c == null || mapM33739c.isEmpty()) {
            return;
        }
        Logger.m32144v(f26295a, "Totol Cache Num: %s", Integer.valueOf(mapM33739c.size()));
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f26298d < 300000 || !NetworkUtil.isForeground()) {
            return;
        }
        Logger.m32143v(f26295a, "updateAllCache updateAll all");
        f26298d = jCurrentTimeMillis;
        ListIterator listIterator = new ArrayList(mapM33739c.entrySet()).listIterator(mapM33739c.size());
        int i10 = 0;
        while (listIterator.hasPrevious()) {
            String str = (String) ((Map.Entry) listIterator.previous()).getKey();
            if (i10 >= 5) {
                m33740c(str);
            } else if (C6093t.m35329m().m35360f(str) != 1) {
                C5925g0.m34278a(str, "dns_network_change", 2);
                i10++;
            }
        }
    }

    /* renamed from: a */
    public static void m33734a() {
        f26296b.m34092a();
    }

    /* renamed from: b */
    public static void m33738b() {
        f26296b.m34092a();
        C5871c0.m34011e();
    }

    /* renamed from: c */
    public static void m33740c(String str) {
        if (!TextUtils.isEmpty(str) && f26296b.m34093a(str)) {
            C5871c0.m34007b(str);
        }
    }

    /* renamed from: a */
    public static void m33735a(NetworkInfo networkInfo) {
        int iM35712c = C6132w.m35712c();
        if (iM35712c == 0) {
            m33734a();
            return;
        }
        if (iM35712c != 1) {
            if (iM35712c != 2) {
                Logger.m32145w(f26295a, "Unkown netowrk change strategy, used to update all cache, strategy:" + C6132w.m35712c());
            }
        } else if (networkInfo == null || NetworkUtil.getNetworkType(networkInfo) != 1) {
            return;
        }
        m33742e();
    }

    /* renamed from: a */
    public static void m33736a(String str, C6003m0 c6003m0) {
        if (TextUtils.isEmpty(str) || C6158y.m35829b(c6003m0)) {
            Logger.m32145w(f26295a, "saveValidIP: host or dnsResult is null");
            return;
        }
        if (DomainManager.getInstance().isExcludePrefetch(str)) {
            Logger.m32143v(f26295a, "exclude save db");
            return;
        }
        C5885d0<C6003m0> c5885d0 = f26296b;
        C6003m0 c6003m0M34095b = c5885d0.m34095b(str);
        if (c6003m0.m34741a(c6003m0M34095b) || c6003m0M34095b.m34752g() != 0) {
            Logger.m32144v(f26295a, "saveValidIP，host: %s, value: %s", str, c6003m0);
            c5885d0.m34094a(str, c6003m0);
            C5871c0.m34008b(str, c6003m0);
        }
    }
}
