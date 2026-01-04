package com.huawei.hicloud.messagecenter.manager;

import android.app.NotificationManager;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.NotifyJumpInfo;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.notification.bean.HiCloudMsgNoticeAction;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class MessageCenterReportUtil {
    private static final String TAG = "MessageCenterReportUtil";

    private static void biReport(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            if (linkedHashMap != null) {
                linkedHashMapM79497A.putAll(linkedHashMap);
            }
            C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "biReport exception: " + e10.toString());
        }
    }

    private static void omReport(String str, Map<String, String> map) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07046"), str, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "omReport exception: " + e10.toString());
        }
    }

    private static void report(String str, LinkedHashMap<String, String> linkedHashMap) {
        biReport(str, linkedHashMap);
        omReport(str, linkedHashMap);
    }

    public static void reportCommonMsgProcSuccess(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        String category;
        String notifyType;
        String str2;
        String notifyType2;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            notifyType = "unknown_type";
        }
        String str3 = notifyType;
        String str4 = category;
        if (notifyWay != null) {
            String name = notifyWay.getName();
            NotifyJumpInfo notifyJumpInfo = notifyWay.getNotifyJumpInfo();
            notifyType2 = notifyJumpInfo != null ? notifyJumpInfo.getNotifyType() : "";
            str2 = name;
        } else {
            str2 = "";
            notifyType2 = str2;
        }
        reportMsgProcSuccess(str4, "unknown_id", str3, str, str2, notifyType2, null);
    }

    public static void reportH5WindowShow(String str, String str2, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("message_id", str2);
        linkedHashMap.put("unique_id", str);
        linkedHashMap.put("h5_window_action", String.valueOf(i10));
        report("H5_WINDOW_SHOW", linkedHashMap);
    }

    public static void reportH5WindowShowResult(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("result", str);
        report("mecloud_end_h5_show_result", linkedHashMap);
    }

    public static void reportMsgActivityEnd(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("report_result", str);
        linkedHashMap.put("report_callback", str2);
        report("RECEIVE_MSG_ACTIVITY_END", linkedHashMap);
    }

    public static void reportMsgClicked(MessageCenterMsgObj messageCenterMsgObj) {
        if (messageCenterMsgObj == null) {
            NotifyLogger.m29914e(TAG, "reportMsgClicked, msg obj is null");
        } else {
            reportMsgClicked(messageCenterMsgObj.getCategory(), messageCenterMsgObj.getResourceInfo(), messageCenterMsgObj.getUniqueId(), messageCenterMsgObj.getMsgType());
        }
    }

    public static void reportMsgProcInterrupted(String str) {
        reportMsgProcInterrupted("unknown_category", "unknown_id", "unknown_type", "unknown_local_id", str);
    }

    public static void reportMsgProcSuccess(ClientMessageBody clientMessageBody, String str, String str2, NotifyWay notifyWay) {
        String category;
        String notifyType;
        String name;
        String msgType;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            notifyType = "unknown_type";
        }
        String str3 = notifyType;
        String str4 = category;
        if (notifyWay != null) {
            name = notifyWay.getName();
            msgType = notifyWay.getMsgType();
        } else {
            name = "";
            msgType = name;
        }
        if (TextUtils.isEmpty(str)) {
            str = "unknown_id";
        }
        reportMsgProcSuccess(str4, str, str3, str2, name, msgType);
    }

    public static void reportMsgShow(List<MessageCenterMsgObj> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<MessageCenterMsgObj> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getResourceInfo());
            }
        }
        String json = new Gson().toJson(arrayList);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("display_message_num", String.valueOf(arrayList.size()));
        linkedHashMap.put("display_message_info_list", json);
        report("MSG_UPDATE_SHOW", linkedHashMap);
    }

    public static void reportNotifyClickEvent(Intent intent) {
        if (intent == null) {
            NotifyLogger.m29915i(TAG, "reportNotifyClickEvent intent is null.");
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        String stringExtra = hiCloudSafeIntent.getStringExtra("message_category");
        if (!"operation".equals(stringExtra) && !"common".equals(stringExtra)) {
            NotifyLogger.m29915i(TAG, "reportNotifyClickEvent is not operation or common type.");
            return;
        }
        String stringExtra2 = hiCloudSafeIntent.getStringExtra("unique_id");
        String stringExtra3 = hiCloudSafeIntent.getStringExtra("message_id");
        String stringExtra4 = hiCloudSafeIntent.getStringExtra("action_type");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("message_category", stringExtra);
        linkedHashMap.put("message_id", stringExtra3);
        linkedHashMap.put("unique_id", stringExtra2);
        linkedHashMap.put("action_type", stringExtra4);
        report("NOTIFY_CLICKED", linkedHashMap);
    }

    public static void reportOperateMsgProcSuccess(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        String category;
        String cfgResourceId;
        String notifyType;
        String name;
        String msgType;
        HiCloudMsgNoticeAction actionById;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            cfgResourceId = clientMessageBody.getCfgResourceId();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            cfgResourceId = "unknown_id";
            notifyType = "unknown_type";
        }
        String str2 = notifyType;
        String str3 = category;
        String str4 = cfgResourceId;
        if (notifyWay != null) {
            name = notifyWay.getName();
            msgType = notifyWay.getMsgType();
        } else {
            name = "";
            msgType = name;
        }
        new LinkedHashMap().put("action_type", String.valueOf((TextUtils.isEmpty(str4) || (actionById = HiCloudMsgNoticeConfigManager.getInstance().getActionById(str4)) == null) ? -1 : actionById.getAction()));
        reportMsgProcSuccess(str3, str4, str2, str, name, msgType);
    }

    public static void reportProcParamSatisfy(LinkedHashMap<String, String> linkedHashMap) {
        report("TRIGGER_SATISFY_RESULT", linkedHashMap);
    }

    public static void reportReceiveMsgSuccess(ClientMessageBody clientMessageBody, String str) {
        String category;
        String cfgResourceId;
        String notifyType;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            cfgResourceId = clientMessageBody.getCfgResourceId();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            cfgResourceId = "unknown_id";
            notifyType = "unknown_type";
        }
        reportReceiveMsgSuccess(category, cfgResourceId, notifyType, str);
    }

    private static void setNotifySwitchStatus(String str, LinkedHashMap<String, String> linkedHashMap) {
        NotificationManager notificationManager;
        if (TextUtils.isEmpty(str) || linkedHashMap == null || !"notification_bar".equals(str) || (notificationManager = (NotificationManager) C0213f.m1377a().getSystemService("notification")) == null) {
            return;
        }
        linkedHashMap.put("notify_switch_enable", String.valueOf(notificationManager.areNotificationsEnabled() ? 1 : 0));
    }

    public static void reportMsgProcInterrupted(ClientMessageBody clientMessageBody, String str) {
        String category;
        String cfgResourceId;
        String notifyType;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            cfgResourceId = clientMessageBody.getCfgResourceId();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            cfgResourceId = "unknown_id";
            notifyType = "unknown_type";
        }
        reportMsgProcInterrupted(category, cfgResourceId, notifyType, "unknown_local_id", str);
    }

    private static void reportReceiveMsgSuccess(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("message_category", str);
        linkedHashMap.put("message_id", str2);
        linkedHashMap.put(RemoteMessageConst.MSGTYPE, str3);
        linkedHashMap.put("unique_id", str4);
        report("RECEIVE_MSG_SUCCESS", linkedHashMap);
    }

    private static void reportMsgClicked(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("message_category", str);
        linkedHashMap.put("message_id", str2);
        linkedHashMap.put("unique_id", str3);
        linkedHashMap.put("notify_way_type", str4);
        report("MSG_CLICKED", linkedHashMap);
    }

    public static void reportMsgProcSuccess(ClientMessageBody clientMessageBody, NotifyNeedData notifyNeedData, String str, NotifyWay notifyWay) {
        String category;
        String notifyType;
        String name;
        String msgType;
        String resourceInfo;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            notifyType = "unknown_type";
        }
        String str2 = notifyType;
        String str3 = category;
        if (notifyWay != null) {
            name = notifyWay.getName();
            msgType = notifyWay.getMsgType();
        } else {
            name = "";
            msgType = name;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (notifyNeedData != null) {
            resourceInfo = notifyNeedData.getResourceInfo();
            linkedHashMap.put(NotifyConstants.NotificationReport.KEY_NOTICE_TYPE, notifyNeedData.getNoticeType());
            linkedHashMap.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, String.valueOf(notifyNeedData.getActivityType()));
        } else {
            resourceInfo = "unknown_id";
        }
        reportMsgProcSuccess(str3, resourceInfo, str2, str, name, msgType, linkedHashMap);
    }

    public static void reportMsgProcInterrupted(ClientMessageBody clientMessageBody, String str, String str2) {
        String category;
        String cfgResourceId;
        String notifyType;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            cfgResourceId = clientMessageBody.getCfgResourceId();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            cfgResourceId = "unknown_id";
            notifyType = "unknown_type";
        }
        reportMsgProcInterrupted(category, cfgResourceId, notifyType, str, str2);
    }

    private static void reportMsgProcInterrupted(String str, String str2, String str3, String str4, String str5) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("message_category", str);
        linkedHashMap.put("message_id", str2);
        linkedHashMap.put(RemoteMessageConst.MSGTYPE, str3);
        linkedHashMap.put("unique_id", str4);
        linkedHashMap.put("reason", str5);
        report("MSG_PROCESS_INTERRUPTED", linkedHashMap);
    }

    public static void reportMsgProcSuccess(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        String category;
        String cfgResourceId;
        String notifyType;
        String name;
        String msgType;
        if (clientMessageBody != null) {
            category = clientMessageBody.getCategory();
            cfgResourceId = clientMessageBody.getCfgResourceId();
            notifyType = clientMessageBody.getNotifyType();
        } else {
            category = "unknown_category";
            cfgResourceId = "unknown_id";
            notifyType = "unknown_type";
        }
        String str2 = notifyType;
        String str3 = category;
        String str4 = cfgResourceId;
        if (notifyWay != null) {
            name = notifyWay.getName();
            msgType = notifyWay.getMsgType();
        } else {
            name = "";
            msgType = name;
        }
        reportMsgProcSuccess(str3, str4, str2, str, name, msgType);
    }

    private static void reportMsgProcSuccess(String str, String str2, String str3, String str4, String str5, String str6) {
        reportMsgProcSuccess(str, str2, str3, str4, str5, str6, null);
    }

    private static void reportMsgProcSuccess(String str, String str2, String str3, String str4, String str5, String str6, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("message_category", str);
        linkedHashMap2.put("message_id", str2);
        linkedHashMap2.put(RemoteMessageConst.MSGTYPE, str3);
        linkedHashMap2.put("unique_id", str4);
        linkedHashMap2.put("notify_way_name", str5);
        linkedHashMap2.put("notify_way_type", str6);
        setNotifySwitchStatus(str5, linkedHashMap2);
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            linkedHashMap2.putAll(linkedHashMap);
        }
        report("MSG_PROCESS_SUCCESS", linkedHashMap2);
    }
}
