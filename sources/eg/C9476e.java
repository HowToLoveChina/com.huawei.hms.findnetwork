package eg;

import android.content.Context;
import bf.C1175a;
import p521og.C11875h;

/* renamed from: eg.e */
/* loaded from: classes4.dex */
public class C9476e extends AbstractC9478g {

    /* renamed from: a */
    public Context f47246a;

    /* renamed from: b */
    public boolean f47247b;

    public C9476e(Context context, boolean z10) {
        this.f47246a = context;
        this.f47247b = z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Context context = this.f47246a;
        if (context != null) {
            C1175a.m7398t(this.f47247b, context);
            C11875h.m71193d(this.f47246a);
        }
    }
}
