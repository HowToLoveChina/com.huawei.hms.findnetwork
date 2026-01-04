package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7098en;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.CountryConfig;

/* renamed from: com.huawei.openalliance.ad.utils.db */
/* loaded from: classes2.dex */
public class C7809db {
    /* renamed from: a */
    public static boolean m48267a(Context context) {
        String strM39390a = new CountryCodeBean(context).m39390a();
        int iMo43064al = C7124fh.m43316b(context).mo43064al();
        if (CountryConfig.isDR3(strM39390a, null) || iMo43064al <= 0 || "US".equalsIgnoreCase(strM39390a)) {
            AbstractC7185ho.m43820b("SyncAppDataUtil", "not allow this area or interval <= 0");
            return false;
        }
        long jMo42968a = C7098en.m42966a(context).mo42968a();
        long j10 = iMo43064al * 60000;
        boolean z10 = AbstractC7741ao.m47566c() - jMo42968a > j10;
        AbstractC7185ho.m43821b("SyncAppDataUtil", "lastSyncTime is : %s, syncInterval is : %s", Long.valueOf(jMo42968a), Long.valueOf(j10));
        return z10;
    }
}
