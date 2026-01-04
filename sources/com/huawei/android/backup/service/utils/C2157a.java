package com.huawei.android.backup.service.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.wifi.WiFiUnit;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import java.io.File;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p006a5.AbstractC0048c;
import p029b5.C1111d;
import p029b5.C1113f;
import p029b5.C1116i;
import p229di.C9137b;
import p229di.C9138c;
import p229di.C9142g;
import p544p4.C12086a;
import p699v4.C13334c;
import p699v4.C13345n;
import p699v4.C13348q;
import p699v4.C13349r;
import p728w4.C13527a;
import p728w4.C13529c;
import p832z4.C14127a;

/* renamed from: com.huawei.android.backup.service.utils.a */
/* loaded from: classes.dex */
public class C2157a {

    /* renamed from: a */
    public static final String f9768a;

    /* renamed from: b */
    public static Set<String> f9769b;

    /* renamed from: c */
    public static Set<String> f9770c;

    /* renamed from: d */
    public static Set<String> f9771d;

    /* renamed from: e */
    public static Set<String> f9772e;

    /* renamed from: f */
    public static Set<String> f9773f;

    /* renamed from: g */
    public static Set<String> f9774g;

    /* renamed from: h */
    public static Set<String> f9775h;

    /* renamed from: i */
    public static Set<String> f9776i;

    /* renamed from: j */
    public static HashMap<String, Set<String>> f9777j;

    /* renamed from: k */
    public static final Set<String> f9778k;

    /* renamed from: l */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f9779l;

    /* renamed from: m */
    public static final Set<String> f9780m;

    static {
        f9768a = C9142g.m57463b() ? "content://com.hihonor.fastapp.provider.open/packageRecordList" : "content://com.huawei.fastapp.provider.open/packageRecordList";
        f9769b = null;
        f9770c = null;
        f9771d = null;
        f9772e = null;
        f9773f = null;
        f9774g = null;
        f9775h = null;
        f9776i = null;
        HashSet hashSet = new HashSet();
        f9778k = hashSet;
        HashSet hashSet2 = new HashSet(4);
        f9780m = hashSet2;
        hashSet2.add("soundrecorder");
        hashSet2.add("callRecorder");
        hashSet2.add("smartcare");
        hashSet2.add("chatSms");
        hashSet2.add("desktopMyFile");
        hashSet2.add("galleryData");
        hashSet.add("Form");
        hashSet.add("contactFA");
    }

    /* renamed from: A */
    public static boolean m13166A(Context context) {
        if (context == null) {
            C2111d.m12653i("BackupUtils", "hasGainedSystemPermission context is null.");
            return false;
        }
        if ("com.huawei.hidisk".equals(context.getPackageName())) {
            return true;
        }
        return m13192a(context, "android.permission.INSTALL_PACKAGES");
    }

