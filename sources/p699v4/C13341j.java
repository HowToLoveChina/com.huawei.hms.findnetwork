package p699v4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.backup.backupremoteservice.C2105a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p229di.C9140e;
import p566q4.C12285d;
import p601r4.C12462b;

/* renamed from: v4.j */
/* loaded from: classes.dex */
public class C13341j {

    /* renamed from: c */
    public static Method f60168c;

    /* renamed from: d */
    public static Method f60169d;

    /* renamed from: a */
    public static final int f60166a = Build.VERSION.SDK_INT;

    /* renamed from: b */
    public static Set<String> f60167b = new HashSet();

    /* renamed from: e */
    public static String f60170e = null;

    static {
        f60168c = null;
        f60169d = null;
        try {
            Class<?> cls = Class.forName("android.os.StrictMode");
            f60168c = cls.getMethod("disableDeathOnFileUriExposure", new Class[0]);
            f60169d = cls.getMethod("enableDeathOnFileUriExposure", new Class[0]);
        } catch (ClassNotFoundException unused) {
            C2111d.m12648d("MediaScanUtils", "load class android.os.StrictMode error");
        } catch (NoSuchMethodException unused2) {
            C2111d.m12648d("MediaScanUtils", "load class android.os.StrictMode method error 1");
        } catch (SecurityException unused3) {
            C2111d.m12648d("MediaScanUtils", "load class android.os.StrictMode method error 2");
        }
    }

    /* renamed from: a */
    public static void m80034a(Context context, String str, String str2) {
        if (context == null || str == null || TextUtils.isEmpty(str2)) {
            C2111d.m12648d("MediaScanUtils", "addMediaScans param is null");
            return;
        }
        if ("wechat_record".equals(str) && !m80038e(str2)) {
            C2111d.m12646b("MediaScanUtils", "not scan for wechat newFile");
        } else if (C2105a.m12585a(str)) {
            m80043j(context, str2, true, str);
        } else {
            m80044k(context, str2, true, false);
        }
    }

    /* renamed from: b */
    public static boolean m80035b(Context context) {
        if (m80036c(context, "android.intent.action.MEDIA_SCANNER_SCAN_FOLDER")) {
            C2111d.m12646b("MediaScanUtils", "SupportScanFolder action = android.intent.action.MEDIA_SCANNER_SCAN_FOLDER");
            f60170e = "android.intent.action.MEDIA_SCANNER_SCAN_FOLDER";
            return true;
        }
        if (!m80036c(context, "huawei.intent.action.MEDIA_SCANNER_SCAN_FOLDER")) {
            return false;
        }
        C2111d.m12646b("MediaScanUtils", "SupportScanFolder action = huawei.intent.action.MEDIA_SCANNER_SCAN_FOLDER");
        f60170e = "huawei.intent.action.MEDIA_SCANNER_SCAN_FOLDER";
        return true;
    }

    /* renamed from: c */
    public static boolean m80036c(Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent;
        if (f60168c == null || f60169d == null) {
            C2111d.m12653i("MediaScanUtils", "disableDeathOnFileUriExposure or enableDeathOnFileUriExposure is null, this is not EMUI5.0");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
        } catch (IllegalAccessException unused) {
            C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalAccessException ");
        } catch (IllegalArgumentException unused2) {
            C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalArgumentException ");
        } catch (InvocationTargetException unused3) {
            C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers InvocationTargetException ");
        }
        try {
            try {
                try {
                    f60168c.invoke(null, new Object[0]);
                    intent = new Intent(str);
                    intent.setData(Uri.parse("file://"));
                } catch (IllegalAccessException unused4) {
                    C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalAccessException ");
                    f60169d.invoke(null, new Object[0]);
                } catch (IllegalArgumentException unused5) {
                    C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalArgumentException ");
                    f60169d.invoke(null, new Object[0]);
                }
            } catch (InvocationTargetException unused6) {
                C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers InvocationTargetException ");
                f60169d.invoke(null, new Object[0]);
            }
            if (!C13348q.m80082b(packageManager.queryBroadcastReceivers(intent, 0))) {
                try {
                    f60169d.invoke(null, new Object[0]);
                } catch (IllegalAccessException unused7) {
                    C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalAccessException ");
                } catch (IllegalArgumentException unused8) {
                    C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalArgumentException ");
                } catch (InvocationTargetException unused9) {
                    C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers InvocationTargetException ");
                }
                return true;
            }
            if (C13349r.m80086b(context)) {
                if (!C13348q.m80082b(packageManager.queryBroadcastReceivers(new Intent(str), 0))) {
                    try {
                        f60169d.invoke(null, new Object[0]);
                    } catch (IllegalAccessException unused10) {
                        C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalAccessException ");
                    } catch (IllegalArgumentException unused11) {
                        C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalArgumentException ");
                    } catch (InvocationTargetException unused12) {
                        C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers InvocationTargetException ");
                    }
                    return true;
                }
            }
            f60169d.invoke(null, new Object[0]);
            return false;
        } catch (Throwable th2) {
            try {
                f60169d.invoke(null, new Object[0]);
            } catch (IllegalAccessException unused13) {
                C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalAccessException ");
            } catch (IllegalArgumentException unused14) {
                C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers IllegalArgumentException ");
            } catch (InvocationTargetException unused15) {
                C2111d.m12648d("MediaScanUtils", "queryBroadcastReceivers InvocationTargetException ");
            }
            throw th2;
        }
    }

