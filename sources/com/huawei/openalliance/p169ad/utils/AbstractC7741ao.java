package com.huawei.openalliance.p169ad.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7020di;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7205hz;
import com.huawei.openalliance.p169ad.C7208ib;
import com.huawei.openalliance.p169ad.C7209ic;
import com.huawei.openalliance.p169ad.C7211ie;
import com.huawei.openalliance.p169ad.C7217ik;
import com.huawei.openalliance.p169ad.C7218il;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.InterfaceC7316iq;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.opendevice.open.TransparencyStatementActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.openalliance.ad.utils.ao */
/* loaded from: classes2.dex */
public abstract class AbstractC7741ao {

    /* renamed from: a */
    private static final Map<Integer, Integer> f35829a;

    static {
        HashMap map = new HashMap();
        f35829a = map;
        map.put(2, 9);
        map.put(3, 10);
        map.put(4, 11);
    }

    /* renamed from: a */
    public static int m47534a(Context context) {
        StringBuilder sb2;
        String str;
        try {
            String strM48289a = AbstractC7811dd.m48289a("ro.build.version.emui");
            if (TextUtils.isEmpty(strM48289a)) {
                return 0;
            }
            String strM47544a = m47544a("^EmotionUI_[0-9]+", strM48289a);
            return !TextUtils.isEmpty(strM47544a) ? m47558b(false, strM47544a) : m47558b(true, m47544a("^MagicUI_[0-9]+", strM48289a));
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "getEmuiVersion RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("HiAdTools", sb2.toString());
            return 0;
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "getEmuiVersion Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("HiAdTools", sb2.toString());
            return 0;
        }
    }

