package p461lw;

/* renamed from: lw.b */
/* loaded from: classes9.dex */
public class C11352b {
    /* renamed from: a */
    public static <T extends Comparable<?>> int m68162a(T t10, T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }
}
