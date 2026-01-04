package com.huawei.hiar;

import java.util.Locale;

/* loaded from: classes5.dex */
public class ARHitResult {
    static final String TAG = "ARHitResult";
    long mNativeHandle;
    final ARSession mSession;

    public ARHitResult() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private native long nativeAcquireTrackable(long j10, long j11);

    private native long nativeCreateAnchor(long j10, long j11);

    private static native void nativeDestroyHitResult(long j10);

    private native float nativeGetDistance(long j10, long j11);

    private native ARPose nativeGetPose(long j10, long j11);

    public ARAnchor createAnchor() {
        return new ARAnchor(nativeCreateAnchor(this.mSession.mNativeHandle, this.mNativeHandle), this.mSession);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ARHitResult) && ((ARHitResult) obj).mNativeHandle == this.mNativeHandle;
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroyHitResult(j10);
        }
        super.finalize();
    }

    public float getDistance() {
        return nativeGetDistance(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARPose getHitPose() {
        return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARTrackable getTrackable() {
        return this.mSession.createTrackable(nativeAcquireTrackable(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public int hashCode() {
        return Long.valueOf(this.mNativeHandle).hashCode();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "AR hit result: { hit on pose: %s, with distance %f }", getHitPose().toString(), Float.valueOf(getDistance()));
    }

    public ARHitResult(long j10, ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeHandle = j10;
    }
}
