package com.huawei.hwcloudjs.core.extkit;

import com.huawei.hwcloudjs.p164f.C6659d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hwcloudjs.core.extkit.a */
/* loaded from: classes8.dex */
public class C6627a {

    /* renamed from: a */
    private static final String f30810a = "AuthResponseBean";

    /* renamed from: b */
    private static Map<String, Class<? extends IExtKit>> f30811b = new HashMap();

    /* renamed from: a */
    public static <U, R extends Class> U m37775a(String str, R r10) {
        String str2;
        try {
            U u10 = (U) f30811b.get(str).newInstance();
            if (r10.isInstance(u10)) {
                return u10;
            }
            return null;
        } catch (IllegalAccessException unused) {
            str2 = "IllegalAccessException";
            C6659d.m37881b(f30810a, str2, true);
            return null;
        } catch (InstantiationException unused2) {
            str2 = "InstantiationException";
            C6659d.m37881b(f30810a, str2, true);
            return null;
        }
    }

    /* renamed from: b */
    public static void m37776b(String str, Class<? extends IExtKit> cls) {
        f30811b.put(str, cls);
    }
}
