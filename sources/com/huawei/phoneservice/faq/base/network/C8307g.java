package com.huawei.phoneservice.faq.base.network;

import android.app.Activity;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.phoneservice.faq.base.network.g */
/* loaded from: classes4.dex */
public class C8307g {

    /* renamed from: a */
    public static Map<String, List<Submit>> f38678a = new HashMap();

    /* renamed from: a */
    public static void m51799a(Activity activity) {
        String name = activity.getClass().getName();
        List<Submit> list = f38678a.get(name);
        if (list != null) {
            for (Submit submit : list) {
                if (!submit.isCanceled()) {
                    submit.cancel();
                }
            }
            f38678a.put(name, null);
        }
    }
}
