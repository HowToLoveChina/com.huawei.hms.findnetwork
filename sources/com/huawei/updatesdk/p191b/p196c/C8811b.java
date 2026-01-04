package com.huawei.updatesdk.p191b.p196c;

import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.c.b */
/* loaded from: classes9.dex */
public class C8811b {

    /* renamed from: a */
    private static final Map<Integer, Class<? extends AbstractC8812c>> f45143a;

    /* renamed from: b */
    private static AbstractC8812c f45144b;

    static {
        HashMap map = new HashMap();
        f45143a = map;
        map.put(3, C8810a.class);
        map.put(1, C8814e.class);
        map.put(2, C8815f.class);
        map.put(0, C8813d.class);
        map.put(4, C8813d.class);
        map.put(7, C8810a.class);
    }

    /* renamed from: a */
    public static synchronized AbstractC8812c m56233a() {
        AbstractC8812c abstractC8812c = f45144b;
        if (abstractC8812c != null) {
            return abstractC8812c;
        }
        C8774a.m56009b("DeviceImplFactory", "deviceType: " + C8789c.m56102e());
        Class<? extends AbstractC8812c> cls = f45143a.get(Integer.valueOf(C8789c.m56102e()));
        if (cls == null) {
            C8813d c8813d = new C8813d();
            f45144b = c8813d;
            return c8813d;
        }
        try {
            f45144b = cls.newInstance();
        } catch (Throwable unused) {
            f45144b = new C8813d();
            C8774a.m56008a("DeviceImplFactory", "createDeviceInfo error and create default phone deviceinfo");
        }
        return f45144b;
    }
}
