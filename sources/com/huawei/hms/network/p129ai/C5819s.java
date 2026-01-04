package com.huawei.hms.network.p129ai;

import android.os.SystemClock;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.hianalytics.EditableMetrics;
import com.huawei.hms.network.inner.api.RequestContext;
import com.huawei.hms.network.netdiag.cache.SignalInfoCache;
import com.huawei.hms.network.netdiag.info.SignalInfoMetrics;
import com.huawei.hms.network.netdiag.tools.NetDetectAndPolicy;

/* renamed from: com.huawei.hms.network.ai.s */
/* loaded from: classes8.dex */
public class C5819s implements InterfaceC5802i {

    /* renamed from: i */
    public static final String f26035i = "ConnectTimeoutModel";

    /* renamed from: j */
    public static final long f26036j = 30000;

    /* renamed from: k */
    public static final long f26037k = 60000;

    /* renamed from: l */
    public static final int f26038l = 3;

    /* renamed from: a */
    public long f26039a;

    /* renamed from: b */
    public long f26040b;

    /* renamed from: c */
    public int f26041c;

    /* renamed from: f */
    public C5820t f26044f;

    /* renamed from: d */
    public boolean f26042d = false;

    /* renamed from: e */
    public boolean f26043e = false;

    /* renamed from: g */
    public int f26045g = 0;

    /* renamed from: h */
    public long f26046h = 0;

    /* renamed from: com.huawei.hms.network.ai.s$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5819s c5819s = C5819s.this;
            c5819s.f26042d = c5819s.f26044f.m33523g();
            if (C5819s.this.f26042d) {
                C5819s.this.f26044f.mo33245b();
                C5819s.this.f26044f.mo33237a();
                C5819s.this.f26044f.m33522f();
                C5819s.this.f26044f.m33524h();
            }
        }
    }

    /* renamed from: com.huawei.hms.network.ai.s$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ RequestContext f26048a;

        public b(RequestContext requestContext) {
            this.f26048a = requestContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5819s.this.m33503b(this.f26048a);
        }
    }

    public C5819s(C5820t c5820t) {
        this.f26044f = c5820t;
    }

    /* renamed from: a */
    private long m33497a(long j10, long j11) {
        if (j11 == 0 || j10 == 0) {
            return 0L;
        }
        return j10 - j11;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: c */
    public void mo33284c() {
    }

    /* renamed from: d */
    public int m33504d() {
        if (SystemClock.elapsedRealtime() >= this.f26046h) {
            return this.f26044f.m33521e();
        }
        Logger.m32141i(f26035i, "getAiConnectTimeout fail, model is locked");
        return -1;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33279a() {
        C5794e.m33310a().m33312b(new a());
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: b */
    public void mo33283b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m33503b(RequestContext requestContext) {
        Logger.m32141i(f26035i, "saveNetworkCache");
        EditableMetrics metrics = requestContext.requestFinishedInfo().getMetrics();
        RequestFinishedInfo.MetricsTime metricsRealTime = requestContext.requestFinishedInfo().getMetricsRealTime();
        long jM33497a = m33497a(metricsRealTime.getConnectEndTime(), metricsRealTime.getConnectStartTime());
        long callStartTime = this.f26039a - (this.f26040b - metricsRealTime.getCallStartTime());
        long ttfb = metricsRealTime.getTtfb();
        if (metricsRealTime.getCallStartTime() == 0) {
            Logger.m32145w(f26035i, "saveNetworkCache meet startTime error");
            return;
        }
        if (jM33497a == 0) {
            Logger.m32145w(f26035i, "saveNetworkCache meet link reuse");
            return;
        }
        if (jM33497a > 60000) {
            Logger.m32145w(f26035i, "connect_time is larger than 60s");
            return;
        }
        C5822v c5822v = new C5822v();
        c5822v.m33531a(metrics.getProtocol());
        c5822v.m33529a(this.f26041c);
        c5822v.m33534b(callStartTime);
        c5822v.m33530a(jM33497a);
        c5822v.m33543f(NetDetectAndPolicy.obtainNetworkChanged(metricsRealTime.getCallStartTime(), this.f26040b));
        c5822v.m33545g(NetworkUtil.getNetworkType(ContextHolder.getAppContext()));
        SignalInfoMetrics signalInfoMetricsPeekLastInfo = SignalInfoCache.getInstance().peekLastInfo();
        c5822v.m33533b(signalInfoMetricsPeekLastInfo.getLteRsrq());
        c5822v.m33539d(signalInfoMetricsPeekLastInfo.getLteRssnr());
        c5822v.m33536c(signalInfoMetricsPeekLastInfo.getLteRssi());
        c5822v.m33547h(signalInfoMetricsPeekLastInfo.getWifiSignalStrength());
        c5822v.m33541e(signalInfoMetricsPeekLastInfo.getMobileSignalStrength());
        c5822v.m33537c(ttfb);
        this.f26044f.m33520a(c5822v);
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33281a(C5808l c5808l) {
        if (this.f26042d) {
            this.f26043e = true;
            this.f26041c = NetworkUtil.getCurrentNetworkType();
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33282a(RequestContext requestContext) {
        if (m33499a(requestContext.getConnectTimeout())) {
            if (requestContext.throwable() != null) {
                int i10 = this.f26045g + 1;
                this.f26045g = i10;
                if (i10 >= 3) {
                    Logger.m32141i(f26035i, "failed many tims, model will locked for 30s");
                    this.f26046h = SystemClock.elapsedRealtime() + 30000;
                    this.f26045g = 0;
                }
            } else {
                this.f26045g = 0;
            }
        }
        if (!this.f26043e) {
            Logger.m32141i(f26035i, "predictor has not finish init when requestStart");
        } else if (this.f26042d) {
            this.f26040b = SystemClock.elapsedRealtime();
            this.f26039a = System.currentTimeMillis();
            C5794e.m33310a().m33311a(new b(requestContext));
        }
    }

    /* renamed from: a */
    private boolean m33499a(int i10) {
        return i10 == 2000 || i10 == 4000;
    }
}
