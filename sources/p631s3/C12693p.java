package p631s3;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p005a4.C0035o;
import p831z3.C14094c0;
import p831z3.EnumC14106i0;
import p831z3.EnumC14126z;

/* renamed from: s3.p */
/* loaded from: classes.dex */
public final class C12693p<P> {

    /* renamed from: a */
    public final ConcurrentMap<c, List<b<P>>> f58213a = new ConcurrentHashMap();

    /* renamed from: b */
    public b<P> f58214b;

    /* renamed from: c */
    public final Class<P> f58215c;

    /* renamed from: s3.p$b */
    public static final class b<P> {

        /* renamed from: a */
        public final P f58216a;

        /* renamed from: b */
        public final byte[] f58217b;

        /* renamed from: c */
        public final EnumC14126z f58218c;

        /* renamed from: d */
        public final EnumC14106i0 f58219d;

        /* renamed from: e */
        public final int f58220e;

        public b(P p10, byte[] bArr, EnumC14126z enumC14126z, EnumC14106i0 enumC14106i0, int i10) {
            this.f58216a = p10;
            this.f58217b = Arrays.copyOf(bArr, bArr.length);
            this.f58218c = enumC14126z;
            this.f58219d = enumC14106i0;
            this.f58220e = i10;
        }

        /* renamed from: a */
        public final byte[] m76364a() {
            byte[] bArr = this.f58217b;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        /* renamed from: b */
        public EnumC14106i0 m76365b() {
            return this.f58219d;
        }

        /* renamed from: c */
        public P m76366c() {
            return this.f58216a;
        }

        /* renamed from: d */
        public EnumC14126z m76367d() {
            return this.f58218c;
        }
    }

    /* renamed from: s3.p$c */
    public static class c implements Comparable<c> {

        /* renamed from: a */
        public final byte[] f58221a;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            byte[] bArr = this.f58221a;
            int length = bArr.length;
            byte[] bArr2 = cVar.f58221a;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i10 = 0;
            while (true) {
                byte[] bArr3 = this.f58221a;
                if (i10 >= bArr3.length) {
                    return 0;
                }
                byte b10 = bArr3[i10];
                byte b11 = cVar.f58221a[i10];
                if (b10 != b11) {
                    return b10 - b11;
                }
                i10++;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(this.f58221a, ((c) obj).f58221a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f58221a);
        }

        public String toString() {
            return C0035o.m144b(this.f58221a);
        }

        public c(byte[] bArr) {
            this.f58221a = Arrays.copyOf(bArr, bArr.length);
        }
    }

    public C12693p(Class<P> cls) {
        this.f58215c = cls;
    }

    /* renamed from: f */
    public static <P> C12693p<P> m76357f(Class<P> cls) {
        return new C12693p<>(cls);
    }

    /* renamed from: a */
    public b<P> m76358a(P p10, C14094c0.c cVar) throws GeneralSecurityException {
        if (cVar.m84498U() != EnumC14126z.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        b<P> bVar = new b<>(p10, C12680c.m76302a(cVar), cVar.m84498U(), cVar.m84497T(), cVar.m84496S());
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        c cVar2 = new c(bVar.m76364a());
        List<b<P>> listPut = this.f58213a.put(cVar2, Collections.unmodifiableList(arrayList));
        if (listPut != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(listPut);
            arrayList2.add(bVar);
            this.f58213a.put(cVar2, Collections.unmodifiableList(arrayList2));
        }
        return bVar;
    }

    /* renamed from: b */
    public b<P> m76359b() {
        return this.f58214b;
    }

    /* renamed from: c */
    public List<b<P>> m76360c(byte[] bArr) {
        List<b<P>> list = this.f58213a.get(new c(bArr));
        return list != null ? list : Collections.emptyList();
    }

    /* renamed from: d */
    public Class<P> m76361d() {
        return this.f58215c;
    }

    /* renamed from: e */
    public List<b<P>> m76362e() {
        return m76360c(C12680c.f58192a);
    }

    /* renamed from: g */
    public void m76363g(b<P> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (bVar.m76367d() != EnumC14126z.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        if (m76360c(bVar.m76364a()).isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.f58214b = bVar;
    }
}
