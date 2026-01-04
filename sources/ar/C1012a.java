package ar;

import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.C6757d;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ar.a */
/* loaded from: classes8.dex */
public final class C1012a {

    /* renamed from: a */
    public static final Map<Integer, String> f5047a;

    static {
        HashMap map = new HashMap();
        C6757d.m38366a(0, map, "SUCCESS", 10000, "INTERNAL_ERROR");
        C6757d.m38366a(LocationStatusCode.ARGUMENTS_EMPTY, map, "ARGUMENTS_EMPTY", 10101, "ARGUMENTS_INVALID");
        C6757d.m38366a(ActivityErrorCode.PERMISSION_DENIED, map, "PERMISSION_DENIED", 10104, "NO_MATCHED_CALLBACK");
        C6757d.m38366a(LocationStatusCode.NETWORK_LOCATION_SERVICES_DISABLED, map, "NETWORK_LOCATION_SERVICES_DISABLED", 10803, "PERMISSION_DENIED");
        f5047a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static String m6166a(int i10) {
        String str = f5047a.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i10;
    }
}
