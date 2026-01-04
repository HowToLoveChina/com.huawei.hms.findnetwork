package ax;

import p790xw.C13879h;

/* renamed from: ax.b */
/* loaded from: classes9.dex */
public class C1032b {
    /* renamed from: a */
    public static int m6238a(int i10) {
        if (new C13879h(2, 36).m83222f(i10)) {
            return i10;
        }
        throw new IllegalArgumentException("radix " + i10 + " was not in valid range " + new C13879h(2, 36));
    }

    /* renamed from: b */
    public static final int m6239b(char c10, int i10) {
        return Character.digit((int) c10, i10);
    }
}
