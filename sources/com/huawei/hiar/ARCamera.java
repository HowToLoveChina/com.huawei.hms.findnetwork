package com.huawei.hiar;

import com.huawei.hiar.ARTrackable;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARCamera {
    private static final int MATRIX_LEAST_SIZE = 16;
    long mNativeHandle;
    final ARSession mSession;

    private ARCamera() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private static native long nativeAcquireCamera(long j10, long j11);

    private native long nativeCreateCameraIntrinsics(long j10);

    private native ARPose nativeDisplayOrientedPose(long j10, long j11);

    private native void nativeGetImageIntrinsics(long j10, long j11, long j12);

    private native ARPose nativeGetPose(long j10, long j11);

    private native void nativeGetProjectionMatrix(long j10, long j11, float[] fArr, int i10, float f10, float f11);

    private native int nativeGetTrackingState(long j10, long j11);

    private native void nativeGetViewMatrix(long j10, long j11, float[] fArr, int i10);

    private static native void nativeReleaseCamera(long j10);

    public boolean equals(Object obj) {
        return (obj instanceof ARCamera) && ((ARCamera) obj).mNativeHandle == this.mNativeHandle;
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleaseCamera(j10);
        }
        super.finalize();
    }

    public ARCameraIntrinsics getCameraImageIntrinsics() {
        ARCameraIntrinsics aRCameraIntrinsics = new ARCameraIntrinsics(this.mSession, nativeCreateCameraIntrinsics(this.mSession.mNativeHandle));
        nativeGetImageIntrinsics(this.mSession.mNativeHandle, this.mNativeHandle, aRCameraIntrinsics.nativeHandle);
        return aRCameraIntrinsics;
    }

    public ARPose getDisplayOrientedPose() {
        return nativeDisplayOrientedPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARPose getPose() {
        return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public void getProjectionMatrix(float[] fArr, int i10, float f10, float f11) {
        if (fArr == null || fArr.length < i10 + 16 || Float.compare(f10, f11) == 0) {
            throw new IllegalArgumentException();
        }
        if (i10 < 0 || f10 < 0.0f || f11 < 0.0f) {
            throw new IllegalArgumentException();
        }
        nativeGetProjectionMatrix(this.mSession.mNativeHandle, this.mNativeHandle, fArr, i10, Math.min(f10, f11), Math.max(f10, f11));
    }

    public ARTrackable.TrackingState getTrackingState() {
        return ARTrackable.TrackingState.forNumber(nativeGetTrackingState(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public void getViewMatrix(float[] fArr, int i10) {
        if (fArr == null || i10 < 0 || fArr.length < i10 + 16) {
            throw new IllegalArgumentException();
        }
        nativeGetViewMatrix(this.mSession.mNativeHandle, this.mNativeHandle, fArr, i10);
    }

    public int hashCode() {
        return Long.valueOf(this.mNativeHandle).hashCode();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ARCamera: {handle=0x%x, trackingState=%s, pose=%s, DisplayOrientedPose=%s}", Long.valueOf(this.mNativeHandle), getTrackingState().name(), getPose().toString(), getDisplayOrientedPose().toString());
    }

    public ARCamera(ARSession aRSession, ARFrame aRFrame) {
        this.mSession = aRSession;
        this.mNativeHandle = nativeAcquireCamera(aRSession.mNativeHandle, aRFrame.mNativeHandle);
    }
}
