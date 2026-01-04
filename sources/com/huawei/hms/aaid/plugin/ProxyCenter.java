package com.huawei.hms.aaid.plugin;

/* loaded from: classes8.dex */
public class ProxyCenter {
    private PushProxy proxy;

    /* renamed from: com.huawei.hms.aaid.plugin.ProxyCenter$a */
    public static class C5046a {

        /* renamed from: a */
        private static ProxyCenter f23040a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return C5046a.f23040a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
