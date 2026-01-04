package com.huawei.openalliance.p169ad;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ub */
/* loaded from: classes8.dex */
public class C7707ub {

    /* renamed from: a */
    private static final Map<String, InterfaceC7701tw> f35761a = new HashMap(5);

    /* renamed from: b */
    private static final Map<String, Class<? extends InterfaceC7701tw>> f35762b;

    static {
        HashMap map = new HashMap();
        f35762b = map;
        map.put("more", C7703ty.class);
        map.put("WX", C7712ug.class);
        map.put("QQ", C7704tz.class);
        map.put("WB", C7711uf.class);
        map.put("weLink", C7710ue.class);
    }

    /* renamed from: a */
    public static void m47350a(String str, Activity activity, C7706ua c7706ua, C7708uc c7708uc) {
        AbstractC7185ho.m43818a("ShareManager", "shareAd : %s", str);
        try {
            Map<String, InterfaceC7701tw> map = f35761a;
            InterfaceC7701tw interfaceC7701twM47352b = !map.containsKey(str) ? m47352b(str) : map.get(str);
            if (interfaceC7701twM47352b != null) {
                interfaceC7701twM47352b.mo47333a(activity, c7706ua, c7708uc);
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("ShareManager", "Share throws exception");
        }
    }

    /* renamed from: b */
    private static InterfaceC7701tw m47352b(String str) throws IllegalAccessException, InstantiationException {
        Class<? extends InterfaceC7701tw> cls = f35762b.get(str);
        if (cls == null) {
            AbstractC7185ho.m43818a("ShareManager", "There is no matching type for %s", str);
            return null;
        }
        InterfaceC7701tw interfaceC7701twNewInstance = cls.newInstance();
        f35761a.put(str, interfaceC7701twNewInstance);
        return interfaceC7701twNewInstance;
    }

    /* renamed from: a */
    public static boolean m47351a(String str) {
        try {
            Class<? extends InterfaceC7701tw> cls = f35762b.get(str);
            if (cls != null) {
                return cls.newInstance().mo47334a();
            }
            AbstractC7185ho.m43818a("ShareManager", "There is no matching type for %s", str);
            return false;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("ShareManager", "Share throws exception");
            return false;
        }
    }
}
