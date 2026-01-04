package com.huawei.hms.network.netdiag.info;

/* loaded from: classes8.dex */
public interface SignalInfoMetrics {
    int getLteCqi();

    int getLteRsrp();

    int getLteRsrq();

    int getLteRssi();

    int getLteRssnr();

    int getMobileSignalStrength();

    long getSignalTimeStamp();

    int getWifiSignalStrength();
}
