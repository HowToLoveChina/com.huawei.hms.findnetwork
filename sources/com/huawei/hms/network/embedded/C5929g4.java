package com.huawei.hms.network.embedded;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Request;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.huawei.hms.network.embedded.g4 */
/* loaded from: classes8.dex */
public class C5929g4 {

    /* renamed from: c */
    public static final String f26841c = "AllLinkDelayAnalysisHelper";

    /* renamed from: d */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile C5929g4 f26842d = null;

    /* renamed from: e */
    public static final String f26843e = "network-in";

    /* renamed from: f */
    public static final String f26844f = "network-out";

    /* renamed from: g */
    public static final String f26845g = "network-vendor";

    /* renamed from: h */
    public static final String f26846h = "net-msg-id";

    /* renamed from: i */
    public static final String f26847i = "NWK";

    /* renamed from: j */
    public static final char f26848j = ';';

    /* renamed from: k */
    public static final char f26849k = '(';

    /* renamed from: l */
    public static final char f26850l = ')';

    /* renamed from: m */
    public static final String f26851m = "time";

    /* renamed from: n */
    public static final char f26852n = '/';

    /* renamed from: a */
    public boolean f26853a = false;

    /* renamed from: b */
    public boolean f26854b = false;

    /* renamed from: a */
    private String m34298a() {
        return C6108u1.parseCurrentUTCTime();
    }

    /* renamed from: b */
    private String m34300b() {
        return "NWK(time/" + m34298a() + f26850l;
    }

    public static C5929g4 getInstance() {
        if (f26842d == null) {
            synchronized (C5929g4.class) {
                try {
                    if (f26842d == null) {
                        f26842d = new C5929g4();
                    }
                } finally {
                }
            }
        }
        return f26842d;
    }

    public boolean addQuicTrace() {
        return false;
    }

    public void addUUIDWithoutDash(Request.Builder builder, Map<String, List<String>> map) {
        if (map.containsKey(f26846h)) {
            return;
        }
        builder.addHeader(f26846h, UUID.randomUUID().toString().replaceAll("-", ""));
    }

    public void enableAllLinkDelayAnalysis(boolean z10) {
        this.f26853a = z10;
    }

    public String getNetMsgIdFromRequest(C5939h1.d dVar) {
        return (dVar.getHeaders().get(f26846h) == null || dVar.getHeaders().get(f26846h).size() <= 0) ? "" : dVar.getHeaders().get(f26846h).get(0).toString();
    }

    public C5939h1.d traceRequestNetworkKitInEvent(C5939h1.d dVar) {
        if (!this.f26853a) {
            Logger.m32143v(f26841c, "isEnableAllLinkDelayAnalysis false");
            return dVar;
        }
        Logger.m32143v(f26841c, "[traceRequestNetworkKitInEvent]before update:" + Headers.m33636of(dVar.getHeaders()).toString());
        Map<String, List<String>> headers = dVar.getHeaders();
        Request.Builder builderAddHeader = dVar.newBuilder().removeHeader(f26843e).addHeader(f26843e, m34299a(headers, f26843e, m34300b())).removeHeader(f26845g).addHeader(f26845g, m34299a(headers, f26845g, "NWK"));
        addUUIDWithoutDash(builderAddHeader, headers);
        Request requestBuild = builderAddHeader.build();
        Logger.m32143v(f26841c, "[traceRequestNetworkKitInEvent]after update:" + Headers.m33636of(requestBuild.getHeaders()).toString());
        return new C5939h1.d(requestBuild);
    }

    public C5939h1.d traceRequestNetworkKitOutEvent(C5939h1.d dVar) {
        if (!this.f26853a) {
            Logger.m32143v(f26841c, "isEnableAllLinkDelayAnalysis false");
            return dVar;
        }
        Logger.m32143v(f26841c, "[traceRequestNetworkKitOutEvent]before update:" + Headers.m33636of(dVar.getHeaders()).toString());
        Request requestBuild = dVar.newBuilder().removeHeader(f26844f).addHeader(f26844f, m34299a(dVar.getHeaders(), f26844f, m34300b())).build();
        Logger.m32143v(f26841c, "[traceRequestNetworkKitOutEvent]after update:" + Headers.m33636of(requestBuild.getHeaders()).toString());
        return new C5939h1.d(requestBuild);
    }

    public void traceResponseNetworkKitInEvent(AbstractC6174z2 abstractC6174z2) {
        if (this.f26853a) {
            abstractC6174z2.traceResponseNetworkKitInEvent(m34300b(), "NWK");
        } else {
            Logger.m32143v(f26841c, "isEnableAllLinkDelayAnalysis false");
        }
    }

    public void traceResponseNetworkKitOutEvent(AbstractC6174z2 abstractC6174z2) {
        if (this.f26853a) {
            abstractC6174z2.traceResponseNetworkKitOutEvent(m34300b());
        } else {
            Logger.m32143v(f26841c, "isEnableAllLinkDelayAnalysis false");
        }
    }

    public void userSet(boolean z10) {
        this.f26854b = z10;
    }

    /* renamed from: a */
    private String m34299a(Map<String, List<String>> map, String str, String str2) {
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next != null && StringUtils.strEquals(next, str)) {
                if (TextUtils.isEmpty(map.get(str).toString())) {
                    String string = map.get(str).toString();
                    if (string.indexOf(59) == string.length() - 1) {
                        return string + str2;
                    }
                    return string + ';' + str2;
                }
            }
        }
        return str2;
    }
}
