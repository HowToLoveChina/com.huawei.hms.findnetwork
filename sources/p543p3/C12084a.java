package p543p3;

import com.google.flatbuffers.reflection.BaseType;
import java.math.RoundingMode;
import p468m3.C11397c;

/* renamed from: p3.a */
/* loaded from: classes.dex */
public final class C12084a {

    /* renamed from: a */
    public static final byte[] f55912a = {BaseType.MaxBaseType, BaseType.Vector64, BaseType.Vector64, BaseType.Vector64, BaseType.Vector64, BaseType.Array, BaseType.Array, BaseType.Array, BaseType.Union, BaseType.Union, BaseType.Union, BaseType.Obj, BaseType.Obj, BaseType.Obj, BaseType.Obj, BaseType.Vector, BaseType.Vector, BaseType.Vector, 13, 13, 13, BaseType.Double, BaseType.Double, BaseType.Double, BaseType.Double, BaseType.Float, BaseType.Float, BaseType.Float, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* renamed from: b */
    public static final long[] f55913b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: c */
    public static final long[] f55914c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: d */
    public static final long[] f55915d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: e */
    public static final int[] f55916e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* renamed from: f */
    public static final int[] f55917f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: g */
    public static final long[][] f55918g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* renamed from: p3.a$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f55919a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f55919a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f55919a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f55919a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f55919a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f55919a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f55919a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f55919a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f55919a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: a */
    public static long m72252a(long j10, long j11, RoundingMode roundingMode) {
        C11397c.m68310g(roundingMode);
        long j12 = j10 / j11;
        long j13 = j10 - (j11 * j12);
        if (j13 == 0) {
            return j12;
        }
        int i10 = ((int) ((j10 ^ j11) >> 63)) | 1;
        switch (a.f55919a[roundingMode.ordinal()]) {
            case 1:
                C12085b.m72253a(j13 == 0);
                return j12;
            case 2:
                return j12;
            case 3:
                if (i10 >= 0) {
                    return j12;
                }
                break;
            case 4:
                break;
            case 5:
                if (i10 <= 0) {
                    return j12;
                }
                break;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j13);
                long jAbs2 = jAbs - (Math.abs(j11) - jAbs);
                if (jAbs2 == 0) {
                    if (!((((1 & j12) != 0) & (roundingMode == RoundingMode.HALF_EVEN)) | (roundingMode == RoundingMode.HALF_UP))) {
                        return j12;
                    }
                } else if (jAbs2 <= 0) {
                    return j12;
                }
                break;
            default:
                throw new AssertionError();
        }
        return j12 + i10;
    }
}
