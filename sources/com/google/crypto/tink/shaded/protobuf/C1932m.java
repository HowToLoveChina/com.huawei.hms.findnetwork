package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1930l0;
import com.google.crypto.tink.shaded.protobuf.C1958u1;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.m */
/* loaded from: classes.dex */
public final class C1932m implements InterfaceC1961v1 {

    /* renamed from: a */
    public final AbstractC1929l f9224a;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.m$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9225a;

        static {
            int[] iArr = new int[C1958u1.b.values().length];
            f9225a = iArr;
            try {
                iArr[C1958u1.b.f9294j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9225a[C1958u1.b.f9293i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9225a[C1958u1.b.f9291g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9225a[C1958u1.b.f9301q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9225a[C1958u1.b.f9303s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9225a[C1958u1.b.f9299o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9225a[C1958u1.b.f9292h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9225a[C1958u1.b.f9289e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9225a[C1958u1.b.f9302r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9225a[C1958u1.b.f9304t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9225a[C1958u1.b.f9290f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9225a[C1958u1.b.f9295k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C1932m(AbstractC1929l abstractC1929l) {
        AbstractC1929l abstractC1929l2 = (AbstractC1929l) C1900b0.m11487b(abstractC1929l, "output");
        this.f9224a = abstractC1929l2;
        abstractC1929l2.f9213a = this;
    }

    /* renamed from: P */
    public static C1932m m11978P(AbstractC1929l abstractC1929l) {
        C1932m c1932m = abstractC1929l.f9213a;
        return c1932m != null ? c1932m : new C1932m(abstractC1929l);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: A */
    public void mo11979A(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.mo11955o0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11913n = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11913n += AbstractC1929l.m11913n(list.get(i12).intValue());
        }
        this.f9224a.mo11940O0(iM11913n);
        while (i11 < list.size()) {
            this.f9224a.mo11956p0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: B */
    public void mo11980B(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.mo11948h0(i10, list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11903e = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11903e += AbstractC1929l.m11903e(list.get(i12).booleanValue());
        }
        this.f9224a.mo11940O0(iM11903e);
        while (i11 < list.size()) {
            this.f9224a.m11949i0(list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: C */
    public void mo11981C(int i10, AbstractC1920i abstractC1920i) throws IOException {
        this.f9224a.mo11950j0(i10, abstractC1920i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: D */
    public void mo11982D(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.mo11939N0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11895W = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11895W += AbstractC1929l.m11895W(list.get(i12).intValue());
        }
        this.f9224a.mo11940O0(iM11895W);
        while (i11 < list.size()) {
            this.f9224a.mo11940O0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: E */
    public void mo11983E(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11935J0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11890R = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11890R += AbstractC1929l.m11890R(list.get(i12).longValue());
        }
        this.f9224a.mo11940O0(iM11890R);
        while (i11 < list.size()) {
            this.f9224a.m11936K0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: F */
    public void mo11984F(int i10, long j10) throws IOException {
        this.f9224a.m11935J0(i10, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: G */
    public void mo11985G(int i10, float f10) throws IOException {
        this.f9224a.m11959s0(i10, f10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: H */
    public void mo11986H(int i10) throws IOException {
        this.f9224a.mo11938M0(i10, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: I */
    public void mo11987I(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11933H0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11888P = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11888P += AbstractC1929l.m11888P(list.get(i12).intValue());
        }
        this.f9224a.mo11940O0(iM11888P);
        while (i11 < list.size()) {
            this.f9224a.m11934I0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: J */
    public void mo11988J(int i10, int i11) throws IOException {
        this.f9224a.m11953m0(i10, i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: K */
    public void mo11989K(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11965y0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11924y = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11924y += AbstractC1929l.m11924y(list.get(i12).longValue());
        }
        this.f9224a.mo11940O0(iM11924y);
        while (i11 < list.size()) {
            this.f9224a.m11966z0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: L */
    public void mo11990L(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11953m0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11911l = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11911l += AbstractC1929l.m11911l(list.get(i12).intValue());
        }
        this.f9224a.mo11940O0(iM11911l);
        while (i11 < list.size()) {
            this.f9224a.m11954n0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: M */
    public void mo11991M(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11951k0(i10, list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11909j = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11909j += AbstractC1929l.m11909j(list.get(i12).doubleValue());
        }
        this.f9224a.mo11940O0(iM11909j);
        while (i11 < list.size()) {
            this.f9224a.m11952l0(list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: N */
    public void mo11992N(int i10, int i11) throws IOException {
        this.f9224a.m11933H0(i10, i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: O */
    public void mo11993O(int i10, List<AbstractC1920i> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f9224a.mo11950j0(i10, list.get(i11));
        }
    }

    /* renamed from: Q */
    public final <K, V> void m11994Q(int i10, C1930l0.a<K, V> aVar, Map<K, V> map) throws IOException {
        int[] iArr = a.f9225a;
        throw null;
    }

    /* renamed from: R */
    public final void m11995R(int i10, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f9224a.mo11937L0(i10, (String) obj);
        } else {
            this.f9224a.mo11950j0(i10, (AbstractC1920i) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: a */
    public void mo11996a(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11959s0(i10, list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11917r = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11917r += AbstractC1929l.m11917r(list.get(i12).floatValue());
        }
        this.f9224a.mo11940O0(iM11917r);
        while (i11 < list.size()) {
            this.f9224a.m11960t0(list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: b */
    public void mo11997b(int i10, int i11) throws IOException {
        this.f9224a.mo11939N0(i10, i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: c */
    public final void mo11998c(int i10, Object obj) throws IOException {
        if (obj instanceof AbstractC1920i) {
            this.f9224a.mo11928C0(i10, (AbstractC1920i) obj);
        } else {
            this.f9224a.mo11927B0(i10, (InterfaceC1951s0) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: d */
    public void mo11999d(int i10, int i11) throws IOException {
        this.f9224a.mo11955o0(i10, i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: e */
    public void mo12000e(int i10, double d10) throws IOException {
        this.f9224a.m11951k0(i10, d10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: f */
    public void mo12001f(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11931F0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11886N = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11886N += AbstractC1929l.m11886N(list.get(i12).longValue());
        }
        this.f9224a.mo11940O0(iM11886N);
        while (i11 < list.size()) {
            this.f9224a.m11932G0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: g */
    public void mo12002g(int i10, Object obj, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        this.f9224a.mo11926A0(i10, (InterfaceC1951s0) obj, interfaceC1919h1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: h */
    public void mo12003h(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.mo11941P0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11897Y = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11897Y += AbstractC1929l.m11897Y(list.get(i12).longValue());
        }
        this.f9224a.mo11940O0(iM11897Y);
        while (i11 < list.size()) {
            this.f9224a.mo11942Q0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: i */
    public <K, V> void mo12004i(int i10, C1930l0.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (this.f9224a.m11945c0()) {
            m11994Q(i10, aVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f9224a.mo11938M0(i10, 2);
            this.f9224a.mo11940O0(C1930l0.m11972b(aVar, entry.getKey(), entry.getValue()));
            C1930l0.m11973d(this.f9224a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: j */
    public void mo12005j(int i10, long j10) throws IOException {
        this.f9224a.mo11957q0(i10, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: k */
    public InterfaceC1961v1.a mo12006k() {
        return InterfaceC1961v1.a.ASCENDING;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: l */
    public void mo12007l(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (!(list instanceof InterfaceC1918h0)) {
            while (i11 < list.size()) {
                this.f9224a.mo11937L0(i10, list.get(i11));
                i11++;
            }
        } else {
            InterfaceC1918h0 interfaceC1918h0 = (InterfaceC1918h0) list;
            while (i11 < list.size()) {
                m11995R(i10, interfaceC1918h0.mo11660a0(i11));
                i11++;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: m */
    public void mo12008m(int i10, String str) throws IOException {
        this.f9224a.mo11937L0(i10, str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: n */
    public void mo12009n(int i10, long j10) throws IOException {
        this.f9224a.mo11941P0(i10, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: o */
    public void mo12010o(int i10, Object obj, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        this.f9224a.m11961u0(i10, (InterfaceC1951s0) obj, interfaceC1919h1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: p */
    public void mo12011p(int i10, List<?> list, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            mo12010o(i10, list.get(i11), interfaceC1919h1);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: q */
    public void mo12012q(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.mo11963w0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11922w = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11922w += AbstractC1929l.m11922w(list.get(i12).intValue());
        }
        this.f9224a.mo11940O0(iM11922w);
        while (i11 < list.size()) {
            this.f9224a.mo11964x0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: r */
    public void mo12013r(int i10, long j10) throws IOException {
        this.f9224a.m11965y0(i10, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: s */
    public void mo12014s(int i10, boolean z10) throws IOException {
        this.f9224a.mo11948h0(i10, z10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: t */
    public void mo12015t(int i10, List<?> list, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            mo12002g(i10, list.get(i11), interfaceC1919h1);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: u */
    public void mo12016u(int i10, int i11) throws IOException {
        this.f9224a.m11929D0(i10, i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: v */
    public void mo12017v(int i10) throws IOException {
        this.f9224a.mo11938M0(i10, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: w */
    public void mo12018w(int i10, int i11) throws IOException {
        this.f9224a.mo11963w0(i10, i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: x */
    public void mo12019x(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.mo11957q0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11915p = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11915p += AbstractC1929l.m11915p(list.get(i12).longValue());
        }
        this.f9224a.mo11940O0(iM11915p);
        while (i11 < list.size()) {
            this.f9224a.mo11958r0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: y */
    public void mo12020y(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f9224a.m11929D0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f9224a.mo11938M0(i10, 2);
        int iM11884L = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM11884L += AbstractC1929l.m11884L(list.get(i12).intValue());
        }
        this.f9224a.mo11940O0(iM11884L);
        while (i11 < list.size()) {
            this.f9224a.m11930E0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1
    /* renamed from: z */
    public void mo12021z(int i10, long j10) throws IOException {
        this.f9224a.m11931F0(i10, j10);
    }
}
