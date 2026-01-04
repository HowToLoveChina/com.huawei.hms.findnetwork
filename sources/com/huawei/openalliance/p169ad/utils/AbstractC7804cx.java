package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.cx */
/* loaded from: classes2.dex */
public abstract class AbstractC7804cx {

    /* renamed from: a */
    private static final List<String> f36046a = new ArrayList();

    /* renamed from: a */
    public static void m48138a(Context context) {
        List<String> list = f36046a;
        list.clear();
        list.add(AbstractC7803cw.m48136f(context));
        list.add(AbstractC7803cw.m48134d(context));
        list.add(AbstractC7803cw.m48137g(context));
        list.add(AbstractC7803cw.m48135e(context));
    }

    /* renamed from: a */
    public static boolean m48139a(String str) {
        List<String> list = f36046a;
        if (list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return list.contains(str);
    }
}
