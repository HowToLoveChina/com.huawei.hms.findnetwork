package com.huawei.hiar;

import android.media.Image;
import android.util.Log;
import android.view.MotionEvent;
import com.huawei.hiar.ARTrackable;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class ARFrame {
    private static final int ALIGN_STATE_PROCESSING = 2;
    private static final int ALIGN_STATE_SUCCESS = 3;
    private static final int MATRIX_OFFSET = 16;
    private static final String TAG = "ARFrame";
    private static final int WORLD_MAPPING_STATE_MAPPED = 2;
    ARCamera mCamera;
    ARLightEstimate mLightEstimate;
    long mNativeHandle;
    ARSession mSession;

    public ARFrame() {
        this.mSession = null;
        this.mNativeHandle = 0L;
        this.mLightEstimate = null;
        this.mCamera = null;
    }

    private List<ARHitResult> getArHitResultsByIds(long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            ARHitResult aRHitResult = new ARHitResult(j10, this.mSession);
            if (aRHitResult.getTrackable() != null) {
                Log.i(TAG, "getArHitResultsByIds arTrackable:" + aRHitResult.getTrackable().toString());
            }
            arrayList.add(aRHitResult);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private native long nativeAcquireCameraImage(long j10, long j11);

    private native long nativeAcquireDepthImage(long j10, long j11);

    private native long nativeAcquireImageMetadata(long j10, long j11);

    private native long nativeAcquirePreviewImage(long j10, long j11);

    private native long nativeAcquireSceneMesh(long j10, long j11);

    private native long[] nativeAcquireUpdatedAnchors(long j10, long j11);

    private native long[] nativeAcquireUpdatedTrackables(long j10, long j11, int i10);

    private static native long nativeCreateFrame(long j10);

    private static native void nativeDestroyFrame(long j10);

    private native void nativeGetLightEstimate(long j10, long j11, long j12);

    private native long nativeGetTimestamp(long j10, long j11);

    private native boolean nativeHasDisplayGeometryChanged(long j10, long j11);

    private native long[] nativeHitTest(long j10, long j11, float f10, float f11);

    private native long[] nativeHitTestArea(long j10, long j11, float[] fArr);

    private native void nativeTransformDisplayUvCoords(long j10, long j11, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

    public Image acquireCameraImage() {
        return new ARImage(nativeAcquireCameraImage(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public Image acquireDepthImage() {
        return new ARImage(nativeAcquireDepthImage(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public ARPointCloud acquirePointCloud() {
        return new ARPointCloud(nativeAcquirePointCloud(this.mSession.mNativeHandle, this.mNativeHandle), this.mSession);
    }

    public Image acquirePreviewImage() {
        return new ARImage(nativeAcquirePreviewImage(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public ARSceneMesh acquireSceneMesh() {
        return new ARSceneMesh(this.mSession, nativeAcquireSceneMesh(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroyFrame(j10);
        }
        super.finalize();
    }

    public ARCamera getCamera() {
        return this.mCamera;
    }

    public ARImageMetadata getImageMetadata() {
        return new ARImageMetadata(nativeAcquireImageMetadata(this.mSession.mNativeHandle, this.mNativeHandle), this.mSession);
    }

    public ARLightEstimate getLightEstimate() {
        nativeGetLightEstimate(this.mSession.mNativeHandle, this.mNativeHandle, this.mLightEstimate.mNativeHandle);
        return this.mLightEstimate;
    }

    @Deprecated
    public ARPointCloud getPointCloud() {
        return acquirePointCloud();
    }

    @Deprecated
    public ARPose getPointCloudPose() {
        return ARPose.IDENTITY;
    }

    @Deprecated
    public ARPose getPose() {
        return this.mCamera.getDisplayOrientedPose();
    }

    public long getTimestampNs() {
        return nativeGetTimestamp(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    @Deprecated
    public ARTrackable.TrackingState getTrackingState() {
        return this.mCamera.getTrackingState();
    }

    public Collection<ARAnchor> getUpdatedAnchors() {
        ARSession aRSession = this.mSession;
        return aRSession.convertNativeAnchorsToCollection(nativeAcquireUpdatedAnchors(aRSession.mNativeHandle, this.mNativeHandle));
    }

    @Deprecated
    public Collection<ARPlane> getUpdatedPlanes() {
        return getUpdatedTrackables(ARPlane.class);
    }

    public <T extends ARTrackable> Collection<T> getUpdatedTrackables(Class<T> cls) {
        int nativeTrackableFilterFromClass = ARSession.getNativeTrackableFilterFromClass(cls);
        if (nativeTrackableFilterFromClass == -1) {
            return Collections.emptyList();
        }
        return this.mSession.convertNativeTrackablesToCollection(cls, nativeAcquireUpdatedTrackables(this.mSession.mNativeHandle, this.mNativeHandle, nativeTrackableFilterFromClass));
    }

    @Deprecated
    public void getViewMatrix(float[] fArr, int i10) {
        if (fArr == null || i10 < 0 || fArr.length < i10 + 16) {
            Log.e(TAG, "getViewMatrix: illegal argument");
            throw new IllegalArgumentException("length of mViewMatrix is illegal.");
        }
        this.mCamera.getViewMatrix(fArr, i10);
    }

    public boolean hasDisplayGeometryChanged() {
        return nativeHasDisplayGeometryChanged(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public List<ARHitResult> hitTest(float f10, float f11) {
        if (f10 >= 0.0f && f11 >= 0.0f) {
            return getArHitResultsByIds(nativeHitTest(this.mSession.mNativeHandle, this.mNativeHandle, f10, f11));
        }
        Log.e(TAG, "hitTest: illegal argument");
        throw new IllegalArgumentException();
    }

    public List<ARHitResult> hitTestArea(float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            Log.e(TAG, "hitTest: illegal argument");
            throw new IllegalArgumentException();
        }
        long[] jArrNativeHitTestArea = nativeHitTestArea(this.mSession.mNativeHandle, this.mNativeHandle, fArr);
        if (jArrNativeHitTestArea != null && jArrNativeHitTestArea.length != 0) {
            return getArHitResultsByIds(jArrNativeHitTestArea);
        }
        Log.w(TAG, "hitTest: hitResult null!");
        return null;
    }

    public void initCamera() {
        this.mCamera = new ARCamera(this.mSession, this);
    }

    public void initLightEstimate() {
        this.mLightEstimate = new ARLightEstimate(this.mSession);
    }

    @Deprecated
    public boolean isDisplayRotationChanged() {
        return hasDisplayGeometryChanged();
    }

    public native long nativeAcquirePointCloud(long j10, long j11);

    public void transformDisplayUvCoords(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer == null || floatBuffer2 == null) {
            throw new IllegalArgumentException("input parameter is null pointer.");
        }
        if (!floatBuffer.isDirect() || !floatBuffer2.isDirect()) {
            throw new IllegalArgumentException("transformDisplayUvCoords error.");
        }
        nativeTransformDisplayUvCoords(this.mSession.mNativeHandle, this.mNativeHandle, floatBuffer, floatBuffer2);
    }

    public ARFrame(ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeHandle = nativeCreateFrame(aRSession.mNativeHandle);
    }

    public List<ARHitResult> hitTest(MotionEvent motionEvent) {
        return hitTest(motionEvent.getX(), motionEvent.getY());
    }
}
