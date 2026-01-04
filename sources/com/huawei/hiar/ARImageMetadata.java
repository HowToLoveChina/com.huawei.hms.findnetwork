package com.huawei.hiar;

import android.util.Rational;
import com.huawei.hiar.exceptions.ARFatalException;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARImageMetadata {
    public static final int BLACK_LEVEL_LOCK = 1441792;
    private static final int BLACK_LEVEL_START = 1441792;
    public static final int COLOR_CORRECTION_ABERRATION_MODE = 3;
    public static final int COLOR_CORRECTION_GAINS = 2;
    public static final int COLOR_CORRECTION_MODE = 0;
    private static final int COLOR_CORRECTION_START = 0;
    public static final int COLOR_CORRECTION_TRANSFORM = 1;
    public static final int CONTROL_AE_ANTIBANDING_MODE = 65536;
    public static final int CONTROL_AE_EXPOSURE_COMPENSATION = 65537;
    public static final int CONTROL_AE_LOCK = 65538;
    public static final int CONTROL_AE_MODE = 65539;
    public static final int CONTROL_AE_PRECAPTURE_TRIGGER = 65542;
    public static final int CONTROL_AE_REGIONS = 65540;
    public static final int CONTROL_AE_STATE = 65567;
    public static final int CONTROL_AE_TARGET_FPS_RANGE = 65541;
    public static final int CONTROL_AF_MODE = 65543;
    public static final int CONTROL_AF_REGIONS = 65544;
    public static final int CONTROL_AF_STATE = 65568;
    public static final int CONTROL_AF_TRIGGER = 65545;
    public static final int CONTROL_AWB_LOCK = 65546;
    public static final int CONTROL_AWB_MODE = 65547;
    public static final int CONTROL_AWB_REGIONS = 65548;
    public static final int CONTROL_AWB_STATE = 65570;
    public static final int CONTROL_CAPTURE_INTENT = 65549;
    public static final int CONTROL_EFFECT_MODE = 65550;
    public static final int CONTROL_MODE = 65551;
    public static final int CONTROL_POST_RAW_SENSITIVITY_BOOST = 65576;
    public static final int CONTROL_SCENE_MODE = 65552;
    private static final int CONTROL_START = 65536;
    public static final int CONTROL_VIDEO_STABILIZATION_MODE = 65553;
    private static final int DEPTH_START = 1638400;
    public static final int EDGE_MODE = 196608;
    private static final int EDGE_START = 196608;
    private static final int FLASH_INFO_START = 327680;
    public static final int FLASH_MODE = 262146;
    private static final int FLASH_START = 262144;
    public static final int FLASH_STATE = 262149;
    public static final int HOT_PIXEL_MODE = 393216;
    private static final int HOT_PIXEL_START = 393216;
    private static final int INFO_START = 1376256;
    public static final int JPEG_GPS_COORDINATES = 458752;
    public static final int JPEG_GPS_PROCESSING_METHOD = 458753;
    public static final int JPEG_GPS_TIMESTAMP = 458754;
    public static final int JPEG_ORIENTATION = 458755;
    public static final int JPEG_QUALITY = 458756;
    private static final int JPEG_START = 458752;
    public static final int JPEG_THUMBNAIL_QUALITY = 458757;
    public static final int JPEG_THUMBNAIL_SIZE = 458758;
    public static final int LENS_APERTURE = 524288;
    public static final int LENS_FILTER_DENSITY = 524289;
    public static final int LENS_FOCAL_LENGTH = 524290;
    public static final int LENS_FOCUS_DISTANCE = 524291;
    public static final int LENS_FOCUS_RANGE = 524296;
    private static final int LENS_INFO_START = 589824;
    public static final int LENS_INTRINSIC_CALIBRATION = 524298;
    public static final int LENS_OPTICAL_STABILIZATION_MODE = 524292;
    public static final int LENS_POSE_ROTATION = 524294;
    public static final int LENS_POSE_TRANSLATION = 524295;
    public static final int LENS_RADIAL_DISTORTION = 524299;
    private static final int LENS_START = 524288;
    public static final int LENS_STATE = 524297;
    public static final int NOISE_REDUCTION_MODE = 655360;
    private static final int NOISE_REDUCTION_START = 655360;
    public static final int REQUEST_PIPELINE_DEPTH = 786441;
    private static final int REQUEST_START = 786432;
    public static final int SCALER_CROP_REGION = 851968;
    private static final int SCALER_START = 851968;
    private static final int SECTION_BLACK_LEVEL = 22;
    private static final int SECTION_COLOR_CORRECTION = 0;
    private static final int SECTION_CONTROL = 1;
    private static final int SECTION_DEPTH = 25;
    private static final int SECTION_EDGE = 3;
    private static final int SECTION_FLASH = 4;
    private static final int SECTION_FLASH_INFO = 5;
    private static final int SECTION_HOT_PIXEL = 6;
    private static final int SECTION_INFO = 21;
    private static final int SECTION_JPEG = 7;
    private static final int SECTION_LENS = 8;
    private static final int SECTION_LENS_INFO = 9;
    private static final int SECTION_NOISE_REDUCTION = 10;
    private static final int SECTION_REQUEST = 12;
    private static final int SECTION_SCALER = 13;
    private static final int SECTION_SENSOR = 14;
    private static final int SECTION_SENSOR_INFO = 15;
    private static final int SECTION_SHADING = 16;
    private static final int SECTION_STATISTICS = 17;
    private static final int SECTION_STATISTICS_INFO = 18;
    private static final int SECTION_SYNC = 23;
    private static final int SECTION_TONEMAP = 19;
    public static final int SENSOR_DYNAMIC_BLACK_LEVEL = 917532;
    public static final int SENSOR_DYNAMIC_WHITE_LEVEL = 917533;
    public static final int SENSOR_EXPOSURE_TIME = 917504;
    public static final int SENSOR_FRAME_DURATION = 917505;
    public static final int SENSOR_GREEN_SPLIT = 917526;
    private static final int SENSOR_INFO_START = 983040;
    public static final int SENSOR_NEUTRAL_COLOR_POINT = 917522;
    public static final int SENSOR_NOISE_PROFILE = 917523;
    public static final int SENSOR_ROLLING_SHUTTER_SKEW = 917530;
    public static final int SENSOR_SENSITIVITY = 917506;
    private static final int SENSOR_START = 917504;
    public static final int SENSOR_TEST_PATTERN_DATA = 917527;
    public static final int SENSOR_TEST_PATTERN_MODE = 917528;
    public static final int SENSOR_TIMESTAMP = 917520;
    public static final int SHADING_MODE = 1048576;
    private static final int SHADING_START = 1048576;
    public static final int STATISTICS_FACE_DETECT_MODE = 1114112;
    public static final int STATISTICS_FACE_IDS = 1114116;
    public static final int STATISTICS_FACE_LANDMARKS = 1114117;
    public static final int STATISTICS_FACE_RECTANGLES = 1114118;
    public static final int STATISTICS_FACE_SCORES = 1114119;
    public static final int STATISTICS_HOT_PIXEL_MAP = 1114127;
    public static final int STATISTICS_HOT_PIXEL_MAP_MODE = 1114115;
    private static final int STATISTICS_INFO_START = 1179648;
    public static final int STATISTICS_LENS_SHADING_MAP = 1114123;
    public static final int STATISTICS_LENS_SHADING_MAP_MODE = 1114128;
    public static final int STATISTICS_SCENE_FLICKER = 1114126;
    private static final int STATISTICS_START = 1114112;
    private static final int STRING_BUILDER_CAPACITY = 80;
    public static final int SYNC_FRAME_NUMBER = 1507328;
    private static final int SYNC_START = 1507328;
    private static final String TAG = "ARImageMetadata";
    public static final int TONEMAP_CURVE_BLUE = 1245184;
    public static final int TONEMAP_CURVE_GREEN = 1245185;
    public static final int TONEMAP_CURVE_RED = 1245186;
    public static final int TONEMAP_GAMMA = 1245190;
    public static final int TONEMAP_MODE = 1245187;
    public static final int TONEMAP_PRESET_CURVE = 1245191;
    private static final int TONEMAP_START = 1245184;
    private static final int TYPE_BYTE = 0;
    private static final int TYPE_DOUBLE = 4;
    private static final int TYPE_FLOAT = 2;
    private static final int TYPE_INT = 1;
    private static final int TYPE_LONG = 3;
    private static final int TYPE_RATIONAL = 5;
    private static final String WRONG_RETURN_TYPE = "Wrong return type for ImageMetadata key: %1$d.";
    private final long mNativeHandle;
    private final ARSession mSession;
    private final C4829a mSketchEntry;

    /* renamed from: com.huawei.hiar.ARImageMetadata$a */
    public static class C4829a {

        /* renamed from: a */
        public long f22017a = 0;

        /* renamed from: b */
        public a f22018b = a.INVALID;

        /* renamed from: c */
        public int f22019c = -1;

        /* renamed from: com.huawei.hiar.ARImageMetadata$a$a */
        public enum a {
            INVALID(-1),
            BYTE(0),
            INT(1),
            FLOAT(2),
            LONG(3),
            DOUBLE(4),
            RATIONAL(5);


            /* renamed from: a */
            public final int f22028a;

            a(int i10) {
                this.f22028a = i10;
            }

            /* renamed from: b */
            public static a m29065b(int i10) {
                for (a aVar : values()) {
                    if (aVar.f22028a == i10) {
                        return aVar;
                    }
                }
                StringBuilder sb2 = new StringBuilder(80);
                sb2.append("Unexpected value for native DataType, value=");
                sb2.append(i10);
                throw new ARFatalException(sb2.toString());
            }
        }
    }

    public ARImageMetadata() {
        this.mSession = null;
        this.mNativeHandle = 0L;
        this.mSketchEntry = null;
    }

    private void getMetadataEntry(int i10, C4829a c4829a) {
        long jNativeGetMetadataEntry = nativeGetMetadataEntry(this.mSession.mNativeHandle, this.mNativeHandle, i10);
        c4829a.f22017a = jNativeGetMetadataEntry;
        if (jNativeGetMetadataEntry == 0) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Invalid ImageMetadata key: %1$d", Integer.valueOf(i10)));
        }
        c4829a.f22018b = C4829a.a.m29065b(nativeGetMetadataEntryValueType(this.mSession.mNativeHandle, jNativeGetMetadataEntry));
        c4829a.f22019c = nativeGetMetadataEntryValueCount(this.mSession.mNativeHandle, c4829a.f22017a);
    }

    private native void nativeDestroyMetadataEntry(long j10, long j11);

    private native int[] nativeGetAllKeys(long j10, long j11);

    private native byte[] nativeGetByteArrayFromMetadataEntry(long j10, long j11);

    private native byte nativeGetByteFromMetadataEntry(long j10, long j11);

    private native double[] nativeGetDoubleArrayFromMetadataEntry(long j10, long j11);

    private native double nativeGetDoubleFromMetadataEntry(long j10, long j11);

    private native float[] nativeGetFloatArrayFromMetadataEntry(long j10, long j11);

    private native float nativeGetFloatFromMetadataEntry(long j10, long j11);

    private native int[] nativeGetIntArrayFromMetadataEntry(long j10, long j11);

    private native int nativeGetIntFromMetadataEntry(long j10, long j11);

    private native long[] nativeGetLongArrayFromMetadataEntry(long j10, long j11);

    private native long nativeGetLongFromMetadataEntry(long j10, long j11);

    private native long nativeGetMetadataEntry(long j10, long j11, int i10);

    private native int nativeGetMetadataEntryValueCount(long j10, long j11);

    private native int nativeGetMetadataEntryValueType(long j10, long j11);

    private native Rational[] nativeGetRationalArrayFromMetadataEntry(long j10, long j11);

    private native Rational nativeGetRationalFromMetadataEntry(long j10, long j11);

    private static native void nativeReleaseImageMetadata(long j10);

    public void finalize() throws Throwable {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeReleaseImageMetadata(j10);
        }
        super.finalize();
    }

    public byte getByte(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.BYTE || c4829a.f22019c != 1) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        byte bNativeGetByteFromMetadataEntry = nativeGetByteFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return bNativeGetByteFromMetadataEntry;
    }

    public byte[] getByteArray(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.BYTE) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        byte[] bArrNativeGetByteArrayFromMetadataEntry = nativeGetByteArrayFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return bArrNativeGetByteArrayFromMetadataEntry;
    }

    public double getDouble(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.DOUBLE || c4829a.f22019c != 1) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        double dNativeGetDoubleFromMetadataEntry = nativeGetDoubleFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return dNativeGetDoubleFromMetadataEntry;
    }

    public double[] getDoubleArray(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.DOUBLE) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        double[] dArrNativeGetDoubleArrayFromMetadataEntry = nativeGetDoubleArrayFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return dArrNativeGetDoubleArrayFromMetadataEntry;
    }

    public float getFloat(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.FLOAT || c4829a.f22019c != 1) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        float fNativeGetFloatFromMetadataEntry = nativeGetFloatFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return fNativeGetFloatFromMetadataEntry;
    }

    public float[] getFloatArray(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.FLOAT) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        float[] fArrNativeGetFloatArrayFromMetadataEntry = nativeGetFloatArrayFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return fArrNativeGetFloatArrayFromMetadataEntry;
    }

    public int getInt(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.INT || c4829a.f22019c != 1) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        int iNativeGetIntFromMetadataEntry = nativeGetIntFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return iNativeGetIntFromMetadataEntry;
    }

    public int[] getIntArray(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.INT) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        int[] iArrNativeGetIntArrayFromMetadataEntry = nativeGetIntArrayFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return iArrNativeGetIntArrayFromMetadataEntry;
    }

    public int[] getKeys() {
        int[] iArrNativeGetAllKeys = nativeGetAllKeys(this.mSession.mNativeHandle, this.mNativeHandle);
        if (iArrNativeGetAllKeys != null) {
            return iArrNativeGetAllKeys;
        }
        throw new ARFatalException("ARImageMetadata.getKeys() error.");
    }

    public long getLong(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.LONG || c4829a.f22019c != 1) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        long jNativeGetLongFromMetadataEntry = nativeGetLongFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return jNativeGetLongFromMetadataEntry;
    }

    public long[] getLongArray(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.LONG) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        long[] jArrNativeGetLongArrayFromMetadataEntry = nativeGetLongArrayFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return jArrNativeGetLongArrayFromMetadataEntry;
    }

    public Rational getRational(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.RATIONAL || c4829a.f22019c != 1) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        Rational rationalNativeGetRationalFromMetadataEntry = nativeGetRationalFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return rationalNativeGetRationalFromMetadataEntry;
    }

    public Rational[] getRationalArray(int i10) {
        getMetadataEntry(i10, this.mSketchEntry);
        C4829a c4829a = this.mSketchEntry;
        if (c4829a.f22018b != C4829a.a.RATIONAL) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, WRONG_RETURN_TYPE, Integer.valueOf(i10)));
        }
        Rational[] rationalArrNativeGetRationalArrayFromMetadataEntry = nativeGetRationalArrayFromMetadataEntry(this.mSession.mNativeHandle, c4829a.f22017a);
        nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.f22017a);
        return rationalArrNativeGetRationalArrayFromMetadataEntry;
    }

    public ARImageMetadata(long j10, ARSession aRSession) {
        this.mSession = aRSession;
        this.mNativeHandle = j10;
        this.mSketchEntry = new C4829a();
    }
}
