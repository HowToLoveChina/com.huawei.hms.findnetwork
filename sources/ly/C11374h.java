package ly;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ly.h */
/* loaded from: classes9.dex */
public class C11374h extends OutputStream implements WritableByteChannel {

    /* renamed from: a */
    public final WritableByteChannel f53101a;

    /* renamed from: b */
    public final int f53102b;

    /* renamed from: c */
    public final ByteBuffer f53103c;

    /* renamed from: d */
    public final AtomicBoolean f53104d = new AtomicBoolean();

    /* renamed from: ly.h$b */
    public static final class b implements WritableByteChannel {

        /* renamed from: a */
        public final OutputStream f53105a;

        /* renamed from: b */
        public final AtomicBoolean f53106b;

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f53106b.compareAndSet(false, true)) {
                this.f53105a.close();
            }
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return !this.f53106b.get();
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer byteBuffer) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!byteBuffer.hasArray()) {
                throw new IOException("Direct buffer somehow written to BufferAtATimeOutputChannel");
            }
            try {
                int iPosition = byteBuffer.position();
                int iLimit = byteBuffer.limit() - iPosition;
                this.f53105a.write(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, iLimit);
                byteBuffer.position(byteBuffer.limit());
                return iLimit;
            } catch (IOException e10) {
                try {
                    close();
                } catch (IOException unused) {
                }
                throw e10;
            }
        }

        public b(OutputStream outputStream) {
            this.f53106b = new AtomicBoolean();
            this.f53105a = outputStream;
        }
    }

    public C11374h(OutputStream outputStream, int i10) {
        if (outputStream instanceof FileOutputStream) {
            this.f53101a = ((FileOutputStream) outputStream).getChannel();
            this.f53103c = ByteBuffer.allocateDirect(i10);
        } else {
            this.f53101a = new b(outputStream);
            this.f53103c = ByteBuffer.allocate(i10);
        }
        this.f53102b = i10;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.f53104d.compareAndSet(false, true)) {
            try {
                m68223s();
            } finally {
                this.f53101a.close();
            }
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        if (!this.f53101a.isOpen()) {
            this.f53104d.set(true);
        }
        return !this.f53104d.get();
    }

    /* renamed from: s */
    public void m68223s() throws IOException {
        if (this.f53103c.position() != 0) {
            m68225u();
            m68226v();
        }
    }

    /* renamed from: t */
    public final void m68224t() throws IOException {
        if (this.f53103c.hasRemaining()) {
            return;
        }
        m68226v();
    }

    /* renamed from: u */
    public final void m68225u() {
        this.f53103c.order(ByteOrder.nativeOrder());
        int iRemaining = this.f53103c.remaining();
        if (iRemaining > 8) {
            int iPosition = this.f53103c.position() & 7;
            if (iPosition != 0) {
                int i10 = 8 - iPosition;
                for (int i11 = 0; i11 < i10; i11++) {
                    this.f53103c.put((byte) 0);
                }
                iRemaining -= i10;
            }
            while (iRemaining >= 8) {
                this.f53103c.putLong(0L);
                iRemaining -= 8;
            }
        }
        while (this.f53103c.hasRemaining()) {
            this.f53103c.put((byte) 0);
        }
    }

    /* renamed from: v */
    public final void m68226v() throws IOException {
        this.f53103c.flip();
        int iWrite = this.f53101a.write(this.f53103c);
        boolean zHasRemaining = this.f53103c.hasRemaining();
        int i10 = this.f53102b;
        if (iWrite != i10 || zHasRemaining) {
            throw new IOException(String.format("Failed to write %,d bytes atomically. Only wrote  %,d", Integer.valueOf(i10), Integer.valueOf(iWrite)));
        }
        this.f53103c.clear();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        while (i11 > 0) {
            int iMin = Math.min(i11, this.f53103c.remaining());
            this.f53103c.put(bArr, i10, iMin);
            m68224t();
            i11 -= iMin;
            i10 += iMin;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        int i10;
        if (isOpen()) {
            int iRemaining = byteBuffer.remaining();
            if (iRemaining < this.f53103c.remaining()) {
                this.f53103c.put(byteBuffer);
            } else {
                int iLimit = byteBuffer.limit();
                if (this.f53103c.position() != 0) {
                    int iRemaining2 = this.f53103c.remaining();
                    byteBuffer.limit(byteBuffer.position() + iRemaining2);
                    this.f53103c.put(byteBuffer);
                    m68226v();
                    i10 = iRemaining - iRemaining2;
                } else {
                    i10 = iRemaining;
                }
                while (i10 >= this.f53102b) {
                    byteBuffer.limit(byteBuffer.position() + this.f53102b);
                    this.f53101a.write(byteBuffer);
                    i10 -= this.f53102b;
                }
                byteBuffer.limit(iLimit);
                this.f53103c.put(byteBuffer);
            }
            return iRemaining;
        }
        throw new ClosedChannelException();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        if (isOpen()) {
            this.f53103c.put((byte) i10);
            m68224t();
            return;
        }
        throw new ClosedChannelException();
    }
}
