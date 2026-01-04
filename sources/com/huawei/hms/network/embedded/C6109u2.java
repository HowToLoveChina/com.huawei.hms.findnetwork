package com.huawei.hms.network.embedded;

import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.u2 */
/* loaded from: classes8.dex */
public class C6109u2 extends RequestFinishedInfo.Metrics {

    /* renamed from: a */
    public final List<String> f28465a = new ArrayList();

    /* renamed from: b */
    public String f28466b = "";

    /* renamed from: c */
    public String f28467c = "unknown";

    /* renamed from: d */
    public int f28468d = -1;

    /* renamed from: e */
    public long f28469e = -1;

    /* renamed from: f */
    public long f28470f = -1;

    /* renamed from: g */
    public String f28471g = "Reuse";

    /* renamed from: h */
    public long f28472h = -1;

    /* renamed from: i */
    public int f28473i = -1;

    /* renamed from: j */
    public String f28474j = "unknown";

    /* renamed from: k */
    public String f28475k = "unknown";

    /* renamed from: l */
    public String f28476l = "unknown";

    /* renamed from: m */
    public int f28477m = 0;

    /* renamed from: n */
    public int f28478n = -1;

    public void addConnectIps(String str) {
        this.f28465a.add(str);
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public String getCipherSuite() {
        return this.f28475k;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public String getCongestionControlType() {
        return this.f28476l;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public List<String> getConnectIps() {
        return this.f28465a;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public int getConnectRetryTime() {
        return this.f28468d;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public int getDnsCache() {
        return this.f28478n;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public int getDnsStatus() {
        return this.f28473i;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public long getDnsTtl() {
        return this.f28472h;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public String getDnsType() {
        return this.f28471g;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public int getMultipathAlgorithm() {
        return this.f28477m;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public String getProtocol() {
        return this.f28467c;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public long getRequestByteCount() {
        return this.f28469e;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public long getResponseByteCount() {
        return this.f28470f;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public String getSuccessIp() {
        return this.f28466b;
    }

    @Override // com.huawei.hms.network.httpclient.RequestFinishedInfo.Metrics
    public String getTlsVersion() {
        return this.f28474j;
    }

    public void setCipherSuite(String str) {
        this.f28475k = str;
    }

    public void setCongestionControlType(String str) {
        this.f28476l = str;
    }

    public void setConnectIps(List<String> list) {
        this.f28465a.addAll(list);
    }

    public void setConnectRetryTime(int i10) {
        this.f28468d = i10;
    }

    public void setDnsCache(int i10) {
        this.f28478n = i10;
    }

    public void setDnsStatus(int i10) {
        this.f28473i = i10;
    }

    public void setDnsTtl(long j10) {
        this.f28472h = j10;
    }

    public void setDnsType(String str) {
        this.f28471g = str;
    }

    public void setMultipathAlgorithm(int i10) {
        this.f28477m = i10;
    }

    public void setProtocol(String str) {
        this.f28467c = str;
    }

    public void setRequestByteCount(long j10) {
        this.f28469e = j10;
    }

    public void setResponseByteCount(long j10) {
        this.f28470f = j10;
    }

    public void setSuccessIp(String str) {
        this.f28466b = str;
    }

    public void setTlsVersion(String str) {
        this.f28474j = str;
    }
}
