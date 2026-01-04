package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARDeadlineExceededException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* loaded from: classes5.dex */
public class ARFaceGeometry {
    private long mNativeHandle;
    private final ARSession mSession;

    public enum TriangleLabel {
        TRIANGLE_LABEL_NON_FACE(-1),
        TRIANGLE_LABEL_FACE_OTHER(0),
        TRIANGLE_LABEL_LOWER_LIP(1),
        TRIANGLE_LABEL_UPPER_LIP(2),
        TRIANGLE_LABEL_LEFT_EYE(3),
        TRIANGLE_LABEL_RIGHT_EYE(4),
        TRIANGLE_LABEL_LEFT_BROW(5),
        TRIANGLE_LABEL_RIGHT_BROW(6),
        TRIANGLE_LABEL_BROW_CENTER(7),
        TRIANGLE_LABEL_NOSE(8);

        final int mNativeCode;

        TriangleLabel(int i10) {
            this.mNativeCode = i10;
        }

        public static TriangleLabel forNumber(int i10) {
            for (TriangleLabel triangleLabel : values()) {
                if (triangleLabel.mNativeCode == i10) {
                    return triangleLabel;
                }
            }
            return TRIANGLE_LABEL_NON_FACE;
        }
    }

    public ARFaceGeometry() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private native float[] nativeGetTextureCoordinates(long j10, long j11);

    private native int nativeGetTriangleCount(long j10, long j11);

    private native int[] nativeGetTriangleIndices(long j10, long j11);

    private native int[] nativeGetTriangleLabels(long j10, long j11);

    private native float[] nativeGetVertices(long j10, long j11);

    private native void nativeReleaseFaceGeometry(long j10);

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleaseFaceGeometry(j10);
        }
        super.finalize();
    }

    public FloatBuffer getTextureCoordinates() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return FloatBuffer.wrap(nativeGetTextureCoordinates(this.mSession.mNativeHandle, j10));
        }
        throw new ARDeadlineExceededException();
    }

    public int getTriangleCount() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return nativeGetTriangleCount(this.mSession.mNativeHandle, j10);
        }
        throw new ARDeadlineExceededException();
    }

    public IntBuffer getTriangleIndices() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return IntBuffer.wrap(nativeGetTriangleIndices(this.mSession.mNativeHandle, j10));
        }
        throw new ARDeadlineExceededException();
    }

    public IntBuffer getTriangleLabels() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return IntBuffer.wrap(nativeGetTriangleLabels(this.mSession.mNativeHandle, j10));
        }
        throw new ARDeadlineExceededException();
    }

    public FloatBuffer getVertices() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return FloatBuffer.wrap(nativeGetVertices(this.mSession.mNativeHandle, j10));
        }
        throw new ARDeadlineExceededException();
    }

    public void release() {
        nativeReleaseFaceGeometry(this.mNativeHandle);
        this.mNativeHandle = 0L;
    }

    public ARFaceGeometry(ARSession aRSession, long j10) {
        this.mSession = aRSession;
        this.mNativeHandle = j10;
    }
}