    /* renamed from: B */
    public static boolean m13167B(Context context, String str, String str2) {
        Account[] accountsByType;
        AccountManager accountManager = AccountManager.get(context);
        if (accountManager == null || (accountsByType = accountManager.getAccountsByType(str2)) == null) {
            return false;
        }
        for (Account account : accountsByType) {
            if (account != null && account.name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: C */
    public static boolean m13168C() throws ClassNotFoundException {
        String str;
        Object objM13193a0;
        String str2 = "";
        try {
            Object objM13193a02 = m13193a0("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.language"});
            objM13193a0 = m13193a0("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP});
            str = objM13193a02 instanceof String ? (String) objM13193a02 : "";
        } catch (ClassCastException e10) {
            e = e10;
            str = "";
        }
        try {
            if (objM13193a0 instanceof String) {
                str2 = (String) objM13193a0;
            }
        } catch (ClassCastException e11) {
            e = e11;
            C2111d.m12657m("BackupUtils", "isChinaROM ClassCastException, error info = " + e.getMessage());
            if ("zh".equalsIgnoreCase(str)) {
            }
        }
        return !"zh".equalsIgnoreCase(str) && "cn".equalsIgnoreCase(str2);
    }

    /* renamed from: D */
    public static boolean m13169D(Object[] objArr) {
        return objArr == null || objArr.length <= 0;
    }

    /* renamed from: E */
    public static boolean m13170E(String... strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: F */
    public static boolean m13171F() {
        String strM57456c = C9138c.m57456c();
        if (strM57456c == null || strM57456c.isEmpty()) {
            return false;
        }
        String strM57454a = C9138c.m57454a();
        C2111d.m12646b("BackupUtils", "isEmuiOS emuiName: " + strM57454a + " ,osBrand: " + strM57456c);
        return strM57456c.equals(strM57454a);
    }

    /* renamed from: G */
    public static boolean m13172G(Context context) {
        int count;
        Cursor cursorM12618d = null;
        try {
            try {
                cursorM12618d = C2108a.m12618d(context, Uri.parse(f9768a), null, null, null, null);
                count = cursorM12618d != null ? cursorM12618d.getCount() : -1;
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
            } catch (Exception unused) {
                C2111d.m12648d("BackupUtils", "Get fast app numbers failed.");
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                count = -1;
            }
            C2111d.m12653i("BackupUtils", "fast app total num = " + count);
            return count == -1 || count > 0;
        } catch (Throwable th2) {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
            throw th2;
        }
    }

    /* renamed from: H */
    public static boolean m13173H(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        if (context == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(Constants.GMS_PGK, 0);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            packageInfo = null;
        }
        boolean z10 = packageInfo != null;
        C2111d.m12654j("BackupUtils", "isGmsInstalled, isInstall ", Boolean.valueOf(z10), ", GMS Version ", C13529c.m81423a("ro.com.google.gmsversion"));
        return z10;
    }

    /* renamed from: I */
    public static boolean m13174I(String str) {
        if (f9779l != null) {
            return !m13185T(r0, str);
        }
        C2111d.m12648d("BackupUtils", "isGreyApp, applicationContext is null");
        return false;
    }

    /* renamed from: J */
    public static boolean m13175J() {
        String strM57456c = C9138c.m57456c();
        if (strM57456c == null || strM57456c.isEmpty()) {
            return false;
        }
        String strM57455b = C9138c.m57455b();
        C2111d.m12646b("BackupUtils", "isHarmonyOS harmony: " + strM57455b + " ,osBrand: " + strM57455b);
        return strM57456c.equals(strM57455b);
    }

    /* renamed from: K */
    public static boolean m13176K() {
        return (m13175J() || m13171F()) && C13529c.m81425c(SystemProperties.HW_SC_BUILD_OS_ENABLE, false);
    }

    /* renamed from: L */
    public static boolean m13177L(Context context) {
        return m13166A(context);
    }

    /* renamed from: M */
    public static boolean m13178M() {
        return C9137b.m57451c("com.huawei.software.features.kidpad");
    }

    /* renamed from: N */
    public static boolean m13179N(Context context, String str, Set<String> set) {
        if (!m13177L(context)) {
            return true;
        }
        if (C13348q.m80082b(set)) {
            return false;
        }
        for (String str2 : set) {
            if (str2.equals(str) || str2.equals("GLOBAL")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: O */
    public static boolean m13180O(String str, Set<String> set) {
        return set != null && set.contains(str);
    }

    /* renamed from: P */
    public static boolean m13181P(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        if (packageManager == null) {
            return false;
        }
        try {
            packageManager.getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
            C2111d.m12648d("BackupUtils", "isPackageInstalled NameNotFoundException: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: Q */
    public static boolean m13182Q(Context context) {
        boolean zIsSmsCapable = false;
        if (context == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                zIsSmsCapable = telephonyManager.isSmsCapable();
            } catch (Resources.NotFoundException e10) {
                C2111d.m12648d("BackupUtils", "IsSmsCapable:" + e10.getMessage());
                zIsSmsCapable = true;
            }
        }
        C2111d.m12653i("BackupUtils", "Judge isSmsCapable:" + zIsSmsCapable);
        return zIsSmsCapable;
    }

    /* renamed from: R */
    public static boolean m13183R(Context context, String str) {
        return C13349r.m80087c() && m13218z(context).containsKey(str);
    }

    /* renamed from: S */
    public static boolean m13184S(Context context, Uri uri) {
        if (context == null || uri == null || uri.getAuthority() == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            C2111d.m12653i("BackupUtils", "not find uri: " + uri.toString());
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        C2111d.m12653i("BackupUtils", "provider packageName is: " + str);
        boolean z10 = (applicationInfo.flags & 1) == 1;
        C2111d.m12653i("BackupUtils", "isTargetAppSystemApp isSystemApp: " + z10);
        boolean z11 = (applicationInfo.flags & 128) != 0;
        C2111d.m12653i("BackupUtils", "isTargetAppSystemApp isUpdateSystemApp: " + z11);
        boolean z12 = packageManager.checkSignatures(str, context.getPackageName()) == 0;
        C2111d.m12653i("BackupUtils", "isTargetAppSystemApp isSameSignatures: " + z12);
        return z10 || z11 || z12;
    }

    /* renamed from: T */
    public static synchronized boolean m13185T(Context context, String str) {
        return m13218z(context).containsKey(str);
    }

    /* renamed from: U */
    public static boolean m13186U(Context context) {
        boolean zIsVoiceCapable = false;
        if (context == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                zIsVoiceCapable = telephonyManager.isVoiceCapable();
            } catch (Resources.NotFoundException e10) {
                C2111d.m12648d("BackupUtils", "IsVoiceCapable exception:" + e10.getMessage());
                zIsVoiceCapable = true;
            }
        }
        C2111d.m12653i("BackupUtils", "Judge isVoiceCapable:" + zIsVoiceCapable);
        return zIsVoiceCapable;
    }

    /* renamed from: V */
    public static ArrayList<String> m13187V(AbstractC0048c abstractC0048c, String str) {
        if (abstractC0048c == null) {
            C2111d.m12648d("BackupUtils", "readBackupDataFileList: storeHandler is null.");
            return null;
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s(str, null, null, null, null);
        if (contentValuesArrM200s == null) {
            C2111d.m12648d("BackupUtils", "readBackupDataFileList: restoreValues is null.");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (ContentValues contentValues : contentValuesArrM200s) {
            if (contentValues != null) {
                arrayList.add(contentValues.getAsString("value"));
            }
        }
        return arrayList;
    }

    /* renamed from: W */
    public static void m13188W(AccessibleObject accessibleObject, boolean z10) throws SecurityException {
        if (accessibleObject != null) {
            accessibleObject.setAccessible(z10);
        }
    }

    /* renamed from: X */
    public static void m13189X(Context context) {
        if (context == null) {
            return;
        }
        f9779l = context.getApplicationContext();
    }

    /* renamed from: Y */
    public static boolean m13190Y(Context context) throws IllegalAccessException, NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (context == null) {
            C2111d.m12657m("BackupUtils", "Context is null.");
            return false;
        }
        C2111d.m12653i("BackupUtils", "Apply for WRITE_SMS permission start");
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if (appOpsManager == null) {
                C2111d.m12657m("BackupUtils", "get AppOpsManager service failed!");
                return false;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 8192);
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("setMode", cls2, cls2, String.class, cls2);
            m13188W(declaredMethod, true);
            Integer num = (Integer) C13527a.m81406l("android.app.AppOpsManager").m81412e("OP_WRITE_SMS").m81413g();
            num.intValue();
            declaredMethod.invoke(appOpsManager, num, Integer.valueOf(packageInfo.applicationInfo.uid), packageName, 0);
            C2111d.m12653i("BackupUtils", "Apply for WRITE_SMS permission successfully!");
            return true;
        } catch (IllegalAccessException e10) {
            C2111d.m12657m("BackupUtils", "set mode failed, IllegalAccessException error info = " + e10.getMessage());
            return false;
        } catch (IllegalArgumentException e11) {
            C2111d.m12657m("BackupUtils", "set mode failed, IllegalArgumentException error info = " + e11.getMessage());
            return false;
        } catch (IllegalStateException e12) {
            C2111d.m12657m("BackupUtils", "set mode failed, IllegalStateException error info = " + e12.getMessage());
            return false;
        } catch (NoSuchMethodException e13) {
            C2111d.m12657m("BackupUtils", "set mode failed, NoSuchMethodException error info = " + e13.getMessage());
            return false;
        } catch (SecurityException e14) {
            C2111d.m12657m("BackupUtils", "set mode failed, SecurityException error info = " + e14.getMessage());
            return false;
        } catch (InvocationTargetException e15) {
            C2111d.m12657m("BackupUtils", "set mode failed, InvocationTargetException error info = " + e15.getMessage());
            return false;
        } catch (Exception unused) {
            C2111d.m12657m("BackupUtils", "set mode failed, Exception.");
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object m13191Z(java.lang.Class<?> r3, java.lang.String r4, java.lang.Class<?>[] r5, java.lang.Object[] r6) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            java.lang.String r0 = " staticFun:Exception!"
            java.lang.String r1 = "BackupUtils"
            r2 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Exception -> La java.lang.SecurityException -> Le java.lang.NoSuchMethodException -> L14
            goto L1a
        La:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r0)
            goto L19
        Le:
            java.lang.String r3 = " staticFun:SecurityException!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
            goto L19
        L14:
            java.lang.String r3 = " staticFun:NoSuchMethodException!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
        L19:
            r3 = r2
        L1a:
            if (r3 == 0) goto L36
            java.lang.Object r3 = r3.invoke(r2, r6)     // Catch: java.lang.Exception -> L21 java.lang.reflect.InvocationTargetException -> L25 java.lang.IllegalArgumentException -> L2b java.lang.IllegalAccessException -> L31
            return r3
        L21:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r0)
            goto L36
        L25:
            java.lang.String r3 = " staticFun:InvocationTargetException!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
            goto L36
        L2b:
            java.lang.String r3 = " staticFun:IllegalArgumentException!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
            goto L36
        L31:
            java.lang.String r3 = " staticFun:IllegalAccessException!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
        L36:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.utils.C2157a.m13191Z(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: a */
    public static boolean m13192a(Context context, String str) {
        boolean z10 = false;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                return false;
            }
            z10 = true;
            C2111d.m12646b("BackupUtils", "get permission : " + str);
            return true;
        } catch (WindowManager.BadTokenException unused) {
            C2111d.m12648d("BackupUtils", "can not get permission : " + str);
            return z10;
        }
    }

    /* renamed from: a0 */
    public static Object m13193a0(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws ClassNotFoundException {
        Class<?> cls;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C2111d.m12648d("BackupUtils", "invokeFun params invalid");
            return null;
        }
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
            C2111d.m12648d("BackupUtils", " staticFun:ClassNotFoundException!");
            cls = null;
        }
        if (cls != null) {
            return m13191Z(cls, str2, clsArr, objArr);
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m13194b(Context context, String str) {
        Uri uri;
        if (context == null || TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        return context.getPackageManager().resolveContentProvider(uri.getAuthority(), 65536) != null;
    }

    /* renamed from: c */
    public static void m13195c(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        for (String str : collection) {
            if (m13185T(C14127a.m84764d().m84768b(), str)) {
                hashSet.add(str);
            }
        }
        collection.removeAll(hashSet);
    }

    /* renamed from: d */
    public static ArrayList<String> m13196d(File file) {
        File[] fileArrListFiles;
        ArrayList<String> arrayList = new ArrayList<>();
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return arrayList;
        }
        if (fileArrListFiles.length == 0) {
            arrayList.add(C13334c.m79991x(file));
        } else {
            for (File file2 : fileArrListFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    ArrayList<String> arrayListM13196d = m13196d(file2);
                    if (arrayListM13196d.size() > 0) {
                        arrayList.addAll(arrayListM13196d);
                    }
                }
            }
        }
        return arrayList;
    }

    @TargetApi(24)
    /* renamed from: e */
    public static ArrayList<String> m13197e() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = LocaleList.getDefault().size();
        for (int i10 = 0; i10 < size; i10++) {
            Locale locale = LocaleList.getDefault().get(i10);
            if (locale != null) {
                arrayList.add(locale.getLanguage() + "-" + locale.getCountry());
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static synchronized Set<String> m13198f(Context context, String str, boolean z10) {
        try {
            Set<String> set = m13218z(context).containsKey(str) ? m13218z(context).get(str) : null;
            if (set == null) {
                return Collections.emptySet();
            }
            String strM72257d = z10 ? C12086a.m72257d(context) : C13345n.m80072k(context, 2);
            HashSet hashSet = new HashSet();
            for (String str2 : set) {
                if (str2.startsWith("external/")) {
                    hashSet.add(strM72257d + File.separator + str2.substring(9));
                }
            }
            return hashSet;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: g */
    public static synchronized Set<String> m13199g() {
        try {
            if (f9776i == null) {
                f9776i = BackupConstant.BackupObject.getBlocklistBackupObject();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f9776i;
    }

    /* renamed from: h */
    public static synchronized Set<String> m13200h() {
        if (!C13348q.m80082b(f9769b)) {
            return Collections.unmodifiableSet(f9769b);
        }
        C1111d.a aVarM84767a = C14127a.m84764d().m84767a();
        if (aVarM84767a == null) {
            C2111d.m12648d("BackupUtils", "blockListInfo load time out, set isAppEnable = false");
            C14127a.m84764d().m84775l(false);
            return new HashSet(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C1111d.b> it = aVarM84767a.f5294a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f5295a);
        }
        m13195c(arrayList);
        HashSet<String> hashSetM84765e = C14127a.m84765e();
        f9769b = hashSetM84765e;
        if (C13348q.m80084d(hashSetM84765e)) {
            f9769b.addAll(arrayList);
        } else {
            f9769b = new HashSet(arrayList);
        }
        return Collections.unmodifiableSet(f9769b);
    }

    /* renamed from: i */
    public static List<String> m13201i(File file) {
        ArrayList arrayList = new ArrayList();
        if (file != null && file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.exists()) {
                        if (file2.isDirectory()) {
                            List<String> listM13201i = m13201i(file2);
                            if (listM13201i.size() > 0) {
                                arrayList.addAll(listM13201i);
                            }
                        } else {
                            arrayList.add(C13334c.m79991x(file2));
                        }
                    }
                }
            }
            if (fileArrListFiles == null && file.exists()) {
                arrayList.add(C13334c.m79991x(file));
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public static String[] m13202j(Context context, Uri uri) {
        String[] columnNames;
        ContentProviderClient contentProviderClientM12617c = C2108a.m12617c(context, uri);
        if (contentProviderClientM12617c == null) {
            C2111d.m12648d("BackupUtils", "getColumnNames client is null");
            return new String[0];
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentProviderClientM12617c.query(uri, null, "_id = 0", null, null);
                if (cursorQuery != null && (columnNames = cursorQuery.getColumnNames()) != null) {
                    if (columnNames.length > 0) {
                        cursorQuery.close();
                        contentProviderClientM12617c.release();
                        return columnNames;
                    }
                }
            } catch (SQLException unused) {
                C2111d.m12648d("BackupUtils", "getColumnNames SQLException.");
                if (cursorQuery != null) {
                }
            } catch (IllegalStateException unused2) {
                C2111d.m12648d("BackupUtils", "getColumnNames IllegalStateException.");
                if (cursorQuery != null) {
                }
            } catch (Exception unused3) {
                C2111d.m12648d("BackupUtils", "Utils getColumnNames failed.");
                if (cursorQuery != null) {
                }
            }
            return new String[0];
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            contentProviderClientM12617c.release();
        }
    }

    /* renamed from: k */
    public static Set<String> m13203k() {
        return f9780m;
    }

    /* renamed from: l */
    public static String m13204l() {
        return Build.SUPPORTED_64_BIT_ABIS.length != 0 ? "64" : "32";
    }

    /* renamed from: m */
    public static String m13205m() {
        Locale locale = LocaleList.getDefault().get(0);
        if (locale == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    /* renamed from: n */
    public static synchronized Set<String> m13206n() {
        if (!C13348q.m80082b(f9775h)) {
            return Collections.unmodifiableSet(f9775h);
        }
        C1113f.a aVarM84769c = C14127a.m84764d().m84769c();
        if (aVarM84769c == null) {
            C2111d.m12648d("BackupUtils", "dependsOnCpuListInfo load time out, set isAppEnable = false.");
            C14127a.m84764d().m84775l(false);
            return new HashSet(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C1113f.b> it = aVarM84769c.f5300a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f5301a);
        }
        HashSet hashSet = new HashSet(arrayList);
        f9775h = hashSet;
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: o */
    public static synchronized Set<String> m13207o(int i10) {
        if (!C13348q.m80082b(f9774g)) {
            return Collections.unmodifiableSet(f9774g);
        }
        C1113f.a aVarM84769c = C14127a.m84764d().m84769c();
        if (aVarM84769c == null) {
            C2111d.m12648d("BackupUtils", "dependsOnCpuListInfo load time out, set isAppEnable = false.");
            C14127a.m84764d().m84775l(false);
            return new HashSet(0);
        }
        ArrayList arrayList = new ArrayList();
        for (C1113f.b bVar : aVarM84769c.f5300a) {
            if (i10 != -1) {
                if (i10 != 1 || !bVar.f5303c) {
                    arrayList.add(bVar.f5301a);
                }
            } else if (!bVar.f5302b) {
                arrayList.add(bVar.f5301a);
            }
        }
        HashSet hashSet = new HashSet(arrayList);
        f9774g = hashSet;
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: p */
    public static String m13208p(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return str + File.separator + str2;
    }

    /* renamed from: q */
    public static long m13209q(Context context, String str) {
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        return m13215w(context, arrayList);
    }

    /* renamed from: r */
    public static int m13210r(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    /* renamed from: s */
    public static int m13211s() {
        String strM81423a = C13529c.m81423a(C9142g.m57463b() ? "ro.build.magic_api_level" : "ro.build.hw_emui_api_level");
        if (m13170E(strM81423a)) {
            return -1;
        }
        try {
            return Integer.parseInt(strM81423a);
        } catch (NumberFormatException e10) {
            C2111d.m12649e("BackupUtils", "getEmuiApiLevel exception info = ", e10.getMessage());
            return -1;
        }
    }

    /* renamed from: t */
    public static Set<String> m13212t() {
        return f9778k;
    }

    /* renamed from: u */
    public static ContentValues m13213u(Cursor cursor, Map<String, Integer> map) {
        if (cursor == null || map == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                if (cursor.getColumnIndex(key) >= 0) {
                    switch (entry.getValue().intValue()) {
                        case 1:
                            contentValues.put(key, cursor.getString(cursor.getColumnIndexOrThrow(key)));
                            break;
                        case 2:
                        case 5:
                            contentValues.put(key, Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(key))));
                            break;
                        case 3:
                            contentValues.put(key, Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(key))));
                            break;
                        case 4:
                            contentValues.put(key, cursor.getBlob(cursor.getColumnIndexOrThrow(key)));
                            break;
                        case 6:
                            contentValues.put(key, Float.valueOf(cursor.getFloat(cursor.getColumnIndexOrThrow(key))));
                            break;
                        case 7:
                            String string = cursor.getString(cursor.getColumnIndexOrThrow(key));
                            contentValues.put(key, string == null ? null : Integer.valueOf(Integer.parseInt(string)));
                            break;
                        case 8:
                            String string2 = cursor.getString(cursor.getColumnIndexOrThrow(key));
                            contentValues.put(key, string2 == null ? null : Long.valueOf(Long.parseLong(string2)));
                            break;
                    }
                }
            } catch (NumberFormatException e10) {
                C2111d.m12648d("BackupUtils", "getFromCursor catch NumberFormatException: " + e10.getMessage());
            } catch (IllegalArgumentException e11) {
                C2111d.m12648d("BackupUtils", "getFromCursor catch IllegalArgumentException: " + e11.getMessage());
            } catch (Exception unused) {
                C2111d.m12648d("BackupUtils", "getFromCursor catch Exception.");
            }
        }
        return contentValues;
    }

    /* renamed from: v */
    public static int m13214v(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    /* renamed from: w */
    public static long m13215w(Context context, ArrayList<String> arrayList) {
        String[] strArrM80071j = C13345n.m80071j(context);
        Iterator<String> it = arrayList.iterator();
        long jM79988u = 0;
        while (it.hasNext()) {
            String next = it.next();
            C2111d.m12653i("BackupUtils", "get media size method srcFile: " + next);
            if (!TextUtils.isEmpty(next)) {
                if (next.startsWith("external") && strArrM80071j[0] != null) {
                    next = strArrM80071j[0] + next.substring(8);
                }
                if (next.startsWith("externalstorage") && strArrM80071j[1] != null) {
                    next = strArrM80071j[1] + next.substring(15);
                }
                jM79988u += C13334c.m79988u(new File(next));
            }
        }
        return jM79988u;
    }

    /* renamed from: x */
    public static String m13216x() {
        return C13529c.m81424b(C9142g.m57463b() ? "mscw.system.folderPrefix" : "hw.system.folderPrefix", C9142g.m57463b() ? "Honor" : "Huawei");
    }

    /* renamed from: y */
    public static long m13217y(Context context, String str, Bundle bundle) {
        if (context == null) {
            return 0L;
        }
        ArrayList<String> stringArrayList = null;
        String str2 = BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null;
        C2111d.m12653i("BackupUtils", "get system media data size start: " + str);
        Bundle bundleM12616b = C2108a.m12616b(context, str2, "backup_query", CloudBackupConstant.Command.PMS_CMD_BACKUP, bundle);
        if (bundleM12616b != null) {
            long j10 = bundleM12616b.getLong("file_size");
            if ("soundrecorder".equals(str) && j10 != 0) {
                C2111d.m12653i("BackupUtils", "get media size method, sound recorder size: " + j10);
                return j10;
            }
            stringArrayList = bundleM12616b.getStringArrayList("copyfile_path_list");
        }
        if (stringArrayList == null) {
            return 0L;
        }
        C2111d.m12653i("BackupUtils", "get media size method uri size: " + stringArrayList.size());
        long jM13215w = m13215w(context, stringArrayList);
        C2111d.m12653i("BackupUtils", "get media size method data size: " + jM13215w);
        if (!"soundrecorder".equals(str)) {
            return jM13215w;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next() + File.separator + "CallRecord");
        }
        C2111d.m12653i("BackupUtils", "get call record media method uri size: " + arrayList.size());
        long jM13215w2 = m13215w(context, arrayList);
        C2111d.m12653i("BackupUtils", "get call record media method data size: " + jM13215w2);
        return jM13215w - jM13215w2;
    }

    /* renamed from: z */
    public static synchronized Map<String, Set<String>> m13218z(Context context) {
        HashMap<String, Set<String>> map = f9777j;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        f9777j = new HashMap<>();
        C1116i.b bVarM84770f = C14127a.m84764d().m84770f();
        if (bVarM84770f == null) {
            C2111d.m12648d("BackupUtils", "trustListInfo load time out, set isAppEnable = false.");
            C14127a.m84764d().m84775l(false);
            return new HashMap(0);
        }
        String strM12667a = new WiFiUnit(context).m12667a();
        C2111d.m12654j("BackupUtils", "country code ", strM12667a);
        for (C1116i.a aVar : bVarM84770f.m6646b()) {
            if (m13179N(context, strM12667a, aVar.m6642e())) {
                f9777j.put(aVar.m6643f(), aVar.m6644g());
            }
        }
        return Collections.unmodifiableMap(f9777j);
    }
}
