package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Request;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.embedded.s3 */
/* loaded from: classes8.dex */
public class C6084s3 {

    /* renamed from: b */
    public static final String f28155b = "HostRoute";

    /* renamed from: c */
    public static volatile C6084s3 f28156c = null;

    /* renamed from: d */
    public static final int f28157d = 1000;

    /* renamed from: e */
    public static final int f28158e = 500;

    /* renamed from: f */
    public static final int f28159f = 400;

    /* renamed from: g */
    public static final int f28160g = 3;

    /* renamed from: a */
    public final ConcurrentHashMap<String, a> f28161a = new ConcurrentHashMap<>();

    /* renamed from: com.huawei.hms.network.embedded.s3$a */
    public static class a {

        /* renamed from: a */
        public int f28162a = 500;

        /* renamed from: b */
        public int f28163b = 1;
    }

    public static C6084s3 getInstance() {
        if (f28156c == null) {
            synchronized (C6084s3.class) {
                try {
                    if (f28156c == null) {
                        f28156c = new C6084s3();
                    }
                } finally {
                }
            }
        }
        return f28156c;
    }

    /* renamed from: a */
    public Request m35252a(C5939h1.d dVar) throws JSONException {
        a aVar = this.f28161a.get(new C5888d3(dVar.getUrl()).getHost());
        if (aVar == null || aVar.f28162a == dVar.getNetConfig().getConcurrentConnectDelay()) {
            Logger.m32143v(f28155b, "request not change: ");
            return dVar;
        }
        Logger.m32143v(f28155b, "  old delay time = " + dVar.getNetConfig().getConcurrentConnectDelay() + " new delay time " + aVar.f28162a);
        dVar.getNetConfig().setValue("core_concurrent_connect_delay", aVar.f28162a);
        return dVar;
    }

    /* renamed from: a */
    public void m35253a(long j10, String str) {
        int i10;
        if (j10 <= 0 || str == null) {
            return;
        }
        if (this.f28161a.get(str) == null) {
            this.f28161a.putIfAbsent(str, new a());
        }
        a aVar = this.f28161a.get(str);
        if (j10 > 400) {
            aVar.f28162a = 1000;
            aVar.f28163b = 1;
        } else if (aVar.f28162a == 1000 && (i10 = aVar.f28163b) < 3) {
            aVar.f28163b = i10 + 1;
        } else {
            aVar.f28163b = 1;
            aVar.f28162a = 500;
        }
    }
}
