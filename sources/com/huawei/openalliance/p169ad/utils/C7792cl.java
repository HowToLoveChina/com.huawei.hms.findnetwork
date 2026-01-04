package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.Content;

/* renamed from: com.huawei.openalliance.ad.utils.cl */
/* loaded from: classes2.dex */
public class C7792cl {
    /* renamed from: a */
    public static void m48071a(final Context context, final Content content, final int i10, final int i11) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.cl.2
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).m39068a(content, i10, i11);
            }
        });
    }

    /* renamed from: a */
    public static void m48072a(final Context context, final C7692tn c7692tn, final String str) {
        if (c7692tn == null) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.cl.1
            @Override // java.lang.Runnable
            public void run() {
                new C6922c(context).mo39085a(c7692tn, str);
            }
        });
    }
}
