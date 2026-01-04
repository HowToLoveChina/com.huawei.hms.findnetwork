package com.huawei.hms.support.feature.result;

import android.text.TextUtils;
import com.huawei.hms.common.api.CommonStatusCodes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class AbstractAuthResultCode extends CommonStatusCodes {
    public static final int RESULT_CODE_CANCELLED = 2012;
    public static final int RESULT_CODE_EXECUTING = 2013;
    public static final int RESULT_CODE_FAILED = 2014;
    public static final int SIGN_IN_JSONEXCEPTION = 2015;

    /* renamed from: a */
    private static final Map<Integer, String> f29963a;

    static {
        HashMap map = new HashMap();
        f29963a = map;
        map.put(2012, "Auth canceled by subscriber");
        map.put(2013, "Auth executing");
        map.put(2014, "An unrecoverable auth failure occurred");
    }

    public static String getResultDescription(int i10) {
        String str = f29963a.get(Integer.valueOf(i10));
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "unknown status code: " + i10;
    }
}
