package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.i2 */
/* loaded from: classes8.dex */
public class C5953i2 extends AbstractC6070r2 {

    /* renamed from: i */
    public static final String f26999i = "CronetRequestFinishedInfo";

    /* renamed from: g */
    public AbstractC6122v2 f27000g = new a();

    /* renamed from: h */
    public C6109u2 f27001h = new C6109u2();

    /* renamed from: com.huawei.hms.network.embedded.i2$a */
    public static class a extends AbstractC6122v2 {

        /* renamed from: u */
        public long f27002u;

        /* renamed from: v */
        public long f27003v;

        @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
        public long getTotalTime() {
            return this.f27002u;
        }

        @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
        public long getTtfb() {
            return this.f27003v;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6122v2, com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
        public long getTtfbV1() {
            return this.f27003v;
        }

        public void setTotalTime(long j10) {
            this.f27002u = j10;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6122v2
        public void setTtfb(long j10) {
            this.f27003v = j10;
        }
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public C6109u2 getMetrics() {
        return this.f27001h;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public AbstractC6122v2 getMetricsRealTime() {
        return this.f27000g;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public AbstractC6122v2 getMetricsTime() {
        return this.f27000g;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getNetworkSdkType() {
        return "type_cronet";
    }
}
