package com.huawei.hiar;

import android.annotation.TargetApi;
import android.util.Size;
import com.huawei.hiar.exceptions.ARDeadlineExceededException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.Locale;

@TargetApi(21)
/* loaded from: classes5.dex */
public class ARBody extends ARTrackableBase {

    public enum ARBodySkeletonType {
        BodySkeleton_Unknown(-1),
        BodySkeleton_Head(0),
        BodySkeleton_Neck(1),
        BodySkeleton_r_Sho(2),
        BodySkeleton_r_Elbow(3),
        BodySkeleton_r_Wrist(4),
        BodySkeleton_l_Sho(5),
        BodySkeleton_l_Elbow(6),
        BodySkeleton_l_Wrist(7),
        BodySkeleton_r_Hip(8),
        BodySkeleton_r_Knee(9),
        BodySkeleton_r_Ankle(10),
        BodySkeleton_l_Hip(11),
        BodySkeleton_l_Knee(12),
        BodySkeleton_l_Ankle(13),
        BodySkeleton_Hip_mid(14),
        BodySkeleton_r_ear(15),
        BodySkeleton_r_eye(16),
        BodySkeleton_nose(17),
        BodySkeleton_l_eye(18),
        BodySkeleton_l_ear(19),
        BodySkeleton_spine(20),
        BodySkeleton_r_toe(21),
        BodySkeleton_l_toe(22),
        BodySkeleton_Length(23);

        final int nativeCode;

        ARBodySkeletonType(int i10) {
            this.nativeCode = i10;
        }

        public static ARBodySkeletonType forNumber(int i10) {
            for (ARBodySkeletonType aRBodySkeletonType : values()) {
                if (aRBodySkeletonType.nativeCode == i10) {
                    return aRBodySkeletonType;
                }
            }
            return BodySkeleton_Unknown;
        }
    }

    private ARBody() {
        super(0L, null);
    }

    private native int nativeGetBodyAction(long j10, long j11);

    private native int nativeGetBodyId(long j10, long j11);

    private native int nativeGetCoordinateSystemType(long j10, long j11);

    private native ByteBuffer nativeGetMaskConfidence(long j10, long j11, int i10);

    private native ByteBuffer nativeGetMaskDepth(long j10, long j11, int i10);

    private native int[] nativeGetSkeletonConnection(long j10, long j11);

    private native float[] nativeGetSkeletonPoint2D(long j10, long j11);

    private native float[] nativeGetSkeletonPoint3D(long j10, long j11);

    private native int[] nativeGetSkeletonPointIsExist2D(long j10, long j11);

    private native int[] nativeGetSkeletonPointIsExist3D(long j10, long j11);

    private native int[] nativeGetSkeletonType(long j10, long j11);

    private native float[] nativeSkeletonConfidence(long j10, long j11);

    public int getBodyAction() {
        return nativeGetBodyAction(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    @Deprecated
    public int getBodyId() {
        return nativeGetBodyId(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int[] getBodySkeletonConnection() {
        return nativeGetSkeletonConnection(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public ARBodySkeletonType[] getBodySkeletonType() {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            throw new ARDeadlineExceededException();
        }
        int[] iArrNativeGetSkeletonType = nativeGetSkeletonType(this.mSession.mNativeHandle, j10);
        if (iArrNativeGetSkeletonType == null) {
            return new ARBodySkeletonType[0];
        }
        ARBodySkeletonType[] aRBodySkeletonTypeArr = new ARBodySkeletonType[iArrNativeGetSkeletonType.length];
        for (int i10 = 0; i10 < iArrNativeGetSkeletonType.length; i10++) {
            aRBodySkeletonTypeArr[i10] = ARBodySkeletonType.forNumber(iArrNativeGetSkeletonType[i10]);
        }
        return aRBodySkeletonTypeArr;
    }

    public ARCoordinateSystemType getCoordinateSystemType() {
        return ARCoordinateSystemType.forNumber(nativeGetCoordinateSystemType(this.mSession.mNativeHandle, this.mNativeHandle));
    }

    public FloatBuffer getMaskConfidence() {
        Size textureDimensions = this.mSession.getCameraConfig().getTextureDimensions();
        return nativeGetMaskConfidence(this.mSession.mNativeHandle, this.mNativeHandle, textureDimensions.getWidth() * textureDimensions.getHeight()).order(ByteOrder.nativeOrder()).asFloatBuffer().asReadOnlyBuffer();
    }

    public ShortBuffer getMaskDepth() {
        Size textureDimensions = this.mSession.getCameraConfig().getTextureDimensions();
        return nativeGetMaskDepth(this.mSession.mNativeHandle, this.mNativeHandle, textureDimensions.getWidth() * textureDimensions.getHeight()).order(ByteOrder.nativeOrder()).asShortBuffer().asReadOnlyBuffer();
    }

    public float[] getSkeletonConfidence() {
        return nativeSkeletonConfidence(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getSkeletonPoint2D() {
        return nativeGetSkeletonPoint2D(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public float[] getSkeletonPoint3D() {
        return nativeGetSkeletonPoint3D(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int[] getSkeletonPointIsExist2D() {
        return nativeGetSkeletonPointIsExist2D(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    public int[] getSkeletonPointIsExist3D() {
        return nativeGetSkeletonPointIsExist3D(this.mSession.mNativeHandle, this.mNativeHandle);
    }

    @Override // com.huawei.hiar.ARTrackableBase
    public String toString() {
        return String.format(Locale.ENGLISH, "HiARBody{skeletonPointExist2D: %s skeletonPointExist3D:%s, bodySkeletonConnection: %s, bodyAction: %d}" + System.getProperty("line.separator"), Arrays.toString(getSkeletonPoint2D()), Arrays.toString(getSkeletonPoint3D()), Arrays.toString(getBodySkeletonConnection()), Integer.valueOf(getBodyAction()));
    }

    public ARBody(long j10, ARSession aRSession) {
        super(j10, aRSession);
    }
}
