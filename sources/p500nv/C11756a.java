package p500nv;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p374iv.C10626e;
import p823yv.C14046a;

/* renamed from: nv.a */
/* loaded from: classes9.dex */
public class C11756a {

    /* renamed from: a */
    public static final Map<Class<?>, C14046a<?>> f54321a = new ConcurrentHashMap();

    /* renamed from: a */
    public static C14046a<?> m70078a(Class<?> cls) throws C10626e {
        Map<Class<?>, C14046a<?>> map = f54321a;
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        C14046a<?> c14046a = new C14046a<>(cls);
        map.put(cls, c14046a);
        return c14046a;
    }

    /* renamed from: b */
    public static <T> void m70079b(T t10) throws C10626e {
        if (t10 == null) {
            throw new C10626e("validate bean is null");
        }
        C14046a<?> c14046aM70078a = m70078a(t10.getClass());
        if (c14046aM70078a.m84253b()) {
            c14046aM70078a.m84254c(t10);
        }
    }
}
