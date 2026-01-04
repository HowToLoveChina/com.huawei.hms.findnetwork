package com.huawei.hiar;

/* loaded from: classes5.dex */
public class ARTarget extends ARTrackableBase {

    public enum TargetLabel {
        TARGET_INVALID(-1),
        TARGET_OTHER(0),
        TARGET_SEAT(1),
        TARGET_TABLE(2);

        final int nativeCode;

        TargetLabel(int i10) {
            this.nativeCode = i10;
        }

        public static TargetLabel forNumber(int i10) {
            for (TargetLabel targetLabel : values()) {
                if (targetLabel.nativeCode == i10) {
                    return targetLabel;
                }
            }
            return TARGET_INVALID;
        }
    }

    public enum TargetShapeType {
        TARGET_SHAPE_INVALID(-1),
        TARGET_SHAPE_OTHER(0),
        TARGET_SHAPE_BOX(1),
        TARGET_SHAPE_CIRCLE(2),
        TARGET_SHAPE_RECT(3);

        final int nativeCode;

        TargetShapeType(int i10) {
            this.nativeCode = i10;
        }

        public static TargetShapeType forNumber(int i10) {
            for (TargetShapeType targetShapeType : values()) {
                if (targetShapeType.nativeCode == i10) {
                    return targetShapeType;
                }
            }
            return TARGET_SHAPE_INVALID;
        }
    }

    public ARTarget(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }

    private native float[] nativeGetAxisAlignBoundingBox(long j10, long j11);

    private native ARPose nativeGetCenterPose(long j10, long j11);

    private native int nativeGetLabel(long j10, long j11);

    private native float nativeGetRadius(long j10, long j11);

    private native int nativeGetShapeType(long j10, long j11);

    public float[] getAxisAlignBoundingBox() {
        return nativeGetAxisAlignBoundingBox(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARPose getCenterPose() {
        return nativeGetCenterPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public TargetLabel getLabel() {
        return TargetLabel.forNumber(nativeGetLabel(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public float getRadius() {
        return nativeGetRadius(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public TargetShapeType getShapeType() {
        return TargetShapeType.forNumber(nativeGetShapeType(this.mSession.mNativeHandle, this.mNativeHandle));
    }
}
