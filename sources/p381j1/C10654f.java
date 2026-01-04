package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: j1.f */
/* loaded from: classes.dex */
public class C10654f implements InterfaceC10686t0 {

    /* renamed from: a */
    public final Class<?> f51249a;

    /* renamed from: b */
    public final InterfaceC10686t0 f51250b;

    public C10654f(Class<?> cls, InterfaceC10686t0 interfaceC10686t0) {
        this.f51249a = cls;
        this.f51250b = interfaceC10686t0;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public final void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        C10696y0 c10696y0 = c10664i0.f51265r;
        c10664i0.m65259D(c10696y0, obj, obj2, 0);
        try {
            c10650d1.append('[');
            for (int i11 = 0; i11 < length; i11++) {
                if (i11 != 0) {
                    c10650d1.append(',');
                }
                Object obj3 = objArr[i11];
                if (obj3 == null) {
                    if (c10650d1.m65237w(EnumC10653e1.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        c10650d1.m65228g0("");
                    } else {
                        c10650d1.append("null");
                    }
                } else if (obj3.getClass() == this.f51249a) {
                    this.f51250b.mo63933e(c10664i0, obj3, Integer.valueOf(i11), null, 0);
                } else {
                    c10664i0.m65276x(obj3.getClass()).mo63933e(c10664i0, obj3, Integer.valueOf(i11), null, 0);
                }
            }
            c10650d1.append(']');
            c10664i0.f51265r = c10696y0;
        } catch (Throwable th2) {
            c10664i0.f51265r = c10696y0;
            throw th2;
        }
    }
}
