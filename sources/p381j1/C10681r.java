package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import p323h1.C10077a;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.r */
/* loaded from: classes.dex */
public class C10681r implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10681r f51321a = new C10681r();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        Object objM62712G = c10077a.m62712G();
        if (objM62712G == null) {
            return null;
        }
        return (T) C11603o.m69308n(objM62712G);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 4;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        Character ch2 = (Character) obj;
        if (ch2 == null) {
            c10650d1.m65228g0("");
        } else if (ch2.charValue() == 0) {
            c10650d1.m65228g0("\u0000");
        } else {
            c10650d1.m65228g0(ch2.toString());
        }
    }
}
