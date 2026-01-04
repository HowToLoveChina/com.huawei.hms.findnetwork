package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.r0 */
/* loaded from: classes8.dex */
public class C5564r0 {

    /* renamed from: a */
    private static final int[] f25284a = {1, 6, 7, 9};

    /* renamed from: b */
    private static final int[] f25285b = {0, 2, 3, 4, 5};

    /* renamed from: c */
    private static final Map<Integer, String> f25286c = new a();

    /* renamed from: com.huawei.hms.hatool.r0$a */
    public static class a extends HashMap<Integer, String> {
        public a() {
            put(1, "2G");
            put(2, "2G");
            put(4, "2G");
            put(7, "2G");
            put(11, "2G");
            put(3, "3G");
            put(8, "3G");
            put(9, "3G");
            put(10, "3G");
            put(15, "3G");
            put(5, "3G");
            put(6, "3G");
            put(12, "3G");
            put(14, "3G");
            put(13, "4G");
            put(20, "5G");
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    private static NetworkInfo m32727a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th2) {
            C5571v.m32789b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th2.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static String m32730b(Context context) {
        NetworkInfo networkInfoM32727a;
        if (context == null) {
            return "unknown";
        }
        try {
            networkInfoM32727a = m32727a(context);
        } catch (Throwable unused) {
        }
        if (!m32731b(networkInfoM32727a)) {
            return "none";
        }
        if (m32732c(networkInfoM32727a)) {
            return "WIFI";
        }
        if (m32729a(networkInfoM32727a)) {
            return m32728a(networkInfoM32727a.getSubtype());
        }
        return "unknown";
    }

    /* renamed from: c */
    private static boolean m32732c(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f25284a, networkInfo.getType()) == -1) ? false : true;
    }

    /* renamed from: a */
    private static String m32728a(int i10) {
        Map<Integer, String> map = f25286c;
        String str = map.containsKey(Integer.valueOf(i10)) ? map.get(Integer.valueOf(i10)) : "unknown";
        return "unknown".equals(str) ? i10 != 16 ? i10 != 17 ? "unknown" : "3G" : "2G" : str;
    }

    /* renamed from: b */
    private static boolean m32731b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    /* renamed from: a */
    private static boolean m32729a(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f25285b, networkInfo.getType()) == -1) ? false : true;
    }
}
