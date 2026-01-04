package p022ay;

import cy.C8964c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kw.C11175g;
import p692uw.C13267j;

/* renamed from: ay.w */
/* loaded from: classes9.dex */
public final class C1073w extends C1057g {

    /* renamed from: f */
    public final transient byte[][] f5179f;

    /* renamed from: g */
    public final transient int[] f5180g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1073w(byte[][] bArr, int[] iArr) {
        super(C1057g.f5136e.m6380q());
        C13267j.m79677e(bArr, "segments");
        C13267j.m79677e(iArr, "directory");
        this.f5179f = bArr;
        this.f5180g = iArr;
    }

    private final Object writeReplace() {
        C1057g c1057gM6445M = m6445M();
        C13267j.m79675c(c1057gM6445M, "null cannot be cast to non-null type java.lang.Object");
        return c1057gM6445M;
    }

    @Override // p022ay.C1057g
    /* renamed from: G */
    public C1057g mo6372G() {
        return m6445M().mo6372G();
    }

    @Override // p022ay.C1057g
    /* renamed from: H */
    public byte[] mo6373H() {
        byte[] bArr = new byte[m6370E()];
        int length = m6444L().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = m6443K()[length + i10];
            int i14 = m6443K()[i10];
            int i15 = i14 - i11;
            C11175g.m67143c(m6444L()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // p022ay.C1057g
    /* renamed from: J */
    public void mo6375J(C1054d c1054d, int i10, int i11) {
        C13267j.m79677e(c1054d, "buffer");
        int i12 = i10 + i11;
        int iM56726b = C8964c.m56726b(this, i10);
        while (i10 < i12) {
            int i13 = iM56726b == 0 ? 0 : m6443K()[iM56726b - 1];
            int i14 = m6443K()[iM56726b] - i13;
            int i15 = m6443K()[m6444L().length + iM56726b];
            int iMin = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            C1071u c1071u = new C1071u(m6444L()[iM56726b], i16, i16 + iMin, true, false);
            C1071u c1071u2 = c1054d.f5125a;
            if (c1071u2 == null) {
                c1071u.f5173g = c1071u;
                c1071u.f5172f = c1071u;
                c1054d.f5125a = c1071u;
            } else {
                C13267j.m79674b(c1071u2);
                C1071u c1071u3 = c1071u2.f5173g;
                C13267j.m79674b(c1071u3);
                c1071u3.m6436c(c1071u);
            }
            i10 += iMin;
            iM56726b++;
        }
        c1054d.m6321H(c1054d.m6322J() + i11);
    }

    /* renamed from: K */
    public final int[] m6443K() {
        return this.f5180g;
    }

    /* renamed from: L */
    public final byte[][] m6444L() {
        return this.f5179f;
    }

    /* renamed from: M */
    public final C1057g m6445M() {
        return new C1057g(mo6373H());
    }

    @Override // p022ay.C1057g
    /* renamed from: b */
    public String mo6376b() {
        return m6445M().mo6376b();
    }

    @Override // p022ay.C1057g
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1057g) {
            C1057g c1057g = (C1057g) obj;
            if (c1057g.m6370E() == m6370E() && mo6387y(0, c1057g, 0, m6370E())) {
                return true;
            }
        }
        return false;
    }

    @Override // p022ay.C1057g
    /* renamed from: h */
    public C1057g mo6378h(String str) throws NoSuchAlgorithmException {
        C13267j.m79677e(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = m6444L().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = m6443K()[length + i10];
            int i13 = m6443K()[i10];
            messageDigest.update(m6444L()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] bArrDigest = messageDigest.digest();
        C13267j.m79676d(bArrDigest, "digestBytes");
        return new C1057g(bArrDigest);
    }

    @Override // p022ay.C1057g
    public int hashCode() {
        int iM6381r = m6381r();
        if (iM6381r != 0) {
            return iM6381r;
        }
        int length = m6444L().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = m6443K()[length + i10];
            int i14 = m6443K()[i10];
            byte[] bArr = m6444L()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        m6366A(i11);
        return i11;
    }

    @Override // p022ay.C1057g
    /* renamed from: s */
    public int mo6382s() {
        return m6443K()[m6444L().length - 1];
    }

    @Override // p022ay.C1057g
    public String toString() {
        return m6445M().toString();
    }

    @Override // p022ay.C1057g
    /* renamed from: u */
    public String mo6384u() {
        return m6445M().mo6384u();
    }

    @Override // p022ay.C1057g
    /* renamed from: v */
    public byte[] mo6385v() {
        return mo6373H();
    }

    @Override // p022ay.C1057g
    /* renamed from: w */
    public byte mo6386w(int i10) {
        C1051b.m6294b(m6443K()[m6444L().length - 1], i10, 1L);
        int iM56726b = C8964c.m56726b(this, i10);
        return m6444L()[iM56726b][(i10 - (iM56726b == 0 ? 0 : m6443K()[iM56726b - 1])) + m6443K()[m6444L().length + iM56726b]];
    }

    @Override // p022ay.C1057g
    /* renamed from: y */
    public boolean mo6387y(int i10, C1057g c1057g, int i11, int i12) {
        C13267j.m79677e(c1057g, "other");
        if (i10 < 0 || i10 > m6370E() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iM56726b = C8964c.m56726b(this, i10);
        while (i10 < i13) {
            int i14 = iM56726b == 0 ? 0 : m6443K()[iM56726b - 1];
            int i15 = m6443K()[iM56726b] - i14;
            int i16 = m6443K()[m6444L().length + iM56726b];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!c1057g.mo6388z(i11, m6444L()[iM56726b], i16 + (i10 - i14), iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iM56726b++;
        }
        return true;
    }

    @Override // p022ay.C1057g
    /* renamed from: z */
    public boolean mo6388z(int i10, byte[] bArr, int i11, int i12) {
        C13267j.m79677e(bArr, "other");
        if (i10 < 0 || i10 > m6370E() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iM56726b = C8964c.m56726b(this, i10);
        while (i10 < i13) {
            int i14 = iM56726b == 0 ? 0 : m6443K()[iM56726b - 1];
            int i15 = m6443K()[iM56726b] - i14;
            int i16 = m6443K()[m6444L().length + iM56726b];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!C1051b.m6293a(m6444L()[iM56726b], i16 + (i10 - i14), bArr, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iM56726b++;
        }
        return true;
    }
}
