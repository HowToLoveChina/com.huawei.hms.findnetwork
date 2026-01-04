package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.EnumC7062e;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;

/* renamed from: com.huawei.openalliance.ad.utils.j */
/* loaded from: classes2.dex */
public class C7831j {

    /* renamed from: com.huawei.openalliance.ad.utils.j$1 */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f36111a;

        static {
            int[] iArr = new int[EnumC7062e.values().length];
            f36111a = iArr;
            try {
                iArr[EnumC7062e.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36111a[EnumC7062e.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36111a[EnumC7062e.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36111a[EnumC7062e.IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36111a[EnumC7062e.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36111a[EnumC7062e.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36111a[EnumC7062e.INSTALLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36111a[EnumC7062e.WAITING_FOR_WIFI.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x002b, code lost:
    
        if (r2.m42080l() > 0) goto L32;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.openalliance.p169ad.download.app.AppStatus m48451a(com.huawei.openalliance.p169ad.download.app.AppDownloadTask r2) {
        /*
            com.huawei.openalliance.ad.download.e r0 = r2.m42077i()
            int[] r1 = com.huawei.openalliance.p169ad.utils.C7831j.AnonymousClass1.f36111a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L27;
                case 2: goto L24;
                case 3: goto L21;
                case 4: goto L1e;
                case 5: goto L1b;
                case 6: goto L18;
                case 7: goto L15;
                case 8: goto L12;
                default: goto Lf;
            }
        Lf:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.DOWNLOAD
            goto L2e
        L12:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.WAITING_FOR_WIFI
            goto L2e
        L15:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.INSTALLED
            goto L2e
        L18:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.INSTALLING
            goto L2e
        L1b:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.INSTALL
            goto L2e
        L1e:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.PAUSE
            goto L2e
        L21:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.DOWNLOADING
            goto L2e
        L24:
            com.huawei.openalliance.ad.download.app.AppStatus r2 = com.huawei.openalliance.p169ad.download.app.AppStatus.WAITING
            goto L2e
        L27:
            int r2 = r2.m42080l()
            if (r2 <= 0) goto Lf
            goto L1e
        L2e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.C7831j.m48451a(com.huawei.openalliance.ad.download.app.AppDownloadTask):com.huawei.openalliance.ad.download.app.AppStatus");
    }

    /* renamed from: b */
    public static int m48462b(String str, AppInfo appInfo) {
        if (appInfo != null && !AbstractC7806cz.m48165b(str)) {
            if (m48458a(appInfo)) {
                return 3;
            }
            if (m48461a(str)) {
                return 2;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static String m48452a(Context context, AppInfo appInfo, int i10) {
        int i11;
        if (context == null || appInfo == null) {
            return "";
        }
        String strM44412l = appInfo.m44412l();
        if (!m48458a(appInfo)) {
            i11 = C6849R.string.hiad_download_open;
        } else {
            if (i10 == 1) {
                return context.getString(C6849R.string.hiad_app_preordered);
            }
            i11 = C6849R.string.hiad_app_preorder;
        }
        return m48453a(context, appInfo, strM44412l, i11);
    }

    /* renamed from: b */
    private static boolean m48463b(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.isCheckSha256() && TextUtils.isEmpty(appInfo.getSha256());
    }

    /* renamed from: a */
    private static String m48453a(Context context, AppInfo appInfo, String str, int i10) {
        return !TextUtils.isEmpty(appInfo.m44416n()) ? appInfo.m44416n() : m48456a(str, context.getString(i10));
    }

    /* renamed from: b */
    private static boolean m48464b(AppInfo appInfo, Integer num) {
        if (appInfo == null) {
            return false;
        }
        return appInfo.m44374a(num);
    }

    /* renamed from: a */
    public static String m48454a(Context context, AppInfo appInfo, boolean z10) {
        String strM44409k;
        String string;
        if (context == null || appInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(appInfo.m44414m())) {
            return appInfo.m44414m();
        }
        int i10 = C6849R.string.hiad_download_download;
        if (z10) {
            int i11 = C6849R.string.hiad_preinstall_restore_and_open;
            strM44409k = appInfo.m44388d();
            string = context.getString(i11);
        } else {
            if ("11".equals(appInfo.getPriorInstallWay())) {
                i10 = appInfo.m44344C() == 1 ? C6849R.string.hiad_preinstall_restore_and_open : C6849R.string.hiad_download_install;
            }
            strM44409k = appInfo.m44409k();
            string = context.getString(i10);
        }
        return m48456a(strM44409k, string);
    }

    /* renamed from: a */
    public static String m48455a(String str, AppInfo appInfo) {
        if (appInfo != null && !AbstractC7806cz.m48165b(str)) {
            if (m48458a(appInfo)) {
                return ClickDestination.APPMARKET;
            }
            if (m48461a(str)) {
                return ClickDestination.FASTAPP;
            }
        }
        return "app";
    }

    /* renamed from: a */
    public static String m48456a(String str, String str2) {
        return (TextUtils.isEmpty(str) || (!(AbstractC7811dd.m48330g() && HNConstants.Language.CN_STANDARD.equalsIgnoreCase(AbstractC7807d.m48224c())) && AbstractC7811dd.m48330g())) ? str2 : str;
    }

    /* renamed from: a */
    public static boolean m48457a(Context context, String str, AppDownloadTask appDownloadTask) {
        if (str == null || appDownloadTask == null || appDownloadTask.m42222B() == null) {
            AbstractC7185ho.m43823c("AppDownloadUtils", "auto open invalid para.");
            return false;
        }
        if (C7124fh.m43316b(context).mo43397bX()) {
            AbstractC7185ho.m43820b("AppDownloadUtils", "media forbidden auto open after install.");
            return false;
        }
        if (appDownloadTask.m42222B().m44344C() != 1 && !m48459a(appDownloadTask.m42222B(), Boolean.valueOf(appDownloadTask.m42242V()))) {
            AbstractC7185ho.m43820b("AppDownloadUtils", "no need auto open.");
            return false;
        }
        if (AbstractC7811dd.m48339o(context)) {
            AbstractC7185ho.m43817a("AppDownloadUtils", "can auto open!");
            return true;
        }
        AbstractC7185ho.m43820b("AppDownloadUtils", "no need auto open due to caller background.");
        return false;
    }

    /* renamed from: a */
    public static boolean m48458a(AppInfo appInfo) {
        return (appInfo == null || TextUtils.isEmpty(appInfo.m44358J())) ? false : true;
    }

    /* renamed from: a */
    public static boolean m48459a(AppInfo appInfo, Boolean bool) {
        return appInfo != null && appInfo.m44383c() == 1 && Boolean.TRUE.equals(bool);
    }

    /* renamed from: a */
    public static boolean m48460a(AppInfo appInfo, Integer num) {
        String str;
        if (appInfo == null) {
            str = " download app info is empty";
        } else if (TextUtils.isEmpty(appInfo.getPackageName())) {
            str = "app packageName is empty";
        } else {
            if ("11".equals(appInfo.getPriorInstallWay()) || m48464b(appInfo, num) || m48458a(appInfo) || (!TextUtils.isEmpty(appInfo.getDownloadUrl()) && !m48463b(appInfo) && appInfo.getFileSize() > 0)) {
                return false;
            }
            str = " download app info is invalid";
        }
        AbstractC7185ho.m43820b("AppDownloadUtils", str);
        return true;
    }

    /* renamed from: a */
    private static boolean m48461a(String str) {
        return Constants.FAST_APP_PKG.equalsIgnoreCase(str) || Constants.FAST_APP_DEV_PKG.equalsIgnoreCase(str);
    }
}
