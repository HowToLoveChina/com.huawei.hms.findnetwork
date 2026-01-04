package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0239x;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class GuideH5ReportUtil {
    private static final String TAG = "GuideH5ReportUtil";

    public static void reportH5GuideDialogOperaitonResult(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07053"), "07053", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(NotifyConstants.NotificationReport.OPERATION_NAME_H5_GUIDE_DIALOG_OPERATION);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
            GuideH5BIReportUtil.reportGuideH5Dialog(str, str2);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportH5GuideDialogOperaitonResult exception:" + e10.toString());
        }
    }

    public static void reportH5GuideDialogOperaitonResult(Map<String, String> map) {
        try {
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07053"), "07053", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(NotifyConstants.NotificationReport.OPERATION_NAME_H5_GUIDE_DIALOG_OPERATION);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportH5GuideDialogOperaitonResult exception:" + e10.toString());
        }
    }
}
