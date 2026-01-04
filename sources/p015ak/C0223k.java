package p015ak;

import android.content.Context;
import android.text.BidiFormatter;
import android.text.TextUtils;
import com.huawei.hicloud.base.R$string;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;
import mk.C11477c;
import p399jk.AbstractC10896a;

/* renamed from: ak.k */
/* loaded from: classes6.dex */
public class C0223k {
    /* renamed from: a */
    public static boolean m1518a(double d10, double d11) {
        return Math.abs(d10 - d11) < 1.0E-10d;
    }

    /* renamed from: b */
    public static String m1519b(Context context, long j10, String str) {
        DateFormat longDateFormat = android.text.format.DateFormat.getLongDateFormat(context);
        longDateFormat.setTimeZone(m1528k(str));
        return new StringBuilder(longDateFormat.format(new Date(j10))).toString();
    }

    /* renamed from: c */
    public static String m1520c(Context context, long j10) {
        return m1521d(context, j10, 1024);
    }

    /* renamed from: d */
    public static String m1521d(Context context, long j10, int i10) {
        return m1522e(context, j10, i10, "0.##", false);
    }

    /* renamed from: e */
    public static String m1522e(Context context, long j10, int i10, String str, boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            context = contextM1377a;
        } else if (context == null) {
            AbstractC10896a.m65886e("FormatUtil", "formatSpace context is null.");
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern(str);
        float fRound = j10;
        int i11 = R$string.cloudpay_Emotion_B;
        if (fRound >= 900.0f) {
            i11 = R$string.cloudpay_Emotion_KB;
            fRound /= i10;
        }
        if (fRound >= 900.0f) {
            fRound /= i10;
            i11 = R$string.cloudpay_Emotion_MB;
        }
        if (fRound >= 900.0f) {
            fRound /= i10;
            i11 = R$string.cloudpay_Emotion_GB;
        }
        if (z10) {
        }
        if (m1527j()) {
            float f10 = i10;
            if (fRound % f10 == 0.0f) {
                float f11 = fRound / f10;
                if (f11 > 0.0f) {
                    i11 = R$string.cloudpay_Emotion_TB;
                    fRound = f11;
                }
            }
        }
        return m1523f(context.getString(i11, decimalFormat.format(fRound)));
    }

    /* renamed from: f */
    public static String m1523f(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("(\\d*)\\.[0]{1} (\\w*)").matcher(str).matches() ? str.replace(".0", "") : Pattern.compile("(\\d*)\\.[0]{2} (\\w*)").matcher(str).matches() ? str.replace(".00", "") : str;
    }

    /* renamed from: g */
    public static String m1524g(Context context, long j10) {
        return m1525h(context, j10, 1024);
    }

    /* renamed from: h */
    public static String m1525h(Context context, long j10, int i10) {
        return m1526i(context, j10, i10, true, false);
    }

    /* renamed from: i */
    public static String m1526i(Context context, long j10, int i10, boolean z10, boolean z11) {
        int i11;
        double dM1530m;
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            context = contextM1377a;
        } else if (context == null) {
            AbstractC10896a.m65886e("FormatUtil", "formatSpace context is null.");
            return null;
        }
        if (j10 == 0) {
            return z10 ? m1523f(context.getString(R$string.cloudpay_Emotion_GB, NumberFormat.getInstance().format(0L))) : m1523f(context.getString(R$string.cloudpay_Emotion_KB, NumberFormat.getInstance().format(0L)));
        }
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        double d10 = j10;
        if (z11) {
            i11 = R$string.cloudpay_Emotion_MB;
            double d11 = i10;
            double d12 = (d10 / d11) / d11;
            if (d12 >= 1.0d) {
                d = d12;
            }
        } else {
            i11 = R$string.cloudpay_Emotion_KB;
            double d13 = i10;
            double d14 = d10 / d13;
            d = d14 >= 1.0d ? d14 : 1.0d;
            if (d >= 900.0d) {
                d /= d13;
                i11 = R$string.cloudpay_Emotion_MB;
            }
        }
        if (d >= 900.0d) {
            d /= i10;
            i11 = R$string.cloudpay_Emotion_GB;
        }
        if (d >= 900.0d) {
            d /= i10;
            i11 = R$string.cloudpay_Emotion_TB;
        }
        if (d >= 15.0d || !(i11 == R$string.cloudpay_Emotion_GB || i11 == R$string.cloudpay_Emotion_TB)) {
            dM1530m = m1530m(d, 0);
        } else {
            decimalFormat.applyPattern("0.#");
            dM1530m = m1530m(d, 1);
        }
        return m1523f(context.getString(i11, decimalFormat.format(dM1530m)));
    }

    /* renamed from: j */
    public static boolean m1527j() {
        return C0214f0.m1382b(C0213f.m1377a(), "account_info", 0).getBoolean("is_bm_type", false);
    }

    /* renamed from: k */
    public static TimeZone m1528k(String str) {
        String strM68633c = C11477c.m68633c(str);
        return TextUtils.isEmpty(strM68633c) ? TimeZone.getDefault() : TimeZone.getTimeZone(strM68633c);
    }

    /* renamed from: l */
    public static String m1529l(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        return (!bidiFormatter.isRtlContext() || bidiFormatter.isRtl(str)) ? str : bidiFormatter.unicodeWrap(str);
    }

    /* renamed from: m */
    public static double m1530m(double d10, int i10) {
        AbstractC10896a.m65887i("FormatUtil", "sevenRounding enter, number = " + d10 + ", bitness = " + i10);
        if (m1518a(d10, 0.0d)) {
            return 0.0d;
        }
        double dPow = (long) Math.pow(10.0d, i10);
        double d11 = d10 * dPow;
        double dCeil = (d11 - Math.floor(d11) >= 0.8d ? Math.ceil(d11) : Math.floor(d11)) / dPow;
        AbstractC10896a.m65887i("FormatUtil", "sevenRounding exit, result = " + dCeil);
        return dCeil;
    }
}
