package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;

/* renamed from: j1.f1 */
/* loaded from: classes.dex */
public class C10656f1 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static C10656f1 f51252a = new C10656f1();

    /* renamed from: f */
    public static <T> T m65245f(C10077a c10077a) {
        InterfaceC10079c interfaceC10079cM62706A = c10077a.m62706A();
        if (interfaceC10079cM62706A.mo62768a0() == 4) {
            T t10 = (T) interfaceC10079cM62706A.mo62763J();
            interfaceC10079cM62706A.mo62756D(16);
            return t10;
        }
        if (interfaceC10079cM62706A.mo62768a0() == 2) {
            T t11 = (T) interfaceC10079cM62706A.mo62757D0();
            interfaceC10079cM62706A.mo62756D(16);
            return t11;
        }
        Object objM62712G = c10077a.m62712G();
        if (objM62712G == null) {
            return null;
        }
        return (T) objM62712G.toString();
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        if (type == StringBuffer.class) {
            InterfaceC10079c interfaceC10079c = c10077a.f49153f;
            if (interfaceC10079c.mo62768a0() == 4) {
                String strMo62763J = interfaceC10079c.mo62763J();
                interfaceC10079c.mo62756D(16);
                return (T) new StringBuffer(strMo62763J);
            }
            Object objM62712G = c10077a.m62712G();
            if (objM62712G == null) {
                return null;
            }
            return (T) new StringBuffer(objM62712G.toString());
        }
        if (type != StringBuilder.class) {
            return (T) m65245f(c10077a);
        }
        InterfaceC10079c interfaceC10079c2 = c10077a.f49153f;
        if (interfaceC10079c2.mo62768a0() == 4) {
            String strMo62763J2 = interfaceC10079c2.mo62763J();
            interfaceC10079c2.mo62756D(16);
            return (T) new StringBuilder(strMo62763J2);
        }
        Object objM62712G2 = c10077a.m62712G();
        if (objM62712G2 == null) {
            return null;
        }
        return (T) new StringBuilder(objM62712G2.toString());
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 4;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        m65246g(c10664i0, (String) obj);
    }

    /* renamed from: g */
    public void m65246g(C10664i0 c10664i0, String str) {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (str == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullStringAsEmpty);
        } else {
            c10650d1.m65228g0(str);
        }
    }
}
