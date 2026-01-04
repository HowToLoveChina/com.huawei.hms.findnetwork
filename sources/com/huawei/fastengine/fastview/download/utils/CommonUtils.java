package com.huawei.fastengine.fastview.download.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes5.dex */
public class CommonUtils {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, boolean z10) {
        if (!z10 && obj == 0) {
            throw new NullPointerException("can not be null");
        }
        if (cls.isInstance(obj) || obj == 0) {
            return obj;
        }
        throw new ClassCastException("can not cast to " + cls.getSimpleName());
    }

    public static boolean getIsDarkTheme(Context context) {
        return isQVersion() ? isQVersionDark(context) : isDarkThemeEnabled();
    }

    public static int getUserId() throws ClassNotFoundException {
        int iIntValue = Constants.COORDINATE_FAIL_DEF;
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            iIntValue = ((Integer) cast(cls.getDeclaredMethod("myUserId", new Class[0]).invoke(cls, new Object[0]), Integer.class, true)).intValue();
            FastViewLogUtils.m28722d("getUserId", "getUserId:" + iIntValue);
            return iIntValue;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            FastViewLogUtils.m28722d("getUserId", " getUserId wrong");
            return iIntValue;
        }
    }

    public static boolean hasParseException(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            intent.getStringExtra("TestIntent");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean isDarkThemeEnabled() {
        try {
            if (!"dark".equals(systemPropertiesGet("persist.deep.theme_" + getUserId()))) {
                if (!"dark".equals(systemPropertiesGet("persist.deep.theme"))) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            FastViewLogUtils.m28728w("dark", "read deep theme flag failed.");
            return false;
        }
    }

    public static boolean isQVersion() {
        return true;
    }

    public static boolean isQVersionDark(Context context) {
        int i10;
        return (context == null || (i10 = context.getResources().getConfiguration().uiMode & 48) == 16 || i10 != 32) ? false : true;
    }

    public static void safeFinish(Activity activity) {
        if (activity != null) {
            try {
                activity.finish();
            } catch (Throwable unused) {
                FastViewLogUtils.m28723e("Activity finish error");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String systemPropertiesGet(java.lang.String r7) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            java.lang.String r0 = "utils"
            r1 = 0
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Exception -> L18 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L24
            java.lang.String r3 = "get"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L19 java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L25
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Exception -> L19 java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L25
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.Exception -> L19 java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L25
            goto L28
        L18:
            r2 = r1
        L19:
            java.lang.String r3 = "other error when getProperty1."
        L1b:
            com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils.m28724e(r0, r3)
            r3 = r1
            goto L28
        L20:
            r2 = r1
        L21:
            java.lang.String r3 = "method not found."
            goto L1b
        L24:
            r2 = r1
        L25:
            java.lang.String r3 = "class not found."
            goto L1b
        L28:
            if (r3 == 0) goto L4f
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch: java.lang.Exception -> L40 java.lang.reflect.InvocationTargetException -> L46 java.lang.IllegalArgumentException -> L49 java.lang.IllegalAccessException -> L4c
            java.lang.Object r7 = r3.invoke(r2, r7)     // Catch: java.lang.Exception -> L40 java.lang.reflect.InvocationTargetException -> L46 java.lang.IllegalArgumentException -> L49 java.lang.IllegalAccessException -> L4c
            boolean r2 = r7 instanceof java.lang.String     // Catch: java.lang.Exception -> L40 java.lang.reflect.InvocationTargetException -> L46 java.lang.IllegalArgumentException -> L49 java.lang.IllegalAccessException -> L4c
            if (r2 == 0) goto L3a
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L40 java.lang.reflect.InvocationTargetException -> L46 java.lang.IllegalArgumentException -> L49 java.lang.IllegalAccessException -> L4c
            r1 = r7
            goto L4f
        L3a:
            java.lang.String r7 = "mGetMethod is not String"
            com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils.m28724e(r0, r7)     // Catch: java.lang.Exception -> L40 java.lang.reflect.InvocationTargetException -> L46 java.lang.IllegalArgumentException -> L49 java.lang.IllegalAccessException -> L4c
            goto L4f
        L40:
            java.lang.String r7 = "other error when getProperty2."
        L42:
            com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils.m28724e(r0, r7)
            goto L4f
        L46:
            java.lang.String r7 = "illegal invocation."
            goto L42
        L49:
            java.lang.String r7 = "illegal argument."
            goto L42
        L4c:
            java.lang.String r7 = "illegal access."
            goto L42
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.fastengine.fastview.download.utils.CommonUtils.systemPropertiesGet(java.lang.String):java.lang.String");
    }
}
