package com.huawei.hiar;

import android.graphics.Rect;
import android.media.Image;
import com.huawei.hiar.exceptions.ARFatalException;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class ARImage extends AbstractC4843a {
    private static final int ERROR_CODE_INT = -1;
    private static final long ERROR_CODE_LONG = -1;
    private long nativeHandle;

    /* renamed from: com.huawei.hiar.ARImage$a */
    public class C4828a extends AbstractC4844b {

        /* renamed from: a */
        public final long f22014a;

        /* renamed from: b */
        public final int f22015b;

        public C4828a(long j10, int i10) {
            this.f22014a = j10;
            this.f22015b = i10;
        }

        @Override // android.media.Image.Plane
        public final ByteBuffer getBuffer() {
            return ARImage.this.nativeGetBuffer(this.f22014a, this.f22015b).asReadOnlyBuffer();
        }

        @Override // android.media.Image.Plane
        public final int getPixelStride() {
            int iNativeGetPixelStride = ARImage.this.nativeGetPixelStride(this.f22014a, this.f22015b);
            if (iNativeGetPixelStride != -1) {
                return iNativeGetPixelStride;
            }
            throw new ARFatalException("Unknown error in ArImage.Plane.getPixelStride().");
        }

        @Override // android.media.Image.Plane
        public final int getRowStride() {
            int iNativeGetRowStride = ARImage.this.nativeGetRowStride(this.f22014a, this.f22015b);
            if (iNativeGetRowStride != -1) {
                return iNativeGetRowStride;
            }
            throw new ARFatalException("Unknown error in ArImage.Plane.getRowStride().");
        }
    }

    public ARImage(long j10) {
        this.nativeHandle = j10;
    }

    private native void nativeClose(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public native ByteBuffer nativeGetBuffer(long j10, int i10);

    private native int nativeGetFormat(long j10);

    private native int nativeGetHeight(long j10);

    private native int nativeGetNumberOfPlanes(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetPixelStride(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetRowStride(long j10, int i10);

    private native long nativeGetTimestamp(long j10);

    private native int nativeGetWidth(long j10);

    @Override // android.media.Image, java.lang.AutoCloseable
    public void close() {
        nativeClose(this.nativeHandle);
        this.nativeHandle = 0L;
    }

    @Override // android.media.Image
    public Rect getCropRect() {
        throw new UnsupportedOperationException("Crop rect is unknown in this image.");
    }

    @Override // android.media.Image
    public int getFormat() {
        int iNativeGetFormat = nativeGetFormat(this.nativeHandle);
        if (iNativeGetFormat != -1) {
            return iNativeGetFormat;
        }
        throw new ARFatalException("Unknown error in ArImage.getFormat().");
    }

    @Override // android.media.Image
    public int getHeight() {
        int iNativeGetHeight = nativeGetHeight(this.nativeHandle);
        if (iNativeGetHeight != -1) {
            return iNativeGetHeight;
        }
        throw new ARFatalException("Unknown error in ArImage.getHeight().");
    }

    @Override // android.media.Image
    public Image.Plane[] getPlanes() {
        int iNativeGetNumberOfPlanes = nativeGetNumberOfPlanes(this.nativeHandle);
        if (iNativeGetNumberOfPlanes == -1) {
            throw new ARFatalException("Unknown error in ArImage.getPlanes().");
        }
        C4828a[] c4828aArr = new C4828a[iNativeGetNumberOfPlanes];
        for (int i10 = 0; i10 < iNativeGetNumberOfPlanes; i10++) {
            c4828aArr[i10] = new C4828a(this.nativeHandle, i10);
        }
        return c4828aArr;
    }

    @Override // android.media.Image
    public long getTimestamp() {
        long jNativeGetTimestamp = nativeGetTimestamp(this.nativeHandle);
        if (jNativeGetTimestamp != -1) {
            return jNativeGetTimestamp;
        }
        throw new ARFatalException("Unknown error in ArImage.getTimestamp().");
    }

    @Override // android.media.Image
    public int getWidth() {
        int iNativeGetWidth = nativeGetWidth(this.nativeHandle);
        if (iNativeGetWidth != -1) {
            return iNativeGetWidth;
        }
        throw new ARFatalException("Unknown error in ArImage.getWidth().");
    }

    @Override // android.media.Image
    public void setCropRect(Rect rect) {
        throw new UnsupportedOperationException("This is read-only image.");
    }

    @Override // android.media.Image
    public void setTimestamp(long j10) {
        throw new UnsupportedOperationException("This is read-only image.");
    }
}
