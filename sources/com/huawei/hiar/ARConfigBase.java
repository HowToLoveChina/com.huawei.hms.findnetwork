package com.huawei.hiar;

import android.util.Log;
import android.view.Surface;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public abstract class ARConfigBase {
    private static final String[] AR_TYPE_STRINGS = {"worldAR", "bodyAR", "handGestureAR", "handSkeletonAR", "faceAR", "imageAR"};
    public static final String AR_TYPE_UNSUPPORTED_MESSAGE = "ARType is unsupported.";
    protected static final int BODY_AR = 2;
    private static final int DEFAULT_SIZE = 16;
    public static final int ENABLE_CLOUD_ANCHOR = 16;
    public static final int ENABLE_CLOUD_AUGMENTED_IMAGE = 32;
    public static final int ENABLE_CLOUD_OBJECT_RECOGNITION = 1024;
    public static final int ENABLE_DEPTH = 1;
    public static final int ENABLE_FLASH_MODE_TORCH = 128;
    public static final int ENABLE_HEALTH_DEVICE = 64;
    public static final int ENABLE_MASK = 2;
    public static final int ENABLE_MESH = 4;
    public static final int ENABLE_NULL = 0;
    protected static final int FACE_AR = 16;
    protected static final int HAND_AR = 4;
    protected static final int IMAGE_AR = 128;
    protected static final int INSTANT_AR = 512;
    public static final int LIGHT_MODE_ALL = 65535;
    public static final int LIGHT_MODE_AMBIENT_INTENSITY = 1;
    public static final int LIGHT_MODE_ENVIRONMENT_LIGHTING = 2;
    public static final int LIGHT_MODE_ENVIRONMENT_TEXTURE = 4;
    public static final int LIGHT_MODE_NONE = 0;
    private static final String M_SESSION_IS_NULL = "mSession is null!";
    public static final int OFFSET_1 = 1;
    public static final int OFFSET_10 = 10;
    public static final int OFFSET_2 = 2;
    public static final int OFFSET_3 = 3;
    public static final int OFFSET_4 = 4;
    public static final int OFFSET_5 = 5;
    public static final int OFFSET_6 = 6;
    public static final int OFFSET_7 = 7;
    public static final int OFFSET_9 = 9;

    @Deprecated
    public static final int SEMANTIC_BOX = 2;
    public static final int SEMANTIC_NONE = 0;
    public static final int SEMANTIC_PLANE = 1;
    public static final int SEMANTIC_TARGET = 2;
    private static final String TAG = "ARConfigBase";
    protected static final int WORLD_AR = 1;
    long mNativeHandle;
    ARSession mSession;

    public enum CameraLensFacing {
        UNKNOWN(-1),
        REAR(0),
        FRONT(1);

        final int nativeCode;

        CameraLensFacing(int i10) {
            this.nativeCode = i10;
        }

        public static CameraLensFacing forNumber(int i10) {
            for (CameraLensFacing cameraLensFacing : values()) {
                if (cameraLensFacing.nativeCode == i10) {
                    return cameraLensFacing;
                }
            }
            return UNKNOWN;
        }
    }

    public enum FaceDetectMode {
        UNKNOWN_MODE(-1),
        HEALTH_ENABLE_HEART_RATE(1),
        HEALTH_ENABLE_BREATH_RATE(2),
        HEALTH_ENABLE_LIVE_DETECTION(4),
        HEALTH_ENABLE_DEFAULT(7),
        HEALTH_ENABLE_SP02(8),
        HEALTH_ENABLE_STRESS(16),
        FACE_ENABLE_MESH(256),
        FACE_ENABLE_BLEND_SHAPE(512),
        FACE_ENABLE_MULTIFACE(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLSX),
        FACE_ENABLE_DEFAULT(768);

        final long mNativeCode;

        FaceDetectMode(long j10) {
            this.mNativeCode = j10;
        }

        public static FaceDetectMode forNumber(long j10) {
            for (FaceDetectMode faceDetectMode : values()) {
                if (faceDetectMode.mNativeCode == j10) {
                    return faceDetectMode;
                }
            }
            return UNKNOWN_MODE;
        }

        public long getEnumValue() {
            return this.mNativeCode;
        }
    }

    public enum FocusMode {
        UNKNOWN(-1),
        FIXED_FOCUS(0),
        AUTO_FOCUS(1);

        final int mNativeCode;

        FocusMode(int i10) {
            this.mNativeCode = i10;
        }

        public static FocusMode forNumber(int i10) {
            for (FocusMode focusMode : values()) {
                if (focusMode.mNativeCode == i10) {
                    return focusMode;
                }
            }
            return UNKNOWN;
        }
    }

    @Deprecated
    public enum HandFindingMode {
        UNKNOWN_MODE(-1),
        DISABLED(0),
        ENABLE_2D(1),
        ENABLE_3D(2);

        final int mNativeCode;

        HandFindingMode(int i10) {
            this.mNativeCode = i10;
        }

        public static HandFindingMode forNumber(int i10) {
            for (HandFindingMode handFindingMode : values()) {
                if (handFindingMode.mNativeCode == i10) {
                    return handFindingMode;
                }
            }
            return UNKNOWN_MODE;
        }
    }

    public enum ImageInputMode {
        UNKNOWN_INPUT_MODE(-2),
        NON_INPUT(0),
        EXTERNAL_INPUT_ALL(-1);

        final int mNativeCode;

        ImageInputMode(int i10) {
            this.mNativeCode = i10;
        }

        public static ImageInputMode forNumber(int i10) {
            for (ImageInputMode imageInputMode : values()) {
                if (imageInputMode.mNativeCode == i10) {
                    return imageInputMode;
                }
            }
            return UNKNOWN_INPUT_MODE;
        }
    }

    public enum PlaneFindingMode {
        UNKNOWN(-1),
        DISABLED(0),
        ENABLE(3),
        HORIZONTAL_ONLY(1),
        VERTICAL_ONLY(2);

        final int mNativeCode;

        PlaneFindingMode(int i10) {
            this.mNativeCode = i10;
        }

        public static PlaneFindingMode forNumber(int i10) {
            for (PlaneFindingMode planeFindingMode : values()) {
                if (planeFindingMode.mNativeCode == i10) {
                    return planeFindingMode;
                }
            }
            return UNKNOWN;
        }
    }

    public enum PowerMode {
        UNKNOWN(-1),
        NORMAL(0),
        POWER_SAVING(1),
        ULTRA_POWER_SAVING(2),
        PERFORMANCE_FIRST(3);

        final int mNativeCode;

        PowerMode(int i10) {
            this.mNativeCode = i10;
        }

        public static PowerMode forNumber(int i10) {
            for (PowerMode powerMode : values()) {
                if (powerMode.mNativeCode == i10) {
                    return powerMode;
                }
            }
            return UNKNOWN;
        }
    }

    public enum SurfaceType {
        UNKNOWN_SURFACE_TYPE(-1),
        PREVIEW(0),
        VGA(1),
        METADATA(2),
        DEPTH(4);

        final int mNativeCode;

        SurfaceType(int i10) {
            this.mNativeCode = i10;
        }

        public static SurfaceType forNumber(int i10) {
            for (SurfaceType surfaceType : values()) {
                if (surfaceType.mNativeCode == i10) {
                    return surfaceType;
                }
            }
            return UNKNOWN_SURFACE_TYPE;
        }
    }

    public enum UpdateMode {
        UNKNOWN(-1),
        BLOCKING(0),
        LATEST_CAMERA_IMAGE(1);

        final int mNativeCode;

        UpdateMode(int i10) {
            this.mNativeCode = i10;
        }

        public static UpdateMode forNumber(int i10) {
            for (UpdateMode updateMode : values()) {
                if (updateMode.mNativeCode == i10) {
                    return updateMode;
                }
            }
            return UNKNOWN;
        }
    }

    public ARConfigBase() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private int getArType() {
        return nativeGetArType(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    private String getArTypeString() {
        StringBuilder sb2 = new StringBuilder(16);
        int arType = getArType();
        int i10 = 1;
        for (String str : AR_TYPE_STRINGS) {
            if ((arType & i10) > 0) {
                sb2.append(str);
            }
            i10 <<= 1;
        }
        return sb2.toString();
    }

    private static native long nativeCreate(long j10);

    private static native void nativeDestroy(long j10);

    private native int nativeGetArType(long j10, long j11);

    private native long nativeGetAugmentedImageDatabase(long j10, long j11);

    private native int nativeGetCameraLensFacing(long j10, long j11);

    private native long nativeGetEnableItem(long j10, long j11);

    private native long nativeGetFaceDetectMode(long j10, long j11);

    private native int nativeGetFocusMode(long j10, long j11);

    private native int nativeGetHandFindingMode(long j10, long j11);

    private native int nativeGetImageInputMode(long j10, long j11);

    private native int[] nativeGetInputSurfaceTypes(long j10, long j11);

    private native Surface[] nativeGetInputSurfaces(long j10, long j11);

    private native int nativeGetLightEstimationMode(long j10, long j11);

    private native long nativeGetMaxMapSize(long j10, long j11);

    private native int nativeGetPlaneFindingMode(long j10, long j11);

    private native int nativeGetPowerMode(long j10, long j11);

    private native int nativeGetSemanticMode(long j10, long j11);

    private native int nativeGetUpdateMode(long j10, long j11);

    private native void nativeSetArType(long j10, long j11, int i10);

    private native void nativeSetAugmentedImageDatabase(long j10, long j11, long j12);

    private native void nativeSetCameraLensFacing(long j10, long j11, int i10);

    private native void nativeSetEnableItem(long j10, long j11, long j12);

    private native void nativeSetFaceDetectMode(long j10, long j11, long j12);

    private native void nativeSetFocusMode(long j10, long j11, int i10);

    private native void nativeSetHandFindingMode(long j10, long j11, int i10);

    private native void nativeSetImageInputMode(long j10, long j11, int i10);

    private native void nativeSetLightEstimationMode(long j10, long j11, int i10);

    private native void nativeSetMaxMapSize(long j10, long j11, long j12);

    private native void nativeSetPlaneFindingMode(long j10, long j11, int i10);

    private native void nativeSetPowerMode(long j10, long j11, int i10);

    private native void nativeSetPreviewSize(long j10, long j11, int i10, int i11);

    private native void nativeSetSemanticMode(long j10, long j11, int i10);

    private native void nativeSetUpdateMode(long j10, long j11, int i10);

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroy(j10);
        }
        super.finalize();
    }

    public ARAugmentedImageDatabase getAugmentedImageDatabase() {
        long jNativeGetAugmentedImageDatabase = nativeGetAugmentedImageDatabase(this.mSession.mNativeHandle, this.mNativeHandle);
        if (jNativeGetAugmentedImageDatabase == 0) {
            return null;
        }
        return new ARAugmentedImageDatabase(this.mSession, jNativeGetAugmentedImageDatabase);
    }

    public CameraLensFacing getCameraLensFacing() {
        return CameraLensFacing.forNumber(nativeGetCameraLensFacing(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public long getEnableItem() {
        return nativeGetEnableItem(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public long getFaceDetectMode() {
        return nativeGetFaceDetectMode(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public FocusMode getFocusMode() {
        return FocusMode.forNumber(nativeGetFocusMode(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    @Deprecated
    public HandFindingMode getHandFindingMode() {
        return HandFindingMode.forNumber(nativeGetHandFindingMode(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public ImageInputMode getImageInputMode() {
        ARSession aRSession = this.mSession;
        if (aRSession != null) {
            return ImageInputMode.forNumber(nativeGetImageInputMode(aRSession.mNativeHandle, this.mNativeHandle));
        }
        Log.e(TAG, M_SESSION_IS_NULL);
        throw new IllegalArgumentException(M_SESSION_IS_NULL);
    }

    public List<SurfaceType> getImageInputSurfaceTypes() {
        ARSession aRSession = this.mSession;
        if (aRSession == null) {
            Log.e(TAG, M_SESSION_IS_NULL);
            throw new IllegalArgumentException(M_SESSION_IS_NULL);
        }
        int[] iArrNativeGetInputSurfaceTypes = nativeGetInputSurfaceTypes(aRSession.mNativeHandle, this.mNativeHandle);
        ArrayList arrayList = new ArrayList(iArrNativeGetInputSurfaceTypes.length);
        for (int i10 : iArrNativeGetInputSurfaceTypes) {
            arrayList.add(SurfaceType.forNumber(i10));
        }
        return arrayList;
    }

    public List<Surface> getImageInputSurfaces() {
        ARSession aRSession = this.mSession;
        if (aRSession != null) {
            return Arrays.asList(nativeGetInputSurfaces(aRSession.mNativeHandle, this.mNativeHandle));
        }
        Log.e(TAG, M_SESSION_IS_NULL);
        throw new IllegalArgumentException(M_SESSION_IS_NULL);
    }

    public int getLightingMode() {
        return nativeGetLightEstimationMode(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public long getMaxMapSize() {
        return nativeGetMaxMapSize(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public PlaneFindingMode getPlaneFindingMode() {
        return PlaneFindingMode.forNumber(nativeGetPlaneFindingMode(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public PowerMode getPowerMode() {
        return PowerMode.forNumber(nativeGetPowerMode(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public int getSemanticMode() {
        return nativeGetSemanticMode(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public UpdateMode getUpdateMode() {
        return UpdateMode.forNumber(nativeGetUpdateMode(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public void setArType(int i10) {
        ARSession aRSession = this.mSession;
        if (aRSession != null) {
            nativeSetArType(aRSession.mNativeHandle, this.mNativeHandle, i10);
        } else {
            Log.e(TAG, M_SESSION_IS_NULL);
            throw new IllegalArgumentException(M_SESSION_IS_NULL);
        }
    }

    public void setAugmentedImageDatabase(ARAugmentedImageDatabase aRAugmentedImageDatabase) {
        nativeSetAugmentedImageDatabase(this.mSession.mNativeHandle, this.mNativeHandle, aRAugmentedImageDatabase.mNativeDatabaseHandle);
    }

    public void setCameraLensFacing(CameraLensFacing cameraLensFacing) {
        ARSession aRSession;
        if (cameraLensFacing == null || (aRSession = this.mSession) == null) {
            Log.e(TAG, "Parameter is null!");
            throw new IllegalArgumentException("Parameter is null!");
        }
        nativeSetCameraLensFacing(aRSession.mNativeHandle, this.mNativeHandle, cameraLensFacing.nativeCode);
    }

    public void setEnableItem(long j10) {
        nativeSetEnableItem(this.mSession.mNativeHandle, this.mNativeHandle, j10);
    }

    public void setFaceDetectMode(long j10) {
        nativeSetFaceDetectMode(this.mSession.mNativeHandle, this.mNativeHandle, j10);
    }

    public void setFocusMode(FocusMode focusMode) {
        nativeSetFocusMode(this.mSession.mNativeHandle, this.mNativeHandle, focusMode.mNativeCode);
    }

    @Deprecated
    public void setHandFindingMode(HandFindingMode handFindingMode) {
        nativeSetHandFindingMode(this.mSession.mNativeHandle, this.mNativeHandle, handFindingMode.mNativeCode);
    }

    public void setImageInputMode(ImageInputMode imageInputMode) {
        ARSession aRSession = this.mSession;
        if (aRSession != null) {
            nativeSetImageInputMode(aRSession.mNativeHandle, this.mNativeHandle, imageInputMode.mNativeCode);
        } else {
            Log.e(TAG, M_SESSION_IS_NULL);
            throw new IllegalArgumentException(M_SESSION_IS_NULL);
        }
    }

    public void setLightingMode(int i10) {
        nativeSetLightEstimationMode(this.mSession.mNativeHandle, this.mNativeHandle, i10);
    }

    public void setMaxMapSize(long j10) {
        nativeSetMaxMapSize(this.mSession.mNativeHandle, this.mNativeHandle, j10);
    }

    public void setPlaneFindingMode(PlaneFindingMode planeFindingMode) {
        nativeSetPlaneFindingMode(this.mSession.mNativeHandle, this.mNativeHandle, planeFindingMode.mNativeCode);
    }

    public void setPowerMode(PowerMode powerMode) {
        nativeSetPowerMode(this.mSession.mNativeHandle, this.mNativeHandle, powerMode.mNativeCode);
    }

    public void setPreviewSize(int i10, int i11) {
        nativeSetPreviewSize(this.mSession.mNativeHandle, this.mNativeHandle, i10, i11);
        ARServiceProxy.setPreviewSize(i10, i11);
    }

    public void setSemanticMode(int i10) {
        nativeSetSemanticMode(this.mSession.mNativeHandle, this.mNativeHandle, i10);
    }

    public void setSession(ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeHandle = nativeCreate(aRSession.mNativeHandle);
    }

    public void setUpdateMode(UpdateMode updateMode) {
        nativeSetUpdateMode(this.mSession.mNativeHandle, this.mNativeHandle, updateMode.mNativeCode);
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ARConfigBase: { AR type %s, CameraLensFacing=%s, UpdateMode=%s,  LightingMode=%s, PlaneFindingMode=%s }", getArTypeString(), getCameraLensFacing(), getUpdateMode(), Integer.valueOf(getLightingMode()), getPlaneFindingMode());
    }

    public ARConfigBase(ARSession aRSession) {
        if (aRSession == null) {
            Log.e(TAG, M_SESSION_IS_NULL);
            throw new IllegalArgumentException(M_SESSION_IS_NULL);
        }
        this.mSession = aRSession;
        this.mNativeHandle = nativeCreate(aRSession.mNativeHandle);
    }
}