    /* renamed from: d */
    public static void m80037d(Context context) {
        C2111d.m12653i("MediaScanUtils", "initWechatRecordDownloadRootPath");
        if (context == null) {
            return;
        }
        f60167b.addAll(C13350s.m80090b(context, false));
        f60167b.addAll(C13350s.m80090b(context, true));
    }

    /* renamed from: e */
    public static boolean m80038e(String str) {
        Iterator<String> it = f60167b.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m80039f(File file) {
        return file != null && file.exists() && file.isFile();
    }

    /* renamed from: g */
    public static void m80040g(Context context, String str, boolean z10, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (z10) {
            m80042i(context, str, str2);
        } else {
            m80041h(context, str);
        }
    }

    /* renamed from: h */
    public static void m80041h(Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(f60170e)) {
            C2111d.m12648d("MediaScanUtils", "supportAction is empty");
        } else {
            intent.setAction(f60170e);
        }
        m80050q(context, str, intent);
    }

    /* renamed from: i */
    public static void m80042i(Context context, String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C12462b.m74717a(str).isDirectory()) {
            C2111d.m12657m("MediaScanUtils", "folder can't scan with file broadcast");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        if (TextUtils.isEmpty(str2)) {
            m80050q(context, str, intent);
            return;
        }
        C12285d c12285dM80032r = C2105a.m12585a(str2) ? C13340i.m80032r(context, str2, str) : null;
        if (c12285dM80032r == null) {
            m80050q(context, str, intent);
            return;
        }
        if (c12285dM80032r.m73812c() != 0.0d && c12285dM80032r.m73813d() != 0.0d) {
            intent.putExtra(JsbMapKeyNames.H5_LOC_LAT, c12285dM80032r.m73812c());
            intent.putExtra(JsbMapKeyNames.H5_LOC_LON, c12285dM80032r.m73813d());
        }
        if (c12285dM80032r.m73811b() != 0) {
            intent.putExtra("datetaken", c12285dM80032r.m73811b());
        }
        m80050q(context, str, intent);
    }

