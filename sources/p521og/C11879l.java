package p521og;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.HwTelephonyManager;
import android.telephony.MSimTelephonyManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.telephony.SubscriptionManagerEx;
import com.huawei.hwcloudjs.p164f.C6661f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p809yg.C13981a;

/* renamed from: og.l */
/* loaded from: classes4.dex */
public class C11879l {
    /* renamed from: a */
    public static int m71325a(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        int iCalculateSignalLevel;
        int i10 = 0;
        if (context == null) {
            C13981a.m83988e("TelePhonyUtils", "context is null");
            return 0;
        }
        if (!m71333i(context)) {
            C13981a.m83988e("TelePhonyUtils", "wifi not connect");
            return 0;
        }
        Object systemService = context.getApplicationContext().getSystemService(C6661f.f30885g);
        if (systemService instanceof WifiManager) {
            WifiManager wifiManager = (WifiManager) systemService;
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return 0;
            }
            int rssi = connectionInfo.getRssi();
            try {
                Class<?> cls = Class.forName("com.huawei.android.net.wifi.WifiManagerCommonEx");
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("calculateSignalLevelHW", cls2, cls2);
                method.setAccessible(true);
                iCalculateSignalLevel = ((Integer) method.invoke(cls, Integer.valueOf(connectionInfo.getFrequency()), Integer.valueOf(rssi))).intValue();
            } catch (Exception unused) {
                iCalculateSignalLevel = Build.VERSION.SDK_INT >= 30 ? wifiManager.calculateSignalLevel(rssi) : WifiManager.calculateSignalLevel(rssi, 5);
            }
            i10 = iCalculateSignalLevel;
            C13981a.m83989i("TelePhonyUtils", "wifiSignalLevel: " + i10);
        }
        return i10;
    }

    /* renamed from: b */
    public static String m71326b(Context context, int i10) {
        String vSimNetworkOperatorName = null;
        try {
            vSimNetworkOperatorName = m71332h(context) ? HwTelephonyManager.getDefault().getVSimNetworkOperatorName() : MSimTelephonyManager.getDefault().getNetworkOperatorName(i10);
            C13981a.m83987d("TelePhonyUtils", "networkOperatorName: " + vSimNetworkOperatorName);
        } catch (NoSuchMethodError e10) {
            C13981a.m83988e("TelePhonyUtils", "error: " + e10.toString());
        }
        return vSimNetworkOperatorName;
    }

    /* renamed from: c */
    public static Map<Integer, String> m71327c(Context context) throws NoSuchMethodException, SecurityException {
        HashMap map = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            Method method = telephonyManager.getClass().getMethod("getLine1Number", Integer.TYPE);
            List<SubscriptionInfo> listM71329e = m71329e(context);
            if (listM71329e != null && listM71329e.size() > 0) {
                Iterator<SubscriptionInfo> it = listM71329e.iterator();
                while (it.hasNext()) {
                    int subscriptionId = it.next().getSubscriptionId();
                    int slotIndex = SubscriptionManagerEx.getSlotIndex(subscriptionId);
                    C13981a.m83987d("TelePhonyUtils", "HwTelephonyManager");
                    String line1NumberFromImpu = HwTelephonyManager.getDefault().getLine1NumberFromImpu(slotIndex);
                    if (TextUtils.isEmpty(line1NumberFromImpu)) {
                        C13981a.m83987d("TelePhonyUtils", "MSimTelephonyManager");
                        line1NumberFromImpu = MSimTelephonyManager.getDefault().getLine1Number(slotIndex);
                    }
                    if (TextUtils.isEmpty(line1NumberFromImpu)) {
                        line1NumberFromImpu = (String) method.invoke(telephonyManager, Integer.valueOf(subscriptionId));
                    }
                    if (!TextUtils.isEmpty(line1NumberFromImpu)) {
                        map.put(Integer.valueOf(slotIndex), line1NumberFromImpu);
                    }
                }
            }
        } catch (IllegalAccessException e10) {
            C13981a.m83988e("TelePhonyUtils", "getSubSimNum, IllegalAccessException: " + e10.toString());
        } catch (NoSuchMethodException e11) {
            C13981a.m83988e("TelePhonyUtils", "getSubSimNum, NoSuchMethodException: " + e11.toString());
        } catch (InvocationTargetException e12) {
            C13981a.m83988e("TelePhonyUtils", "getSubSimNum, InvocationTargetException: " + e12.toString());
        }
        return map;
    }

    /* renamed from: d */
    public static int m71328d(Context context) throws Settings.SettingNotFoundException {
        if (context == null) {
            return -1;
        }
        try {
            int i10 = Settings.System.getInt(context.getContentResolver(), "switch_dual_card_slots");
            C13981a.m83987d("TelePhonyUtils", "subId: " + i10);
            return i10;
        } catch (Settings.SettingNotFoundException e10) {
            C13981a.m83988e("TelePhonyUtils", e10.toString());
            return -1;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: e */
    public static List<SubscriptionInfo> m71329e(Context context) {
        ArrayList arrayList = new ArrayList();
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        return subscriptionManager != null ? subscriptionManager.getActiveSubscriptionInfoList() : arrayList;
    }

    /* renamed from: f */
    public static String m71330f(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(C6661f.f30885g);
        String str = "";
        if (wifiManager == null) {
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            String ssid = connectionInfo.getSSID();
            try {
                int networkId = connectionInfo.getNetworkId();
                List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
                if (configuredNetworks == null || configuredNetworks.size() <= 0) {
                    C13981a.m83988e("TelePhonyUtils", "wifiId is empty");
                    return "";
                }
                for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                    if (wifiConfiguration.networkId == networkId) {
                        return wifiConfiguration.SSID;
                    }
                }
                return ssid;
            } catch (Exception e10) {
                e = e10;
                str = ssid;
                C13981a.m83988e("TelePhonyUtils", "getWifiInfo occurred exception, " + e.toString());
                return str;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* renamed from: g */
    public static boolean m71331g(Context context) {
        if (context == null) {
            C13981a.m83988e("TelePhonyUtils", "context is null");
            return false;
        }
        if (HwTelephonyManager.getDefault().isPlatformSupportVsim()) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    if (packageManager.getPackageInfo("com.huawei.skytone", 16384) != null) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
                C13981a.m83988e("TelePhonyUtils", "isSupportVSim error: " + e10.toString());
            }
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m71332h(Context context) {
        boolean z10 = context != null && HwTelephonyManager.getDefault().isVSimEnabled() && m71331g(context);
        C13981a.m83989i("TelePhonyUtils", "isVSimOpen " + z10);
        return z10;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: i */
    public static boolean m71333i(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getNetworkInfo(1).isConnected();
        }
        return false;
    }
}
