package es;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import as.C1016d;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hwcloudjs.p164f.C6661f;
import p531or.C11991a;

/* renamed from: es.k */
/* loaded from: classes8.dex */
public class C9546k {
    @SuppressLint({"MissingPermission", "NewApi"})
    /* renamed from: a */
    public static int m59607a(Context context) {
        TelephonyManager telephonyManager;
        String str;
        ServiceState serviceState;
        if (C9551p.m59637a(EmuiUtil.BUILDEX_VERSION) && context != null && (telephonyManager = (TelephonyManager) m59612f(context, "phone")) != null) {
            try {
                if (BuildEx.VERSION.EMUI_SDK_INT >= 21 && (serviceState = telephonyManager.getServiceState()) != null) {
                    return ServiceStateEx.getConfigRadioTechnology(serviceState);
                }
            } catch (NoClassDefFoundError unused) {
                str = "NoClassDefFoundError occur in method getHwNetworkType.";
                C1016d.m6181a("NetworkUtil", str);
                return 0;
            } catch (NoSuchMethodError unused2) {
                str = "NoSuchMethodError occur in method getHwNetworkType.";
                C1016d.m6181a("NetworkUtil", str);
                return 0;
            } catch (SecurityException unused3) {
                str = "requires permission maybe missing.";
                C1016d.m6181a("NetworkUtil", str);
                return 0;
            }
        }
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public static NetworkInfo m59608b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) m59612f(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (RuntimeException unused) {
            C1016d.m6181a("NetworkUtil", "getActiveNetworkInfo failed, exception");
            return null;
        }
    }

    /* renamed from: c */
    public static String m59609c() {
        int iM59611e = m59611e(C11991a.m72145a());
        return iM59611e != 1 ? iM59611e != 2 ? iM59611e != 3 ? iM59611e != 4 ? iM59611e != 5 ? "" : "5G" : "4G" : "3G" : "2G" : C6661f.f30885g;
    }

    /* renamed from: d */
    public static int m59610d() {
        return m59611e(C11991a.m72145a()) != 1 ? 0 : 1;
    }

    /* renamed from: e */
    public static int m59611e(Context context) {
        int i10;
        try {
            NetworkInfo networkInfoM59608b = m59608b(context);
            if (networkInfoM59608b == null || !networkInfoM59608b.isConnected()) {
                return -1;
            }
            int type = networkInfoM59608b.getType();
            int i11 = 1;
            if (1 != type && 13 != type && (C9538c.m59567f(context) != 8 || 9 != type)) {
                i11 = 0;
                if (type == 0) {
                    int iM59607a = m59607a(context);
                    C1016d.m6181a("NetworkUtil", "getHwNetworkType return is: " + iM59607a);
                    if (iM59607a == 0) {
                        iM59607a = networkInfoM59608b.getSubtype();
                    }
                    if (iM59607a != 20) {
                        switch (iM59607a) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                i10 = 2;
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
                                i10 = 3;
                                break;
                            case 13:
                                i10 = 4;
                                break;
                            default:
                                i10 = 0;
                                break;
                        }
                    } else {
                        i10 = 5;
                    }
                    if (i10 != 0) {
                        return i10;
                    }
                    if (iM59607a == 16) {
                        return 2;
                    }
                    if (iM59607a == 17) {
                        return 3;
                    }
                }
            }
            return i11;
        } catch (Exception unused) {
            C1016d.m6183c("NetworkUtil", "getNetworkType exception");
            return -1;
        }
    }

    /* renamed from: f */
    public static Object m59612f(Context context, String str) {
        if (context == null) {
            C1016d.m6181a("NetworkUtil", "context is null");
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (RuntimeException e10) {
            C1016d.m6184d("NetworkUtil", "SystemServer error:", e10);
            return null;
        }
    }

    /* renamed from: g */
    public static boolean m59613g(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) m59612f(context, "connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                return networkCapabilities.hasCapability(16);
            }
        } catch (Exception unused) {
            C1016d.m6183c("NetworkUtil", "isNetValida exception");
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m59614h(Context context) {
        NetworkInfo networkInfoM59608b;
        return C9548m.m59619b(context, "android.permission.ACCESS_NETWORK_STATE") && (networkInfoM59608b = m59608b(context)) != null && networkInfoM59608b.isConnected();
    }
}
