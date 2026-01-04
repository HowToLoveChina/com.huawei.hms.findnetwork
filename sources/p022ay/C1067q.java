package p022ay;

import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;
import kw.AbstractC11165b;
import p692uw.C13264g;

/* renamed from: ay.q */
/* loaded from: classes9.dex */
public final class C1067q extends AbstractC11165b<C1057g> implements RandomAccess {

    /* renamed from: d */
    public static final a f5153d = new a(null);

    /* renamed from: b */
    public final C1057g[] f5154b;

    /* renamed from: c */
    public final int[] f5155c;

    /* renamed from: ay.q$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: b */
        public static /* synthetic */ void m6425b(a aVar, long j10, C1054d c1054d, int i10, List list, int i11, int i12, List list2, int i13, Object obj) throws IOException {
            aVar.m6426a((i13 & 1) != 0 ? 0L : j10, c1054d, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        /* renamed from: a */
        public final void m6426a(long j10, C1054d c1054d, int i10, List<? extends C1057g> list, int i11, int i12, List<Integer> list2) throws IOException {
            int i13;
            int i14;
            int i15;
            int i16;
            C1054d c1054d2;
            int i17 = i10;
            if (i11 >= i12) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i18 = i11; i18 < i12; i18++) {
                if (list.get(i18).m6370E() < i17) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            C1057g c1057g = list.get(i11);
            C1057g c1057g2 = list.get(i12 - 1);
            int i19 = -1;
            if (i17 == c1057g.m6370E()) {
                int iIntValue = list2.get(i11).intValue();
                int i20 = i11 + 1;
                C1057g c1057g3 = list.get(i20);
                i13 = i20;
                i14 = iIntValue;
                c1057g = c1057g3;
            } else {
                i13 = i11;
                i14 = -1;
            }
            if (c1057g.m6379p(i17) == c1057g2.m6379p(i17)) {
                int iMin = Math.min(c1057g.m6370E(), c1057g2.m6370E());
                int i21 = 0;
                for (int i22 = i17; i22 < iMin && c1057g.m6379p(i22) == c1057g2.m6379p(i22); i22++) {
                    i21++;
                }
                long jM6427c = j10 + m6427c(c1054d) + 2 + i21 + 1;
                c1054d.writeInt(-i21);
                c1054d.writeInt(i14);
                int i23 = i21 + i17;
                while (i17 < i23) {
                    c1054d.writeInt(c1057g.m6379p(i17) & 255);
                    i17++;
                }
                if (i13 + 1 == i12) {
                    if (i23 != list.get(i13).m6370E()) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    c1054d.writeInt(list2.get(i13).intValue());
                    return;
                } else {
                    C1054d c1054d3 = new C1054d();
                    c1054d.writeInt(((int) (m6427c(c1054d3) + jM6427c)) * (-1));
                    m6426a(jM6427c, c1054d3, i23, list, i13, i12, list2);
                    c1054d.mo6328P(c1054d3);
                    return;
                }
            }
            int i24 = 1;
            for (int i25 = i13 + 1; i25 < i12; i25++) {
                if (list.get(i25 - 1).m6379p(i17) != list.get(i25).m6379p(i17)) {
                    i24++;
                }
            }
            long jM6427c2 = j10 + m6427c(c1054d) + 2 + (i24 * 2);
            c1054d.writeInt(i24);
            c1054d.writeInt(i14);
            for (int i26 = i13; i26 < i12; i26++) {
                byte bM6379p = list.get(i26).m6379p(i17);
                if (i26 == i13 || bM6379p != list.get(i26 - 1).m6379p(i17)) {
                    c1054d.writeInt(bM6379p & 255);
                }
            }
            C1054d c1054d4 = new C1054d();
            while (i13 < i12) {
                byte bM6379p2 = list.get(i13).m6379p(i17);
                int i27 = i13 + 1;
                int i28 = i27;
                while (true) {
                    if (i28 >= i12) {
                        i15 = i12;
                        break;
                    } else {
                        if (bM6379p2 != list.get(i28).m6379p(i17)) {
                            i15 = i28;
                            break;
                        }
                        i28++;
                    }
                }
                if (i27 == i15 && i17 + 1 == list.get(i13).m6370E()) {
                    c1054d.writeInt(list2.get(i13).intValue());
                    i16 = i15;
                    c1054d2 = c1054d4;
                } else {
                    c1054d.writeInt(((int) (jM6427c2 + m6427c(c1054d4))) * i19);
                    i16 = i15;
                    c1054d2 = c1054d4;
                    m6426a(jM6427c2, c1054d4, i17 + 1, list, i13, i15, list2);
                }
                c1054d4 = c1054d2;
                i13 = i16;
                i19 = -1;
            }
            c1054d.mo6328P(c1054d4);
        }

        /* renamed from: c */
        public final long m6427c(C1054d c1054d) {
            return c1054d.m6322J() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:95:0x00d7, code lost:
        
            continue;
         */
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final p022ay.C1067q m6428d(p022ay.C1057g... r17) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 292
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p022ay.C1067q.a.m6428d(ay.g[]):ay.q");
        }

        public a() {
        }
    }

    public /* synthetic */ C1067q(C1057g[] c1057gArr, int[] iArr, C13264g c13264g) {
        this(c1057gArr, iArr);
    }

    /* renamed from: h */
    public static final C1067q m6417h(C1057g... c1057gArr) {
        return f5153d.m6428d(c1057gArr);
    }

    @Override // kw.AbstractC11163a
    /* renamed from: a */
    public int mo6418a() {
        return this.f5154b.length;
    }

    /* renamed from: b */
    public /* bridge */ boolean m6419b(C1057g c1057g) {
        return super.contains(c1057g);
    }

    @Override // kw.AbstractC11165b, java.util.List
    /* renamed from: c */
    public C1057g get(int i10) {
        return this.f5154b[i10];
    }

    @Override // kw.AbstractC11163a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C1057g) {
            return m6419b((C1057g) obj);
        }
        return false;
    }

    /* renamed from: d */
    public final C1057g[] m6421d() {
        return this.f5154b;
    }

    /* renamed from: e */
    public final int[] m6422e() {
        return this.f5155c;
    }

    /* renamed from: f */
    public /* bridge */ int m6423f(C1057g c1057g) {
        return super.indexOf(c1057g);
    }

    /* renamed from: g */
    public /* bridge */ int m6424g(C1057g c1057g) {
        return super.lastIndexOf(c1057g);
    }

    @Override // kw.AbstractC11165b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof C1057g) {
            return m6423f((C1057g) obj);
        }
        return -1;
    }

    @Override // kw.AbstractC11165b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof C1057g) {
            return m6424g((C1057g) obj);
        }
        return -1;
    }

    public C1067q(C1057g[] c1057gArr, int[] iArr) {
        this.f5154b = c1057gArr;
        this.f5155c = iArr;
    }
}
