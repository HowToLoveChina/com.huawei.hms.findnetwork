package p381j1;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* renamed from: j1.z */
/* loaded from: classes.dex */
public class C10697z implements InterfaceC10686t0 {

    /* renamed from: a */
    public static C10697z f51336a = new C10697z();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullListAsEmpty);
            return;
        }
        int i11 = 0;
        Type type2 = (c10650d1.m65237w(EnumC10653e1.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        C10696y0 c10696y0 = c10664i0.f51265r;
        c10664i0.m65259D(c10696y0, obj, obj2, 0);
        try {
            c10650d1.append('[');
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i12 = i11 + 1;
                if (i11 != 0) {
                    c10650d1.append(',');
                }
                if (objNextElement == null) {
                    c10650d1.m65222a0();
                } else {
                    c10664i0.m65276x(objNextElement.getClass()).mo63933e(c10664i0, objNextElement, Integer.valueOf(i11), type2, 0);
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
