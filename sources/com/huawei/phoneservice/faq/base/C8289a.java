package com.huawei.phoneservice.faq.base;

import com.huawei.phoneservice.faq.base.util.FaqLogger;

/* renamed from: com.huawei.phoneservice.faq.base.a */
/* loaded from: classes4.dex */
public class C8289a {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m51747a(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "CommonUtils"
            r1 = 0
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "get"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L18
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> L18
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.Throwable -> L18
            goto L20
        L18:
            r3 = move-exception
            goto L1c
        L1a:
            r3 = move-exception
            r2 = r1
        L1c:
            m51748b(r3, r0)
            r3 = r1
        L20:
            if (r3 == 0) goto L32
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r3.invoke(r2, r7)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L2e
            r1 = r7
            goto L32
        L2e:
            r7 = move-exception
            m51748b(r7, r0)
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.base.C8289a.m51747a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static void m51748b(Exception exc, String str) throws Throwable {
        if (exc == null || exc.getMessage() == null) {
            return;
        }
        FaqLogger.m51840e(str, exc.getMessage());
    }
}
