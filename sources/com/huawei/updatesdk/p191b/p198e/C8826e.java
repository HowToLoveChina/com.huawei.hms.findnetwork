package com.huawei.updatesdk.p191b.p198e;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.updatesdk.b.e.e */
/* loaded from: classes9.dex */
public class C8826e {

    /* renamed from: a */
    private static final Map<String, AbstractC8822a> f45166a = new ConcurrentHashMap();

    /* renamed from: a */
    public static AbstractC8822a m56286a(boolean z10) {
        String str = z10 ? "apptouch" : "default";
        if (TextUtils.isEmpty(str)) {
            return new C8824c();
        }
        Map<String, AbstractC8822a> map = f45166a;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        map.put(str, "apptouch".equals(str) ? new C8823b() : new C8824c());
        return map.get(str);
    }
}
