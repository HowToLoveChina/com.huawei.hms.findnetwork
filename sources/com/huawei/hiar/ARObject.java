package com.huawei.hiar;

import com.huawei.hiar.ARTrackable;

/* loaded from: classes5.dex */
public class ARObject extends ARTrackableBase {
    public ARObject(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }

    private native ARPose nativeGetCenterPose(long j10, long j11);

    private native int nativeGetObjectAnchorId(long j10, long j11);

    private native int nativeGetObjectIndex(long j10, long j11);

    private native String nativeGetObjectName(long j10, long j11);

    public ARPose getCenterPose() {
        return nativeGetCenterPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public String getName() {
        return nativeGetObjectName(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int getObjectAnchorId() {
        return nativeGetObjectAnchorId(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int getObjectID() {
        return nativeGetObjectIndex(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    @Override // com.huawei.hiar.ARTrackableBase, com.huawei.hiar.ARTrackable
    public ARTrackable.TrackingState getTrackingState() {
        return super.getTrackingState();
    }
}
