package p593qw;

import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import java.lang.reflect.InvocationTargetException;
import p692uw.C13267j;
import pw.C12239a;

/* renamed from: qw.a */
/* loaded from: classes9.dex */
public class C12421a extends C12239a {

    /* renamed from: qw.a$a */
    public static final class a {

        /* renamed from: a */
        public static final a f57259a = new a();

        /* renamed from: b */
        public static final Integer f57260b;

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
            f57260b = num;
        }
    }

    /* renamed from: c */
    private final boolean m74568c(int i10) {
        Integer num = a.f57260b;
        return num == null || num.intValue() >= i10;
    }

    @Override // pw.C12239a
    /* renamed from: a */
    public void mo73439a(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13267j.m79677e(th2, "cause");
        C13267j.m79677e(th3, TrackConstants$Events.EXCEPTION);
        if (m74568c(19)) {
            th2.addSuppressed(th3);
        } else {
            super.mo73439a(th2, th3);
        }
    }
}
