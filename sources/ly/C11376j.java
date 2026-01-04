package ly;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.LinkOption;
import my.C11562e;

/* renamed from: ly.j */
/* loaded from: classes9.dex */
public final class C11376j {

    /* renamed from: a */
    public static final LinkOption[] f53107a = new LinkOption[0];

    @Deprecated
    /* renamed from: a */
    public static void m68227a(Closeable closeable) throws IOException {
        C11562e.m69026g(closeable);
    }

    /* renamed from: b */
    public static int m68228b(InputStream inputStream, byte[] bArr) throws IOException {
        return m68229c(inputStream, bArr, 0, bArr.length);
    }

    /* renamed from: c */
    public static int m68229c(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        if (i11 < 0 || i10 < 0 || (i12 = i11 + i10) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        return C11562e.m69034o(inputStream, bArr, i10, i11);
    }

    /* renamed from: d */
    public static void m68230d(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        if (C11562e.m69035p(readableByteChannel, byteBuffer) < byteBuffer.remaining()) {
            throw new EOFException();
        }
    }

    /* renamed from: e */
    public static byte[] m68231e(InputStream inputStream, int i10) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C11562e.m69028i(inputStream, byteArrayOutputStream, 0L, i10);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: f */
    public static long m68232f(InputStream inputStream, long j10) throws IOException {
        return C11562e.m69038s(inputStream, j10, new C11375i());
    }
}
