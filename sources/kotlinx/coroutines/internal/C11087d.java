package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import mw.InterfaceC11537d;
import mw.InterfaceC11539f;
import p040bx.AbstractC1306e0;
import p040bx.AbstractC1321j0;
import p040bx.AbstractC1344t;
import p040bx.C1314h;
import p040bx.C1319i1;
import p040bx.C1334o;
import p040bx.C1340r;
import p040bx.C1354y;
import p408jw.C10951q;
import p536ow.InterfaceC12051d;

/* renamed from: kotlinx.coroutines.internal.d */
/* loaded from: classes9.dex */
public final class C11087d<T> extends AbstractC1306e0<T> implements InterfaceC12051d, InterfaceC11537d<T> {

    /* renamed from: h */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52299h = AtomicReferenceFieldUpdater.newUpdater(C11087d.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: d */
    public final AbstractC1344t f52300d;

    /* renamed from: e */
    public final InterfaceC11537d<T> f52301e;

    /* renamed from: f */
    public Object f52302f;

    /* renamed from: g */
    public final Object f52303g;

    /* JADX WARN: Multi-variable type inference failed */
    public C11087d(AbstractC1344t abstractC1344t, InterfaceC11537d<? super T> interfaceC11537d) {
        super(-1);
        this.f52300d = abstractC1344t;
        this.f52301e = interfaceC11537d;
        this.f52302f = C11088e.f52304a;
        this.f52303g = C11108y.m66818b(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // p040bx.AbstractC1306e0
    /* renamed from: a */
    public void mo7741a(Object obj, Throwable th2) {
        if (obj instanceof C1334o) {
            ((C1334o) obj).f5834b.mo5000c(th2);
        }
    }

    @Override // p536ow.InterfaceC12051d
    /* renamed from: c */
    public InterfaceC12051d mo7759c() {
        InterfaceC11537d<T> interfaceC11537d = this.f52301e;
        if (interfaceC11537d instanceof InterfaceC12051d) {
            return (InterfaceC12051d) interfaceC11537d;
        }
        return null;
    }

    @Override // mw.InterfaceC11537d
    /* renamed from: d */
    public void mo7657d(Object obj) {
        InterfaceC11539f context = this.f52301e.getContext();
        Object objM7827d = C1340r.m7827d(obj, null, 1, null);
        if (this.f52300d.mo7788d(context)) {
            this.f52302f = objM7827d;
            this.f5794c = 0;
            this.f52300d.mo7787c(context, this);
            return;
        }
        AbstractC1321j0 abstractC1321j0M7775a = C1319i1.f5807a.m7775a();
        if (abstractC1321j0M7775a.m7780C()) {
            this.f52302f = objM7827d;
            this.f5794c = 0;
            abstractC1321j0M7775a.m7785n(this);
            return;
        }
        abstractC1321j0M7775a.m7779A(true);
        try {
            InterfaceC11539f context2 = getContext();
            Object objM66819c = C11108y.m66819c(context2, this.f52303g);
            try {
                this.f52301e.mo7657d(obj);
                C10951q c10951q = C10951q.f51861a;
                while (abstractC1321j0M7775a.m7782E()) {
                }
            } finally {
                C11108y.m66817a(context2, objM66819c);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // p040bx.AbstractC1306e0
    /* renamed from: e */
    public InterfaceC11537d<T> mo7742e() {
        return this;
    }

    @Override // mw.InterfaceC11537d
    public InterfaceC11539f getContext() {
        return this.f52301e.getContext();
    }

    @Override // p040bx.AbstractC1306e0
    /* renamed from: i */
    public Object mo7746i() {
        Object obj = this.f52302f;
        this.f52302f = C11088e.f52304a;
        return obj;
    }

    /* renamed from: j */
    public final void m66748j() {
        while (this._reusableCancellableContinuation == C11088e.f52305b) {
        }
    }

    /* renamed from: k */
    public final C1314h<?> m66749k() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof C1314h) {
            return (C1314h) obj;
        }
        return null;
    }

    /* renamed from: l */
    public final boolean m66750l() {
        return this._reusableCancellableContinuation != null;
    }

    /* renamed from: m */
    public final void m66751m() {
        m66748j();
        C1314h<?> c1314hM66749k = m66749k();
        if (c1314hM66749k == null) {
            return;
        }
        c1314hM66749k.m7763m();
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f52300d + ", " + C1354y.m7846c(this.f52301e) + ']';
    }
}
