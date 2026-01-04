package p354i1;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.C10082f;
import p481n1.C11603o;

/* renamed from: i1.z */
/* loaded from: classes.dex */
public class C10414z extends AbstractC10388b implements InterfaceC10408t {

    /* renamed from: b */
    public static final C10414z f50243b = new C10414z();

    /* renamed from: c */
    public static final C10414z f50244c = new C10414z(true);

    /* renamed from: a */
    public boolean f50245a = false;

    public C10414z() {
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 2;
    }

    @Override // p354i1.AbstractC10388b
    /* renamed from: g */
    public <T> T mo63894g(C10077a c10077a, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (this.f50245a) {
            return (T) m63945h(c10077a, type, obj, obj2);
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new java.sql.Date(((Date) obj2).getTime());
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new java.sql.Date(C11603o.m69248D0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new java.sql.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new C9380d("parse error : " + obj2);
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        C10082f c10082f = new C10082f(str);
        try {
            if (c10082f.m62837t1()) {
                timeInMillis = c10082f.m62795G0().getTimeInMillis();
            } else {
                try {
                    T t10 = (T) new java.sql.Date(c10077a.m62743v().parse(str).getTime());
                    c10082f.close();
                    return t10;
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            c10082f.close();
            return (T) new java.sql.Date(timeInMillis);
        } catch (Throwable th2) {
            c10082f.close();
            throw th2;
        }
    }

    /* renamed from: h */
    public <T> T m63945h(C10077a c10077a, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new Timestamp(((Date) obj2).getTime());
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Timestamp(C11603o.m69248D0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new Timestamp(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new C9380d("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        C10082f c10082f = new C10082f(str);
        try {
            if (str.length() > 19 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                String strM62741u = c10077a.m62741u();
                if (strM62741u.length() != str.length() && strM62741u == AbstractC9377a.f46782e) {
                    return (T) Timestamp.valueOf(str);
                }
            }
            if (c10082f.m62838u1(false)) {
                timeInMillis = c10082f.m62795G0().getTimeInMillis();
            } else {
                try {
                    return (T) new Timestamp(c10077a.m62743v().parse(str).getTime());
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            c10082f.close();
            return (T) new Timestamp(timeInMillis);
        } finally {
            c10082f.close();
        }
    }

    public C10414z(boolean z10) {
    }
}
