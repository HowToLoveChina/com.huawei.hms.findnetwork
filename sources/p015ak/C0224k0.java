package p015ak;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p017pm.IPackageInstallObserver;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.RouteInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Window;
import com.hihonor.android.app.ActivityManagerEx;
import com.huawei.hicloud.base.bean.BatteryOptimizationInfo;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import p399jk.AbstractC10896a;
import p657tp.C13053d;
import p686up.InterfaceC13233a;
import p686up.InterfaceC13235c;

/* renamed from: ak.k0 */
/* loaded from: classes6.dex */
public class C0224k0 {

    /* renamed from: a */
    public static final UserHandle f833a = (UserHandle) m1553h("android.os.UserHandle", "CURRENT_OR_SELF", null);

    /* renamed from: b */
    public static final String f834b = (String) m1553h("android.provider.Settings$Secure", "USER_SETUP_COMPLETE", "");

    /* renamed from: c */
    public static final int f835c = ((Integer) m1553h("android.net.wifi.WifiManager", "WIFI_AP_STATE_ENABLED", 13)).intValue();

    /* renamed from: d */
    public static final int f836d = ((Integer) m1553h("android.net.wifi.WifiManager", "WIFI_AP_STATE_ENABLING", 12)).intValue();

    /* renamed from: e */
    public static final int f837e = ((Integer) m1553h("android.media.MediaFile", "FILE_TYPE_PNG", 33)).intValue();

    /* renamed from: f */
    public static final int f838f = ((Integer) m1553h("android.media.RingtoneManager", "TYPE_RINGTONE2", 0)).intValue();

    /* renamed from: g */
    public static final String f839g = (String) m1553h("android.Manifest$permission", "GRANT_RUNTIME_PERMISSIONS", "");

    /* renamed from: ak.k0$a */
    public static class a {

        /* renamed from: a */
        public static Method f840a;

        /* renamed from: b */
        public static Method f841b;

        /* renamed from: c */
        public static Method f842c;

        /* renamed from: d */
        public static Method f843d;

        /* renamed from: e */
        public static Method f844e;

        /* renamed from: f */
        public static Method f845f;

        static {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f840a = cls.getMethod("get", String.class);
                f841b = cls.getMethod("get", String.class, String.class);
                f842c = cls.getMethod("getLong", String.class, Long.TYPE);
                f843d = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
                f844e = cls.getMethod("getInt", String.class, Integer.TYPE);
                f845f = cls.getMethod("set", String.class, String.class);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("SystemPropertiesInvoke", "init SystemProperties Method : " + e10.getMessage());
            }
        }

