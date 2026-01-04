package com.huawei.location.mdc;

import android.location.Location;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.adsdataservice.bean.Point;
import com.huawei.adsdataservice.bean.Quaternion;
import com.huawei.hmiuikitsdk.adsdata.receiver.EgoTfSd;
import hu.C10343b;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class AdsLocationHelper {
    private static final double DEFAULT_LATITUDE_MAX = 90.0d;
    private static final double DEFAULT_LATITUDE_MIN = -90.0d;
    private static final double DEFAULT_LONGITUDE_MAX = 180.0d;
    private static final double DEFAULT_LONGITUDE_MIN = -180.0d;
    public static final String MDC_COORDINATE_TYPE = "mdcCoordinateType";
    public static final int MDC_COORDINATE_TYPE_GCJ02 = 1;
    public static final int MDC_COORDINATE_TYPE_WGS84 = 0;
    private static final String TAG = "AdsLocationHelper";

    public static float calSpeed(Quaternion quaternion, Point point) {
        if (quaternion == null) {
            C1016d.m6183c(TAG, "orientation is null, set speed 0");
            return 0.0f;
        }
        if (point == null) {
            C1016d.m6183c(TAG, "linear is null, set speed 0");
            return 0.0f;
        }
        double w10 = quaternion.getW();
        double x10 = quaternion.getX();
        double y10 = quaternion.getY();
        double z10 = quaternion.getZ();
        double x11 = point.getX();
        double y11 = point.getY();
        double z11 = point.getZ();
        double d10 = x10 * 2.0d;
        double d11 = 2.0d * w10;
        double d12 = ((d11 * z10) + (d10 * y10)) * y11;
        float fAbs = (float) Math.abs((((d10 * z10) - (d11 * y10)) * z11) + d12 + (((1.0d - ((y10 * 2.0d) * y10)) - ((z10 * 2.0d) * z10)) * x11));
        C1016d.m6181a(TAG, "cal speed: " + fAbs + ", orientation is: " + w10 + "," + x10 + "," + y10 + "," + z10 + ", linear is: " + x11 + "," + y11 + "," + z11);
        return fAbs;
    }

    public static float getBearing(Quaternion quaternion) {
        if (quaternion == null) {
            C1016d.m6183c(TAG, "orientation is null, set bearing 0");
            return 0.0f;
        }
        float w10 = (float) quaternion.getW();
        float x10 = (float) quaternion.getX();
        float y10 = (float) quaternion.getY();
        float z10 = (float) quaternion.getZ();
        return 360.0f - ((((float) (((((float) Math.atan2(((x10 * y10) + (w10 * z10)) * 2.0f, 1.0f - (((z10 * z10) + (y10 * y10)) * 2.0f))) * 180.0f) / 3.141592653589793d) + 360.0d)) + 270.0f) % 360.0f);
    }

    public static Location getLocation(EgoTfSd egoTfSd) {
        if (egoTfSd == null) {
            C1016d.m6183c(TAG, "egoTfSd is null ");
            return null;
        }
        if (egoTfSd.getWorkState() != 1) {
            C1016d.m6183c(TAG, "egoTfSd workState is: " + egoTfSd.getWorkState());
            return null;
        }
        if (egoTfSd.getPoseLLA() == null || egoTfSd.getPoseLLA().getPose() == null || egoTfSd.getPoseLLA().getPose().getPosition() == null) {
            return null;
        }
        Point position = egoTfSd.getPoseLLA().getPose().getPosition();
        if (!isMdcLocationValid(position)) {
            return null;
        }
        if (!isMdcCoordinateValid(egoTfSd.getCoordType())) {
            C1016d.m6183c(TAG, "invalid coordinate type, drop mdc location here");
            return null;
        }
        int i10 = egoTfSd.getCoordType() == EgoTfSd.CoordTypeEnum.WGS84.ordinal() ? 0 : 1;
        Quaternion orientation = egoTfSd.getPoseLLA().getPose().getOrientation();
        Location location = new Location("gps");
        location.setTime(TimeUnit.NANOSECONDS.toMillis(egoTfSd.getTimeStamp()));
        location.setLongitude(position.getX());
        location.setLatitude(position.getY());
        location.setAltitude(position.getZ());
        location.setBearing(getBearing(orientation));
        location.setSpeed(calSpeed(orientation, egoTfSd.getLinear()));
        location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        C10343b c10343b = new C10343b(location.getExtras());
        c10343b.m63698t("LocationSource", 16);
        c10343b.m63698t(MDC_COORDINATE_TYPE, i10);
        location.setExtras(c10343b.m63683e());
        return location;
    }

    private static boolean isMdcCoordinateValid(int i10) {
        C1016d.m6181a(TAG, "coordinate type from mdc: " + i10);
        return i10 == EgoTfSd.CoordTypeEnum.WGS84.ordinal() || i10 == EgoTfSd.CoordTypeEnum.GCJ02.ordinal();
    }

    private static boolean isMdcLocationValid(Point point) {
        String str;
        if (point == null) {
            str = "position is null";
        } else {
            double x10 = point.getX();
            double y10 = point.getY();
            if (y10 > DEFAULT_LATITUDE_MAX || y10 < DEFAULT_LATITUDE_MIN) {
                str = "invalid latitude";
            } else {
                if (x10 <= DEFAULT_LONGITUDE_MAX && x10 >= DEFAULT_LONGITUDE_MIN) {
                    return true;
                }
                str = "invalid longitude";
            }
        }
        C1016d.m6183c(TAG, str);
        return false;
    }
}
