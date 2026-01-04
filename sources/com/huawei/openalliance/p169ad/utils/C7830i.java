package com.huawei.openalliance.p169ad.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.huawei.android.hms.ppskit.RemoteInstallReq;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7486mu;
import com.huawei.openalliance.p169ad.C7562ow;
import com.huawei.openalliance.p169ad.C7691tm;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.HMSConstants;
import com.huawei.openalliance.p169ad.constant.IntentFailError;
import com.huawei.openalliance.p169ad.download.DownloadFileProvider;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.hsf.C7192a;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.net.URISyntaxException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.utils.i */
/* loaded from: classes2.dex */
public class C7830i {

    /* renamed from: a */
    private static final Map<String, List<String>> f36101a;

    /* renamed from: com.huawei.openalliance.ad.utils.i$a */
    public static class a {

        /* renamed from: a */
        private String f36102a;

        /* renamed from: b */
        private String f36103b;

        /* renamed from: a */
        public String m48442a() {
            return this.f36102a;
        }

        /* renamed from: b */
        public String m48443b() {
            return this.f36103b;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.f36102a;
            return str != null && str.equals(aVar.f36102a);
        }

        public int hashCode() {
            String str = this.f36102a;
            return str != null ? str.hashCode() : super.hashCode();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.i$b */
    public static abstract class b {

        /* renamed from: a */
        private final C7562ow.a f36104a;

        /* renamed from: b */
        private final Context f36105b;

        /* renamed from: c */
        private final String f36106c;

        /* renamed from: d */
        private final String f36107d;

        /* renamed from: com.huawei.openalliance.ad.utils.i$b$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f36108a;

            public AnonymousClass1(int i10) {
                i = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43818a("ApkUtil", "App install failed, reason :%d", Integer.valueOf(i));
                AppDownloadTask appDownloadTaskMo42385a = C7046e.m42377h().mo42385a(b.this.f36107d);
                if (appDownloadTaskMo42385a != null) {
                    InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTaskMo42385a.m42223C();
                    if (interfaceC7615qqM42223C != null) {
                        interfaceC7615qqM42223C.mo46619c(Integer.valueOf(b.this.mo48450d()), appDownloadTaskMo42385a.m42226F(), appDownloadTaskMo42385a.m42236P(), appDownloadTaskMo42385a.m42237Q(), appDownloadTaskMo42385a.m42227G());
                    }
                    if (5 == i && EnumC7062e.INSTALLING == appDownloadTaskMo42385a.m42077i()) {
                        if (b.this.f36104a != null) {
                            b.this.f36104a.mo42337a(i);
                            return;
                        }
                        return;
                    }
                }
                if (1 != i) {
                    b bVar = b.this;
                    bVar.m48446a(bVar.f36107d, b.this.f36106c, appDownloadTaskMo42385a, b.this.f36104a);
                } else if (b.this.f36104a != null) {
                    b.this.f36104a.mo42337a(i);
                }
            }
        }

        public b(C7562ow.a aVar, Context context, String str, String str2) {
            this.f36104a = aVar;
            this.f36105b = context;
            this.f36106c = str;
            this.f36107d = str2;
        }

        /* renamed from: d */
        public abstract int mo48450d();

        /* renamed from: a */
        public void m48449a(int i10) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.i.b.1

                /* renamed from: a */
                final /* synthetic */ int f36108a;

                public AnonymousClass1(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7185ho.m43818a("ApkUtil", "App install failed, reason :%d", Integer.valueOf(i));
                    AppDownloadTask appDownloadTaskMo42385a = C7046e.m42377h().mo42385a(b.this.f36107d);
                    if (appDownloadTaskMo42385a != null) {
                        InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTaskMo42385a.m42223C();
                        if (interfaceC7615qqM42223C != null) {
                            interfaceC7615qqM42223C.mo46619c(Integer.valueOf(b.this.mo48450d()), appDownloadTaskMo42385a.m42226F(), appDownloadTaskMo42385a.m42236P(), appDownloadTaskMo42385a.m42237Q(), appDownloadTaskMo42385a.m42227G());
                        }
                        if (5 == i && EnumC7062e.INSTALLING == appDownloadTaskMo42385a.m42077i()) {
                            if (b.this.f36104a != null) {
                                b.this.f36104a.mo42337a(i);
                                return;
                            }
                            return;
                        }
                    }
                    if (1 != i) {
                        b bVar = b.this;
                        bVar.m48446a(bVar.f36107d, b.this.f36106c, appDownloadTaskMo42385a, b.this.f36104a);
                    } else if (b.this.f36104a != null) {
                        b.this.f36104a.mo42337a(i);
                    }
                }
            });
        }

