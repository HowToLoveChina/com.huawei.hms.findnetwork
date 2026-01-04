package com.huawei.hiar;

import java.util.Locale;

/* loaded from: classes5.dex */
public class ARPoint extends ARTrackableBase {
    static final int AR_POINT_ORIENTATION_ESTIMATED_SURFACE_NORMAL = 1;
    static final int AR_POINT_ORIENTATION_INITIALIZED_TO_IDENTITY = 0;

    public enum OrientationMode {
        UNKNOWN_MODE(-1),
        INITIALIZED_TO_IDENTITY(0),
        ESTIMATED_SURFACE_NORMAL(1);

        private final int nativeCode;

        OrientationMode(int i10) {
            this.nativeCode = i10;
        }

        public static OrientationMode forNumber(int i10) {
            for (OrientationMode orientationMode : values()) {
                if (orientationMode.nativeCode == i10) {
                    return orientationMode;
                }
            }
            return UNKNOWN_MODE;
        }
    }

    public ARPoint() {
        super(0L, null);
    }

    private native int nativeGetOrientationMode(long j10, long j11);

    private native ARPose nativeGetPose(long j10, long j11);

    public OrientationMode getOrientationMode() {
        return OrientationMode.forNumber(nativeGetOrientationMode(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public ARPose getPose() {
        return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    @Override // com.huawei.hiar.ARTrackableBase
    public String toString() {
        return String.format(Locale.ENGLISH, "ARPoint: { %s, pose=%s, orientationMode=%s }", super.toString(), getPose().toString(), getOrientationMode().name());
    }

    public ARPoint(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }
}
