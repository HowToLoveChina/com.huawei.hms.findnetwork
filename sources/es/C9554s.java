package es;

import android.os.Build;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import java.util.HashMap;
import java.util.Map;

/* renamed from: es.s */
/* loaded from: classes8.dex */
public class C9554s {

    /* renamed from: a */
    public static Map<String, String> f47465a;

    /* renamed from: b */
    public static volatile String f47466b;

    /* renamed from: c */
    public static volatile String f47467c;

    /* renamed from: d */
    public static volatile String f47468d;

    /* renamed from: e */
    public static volatile String f47469e;

    /* renamed from: f */
    public static volatile String f47470f;

    /* renamed from: g */
    public static volatile String f47471g;

    /* renamed from: a */
    public static String m59646a(String str, String str2) {
        Object objM59640d;
        try {
            objM59640d = C9551p.m59640d(null, C9551p.m59639c(C9551p.m59638b("android.os.SystemProperties"), "get", String.class, String.class), str, str2);
        } catch (Exception unused) {
            C1016d.m6183c("SystemPropertiesUtil", "get SystemProperties Exception");
        }
        String str3 = objM59640d instanceof String ? (String) objM59640d : str2;
        if (TextUtils.equals(str3, str2)) {
            String strM59650e = m59650e(str);
            if (!TextUtils.isEmpty(strM59650e)) {
                return m59646a(strM59650e, str2);
            }
        }
        return str3;
    }

    /* renamed from: b */
    public static String m59647b() {
        if (!TextUtils.isEmpty(f47468d)) {
            return f47468d;
        }
        f47468d = m59646a("ro.build.version.release", "NULL");
        return f47468d;
    }

    /* renamed from: c */
    public static String m59648c() {
        if (!TextUtils.isEmpty(f47466b)) {
            return f47466b;
        }
        f47466b = m59646a("ro.build.characteristics", "");
        return f47466b;
    }

    /* renamed from: d */
    public static String m59649d() {
        if (!TextUtils.isEmpty(f47467c)) {
            return f47467c;
        }
        f47467c = m59646a("ro.build.version.emui", "NULL");
        return f47467c;
    }

    /* renamed from: e */
    public static synchronized String m59650e(String str) {
        try {
            if (f47465a == null) {
                m59655j();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f47465a.get(str);
    }

    /* renamed from: f */
    public static String m59651f() {
        if (!TextUtils.isEmpty(f47471g)) {
            return f47471g;
        }
        f47471g = m59646a("ro.board.platform", "");
        return f47471g;
    }

    /* renamed from: g */
    public static String m59652g() {
        if (!TextUtils.isEmpty(f47470f)) {
            return f47470f;
        }
        f47470f = m59646a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
        return f47470f;
    }

    /* renamed from: h */
    public static String m59653h(String str, String str2) {
        return m59646a(str, str2);
    }

    /* renamed from: i */
    public static String m59654i() {
        if (!TextUtils.isEmpty(f47469e)) {
            return f47469e;
        }
        String[] strArr = {m59646a("ro.build.realversion.id", "NULL"), m59646a("ro.build.cust.id", "NULL"), m59646a("ro.build.display.id", "NULL")};
        f47469e = Build.DISPLAY;
        int i10 = 0;
        while (true) {
            if (i10 >= 3) {
                break;
            }
            String str = strArr[i10];
            if (!"NULL".equals(str)) {
                f47469e = str;
                break;
            }
            i10++;
        }
        return f47469e;
    }

    /* renamed from: j */
    public static void m59655j() {
        HashMap map = new HashMap(4);
        f47465a = map;
        map.put(CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP, CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP_HN);
        f47465a.put("ro.build.hw_emui_api_level", "ro.build.magic_api_level");
        f47465a.put("ro.build.version.emui", "ro.build.version.magic");
        f47465a.put("ro.config.hw_nlp", "msc.config.nlp");
    }
}
