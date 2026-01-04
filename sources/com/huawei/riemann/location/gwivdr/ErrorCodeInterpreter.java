package com.huawei.riemann.location.gwivdr;

import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class ErrorCodeInterpreter {
    private static final HashMap<Integer, String> map = new HashMap<Integer, String>() { // from class: com.huawei.riemann.location.gwivdr.ErrorCodeInterpreter.1
        public C86811() {
            C8683yn.m53569yn(0, this, "ok with merge", 1, "init fail");
            C8683yn.m53569yn(2, this, "waiting for init", 3, "acc not coming");
            C8683yn.m53569yn(4, this, "gyro not coming", 5, "gyroBias unset");
            C8683yn.m53569yn(6, this, "speed and gear not coming", 7, "time abnormal");
            C8683yn.m53569yn(8, this, "acc data abnormal", 9, "gyro data abnormal");
            C8683yn.m53569yn(10, this, "speed or gear abnormal", 11, "location data abnormal");
            C8683yn.m53569yn(12, this, "gnssStatus data abnormal", 13, "acc freq abnormal");
            C8683yn.m53569yn(14, this, "gyro freq abnormal", 15, "speed and gear freq abnormal");
            C8683yn.m53569yn(16, this, "system stop", 17, "lon/lat/alt abnormal");
            C8683yn.m53569yn(18, this, "internal error", 19, "fail");
            C8683yn.m53569yn(20, this, "ok with vdr", 21, "anchor not set");
            C8683yn.m53569yn(22, this, "invalid init parameters", 201, "no acc received within 1 second");
            C8683yn.m53569yn(202, this, "low acc freq within 1 second", 203, "large time diff between 2 accelerations");
            C8683yn.m53569yn(204, this, "null acc value", Constant.ERROR_ACC_GRAVITY_INVALID, "invalid acc in gravity direction");
            C8683yn.m53569yn(206, this, "acceleration value jump", 211, "no gyro received within 1 second");
            C8683yn.m53569yn(212, this, "low gyro freq within 1 second", 213, "large time diff between 2 gyros");
            C8683yn.m53569yn(214, this, "null gyro value", PlayerConstants.EventCode.VIDEO_MATCH_PRELOAD, "invalid acc in gravity direction");
            C8683yn.m53569yn(216, this, "gyro value jump", Constant.ERROR_WSS_NO_DATA, "no wss received within 1 second");
            C8683yn.m53569yn(Constant.ERROR_WSS_LOW_FREQ, this, "low wss freq within 1 second", Constant.ERROR_WSS_TIME_DIFF_LARGE, "large time diff between 2 wss");
            C8683yn.m53569yn(Constant.ERROR_WSS_INVALID, this, "null wss value", Constant.ERROR_WSS_SPEED_JUMP, "wss value jump");
            C8683yn.m53569yn(Constant.ERROR_LOCATION_INVALID, this, "null location value", Constant.ERROR_GNSS_STATUS_INVALID, "null gnss status value");
            C8683yn.m53569yn(400, this, "vdr so package not loaded", 401, "vdr null result");
            C8683yn.m53569yn(402, this, "vdr not start", 500, "unknown error");
        }
    };

    /* renamed from: com.huawei.riemann.location.gwivdr.ErrorCodeInterpreter$1 */
    public class C86811 extends HashMap<Integer, String> {
        public C86811() {
            C8683yn.m53569yn(0, this, "ok with merge", 1, "init fail");
            C8683yn.m53569yn(2, this, "waiting for init", 3, "acc not coming");
            C8683yn.m53569yn(4, this, "gyro not coming", 5, "gyroBias unset");
            C8683yn.m53569yn(6, this, "speed and gear not coming", 7, "time abnormal");
            C8683yn.m53569yn(8, this, "acc data abnormal", 9, "gyro data abnormal");
            C8683yn.m53569yn(10, this, "speed or gear abnormal", 11, "location data abnormal");
            C8683yn.m53569yn(12, this, "gnssStatus data abnormal", 13, "acc freq abnormal");
            C8683yn.m53569yn(14, this, "gyro freq abnormal", 15, "speed and gear freq abnormal");
            C8683yn.m53569yn(16, this, "system stop", 17, "lon/lat/alt abnormal");
            C8683yn.m53569yn(18, this, "internal error", 19, "fail");
            C8683yn.m53569yn(20, this, "ok with vdr", 21, "anchor not set");
            C8683yn.m53569yn(22, this, "invalid init parameters", 201, "no acc received within 1 second");
            C8683yn.m53569yn(202, this, "low acc freq within 1 second", 203, "large time diff between 2 accelerations");
            C8683yn.m53569yn(204, this, "null acc value", Constant.ERROR_ACC_GRAVITY_INVALID, "invalid acc in gravity direction");
            C8683yn.m53569yn(206, this, "acceleration value jump", 211, "no gyro received within 1 second");
            C8683yn.m53569yn(212, this, "low gyro freq within 1 second", 213, "large time diff between 2 gyros");
            C8683yn.m53569yn(214, this, "null gyro value", PlayerConstants.EventCode.VIDEO_MATCH_PRELOAD, "invalid acc in gravity direction");
            C8683yn.m53569yn(216, this, "gyro value jump", Constant.ERROR_WSS_NO_DATA, "no wss received within 1 second");
            C8683yn.m53569yn(Constant.ERROR_WSS_LOW_FREQ, this, "low wss freq within 1 second", Constant.ERROR_WSS_TIME_DIFF_LARGE, "large time diff between 2 wss");
            C8683yn.m53569yn(Constant.ERROR_WSS_INVALID, this, "null wss value", Constant.ERROR_WSS_SPEED_JUMP, "wss value jump");
            C8683yn.m53569yn(Constant.ERROR_LOCATION_INVALID, this, "null location value", Constant.ERROR_GNSS_STATUS_INVALID, "null gnss status value");
            C8683yn.m53569yn(400, this, "vdr so package not loaded", 401, "vdr null result");
            C8683yn.m53569yn(402, this, "vdr not start", 500, "unknown error");
        }
    }

    public static String interpret(int i10) {
        HashMap<Integer, String> map2 = map;
        return !map2.containsKey(Integer.valueOf(i10)) ? "Unknown error code!" : map2.get(Integer.valueOf(i10));
    }
}
