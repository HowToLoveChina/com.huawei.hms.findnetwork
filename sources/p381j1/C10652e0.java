package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import p244e1.InterfaceC9379c;

/* renamed from: j1.e0 */
/* loaded from: classes.dex */
public class C10652e0 implements InterfaceC10686t0 {

    /* renamed from: a */
    public static C10652e0 f51214a = new C10652e0();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65222a0();
        } else {
            c10650d1.write(((InterfaceC9379c) obj).mo58779c());
        }
    }
}
