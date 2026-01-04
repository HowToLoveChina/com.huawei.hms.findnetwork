package com.huawei.hms.network.embedded;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.embedded.AbstractC5932g7;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.inner.api.DnsNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.huawei.hms.network.embedded.g3 */
/* loaded from: classes8.dex */
public class C5928g3 extends AbstractC5932g7 {

    /* renamed from: h */
    public static final String f26831h = "HttpEventListener";

    /* renamed from: i */
    public static final AtomicLong f26832i = new AtomicLong(1);

    /* renamed from: j */
    public static final a f26833j = new a();

    /* renamed from: a */
    public final long f26834a;

    /* renamed from: b */
    public final C5993l3 f26835b;

    /* renamed from: c */
    public final DnsNetworkService f26836c;

    /* renamed from: d */
    public long f26837d;

    /* renamed from: e */
    public int f26838e = 0;

    /* renamed from: f */
    public C5902e3 f26839f;

    /* renamed from: g */
    public AbstractC6174z2 f26840g;

    /* renamed from: com.huawei.hms.network.embedded.g3$a */
    public static class a implements AbstractC5932g7.b {
        public WeakHashMap<InterfaceC6100t6, WeakReference<C5928g3>> events = new WeakHashMap<>();
        public final Object lock = new Object();

        @Override // com.huawei.hms.network.embedded.AbstractC5932g7.b
        public C5928g3 create(InterfaceC6100t6 interfaceC6100t6) {
            C5928g3 c5928g3 = new C5928g3();
            synchronized (this.lock) {
                this.events.put(interfaceC6100t6, new WeakReference<>(c5928g3));
            }
            return c5928g3;
        }

        public C5928g3 getListener(InterfaceC6100t6 interfaceC6100t6) {
            WeakReference<C5928g3> weakReference;
            synchronized (this.lock) {
                weakReference = this.events.get(interfaceC6100t6);
            }
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
    }

    public C5928g3() {
        NetworkService service = NetworkKitInnerImpl.getInstance().getService("dns");
        if (!(service instanceof DnsNetworkService)) {
            throw new IllegalStateException("DNS service not available");
        }
        this.f26836c = (DnsNetworkService) service;
        this.f26834a = f26832i.getAndIncrement();
        this.f26835b = new C5993l3();
    }

    /* renamed from: a */
    private void m34295a(C6127v7 c6127v7) {
        String strM35582b = c6127v7.m35582b(C5966j2.f27081w);
        Logger.m32143v(f26831h, "content-length : " + strM35582b);
        this.f26835b.getMetrics().setResponseByteCount(StringUtils.stringToLong(strM35582b, -1L));
    }

