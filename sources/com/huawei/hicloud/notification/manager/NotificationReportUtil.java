package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0239x;
import p429kk.C11058a;
import p429kk.C11060c;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class NotificationReportUtil {
    private static final String TAG = "NotificationReportUtil";

    public static void clearLastDayMillis() {
        C0212e0.m1353c(NotifyConstants.NotificationReport.SP_NAME_NOTIFICATION_REPORT);
    }

    private static long getLastDayMillis(String str) {
        return C0212e0.m1361k(NotifyConstants.NotificationReport.SP_NAME_NOTIFICATION_REPORT, str);
    }

    public static boolean isLimitInOneDay(String str) {
        try {
            return !isOutDayLimits(getLastDayMillis(str), 1);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudBackupNoSpace exception:" + e10.toString());
            return false;
        }
    }

    public static boolean isOutDayLimits(long j10, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j10));
        int i11 = calendar.get(1);
        int i12 = calendar2.get(1);
        if (i11 > i12) {
            return true;
        }
        return i11 == i12 && calendar.get(6) - calendar2.get(6) >= i10;
    }

    public static void reportAllSwitchOff(String str) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_NOTI_NAME, str);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_ALL_SWITCH_OFF, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportAllSwitchOff exception:" + e10.toString());
        }
    }

    public static void reportAutoBackupExecute() {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, NotifyConstants.NotificationReport.OPERATION_NAME_AUTO_BACKUP_EXECUTE);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_AUTO_BACKUP_EXECUTE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportAutoBackupExecute exception:" + e10.toString());
        }
    }

    public static void reportAutoBackupNoticeDelay(Map<String, String> map) {
        try {
            HashMap map2 = new HashMap();
            if (map != null && !map.isEmpty()) {
                map2.putAll(map);
            }
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_AUTO_BACKUP_NOTICE_DELAY, map2);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportAutoBackupNoticeDelay exception:" + e10.toString());
        }
    }

    public static void reportBackupCycle(String str, String str2, int i10) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.KEY_NO_BACKUP_WEEKS, String.valueOf(i10));
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_BACKUP_CYCLE_CHECK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportBackupCycle exception:" + e10.toString());
        }
    }

    public static void reportCloudBackupActivityNoSpace(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_BACKUP_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudBackupNoSpace exception:" + e10.toString());
        }
    }

    public static void reportCloudBackupFrequency(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_BACKUP_FREQUENCY, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudBackupFrequency exception:" + e10.toString());
        }
    }

    public static void reportCloudBackupNoSpace(String str, String str2) {
        try {
            String str3 = NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_BACKUP_NO_SPACE + str;
            if (isLimitInOneDay(str3)) {
                return;
            }
            setLastDayMillis(str3, System.currentTimeMillis());
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_BACKUP_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudBackupNoSpace exception:" + e10.toString());
        }
    }

    public static void reportCloudBackupNoSpaceWithInfo(String str, String str2, String str3) {
        try {
            String str4 = NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_BACKUP_NO_SPACE + str;
            if (isLimitInOneDay(str4)) {
                return;
            }
            setLastDayMillis(str4, System.currentTimeMillis());
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.KEY_INFORMATION, str3);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_BACKUP_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudBackupNoSpace exception:" + e10.toString());
        }
    }

    public static void reportCloudNoSpace(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudNoSpace exception:" + e10.toString());
        }
    }

    public static void reportCloudNoSpaceException(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudNoSpaceException exception:" + e10.toString());
        }
    }

    public static void reportCloudSpaceCheckResult(String str, int i10, boolean z10) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", String.valueOf(i10));
            map.put(NotifyConstants.NotificationReport.KEY_SPACE_NOTI_FROM_ALBUM, String.valueOf(z10));
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudSpaceCheckResult exception:" + e10.toString());
        }
    }

    public static void reportDailyJobByAppLastTime(String str, String str2, long j10, long j11, long j12, long j13) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_SOURCE, str2);
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_BY_APP_CURRENT_TIME, String.valueOf(j10));
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_BY_APP_DURATION, String.valueOf(j11));
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_BY_APP_MIN_LATENCY, String.valueOf(j12));
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_BY_APP_LAST_DURATION, String.valueOf(j13));
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_DAILY_JOB_MANAGER, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDailyJobByAppLastTime exception:" + e10.toString());
        }
    }

    public static void reportDailyJobExecuteTask(String str, int i10) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put(NotifyConstants.NotificationReport.EVENT_NAME_CALLLBACK_NUM, String.valueOf(i10));
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_DAILY_JOB_MANAGER, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDailyJobExecuteTask exception:" + e10.toString());
        }
    }

    public static void reportDailyJobStartError(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_SOURCE, str2);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_DAILY_JOB_MANAGER, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDailyJobStartError exception:" + e10.toString());
        }
    }

    public static void reportDailyJobStartResult(String str, String str2, int i10, long j10) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_SOURCE, str2);
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_RETCODE, String.valueOf(i10));
            map.put(NotifyConstants.NotificationReport.KEY_DAILY_JOB_LATENCY_TIME, String.valueOf(j10));
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_DAILY_JOB_MANAGER, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDailyJobStartResult exception:" + e10.toString());
        }
    }

    public static void reportDialogMuted(String str) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE, str);
            reportOMEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDialogMuted exception:" + e10.toString());
        }
    }

    public static void reportDialogMutedDelay(String str) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_DELAY_SCENE, str);
            reportOMEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDialogMutedDelay exception:" + e10.toString());
        }
    }

    public static void reportDialogMutedShowCondition(boolean z10, boolean z11) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONTITION_IS_HOME, String.valueOf(z10));
            linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONTITION_SCREEN_STATUS, String.valueOf(z11));
            reportOMEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONDITION, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDialogMutedShowCondition exception:" + e10.toString());
        }
    }

    public static void reportGetFreePackageFail(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C13230i.m79507N0(linkedHashMap);
        linkedHashMap.put("error_code", str);
        linkedHashMap.put("description", str2);
        reportOMEvent(NotifyConstants.NotificationReport.EVENT_GET_FREE_PACKAGE_FAIL, linkedHashMap);
    }

    public static void reportGetFreePackageSuccess() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C13230i.m79507N0(linkedHashMap);
        linkedHashMap.put("error_code", "0");
        reportOMEvent(NotifyConstants.NotificationReport.EVENT_GET_FREE_PACKAGE_SUCCESS, linkedHashMap);
    }

    public static void reportLastSpaceNoticeInfo() {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_LAST_SPACE_NOTICE_CHECKING, String.valueOf(C10028c.m62182c0().m62253O0()));
            map.put(NotifyConstants.NotificationReport.KEY_LAST_SPACE_NOTICE_PROCESS_ID, String.valueOf(C10028c.m62182c0().m62354l0()));
            map.put(NotifyConstants.NotificationReport.KEY_LAST_SPACE_NOTICE_CHECK_TIME, String.valueOf(C10028c.m62182c0().m62349k0()));
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_LAST_CLOUD_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportLastSpaceNoticeInfo exception:" + e10.toString());
        }
    }

    public static void reportNegFreqControlled(LinkedHashMap<String, String> linkedHashMap) {
        reportOMEvent(NotifyConstants.NotificationReport.EVENT_NOTICE_NEG_FREQ_CHECK_FAIL, linkedHashMap);
    }

    public static void reportNotificationTimer(String str, Map<String, String> map) {
        try {
            HashMap map2 = new HashMap();
            if (map != null && !map.isEmpty()) {
                map2.putAll(map);
            }
            reportOMEvent(str, map2);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportAutoBackupNoticeDelay exception:" + e10.getMessage());
        }
    }

    public static void reportOMEvent(String str, Map<String, String> map) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07008"), "07008", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(str);
            c11060cM66626a.m66665u("0");
            C0239x.m1671c().m1672a(map);
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportOMEvent exception:" + e10.toString());
        }
    }

    public static void reportOtherOperationDailyCheck(String str, int i10, boolean z10) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_OTHER_OPRATION_CHECK_IS_TRANS_NOW, String.valueOf(i10));
            map.put(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_OTHER_OPRATION_CHECK_IS_NEED_PROCESS, String.valueOf(z10));
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_DAILY_OTHER_OPRATION_CHECK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDailyJobExecuteTask exception:" + e10.toString());
        }
    }

    public static void reportPageDialogEvent(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("event", str2);
        linkedHashMap2.putAll(linkedHashMap);
        C13230i.m79504I().m79591l0(str, linkedHashMap2);
        UBAAnalyze.m29958S("PVC", str, "4", "22", linkedHashMap2);
    }

    public static void reportPpsAdCheck(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_PPS_AD_LOADER_CHECK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportPpsAdCheck exception:" + e10.toString());
        }
    }

    public static void reportPrepareActivityNoSpace(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_PREPARE_ACTIVITY_NO_SPACE, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudBackupNoSpace exception:" + e10.toString());
        }
    }

    public static void reportSpaceNoticeDelay(Map<String, String> map) {
        try {
            HashMap map2 = new HashMap();
            if (map != null && !map.isEmpty()) {
                map2.putAll(map);
            }
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_SPACE_NOTICE_DELAY, map2);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportSpaceNoticeDelay exception:" + e10.toString());
        }
    }

    public static void reportSpaceNotifyActivityShow(Map<String, String> map) {
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "reportSpaceNotifyActivityShow exception:" + e10.toString());
                return;
            }
        }
        map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, NotifyConstants.NotificationReport.EVENT_NAME_SPACE_NOTICE_ACTIVITY_FINAL_SHOW);
        reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_NO_SPACE, map);
    }

    public static void reportSpaceNotifyCheck() {
        try {
            if (isLimitInOneDay(NotifyConstants.NotificationReport.SP_KEY_NOTIFICATION_CHECK_TIME)) {
                return;
            }
            setLastDayMillis(NotifyConstants.NotificationReport.SP_KEY_NOTIFICATION_CHECK_TIME, System.currentTimeMillis());
            HashMap map = new HashMap();
            map.put("detail", NotificationReportManager.getInstance().getContent());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_SPACE_CHECK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportSpaceNotifyCheck exception:" + e10.toString());
        }
    }

    public static void reportSpaceNotifyClear(String str) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_CLEAR_FREQ_FROM, str);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_SPACE_NOTIFY_OPERATOR_CLEAR, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportOMEvent exception:" + e10.toString());
        }
    }

    public static void reportSpaceNotifyShow(Map<String, String> map) {
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "reportSpaceNotifyShow exception:" + e10.toString());
                return;
            }
        }
        map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, NotifyConstants.NotificationReport.EVENT_NAME_SPACE_NOTICE_FINAL_SHOW);
        reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_CLOUD_NO_SPACE, map);
    }

    public static void reportSpaceOverMaxCheck(String str, int i10, long j10, long j11, long j12) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_NOTI_NAME, str);
            map.put(NotifyConstants.NotificationReport.KEY_SPACE_CHECK_RESULT, String.valueOf(i10));
            map.put(NotifyConstants.NotificationReport.KEY_SPACE_CHECK_USED, String.valueOf(j10));
            map.put(NotifyConstants.NotificationReport.KEY_SPACE_CHECK_TOTAL, String.valueOf(j11));
            map.put(NotifyConstants.NotificationReport.KEY_SPACE_CHECK_MAX, String.valueOf(j12));
            map.put(NotifyConstants.NotificationReport.KEY_SPACE_CHECK_SERVICE_COUNTRY, C13452e.m80781L().m80921h0());
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_SPACE_OVER_MAX, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportSpaceOverMaxCheck exception:" + e10.toString());
        }
    }

    public static void reportSpaceUse(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_SPACE_USE_CHECK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportSpaceUse exception:" + e10.toString());
        }
    }

    public static void reportTriggerSrc(String str) {
        try {
            String str2 = NotifyConstants.NotificationReport.OPERATION_NAME_TRIGGER_SRC_CHECK + str;
            if (isLimitInOneDay(str2)) {
                return;
            }
            setLastDayMillis(str2, System.currentTimeMillis());
            HashMap map = new HashMap();
            map.put("detail", str);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_TRIGGER_SRC_CHECK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportTriggerSrc exception:" + e10.toString());
        }
    }

    public static void reportWiseMarketingOperaitonResult(String str, Map<String, String> map, String str2) {
        try {
            HashMap map2 = new HashMap();
            map2.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
            map2.put("result", str2);
            reportOMEvent(NotifyConstants.NotificationReport.OPERATION_NAME_WISEMARKETING_OPERATION, map2);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportWiseMarketingOperaitonResult exception:" + e10.toString());
        }
    }

    private static void setLastDayMillis(String str, long j10) {
        C0212e0.m1376z(NotifyConstants.NotificationReport.SP_NAME_NOTIFICATION_REPORT, str, j10);
    }

    public static void reportDialogMuted(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE, str);
            map.put(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_TYPE, str2);
            reportOMEvent(NotifyConstants.NotificationReport.EVENT_BACKUP_FAIL_DIALOG_MUTED, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportDialogMuted exception:" + e10.toString());
        }
    }
}
