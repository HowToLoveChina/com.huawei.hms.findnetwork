package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.nl */
/* loaded from: classes8.dex */
public class C7517nl implements IPPSWebEventCallback {

    /* renamed from: a */
    private Map<String, IPPSWebEventCallback> f34917a;

    /* renamed from: com.huawei.openalliance.ad.nl$a */
    public static class a {

        /* renamed from: a */
        private static final C7517nl f34918a = new C7517nl();
    }

    private C7517nl() {
        this.f34917a = new ConcurrentHashMap();
    }

    /* renamed from: a */
    public static C7517nl m46150a() {
        return a.f34918a;
    }

    /* renamed from: b */
    public void m46152b(IPPSWebEventCallback iPPSWebEventCallback) {
        Map<String, IPPSWebEventCallback> map = this.f34917a;
        if (iPPSWebEventCallback == null) {
            map.remove("jsb_listener_key");
        } else {
            map.put("jsb_listener_key", iPPSWebEventCallback);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback
    public void onWebClose(int i10) {
        for (IPPSWebEventCallback iPPSWebEventCallback : this.f34917a.values()) {
            if (iPPSWebEventCallback != null) {
                iPPSWebEventCallback.onWebClose(i10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback
    public void onWebOpen() {
        for (IPPSWebEventCallback iPPSWebEventCallback : this.f34917a.values()) {
            if (iPPSWebEventCallback != null) {
                iPPSWebEventCallback.onWebOpen();
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback
    public void onWebloadFinish() {
        for (IPPSWebEventCallback iPPSWebEventCallback : this.f34917a.values()) {
            if (iPPSWebEventCallback != null) {
                iPPSWebEventCallback.onWebloadFinish();
            }
        }
    }

    /* renamed from: a */
    public void m46151a(IPPSWebEventCallback iPPSWebEventCallback) {
        Map<String, IPPSWebEventCallback> map = this.f34917a;
        if (iPPSWebEventCallback == null) {
            map.remove("outer_listener_key");
        } else {
            map.put("outer_listener_key", iPPSWebEventCallback);
        }
    }
}
