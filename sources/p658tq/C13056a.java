package p658tq;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p237du.C9310c;
import p640sq.C12836o;
import p640sq.C12843v;

/* renamed from: tq.a */
/* loaded from: classes8.dex */
public class C13056a {
    /* renamed from: a */
    public static String m78781a() {
        String strM77126c = C12843v.m77126c();
        if (TextUtils.isEmpty(strM77126c) || "NULL".equals(strM77126c)) {
            C12836o.m77097b("BiReportUtils", "TransID get imei is null", true);
            return null;
        }
        return C9310c.m58618b(strM77126c + m78782b("yyyyMMddHHmmssSSS"));
    }

    /* renamed from: b */
    public static String m78782b(String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: c */
    public static void m78783c(Context context, int i10, int i11, String str, String str2, String str3, String str4) {
    }
}
