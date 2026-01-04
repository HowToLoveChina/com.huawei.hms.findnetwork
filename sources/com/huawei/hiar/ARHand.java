package com.huawei.hiar;

import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARHand extends ARTrackableBase {
    static final String TAG = "ARHand";

    public enum ARHandSkeletonType {
        HANDSKELETON_UNKNOWN(-1),
        HANDSKELETON_ROOT(0),
        HANDSKELETON_PINKY_1(1),
        HANDSKELETON_PINKY_2(2),
        HANDSKELETON_PINKY_3(3),
        HANDSKELETON_PINKY_4(4),
        HANDSKELETON_RING_1(5),
        HANDSKELETON_RING_2(6),
        HANDSKELETON_RING_3(7),
        HANDSKELETON_RING_4(8),
        HANDSKELETON_MIDDLE_1(9),
        HANDSKELETON_MIDDLE_2(10),
        HANDSKELETON_MIDDLE_3(11),
        HANDSKELETON_MIDDLE_4(12),
        HANDSKELETON_INDEX_1(13),
        HANDSKELETON_INDEX_2(14),
        HANDSKELETON_INDEX_3(15),
        HANDSKELETON_INDEX_4(16),
        HANDSKELETON_THUMB_1(17),
        HANDSKELETON_THUMB_2(18),
        HANDSKELETON_THUMB_3(19),
        HANDSKELETON_THUMB_4(20),
        HANDSKELETON_LENGTH(21);

        final int nativeCode;

        ARHandSkeletonType(int i10) {
            this.nativeCode = i10;
        }

        public static ARHandSkeletonType forNumber(int i10) {
            for (ARHandSkeletonType aRHandSkeletonType : values()) {
                if (aRHandSkeletonType.nativeCode == i10) {
                    return aRHandSkeletonType;
                }
            }
            return HANDSKELETON_UNKNOWN;
        }
    }

    public enum ARHandType {
        AR_HAND_UNKNOWN(-1),
        AR_HAND_RIGHT(0),
        AR_HAND_LEFT(1);

        final int nativeCode;

        ARHandType(int i10) {
            this.nativeCode = i10;
        }

        public static ARHandType forNumber(int i10) {
            for (ARHandType aRHandType : values()) {
                if (aRHandType.nativeCode == i10) {
                    return aRHandType;
                }
            }
            return AR_HAND_UNKNOWN;
        }

        public int getKeyValues() {
            return this.nativeCode;
        }
    }

    public ARHand(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }

    private native int[] nativeGetGestureAction(long j10, long j11);

    private native float[] nativeGetGestureCenter(long j10, long j11);

    private native int nativeGetGestureCoordinateSystem(long j10, long j11);

    private native float[] nativeGetGestureHandBox(long j10, long j11);

    private native float[] nativeGetGestureOrientation(long j10, long j11);

    private native int nativeGetGestureType(long j10, long j11);

    private native int nativeGetHandId(long j10, long j11);

    private native float[] nativeGetHandSkeletonArray(long j10, long j11);

    private native int[] nativeGetHandSkeletonConnection(long j10, long j11);

    private native int[] nativeGetHandSkeletonType(long j10, long j11);

    private native int nativeGetHandType(long j10, long j11);

    private native int nativeGetSkeletonCoordinateSystem(long j10, long j11);

    @Override // com.huawei.hiar.ARTrackableBase
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.huawei.hiar.ARTrackableBase
    public void finalize() throws Throwable {
        super.finalize();
    }

    public int[] getGestureAction() {
        return nativeGetGestureAction(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getGestureCenter() {
        return nativeGetGestureCenter(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARCoordinateSystemType getGestureCoordinateSystem() {
        return ARCoordinateSystemType.forNumber(nativeGetGestureCoordinateSystem(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public float[] getGestureHandBox() {
        return nativeGetGestureHandBox(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getGestureOrientation() {
        return nativeGetGestureOrientation(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int getGestureType() {
        return nativeGetGestureType(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    @Deprecated
    public int getHandID() {
        return nativeGetHandId(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int[] getHandSkeletonConnection() {
        return nativeGetHandSkeletonConnection(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getHandskeletonArray() {
        return nativeGetHandSkeletonArray(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARHandSkeletonType[] getHandskeletonTypes() {
        int[] iArrNativeGetHandSkeletonType = nativeGetHandSkeletonType(this.mSession.mNativeHandle, this.mNativeHandle);
        if (iArrNativeGetHandSkeletonType == null) {
            return new ARHandSkeletonType[0];
        }
        ARHandSkeletonType[] aRHandSkeletonTypeArr = new ARHandSkeletonType[iArrNativeGetHandSkeletonType.length];
        for (int i10 = 0; i10 < iArrNativeGetHandSkeletonType.length; i10++) {
            aRHandSkeletonTypeArr[i10] = ARHandSkeletonType.forNumber(iArrNativeGetHandSkeletonType[i10]);
        }
        return aRHandSkeletonTypeArr;
    }

    public ARHandType getHandtype() {
        return ARHandType.forNumber(nativeGetHandType(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public ARCoordinateSystemType getSkeletonCoordinateSystem() {
        return ARCoordinateSystemType.forNumber(nativeGetSkeletonCoordinateSystem(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    @Override // com.huawei.hiar.ARTrackableBase
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.huawei.hiar.ARTrackableBase
    public String toString() {
        return String.format(Locale.ENGLISH, "ARHand{ coordinate: %d, handType: %d,gestureType:%d, handBox:%s , center:%s, action:%s, eulerAngle:%s} %n", Integer.valueOf(getGestureCoordinateSystem().getKeyValues()), Integer.valueOf(getHandtype().getKeyValues()), Integer.valueOf(getGestureType()), Arrays.toString(getGestureHandBox()), Arrays.toString(getGestureCenter()), Arrays.toString(getGestureAction()), Arrays.toString(getGestureOrientation()));
    }
}
