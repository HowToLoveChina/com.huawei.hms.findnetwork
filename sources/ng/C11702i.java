package ng;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import fk.C9721b;
import java.net.URL;
import mu.C11526c;
import p015ak.C0214f0;
import p521og.C11877j;
import p575qe.C12347f;
import p681uj.C13195l;
import p809yg.C13981a;
import tm.C13040c;

/* renamed from: ng.i */
/* loaded from: classes4.dex */
public class C11702i {

    /* renamed from: a */
    public static String f54184a;

    /* renamed from: b */
    public static String f54185b;

    /* renamed from: c */
    public static String f54186c;

    /* renamed from: d */
    public static String f54187d;

    /* renamed from: a */
    public static void m69785a() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C12347f.m74285n().m74301m(), "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.remove("wap_has_login");
            editorEdit.remove("wap_country_code");
            editorEdit.apply();
        }
        m69804t("");
        m69800p("");
        m69803s("");
    }

    /* renamed from: b */
    public static String m69786b() {
        try {
            return C13195l.m79272J().m79344y("WapAccount", "");
        } catch (Exception e10) {
            C13981a.m83988e("WapAccountUtils", "getAccessToken exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static String m69787c(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String protocol = new URL(str).getProtocol();
            String strM68805b = C11526c.m68805b(str);
            if (TextUtils.isEmpty(protocol) || TextUtils.isEmpty(strM68805b) || (iIndexOf = strM68805b.indexOf(".")) == -1) {
                return str;
            }
            return protocol + "://" + strM68805b.substring(0, iIndexOf - 1) + strM68805b.substring(iIndexOf);
        } catch (Exception e10) {
            C13981a.m83988e("WapAccountUtils", "parse Url error:" + e10.getMessage());
        }
        return str;
    }

    /* renamed from: d */
    public static String m69788d() {
        try {
            return C13040c.m78609F().m78667t();
        } catch (C9721b e10) {
            C13981a.m83988e("WapAccountUtils", "getCasUrl: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: e */
    public static String m69789e() {
        return f54187d;
    }

    /* renamed from: f */
    public static String m69790f() {
        return f54185b;
    }

    /* renamed from: g */
    public static String m69791g() {
        try {
            String strM78625Q = C13040c.m78609F().m78625Q();
            if (TextUtils.isEmpty(strM78625Q)) {
                return "";
            }
            m69799o(strM78625Q);
            return strM78625Q + "/wapFindPhone";
        } catch (C9721b e10) {
            C13981a.m83988e("WapAccountUtils", "getWapFindPhone " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: h */
    public static String m69792h() {
        try {
            String strM78625Q = C13040c.m78609F().m78625Q();
            if (TextUtils.isEmpty(strM78625Q)) {
                C13981a.m83990w("WapAccountUtils", "getWapFindPhoneHtml url is null");
                return "";
            }
            return strM78625Q + "/wapFindPhone.html";
        } catch (C9721b e10) {
            C13981a.m83988e("WapAccountUtils", "getWapFindPhoneHtml:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: i */
    public static boolean m69793i(Context context) {
        return C11877j.m71317y(context);
    }

    /* renamed from: j */
    public static String m69794j() {
        if (TextUtils.isEmpty(f54186c)) {
            C13981a.m83989i("WapAccountUtils", "get wapFindPhone from grs");
            f54186c = m69791g();
        }
        if (TextUtils.isEmpty(f54186c)) {
            C13981a.m83988e("WapAccountUtils", "wapFindPhone is empty");
            return "";
        }
        String strM69824t = C11703j.m69824t(f54186c);
        f54186c = strM69824t;
        return strM69824t;
    }

    /* renamed from: k */
    public static String m69795k() {
        return f54184a;
    }

    /* renamed from: l */
    public static boolean m69796l(String str) {
        String strM69787c = m69787c(str);
        return !TextUtils.isEmpty(strM69787c) && strM69787c.equals(m69787c(m69788d()));
    }

    /* renamed from: m */
    public static boolean m69797m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strM69824t = C11703j.m69824t(str);
        String strM69794j = m69794j();
        if (strM69824t != null && strM69794j != null && strM69824t.startsWith(strM69794j)) {
            return true;
        }
        C13981a.m83989i("WapAccountUtils", "url does not start with wapFindPhone");
        return false;
    }

    /* renamed from: n */
    public static String m69798n(String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("&relogin=true", "");
    }

    /* renamed from: o */
    public static void m69799o(String str) {
        f54187d = str;
    }

    /* renamed from: p */
    public static void m69800p(String str) {
        f54185b = str;
    }

    /* renamed from: q */
    public static void m69801q(Context context, String str) {
        C11877j.m71213I0(context, str);
    }

    /* renamed from: r */
    public static void m69802r(Context context, boolean z10) {
        C11877j.m71215J0(context, z10);
    }

    /* renamed from: s */
    public static void m69803s(String str) {
        f54186c = str;
    }

    /* renamed from: t */
    public static void m69804t(String str) {
        f54184a = str;
    }
}
