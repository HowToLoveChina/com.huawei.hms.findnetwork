package com.huawei.hwcloudjs.core;

import com.huawei.hwcloudjs.support.enables.INoProguard;

/* loaded from: classes8.dex */
public abstract class JSRequest implements INoProguard {

    /* renamed from: a */
    private static final String f30791a = "JSRequest";

    /* JADX WARN: Removed duplicated region for block: B:32:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void execute(java.lang.reflect.Method r7, java.lang.Object r8, com.huawei.hwcloudjs.core.JsCallback r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r6 = this;
            java.lang.String r0 = "JSRequest"
            java.lang.String r1 = "execute begin"
            r2 = 1
            com.huawei.hwcloudjs.p164f.C6659d.m37882c(r0, r1, r2)
            java.lang.Class[] r1 = r7.getParameterTypes()
            int r3 = r1.length
            r4 = 0
            if (r3 <= 0) goto L21
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r4] = r8
            int r3 = r3 - r2
            r8 = r1[r3]
            java.lang.Class<com.huawei.hwcloudjs.core.JsCallback> r1 = com.huawei.hwcloudjs.core.JsCallback.class
            if (r8 != r1) goto L1f
            r5[r3] = r9
            r8 = r2
            goto L23
        L1f:
            r8 = r4
            goto L23
        L21:
            r5 = 0
            goto L1f
        L23:
            r7.invoke(r6, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L4e
            if (r8 != 0) goto L2b
            r9.success()
        L2b:
            return
        L2c:
            r6 = move-exception
            java.lang.String r7 = "InvocationTargetException"
            com.huawei.hwcloudjs.p164f.C6659d.m37881b(r0, r7, r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "InvocationTargetException:"
            r7.append(r8)
            java.lang.Throwable r6 = r6.getTargetException()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.huawei.hwcloudjs.p164f.C6659d.m37881b(r0, r6, r4)
        L4a:
            r9.failure()
            return
        L4e:
            java.lang.String r6 = "IllegalAccessException"
            com.huawei.hwcloudjs.p164f.C6659d.m37881b(r0, r6, r2)
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwcloudjs.core.JSRequest.execute(java.lang.reflect.Method, java.lang.Object, com.huawei.hwcloudjs.core.JsCallback):void");
    }
}
