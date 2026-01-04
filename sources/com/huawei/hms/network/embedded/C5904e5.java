package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.netdiag.info.SignalInfoMetrics;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.e5 */
/* loaded from: classes8.dex */
public class C5904e5 implements SignalInfoMetrics {

    /* renamed from: a */
    public int f26686a;

    /* renamed from: b */
    public Map<String, Integer> f26687b = NetworkUtil.getLteSignalInfo(ContextHolder.getResourceContext());

    /* renamed from: c */
    public long f26688c;

    /* renamed from: a */
    private int m34118a(String str) {
        Map<String, Integer> map = this.f26687b;
        if (map == null || map.get(str) == null) {
            return Integer.MAX_VALUE;
        }
        return this.f26687b.get(str).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public int getLteCqi() {
        return m34118a(NetworkUtil.SignalType.LTE_CQI);
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public int getLteRsrp() {
        return m34118a(NetworkUtil.SignalType.LTE_RSRP);
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public int getLteRsrq() {
        return m34118a(NetworkUtil.SignalType.LTE_RSRQ);
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public int getLteRssi() {
        return m34118a(NetworkUtil.SignalType.LTE_RSSI);
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public int getLteRssnr() {
        return m34118a(NetworkUtil.SignalType.LTE_RSSNR);
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public int getMobileSignalStrength() {
        return m34118a(NetworkUtil.SignalType.LTE_DBM);
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public long getSignalTimeStamp() {
        return this.f26688c;
    }

    @Override // com.huawei.hms.network.netdiag.info.SignalInfoMetrics
    public int getWifiSignalStrength() {
        return this.f26686a;
    }

    public String toString() {
        return "SignalInfoImpl{wifiSignalStrength=" + getWifiSignalStrength() + ", signalTimeStamp=" + getSignalTimeStamp() + ", MobileSignalStrength=" + getMobileSignalStrength() + ", LteRsrq=" + getLteRsrq() + ", LteRssi=" + getLteRssi() + ", LteRssnr=" + getLteRssnr() + ", LteRsrp=" + getLteRsrp() + ", LteCqi=" + getLteCqi() + '}';
    }

    /* renamed from: a */
    public void m34119a(int i10) {
        this.f26686a = i10;
    }

    /* renamed from: a */
    public void m34120a(long j10) {
        this.f26688c = j10;
    }
}
