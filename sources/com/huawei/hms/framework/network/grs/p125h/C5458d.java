package com.huawei.hms.framework.network.grs.p125h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.h.d */
/* loaded from: classes8.dex */
public class C5458d {

    /* renamed from: a */
    private static final Map<String, a> f25004a = new ConcurrentHashMap(16);

    /* renamed from: com.huawei.hms.framework.network.grs.h.d$a */
    public static class a {

        /* renamed from: a */
        private final long f25005a;

        /* renamed from: b */
        private final long f25006b;

        public a(long j10, long j11) {
            this.f25005a = j10;
            this.f25006b = j11;
        }

        /* renamed from: a */
        public boolean m32330a() {
            return SystemClock.elapsedRealtime() - this.f25006b <= this.f25005a;
        }
    }

    /* renamed from: a */
    public static a m32328a(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of get is before: ");
        Map<String, a> map = f25004a;
        sb2.append(map.size());
        Logger.m32143v("RequestUtil", sb2.toString());
        a aVar = map.get(str);
        Logger.m32143v("RequestUtil", "map size of get is after: " + map.size());
        return aVar;
    }

    /* renamed from: a */
    public static void m32329a(String str, a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of put is before: ");
        Map<String, a> map = f25004a;
        sb2.append(map.size());
        Logger.m32143v("RequestUtil", sb2.toString());
        map.put(str, aVar);
        Logger.m32143v("RequestUtil", "map size of put is after: " + map.size());
    }
}
