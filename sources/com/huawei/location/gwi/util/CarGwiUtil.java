package com.huawei.location.gwi.util;

import android.location.Location;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.riemann.location.common.bean.VdrInputData;
import com.huawei.riemann.location.gwivdr.ErrorCodeInterpreter;

/* loaded from: classes8.dex */
public class CarGwiUtil {
    private static final double DEFAULT_LATITUDE_MAX = 90.0d;
    private static final double DEFAULT_LATITUDE_MIN = -90.0d;
    private static final double DEFAULT_LONGITUDE_MAX = 180.0d;
    private static final double DEFAULT_LONGITUDE_MIN = -180.0d;
    private static final long LOG_TIME_THRESHOLD = 1000;
    private static final String TAG = "CarGwiUtil";
    private static final float ZERO_ERROR_RANGE = 1.0E-6f;
    private static volatile int accCount;
    private static volatile int gnssInfoCount;
    private static volatile int gyroCount;
    private static volatile long lastLogTime;
    private static volatile int locationCount;
    private static volatile int vehicleCount;

    /* renamed from: com.huawei.location.gwi.util.CarGwiUtil$1 */
    public static /* synthetic */ class C67661 {

        /* renamed from: $SwitchMap$com$huawei$riemann$location$common$bean$VdrInputData$DataType */
        static final /* synthetic */ int[] f31329xce12f30a;

        static {
            int[] iArr = new int[VdrInputData.DataType.values().length];
            f31329xce12f30a = iArr;
            try {
                iArr[VdrInputData.DataType.ACC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31329xce12f30a[VdrInputData.DataType.GYRO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31329xce12f30a[VdrInputData.DataType.VEHICLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31329xce12f30a[VdrInputData.DataType.LOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31329xce12f30a[VdrInputData.DataType.GNSS_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void calInputInfo(VdrInputData vdrInputData) {
        if (vdrInputData == null) {
            return;
        }
        int i10 = C67661.f31329xce12f30a[vdrInputData.getDataType().ordinal()];
        if (i10 == 1) {
            accCount++;
            return;
        }
        if (i10 == 2) {
            gyroCount++;
            return;
        }
        if (i10 == 3) {
            vehicleCount++;
        } else if (i10 == 4) {
            locationCount++;
        } else {
            if (i10 != 5) {
                return;
            }
            gnssInfoCount++;
        }
    }

    public static String getAlgErrorMsg(int i10, int i11) {
        String string;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append(": ");
            sb2.append(i10 == 0 ? "sdk 0" : ErrorCodeInterpreter.interpret(i10));
            sb2.append(", ");
            sb2.append(i11);
            sb2.append(": ");
            sb2.append(ErrorCodeInterpreter.interpret(i11));
            string = sb2.toString();
        } catch (Exception unused) {
            C1016d.m6183c(TAG, "getAlgErrorMsg exception");
            string = "";
        }
        C1016d.m6186f(TAG, "getAlgErrorMsg: " + string);
        return string;
    }

    public static void getAndResetInputCount() {
        C1016d.m6186f(TAG, "CarGwiUtil{accCount=" + accCount + ", gyroCount=" + gyroCount + ", locationCount=" + locationCount + ", vehicleCount=" + vehicleCount + ", gnssInfoCount=" + gnssInfoCount + '}');
        accCount = 0;
        gyroCount = 0;
        locationCount = 0;
        vehicleCount = 0;
        gnssInfoCount = 0;
    }

    private static boolean isGwiRecover(int i10) {
        return i10 == 0 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 17 || i10 == 20 || i10 == 21;
    }

    public static boolean isIllegalBearing(float f10) {
        return Math.abs(f10) < ZERO_ERROR_RANGE;
    }

    public static boolean isLocationValid(Location location) {
        String str;
        if (location == null) {
            str = "location is null";
        } else {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            if (latitude > DEFAULT_LATITUDE_MAX || latitude < DEFAULT_LATITUDE_MIN) {
                str = "invalid latitude";
            } else {
                if (longitude <= DEFAULT_LONGITUDE_MAX && longitude >= DEFAULT_LONGITUDE_MIN) {
                    return true;
                }
                str = "invalid longitude";
            }
        }
        C1016d.m6183c(TAG, str);
        return false;
    }

    public static boolean isRestart(int i10) {
        if (i10 == 102) {
            return true;
        }
        return !isGwiRecover(i10);
    }

    public static void logClientNullControl() {
        if (SystemClock.elapsedRealtime() - lastLogTime < 1000) {
            return;
        }
        lastLogTime = SystemClock.elapsedRealtime();
        C1016d.m6183c(TAG, "locationClient is null, setVdrData fail.");
    }
}
