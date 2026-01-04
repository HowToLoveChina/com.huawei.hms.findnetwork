package com.huawei.hicloud.notification;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.RestoreNotifyConfigManager;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyContent;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifyLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifyOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifydDevicesOperator;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0234s;
import p015ak.C0241z;
import p783xp.C13843a;

/* loaded from: classes6.dex */
public class RestoreNotifyUtil {
    private static final long HOUR_MILLS = 3600000;
    private static final long MINUTE_MILLS = 60000;
    private static final String OOBE_FISH_TIME = "oobe_finish_time";
    public static final String OOBE_LOGIN_STATE = "login";
    public static final String OOBE_LOGOUT_STATE = "logout";
    private static final String RESTORE_HAVE_RECOVERED = "have_restored";
    private static final String RESTORE_NOTIFIED_COUNT = "restore_notified_count";
    public static final String RESTORE_NOTIFY_SP = "restore_notify_record";
    private static final String RESTORE_NOTIFY_STATE = "is_oobe_login";
    private static final String RESTORE_NOTIFY_TIME = "restore_notify_time";
    private static final String RESTORE_OOBE_NOTIFIED = "oobe_notified";
    private static final String RESTORE_START_CLOUD_NOTIFIED = "start_cloud_notified";
    private static final String TAG = "RestoreNotifyUtil";
    private static final String WAITING_OOBE_NOTIFY = "waiting_oobe_notify";
    private static final Uri CALENDAR_IS_NEED_SYNC_URI = Uri.parse("content://com.android.calendar/hw_sync/get_count");
    private static final RestoreNotifyUtil INSTANCE = new RestoreNotifyUtil();

    public static RestoreNotifyUtil getInstance() {
        return INSTANCE;
    }

    public static boolean hasCalendarLocalData(Context context) {
        Uri uri = CALENDAR_IS_NEED_SYNC_URI;
        boolean z10 = false;
        if (!C0209d.m1227Y1(context, uri)) {
            NotifyLogger.m29914e(TAG, "hasCalendarLocalData, is not Target App or System App");
            return false;
        }
        Cursor cursorM1286n2 = C0209d.m1286n2(context, uri, null, null, null, null);
        if (cursorM1286n2 != null) {
            try {
                try {
                    if (cursorM1286n2.getCount() == 1 && cursorM1286n2.moveToFirst()) {
                        if (cursorM1286n2.getInt(cursorM1286n2.getColumnIndex("count")) > 0) {
                            z10 = true;
                        }
                    }
                } catch (SQLException e10) {
                    NotifyLogger.m29914e(TAG, "hasCalendarLocalData error: " + e10.toString());
                }
            } finally {
                cursorM1286n2.close();
            }
        }
        return z10;
    }

