package androidx.lifecycle;

import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0779b;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements InterfaceC0794j {

    /* renamed from: a */
    public final Object f4130a;

    /* renamed from: b */
    public final C0779b.a f4131b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f4130a = obj;
        this.f4131b = C0779b.f4140c.m4917c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f4131b.m4921a(interfaceC0796l, bVar, this.f4130a);
    }
}
