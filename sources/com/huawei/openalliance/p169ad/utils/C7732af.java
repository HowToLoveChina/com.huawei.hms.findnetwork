package com.huawei.openalliance.p169ad.utils;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.af */
/* loaded from: classes2.dex */
public class C7732af {
    /* renamed from: a */
    public static boolean m47471a() {
        return false;
    }

    /* renamed from: a */
    private static boolean m47472a(List<String> list, String str) {
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m47473a(Map<String, List<String>> map, String str, String str2) {
        if (!C7765bl.m47802a(map) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return m47472a(map.get(str), str2);
        }
        AbstractC7185ho.m43820b("FlavorUtils", "inWhiteList invalid input.");
        return false;
    }
}
