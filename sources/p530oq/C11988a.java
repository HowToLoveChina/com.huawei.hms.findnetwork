package p530oq;

import android.content.Context;

/* renamed from: oq.a */
/* loaded from: classes8.dex */
public class C11988a extends C11989b {

    /* renamed from: d */
    public static C11988a f55778d;

    public C11988a(Context context, String str) {
        super(context, str);
    }

    /* renamed from: k */
    public static synchronized C11988a m72133k(Context context) {
        try {
            if (f55778d == null) {
                f55778d = new C11988a(context, "HwIDAuthInfo");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f55778d;
    }
}
