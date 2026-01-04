package gu;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: gu.f */
/* loaded from: classes5.dex */
public class C10052f {
    /* renamed from: a */
    public static void m62487a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C10053g.m62491c("IOUtil", "closeSecure IOException");
            }
        }
    }

    /* renamed from: b */
    public static void m62488b(InputStream inputStream) throws IOException {
        m62487a(inputStream);
    }
}
