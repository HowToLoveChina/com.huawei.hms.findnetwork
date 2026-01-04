package p216d4;

import android.content.Context;
import p357i4.AbstractC10436a;
import p357i4.AbstractC10437b;
import p384j4.C10703b;

/* renamed from: d4.t */
/* loaded from: classes.dex */
public class C9033t extends AbstractC10436a {

    /* renamed from: c */
    public static C9033t f45691c;

    /* renamed from: d */
    public static final byte[] f45692d = new byte[0];

    public C9033t(Context context) {
        super(context, "hiad_recd.db", null, 7);
    }

    /* renamed from: a0 */
    public static C9033t m56980a0(Context context) {
        C9033t c9033t;
        synchronized (f45692d) {
            try {
                if (f45691c == null) {
                    f45691c = new C9033t(C10703b.m65334b(context.getApplicationContext()));
                }
                AbstractC10436a.f50382b.incrementAndGet();
                c9033t = f45691c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c9033t;
    }

    @Override // p357i4.AbstractC10436a
    /* renamed from: G */
    public AbstractC10437b mo56981G() {
        return new C9035v(this);
    }

    @Override // p357i4.AbstractC10436a
    /* renamed from: H */
    public String mo56982H() {
        return "AdsRecDbHelper";
    }

    @Override // p357i4.AbstractC10436a
    /* renamed from: V */
    public boolean mo56983V() {
        return true;
    }
}
