package p015ak;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Locale;
import p399jk.AbstractC10896a;
import uk.C13206d;

/* renamed from: ak.s */
/* loaded from: classes6.dex */
public class C0234s {
    /* renamed from: a */
    public static String m1623a(String str, String str2, int i10) {
        String strM1631i = i10 == 1 ? m1631i() : i10 == 2 ? m1631i().toLowerCase() : i10 == 3 ? m1632j() : i10 == 4 ? m1632j().toLowerCase(Locale.ROOT) : "";
        return StringUtil.isBlank(strM1631i) ? str : C13206d.m79403c(str, str2, strM1631i);
    }

    /* renamed from: b */
    public static String m1624b(Context context, int i10) {
        if (m1642t()) {
            return context.getString(i10);
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(Locale.US);
        return context.createConfigurationContext(configuration).getResources().getString(i10);
    }

    /* renamed from: c */
    public static String m1625c() {
        return m1642t() ? m1632j() : HNConstants.Language.EN_STANDARD;
    }

    /* renamed from: d */
    public static String m1626d() {
        return Locale.getDefault().getCountry();
    }

    /* renamed from: e */
    public static String m1627e() {
        return m1629g("-");
    }

    /* renamed from: f */
    public static String m1628f() {
        return m1629g("_");
    }

    /* renamed from: g */
    public static String m1629g(String str) {
        String strM1636n = m1636n();
        String strM1626d = m1626d();
        String strM1637o = m1637o();
        if (TextUtils.isEmpty(strM1636n)) {
            return "";
        }
        Locale locale = Locale.US;
        String lowerCase = strM1636n.toLowerCase(locale);
        String lowerCase2 = strM1626d.toLowerCase(locale);
        if (TextUtils.isEmpty(strM1637o)) {
            return lowerCase + str + lowerCase2;
        }
        if (strM1636n.equals("my") && strM1637o.equals("Qaag")) {
            return "my-zg";
        }
        if (strM1636n.equals(FaqConstants.DEFAULT_ISO_LANGUAGE) && strM1637o.equals("Qaag")) {
            return "en-gb";
        }
        return lowerCase + str + lowerCase2;
    }

    /* renamed from: h */
    public static String m1630h(String str) {
        String strM1636n = m1636n();
        String strM1626d = m1626d();
        String strM1637o = m1637o();
        if (TextUtils.isEmpty(strM1636n)) {
            return "";
        }
        if (TextUtils.isEmpty(strM1637o)) {
            return strM1636n + str + strM1626d;
        }
        if (strM1636n.equals("my") && strM1637o.equals("Qaag")) {
            return "my-ZG";
        }
        if (strM1636n.equals(FaqConstants.DEFAULT_ISO_LANGUAGE) && strM1637o.equals("Qaag")) {
            return "en-GB";
        }
        if (strM1636n.equals("zh") && strM1637o.equals("Hans")) {
            return "zh" + str + "CN";
        }
        return strM1636n + str + strM1626d;
    }

    /* renamed from: i */
    public static String m1631i() {
        return m1630h("-");
    }

    /* renamed from: j */
    public static String m1632j() {
        return m1630h("_");
    }

    /* renamed from: k */
    public static String m1633k(String str) {
        String strM1637o = m1637o();
        String strM1636n = m1636n();
        String strM1626d = m1626d();
        if (TextUtils.isEmpty(strM1636n)) {
            return "";
        }
        if (TextUtils.isEmpty(strM1637o)) {
            return strM1636n + str + strM1626d;
        }
        if (strM1636n.equals("my") && strM1637o.equals("Qaag")) {
            return "my-ZG";
        }
        if (strM1636n.equals(FaqConstants.DEFAULT_ISO_LANGUAGE) && strM1637o.equals("Qaag")) {
            return "en-GB";
        }
        return strM1636n + str + strM1637o + str + strM1626d;
    }

    /* renamed from: l */
    public static String m1634l() {
        return m1633k("-");
    }

    /* renamed from: m */
    public static String m1635m() {
        return m1633k("_");
    }

    /* renamed from: n */
    public static String m1636n() {
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: o */
    public static String m1637o() {
        return Locale.getDefault().getScript();
    }

    /* renamed from: p */
    public static String m1638p() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry().toLowerCase(Locale.US);
    }

    /* renamed from: q */
    public static void m1639q(Activity activity) {
        try {
            new LanguagePlugin().activityInit(activity);
        } catch (ExceptionInInitializerError e10) {
            AbstractC10896a.m65886e("LanguageUtil", "initLanguagePlugin ExceptionInInitializerError: " + e10.toString());
        }
    }

    /* renamed from: r */
    public static boolean m1640r(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!Character.isLowerCase(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: s */
    public static boolean m1641s(String str) {
        String strReplace = str.replace("-", "").replace("_", "");
        for (int i10 = 0; i10 < strReplace.length(); i10++) {
            if (!Character.isLowerCase(strReplace.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: t */
    public static boolean m1642t() {
        String strM1636n = m1636n();
        AbstractC10896a.m65885d("LanguageUtil", "current status: language = " + strM1636n + " ,country = " + m1626d() + " ,script = " + m1637o());
        return strM1636n.equals("zh") || strM1636n.equals("ug") || strM1636n.equals("bo") || strM1636n.equals(FaqConstants.DEFAULT_ISO_LANGUAGE);
    }

    /* renamed from: u */
    public static boolean m1643u() {
        return "bo".equalsIgnoreCase(m1636n());
    }

    /* renamed from: v */
    public static int m1644v(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strM79402b = C13206d.m79402b(str, str2);
        if (TextUtils.isEmpty(strM79402b)) {
            return 1;
        }
        boolean zM1641s = z10 ? m1641s(strM79402b) : m1640r(strM79402b);
        if (strM79402b.contains("-")) {
            return zM1641s ? 2 : 1;
        }
        if (strM79402b.contains("_")) {
            return zM1641s ? 4 : 3;
        }
        return 1;
    }
}
