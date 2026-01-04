package com.huawei.hms.push.utils.p137ha;

/* loaded from: classes8.dex */
public class PushAnalyticsCenter {

    /* renamed from: a */
    private PushBaseAnalytics f29733a;

    /* renamed from: com.huawei.hms.push.utils.ha.PushAnalyticsCenter$a */
    public static class C6305a {

        /* renamed from: a */
        private static PushAnalyticsCenter f29734a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return C6305a.f29734a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f29733a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f29733a = pushBaseAnalytics;
    }
}
