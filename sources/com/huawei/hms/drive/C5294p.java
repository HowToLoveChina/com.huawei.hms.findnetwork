package com.huawei.hms.drive;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.NetworkKit;

/* renamed from: com.huawei.hms.drive.p */
/* loaded from: classes8.dex */
public class C5294p extends HianalyticsBaseData {

    /* renamed from: a */
    private static volatile boolean f24549a = false;

    public C5294p() {
        put("sdk_version", "7.0.5.301");
        put("dns_subtype", "dnkeeper");
    }

    /* renamed from: a */
    public static void m31776a() {
        synchronized (C5294p.class) {
            if (!f24549a) {
                try {
                    String option = NetworkKit.getInstance().getOption("core_ha_tag");
                    if (!option.isEmpty()) {
                        HianalyticsHelper.getInstance().setHaTag(option);
                    }
                } catch (NoSuchMethodError unused) {
                    Logger.m32145w("DNKeeperHianalyticsData", "sdk version is too low,ha tag cannot be found");
                }
                f24549a = true;
            }
        }
    }
}
