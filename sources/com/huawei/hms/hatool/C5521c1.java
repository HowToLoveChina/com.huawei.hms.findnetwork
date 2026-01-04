package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hiar.ARImageMetadata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.c1 */
/* loaded from: classes8.dex */
public class C5521c1 {
    /* renamed from: a */
    public static Map<String, List<C5518b1>> m32468a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> mapM32477a = C5522d.m32477a(context, str);
        m32474b(mapM32477a);
        return m32470a(mapM32477a);
    }

    /* renamed from: b */
    public static Map<String, List<C5518b1>> m32473b(Context context, String str, String str2) {
        String strM32476a = C5522d.m32476a(context, str, str2, "");
        HashMap map = new HashMap();
        m32472a(str2, strM32476a, map);
        return map;
    }

    /* renamed from: a */
    public static Map<String, List<C5518b1>> m32469a(Context context, String str, String str2) {
        Map<String, List<C5518b1>> mapM32468a;
        Map<String, List<C5518b1>> mapM32468a2;
        int iM32716h = AbstractC5562q0.m32716h() * ARImageMetadata.SHADING_MODE;
        if (C5520c0.m32466a(context, "cached_v2_1", iM32716h)) {
            C5571v.m32797f("hmsSdk", "cached event reach max size, delete it");
            C5522d.m32478a(context, "cached_v2_1", new String[0]);
        }
        if (C5520c0.m32466a(context, "stat_v2_1", iM32716h)) {
            C5571v.m32797f("hmsSdk", "stat event reach max size, delete it");
            C5522d.m32478a(context, "stat_v2_1", new String[0]);
        }
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            C5571v.m32786a("hmsSdk", "read all event records");
            mapM32468a = m32468a(context, "stat_v2_1");
            mapM32468a2 = m32468a(context, "cached_v2_1");
        } else {
            String strM32660a = AbstractC5554n1.m32660a(str, str2);
            mapM32468a = m32473b(context, "stat_v2_1", strM32660a);
            mapM32468a2 = m32473b(context, "cached_v2_1", strM32660a);
        }
        return m32471a(mapM32468a, mapM32468a2);
    }

    /* renamed from: b */
    private static void m32474b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> setM32662a = AbstractC5554n1.m32662a(AbstractC5562q0.m32704b());
        while (it.hasNext()) {
            if (!setM32662a.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    private static Map<String, List<C5518b1>> m32470a(Map<String, ?> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                m32472a(key, (String) entry.getValue(), map2);
            }
        }
        return map2;
    }

    /* renamed from: a */
    private static Map<String, List<C5518b1>> m32471a(Map<String, List<C5518b1>> map, Map<String, List<C5518b1>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap map3 = new HashMap(map);
        map3.putAll(map2);
        return map3;
    }

    /* renamed from: a */
    private static void m32472a(String str, String str2, Map<String, List<C5518b1>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                C5518b1 c5518b1 = new C5518b1();
                try {
                    c5518b1.m32453a(jSONArray.getJSONObject(i10));
                    arrayList.add(c5518b1);
                } catch (JSONException unused) {
                    C5571v.m32796e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (JSONException unused2) {
            C5571v.m32796e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }
}
