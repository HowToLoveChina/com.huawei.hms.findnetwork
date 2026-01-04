package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.l */
/* loaded from: classes.dex */
public class C10669l implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final BigDecimal f51300a = BigDecimal.valueOf(-9007199254740991L);

    /* renamed from: b */
    public static final BigDecimal f51301b = BigDecimal.valueOf(9007199254740991L);

    /* renamed from: c */
    public static final C10669l f51302c = new C10669l();

    /* renamed from: f */
    public static <T> T m65305f(C10077a c10077a) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 2) {
            T t10 = (T) interfaceC10079c.mo62759F();
            interfaceC10079c.mo62756D(16);
            return t10;
        }
        if (interfaceC10079c.mo62768a0() == 3) {
            T t11 = (T) interfaceC10079c.mo62759F();
            interfaceC10079c.mo62756D(16);
            return t11;
        }
        Object objM62712G = c10077a.m62712G();
        if (objM62712G == null) {
            return null;
        }
        return (T) C11603o.m69298i(objM62712G);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        try {
            return (T) m65305f(c10077a);
        } catch (Exception e10) {
            throw new C9380d("parseDecimal error, field : " + obj, e10);
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
        BigDecimal bigDecimal = (BigDecimal) obj;
        int iScale = bigDecimal.scale();
        String string = (!EnumC10653e1.m65241e(i10, c10650d1.f51197c, EnumC10653e1.WriteBigDecimalAsPlain) || iScale < -100 || iScale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString();
        if (iScale == 0 && string.length() >= 16 && EnumC10653e1.m65241e(i10, c10650d1.f51197c, EnumC10653e1.BrowserCompatible) && (bigDecimal.compareTo(f51300a) < 0 || bigDecimal.compareTo(f51301b) > 0)) {
            c10650d1.m65228g0(string);
            return;
        }
        c10650d1.write(string);
        if (c10650d1.m65237w(EnumC10653e1.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            c10650d1.write(46);
        }
    }
}
