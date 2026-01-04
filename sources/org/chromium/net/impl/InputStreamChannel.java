package org.chromium.net.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes9.dex */
final class InputStreamChannel implements ReadableByteChannel {
    private static final int MAX_TMP_BUFFER_SIZE = 16384;
    private static final int MIN_TMP_BUFFER_SIZE = 4096;
    private final InputStream mInputStream;
    private final AtomicBoolean mIsOpen = new AtomicBoolean(true);

    private InputStreamChannel(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public static ReadableByteChannel wrap(InputStream inputStream) {
        return inputStream instanceof FileInputStream ? ((FileInputStream) inputStream).getChannel() : new InputStreamChannel(inputStream);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mIsOpen.compareAndSet(true, false)) {
            this.mInputStream.close();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        int i10;
        if (byteBuffer.hasArray()) {
            i10 = this.mInputStream.read(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            if (i10 > 0) {
                byteBuffer.position(byteBuffer.position() + i10);
            }
        } else {
            byte[] bArr = new byte[Math.min(16384, Math.min(Math.max(this.mInputStream.available(), 4096), byteBuffer.remaining()))];
            i10 = this.mInputStream.read(bArr);
            if (i10 > 0) {
                byteBuffer.put(bArr, 0, i10);
            }
        }
        return i10;
    }
}
