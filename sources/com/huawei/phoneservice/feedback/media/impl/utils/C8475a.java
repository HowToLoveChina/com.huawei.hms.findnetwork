package com.huawei.phoneservice.feedback.media.impl.utils;

/* renamed from: com.huawei.phoneservice.feedback.media.impl.utils.a */
/* loaded from: classes5.dex */
public final class C8475a {

    /* renamed from: a */
    public static String f39544a;

    /* renamed from: a */
    public static boolean m52649a() {
        synchronized (C8475a.class) {
            try {
                if (f39544a == null) {
                    f39544a = C8476b.m52650a("ro.build.characteristics");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return "tablet".equals(f39544a) || "car".equals(f39544a);
    }
}
