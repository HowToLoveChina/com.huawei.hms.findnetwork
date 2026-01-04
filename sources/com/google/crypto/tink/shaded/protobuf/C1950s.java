package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1958u1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.s */
/* loaded from: classes.dex */
public final class C1950s extends AbstractC1947r<AbstractC1968z.d> {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.s$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9254a;

        static {
            int[] iArr = new int[C1958u1.b.values().length];
            f9254a = iArr;
            try {
                iArr[C1958u1.b.f9287c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9254a[C1958u1.b.f9288d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9254a[C1958u1.b.f9289e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9254a[C1958u1.b.f9290f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9254a[C1958u1.b.f9291g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9254a[C1958u1.b.f9292h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9254a[C1958u1.b.f9293i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9254a[C1958u1.b.f9294j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9254a[C1958u1.b.f9299o.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9254a[C1958u1.b.f9301q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9254a[C1958u1.b.f9302r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9254a[C1958u1.b.f9303s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9254a[C1958u1.b.f9304t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9254a[C1958u1.b.f9300p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9254a[C1958u1.b.f9298n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9254a[C1958u1.b.f9295k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9254a[C1958u1.b.f9296l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f9254a[C1958u1.b.f9297m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: a */
    public int mo12121a(Map.Entry<?, ?> entry) {
        return ((AbstractC1968z.d) entry.getKey()).mo12285a0();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: b */
    public Object mo12122b(C1944q c1944q, InterfaceC1951s0 interfaceC1951s0, int i10) {
        return c1944q.m12104a(interfaceC1951s0, i10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: c */
    public C1959v<AbstractC1968z.d> mo12123c(Object obj) {
        return ((AbstractC1968z.c) obj).extensions;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: d */
    public C1959v<AbstractC1968z.d> mo12124d(Object obj) {
        return ((AbstractC1968z.c) obj).m12409M();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: e */
    public boolean mo12125e(InterfaceC1951s0 interfaceC1951s0) {
        return interfaceC1951s0 instanceof AbstractC1968z.c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: f */
    public void mo12126f(Object obj) {
        mo12123c(obj).m12280s();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: g */
    public <UT, UB> UB mo12127g(InterfaceC1916g1 interfaceC1916g1, Object obj, C1944q c1944q, C1959v<AbstractC1968z.d> c1959v, UB ub2, AbstractC1940o1<UT, UB> abstractC1940o1) throws IOException {
        Object objValueOf;
        Object objM12272i;
        ArrayList arrayList;
        AbstractC1968z.e eVar = (AbstractC1968z.e) obj;
        int iM12414c = eVar.m12414c();
        if (eVar.f9432b.mo12286b0() && eVar.f9432b.mo12290o0()) {
            switch (a.f9254a[eVar.m12412a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11581L(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11575F(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11621n(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11617l(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11623p(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11585P(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11628u(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11632y(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11607g(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11603e(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11622o(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11597b(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11605f(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    interfaceC1916g1.mo11624q(arrayList);
                    ub2 = (UB) C1925j1.m11829z(iM12414c, arrayList, eVar.f9432b.m12411b(), ub2, abstractC1940o1);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f9432b.mo12287c0());
            }
            c1959v.m12283w(eVar.f9432b, arrayList);
        } else {
            if (eVar.m12412a() != C1958u1.b.f9300p) {
                switch (a.f9254a[eVar.m12412a().ordinal()]) {
                    case 1:
                        objValueOf = Double.valueOf(interfaceC1916g1.readDouble());
                        break;
                    case 2:
                        objValueOf = Float.valueOf(interfaceC1916g1.readFloat());
                        break;
                    case 3:
                        objValueOf = Long.valueOf(interfaceC1916g1.mo11583N());
                        break;
                    case 4:
                        objValueOf = Long.valueOf(interfaceC1916g1.mo11599c());
                        break;
                    case 5:
                        objValueOf = Integer.valueOf(interfaceC1916g1.mo11576G());
                        break;
                    case 6:
                        objValueOf = Long.valueOf(interfaceC1916g1.mo11601d());
                        break;
                    case 7:
                        objValueOf = Integer.valueOf(interfaceC1916g1.mo11611i());
                        break;
                    case 8:
                        objValueOf = Boolean.valueOf(interfaceC1916g1.mo11613j());
                        break;
                    case 9:
                        objValueOf = Integer.valueOf(interfaceC1916g1.mo11619m());
                        break;
                    case 10:
                        objValueOf = Integer.valueOf(interfaceC1916g1.mo11578I());
                        break;
                    case 11:
                        objValueOf = Long.valueOf(interfaceC1916g1.mo11615k());
                        break;
                    case 12:
                        objValueOf = Integer.valueOf(interfaceC1916g1.mo11629v());
                        break;
                    case 13:
                        objValueOf = Long.valueOf(interfaceC1916g1.mo11630w());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        objValueOf = interfaceC1916g1.mo11574E();
                        break;
                    case 16:
                        objValueOf = interfaceC1916g1.mo11633z();
                        break;
                    case 17:
                        objValueOf = interfaceC1916g1.mo11631x(eVar.m12413b().getClass(), c1944q);
                        break;
                    case 18:
                        objValueOf = interfaceC1916g1.mo11570A(eVar.m12413b().getClass(), c1944q);
                        break;
                    default:
                        objValueOf = null;
                        break;
                }
            } else {
                int iMo11576G = interfaceC1916g1.mo11576G();
                if (eVar.f9432b.m12411b().mo11497a(iMo11576G) == null) {
                    return (UB) C1925j1.m11784L(iM12414c, iMo11576G, ub2, abstractC1940o1);
                }
                objValueOf = Integer.valueOf(iMo11576G);
            }
            if (eVar.m12415d()) {
                c1959v.m12269a(eVar.f9432b, objValueOf);
            } else {
                int i10 = a.f9254a[eVar.m12412a().ordinal()];
                if ((i10 == 17 || i10 == 18) && (objM12272i = c1959v.m12272i(eVar.f9432b)) != null) {
                    objValueOf = C1900b0.m11493h(objM12272i, objValueOf);
                }
                c1959v.m12283w(eVar.f9432b, objValueOf);
            }
        }
        return ub2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: h */
    public void mo12128h(InterfaceC1916g1 interfaceC1916g1, Object obj, C1944q c1944q, C1959v<AbstractC1968z.d> c1959v) throws IOException {
        AbstractC1968z.e eVar = (AbstractC1968z.e) obj;
        c1959v.m12283w(eVar.f9432b, interfaceC1916g1.mo11570A(eVar.m12413b().getClass(), c1944q));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: i */
    public void mo12129i(AbstractC1920i abstractC1920i, Object obj, C1944q c1944q, C1959v<AbstractC1968z.d> c1959v) throws IOException {
        AbstractC1968z.e eVar = (AbstractC1968z.e) obj;
        InterfaceC1951s0 interfaceC1951s0Mo12143I = eVar.m12413b().mo12141k().mo12143I();
        AbstractC1911f abstractC1911fM11569Q = AbstractC1911f.m11569Q(ByteBuffer.wrap(abstractC1920i.m11698u()), true);
        C1907d1.m11516a().m11517b(interfaceC1951s0Mo12143I, abstractC1911fM11569Q, c1944q);
        c1959v.m12283w(eVar.f9432b, interfaceC1951s0Mo12143I);
        if (abstractC1911fM11569Q.mo11571B() != Integer.MAX_VALUE) {
            throw C1903c0.m11502b();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1947r
    /* renamed from: j */
    public void mo12130j(InterfaceC1961v1 interfaceC1961v1, Map.Entry<?, ?> entry) throws IOException {
        AbstractC1968z.d dVar = (AbstractC1968z.d) entry.getKey();
        if (!dVar.mo12286b0()) {
            switch (a.f9254a[dVar.mo12287c0().ordinal()]) {
                case 1:
                    interfaceC1961v1.mo12000e(dVar.mo12285a0(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    interfaceC1961v1.mo11985G(dVar.mo12285a0(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    interfaceC1961v1.mo12013r(dVar.mo12285a0(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    interfaceC1961v1.mo12009n(dVar.mo12285a0(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    interfaceC1961v1.mo12018w(dVar.mo12285a0(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    interfaceC1961v1.mo12005j(dVar.mo12285a0(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    interfaceC1961v1.mo11999d(dVar.mo12285a0(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    interfaceC1961v1.mo12014s(dVar.mo12285a0(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    interfaceC1961v1.mo11997b(dVar.mo12285a0(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    interfaceC1961v1.mo12016u(dVar.mo12285a0(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    interfaceC1961v1.mo12021z(dVar.mo12285a0(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    interfaceC1961v1.mo11992N(dVar.mo12285a0(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    interfaceC1961v1.mo11984F(dVar.mo12285a0(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    interfaceC1961v1.mo12018w(dVar.mo12285a0(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    interfaceC1961v1.mo11981C(dVar.mo12285a0(), (AbstractC1920i) entry.getValue());
                    break;
                case 16:
                    interfaceC1961v1.mo12008m(dVar.mo12285a0(), (String) entry.getValue());
                    break;
                case 17:
                    interfaceC1961v1.mo12010o(dVar.mo12285a0(), entry.getValue(), C1907d1.m11516a().m11519d(entry.getValue().getClass()));
                    break;
                case 18:
                    interfaceC1961v1.mo12002g(dVar.mo12285a0(), entry.getValue(), C1907d1.m11516a().m11519d(entry.getValue().getClass()));
                    break;
            }
        }
        switch (a.f9254a[dVar.mo12287c0().ordinal()]) {
            case 1:
                C1925j1.m11788P(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 2:
                C1925j1.m11792T(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 3:
                C1925j1.m11795W(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 4:
                C1925j1.m11808e0(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 5:
                C1925j1.m11794V(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 6:
                C1925j1.m11791S(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 7:
                C1925j1.m11790R(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 8:
                C1925j1.m11786N(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 9:
                C1925j1.m11806d0(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 10:
                C1925j1.m11797Y(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 11:
                C1925j1.m11798Z(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 12:
                C1925j1.m11800a0(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 13:
                C1925j1.m11802b0(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 14:
                C1925j1.m11794V(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, dVar.mo12290o0());
                break;
            case 15:
                C1925j1.m11787O(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1);
                break;
            case 16:
                C1925j1.m11804c0(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    C1925j1.m11793U(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, C1907d1.m11516a().m11519d(list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    C1925j1.m11796X(dVar.mo12285a0(), (List) entry.getValue(), interfaceC1961v1, C1907d1.m11516a().m11519d(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }
}
