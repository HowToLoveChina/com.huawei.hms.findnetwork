package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0874m;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import java.util.ArrayList;
import java.util.List;
import p243e0.C9371f;
import p243e0.InterfaceC9370e;

/* renamed from: androidx.recyclerview.widget.a */
/* loaded from: classes.dex */
public final class C0862a implements C0874m.a {

    /* renamed from: a */
    public InterfaceC9370e<b> f4463a;

    /* renamed from: b */
    public final ArrayList<b> f4464b;

    /* renamed from: c */
    public final ArrayList<b> f4465c;

    /* renamed from: d */
    public final a f4466d;

    /* renamed from: e */
    public Runnable f4467e;

    /* renamed from: f */
    public final boolean f4468f;

    /* renamed from: g */
    public final C0874m f4469g;

    /* renamed from: h */
    public int f4470h;

    /* renamed from: androidx.recyclerview.widget.a$a */
    public interface a {
        /* renamed from: a */
        void mo5195a(int i10, int i11);

        /* renamed from: b */
        void mo5196b(b bVar);

        /* renamed from: c */
        void mo5197c(int i10, int i11, Object obj);

        /* renamed from: d */
        void mo5198d(b bVar);

        /* renamed from: e */
        RecyclerView.AbstractC0833c0 mo5199e(int i10);

        /* renamed from: f */
        void mo5200f(int i10, int i11);

        /* renamed from: g */
        void mo5201g(int i10, int i11);

        /* renamed from: h */
        void mo5202h(int i10, int i11);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    public static final class b {

        /* renamed from: a */
        public int f4471a;

        /* renamed from: b */
        public int f4472b;

        /* renamed from: c */
        public Object f4473c;

        /* renamed from: d */
        public int f4474d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f4471a = i10;
            this.f4472b = i11;
            this.f4474d = i12;
            this.f4473c = obj;
        }

