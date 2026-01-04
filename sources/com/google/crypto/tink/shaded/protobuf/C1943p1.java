package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.InterfaceC1961v1;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.crypto.tink.shaded.protobuf.p1 */
/* loaded from: classes.dex */
public final class C1943p1 {

    /* renamed from: f */
    public static final C1943p1 f9236f = new C1943p1(0, new int[0], new Object[0], false);

    /* renamed from: a */
    public int f9237a;

    /* renamed from: b */
    public int[] f9238b;

    /* renamed from: c */
    public Object[] f9239c;

    /* renamed from: d */
    public int f9240d;

    /* renamed from: e */
    public boolean f9241e;

    public C1943p1() {
        this(0, new int[8], new Object[8], true);
    }

    /* renamed from: c */
    public static boolean m12086c(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m12087d(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static C1943p1 m12088e() {
        return f9236f;
    }

    /* renamed from: h */
    public static int m12089h(int[] iArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        return i11;
    }

    /* renamed from: i */
    public static int m12090i(Object[] objArr, int i10) {
        int iHashCode = 17;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return iHashCode;
    }

    /* renamed from: k */
    public static C1943p1 m12091k(C1943p1 c1943p1, C1943p1 c1943p12) {
        int i10 = c1943p1.f9237a + c1943p12.f9237a;
        int[] iArrCopyOf = Arrays.copyOf(c1943p1.f9238b, i10);
        System.arraycopy(c1943p12.f9238b, 0, iArrCopyOf, c1943p1.f9237a, c1943p12.f9237a);
        Object[] objArrCopyOf = Arrays.copyOf(c1943p1.f9239c, i10);
        System.arraycopy(c1943p12.f9239c, 0, objArrCopyOf, c1943p1.f9237a, c1943p12.f9237a);
        return new C1943p1(i10, iArrCopyOf, objArrCopyOf, true);
    }

    /* renamed from: l */
    public static C1943p1 m12092l() {
        return new C1943p1();
    }

    /* renamed from: p */
    public static void m12093p(int i10, Object obj, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        int iM12257a = C1958u1.m12257a(i10);
        int iM12258b = C1958u1.m12258b(i10);
        if (iM12258b == 0) {
            interfaceC1961v1.mo12013r(iM12257a, ((Long) obj).longValue());
            return;
        }
        if (iM12258b == 1) {
            interfaceC1961v1.mo12005j(iM12257a, ((Long) obj).longValue());
            return;
        }
        if (iM12258b == 2) {
            interfaceC1961v1.mo11981C(iM12257a, (AbstractC1920i) obj);
            return;
        }
        if (iM12258b != 3) {
            if (iM12258b != 5) {
                throw new RuntimeException(C1903c0.m11505e());
            }
            interfaceC1961v1.mo11999d(iM12257a, ((Integer) obj).intValue());
        } else if (interfaceC1961v1.mo12006k() == InterfaceC1961v1.a.ASCENDING) {
            interfaceC1961v1.mo12017v(iM12257a);
            ((C1943p1) obj).m12102q(interfaceC1961v1);
            interfaceC1961v1.mo11986H(iM12257a);
        } else {
            interfaceC1961v1.mo11986H(iM12257a);
            ((C1943p1) obj).m12102q(interfaceC1961v1);
            interfaceC1961v1.mo12017v(iM12257a);
        }
    }

    /* renamed from: a */
    public void m12094a() {
        if (!this.f9241e) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: b */
    public final void m12095b() {
        int i10 = this.f9237a;
        int[] iArr = this.f9238b;
        if (i10 == iArr.length) {
            int i11 = i10 + (i10 < 4 ? 8 : i10 >> 1);
            this.f9238b = Arrays.copyOf(iArr, i11);
            this.f9239c = Arrays.copyOf(this.f9239c, i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C1943p1)) {
            return false;
        }
        C1943p1 c1943p1 = (C1943p1) obj;
        int i10 = this.f9237a;
        return i10 == c1943p1.f9237a && m12086c(this.f9238b, c1943p1.f9238b, i10) && m12087d(this.f9239c, c1943p1.f9239c, this.f9237a);
    }

    /* renamed from: f */
    public int m12096f() {
        int iM11896X;
        int i10 = this.f9240d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f9237a; i12++) {
            int i13 = this.f9238b[i12];
            int iM12257a = C1958u1.m12257a(i13);
            int iM12258b = C1958u1.m12258b(i13);
            if (iM12258b == 0) {
                iM11896X = AbstractC1929l.m11896X(iM12257a, ((Long) this.f9239c[i12]).longValue());
            } else if (iM12258b == 1) {
                iM11896X = AbstractC1929l.m11914o(iM12257a, ((Long) this.f9239c[i12]).longValue());
            } else if (iM12258b == 2) {
                iM11896X = AbstractC1929l.m11906g(iM12257a, (AbstractC1920i) this.f9239c[i12]);
            } else if (iM12258b == 3) {
                iM11896X = (AbstractC1929l.m11893U(iM12257a) * 2) + ((C1943p1) this.f9239c[i12]).m12096f();
            } else {
                if (iM12258b != 5) {
                    throw new IllegalStateException(C1903c0.m11505e());
                }
                iM11896X = AbstractC1929l.m11912m(iM12257a, ((Integer) this.f9239c[i12]).intValue());
            }
            i11 += iM11896X;
        }
        this.f9240d = i11;
        return i11;
    }

    /* renamed from: g */
    public int m12097g() {
        int i10 = this.f9240d;
        if (i10 != -1) {
            return i10;
        }
        int iM11881I = 0;
        for (int i11 = 0; i11 < this.f9237a; i11++) {
            iM11881I += AbstractC1929l.m11881I(C1958u1.m12257a(this.f9238b[i11]), (AbstractC1920i) this.f9239c[i11]);
        }
        this.f9240d = iM11881I;
        return iM11881I;
    }

    public int hashCode() {
        int i10 = this.f9237a;
        return ((((527 + i10) * 31) + m12089h(this.f9238b, i10)) * 31) + m12090i(this.f9239c, this.f9237a);
    }

    /* renamed from: j */
    public void m12098j() {
        this.f9241e = false;
    }

    /* renamed from: m */
    public final void m12099m(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f9237a; i11++) {
            C1957u0.m12254c(sb2, i10, String.valueOf(C1958u1.m12257a(this.f9238b[i11])), this.f9239c[i11]);
        }
    }

    /* renamed from: n */
    public void m12100n(int i10, Object obj) {
        m12094a();
        m12095b();
        int[] iArr = this.f9238b;
        int i11 = this.f9237a;
        iArr[i11] = i10;
        this.f9239c[i11] = obj;
        this.f9237a = i11 + 1;
    }

    /* renamed from: o */
    public void m12101o(InterfaceC1961v1 interfaceC1961v1) throws IOException {
        if (interfaceC1961v1.mo12006k() == InterfaceC1961v1.a.DESCENDING) {
            for (int i10 = this.f9237a - 1; i10 >= 0; i10--) {
                interfaceC1961v1.mo11998c(C1958u1.m12257a(this.f9238b[i10]), this.f9239c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f9237a; i11++) {
            interfaceC1961v1.mo11998c(C1958u1.m12257a(this.f9238b[i11]), this.f9239c[i11]);
        }
    }

    /* renamed from: q */
    public void m12102q(InterfaceC1961v1 interfaceC1961v1) throws IOException {
        if (this.f9237a == 0) {
            return;
        }
        if (interfaceC1961v1.mo12006k() == InterfaceC1961v1.a.ASCENDING) {
            for (int i10 = 0; i10 < this.f9237a; i10++) {
                m12093p(this.f9238b[i10], this.f9239c[i10], interfaceC1961v1);
            }
            return;
        }
        for (int i11 = this.f9237a - 1; i11 >= 0; i11--) {
            m12093p(this.f9238b[i11], this.f9239c[i11], interfaceC1961v1);
        }
    }

    public C1943p1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f9240d = -1;
        this.f9237a = i10;
        this.f9238b = iArr;
        this.f9239c = objArr;
        this.f9241e = z10;
    }
}
