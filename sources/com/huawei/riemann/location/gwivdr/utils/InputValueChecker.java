package com.huawei.riemann.location.gwivdr.utils;

import android.location.Location;
import as.C1016d;
import com.huawei.riemann.location.common.bean.Acceleration;
import com.huawei.riemann.location.common.bean.GnssInfo;
import com.huawei.riemann.location.common.bean.Gyroscope;
import com.huawei.riemann.location.common.bean.RoadArea;
import com.huawei.riemann.location.common.bean.RotationAngle;
import com.huawei.riemann.location.common.bean.Vehicle;
import com.huawei.riemann.location.common.utils.Constant;

/* loaded from: classes5.dex */
public class InputValueChecker {
    private static final double ACC_JUMP_THRESHOLD = 10.0d;
    private static final double GYRO_JUMP_THRESHOLD = 0.15d;
    private static final double INVALID_ACC_GRAVITY = 15.0d;
    private static final double INVALID_GYRO_AXIS = 0.15d;
    private static final double INVALID_WSS_SPEED = 200.0d;
    private static final double SPEED_JUMP_THRESHOLD = 10.0d;
    private static final String TAG = "InputValueChecker";
    private static Acceleration accPreFrame;
    private static Gyroscope gyroPreFrame;
    private static double speedPreFrame;

    public static boolean isAccValid(Acceleration acceleration) {
        if (acceleration == null) {
            C1016d.m6183c(TAG, "null acc!");
            ErrorCodeManager.setErrorCode(204);
            return false;
        }
        if (acceleration.getAccZ() > INVALID_ACC_GRAVITY) {
            C1016d.m6190j(TAG, "possible invalid acc: " + acceleration);
            ErrorCodeManager.setErrorCode(Constant.ERROR_ACC_GRAVITY_INVALID);
            return true;
        }
        if (accPreFrame == null || (Math.abs(acceleration.getAccX() - accPreFrame.getAccX()) <= 10.0d && Math.abs(acceleration.getAccY() - accPreFrame.getAccY()) <= 10.0d && Math.abs(acceleration.getAccZ() - accPreFrame.getAccZ()) <= 10.0d)) {
            accPreFrame = acceleration;
            ErrorCodeManager.setErrorCode(0);
            return true;
        }
        C1016d.m6190j(TAG, "possible jump acc!");
        ErrorCodeManager.setErrorCode(206);
        return true;
    }

    public static boolean isGnssInfoValid(GnssInfo gnssInfo) {
        if (gnssInfo != null) {
            ErrorCodeManager.setErrorCode(0);
            return true;
        }
        C1016d.m6183c(TAG, "null gnssStatus!");
        ErrorCodeManager.setErrorCode(Constant.ERROR_GNSS_STATUS_INVALID);
        return false;
    }

    public static boolean isGyroValid(Gyroscope gyroscope) {
        if (gyroscope == null) {
            C1016d.m6183c(TAG, "null gyro!");
            ErrorCodeManager.setErrorCode(214);
            return false;
        }
        if (Math.abs(gyroscope.getGyroX()) > 0.15d) {
            C1016d.m6190j(TAG, "possible invalid gyro: " + gyroscope);
            ErrorCodeManager.setErrorCode(214);
            return true;
        }
        if (gyroPreFrame == null || (Math.abs(gyroscope.getGyroX() - gyroPreFrame.getGyroX()) <= 0.15d && Math.abs(gyroscope.getGyroY() - gyroPreFrame.getGyroY()) <= 0.15d && Math.abs(gyroscope.getGyroZ() - gyroPreFrame.getGyroZ()) <= 0.15d)) {
            gyroPreFrame = gyroscope;
            ErrorCodeManager.setErrorCode(0);
            return true;
        }
        C1016d.m6190j(TAG, "possible jump gyro!");
        ErrorCodeManager.setErrorCode(216);
        return true;
    }

    public static boolean isLocationValid(Location location) {
        if (location != null) {
            ErrorCodeManager.setErrorCode(0);
            return true;
        }
        C1016d.m6183c(TAG, "null location!");
        ErrorCodeManager.setErrorCode(Constant.ERROR_LOCATION_INVALID);
        return false;
    }

    public static boolean isRoadAreaValid(RoadArea roadArea) {
        if (roadArea != null) {
            ErrorCodeManager.setErrorCode(0);
            return true;
        }
        C1016d.m6183c(TAG, "null roadArea!");
        ErrorCodeManager.setErrorCode(Constant.ERROR_ROAD_AREA_INVALID);
        return false;
    }

    public static boolean isRotationAngleValid(RotationAngle rotationAngle) {
        if (rotationAngle != null) {
            return true;
        }
        C1016d.m6183c(TAG, "null rotationAngle!");
        ErrorCodeManager.setErrorCode(Constant.ERROR_ROTATION_ANGLE_INVALID);
        return false;
    }

    public static boolean isWssValid(Vehicle vehicle) {
        if (vehicle == null) {
            C1016d.m6183c(TAG, "null wss!");
            ErrorCodeManager.setErrorCode(Constant.ERROR_WSS_INVALID);
            return false;
        }
        if (vehicle.getSpeed() > INVALID_WSS_SPEED || vehicle.getGear() <= 0) {
            C1016d.m6190j(TAG, "possible invalid wss: " + vehicle);
            ErrorCodeManager.setErrorCode(Constant.ERROR_WSS_INVALID);
            return true;
        }
        if (Math.abs(vehicle.getSpeed() - speedPreFrame) > 10.0d) {
            C1016d.m6190j(TAG, "possible jump speed!");
            ErrorCodeManager.setErrorCode(Constant.ERROR_WSS_SPEED_JUMP);
            return true;
        }
        speedPreFrame = vehicle.getSpeed();
        ErrorCodeManager.setErrorCode(0);
        return true;
    }
}