    /* renamed from: j */
    public static void m80043j(Context context, String str, boolean z10, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (context == null) {
            C2111d.m12657m("MediaScanUtils", "context is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C2111d.m12657m("MediaScanUtils", "notifyMediaScan begin, path:" + str);
            return;
        }
        if (!new File(str).exists()) {
            C2111d.m12657m("MediaScanUtils", "file is not exist: " + str);
            return;
        }
        if (!TextUtils.isEmpty(f60170e) || m80035b(context)) {
            m80040g(context, str, z10, str2);
            C2111d.m12646b("MediaScanUtils", "is support scan folder");
        } else if (f60166a >= 19) {
            m80045l(context, str);
        } else {
            m80046m(context);
        }
    }

    /* renamed from: k */
    public static void m80044k(Context context, String str, boolean z10, boolean z11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m80043j(context, str, z10, null);
    }

    /* renamed from: l */
    public static void m80045l(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            m80049p(context, file.listFiles());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, null);
        }
    }

    /* renamed from: m */
    public static void m80046m(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MEDIA_MOUNTED");
            intent.setData(Uri.parse("file://"));
            intent.putExtra("filemanager.flag", true);
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: n */
    public static void m80047n(Context context, String str, String str2, String str3) {
        C12285d c12285dM80032r;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || context == null || !C2105a.m12585a(str2)) {
            return;
        }
        if ((!"wechat_record".equals(str2) || m80038e(str)) && (c12285dM80032r = C13340i.m80032r(context, str2, str)) != null) {
            m80048o(str3, c12285dM80032r);
        }
    }

    /* renamed from: o */
    public static void m80048o(String str, C12285d c12285d) {
        File fileM74717a = C12462b.m74717a(str);
        if (!fileM74717a.exists()) {
            C2111d.m12648d("MediaScanUtils", " setLastModified file is non-existent");
        } else {
            if (c12285d.m73810a() == 0) {
                C2111d.m12657m("MediaScanUtils", " getDateModified is 0");
                return;
            }
            try {
                C2111d.m12647c("MediaScanUtils", "setLastModified result: ", Boolean.valueOf(fileM74717a.setLastModified(c12285d.m73810a() * 1000)));
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("MediaScanUtils", "restoreFileProperties error IllegalArgumentException");
            }
        }
    }

    /* renamed from: p */
    public static void m80049p(Context context, File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            if (m80039f(file)) {
                try {
                    MediaScannerConnection.scanFile(context, new String[]{file.getCanonicalPath()}, null, null);
                } catch (IOException unused) {
                    C2111d.m12648d("MediaScanUtils", "getCanonicalPath fail");
                }
            }
        }
    }

    /* renamed from: q */
    public static void m80050q(Context context, String str, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        intent.setData(Uri.parse("file://" + str));
        if (C2157a.m13177L(context)) {
            C9140e.m57458a(intent, C9140e.m57459b("FLAG_HW_INTENT_TO_STRING_SAFELY"));
        }
        m80051r(context, intent);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x002b
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* renamed from: r */
    public static void m80051r(android.content.Context r8, android.content.Intent r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            java.lang.String r0 = "sendRealBroadcast IllegalAccessException "
            java.lang.String r1 = "sendRealBroadcast IllegalArgumentException "
            java.lang.String r2 = "sendRealBroadcast InvocationTargetException "
            java.lang.String r3 = "MediaScanUtils"
            java.lang.reflect.Method r4 = p699v4.C13341j.f60168c
            if (r4 == 0) goto L66
            java.lang.reflect.Method r5 = p699v4.C13341j.f60169d
            if (r5 != 0) goto L11
            goto L66
        L11:
            r5 = 0
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L2f java.lang.reflect.InvocationTargetException -> L31 java.lang.IllegalArgumentException -> L3c java.lang.IllegalAccessException -> L47
            r4.invoke(r6, r7)     // Catch: java.lang.Throwable -> L2f java.lang.reflect.InvocationTargetException -> L31 java.lang.IllegalArgumentException -> L3c java.lang.IllegalAccessException -> L47
            r8.sendBroadcast(r9)     // Catch: java.lang.Throwable -> L2f java.lang.reflect.InvocationTargetException -> L31 java.lang.IllegalArgumentException -> L3c java.lang.IllegalAccessException -> L47
            java.lang.reflect.Method r8 = p699v4.C13341j.f60169d     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            r8.invoke(r6, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            goto L51
        L23:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r2)
            goto L51
        L27:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r1)
            goto L51
        L2b:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r0)
            goto L51
        L2f:
            r8 = move-exception
            goto L52
        L31:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Method r8 = p699v4.C13341j.f60169d     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            r8.invoke(r6, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            goto L51
        L3c:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r1)     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Method r8 = p699v4.C13341j.f60169d     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            r8.invoke(r6, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            goto L51
        L47:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r0)     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Method r8 = p699v4.C13341j.f60169d     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
            r8.invoke(r6, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.IllegalArgumentException -> L27 java.lang.IllegalAccessException -> L2b
        L51:
            return
        L52:
            java.lang.reflect.Method r9 = p699v4.C13341j.f60169d     // Catch: java.lang.reflect.InvocationTargetException -> L5a java.lang.IllegalArgumentException -> L5e java.lang.IllegalAccessException -> L62
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L5a java.lang.IllegalArgumentException -> L5e java.lang.IllegalAccessException -> L62
            r9.invoke(r6, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L5a java.lang.IllegalArgumentException -> L5e java.lang.IllegalAccessException -> L62
            goto L65
        L5a:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r2)
            goto L65
        L5e:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r1)
            goto L65
        L62:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r0)
        L65:
            throw r8
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p699v4.C13341j.m80051r(android.content.Context, android.content.Intent):void");
    }
}
