package com.huawei.location.gwi.util;

import com.huawei.location.activity.C6738e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class GwiErrorCode {
    public static final int ALG_GWI_COMPUTE_ABNORMAL = 17;
    public static final int ALG_GWI_SUCCESS = 0;
    public static final int ALG_GWI_VDR_ONLY = 20;
    public static final int ALG_GWI_WAIT_ACC = 3;
    public static final int ALG_GWI_WAIT_GPS = 21;
    public static final int ALG_GWI_WAIT_GYRO = 4;
    public static final int ALG_GWI_WAIT_INIT = 2;
    public static final int ALG_GWI_WAIT_STILL = 5;
    public static final int ALG_GWI_WAIT_WSS = 6;
    public static final int ALG_LIBRARY_GET_ERROR = 102;
    public static final int ALG_LIBRARY_NOT_EXIST = 106;
    public static final int CONTEXT_NULL_ERROR = 107;
    private static final Map<Integer, String> GWI_ERROR_CODE_DESC_MAP;
    public static final int LOCATION_CLIENT_GET_ERROR = 103;
    public static final int LOCATION_CLIENT_GET_ERROR_EXCEPTION = 105;
    public static final int LOCATION_CLIENT_GET_ERROR_ILLEGAL_ARGUMENT = 104;
    public static final int OTHER_ERROR = 999;
    public static final int ROTATION_ANGLE_NULL_ERROR = 101;
    public static final int SUCCESS = 0;
    public int code;
    public String msg;

    static {
        HashMap map = new HashMap();
        GWI_ERROR_CODE_DESC_MAP = map;
        C6767yn.m38372yn(0, map, "success", 101, "rotation angle is null or invalid");
        C6767yn.m38372yn(102, map, "alg library get fail", 103, "location client get fail");
        C6767yn.m38372yn(104, map, "location client get fail, illegal argument", 105, "location client get fail, exception");
        C6767yn.m38372yn(106, map, "alg library not exist", 107, "context is null");
        map.put(999, "other error");
    }

    public GwiErrorCode(int i10, String str) {
        this.code = i10;
        this.msg = str;
    }

    public static GwiErrorCode valueOf(int i10) {
        Map<Integer, String> map = GWI_ERROR_CODE_DESC_MAP;
        return map.containsKey(Integer.valueOf(i10)) ? new GwiErrorCode(i10, map.get(Integer.valueOf(i10))) : new GwiErrorCode(999, map.get(999));
    }

    public static String valueOfKey(int i10) {
        Map<Integer, String> map = GWI_ERROR_CODE_DESC_MAP;
        if (!map.containsKey(Integer.valueOf(i10))) {
            i10 = 999;
        }
        return map.get(Integer.valueOf(i10));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GwiErrorCode{code=");
        sb2.append(this.code);
        sb2.append(", msg='");
        return C6738e.m38291a(sb2, this.msg, "'}");
    }
}
