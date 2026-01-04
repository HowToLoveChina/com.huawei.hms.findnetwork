package p823yv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import p374iv.C10626e;

/* renamed from: yv.a */
/* loaded from: classes9.dex */
public class C14046a<T> {

    /* renamed from: a */
    public final String f62834a;

    /* renamed from: b */
    public final List<C14048c> f62835b;

    public C14046a(Class<T> cls) throws C10626e {
        this(null, cls);
    }

    /* renamed from: a */
    public final void m84252a(Class<?> cls) throws C10626e {
        if (cls == null) {
            return;
        }
        m84252a(cls.getSuperclass());
        for (Field field : cls.getDeclaredFields()) {
            C14048c c14048c = new C14048c(this.f62834a, field);
            if (c14048c.m84257b()) {
                this.f62835b.add(c14048c);
            }
        }
    }

    /* renamed from: b */
    public boolean m84253b() {
        return this.f62835b.size() > 0;
    }

    /* renamed from: c */
    public void m84254c(T t10) throws C10626e {
        if (t10 == null) {
            return;
        }
        for (C14048c c14048c : this.f62835b) {
            if (c14048c.m84257b()) {
                c14048c.m84258c(t10);
            }
        }
    }

    public C14046a(String str, Class<?> cls) throws C10626e {
        String simpleName;
        this.f62835b = new ArrayList();
        if (str != null) {
            simpleName = str + "." + cls.getSimpleName();
        } else {
            simpleName = cls.getSimpleName();
        }
        this.f62834a = simpleName;
        m84252a(cls);
    }
}
