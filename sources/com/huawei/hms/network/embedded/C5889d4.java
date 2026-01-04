package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.d4 */
/* loaded from: classes8.dex */
public class C5889d4 extends AbstractC6070r2 {

    /* renamed from: j */
    public static final String f26638j = "URLConnRequestFinishedInfo";

    /* renamed from: g */
    public AbstractC6122v2 f26639g = new a(false);

    /* renamed from: h */
    public AbstractC6122v2 f26640h = new a(true);

    /* renamed from: i */
    public C6109u2 f26641i = new C6109u2();

    /* renamed from: com.huawei.hms.network.embedded.d4$a */
    public static class a extends AbstractC6122v2 {
        public a(boolean z10) {
            super(z10);
        }

        @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
        public long getTotalTime() {
            return getAndCheckEndTime(getCallStartTime(), getCallEndTime()) - getCallStartTime();
        }

        @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
        public long getTtfb() {
            return 0L;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6122v2, com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
        public long getTtfbV1() {
            return 0L;
        }
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public C6109u2 getMetrics() {
        return this.f26641i;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public AbstractC6122v2 getMetricsRealTime() {
        return this.f26640h;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public AbstractC6122v2 getMetricsTime() {
        return this.f26639g;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getNetworkSdkType() {
        return "type_urlconnection";
    }
}
