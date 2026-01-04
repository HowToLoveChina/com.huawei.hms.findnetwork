package ly;

/* renamed from: ly.g */
/* loaded from: classes9.dex */
public class C11373g {
    /* renamed from: a */
    public static int m68222a(int i10, long j10) {
        try {
            return Math.addExact(i10, Math.toIntExact(j10));
        } catch (ArithmeticException e10) {
            throw new IllegalArgumentException("Argument too large or result overflows", e10);
        }
    }
}
