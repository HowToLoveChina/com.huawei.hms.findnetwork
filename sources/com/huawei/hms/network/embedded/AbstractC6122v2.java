package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Utils;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;

/* renamed from: com.huawei.hms.network.embedded.v2 */
/* loaded from: classes8.dex */
public abstract class AbstractC6122v2 extends RequestFinishedInfo.MetricsTime {

    /* renamed from: a */
    public long f28613a;

    /* renamed from: b */
    public long f28614b;

    /* renamed from: c */
    public long f28615c;

    /* renamed from: d */
    public long f28616d;

    /* renamed from: e */
    public long f28617e;

    /* renamed from: f */
    public long f28618f;

    /* renamed from: g */
    public long f28619g;

    /* renamed from: h */
    public long f28620h;

    /* renamed from: i */
    public long f28621i;

    /* renamed from: j */
    public long f28622j;

    /* renamed from: k */
    public long f28623k;

    /* renamed from: l */
    public long f28624l;

    /* renamed from: m */
    public long f28625m;

    /* renamed from: n */
    public long f28626n;

    /* renamed from: o */
    public long f28627o;

    /* renamed from: p */
    public long f28628p;

    /* renamed from: q */
    public long f28629q;

    /* renamed from: r */
    public long f28630r;

    /* renamed from: s */
    public boolean f28631s;

    /* renamed from: t */
    public long f28632t;
    public long ttfb;
    public long ttfbV1;

    public AbstractC6122v2() {
    }

    public long getAndCheckEndTime(long j10, long j11) {
        return (j10 == 0 || j11 != 0) ? j11 : Utils.getCurrentTime(this.f28631s);
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getCallEndTime() {
        return this.f28630r;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getCallStartTime() {
        return this.f28613a;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getConnectEndTime() {
        return this.f28619g;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getConnectStartTime() {
        return this.f28616d;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getConnectionAcquiredTime() {
        return this.f28620h;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getConnectionReleasedTime() {
        return this.f28621i;
    }

    public long getCurrentTime() {
        return Utils.getCurrentTime(this.f28631s);
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getDnsEndTime() {
        return this.f28615c;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getDnsStartTime() {
        return this.f28614b;
    }

    public long getPingInterval() {
        return this.f28632t;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getRequestBodyEndTime() {
        return this.f28625m;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getRequestBodyStartTime() {
        return this.f28624l;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getRequestHeadersEndTime() {
        return this.f28623k;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getRequestHeadersStartTime() {
        return this.f28622j;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getResponseBodyEndTime() {
        return this.f28629q;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getResponseBodyStartTime() {
        return this.f28628p;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getResponseHeadersEndTime() {
        return this.f28627o;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getResponseHeadersStartTime() {
        return this.f28626n;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getSecureConnectEndTime() {
        return this.f28618f;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public long getSecureConnectStartTime() {
        return this.f28617e;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.MetricsTime
    public abstract long getTtfbV1();

    public void setCallEndTime() {
        this.f28630r = getCurrentTime();
    }

    public void setCallStartTime() {
        this.f28613a = getCurrentTime();
    }

    public void setConnectEndTime() {
        this.f28619g = getCurrentTime();
    }

    public void setConnectStartTime() {
        this.f28616d = getCurrentTime();
    }

    public void setConnectionAcquiredTime() {
        this.f28620h = getCurrentTime();
    }

    public void setConnectionReleasedTime() {
        this.f28621i = getCurrentTime();
    }

    public void setDnsEndTime() {
        this.f28615c = getCurrentTime();
    }

    public void setDnsStartTime() {
        this.f28614b = getCurrentTime();
    }

    public void setPingInterval(long j10) {
        this.f28632t = j10;
    }

    public void setRequestBodyEndTime() {
        this.f28625m = getCurrentTime();
    }

    public void setRequestBodyStartTime() {
        this.f28624l = getCurrentTime();
    }

    public void setRequestHeadersEndTime() {
        this.f28623k = getCurrentTime();
    }

    public void setRequestHeadersStartTime() {
        this.f28622j = getCurrentTime();
    }

    public void setResponseBodyEndTime() {
        this.f28629q = getCurrentTime();
    }

    public void setResponseBodyStartTime() {
        this.f28628p = getCurrentTime();
    }

    public void setResponseHeadersEndTime() {
        this.f28627o = getCurrentTime();
    }

    public void setResponseHeadersStartTime() {
        this.f28626n = getCurrentTime();
    }

    public void setSecureConnectEndTime() {
        this.f28618f = getCurrentTime();
    }

    public void setSecureConnectStartTime() {
        this.f28617e = getCurrentTime();
    }

    public void setTtfb(long j10) {
        this.ttfb = j10;
    }

    public void setTtfbV1(long j10) {
        this.ttfbV1 = j10;
    }

    public AbstractC6122v2(boolean z10) {
        this.f28631s = z10;
    }

    public void setCallEndTime(long j10) {
        this.f28630r = j10;
    }

    public void setCallStartTime(long j10) {
        this.f28613a = j10;
    }

    public void setConnectEndTime(long j10) {
        this.f28619g = j10;
    }

    public void setConnectStartTime(long j10) {
        this.f28616d = j10;
    }

    public void setConnectionAcquiredTime(long j10) {
        this.f28620h = j10;
    }

    public void setConnectionReleasedTime(long j10) {
        this.f28621i = j10;
    }

    public void setDnsEndTime(long j10) {
        this.f28615c = j10;
    }

    public void setDnsStartTime(long j10) {
        this.f28614b = j10;
    }

    public void setRequestBodyEndTime(long j10) {
        this.f28625m = j10;
    }

    public void setRequestBodyStartTime(long j10) {
        this.f28624l = j10;
    }

    public void setRequestHeadersEndTime(long j10) {
        this.f28623k = j10;
    }

    public void setRequestHeadersStartTime(long j10) {
        this.f28622j = j10;
    }

    public void setResponseBodyEndTime(long j10) {
        this.f28629q = j10;
    }

    public void setResponseBodyStartTime(long j10) {
        this.f28628p = j10;
    }

    public void setResponseHeadersEndTime(long j10) {
        this.f28627o = j10;
    }

    public void setResponseHeadersStartTime(long j10) {
        this.f28626n = j10;
    }

    public void setSecureConnectEndTime(long j10) {
        this.f28618f = j10;
    }

    public void setSecureConnectStartTime(long j10) {
        this.f28617e = j10;
    }
}
