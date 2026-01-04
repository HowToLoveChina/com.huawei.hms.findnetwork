package p381j1;

import com.huawei.hms.network.embedded.C6010m7;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import p481n1.C11603o;

/* renamed from: j1.n0 */
/* loaded from: classes.dex */
public final class C10674n0 implements InterfaceC10686t0 {

    /* renamed from: a */
    public static final C10674n0 f51307a = new C10674n0();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public final void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        int i11;
        Object obj3;
        boolean z10;
        char c10;
        C10650d1 c10650d1 = c10664i0.f51258k;
        EnumC10653e1 enumC10653e1 = EnumC10653e1.WriteClassName;
        boolean z11 = c10650d1.m65237w(enumC10653e1) || EnumC10653e1.m65242f(i10, enumC10653e1);
        C10650d1 c10650d12 = c10664i0.f51258k;
        Type typeM69276U = z11 ? C11603o.m69276U(type) : null;
        if (obj == null) {
            c10650d12.m65226c0(EnumC10653e1.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            c10650d12.append(C6010m7.f27500n);
            return;
        }
        C10696y0 c10696y0 = c10664i0.f51265r;
        c10664i0.m65259D(c10696y0, obj, obj2, 0);
        try {
            char c11 = ',';
            if (c10650d12.m65237w(EnumC10653e1.PrettyFormat)) {
                c10650d12.append('[');
                c10664i0.m65278z();
                int i12 = 0;
                for (Object obj4 : list) {
                    if (i12 != 0) {
                        c10650d12.append(c11);
                    }
                    c10664i0.m65258C();
                    if (obj4 == null) {
                        c10 = c11;
                        c10664i0.f51258k.m65222a0();
                    } else if (c10664i0.m65270r(obj4)) {
                        c10664i0.m65265J(obj4);
                        c10 = c11;
                    } else {
                        InterfaceC10686t0 interfaceC10686t0M65276x = c10664i0.m65276x(obj4.getClass());
                        c10 = c11;
                        c10664i0.f51265r = new C10696y0(c10696y0, obj, obj2, 0, 0);
                        interfaceC10686t0M65276x.mo63933e(c10664i0, obj4, Integer.valueOf(i12), typeM69276U, i10);
                    }
                    i12++;
                    c11 = c10;
                }
                c10664i0.m65271s();
                c10664i0.m65258C();
                c10650d12.append(']');
                c10664i0.f51265r = c10696y0;
                return;
            }
            char c12 = ',';
            c10650d12.append('[');
            int size = list.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj5 = list.get(i13);
                if (i13 != 0) {
                    c10650d12.append(c12);
                }
                if (obj5 == null) {
                    c10650d12.append("null");
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        c10650d12.m65219X(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long jLongValue = ((Long) obj5).longValue();
                        if (z11) {
                            c10650d12.m65221Z(jLongValue);
                            c10650d12.write(76);
                        } else {
                            c10650d12.m65221Z(jLongValue);
                        }
                    } else if ((EnumC10653e1.DisableCircularReferenceDetect.f51248a & i10) != 0) {
                        i11 = i13;
                        c10664i0.m65276x(obj5.getClass()).mo63933e(c10664i0, obj5, Integer.valueOf(i13), typeM69276U, i10);
                        z10 = z11;
                        i13 = i11 + 1;
                        z11 = z10;
                        c12 = ',';
                    } else {
                        i11 = i13;
                        if (c10650d12.f51202h) {
                            obj3 = obj5;
                            z10 = z11;
                        } else {
                            obj3 = obj5;
                            z10 = z11;
                            c10664i0.f51265r = new C10696y0(c10696y0, obj, obj2, 0, 0);
                        }
                        if (c10664i0.m65270r(obj3)) {
                            c10664i0.m65265J(obj3);
                        } else {
                            InterfaceC10686t0 interfaceC10686t0M65276x2 = c10664i0.m65276x(obj3.getClass());
                            if ((EnumC10653e1.WriteClassName.f51248a & i10) == 0 || !(interfaceC10686t0M65276x2 instanceof C10666j0)) {
                                interfaceC10686t0M65276x2.mo63933e(c10664i0, obj3, Integer.valueOf(i11), typeM69276U, i10);
                            } else {
                                ((C10666j0) interfaceC10686t0M65276x2).m65286E(c10664i0, obj3, Integer.valueOf(i11), typeM69276U, i10);
                            }
                        }
                        i13 = i11 + 1;
                        z11 = z10;
                        c12 = ',';
                    }
                }
                i11 = i13;
                z10 = z11;
                i13 = i11 + 1;
                z11 = z10;
                c12 = ',';
            }
            c10650d12.append(']');
            c10664i0.f51265r = c10696y0;
        } catch (Throwable th2) {
            c10664i0.f51265r = c10696y0;
            throw th2;
        }
    }
}
