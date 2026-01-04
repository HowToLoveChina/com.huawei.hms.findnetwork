package p335hd;

import android.content.Context;
import android.os.Handler;
import p581qk.AbstractC12367d;
import p681uj.C13198o;

/* renamed from: hd.h */
/* loaded from: classes3.dex */
public class C10145h extends AbstractC12367d {

    /* renamed from: a */
    public boolean f49440a;

    /* renamed from: b */
    public Handler f49441b;

    /* renamed from: c */
    public Context f49442c;

    public C10145h(Context context, boolean z10) {
        this.f49442c = context;
        this.f49440a = z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C13198o.m79385c().m79389f(this.f49442c, this.f49440a, this.f49441b);
    }

    public C10145h(Context context, boolean z10, Handler handler) {
        this.f49442c = context;
        this.f49440a = z10;
        this.f49441b = handler;
    }
}
