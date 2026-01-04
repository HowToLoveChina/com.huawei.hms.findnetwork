package ax;

/* renamed from: ax.c */
/* loaded from: classes9.dex */
public class C1033c extends C1032b {
    /* renamed from: c */
    public static final boolean m6240c(char c10, char c11, boolean z10) {
        if (c10 == c11) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c10);
        char upperCase2 = Character.toUpperCase(c11);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}
