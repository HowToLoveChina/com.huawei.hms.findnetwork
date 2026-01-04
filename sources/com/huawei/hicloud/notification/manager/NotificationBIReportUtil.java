package com.huawei.hicloud.notification.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.util.LinkedHashMap;
import p684un.C13227f;
import p684un.C13230i;
import vn.C13469a;

/* loaded from: classes6.dex */
public class NotificationBIReportUtil {
    private static final long REPORT_INTERV = 28800000;

    public static void addDayOnceCheckFailNotice(JsonArray jsonArray, String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("noti_id", str2);
        jsonObject.addProperty("noti_type", str);
        jsonArray.add(jsonObject);
    }

    public static void reportActivityDayonceCheckFail(JsonArray jsonArray) {
        if (jsonArray == null || jsonArray.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationBIReport.BI_PARAM_FAILED_NOTICE_INFO, jsonArray.toString());
        reportBIEventWithTimeCheck(NotifyConstants.NotificationBIReport.BI_EVENT_ACTIVITY_DAYONECE_CHECK_FAIL, linkedHashMap);
    }

    public static void reportAutoBackupActivityDayonceCheckFail(JsonArray jsonArray) {
        if (jsonArray == null || jsonArray.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationBIReport.BI_PARAM_FAILED_NOTICE_INFO, jsonArray.toString());
        reportBIEventWithTimeCheck(NotifyConstants.NotificationBIReport.BI_EVENT_AUTO_BACKUP_ACTIVITY_DAYONECE_CHECK_FAIL, linkedHashMap);
    }

    public static void reportAutoBackupDayonceCheckFail(JsonArray jsonArray) {
        if (jsonArray == null || jsonArray.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationBIReport.BI_PARAM_FAILED_NOTICE_INFO, jsonArray.toString());
        reportBIEventWithTimeCheck(NotifyConstants.NotificationBIReport.BI_EVENT_AUTO_BACKUP_DAYONECE_CHECK_FAIL, linkedHashMap);
    }

    public static void reportAutoBackupTaskCenterCheckFail(JsonArray jsonArray) {
        if (jsonArray == null || jsonArray.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationBIReport.BI_PARAM_FAILED_NOTICE_INFO, jsonArray.toString());
        reportBIEventWithTimeCheck(NotifyConstants.NotificationBIReport.BI_EVENT_AUTO_BACKUP_TASK_CENTER_CHECK_FAIL, linkedHashMap);
    }

    private static void reportBIEventWithTimeCheck(String str, LinkedHashMap<String, String> linkedHashMap) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - C10028c.m62182c0().m62359m0(str) > REPORT_INTERV) {
            C13227f.m79492i1().m79567R(str, linkedHashMap);
            UBAAnalyze.m29947H("PVC", str, linkedHashMap);
            C10028c.m62182c0().m62309b3(str, jCurrentTimeMillis);
        }
    }

    public static void reportDayonceCheckFail(JsonArray jsonArray) {
        if (jsonArray == null || jsonArray.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationBIReport.BI_PARAM_FAILED_NOTICE_INFO, jsonArray.toString());
        reportBIEventWithTimeCheck(NotifyConstants.NotificationBIReport.BI_EVENT_DAYONECE_CHECK_FAIL, linkedHashMap);
    }

    public static void reportDialogMuted(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE, str);
        reportEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED, linkedHashMap);
    }

    public static void reportDialogMutedDelay(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_DELAY_SCENE, str);
        reportEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED, linkedHashMap);
    }

    public static void reportDialogMutedShowCondition(boolean z10, boolean z11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONTITION_IS_HOME, String.valueOf(z10));
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONTITION_SCREEN_STATUS, String.valueOf(z11));
        reportEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONDITION, linkedHashMap);
    }

    private static void reportEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        C13227f.m79492i1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29947H("PVC", str, linkedHashMap);
    }

    public static void reportFullFrequencyCheckFail(boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_from_album", String.valueOf(z10));
        reportBIEventWithTimeCheck(NotifyConstants.NotificationBIReport.BI_EVENT_FULL_FREQ_CHECK_FAIL, linkedHashMap);
    }

    public static void reportGetFreePackageFail(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("error_code", str);
        linkedHashMap.put("description", str2);
        C13230i.m79507N0(linkedHashMap);
        C13469a.m81112f().m81113a(NotifyConstants.NotificationReport.EVENT_GET_FREE_PACKAGE_FAIL, linkedHashMap);
        C13469a.m81112f().m81114b("CKC", NotifyConstants.NotificationReport.EVENT_GET_FREE_PACKAGE_FAIL, "", "", linkedHashMap);
    }

    public static void reportGetFreePackageSuccess() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("error_code", "0");
        C13230i.m79507N0(linkedHashMap);
        C13469a.m81112f().m81113a(NotifyConstants.NotificationReport.EVENT_GET_FREE_PACKAGE_SUCCESS, linkedHashMap);
        C13469a.m81112f().m81114b("CKC", NotifyConstants.NotificationReport.EVENT_GET_FREE_PACKAGE_SUCCESS, "", "", linkedHashMap);
    }

    public static void reportLastCheckExceptionInfo() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationReport.KEY_LAST_SPACE_NOTICE_PROCESS_ID, String.valueOf(C10028c.m62182c0().m62354l0()));
        linkedHashMap.put(NotifyConstants.NotificationReport.KEY_LAST_SPACE_NOTICE_CHECK_TIME, String.valueOf(C10028c.m62182c0().m62349k0()));
        reportBIEventWithTimeCheck(NotifyConstants.NotificationBIReport.BI_EVENT_NOTICE_CHECK_EXCEPTION, linkedHashMap);
    }

    public static void reportNegFreqControlled(LinkedHashMap<String, String> linkedHashMap) {
        reportEvent(NotifyConstants.NotificationReport.EVENT_NOTICE_NEG_FREQ_CHECK_FAIL, linkedHashMap);
    }

    public static void reportDialogMuted(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE, str);
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_TYPE, str2);
        reportEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED, linkedHashMap);
    }
}
