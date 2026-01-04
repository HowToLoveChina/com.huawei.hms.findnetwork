package com.huawei.hicloud.notification.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import gp.C10028c;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p709vj.C13452e;
import p778xk.C13821b;

/* loaded from: classes6.dex */
public class CampaignCheckUtil {
    public static final String IN_ACTIVE = "I";
    public static final String IN_CLEAR = "W";
    private static final String TAG = "CampaignCheckUtil";

    public static boolean checkCampaignEntryCondition(Context context) {
        if (C0209d.m1293p1()) {
            NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition is InkScreen!");
            return false;
        }
        if (!C0209d.m1166E1()) {
            NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition is not owner user!");
            return false;
        }
        if (isSilenceUser()) {
            NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition is false , due to the user is silenceUser!");
            return false;
        }
        if (C13452e.m80781L().m80795D0()) {
            NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition isChildAccount!");
            return false;
        }
        if (!C10028c.m62182c0().m62413x()) {
            NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition function switch is false!");
            return false;
        }
        String strM1363m = C0212e0.m1363m(context, "hicloud_campaign_activity_entry_sp", "activityId", "");
        if (TextUtils.isEmpty(strM1363m)) {
            NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition activityId is empty!");
            return false;
        }
        if (1 != C0212e0.m1357g(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "displayEntryFlag", 0)) {
            NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition activity displayEntryFlag is not 1!");
            return false;
        }
        if (!C13821b.m82867w().m82873F(strM1363m)) {
            return true;
        }
        NotifyLogger.m29916w(TAG, "checkCampaignEntryCondition activity finished!");
        return false;
    }

    public static boolean isSilenceUser() {
        String strM80906e0 = C13452e.m80781L().m80906e0();
        NotifyLogger.m29913d(TAG, "isSilenceUser userStatus = " + strM80906e0);
        return StringUtil.equals("I", strM80906e0) || StringUtil.equals("W", strM80906e0);
    }
}
