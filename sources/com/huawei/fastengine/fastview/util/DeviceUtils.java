package com.huawei.fastengine.fastview.util;

import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public class DeviceUtils {
    private static final String TAG = "DeviceUtils";

    public static boolean isHonorDevice() {
        FastViewLogUtils.m28722d(TAG, "DEVICE " + systemPropertiesGet("ro.product.manufacturer"));
        return "HONOR".equalsIgnoreCase(systemPropertiesGet("ro.product.manufacturer"));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String systemPropertiesGet(java.lang.String r8) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "DeviceUtils"
            r2 = 1
            r3 = 0
            java.lang.String r4 = "android.os.SystemProperties"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.NoSuchMethodException -> L18 java.lang.ClassNotFoundException -> L20
            java.lang.String r5 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L19 java.lang.ClassNotFoundException -> L21
            r7 = 0
            r6[r7] = r0     // Catch: java.lang.NoSuchMethodException -> L19 java.lang.ClassNotFoundException -> L21
            java.lang.reflect.Method r5 = r4.getDeclaredMethod(r5, r6)     // Catch: java.lang.NoSuchMethodException -> L19 java.lang.ClassNotFoundException -> L21
            goto L24
        L18:
            r4 = r3
        L19:
            java.lang.String r5 = "method not found."
        L1b:
            com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils.m28724e(r1, r5)
            r5 = r3
            goto L24
        L20:
            r4 = r3
        L21:
            java.lang.String r5 = "class not found."
            goto L1b
        L24:
            if (r5 == 0) goto L42
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalArgumentException -> L3c java.lang.IllegalAccessException -> L3f
            java.lang.Object r8 = r5.invoke(r4, r8)     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalArgumentException -> L3c java.lang.IllegalAccessException -> L3f
            java.lang.Object r8 = com.huawei.fastengine.fastview.download.utils.CommonUtils.cast(r8, r0, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalArgumentException -> L3c java.lang.IllegalAccessException -> L3f
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalArgumentException -> L3c java.lang.IllegalAccessException -> L3f
            r3 = r8
            goto L42
        L36:
            java.lang.String r8 = "illegal invocation."
        L38:
            com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils.m28724e(r1, r8)
            goto L42
        L3c:
            java.lang.String r8 = "illegal argument"
            goto L38
        L3f:
            java.lang.String r8 = "illegal access"
            goto L38
        L42:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.fastengine.fastview.util.DeviceUtils.systemPropertiesGet(java.lang.String):java.lang.String");
    }
}
