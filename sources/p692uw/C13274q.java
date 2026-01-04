package p692uw;

import p824yw.InterfaceC14050b;
import p824yw.InterfaceC14051c;
import p824yw.InterfaceC14054f;

/* renamed from: uw.q */
/* loaded from: classes9.dex */
public class C13274q {

    /* renamed from: a */
    public static final C13275r f59979a;

    /* renamed from: b */
    public static final InterfaceC14050b[] f59980b;

    static {
        C13275r c13275r = null;
        try {
            c13275r = (C13275r) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c13275r == null) {
            c13275r = new C13275r();
        }
        f59979a = c13275r;
        f59980b = new InterfaceC14050b[0];
    }

    /* renamed from: a */
    public static InterfaceC14050b m79691a(Class cls) {
        return f59979a.m79695a(cls);
    }

    /* renamed from: b */
    public static InterfaceC14051c m79692b(Class cls) {
        return f59979a.m79696b(cls, "");
    }

    /* renamed from: c */
    public static InterfaceC14054f m79693c(AbstractC13270m abstractC13270m) {
        return f59979a.m79697c(abstractC13270m);
    }

    /* renamed from: d */
    public static String m79694d(AbstractC13268k abstractC13268k) {
        return f59979a.m79699e(abstractC13268k);
    }
}
