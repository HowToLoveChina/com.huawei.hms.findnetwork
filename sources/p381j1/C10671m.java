package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.m */
/* loaded from: classes.dex */
public class C10671m implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final BigInteger f51303a = BigInteger.valueOf(-9007199254740991L);

    /* renamed from: b */
    public static final BigInteger f51304b = BigInteger.valueOf(9007199254740991L);

    /* renamed from: c */
    public static final C10671m f51305c = new C10671m();

    /* renamed from: f */
    public static <T> T m65307f(C10077a c10077a) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() != 2) {
            Object objM62712G = c10077a.m62712G();
            if (objM62712G == null) {
                return null;
            }
            return (T) C11603o.m69300j(objM62712G);
        }
        String strMo62757D0 = interfaceC10079c.mo62757D0();
        interfaceC10079c.mo62756D(16);
        if (strMo62757D0.length() <= 65535) {
            return (T) new BigInteger(strMo62757D0);
        }
        throw new C9380d("decimal overflow");
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        return (T) m65307f(c10077a);
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
        BigInteger bigInteger = (BigInteger) obj;
        String string = bigInteger.toString();
        if (string.length() < 16 || !EnumC10653e1.m65241e(i10, c10650d1.f51197c, EnumC10653e1.BrowserCompatible) || (bigInteger.compareTo(f51303a) >= 0 && bigInteger.compareTo(f51304b) <= 0)) {
            c10650d1.write(string);
        } else {
            c10650d1.m65228g0(string);
        }
    }
}
