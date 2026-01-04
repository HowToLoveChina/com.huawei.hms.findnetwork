package com.huawei.hiar;

import com.huawei.hiar.ARTrackable;
import java.util.Collection;

/* loaded from: classes5.dex */
public class ARAugmentedImage extends ARTrackableBase {
    public ARAugmentedImage(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }

    private native String nativeAcquireName(long j10, long j11);

    private native ARPose nativeGetCenterPose(long j10, long j11);

    private native String nativeGetCloudImageId(long j10, long j11);

    private native String nativeGetCloudImageMetadata(long j10, long j11);

    private native float nativeGetExtentX(long j10, long j11);

    private native float nativeGetExtentZ(long j10, long j11);

    private native int nativeGetIndex(long j10, long j11);

    @Override // com.huawei.hiar.ARTrackableBase
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.huawei.hiar.ARTrackableBase, com.huawei.hiar.ARTrackable
    public Collection<ARAnchor> getAnchors() {
        return super.getAnchors();
    }

    public ARPose getCenterPose() {
        return nativeGetCenterPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public String getCloudImageId() {
        return nativeGetCloudImageId(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public String getCloudImageMetadata() {
        return nativeGetCloudImageMetadata(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float getExtentX() {
        return nativeGetExtentX(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float getExtentZ() {
        return nativeGetExtentZ(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int getIndex() {
        return nativeGetIndex(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public String getName() {
        return nativeAcquireName(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    @Override // com.huawei.hiar.ARTrackableBase, com.huawei.hiar.ARTrackable
    public ARTrackable.TrackingState getTrackingState() {
        return super.getTrackingState();
    }

    @Override // com.huawei.hiar.ARTrackableBase
    public int hashCode() {
        return super.hashCode();
    }
}
