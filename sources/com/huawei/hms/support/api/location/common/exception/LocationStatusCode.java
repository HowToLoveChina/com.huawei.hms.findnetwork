package com.huawei.hms.support.api.location.common.exception;

import com.huawei.hms.common.api.CommonStatusCodes;
import com.huawei.location.C6757d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class LocationStatusCode extends CommonStatusCodes {
    public static final int AGC_CHECK_FAIL = 10808;
    public static final int ARGUMENTS_EMPTY = 10100;
    public static final int ARGUMENTS_INVALID = 10101;
    private static final Map<Integer, String> CODE_MAPPING;
    public static final int GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION = 10204;
    public static final int GEOFENCE_NOT_AVAILABLE = 10200;
    public static final int GEOFENCE_REQUEST_TOO_FREQUENT = 10205;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 10201;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 10202;
    public static final int LOCATION_ENABLE_OFF = 10106;
    public static final int LOCATION_INTERNAL_ERROR = 10000;
    public static final int METHOD_INVOKE_ERROR = 10807;
    public static final int NAVIGATION_EMPTY_RESULT = 10110;
    public static final int NAVIGATION_NOT_AVAILABLE = 10109;
    public static final int NETWORK_LOCATION_SERVICES_DISABLED = 10105;
    public static final int NOT_IN_WHITELIST = 10111;
    public static final int NOT_SUPPORT_WATCH = 10601;
    public static final int NOT_YET_SUPPORTED = 10806;
    public static final int NO_MATCHED_CALLBACK = 10804;
    public static final int NO_MATCHED_INTENT = 10805;
    public static final int NO_PRECISE_LOCATION_PERMISSION = 10809;
    public static final int OFFLINE_LOCATION_MODE_OFF = 10112;
    public static final int PARAM_ERROR_EMPTY = 10801;
    public static final int PARAM_ERROR_INVALID = 10802;
    public static final int PERMISSION_DENIED = 10803;
    public static final int SUCCESS = 0;

    static {
        HashMap map = new HashMap(0);
        C6757d.m38366a(0, map, "SUCCESS", LOCATION_ENABLE_OFF, "LOCATION_ENABLE_OFF");
        C6757d.m38366a(8, map, "INTERNAL_ERROR", ARGUMENTS_EMPTY, "ARGUMENTS_EMPTY");
        C6757d.m38366a(10101, map, "ARGUMENTS_INVALID", 10802, "PARAM_ERROR_INVALID");
        C6757d.m38366a(10803, map, "PERMISSION_DENIED", NO_MATCHED_CALLBACK, "NO_MATCHED_CALLBACK");
        C6757d.m38366a(NOT_YET_SUPPORTED, map, "NOT_YET_SUPPORTED", NETWORK_LOCATION_SERVICES_DISABLED, "NETWORK_LOCATION_SERVICES_DISABLED");
        C6757d.m38366a(NO_MATCHED_INTENT, map, "NO_MATCHED_INTENT", PARAM_ERROR_EMPTY, "PARAM_ERROR_EMPTY");
        C6757d.m38366a(METHOD_INVOKE_ERROR, map, "METHOD_INVOKE_ERROR", AGC_CHECK_FAIL, "AGC_CHECK_FAIL");
        C6757d.m38366a(NO_PRECISE_LOCATION_PERMISSION, map, "NO_PRECISE_LOCATION_PERMISSION", 10200, "GEOFENCE_NOT_AVAILABLE");
        C6757d.m38366a(10201, map, "GEOFENCE_TOO_MANY_GEOFENCES", 10202, "GEOFENCE_TOO_MANY_PENDING_INTENTS");
        C6757d.m38366a(10204, map, "GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION", 10205, "GEOFENCE_REQUEST_TOO_FREQUENT");
        C6757d.m38366a(NOT_SUPPORT_WATCH, map, "NOT_SUPPORT_WATCH", NOT_IN_WHITELIST, "NOT_IN_WHITELIST");
        C6757d.m38366a(NAVIGATION_NOT_AVAILABLE, map, "NAVIGATION_NOT_AVAILABLE", NAVIGATION_EMPTY_RESULT, "NAVIGATION_EMPTY_RESULT");
        map.put(Integer.valueOf(OFFLINE_LOCATION_MODE_OFF), "OFFLINE_LOCATION_MODE_OFF");
        CODE_MAPPING = Collections.unmodifiableMap(map);
    }

    public static String getStatusCodeString(int i10) {
        String str = CODE_MAPPING.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i10;
    }
}
