package com.huawei.fastengine.fastview.download.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public final class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        boolean zIsAvailable = false;
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            connectivityManager = (ConnectivityManager) systemService;
        } else {
            FastViewLogUtils.m28724e("isNetworkAvailable", "ConnectivityManager get failed");
            connectivityManager = null;
        }
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                zIsAvailable = activeNetworkInfo.isAvailable();
            } else {
                FastViewLogUtils.m28726i(TAG, "Network NotAvailable");
            }
        }
        FastViewLogUtils.m28726i(TAG, "Network IsAvailable: " + zIsAvailable);
        return zIsAvailable;
    }
}
