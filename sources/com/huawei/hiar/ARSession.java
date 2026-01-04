package com.huawei.hiar;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.huawei.hiar.annotations.UsedByNative;
import com.huawei.hiar.common.CloudServiceState;
import com.huawei.hiar.common.FaceHealthCheckState;
import com.huawei.hiar.exceptions.ARCameraPermissionDeniedException;
import com.huawei.hiar.exceptions.ARUnSupportedConfigurationException;
import com.huawei.hiar.listener.CloudServiceEvent;
import com.huawei.hiar.listener.CloudServiceListener;
import com.huawei.hiar.listener.FaceHealthCheckStateEvent;
import com.huawei.hiar.listener.FaceHealthServiceListener;
import com.huawei.hiar.listener.ServiceListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARSession {
    static final int AR_DISPLAY_ROTATION_MAX = 3;
    static final int AR_TRACKABLE_BASE_TRACKABLE = 1095893248;
    static final int AR_TRACKABLE_BODY = 1342177281;
    static final int AR_TRACKABLE_FACE = 1342177282;
    static final int AR_TRACKABLE_HAND = 1342177280;
    static final int AR_TRACKABLE_IMAGE = 1095893252;
    static final int AR_TRACKABLE_NOT_VALID = 0;
    static final int AR_TRACKABLE_OBJECT = 1342177285;
    static final int AR_TRACKABLE_PLANE = 1095893249;
    static final int AR_TRACKABLE_POINT = 1095893250;
    static final int AR_TRACKABLE_TARGET = 1342177288;
    static final int AR_TRACKABLE_UNKNOWN_TO_JAVA = -1;
    static final int AR_TRACKING_STATE_PAUSED = 1;
    static final int AR_TRACKING_STATE_STOPPED = 2;
    static final int AR_TRACKING_STATE_TRACKING = 0;
    public static final int CURRENT_SDK_VERSIONCODE = 158;
    private static final String TAG = "ARSession";
    static String libraryName = "huawei_arengine_jni";
    private Context mContext;
    ARFrame mLastFrame;
    long mNativeHandle;
    protected Object syncObject = new Object();
    private List<ServiceListener> serviceListeners = new ArrayList();

    public enum EnvironmentTextureUpdateMode {
        UNKNOWN(-1),
        AUTO(0),
        UPDATE_ONE_TIME(1);

        final int mNativeCode;

        EnvironmentTextureUpdateMode(int i10) {
            this.mNativeCode = i10;
        }

        public static EnvironmentTextureUpdateMode forNumber(int i10) {
            for (EnvironmentTextureUpdateMode environmentTextureUpdateMode : values()) {
                if (environmentTextureUpdateMode.mNativeCode == i10) {
                    return environmentTextureUpdateMode;
                }
            }
            return UNKNOWN;
        }
    }

    static {
        System.loadLibrary(libraryName);
    }

    public ARSession(Context context) {
        this.mLastFrame = null;
        String str = TAG;
        Log.d(str, "ARSession: Current SDK Versioncode : 158");
        if (context == null) {
            Log.e(str, "The input parameter context is invalid");
            throw new IllegalArgumentException("The input parameter context is invalid");
        }
        this.mContext = context;
        this.mNativeHandle = nativeCreateSession(context);
        this.mLastFrame = new ARFrame(this);
    }

    public static int getNativeTrackableFilterFromClass(Class<?> cls) {
        if (cls == ARTrackable.class) {
            return AR_TRACKABLE_BASE_TRACKABLE;
        }
        if (cls == ARPlane.class) {
            return AR_TRACKABLE_PLANE;
        }
        if (cls == ARAugmentedImage.class) {
            return AR_TRACKABLE_IMAGE;
        }
        if (cls == ARPoint.class) {
            return AR_TRACKABLE_POINT;
        }
        if (cls == ARHand.class) {
            return AR_TRACKABLE_HAND;
        }
        if (cls == ARBody.class) {
            return AR_TRACKABLE_BODY;
        }
        if (cls == ARFace.class) {
            return AR_TRACKABLE_FACE;
        }
        if (cls == ARObject.class) {
            return AR_TRACKABLE_OBJECT;
        }
        if (cls == ARTarget.class) {
            return AR_TRACKABLE_TARGET;
        }
        return -1;
    }

    private FaceHealthServiceListener getValidFaceHealthServiceListener() {
        for (ServiceListener serviceListener : this.serviceListeners) {
            if (serviceListener instanceof FaceHealthServiceListener) {
                return (FaceHealthServiceListener) serviceListener;
            }
        }
        return null;
    }

    private native long[] nativeAcquireAllAnchors(long j10);

    private native long[] nativeAcquireAllTrackables(long j10, int i10);

    private native void nativeConfigure(long j10, long j11);

    private native long nativeCreateAnchor(long j10, ARPose aRPose);

    private static native long nativeCreateSession(Context context);

    private static native void nativeDestroySession(long j10);

    private native long nativeGetCameraConfig(long j10);

    private native int nativeGetSupportedSemanticMode(long j10);

    private native boolean nativeIsSupported(long j10, long j11);

    private native void nativePause(long j10);

    private native void nativeResume(long j10);

    private native void nativeSetCameraTextureName(long j10, int i10);

    private native void nativeSetCloudServiceAuthInfo(long j10, String str);

    private native void nativeSetDisplayGeometry(long j10, int i10, int i11, int i12);

    private native void nativeSetEnvironmentTextureProbe(long j10, float[] fArr);

    private native void nativeSetEnvironmentTextureUpdateMode(long j10, int i10);

    private native void nativeSetServiceCallback(long j10);

    private native void nativeStop(long j10);

    private native void nativeUpdate(long j10, long j11);

    @UsedByNative("session_jni.cpp")
    private void notifyToCloudServiceListener(int i10) {
        CloudServiceListener cloudServiceListener;
        Iterator<ServiceListener> it = this.serviceListeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                cloudServiceListener = null;
                break;
            }
            ServiceListener next = it.next();
            if (next instanceof CloudServiceListener) {
                cloudServiceListener = (CloudServiceListener) next;
                break;
            }
        }
        if (cloudServiceListener == null) {
            return;
        }
        cloudServiceListener.handleEvent(new CloudServiceEvent(this, CloudServiceState.forNumber(i10)));
    }

    private void removeServiceListener() {
        List<ServiceListener> list = this.serviceListeners;
        if (list != null && list.size() > 0) {
            this.serviceListeners.clear();
        }
    }

    @Deprecated
    public ARAnchor addAnchor(ARPose aRPose) {
        return createAnchor(aRPose);
    }

    public void addServiceListener(ServiceListener serviceListener) {
        if (this.serviceListeners.size() == 0) {
            nativeSetServiceCallback(this.mNativeHandle);
        }
        this.serviceListeners.add(serviceListener);
    }

    public void configure(ARConfigBase aRConfigBase) {
        if (aRConfigBase.mSession == null) {
            aRConfigBase.setSession(this);
        }
        nativeConfigure(this.mNativeHandle, aRConfigBase.mNativeHandle);
    }

    public Collection<ARAnchor> convertNativeAnchorsToCollection(long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(new ARAnchor(j10, this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public <T extends ARTrackable> Collection<T> convertNativeTrackablesToCollection(Class<T> cls, long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            ARTrackable aRTrackableCreateTrackable = createTrackable(j10);
            if (aRTrackableCreateTrackable != null) {
                arrayList.add(cls.cast(aRTrackableCreateTrackable));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public ARAnchor createAnchor(ARPose aRPose) {
        return new ARAnchor(nativeCreateAnchor(this.mNativeHandle, aRPose), this);
    }

    public ARTrackable createTrackable(long j10) {
        switch (ARTrackableBase.internalGetType(this.mNativeHandle, j10)) {
            case AR_TRACKABLE_PLANE /* 1095893249 */:
                Log.d(TAG, "createTrackable: plane");
                return new ARPlane(j10, this);
            case AR_TRACKABLE_POINT /* 1095893250 */:
                Log.d(TAG, "createTrackable: point");
                return new ARPoint(j10, this);
            case AR_TRACKABLE_IMAGE /* 1095893252 */:
                Log.d(TAG, "createTrackable: point");
                return new ARAugmentedImage(j10, this);
            case AR_TRACKABLE_HAND /* 1342177280 */:
                Log.d(TAG, "createTrackable: hand");
                return new ARHand(j10, this);
            case AR_TRACKABLE_BODY /* 1342177281 */:
                Log.d(TAG, "createTrackable: body");
                return new ARBody(j10, this);
            case AR_TRACKABLE_FACE /* 1342177282 */:
                Log.d(TAG, "createTrackable: face");
                return new ARFace(j10, this);
            case AR_TRACKABLE_OBJECT /* 1342177285 */:
                Log.d(TAG, "createTrackable: object");
                return new ARObject(j10, this);
            case AR_TRACKABLE_TARGET /* 1342177288 */:
                Log.d(TAG, "createTrackable: target");
                return new ARTarget(j10, this);
            default:
                ARTrackableBase.internalReleaseNativeHandle(j10);
                return null;
        }
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroySession(j10);
        }
        super.finalize();
    }

    public Collection<ARAnchor> getAllAnchors() {
        return convertNativeAnchorsToCollection(nativeAcquireAllAnchors(this.mNativeHandle));
    }

    @Deprecated
    public Collection<ARPlane> getAllPlanes() {
        return getAllTrackables(ARPlane.class);
    }

    public <T extends ARTrackable> Collection<T> getAllTrackables(Class<T> cls) {
        int nativeTrackableFilterFromClass = getNativeTrackableFilterFromClass(cls);
        return nativeTrackableFilterFromClass == -1 ? Collections.emptyList() : convertNativeTrackablesToCollection(cls, nativeAcquireAllTrackables(this.mNativeHandle, nativeTrackableFilterFromClass));
    }

    public ARCameraConfig getCameraConfig() {
        return new ARCameraConfig(this, nativeGetCameraConfig(this.mNativeHandle));
    }

    @Deprecated
    public void getProjectionMatrix(float[] fArr, int i10, float f10, float f11) {
        synchronized (this.syncObject) {
            this.mLastFrame.mCamera.getProjectionMatrix(fArr, i10, f10, f11);
        }
    }

    public int getSupportedSemanticMode() {
        return nativeGetSupportedSemanticMode(this.mNativeHandle);
    }

    @Deprecated
    public boolean isSupported(ARConfigBase aRConfigBase) {
        if (aRConfigBase == null) {
            throw new IllegalArgumentException();
        }
        if (aRConfigBase.mSession == null) {
            aRConfigBase.setSession(this);
        }
        return nativeIsSupported(this.mNativeHandle, aRConfigBase.mNativeHandle);
    }

    public void nativeUpdate4Unity(long j10, long j11) {
        nativeUpdate(j10, j11);
    }

    public void notifyFaceHealthCheckStateToListener(int i10) {
        FaceHealthServiceListener validFaceHealthServiceListener = getValidFaceHealthServiceListener();
        if (validFaceHealthServiceListener == null) {
            return;
        }
        validFaceHealthServiceListener.handleEvent(new FaceHealthCheckStateEvent(this, FaceHealthCheckState.forNumber(i10)));
    }

    public void notifyFaceHealthProcessProgressToListener(int i10) {
        FaceHealthServiceListener validFaceHealthServiceListener = getValidFaceHealthServiceListener();
        if (validFaceHealthServiceListener == null) {
            return;
        }
        validFaceHealthServiceListener.handleProcessProgressEvent(i10);
    }

    public void pause() {
        nativePause(this.mNativeHandle);
    }

    @Deprecated
    public void removeAnchors(Collection<ARAnchor> collection) {
        if (collection == null) {
            return;
        }
        Iterator<ARAnchor> it = collection.iterator();
        while (it.hasNext()) {
            it.next().detach();
        }
    }

    public void resume() {
        nativeResume(this.mNativeHandle);
    }

    public void setCameraTextureName(int i10) {
        nativeSetCameraTextureName(this.mNativeHandle, i10);
    }

    public void setCloudServiceAuthInfo(String str) {
        nativeSetCloudServiceAuthInfo(this.mNativeHandle, str);
    }

    @Deprecated
    public void setDisplayGeometry(float f10, float f11) {
        if (f10 <= 0.0f || f11 <= 0.0f) {
            Log.e(TAG, "setDisplayGeometry: width or height is less than or equal to zero");
            throw new IllegalArgumentException("width or height must be greater than zero");
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            setDisplayGeometry(((Activity) context).getWindowManager().getDefaultDisplay().getRotation(), (int) f10, (int) f11);
        } else {
            Log.e(TAG, "The Context set to this session should be instance of Activity whilecalling setDisplayGeometry(float width, float height)");
            throw new IllegalStateException("context should be instance of Activity");
        }
    }

    public void setEnvironmentTextureProbe(float[] fArr) {
        nativeSetEnvironmentTextureProbe(this.mNativeHandle, fArr);
    }

    public void setEnvironmentTextureUpdateMode(EnvironmentTextureUpdateMode environmentTextureUpdateMode) {
        nativeSetEnvironmentTextureUpdateMode(this.mNativeHandle, environmentTextureUpdateMode.mNativeCode);
    }

    public void stop() {
        nativeStop(this.mNativeHandle);
        removeServiceListener();
    }

    public ARFrame update() {
        ARFrame aRFrame;
        synchronized (this.syncObject) {
            ARFrame aRFrame2 = new ARFrame(this);
            this.mLastFrame = aRFrame2;
            nativeUpdate(this.mNativeHandle, aRFrame2.mNativeHandle);
            this.mLastFrame.initCamera();
            this.mLastFrame.initLightEstimate();
            aRFrame = this.mLastFrame;
        }
        return aRFrame;
    }

    @Deprecated
    public void resume(ARConfigBase aRConfigBase) {
        if (this.mContext.checkSelfPermission("android.permission.CAMERA") != 0) {
            throw new ARCameraPermissionDeniedException();
        }
        if (aRConfigBase == null) {
            throw new ARUnSupportedConfigurationException();
        }
        if (aRConfigBase.mSession == null) {
            aRConfigBase.setSession(this);
        }
        configure(aRConfigBase);
        resume();
    }

    public void setDisplayGeometry(int i10, int i11, int i12) {
        if (i10 < 0 || i10 > 3) {
            Log.e(TAG, String.format(Locale.ENGLISH, "setDisplayGeometry: displayRotation %d out of range(0~3)", Integer.valueOf(i10)));
            throw new IllegalArgumentException("displayRoation is out of range");
        }
        if (i11 <= 0 || i12 <= 0) {
            Log.e(TAG, "setDisplayGeometry: width or height is less than or equal to zero");
            throw new IllegalArgumentException("width or height must be greater than zero");
        }
        nativeSetDisplayGeometry(this.mNativeHandle, i10, i11, i12);
    }
}
