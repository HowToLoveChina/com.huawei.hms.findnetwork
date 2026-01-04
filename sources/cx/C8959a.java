package cx;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import mw.InterfaceC11539f;
import p040bx.C1312g0;
import p040bx.C1353x0;
import p040bx.InterfaceC1297b0;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: cx.a */
/* loaded from: classes9.dex */
public final class C8959a extends AbstractC8960b implements InterfaceC1297b0 {
    private volatile C8959a _immediate;

    /* renamed from: b */
    public final Handler f45463b;

    /* renamed from: c */
    public final String f45464c;

    /* renamed from: d */
    public final boolean f45465d;

    /* renamed from: e */
    public final C8959a f45466e;

    public C8959a(Handler handler, String str) {
        this(handler, str, false);
    }

    /* renamed from: B */
    public final void m56712B(InterfaceC11539f interfaceC11539f, Runnable runnable) {
        C1353x0.m7843a(interfaceC11539f, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C1312g0.m7755a().mo7787c(interfaceC11539f, runnable);
    }

    @Override // p040bx.AbstractC1301c1
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public C8959a mo7738z() {
        return this.f45466e;
    }

    @Override // p040bx.AbstractC1344t
    /* renamed from: c */
    public void mo7787c(InterfaceC11539f interfaceC11539f, Runnable runnable) {
        if (this.f45463b.post(runnable)) {
            return;
        }
        m56712B(interfaceC11539f, runnable);
    }

    @Override // p040bx.AbstractC1344t
    /* renamed from: d */
    public boolean mo7788d(InterfaceC11539f interfaceC11539f) {
        return (this.f45465d && C13267j.m79673a(Looper.myLooper(), this.f45463b.getLooper())) ? false : true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C8959a) && ((C8959a) obj).f45463b == this.f45463b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f45463b);
    }

    @Override // p040bx.AbstractC1301c1, p040bx.AbstractC1344t
    public String toString() {
        String strM7737A = m7737A();
        if (strM7737A != null) {
            return strM7737A;
        }
        String string = this.f45464c;
        if (string == null) {
            string = this.f45463b.toString();
        }
        return this.f45465d ? C13267j.m79683k(string, ".immediate") : string;
    }

    public /* synthetic */ C8959a(Handler handler, String str, int i10, C13264g c13264g) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public C8959a(Handler handler, String str, boolean z10) {
        super(null);
        this.f45463b = handler;
        this.f45464c = str;
        this.f45465d = z10;
        this._immediate = z10 ? this : null;
        C8959a c8959a = this._immediate;
        if (c8959a == null) {
            c8959a = new C8959a(handler, str, true);
            this._immediate = c8959a;
        }
        this.f45466e = c8959a;
    }
}
