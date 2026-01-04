package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARDeadlineExceededException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* loaded from: classes5.dex */
public class ARSceneMesh {
    private long mNativeHandle;
    private final ARSession mSession;

    public ARSceneMesh() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private native ByteBuffer nativeGetSceneDepth(long j10, long j11);

    private native int nativeGetSceneDepthHeight(long j10, long j11);

    private native int nativeGetSceneDepthWidth(long j10, long j11);

    private native int[] nativeGetSceneMeshTriangleIndices(long j10, long j11);

    private native float[] nativeGetSceneMeshVertexNormals(long j10, long j11);

    private native float[] nativeGetSceneMeshVertices(long j10, long j11);

    private native void nativeReleaseSceneMesh(long j10);

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleaseSceneMesh(j10);
        }
        super.finalize();
    }

    public ShortBuffer getSceneDepth() {
        ByteBuffer byteBufferNativeGetSceneDepth = nativeGetSceneDepth(this.mSession.mNativeHandle, this.mNativeHandle);
        if (byteBufferNativeGetSceneDepth == null) {
            return null;
        }
        return byteBufferNativeGetSceneDepth.order(ByteOrder.nativeOrder()).asShortBuffer().asReadOnlyBuffer();
    }

    public int getSceneDepthHeight() {
        return nativeGetSceneDepthHeight(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int getSceneDepthWidth() {
        return nativeGetSceneDepthWidth(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public IntBuffer getTriangleIndices() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return IntBuffer.wrap(nativeGetSceneMeshTriangleIndices(this.mSession.mNativeHandle, j10));
        }
        throw new ARDeadlineExceededException();
    }

    public FloatBuffer getVertexNormals() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return FloatBuffer.wrap(nativeGetSceneMeshVertexNormals(this.mSession.mNativeHandle, j10));
        }
        throw new ARDeadlineExceededException();
    }

    public FloatBuffer getVertices() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return FloatBuffer.wrap(nativeGetSceneMeshVertices(this.mSession.mNativeHandle, j10));
        }
        throw new ARDeadlineExceededException();
    }

    public void release() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleaseSceneMesh(j10);
        }
        this.mNativeHandle = 0L;
    }

    public ARSceneMesh(ARSession aRSession, long j10) {
        this.mSession = aRSession;
        this.mNativeHandle = j10;
    }
}
