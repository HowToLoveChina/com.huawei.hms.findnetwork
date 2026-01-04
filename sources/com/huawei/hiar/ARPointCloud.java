package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARDeadlineExceededException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARPointCloud {
    static final String TAG = "ARPointCloud";
    long mNativeHandle;
    private final ARSession mSession;

    public ARPointCloud() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private native ByteBuffer nativeGetData(long j10, long j11);

    private native long nativeGetTimestamp(long j10, long j11);

    private native void nativeReleasePointCloud(long j10);

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleasePointCloud(j10);
        }
        super.finalize();
    }

    public FloatBuffer getPoints() {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            throw new ARDeadlineExceededException();
        }
        ByteBuffer byteBufferNativeGetData = nativeGetData(this.mSession.mNativeHandle, j10);
        if (byteBufferNativeGetData == null) {
            byteBufferNativeGetData = ByteBuffer.allocateDirect(0);
        }
        return byteBufferNativeGetData.order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public long getTimestampNs() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            return nativeGetTimestamp(this.mSession.mNativeHandle, j10);
        }
        throw new ARDeadlineExceededException();
    }

    public void release() {
        nativeReleasePointCloud(this.mNativeHandle);
        this.mNativeHandle = 0L;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ARPointcloud:{handle=0x%x, timestamp= %d}", Long.valueOf(this.mNativeHandle), Long.valueOf(getTimestampNs()));
    }

    public ARPointCloud(long j10, ARSession aRSession) {
        this.mNativeHandle = j10;
        this.mSession = aRSession;
    }
}
