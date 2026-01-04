package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.bj */
/* loaded from: classes2.dex */
public abstract class AbstractC7763bj {
    /* renamed from: a */
    public static void m47798a(Context context) {
        m47799a(context, 4, null);
    }

    /* renamed from: a */
    public static void m47799a(Context context, int i10, String str) {
        if (i10 < 4) {
            i10 = 4;
        }
        if (TextUtils.isEmpty(str)) {
            str = AbstractC7803cw.m48129a(context);
            if (TextUtils.isEmpty(str)) {
                AbstractC7185ho.m43823c("LogTool", "enable log failed, due to root path is null");
                return;
            }
        }
        AbstractC7185ho.m43812a(i10, str, "HiAd");
    }
}
