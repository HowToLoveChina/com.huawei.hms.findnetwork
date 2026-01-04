package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;
import p244e1.C9380d;
import p244e1.C9381e;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.o0 */
/* loaded from: classes.dex */
public class C10676o0 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static C10676o0 f51312a = new C10676o0();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        Object objM69324v;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        try {
            int iMo62768a0 = interfaceC10079c.mo62768a0();
            if (iMo62768a0 == 2) {
                long jMo62783u = interfaceC10079c.mo62783u();
                interfaceC10079c.mo62756D(16);
                objM69324v = (T) Long.valueOf(jMo62783u);
            } else if (iMo62768a0 == 3) {
                Object objValueOf = Long.valueOf(C11603o.m69248D0(interfaceC10079c.mo62759F()));
                interfaceC10079c.mo62756D(16);
                objM69324v = (T) objValueOf;
            } else {
                if (iMo62768a0 == 12) {
                    C9381e c9381e = new C9381e(true);
                    c10077a.m62730i0(c9381e);
                    objM69324v = (T) C11603o.m69324v(c9381e);
                } else {
                    objM69324v = C11603o.m69324v(c10077a.m62712G());
                }
                if (objM69324v == null) {
                    return null;
                }
            }
            return type == AtomicLong.class ? (T) new AtomicLong(((Long) objM69324v).longValue()) : (T) objM69324v;
        } catch (Exception e10) {
            throw new C9380d("parseLong error, field : " + obj, e10);
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
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullNumberAsZero);
            return;
        }
        long jLongValue = ((Long) obj).longValue();
        c10650d1.m65221Z(jLongValue);
        if (!c10650d1.m65237w(EnumC10653e1.WriteClassName) || jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class || type == Long.TYPE) {
            return;
        }
        c10650d1.write(76);
    }
}
