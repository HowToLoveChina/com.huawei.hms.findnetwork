package com.huawei.hms.findnetwork.comm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.huawei.hms.app.CoreApplication;
import com.huawei.hms.findnetwork.comm.log.HmsFindLog;
import com.huawei.hwcloudjs.p164f.C6661f;

/* loaded from: classes8.dex */
public class NetworkUtils {
    private static final String GET_MOBILE_DATA_ENABLED_METHOD = "getDataEnabled";
    public static final int OFFLINE_MODE = 1;
    public static final int ONLINE_MODE = 2;
    private static final String TAG = "NetworkUtils";

    private static Context getCoreApplicationContext() {
        Context coreBaseContext = CoreApplication.getCoreBaseContext();
        if (coreBaseContext == null) {
            return null;
        }
        return coreBaseContext.getApplicationContext();
    }

    public static int getNetworkMode() {
        boolean zIsWifiEnabled;
        Context coreApplicationContext;
        TelephonyManager telephonyManager;
        try {
            zIsWifiEnabled = isWifiEnabled();
        } catch (RuntimeException e10) {
            HmsFindLog.m31928e(TAG, ">>> RuntimeException:" + e10.getMessage());
            zIsWifiEnabled = false;
        }
        boolean zIsWifiConnected = isWifiConnected();
        if (zIsWifiEnabled && zIsWifiConnected) {
            return 2;
        }
        return (isMobileDataEnabled() && (coreApplicationContext = getCoreApplicationContext()) != null && (telephonyManager = (TelephonyManager) coreApplicationContext.getSystemService("phone")) != null && telephonyManager.getSimState() == 5) ? 2 : 1;
    }

    public static boolean isMobileDataEnabled() {
        Context coreApplicationContext = getCoreApplicationContext();
        if (coreApplicationContext == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) coreApplicationContext.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.isDataEnabled();
        }
        HmsFindLog.m31931w(TAG, "telephonyManager is null.");
        return false;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Context coreApplicationContext = getCoreApplicationContext();
        if (coreApplicationContext == null || (connectivityManager = (ConnectivityManager) coreApplicationContext.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean isWifiConnected() {
        NetworkCapabilities networkCapabilities;
        Context coreApplicationContext = getCoreApplicationContext();
        if (coreApplicationContext == null) {
            return false;
        }
        Object systemService = coreApplicationContext.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            HmsFindLog.m31931w(TAG, "connectManager is null.");
            return false;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasTransport(1);
        } catch (Exception e10) {
            HmsFindLog.m31928e(TAG, "getNetworkCapabilities error:" + e10.getMessage());
            return false;
        }
    }

    public static boolean isWifiEnabled() throws RuntimeException {
        Context coreApplicationContext = getCoreApplicationContext();
        if (coreApplicationContext == null) {
            return false;
        }
        WifiManager wifiManager = (WifiManager) coreApplicationContext.getSystemService(C6661f.f30885g);
        if (wifiManager != null) {
            return wifiManager.isWifiEnabled();
        }
        HmsFindLog.m31931w(TAG, "wifiManager is null.");
        return false;
    }
}
