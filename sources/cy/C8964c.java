package cy;

import p022ay.C1073w;
import p692uw.C13267j;

/* renamed from: cy.c */
/* loaded from: classes9.dex */
public final class C8964c {
    /* renamed from: a */
    public static final int m56725a(int[] iArr, int i10, int i11, int i12) {
        C13267j.m79677e(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    /* renamed from: b */
    public static final int m56726b(C1073w c1073w, int i10) {
        C13267j.m79677e(c1073w, "<this>");
        int iM56725a = m56725a(c1073w.m6443K(), i10 + 1, 0, c1073w.m6444L().length);
        return iM56725a >= 0 ? iM56725a : ~iM56725a;
    }
}
