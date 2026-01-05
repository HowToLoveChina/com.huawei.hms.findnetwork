package p015ak;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.hihonor.android.app.LocaleHelperEx;
import com.huawei.android.dynamicfeature.plugin.language.LanguageInstaller;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.os.BuildEx;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import hk.C10278a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import okhttp3.HttpRequestBuilder;
import p015ak.C0224k0;
import p035bk.C1248a;
import p035bk.C1249b;
import p293fp.C9738a;
import p399jk.AbstractC10896a;
import p783xp.C13843a;
import sk.C12806c;

/* renamed from: ak.d */
/* loaded from: classes6.dex */
public class C0209d {

    /* renamed from: a */
    public static final boolean f776a;

    /* renamed from: b */
    public static long f777b;

    /* renamed from: c */
    public static final boolean f778c;

    /* renamed from: d */
    public static final boolean f779d;

    /* renamed from: e */
    public static Method f780e;

    /* renamed from: f */
    public static Method f781f;

    /* renamed from: g */
    public static int f782g;

    /* renamed from: h */
    public static String f783h;

    /* renamed from: i */
    public static String f784i;

    /* renamed from: j */
    public static String f785j;

    /* renamed from: k */
    public static String f786k;

    /* renamed from: l */
    public static String f787l;

    /* renamed from: m */
    public static String f788m;

    /* renamed from: n */
    public static String f789n;

    /* renamed from: o */
    public static String f790o;

    /* renamed from: p */
    public static long f791p;

    /* renamed from: q */
    public static PrivilegedAction f792q;

