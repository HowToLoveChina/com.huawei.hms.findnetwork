package com.huawei.hiar;

import android.util.Log;
import java.nio.FloatBuffer;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARPlane extends ARTrackableBase {
    private static final String TAG = "ARPlane";

    public enum PlaneType {
        HORIZONTAL_UPWARD_FACING(0),
        HORIZONTAL_DOWNWARD_FACING(1),
        VERTICAL_FACING(2),
        UNKNOWN_FACING(3);

        final int mNativeCode;

        PlaneType(int i10) {
            this.mNativeCode = i10;
        }

        public static PlaneType forNumber(int i10) {
            for (PlaneType planeType : values()) {
                if (planeType.mNativeCode == i10) {
                    return planeType;
                }
            }
            return UNKNOWN_FACING;
        }
    }

    public enum SemanticPlaneLabel {
        PLANE_OTHER(0),
        PLANE_WALL(1),
        PLANE_FLOOR(2),
        PLANE_SEAT(3),
        PLANE_TABLE(4),
        PLANE_CEILING(5),
        PLANE_DOOR(6),
        PLANE_WINDOW(7),
        PLANE_BED(8);

        final int mNativeCode;

        SemanticPlaneLabel(int i10) {
            this.mNativeCode = i10;
        }

        public static SemanticPlaneLabel forNumber(int i10) {
            for (SemanticPlaneLabel semanticPlaneLabel : values()) {
                if (semanticPlaneLabel.mNativeCode == i10) {
                    return semanticPlaneLabel;
                }
            }
            return PLANE_OTHER;
        }
    }

    public ARPlane() {
        super(0L, null);
    }

    private native long nativeAcquireSubsumedBy(long j10, long j11);

    private native ARPose nativeGetCenterPose(long j10, long j11);

    private native float nativeGetExtentX(long j10, long j11);

    private native float nativeGetExtentZ(long j10, long j11);

    private native int nativeGetLabel(long j10, long j11);

    private native float[] nativeGetPolygon(long j10, long j11);

    private native int nativeGetType(long j10, long j11);

    private native boolean nativeIsPoseInExtents(long j10, long j11, ARPose aRPose);

    private native boolean nativeIsPoseInPolygon(long j10, long j11, ARPose aRPose);

    public ARPose getCenterPose() {
        return nativeGetCenterPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float getExtentX() {
        return nativeGetExtentX(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float getExtentZ() {
        return nativeGetExtentZ(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public SemanticPlaneLabel getLabel() {
        return SemanticPlaneLabel.forNumber(nativeGetLabel(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public FloatBuffer getPlanePolygon() {
        return FloatBuffer.wrap(nativeGetPolygon(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public ARPlane getSubsumedBy() {
        long jNativeAcquireSubsumedBy = nativeAcquireSubsumedBy(this.mSession.mNativeHandle, this.mNativeHandle);
        if (jNativeAcquireSubsumedBy == 0) {
            return null;
        }
        return new ARPlane(jNativeAcquireSubsumedBy, this.mSession);
    }

    public PlaneType getType() {
        return PlaneType.forNumber(nativeGetType(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public boolean isPoseInExtents(ARPose aRPose) {
        if (aRPose != null) {
            return nativeIsPoseInExtents(this.mSession.mNativeHandle, this.mNativeHandle, aRPose);
        }
        Log.e(TAG, "ARPlane isPoseInExtents: input pose is null");
        throw new IllegalArgumentException();
    }

    public boolean isPoseInPolygon(ARPose aRPose) {
        if (aRPose != null) {
            return nativeIsPoseInPolygon(this.mSession.mNativeHandle, this.mNativeHandle, aRPose);
        }
        Log.e(TAG, "ARPlane isPoseInPolygon: input pose is null");
        throw new IllegalArgumentException();
    }

    @Override // com.huawei.hiar.ARTrackableBase
    public String toString() {
        return String.format(Locale.ENGLISH, "ARPlane: { %s, plane type=%s, center pose= %s }", super.toString(), getType().name(), getCenterPose().toString());
    }

    public ARPlane(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }
}
