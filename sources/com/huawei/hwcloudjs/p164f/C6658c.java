package com.huawei.hwcloudjs.p164f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.huawei.hwcloudjs.f.c */
/* loaded from: classes8.dex */
public class C6658c {
    /* renamed from: a */
    public static List<String> m37879a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(jSONArray.optString(i10));
            }
        }
        return arrayList;
    }
}
