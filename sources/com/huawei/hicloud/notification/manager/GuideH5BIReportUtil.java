package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p684un.C13227f;

/* loaded from: classes6.dex */
public class GuideH5BIReportUtil {
    private static final String TAG = "GuideH5BIReportUtil";

    public static void reportGuideH5Dialog(String str, String str2) {
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(str, str2);
            C13227f.m79492i1().m79567R(str, linkedHashMap);
            UBAAnalyze.m29947H("PVC", str, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportGuideH5Dialog exception:" + e10.toString());
        }
    }
}
