package ly;

import java.io.IOException;

/* renamed from: ly.k */
/* loaded from: classes9.dex */
public final class C11377k {
    /* renamed from: a */
    public static int m68233a(String str) throws IOException {
        return m68234b(str, 10);
    }

    /* renamed from: b */
    public static int m68234b(String str, int i10) throws IOException {
        try {
            return Integer.parseInt(str, i10);
        } catch (NumberFormatException unused) {
            throw new IOException("Unable to parse int from string value: " + str);
        }
    }

    /* renamed from: c */
    public static long m68235c(String str) throws IOException {
        return m68236d(str, 10);
    }

    /* renamed from: d */
    public static long m68236d(String str, int i10) throws IOException {
        try {
            return Long.parseLong(str, i10);
        } catch (NumberFormatException unused) {
            throw new IOException("Unable to parse long from string value: " + str);
        }
    }
}
