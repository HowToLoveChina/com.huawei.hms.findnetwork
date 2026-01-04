package p354i1;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.C10082f;
import p323h1.InterfaceC10079c;
import p481n1.C11603o;

/* renamed from: i1.c0 */
/* loaded from: classes.dex */
public class C10391c0 implements InterfaceC10408t {

    /* renamed from: a */
    public static final C10391c0 f50189a = new C10391c0();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) throws NumberFormatException {
        long timeInMillis;
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        if (interfaceC10079c.mo62768a0() == 16) {
            interfaceC10079c.mo62756D(4);
            if (interfaceC10079c.mo62768a0() != 4) {
                throw new C9380d("syntax error");
            }
            interfaceC10079c.mo62762I(2);
            if (interfaceC10079c.mo62768a0() != 2) {
                throw new C9380d("syntax error");
            }
            long jMo62783u = interfaceC10079c.mo62783u();
            interfaceC10079c.mo62756D(13);
            if (interfaceC10079c.mo62768a0() != 13) {
                throw new C9380d("syntax error");
            }
            interfaceC10079c.mo62756D(16);
            return (T) new Time(jMo62783u);
        }
        T t10 = (T) c10077a.m62712G();
        if (t10 == 0) {
            return null;
        }
        if (t10 instanceof Time) {
            return t10;
        }
        if (t10 instanceof BigDecimal) {
            return (T) new Time(C11603o.m69248D0((BigDecimal) t10));
        }
        if (t10 instanceof Number) {
            return (T) new Time(((Number) t10).longValue());
        }
        if (!(t10 instanceof String)) {
            throw new C9380d("parse error");
        }
        String str = (String) t10;
        if (str.length() == 0) {
            return null;
        }
        C10082f c10082f = new C10082f(str);
        if (c10082f.m62837t1()) {
            timeInMillis = c10082f.m62795G0().getTimeInMillis();
        } else {
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (cCharAt < '0' || cCharAt > '9') {
                    c10082f.close();
                    return (T) Time.valueOf(str);
                }
            }
            timeInMillis = Long.parseLong(str);
        }
        c10082f.close();
        return (T) new Time(timeInMillis);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 2;
    }
}
