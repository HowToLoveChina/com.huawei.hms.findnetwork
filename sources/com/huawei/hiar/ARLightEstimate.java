package com.huawei.hiar;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARLightEstimate {
    static final String TAG = "ARLightEstimate";
    long mNativeHandle;
    private final ARSession mSession;

    public enum LightShadowType {
        SHDOW_TYPE_UNKNOW(-1),
        SHADOW_TYPE_NONE(0),
        SHADOW_TYPE_HARD(1),
        SHADOW_TYPE_SOFT(2);

        final int nativeCode;

        LightShadowType(int i10) {
            this.nativeCode = i10;
        }

        public static LightShadowType forNumber(int i10) {
            for (LightShadowType lightShadowType : values()) {
                if (lightShadowType.nativeCode == i10) {
                    return lightShadowType;
                }
            }
            return SHDOW_TYPE_UNKNOW;
        }
    }

    public enum State {
        UNKNOWN_STATE(-1),
        NOT_VALID(0),
        VALID(1);

        final int nativeCode;

        State(int i10) {
            this.nativeCode = i10;
        }

        public static State forNumber(int i10) {
            for (State state : values()) {
                if (state.nativeCode == i10) {
                    return state;
                }
            }
            return UNKNOWN_STATE;
        }
    }

    public ARLightEstimate() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private native ByteBuffer nativeAcquireEnvironmentTexture(long j10, long j11);

    private static native long nativeCreateLightEstimate(long j10);

    private static native void nativeDestroyLightEstimate(long j10);

    private native int nativeGetLightShadowType(long j10, long j11);

    private native float nativeGetPixelIntensity(long j10, long j11);

    private native float[] nativeGetPrimaryLightDirection(long j10, long j11);

    private native float nativeGetPrimaryLightIntensity(long j10, long j11);

    private native float nativeGetShadowStrength(long j10, long j11);

    private native float[] nativeGetSphericalHarmonicCoefficients(long j10, long j11);

    private native int nativeGetState(long j10, long j11);

    private native float[] nativegetPrimaryLightColor(long j10, long j11);

    public ByteBuffer acquireEnvironmentTexture() {
        ByteBuffer byteBufferNativeAcquireEnvironmentTexture = nativeAcquireEnvironmentTexture(this.mSession.mNativeHandle, this.mNativeHandle);
        if (byteBufferNativeAcquireEnvironmentTexture != null) {
            return byteBufferNativeAcquireEnvironmentTexture.asReadOnlyBuffer();
        }
        Log.e(TAG, "acquire environment texture is null.");
        return null;
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroyLightEstimate(j10);
        }
        super.finalize();
    }

    public LightShadowType getLightShadowType() {
        return LightShadowType.forNumber(nativeGetLightShadowType(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public float getPixelIntensity() {
        return nativeGetPixelIntensity(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getPrimaryLightColor() {
        return nativegetPrimaryLightColor(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getPrimaryLightDirection() {
        return nativeGetPrimaryLightDirection(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float getPrimaryLightIntensity() {
        return nativeGetPrimaryLightIntensity(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float getShadowStrength() {
        return nativeGetShadowStrength(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getSphericalHarmonicCoefficients() {
        return nativeGetSphericalHarmonicCoefficients(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public State getState() {
        return State.forNumber(nativeGetState(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    @Deprecated
    public boolean isValid() {
        return getState() == State.VALID;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ARLightEstimate: { handle= 0x%x, light estimate with state %s, intensity %s }", Long.valueOf(this.mNativeHandle), getState().name(), Float.valueOf(getPixelIntensity()));
    }

    public ARLightEstimate(ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeHandle = nativeCreateLightEstimate(aRSession.mNativeHandle);
    }
}
