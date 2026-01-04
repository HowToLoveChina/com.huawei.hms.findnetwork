package p565q3;

import p468m3.C11397c;

/* renamed from: q3.a */
/* loaded from: classes.dex */
public final class C12277a extends AbstractC12278b {
    /* renamed from: a */
    public static int m73801a(long j10) {
        int i10 = (int) j10;
        C11397c.m68308e(((long) i10) == j10, "Out of range: %s", j10);
        return i10;
    }

    /* renamed from: b */
    public static int m73802b(int i10, int i11, int i12) {
        C11397c.m68307d(i11 <= i12, "min (%s) must be less than or equal to max (%s)", i11, i12);
        return Math.min(Math.max(i10, i11), i12);
    }
}
