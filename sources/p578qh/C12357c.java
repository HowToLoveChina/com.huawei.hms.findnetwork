package p578qh;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import java.util.Locale;

/* renamed from: qh.c */
/* loaded from: classes4.dex */
public class C12357c {

    /* renamed from: a */
    public static int f57160a = -1;

    /* renamed from: a */
    public static String m74382a() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        String script = locale.getScript();
        if (TextUtils.isEmpty(script) && TextUtils.isEmpty(variant)) {
            return language + "_" + country;
        }
        return language + "_" + script + "_" + country + "_" + variant;
    }

    /* renamed from: b */
    public static boolean m74383b() {
        if (f57160a == -1) {
            f57160a = ("zh".equals(C12359e.m74386b("ro.product.locale.language")) && "CN".equals(C12359e.m74386b(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP))) ? 0 : 1;
        }
        return f57160a == 1;
    }
}
