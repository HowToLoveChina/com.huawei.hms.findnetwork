package p354i1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import p244e1.C9380d;
import p323h1.C10077a;

/* renamed from: i1.g */
/* loaded from: classes.dex */
public class C10395g implements InterfaceC10408t {

    /* renamed from: a */
    public final Method f50192a;

    /* renamed from: b */
    public final Class f50193b;

    public C10395g(Method method) {
        this.f50192a = method;
        this.f50193b = method.getParameterTypes()[0];
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        try {
            return (T) this.f50192a.invoke(null, c10077a.m62721b0(this.f50193b));
        } catch (IllegalAccessException e10) {
            throw new C9380d("parse enum error", e10);
        } catch (InvocationTargetException e11) {
            throw new C9380d("parse enum error", e11);
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 0;
    }
}
