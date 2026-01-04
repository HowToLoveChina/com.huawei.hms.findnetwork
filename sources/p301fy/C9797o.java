package p301fy;

import java.nio.file.attribute.FileTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;
import p270ey.InterfaceC9572a;
import p503ny.C11767a;

/* renamed from: fy.o */
/* loaded from: classes9.dex */
public class C9797o implements InterfaceC9572a {

    /* renamed from: s */
    public static final C9797o[] f48155s = new C9797o[0];

    /* renamed from: a */
    public String f48156a;

    /* renamed from: b */
    public boolean f48157b;

    /* renamed from: c */
    public boolean f48158c;

    /* renamed from: d */
    public boolean f48159d;

    /* renamed from: e */
    public boolean f48160e;

    /* renamed from: f */
    public boolean f48161f;

    /* renamed from: g */
    public boolean f48162g;

    /* renamed from: h */
    public FileTime f48163h;

    /* renamed from: i */
    public FileTime f48164i;

    /* renamed from: j */
    public FileTime f48165j;

    /* renamed from: k */
    public boolean f48166k;

    /* renamed from: l */
    public int f48167l;

    /* renamed from: m */
    public boolean f48168m;

    /* renamed from: n */
    public long f48169n;

    /* renamed from: o */
    public long f48170o;

    /* renamed from: p */
    public long f48171p;

    /* renamed from: q */
    public long f48172q;

    /* renamed from: r */
    public Iterable<? extends C9805w> f48173r;

    /* renamed from: A */
    public void m60877A(long j10) {
        this.f48171p = j10;
    }

    /* renamed from: B */
    public void m60878B(int i10) {
        this.f48167l = i10;
    }

    /* renamed from: a */
    public final boolean m60879a(Iterable<? extends C9805w> iterable, Iterable<? extends C9805w> iterable2) {
        if (iterable == null) {
            return iterable2 == null;
        }
        if (iterable2 == null) {
            return false;
        }
        Iterator<? extends C9805w> it = iterable2.iterator();
        for (C9805w c9805w : iterable) {
            if (!it.hasNext() || !c9805w.equals(it.next())) {
                return false;
            }
        }
        return true ^ it.hasNext();
    }

    /* renamed from: b */
    public Iterable<? extends C9805w> m60880b() {
        return this.f48173r;
    }

    /* renamed from: c */
    public long m60881c() {
        return this.f48169n;
    }

    /* renamed from: d */
    public boolean m60882d() {
        return this.f48162g;
    }

    /* renamed from: e */
    public boolean m60883e() {
        return this.f48168m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C9797o c9797o = (C9797o) obj;
        return Objects.equals(this.f48156a, c9797o.f48156a) && this.f48157b == c9797o.f48157b && this.f48158c == c9797o.f48158c && this.f48159d == c9797o.f48159d && this.f48160e == c9797o.f48160e && this.f48161f == c9797o.f48161f && this.f48162g == c9797o.f48162g && Objects.equals(this.f48163h, c9797o.f48163h) && Objects.equals(this.f48164i, c9797o.f48164i) && Objects.equals(this.f48165j, c9797o.f48165j) && this.f48166k == c9797o.f48166k && this.f48167l == c9797o.f48167l && this.f48168m == c9797o.f48168m && this.f48169n == c9797o.f48169n && this.f48170o == c9797o.f48170o && this.f48171p == c9797o.f48171p && this.f48172q == c9797o.f48172q && m60879a(this.f48173r, c9797o.f48173r);
    }

    /* renamed from: f */
    public boolean m60884f() {
        return this.f48160e;
    }

    /* renamed from: g */
    public boolean m60885g() {
        return this.f48161f;
    }

    /* renamed from: h */
    public boolean m60886h() {
        return this.f48166k;
    }

    public int hashCode() {
        String strM60887i = m60887i();
        if (strM60887i == null) {
            return 0;
        }
        return strM60887i.hashCode();
    }

    /* renamed from: i */
    public String m60887i() {
        return this.f48156a;
    }

    /* renamed from: j */
    public long m60888j() {
        return this.f48171p;
    }

    /* renamed from: k */
    public boolean m60889k() {
        return this.f48157b;
    }

    /* renamed from: l */
    public boolean m60890l() {
        return this.f48158c;
    }

    /* renamed from: m */
    public void m60891m(long j10) {
        this.f48165j = C11767a.m70096a(j10);
    }

    /* renamed from: n */
    public void m60892n(boolean z10) {
        this.f48159d = z10;
    }

    /* renamed from: o */
    public void m60893o(Iterable<? extends C9805w> iterable) {
        if (iterable == null) {
            this.f48173r = null;
            return;
        }
        final LinkedList linkedList = new LinkedList();
        iterable.forEach(new Consumer() { // from class: fy.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                linkedList.addLast((C9805w) obj);
            }
        });
        this.f48173r = Collections.unmodifiableList(linkedList);
    }

    /* renamed from: p */
    public void m60894p(long j10) {
        this.f48169n = j10;
    }

    /* renamed from: q */
    public void m60895q(long j10) {
        this.f48163h = C11767a.m70096a(j10);
    }

    /* renamed from: r */
    public void m60896r(boolean z10) {
        this.f48158c = z10;
    }

    /* renamed from: s */
    public void m60897s(boolean z10) {
        this.f48162g = z10;
    }

    /* renamed from: t */
    public void m60898t(boolean z10) {
        this.f48168m = z10;
    }

    /* renamed from: u */
    public void m60899u(boolean z10) {
        this.f48160e = z10;
    }

    /* renamed from: v */
    public void m60900v(boolean z10) {
        this.f48161f = z10;
    }

    /* renamed from: w */
    public void m60901w(boolean z10) {
        this.f48157b = z10;
    }

    /* renamed from: x */
    public void m60902x(boolean z10) {
        this.f48166k = z10;
    }

    /* renamed from: y */
    public void m60903y(long j10) {
        this.f48164i = C11767a.m70096a(j10);
    }

    /* renamed from: z */
    public void m60904z(String str) {
        this.f48156a = str;
    }
}
