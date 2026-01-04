package com.huawei.hms.videokit.player;

import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;

/* renamed from: com.huawei.hms.videokit.player.j0 */
/* loaded from: classes8.dex */
public class C6581j0 {

    /* renamed from: a */
    private static volatile String f30543a = "";

    /* renamed from: a */
    public static String m37455a() {
        Object objM37670a = C6600t0.m37670a(C6600t0.m37677a("android.os.SystemProperties", "get", String.class, String.class), (Object) null, CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
        return objM37670a instanceof String ? (String) objM37670a : "";
    }

    /* renamed from: b */
    public static String m37456b() throws ClassNotFoundException {
        if (C6600t0.m37683c(f30543a)) {
            f30543a = "false";
            try {
                Class<?> cls = Class.forName("com.huawei.hms.feature.dynamic.descriptors.huawei_module_videoplayer.AssetModuleDescriptor");
                f30543a = String.valueOf(cls.getField("FULL_SDK").get(cls));
            } catch (Error | Exception unused) {
                C6550c1.m37262b("CommonUtils", "is base sdk");
            }
        }
        return f30543a;
    }
}
