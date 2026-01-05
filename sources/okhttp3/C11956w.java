package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import okhttp3.C11916d0;
import okhttp3.C11916d0.a;

/* renamed from: okhttp3.w */
/* loaded from: classes9.dex */
public final class C11956w extends C11949p {

    /* renamed from: h */
    public int f55651h = 5;

    /* renamed from: i */
    public int f55652i = 2;

    /* renamed from: j */
    public int f55653j = 32;

    /* renamed from: k */
    public final List<b> f55654k = new ArrayList();

    /* renamed from: l */
    public int f55655l = 2;

    /* renamed from: okhttp3.w$a */
    public class a implements InterfaceC11921g {
        public a() {
        }

        @Override // okhttp3.InterfaceC11921g
        public void onFailure(InterfaceC11919f interfaceC11919f, IOException iOException) {
        }

        @Override // okhttp3.InterfaceC11921g
        public void onResponse(InterfaceC11919f interfaceC11919f, HttpResponseBuilder HttpResponseBuilder) throws IOException {
            if (HttpResponseBuilder != null) {
                HttpResponseBuilder.close();
            }
        }
    }

    /* renamed from: okhttp3.w$b */
    public final class b {

        /* renamed from: a */
        public String f55657a;

        /* renamed from: b */
        public int f55658b;

        /* renamed from: c */
        public String f55659c;

        /* renamed from: d */
        public int f55660d;

        /* renamed from: e */
        public int f55661e;

        /* renamed from: f */
        public int f55662f = 1;

        public b(String str, int i10, String str2) {
            this.f55657a = str;
            this.f55658b = i10;
            this.f55659c = str2;
            m71876a(str, i10, str2);
        }

