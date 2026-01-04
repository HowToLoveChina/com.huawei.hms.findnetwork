package com.huawei.hms.ads.identifier;

import android.util.Log;
import com.huawei.openalliance.p169ad.constant.HMSConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.ads.identifier.b */
/* loaded from: classes8.dex */
public class C5068b {

    /* renamed from: a */
    private static final Map<String, List<String>> f23183a;

    static {
        HashMap map = new HashMap();
        f23183a = map;
        map.put("com.huawei.hwid", Arrays.asList(HMSConstants.HMS_SIGNATURE));
        map.put("com.huawei.hwid.tv", Arrays.asList(HMSConstants.HMS_TV_SIGNATURE));
        map.put("com.huawei.hms", Arrays.asList(HMSConstants.HMS_NEW_SIGNATURE));
    }

    /* renamed from: a */
    public static boolean m30249a(String str, String str2) {
        return m30250a(f23183a.get(str), str2);
    }

    /* renamed from: a */
    private static boolean m30250a(List<String> list, String str) {
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
        }
        Log.d("WhiteList", "check false!");
        return false;
    }
}
