package p022ay;

import kw.C11175g;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: ay.u */
/* loaded from: classes9.dex */
public final class C1071u {

    /* renamed from: h */
    public static final a f5166h = new a(null);

    /* renamed from: a */
    public final byte[] f5167a;

    /* renamed from: b */
    public int f5168b;

    /* renamed from: c */
    public int f5169c;

    /* renamed from: d */
    public boolean f5170d;

    /* renamed from: e */
    public boolean f5171e;

    /* renamed from: f */
    public C1071u f5172f;

    /* renamed from: g */
    public C1071u f5173g;

    /* renamed from: ay.u$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    public C1071u(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        C13267j.m79677e(bArr, "data");
        this.f5167a = bArr;
        this.f5168b = i10;
        this.f5169c = i11;
        this.f5170d = z10;
        this.f5171e = z11;
    }

    /* renamed from: a */
    public final void m6434a() {
        int i10;
        C1071u c1071u = this.f5173g;
        if (c1071u == this) {
            throw new IllegalStateException("cannot compact".toString());
        }
        C13267j.m79674b(c1071u);
        if (c1071u.f5171e) {
            int i11 = this.f5169c - this.f5168b;
            C1071u c1071u2 = this.f5173g;
            C13267j.m79674b(c1071u2);
            int i12 = 8192 - c1071u2.f5169c;
            C1071u c1071u3 = this.f5173g;
            C13267j.m79674b(c1071u3);
            if (c1071u3.f5170d) {
                i10 = 0;
            } else {
                C1071u c1071u4 = this.f5173g;
                C13267j.m79674b(c1071u4);
                i10 = c1071u4.f5168b;
            }
            if (i11 > i12 + i10) {
                return;
            }
            C1071u c1071u5 = this.f5173g;
            C13267j.m79674b(c1071u5);
            m6439f(c1071u5, i11);
            m6435b();
            C1072v.m6440b(this);
        }
    }

    /* renamed from: b */
    public final C1071u m6435b() {
        C1071u c1071u = this.f5172f;
        if (c1071u == this) {
            c1071u = null;
        }
        C1071u c1071u2 = this.f5173g;
        C13267j.m79674b(c1071u2);
        c1071u2.f5172f = this.f5172f;
        C1071u c1071u3 = this.f5172f;
        C13267j.m79674b(c1071u3);
        c1071u3.f5173g = this.f5173g;
        this.f5172f = null;
        this.f5173g = null;
        return c1071u;
    }

    /* renamed from: c */
    public final C1071u m6436c(C1071u c1071u) {
        C13267j.m79677e(c1071u, "segment");
        c1071u.f5173g = this;
        c1071u.f5172f = this.f5172f;
        C1071u c1071u2 = this.f5172f;
        C13267j.m79674b(c1071u2);
        c1071u2.f5173g = c1071u;
        this.f5172f = c1071u;
        return c1071u;
    }

    /* renamed from: d */
    public final C1071u m6437d() {
        this.f5170d = true;
        return new C1071u(this.f5167a, this.f5168b, this.f5169c, true, false);
    }

    /* renamed from: e */
    public final C1071u m6438e(int i10) {
        C1071u c1071uM6441c;
        if (i10 <= 0 || i10 > this.f5169c - this.f5168b) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i10 >= 1024) {
            c1071uM6441c = m6437d();
        } else {
            c1071uM6441c = C1072v.m6441c();
            byte[] bArr = this.f5167a;
            byte[] bArr2 = c1071uM6441c.f5167a;
            int i11 = this.f5168b;
            C11175g.m67145e(bArr, bArr2, 0, i11, i11 + i10, 2, null);
        }
        c1071uM6441c.f5169c = c1071uM6441c.f5168b + i10;
        this.f5168b += i10;
        C1071u c1071u = this.f5173g;
        C13267j.m79674b(c1071u);
        c1071u.m6436c(c1071uM6441c);
        return c1071uM6441c;
    }

    /* renamed from: f */
    public final void m6439f(C1071u c1071u, int i10) {
        C13267j.m79677e(c1071u, "sink");
        if (!c1071u.f5171e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i11 = c1071u.f5169c;
        if (i11 + i10 > 8192) {
            if (c1071u.f5170d) {
                throw new IllegalArgumentException();
            }
            int i12 = c1071u.f5168b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = c1071u.f5167a;
            C11175g.m67145e(bArr, bArr, 0, i12, i11, 2, null);
            c1071u.f5169c -= c1071u.f5168b;
            c1071u.f5168b = 0;
        }
        byte[] bArr2 = this.f5167a;
        byte[] bArr3 = c1071u.f5167a;
        int i13 = c1071u.f5169c;
        int i14 = this.f5168b;
        C11175g.m67143c(bArr2, bArr3, i13, i14, i14 + i10);
        c1071u.f5169c += i10;
        this.f5168b += i10;
    }

    public C1071u() {
        this.f5167a = new byte[8192];
        this.f5171e = true;
        this.f5170d = false;
    }
}
