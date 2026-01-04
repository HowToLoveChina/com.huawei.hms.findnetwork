package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.f */
/* loaded from: classes.dex */
public class C0867f {

    /* renamed from: a */
    public static final Comparator<d> f4537a = new a();

    /* renamed from: androidx.recyclerview.widget.f$a */
    public class a implements Comparator<d> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.f4540a - dVar2.f4540a;
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$b */
    public static abstract class b {
        /* renamed from: a */
        public abstract boolean mo5482a(int i10, int i11);

        /* renamed from: b */
        public abstract boolean mo5483b(int i10, int i11);

        /* renamed from: c */
        public Object m5484c(int i10, int i11) {
            return null;
        }

        /* renamed from: d */
        public abstract int mo5485d();

        /* renamed from: e */
        public abstract int mo5486e();
    }

    /* renamed from: androidx.recyclerview.widget.f$c */
    public static class c {

        /* renamed from: a */
        public final int[] f4538a;

        /* renamed from: b */
        public final int f4539b;

        public c(int i10) {
            int[] iArr = new int[i10];
            this.f4538a = iArr;
            this.f4539b = iArr.length / 2;
        }

        /* renamed from: a */
        public int[] m5487a() {
            return this.f4538a;
        }

        /* renamed from: b */
        public int m5488b(int i10) {
            return this.f4538a[i10 + this.f4539b];
        }

