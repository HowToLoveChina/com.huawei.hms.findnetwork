package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.u */
/* loaded from: classes2.dex */
public abstract class AbstractC7842u {
    /* renamed from: a */
    public static Map<Integer, String> m48506a(Context context, Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (!C7765bl.m47802a(map)) {
            m48507a(context, "title", map, map2);
            m48507a(context, "content", map, map2);
            m48507a(context, Constants.AUTOCONTENT_CATEGORY, map, map2);
            m48507a(context, Constants.AUTOCONTENT_SUBCATEGORY, map, map2);
        }
        return map2;
    }

    /* renamed from: a */
    private static void m48507a(Context context, String str, Map<String, String> map, Map<Integer, String> map2) {
        List list = (List) AbstractC7758be.m47739b(map.get(str), List.class, new Class[0]);
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int identifier = context.getResources().getIdentifier((String) it.next(), "id", context.getPackageName());
            if (identifier != 0) {
                map2.put(Integer.valueOf(identifier), str);
            }
        }
    }
}
