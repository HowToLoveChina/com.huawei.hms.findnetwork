package com.huawei.android.hicloud.p088ui.notification;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.BackUpOverMonthRecordConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.StockActiveConstants;
import com.huawei.hicloud.notification.receiver.CommonNotifyCallBack;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import p514o9.C11839m;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p766x8.C13731j;
import vn.C13469a;

/* loaded from: classes3.dex */
public class NotificationRemoveReceiver implements CommonNotifyCallBack {
    private static final Map<String, String> CANCELKEY;
    private static final Map<String, String> NEVERKEY;
    private static final String TAG = "NotificationRemoveReceiver";

    static {
        HashMap map = new HashMap();
        CANCELKEY = map;
        map.put("1", "mecloud_notify_pullnew_cancel");
        map.put("2", "mecloud_notify_cloudspace_cancel");
        map.put("3", "mecloud_notify_cloudspace_not_enough_cancel");
        map.put("5", "risk_notice_cancel");
        map.put("6", "upgrade_notice_cancel");
        map.put("7", StockActiveConstants.Report.CANCEL_NOTIFY);
        map.put("8", BackUpOverMonthRecordConstants.Report.CANCEL_NOTIFY);
        map.put("9", "accept_gift_notify_cancel");
        map.put("10", "app_installed_notify_cancel");
        HashMap map2 = new HashMap();
        NEVERKEY = map2;
        map2.put("1", "mecloud_notify_pullnew_never");
        map2.put("2", "mecloud_notify_cloudspace_never");
        map2.put("3", "mecloud_notify_cloudspace_not_enough_cancel_never");
        map2.put("5", "risk_notice_never");
        map2.put("6", "upgrade_notice_never");
        map2.put("7", StockActiveConstants.Report.NEVER_NOTIFY);
        map2.put("8", BackUpOverMonthRecordConstants.Report.NEVER_NOTIFY);
        map2.put("9", "accept_gift_notify_cancel");
        map2.put("10", "app_installed_notify_cancel");
    }

    @Override // com.huawei.hicloud.notification.receiver.CommonNotifyCallBack
    public boolean onReciveNotify(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        Bundle bundleExtra;
        if (hiCloudSafeIntent == null) {
            C11839m.m70687e(TAG, "onReceive intent is null");
            return false;
        }
        String stringExtra = hiCloudSafeIntent.getStringExtra(CommonNotifyReceiver.COMMAND_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            C11839m.m70687e(TAG, "onReceive action is nulll");
            return false;
        }
        C11839m.m70686d(TAG, "onReceive action:" + stringExtra);
        if (stringExtra.equals(CommonNotifyReceiver.COMMAND_CANCAL)) {
            String stringExtra2 = hiCloudSafeIntent.getStringExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE);
            float floatExtra = hiCloudSafeIntent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f);
            if (TextUtils.isEmpty(stringExtra2)) {
                return false;
            }
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            if (hiCloudSafeIntent.getBooleanExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, false) && (bundleExtra = hiCloudSafeIntent.getBundleExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO)) != null) {
                linkedHashMapM79499C.put("notify_id", Integer.valueOf(bundleExtra.getInt("notify_id")));
                linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, bundleExtra.getString(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE));
            }
            linkedHashMapM79499C.put("voucher_notice", Boolean.valueOf(hiCloudSafeIntent.getBooleanExtra(HNConstants.C4906BI.DATA_IS_VOUCHER_NOTICE, false)));
            linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(floatExtra));
            if (stringExtra2.equals("6")) {
                linkedHashMapM79499C.put("forced_upgrade_type", Integer.valueOf(C10028c.m62182c0().m62278U()));
            }
            String stringExtra3 = hiCloudSafeIntent.getStringExtra(HNConstants.C4906BI.NOTIFY_TITLE);
            if (!TextUtils.isEmpty(stringExtra3)) {
                linkedHashMapM79499C.put(HNConstants.C4906BI.NOTIFY_TITLE, stringExtra3);
            }
            if ("7".equals(stringExtra2)) {
                C13469a c13469aM81112f = C13469a.m81112f();
                Map<String, String> map = CANCELKEY;
                c13469aM81112f.m81113a(map.get(stringExtra2), linkedHashMapM79499C);
                C13469a.m81112f().m81114b("PVC", map.get(stringExtra2), "4", "49", linkedHashMapM79499C);
            } else {
                C13227f c13227fM79492i1 = C13227f.m79492i1();
                Map<String, String> map2 = CANCELKEY;
                c13227fM79492i1.m79591l0(map2.get(stringExtra2), linkedHashMapM79499C);
                UBAAnalyze.m29958S("PVC", map2.get(stringExtra2), "4", "100", linkedHashMapM79499C);
            }
            if (!C13731j.m82513c(context)) {
                C13227f c13227fM79492i12 = C13227f.m79492i1();
                Map<String, String> map3 = NEVERKEY;
                c13227fM79492i12.m79591l0(map3.get(stringExtra2), linkedHashMapM79499C);
                UBAAnalyze.m29958S("PVC", map3.get(stringExtra2), "4", "100", linkedHashMapM79499C);
            }
        }
        return false;
    }
}
