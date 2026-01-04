package com.huawei.updatesdk.p177a.p178a.p183d.p185j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* renamed from: com.huawei.updatesdk.a.a.d.j.a */
/* loaded from: classes9.dex */
public class C8792a {

    /* renamed from: a */
    private static ConnectivityManager f45100a;

    /* renamed from: a */
    public static int m56125a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    private static ConnectivityManager m56128b(Context context) {
        if (f45100a == null) {
            f45100a = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return f45100a;
    }

    /* renamed from: c */
    public static int m56129c(Context context) {
        return m56125a(m56126a(context));
    }

    /* renamed from: d */
    public static boolean m56130d(Context context) {
        ConnectivityManager connectivityManagerM56128b;
        if (context == null || (connectivityManagerM56128b = m56128b(context)) == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManagerM56128b.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return m56127a(connectivityManagerM56128b);
        }
        return true;
    }

    /* renamed from: a */
    private static NetworkInfo m56126a(Context context) {
        ConnectivityManager connectivityManagerM56128b = m56128b(context);
        if (connectivityManagerM56128b != null) {
            return connectivityManagerM56128b.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m56127a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(16);
    }
}