        /* renamed from: c */
        public void m5489c(int i10, int i11) {
            this.f4538a[i10 + this.f4539b] = i11;
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$d */
    public static class d {

        /* renamed from: a */
        public final int f4540a;

        /* renamed from: b */
        public final int f4541b;

        /* renamed from: c */
        public final int f4542c;

        public d(int i10, int i11, int i12) {
            this.f4540a = i10;
            this.f4541b = i11;
            this.f4542c = i12;
        }

        /* renamed from: a */
        public int m5490a() {
            return this.f4540a + this.f4542c;
        }

        /* renamed from: b */
        public int m5491b() {
            return this.f4541b + this.f4542c;
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$e */
    public static class e {

        /* renamed from: a */
        public final List<d> f4543a;

        /* renamed from: b */
        public final int[] f4544b;

        /* renamed from: c */
        public final int[] f4545c;

        /* renamed from: d */
        public final b f4546d;

        /* renamed from: e */
        public final int f4547e;

        /* renamed from: f */
        public final int f4548f;

        /* renamed from: g */
        public final boolean f4549g;

        public e(b bVar, List<d> list, int[] iArr, int[] iArr2, boolean z10) {
            this.f4543a = list;
            this.f4544b = iArr;
            this.f4545c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f4546d = bVar;
            this.f4547e = bVar.mo5486e();
            this.f4548f = bVar.mo5485d();
            this.f4549g = z10;
            m5493a();
            m5497e();
        }

        /* renamed from: g */
        public static f m5492g(Collection<f> collection, int i10, boolean z10) {
            f next;
            Iterator<f> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.f4550a == i10 && next.f4552c == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                f next2 = it.next();
                if (z10) {
                    next2.f4551b--;
                } else {
                    next2.f4551b++;
                }
            }
            return next;
        }

        /* renamed from: a */
        public final void m5493a() {
            d dVar = this.f4543a.isEmpty() ? null : this.f4543a.get(0);
            if (dVar == null || dVar.f4540a != 0 || dVar.f4541b != 0) {
                this.f4543a.add(0, new d(0, 0, 0));
            }
            this.f4543a.add(new d(this.f4547e, this.f4548f, 0));
        }

        /* renamed from: b */
        public void m5494b(InterfaceC0873l interfaceC0873l) {
            int i10;
            C0864c c0864c = interfaceC0873l instanceof C0864c ? (C0864c) interfaceC0873l : new C0864c(interfaceC0873l);
            int i11 = this.f4547e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.f4547e;
            int i13 = this.f4548f;
            for (int size = this.f4543a.size() - 1; size >= 0; size--) {
                d dVar = this.f4543a.get(size);
                int iM5490a = dVar.m5490a();
                int iM5491b = dVar.m5491b();
                while (true) {
                    if (i12 <= iM5490a) {
                        break;
                    }
                    i12--;
                    int i14 = this.f4544b[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        f fVarM5492g = m5492g(arrayDeque, i15, false);
                        if (fVarM5492g != null) {
                            int i16 = (i11 - fVarM5492g.f4551b) - 1;
                            c0864c.mo5434a(i12, i16);
                            if ((i14 & 4) != 0) {
                                c0864c.mo5437d(i16, 1, this.f4546d.m5484c(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new f(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        c0864c.mo5436c(i12, 1);
                        i11--;
                    }
                }
                while (i13 > iM5491b) {
                    i13--;
                    int i17 = this.f4545c[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        f fVarM5492g2 = m5492g(arrayDeque, i18, true);
                        if (fVarM5492g2 == null) {
                            arrayDeque.add(new f(i13, i11 - i12, false));
                        } else {
                            c0864c.mo5434a((i11 - fVarM5492g2.f4551b) - 1, i12);
                            if ((i17 & 4) != 0) {
                                c0864c.mo5437d(i12, 1, this.f4546d.m5484c(i18, i13));
                            }
                        }
                    } else {
                        c0864c.mo5435b(i12, 1);
                        i11++;
                    }
                }
                int i19 = dVar.f4540a;
                int i20 = dVar.f4541b;
                for (i10 = 0; i10 < dVar.f4542c; i10++) {
                    if ((this.f4544b[i19] & 15) == 2) {
                        c0864c.mo5437d(i19, 1, this.f4546d.m5484c(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = dVar.f4540a;
                i13 = dVar.f4541b;
            }
            c0864c.m5438e();
        }

        /* renamed from: c */
        public void m5495c(RecyclerView.AbstractC0838h abstractC0838h) {
            m5494b(new C0863b(abstractC0838h));
        }

        /* renamed from: d */
        public final void m5496d(int i10) {
            int size = this.f4543a.size();
            int iM5491b = 0;
            for (int i11 = 0; i11 < size; i11++) {
                d dVar = this.f4543a.get(i11);
                while (iM5491b < dVar.f4541b) {
                    if (this.f4545c[iM5491b] == 0 && this.f4546d.mo5483b(i10, iM5491b)) {
                        int i12 = this.f4546d.mo5482a(i10, iM5491b) ? 8 : 4;
                        this.f4544b[i10] = (iM5491b << 4) | i12;
                        this.f4545c[iM5491b] = (i10 << 4) | i12;
                        return;
                    }
                    iM5491b++;
                }
                iM5491b = dVar.m5491b();
            }
        }

        /* renamed from: e */
        public final void m5497e() {
            for (d dVar : this.f4543a) {
                for (int i10 = 0; i10 < dVar.f4542c; i10++) {
                    int i11 = dVar.f4540a + i10;
                    int i12 = dVar.f4541b + i10;
                    int i13 = this.f4546d.mo5482a(i11, i12) ? 1 : 2;
                    this.f4544b[i11] = (i12 << 4) | i13;
                    this.f4545c[i12] = (i11 << 4) | i13;
                }
            }
            if (this.f4549g) {
                m5498f();
            }
        }

        /* renamed from: f */
        public final void m5498f() {
            int iM5490a = 0;
            for (d dVar : this.f4543a) {
                while (iM5490a < dVar.f4540a) {
                    if (this.f4544b[iM5490a] == 0) {
                        m5496d(iM5490a);
                    }
                    iM5490a++;
                }
                iM5490a = dVar.m5490a();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$f */
    public static class f {

        /* renamed from: a */
        public int f4550a;

        /* renamed from: b */
        public int f4551b;

        /* renamed from: c */
        public boolean f4552c;

        public f(int i10, int i11, boolean z10) {
            this.f4550a = i10;
            this.f4551b = i11;
            this.f4552c = z10;
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$g */
    public static class g {

        /* renamed from: a */
        public int f4553a;

        /* renamed from: b */
        public int f4554b;

        /* renamed from: c */
        public int f4555c;

        /* renamed from: d */
        public int f4556d;

        public g() {
        }

        /* renamed from: a */
        public int m5499a() {
            return this.f4556d - this.f4555c;
        }

        /* renamed from: b */
        public int m5500b() {
            return this.f4554b - this.f4553a;
        }

        public g(int i10, int i11, int i12, int i13) {
            this.f4553a = i10;
            this.f4554b = i11;
            this.f4555c = i12;
            this.f4556d = i13;
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$h */
    public static class h {

        /* renamed from: a */
        public int f4557a;

        /* renamed from: b */
        public int f4558b;

        /* renamed from: c */
        public int f4559c;

        /* renamed from: d */
        public int f4560d;

        /* renamed from: e */
        public boolean f4561e;

        /* renamed from: a */
        public int m5501a() {
            return Math.min(this.f4559c - this.f4557a, this.f4560d - this.f4558b);
        }

        /* renamed from: b */
        public boolean m5502b() {
            return this.f4560d - this.f4558b != this.f4559c - this.f4557a;
        }

        /* renamed from: c */
        public boolean m5503c() {
            return this.f4560d - this.f4558b > this.f4559c - this.f4557a;
        }

        /* renamed from: d */
        public d m5504d() {
            if (m5502b()) {
                return this.f4561e ? new d(this.f4557a, this.f4558b, m5501a()) : m5503c() ? new d(this.f4557a, this.f4558b + 1, m5501a()) : new d(this.f4557a + 1, this.f4558b, m5501a());
            }
            int i10 = this.f4557a;
            return new d(i10, this.f4558b, this.f4559c - i10);
        }
    }

    /* renamed from: a */
    public static h m5477a(g gVar, b bVar, c cVar, c cVar2, int i10) {
        int iM5488b;
        int i11;
        int i12;
        boolean z10 = (gVar.m5500b() - gVar.m5499a()) % 2 == 0;
        int iM5500b = gVar.m5500b() - gVar.m5499a();
        int i13 = -i10;
        for (int i14 = i13; i14 <= i10; i14 += 2) {
            if (i14 == i13 || (i14 != i10 && cVar2.m5488b(i14 + 1) < cVar2.m5488b(i14 - 1))) {
                iM5488b = cVar2.m5488b(i14 + 1);
                i11 = iM5488b;
            } else {
                iM5488b = cVar2.m5488b(i14 - 1);
                i11 = iM5488b - 1;
            }
            int i15 = gVar.f4556d - ((gVar.f4554b - i11) - i14);
            int i16 = (i10 == 0 || i11 != iM5488b) ? i15 : i15 + 1;
            while (i11 > gVar.f4553a && i15 > gVar.f4555c && bVar.mo5483b(i11 - 1, i15 - 1)) {
                i11--;
                i15--;
            }
            cVar2.m5489c(i14, i11);
            if (z10 && (i12 = iM5500b - i14) >= i13 && i12 <= i10 && cVar.m5488b(i12) >= i11) {
                h hVar = new h();
                hVar.f4557a = i11;
                hVar.f4558b = i15;
                hVar.f4559c = iM5488b;
                hVar.f4560d = i16;
                hVar.f4561e = true;
                return hVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static e m5478b(b bVar, boolean z10) {
        int iMo5486e = bVar.mo5486e();
        int iMo5485d = bVar.mo5485d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new g(0, iMo5486e, 0, iMo5485d));
        int i10 = ((((iMo5486e + iMo5485d) + 1) / 2) * 2) + 1;
        c cVar = new c(i10);
        c cVar2 = new c(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            g gVar = (g) arrayList2.remove(arrayList2.size() - 1);
            h hVarM5480d = m5480d(gVar, bVar, cVar, cVar2);
            if (hVarM5480d != null) {
                if (hVarM5480d.m5501a() > 0) {
                    arrayList.add(hVarM5480d.m5504d());
                }
                g gVar2 = arrayList3.isEmpty() ? new g() : (g) arrayList3.remove(arrayList3.size() - 1);
                gVar2.f4553a = gVar.f4553a;
                gVar2.f4555c = gVar.f4555c;
                gVar2.f4554b = hVarM5480d.f4557a;
                gVar2.f4556d = hVarM5480d.f4558b;
                arrayList2.add(gVar2);
                gVar.f4554b = gVar.f4554b;
                gVar.f4556d = gVar.f4556d;
                gVar.f4553a = hVarM5480d.f4559c;
                gVar.f4555c = hVarM5480d.f4560d;
                arrayList2.add(gVar);
            } else {
                arrayList3.add(gVar);
            }
        }
        Collections.sort(arrayList, f4537a);
        return new e(bVar, arrayList, cVar.m5487a(), cVar2.m5487a(), z10);
    }

    /* renamed from: c */
    public static h m5479c(g gVar, b bVar, c cVar, c cVar2, int i10) {
        int iM5488b;
        int i11;
        int i12;
        boolean z10 = Math.abs(gVar.m5500b() - gVar.m5499a()) % 2 == 1;
        int iM5500b = gVar.m5500b() - gVar.m5499a();
        int i13 = -i10;
        for (int i14 = i13; i14 <= i10; i14 += 2) {
            if (i14 == i13 || (i14 != i10 && cVar.m5488b(i14 + 1) > cVar.m5488b(i14 - 1))) {
                iM5488b = cVar.m5488b(i14 + 1);
                i11 = iM5488b;
            } else {
                iM5488b = cVar.m5488b(i14 - 1);
                i11 = iM5488b + 1;
            }
            int i15 = (gVar.f4555c + (i11 - gVar.f4553a)) - i14;
            int i16 = (i10 == 0 || i11 != iM5488b) ? i15 : i15 - 1;
            while (i11 < gVar.f4554b && i15 < gVar.f4556d && bVar.mo5483b(i11, i15)) {
                i11++;
                i15++;
            }
            cVar.m5489c(i14, i11);
            if (z10 && (i12 = iM5500b - i14) >= i13 + 1 && i12 <= i10 - 1 && cVar2.m5488b(i12) <= i11) {
                h hVar = new h();
                hVar.f4557a = iM5488b;
                hVar.f4558b = i16;
                hVar.f4559c = i11;
                hVar.f4560d = i15;
                hVar.f4561e = false;
                return hVar;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static h m5480d(g gVar, b bVar, c cVar, c cVar2) {
        if (gVar.m5500b() >= 1 && gVar.m5499a() >= 1) {
            int iM5500b = ((gVar.m5500b() + gVar.m5499a()) + 1) / 2;
            cVar.m5489c(1, gVar.f4553a);
            cVar2.m5489c(1, gVar.f4554b);
            for (int i10 = 0; i10 < iM5500b; i10++) {
                h hVarM5479c = m5479c(gVar, bVar, cVar, cVar2, i10);
                if (hVarM5479c != null) {
                    return hVarM5479c;
                }
                h hVarM5477a = m5477a(gVar, bVar, cVar, cVar2, i10);
                if (hVarM5477a != null) {
                    return hVarM5477a;
                }
            }
        }
        return null;
    }
}
