package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import p405jt.AbstractC10915a;
import p405jt.C10917c;

/* renamed from: com.huawei.openalliance.ad.utils.s */
/* loaded from: classes2.dex */
public class C7840s {
    /* renamed from: a */
    public static void m48502a(final Context context) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.s.1
            @Override // java.lang.Runnable
            public void run() {
                Context contextM48571i = C7845x.m48571i(context);
                String strM48129a = AbstractC7803cw.m48129a(contextM48571i);
                if (TextUtils.isEmpty(strM48129a)) {
                    AbstractC10915a.m65978j("CommonLibLogTool", "enable log failed, due to root path is null");
                } else {
                    AbstractC10915a.m65974f(contextM48571i, new C10917c().m65992l(4).m65991k("HiAd.RecEngine").m65994n("HiAd-3.4.76.300").m65993m(strM48129a).m65990j("HiAdCommon"));
                }
            }
        });
    }
}
