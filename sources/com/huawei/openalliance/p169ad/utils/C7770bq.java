package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6985cb;

/* renamed from: com.huawei.openalliance.ad.utils.bq */
/* loaded from: classes2.dex */
public class C7770bq {

    /* renamed from: a */
    private static byte f35953a = 1;

    /* renamed from: a */
    public static InterfaceC7769bp m47813a(Context context) {
        m47815b(context);
        return f35953a == 4 ? new C7773bt() : C6985cb.m41166a(context).mo41201a();
    }

    /* renamed from: b */
    public static boolean m47815b(Context context) {
        byte b10 = f35953a;
        if (b10 != 1) {
            if (b10 == 3 || b10 == 4) {
                return true;
            }
        } else {
            if (m47814a()) {
                f35953a = (byte) 4;
                return true;
            }
            if (m47816c(context)) {
                f35953a = (byte) 3;
                return true;
            }
            f35953a = (byte) 2;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m47816c(Context context) {
        Object objM47819c;
        Object objM48057a;
        InterfaceC7769bp interfaceC7769bpMo41201a = C6985cb.m41166a(context).mo41201a();
        if (interfaceC7769bpMo41201a instanceof C7771br) {
            objM47819c = C7771br.m47817c();
        } else {
            objM47819c = C7772bs.m47819c();
        }
        boolean zBooleanValue = (objM47819c == null || (objM48057a = AbstractC7791ck.m48057a(objM47819c, "isMultiSimEnabled", (Class<?>[]) null, (Object[]) null)) == null || !(objM48057a instanceof Boolean)) ? false : ((Boolean) objM48057a).booleanValue();
        AbstractC7185ho.m43821b("mutiCardFactory", "isHwGeminiSupport1 %s", String.valueOf(zBooleanValue));
        return zBooleanValue;
    }

    /* renamed from: a */
    private static boolean m47814a() throws IllegalAccessException, IllegalArgumentException {
        String str;
        boolean z10;
        try {
            z10 = AbstractC7791ck.m48058a(Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT"), true).getBoolean(null);
        } catch (Error unused) {
            str = "MTK NoClassDefFoundError";
            AbstractC7185ho.m43823c("mutiCardFactory", str);
            z10 = false;
            AbstractC7185ho.m43821b("mutiCardFactory", "isMtkGeminiSupport %s", String.valueOf(z10));
            return z10;
        } catch (Exception unused2) {
            str = "cannot find ext mtkapi";
            AbstractC7185ho.m43823c("mutiCardFactory", str);
            z10 = false;
            AbstractC7185ho.m43821b("mutiCardFactory", "isMtkGeminiSupport %s", String.valueOf(z10));
            return z10;
        }
        AbstractC7185ho.m43821b("mutiCardFactory", "isMtkGeminiSupport %s", String.valueOf(z10));
        return z10;
    }
}
