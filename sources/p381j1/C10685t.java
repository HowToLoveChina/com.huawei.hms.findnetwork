package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import p244e1.C9378b;
import p323h1.C10077a;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.t */
/* loaded from: classes.dex */
public class C10685t implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10685t f51324a = new C10685t();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, e1.b, java.util.Collection] */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        Collection collection;
        if (c10077a.f49153f.mo62768a0() == 8) {
            c10077a.f49153f.mo62756D(16);
            return null;
        }
        if (type == C9378b.class) {
            ?? r12 = (T) new C9378b();
            c10077a.m62717X(r12);
            return r12;
        }
        if (c10077a.f49153f.mo62768a0() == 21) {
            c10077a.f49153f.mo62790z();
            collection = (T) C11603o.m69253G(type);
        } else {
            collection = (T) C11603o.m69251F(type);
        }
        c10077a.m62716V(C11603o.m69276U(type), collection, obj);
        return (T) collection;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 14;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullListAsEmpty);
            return;
        }
        EnumC10653e1 enumC10653e1 = EnumC10653e1.WriteClassName;
        Type typeM69276U = (c10650d1.m65237w(enumC10653e1) || EnumC10653e1.m65242f(i10, enumC10653e1)) ? C11603o.m69276U(type) : null;
        Collection collection = (Collection) obj;
        C10696y0 c10696y0 = c10664i0.f51265r;
        int i11 = 0;
        c10664i0.m65259D(c10696y0, obj, obj2, 0);
        if (c10650d1.m65237w(enumC10653e1)) {
            if (HashSet.class.isAssignableFrom(collection.getClass())) {
                c10650d1.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                c10650d1.append("TreeSet");
            }
        }
        try {
            c10650d1.append('[');
            for (Object obj3 : collection) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    c10650d1.append(',');
                }
                if (obj3 == null) {
                    c10650d1.m65222a0();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        c10650d1.m65219X(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        c10650d1.m65221Z(((Long) obj3).longValue());
                        if (c10650d1.m65237w(EnumC10653e1.WriteClassName)) {
                            c10650d1.write(76);
                        }
                    } else {
                        InterfaceC10686t0 interfaceC10686t0M65276x = c10664i0.m65276x(cls);
                        if (EnumC10653e1.m65242f(i10, EnumC10653e1.WriteClassName) && (interfaceC10686t0M65276x instanceof C10666j0)) {
                            ((C10666j0) interfaceC10686t0M65276x).m65286E(c10664i0, obj3, Integer.valueOf(i11), typeM69276U, i10);
                        } else {
                            interfaceC10686t0M65276x.mo63933e(c10664i0, obj3, Integer.valueOf(i11), typeM69276U, i10);
                        }
                    }
                }
                i11 = i12;
            }
            c10650d1.append(']');
            c10664i0.f51265r = c10696y0;
        } catch (Throwable th2) {
            c10664i0.f51265r = c10696y0;
            throw th2;
        }
    }
}
