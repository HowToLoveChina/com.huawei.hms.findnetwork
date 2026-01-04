package p514o9;

import android.database.Cursor;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

/* renamed from: o9.k */
/* loaded from: classes3.dex */
public class C11837k {
    /* renamed from: a */
    public static void m70678a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: b */
    public static void m70679b(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e("IOUtil", "closeSecure IOException");
            }
        }
    }

    /* renamed from: c */
    public static void m70680c(InputStream inputStream) throws IOException {
        m70679b(inputStream);
    }

    /* renamed from: d */
    public static void m70681d(OutputStream outputStream) throws IOException {
        m70679b(outputStream);
    }

    /* renamed from: e */
    public static void m70682e(Reader reader) throws IOException {
        m70679b(reader);
    }
}