        /* renamed from: a */
        public String m5433a() {
            int i10 = this.f4471a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : SyncProtocol.Constant.ADD;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f4471a;
            if (i10 != bVar.f4471a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f4474d - this.f4472b) == 1 && this.f4474d == bVar.f4472b && this.f4472b == bVar.f4474d) {
                return true;
            }
            if (this.f4474d != bVar.f4474d || this.f4472b != bVar.f4472b) {
                return false;
            }
            Object obj2 = this.f4473c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f4473c)) {
                    return false;
                }
            } else if (bVar.f4473c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f4471a * 31) + this.f4472b) * 31) + this.f4474d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m5433a() + ",s:" + this.f4472b + "c:" + this.f4474d + ",p:" + this.f4473c + "]";
        }
    }

    public C0862a(a aVar) {
        this(aVar, false);
    }

    @Override // androidx.recyclerview.widget.C0874m.a
    /* renamed from: a */
    public void mo5407a(b bVar) {
        if (this.f4468f) {
            return;
        }
        bVar.f4473c = null;
        this.f4463a.mo58737a(bVar);
    }

    @Override // androidx.recyclerview.widget.C0874m.a
    /* renamed from: b */
    public b mo5408b(int i10, int i11, int i12, Object obj) {
        b bVarMo58738b = this.f4463a.mo58738b();
        if (bVarMo58738b == null) {
            return new b(i10, i11, i12, obj);
        }
        bVarMo58738b.f4471a = i10;
        bVarMo58738b.f4472b = i11;
        bVarMo58738b.f4474d = i12;
        bVarMo58738b.f4473c = obj;
        return bVarMo58738b;
    }

    /* renamed from: c */
    public final void m5409c(b bVar) {
        m5428v(bVar);
    }

    /* renamed from: d */
    public final void m5410d(b bVar) {
        m5428v(bVar);
    }

    /* renamed from: e */
    public int m5411e(int i10) {
        int size = this.f4464b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f4464b.get(i11);
            int i12 = bVar.f4471a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f4472b;
                    if (i13 <= i10) {
                        int i14 = bVar.f4474d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f4472b;
                    if (i15 == i10) {
                        i10 = bVar.f4474d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f4474d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f4472b <= i10) {
                i10 += bVar.f4474d;
            }
        }
        return i10;
    }

    /* renamed from: f */
    public final void m5412f(b bVar) {
        boolean z10;
        char c10;
        int i10 = bVar.f4472b;
        int i11 = bVar.f4474d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f4466d.mo5199e(i12) != null || m5414h(i12)) {
                if (c11 == 0) {
                    m5417k(mo5408b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    m5428v(mo5408b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f4474d) {
            mo5407a(bVar);
            bVar = mo5408b(2, i10, i13, null);
        }
        if (c11 == 0) {
            m5417k(bVar);
        } else {
            m5428v(bVar);
        }
    }

    /* renamed from: g */
    public final void m5413g(b bVar) {
        int i10 = bVar.f4472b;
        int i11 = bVar.f4474d + i10;
        int i12 = 0;
        boolean z10 = -1;
        int i13 = i10;
        while (i10 < i11) {
            if (this.f4466d.mo5199e(i10) != null || m5414h(i10)) {
                if (!z10) {
                    m5417k(mo5408b(4, i13, i12, bVar.f4473c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = true;
            } else {
                if (z10) {
                    m5428v(mo5408b(4, i13, i12, bVar.f4473c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = false;
            }
            i12++;
            i10++;
        }
        if (i12 != bVar.f4474d) {
            Object obj = bVar.f4473c;
            mo5407a(bVar);
            bVar = mo5408b(4, i13, i12, obj);
        }
        if (z10) {
            m5428v(bVar);
        } else {
            m5417k(bVar);
        }
    }

    /* renamed from: h */
    public final boolean m5414h(int i10) {
        int size = this.f4465c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f4465c.get(i11);
            int i12 = bVar.f4471a;
            if (i12 == 8) {
                if (m5420n(bVar.f4474d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f4472b;
                int i14 = bVar.f4474d + i13;
                while (i13 < i14) {
                    if (m5420n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: i */
    public void m5415i() {
        int size = this.f4465c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4466d.mo5198d(this.f4465c.get(i10));
        }
        m5430x(this.f4465c);
        this.f4470h = 0;
    }

    /* renamed from: j */
    public void m5416j() {
        m5415i();
        int size = this.f4464b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f4464b.get(i10);
            int i11 = bVar.f4471a;
            if (i11 == 1) {
                this.f4466d.mo5198d(bVar);
                this.f4466d.mo5201g(bVar.f4472b, bVar.f4474d);
            } else if (i11 == 2) {
                this.f4466d.mo5198d(bVar);
                this.f4466d.mo5202h(bVar.f4472b, bVar.f4474d);
            } else if (i11 == 4) {
                this.f4466d.mo5198d(bVar);
                this.f4466d.mo5197c(bVar.f4472b, bVar.f4474d, bVar.f4473c);
            } else if (i11 == 8) {
                this.f4466d.mo5198d(bVar);
                this.f4466d.mo5195a(bVar.f4472b, bVar.f4474d);
            }
            Runnable runnable = this.f4467e;
            if (runnable != null) {
                runnable.run();
            }
        }
        m5430x(this.f4464b);
        this.f4470h = 0;
    }

    /* renamed from: k */
    public final void m5417k(b bVar) {
        int i10;
        int i11 = bVar.f4471a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM5432z = m5432z(bVar.f4472b, i11);
        int i12 = bVar.f4472b;
        int i13 = bVar.f4471a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f4474d; i15++) {
            int iM5432z2 = m5432z(bVar.f4472b + (i10 * i15), bVar.f4471a);
            int i16 = bVar.f4471a;
            if (i16 == 2 ? iM5432z2 != iM5432z : !(i16 == 4 && iM5432z2 == iM5432z + 1)) {
                b bVarMo5408b = mo5408b(i16, iM5432z, i14, bVar.f4473c);
                m5418l(bVarMo5408b, i12);
                mo5407a(bVarMo5408b);
                if (bVar.f4471a == 4) {
                    i12 += i14;
                }
                i14 = 1;
                iM5432z = iM5432z2;
            } else {
                i14++;
            }
        }
        Object obj = bVar.f4473c;
        mo5407a(bVar);
        if (i14 > 0) {
            b bVarMo5408b2 = mo5408b(bVar.f4471a, iM5432z, i14, obj);
            m5418l(bVarMo5408b2, i12);
            mo5407a(bVarMo5408b2);
        }
    }

    /* renamed from: l */
    public void m5418l(b bVar, int i10) {
        this.f4466d.mo5196b(bVar);
        int i11 = bVar.f4471a;
        if (i11 == 2) {
            this.f4466d.mo5202h(i10, bVar.f4474d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f4466d.mo5197c(i10, bVar.f4474d, bVar.f4473c);
        }
    }

    /* renamed from: m */
    public int m5419m(int i10) {
        return m5420n(i10, 0);
    }

    /* renamed from: n */
    public int m5420n(int i10, int i11) {
        int size = this.f4465c.size();
        while (i11 < size) {
            b bVar = this.f4465c.get(i11);
            int i12 = bVar.f4471a;
            if (i12 == 8) {
                int i13 = bVar.f4472b;
                if (i13 == i10) {
                    i10 = bVar.f4474d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f4474d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f4472b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f4474d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f4474d;
                }
            }
            i11++;
        }
        return i10;
    }

    /* renamed from: o */
    public boolean m5421o(int i10) {
        return (this.f4470h & i10) != 0;
    }

    /* renamed from: p */
    public boolean m5422p() {
        return this.f4464b.size() > 0;
    }

    /* renamed from: q */
    public boolean m5423q() {
        return (this.f4465c.isEmpty() || this.f4464b.isEmpty()) ? false : true;
    }

    /* renamed from: r */
    public boolean m5424r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f4464b.add(mo5408b(4, i10, i11, obj));
        this.f4470h |= 4;
        return this.f4464b.size() == 1;
    }

    /* renamed from: s */
    public boolean m5425s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f4464b.add(mo5408b(1, i10, i11, null));
        this.f4470h |= 1;
        return this.f4464b.size() == 1;
    }

    /* renamed from: t */
    public boolean m5426t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f4464b.add(mo5408b(8, i10, i11, null));
        this.f4470h |= 8;
        return this.f4464b.size() == 1;
    }

    /* renamed from: u */
    public boolean m5427u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f4464b.add(mo5408b(2, i10, i11, null));
        this.f4470h |= 2;
        return this.f4464b.size() == 1;
    }

    /* renamed from: v */
    public final void m5428v(b bVar) {
        this.f4465c.add(bVar);
        int i10 = bVar.f4471a;
        if (i10 == 1) {
            this.f4466d.mo5201g(bVar.f4472b, bVar.f4474d);
            return;
        }
        if (i10 == 2) {
            this.f4466d.mo5200f(bVar.f4472b, bVar.f4474d);
            return;
        }
        if (i10 == 4) {
            this.f4466d.mo5197c(bVar.f4472b, bVar.f4474d, bVar.f4473c);
        } else {
            if (i10 == 8) {
                this.f4466d.mo5195a(bVar.f4472b, bVar.f4474d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* renamed from: w */
    public void m5429w() {
        this.f4469g.m5543b(this.f4464b);
        int size = this.f4464b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f4464b.get(i10);
            int i11 = bVar.f4471a;
            if (i11 == 1) {
                m5409c(bVar);
            } else if (i11 == 2) {
                m5412f(bVar);
            } else if (i11 == 4) {
                m5413g(bVar);
            } else if (i11 == 8) {
                m5410d(bVar);
            }
            Runnable runnable = this.f4467e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f4464b.clear();
    }

    /* renamed from: x */
    public void m5430x(List<b> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            mo5407a(list.get(i10));
        }
        list.clear();
    }

    /* renamed from: y */
    public void m5431y() {
        m5430x(this.f4464b);
        m5430x(this.f4465c);
        this.f4470h = 0;
    }

    /* renamed from: z */
    public final int m5432z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f4465c.size() - 1; size >= 0; size--) {
            b bVar = this.f4465c.get(size);
            int i14 = bVar.f4471a;
            if (i14 == 8) {
                int i15 = bVar.f4472b;
                int i16 = bVar.f4474d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f4472b = i15 + 1;
                            bVar.f4474d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f4472b = i15 - 1;
                            bVar.f4474d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f4474d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f4474d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f4472b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f4472b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f4472b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f4474d;
                    } else if (i14 == 2) {
                        i10 += bVar.f4474d;
                    }
                } else if (i11 == 1) {
                    bVar.f4472b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f4472b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f4465c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f4465c.get(size2);
            if (bVar2.f4471a == 8) {
                int i18 = bVar2.f4474d;
                if (i18 == bVar2.f4472b || i18 < 0) {
                    this.f4465c.remove(size2);
                    mo5407a(bVar2);
                }
            } else if (bVar2.f4474d <= 0) {
                this.f4465c.remove(size2);
                mo5407a(bVar2);
            }
        }
        return i10;
    }

    public C0862a(a aVar, boolean z10) {
        this.f4463a = new C9371f(30);
        this.f4464b = new ArrayList<>();
        this.f4465c = new ArrayList<>();
        this.f4470h = 0;
        this.f4466d = aVar;
        this.f4468f = z10;
        this.f4469g = new C0874m(this);
    }
}
