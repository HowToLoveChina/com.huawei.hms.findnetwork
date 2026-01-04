package com.huawei.phoneservice.feedback.media.impl.utils;

import com.huawei.phoneservice.faq.base.util.FaqLogger;

/* renamed from: com.huawei.phoneservice.feedback.media.impl.utils.b */
/* loaded from: classes5.dex */
public class C8476b {

    /* renamed from: a */
    public static final String f39545a = "b";

    /* JADX WARN: Removed duplicated region for block: B:17:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m52650a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r2 = "get"
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L16
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L16
            java.lang.reflect.Method r2 = r1.getDeclaredMethod(r2, r3)     // Catch: java.lang.Throwable -> L16
            goto L20
        L16:
            r2 = move-exception
            goto L1a
        L18:
            r2 = move-exception
            r1 = r0
        L1a:
            java.lang.String r3 = com.huawei.phoneservice.feedback.media.impl.utils.C8476b.f39545a
            m52651b(r2, r3)
            r2 = r0
        L20:
            if (r2 == 0) goto L34
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r2.invoke(r1, r6)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L2e
            r0 = r6
            goto L34
        L2e:
            r6 = move-exception
            java.lang.String r1 = com.huawei.phoneservice.feedback.media.impl.utils.C8476b.f39545a
            m52651b(r6, r1)
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.media.impl.utils.C8476b.m52650a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static void m52651b(Exception exc, String str) throws Throwable {
        if (exc == null || exc.getMessage() == null) {
            return;
        }
        FaqLogger.m51840e(str, exc.getMessage());
    }
}
