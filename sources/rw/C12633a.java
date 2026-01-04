package rw;

import p593qw.C12421a;
import p720vw.AbstractC13499c;
import p754ww.C13651a;

/* renamed from: rw.a */
/* loaded from: classes9.dex */
public class C12633a extends C12421a {

    /* renamed from: rw.a$a */
    public static final class a {

        /* renamed from: a */
        public static final a f58077a = new a();

        /* renamed from: b */
        public static final Integer f58078b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f58078b = num;
        }
    }

    @Override // pw.C12239a
    /* renamed from: b */
    public AbstractC13499c mo73440b() {
        return m76165c(34) ? new C13651a() : super.mo73440b();
    }

    /* renamed from: c */
    public final boolean m76165c(int i10) {
        Integer num = a.f58078b;
        return num == null || num.intValue() >= i10;
    }
}