    /* renamed from: b */
    public static int m47557b(Context context, float f10) {
        if (context == null || f10 <= 0.0f) {
            return 0;
        }
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: c */
    public static int m47565c(Context context, float f10) {
        if (context != null && f10 > 0.0f) {
            return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m47570d(Context context, float f10) {
        if (context == null || f10 <= 0.0f) {
            return 0;
        }
        return (int) ((f10 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: e */
    public static boolean m47575e() {
        return AbstractC7791ck.m48070c(Constants.CONSENT_SDK) && AbstractC7791ck.m48067a(Constants.CONSENT_SDK, Constants.CONSENT_SYNC, (Class<?>[]) null);
    }

    /* renamed from: f */
    public static Integer m47578f(Context context) {
        Integer numM47805a = C7767bn.m47805a(context, C7830i.m48434e(context.getApplicationContext()), "ppskit_ver_code");
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("HiAdTools", "ppsKitVerCode:%s", numM47805a);
        }
        return numM47805a;
    }

    /* renamed from: g */
    public static Integer m47581g(Context context) {
        Integer numM47805a = C7767bn.m47805a(context, context.getApplicationContext().getPackageName(), "hw_ads_sdk_type");
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("HiAdTools", "sdkType:%s", numM47805a);
        }
        return numM47805a;
    }

    /* renamed from: h */
    public static int m47583h(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", OsType.ANDROID);
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HiAdTools", "getStatusBarHeight err: %s", th2.getClass().getSimpleName());
            return 0;
        }
    }

    /* renamed from: i */
    public static void m47585i(Context context) {
        if (context != null && C6982bz.m41152b(context)) {
            C7484ms.m45854a(context).m45855a(RTCMethods.REMOVE_EXSPLASH_BLOCK, null, null, null);
        }
    }

    /* renamed from: j */
    public static boolean m47587j() {
        return true;
    }

    /* renamed from: k */
    public static boolean m47589k(Context context) {
        try {
            Intent intent = new Intent(Constants.GMS_AD_SETTING_ACTION);
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.setPackage(Constants.GMS_PGK);
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("HiAdTools", "open GMS ads setting exception.");
            return false;
        }
    }

    /* renamed from: l */
    public static boolean m47590l(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("uimode");
        return (systemService instanceof UiModeManager) && ((UiModeManager) systemService).getNightMode() == 2;
    }

    /* renamed from: m */
    public static float m47591m(Context context) {
        Configuration configuration;
        if (context == null) {
            return -1.0f;
        }
        float fM47596r = m47596r(context);
        if (fM47596r > 0.0f) {
            return fM47596r;
        }
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return -1.0f;
        }
        return configuration.fontScale;
    }

    /* renamed from: n */
    public static boolean m47592n(Context context) {
        return m47591m(context) >= 1.75f;
    }

    /* renamed from: o */
    public static boolean m47593o(Context context) {
        return m47591m(context) >= 1.3f;
    }

    /* renamed from: p */
    public static boolean m47594p(Context context) {
        if (m47562b(context)) {
            return C7124fh.m43316b(context).mo43345aL();
        }
        return false;
    }

    /* renamed from: q */
    public static boolean m47595q(Context context) {
        return AbstractC7807d.m48223c(context) >= 600;
    }

    /* renamed from: r */
    private static float m47596r(Context context) {
        try {
            return Settings.System.getFloat(context.getContentResolver(), "font_scale", -1.0f);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HiAdTools", "get font err: %s", th2.getClass().getSimpleName());
            return -1.0f;
        }
    }

    /* renamed from: a */
    public static int m47535a(Context context, float f10) {
        if (context != null && f10 > 0.0f) {
            return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x001f  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m47558b(boolean r2, java.lang.String r3) throws java.lang.NumberFormatException {
        /*
            boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r3)
            if (r0 != 0) goto L1f
            java.lang.String r0 = "_"
            java.lang.String[] r3 = r3.split(r0)
            int r0 = r3.length
            r1 = 2
            if (r0 != r1) goto L1f
            r0 = 1
            r3 = r3[r0]     // Catch: java.lang.NumberFormatException -> L18
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L18
            goto L20
        L18:
            java.lang.String r3 = "HiAdTools"
            java.lang.String r0 = "get emui version error!"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r3, r0)
        L1f:
            r3 = 0
        L20:
            if (r2 == 0) goto L28
            r0 = 4
            if (r3 <= r0) goto L28
            r2 = 11
            return r2
        L28:
            if (r2 == 0) goto L45
            java.util.Map<java.lang.Integer, java.lang.Integer> r2 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.f35829a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            boolean r0 = r2.containsKey(r0)
            if (r0 == 0) goto L45
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            return r2
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47558b(boolean, java.lang.String):int");
    }

    /* renamed from: c */
    public static long m47566c() {
        return System.currentTimeMillis();
    }

    /* renamed from: d */
    private static String m47571d(String str) {
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HiAdTools", "decode failed");
            return "";
        }
    }

    /* renamed from: e */
    public static boolean m47576e(Context context) {
        if (context == null) {
            return false;
        }
        Integer numM47578f = m47578f(context);
        if (numM47578f != null && numM47578f.intValue() >= 30466100) {
            return true;
        }
        AbstractC7185ho.m43820b("HiAdTools", "hms version is too low to support query ins app.");
        return false;
    }

    /* renamed from: f */
    public static boolean m47579f() {
        boolean z10 = AbstractC7791ck.m48069b(Constants.NETWORK_CLIENT_CLASS) && AbstractC7791ck.m48069b(Constants.NETWORK_REQ_BODY_PROVIDER);
        return !z10 ? AbstractC7791ck.m48070c(Constants.NETWORK_CLIENT_CLASS) && AbstractC7791ck.m48070c(Constants.NETWORK_REQ_BODY_PROVIDER) : z10;
    }

    /* renamed from: g */
    public static boolean m47582g() {
        return !TextUtils.isEmpty(C7084e.m42836a());
    }

    /* renamed from: h */
    public static boolean m47584h() {
        return AbstractC7806cz.m48145a(C7084e.m42836a(), -111111) >= 30470106;
    }

    /* renamed from: i */
    public static boolean m47586i() {
        return AbstractC7806cz.m48145a(C7084e.m42836a(), -111111) >= 30476300;
    }

    /* renamed from: j */
    public static boolean m47588j(Context context) {
        String strM48250m = AbstractC7807d.m48250m(context);
        Integer numM48178h = AbstractC7806cz.m48178h(strM48250m);
        if (numM48178h != null && numM48178h.intValue() >= 40000300) {
            return true;
        }
        AbstractC7185ho.m43821b("HiAdTools", "hms not installed or low version, current version: %s", strM48250m);
        return false;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    public static Intent m47536a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(broadcastReceiver, intentFilter, 2) : context.registerReceiver(broadcastReceiver, intentFilter);
    }

    /* renamed from: b */
    public static long m47559b() {
        long jMaxMemory = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("HiAdTools", "unUsedMemory is: %s", String.valueOf(jMaxMemory));
        }
        return jMaxMemory;
    }

    /* renamed from: c */
    public static String m47567c(String str) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("HiAdTools", "filterUrl, originUrl: %s", str);
        }
        return TextUtils.isEmpty(str) ? str : str.replace(" ", "");
    }

    /* renamed from: d */
    public static boolean m47572d() {
        try {
            return new C7744ar().m47602a();
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("HiAdTools", "check okhttp error:%s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: e */
    private static boolean m47577e(Context context, String str) {
        if (!AbstractC7806cz.m48181j(str)) {
            AbstractC7185ho.m43823c("HiAdTools", "url is invalid");
            return false;
        }
        Boolean boolMo44062o = HiAd.m44014a(context).mo44062o();
        if (boolMo44062o != null && boolMo44062o.booleanValue()) {
            AbstractC7185ho.m43817a("HiAdTools", "try open in browser");
            if (m47569c(context, str)) {
                AbstractC7185ho.m43817a("HiAdTools", "open in browser success");
                return true;
            }
        }
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setClass(context, TransparencyStatementActivity.class);
        intent.putExtra(MapKeyNames.DSA_URL, str);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        AbstractC7811dd.m48294a(context, intent);
        return true;
    }

    /* renamed from: f */
    private static boolean m47580f(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = "processWhyEvent context is null, return";
        } else {
            if (!C6982bz.m41148a(context).mo41175d()) {
                if (Constants.WHY_THIS_AD_DEFAULT_URL.equalsIgnoreCase(str)) {
                    str = Constants.THIRD_ADINFO_DP + context.getPackageName();
                }
                if (!AbstractC7806cz.m48165b(str)) {
                    AbstractC7185ho.m43818a("HiAdTools", "processWhyEvent url = %s", str);
                    return AbstractC7806cz.m48181j(str) ? m47550a(context, str) : m47574d(context, str);
                }
                String str3 = Constants.THIRD_ADINFO_DP + context.getPackageName();
                AbstractC7185ho.m43817a("HiAdTools", "processWhyEvent cloud download url is empty, use default!");
                return m47574d(context, str3);
            }
            str2 = "china rom should not call gotoWhyThisAdPage method";
        }
        AbstractC7185ho.m43823c("HiAdTools", str2);
        return false;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    public static Intent m47537a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (context == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, 2) : context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    /* renamed from: b */
    private static String m47560b(ContentRecord contentRecord) {
        String strM41490al = contentRecord.m41490al();
        if (TextUtils.isEmpty(strM41490al)) {
            strM41490al = contentRecord.m41476aa();
        }
        return m47571d(strM41490al);
    }

    /* renamed from: c */
    public static boolean m47568c(Context context) {
        if (context == null) {
            return false;
        }
        Integer numM47578f = m47578f(context);
        if (numM47578f != null && numM47578f.intValue() >= 30445100) {
            return true;
        }
        AbstractC7185ho.m43820b("HiAdTools", "hms version is too low to support switch next install way.");
        return false;
    }

    /* renamed from: d */
    public static boolean m47573d(Context context) {
        if (context == null) {
            return false;
        }
        Integer numM47578f = m47578f(context);
        if (numM47578f != null && numM47578f.intValue() >= 30462300) {
            return true;
        }
        AbstractC7185ho.m43820b("HiAdTools", "hms version is too low to support kit preload.");
        return false;
    }

    /* renamed from: a */
    public static Cursor m47538a(Context context, Uri uri) {
        if (context == null || uri == null || !m47563b(context, uri)) {
            return null;
        }
        return context.getContentResolver().query(uri, null, null, null, null);
    }

    /* renamed from: b */
    public static String m47561b(String str) {
        return m47545a(str).format(new Date());
    }

    /* renamed from: c */
    private static boolean m47569c(Context context, String str) {
        String str2;
        if (context == null || !AbstractC7806cz.m48181j(str)) {
            str2 = "param is error, return";
        } else {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                if (AbstractC7760bg.m47767a(packageManager.queryIntentActivities(intent, 65536))) {
                    AbstractC7185ho.m43823c("HiAdTools", "No any browser installed");
                    return false;
                }
                intent.setFlags(268468224);
                context.startActivity(intent);
                return true;
            } catch (Throwable th2) {
                str2 = "openLinkInBrowser " + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43823c("HiAdTools", str2);
        return false;
    }

    /* renamed from: d */
    private static boolean m47574d(Context context, String str) {
        String str2;
        if (AbstractC7806cz.m48165b(str)) {
            str2 = "openLinkByDeepLink deepLinkUrl is null, return";
        } else {
            try {
                Intent intent = new Intent();
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                intent.setPackage(context.getPackageName());
                intent.setData(Uri.parse(str));
                intent.setClipData(Constants.CLIP_DATA);
                context.startActivity(intent);
                return true;
            } catch (Throwable th2) {
                str2 = "openLinkByDeepLink " + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43823c("HiAdTools", str2);
        return false;
    }

    /* renamed from: a */
    public static String m47539a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: b */
    public static boolean m47562b(Context context) {
        if (context == null) {
            return false;
        }
        if (C6982bz.m41148a(context).mo41175d() || !C6982bz.m41152b(context)) {
            return true;
        }
        String strM48207a = AbstractC7807d.m48207a(context, C7830i.m48434e(context));
        Integer numM48178h = AbstractC7806cz.m48178h(strM48207a);
        if (numM48178h != null && numM48178h.intValue() >= 40000300) {
            return true;
        }
        AbstractC7185ho.m43820b("HiAdTools", "hms is not installed or hms version is too low, version is: " + strM48207a);
        return false;
    }

    /* renamed from: a */
    public static String m47540a(Context context, VideoInfo videoInfo) {
        if (context == null || videoInfo == null || TextUtils.isEmpty(videoInfo.getVideoDownloadUrl())) {
            return null;
        }
        String videoDownloadUrl = videoInfo.getVideoDownloadUrl();
        if (videoDownloadUrl.startsWith(Scheme.CONTENT.toString())) {
            AbstractC7185ho.m43820b("HiAdTools", "start with content");
            return videoDownloadUrl;
        }
        C7022dk c7022dkM41937a = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        return c7022dkM41937a.m41968c(c7022dkM41937a.m41970e(videoInfo.getVideoDownloadUrl()));
    }

    /* renamed from: b */
    public static boolean m47563b(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            AbstractC7185ho.m43826d("HiAdTools", "Invalid param");
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        AbstractC7185ho.m43820b("HiAdTools", "Target provider service's package name is : " + str);
        if (str == null) {
            return false;
        }
        boolean z10 = packageManager.checkSignatures(context.getPackageName(), str) == 0 || (applicationInfo.flags & 1) == 1;
        if (z10) {
            return z10;
        }
        String strM48435e = C7830i.m48435e(context, str);
        boolean zIsEmpty = TextUtils.isEmpty(strM48435e);
        AbstractC7185ho.m43821b("HiAdTools", "is sign empty: %s", Boolean.valueOf(zIsEmpty));
        return !zIsEmpty ? WhiteListPkgList.isTrustApp(context, str, strM48435e) : z10;
    }

    /* renamed from: a */
    public static String m47541a(Context context, VideoInfo videoInfo, InterfaceC7316iq interfaceC7316iq) {
        return m47542a(context, videoInfo, interfaceC7316iq, Constants.NATIVE_CACHE);
    }

    /* renamed from: b */
    public static boolean m47564b(Context context, String str) {
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43823c("HiAdTools", "openHmsSetting, deepLink is empty.");
        }
        try {
            Intent intent = new Intent();
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.setPackage(C7830i.m48434e(context));
            intent.setData(Uri.parse(str));
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HiAdTools", "openHmsSetting error: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static String m47542a(Context context, VideoInfo videoInfo, InterfaceC7316iq interfaceC7316iq, String str) {
        C7208ib c7208ib;
        if (context == null || videoInfo == null || !m47579f()) {
            return null;
        }
        AbstractC7185ho.m43818a("HiAdTools", "getProxyUrl for: %s", AbstractC7819dl.m48375a(videoInfo.m44586g()));
        Context applicationContext = context.getApplicationContext();
        try {
            C7217ik.m43940a(applicationContext);
            C7211ie.m43919a().m43924b();
            C7218il c7218il = new C7218il(new C7205hz(applicationContext, str), new C7020di(applicationContext, str));
            c7218il.m43946a();
            C7209ic c7209ic = new C7209ic(applicationContext, c7218il, C7217ik.m43939a(), interfaceC7316iq);
            c7209ic.m43912a(applicationContext);
            c7208ib = new C7208ib(applicationContext, c7218il, c7209ic);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HiAdTools", "CreativeHttpServer boot failed, error: %s", th2.getClass().getSimpleName());
            c7208ib = null;
        }
        if (c7208ib == null) {
            return null;
        }
        return c7208ib.m43908a(videoInfo);
    }

    /* renamed from: a */
    private static String m47543a(IAd iAd) {
        String adChoiceUrl = iAd.getAdChoiceUrl();
        if (TextUtils.isEmpty(adChoiceUrl)) {
            adChoiceUrl = iAd.getWhyThisAd();
        }
        return m47571d(adChoiceUrl);
    }

    /* renamed from: a */
    private static String m47544a(String str, String str2) {
        String strGroup = "";
        try {
            Matcher matcher = Pattern.compile(str).matcher(str2);
            if (matcher.find()) {
                strGroup = matcher.group(0);
            } else {
                AbstractC7185ho.m43824c("HiAdTools", "can not find versionName: %s by pattern: %s", str2, str);
            }
        } catch (RuntimeException e10) {
            AbstractC7185ho.m43827d("HiAdTools", "getVersionByPattern RuntimeException: %s", e10.getClass().getSimpleName());
        } catch (Exception e11) {
            AbstractC7185ho.m43827d("HiAdTools", "getVersionByPattern Exception: %s", e11.getClass().getSimpleName());
        }
        return strGroup;
    }

    /* renamed from: a */
    public static SimpleDateFormat m47545a(String str) {
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH);
        } catch (Throwable unused) {
            return new SimpleDateFormat(str);
        }
    }

    /* renamed from: a */
    public static Date m47546a(Date date, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - i10);
        calendar.set(11, 24);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    /* renamed from: a */
    public static List<ActivityManager.RunningTaskInfo> m47547a(ActivityManager activityManager) {
        if (activityManager == null) {
            return null;
        }
        return activityManager.getRunningTasks(10);
    }

    /* renamed from: a */
    public static boolean m47548a(Context context, ContentRecord contentRecord) {
        if (context == null || contentRecord == null) {
            return false;
        }
        boolean zM41517bd = contentRecord.m41517bd();
        String strM41516bc = contentRecord.m41516bc();
        return m47554a(zM41517bd, strM41516bc) ? m47577e(context, strM41516bc) : m47580f(context, m47560b(contentRecord));
    }

    /* renamed from: a */
    public static boolean m47549a(Context context, IAd iAd) {
        if (context == null || iAd == null) {
            return false;
        }
        boolean zIsTransparencyOpen = iAd.isTransparencyOpen();
        String transparencyTplUrl = iAd.getTransparencyTplUrl();
        return m47554a(zIsTransparencyOpen, transparencyTplUrl) ? m47577e(context, transparencyTplUrl) : m47580f(context, m47543a(iAd));
    }

    /* renamed from: a */
    public static boolean m47550a(Context context, String str) {
        String str2;
        if (AbstractC7806cz.m48181j(str)) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268468224);
                AbstractC7811dd.m48294a(context, intent);
                return true;
            } catch (Throwable th2) {
                str2 = "openLinkInBrowser " + th2.getClass().getSimpleName();
            }
        } else {
            str2 = "url is error, return";
        }
        AbstractC7185ho.m43823c("HiAdTools", str2);
        return false;
    }

    /* renamed from: a */
    public static boolean m47551a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return false;
        }
        return contentRecord.m41464aP() == 3 || contentRecord.m41392E() == 99;
    }

    /* renamed from: a */
    public static boolean m47552a(AdLandingPageData adLandingPageData) {
        return (adLandingPageData == null || !adLandingPageData.isShowPageTitle() || AbstractC7558os.m46467f(adLandingPageData.m44290f()) != 3 || adLandingPageData.getAppInfo() == null || TextUtils.isEmpty(adLandingPageData.getAppInfo().getAppName())) ? false : true;
    }

    /* renamed from: a */
    public static boolean m47553a(VideoInfo videoInfo) {
        return videoInfo != null && 3 == videoInfo.getVideoPlayMode();
    }

    /* renamed from: a */
    public static boolean m47554a(boolean z10, String str) {
        AbstractC7185ho.m43821b("HiAdTools", "dsa switch on:%s, url:%s", Boolean.valueOf(z10), AbstractC7819dl.m48375a(str));
        return z10 && !AbstractC7806cz.m48165b(str);
    }

    /* renamed from: a */
    public static boolean m47555a(boolean z10, boolean z11, String str) {
        return z10 && z11 && !AbstractC7806cz.m48165b(str);
    }

    /* renamed from: a */
    public static boolean m47556a(int[] iArr, int i10) {
        return iArr != null && iArr.length == i10;
    }
}
