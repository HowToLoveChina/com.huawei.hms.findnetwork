package cn.com.miaozhen.mobile.tracking.util;

import android.content.Context;
import cn.com.miaozhen.mobile.tracking.p055a.C1471h;
import cn.com.miaozhen.mobile.tracking.util.C1488e;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import ijiami_release01.NCall;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Reader;
import java.util.HashMap;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.f */
/* loaded from: classes.dex */
public class C1489f {

    /* renamed from: a */
    private static boolean f6363a = false;

    /* renamed from: b */
    public static final String f6364b = null;

    /* renamed from: c */
    public static final String[] f6365c = null;

    /* renamed from: d */
    public static String f6366d;

    /* renamed from: cn.com.miaozhen.mobile.tracking.util.f$a */
    public static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f6367a;

        /* renamed from: b */
        final /* synthetic */ String f6368b;

        /* renamed from: cn.com.miaozhen.mobile.tracking.util.f$a$a, reason: collision with other inner class name */
        public class C14416a implements C1488e.a {
            public C14416a() {
            }

            @Override // cn.com.miaozhen.mobile.tracking.util.C1488e.a
            /* renamed from: a */
            public void mo8437a(String str) {
                NCall.m64618IV(new Object[]{108, this, str});
            }
        }

        public a(Context context, String str) {
            this.f6367a = context;
            this.f6368b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.m64618IV(new Object[]{109, this});
        }
    }

    static {
        NCall.m64618IV(new Object[]{114});
    }

    /* renamed from: a */
    public static int m8438a() {
        return NCall.m64614II(new Object[]{115});
    }

    /* renamed from: b */
    public static String m8449b() {
        return (String) NCall.m64616IL(new Object[]{125});
    }

    /* renamed from: c */
    public static int m8451c(Context context) {
        return NCall.m64614II(new Object[]{127, context});
    }

    /* renamed from: d */
    public static int m8453d() {
        return NCall.m64614II(new Object[]{Integer.valueOf(SyncType.WLAN_CHANGE)});
    }

    /* renamed from: e */
    public static String m8455e(Context context) {
        return (String) NCall.m64616IL(new Object[]{Integer.valueOf(SyncType.AUTO_SYNC_CALLLOG), context});
    }

    /* renamed from: f */
    public static String m8456f(Context context) {
        return (String) NCall.m64616IL(new Object[]{Integer.valueOf(SyncType.AUTO_SYNC_RECORD), context});
    }

    /* renamed from: g */
    public static int m8457g(Context context) {
        return NCall.m64614II(new Object[]{Integer.valueOf(SyncType.OPEN_SWITCH_MANUALLY), context});
    }

    /* renamed from: h */
    public static boolean m8458h(Context context) {
        return NCall.m64619IZ(new Object[]{Integer.valueOf(SyncType.OPEN_SWITCH_FROM_GUIDE), context});
    }

    /* renamed from: i */
    public static String m8459i(Context context) {
        return (String) NCall.m64616IL(new Object[]{Integer.valueOf(SyncType.RISK_MANAGEMENT_MANUALLY), context});
    }

    /* renamed from: j */
    public static String m8460j(Context context) {
        return (String) NCall.m64616IL(new Object[]{Integer.valueOf(SyncType.AUTO_SYNC_PHONE_MANAGER), context});
    }

    /* renamed from: a */
    public static String m8439a(Context context, C1471h c1471h) {
        return (String) NCall.m64616IL(new Object[]{116, context, c1471h});
    }

    /* renamed from: b */
    public static String m8450b(Context context) {
        return (String) NCall.m64616IL(new Object[]{126, context});
    }

    /* renamed from: c */
    public static String m8452c() {
        return (String) NCall.m64616IL(new Object[]{128});
    }

    /* renamed from: d */
    public static String m8454d(Context context) {
        return (String) NCall.m64616IL(new Object[]{130, context});
    }

    /* renamed from: a */
    private static String m8440a(C1471h c1471h) {
        return (String) NCall.m64616IL(new Object[]{117, c1471h});
    }

    /* renamed from: a */
    public static String m8441a(String str, String str2) {
        return (String) NCall.m64616IL(new Object[]{118, str, str2});
    }

    /* renamed from: a */
    public static HashMap<String, String> m8442a(String str, String str2, String str3) {
        return (HashMap) NCall.m64616IL(new Object[]{119, str, str2, str3});
    }

    /* renamed from: a */
    public static void m8443a(FileInputStream fileInputStream) {
        NCall.m64618IV(new Object[]{120, fileInputStream});
    }

    /* renamed from: a */
    public static void m8444a(FileOutputStream fileOutputStream) {
        NCall.m64618IV(new Object[]{121, fileOutputStream});
    }

    /* renamed from: a */
    public static void m8445a(Reader reader) {
        NCall.m64618IV(new Object[]{122, reader});
    }

    /* renamed from: a */
    private static boolean m8446a(Context context) {
        return NCall.m64619IZ(new Object[]{123, context});
    }

    /* renamed from: a */
    public static boolean m8447a(Context context, String str) {
        return NCall.m64619IZ(new Object[]{124, context, str});
    }
}
