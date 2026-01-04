package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.d */
/* loaded from: classes8.dex */
public class C5433d {

    /* renamed from: a */
    private static final Map<String, C5431c> f24912a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private static final Object f24913b = new Object();

    /* renamed from: a */
    public static C5431c m32187a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (f24913b) {
            try {
                int iUniqueCode = grsBaseInfo.uniqueCode();
                Map<String, C5431c> map = f24912a;
                C5431c c5431c = map.get(context.getPackageName() + iUniqueCode);
                if (c5431c == null) {
                    Logger.m32141i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                    C5431c c5431c2 = new C5431c(context, grsBaseInfo);
                    map.put(context.getPackageName() + iUniqueCode, c5431c2);
                    return c5431c2;
                }
                if (c5431c.m32185a((Object) new C5431c(grsBaseInfo))) {
                    return c5431c;
                }
                Logger.m32141i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
                C5431c c5431c3 = new C5431c(context, grsBaseInfo);
                map.put(context.getPackageName() + iUniqueCode, c5431c3);
                return c5431c3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
