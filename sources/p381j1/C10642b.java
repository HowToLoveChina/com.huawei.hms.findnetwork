package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/* renamed from: j1.b */
/* loaded from: classes.dex */
public class C10642b implements InterfaceC10686t0 {

    /* renamed from: a */
    public static final C10642b f51167a = new C10642b();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj instanceof LongAdder) {
            c10650d1.m65213F('{', "value", ((LongAdder) obj).longValue());
            c10650d1.write(125);
        } else if (obj instanceof DoubleAdder) {
            c10650d1.m65211D('{', "value", ((DoubleAdder) obj).doubleValue());
            c10650d1.write(125);
        }
    }
}
