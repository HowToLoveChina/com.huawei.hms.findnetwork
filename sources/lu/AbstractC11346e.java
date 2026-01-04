package lu;

import android.text.TextUtils;

/* renamed from: lu.e */
/* loaded from: classes5.dex */
public abstract class AbstractC11346e {
    /* renamed from: a */
    public static boolean m68155a(String str) {
        String[] strArr = {"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"};
        for (int i10 = 0; i10 < 10; i10++) {
            if (str.contains(strArr[i10])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m68156b(String str, Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append(" ");
        }
        sb2.append("Exception: ");
        sb2.append(th2.getClass().getName());
        sb2.append('\n');
        if (!m68155a(th2.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            if (stackTrace == null) {
                sb2.append("Stack trace is NULL!");
                sb2.append('\n');
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb2.append(stackTraceElement.toString());
                    sb2.append('\n');
                }
            }
        }
        return sb2.toString();
    }
}
