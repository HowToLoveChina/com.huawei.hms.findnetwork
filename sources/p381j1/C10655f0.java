package p381j1;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/* renamed from: j1.f0 */
/* loaded from: classes.dex */
public class C10655f0 implements InterfaceC10686t0 {

    /* renamed from: a */
    public static final C10655f0 f51251a = new C10655f0();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws NoSuchFieldException, SecurityException, IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        C10678p0 c10678p0 = C10678p0.f51315j;
        try {
            Field declaredField = obj.getClass().getDeclaredField("map");
            if (Modifier.isPrivate(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }
            c10678p0.mo63933e(c10664i0, declaredField.get(obj), obj2, type, i10);
        } catch (Exception unused) {
            c10650d1.m65222a0();
        }
    }
}
