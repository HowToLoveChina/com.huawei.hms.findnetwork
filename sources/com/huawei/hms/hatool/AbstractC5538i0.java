package com.huawei.hms.hatool;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.hms.hatool.i0 */
/* loaded from: classes8.dex */
public abstract class AbstractC5538i0 {
    /* renamed from: a */
    public static String m32571a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(AbstractC5579z.m32828a(str, str2))) {
            return AbstractC5579z.m32828a(str, str2);
        }
        C5571v.m32786a("hmsSdk", "getAndroidId(): to getConfigByType()");
        return m32573c(context, str, str2);
    }

    /* renamed from: b */
    public static String m32572b(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            C5571v.m32797f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return m32574d(context, str, str2);
    }

    /* renamed from: c */
    private static String m32573c(Context context, String str, String str2) {
        if (!AbstractC5579z.m32829b(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(AbstractC5562q0.m32708d())) {
            C5565s.m32733c().m32738b().m32526b(AbstractC5555o.m32666a(context));
        }
        return AbstractC5562q0.m32708d();
    }

    /* renamed from: d */
    private static String m32574d(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        if (!TextUtils.isEmpty(AbstractC5515a1.m32429d(str, str2))) {
            return AbstractC5515a1.m32429d(str, str2);
        }
        C5533g1 c5533g1M32738b = C5565s.m32733c().m32738b();
        if (TextUtils.isEmpty(c5533g1M32738b.m32537h())) {
            String strM32670b = AbstractC5555o.m32670b(context);
            if (!C5527e1.m32505a(FaqConstants.FAQ_CHANNEL, strM32670b, 256)) {
                strM32670b = "";
            }
            c5533g1M32738b.m32534f(strM32670b);
        }
        return c5533g1M32738b.m32537h();
    }
}
