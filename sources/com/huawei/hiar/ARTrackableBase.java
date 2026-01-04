package com.huawei.hiar;

import com.huawei.hiar.ARTrackable;
import java.util.Collection;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARTrackableBase implements ARTrackable {
    private static final String TAG = "ARTrackableBase";
    final long mNativeHandle;
    final ARSession mSession;

    public ARTrackableBase(long j10, ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeHandle = j10;
    }

    public static int internalGetType(long j10, long j11) {
        return nativeGetType(j10, j11);
    }

    public static void internalReleaseNativeHandle(long j10) {
        nativeReleaseTrackable(j10);
    }

    private native long nativeCreateAnchor(long j10, long j11, ARPose aRPose);

    private native long[] nativeGetAnchors(long j10, long j11);

    private native int nativeGetTrackingState(long j10, long j11);

    private static native int nativeGetType(long j10, long j11);

    private static native void nativeReleaseTrackable(long j10);

    @Override // com.huawei.hiar.ARTrackable
    public ARAnchor createAnchor(ARPose aRPose) {
        return new ARAnchor(nativeCreateAnchor(this.mSession.mNativeHandle, this.mNativeHandle, aRPose), this.mSession);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ARTrackableBase) && ((ARTrackableBase) obj).mNativeHandle == this.mNativeHandle;
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleaseTrackable(j10);
        }
        super.finalize();
    }

    @Override // com.huawei.hiar.ARTrackable
    public Collection<ARAnchor> getAnchors() {
        ARSession aRSession = this.mSession;
        return aRSession.convertNativeAnchorsToCollection(nativeGetAnchors(aRSession.mNativeHandle, this.mNativeHandle));
    }

    @Override // com.huawei.hiar.ARTrackable
    public ARTrackable.TrackingState getTrackingState() {
        return ARTrackable.TrackingState.forNumber(nativeGetTrackingState(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public int hashCode() {
        return Long.valueOf(this.mNativeHandle).hashCode();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "trackableHandle= 0x%x, trackingState=%s, anchors=%s", Long.valueOf(this.mNativeHandle), getTrackingState(), getAnchors().toString());
    }
}
