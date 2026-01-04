package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* loaded from: classes8.dex */
public class HiAnalyticsOfCpUtils {

    /* renamed from: a */
    private static HiAnalyticsInstance f29735a;

    /* renamed from: a */
    private static HiAnalyticsInstance m36620a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f29735a = analyticsInstance;
        return analyticsInstance;
    }

    public static void onEvent(Context context, String str, String str2) {
        if (m36620a(context) != null) {
            f29735a.onEvent(context, str, str2);
        }
    }

    public static void onReport(Context context, int i10) {
        if (m36620a(context) != null) {
            f29735a.onReport(i10);
        }
    }

    public static void onStreamEvent(Context context, int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m36620a(context) != null) {
            f29735a.onStreamEvent(i10, str, linkedHashMap);
        }
    }

    public static void onEvent(Context context, int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m36620a(context) != null) {
            f29735a.onEvent(i10, str, linkedHashMap);
        }
    }
}
