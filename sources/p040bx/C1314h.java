package p040bx;

import com.huawei.hms.network.embedded.C5929g4;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.C11087d;
import mw.InterfaceC11537d;
import mw.InterfaceC11539f;
import p408jw.C10938d;
import p408jw.C10951q;
import p464m.C11384b;
import p536ow.InterfaceC12051d;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* renamed from: bx.h */
/* loaded from: classes9.dex */
public class C1314h<T> extends AbstractC1306e0<T> implements InterfaceC1311g<T>, InterfaceC12051d {

    /* renamed from: g */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5800g = AtomicIntegerFieldUpdater.newUpdater(C1314h.class, "_decision");

    /* renamed from: h */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5801h = AtomicReferenceFieldUpdater.newUpdater(C1314h.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: d */
    public final InterfaceC11537d<T> f5802d;

    /* renamed from: e */
    public final InterfaceC11539f f5803e;

    /* renamed from: f */
    public InterfaceC1315h0 f5804f;

    /* renamed from: r */
    private final boolean m7757r() {
        return C1309f0.m7752c(this.f5794c) && ((C11087d) this.f5802d).m66750l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    public static /* synthetic */ void m7758u(C1314h c1314h, Object obj, int i10, InterfaceC13086l interfaceC13086l, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            interfaceC13086l = null;
        }
        c1314h.m7769t(obj, i10, interfaceC13086l);
    }

    @Override // p040bx.AbstractC1306e0
    /* renamed from: a */
    public void mo7741a(Object obj, Throwable th2) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof InterfaceC1310f1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof C1332n) {
                return;
            }
            if (obj2 instanceof C1329m) {
                C1329m c1329m = (C1329m) obj2;
                if (!(!c1329m.m7816c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (C11384b.m68273a(f5801h, this, obj2, C1329m.m7814b(c1329m, null, null, null, null, th2, 15, null))) {
                    c1329m.m7817d(this, th2);
                    return;
                }
            } else if (C11384b.m68273a(f5801h, this, obj2, new C1329m(obj2, null, null, null, th2, 14, null))) {
                return;
            }
        }
    }

    @Override // p536ow.InterfaceC12051d
    /* renamed from: c */
    public InterfaceC12051d mo7759c() {
        InterfaceC11537d<T> interfaceC11537d = this.f5802d;
        if (interfaceC11537d instanceof InterfaceC12051d) {
            return (InterfaceC12051d) interfaceC11537d;
        }
        return null;
    }

    @Override // mw.InterfaceC11537d
    /* renamed from: d */
    public void mo7657d(Object obj) {
        m7758u(this, C1340r.m7825b(obj, this), this.f5794c, null, 4, null);
    }

    @Override // p040bx.AbstractC1306e0
    /* renamed from: e */
    public final InterfaceC11537d<T> mo7742e() {
        return this.f5802d;
    }

    @Override // p040bx.AbstractC1306e0
    /* renamed from: f */
    public Throwable mo7743f(Object obj) {
        Throwable thMo7743f = super.mo7743f(obj);
        if (thMo7743f == null) {
            return null;
        }
        mo7742e();
        return thMo7743f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p040bx.AbstractC1306e0
    /* renamed from: g */
    public <T> T mo7744g(Object obj) {
        return obj instanceof C1329m ? (T) ((C1329m) obj).f5822a : obj;
    }

    @Override // mw.InterfaceC11537d
    public InterfaceC11539f getContext() {
        return this.f5803e;
    }

    @Override // p040bx.AbstractC1306e0
    /* renamed from: i */
    public Object mo7746i() {
        return m7766p();
    }

    /* renamed from: j */
    public final Void m7760j(Object obj) {
        throw new IllegalStateException(C13267j.m79683k("Already resumed, but proposed with update ", obj).toString());
    }

    /* renamed from: k */
    public final void m7761k(AbstractC1305e abstractC1305e, Throwable th2) {
        try {
            abstractC1305e.m7749a(th2);
        } catch (Throwable th3) {
            C1350w.m7841a(getContext(), new C1338q(C13267j.m79683k("Exception in invokeOnCancellation handler for ", this), th3));
        }
    }

    /* renamed from: l */
    public final void m7762l(InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l, Throwable th2) {
        try {
            interfaceC13086l.mo5000c(th2);
        } catch (Throwable th3) {
            C1350w.m7841a(getContext(), new C1338q(C13267j.m79683k("Exception in resume onCancellation handler for ", this), th3));
        }
    }

    /* renamed from: m */
    public final void m7763m() {
        InterfaceC1315h0 interfaceC1315h0 = this.f5804f;
        if (interfaceC1315h0 == null) {
            return;
        }
        interfaceC1315h0.mo7748i();
        this.f5804f = C1307e1.f5795a;
    }

    /* renamed from: n */
    public final void m7764n() {
        if (m7757r()) {
            return;
        }
        m7763m();
    }

    /* renamed from: o */
    public final void m7765o(int i10) {
        if (m7771y()) {
            return;
        }
        C1309f0.m7750a(this, i10);
    }

    /* renamed from: p */
    public final Object m7766p() {
        return this._state;
    }

    /* renamed from: q */
    public final String m7767q() {
        Object objM7766p = m7766p();
        return objM7766p instanceof InterfaceC1310f1 ? "Active" : objM7766p instanceof C1317i ? "Cancelled" : "Completed";
    }

    /* renamed from: s */
    public String m7768s() {
        return "CancellableContinuation";
    }

    /* renamed from: t */
    public final void m7769t(Object obj, int i10, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof InterfaceC1310f1)) {
                if (obj2 instanceof C1317i) {
                    C1317i c1317i = (C1317i) obj2;
                    if (c1317i.m7774c()) {
                        if (interfaceC13086l == null) {
                            return;
                        }
                        m7762l(interfaceC13086l, c1317i.f5830a);
                        return;
                    }
                }
                m7760j(obj);
                throw new C10938d();
            }
        } while (!C11384b.m68273a(f5801h, this, obj2, m7770v((InterfaceC1310f1) obj2, obj, i10, interfaceC13086l, null)));
        m7764n();
        m7765o(i10);
    }

    public String toString() {
        return m7768s() + C5929g4.f26849k + C1354y.m7846c(this.f5802d) + "){" + m7767q() + "}@" + C1354y.m7845b(this);
    }

    /* renamed from: v */
    public final Object m7770v(InterfaceC1310f1 interfaceC1310f1, Object obj, int i10, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l, Object obj2) {
        if (obj instanceof C1332n) {
            return obj;
        }
        if (!C1309f0.m7751b(i10) && obj2 == null) {
            return obj;
        }
        if (interfaceC13086l == null && !(interfaceC1310f1 instanceof AbstractC1305e) && obj2 == null) {
            return obj;
        }
        return new C1329m(obj, interfaceC1310f1 instanceof AbstractC1305e ? (AbstractC1305e) interfaceC1310f1 : null, interfaceC13086l, obj2, null, 16, null);
    }

    /* renamed from: y */
    public final boolean m7771y() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f5800g.compareAndSet(this, 0, 2));
        return true;
    }
}
