package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.utils.aj */
/* loaded from: classes2.dex */
public class C7736aj {
    /* renamed from: a */
    public static boolean m47496a() {
        return true;
    }

    /* renamed from: b */
    public static boolean m47497b() {
        try {
            Class.forName("com.hihonor.common.grs.HihonorGrsApi");
            return true;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("GrsUtil", "check honor grs available error");
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m47498c() {
        return AbstractC7791ck.m48067a("com.huawei.hms.framework.network.grs.GrsApp", "getIssueCountryCode", (Class<?>[]) new Class[]{Context.class});
    }

    /* renamed from: d */
    public static boolean m47499d() {
        return AbstractC7791ck.m48067a("com.hihonor.common.grs.HihonorGrsApp", "getIssueCountryCode", (Class<?>[]) new Class[]{Context.class});
    }
}
