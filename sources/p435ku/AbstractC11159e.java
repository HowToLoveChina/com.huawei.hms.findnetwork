package p435ku;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ku.e */
/* loaded from: classes5.dex */
public abstract class AbstractC11159e {
    /* renamed from: a */
    public static void m67090a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C11160f.m67095d("IOUtil", "closeSecure IOException");
            }
        }
    }

    /* renamed from: b */
    public static void m67091b(InputStream inputStream) throws IOException {
        m67090a(inputStream);
    }
}
