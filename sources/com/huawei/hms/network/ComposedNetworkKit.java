package com.huawei.hms.network;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.hms.network.api.advance.AdvanceNetworkKit;
import com.huawei.hms.network.api.advance.BandwidthCallBack;
import com.huawei.hms.network.api.advance.ReportCallBack;
import com.huawei.hms.network.api.advance.WrapperLogger;
import com.huawei.hms.network.embedded.C5844a1;
import com.huawei.hms.network.embedded.C5846a3;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C5991l1;
import com.huawei.hms.network.embedded.C6007m4;
import com.huawei.hms.network.embedded.C6083s2;
import com.huawei.hms.network.embedded.C6110u3;
import com.huawei.hms.network.embedded.C6159y0;
import com.huawei.hms.network.embedded.C6172z0;
import com.huawei.hms.network.httpclient.excutor.PolicyExecutor;
import com.huawei.hms.network.httpclient.okhttp.OkHttpClientGlobal;
import com.huawei.hms.network.inner.api.InterceptorNetworkService;
import com.huawei.hms.network.inner.api.NetDiagnosisNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.netdiag.qoe.QoeMetrics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public class ComposedNetworkKit {

    /* renamed from: c */
    public static final String f25611c = "ComposedNetworkKit";

    /* renamed from: d */
    public static final ComposedNetworkKit f25612d = new ComposedNetworkKit();

    /* renamed from: a */
    public PolicyExecutor f25613a;

    /* renamed from: b */
    public CyclicBarrier f25614b = new CyclicBarrier(2);

    /* renamed from: com.huawei.hms.network.ComposedNetworkKit$a */
    public class C5777a implements HianalyticsHelper.ReportCallBack {

        /* renamed from: a */
        public final /* synthetic */ ReportCallBack f25615a;

        public C5777a(ReportCallBack reportCallBack) {
            this.f25615a = reportCallBack;
        }

        @Override // com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.ReportCallBack
        public void onReport(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
            this.f25615a.onReport(i10, str, linkedHashMap);
        }
    }

    /* renamed from: com.huawei.hms.network.ComposedNetworkKit$b */
    public class RunnableC5778b implements Runnable {

        /* renamed from: a */
        public Context f25617a;

        public RunnableC5778b(Context context) {
            this.f25617a = context;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException, TimeoutException, BrokenBarrierException {
            new C6083s2().init();
            C5846a3.init();
            C6159y0.registerNetworkState(this.f25617a);
            try {
                ComposedNetworkKit.this.f25614b.await(1L, TimeUnit.SECONDS);
            } catch (InterruptedException | BrokenBarrierException | TimeoutException unused) {
                Logger.m32145w(ComposedNetworkKit.f25611c, "cyclicBarrier  await error!");
            }
        }
    }

    /* renamed from: a */
    private Bundle m33219a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(PolicyNetworkService.NetworkServiceConstants.IS_DYNAMIC, ContextHolder.getKitContext() != null);
        return bundle;
    }

    /* renamed from: b */
    private void m33220b() {
        HianalyticsHelper.getInstance().setHaTag(this.f25613a.getString("", "core_ha_tag"));
        HianalyticsHelper.getInstance().enablePrivacyPolicy(this.f25613a.getBoolean("", "core_enable_privacy_policy"));
        HianalyticsHelper.getInstance().setRate(this.f25613a.getInt("", PolicyNetworkService.GlobalConstants.REPORT_RATE));
        HianalyticsHelper.getInstance().setQuicRate(this.f25613a.getInt("", PolicyNetworkService.GlobalConstants.QUIC_REPORT_RATE));
        C5929g4.getInstance().enableAllLinkDelayAnalysis(this.f25613a.getBoolean("", "core_enable_alllink_delay_analysis"));
        C5929g4.getInstance().userSet(!TextUtils.isEmpty(this.f25613a.getUserConfigValue("core_enable_alllink_delay_analysis")));
    }

    public static ComposedNetworkKit getInstance() {
        return f25612d;
    }

    public void addQuicHint(boolean z10, String... strArr) {
        C5927g2.getInstance().addQuicHint(Arrays.asList(strArr), z10);
    }

    public boolean checkConnectivity() {
        InterceptorNetworkService interceptorNetworkService = NetworkKitInnerImpl.getInstance().getInterceptorNetworkService("netdiag");
        if (interceptorNetworkService != null) {
            return ((NetDiagnosisNetworkService) interceptorNetworkService).checkConnectivity();
        }
        Logger.m32145w(f25611c, "the netdiag service is not reachable for connect");
        return false;
    }

    public void clear() {
        Iterator<NetworkService> it = C6007m4.m34758c().m34760a().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public void doAction(String str) {
        if (str == null) {
            Logger.m32138e(f25611c, "invalid actionkey!");
        } else if (str.equals(AdvanceNetworkKit.ACTION_CLEAN_CONNECTDATA)) {
            clear();
            InitReport.disableConnectNet();
        }
    }

    public void evictAllConnections() {
        OkHttpClientGlobal.getInstance().evictAll();
    }

    public String getNetworkMetrics() {
        InterceptorNetworkService interceptorNetworkService = NetworkKitInnerImpl.getInstance().getInterceptorNetworkService("netdiag");
        if (interceptorNetworkService != null) {
            return ((NetDiagnosisNetworkService) interceptorNetworkService).getNetworkMetrics();
        }
        Logger.m32145w(f25611c, "the netdiag service is not reachable for NetworkMetrics");
        return null;
    }

    public String getOption(String str, String str2) {
        PolicyExecutor policyExecutor = this.f25613a;
        return policyExecutor != null ? policyExecutor.getValue(str, str2) : "";
    }

    public QoeMetrics getQoeMetrics() {
        InterceptorNetworkService interceptorNetworkService = NetworkKitInnerImpl.getInstance().getInterceptorNetworkService("netdiag");
        if (interceptorNetworkService != null) {
            return ((NetDiagnosisNetworkService) interceptorNetworkService).getQoeMetrics(false);
        }
        Logger.m32145w(f25611c, "the netdiag service is not reachable for qoe");
        return null;
    }

    public Map<String, Integer> getSignalMetrics() {
        InterceptorNetworkService interceptorNetworkService = NetworkKitInnerImpl.getInstance().getInterceptorNetworkService("netdiag");
        if (interceptorNetworkService != null) {
            return ((NetDiagnosisNetworkService) interceptorNetworkService).getSignalMetrics();
        }
        Logger.m32145w(f25611c, "the netdiag service is not reachable for signal");
        return new HashMap();
    }

    public void initConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        OkHttpClientGlobal.init(i10, j10, timeUnit);
    }

    public void initKit(Context context, String str) throws InterruptedException, TimeoutException, BrokenBarrierException {
        ContextHolder.setAppContext(context);
        ExecutorsUtils.newThread(new RunnableC5778b(context), "ComposedNetworkKit_initKit").start();
        NetworkKitInnerImpl.getInstance().init(context, str, m33219a()).setProtocolStackManager(new C6172z0());
        this.f25613a = new PolicyExecutor();
        NetworkKitInnerImpl.getInstance().setPolicyExecutor(this.f25613a);
        m33220b();
        Boolean boolM34765c = C6007m4.m34758c().m34765c(NetworkService.Constants.REMOTE_SCENE_SWITCH);
        if (boolM34765c != null && boolM34765c.booleanValue()) {
            C6110u3.getInstance().registerSceneChangeListener(context);
        }
        try {
            this.f25614b.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | BrokenBarrierException | TimeoutException unused) {
            Logger.m32145w(f25611c, "cyclicBarrier  await error!");
        }
    }

    public void registerBandwidthCallback(String str, int i10, BandwidthCallBack bandwidthCallBack) {
        C5991l1.getInstance().init(str, i10);
        C5991l1.getInstance().registerBandwidthCallback(bandwidthCallBack);
    }

    public void reloadQuic() {
        C5844a1.reloadQuic();
    }

    public void setLogEnableLevel(int i10) {
        Logger.setLogEnableLevel(i10);
    }

    public void setOptions(String str) {
        if (str == null) {
            Logger.m32145w(f25611c, "setOptions == null");
            return;
        }
        PolicyExecutor policyExecutor = this.f25613a;
        if (policyExecutor != null) {
            policyExecutor.setOptions(str);
            NetworkKitInnerImpl.getInstance().setPolicyExecutor(this.f25613a);
            m33220b();
        }
    }

    public void setReportCallback(ReportCallBack reportCallBack) {
        HianalyticsHelper.getInstance().setReportCallback(new C5777a(reportCallBack));
    }

    public void setWrapperLogger(WrapperLogger wrapperLogger, boolean z10) {
        Logger.setExtLogger(new C5939h1.k(wrapperLogger), z10);
    }
}
