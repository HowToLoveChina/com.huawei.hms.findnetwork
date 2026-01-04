package p695v0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* renamed from: v0.c */
/* loaded from: classes.dex */
public class C13315c {
    /* renamed from: a */
    public static int m79813a(int i10) {
        return ((i10 + 7) & (-8)) / 8;
    }

    /* renamed from: b */
    public static byte[] m79814b(byte[] bArr) throws IOException {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th2) {
            deflater.end();
            throw th2;
        }
    }

    /* renamed from: c */
    public static RuntimeException m79815c(String str) {
        return new IllegalStateException(str);
    }

    /* renamed from: d */
    public static byte[] m79816d(InputStream inputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int i12 = inputStream.read(bArr, i11, i10 - i11);
            if (i12 < 0) {
                throw m79815c("Not enough bytes to read: " + i10);
            }
            i11 += i12;
        }
        return bArr;
    }

    /* renamed from: e */
    public static byte[] m79817e(InputStream inputStream, int i10, int i11) throws IOException {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i11];
            byte[] bArr2 = new byte[2048];
            int i12 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i12 < i10) {
                int i13 = inputStream.read(bArr2);
                if (i13 < 0) {
                    throw m79815c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i10 + " bytes");
                }
                inflater.setInput(bArr2, 0, i13);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i11 - iInflate);
                    i12 += i13;
                } catch (DataFormatException e10) {
                    throw m79815c(e10.getMessage());
                }
            }
            if (i12 == i10) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw m79815c("Inflater did not finish");
            }
            throw m79815c("Didn't read enough bytes during decompression. expected=" + i10 + " actual=" + i12);
        } finally {
            inflater.end();
        }
    }

    /* renamed from: f */
    public static String m79818f(InputStream inputStream, int i10) throws IOException {
        return new String(m79816d(inputStream, i10), StandardCharsets.UTF_8);
    }

    /* renamed from: g */
    public static long m79819g(InputStream inputStream, int i10) throws IOException {
        byte[] bArrM79816d = m79816d(inputStream, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 += (bArrM79816d[i11] & 255) << (i11 * 8);
        }
        return j10;
    }

    /* renamed from: h */
    public static int m79820h(InputStream inputStream) throws IOException {
        return (int) m79819g(inputStream, 2);
    }

    /* renamed from: i */
    public static long m79821i(InputStream inputStream) throws IOException {
        return m79819g(inputStream, 4);
    }

    /* renamed from: j */
    public static int m79822j(InputStream inputStream) throws IOException {
        return (int) m79819g(inputStream, 1);
    }

    /* renamed from: k */
    public static int m79823k(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    /* renamed from: l */
    public static void m79824l(InputStream inputStream, OutputStream outputStream, FileLock fileLock) throws IOException {
        if (fileLock == null || !fileLock.isValid()) {
            throw new IOException("Unable to acquire a lock on the underlying file channel.");
        }
        byte[] bArr = new byte[512];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i10);
            }
        }
    }

    /* renamed from: m */
    public static void m79825m(OutputStream outputStream, byte[] bArr) throws IOException {
        m79829q(outputStream, bArr.length);
        byte[] bArrM79814b = m79814b(bArr);
        m79829q(outputStream, bArrM79814b.length);
        outputStream.write(bArrM79814b);
    }

    /* renamed from: n */
    public static void m79826n(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: o */
    public static void m79827o(OutputStream outputStream, long j10, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) ((j10 >> (i11 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    /* renamed from: p */
    public static void m79828p(OutputStream outputStream, int i10) throws IOException {
        m79827o(outputStream, i10, 2);
    }

    /* renamed from: q */
    public static void m79829q(OutputStream outputStream, long j10) throws IOException {
        m79827o(outputStream, j10, 4);
    }

    /* renamed from: r */
    public static void m79830r(OutputStream outputStream, int i10) throws IOException {
        m79827o(outputStream, i10, 1);
    }
}
