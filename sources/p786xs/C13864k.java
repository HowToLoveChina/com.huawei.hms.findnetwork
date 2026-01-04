package p786xs;

/* renamed from: xs.k */
/* loaded from: classes8.dex */
public final class C13864k {

    /* renamed from: a */
    public static final int[] f62147a = {16, 8, 4, 2, 1};

    /* renamed from: a */
    public static C13861h m83186a(long j10) {
        long j11 = j10 << 5;
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        int i10 = (((int) (j11 >>> 59)) * 2) + 1;
        boolean z10 = true;
        int i11 = 0;
        for (int i12 = 1; i12 < 13; i12++) {
            int i13 = (int) (j11 >>> 59);
            j11 <<= 5;
            for (int i14 = 0; i14 < 5; i14++) {
                int i15 = f62147a[i14];
                if (z10) {
                    if ((i15 & i13) != 0) {
                        dArr2[0] = (dArr2[0] + dArr2[1]) / 2.0d;
                    } else {
                        dArr2[1] = (dArr2[0] + dArr2[1]) / 2.0d;
                    }
                } else if ((i15 & i13) != 0) {
                    dArr[0] = (dArr[0] + dArr[1]) / 2.0d;
                } else {
                    dArr[1] = (dArr[0] + dArr[1]) / 2.0d;
                }
                z10 = !z10;
                i11++;
                if (i11 >= i10) {
                    break;
                }
            }
            if (i11 >= i10) {
                break;
            }
        }
        return new C13861h((dArr[0] + dArr[1]) / 2.0d, (dArr2[0] + dArr2[1]) / 2.0d);
    }
}
