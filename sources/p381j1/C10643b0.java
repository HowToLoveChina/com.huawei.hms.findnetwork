package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.InterfaceC10408t;
import p481n1.C11603o;

/* renamed from: j1.b0 */
/* loaded from: classes.dex */
public class C10643b0 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: b */
    public static C10643b0 f51168b = new C10643b0();

    /* renamed from: a */
    public NumberFormat f51169a;

    public C10643b0() {
    }

    /* renamed from: f */
    public static <T> T m65192f(C10077a c10077a) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 2) {
            String strMo62757D0 = interfaceC10079c.mo62757D0();
            interfaceC10079c.mo62756D(16);
            return (T) Float.valueOf(Float.parseFloat(strMo62757D0));
        }
        if (interfaceC10079c.mo62768a0() == 3) {
            float fMo62766Y = interfaceC10079c.mo62766Y();
            interfaceC10079c.mo62756D(16);
            return (T) Float.valueOf(fMo62766Y);
        }
        Object objM62712G = c10077a.m62712G();
        if (objM62712G == null) {
            return null;
        }
        return (T) C11603o.m69318s(objM62712G);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        try {
            return (T) m65192f(c10077a);
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
        float fFloatValue = ((Float) obj).floatValue();
        NumberFormat numberFormat = this.f51169a;
        if (numberFormat != null) {
            c10650d1.write(numberFormat.format(fFloatValue));
        } else {
            c10650d1.m65217J(fFloatValue, true);
        }
    }

    public C10643b0(DecimalFormat decimalFormat) {
        this.f51169a = decimalFormat;
    }

    public C10643b0(String str) {
        this(new DecimalFormat(str));
    }
}
