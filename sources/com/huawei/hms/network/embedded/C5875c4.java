package com.huawei.hms.network.embedded;

import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.c4 */
/* loaded from: classes8.dex */
public class C5875c4 {

    /* renamed from: a */
    public C5889d4 f26563a = new C5889d4();

    /* renamed from: a */
    public void m34024a() {
    }

    /* renamed from: b */
    public void m34031b() {
    }

    /* renamed from: c */
    public void m34034c() {
    }

    /* renamed from: d */
    public void m34035d() {
    }

    /* renamed from: e */
    public void m34036e() {
    }

    public RequestFinishedInfo getRequestFinishedInfo() {
        return this.f26563a;
    }

    /* renamed from: a */
    public void m34025a(long j10) {
        this.f26563a.getMetrics().setRequestByteCount(j10);
    }

    /* renamed from: b */
    public void m34032b(long j10) {
        this.f26563a.getMetrics().setResponseByteCount(j10);
    }

    /* renamed from: a */
    public void m34026a(Response response) {
        this.f26563a.getMetricsTime().setCallEndTime();
        this.f26563a.getMetricsRealTime().setCallEndTime();
    }

    /* renamed from: b */
    public void m34033b(String str) {
    }

    /* renamed from: a */
    public void m34027a(Exception exc) {
        this.f26563a.setException(exc);
        this.f26563a.getMetricsTime().setCallEndTime();
        this.f26563a.getMetricsRealTime().setCallEndTime();
    }

    /* renamed from: a */
    public void m34028a(String str) {
        this.f26563a.setUrl(str);
        this.f26563a.getMetricsTime().setCallStartTime();
        this.f26563a.getMetricsRealTime().setCallStartTime();
    }

    /* renamed from: a */
    public void m34029a(String str, String str2, String str3, InterfaceC5886d1 interfaceC5886d1) {
    }

    /* renamed from: a */
    public void m34030a(Map<String, List<String>> map) {
    }
}
