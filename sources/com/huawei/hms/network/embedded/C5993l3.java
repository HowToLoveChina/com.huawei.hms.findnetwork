package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.huawei.hms.network.embedded.l3 */
/* loaded from: classes8.dex */
public class C5993l3 extends AbstractC6070r2 {

    /* renamed from: l */
    public static final String f27368l = "OkhttpConnRequestFinish";

    /* renamed from: g */
    public String f27369g;

    /* renamed from: h */
    public String f27370h;

    /* renamed from: i */
    public AbstractC6122v2 f27371i = new a(false);

    /* renamed from: j */
    public AbstractC6122v2 f27372j = new a(true);

    /* renamed from: k */
    public C6109u2 f27373k = new C6109u2();

    /* renamed from: com.huawei.hms.network.embedded.l3$a */
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
            return getAndCheckEndTime(getCallStartTime(), this.ttfb) - getCallStartTime();
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6122v2, com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
        public long getTtfbV1() {
            return getAndCheckEndTime(getCallStartTime(), this.ttfbV1) - getCallStartTime();
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6070r2, com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getHost() {
        return this.f27369g;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public C6109u2 getMetrics() {
        return this.f27373k;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public AbstractC6122v2 getMetricsRealTime() {
        return this.f27372j;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public AbstractC6122v2 getMetricsTime() {
        return this.f27371i;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getNetworkSdkType() {
        return "type_okhttp";
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6070r2, com.huawei.hms.network.httpclient.RequestFinishedInfo
    public long getPingInterval() {
        return this.f27371i.getPingInterval();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6070r2, com.huawei.hms.network.httpclient.RequestFinishedInfo
    public String getUrl() {
        return this.f27370h;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6070r2
    public void setUrl(String str) {
        this.f27370h = str;
        try {
            this.f27369g = new URL(str).getHost();
        } catch (MalformedURLException unused) {
            Logger.m32141i(f27368l, "fail to get hostname from url");
        }
    }
}
