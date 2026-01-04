package p354i1;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;
import p481n1.C11603o;

/* renamed from: i1.s */
/* loaded from: classes.dex */
public class C10407s implements InterfaceC10408t {

    /* renamed from: a */
    public static final C10407s f50234a = new C10407s();

    /* JADX WARN: Type inference failed for: r7v13, types: [T, java.math.BigDecimal] */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strMo62757D0 = interfaceC10079c.mo62757D0();
                interfaceC10079c.mo62756D(16);
                return (T) Double.valueOf(Double.parseDouble(strMo62757D0));
            }
            long jMo62783u = interfaceC10079c.mo62783u();
            interfaceC10079c.mo62756D(16);
            if (type == Short.TYPE || type == Short.class) {
                if (jMo62783u <= 32767 && jMo62783u >= -32768) {
                    return (T) Short.valueOf((short) jMo62783u);
                }
                throw new C9380d("short overflow : " + jMo62783u);
            }
            if (type != Byte.TYPE && type != Byte.class) {
                return (jMo62783u < -2147483648L || jMo62783u > 2147483647L) ? (T) Long.valueOf(jMo62783u) : (T) Integer.valueOf((int) jMo62783u);
            }
            if (jMo62783u <= 127 && jMo62783u >= -128) {
                return (T) Byte.valueOf((byte) jMo62783u);
            }
            throw new C9380d("short overflow : " + jMo62783u);
        }
        if (interfaceC10079c.mo62768a0() == 3) {
            if (type == Double.TYPE || type == Double.class) {
                String strMo62757D02 = interfaceC10079c.mo62757D0();
                interfaceC10079c.mo62756D(16);
                return (T) Double.valueOf(Double.parseDouble(strMo62757D02));
            }
            if (type == Short.TYPE || type == Short.class) {
                BigDecimal bigDecimalMo62759F = interfaceC10079c.mo62759F();
                interfaceC10079c.mo62756D(16);
                return (T) Short.valueOf(C11603o.m69266M0(bigDecimalMo62759F));
            }
            if (type == Byte.TYPE || type == Byte.class) {
                BigDecimal bigDecimalMo62759F2 = interfaceC10079c.mo62759F();
                interfaceC10079c.mo62756D(16);
                return (T) Byte.valueOf(C11603o.m69290e(bigDecimalMo62759F2));
            }
            ?? r72 = (T) interfaceC10079c.mo62759F();
            interfaceC10079c.mo62756D(16);
            return interfaceC10079c.mo62788x0(EnumC10078b.UseBigDecimal) ? r72 : (T) Double.valueOf(r72.doubleValue());
        }
        if (interfaceC10079c.mo62768a0() == 18 && "NaN".equals(interfaceC10079c.mo62763J())) {
            interfaceC10079c.mo62790z();
            if (type == Double.class) {
                return (T) Double.valueOf(Double.NaN);
            }
            if (type == Float.class) {
                return (T) Float.valueOf(Float.NaN);
            }
            return null;
        }
        Object objM62712G = c10077a.m62712G();
        if (objM62712G == null) {
            return null;
        }
        if (type == Double.TYPE || type == Double.class) {
            try {
                return (T) C11603o.m69314q(objM62712G);
            } catch (Exception e10) {
                throw new C9380d("parseDouble error, field : " + obj, e10);
            }
        }
        if (type == Short.TYPE || type == Short.class) {
            try {
                return (T) C11603o.m69326w(objM62712G);
            } catch (Exception e11) {
                throw new C9380d("parseShort error, field : " + obj, e11);
            }
        }
        if (type != Byte.TYPE && type != Byte.class) {
            return (T) C11603o.m69298i(objM62712G);
        }
        try {
            return (T) C11603o.m69304l(objM62712G);
        } catch (Exception e12) {
            throw new C9380d("parseByte error, field : " + obj, e12);
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 2;
    }
}