        /* renamed from: a */
        public void m48446a(String str, String str2, AppDownloadTask appDownloadTask, C7562ow.a aVar) {
            if (aVar != null) {
                aVar.mo42338b();
            }
            if (appDownloadTask != null) {
                C7830i.m48418a(appDownloadTask, EventType.APPINSTALLSTART, 2);
                appDownloadTask.m42248d(2);
            }
            C7830i.m48415a(this.f36105b, str2, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.i$c */
    public static class c extends b {
        public c(C7562ow.a aVar, Context context, String str, String str2) {
            super(aVar, context, str, str2);
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7830i.b
        /* renamed from: d */
        public int mo48450d() {
            return 4;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.i$d */
    public static class d extends b implements C7192a.b {
        public d(C7562ow.a aVar, Context context, String str, String str2) {
            super(aVar, context, str, str2);
        }

        @Override // com.huawei.openalliance.p169ad.hsf.C7192a.b
        /* renamed from: a */
        public void mo43859a() {
            AbstractC7185ho.m43820b("HsfPackageInstallResult", "onServiceBindFail");
            m48449a(2);
        }

        @Override // com.huawei.openalliance.p169ad.hsf.C7192a.b
        /* renamed from: b */
        public void mo43860b() {
            AbstractC7185ho.m43820b("HsfPackageInstallResult", "onInstallSuccess");
        }

        @Override // com.huawei.openalliance.p169ad.hsf.C7192a.b
        /* renamed from: c */
        public void mo43861c() {
            AbstractC7185ho.m43820b("HsfPackageInstallResult", "onInstallFailed");
            m48449a(4);
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7830i.b
        /* renamed from: d */
        public int mo48450d() {
            return 3;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.i$e */
    public static class e extends C7486mu.a {

        /* renamed from: a */
        private c f36110a;

        public e(C7562ow.a aVar, Context context, String str, String str2) {
            this.f36110a = new c(aVar, context, str, str2);
        }

        @Override // com.huawei.openalliance.p169ad.C7486mu.a
        /* renamed from: a */
        public void mo45875a(String str) {
            AbstractC7185ho.m43823c("ApkUtil", "HMS - onServiceCallFailed: " + str);
            this.f36110a.m48449a(Constants.FAIL_REASON_SERVICE_DISCONNET.equals(str) ? 5 : 2);
        }

        @Override // com.huawei.openalliance.p169ad.C7486mu.a, com.huawei.android.hms.ppskit.InterfaceC4312c
        /* renamed from: a */
        public void mo25937a(boolean z10, int i10) {
            AbstractC7185ho.m43820b("ApkUtil", "HMS - onInstallResult: " + z10 + " reason: " + i10);
            if (z10) {
                return;
            }
            this.f36110a.m48449a(i10);
        }
    }

    static {
        HashMap map = new HashMap();
        f36101a = map;
        map.put("com.huawei.hwid", Arrays.asList(HMSConstants.HMS_SIGNATURE));
        map.put("com.huawei.hms", Arrays.asList(HMSConstants.HMS_NEW_SIGNATURE));
        map.put("com.huawei.hwid.tv", Arrays.asList(HMSConstants.HMS_TV_SIGNATURE));
    }

    /* renamed from: a */
    public static PackageInfo m48408a(PackageManager packageManager, String str, int i10) {
        if (packageManager != null && !TextUtils.isEmpty(str)) {
            try {
                return packageManager.getPackageInfo(str, i10);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public static Intent m48426b(Context context, String str, String str2, C7692tn c7692tn) throws URISyntaxException {
        String str3;
        try {
        } catch (ActivityNotFoundException unused) {
            C7792cl.m48072a(context, c7692tn, IntentFailError.ACTIVITY_NOT_FOUND_EXP);
            str3 = "parseAndCheckIntent, activity not exist";
            AbstractC7185ho.m43823c("ApkUtil", str3);
            return null;
        } catch (URISyntaxException unused2) {
            C7792cl.m48072a(context, c7692tn, IntentFailError.PARSE_INTENT_ERROR);
            str3 = "parseAndCheckIntent, parse uri fail";
            AbstractC7185ho.m43823c("ApkUtil", str3);
            return null;
        } catch (Exception e10) {
            C7792cl.m48072a(context, c7692tn, "unknown exception:" + e10.getClass().getSimpleName());
            str3 = "handle intent url fail";
            AbstractC7185ho.m43823c("ApkUtil", str3);
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            C7792cl.m48072a(context, c7692tn, IntentFailError.INTENT_URI_EMPTY);
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            boolean z10 = true;
            Intent uri = Intent.parseUri(Uri.decode(str), 1);
            if (!m48422a(uri, str2)) {
                C7792cl.m48072a(context, c7692tn, IntentFailError.NOT_SAME_PACKAGE);
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                uri.setPackage(str2);
            }
            if (uri.getData() != null) {
                uri = uri.setDataAndTypeAndNormalize(uri.getData(), uri.getType());
            }
            if (Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30 || AbstractC7784cd.m47887a(context, "android.permission.QUERY_ALL_PACKAGES")) {
                z10 = false;
            } else {
                AbstractC7185ho.m43817a("ApkUtil", "has no QUERY_ALL_PACKAGES permission");
                C7792cl.m48072a(context, c7692tn, IntentFailError.NO_PERMISSION);
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(uri, 0);
            if (AbstractC7760bg.m47767a(listQueryIntentActivities)) {
                if (z10) {
                    return null;
                }
                AbstractC7185ho.m43823c("ApkUtil", "can not find the activity");
                C7792cl.m48072a(context, c7692tn, IntentFailError.ACTIVITY_NOT_FOUND);
                return null;
            }
            if (!m48424a(listQueryIntentActivities)) {
                AbstractC7185ho.m43823c("ApkUtil", "parseAndCheckIntent, activity not exists or not exported.");
                C7792cl.m48072a(context, c7692tn, IntentFailError.ACTIVITY_NOT_EXPORTED);
                return null;
            }
            if (C7124fh.m43316b(context).mo43051a(uri.getPackage())) {
                m48417a(uri);
            }
            if (!listQueryIntentActivities.isEmpty()) {
                return uri;
            }
        } else {
            C7792cl.m48072a(context, c7692tn, IntentFailError.CAN_NOT_GET_PKG_MANAGER);
        }
        return null;
    }

    /* renamed from: c */
    public static String m48430c(Context context, String str) {
        String str2;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return m48410a(packageManager, str);
            }
            return null;
        } catch (RuntimeException unused) {
            str2 = "getAppName RuntimeException";
            AbstractC7185ho.m43823c("ApkUtil", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "getAppName Exception";
            AbstractC7185ho.m43823c("ApkUtil", str2);
            return null;
        }
    }

    /* renamed from: d */
    public static ApplicationInfo m48432d(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getApplicationInfo(str, 128);
            }
            AbstractC7185ho.m43820b("ApkUtil", "pm is null");
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("ApkUtil", "getApplicationInfo " + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: e */
    public static String m48434e(Context context) {
        return m48419a(context, "com.huawei.hwid") ? "com.huawei.hwid" : m48419a(context, "com.huawei.hms") ? "com.huawei.hms" : m48419a(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    /* renamed from: f */
    public static int m48436f(Context context, String str) {
        try {
            PackageInfo packageInfoM48427b = m48427b(context, str);
            if (packageInfoM48427b == null) {
                return 0;
            }
            return packageInfoM48427b.versionCode;
        } catch (AndroidRuntimeException | Exception unused) {
            AbstractC7185ho.m43823c("ApkUtil", "getAppVersionCode fail");
            return 0;
        }
    }

    /* renamed from: g */
    public static boolean m48437g(Context context, String str) {
        return m48425a(f36101a.get(str), m48435e(context, str));
    }

    /* renamed from: h */
    private static byte[] m48438h(Context context, String str) {
        String str2;
        PackageInfo packageInfo;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr.length > 0) {
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                        try {
                            byte[] encoded = CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(byteArrayInputStream2).getEncoded();
                            AbstractC7805cy.m48142a((Closeable) byteArrayInputStream2);
                            return encoded;
                        } catch (RuntimeException e10) {
                            e = e10;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes RuntimeException:" + e.getClass().getSimpleName();
                            AbstractC7185ho.m43826d("ApkUtil", str2);
                            AbstractC7805cy.m48142a((Closeable) byteArrayInputStream);
                            AbstractC7185ho.m43820b("ApkUtil", "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes Exception:" + th.getClass().getSimpleName();
                            AbstractC7185ho.m43826d("ApkUtil", str2);
                            AbstractC7805cy.m48142a((Closeable) byteArrayInputStream);
                            AbstractC7185ho.m43820b("ApkUtil", "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        }
                    }
                }
            } catch (RuntimeException e11) {
                e = e11;
            } catch (Throwable th3) {
                th = th3;
            }
            AbstractC7805cy.m48142a((Closeable) byteArrayInputStream);
            AbstractC7185ho.m43820b("ApkUtil", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        } catch (Throwable th4) {
            AbstractC7805cy.m48142a((Closeable) byteArrayInputStream);
            throw th4;
        }
    }

    /* renamed from: a */
    public static String m48409a(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str = "getPackageInfo NameNotFoundException";
            AbstractC7185ho.m43823c("ApkUtil", str);
            return null;
        } catch (Throwable unused2) {
            str = "getPackageInfo Exception";
            AbstractC7185ho.m43823c("ApkUtil", str);
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public static PackageInfo m48427b(Context context, String str) {
        String str2;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("ApkUtil", "getPackageInfo, packageName:%s", str);
        }
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getPackageInfo NameNotFoundException";
            AbstractC7185ho.m43823c("ApkUtil", str2);
            return null;
        } catch (Throwable unused2) {
            str2 = "getPackageInfo Exception";
            AbstractC7185ho.m43823c("ApkUtil", str2);
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m48431c(Context context) {
        return !TextUtils.isEmpty(m48433d(context));
    }

    /* renamed from: d */
    public static String m48433d(Context context) {
        String strM48434e = m48434e(context);
        if (TextUtils.isEmpty(strM48434e)) {
            return null;
        }
        if (m48425a(f36101a.get(strM48434e), m48435e(context, strM48434e))) {
            return strM48434e;
        }
        return null;
    }

    /* renamed from: e */
    public static String m48435e(Context context, String str) {
        byte[] bArrM48438h = m48438h(context, str);
        if (bArrM48438h == null || bArrM48438h.length == 0) {
            return null;
        }
        return AbstractC7740an.m47531a(AbstractC7801cu.m48127a(bArrM48438h));
    }

    /* renamed from: a */
    private static String m48410a(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        String str2;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return packageManager.getApplicationLabel(applicationInfo).toString();
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getAppName NameNotFoundException";
            AbstractC7185ho.m43823c("ApkUtil", str2);
            return null;
        } catch (Exception e10) {
            str2 = "getAppName Exception:" + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("ApkUtil", str2);
            return null;
        }
    }

    /* renamed from: b */
    public static Integer m48428b(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(m48434e(context), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("ppskit_ver_code")) == null) {
                return null;
            }
            String string = obj.toString();
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("ApkUtil", "ppsKitVerCode:%s", string);
            }
            return AbstractC7806cz.m48178h(string);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("ApkUtil", "getPpsKitVerCode ex: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public static Set<a> m48411a(Context context, Intent intent) {
        StringBuilder sb2;
        String str;
        String string;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                if (!m48424a(listQueryIntentActivities)) {
                    AbstractC7185ho.m43823c("ApkUtil", "queryIntentActivities, activity not exists or not exported.");
                    return null;
                }
                if (!listQueryIntentActivities.isEmpty()) {
                    HashSet hashSet = new HashSet();
                    for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                        if (resolveInfo != null && resolveInfo.activityInfo != null) {
                            a aVar = new a();
                            aVar.f36102a = resolveInfo.activityInfo.packageName;
                            if (!TextUtils.isEmpty(aVar.f36102a)) {
                                aVar.f36103b = m48410a(packageManager, aVar.f36102a);
                                hashSet.add(aVar);
                            }
                        }
                    }
                    return hashSet;
                }
            }
        } catch (ActivityNotFoundException unused) {
            string = "queryIntentActivities, activity not exist";
            AbstractC7185ho.m43823c("ApkUtil", string);
            return null;
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "queryIntentActivities RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            string = sb2.toString();
            AbstractC7185ho.m43823c("ApkUtil", string);
            return null;
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "queryIntentActivities Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            string = sb2.toString();
            AbstractC7185ho.m43823c("ApkUtil", string);
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public static String m48429b(Context context, Intent intent) {
        ActivityInfo activityInfo;
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return null;
        }
        return activityInfo.packageName;
    }

    /* renamed from: a */
    public static void m48412a(Context context, Intent intent, C7692tn c7692tn) {
        if (c7692tn != null && AbstractC7806cz.m48165b(c7692tn.m47264d())) {
            c7692tn.m47260a(m48429b(context, intent));
        }
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
            C7691tm.m47256a(context, c7692tn);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("ApkUtil", "start activity error");
            new C6922c(context).mo39085a(c7692tn, th2.getMessage());
        }
    }

    /* renamed from: a */
    private static void m48413a(Context context, RemoteInstallReq remoteInstallReq, Uri uri, C7562ow.a aVar, e eVar) {
        AbstractC7185ho.m43820b("ApkUtil", "installViaHmsAidl");
        C7486mu c7486muM45871a = C7486mu.m45871a(context);
        if (aVar != null) {
            aVar.mo42336a();
        }
        c7486muM45871a.m45872a(remoteInstallReq, uri, eVar);
    }

    /* renamed from: a */
    public static void m48414a(Context context, RemoteInstallReq remoteInstallReq, String str, String str2, C7562ow.a aVar) {
        String simpleName;
        AbstractC7185ho.m43818a("ApkUtil", "installApkViaHMS, packageName: %s", str2);
        e eVar = new e(aVar, context, str, str2);
        if (m48427b(context, m48434e(context)) == null) {
            eVar.mo45875a("HMS is not found");
            return;
        }
        try {
            Uri uriM42032a = DownloadFileProvider.m42032a(context, context.getPackageName() + ".hiad.fileprovider", new File(str));
            context.getApplicationContext().grantUriPermission(m48434e(context), uriM42032a, 1);
            m48413a(context, remoteInstallReq, uriM42032a, aVar, eVar);
        } catch (IllegalArgumentException unused) {
            AbstractC7185ho.m43823c("ApkUtil", "installApkViaHMS IllegalArgumentException");
            simpleName = "IllegalArgumentException";
            eVar.mo45875a(simpleName);
        } catch (Exception e10) {
            AbstractC7185ho.m43823c("ApkUtil", "installApkViaHMS " + e10.getClass().getSimpleName());
            simpleName = e10.getClass().getSimpleName();
            eVar.mo45875a(simpleName);
        }
    }

    /* renamed from: a */
    public static void m48415a(Context context, String str, String str2) {
        String str3;
        AbstractC7185ho.m43818a("ApkUtil", "installApkManually, packageName: %s", str2);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (m48419a(context, Constants.SYSTEM_PKG_INSTALLER)) {
                intent.setPackage(Constants.SYSTEM_PKG_INSTALLER);
            }
            Uri uriM42032a = DownloadFileProvider.m42032a(context, context.getPackageName() + ".hiad.fileprovider", new File(str));
            intent.addFlags(1);
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            intent.addFlags(C5914f2.f26733f);
            intent.setDataAndType(uriM42032a, "application/vnd.android.package-archive");
            if (!AbstractC7811dd.m48311b(context, intent)) {
                AbstractC7185ho.m43820b("ApkUtil", "system package installer is unavailable");
                intent.setPackage(null);
            }
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            str3 = "installApkManually ActivityNotFoundException";
            AbstractC7185ho.m43823c("ApkUtil", str3);
        } catch (Exception e10) {
            str3 = "installApkManually " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("ApkUtil", str3);
        }
    }

    /* renamed from: a */
    public static void m48416a(Context context, String str, String str2, C7562ow.a aVar) {
        String str3;
        Uri uriFromFile;
        AbstractC7185ho.m43818a("ApkUtil", "installApkViaHsf, packageName: %s", str2);
        d dVar = new d(aVar, context, str, str2);
        String str4 = Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE;
        PackageInfo packageInfoM48427b = m48427b(context, Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE);
        if (packageInfoM48427b == null) {
            str4 = Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE_NEW;
            packageInfoM48427b = m48427b(context, Constants.REMOTE_APP_INSTALL_HOST_HSF_PACKAGE_NEW);
        }
        if (packageInfoM48427b == null) {
            dVar.mo43859a();
            return;
        }
        try {
            if (packageInfoM48427b.versionCode >= 90000300) {
                uriFromFile = DownloadFileProvider.m42032a(context, context.getPackageName() + ".hiad.fileprovider", new File(str));
            } else {
                uriFromFile = Uri.fromFile(new File(str));
            }
            context.getApplicationContext().grantUriPermission(str4, uriFromFile, 1);
            C7192a c7192aM43846a = C7192a.m43846a(context);
            if (aVar != null) {
                aVar.mo42336a();
            }
            c7192aM43846a.m43856a(str2, uriFromFile.toString(), dVar);
        } catch (IllegalArgumentException unused) {
            str3 = "installApkViaHsf IllegalArgumentException";
            AbstractC7185ho.m43823c("ApkUtil", str3);
            dVar.mo43859a();
        } catch (Exception e10) {
            str3 = "installApkViaHsf " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("ApkUtil", str3);
            dVar.mo43859a();
        }
    }

    /* renamed from: a */
    public static void m48417a(Intent intent) {
        intent.addFlags(536870912);
        intent.addFlags(C5914f2.f26733f);
        AbstractC7185ho.m43820b("ApkUtil", "addFlagsToIntent: Success");
    }

    /* renamed from: a */
    public static void m48418a(AppDownloadTask appDownloadTask, EventType eventType, int i10) {
        InterfaceC7615qq interfaceC7615qqM42223C;
        if (appDownloadTask == null || (interfaceC7615qqM42223C = appDownloadTask.m42223C()) == null) {
            return;
        }
        if (EventType.APPINSTALLSTART == eventType) {
            interfaceC7615qqM42223C.mo46611b(Integer.valueOf(i10), appDownloadTask.m42226F(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
        } else if (EventType.APPINSTALLFAIL == eventType) {
            interfaceC7615qqM42223C.mo46619c(Integer.valueOf(i10), appDownloadTask.m42226F(), appDownloadTask.m42236P(), appDownloadTask.m42237Q(), appDownloadTask.m42227G());
        }
    }

    /* renamed from: a */
    public static boolean m48419a(Context context, String str) {
        return m48427b(context, str) != null;
    }

    /* renamed from: a */
    public static boolean m48420a(Context context, String str, C7692tn c7692tn) {
        AbstractC7185ho.m43820b("ApkUtil", "open app main page");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            C7792cl.m48072a(context, c7692tn, IntentFailError.DO_OPEN_MAIN_PAGE_GET_INTENT_ERROR);
            return false;
        }
        launchIntentForPackage.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        launchIntentForPackage.setPackage(str);
        if (c7692tn != null) {
            c7692tn.m47262b(null);
        }
        m48412a(context, launchIntentForPackage, c7692tn);
        return true;
    }

    /* renamed from: a */
    public static boolean m48421a(Context context, String str, String str2, C7692tn c7692tn) {
        AbstractC7185ho.m43820b("ApkUtil", "openApp intent");
        try {
        } catch (ActivityNotFoundException unused) {
            AbstractC7185ho.m43823c("ApkUtil", "activity not exist");
            C7792cl.m48072a(context, c7692tn, IntentFailError.ACTIVITY_NOT_FOUND_EXP);
        } catch (Exception e10) {
            C7792cl.m48072a(context, c7692tn, "unknown exception:" + e10.getClass().getSimpleName());
            AbstractC7185ho.m43823c("ApkUtil", "handle intent url fail");
        }
        if (context.getPackageManager() == null) {
            C7792cl.m48072a(context, c7692tn, IntentFailError.CAN_NOT_GET_PKG_MANAGER);
            return false;
        }
        Intent intentM48426b = m48426b(context, str2, str, c7692tn);
        if (intentM48426b == null) {
            return false;
        }
        intentM48426b.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (c7692tn != null) {
            c7692tn.m47259a(intentM48426b);
        }
        m48412a(context, intentM48426b, c7692tn);
        return true;
    }

    /* renamed from: a */
    public static boolean m48422a(Intent intent, String str) {
        ComponentName component;
        if (intent == null || TextUtils.isEmpty(str) || (component = intent.getComponent()) == null) {
            return true;
        }
        String packageName = component.getPackageName();
        return TextUtils.isEmpty(packageName) || str.equalsIgnoreCase(packageName);
    }

    /* renamed from: a */
    public static boolean m48423a(String str) {
        return "com.huawei.hwid".equals(str) || "com.huawei.hms".equals(str) || "com.huawei.hwid.tv".equals(str);
    }

    /* renamed from: a */
    public static boolean m48424a(List<ResolveInfo> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            if (!it.next().activityInfo.exported) {
                z10 = false;
            }
        }
        return z10;
    }

    /* renamed from: a */
    private static boolean m48425a(List<String> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
