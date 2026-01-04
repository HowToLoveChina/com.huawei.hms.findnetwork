package androidx.lifecycle;

import androidx.lifecycle.AbstractC0791h;
import p321h.C10073a;
import p352i.C10381b;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k */
    public static final Object f4111k = new Object();

    /* renamed from: a */
    public final Object f4112a;

    /* renamed from: b */
    public C10381b<InterfaceC0802r<? super T>, LiveData<T>.AbstractC0774c> f4113b;

    /* renamed from: c */
    public int f4114c;

    /* renamed from: d */
    public boolean f4115d;

    /* renamed from: e */
    public volatile Object f4116e;

    /* renamed from: f */
    public volatile Object f4117f;

    /* renamed from: g */
    public int f4118g;

    /* renamed from: h */
    public boolean f4119h;

    /* renamed from: i */
    public boolean f4120i;

    /* renamed from: j */
    public final Runnable f4121j;

    public class LifecycleBoundObserver extends LiveData<T>.AbstractC0774c implements InterfaceC0794j {

        /* renamed from: e */
        public final InterfaceC0796l f4122e;

        public LifecycleBoundObserver(InterfaceC0796l interfaceC0796l, InterfaceC0802r<? super T> interfaceC0802r) {
            super(interfaceC0802r);
            this.f4122e = interfaceC0796l;
        }

        @Override // androidx.lifecycle.InterfaceC0794j
        /* renamed from: d */
        public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            AbstractC0791h.c cVarMo4949b = this.f4122e.mo1915g().mo4949b();
            if (cVarMo4949b == AbstractC0791h.c.DESTROYED) {
                LiveData.this.mo4895m(this.f4126a);
                return;
            }
            AbstractC0791h.c cVar = null;
            while (cVar != cVarMo4949b) {
                m4900e(mo4899h());
                cVar = cVarMo4949b;
                cVarMo4949b = this.f4122e.mo1915g().mo4949b();
            }
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0774c
        /* renamed from: f */
        public void mo4897f() {
            this.f4122e.mo1915g().mo4950c(this);
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0774c
        /* renamed from: g */
        public boolean mo4898g(InterfaceC0796l interfaceC0796l) {
            return this.f4122e == interfaceC0796l;
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0774c
        /* renamed from: h */
        public boolean mo4899h() {
            return this.f4122e.mo1915g().mo4949b().m4954b(AbstractC0791h.c.STARTED);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$a */
    public class RunnableC0772a implements Runnable {
        public RunnableC0772a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f4112a) {
                obj = LiveData.this.f4117f;
                LiveData.this.f4117f = LiveData.f4111k;
            }
            LiveData.this.mo4896n(obj);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$b */
    public class C0773b extends LiveData<T>.AbstractC0774c {
        public C0773b(InterfaceC0802r<? super T> interfaceC0802r) {
            super(interfaceC0802r);
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0774c
        /* renamed from: h */
        public boolean mo4899h() {
            return true;
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$c */
    public abstract class AbstractC0774c {

        /* renamed from: a */
        public final InterfaceC0802r<? super T> f4126a;

        /* renamed from: b */
        public boolean f4127b;

        /* renamed from: c */
        public int f4128c = -1;

        public AbstractC0774c(InterfaceC0802r<? super T> interfaceC0802r) {
            this.f4126a = interfaceC0802r;
        }

        /* renamed from: e */
        public void m4900e(boolean z10) {
            if (z10 == this.f4127b) {
                return;
            }
            this.f4127b = z10;
            LiveData.this.m4885c(z10 ? 1 : -1);
            if (this.f4127b) {
                LiveData.this.m4887e(this);
            }
        }

        /* renamed from: f */
        public void mo4897f() {
        }

        /* renamed from: g */
        public boolean mo4898g(InterfaceC0796l interfaceC0796l) {
            return false;
        }

        /* renamed from: h */
        public abstract boolean mo4899h();
    }

    public LiveData(T t10) {
        this.f4112a = new Object();
        this.f4113b = new C10381b<>();
        this.f4114c = 0;
        this.f4117f = f4111k;
        this.f4121j = new RunnableC0772a();
        this.f4116e = t10;
        this.f4118g = 0;
    }

    /* renamed from: b */
    public static void m4884b(String str) {
        if (C10073a.m62696d().mo62698b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    /* renamed from: c */
    public void m4885c(int i10) {
        int i11 = this.f4114c;
        this.f4114c = i10 + i11;
        if (this.f4115d) {
            return;
        }
        this.f4115d = true;
        while (true) {
            try {
                int i12 = this.f4114c;
                if (i11 == i12) {
                    this.f4115d = false;
                    return;
                }
                boolean z10 = i11 == 0 && i12 > 0;
                boolean z11 = i11 > 0 && i12 == 0;
                if (z10) {
                    mo4892j();
                } else if (z11) {
                    mo4893k();
                }
                i11 = i12;
            } catch (Throwable th2) {
                this.f4115d = false;
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public final void m4886d(LiveData<T>.AbstractC0774c abstractC0774c) {
        if (abstractC0774c.f4127b) {
            if (!abstractC0774c.mo4899h()) {
                abstractC0774c.m4900e(false);
                return;
            }
            int i10 = abstractC0774c.f4128c;
            int i11 = this.f4118g;
            if (i10 >= i11) {
                return;
            }
            abstractC0774c.f4128c = i11;
            abstractC0774c.f4126a.mo4709a((Object) this.f4116e);
        }
    }

    /* renamed from: e */
    public void m4887e(LiveData<T>.AbstractC0774c abstractC0774c) {
        if (this.f4119h) {
            this.f4120i = true;
            return;
        }
        this.f4119h = true;
        do {
            this.f4120i = false;
            if (abstractC0774c != null) {
                m4886d(abstractC0774c);
                abstractC0774c = null;
            } else {
                C10381b<InterfaceC0802r<? super T>, LiveData<T>.AbstractC0774c>.d dVarM63821d = this.f4113b.m63821d();
                while (dVarM63821d.hasNext()) {
                    m4886d((AbstractC0774c) dVarM63821d.next().getValue());
                    if (this.f4120i) {
                        break;
                    }
                }
            }
        } while (this.f4120i);
        this.f4119h = false;
    }

    /* renamed from: f */
    public T m4888f() {
        T t10 = (T) this.f4116e;
        if (t10 != f4111k) {
            return t10;
        }
        return null;
    }

    /* renamed from: g */
    public boolean m4889g() {
        return this.f4114c > 0;
    }

    /* renamed from: h */
    public void m4890h(InterfaceC0796l interfaceC0796l, InterfaceC0802r<? super T> interfaceC0802r) {
        m4884b("observe");
        if (interfaceC0796l.mo1915g().mo4949b() == AbstractC0791h.c.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(interfaceC0796l, interfaceC0802r);
        LiveData<T>.AbstractC0774c abstractC0774cMo63816g = this.f4113b.mo63816g(interfaceC0802r, lifecycleBoundObserver);
        if (abstractC0774cMo63816g != null && !abstractC0774cMo63816g.mo4898g(interfaceC0796l)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0774cMo63816g != null) {
            return;
        }
        interfaceC0796l.mo1915g().mo4948a(lifecycleBoundObserver);
    }

    /* renamed from: i */
    public void m4891i(InterfaceC0802r<? super T> interfaceC0802r) {
        m4884b("observeForever");
        C0773b c0773b = new C0773b(interfaceC0802r);
        LiveData<T>.AbstractC0774c abstractC0774cMo63816g = this.f4113b.mo63816g(interfaceC0802r, c0773b);
        if (abstractC0774cMo63816g instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0774cMo63816g != null) {
            return;
        }
        c0773b.m4900e(true);
    }

    /* renamed from: j */
    public void mo4892j() {
    }

    /* renamed from: k */
    public void mo4893k() {
    }

    /* renamed from: l */
    public void mo4894l(T t10) {
        boolean z10;
        synchronized (this.f4112a) {
            z10 = this.f4117f == f4111k;
            this.f4117f = t10;
        }
        if (z10) {
            C10073a.m62696d().mo62699c(this.f4121j);
        }
    }

    /* renamed from: m */
    public void mo4895m(InterfaceC0802r<? super T> interfaceC0802r) {
        m4884b("removeObserver");
        LiveData<T>.AbstractC0774c abstractC0774cMo63817h = this.f4113b.mo63817h(interfaceC0802r);
        if (abstractC0774cMo63817h == null) {
            return;
        }
        abstractC0774cMo63817h.mo4897f();
        abstractC0774cMo63817h.m4900e(false);
    }

    /* renamed from: n */
    public void mo4896n(T t10) {
        m4884b("setValue");
        this.f4118g++;
        this.f4116e = t10;
        m4887e(null);
    }

    public LiveData() {
        this.f4112a = new Object();
        this.f4113b = new C10381b<>();
        this.f4114c = 0;
        Object obj = f4111k;
        this.f4117f = obj;
        this.f4121j = new RunnableC0772a();
        this.f4116e = obj;
        this.f4118g = -1;
    }
}
