package p454lj;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.cloud.pay.R$plurals;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.base.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;
import mk.C11477c;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0234s;
import p054cj.C1442a;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: lj.m */
/* loaded from: classes5.dex */
public class C11290m {

    /* renamed from: a */
    public static final Pattern f52945a = Pattern.compile("(\\d*)\\.[0]");

    /* renamed from: a */
    public static String m67740a(String str) {
        if (str != null) {
            return "CNY".equalsIgnoreCase(str) ? "¥" : Currency.getInstance(str).getSymbol();
        }
        C1442a.m8290i("FormatUtil", "formatCurrencySymbol currency is null.");
        return "";
    }

    /* renamed from: b */
    public static String m67741b(Context context, long j10) {
        try {
            DateFormat longDateFormat = android.text.format.DateFormat.getLongDateFormat(context);
            longDateFormat.setTimeZone(m67755p(context));
            return new StringBuilder(longDateFormat.format(new Date(j10))).toString();
        } catch (Exception e10) {
            C11839m.m70688i("FormatUtil", "formatDate exception: " + e10);
            return "";
        }
    }

    /* renamed from: c */
    public static String m67742c(Context context, long j10, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(m67755p(context));
        return new StringBuilder(simpleDateFormat.format(new Date(j10))).toString();
    }

    /* renamed from: d */
    public static String m67743d(Context context, long j10) {
        try {
            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
            dateFormat.setTimeZone(m67755p(context));
            return new StringBuilder(dateFormat.format(new Date(j10))).toString();
        } catch (Exception e10) {
            C11839m.m70688i("FormatUtil", "formatDateShort exception: " + e10);
            return "";
        }
    }

    /* renamed from: e */
    public static String m67744e(Context context, long j10, TimeZone timeZone) {
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        dateFormat.setTimeZone(timeZone);
        String str = dateFormat.format(new Date(j10));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(timeZone);
        String str2 = simpleDateFormat.format(new Date(j10));
        if (context.getResources().getConfiguration().getLayoutDirection() != 1) {
            return str + ' ' + str2;
        }
        return "\u202b" + str + ' ' + str2 + "\u202b";
    }

    /* renamed from: f */
    public static String m67745f(Context context, long j10, TimeZone timeZone) {
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(new Date(j10));
    }

    /* renamed from: g */
    public static String m67746g(Context context, long j10, int i10, boolean z10, boolean z11) {
        String str;
        if (!C13452e.m80781L().m80838O0()) {
            return C0223k.m1526i(context, j10, i10, z10, z11);
        }
        if (2252710346752L == j10) {
            str = "2.05";
        } else if (2413771620352L == j10) {
            str = "2.2";
        } else if (4451733602304L == j10) {
            str = "4.05";
        } else if (4612794875904L == j10) {
            str = "4.2";
        } else if (6650756857856L == j10) {
            str = "6.05";
        } else if (6811818131456L == j10) {
            str = "6.2";
        } else if (13247826624512L == j10) {
            str = "12.05";
        } else {
            if (13408887898112L != j10) {
                return C0223k.m1526i(context, j10, i10, z10, z11);
            }
            str = "12.2";
        }
        return context.getString(R$string.cloudpay_Emotion_TB, str);
    }

    /* renamed from: h */
    public static String m67747h(Context context, BigDecimal bigDecimal, String str, String str2) {
        if (context == null || bigDecimal == null) {
            C1442a.m8289e("FormatUtil", "formatPrice, context is null or price is null");
            return "";
        }
        String strM1631i = C0234s.m1631i();
        return (FeedbackConst.SDK.EMUI_LANGUAGE.equals(strM1631i) || (HNConstants.Language.CN_STANDARD.equals(strM1631i) && "CNY".equals(str))) ? context.getString(com.huawei.cloud.pay.R$string.price_format_yuan, m67748i(bigDecimal)) : m67749j(bigDecimal, str, str2);
    }

