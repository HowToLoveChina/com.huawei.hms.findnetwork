package com.huawei.hms.network.netdiag.cache;

import android.os.SystemClock;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.LimitQueue;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.embedded.AbstractC6072r4;
import com.huawei.hms.network.embedded.C5904e5;
import com.huawei.hms.network.netdiag.info.SignalInfoMetrics;
import java.util.LinkedHashSet;

/* loaded from: classes8.dex */
public class SignalInfoCache extends AbstractC6072r4<SignalInfoMetrics, Long> {

    /* renamed from: c */
    public static final String f29543c = "SignalInfoCache";

    /* renamed from: d */
    public static volatile SignalInfoCache f29544d = new SignalInfoCache();

    /* renamed from: a */
    public LimitQueue<SignalInfoMetrics> f29545a = new LimitQueue<>(8);

    /* renamed from: b */
    public SignalInfoMetrics f29546b;

    public static SignalInfoCache getInstance() {
        return f29544d;
    }

    public SignalInfoMetrics getLastInfo() {
        SignalInfoMetrics signalInfoMetrics = this.f29546b;
        return signalInfoMetrics != null ? signalInfoMetrics : new C5904e5();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public SignalInfoMetrics getPeekLastInfo() {
        SignalInfoMetrics signalInfoMetricsPeekLast = this.f29545a.peekLast();
        if (signalInfoMetricsPeekLast != null) {
            return signalInfoMetricsPeekLast;
        }
        Logger.m32143v(f29543c, "the networkInfoMetrics is null,and return new object");
        return new C5904e5();
    }

    public C5904e5 getSignalInfo(long j10) {
        C5904e5 c5904e5 = new C5904e5();
        c5904e5.m34119a(NetworkUtil.getWifiRssi(ContextHolder.getResourceContext()));
        c5904e5.m34120a(j10);
        Logger.m32143v(f29543c, c5904e5);
        return c5904e5;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public int obtainNetworkQuality(long j10, long j11) {
        if (this.f29545a.size() <= 1) {
            return 0;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (int i10 = 0; i10 < this.f29545a.size(); i10++) {
            SignalInfoMetrics signalInfoMetrics = this.f29545a.get(i10);
            if (signalInfoMetrics != null && j10 <= signalInfoMetrics.getSignalTimeStamp() && signalInfoMetrics.getSignalTimeStamp() <= j11) {
                linkedHashSet.add(Integer.valueOf(signalInfoMetrics.getMobileSignalStrength()));
                linkedHashSet2.add(Integer.valueOf(signalInfoMetrics.getMobileSignalStrength()));
            }
        }
        return (linkedHashSet.size() <= 1 && linkedHashSet2.size() <= 1) ? 0 : 3;
    }

    public SignalInfoMetrics peekLastInfo() {
        SignalInfoMetrics signalInfoMetricsPeekLast = this.f29545a.peekLast();
        if (signalInfoMetricsPeekLast != null) {
            return signalInfoMetricsPeekLast;
        }
        Logger.m32143v(f29543c, "the networkInfoMetrics is null,and return new object");
        C5904e5 c5904e5 = new C5904e5();
        c5904e5.m34119a(NetworkUtil.getWifiRssi(ContextHolder.getResourceContext()));
        return c5904e5;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6072r4
    public void updateCacheInfo(Long l10) {
        SignalInfoMetrics signalInfoMetricsPeekLast = this.f29545a.peekLast();
        this.f29546b = getSignalInfo(SystemClock.elapsedRealtime());
        if (signalInfoMetricsPeekLast == null || Math.abs(signalInfoMetricsPeekLast.getWifiSignalStrength() - this.f29546b.getWifiSignalStrength()) > 15 || Math.abs(signalInfoMetricsPeekLast.getMobileSignalStrength() - this.f29546b.getMobileSignalStrength()) > 15) {
            this.f29545a.add(this.f29546b);
            return;
        }
        Logger.m32143v(f29543c, "the signal not meet interval!" + this.f29546b.getMobileSignalStrength() + "/" + this.f29546b.getWifiSignalStrength());
    }
}
