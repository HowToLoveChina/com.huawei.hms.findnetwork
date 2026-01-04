package com.huawei.hms.network.api.advance;

import com.huawei.hms.network.AdvanceNetworkKitProvider;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.netdiag.qoe.QoeMetrics;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class AdvanceNetworkKit extends NetworkKit {
    public static final String ACTION_CLEAN_CONNECTDATA = "network.clean.ConnectData";

    public static AdvanceNetworkKit getInstance() {
        return AdvanceNetworkKitProvider.getEnableProvider().createAdvanceNetworkKit();
    }

    public abstract boolean checkConnectivity();

    public abstract void doAction(String str);

    public abstract String getNetworkMetrics();

    public abstract QoeMetrics getQoeMetrics();

    public abstract Map<String, Integer> getSignalMetrics();

    public abstract void registerBandwidthCallback(String str, int i10, BandwidthCallBack bandwidthCallBack);

    public abstract void reloadQuic();

    public abstract void setLogEnableLevel(int i10);

    public abstract void setReportCallback(ReportCallBack reportCallBack);

    public abstract void setWrapperLogger(WrapperLogger wrapperLogger, boolean z10);
}