    /* renamed from: i */
    public static String m67748i(BigDecimal bigDecimal) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.##");
        String str = decimalFormat.format(bigDecimal);
        return Pattern.compile("(\\d*)\\.[0]{1}").matcher(str).matches() ? str.replace(".0", "") : Pattern.compile("(\\d*)\\.[0]{2}").matcher(str).matches() ? str.replace(".00", "") : str;
    }

    /* renamed from: j */
    public static String m67749j(BigDecimal bigDecimal, String str, String str2) {
        try {
            StringBuilder sb2 = new StringBuilder();
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            decimalFormat.applyPattern("0.##");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            String strReplace = decimalFormat.format(bigDecimal);
            int length = 0;
            if (Pattern.compile("(\\d*)\\.[0]{1}").matcher(strReplace).matches()) {
                strReplace = strReplace.replace(".0", "");
            } else if (Pattern.compile("(\\d*)\\.[0]{2}").matcher(strReplace).matches()) {
                strReplace = strReplace.replace(".00", "");
            } else {
                int iIndexOf = strReplace.indexOf(".");
                if (iIndexOf >= 0) {
                    length = (strReplace.length() - iIndexOf) - 1;
                }
            }
            if ("CNY".equalsIgnoreCase(str)) {
                sb2.append("¥");
                sb2.append(strReplace);
                return sb2.toString();
            }
            if (TextUtils.isEmpty(str)) {
                sb2.append(str2);
                sb2.append(strReplace);
                return sb2.toString();
            }
            Currency currency = Currency.getInstance(str);
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            currencyInstance.setCurrency(currency);
            currencyInstance.setMaximumFractionDigits(length);
            return currencyInstance.format(bigDecimal);
        } catch (Exception e10) {
            C1442a.m8289e("FormatUtil", "formatPriceAndSymbol err:" + e10.toString());
            return "";
        }
    }

    /* renamed from: k */
    public static String m67750k(BigDecimal bigDecimal) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.##");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        String str = decimalFormat.format(bigDecimal);
        return Pattern.compile("(\\d*)\\.[0]{1}").matcher(str).matches() ? str.replace(".0", "") : Pattern.compile("(\\d*)\\.[0]{2}").matcher(str).matches() ? str.replace(".00", "") : str;
    }

    /* renamed from: l */
    public static String m67751l(Context context, long j10, long j11) {
        return context.getString(com.huawei.cloud.pay.R$string.cloudpay_used_total_space, C0223k.m1524g(context, j10), C0223k.m1524g(context, j11));
    }

    /* renamed from: m */
    public static String m67752m(Context context, long j10, long j11) {
        return context.getString(com.huawei.cloud.pay.R$string.cloudpay_used_total_space, m67746g(context, j10, 1024, true, true), m67746g(context, j11, 1024, true, true));
    }

    /* renamed from: n */
    public static String m67753n(Resources resources, long j10, int i10) {
        return resources.getString(com.huawei.cloud.pay.R$string.cancel_auto_renewal_new_business_time, i10 <= 0 ? resources.getString(com.huawei.cloud.pay.R$string.main_today) : resources.getQuantityString(R$plurals.common_days, i10, Integer.valueOf(i10)), android.text.format.DateFormat.getLongDateFormat(C0213f.m1377a()).format(new Date(j10)));
    }

    /* renamed from: o */
    public static String m67754o(BigDecimal bigDecimal, String str, String str2, int i10, Context context) {
        if (context == null) {
            return "";
        }
        String strM67749j = m67749j(bigDecimal, str, str2);
        return i10 == 1 ? context.getString(com.huawei.cloud.pay.R$string.cloudpay_exchange_month_price, strM67749j) : i10 == 12 ? context.getString(com.huawei.cloud.pay.R$string.cloudpay_exchange_year_price, strM67749j) : context.getString(com.huawei.cloud.pay.R$string.cloudpay_exchange_phase_price, strM67749j);
    }

    /* renamed from: p */
    public static TimeZone m67755p(Context context) {
        String strM68633c = C11477c.m68633c(C11282e.m67709b(context).m67712d("ACCOUNT_REGISTER_TIMEZONE"));
        return TextUtils.isEmpty(strM68633c) ? TimeZone.getDefault() : TimeZone.getTimeZone(strM68633c);
    }
}
