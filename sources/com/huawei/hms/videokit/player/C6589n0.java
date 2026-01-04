package com.huawei.hms.videokit.player;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import androidx.core.content.PermissionChecker;

/* renamed from: com.huawei.hms.videokit.player.n0 */
/* loaded from: classes8.dex */
public class C6589n0 {
    /* renamed from: a */
    private static int m37565a(Context context) throws ClassNotFoundException {
        TelephonyManager telephonyManager;
        if (!C6600t0.m37694k() || (telephonyManager = (TelephonyManager) C6600t0.m37668a(context, "phone", TelephonyManager.class)) == null || PermissionChecker.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
            return 0;
        }
        Object objM37669a = C6600t0.m37669a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", new Class[]{ServiceState.class}, telephonyManager.getServiceState());
        if (objM37669a instanceof Integer) {
            return ((Integer) objM37669a).intValue();
        }
        return 0;
    }

    /* renamed from: b */
    public static String m37566b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return "-1";
        }
        try {
            Object systemService = context.getSystemService("connectivity");
            connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        } catch (Exception e10) {
            C6550c1.m37258a("NetworkUtil", "getNetType e:", e10);
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            C6550c1.m37256a("NetworkUtil", "NetworkInfo:" + activeNetworkInfo.toString());
            String typeName = activeNetworkInfo.getTypeName();
            return "Wifi".equalsIgnoreCase(typeName) ? "1" : "Mobile".equalsIgnoreCase(typeName) ? m37565a(context) == 20 ? "4" : "2" : "Ethernet".equalsIgnoreCase(typeName) ? "3" : "-1";
        }
        return "-1";
    }

    /* renamed from: c */
    public static String m37567c(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        String str;
        if (context == null) {
            return "";
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e10) {
            C6550c1.m37258a("NetworkUtil", "getNetTypeName e:", e10);
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            C6550c1.m37256a("NetworkUtil", "NetworkInfo:" + activeNetworkInfo.toString());
            String typeName = activeNetworkInfo.getTypeName();
            if ("Wifi".equalsIgnoreCase(typeName)) {
                return "Wifi";
            }
            if (!"Mobile".equalsIgnoreCase(typeName)) {
                return "Ethernet".equalsIgnoreCase(typeName) ? "Ethernet" : "";
            }
            int iM37565a = m37565a(context);
            C6550c1.m37256a("NetworkUtil", "Hw NetworkType is: " + iM37565a);
            if (iM37565a == 0) {
                iM37565a = activeNetworkInfo.getSubtype();
            }
            if (iM37565a != 20) {
                switch (iM37565a) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = "3G";
                        break;
                    case 13:
                        str = "4G";
                        break;
                    default:
                        str = "";
                        break;
                }
            } else {
                str = "5G";
            }
            if (str.equals("")) {
                if (iM37565a == 16) {
                    return "2G";
                }
                if (iM37565a == 17) {
                    return "3G";
                }
            }
            return str;
        }
        return "";
    }
}
