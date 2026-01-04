package p622rr;

import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.C6757d;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: rr.c */
/* loaded from: classes8.dex */
public final class C12620c {

    /* renamed from: a */
    public static final Map<Integer, String> f58054a;

    static {
        HashMap map = new HashMap();
        C6757d.m38366a(0, map, "SUCCESS", 10000, "INTERNAL_ERROR");
        C6757d.m38366a(LocationStatusCode.ARGUMENTS_EMPTY, map, "ARGUMENTS_EMPTY", 10101, "ARGUMENTS_INVALID");
        C6757d.m38366a(ActivityErrorCode.PERMISSION_DENIED, map, "PERMISSION_DENIED", 10103, "NOT_IN_MOCK_MODE");
        C6757d.m38366a(10104, map, "NO_MATCHED_CALLBACK", LocationStatusCode.NETWORK_LOCATION_SERVICES_DISABLED, "NETWORK_LOCATION_SERVICES_DISABLED");
        C6757d.m38366a(10107, map, "HD_LOCATION_REQUEST_FAILED", ActivityErrorCode.NO_MATCHED_INTENT, "NO_MATCHED_INTENT");
        C6757d.m38366a(10200, map, "GEOFENCE_NOT_AVAILABLE", 10201, "GEOFENCE_TOO_MANY_GEOFENCES");
        C6757d.m38366a(10202, map, "GEOFENCE_TOO_MANY_PENDING_INTENTS", 10204, "GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION");
        C6757d.m38366a(10205, map, "GEOFENCE_REQUEST_TOO_FREQUENT", ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED, "ENABLE_CONVERSION_EVENT_FAILED");
        C6757d.m38366a(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, map, "ACTIVITY_IDENTIFICATION_NOT_AVAILABLE", 10400, "GEOCODER_TOO_MANY_REQUEST");
        C6757d.m38366a(10401, map, "GEOCODER_NEWWORK_FAILED", 10803, "PERMISSION_DENIED");
        C6757d.m38366a(LocationStatusCode.NO_PRECISE_LOCATION_PERMISSION, map, "NO_PRECISE_LOCATION_PERMISSION", 10206, "GEOFENCING_SERVICE_SWITCH_OFF");
        C6757d.m38366a(LocationStatusCode.NOT_SUPPORT_WATCH, map, "NOT_SUPPORT_WATCH", LocationStatusCode.NOT_IN_WHITELIST, "NOT_IN_WHITELIST");
        C6757d.m38366a(LocationStatusCode.NAVIGATION_NOT_AVAILABLE, map, "NAVIGATION_NOT_AVAILABLE", LocationStatusCode.NAVIGATION_EMPTY_RESULT, "NAVIGATION_EMPTY_RESULT");
        C6757d.m38366a(20010, map, "Huawei Account Not Login", 20011, "Setting gnss switch is close");
        C6757d.m38366a(20000, map, "device do not support hd", 20020, "huawei AGC checkCerFingerprint fail");
        C6757d.m38366a(20030, map, "get empty UUID from lbs with max retry count", 20031, "get empty UUID");
        C6757d.m38366a(20032, map, "encrypt Data fail", 20033, "decrypt Data fail");
        C6757d.m38366a(20040, map, "getRequest failed ,requestBody is null", 20041, "not support hd from hw server");
        C6757d.m38366a(20042, map, "he APPID is different from hw server", 20043, "Server response failure");
        C6757d.m38366a(20044, map, "authentication error from hw server", 20050, "handler cahche data fail");
        C6757d.m38366a(CommonPickerConstant.RETCODE.SIGN_IN_BY_H5, map, "handler clear data fail", 20016, "lbs close rtk fail because of other app use rtk");
        C6757d.m38366a(30000, map, "device do not support indoorHD", 10602, "DEVICE_NOT_SUPPORT_MAG_POSITION");
        map.put(Integer.valueOf(LocationStatusCode.OFFLINE_LOCATION_MODE_OFF), "OFFLINE_LOCATION_MODE_OFF");
        f58054a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static String m76137a(int i10) {
        String str = f58054a.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i10;
    }
}