        /* renamed from: a */
        public final void m71876a(String str, int i10, String str2) {
            Iterator<C11916d0.a> it = C11956w.this.f55641f.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                C11958y c11958yM71573m = it.next().m71543s().m71573m();
                if (c11958yM71573m.m71904l().equals(str) && c11958yM71573m.m71909w() == i10 && c11958yM71573m.m71896B().equals(str2)) {
                    i11++;
                }
            }
            this.f55661e = i11;
            Iterator<C11916d0.a> it2 = C11956w.this.f55640e.iterator();
            while (it2.hasNext()) {
                C11958y c11958yM71573m2 = it2.next().m71543s().m71573m();
                if (c11958yM71573m2.m71904l().equals(str) && c11958yM71573m2.m71909w() == i10 && c11958yM71573m2.m71896B().equals(str2)) {
                    i11++;
                }
            }
            this.f55660d = i11;
        }
    }

    @Override // okhttp3.C11949p
    /* renamed from: a */
    public void mo71826a(String str, int i10, String str2) {
        synchronized (this) {
            try {
                if (m71871r(str, i10, str2) != null) {
                    return;
                }
                this.f55654k.add(new b(str, i10, str2));
                m71868i();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // okhttp3.C11949p
    /* renamed from: b */
    public void mo71827b(C11916d0.a aVar) {
        boolean zM71870q;
        C11916d0.a aVarM71830e;
        synchronized (this) {
            try {
                if (aVar == null) {
                    return;
                }
                b bVarM71872s = m71872s(aVar.m71543s());
                if (bVarM71872s != null) {
                    zM71870q = m71870q(aVar, bVarM71872s);
                } else {
                    m71869p(aVar);
                    zM71870q = false;
                }
                if (!aVar.m71541q().f55240d && (aVarM71830e = m71830e(aVar.m71542r())) != null) {
                    aVar.m71544t(aVarM71830e);
                }
                m71868i();
                if (zM71870q) {
                    m71873t(aVar, bVarM71872s);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public final <T> void m71867f(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t10)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f55638c;
        }
        if (m71868i() || runnable == null) {
            return;
        }
        runnable.run();
    }

    @Override // okhttp3.C11949p
    /* renamed from: g */
    public void mo71831g(C11916d0.a aVar) {
        synchronized (this) {
            try {
                b bVarM71872s = m71872s(aVar.m71543s());
                if (bVarM71872s != null) {
                    bVarM71872s.f55660d--;
                    bVarM71872s.f55661e--;
                    if (aVar.m71540p()) {
                        C11958y c11958yM71573m = aVar.m71543s().m71573m();
                        bVarM71872s.f55662f = aVar.m71538n().m71489t(c11958yM71573m.m71904l(), c11958yM71573m.m71909w(), c11958yM71573m.m71896B());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        aVar.m71537m().decrementAndGet();
        m71867f(this.f55641f, aVar);
    }

    @Override // okhttp3.C11949p
    /* renamed from: h */
    public void mo71832h(C11916d0 c11916d0) {
        m71867f(this.f55642g, c11916d0);
    }

    /* renamed from: i */
    public final boolean m71868i() {
        boolean z10;
        int i10;
        int iM71874u;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C11916d0.a> it = this.f55640e.iterator();
                while (true) {
                    z10 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    C11916d0.a next = it.next();
                    if (this.f55641f.size() >= this.f55636a) {
                        break;
                    }
                    b bVarM71872s = m71872s(next.m71543s());
                    if (bVarM71872s != null) {
                        i10 = this.f55653j;
                        iM71874u = m71875v(next);
                    } else {
                        i10 = this.f55651h;
                        iM71874u = m71874u(next);
                    }
                    if (iM71874u < i10) {
                        it.remove();
                        next.m71537m().incrementAndGet();
                        arrayList.add(next);
                        this.f55641f.add(next);
                        if (bVarM71872s != null) {
                            bVarM71872s.f55661e++;
                        }
                    }
                }
                if (m71837n() <= 0) {
                    z10 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((C11916d0.a) it2.next()).m71539o(m71829d());
        }
        return z10;
    }

    @Override // okhttp3.C11949p
    /* renamed from: l */
    public void mo71835l(String str, int i10, String str2) {
        synchronized (this) {
            try {
                Iterator<b> it = this.f55654k.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f55657a.equals(str) && next.f55658b == i10 && next.f55659c.equals(str2)) {
                        it.remove();
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public final void m71869p(C11916d0.a aVar) {
        this.f55640e.add(aVar);
    }

    /* renamed from: q */
    public final boolean m71870q(C11916d0.a aVar, b bVar) {
        if (bVar.f55660d == 0) {
            C11958y c11958yM71573m = aVar.m71543s().m71573m();
            if (!aVar.m71538n().m71492w(c11958yM71573m.m71904l(), c11958yM71573m.m71909w(), c11958yM71573m.m71896B())) {
                mo71835l(c11958yM71573m.m71904l(), c11958yM71573m.m71909w(), c11958yM71573m.m71896B());
                m71869p(aVar);
                return false;
            }
        }
        bVar.f55660d++;
        this.f55640e.add(aVar);
        return true;
    }

    /* renamed from: r */
    public final b m71871r(String str, int i10, String str2) {
        for (b bVar : this.f55654k) {
            if (bVar.f55657a.equals(str) && bVar.f55658b == i10 && bVar.f55659c.equals(str2)) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: s */
    public final b m71872s(HttpRequestBuilder HttpRequestBuilder) {
        return m71871r(HttpRequestBuilder.m71573m().m71904l(), HttpRequestBuilder.m71573m().m71909w(), HttpRequestBuilder.m71573m().m71896B());
    }

    /* renamed from: t */
    public final void m71873t(C11916d0.a aVar, b bVar) {
        int i10;
        boolean z10;
        synchronized (this) {
            try {
                if (bVar.f55660d == this.f55653j + 1) {
                    C11958y c11958yM71573m = aVar.m71543s().m71573m();
                    bVar.f55662f = aVar.m71538n().m71489t(c11958yM71573m.m71904l(), c11958yM71573m.m71909w(), c11958yM71573m.m71896B());
                }
                i10 = bVar.f55662f;
                if (this.f55653j * i10 * this.f55655l >= bVar.f55660d || i10 >= this.f55652i) {
                    z10 = false;
                } else {
                    bVar.f55662f = i10 + 1;
                    bVar.f55661e++;
                    z10 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            InterfaceC11919f interfaceC11919fM71495z = aVar.m71538n().m71495z(aVar.m71543s().m71570j().m71578e("Http2ConnectionIndex", Integer.toString(i10 + 1)).m71575b());
            if (interfaceC11919fM71495z instanceof C11916d0) {
                C11916d0 c11916d0 = (C11916d0) interfaceC11919fM71495z;
                a aVar2 = new a();
                Objects.requireNonNull(c11916d0);
                C11916d0.a aVar3 = c11916d0.new a(aVar2);
                aVar3.m71545u();
                synchronized (this) {
                    this.f55641f.add(aVar3);
                }
                aVar3.m71539o(m71829d());
            }
        }
    }

    /* renamed from: u */
    public final int m71874u(C11916d0.a aVar) {
        return aVar.m71537m().get() - m71875v(aVar);
    }

    /* renamed from: v */
    public final int m71875v(C11916d0.a aVar) {
        int i10 = 0;
        for (b bVar : this.f55654k) {
            if (bVar.f55657a.equals(aVar.m71542r())) {
                i10 += bVar.f55661e;
            }
        }
        return i10;
    }
}