    public static boolean hasContactLocalData(Context context) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "query contact local data error : context is null");
            return false;
        }
        Uri uriBuild = new Uri.Builder().authority(C13843a.m83095q()).scheme("content").appendPath("query_local_data").build();
        if (!C0209d.m1227Y1(context, uriBuild)) {
            NotifyLogger.m29914e(TAG, "hasContactLocalData, TargetApp is not SystemApp");
            return false;
        }
        Cursor cursorM1286n2 = C0209d.m1286n2(context, uriBuild, null, null, null, null);
        if (cursorM1286n2 != null) {
            NotifyLogger.m29914e(TAG, "queryProvider:" + cursorM1286n2.getCount());
            try {
                try {
                    if (cursorM1286n2.getCount() > 0) {
                        cursorM1286n2.close();
                        return true;
                    }
                } catch (SQLException e10) {
                    NotifyLogger.m29914e(TAG, "hasContactLocalData error: " + e10.toString());
                }
            } finally {
                cursorM1286n2.close();
            }
        }
        return false;
    }

    public boolean checkNotifyFrequency(Context context, String str) {
        int notifiedCount = getNotifiedCount(context);
        RestoreNotifyConfig restoreNotifyConfig = getRestoreNotifyConfig(str);
        if (restoreNotifyConfig != null) {
            return notifiedCount < Integer.parseInt(restoreNotifyConfig.getTimesInHours());
        }
        NotifyLogger.m29914e(TAG, "RestoreNotifyConfig nor found");
        return false;
    }

    public boolean checkNotifyInterval(Context context) {
        return System.currentTimeMillis() - getLastNotifyTime(context) >= 3600000;
    }

    public boolean checkNotifyTime(Context context, String str) {
        NotifyLogger.m29913d(TAG, "checkNotifyTime: ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        RestoreNotifyConfig restoreNotifyConfig = getRestoreNotifyConfig(str);
        if (restoreNotifyConfig == null) {
            NotifyLogger.m29914e(TAG, "RestoreNotifyConfig nor found");
            return false;
        }
        long jM1685c = C0241z.m1685c(restoreNotifyConfig.getHoursAfterOOBE()) * 3600000;
        long oOBEFishTime = jCurrentTimeMillis - getOOBEFishTime(context);
        if (oOBEFishTime > jM1685c) {
            NotifyLogger.m29913d(TAG, "out of HoursAfterOOBE.");
            return false;
        }
        String startTime = restoreNotifyConfig.getStartTime();
        String endTime = restoreNotifyConfig.getEndTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        boolean z10 = oOBEFishTime < ((long) C0241z.m1685c(restoreNotifyConfig.getFirstTrigAfter())) * 60000;
        if (getCurrentState(context).equals("login") && z10) {
            NotifyLogger.m29913d(TAG, "not reach first trig time");
            return false;
        }
        try {
            Date date = simpleDateFormat.parse(getCurrentDate() + " " + startTime);
            Date date2 = simpleDateFormat.parse(getCurrentDate() + " " + endTime);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("dateStart: ");
            sb2.append(date.toLocaleString());
            NotifyLogger.m29913d(TAG, sb2.toString());
            NotifyLogger.m29913d(TAG, "dateEnd: " + date2.toLocaleString());
            Date date3 = new Date();
            NotifyLogger.m29913d(TAG, "nowTime: " + date3.toLocaleString());
            if (date3.after(date)) {
                if (date3.before(date2)) {
                    return true;
                }
            }
        } catch (ParseException e10) {
            NotifyLogger.m29914e(TAG, "ParseException: " + e10.toString());
        }
        return false;
    }

    public boolean checkReleasedDevices(String str) {
        String strM1168F = C0209d.m1168F();
        NotifyLogger.m29913d(TAG, "getDeviceMode: " + strM1168F);
        List<String> releasedDevices = getReleasedDevices(str);
        if (releasedDevices != null && releasedDevices.size() != 0) {
            NotifyLogger.m29913d(TAG, "devices: " + releasedDevices.toString());
            for (String str2 : releasedDevices) {
                NotifyLogger.m29913d(TAG, "device: " + str2);
                if (str2.length() == 1 && str2.equals("*")) {
                    return true;
                }
                if (str2.length() != 1 && strM1168F.startsWith(str2.substring(0, str2.length() - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
    }

    public String getCurrentState(Context context) {
        return isOOBELogin(context) ? "login" : "logout";
    }

    public boolean getHaveRestored(Context context) {
        return C0212e0.m1354d(context, RESTORE_NOTIFY_SP, RESTORE_HAVE_RECOVERED, false);
    }

    public boolean getIsWaiting(Context context) {
        return C0212e0.m1354d(context, RESTORE_NOTIFY_SP, WAITING_OOBE_NOTIFY, false);
    }

    public long getLastNotifyTime(Context context) {
        return C0212e0.m1359i(context, RESTORE_NOTIFY_SP, RESTORE_NOTIFY_TIME, 0L);
    }

    public RestoreNotifyContent getNoticeContent(String str) {
        RestoreNotifyLanguageOperator restoreNotifyLanguageOperator = new RestoreNotifyLanguageOperator();
        String strM1631i = C0234s.m1631i();
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        NotifyLogger.m29914e(TAG, "contryLanguage" + strM1631i);
        NotifyLogger.m29914e(TAG, FaqConstants.FAQ_EMUI_LANGUAGE + currentBaseLanguage);
        if (TextUtils.isEmpty(strM1631i)) {
            NotifyLogger.m29914e(TAG, "getNoticeContent language null");
            return null;
        }
        RestoreNotifyContent restoreNotifyContent = restoreNotifyLanguageOperator.getRestoreNotifyContent(str, strM1631i);
        if (restoreNotifyContent != null) {
            return restoreNotifyContent;
        }
        NotifyLogger.m29915i(TAG, "cannot find content by language-country=" + strM1631i);
        return restoreNotifyLanguageOperator.getRestoreNotifyContentByLanguage(str, currentBaseLanguage);
    }

    public int getNotifiedCount(Context context) {
        return C0212e0.m1357g(context, RESTORE_NOTIFY_SP, RESTORE_NOTIFIED_COUNT, 0);
    }

    public long getOOBEFishTime(Context context) {
        return C0212e0.m1359i(context, RESTORE_NOTIFY_SP, OOBE_FISH_TIME, 0L);
    }

    public boolean getOOBENotified(Context context) {
        return C0212e0.m1354d(context, RESTORE_NOTIFY_SP, RESTORE_OOBE_NOTIFIED, false);
    }

    public boolean getOpenCloudNotified(Context context) {
        return C0212e0.m1354d(context, RESTORE_NOTIFY_SP, RESTORE_START_CLOUD_NOTIFIED, false);
    }

    public List<String> getReleasedDevices(String str) {
        List<RestoreNotifyConfig> restoreNotifyConfig;
        RestoreNotifydDevicesOperator restoreNotifydDevicesOperator = new RestoreNotifydDevicesOperator();
        List<String> releaseDevices = restoreNotifydDevicesOperator.getReleaseDevices(str);
        if (releaseDevices == null || releaseDevices.size() == 0) {
            NotificationConfig configFromFile = new HNCloudConfig().getConfigFromFile();
            if (configFromFile != null) {
                restoreNotifyConfig = configFromFile.getHiCloudPullNewNotice().getRestoreNotifyConfig();
            } else {
                NotifyLogger.m29914e(TAG, "fullConfig is null");
                restoreNotifyConfig = null;
            }
            if (restoreNotifyConfig == null) {
                NotifyLogger.m29914e(TAG, "restoreNotifyConfigs is null");
            }
            RestoreNotifyOperator restoreNotifyOperator = new RestoreNotifyOperator();
            RestoreNotifydDevicesOperator restoreNotifydDevicesOperator2 = new RestoreNotifydDevicesOperator();
            if (restoreNotifyConfig != null) {
                for (RestoreNotifyConfig restoreNotifyConfig2 : restoreNotifyConfig) {
                    restoreNotifyConfig2.setStartTime(restoreNotifyConfig2.getvalidDuration().getStartTime());
                    restoreNotifyConfig2.setEndTime(restoreNotifyConfig2.getvalidDuration().getEndTime());
                    new RestoreNotifyConfigManager().parseRestoreNotifyConfig(restoreNotifyConfig2);
                    restoreNotifydDevicesOperator2.batchInsert(restoreNotifyConfig2);
                }
                restoreNotifyOperator.batchInsert(restoreNotifyConfig);
            }
        }
        return restoreNotifydDevicesOperator.getReleaseDevices(str);
    }

    public RestoreNotifyConfig getRestoreNotifyConfig(String str) {
        return new RestoreNotifyOperator().getRestoreNotifyConfig(str);
    }

    public boolean hasNoteLocalData(Context context) {
        Uri uri = Uri.parse("content://" + C13843a.m83052D() + "/is_need_sync");
        boolean z10 = false;
        if (!C0209d.m1227Y1(context, uri)) {
            NotifyLogger.m29914e(TAG, "hasNoteLocalData, TargetApp is not SystemApp");
            return false;
        }
        Cursor cursorM1286n2 = C0209d.m1286n2(context, uri, null, null, null, null);
        if (cursorM1286n2 != null) {
            try {
                try {
                    if (cursorM1286n2.getCount() == 1 && cursorM1286n2.moveToFirst()) {
                        if (cursorM1286n2.getInt(cursorM1286n2.getColumnIndex("count")) > 8) {
                            z10 = true;
                        }
                    }
                } catch (SQLException e10) {
                    NotifyLogger.m29914e(TAG, "hasNoteLocalData error: " + e10.toString());
                }
            } finally {
                cursorM1286n2.close();
            }
        }
        return z10;
    }

    public boolean isOOBELogin(Context context) {
        return C0212e0.m1354d(context, RESTORE_NOTIFY_SP, RESTORE_NOTIFY_STATE, false);
    }

    public void saveHaveRestored(Context context, boolean z10) {
        C0212e0.m1365o(context, RESTORE_NOTIFY_SP, RESTORE_HAVE_RECOVERED, z10);
    }

    public void saveIsWaiting(Context context, boolean z10) {
        C0212e0.m1365o(context, RESTORE_NOTIFY_SP, WAITING_OOBE_NOTIFY, z10);
    }

    public void saveNotifiedCount(Context context, int i10) {
        C0212e0.m1368r(context, RESTORE_NOTIFY_SP, RESTORE_NOTIFIED_COUNT, i10);
    }

    public void saveNotifyTime(Context context) {
        C0212e0.m1370t(context, RESTORE_NOTIFY_SP, RESTORE_NOTIFY_TIME, System.currentTimeMillis());
    }

    public void saveOOBEFinishTime(Context context, long j10) {
        C0212e0.m1370t(context, RESTORE_NOTIFY_SP, OOBE_FISH_TIME, j10);
    }

    public void saveOOBENotified(Context context, boolean z10) {
        C0212e0.m1365o(context, RESTORE_NOTIFY_SP, RESTORE_OOBE_NOTIFIED, z10);
    }

    public void saveOOBEState(Context context) {
        C0212e0.m1365o(context, RESTORE_NOTIFY_SP, RESTORE_NOTIFY_STATE, true);
    }

    public void saveOpenCloudNotified(Context context, boolean z10) {
        C0212e0.m1365o(context, RESTORE_NOTIFY_SP, RESTORE_START_CLOUD_NOTIFIED, z10);
    }
}
