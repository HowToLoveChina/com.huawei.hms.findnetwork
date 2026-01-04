package com.huawei.hms.network.embedded;

import android.content.Context;
import com.huawei.hms.network.ComposedNetworkKit;
import com.huawei.hms.network.api.advance.AdvanceNetworkKit;
import com.huawei.hms.network.api.advance.BandwidthCallBack;
import com.huawei.hms.network.api.advance.ReportCallBack;
import com.huawei.hms.network.api.advance.WrapperLogger;
import com.huawei.hms.network.netdiag.qoe.QoeMetrics;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.network.embedded.f */
/* loaded from: classes8.dex */
public class C5911f extends AdvanceNetworkKit {

    /* renamed from: a */
    public static final String f26715a = "NetworkKitAdvImpl";

    /* renamed from: b */
    public static final AdvanceNetworkKit f26716b = new C5911f();

    public static AdvanceNetworkKit getInstance() {
        return f26716b;
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void addQuicHint(boolean z10, String... strArr) {
        ComposedNetworkKit.getInstance().addQuicHint(z10, strArr);
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public boolean checkConnectivity() {
        return ComposedNetworkKit.getInstance().checkConnectivity();
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public void doAction(String str) {
        ComposedNetworkKit.getInstance().doAction(str);
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void evictAllConnections() {
        ComposedNetworkKit.getInstance().evictAllConnections();
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public String getNetworkMetrics() {
        return ComposedNetworkKit.getInstance().getNetworkMetrics();
    }

    @Override // com.huawei.hms.network.NetworkKit
    public String getOption(String str) {
        return ComposedNetworkKit.getInstance().getOption("", str);
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public QoeMetrics getQoeMetrics() {
        return ComposedNetworkKit.getInstance().getQoeMetrics();
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public Map<String, Integer> getSignalMetrics() {
        return ComposedNetworkKit.getInstance().getSignalMetrics();
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void initConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        ComposedNetworkKit.getInstance().initConnectionPool(i10, j10, timeUnit);
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void initKit(Context context, String str) throws InterruptedException, TimeoutException, BrokenBarrierException {
        ComposedNetworkKit.getInstance().initKit(context, str);
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public void registerBandwidthCallback(String str, int i10, BandwidthCallBack bandwidthCallBack) {
        if (bandwidthCallBack == null) {
            return;
        }
        ComposedNetworkKit.getInstance().registerBandwidthCallback(str, i10, bandwidthCallBack);
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public void reloadQuic() {
        ComposedNetworkKit.getInstance().reloadQuic();
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public void setLogEnableLevel(int i10) {
        ComposedNetworkKit.getInstance().setLogEnableLevel(i10);
    }

    @Override // com.huawei.hms.network.NetworkKit
    public void setOptions(String str) {
        ComposedNetworkKit.getInstance().setOptions(str);
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public void setReportCallback(ReportCallBack reportCallBack) {
        if (reportCallBack == null) {
            return;
        }
        ComposedNetworkKit.getInstance().setReportCallback(reportCallBack);
    }

    @Override // com.huawei.hms.network.api.advance.AdvanceNetworkKit
    public void setWrapperLogger(WrapperLogger wrapperLogger, boolean z10) {
        ComposedNetworkKit.getInstance().setWrapperLogger(wrapperLogger, z10);
    }
}
