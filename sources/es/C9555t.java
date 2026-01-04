package es;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hwcloudjs.p164f.C6661f;
import p531or.C11991a;
import sr.C12847b;

/* renamed from: es.t */
/* loaded from: classes8.dex */
public class C9555t {
    /* renamed from: a */
    public static boolean m59656a(Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService(C6661f.f30885g);
            if (systemService instanceof WifiManager) {
                return ((WifiManager) systemService).isScanAlwaysAvailable();
            }
            return false;
        } catch (Exception unused) {
            C1016d.m6183c("TelephonyUtil", "isWLANScan error, system exception");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m59657b(Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService(C6661f.f30885g);
            if (systemService instanceof WifiManager) {
                return ((WifiManager) systemService).isWifiEnabled();
            }
            return false;
        } catch (Exception unused) {
            C1016d.m6183c("TelephonyUtil", "checkWifiIsEnable exception");
            return false;
        }
    }

    /* renamed from: c */
    public static String m59658c(String str) {
        return (TextUtils.isEmpty(str) || str.length() != 2) ? "" : str;
    }

    /* renamed from: d */
    public static String m59659d() {
        String str;
        if (C9538c.m59567f(C11991a.m72145a()) != 8) {
            return "";
        }
        String strM77153h = C12847b.m77153h();
        if (TextUtils.isEmpty(strM77153h)) {
            str = "getCarMcc--getLocationIPAddress--host is empty";
        } else {
            if (strM77153h.contains("cn")) {
                return FeedbackConst.SDK.MCC_ZHCN;
            }
            str = "getCarMcc--host is empty";
        }
        C1016d.m6190j("TelephonyUtil", str);
        return "";
    }

    /* renamed from: e */
    public static String m59660e() {
        String networkOperator;
        try {
            if (m59664i()) {
                C1016d.m6181a("TelephonyUtil", "airplaneMode on, no mcc");
                return m59659d();
            }
            Object systemService = C11991a.m72146b().getApplicationContext().getSystemService("phone");
            if (systemService == null) {
                C1016d.m6181a("TelephonyUtil", "systemService is null");
                return m59659d();
            }
            String str = null;
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManager == null) {
                C1016d.m6181a("TelephonyUtil", "no TelephonyManager");
                return m59659d();
            }
            if (telephonyManager.getPhoneType() == 2) {
                if (telephonyManager.getSimState() == 5 && !telephonyManager.isNetworkRoaming()) {
                    networkOperator = telephonyManager.getSimOperator();
                }
                return (str != null || str.length() < 3) ? m59659d() : str.substring(0, 3);
            }
            networkOperator = telephonyManager.getNetworkOperator();
            str = networkOperator;
            if (str != null) {
            }
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static String m59661f() {
        Object systemService;
        try {
            if (m59663h() || (systemService = C11991a.m72146b().getApplicationContext().getSystemService("phone")) == null || !(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return telephonyManager.getPhoneType() != 2 ? m59658c(telephonyManager.getNetworkCountryIso()) : "";
        } catch (Exception unused) {
            C1016d.m6185e("TelephonyUtil", "getNetworkCountryCode exception", true);
            return "";
        }
    }

    /* renamed from: g */
    public static String m59662g() {
        try {
            Object systemService = C11991a.m72146b().getApplicationContext().getSystemService("phone");
            if (!(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return m59658c(telephonyManager.getSimState() == 5 ? telephonyManager.getSimCountryIso() : null);
        } catch (Exception unused) {
            C1016d.m6185e("TelephonyUtil", "getSimCountryCode exception", true);
            return "";
        }
    }

    /* renamed from: h */
    public static boolean m59663h() {
        Object systemService = C11991a.m72146b().getApplicationContext().getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            int simState = ((TelephonyManager) systemService).getSimState();
            z = simState == 0 || simState == 1 || simState == 2 || simState == 3 || simState == 6 || simState == 7 || simState == 8;
            C1016d.m6181a("TelephonyUtil", "simState:" + simState);
        }
        return z;
    }

    @TargetApi(17)
    /* renamed from: i */
    public static boolean m59664i() {
        return Settings.Global.getInt(C11991a.m72145a().getApplicationContext().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    /* renamed from: j */
    public static boolean m59665j() {
        try {
            Object systemService = C11991a.m72146b().getApplicationContext().getSystemService("phone");
            if (systemService instanceof TelephonyManager) {
                return ((TelephonyManager) systemService).isNetworkRoaming();
            }
            return false;
        } catch (Exception unused) {
            C1016d.m6185e("TelephonyUtil", "isSimRoaming exception", true);
            return false;
        }
    }
}
