package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;
import p244e1.C9380d;
import p244e1.C9381e;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.d0 */
/* loaded from: classes.dex */
public class C10649d0 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static C10649d0 f51188a = new C10649d0();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        Object obj2;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        int iMo62768a0 = interfaceC10079c.mo62768a0();
        if (iMo62768a0 == 8) {
            interfaceC10079c.mo62756D(16);
            return null;
        }
        try {
            if (iMo62768a0 == 2) {
                int iMo62753B = interfaceC10079c.mo62753B();
                interfaceC10079c.mo62756D(16);
                obj2 = (T) Integer.valueOf(iMo62753B);
            } else if (iMo62768a0 == 3) {
                Integer numValueOf = Integer.valueOf(C11603o.m69303k0(interfaceC10079c.mo62759F()));
                interfaceC10079c.mo62756D(16);
                obj2 = (T) numValueOf;
            } else if (iMo62768a0 == 12) {
                C9381e c9381e = new C9381e(true);
                c10077a.m62730i0(c9381e);
                obj2 = (T) C11603o.m69320t(c9381e);
            } else {
                obj2 = (T) C11603o.m69320t(c10077a.m62712G());
            }
            return type == AtomicInteger.class ? (T) new AtomicInteger(((Integer) obj2).intValue()) : (T) obj2;
        } catch (Exception e10) {
            String str = "parseInt error";
            if (obj != null) {
                str = "parseInt error, field : " + obj;
            }
            throw new C9380d(str, e10);
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 2;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        Number number = (Number) obj;
        if (number == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            c10650d1.m65221Z(number.longValue());
        } else {
            c10650d1.m65219X(number.intValue());
        }
        if (c10650d1.m65237w(EnumC10653e1.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                c10650d1.write(66);
            } else if (cls == Short.class) {
                c10650d1.write(83);
            }
        }
    }
}
