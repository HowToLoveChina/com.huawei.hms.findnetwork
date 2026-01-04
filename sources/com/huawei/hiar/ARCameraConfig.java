package com.huawei.hiar;

import android.annotation.TargetApi;
import android.util.Size;
import java.util.Locale;

@TargetApi(21)
/* loaded from: classes5.dex */
public class ARCameraConfig {
    long mNativeHandle;
    final ARSession mSession;

    private ARCameraConfig() {
        this.mSession = null;
        this.mNativeHandle = 0L;
    }

    private static native void nativeDestroy(long j10);

    private native int[] nativeGetImageDimensions(long j10, long j11);

    private native int[] nativeGetTextureDimensions(long j10, long j11);

    public boolean equals(Object obj) {
        return (obj instanceof ARCameraConfig) && ((ARCameraConfig) obj).mNativeHandle == this.mNativeHandle;
    }

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroy(j10);
        }
        super.finalize();
    }

    public Size getImageDimensions() {
        int[] iArrNativeGetImageDimensions = nativeGetImageDimensions(this.mSession.mNativeHandle, this.mNativeHandle);
        return new Size(iArrNativeGetImageDimensions[0], iArrNativeGetImageDimensions[1]);
    }

    public Size getTextureDimensions() {
        int[] iArrNativeGetTextureDimensions = nativeGetTextureDimensions(this.mSession.mNativeHandle, this.mNativeHandle);
        return new Size(iArrNativeGetTextureDimensions[0], iArrNativeGetTextureDimensions[1]);
    }

    public int hashCode() {
        return Long.valueOf(this.mNativeHandle).hashCode();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ARCameraConfig: {handle=0x%x, ImageDimensions=(%d,%d), TextureDimensions=(%d,%d)}", Long.valueOf(this.mNativeHandle), Integer.valueOf(getImageDimensions().getWidth()), Integer.valueOf(getImageDimensions().getHeight()), Integer.valueOf(getTextureDimensions().getWidth()), Integer.valueOf(getTextureDimensions().getHeight()));
    }

    public ARCameraConfig(ARSession aRSession, long j10) {
        this.mSession = aRSession;
        this.mNativeHandle = j10;
    }
}
