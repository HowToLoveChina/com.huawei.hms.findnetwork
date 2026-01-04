package com.huawei.hwcloudjs.p164f;

import com.huawei.hwcloudjs.annotation.JSMethod;
import com.huawei.hwcloudjs.core.p153a.C6622a;

/* renamed from: com.huawei.hwcloudjs.f.e */
/* loaded from: classes8.dex */
public class C6660e {
    /* renamed from: a */
    public static String m37884a(C6622a c6622a) {
        return ((JSMethod) c6622a.m37762a().getAnnotation(JSMethod.class)).permission();
    }

    /* renamed from: b */
    public static boolean m37885b(C6622a c6622a) {
        return ((JSMethod) c6622a.m37762a().getAnnotation(JSMethod.class)).isOpen();
    }

    /* renamed from: c */
    public static boolean m37886c(C6622a c6622a) {
        return !"".equals(m37884a(c6622a));
    }
}
