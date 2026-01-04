package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;

/* renamed from: com.huawei.openalliance.ad.utils.dr */
/* loaded from: classes2.dex */
public class C7825dr {
    /* renamed from: a */
    public static boolean m48391a(Context context) {
        if (!C6982bz.m41148a(context).mo41183l()) {
            AbstractC7185ho.m43820b("WifiUtils", "base location switch off");
            return false;
        }
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        if (!interfaceC7146gcM43316b.mo43088v()) {
            AbstractC7185ho.m43820b("WifiUtils", "collect devCntList switch off");
            return false;
        }
        if (C7124fh.m43316b(context).mo43091y() <= 0) {
            return false;
        }
        long jMo43090x = interfaceC7146gcM43316b.mo43090x();
        if (System.currentTimeMillis() - interfaceC7146gcM43316b.mo43378bE() < 60000 * jMo43090x) {
            AbstractC7185ho.m43821b("WifiUtils", "The reporting interval is less than %s min", Long.valueOf(jMo43090x));
            return false;
        }
        interfaceC7146gcM43316b.mo43460h(System.currentTimeMillis());
        return true;
    }
}
