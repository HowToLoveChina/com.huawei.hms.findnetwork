package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.VastVersion;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ri */
/* loaded from: classes8.dex */
public class C7633ri {

    /* renamed from: a */
    private static VastVersion f35561a;

    /* renamed from: b */
    private static Map<VastVersion, AbstractC7627rc> f35562b;

    /* renamed from: c */
    private static Map<VastVersion, AbstractC7625ra> f35563c;

    /* renamed from: d */
    private static Map<VastVersion, AbstractC7626rb> f35564d;

    static {
        VastVersion vastVersion = VastVersion.VAST_30;
        f35561a = vastVersion;
        f35562b = new HashMap();
        f35563c = new HashMap();
        f35564d = new HashMap();
        Map<VastVersion, AbstractC7627rc> map = f35562b;
        VastVersion vastVersion2 = VastVersion.VAST_20;
        map.put(vastVersion2, new C7634rj());
        f35562b.put(vastVersion, new C7635rk());
        f35563c.put(vastVersion2, new C7628rd());
        f35563c.put(vastVersion, new C7629re());
        f35564d.put(vastVersion2, new C7630rf());
        f35564d.put(vastVersion, new C7631rg());
    }

    /* renamed from: a */
    public static AbstractC7627rc m47098a() {
        return f35562b.get(f35561a);
    }

    /* renamed from: b */
    public static AbstractC7626rb m47100b() {
        return f35564d.get(f35561a);
    }

    /* renamed from: c */
    public static AbstractC7625ra m47101c() {
        return f35563c.get(f35561a);
    }

    /* renamed from: a */
    public static void m47099a(VastVersion vastVersion) {
        f35561a = vastVersion;
    }
}
