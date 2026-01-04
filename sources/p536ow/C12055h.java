package p536ow;

import java.lang.reflect.Method;
import p692uw.C13267j;

/* renamed from: ow.h */
/* loaded from: classes9.dex */
public final class C12055h {

    /* renamed from: a */
    public static final C12055h f55805a = new C12055h();

    /* renamed from: b */
    public static final a f55806b = new a(null, null, null);

    /* renamed from: c */
    public static a f55807c;

    /* renamed from: ow.h$a */
    public static final class a {

        /* renamed from: a */
        public final Method f55808a;

        /* renamed from: b */
        public final Method f55809b;

        /* renamed from: c */
        public final Method f55810c;

        public a(Method method, Method method2, Method method3) {
            this.f55808a = method;
            this.f55809b = method2;
            this.f55810c = method3;
        }
    }

    /* renamed from: a */
    public final a m72191a(AbstractC12048a abstractC12048a) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), abstractC12048a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), abstractC12048a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f55807c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f55806b;
            f55807c = aVar2;
            return aVar2;
        }
    }

    /* renamed from: b */
    public final String m72192b(AbstractC12048a abstractC12048a) {
        C13267j.m79677e(abstractC12048a, "continuation");
        a aVarM72191a = f55807c;
        if (aVarM72191a == null) {
            aVarM72191a = m72191a(abstractC12048a);
        }
        if (aVarM72191a == f55806b) {
            return null;
        }
        Method method = aVarM72191a.f55808a;
        Object objInvoke = method != null ? method.invoke(abstractC12048a.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarM72191a.f55809b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarM72191a.f55810c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
