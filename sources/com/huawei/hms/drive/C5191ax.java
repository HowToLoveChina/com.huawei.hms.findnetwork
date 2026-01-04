package com.huawei.hms.drive;

import com.huawei.hms.drive.C5200be;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.drive.ax */
/* loaded from: classes8.dex */
public final class C5191ax extends C5186as {

    /* renamed from: h */
    static final /* synthetic */ boolean f23782h = true;

    /* renamed from: i */
    private int f23783i = 5;

    /* renamed from: j */
    private int f23784j = 2;

    /* renamed from: k */
    private int f23785k = 32;

    /* renamed from: l */
    private final List<a> f23786l = new ArrayList();

    /* renamed from: m */
    private int f23787m = 2;

    /* renamed from: com.huawei.hms.drive.ax$a */
    public final class a {

        /* renamed from: g */
        static final /* synthetic */ boolean f23788g = true;

        /* renamed from: a */
        public String f23789a;

        /* renamed from: b */
        public int f23790b;

        /* renamed from: c */
        public String f23791c;

        /* renamed from: d */
        public int f23792d;

        /* renamed from: e */
        public int f23793e;

        /* renamed from: f */
        public int f23794f = 1;

        public a(String str, int i10, String str2) {
            this.f23789a = str;
            this.f23790b = i10;
            this.f23791c = str2;
            m30943a(str, i10, str2);
        }

        /* renamed from: a */
        private void m30943a(String str, int i10, String str2) {
            if (!f23788g && !Thread.holdsLock(C5191ax.this)) {
                throw new AssertionError();
            }
            Iterator<C5200be.a> it = C5191ax.this.f23771e.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                C5193az c5193azM31107a = it.next().m31103c().m31107a();
                if (c5193azM31107a.m30970f().equals(str) && c5193azM31107a.m30971g() == i10 && c5193azM31107a.m30964b().equals(str2)) {
                    i11++;
                }
            }
            this.f23793e = i11;
            Iterator<C5200be.a> it2 = C5191ax.this.f23770d.iterator();
            while (it2.hasNext()) {
                C5193az c5193azM31107a2 = it2.next().m31103c().m31107a();
                if (c5193azM31107a2.m30970f().equals(str) && c5193azM31107a2.m30971g() == i10 && c5193azM31107a2.m30964b().equals(str2)) {
                    i11++;
                }
            }
            this.f23792d = i11;
        }
    }

    @Override // com.huawei.hms.drive.C5186as, com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: a */
    public void mo30802a(String str, int i10, String str2) {
        synchronized (this) {
            try {
                if (m30938c(str, i10, str2) != null) {
                    return;
                }
                this.f23786l.add(new a(str, i10, str2));
                m30939c();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m30940b(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f23783i = i10;
            }
            m30939c();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    /* renamed from: c */
    public void m30941c(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f23785k = i10;
            }
            m30939c();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    /* renamed from: d */
    public void m30942d(int i10) {
        if (i10 >= 1) {
            this.f23784j = i10;
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i10);
    }

    /* renamed from: c */
    private boolean m30939c() {
        boolean z10;
        int i10;
        int iM30937c;
        if (!f23782h && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C5200be.a> it = this.f23770d.iterator();
                while (true) {
                    z10 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    C5200be.a next = it.next();
                    if (this.f23771e.size() >= this.f23767a) {
                        break;
                    }
                    a aVarM30934a = m30934a(next.m31103c());
                    if (aVarM30934a != null) {
                        i10 = this.f23785k;
                        iM30937c = m30936b(next);
                    } else {
                        i10 = this.f23783i;
                        iM30937c = m30937c(next);
                    }
                    if (iM30937c < i10) {
                        it.remove();
                        next.m31100a().incrementAndGet();
                        arrayList.add(next);
                        this.f23771e.add(next);
                        if (aVarM30934a != null) {
                            aVarM30934a.f23793e++;
                        }
                    }
                }
                if (m30885b() <= 0) {
                    z10 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((C5200be.a) it2.next()).m31101a(m30883a());
        }
        return z10;
    }

    @Override // com.huawei.hms.drive.C5186as, com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: b */
    public void mo30804b(String str, int i10, String str2) {
        synchronized (this) {
            try {
                Iterator<a> it = this.f23786l.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f23789a.equals(str) && next.f23790b == i10 && next.f23791c.equals(str2)) {
                        it.remove();
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.drive.C5186as, com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: a */
    public void mo30800a(C5200be.a aVar) {
        synchronized (this) {
            try {
                a aVarM30934a = m30934a(aVar.m31103c());
                if (aVarM30934a != null) {
                    aVarM30934a.f23792d--;
                    aVarM30934a.f23793e--;
                    if (aVar.m31105e()) {
                        C5193az c5193azM31107a = aVar.m31103c().m31107a();
                        aVarM30934a.f23794f = aVar.m31104d().m31047b(c5193azM31107a.m30970f(), c5193azM31107a.m30971g(), c5193azM31107a.m30964b());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        aVar.m31100a().decrementAndGet();
        m30935a(this.f23771e, aVar);
    }

    @Override // com.huawei.hms.drive.C5186as, com.huawei.hms.drive.AbstractC5172ae
    /* renamed from: b */
    public void mo30803b(C5200be c5200be) {
        m30935a(this.f23772f, c5200be);
    }

    /* renamed from: b */
    private int m30936b(C5200be.a aVar) {
        int i10 = 0;
        for (a aVar2 : this.f23786l) {
            if (aVar2.f23789a.equals(aVar.m31102b())) {
                i10 += aVar2.f23793e;
            }
        }
        return i10;
    }

    /* renamed from: a */
    private <T> void m30935a(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t10)) {
                runnable = this.f23768b;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (m30939c() || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: c */
    private int m30937c(C5200be.a aVar) {
        return aVar.m31100a().get() - m30936b(aVar);
    }

    /* renamed from: c */
    private a m30938c(String str, int i10, String str2) {
        for (a aVar : this.f23786l) {
            if (aVar.f23789a.equals(str) && aVar.f23790b == i10 && aVar.f23791c.equals(str2)) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    private a m30934a(C5201bf c5201bf) {
        return m30938c(c5201bf.m31107a().m30970f(), c5201bf.m31107a().m30971g(), c5201bf.m31107a().m30964b());
    }
}
