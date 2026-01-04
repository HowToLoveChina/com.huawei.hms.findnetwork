package com.huawei.hianalytics.p101v2;

import android.content.Context;
import com.huawei.hianalytics.C4787j1;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import java.util.LinkedHashMap;

@Deprecated
/* loaded from: classes5.dex */
public abstract class HiAnalytics {
    public static HiAnalyticsInstance defaultInstance;

    public static void clearCachedData() {
        HiAnalyticsManager.clearCachedData();
    }

    public static synchronized HiAnalyticsInstance getDefaultInstance() {
        try {
            if (defaultInstance == null) {
                defaultInstance = HiAnalyticsManager.getInstanceByTag("_default_config_tag");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return defaultInstance;
    }

    public static boolean getInitFlag() {
        return HiAnalyticsManager.getInitFlag("_default_config_tag");
    }

    public static void newInstanceUUID() {
        if (getDefaultInstance() != null) {
            defaultInstance.newInstanceUUID();
        }
    }

    public static void onBackground(long j10) {
        if (getDefaultInstance() != null) {
            defaultInstance.onBackground(j10);
        }
    }

    public static void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onEvent(i10, str, linkedHashMap);
    }

    public static void onForeground(long j10) {
        if (getDefaultInstance() != null) {
            defaultInstance.onForeground(j10);
        }
    }

    public static void onPause(Context context) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onPause(context);
    }

    public static void onReport() {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onReport(0);
        defaultInstance.onReport(1);
    }

    public static void onResume(Context context) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onResume(context);
    }

    public static void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onStreamEvent(i10, str, linkedHashMap);
    }

    public static void setIsOaidTracking(boolean z10) {
        if (getDefaultInstance() != null) {
            defaultInstance.setOAIDTrackingFlag(1, z10);
            defaultInstance.setOAIDTrackingFlag(0, z10);
        }
    }

    public static void setOAID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.setOAID(1, str);
            defaultInstance.setOAID(0, str);
        }
    }

    public static void setUPID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.setUpid(1, str);
            defaultInstance.setUpid(0, str);
        }
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onEvent(context, str, str2);
    }

    public static void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onPause(context, linkedHashMap);
    }

    @Deprecated
    public static void onReport(Context context) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onReport(context, 0);
        defaultInstance.onReport(context, 1);
    }

    public static void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onResume(context, linkedHashMap);
    }

    public static void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onEvent(0, str, linkedHashMap);
    }

    public static void onPause(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onPause(str, linkedHashMap);
    }

    public static void onResume(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() == null || !C4787j1.f21836a.m28952a()) {
            return;
        }
        defaultInstance.onResume(str, linkedHashMap);
    }
}
