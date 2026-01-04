package com.huawei.hiar;

/* loaded from: classes5.dex */
public class ARCameraIntrinsics {
    private static final int ARRAY_LENS_FIVE = 5;
    private static final int ARRAY_LENS_TWO = 2;
    private final ARSession arSession;
    long nativeHandle;

    public ARCameraIntrinsics(ARSession aRSession, long j10) {
        this.arSession = aRSession;
        this.nativeHandle = j10;
    }

    private native void nativeDestroyCameraIntrinsics(long j10, long j11);

    private native void nativeGetDistortions(long j10, long j11, float[] fArr);

    private native void nativeGetFocalLength(long j10, long j11, float[] fArr);

    private native void nativeGetImageDimensions(long j10, long j11, int[] iArr);

    private native void nativeGetPrincipalPoint(long j10, long j11, float[] fArr);

    public void finalize() throws Throwable {
        long j10 = this.nativeHandle;
        if (j10 != 0) {
            nativeDestroyCameraIntrinsics(this.arSession.mNativeHandle, j10);
        }
        super.finalize();
    }

    public float[] getDistortions() {
        float[] fArr = new float[5];
        nativeGetDistortions(this.arSession.mNativeHandle, this.nativeHandle, fArr);
        return fArr;
    }

    public float[] getFocalLength() {
        float[] fArr = new float[2];
        nativeGetFocalLength(this.arSession.mNativeHandle, this.nativeHandle, fArr);
        return fArr;
    }

    public int[] getImageDimensions() {
        int[] iArr = new int[2];
        nativeGetImageDimensions(this.arSession.mNativeHandle, this.nativeHandle, iArr);
        return iArr;
    }

    public float[] getPrincipalPoint() {
        float[] fArr = new float[2];
        nativeGetPrincipalPoint(this.arSession.mNativeHandle, this.nativeHandle, fArr);
        return fArr;
    }
}