        /* renamed from: a */
        public static String m1572a(String str) {
            try {
                Method method = f840a;
                if (method != null) {
                    return (String) method.invoke(null, str);
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("SystemPropertiesInvoke", "Platform error: " + e10.toString());
            }
            return null;
        }

        /* renamed from: b */
        public static String m1573b(String str, String str2) {
            try {
                Method method = f841b;
                if (method != null) {
                    return (String) method.invoke(null, str, str2);
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("SystemPropertiesInvoke", "Platform error: " + e10.toString());
            }
            return str2;
        }

        /* renamed from: c */
        public static boolean m1574c(String str, boolean z10) {
            try {
                Method method = f843d;
                if (method != null) {
                    return ((Boolean) method.invoke(null, str, Boolean.valueOf(z10))).booleanValue();
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("SystemPropertiesInvoke", "Platform error: " + e10.toString());
            }
            return z10;
        }

        /* renamed from: d */
        public static int m1575d(String str, int i10) {
            try {
                Method method = f844e;
                if (method != null) {
                    return ((Integer) method.invoke(null, str, Integer.valueOf(i10))).intValue();
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("SystemPropertiesInvoke", "Platform error: " + e10.toString());
            }
            return i10;
        }

        /* renamed from: e */
        public static void m1576e(String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                Method method = f845f;
                if (method != null) {
                    method.invoke(null, str, str2);
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("SystemPropertiesInvoke", "SystemPropertiesInvoke set : " + e10.toString());
            }
        }
    }

    /* renamed from: A */
    public static boolean m1531A(Activity activity) throws ClassNotFoundException {
        boolean zBooleanValue = false;
        try {
            Class<?> cls = Class.forName("android.common.HwFrameworkFactory");
            zBooleanValue = ((Boolean) Class.forName("android.app.IHwActivitySplitterImpl").getMethod("isSplitMode", new Class[0]).invoke(cls.getMethod("getHwActivitySplitterImpl", Activity.class, Boolean.TYPE).invoke(cls, activity, Boolean.TRUE), new Object[0])).booleanValue();
            AbstractC10896a.m65887i("SystemUtil", "isSplitMode: " + zBooleanValue);
            return zBooleanValue;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "isSplitMode: " + e10.toString());
            return zBooleanValue;
        }
    }

    /* renamed from: B */
    public static boolean m1532B(Context context) {
        return m1561p(context) == 0;
    }

    /* renamed from: C */
    public static boolean m1533C(int i10) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.media.MediaFile");
            return ((Boolean) cls.getMethod("isVideoFileType", Integer.TYPE).invoke(cls, Integer.valueOf(i10))).booleanValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "isVideoFileType: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: D */
    public static boolean m1534D(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            return !((Boolean) connectivityManager.getClass().getMethod("isNetworkSupported", Integer.TYPE).invoke(connectivityManager, 0)).booleanValue();
        } catch (IllegalAccessException unused) {
            AbstractC10896a.m65886e("SystemUtil", "illegal access exception when isWifiOnly");
            return false;
        } catch (NoSuchMethodException unused2) {
            AbstractC10896a.m65886e("SystemUtil", "no such method exception when isWifiOnly");
            return false;
        } catch (InvocationTargetException unused3) {
            AbstractC10896a.m65886e("SystemUtil", "invocation target exception when isWifiOnly");
            return false;
        }
    }

    /* renamed from: E */
    public static /* synthetic */ void m1535E(boolean z10, BatteryOptimizationInfo batteryOptimizationInfo) {
        batteryOptimizationInfo.setResult(z10);
        batteryOptimizationInfo.setTs(System.currentTimeMillis());
    }

    /* renamed from: F */
    public static int m1536F() {
        try {
            return ((Integer) UserHandle.class.getMethod("myUserId", new Class[0]).invoke(UserHandle.class, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            AbstractC10896a.m65886e("SystemUtil", "illegal access exception when myUserId");
            return 0;
        } catch (NoSuchMethodException unused2) {
            AbstractC10896a.m65886e("SystemUtil", "no such method exception when set myUserId");
            return 0;
        } catch (InvocationTargetException unused3) {
            AbstractC10896a.m65886e("SystemUtil", "invocation target exception when myUserId");
            return 0;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "other exception" + e10.toString());
            return 0;
        }
    }

    /* renamed from: G */
    public static final LinkAddress m1537G(InetAddress inetAddress, int i10) throws NoSuchMethodException, SecurityException {
        try {
            Constructor constructor = LinkAddress.class.getConstructor(InetAddress.class, Integer.TYPE);
            AbstractC10896a.m65887i("SystemUtil", constructor.toString());
            return (LinkAddress) constructor.newInstance(inetAddress, Integer.valueOf(i10));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "newLinkAddressInstance: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: H */
    public static Object m1538H(Context context) {
        try {
            return Class.forName("com.android.internal.widget.LockPatternUtils").getConstructor(Context.class).newInstance(context);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "newLockPatternUtils: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: I */
    public static final RouteInfo m1539I(InetAddress inetAddress) throws NoSuchMethodException, SecurityException {
        try {
            Constructor constructor = RouteInfo.class.getConstructor(InetAddress.class);
            AbstractC10896a.m65887i("SystemUtil", constructor.toString());
            return (RouteInfo) constructor.newInstance(inetAddress);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "newRouteInfoInstance: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: J */
    public static void m1540J(DevicePolicyManager devicePolicyManager, ComponentName componentName, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (devicePolicyManager == null || componentName == null) {
            return;
        }
        try {
            DevicePolicyManager.class.getMethod("setActiveAdmin", ComponentName.class, Boolean.TYPE).invoke(devicePolicyManager, componentName, Boolean.valueOf(z10));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "setActiveAdmin: " + e10.getMessage());
        }
    }

    /* renamed from: K */
    public static void m1541K(Window window, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (window == null) {
            return;
        }
        try {
            Window.class.getMethod("setCloseOnTouchOutside", Boolean.TYPE).invoke(window, Boolean.valueOf(z10));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "setCloseOnTouchOutside: " + e10.getMessage());
        }
    }

    /* renamed from: L */
    public static void m1542L(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "startActivity error:" + e10.getMessage());
        }
    }

    /* renamed from: M */
    public static void m1543M(Context context, Intent intent, Bundle bundle, UserHandle userHandle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (context == null) {
            return;
        }
        try {
            Context.class.getMethod("startActivityAsUser", Intent.class, Bundle.class, UserHandle.class).invoke(context, intent, bundle, userHandle);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "startActivityAsUser: " + e10.getMessage());
        }
    }

    /* renamed from: N */
    public static void m1544N(Activity activity, Intent intent, int i10) {
        try {
            activity.startActivityForResult(intent, i10);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "startActivityForResult error:" + e10.getMessage());
        }
    }

    /* renamed from: O */
    public static void m1545O(TelephonyManager telephonyManager) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (telephonyManager == null) {
            return;
        }
        try {
            TelephonyManager.class.getMethod("updateServiceLocation", new Class[0]).invoke(telephonyManager, new Object[0]);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "updateServiceLocation: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public static void m1547b(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("android.os.IDeviceIdleController$Stub").getMethod("asInterface", IBinder.class).invoke(null, m1560o("deviceidle"));
            objInvoke.getClass().getMethod("addPowerSaveWhitelistApp", String.class).invoke(objInvoke, str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "addPowerSaveWhitelistApp: " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public static Bitmap m1548c(String str, int i10) {
        try {
            return (Bitmap) ThumbnailUtils.class.getMethod("createImageThumbnail", String.class, Integer.TYPE).invoke(ThumbnailUtils.class, str, Integer.valueOf(i10));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "createImageThumbnail: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public static void m1549d(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.common.HwFrameworkFactory");
            Class.forName("android.app.IHwActivitySplitterImpl").getMethod("onSplitActivityDestroy", new Class[0]).invoke(cls.getMethod("getHwActivitySplitterImpl", Activity.class, Boolean.TYPE).invoke(cls, activity, Boolean.TRUE), new Object[0]);
            AbstractC10896a.m65887i("SystemUtil", "destroySplitActivity succ ");
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "destroySplitActivity: " + e10.toString());
        }
    }

    /* renamed from: e */
    public static void m1550e(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("android.os.IDeviceIdleController$Stub").getMethod("asInterface", IBinder.class).invoke(null, m1560o("deviceidle"));
            objInvoke.getClass().getMethod("exitIdle", String.class).invoke(objInvoke, str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "exitIdle: " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public static void m1551f(WifiManager wifiManager, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (wifiManager == null) {
            return;
        }
        try {
            WifiManager.class.getMethod("forget", Integer.TYPE, Class.forName("android.net.wifi.WifiManager$ActionListener")).invoke(wifiManager, Integer.valueOf(i10), null);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "forgetWifi: " + e10.getMessage());
        }
    }

    /* renamed from: g */
    public static int m1552g() {
        try {
            return ((Integer) ActivityManager.class.getMethod("getCurrentUser", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            AbstractC10896a.m65886e("SystemUtil", "illegal access exception when getCurrentUser");
            return 0;
        } catch (NoSuchMethodException unused2) {
            AbstractC10896a.m65886e("SystemUtil", "no such method exception when getCurrentUser");
            return 0;
        } catch (InvocationTargetException unused3) {
            AbstractC10896a.m65886e("SystemUtil", "invocation target exception when getCurrentUser");
            return 0;
        }
    }

    /* renamed from: h */
    public static <T> T m1553h(String str, String str2, T t10) throws IllegalAccessException, IllegalArgumentException {
        Object obj;
        try {
            obj = Class.forName(str).getField(str2).get(null);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getFieldByName: " + e10.getMessage());
            obj = t10;
        }
        AbstractC10896a.m65887i("SystemUtil", "getFieldByName," + obj);
        return obj == null ? t10 : (T) obj;
    }

    /* renamed from: i */
    public static int m1554i(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.media.MediaFile");
            return ((Integer) cls.getMethod("getFileTypeForMimeType", String.class).invoke(cls, str)).intValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getFileTypeForMimeType: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: j */
    public static float m1555j(Resources resources, int i10) {
        if (resources == null) {
            return 0.0f;
        }
        try {
            return ((Float) Resources.class.getMethod("getFloat", Integer.TYPE).invoke(resources, Integer.valueOf(i10))).floatValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getFloatFromResouses: " + e10.getMessage());
            return 0.0f;
        }
    }

    /* renamed from: k */
    public static String[] m1556k() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("android.os.IDeviceIdleController$Stub").getMethod("asInterface", IBinder.class).invoke(null, m1560o("deviceidle"));
            Object objInvoke2 = objInvoke.getClass().getMethod("getFullPowerWhitelist", new Class[0]).invoke(objInvoke, new Object[0]);
            if (objInvoke2 instanceof String[]) {
                return (String[]) objInvoke2;
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getFullPowerWhitelist: " + e10.getMessage());
        }
        return null;
    }

    /* renamed from: l */
    public static long m1557l(ExifInterface exifInterface) {
        try {
            return ((Long) ExifInterface.class.getMethod("getGpsDateTime", new Class[0]).invoke(exifInterface, new Object[0])).longValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getGpsDateTime: " + e10.getMessage());
            return -1L;
        }
    }

    /* renamed from: m */
    public static int m1558m(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            int iM1536F = m1536F();
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            return ((Integer) cls.getMethod("getKeyguardStoredPasswordQuality", Integer.TYPE).invoke(cls.getConstructor(Context.class).newInstance(context), Integer.valueOf(iM1536F))).intValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "newLockPatternUtils: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: n */
    public static String m1559n(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.media.MediaFile");
            return (String) cls.getMethod("getMimeTypeForFile", String.class).invoke(cls, str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getMimeTypeForFile: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: o */
    public static IBinder m1560o(String str) {
        try {
            return (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getServiceFromServiceManager: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: p */
    public static int m1561p(Context context) {
        try {
            return ((Integer) Context.class.getMethod("getUserId", new Class[0]).invoke(context, new Object[0])).intValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "newLockPatternUtils: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: q */
    public static int m1562q(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return ((Integer) WifiManager.class.getMethod("getWifiApState", new Class[0]).invoke((WifiManager) context.getSystemService(C6661f.f30885g), new Object[0])).intValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "getWifiApState: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: r */
    public static void m1563r(Context context, Uri uri, IPackageInstallObserver iPackageInstallObserver, int i10, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (context == null) {
            return;
        }
        try {
            PackageManager.class.getMethod("installPackage", Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class).invoke(context.getPackageManager(), uri, iPackageInstallObserver, Integer.valueOf(i10), str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "installPackage: " + e10.getMessage());
        }
    }

    /* renamed from: s */
    public static boolean m1564s() {
        BatteryOptimizationInfo batteryOptimizationInfo = (BatteryOptimizationInfo) C13053d.m78770i().m78764c(BatteryOptimizationInfo.class);
        if (batteryOptimizationInfo != null && System.currentTimeMillis() - batteryOptimizationInfo.getTs() < 86400000) {
            return batteryOptimizationInfo.isResult();
        }
        Context contextM1377a = C0213f.m1377a();
        try {
            final boolean zContains = contextM1377a.getContentResolver().call(Uri.parse("content://com.huawei.android.smartpowerprovider"), "hsm_get_freeze_list", "all", (Bundle) null).getStringArrayList("frz_protect").contains(contextM1377a.getPackageName());
            C13053d.m78770i().m78765d(BatteryOptimizationInfo.class, new InterfaceC13235c() { // from class: ak.j0
                @Override // p686up.InterfaceC13235c
                /* renamed from: a */
                public final void mo1517a(InterfaceC13233a interfaceC13233a) {
                    C0224k0.m1535E(zContains, (BatteryOptimizationInfo) interfaceC13233a);
                }
            });
            return zContains;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "isBatteryOptimizationContainsHiDisk  : " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: t */
    public static boolean m1565t() {
        Context contextM1377a = C0213f.m1377a();
        return contextM1377a != null && Settings.Global.getInt(contextM1377a.getContentResolver(), "hidisk_ds_start_sticky", 0) == 1;
    }

    /* renamed from: u */
    public static int m1566u(Activity activity) {
        try {
            return C0209d.m1277l1() ? ((Integer) ActivityManagerEx.class.getMethod("getActivityWindowMode", Activity.class).invoke(null, activity)).intValue() : ((Integer) com.huawei.android.app.ActivityManagerEx.class.getMethod("getActivityWindowMode", Activity.class).invoke(null, activity)).intValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "isGetActivityWindowMode: " + e10.getMessage());
            return -1;
        }
    }

    /* renamed from: v */
    public static boolean m1567v() throws ClassNotFoundException {
        boolean zEquals;
        String strM1244d0;
        try {
            strM1244d0 = C0209d.m1244d0();
        } catch (Exception e10) {
            AbstractC10896a.m65888w("SystemUtil", "isHarmonyOS error: " + e10.getMessage());
        }
        if (strM1244d0 == null || strM1244d0.isEmpty()) {
            zEquals = false;
        } else {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx$OsBrand");
            zEquals = strM1244d0.equals((String) cls.getDeclaredField("HARMONY").get(cls));
        }
        return zEquals && a.m1574c(SystemProperties.HW_SC_BUILD_OS_ENABLE, false);
    }

    /* renamed from: w */
    public static boolean m1568w() throws ClassNotFoundException {
        try {
            if (C0209d.m1277l1()) {
                Class.forName("com.hihonor.android.content.pm.UserInfoEx");
                return true;
            }
            Class.forName("com.huawei.android.content.pm.UserInfoEx");
            return true;
        } catch (ClassNotFoundException unused) {
            AbstractC10896a.m65888w("SystemUtil", "UserInfoEx not found");
            return false;
        }
    }

    /* renamed from: x */
    public static boolean m1569x(int i10) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.media.MediaFile");
            return ((Boolean) cls.getMethod("isImageFileType", Integer.TYPE).invoke(cls, Integer.valueOf(i10))).booleanValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "isImageFileType: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: y */
    public static boolean m1570y(Context context) throws ClassNotFoundException {
        if (context == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            Integer num = (Integer) cls.getMethod("myUserId", new Class[0]).invoke(cls, new Object[0]);
            num.intValue();
            Class<?> cls2 = C0209d.m1277l1() ? Class.forName("com.hihonor.android.os.UserManagerEx") : Class.forName("com.huawei.android.os.UserManagerEx");
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (m1568w()) {
                return ((Boolean) cls2.getMethod("isHwHiddenSpace", C0209d.m1277l1() ? Class.forName("com.hihonor.android.content.pm.UserInfoEx") : Class.forName("com.huawei.android.content.pm.UserInfoEx")).invoke(UserManager.class, cls2.getMethod("getUserInfoEx", UserManager.class, Integer.TYPE).invoke(null, userManager, num))).booleanValue();
            }
            return ((Boolean) cls2.getMethod("isHwHiddenSpace", Class.forName("android.content.pm.UserInfo")).invoke(UserManager.class, UserManager.class.getMethod("getUserInfo", Integer.TYPE).invoke(userManager, num))).booleanValue();
        } catch (ClassNotFoundException unused) {
            AbstractC10896a.m65886e("SystemUtil", "class not found exception when set privacy user");
            return false;
        } catch (IllegalAccessException unused2) {
            AbstractC10896a.m65886e("SystemUtil", "illegal access exception when set privacy user");
            return false;
        } catch (NoSuchMethodException unused3) {
            AbstractC10896a.m65886e("SystemUtil", "no such method exception when set privacy user");
            return false;
        } catch (InvocationTargetException unused4) {
            AbstractC10896a.m65886e("SystemUtil", "invocation target exception when set privacy user");
            return false;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("SystemUtil", "other exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: z */
    public static boolean m1571z(Context context) {
        if (context == null) {
            return false;
        }
        return Settings.System.getInt(context.getContentResolver(), "disable_factory_data_reset", 1) == 0 || FaqConstants.DISABLE_HA_REPORT.equals(a.m1573b("persist.sys.disable_reset", ""));
    }
}