    public static a getFactory() {
        return f26833j;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void callEnd(InterfaceC6100t6 interfaceC6100t6) {
        super.callEnd(interfaceC6100t6);
        this.f26835b.getMetricsRealTime().setCallEndTime();
        this.f26835b.getMetricsTime().setCallEndTime();
        m34296a("callEnd", this.f26835b.getMetricsRealTime().getCallEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void callFailed(InterfaceC6100t6 interfaceC6100t6, IOException iOException) {
        super.callFailed(interfaceC6100t6, iOException);
        this.f26835b.setException(iOException);
        this.f26835b.getMetricsRealTime().setCallEndTime();
        this.f26835b.getMetricsTime().setCallEndTime();
        this.f26835b.getMetrics().setDnsType(this.f26836c.getDnsType());
        this.f26835b.getMetrics().setDnsCache(this.f26836c.getDnsCache());
        m34296a("callFailed", this.f26835b.getMetricsRealTime().getCallEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void callStart(InterfaceC6100t6 interfaceC6100t6) {
        super.callStart(interfaceC6100t6);
        this.f26835b.getMetricsRealTime().setCallStartTime();
        this.f26835b.getMetricsTime().setCallStartTime();
        this.f26835b.setUrl(interfaceC6100t6.request().m35423k().toString());
        this.f26837d = SystemClock.elapsedRealtime();
        m34296a("callStart", this.f26835b.getMetricsRealTime().getCallStartTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void connectEnd(InterfaceC6100t6 interfaceC6100t6, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC6075r7 enumC6075r7) {
        super.connectEnd(interfaceC6100t6, inetSocketAddress, proxy, enumC6075r7);
        if (enumC6075r7 != null) {
            this.f26835b.getMetrics().setProtocol(enumC6075r7.toString());
        }
        m34297a(inetSocketAddress, true);
        this.f26835b.getMetricsRealTime().setConnectEndTime();
        this.f26835b.getMetricsTime().setConnectEndTime();
        m34296a("connectEnd", this.f26835b.getMetricsRealTime().getConnectEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void connectFailed(InterfaceC6100t6 interfaceC6100t6, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC6075r7 enumC6075r7, IOException iOException) {
        super.connectFailed(interfaceC6100t6, inetSocketAddress, proxy, enumC6075r7, iOException);
        if (enumC6075r7 != null) {
            this.f26835b.getMetrics().setProtocol(enumC6075r7.toString());
        }
        this.f26835b.getMetricsRealTime().setConnectEndTime();
        this.f26835b.getMetricsTime().setConnectEndTime();
        m34296a("connectFailed", this.f26835b.getMetricsRealTime().getConnectEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void connectStart(InterfaceC6100t6 interfaceC6100t6, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(interfaceC6100t6, inetSocketAddress, proxy);
        C6109u2 metrics = this.f26835b.getMetrics();
        int i10 = this.f26838e;
        this.f26838e = i10 + 1;
        metrics.setConnectRetryTime(i10);
        m34297a(inetSocketAddress, false);
        if (this.f26835b.getMetricsRealTime().getConnectStartTime() == 0) {
            this.f26835b.getMetricsRealTime().setConnectStartTime();
            this.f26835b.getMetricsTime().setConnectStartTime();
        }
        m34296a("connectStart", this.f26835b.getMetricsRealTime().getConnectStartTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void connectionAcquired(InterfaceC6100t6 interfaceC6100t6, InterfaceC6165y6 interfaceC6165y6) {
        String strM35842a;
        String strM35786a;
        super.connectionAcquired(interfaceC6100t6, interfaceC6165y6);
        C6167y8 c6167y8 = (C6167y8) interfaceC6165y6;
        this.f26835b.getMetricsRealTime().setConnectionAcquiredTime();
        this.f26835b.getMetricsTime().setConnectionAcquiredTime();
        m34296a("connectionAcquired, connection id = " + interfaceC6165y6.hashCode(), this.f26835b.getMetricsRealTime().getConnectionAcquiredTime());
        if (c6167y8 == null) {
            return;
        }
        this.f26839f = new C5902e3(this.f26835b.getHost(), c6167y8);
        C6153x7 c6153x7Mo35837b = c6167y8.mo35837b();
        EnumC6075r7 enumC6075r7Mo35839d = c6167y8.mo35839d();
        if (c6167y8.mo35836a() != null) {
            strM35842a = c6167y8.mo35836a().m34393f().m35842a();
            strM35786a = c6167y8.mo35836a().m34388a().m35786a();
        } else {
            strM35842a = null;
            strM35786a = null;
        }
        if (strM35842a != null) {
            this.f26835b.getMetrics().setTlsVersion(strM35842a);
        }
        if (strM35786a != null) {
            this.f26835b.getMetrics().setCipherSuite(strM35786a);
        }
        if (enumC6075r7Mo35839d != null) {
            this.f26835b.getMetrics().setProtocol(enumC6075r7Mo35839d.toString());
        }
        m34297a(c6153x7Mo35837b.m35790d(), true);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void connectionReleased(InterfaceC6100t6 interfaceC6100t6, InterfaceC6165y6 interfaceC6165y6) {
        super.connectionReleased(interfaceC6100t6, interfaceC6165y6);
        this.f26835b.getMetricsRealTime().setConnectionReleasedTime();
        this.f26835b.getMetricsTime().setConnectionReleasedTime();
        m34296a("connectionReleased", this.f26835b.getMetricsRealTime().getConnectionReleasedTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void dnsEnd(InterfaceC6100t6 interfaceC6100t6, String str, List<InetAddress> list) {
        super.dnsEnd(interfaceC6100t6, str, list);
        this.f26835b.getMetricsRealTime().setDnsEndTime();
        this.f26835b.getMetricsTime().setDnsEndTime();
        this.f26835b.getMetrics().setDnsCache(this.f26836c.getDnsCache());
        this.f26835b.getMetrics().setDnsType(this.f26836c.getDnsType());
        this.f26835b.getMetrics().setDnsTtl(this.f26836c.getDnsTtl());
        this.f26835b.getMetrics().setDnsStatus(this.f26836c.getDnsStatus());
        m34296a("dnsEnd", this.f26835b.getMetricsRealTime().getDnsEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void dnsStart(InterfaceC6100t6 interfaceC6100t6, String str) {
        super.dnsStart(interfaceC6100t6, str);
        this.f26835b.getMetricsRealTime().setDnsStartTime();
        this.f26835b.getMetricsTime().setDnsStartTime();
        m34296a("dnsStart", this.f26835b.getMetricsRealTime().getDnsStartTime());
    }

    public C5902e3 getConnectionInfo() {
        return this.f26839f;
    }

    public RequestFinishedInfo getRequestFinishedInfo() {
        return this.f26835b;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void requestBodyEnd(InterfaceC6100t6 interfaceC6100t6, long j10) {
        super.requestBodyEnd(interfaceC6100t6, j10);
        this.f26835b.getMetrics().setRequestByteCount(j10);
        this.f26835b.getMetricsRealTime().setRequestBodyEndTime();
        this.f26835b.getMetricsTime().setRequestBodyEndTime();
        m34296a("requestBodyEnd", this.f26835b.getMetricsRealTime().getRequestBodyEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void requestBodyStart(InterfaceC6100t6 interfaceC6100t6) {
        super.requestBodyStart(interfaceC6100t6);
        this.f26835b.getMetricsRealTime().setRequestBodyStartTime();
        this.f26835b.getMetricsTime().setRequestBodyStartTime();
        m34296a("requestBodyStart", this.f26835b.getMetricsRealTime().getRequestBodyStartTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void requestHeadersEnd(InterfaceC6100t6 interfaceC6100t6, C6101t7 c6101t7) {
        super.requestHeadersEnd(interfaceC6100t6, c6101t7);
        this.f26835b.getMetricsRealTime().setRequestHeadersEndTime();
        this.f26835b.getMetricsTime().setRequestHeadersEndTime();
        m34296a("requestHeadersEnd", this.f26835b.getMetricsRealTime().getRequestHeadersEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void requestHeadersStart(InterfaceC6100t6 interfaceC6100t6) {
        super.requestHeadersStart(interfaceC6100t6);
        this.f26835b.getMetricsRealTime().setRequestHeadersStartTime();
        this.f26835b.getMetricsTime().setRequestHeadersStartTime();
        m34296a("requestHeadersStart", this.f26835b.getMetricsRealTime().getRequestHeadersStartTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void responseBodyEnd(InterfaceC6100t6 interfaceC6100t6, long j10) {
        super.responseBodyEnd(interfaceC6100t6, j10);
        this.f26835b.getMetricsRealTime().setResponseBodyEndTime();
        this.f26835b.getMetricsTime().setResponseBodyEndTime();
        m34296a("responseBodyEnd", this.f26835b.getMetricsRealTime().getResponseBodyEndTime());
        AbstractC6174z2 abstractC6174z2 = this.f26840g;
        if (abstractC6174z2 != null) {
            abstractC6174z2.responseBodyEnd();
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void responseBodyStart(InterfaceC6100t6 interfaceC6100t6) {
        super.responseBodyStart(interfaceC6100t6);
        this.f26835b.getMetricsRealTime().setResponseBodyStartTime();
        this.f26835b.getMetricsTime().setResponseBodyStartTime();
        m34296a("responseBodyStart", this.f26835b.getMetricsRealTime().getResponseBodyStartTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void responseFailed(InterfaceC6100t6 interfaceC6100t6, IOException iOException) {
        super.responseFailed(interfaceC6100t6, iOException);
        this.f26835b.getMetricsRealTime().setResponseBodyEndTime();
        this.f26835b.getMetricsTime().setResponseBodyEndTime();
        m34296a("responseFailed", this.f26835b.getMetricsRealTime().getResponseBodyEndTime());
        AbstractC6174z2 abstractC6174z2 = this.f26840g;
        if (abstractC6174z2 != null) {
            abstractC6174z2.responseFailed();
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void responseHeadersEnd(InterfaceC6100t6 interfaceC6100t6, C6127v7 c6127v7) {
        super.responseHeadersEnd(interfaceC6100t6, c6127v7);
        this.f26835b.getMetricsRealTime().setResponseHeadersEndTime();
        this.f26835b.getMetricsTime().setResponseHeadersEndTime();
        this.f26835b.getMetricsRealTime().setTtfbV1(this.f26835b.getMetricsRealTime().getResponseHeadersEndTime());
        this.f26835b.getMetricsTime().setTtfbV1(this.f26835b.getMetricsTime().getResponseHeadersEndTime());
        m34295a(c6127v7);
        m34296a("responseHeadersEnd", this.f26835b.getMetricsRealTime().getResponseHeadersEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void responseHeadersStart(InterfaceC6100t6 interfaceC6100t6) {
        super.responseHeadersStart(interfaceC6100t6);
        this.f26835b.getMetricsRealTime().setResponseHeadersStartTime();
        this.f26835b.getMetricsTime().setResponseHeadersStartTime();
        this.f26835b.getMetricsRealTime().setTtfb(this.f26835b.getMetricsRealTime().getResponseHeadersStartTime());
        this.f26835b.getMetricsTime().setTtfb(this.f26835b.getMetricsTime().getResponseHeadersStartTime());
        m34296a("responseHeadersStart", this.f26835b.getMetricsRealTime().getResponseHeadersStartTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void secureConnectEnd(InterfaceC6100t6 interfaceC6100t6, C5958i7 c5958i7) {
        super.secureConnectEnd(interfaceC6100t6, c5958i7);
        this.f26835b.getMetricsRealTime().setSecureConnectEndTime();
        this.f26835b.getMetricsTime().setSecureConnectEndTime();
        m34296a("secureConnectEnd", this.f26835b.getMetricsRealTime().getSecureConnectEndTime());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5932g7
    public void secureConnectStart(InterfaceC6100t6 interfaceC6100t6) {
        super.secureConnectStart(interfaceC6100t6);
        this.f26835b.getMetricsRealTime().setSecureConnectStartTime();
        this.f26835b.getMetricsTime().setSecureConnectStartTime();
        m34296a("secureConnectStart", this.f26835b.getMetricsRealTime().getSecureConnectStartTime());
    }

    public void setRCEventListener(AbstractC6174z2 abstractC6174z2) {
        this.f26840g = abstractC6174z2;
    }

    /* renamed from: a */
    private void m34296a(String str, long j10) {
        Logger.m32144v(f26831h, "callId = %d / %s : ElapsedTime = %d", Long.valueOf(this.f26834a), str, Long.valueOf(j10 - this.f26837d));
    }

    /* renamed from: a */
    private void m34297a(InetSocketAddress inetSocketAddress, boolean z10) {
        InetAddress address;
        if (inetSocketAddress == null || (address = inetSocketAddress.getAddress()) == null) {
            return;
        }
        C6109u2 metrics = this.f26835b.getMetrics();
        String hostAddress = address.getHostAddress();
        if (z10) {
            metrics.setSuccessIp(hostAddress);
        } else {
            metrics.addConnectIps(hostAddress);
        }
    }
}
