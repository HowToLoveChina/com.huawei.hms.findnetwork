package p774xg;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.android.remotecontrol.track.C4440b;
import com.huawei.android.remotecontrol.track.C4450l;
import com.huawei.android.remotecontrol.track.C4452n;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0224k0;
import p366if.AbstractC10482g;
import p366if.C10481f;
import p366if.C10489n;
import p572qb.C12315j;
import p772xe.C13777b;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: xg.a */
/* loaded from: classes4.dex */
public class C13811a {

    /* renamed from: a */
    public static final Object f62006a = new Object();

    /* renamed from: b */
    public static Timer f62007b = null;

    /* renamed from: c */
    public static PowerManager.WakeLock f62008c = null;

    /* renamed from: d */
    public static volatile boolean f62009d = false;

    /* renamed from: e */
    public static int f62010e = -1;

    /* renamed from: f */
    public static String f62011f = null;

    /* renamed from: g */
    public static boolean f62012g = false;

    /* renamed from: xg.a$a */
    public class a extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13811a.m82790H();
        }
    }

    /* renamed from: A */
    public static boolean m82783A(Context context) {
        PowerManager powerManager;
        if (context == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        return powerManager.isInteractive();
    }

    /* renamed from: B */
    public static boolean m82784B(Context context) {
        if (context == null) {
            C13981a.m83988e("LocUtil", "isWiFiEnable, context is null");
            return false;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService(C6661f.f30885g);
        return wifiManager != null && wifiManager.isWifiEnabled();
    }

    /* renamed from: C */
    public static void m82785C(Context context, boolean z10, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("LocUtil", "locatePreparation");
        m82807d(context);
        m82808e(context);
        m82786D(context);
        m82788F(context);
        m82812i(z10);
        m82813j(context, true);
        m82803U(context);
        if (m82818o(context)) {
            m82798P(context, false);
        }
        m82798P(context, true);
        m82797O(context);
        m82787E(context, z10, str);
    }

    /* renamed from: D */
    public static void m82786D(Context context) {
        if (m82819p(context) == 0) {
            C13812b.m82848s(context, "high_accuracy_startup_comfirm", 1);
            C13981a.m83989i("LocUtil", "openHighAccuracyInStartup");
        }
    }

    /* renamed from: E */
    public static void m82787E(Context context, boolean z10, String str) {
        String strM82821r = m82821r(z10);
        C13981a.m83989i("LocUtil", "apply powerKit for hiDisk and lbs and hms:" + strM82821r + " sourceFrom: " + str);
        C12315j.m74059f().m74060c("com.huawei.hidisk", 600000L, strM82821r);
        C12315j.m74059f().m74060c(m82817n(), 300000L, strM82821r);
        C12315j.m74059f().m74060c("com.huawei.hwid", 300000L, strM82821r);
    }

    /* renamed from: F */
    public static void m82788F(Context context) {
        if (context == null) {
            C13981a.m83988e("LocUtil", "context is null");
            return;
        }
        boolean zM82847r = C13812b.m82847r(context, "gps");
        boolean zM82847r2 = C13812b.m82847r(context, "network");
        C13981a.m83989i("LocUtil", "openLocationSource isGpsProviderOn:" + zM82847r + ";isNetworksProviderOn:" + zM82847r2);
        if (!zM82847r || !zM82847r2) {
            context.getContentResolver();
            C13812b.m82850u(context, true);
            C13812b.m82849t(context, "location_providers_allowed", "+gps");
            C13812b.m82849t(context, "location_providers_allowed", "+network");
        }
        m82789G(context);
    }

    /* renamed from: G */
    public static void m82789G(Context context) {
        if (context == null) {
            C13981a.m83988e("LocUtil", "openWiFiSource, context is null");
        } else {
            if (m82784B(context)) {
                return;
            }
            m82823t(context);
        }
    }

    /* renamed from: H */
    public static void m82790H() {
        PowerManager.WakeLock wakeLock = f62008c;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        f62008c.release();
        C13981a.m83989i("LocUtil", "sWakeLock release");
    }

    /* renamed from: I */
    public static void m82791I(Context context) {
        C13981a.m83989i("LocUtil", "releaseWiFiSource, isWiFiScanNeedRecover: " + f62009d);
        if (context == null) {
            C13981a.m83988e("LocUtil", "releaseWiFiSource, context is null");
        } else if (f62009d) {
            m82810g(context);
            f62009d = false;
        }
    }

    /* renamed from: J */
    public static void m82792J(Context context, String str, boolean z10) {
        C13981a.m83989i("LocUtil", "resetConfigStatus,userLocateConf is:" + str + ", isTrack: " + z10);
        if (str == null) {
            return;
        }
        String strM82806c = m82806c(context);
        if (!z10 && (TextUtils.isEmpty(strM82806c) || strM82806c.contains("false"))) {
            C13981a.m83989i("LocUtil", "currentLocateConf is empty, close locateConf");
            str = "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (TextUtils.isEmpty(str)) {
            C13812b.m82850u(context, false);
            Settings.Secure.setLocationProviderEnabled(contentResolver, "gps", false);
            Settings.Secure.setLocationProviderEnabled(contentResolver, "network", false);
        } else {
            C13812b.m82850u(context, str.contains(FaqConstants.DISABLE_HA_REPORT));
            Settings.Secure.setLocationProviderEnabled(contentResolver, "gps", str.contains("gps"));
            Settings.Secure.setLocationProviderEnabled(contentResolver, "network", str.contains("network"));
        }
        m82791I(context);
    }

    /* renamed from: K */
    public static synchronized void m82793K(Context context) {
        C13981a.m83987d("LocUtil", "reset userConfirmConf is:" + f62010e);
        if (!C10481f.m64435k() && !C13777b.m82707h() && !C4440b.m26936f() && !C4450l.m27011g(context)) {
            m82794L(context, f62010e);
            f62010e = -1;
            return;
        }
        C13981a.m83990w("LocUtil", "userConfirmConf isLocating");
    }

    /* renamed from: L */
    public static void m82794L(Context context, int i10) {
        if (f62010e == 0 && i10 == 0) {
            C13812b.m82848s(context, "high_accuracy_startup_comfirm", i10);
            C13981a.m83989i("LocUtil", "resetHighAccuracyConfirm");
        }
    }

    /* renamed from: M */
    public static synchronized void m82795M(Context context) {
        m82796N(context, false);
    }

    /* renamed from: N */
    public static synchronized void m82796N(Context context, boolean z10) {
        try {
            C13981a.m83987d("LocUtil", "reset userLocateConf is:" + m82822s() + ",isTrack: " + z10);
            if (z10 || (!C10481f.m64435k() && !C13777b.m82707h() && !C4440b.m26936f() && !C4450l.m27011g(context))) {
                if (WapFindPhoneActivity.m27740U3()) {
                    C13981a.m83989i("LocUtil", "resetLocateConf, getLocationStatus is true");
                    m82799Q(WapFindPhoneActivity.m27738T3());
                    WapFindPhoneActivity.m27760j5(false);
                    WapFindPhoneActivity.m27758i5(null);
                }
                m82792J(context, m82822s(), z10);
                f62012g = false;
                m82799Q(null);
                return;
            }
            C13981a.m83990w("LocUtil", "userLocateConf isLocating");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: O */
    public static void m82797O(Context context) {
        Settings.Global.putString(context.getContentResolver(), "device_remote_lbspkg", m82817n());
        C13981a.m83989i("LocUtil", "setDeviceRemoteLbspkg:" + m82817n());
    }

    /* renamed from: P */
    public static void m82798P(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), "device_remote_locate", z10 ? 1 : 0);
        C13981a.m83989i("LocUtil", "setDeviceRemoteLocate:" + (z10 ? 1 : 0));
    }

    /* renamed from: Q */
    public static synchronized void m82799Q(String str) {
        f62011f = str;
    }

    /* renamed from: R */
    public static void m82800R(Context context, int i10) {
        if (context == null) {
            C13981a.m83988e("LocUtil", "getWiFiScanStatus failed");
        } else {
            Settings.Global.putInt(context.getContentResolver(), "wifi_scan_always_enabled", i10);
        }
    }

    /* renamed from: S */
    public static void m82801S(Context context) {
        m82812i(true);
        m82813j(context, true);
        m82787E(context, true, "share_locate");
    }

    /* renamed from: T */
    public static void m82802T(Consumer<Location> consumer, Context context) {
        Location locationM64555c = C10489n.m64552d().m64555c();
        if (locationM64555c != null) {
            C13981a.m83989i("LocUtil", "the cacheLocation is valid.");
            consumer.accept(locationM64555c);
            return;
        }
        C13981a.m83989i("LocUtil", "the cacheLocation has expired, startLocate now.");
        Intent intent = new Intent();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "locate");
            jSONObject.put("x-hw-trace-id", C12797b.m76774a("01030"));
            intent.putExtra("msg_data", jSONObject.toString());
        } catch (JSONException e10) {
            C13981a.m83988e("LocUtil", "startLocate JSONException:" + e10.getMessage());
        }
        AbstractC10482g abstractC10482gM64432h = C10481f.m64432h(context, new PushCmdParser(intent, context), true, consumer, true, "screenshot_locate");
        abstractC10482gM64432h.m64453E0(true);
        abstractC10482gM64432h.mo7440z();
    }

    /* renamed from: U */
    public static void m82803U(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C0224k0.m1545O((TelephonyManager) context.getSystemService("phone"));
    }

    /* renamed from: a */
    public static void m82804a(Context context) {
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "hisync-findmyphone.LocateTrackModel.WakeLock");
        f62008c = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire();
    }

    /* renamed from: b */
    public static void m82805b(boolean z10, String str) {
        try {
            String strM82821r = m82821r(z10);
            C13981a.m83989i("LocUtil", "applyCloudPowerKit:" + strM82821r + " sourceFrom: " + str);
            C12315j.m74059f().m74060c("com.huawei.hidisk", 600000L, strM82821r);
        } catch (Exception unused) {
            C13981a.m83988e("LocUtil", "applyCloudPowerKit Exception");
        }
    }

    /* renamed from: c */
    public static String m82806c(Context context) {
        if (((LocationManager) context.getSystemService(JsbMapKeyNames.H5_LOC)) == null) {
            C13981a.m83989i("LocUtil", "LocationManager is null, get settings system data.");
            return C13812b.m82841l(context, "location_providers_allowed");
        }
        boolean zM82847r = C13812b.m82847r(context, "gps");
        boolean zM82847r2 = C13812b.m82847r(context, "network");
        String str = zM82847r ? "gps" : "";
        if (zM82847r2) {
            str = str + ",network";
        }
        boolean zM82846q = C13812b.m82846q(context);
        String str2 = str + "," + zM82846q;
        C13981a.m83989i("LocUtil", "cur locationEnabled:" + zM82846q);
        return str2;
    }

    /* renamed from: d */
    public static synchronized void m82807d(Context context) {
        try {
            if (f62010e == -1) {
                f62010e = m82819p(context);
            }
            C13981a.m83987d("LocUtil", "cache userConfirmConf is:" + f62010e);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public static synchronized void m82808e(Context context) {
        try {
            if (!f62012g) {
                f62012g = true;
                m82799Q(m82806c(context));
                C13981a.m83989i("LocUtil", "real cache userLocateConf");
            }
            C13981a.m83989i("LocUtil", "cache userLocateConf is:" + m82822s());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: f */
    public static void m82809f(Context context, boolean z10, boolean z11) {
        C13981a.m83989i("LocUtil", "close powerKit for lbs, hms");
        if (!z10 && C4452n.m27032l(context)) {
            C13981a.m83990w("LocUtil", "track task is running, not unApply power kit");
            return;
        }
        String strM82821r = m82821r(z11);
        C12315j.m74059f().m74071o("com.huawei.hidisk", strM82821r);
        C12315j.m74059f().m74071o(m82817n(), strM82821r);
        C12315j.m74059f().m74071o("com.huawei.hwid", strM82821r);
    }

    /* renamed from: g */
    public static void m82810g(Context context) {
        if (context == null) {
            C13981a.m83988e("LocUtil", "closeWiFiScan, context is null");
            return;
        }
        m82800R(context, 0);
        C13981a.m83989i("LocUtil", "closeWiFiScan");
        if (m82823t(context) != 0) {
            C13981a.m83988e("LocUtil", "closeWiFiScan failed");
        }
    }

    /* renamed from: h */
    public static boolean m82811h(Location location, Location location2, int i10) {
        long gpsLocTimeInterval = i10 == 0 ? ParamConfig.getInstance().getGpsLocTimeInterval() : ParamConfig.getInstance().getNetworkLocTimeInterval();
        int gpsLocAccInterval = i10 == 0 ? ParamConfig.getInstance().getGpsLocAccInterval() : ParamConfig.getInstance().getNetworkLocAccInterval();
        int gpsLocDisInterval = i10 == 0 ? ParamConfig.getInstance().getGpsLocDisInterval() : ParamConfig.getInstance().getNetworkLocDisInterval();
        if (location.getTime() - location2.getTime() >= gpsLocTimeInterval) {
            return true;
        }
        return !(location.getLatitude() == location2.getLatitude() && location.getLongitude() == location2.getLongitude()) && (location.getAccuracy() < location2.getAccuracy() || location.getAccuracy() - location2.getAccuracy() <= ((float) gpsLocAccInterval)) && location2.distanceTo(location) > ((float) gpsLocDisInterval);
    }

    /* renamed from: i */
    public static void m82812i(boolean z10) {
        C13981a.m83987d("LocUtil", "isManual is:" + z10);
        if (z10) {
            C13981a.m83989i("LocUtil", "exitIdleMode");
            try {
                C0224k0.m1550e("findmyphone");
            } catch (Exception e10) {
                C13981a.m83988e("LocUtil", "exitIdleMode exception :" + e10.getMessage());
            }
        }
    }

    /* renamed from: j */
    public static void m82813j(Context context, boolean z10) {
        C13981a.m83989i("LocUtil", "locate run forceCPUALive begin,isNorLocate:" + z10);
        if (m82783A(context)) {
            C13981a.m83988e("LocUtil", "forceCPUALive false because screen on");
            return;
        }
        synchronized (f62006a) {
            try {
                Timer timer = f62007b;
                if (timer != null) {
                    timer.cancel();
                    f62007b = null;
                }
                f62007b = new Timer("PhoneFinderWakeLock");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        PowerManager.WakeLock wakeLock = f62008c;
        if (wakeLock == null || !wakeLock.isHeld()) {
            m82804a(context);
        }
        f62007b.schedule(new a(), z10 ? PreConnectManager.CONNECT_SUCCESS_INTERNAL : 100000L);
    }

    /* renamed from: k */
    public static int m82814k(Context context) {
        int intExtra = new SafeIntent(context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))).getIntExtra("status", -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    /* renamed from: l */
    public static int m82815l(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return -1;
        }
        return batteryManager.getIntProperty(4);
    }

    /* renamed from: m */
    public static Object m82816m(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("percentage", m82815l(context));
            jSONObject.put("isCharging", m82814k(context));
        } catch (JSONException unused) {
            C13981a.m83988e("LocUtil", "getBatteryStatusInfo fail");
        }
        return jSONObject;
    }

    /* renamed from: n */
    public static String m82817n() {
        String strM1572a = C0224k0.a.m1572a("ro.config.hw_nlp");
        return TextUtils.isEmpty(strM1572a) ? "com.huawei.lbs" : strM1572a;
    }

    /* renamed from: o */
    public static boolean m82818o(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "device_remote_locate") != 0;
        } catch (Settings.SettingNotFoundException e10) {
            C13981a.m83988e("LocUtil", "getDeviceRemoteLocateIsOpen fail" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: p */
    public static int m82819p(Context context) {
        return C13812b.m82839j(context, "high_accuracy_startup_comfirm", 0);
    }

    /* renamed from: q */
    public static int m82820q(Context context) {
        if (context == null) {
            C13981a.m83988e("LocUtil", "getLockScreen context null");
            return -1;
        }
        if (C0209d.m1203Q1(context)) {
            return C0224k0.m1558m(context) == 0 ? 0 : 1;
        }
        C13981a.m83988e("LocUtil", "getLockScreen OOBE not finish");
        return 2;
    }

    /* renamed from: r */
    public static String m82821r(boolean z10) {
        return z10 ? "user-phoneFinder_lbs_apply" : "auto-finddevice-phoneFinder_lbs_apply";
    }

    /* renamed from: s */
    public static String m82822s() {
        return f62011f;
    }

    /* renamed from: t */
    public static int m82823t(Context context) {
        if (context != null) {
            return Settings.Global.getInt(context.getContentResolver(), "wifi_scan_always_enabled", 0);
        }
        C13981a.m83988e("LocUtil", "getWiFiScanStatus failed");
        return 0;
    }

    /* renamed from: u */
    public static boolean m82824u(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        if (location == null) {
            return false;
        }
        boolean zM82844o = C13812b.m82844o(location);
        boolean zM82844o2 = C13812b.m82844o(location2);
        C13981a.m83989i("LocUtil", "newLocation is " + location.getProvider() + " currentLocation is " + location2.getProvider() + " " + zM82844o + " " + zM82844o2);
        if (zM82844o && !zM82844o2) {
            return true;
        }
        if (zM82844o && location.getTime() - location2.getTime() > RippleView.SINGLE_RIPPLE_TIME && (location.distanceTo(location2) > ParamConfig.getInstance().getNetworkLocDisInterval() || !C13812b.m82831b(location2).equals(C13812b.m82831b(location)))) {
            return true;
        }
        if (!m82825v(location)) {
            return m82825v(location2) ? location.getTime() > location2.getTime() && location.getTime() - location2.getTime() >= ParamConfig.getInstance().getGpsLocTimeInterval() : m82811h(location, location2, 1);
        }
        if ("network".equals(location2.getProvider())) {
            return true;
        }
        if (location.getProvider().equals(location2.getProvider())) {
            return m82811h(location, location2, 0);
        }
        return false;
    }

    /* renamed from: v */
    public static boolean m82825v(Location location) {
        return "gps".equals(location.getProvider());
    }

    /* renamed from: w */
    public static boolean m82826w(Context context) {
        return C13812b.m82846q(context);
    }

    /* renamed from: x */
    public static boolean m82827x(Location location) {
        return location != null && m82825v(location) && location.getAccuracy() <= 20.0f;
    }

    /* renamed from: y */
    public static boolean m82828y(Context context) {
        return m82819p(context) != 0;
    }

    /* renamed from: z */
    public static boolean m82829z(Context context) {
        boolean zM82847r = C13812b.m82847r(context, "gps");
        boolean zM82847r2 = C13812b.m82847r(context, "network");
        C13981a.m83989i("LocUtil", "isGpsProviderOn:" + zM82847r + ";isNetworksProviderOn:" + zM82847r2);
        return C0209d.m1293p1() ? zM82847r2 : zM82847r && zM82847r2;
    }
}
