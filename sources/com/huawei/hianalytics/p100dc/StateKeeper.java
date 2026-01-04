package com.huawei.hianalytics.p100dc;

/* loaded from: classes5.dex */
public class StateKeeper {
    public static volatile boolean isInit = false;
    public static volatile boolean isMetricInit = false;

    public static boolean isInit() {
        return isInit;
    }

    public static boolean isMetricInit() {
        return isMetricInit;
    }

    public static void setInit(boolean z10) {
        isInit = z10;
    }

    public static void setMetricInit(boolean z10) {
        isMetricInit = z10;
    }
}
