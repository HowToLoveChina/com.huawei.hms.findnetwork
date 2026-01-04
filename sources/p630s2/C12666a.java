package p630s2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: s2.a */
/* loaded from: classes.dex */
public final class C12666a {

    /* renamed from: a */
    public static final AtomicReference<byte[]> f58161a = new AtomicReference<>();

    /* renamed from: s2.a$b */
    public static final class b {

        /* renamed from: a */
        public final int f58164a;

        /* renamed from: b */
        public final int f58165b;

        /* renamed from: c */
        public final byte[] f58166c;

        public b(byte[] bArr, int i10, int i11) {
            this.f58166c = bArr;
            this.f58164a = i10;
            this.f58165b = i11;
        }
    }

    /* renamed from: a */
    public static ByteBuffer m76246a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return mappedByteBufferLoad;
            } catch (Throwable th2) {
                th = th2;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    /* renamed from: b */
    public static ByteBuffer m76247b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f58161a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i10 = inputStream.read(andSet);
            if (i10 < 0) {
                f58161a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return m76249d(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
            byteArrayOutputStream.write(andSet, 0, i10);
        }
    }

    /* renamed from: c */
    public static b m76248c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    /* renamed from: d */
    public static ByteBuffer m76249d(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    /* renamed from: e */
    public static byte[] m76250e(ByteBuffer byteBuffer) {
        b bVarM76248c = m76248c(byteBuffer);
        if (bVarM76248c != null && bVarM76248c.f58164a == 0 && bVarM76248c.f58165b == bVarM76248c.f58166c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        m76249d(byteBufferAsReadOnlyBuffer);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: f */
    public static void m76251f(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        m76249d(byteBuffer);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            channel = randomAccessFile.getChannel();
            channel.write(byteBuffer);
            channel.force(false);
            channel.close();
            randomAccessFile.close();
            try {
                channel.close();
            } catch (IOException unused) {
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile == null) {
                throw th;
            }
            try {
                randomAccessFile.close();
                throw th;
            } catch (IOException unused4) {
                throw th;
            }
        }
    }

    /* renamed from: g */
    public static InputStream m76252g(ByteBuffer byteBuffer) {
        return new a(byteBuffer);
    }

    /* renamed from: s2.a$a */
    public static class a extends InputStream {

        /* renamed from: a */
        public final ByteBuffer f58162a;

        /* renamed from: b */
        public int f58163b = -1;

        public a(ByteBuffer byteBuffer) {
            this.f58162a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f58162a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i10) {
            this.f58163b = this.f58162a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f58162a.hasRemaining()) {
                return this.f58162a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i10 = this.f58163b;
            if (i10 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f58162a.position(i10);
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            if (!this.f58162a.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j10, available());
            this.f58162a.position((int) (r2.position() + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            if (!this.f58162a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i11, available());
            this.f58162a.get(bArr, i10, iMin);
            return iMin;
        }
    }
}
