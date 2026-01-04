package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;
import java.util.HashMap;

/* loaded from: classes5.dex */
public final class ARFace extends ARTrackableBase {
    private static final int DEFAULT_SIZE = 60;
    private static final int MAX_PROGRESS = 100;
    private static final int PARAMETER_FACE_HEALTH_CHECK_STATUS = 13;
    private static final int PARAMETER_FACE_HEALTH_PROC_PROGRESS = 14;

    public enum HealthParameter {
        UNKNOWN_TYPE(-1),
        PARAMETER_INVALID(0),
        PARAMETER_HEART_RATE(1),
        PARAMETER_HEART_RATE_SNR(2),
        PARAMETER_HEART_RATE_CONFIDENCE(3),
        PARAMETER_BREATH_RATE(4),
        PARAMETER_BREATH_RATE_SNR(5),
        PARAMETER_BREATH_RATE_CONFIDENCE(6),
        PARAMETER_FACE_AGE(7),
        PARAMETER_GENDER_MALE_WEIGHT(8),
        PARAMETER_GENDER_FEMALE_WEIGHT(9),
        PARAMETER_HEART_WAVE(15),
        PARAMETER_SPO2_VALUE(16);

        final int nativeCode;

        HealthParameter(int i10) {
            this.nativeCode = i10;
        }

        public static HealthParameter forNumber(int i10) {
            for (HealthParameter healthParameter : values()) {
                if (healthParameter.nativeCode == i10) {
                    return healthParameter;
                }
            }
            return UNKNOWN_TYPE;
        }
    }

    private ARFace() {
        super(0L, null);
    }

    private native long nativeAcquireBlendShapes(long j10, long j11);

    private native long nativeAcquireGeometry(long j10, long j11);

    private native int nativeGetHealthParameterCount(long j10, long j11);

    private native int[] nativeGetHealthParameterTypeArray(long j10, long j11);

    private native float[] nativeGetHealthParameterValueArray(long j10, long j11);

    private native ARPose nativeGetPose(long j10, long j11);

    public ARFaceBlendShapes getFaceBlendShapes() {
        return new ARFaceBlendShapes(this.mSession, nativeAcquireBlendShapes(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public ARFaceGeometry getFaceGeometry() {
        return new ARFaceGeometry(this.mSession, nativeAcquireGeometry(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public int getHealthParameterCount() {
        return nativeGetHealthParameterCount(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public HashMap<HealthParameter, Float> getHealthParameters() {
        float[] fArrNativeGetHealthParameterValueArray = nativeGetHealthParameterValueArray(this.mSession.mNativeHandle, this.mNativeHandle);
        int[] iArrNativeGetHealthParameterTypeArray = nativeGetHealthParameterTypeArray(this.mSession.mNativeHandle, this.mNativeHandle);
        if (iArrNativeGetHealthParameterTypeArray.length != fArrNativeGetHealthParameterValueArray.length) {
            throw new ARFatalException("Unexpected array length!");
        }
        HashMap<HealthParameter, Float> map = new HashMap<>(60);
        for (int i10 = 0; i10 < iArrNativeGetHealthParameterTypeArray.length; i10++) {
            int i11 = iArrNativeGetHealthParameterTypeArray[i10];
            if (i11 == 13) {
                this.mSession.notifyFaceHealthCheckStateToListener((int) Math.floor(fArrNativeGetHealthParameterValueArray[i10]));
            } else if (i11 == 14) {
                int iFloor = (int) Math.floor(fArrNativeGetHealthParameterValueArray[i10] * 100.0f);
                if (iFloor >= 100) {
                    iFloor = 100;
                }
                this.mSession.notifyFaceHealthProcessProgressToListener(iFloor);
            } else {
                map.put(HealthParameter.forNumber(i11), Float.valueOf(fArrNativeGetHealthParameterValueArray[i10]));
            }
        }
        return map;
    }

    public ARPose getPose() {
        return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARFace(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }
}
