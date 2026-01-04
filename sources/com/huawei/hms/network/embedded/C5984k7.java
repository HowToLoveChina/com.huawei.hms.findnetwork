package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6088s7;
import com.huawei.hms.network.embedded.C6088s7.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* renamed from: com.huawei.hms.network.embedded.k7 */
/* loaded from: classes8.dex */
public final class C5984k7 extends C5906e7 {

    /* renamed from: o */
    public static final int f27280o = 5;

    /* renamed from: p */
    public static final int f27281p = 2;

    /* renamed from: q */
    public static final int f27282q = 32;

    /* renamed from: r */
    public static final /* synthetic */ boolean f27283r = true;

    /* renamed from: j */
    public int f27284j = 5;

    /* renamed from: k */
    public int f27285k = 2;

    /* renamed from: l */
    public int f27286l = 32;

    /* renamed from: m */
    public final List<b> f27287m = new ArrayList();

    /* renamed from: n */
    public int f27288n = 2;

    /* renamed from: com.huawei.hms.network.embedded.k7$a */
    public class a implements InterfaceC6113u6 {
        public a() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6113u6
        public void onFailure(InterfaceC6100t6 interfaceC6100t6, IOException iOException) {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6113u6
        public void onResponse(InterfaceC6100t6 interfaceC6100t6, C6127v7 c6127v7) throws IOException {
            if (c6127v7 != null) {
                c6127v7.close();
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.k7$b */
    public final class b {

        /* renamed from: h */
        public static final /* synthetic */ boolean f27290h = true;

        /* renamed from: a */
        public String f27291a;

        /* renamed from: b */
        public int f27292b;

        /* renamed from: c */
        public String f27293c;

        /* renamed from: d */
        public int f27294d;

        /* renamed from: e */
        public int f27295e;

        /* renamed from: f */
        public int f27296f = 1;

        public b(String str, int i10, String str2) {
            this.f27291a = str;
            this.f27292b = i10;
            this.f27293c = str2;
            m34611a(str, i10, str2);
        }

        /* renamed from: a */
        private void m34611a(String str, int i10, String str2) {
            if (!f27290h && !Thread.holdsLock(C5984k7.this)) {
                throw new AssertionError();
            }
            Iterator<C6088s7.a> it = C5984k7.this.f26699f.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                C6010m7 c6010m7M35423k = it.next().m35291h().m35423k();
                if (c6010m7M35423k.m34797h().equals(str) && c6010m7M35423k.m34803n() == i10 && c6010m7M35423k.m34808s().equals(str2)) {
                    i11++;
                }
            }
            this.f27295e = i11;
            Iterator<C6088s7.a> it2 = C5984k7.this.f26698e.iterator();
            while (it2.hasNext()) {
                C6010m7 c6010m7M35423k2 = it2.next().m35291h().m35423k();
                if (c6010m7M35423k2.m34797h().equals(str) && c6010m7M35423k2.m34803n() == i10 && c6010m7M35423k2.m34808s().equals(str2)) {
                    i11++;
                }
            }
            this.f27294d = i11;
        }
    }

    public C5984k7() {
    }

    /* renamed from: a */
    private b m34597a(C6101t7 c6101t7) {
        return m34601c(c6101t7.m35423k().m34797h(), c6101t7.m35423k().m34803n(), c6101t7.m35423k().m34808s());
    }

    /* renamed from: c */
    private b m34601c(String str, int i10, String str2) {
        for (b bVar : this.f27287m) {
            if (bVar.f27291a.equals(str) && bVar.f27292b == i10 && bVar.f27293c.equals(str2)) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: d */
    private int m34603d(C6088s7.a aVar) {
        return aVar.m35286c().get() - m34604e(aVar);
    }

    /* renamed from: e */
    private int m34604e(C6088s7.a aVar) {
        int i10 = 0;
        for (b bVar : this.f27287m) {
            if (bVar.f27291a.equals(aVar.m35290g())) {
                i10 += bVar.f27295e;
            }
        }
        return i10;
    }

    /* renamed from: l */
    private boolean m34605l() {
        boolean z10;
        int i10;
        int iM34603d;
        if (!f27283r && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C6088s7.a> it = this.f26698e.iterator();
                while (true) {
                    z10 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    C6088s7.a next = it.next();
                    if (this.f26699f.size() >= this.f26694a) {
                        break;
                    }
                    b bVarM34597a = m34597a(next.m35291h());
                    if (bVarM34597a != null) {
                        i10 = this.f27286l;
                        iM34603d = m34604e(next);
                    } else {
                        i10 = this.f27284j;
                        iM34603d = m34603d(next);
                    }
                    if (iM34603d < i10) {
                        it.remove();
                        next.m35286c().incrementAndGet();
                        arrayList.add(next);
                        this.f26699f.add(next);
                        if (bVarM34597a != null) {
                            bVarM34597a.f27295e++;
                        }
                    }
                }
                if (mo33897d() <= 0) {
                    z10 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((C6088s7.a) it2.next()).m35285a(m34131i());
        }
        return z10;
    }

    @Override // com.huawei.hms.network.embedded.C5906e7, com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: b */
    public void mo34127b(C6088s7.a aVar) {
        synchronized (this) {
            try {
                b bVarM34597a = m34597a(aVar.m35291h());
                if (bVarM34597a != null) {
                    bVarM34597a.f27294d--;
                    bVarM34597a.f27295e--;
                    if (aVar.m35288e()) {
                        C6010m7 c6010m7M35423k = aVar.m35291h().m35423k();
                        bVarM34597a.f27296f = aVar.m35287d().m35076b(c6010m7M35423k.m34797h(), c6010m7M35423k.m34803n(), c6010m7M35423k.m34808s());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        aVar.m35286c().decrementAndGet();
        m34598a((Deque<Deque<C6088s7.a>>) this.f26699f, (Deque<C6088s7.a>) aVar);
    }

    @Override // com.huawei.hms.network.embedded.C5906e7, com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: h */
    public int mo34130h() {
        return this.f27285k;
    }

    /* renamed from: j */
    public int m34609j() {
        int i10;
        synchronized (this) {
            i10 = this.f27284j;
        }
        return i10;
    }

    /* renamed from: k */
    public int m34610k() {
        int i10;
        synchronized (this) {
            i10 = this.f27286l;
        }
        return i10;
    }

    public C5984k7(ExecutorService executorService) {
        this.f26697d = executorService;
    }

    /* renamed from: b */
    private void m34600b(C6088s7.a aVar, b bVar) {
        int i10;
        boolean z10;
        synchronized (this) {
            try {
                if (bVar.f27294d == this.f27286l + 1) {
                    C6010m7 c6010m7M35423k = aVar.m35291h().m35423k();
                    bVar.f27296f = aVar.m35287d().m35076b(c6010m7M35423k.m34797h(), c6010m7M35423k.m34803n(), c6010m7M35423k.m34808s());
                }
                i10 = bVar.f27296f;
                if (this.f27286l * i10 * this.f27288n >= bVar.f27294d || i10 >= this.f27285k) {
                    z10 = false;
                } else {
                    bVar.f27296f = i10 + 1;
                    bVar.f27295e++;
                    z10 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            InterfaceC6100t6 interfaceC6100t6Mo35073a = aVar.m35287d().mo35073a(aVar.m35291h().m35421i().m35440b("Http2ConnectionIndex", Integer.toString(i10 + 1)).m35436a());
            if (interfaceC6100t6Mo35073a instanceof C6088s7) {
                C6088s7 c6088s7 = (C6088s7) interfaceC6100t6Mo35073a;
                a aVar2 = new a();
                Objects.requireNonNull(c6088s7);
                C6088s7.a aVar3 = c6088s7.new a(aVar2);
                aVar3.m35292i();
                synchronized (this) {
                    this.f26699f.add(aVar3);
                }
                aVar3.m35285a(m34131i());
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.C5906e7, com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: a */
    public void mo34124a(C6088s7.a aVar) {
        boolean zM34599a;
        C6088s7.a aVarM34123a;
        synchronized (this) {
            try {
                if (aVar == null) {
                    return;
                }
                b bVarM34597a = m34597a(aVar.m35291h());
                if (bVarM34597a != null) {
                    zM34599a = m34599a(aVar, bVarM34597a);
                } else {
                    m34602c(aVar);
                    zM34599a = false;
                }
                if (!aVar.m35289f().f28208d && (aVarM34123a = m34123a(aVar.m35290g())) != null) {
                    aVar.m35284a(aVarM34123a);
                }
                m34605l();
                if (zM34599a) {
                    m34600b(aVar, bVarM34597a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public void m34606c(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f27284j = i10;
            }
            m34605l();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    /* renamed from: d */
    public void m34607d(int i10) {
        if (i10 >= 1) {
            this.f27285k = i10;
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i10);
    }

    /* renamed from: e */
    public void m34608e(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f27286l = i10;
            }
            m34605l();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    /* renamed from: c */
    private void m34602c(C6088s7.a aVar) {
        this.f26698e.add(aVar);
    }

    @Override // com.huawei.hms.network.embedded.C5906e7, com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: a */
    public void mo34126a(String str, int i10, String str2) {
        synchronized (this) {
            try {
                if (m34601c(str, i10, str2) != null) {
                    return;
                }
                this.f27287m.add(new b(str, i10, str2));
                m34605l();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.C5906e7, com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: b */
    public void mo34128b(C6088s7 c6088s7) {
        m34598a((Deque<Deque<C6088s7>>) this.f26700g, (Deque<C6088s7>) c6088s7);
    }

    /* renamed from: a */
    private <T> void m34598a(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t10)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f26696c;
        }
        if (m34605l() || runnable == null) {
            return;
        }
        runnable.run();
    }

    @Override // com.huawei.hms.network.embedded.C5906e7, com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: b */
    public void mo34129b(String str, int i10, String str2) {
        synchronized (this) {
            try {
                Iterator<b> it = this.f27287m.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f27291a.equals(str) && next.f27292b == i10 && next.f27293c.equals(str2)) {
                        it.remove();
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private boolean m34599a(C6088s7.a aVar, b bVar) {
        if (bVar.f27294d == 0) {
            C6010m7 c6010m7M35423k = aVar.m35291h().m35423k();
            if (!aVar.m35287d().m35079c(c6010m7M35423k.m34797h(), c6010m7M35423k.m34803n(), c6010m7M35423k.m34808s())) {
                mo34129b(c6010m7M35423k.m34797h(), c6010m7M35423k.m34803n(), c6010m7M35423k.m34808s());
                m34602c(aVar);
                return false;
            }
        }
        bVar.f27294d++;
        this.f26698e.add(aVar);
        return true;
    }
}
