package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.inner.api.RequestContext;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.ai.h */
/* loaded from: classes8.dex */
public class C5800h {

    /* renamed from: b */
    public static final String f25880b = "ModelDispatcher";

    /* renamed from: a */
    public Map<String, InterfaceC5802i> f25881a;

    /* renamed from: com.huawei.hms.network.ai.h$b */
    public static class b {

        /* renamed from: a */
        public static final C5800h f25882a = new C5800h();
    }

    public C5800h() {
        this.f25881a = new ConcurrentHashMap();
    }

    /* renamed from: d */
    public static C5800h m33340d() {
        return b.f25882a;
    }

    /* renamed from: a */
    public void m33341a() {
        Iterator<InterfaceC5802i> it = this.f25881a.values().iterator();
        while (it.hasNext()) {
            it.next().mo33284c();
        }
    }

    /* renamed from: b */
    public void m33345b() {
        Iterator<InterfaceC5802i> it = this.f25881a.values().iterator();
        while (it.hasNext()) {
            it.next().mo33283b();
        }
    }

    /* renamed from: c */
    public void m33346c() {
        Iterator<InterfaceC5802i> it = this.f25881a.values().iterator();
        while (it.hasNext()) {
            it.next().mo33279a();
        }
    }

    /* renamed from: a */
    public void m33342a(Request request) {
        String str;
        C5808l c5808l = new C5808l(request);
        if (C5788b.f25737g.equals(c5808l.m33420a())) {
            str = "request has error url";
        } else {
            if (!c5808l.m33422c()) {
                for (InterfaceC5802i interfaceC5802i : this.f25881a.values()) {
                    Logger.m32136d(f25880b, "dispatchRequest");
                    interfaceC5802i.mo33281a(c5808l);
                }
                return;
            }
            str = "request is only connect";
        }
        Logger.m32136d(f25880b, str);
    }

    /* renamed from: a */
    public void m33343a(RequestContext requestContext) {
        String str;
        if (requestContext.requestFinishedInfo() == null) {
            return;
        }
        C5808l c5808l = new C5808l(requestContext.request());
        if (C5788b.f25737g.equals(c5808l.m33420a())) {
            str = "response has error url";
        } else {
            if (!c5808l.m33422c()) {
                for (InterfaceC5802i interfaceC5802i : this.f25881a.values()) {
                    Logger.m32136d(f25880b, "dispatchResponse");
                    if (requestContext.requestFinishedInfo() != null) {
                        interfaceC5802i.mo33282a(requestContext);
                    }
                }
                return;
            }
            str = "response is only connect";
        }
        Logger.m32136d(f25880b, str);
    }

    /* renamed from: a */
    public void m33344a(String str, InterfaceC5802i interfaceC5802i) {
        this.f25881a.put(str, interfaceC5802i);
    }
}
