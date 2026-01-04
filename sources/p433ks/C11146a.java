package p433ks;

import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.C6757d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ks.a */
/* loaded from: classes8.dex */
public final class C11146a {

    /* renamed from: a */
    public static final Map<Integer, String> f52491a;

    static {
        HashMap map = new HashMap();
        C6757d.m38366a(0, map, "SUCCESS", 10000, "INTERNAL_ERROR");
        C6757d.m38366a(LocationStatusCode.ARGUMENTS_EMPTY, map, "SCAN_RESULT_ERROR", 11000, "LOCATION_CLOUD_ERROR");
        f52491a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static String m67058a(int i10) {
        String str = f52491a.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i10;
    }
}
