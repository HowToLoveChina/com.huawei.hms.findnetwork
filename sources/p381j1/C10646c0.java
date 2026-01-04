package p381j1;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p323h1.C10077a;
import p354i1.InterfaceC10408t;
import p483n3.C11614e;
import p483n3.InterfaceC11624o;

/* renamed from: j1.c0 */
/* loaded from: classes.dex */
public class C10646c0 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static C10646c0 f51173a = new C10646c0();

    /* JADX WARN: Type inference failed for: r1v4, types: [T, n3.e] */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        if (type != C11614e.class) {
            return null;
        }
        ?? r12 = (T) C11614e.m69396y();
        for (Map.Entry<String, Object> entry : c10077a.m62720a0().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Collection) {
                r12.mo69395f(entry.getKey(), (List) value);
            } else {
                r12.mo69359s(entry.getKey(), value);
            }
        }
        return r12;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 0;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj instanceof InterfaceC11624o) {
            c10664i0.m65262G(((InterfaceC11624o) obj).mo69358b());
        }
    }
}