    /* renamed from: ak.d$a */
    public class a implements PrivilegedAction {
        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            try {
                (C0209d.m1277l1() ? C0213f.m1377a().getClassLoader().loadClass("com.hihonor.android.os.Build") : C0213f.m1377a().getClassLoader().loadClass("com.huawei.android.os.BuildEx")).getDeclaredMethod("getUDID", new Class[0]).setAccessible(true);
                return null;
            } catch (Exception unused) {
                AbstractC10896a.m65887i("BaseUtil", "old phone getUDID udid err.");
                return null;
            }
        }
    }

    static {
        f776a = m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 14;
        f778c = m1175H0();
        f779d = C0224k0.a.m1575d("hw_mc.oobe.button_style", 0) == 1;
        f782g = -1;
        f791p = 0L;
        f792q = new a();
        try {
            f780e = m1216V(Class.forName("com.android.internal.widget.LockPatternUtils"), "getKeyguardStoredPasswordQuality", Integer.TYPE);
            f781f = m1216V(UserHandle.class, "myUserId", new Class[0]);
        } catch (ClassNotFoundException unused) {
            AbstractC10896a.m65886e("BaseUtil", "lockPatternUtils init failed");
        }
    }

    /* renamed from: A */
    public static Context m1148A(Context context, String str) {
        AbstractC10896a.m65887i("BaseUtil", "customLanguageCode is:" + str + ", locale language is:" + Locale.getDefault().getLanguage() + ", local script : " + Locale.getDefault().getScript() + ", local country : " + Locale.getDefault().getCountry());
        if (context == null || TextUtils.isEmpty(str)) {
            return context;
        }
        Locale.Builder builder = new Locale.Builder();
        builder.setLanguage(str);
        builder.setScript(Locale.getDefault().getScript());
        builder.setRegion(Locale.getDefault().getCountry());
        Locale localeBuild = builder.build();
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(localeBuild);
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        new LanguageInstaller(contextCreateConfigurationContext).m14975j();
        return contextCreateConfigurationContext;
    }

    /* renamed from: A0 */
    public static String m1149A0() {
        if (!TextUtils.isEmpty(f786k)) {
            return f786k;
        }
        String strM1573b = C0224k0.a.m1573b("ro.build.version.emui", "");
        f786k = strM1573b;
        return strM1573b;
    }

    /* renamed from: A1 */
    public static boolean m1150A1(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            AbstractC10896a.m65887i("BaseUtil", "isNetWorkConnectedExcludeWifi context is null");
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isNetWorkConnectedExcludeWifi error. " + e10.toString());
            return false;
        }
    }

    /* renamed from: A2 */
    public static boolean m1151A2(Context context, String str, boolean z10) {
        AbstractC10896a.m65885d("BaseUtil", "setSettingsInt: " + str + ", " + z10);
        if (context == null) {
            AbstractC10896a.m65886e("BaseUtil", "setSettingsInt context is null");
            return false;
        }
        try {
            return Settings.Secure.putInt(context.getContentResolver(), str, z10 ? 1 : 0);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "setSettingsInt ex" + e10.toString());
            return false;
        }
    }

    /* renamed from: B */
    public static View m1152B(Window window) {
        if (window != null) {
            return window.getDecorView();
        }
        AbstractC10896a.m65886e("BaseUtil", "getDecorView window is null");
        return null;
    }

    /* renamed from: B0 */
    public static Bitmap m1153B0(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("BaseUtil", "getVideoBitmap filePath is null");
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return mediaMetadataRetriever.getFrameAtTime();
    }

    /* renamed from: B1 */
    public static boolean m1154B1(Context context) {
        if (context == null) {
            AbstractC10896a.m65886e("BaseUtil", "isNetworkValidated context is null");
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AbstractC10896a.m65886e("BaseUtil", "isNetworkValidated cm is null");
                return false;
            }
            AbstractC10896a.m65887i("BaseUtil", "isNetworkValidated sdk version: " + Build.VERSION.SDK_INT);
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                AbstractC10896a.m65886e("BaseUtil", "isNetworkValidated network is null");
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                AbstractC10896a.m65886e("BaseUtil", "isNetworkValidated capabilities is null");
                return false;
            }
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            AbstractC10896a.m65887i("BaseUtil", "isNetworkValidated, hasCapability: " + zHasCapability);
            return zHasCapability;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isNetworkValidated error: " + e10);
            return false;
        }
    }

    /* renamed from: B2 */
    public static void m1155B2() {
        C0212e0.m1370t(C0213f.m1377a(), "reqUpdateAppTime", "update_apk_time", System.currentTimeMillis());
    }

    /* renamed from: C */
    public static String m1156C() {
        return "HONOR".equals(m1164E()) ? "2" : "1";
    }

    /* renamed from: C0 */
    public static String m1157C0(String str) {
        return Locale.getDefault().getLanguage().contains(Constants.URDU_LANG) ? m1232a0(str) : str;
    }

    /* renamed from: C1 */
    public static boolean m1158C1(Context context) {
        try {
            return m1277l1() ? 2 != context.getPackageManager().getComponentEnabledSetting(new ComponentName("com.hihonor.hnstartupguide", "com.hihonor.hnstartupguide.LanguageSelectActivity")) : m1202Q0() ? 2 != context.getPackageManager().getComponentEnabledSetting(new ComponentName("com.huawei.hwstartupguide", "com.huawei.hwstartupguide.LanguageSelectActivity")) : 2 != context.getPackageManager().getComponentEnabledSetting(new ComponentName("com.huawei.hwstartupguide", "com.huawei.hwstartupguide.WizardActivity"));
        } catch (Exception unused) {
            AbstractC10896a.m65886e("BaseUtil", "oobe activity not found");
            return true;
        }
    }

    /* renamed from: C2 */
    public static void m1159C2(Activity activity) {
        if (activity == null) {
            AbstractC10896a.m65886e("BaseUtil", "showStatusBar activity is null!");
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            AbstractC10896a.m65886e("BaseUtil", "showStatusBar window is null!");
        } else {
            window.clearFlags(1024);
            m1163D2(m1152B(window));
        }
    }

    /* renamed from: D */
    public static String m1160D() {
        if (!TextUtils.isEmpty(f783h)) {
            return f783h;
        }
        String strM1573b = C0224k0.a.m1573b(SystemUtils.PRODUCT_BRAND, "");
        f783h = strM1573b;
        return strM1573b;
    }

    /* renamed from: D0 */
    public static boolean m1161D0() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return false;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM1377a, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("is_already_configed_V5", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_V4", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_new_v3", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_new", false) || sharedPreferencesM1382b.getBoolean("server_config_flag", false);
        }
        AbstractC10896a.m65886e("BaseUtil", "hasHistoryConfig globalSetting is null");
        return false;
    }

    /* renamed from: D1 */
    public static boolean m1162D1() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("BaseUtil", "context is null");
            return false;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM1377a, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b == null) {
            AbstractC10896a.m65886e("BaseUtil", "isOverlayInstall globalSetting is null");
            return false;
        }
        if (sharedPreferencesM1382b.getBoolean("is_already_configed_V8", false)) {
            return false;
        }
        return sharedPreferencesM1382b.getBoolean("is_already_configed_V7", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_V6", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_V5", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_V4", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_new_v3", false) || sharedPreferencesM1382b.getBoolean("is_already_configed_new", false) || sharedPreferencesM1382b.getBoolean("server_config_flag", false);
    }

    /* renamed from: D2 */
    public static void m1163D2(View view) {
        if (view == null) {
            AbstractC10896a.m65886e("BaseUtil", "showStatusBar view is null!");
        } else {
            view.setSystemUiVisibility(view.getSystemUiVisibility() & (-5));
            AbstractC10896a.m65887i("BaseUtil", "showStatusBar");
        }
    }

    /* renamed from: E */
    public static String m1164E() {
        if (!TextUtils.isEmpty(f784i)) {
            return f784i;
        }
        String strM1573b = C0224k0.a.m1573b("ro.product.manufacturer", "");
        f784i = strM1573b;
        return strM1573b;
    }

    /* renamed from: E0 */
    public static boolean m1165E0(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("com.android.settings.PHONE_FINDER_LOCK_SCREEN");
        intent.addCategory("android.intent.category.DEFAULT");
        m1302r2(intent, "com.android.settings");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    /* renamed from: E1 */
    public static boolean m1166E1() {
        return C0224k0.m1536F() == 0;
    }

    /* renamed from: E2 */
    public static int m1167E2(int i10, int i11) {
        return m1262h2() ? i10 : i11;
    }

    /* renamed from: F */
    public static String m1168F() {
        return Build.MODEL;
    }

    /* renamed from: F0 */
    public static void m1169F0(Activity activity) {
        if (activity == null) {
            AbstractC10896a.m65886e("BaseUtil", "showStatusBar activity is null!");
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            AbstractC10896a.m65886e("BaseUtil", "hideStatusBar window is null!");
        } else {
            window.addFlags(1024);
            m1172G0(m1152B(window));
        }
    }

    /* renamed from: F1 */
    public static boolean m1170F1() {
        return "tablet".equals(m1327y());
    }

    /* renamed from: G */
    public static String m1171G() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            String name = defaultAdapter != null ? defaultAdapter.getName() : "";
            return TextUtils.isEmpty(name) ? m1168F() : name;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getDeviceName exception: " + e10.toString());
            return m1168F();
        }
    }

    /* renamed from: G0 */
    public static void m1172G0(View view) {
        if (view == null) {
            AbstractC10896a.m65886e("BaseUtil", "hideStatusBar view is null!");
        } else {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 4);
            AbstractC10896a.m65887i("BaseUtil", "hideStatusBar");
        }
    }

    /* renamed from: G1 */
    public static boolean m1173G1(Context context) {
        return C0224k0.m1570y(context);
    }

    /* renamed from: H */
    public static String m1174H() {
        String strM1168F;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            strM1168F = defaultAdapter != null ? defaultAdapter.getName() : "";
            if (TextUtils.isEmpty(strM1168F)) {
                strM1168F = m1168F();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getDeviceName exception: " + e10.toString());
            strM1168F = m1168F();
        }
        return m1232a0(strM1168F);
    }

    /* renamed from: H0 */
    public static boolean m1175H0() {
        boolean zM1574c = C0224k0.a.m1574c("ro.build.beta", false);
        if (!zM1574c) {
            zM1574c = C0224k0.a.m1574c("ro.config.beta_sec_ctrl", false);
        }
        return zM1574c && !C0224k0.a.m1574c("hw.beta.skip", false);
    }

    /* renamed from: H1 */
    public static boolean m1176H1(Context context, String str) {
        if (context == null) {
            return false;
        }
        String processName = Application.getProcessName();
        AbstractC10896a.m65887i("BaseUtil", "Application.getProcessName:" + processName);
        return !TextUtils.isEmpty(processName) && processName.equals(str);
    }

    /* renamed from: I */
    public static String m1177I(String str) {
        try {
            Locale locale = new Locale(Locale.getDefault().getLanguage(), str);
            return m1277l1() ? LocaleHelperEx.getDisplayCountry(locale, Locale.getDefault()) : com.huawei.android.app.LocaleHelperEx.getDisplayCountry(locale, Locale.getDefault());
        } catch (Error e10) {
            AbstractC10896a.m65887i("BaseUtil", "getDisplayCountry Error fail: " + e10.toString());
            return "";
        } catch (RuntimeException e11) {
            AbstractC10896a.m65887i("BaseUtil", "getDisplayCountry RuntimeException fail: " + e11.toString());
            return "";
        } catch (Exception e12) {
            AbstractC10896a.m65887i("BaseUtil", "getDisplayCountry Exception fail: " + e12.toString());
            return "";
        }
    }

    /* renamed from: I0 */
    public static Object m1178I0(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "invoke exception:" + e10.toString());
            return null;
        }
    }

    /* renamed from: I1 */
    public static boolean m1179I1() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* renamed from: J */
    public static DisplayMetrics m1180J(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: J0 */
    public static boolean m1181J0(Activity activity) throws SecurityException {
        ComponentName componentName;
        if (activity == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
        if (activityManager == null) {
            AbstractC10896a.m65886e("BaseUtil", "ActivityManager is null");
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        String className = (runningTasks == null || (componentName = runningTasks.get(0).topActivity) == null) ? "" : componentName.getClassName();
        if (TextUtils.isEmpty(className) || !className.equals(activity.getClass().getName())) {
            AbstractC10896a.m65885d("BaseUtil", "hiCloud is background");
            return false;
        }
        AbstractC10896a.m65885d("BaseUtil", "hiCloud is foreground");
        return true;
    }

    /* renamed from: J1 */
    public static boolean m1182J1() {
        AbstractC10896a.m65887i("BaseUtil", "sRestoreUpdateFailTime: " + f791p);
        return System.currentTimeMillis() - f791p > C5863b6.g.f26453g;
    }

    /* renamed from: K */
    public static int m1183K(Context context, String str) {
        int i10 = 0;
        try {
            i10 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getInt("drive-sdk-version");
            AbstractC10896a.m65887i("BaseUtil", "getDriveSdkVersion, packageName: " + str + ", driveSdkVersion = " + i10);
            return i10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getDriveSdkVersion, " + e10.toString());
            return i10;
        }
    }

    /* renamed from: K0 */
    public static boolean m1184K0(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (Exception e10) {
                AbstractC10896a.m65886e("BaseUtil", "isAppInstalled exception: " + e10.toString());
            }
        }
        return false;
    }

    /* renamed from: K1 */
    public static boolean m1185K1(Context context) throws SecurityException {
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            AbstractC10896a.m65886e("BaseUtil", "ActivityManager is null");
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        String packageName = (runningTasks == null || (componentName = runningTasks.get(0).topActivity) == null) ? "" : componentName.getPackageName();
        if (TextUtils.isEmpty(packageName) || !packageName.equals(context.getPackageName())) {
            AbstractC10896a.m65885d("BaseUtil", "app is background");
            return false;
        }
        AbstractC10896a.m65885d("BaseUtil", "app is foreground");
        return true;
    }

    /* renamed from: L */
    public static String m1186L() {
        return m1189M(m1149A0());
    }

    /* renamed from: L0 */
    public static boolean m1187L0(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        if (context == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            AbstractC10896a.m65886e("BaseUtil", str + " not install");
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: L1 */
    public static boolean m1188L1(Context context, int i10) throws SecurityException {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            AbstractC10896a.m65886e("BaseUtil", "ActivityManager is null");
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(i10);
        if (runningTasks == null) {
            AbstractC10896a.m65886e("BaseUtil", "RunningTask is null");
            return false;
        }
        String packageName = "";
        for (int i11 = 0; i11 < runningTasks.size(); i11++) {
            ComponentName componentName = runningTasks.get(i11).topActivity;
            if (componentName != null) {
                packageName = componentName.getPackageName();
            }
            if (!TextUtils.isEmpty(packageName) && packageName.equals(context.getPackageName())) {
                AbstractC10896a.m65885d("BaseUtil", "app is running in stack");
                return true;
            }
        }
        AbstractC10896a.m65885d("BaseUtil", "app is background");
        return false;
    }

    /* renamed from: M */
    public static String m1189M(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    /* renamed from: M0 */
    public static boolean m1190M0(Context context, List<String> list) {
        if (list != null && list.size() != 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (m1184K0(context, it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: M1 */
    public static boolean m1191M1(Context context) {
        if (context == null) {
            return false;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            if (storageManager == null) {
                return false;
            }
            for (StorageVolume storageVolume : C1249b.m7483f(storageManager)) {
                if ("mounted".equals(C1249b.m7484g(storageManager, C1249b.m7481d(storageVolume))) && storageVolume.isRemovable()) {
                    Object objM7478a = C1249b.m7478a(storageManager, storageVolume.getUuid());
                    Object objM7479b = C1249b.m7479b(objM7478a);
                    if (objM7478a != null && C1249b.m7485h(objM7479b)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "get SD card path exception," + e10.toString());
            return false;
        }
    }

    /* renamed from: N */
    public static String m1192N() {
        String property = System.getProperty("hw.system.folderPrefix");
        AbstractC10896a.m65885d("BaseUtil", "profix:" + property);
        return property;
    }

    /* renamed from: N0 */
    public static boolean m1193N0() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isBeta = ");
        boolean z10 = f778c;
        sb2.append(z10);
        AbstractC10896a.m65887i("BaseUtil", sb2.toString());
        return z10;
    }

    /* renamed from: N1 */
    public static boolean m1194N1(Context context) {
        if (context == null) {
            AbstractC10896a.m65886e("BaseUtil", "isScreenOn context null");
            return false;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isInteractive();
        }
        AbstractC10896a.m65886e("BaseUtil", "powerManager null");
        return false;
    }

    /* renamed from: O */
    public static float m1195O(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 1.0f;
        }
        return configuration.fontScale;
    }

    /* renamed from: O0 */
    public static boolean m1196O0(Context context) {
        if (context == null) {
            AbstractC10896a.m65886e("BaseUtil", "isCharging context null");
            return false;
        }
        int intExtra = new SafeIntent(context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))).getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: O1 */
    public static boolean m1197O1() {
        AbstractC10896a.m65885d("BaseUtil", "sdk version: " + Build.VERSION.SDK_INT);
        return true;
    }

    /* renamed from: P */
    public static boolean m1198P(Context context) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return false;
        }
        try {
            int i10 = Settings.Secure.getInt(applicationContext.getContentResolver(), "HwCloudPage", 0);
            AbstractC10896a.m65887i("BaseUtil", "HwCloudPage Status = " + i10);
            return i10 == 100;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "Settings.Secure.getInt exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: P0 */
    public static boolean m1199P0() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("BaseUtil", "context is null");
            return false;
        }
        try {
            return Settings.Secure.getInt(contextM1377a.getContentResolver(), Constants.PATH_CHILDMODE_STATUS) == 1;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isChildMode exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: P1 */
    public static boolean m1200P1(Context context) {
        return m1210T(context) && !m1288o0(context);
    }

    /* renamed from: Q */
    public static List<String> m1201Q(Context context) {
        List listAsList = Arrays.asList("com.huawei.android.dsdscardmanager", "com.huawei.vdrive", "com.android.settings", "com.huawei.hwstartupguide");
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
            if (!listAsList.contains(resolveInfo.activityInfo.packageName)) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        return arrayList;
    }

    /* renamed from: Q0 */
    public static boolean m1202Q0() {
        return "CN".equalsIgnoreCase(m1207S());
    }

    /* renamed from: Q1 */
    public static boolean m1203Q1(Context context) {
        if (context != null) {
            return m1211T0(context) && m1242c2(context);
        }
        AbstractC10896a.m65886e("BaseUtil", "isStartupGuideFinished, context is null");
        return false;
    }

    /* renamed from: R */
    public static String m1204R() {
        String language = Locale.getDefault().getLanguage();
        String script = Locale.getDefault().getScript();
        if ("my".equals(language) && "Qaag".equals(script)) {
            return "my-ZG";
        }
        if (FaqConstants.DEFAULT_ISO_LANGUAGE.equals(language) && "Qaag".equals(script)) {
            return "en-GB";
        }
        return language + "-" + Locale.getDefault().getCountry();
    }

    /* renamed from: R0 */
    public static boolean m1205R0(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    /* renamed from: R1 */
    public static boolean m1206R1(Context context) {
        if (context != null) {
            return m1211T0(context) && m1242c2(context) && !m1158C1(context);
        }
        AbstractC10896a.m65886e("BaseUtil", "isStartupGuideFinishedNormally, context is null");
        return false;
    }

    /* renamed from: S */
    public static String m1207S() {
        if (!TextUtils.isEmpty(f789n)) {
            return f789n;
        }
        String strM1573b = C0224k0.a.m1573b(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
        f789n = strM1573b;
        return strM1573b;
    }

    /* renamed from: S0 */
    public static boolean m1208S0(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            AbstractC10896a.m65888w("BaseUtil", "isConnect context is null");
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isConnect error. " + e10.getMessage());
        }
        return false;
    }

    /* renamed from: S1 */
    public static String m1209S1(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* renamed from: T */
    public static boolean m1210T(Context context) throws Settings.SettingNotFoundException {
        Context applicationContext;
        int i10;
        int i11;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return false;
        }
        try {
            i10 = Settings.Secure.getInt(applicationContext.getContentResolver(), C0224k0.f834b);
        } catch (Settings.SettingNotFoundException e10) {
            AbstractC10896a.m65886e("BaseUtil", "userSetupComplete not found error: " + e10.toString());
            i10 = 0;
        }
        try {
            i11 = Settings.Secure.getInt(applicationContext.getContentResolver(), "device_provisioned");
        } catch (Settings.SettingNotFoundException e11) {
            AbstractC10896a.m65886e("BaseUtil", "deviceProvisioned not found error: " + e11.toString());
            i11 = 0;
        }
        AbstractC10896a.m65887i("BaseUtil", "userSetupComplete = " + i10 + " ,deviceProvisioned = " + i11);
        return i10 == 1 && i11 == 1;
    }

    /* renamed from: T0 */
    public static boolean m1211T0(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1;
    }

    /* renamed from: T1 */
    public static boolean m1212T1() {
        return m1223X0("com.huawei.android.app.ActionBarEx");
    }

    /* renamed from: U */
    public static String m1213U(String str, String str2) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("BaseUtil", "getMetaDataValue, context is null.");
            return str2;
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        if (packageManager == null) {
            AbstractC10896a.m65886e("BaseUtil", "getMetaDataValue, packageManager is null.");
            return str2;
        }
        try {
            Object obj = packageManager.getApplicationInfo(contextM1377a.getPackageName(), 128).metaData.get(str);
            if (obj != null) {
                return obj.toString();
            }
        } catch (PackageManager.NameNotFoundException e10) {
            AbstractC10896a.m65886e("BaseUtil", "get app id failed. e: " + e10.getMessage());
        }
        return str2;
    }

    /* renamed from: U0 */
    public static boolean m1214U0(Context context) {
        return m1176H1(context, "com.huawei.android.ds");
    }

    /* renamed from: U1 */
    public static boolean m1215U1(Context context) {
        if (context != null) {
            return !m1293p1() || m1304s0(context, C13843a.m83050B(context)) >= 105;
        }
        AbstractC10896a.m65886e("BaseUtil", "isSupportNotePadAbility context is null ");
        return false;
    }

    /* renamed from: V */
    public static Method m1216V(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            AbstractC10896a.m65888w("", "getMethod->clazz is null, method name is " + str);
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getMethod exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: V0 */
    public static boolean m1217V0(List<String> list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: V1 */
    public static boolean m1218V1(Context context, String str) {
        return m1183K(context, str) > 0;
    }

    /* renamed from: W */
    public static int m1219W(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return 0;
        }
        int subtype = networkInfo.getSubtype();
        if (m1325x1(subtype)) {
            return 5;
        }
        if (m1321w1(subtype)) {
            return 4;
        }
        if (m1317v1(subtype)) {
            return 3;
        }
        if (m1313u1(subtype)) {
            return 2;
        }
        return m1320w0(networkInfo);
    }

    /* renamed from: W0 */
    public static boolean m1220W0() {
        return f779d;
    }

    /* renamed from: W1 */
    public static boolean m1221W1(Context context, String str) {
        return m1304s0(context, str) > 0;
    }

    /* renamed from: X */
    public static int m1222X() {
        return C0224k0.m1536F();
    }

    /* renamed from: X0 */
    public static boolean m1223X0(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: X1 */
    public static boolean m1224X1() {
        return C0224k0.a.m1573b("hbc.country", "").toLowerCase(Locale.US).equals("tw");
    }

    /* renamed from: Y */
    public static int m1225Y(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        return activeNetworkInfo.getType() == 0 ? m1219W(activeNetworkInfo) : activeNetworkInfo.getType() == 9 ? 100 : 0;
    }

    /* renamed from: Y0 */
    public static boolean m1226Y0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - f777b <= 600;
        f777b = jCurrentTimeMillis;
        return z10;
    }

    /* renamed from: Y1 */
    public static boolean m1227Y1(Context context, Uri uri) {
        if (context == null || uri == null || uri.getAuthority() == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            AbstractC10896a.m65887i("BaseUtil", "not find uri: " + uri.toString());
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        AbstractC10896a.m65887i("BaseUtil", "provider packageName is: " + str);
        int i10 = applicationInfo.flags;
        return ((i10 & 1) == 1) || ((i10 & 128) != 0) || (packageManager.checkSignatures(str, context.getPackageName()) == 0);
    }

    /* renamed from: Z */
    public static String m1228Z(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 100 ? "unknown" : "cable" : "5g" : C6661f.f30884f : C6661f.f30883e : C6661f.f30882d : C6661f.f30885g;
    }

    /* renamed from: Z0 */
    public static boolean m1229Z0(File file) {
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    /* renamed from: Z1 */
    public static boolean m1230Z1(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                int i10 = packageManager.getPackageInfo(str, 16384).applicationInfo.flags;
                return ((i10 & 1) != 0) || ((i10 & 128) != 0) || (packageManager.checkSignatures(str, context.getPackageName()) == 0);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("BaseUtil", "isTargetSystemApp error." + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m1231a(HttpRequestBuilder.a aVar) {
        aVar.addHeader("x-hw-device-category", m1170F1() ? "pad" : "phone");
    }

    /* renamed from: a0 */
    public static String m1232a0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "\u202a" + str + "\u202c";
    }

    /* renamed from: a1 */
    public static boolean m1233a1() throws NoSuchMethodException, SecurityException {
        try {
            Method method = Class.forName("com.huawei.android.fsm.HwFoldScreenManagerEx").getMethod("isFoldable", new Class[0]);
            method.setAccessible(true);
            return ((Boolean) method.invoke(null, new Object[0])).booleanValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isFoldable exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a2 */
    public static boolean m1234a2(Context context, String str) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        return (context == null || TextUtils.isEmpty(str) || (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.size() <= 0 || (componentName = runningTasks.get(0).topActivity) == null || !TextUtils.equals(str, componentName.getPackageName())) ? false : true;
    }

    /* renamed from: b */
    public static int m1235b(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 > i11 || i13 > i10) {
            int i15 = i12 / 2;
            int i16 = i13 / 2;
            while (i15 / i14 >= i11 && i16 / i14 >= i10) {
                i14 *= 2;
            }
        }
        return i14;
    }

    /* renamed from: b0 */
    public static String m1236b0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "\u202d" + str + "\u202c";
    }

    /* renamed from: b1 */
    public static boolean m1237b1(Context context) {
        DisplayMetrics displayMetricsM1180J;
        int i10;
        int i11;
        if (context == null || (i10 = (displayMetricsM1180J = m1180J(context)).widthPixels) == 0 || (i11 = displayMetricsM1180J.heightPixels) == 0) {
            return false;
        }
        float f10 = i11 / i10;
        if (f10 < 1.0f && f10 != 0.0f) {
            f10 = 1.0f / f10;
        }
        return f10 >= 1.0f && f10 <= 1.33f;
    }

    /* renamed from: b2 */
    public static boolean m1238b2(String str, String str2) throws ParseException {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "format exception: " + e10.toString());
            date = null;
        }
        try {
            date2 = simpleDateFormat.parse(str2);
        } catch (Exception e11) {
            AbstractC10896a.m65886e("BaseUtil", "isTimeInRange exception: " + e11.toString());
        }
        Date date3 = new Date();
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) ? TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && date2 != null && date3.compareTo(date2) <= 0 : date != null && date3.compareTo(date) >= 0;
        }
        if (date == null || date2 == null) {
            return false;
        }
        return date3.compareTo(date) >= 0 && date3.compareTo(date2) <= 0;
    }

    /* renamed from: c */
    public static long m1239c(String str) {
        long j10;
        long j11 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int i10 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= 127) {
                j10 = 1;
            } else if (cCharAt <= 2047) {
                j10 = 2;
            } else if (Character.isHighSurrogate(cCharAt)) {
                j11 += 4;
                i10++;
                i10++;
            } else {
                j10 = 3;
            }
            j11 += j10;
            i10++;
        }
        return j11;
    }

    /* renamed from: c0 */
    public static String m1240c0(Context context, String str) {
        String string = "";
        try {
            string = context.getPackageManager().getApplicationInfo(str, 128).metaData.getString("sync-datatypes-count");
            AbstractC10896a.m65887i("BaseUtil", "getNotePadDataType, packageName: " + str + ", dataType = " + string);
            return string;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getNotePadDataType, " + e10.toString());
            return string;
        }
    }

    /* renamed from: c1 */
    public static boolean m1241c1() {
        Context contextM1377a = C0213f.m1377a();
        boolean zM1234a2 = contextM1377a != null ? m1234a2(contextM1377a, contextM1377a.getApplicationContext().getPackageName()) : false;
        AbstractC10896a.m65887i("BaseUtil", "clouddrive is foreground :" + zM1234a2);
        return zM1234a2;
    }

    /* renamed from: c2 */
    public static boolean m1242c2(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), C0224k0.f834b, 0) == 1;
    }

    /* renamed from: d */
    public static Bundle m1243d(Context context, Uri uri, String str, String str2, Bundle bundle) {
        if (!m1227Y1(context, uri)) {
            AbstractC10896a.m65886e("BaseUtil", "TargetApp is not SystemApp");
            return null;
        }
        try {
            return context.getContentResolver().call(uri, str, str2, bundle);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "callProvider error = " + e10.toString());
            return null;
        }
    }

    /* renamed from: d0 */
    public static String m1244d0() {
        if (!TextUtils.isEmpty(f787l)) {
            return f787l;
        }
        try {
            f787l = (String) Class.forName("com.huawei.system.BuildEx").getMethod("getOsBrand", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getOsBrand exception: " + e10.toString());
        }
        return f787l;
    }

    /* renamed from: d1 */
    public static boolean m1245d1(Context context, String str) throws SecurityException {
        ComponentName componentName;
        if (context != null && !TextUtils.isEmpty(str)) {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0 && (componentName = runningTasks.get(0).topActivity) != null && str.equals(componentName.getClassName())) {
                return true;
            }
            AbstractC10896a.m65887i("BaseUtil", "is not Foreground");
        }
        return false;
    }

    /* renamed from: d2 */
    public static boolean m1246d2(Context context) {
        try {
            if (context != null) {
                return ((UserManager) context.getSystemService("user")).isUserUnlocked();
            }
            AbstractC10896a.m65886e("BaseUtil", "isUserUnlocked context null");
            return false;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isUserUnlocked exception:" + e10.toString());
            return true;
        }
    }

    /* renamed from: e */
    public static boolean m1247e(Context context) {
        if (C0213f.m1377a() != null) {
            return true;
        }
        if (context == null) {
            AbstractC10896a.m65886e("BaseUtil", "context is null");
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            AbstractC10896a.m65886e("BaseUtil", "app context is null");
            return false;
        }
        AbstractC10896a.m65885d("BaseUtil", "check init context");
        C0213f.m1380d(applicationContext);
        return true;
    }

    /* renamed from: e0 */
    public static PendingIntent m1248e0(Context context, int i10, Intent intent, int i11) {
        return PendingIntent.getActivity(context, i10, intent, i11 | HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
    }

    /* renamed from: e1 */
    public static boolean m1249e1() {
        try {
            if (HwFoldScreenManagerEx.isFoldable()) {
                return HwFoldScreenManagerEx.getDisplayMode() == 7;
            }
            return false;
        } catch (Throwable th2) {
            AbstractC10896a.m65886e("BaseUtil", "isFoldedScreenExpand exception:" + th2.getMessage());
            return false;
        }
    }

    /* renamed from: e2 */
    public static boolean m1250e2(Context context) {
        return m1184K0(context, "com.huawei.welink") || m1184K0(context, Constants.WELINK_PKG_NAME);
    }

    /* renamed from: f */
    public static boolean m1251f(Intent intent) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return intent.resolveActivity(contextM1377a.getPackageManager()) != null;
        }
        AbstractC10896a.m65886e("BaseUtil", "checkIntent context null");
        return false;
    }

    /* renamed from: f0 */
    public static PendingIntent m1252f0(Context context, int i10, Intent intent, int i11, Bundle bundle) {
        return PendingIntent.getActivity(context, i10, intent, i11 | HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK, bundle);
    }

    /* renamed from: f1 */
    public static boolean m1253f1() {
        return C0219i.m1463a() >= 31;
    }

    /* renamed from: f2 */
    public static boolean m1254f2(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.getType() != 1) {
                        if (activeNetworkInfo.getType() == 9) {
                        }
                    }
                    AbstractC10896a.m65885d("BaseUtil", "isWifiActive ,status = " + activeNetworkInfo.isConnected());
                    return activeNetworkInfo.isConnected();
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isWifiActive error. " + e10.toString());
        }
        return false;
    }

    /* renamed from: g */
    public static String m1255g(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? "" : (str.equals(str2) || str.equals(str3)) ? str : str2;
    }

    /* renamed from: g0 */
    public static String m1256g0(Context context, int i10) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i10) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: g1 */
    public static boolean m1257g1() {
        return C0224k0.a.m1575d(SystemProperties.HW_SC_BUILD_OS_API_VERSION, 0) >= 8;
    }

    /* renamed from: g2 */
    public static boolean m1258g2(Context context) {
        return C0224k0.m1534D(context);
    }

    /* renamed from: h */
    public static void m1259h() {
        AbstractC10896a.m65887i("BaseUtil", "clearRestoreUpdateFailTime");
        f791p = 0L;
    }

    /* renamed from: h0 */
    public static int m1260h0(int i10, int i11) {
        if (i10 > i11) {
            AbstractC10896a.m65886e("BaseUtil", "getRandomInRange min < max");
            return 0;
        }
        try {
            return new SecureRandom().nextInt((i11 - i10) + 1) + i10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getRandomInRange exception:" + e10.toString());
            return 0;
        }
    }

    /* renamed from: h1 */
    public static boolean m1261h1() {
        int iM1575d = C0224k0.a.m1575d("ro.build.version.release", 0);
        int iM1575d2 = C0224k0.a.m1575d(SystemProperties.HW_SC_BUILD_OS_API_VERSION, 0);
        AbstractC10896a.m65885d("BaseUtil", "AOSP: " + iM1575d + ", API: " + iM1575d2);
        return iM1575d >= 12 && iM1575d2 >= 8;
    }

    /* renamed from: h2 */
    public static boolean m1262h2() {
        return "156".equals(C0224k0.a.m1573b("ro.config.hw_optb", ""));
    }

    /* renamed from: i */
    public static void m1263i(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                AbstractC10896a.m65886e("BaseUtil", "inputStream close exception.");
            }
        }
    }

    /* renamed from: i0 */
    public static long m1264i0(long j10, long j11) {
        if (j10 > j11) {
            AbstractC10896a.m65886e("BaseUtil", "getRandomLongInRange min < max");
            return 0L;
        }
        try {
            return new SecureRandom().longs(j10, j11 + 1).findFirst().getAsLong();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getRandomLongInRange exception:" + e10.toString());
            return 0L;
        }
    }

    /* renamed from: i1 */
    public static boolean m1265i1(Context context) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager != null ? activityManager.getRunningTasks(1) : null;
        if (runningTasks == null || runningTasks.size() <= 0) {
            AbstractC10896a.m65887i("BaseUtil", "is not Home");
            return false;
        }
        ComponentName componentName = runningTasks.get(0).topActivity;
        if (componentName == null) {
            return false;
        }
        String packageName = componentName.getPackageName();
        AbstractC10896a.m65887i("BaseUtil", "homeName is: " + packageName);
        return m1201Q(context).contains(packageName);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:62|37|(3:64|38|(2:40|41))|66|44|53) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x002d, code lost:
    
        p399jk.AbstractC10896a.m65886e("BaseUtil", "is.close failed");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: i2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1266i2(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "is.close failed"
            java.lang.String r1 = "BaseUtil"
            r2 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            java.io.InputStream r5 = r5.open(r6)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            int r6 = r5.available()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L34
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L34
            int r3 = r5.read(r6)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L34
            r4 = -1
            if (r3 == r4) goto L29
            r5.close()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L34
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L34
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L34
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L34
            r2 = r3
            goto L29
        L26:
            r6 = move-exception
            r2 = r5
            goto L3d
        L29:
            r5.close()     // Catch: java.io.IOException -> L2d
            goto L3c
        L2d:
            p399jk.AbstractC10896a.m65886e(r1, r0)
            goto L3c
        L31:
            r6 = move-exception
            goto L3d
        L33:
            r5 = r2
        L34:
            java.lang.String r6 = "IOException"
            p399jk.AbstractC10896a.m65888w(r1, r6)     // Catch: java.lang.Throwable -> L26
            if (r5 == 0) goto L3c
            goto L29
        L3c:
            return r2
        L3d:
            if (r2 == 0) goto L46
            r2.close()     // Catch: java.io.IOException -> L43
            goto L46
        L43:
            p399jk.AbstractC10896a.m65886e(r1, r0)
        L46:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0209d.m1266i2(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: j */
    public static int m1267j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        int length = 0;
        for (int i10 = 0; i10 < iMin; i10++) {
            length = strArrSplit[i10].length() - strArrSplit2[i10].length();
            if (length != 0 || (length = strArrSplit[i10].compareTo(strArrSplit2[i10])) != 0) {
                break;
            }
        }
        return length != 0 ? length : strArrSplit.length - strArrSplit2.length;
    }

    /* renamed from: j0 */
    public static int m1268j0(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        return i10 > i11 ? i10 : i11;
    }

    /* renamed from: j1 */
    public static boolean m1269j1() {
        return "HONOR".equals(m1164E());
    }

    /* renamed from: j2 */
    public static boolean m1270j2(String str) {
        Locale locale;
        if (TextUtils.isEmpty(str) || (locale = Locale.getDefault()) == null) {
            return false;
        }
        String str2 = locale.getLanguage() + '-' + locale.getCountry();
        Locale locale2 = Locale.ROOT;
        return StringUtil.equals(str.toLowerCase(locale2), str2.toLowerCase(locale2));
    }

    /* renamed from: k */
    public static long m1271k(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new SimpleDateFormat(str2).parse(str).getTime();
            } catch (ParseException unused) {
                AbstractC10896a.m65886e("BaseUtil", "convertToMilli exception");
            }
        }
        return 0L;
    }

    /* renamed from: k0 */
    public static int m1272k0(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        return i10 > i11 ? i11 : i10;
    }

    /* renamed from: k1 */
    public static boolean m1273k1() {
        return m1269j1() && Build.VERSION.SDK_INT >= 30;
    }

    /* renamed from: k2 */
    public static String m1274k2(long j10) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j10));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "milsToDateString exception:" + e10.toString());
            return "";
        }
    }

    /* renamed from: l */
    public static void m1275l(CountDownLatch countDownLatch) {
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* renamed from: l0 */
    public static String m1276l0() {
        try {
            String strM1244d0 = m1244d0();
            String strM1164E = m1164E();
            String strM1160D = m1160D();
            if (TextUtils.isEmpty(strM1244d0)) {
                return TextUtils.isEmpty(strM1164E) ? "Other" : strM1164E.equals("HONOR") ? "MagicUI" : strM1164E.equals("HUAWEI") ? "EMUI" : "Other";
            }
            if (!strM1244d0.equals("emui")) {
                return strM1244d0.equals("harmony") ? "Harmony" : strM1244d0.equals("magicui") ? "MagicUI" : "Other";
            }
            if (!strM1164E.equals("HONOR") || !strM1160D.equals("HONOR")) {
                return "EMUI";
            }
            AbstractC10896a.m65885d("BaseUtil", "getReportOsBrand in Honor error OsBrand device, OsBrand = MagicUI");
            return "MagicUI";
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getReportOsBrand exception: " + e10.toString());
            return "Other";
        }
    }

    /* renamed from: l1 */
    public static boolean m1277l1() {
        return m1269j1() && Build.VERSION.SDK_INT >= 31;
    }

    /* renamed from: l2 */
    public static boolean m1278l2(String str) {
        Locale locale;
        if (TextUtils.isEmpty(str) || (locale = Locale.getDefault()) == null) {
            return false;
        }
        AbstractC10896a.m65887i("BaseUtil", "locale.getLanguage():" + locale.getLanguage());
        return locale.getLanguage().equals(new Locale(str).getLanguage());
    }

    /* renamed from: m */
    public static File m1279m(String str) {
        File fileM63442h = C10278a.m63442h(str);
        if (m1229Z0(fileM63442h)) {
            return fileM63442h;
        }
        try {
            if (!m1283n(fileM63442h.getParent())) {
                return null;
            }
            if (fileM63442h.createNewFile()) {
                return fileM63442h;
            }
            return null;
        } catch (IOException e10) {
            AbstractC10896a.m65886e("BaseUtil", "createFile error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: m0 */
    public static long m1280m0() {
        return C0212e0.m1359i(C0213f.m1377a(), "reqUpdateAppTime", Utils.REQUEST_TIME, 0L);
    }

    /* renamed from: m1 */
    public static boolean m1281m1() {
        return m1269j1() && Build.VERSION.SDK_INT >= 33;
    }

    /* renamed from: m2 */
    public static void m1282m2(Context context, int i10) {
        if (context == null) {
            return;
        }
        Intent data = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", "com.huawei.hidisk", null));
        data.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(data, i10);
            } else {
                context.startActivity(data);
            }
        } catch (RuntimeException e10) {
            AbstractC10896a.m65886e("Permission", "ViewPermission RuntimeException: " + e10.toString());
        } catch (Exception e11) {
            AbstractC10896a.m65886e("Permission", "ViewPermission Exception: " + e11.toString());
        }
    }

    /* renamed from: n */
    public static boolean m1283n(String str) {
        if (str == null) {
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        return (fileM63442h.exists() && fileM63442h.isDirectory()) || fileM63442h.mkdirs();
    }

    /* renamed from: n0 */
    public static String m1284n0() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: n1 */
    public static boolean m1285n1() {
        return "HUAWEI".equalsIgnoreCase(m1164E());
    }

    /* renamed from: n2 */
    public static Cursor m1286n2(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return context.getContentResolver().query(uri, strArr, str, strArr2, str2);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "queryProvider error = " + e10.toString());
            return null;
        }
    }

    /* renamed from: o */
    public static Bitmap m1287o(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("BaseUtil", "decodeSampledBitmapFile filePath is null");
            return null;
        }
        AbstractC10896a.m65885d("BaseUtil", "decodeSampledBitmapFile displayWidth=" + i10 + ",displayHeight=" + i11);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        C1248a.m7473d(str, options);
        options.inSampleSize = m1235b(options, i10, i11);
        AbstractC10896a.m65885d("BaseUtil", "decodeSampledBitmapFile inSampleSize=" + options.inSampleSize);
        options.inJustDecodeBounds = false;
        return C1248a.m7473d(str, options);
    }

    /* renamed from: o0 */
    public static boolean m1288o0(Context context) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return false;
        }
        try {
            int i10 = Settings.Secure.getInt(applicationContext.getContentResolver(), "oobe_set_later_complete", 0);
            AbstractC10896a.m65887i("BaseUtil", "set later Status = " + i10);
            return i10 == 100;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "Settings.Secure.getInt exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: o1 */
    public static boolean m1289o1(String[] strArr, String[] strArr2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.getDefault());
        try {
            Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            AbstractC10896a.m65885d("BaseUtil", "isInDelayTime now: " + date);
            for (int i10 = 0; i10 < strArr.length; i10++) {
                Date date2 = simpleDateFormat.parse(strArr[i10]);
                Date date3 = simpleDateFormat.parse(strArr2[i10]);
                AbstractC10896a.m65885d("BaseUtil", "isInDelayTime after: " + date.after(date2) + ", before: " + date.before(date3) + ", i: " + i10);
                if (date.after(date2) && date.before(date3)) {
                    return true;
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isInDelayTime exception: " + e10.toString());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0062 A[Catch: IOException -> 0x006b, TryCatch #7 {IOException -> 0x006b, blocks: (B:91:0x005d, B:93:0x0062, B:95:0x0067), top: B:104:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0067 A[Catch: IOException -> 0x006b, TRY_LEAVE, TryCatch #7 {IOException -> 0x006b, blocks: (B:91:0x005d, B:93:0x0062, B:95:0x0067), top: B:104:0x005d }] */
    /* renamed from: o2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1290o2(java.io.InputStream r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "readConfigStr, close input failed"
            java.lang.String r1 = "BaseUtil"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            r4.<init>(r6, r5)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
        L16:
            java.lang.String r3 = r5.readLine()     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L23
            if (r3 == 0) goto L25
            r2.append(r3)     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L23
            goto L16
        L20:
            r2 = move-exception
        L21:
            r3 = r4
            goto L5b
        L23:
            r3 = r4
            goto L43
        L25:
            java.lang.String r3 = "readConfigStr, read local config str success"
            p399jk.AbstractC10896a.m65887i(r1, r3)     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L23
            if (r6 == 0) goto L2f
            r6.close()     // Catch: java.io.IOException -> L36
        L2f:
            r4.close()     // Catch: java.io.IOException -> L36
        L32:
            r5.close()     // Catch: java.io.IOException -> L36
            goto L55
        L36:
            p399jk.AbstractC10896a.m65886e(r1, r0)
            goto L55
        L3a:
            r2 = move-exception
            r5 = r3
            goto L21
        L3d:
            r5 = r3
            goto L23
        L3f:
            r2 = move-exception
            r5 = r3
            goto L5b
        L42:
            r5 = r3
        L43:
            java.lang.String r4 = "readConfigStr, read local config failed"
            p399jk.AbstractC10896a.m65886e(r1, r4)     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L4d
            r6.close()     // Catch: java.io.IOException -> L36
        L4d:
            if (r3 == 0) goto L52
            r3.close()     // Catch: java.io.IOException -> L36
        L52:
            if (r5 == 0) goto L55
            goto L32
        L55:
            java.lang.String r6 = r2.toString()
            return r6
        L5a:
            r2 = move-exception
        L5b:
            if (r6 == 0) goto L60
            r6.close()     // Catch: java.io.IOException -> L6b
        L60:
            if (r3 == 0) goto L65
            r3.close()     // Catch: java.io.IOException -> L6b
        L65:
            if (r5 == 0) goto L6e
            r5.close()     // Catch: java.io.IOException -> L6b
            goto L6e
        L6b:
            p399jk.AbstractC10896a.m65886e(r1, r0)
        L6e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0209d.m1290o2(java.io.InputStream):java.lang.String");
    }

    /* renamed from: p */
    public static boolean m1291p(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* renamed from: p0 */
    public static int m1292p0(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", OsType.ANDROID)) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: p1 */
    public static boolean m1293p1() {
        if (f782g == -1) {
            f782g = C0224k0.a.m1575d("hw_sc.eink.support.mode", -1);
        }
        AbstractC10896a.m65887i("BaseUtil", "current device mScreenMode: " + f782g);
        return f782g > 0;
    }

    /* renamed from: p2 */
    public static void m1294p2(Context context, String str, int i10) {
        AbstractC10896a.m65887i("BaseUtil", "recordBootStatus keyName=" + str);
        if (context != null) {
            try {
                SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "boot_status", 0);
                StringBuffer stringBuffer = new StringBuffer();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                date.setTime(System.currentTimeMillis());
                String str2 = simpleDateFormat.format(date);
                stringBuffer.append("");
                stringBuffer.append(String.valueOf(i10));
                stringBuffer.append("-");
                stringBuffer.append("[");
                stringBuffer.append(str2);
                stringBuffer.append("]");
                sharedPreferencesM1382b.edit().putString(str, stringBuffer.toString()).commit();
            } catch (Exception e10) {
                AbstractC10896a.m65886e("BaseUtil", "recordBootStatus exception:" + e10.toString());
            }
        }
    }

    /* renamed from: q */
    public static String m1295q(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null || (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.size() <= 0 || (componentName = runningTasks.get(0).topActivity) == null) {
            return null;
        }
        return componentName.getClassName();
    }

    /* renamed from: q0 */
    public static int m1296q0(Context context, String str) {
        int i10 = 0;
        try {
            i10 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getInt("sync-app-versioncode");
            AbstractC10896a.m65887i("BaseUtil", "getSyncAppVersionCode, packageName: " + str + ", appVersionCode = " + i10);
            return i10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getSyncSdkVersion, " + e10.toString());
            return i10;
        }
    }

    /* renamed from: q1 */
    public static boolean m1297q1(Context context) {
        Resources resources;
        Configuration configuration;
        return (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x001b  */
    /* renamed from: q2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1298q2(java.lang.String r3, long r4, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            java.lang.String r2 = "BaseUtil"
            if (r0 == 0) goto L10
            java.lang.String r3 = "str is empty"
            p399jk.AbstractC10896a.m65886e(r2, r3)
            return r1
        L10:
            if (r6 == 0) goto L1b
            boolean r6 = p015ak.C0209d.f776a     // Catch: java.lang.Exception -> L19
            if (r6 == 0) goto L1b
            r6 = 1000(0x3e8, float:1.401E-42)
            goto L1d
        L19:
            r3 = move-exception
            goto L38
        L1b:
            r6 = 1024(0x400, float:1.435E-42)
        L1d:
            android.content.Context r0 = p015ak.C0213f.m1377a()     // Catch: java.lang.Exception -> L19
            java.lang.String r4 = p015ak.C0223k.m1521d(r0, r4, r6)     // Catch: java.lang.Exception -> L19
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L19
            if (r5 == 0) goto L31
            java.lang.String r3 = "cap is empty"
            p399jk.AbstractC10896a.m65886e(r2, r3)     // Catch: java.lang.Exception -> L19
            return r1
        L31:
            java.lang.String r5 = "\\$\\$Cap"
            java.lang.String r3 = r3.replaceAll(r5, r4)     // Catch: java.lang.Exception -> L19
            return r3
        L38:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "replaceCapacityPlaceholder exception: "
            r4.append(r5)
            java.lang.String r3 = r3.toString()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            p399jk.AbstractC10896a.m65886e(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0209d.m1298q2(java.lang.String, long, boolean):java.lang.String");
    }

    /* renamed from: r */
    public static String m1299r(Context context, long j10, String str) {
        if (context == null) {
            return "";
        }
        String strM83086h = C13843a.m83086h(context, j10);
        return (m1278l2(str) && !TextUtils.isEmpty(strM83086h)) ? strM83086h.replace(" ", " ") : strM83086h;
    }

    /* renamed from: r0 */
    public static String m1300r0(Context context, String[] strArr) {
        if (context == null) {
            AbstractC10896a.m65887i("BaseUtil", "getSyncConfigPackageName, context is null");
            return "";
        }
        if (strArr == null || strArr.length <= 0) {
            AbstractC10896a.m65887i("BaseUtil", "getSyncConfigPackageName, packageNames is empty");
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && m1221W1(context, str)) {
                return str;
            }
        }
        AbstractC10896a.m65887i("BaseUtil", "getSyncConfigPackageName, packageName: ");
        return "";
    }

    /* renamed from: r1 */
    public static boolean m1301r1(Context context) {
        Object objM1178I0 = m1178I0(f780e, C0224k0.m1538H(context), m1178I0(f781f, UserHandle.class, new Object[0]));
        int iIntValue = objM1178I0 instanceof Integer ? ((Integer) objM1178I0).intValue() : 0;
        AbstractC10896a.m65887i("BaseUtil", "isLocked passwordQuality = " + iIntValue);
        return iIntValue >= 65536;
    }

    /* renamed from: r2 */
    public static void m1302r2(Intent intent, String str) {
        C9738a.m60790a(intent, str);
    }

    /* renamed from: s */
    public static String m1303s(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "formatSring err:" + e10.toString());
            return str;
        }
    }

    /* renamed from: s0 */
    public static int m1304s0(Context context, String str) {
        int i10 = 0;
        try {
            i10 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getInt("sync-sdk-version");
            AbstractC10896a.m65887i("BaseUtil", "getSyncSdkVersion, packageName: " + str + ", sdkVersion = " + i10);
            return i10;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "getSyncSdkVersion, " + e10.toString());
            return i10;
        }
    }

    /* renamed from: s1 */
    public static boolean m1305s1() {
        return m1269j1() && C0219i.m1463a() >= 33;
    }

    /* renamed from: s2 */
    public static void m1306s2(ActionBar actionBar, Activity activity, int i10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (activity != null) {
            try {
                Class<?> cls = Class.forName("com.huawei.android.app.ActionBarEx");
                cls.getDeclaredMethod("setAppbarBackground", ActionBar.class, Drawable.class).invoke(cls, actionBar, new ColorDrawable(i10));
            } catch (ClassNotFoundException unused) {
                AbstractC10896a.m65886e("BaseUtil", "ClassNotFoundException");
            } catch (IllegalAccessException unused2) {
                AbstractC10896a.m65886e("BaseUtil", "IllegalAccessException");
            } catch (NoSuchMethodException unused3) {
                AbstractC10896a.m65886e("BaseUtil", "NoSuchMethodException");
            } catch (InvocationTargetException unused4) {
                AbstractC10896a.m65886e("BaseUtil", "InvocationTargetException");
            }
        }
    }

    /* renamed from: t */
    public static String m1307t() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: t0 */
    public static int m1308t0(String str) {
        Resources system = Resources.getSystem();
        if (system != null) {
            return system.getIdentifier(str, "id", OsType.ANDROID);
        }
        return 0;
    }

    /* renamed from: t1 */
    public static boolean m1309t1(Context context) {
        if (context == null) {
            return false;
        }
        return m1176H1(context, context.getPackageName());
    }

    /* renamed from: t2 */
    public static boolean m1310t2(Context context, List<String> list, int i10) {
        Iterator<String> it = list.iterator();
        boolean zM1334z2 = true;
        while (it.hasNext()) {
            zM1334z2 &= m1334z2(context, it.next(), i10);
        }
        return zM1334z2;
    }

    /* renamed from: u */
    public static Bitmap m1311u(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("BaseUtil", "getBitmapFromFile filePath is null");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        C1248a.m7473d(str, options);
        if (options.outHeight <= 0 || options.outWidth <= 0) {
            return null;
        }
        options.inJustDecodeBounds = false;
        return C1248a.m7473d(str, options);
    }

    /* renamed from: u0 */
    public static int m1312u0() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: u1 */
    public static boolean m1313u1(int i10) {
        return i10 == 7 || i10 == 2 || i10 == 4 || i10 == 11 || i10 == 1 || i10 == 16;
    }

    /* renamed from: u2 */
    public static void m1314u2(Context context, Dialog dialog) throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !C12806c.m76815f(context)) {
            return;
        }
        if (context == null || dialog == null) {
            AbstractC10896a.m65886e("BaseUtil", "setCutoutMode context or activity null");
            return;
        }
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        try {
            attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, 1);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "setCutoutMode exception:" + e10.toString());
        }
        dialog.getWindow().setAttributes(attributes);
    }

    /* renamed from: v */
    public static String m1315v() {
        String strM1323x = m1323x();
        if (TextUtils.isEmpty(strM1323x)) {
            strM1323x = Build.DISPLAY;
        }
        return !Pattern.matches("[^<>|:*?\"/\\\\]*", strM1323x) ? "unknown" : strM1323x;
    }

    /* renamed from: v0 */
    public static String m1316v0() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: v1 */
    public static boolean m1317v1(int i10) {
        return i10 == 5 || i10 == 6 || i10 == 12 || i10 == 8 || i10 == 9 || i10 == 3 || i10 == 14 || i10 == 10 || i10 == 15 || i10 == 17;
    }

    /* renamed from: v2 */
    public static void m1318v2(Context context) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        try {
            if (m1198P(context)) {
                return;
            }
            AbstractC10896a.m65887i("BaseUtil", "setHiCloudOOBEFinish");
            Settings.Secure.putInt(applicationContext.getContentResolver(), "HwCloudPage", 100);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "Settings.Secure.putInt exception: " + e10.getMessage());
        }
    }

    /* renamed from: w */
    public static String m1319w() {
        String strM1323x = m1323x();
        return TextUtils.isEmpty(strM1323x) ? Build.DISPLAY : strM1323x;
    }

    /* renamed from: w0 */
    public static int m1320w0(NetworkInfo networkInfo) {
        String subtypeName = networkInfo.getSubtypeName();
        if (TextUtils.isEmpty(subtypeName)) {
            return 0;
        }
        return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 0;
    }

    /* renamed from: w1 */
    public static boolean m1321w1(int i10) {
        return i10 == 13 || i10 == 18 || i10 == 19;
    }

    /* renamed from: w2 */
    public static void m1322w2(Context context) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        try {
            Settings.Secure.putInt(applicationContext.getContentResolver(), "HwCloudPage", 0);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "Settings.Secure.putInt exception: " + e10.getMessage());
        }
    }

    /* renamed from: x */
    public static String m1323x() {
        if (!TextUtils.isEmpty(f785j)) {
            return f785j;
        }
        String strM1573b = C0224k0.a.m1573b("ro.huawei.build.display.id", "");
        f785j = strM1573b;
        return strM1573b;
    }

    /* renamed from: x0 */
    public static String m1324x0() throws NoSuchMethodException, SecurityException {
        if (!C0211e.m1344c().m1347d()) {
            return "";
        }
        if (!TextUtils.isEmpty(f790o)) {
            return f790o;
        }
        try {
            Method method = (m1277l1() ? Class.forName("com.hihonor.android.os.Build") : Class.forName("com.huawei.android.os.BuildEx")).getMethod("getUDID", new Class[0]);
            AccessController.doPrivileged(f792q);
            f790o = (String) method.invoke(null, new Object[0]);
        } catch (Exception unused) {
            AbstractC10896a.m65887i("BaseUtil", "old phone getUDID udid err.");
        }
        return f790o;
    }

    /* renamed from: x1 */
    public static boolean m1325x1(int i10) {
        return i10 == 20;
    }

    /* renamed from: x2 */
    public static void m1326x2() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = f791p;
        if (j10 == 0 || jCurrentTimeMillis - j10 > C5863b6.g.f26453g) {
            AbstractC10896a.m65887i("BaseUtil", "set sRestoreUpdateFailTime: " + f791p);
            f791p = jCurrentTimeMillis;
        }
    }

    /* renamed from: y */
    public static String m1327y() {
        if (!TextUtils.isEmpty(f788m)) {
            return f788m;
        }
        String strM1573b = C0224k0.a.m1573b("ro.build.characteristics", "");
        f788m = strM1573b;
        return strM1573b;
    }

    /* renamed from: y0 */
    public static String m1328y0(Context context) {
        if (context == null) {
            return "";
        }
        String strM1207S = m1207S();
        AbstractC10896a.m65885d("BaseUtil", " productRegion");
        if ("CN".equalsIgnoreCase(strM1207S)) {
            return strM1207S;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String upperCase = telephonyManager.getNetworkCountryIso().toUpperCase(Locale.getDefault());
        String upperCase2 = telephonyManager.getSimCountryIso().toUpperCase(Locale.getDefault());
        boolean z10 = (telephonyManager.getSimState() != 5 || TextUtils.isEmpty(upperCase2) || TextUtils.isEmpty(upperCase)) ? false : true;
        AbstractC10896a.m65885d("BaseUtil", "isSimReady:" + z10 + " simRegion:" + upperCase2 + " visitRegion:" + upperCase);
        if (z10 && upperCase2.equals(upperCase)) {
            return upperCase2;
        }
        String country = Locale.getDefault().getCountry();
        AbstractC10896a.m65885d("BaseUtil", "settingRegion:" + country);
        return (!z10 || TextUtils.isEmpty(country)) ? (z10 || TextUtils.isEmpty(country)) ? (z10 || !TextUtils.isEmpty(country)) ? "" : strM1207S : country : m1255g(country, upperCase2, upperCase);
    }

    /* renamed from: y1 */
    public static boolean m1329y1() {
        long jCurrentTimeMillis = System.currentTimeMillis() - m1332z0();
        if (m1269j1()) {
            if (jCurrentTimeMillis < 86400000) {
                return false;
            }
        } else if (jCurrentTimeMillis < 604800000) {
            return false;
        }
        return true;
    }

    /* renamed from: y2 */
    public static void m1330y2() {
        C0212e0.m1370t(C0213f.m1377a(), "reqUpdateAppTime", Utils.REQUEST_TIME, System.currentTimeMillis());
    }

    /* renamed from: z */
    public static int m1331z(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("BaseUtil", "getCodeByMessage errorMessage is empty");
            return -1;
        }
        int iIndexOf = str.indexOf("(");
        int iIndexOf2 = str.indexOf(")");
        if (iIndexOf < 0 || iIndexOf2 < 0) {
            return -1;
        }
        try {
            return Integer.parseInt(str.substring(iIndexOf, iIndexOf2).substring(1));
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: z0 */
    public static long m1332z0() {
        return C0212e0.m1359i(C0213f.m1377a(), "reqUpdateAppTime", "update_apk_time", 0L);
    }

    /* renamed from: z1 */
    public static boolean m1333z1(Context context) {
        if (context == null) {
            AbstractC10896a.m65886e("BaseUtil", "isNetWorkConnected:context is null");
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AbstractC10896a.m65886e("BaseUtil", "isNetWorkConnected:ConnectivityManager is null");
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities != null && networkCapabilities.hasCapability(12);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "isNetWorkConnected error." + e10.toString());
            return false;
        }
    }

    /* renamed from: z2 */
    public static boolean m1334z2(Context context, String str, int i10) {
        AbstractC10896a.m65885d("BaseUtil", "setSettingsInt: " + str + ", " + i10);
        if (context == null) {
            AbstractC10896a.m65886e("BaseUtil", "setSettingsInt context is null");
            return false;
        }
        try {
            return Settings.Secure.putInt(context.getContentResolver(), str, i10);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BaseUtil", "setSettingsInt ex" + e10.toString());
            return false;
        }
    }
}
