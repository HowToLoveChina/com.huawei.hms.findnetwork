package com.huawei.fastsdk;

import android.content.Context;
import android.util.Log;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import java.util.LinkedHashMap;

/* loaded from: classes5.dex */
public class HASDKManager {
    private static final int CONFIG_TYPE_MAIN = 1;
    public static final String SERVICE_TAG = "quickCard";
    private static final String TAG = "HASDKManager";
    private static volatile boolean allowLog = false;
    private static volatile boolean hasSDKInit;
    private static volatile boolean isSDKInitSuccess;

    private static void initSDK(Context context) {
        if (context == null) {
            hasSDKInit = true;
            isSDKInitSuccess = false;
            if (isAllowLog()) {
                Log.e(TAG, "init HA SDK failed ctx is null");
                return;
            }
            return;
        }
        try {
            new HiAnalyticsInstance.Builder(context).setMaintConf(new HiAnalyticsConfig.Builder().build()).create(SERVICE_TAG);
            hasSDKInit = true;
            isSDKInitSuccess = true;
        } catch (NoClassDefFoundError unused) {
            hasSDKInit = true;
            isSDKInitSuccess = false;
            if (isAllowLog()) {
                Log.e(TAG, "HA SDK not found");
            }
        }
    }

    private static boolean isAllowLog() {
        return allowLog;
    }

    public static void onEvent(Context context, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!hasSDKInit) {
            initSDK(context);
        }
        if (!hasSDKInit || !isSDKInitSuccess) {
            if (isAllowLog()) {
                Log.d(TAG, "onEvent: sdk init fail");
                return;
            }
            return;
        }
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag(SERVICE_TAG);
        if (instanceByTag == null) {
            if (isAllowLog()) {
                Log.i(TAG, "onEvent: instance is empty");
                return;
            }
            return;
        }
        instanceByTag.onEvent(1, str, linkedHashMap);
        if (isAllowLog()) {
            Log.i(TAG, "eventId: " + str + " mapValue:" + linkedHashMap);
        }
    }

    public static void setAllowLog(boolean z10) {
        allowLog = z10;
    }
}
