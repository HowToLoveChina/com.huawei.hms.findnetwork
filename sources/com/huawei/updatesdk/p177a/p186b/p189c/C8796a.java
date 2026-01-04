package com.huawei.updatesdk.p177a.p186b.p189c;

import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d;
import com.huawei.updatesdk.service.appmgr.bean.C8843b;
import com.huawei.updatesdk.service.appmgr.bean.C8845d;
import com.huawei.updatesdk.service.appmgr.bean.C8846e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.a.b.c.a */
/* loaded from: classes9.dex */
public class C8796a {

    /* renamed from: a */
    private static final Map<String, Class> f45105a;

    static {
        HashMap map = new HashMap();
        f45105a = map;
        map.put(C8845d.APIMETHOD, C8846e.class);
        map.put("client.getMarketInfo", C8843b.class);
    }

    /* renamed from: a */
    public static C8801d m56145a(String str) throws InstantiationException {
        Class cls = f45105a.get(str);
        if (cls != null) {
            return (C8801d) cls.newInstance();
        }
        throw new InstantiationException("ResponseBean class not found, method:" + str);
    }
}
