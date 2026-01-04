package p640sq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* renamed from: sq.p */
/* loaded from: classes8.dex */
public class C12837p {
    /* renamed from: a */
    public static String m77100a(Context context) {
        NetworkInfo.State state;
        C12836o.m77097b("NetUtils", "getNetType begin", true);
        if (context == null) {
            C12836o.m77099d("NetUtils", "context is null", true);
            return "NONE";
        }
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "NONE";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            C12836o.m77099d("NetUtils", "activeNetInfo is null or activeNetInfo is not available", true);
            return "NONE";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return "WIFI";
        }
        if (applicationContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return m77101b(applicationContext);
        }
        C12836o.m77097b("NetUtils", "no Permission READ_PHONE_STATE", true);
        return "NONE";
    }

    /* renamed from: b */
    public static String m77101b(Context context) {
        if (context == null) {
            C12836o.m77099d("NetUtils", "activity is null", true);
            return "NONE";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            C12836o.m77099d("NetUtils", "telephonyManager is null", true);
            return "NONE";
        }
        try {
            int networkType = telephonyManager.getNetworkType();
            C12836o.m77097b("NetUtils", "networkType is " + networkType, false);
            switch (networkType) {
            }
        } catch (Throwable th2) {
            C12836o.m77099d("NetUtils", "no permission " + th2.getClass().getSimpleName(), true);
            return "NONE";
        }
        return "NONE";
    }
}
