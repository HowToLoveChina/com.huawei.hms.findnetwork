package p320gz;

import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collection;

/* renamed from: gz.a */
/* loaded from: classes9.dex */
public class C10072a {
    /* renamed from: a */
    public static <T> T m62693a(Class<T> cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(C10072a.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* renamed from: b */
    public static boolean m62694b(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (m62695c()) {
                if (collection.contains(str + ":dev")) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m62695c() {
        String str = Build.TYPE;
        return "eng".equals(str) || "userdebug".equals(str);
    }
}
