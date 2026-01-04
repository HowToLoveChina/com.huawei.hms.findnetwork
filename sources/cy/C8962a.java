package cy;

import java.io.EOFException;
import p022ay.C1052b0;
import p022ay.C1054d;
import p022ay.C1067q;
import p692uw.C13267j;

/* renamed from: cy.a */
/* loaded from: classes9.dex */
public final class C8962a {

    /* renamed from: a */
    public static final byte[] f45468a = C1052b0.m6300a("0123456789abcdef");

    /* renamed from: a */
    public static final byte[] m56715a() {
        return f45468a;
    }

    /* renamed from: b */
    public static final String m56716b(C1054d c1054d, long j10) throws EOFException {
        C13267j.m79677e(c1054d, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (c1054d.m6359y(j11) == 13) {
                String strM6320G = c1054d.m6320G(j11);
                c1054d.skip(2L);
                return strM6320G;
            }
        }
        String strM6320G2 = c1054d.m6320G(j10);
        c1054d.skip(1L);
        return strM6320G2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0065, code lost:
    
        if (r19 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0067, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0068, code lost:
    
        return r10;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int m56717c(p022ay.C1054d r17, p022ay.C1067q r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 174
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cy.C8962a.m56717c(ay.d, ay.q, boolean):int");
    }

    /* renamed from: d */
    public static /* synthetic */ int m56718d(C1054d c1054d, C1067q c1067q, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return m56717c(c1054d, c1067q, z10);
    }
}
