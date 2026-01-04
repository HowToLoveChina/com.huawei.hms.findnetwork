package p381j1;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import p244e1.C9380d;

/* renamed from: j1.y */
/* loaded from: classes.dex */
public class C10695y implements InterfaceC10686t0 {

    /* renamed from: b */
    public static final C10695y f51330b = new C10695y();

    /* renamed from: a */
    public final Member f51331a;

    public C10695y() {
        this.f51331a = null;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        Member member = this.f51331a;
        if (member == null) {
            c10664i0.f51258k.m65208A((Enum) obj);
            return;
        }
        try {
            c10664i0.m65262G(member instanceof Field ? ((Field) member).get(obj) : ((Method) member).invoke(obj, new Object[0]));
        } catch (Exception e10) {
            throw new C9380d("getEnumValue error", e10);
        }
    }

    public C10695y(Member member) {
        this.f51331a = member;
    }
}
