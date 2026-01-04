package p244e1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p481n1.C11599k;

/* renamed from: e1.n */
/* loaded from: classes.dex */
public class C9390n<T> {

    /* renamed from: b */
    public static ConcurrentMap<Type, Type> f46911b = new ConcurrentHashMap(16, 0.75f, 1);

    /* renamed from: c */
    public static final Type f46912c = new a().m58850a();

    /* renamed from: a */
    public final Type f46913a;

    /* renamed from: e1.n$a */
    public static class a extends C9390n<List<String>> {
    }

    public C9390n() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = f46911b.get(type);
        if (type2 == null) {
            f46911b.putIfAbsent(type, type);
            type2 = f46911b.get(type);
        }
        this.f46913a = type2;
    }

    /* renamed from: b */
    public static Type m58849b(C11599k c11599k) {
        Type type = f46911b.get(c11599k);
        if (type != null) {
            return type;
        }
        f46911b.putIfAbsent(c11599k, c11599k);
        return f46911b.get(c11599k);
    }

    /* renamed from: a */
    public Type m58850a() {
        return this.f46913a;
    }
}
