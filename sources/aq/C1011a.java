package aq;

import android.text.TextUtils;
import ck.C1443a;
import java.text.NumberFormat;

/* renamed from: aq.a */
/* loaded from: classes8.dex */
public class C1011a {
    /* renamed from: a */
    public static String m6161a() {
        String strM6162b = m6162b(0.1d, m6164d(10));
        String strM6163c = m6163c(10);
        return strM6162b.contains(strM6163c) ? strM6162b.replaceAll(strM6163c, "") : "%";
    }

    /* renamed from: b */
    public static String m6162b(double d10, int i10) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMaximumIntegerDigits(i10);
        return percentInstance.format(d10);
    }

    /* renamed from: c */
    public static String m6163c(Object obj) {
        return obj == null ? "" : NumberFormat.getNumberInstance().format(obj);
    }

    /* renamed from: d */
    public static int m6164d(int i10) {
        if (i10 > 0) {
            return String.valueOf(i10).length();
        }
        return 0;
    }

    /* renamed from: e */
    public static boolean m6165e(String str) {
        return !TextUtils.isEmpty(str) && str.length() == C1443a.f6213a.length() && str.matches("\\d+");
    }
}
