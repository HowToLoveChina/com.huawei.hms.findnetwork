package p396jh;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import kh.C11054a;
import p208cq.C8941i;
import p453lh.C11276a;

/* renamed from: jh.a */
/* loaded from: classes4.dex */
public class C10890a {
    /* renamed from: a */
    public static void m65881a(Context context) {
        C11276a.m67671a(context).m67676f(null);
        C11276a.m67671a(context).m67672b();
    }

    /* renamed from: b */
    public static void m65882b(C8941i<String> c8941i, Context context, String str) throws Throwable {
        Exception exc;
        String strM66622a = C11054a.m66622a(context);
        if (strM66622a == null) {
            Log.w("MarketHomeCountryByProvider", "get verify market package name is null");
            m65881a(context);
            exc = new Exception("get verify market package name is null");
        } else {
            String str2 = String.format(Locale.ROOT, "content://%s.commondata/item/1", strM66622a);
            if (m65884d(context, Uri.parse(str2), strM66622a)) {
                m65883c(c8941i, context, str2, str);
                return;
            } else {
                Log.w("MarketHomeCountryByProvider", "homeCountry uri is invalid");
                m65881a(context);
                exc = new Exception("homeCountry uri is invalid");
            }
        }
        c8941i.m56657c(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0087 A[Catch: all -> 0x0055, Exception -> 0x0083, TRY_LEAVE, TryCatch #9 {Exception -> 0x0083, all -> 0x0055, blocks: (B:5:0x001b, B:7:0x0021, B:9:0x002d, B:19:0x005b, B:21:0x0070, B:22:0x007f, B:24:0x0087), top: B:63:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m65883c(p208cq.C8941i<java.lang.String> r11, android.content.Context r12, java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p396jh.C10890a.m65883c(cq.i, android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: d */
    public static boolean m65884d(Context context, Uri uri, String str) {
        if (uri == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            Log.w("MarketHomeCountryByProvider", "isProviderValid, invalid provider: " + uri);
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null || !TextUtils.equals(str, applicationInfo.packageName)) {
            return false;
        }
        Log.i("MarketHomeCountryByProvider", "valid provider uri = " + uri);
        return true;
    }
}
