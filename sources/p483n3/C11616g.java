package p483n3;

import p468m3.C11397c;

/* renamed from: n3.g */
/* loaded from: classes.dex */
public final class C11616g {
    /* renamed from: a */
    public static int m69398a(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 40);
        sb2.append(str);
        sb2.append(" cannot be negative but was: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* renamed from: b */
    public static void m69399b(boolean z10) {
        C11397c.m68311h(z10, "no calls to next() since the last call to remove()");
    }
}
