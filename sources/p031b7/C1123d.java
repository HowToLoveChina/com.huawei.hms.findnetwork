package p031b7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* renamed from: b7.d */
/* loaded from: classes2.dex */
public final class C1123d {
    /* renamed from: a */
    public static int m6855a(Context context) {
        int i10 = 1;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                i10 = 0;
            } else {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    i10 = 4;
                } else if (type == 0) {
                    i10 = m6856b(context) ? 3 : 2;
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("ConnectTypeUtils", "checkNetworkType Exception:" + e10.toString());
        }
        C1120a.m6675d("ConnectTypeUtils", "netType: " + i10);
        return i10;
    }

    /* renamed from: b */
    public static boolean m6856b(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            default:
                return false;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
        }
    }
}
