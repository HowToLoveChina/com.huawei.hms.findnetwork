package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.openalliance.ad.utils.a */
/* loaded from: classes2.dex */
public class C7726a {
    /* renamed from: a */
    public static String m47420a(final Context context) {
        if (!m47421a()) {
            return "";
        }
        final C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47934M = c7787cgM47900a.m47934M();
        if (TextUtils.isEmpty(strM47934M)) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Task aaid = HiAnalytics.getInstance(context).getAAID();
                        if (aaid != null) {
                            c7787cgM47900a.m47923F((String) aaid.getResult());
                        }
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43823c("AaidUtil", "error getAgcAaid: " + th2.getClass().getSimpleName());
                    }
                }
            });
        }
        return strM47934M;
    }

    /* renamed from: a */
    public static boolean m47421a() {
        return AbstractC7791ck.m48070c(Constants.HIANALYTICS_SDK);
    }
}
