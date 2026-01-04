package com.huawei.hiar;

import com.huawei.hiar.ARTrackable;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARAnchor {
    private static final String TAG = "ARAnchor";
    long mNativeHandle;
    private final ARSession mSession;

    private ARAnchor() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private native void nativeDetach(long j10, long j11);

    private native ARPose nativeGetPose(long j10, long j11);

    private native int nativeGetTrackingState(long j10, long j11);

    private static native void nativeReleaseAnchor(long j10);

    public void detach() {
        nativeDetach(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ARAnchor) && ((ARAnchor) obj).mNativeHandle == this.mNativeHandle;
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleaseAnchor(j10);
        }
        super.finalize();
    }

    @Deprecated
    public int getId() {
        return 0;
    }

    public ARPose getPose() {
        return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARTrackable.TrackingState getTrackingState() {
        return ARTrackable.TrackingState.forNumber(nativeGetTrackingState(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public int hashCode() {
        return Long.valueOf(this.mNativeHandle).hashCode();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ARAnchor{ handle=0x%x, tracking state is %s}", Long.valueOf(this.mNativeHandle), getTrackingState().name());
    }

    public ARAnchor(long j10, ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeHandle = j10;
    }
}
