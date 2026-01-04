package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.n5 */
/* loaded from: classes8.dex */
public class C6021n5 {

    /* renamed from: i */
    public static final String f27576i = "RequestMetrics";

    /* renamed from: a */
    public String f27577a;

    /* renamed from: b */
    public long f27578b;

    /* renamed from: c */
    public long f27579c;

    /* renamed from: d */
    public long f27580d;

    /* renamed from: e */
    public long f27581e;

    /* renamed from: f */
    public long f27582f;

    /* renamed from: g */
    public String f27583g;

    /* renamed from: h */
    public boolean f27584h;

    public C6021n5(Interceptor.Chain chain) {
        RequestFinishedInfo requestFinishedInfo = chain.requestFinishedInfo();
        if (requestFinishedInfo != null) {
            RequestFinishedInfo.MetricsTime metricsTime = requestFinishedInfo.getMetricsTime();
            this.f27577a = chain.requestFinishedInfo().getHost();
            this.f27583g = requestFinishedInfo.getMetrics().getSuccessIp();
            this.f27584h = requestFinishedInfo.getResponse() == null ? false : requestFinishedInfo.getResponse().isOK();
            if (metricsTime != null) {
                this.f27578b = metricsTime.getDnsEndTime() - metricsTime.getDnsStartTime();
                this.f27579c = metricsTime.getConnectEndTime() - metricsTime.getConnectStartTime();
                this.f27580d = metricsTime.getSecureConnectEndTime() - metricsTime.getSecureConnectStartTime();
                this.f27581e = metricsTime.getConnectStartTime();
                this.f27582f = metricsTime.getSecureConnectStartTime();
            }
        }
    }

    /* renamed from: a */
    public long m34888a() {
        return this.f27581e;
    }

    /* renamed from: b */
    public long m34889b() {
        return this.f27579c;
    }

    /* renamed from: c */
    public long m34890c() {
        return this.f27578b;
    }

    /* renamed from: d */
    public String m34891d() {
        return this.f27577a;
    }

    /* renamed from: e */
    public String m34892e() {
        return this.f27583g;
    }

    /* renamed from: f */
    public long m34893f() {
        return this.f27582f;
    }

    /* renamed from: g */
    public long m34894g() {
        return this.f27580d;
    }

    /* renamed from: h */
    public boolean m34895h() {
        return this.f27584h;
    }

    /* renamed from: i */
    public JSONObject m34896i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("domain", this.f27577a);
            jSONObject.put(C6047p5.f27703d, this.f27583g);
            jSONObject.put(C6047p5.f27704e, this.f27578b);
            jSONObject.put(C6047p5.f27705f, this.f27579c);
            jSONObject.put(C6047p5.f27706g, this.f27580d);
            jSONObject.put(C6047p5.f27707h, this.f27581e);
        } catch (JSONException unused) {
            Logger.m32145w(f27576i, "Generate RequestMetrics Error");
        }
        return jSONObject;
    }

    public C6021n5(RequestFinishedInfo requestFinishedInfo) {
        if (requestFinishedInfo == null || requestFinishedInfo.getMetricsTime() == null) {
            return;
        }
        RequestFinishedInfo.MetricsTime metricsTime = requestFinishedInfo.getMetricsTime();
        this.f27577a = requestFinishedInfo.getHost();
        this.f27578b = metricsTime.getDnsEndTime() - metricsTime.getDnsStartTime();
        this.f27579c = metricsTime.getConnectEndTime() - metricsTime.getConnectStartTime();
        this.f27580d = metricsTime.getSecureConnectEndTime() - metricsTime.getSecureConnectStartTime();
        this.f27581e = metricsTime.getConnectStartTime();
        this.f27582f = metricsTime.getSecureConnectStartTime();
        this.f27583g = requestFinishedInfo.getMetrics().getSuccessIp();
        this.f27584h = requestFinishedInfo.getResponse() == null ? false : requestFinishedInfo.getResponse().isOK();
    }
}
