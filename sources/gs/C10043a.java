package gs;

import android.text.TextUtils;
import as.C1016d;
import es.C9555t;

/* renamed from: gs.a */
/* loaded from: classes8.dex */
public class C10043a {
    /* renamed from: a */
    public static String m62448a() {
        if (C9555t.m59664i()) {
            C1016d.m6181a("CountryCodeUtil", "airplane Mode is on");
            return "UNKNOWN";
        }
        String strM59661f = C9555t.m59661f();
        if (TextUtils.isEmpty(strM59661f) && !C9555t.m59665j()) {
            strM59661f = C9555t.m59662g();
        }
        if (!TextUtils.isEmpty(strM59661f)) {
            return strM59661f;
        }
        C1016d.m6181a("CountryCodeUtil", "get countryCode is UNKNOWN");
        return "UNKNOWN";
    }

    /* renamed from: b */
    public static boolean m62449b(String str) {
        return (TextUtils.isEmpty(str) || "UNKNOWN".equals(str)) ? false : true;
    }
}
