package com.huawei.location.base.activity.constant;

import com.huawei.location.C6757d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class ActivityErrorCode {
    public static final int ACTIVITY_IDENTIFICATION_NOT_AVAILABLE = 10301;
    public static final int ARGUMENTS_INVALID = 10101;
    private static final Map<Integer, String> CODE_MAPPING;
    public static final int CP_PERMISSION_DENIED = 10803;
    public static final int ENABLE_CONVERSION_EVENT_FAILED = 10300;
    public static final int INTERNAL_ERROR = 10000;
    public static final int NO_MATCHED_INTENT = 10108;
    public static final int PARAM_ERROR_INVALID = 10802;
    public static final int PERMISSION_DENIED = 10102;
    public static final int SUCCESS = 0;

    static {
        HashMap map = new HashMap();
        C6757d.m38366a(0, map, "SUCCESS", 10000, "INTERNAL_ERROR");
        C6757d.m38366a(10101, map, "ARGUMENTS_INVALID", PERMISSION_DENIED, "PERMISSION_DENIED");
        C6757d.m38366a(NO_MATCHED_INTENT, map, "NO_MATCHED_INTENT", ENABLE_CONVERSION_EVENT_FAILED, "ENABLE_CONVERSION_EVENT_FAILED");
        C6757d.m38366a(ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, map, "ACTIVITY_IDENTIFICATION_NOT_AVAILABLE", 10802, "PARAM_ERROR_INVALID");
        map.put(10803, "CP_PERMISSION_DENIED");
        CODE_MAPPING = Collections.unmodifiableMap(map);
    }

    public static String getErrorCodeMessage(int i10) {
        String str = CODE_MAPPING.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i10;
    }
}
