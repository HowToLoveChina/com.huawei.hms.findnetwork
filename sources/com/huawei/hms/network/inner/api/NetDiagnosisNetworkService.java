package com.huawei.hms.network.inner.api;

import com.huawei.hms.network.netdiag.qoe.QoeMetrics;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class NetDiagnosisNetworkService extends InterceptorNetworkService {
    public abstract boolean checkConnectivity();

    public abstract String getNetworkMetrics();

    public abstract QoeMetrics getQoeMetrics(boolean z10);

    public abstract Map<String, Integer> getSignalMetrics();

    public abstract Map<String, String> getSyncNetDiagnosisInfo(long j10, long j11, boolean z10, boolean z11);

    public abstract Map<String, String> getWebsocketNetworkData(long j10, long j11);

    public abstract boolean networkUnavailable(long j10, long j11);

    public abstract void requestThirdMetrics(String str);
}
