package my;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import ly.C11375i;
import p538oy.InterfaceC12057a;
import p538oy.InterfaceC12058b;

/* renamed from: my.e */
/* loaded from: classes9.dex */
public class C11562e {

    /* renamed from: a */
    public static final char f53608a = File.separatorChar;

    /* renamed from: b */
    public static final byte[] f53609b = new byte[0];

    /* renamed from: c */
    @Deprecated
    public static final String f53610c = System.lineSeparator();

    /* renamed from: d */
    public static final String f53611d = EnumC11563f.LF.m69041e();

    /* renamed from: e */
    public static final String f53612e = EnumC11563f.CRLF.m69041e();

    /* renamed from: f */
    public static final ThreadLocal<byte[]> f53613f = ThreadLocal.withInitial(new C11375i());

    /* renamed from: g */
    public static final byte[] f53614g = m69021b();

    /* renamed from: h */
    public static final ThreadLocal<char[]> f53615h = ThreadLocal.withInitial(new Supplier() { // from class: my.d
        @Override // java.util.function.Supplier
        public final Object get() {
            return C11562e.m69023d();
        }
    });

    /* renamed from: i */
    public static final char[] f53616i = m69023d();

    /* renamed from: b */
    public static byte[] m69021b() {
        return m69022c(8192);
    }

    /* renamed from: c */
    public static byte[] m69022c(int i10) {
        return new byte[i10];
    }

    /* renamed from: d */
    public static char[] m69023d() {
        return m69024e(8192);
    }

    /* renamed from: e */
    public static char[] m69024e(int i10) {
        return new char[i10];
    }

    /* renamed from: f */
    public static void m69025f(Closeable closeable, InterfaceC12057a<IOException> interfaceC12057a) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                if (interfaceC12057a != null) {
                    interfaceC12057a.accept(e10);
                }
            }
        }
    }

    /* renamed from: g */
    public static void m69026g(Closeable closeable) throws IOException {
        m69027h(closeable, null);
    }

    /* renamed from: h */
    public static void m69027h(Closeable closeable, Consumer<IOException> consumer) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                if (consumer != null) {
                    consumer.accept(e10);
                }
            }
        }
    }

    /* renamed from: i */
    public static long m69028i(InputStream inputStream, OutputStream outputStream, long j10, long j11) throws IOException {
        return m69029j(inputStream, outputStream, j10, j11, m69031l());
    }

    /* renamed from: j */
    public static long m69029j(InputStream inputStream, OutputStream outputStream, long j10, long j11, byte[] bArr) throws IOException {
        long j12 = 0;
        if (j10 > 0) {
            m69039t(inputStream, j10);
        }
        if (j11 == 0) {
            return 0L;
        }
        int length = bArr.length;
        int iMin = (j11 <= 0 || j11 >= ((long) length)) ? length : (int) j11;
        while (iMin > 0) {
            int i10 = inputStream.read(bArr, 0, iMin);
            if (-1 == i10) {
                break;
            }
            outputStream.write(bArr, 0, i10);
            j12 += i10;
            if (j11 > 0) {
                iMin = (int) Math.min(j11 - j12, length);
            }
        }
        return j12;
    }

    /* renamed from: k */
    public static byte[] m69030k(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        return bArr;
    }

    /* renamed from: l */
    public static byte[] m69031l() {
        return m69030k(f53613f.get());
    }

    /* renamed from: m */
    public static byte[] m69032m() {
        return m69030k(f53614g);
    }

    /* renamed from: n */
    public static int m69033n(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    /* renamed from: o */
    public static int m69034o(final InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        Objects.requireNonNull(inputStream);
        return m69036q(new InterfaceC12058b() { // from class: my.b
            @Override // p538oy.InterfaceC12058b
            /* renamed from: a */
            public final Object mo69019a(Object obj, Object obj2, Object obj3) {
                return Integer.valueOf(inputStream.read((byte[]) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue()));
            }
        }, bArr, i10, i11);
    }

    /* renamed from: p */
    public static int m69035p(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        while (byteBuffer.remaining() > 0 && -1 != readableByteChannel.read(byteBuffer)) {
        }
        return iRemaining - byteBuffer.remaining();
    }

    /* renamed from: q */
    public static int m69036q(InterfaceC12058b<byte[], Integer, Integer, Integer> interfaceC12058b, byte[] bArr, int i10, int i11) throws IOException {
        if (i11 < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + i11);
        }
        int i12 = i11;
        while (i12 > 0) {
            int iIntValue = interfaceC12058b.mo69019a(bArr, Integer.valueOf((i11 - i12) + i10), Integer.valueOf(i12)).intValue();
            if (-1 == iIntValue) {
                break;
            }
            i12 -= iIntValue;
        }
        return i11 - i12;
    }

    /* renamed from: r */
    public static long m69037r(InputStream inputStream, long j10) throws IOException {
        return m69038s(inputStream, j10, new C11560c());
    }

    /* renamed from: s */
    public static long m69038s(InputStream inputStream, long j10, Supplier<byte[]> supplier) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j10);
        }
        long j11 = j10;
        while (j11 > 0) {
            long j12 = inputStream.read(supplier.get(), 0, (int) Math.min(j11, r4.length));
            if (j12 < 0) {
                break;
            }
            j11 -= j12;
        }
        return j10 - j11;
    }

    /* renamed from: t */
    public static void m69039t(InputStream inputStream, long j10) throws IOException {
        long jM69038s = m69038s(inputStream, j10, new C11560c());
        if (jM69038s == j10) {
            return;
        }
        throw new EOFException("Bytes to skip: " + j10 + " actual: " + jM69038s);
    }
}
