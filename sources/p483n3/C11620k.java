package p483n3;

/* renamed from: n3.k */
/* loaded from: classes.dex */
public final class C11620k {
    /* renamed from: a */
    public static int m69467a(int i10, double d10) {
        int iMax = Math.max(i10, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d10 * iHighestOneBit))) {
            return iHighestOneBit;
        }
        int i11 = iHighestOneBit << 1;
        if (i11 > 0) {
            return i11;
        }
        return 1073741824;
    }

    /* renamed from: b */
    public static int m69468b(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * (-862048943)), 15) * 461845907);
    }

    /* renamed from: c */
    public static int m69469c(Object obj) {
        return m69468b(obj == null ? 0 : obj.hashCode());
    }
}
