package com.huawei.hicloud.notification;

import android.content.Context;
import android.database.SQLException;
import com.google.gson.JsonObject;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NotifyAgdParameters;
import com.huawei.hicloud.notification.bean.NotifyUserCapacity;
import com.huawei.hicloud.notification.checker.LevelFrequencyController;
import com.huawei.hicloud.notification.config.FullFrequency;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.NotificationReportManager;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SNTimes;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.operator.SNTimeOperator;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p292fn.C9733f;
import p459lp.C11327e;
import p709vj.C13452e;
import p783xp.C13843a;

/* loaded from: classes6.dex */
public class CloudSpaceNotifyHelper {
    public static final long DEFAULT_RECOMMEND_PACKAGE_SIZE = -1;
    public static final long ONE_MINUTE = 60000;
    private static final String TAG = "CloudSpaceNotifyHelper";
    private static IPayNotifyProxy iNotifyProxy;

    private static void addParams(long j10, MsgUserData msgUserData) {
        NotifyLogger.m29915i(TAG, "addParams");
        JsonObject jsonObject = new JsonObject();
        Context contextM1377a = C0213f.m1377a();
        jsonObject.addProperty("totalSpace", C13843a.m83086h(contextM1377a, msgUserData.getCurrentPackageSpace()));
        jsonObject.addProperty("usedSpace", C13843a.m83086h(contextM1377a, j10));
        jsonObject.addProperty("packageEndTime", C0223k.m1519b(contextM1377a, msgUserData.getPackageEndTime(), C13452e.m80781L().m80901d0()));
        long jCurrentTimeMillis = (System.currentTimeMillis() - msgUserData.getPackageEndTime()) / 86400000;
        if (jCurrentTimeMillis >= 0) {
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = 1;
            }
            jsonObject.addProperty("expiredDays", Long.valueOf(jCurrentTimeMillis));
        }
        msgUserData.setParams(jsonObject);
    }

    private static boolean isOneDay(long j10, long j11) {
        Date date = new Date(j10);
        Date date2 = new Date(j11);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static boolean isTooFrequent(FullFrequency fullFrequency, SNTimeOperator sNTimeOperator, SNTimes sNTimes) {
        int everyday = fullFrequency.getEveryday();
        int everyweek = fullFrequency.getEveryweek();
        int everymonth = fullFrequency.getEverymonth();
        if (everyday == 0) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "config everyDayMax=" + everyday + ", everyWeekMax=" + everyweek + ", everyMonthMax=" + everymonth);
        if (everyday <= 0) {
            return false;
        }
        int iQueryCountByDay = sNTimeOperator.queryCountByDay(String.valueOf(sNTimes.getDay()), String.valueOf(sNTimes.getMonth()), String.valueOf(sNTimes.getYear()));
        NotifyLogger.m29915i(TAG, "queryCountByDay = " + iQueryCountByDay);
        if (iQueryCountByDay >= everyday) {
            return true;
        }
        if (everyweek > 0) {
            int iQueryCountByWeek = sNTimeOperator.queryCountByWeek(String.valueOf(sNTimes.getWeek()), String.valueOf(sNTimes.getYear()));
            NotifyLogger.m29915i(TAG, "queryCountByWeek = " + iQueryCountByWeek);
            if (iQueryCountByWeek >= everyweek) {
                return true;
            }
        }
        if (everymonth <= 0) {
            return false;
        }
        int iQueryCountByMonth = sNTimeOperator.queryCountByMonth(String.valueOf(sNTimes.getMonth()), String.valueOf(sNTimes.getYear()));
        NotifyLogger.m29915i(TAG, "queryCountByMonth = " + iQueryCountByMonth);
        return iQueryCountByMonth >= everymonth;
    }

    public static boolean notifyActivityAvailableRatio(HiCloudNotificationManager hiCloudNotificationManager, NotificationWithActivity notificationWithActivity, SNTimes sNTimes, SNTimeOperator sNTimeOperator, float f10, long j10, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters) throws JSONException, SQLException {
        String lessThan = notificationWithActivity.getRange().getLessThan();
        String morethan = notificationWithActivity.getRange().getMorethan();
        NotifyLogger.m29915i(TAG, "notifyActivityAvailableRatio lessThan=" + lessThan + ",moreThan=" + morethan + ",percentage=" + f10);
        NotificationReportManager.getInstance().addActivitySpaceCheckInfo(morethan, lessThan, String.valueOf(f10), notificationWithActivity.getActivityType(), "0002");
        try {
            if (Float.valueOf(lessThan).floatValue() < 0.0f) {
                if (f10 < Float.valueOf(morethan).floatValue()) {
                    return false;
                }
                hiCloudNotificationManager.sendSpaceNotifyWithActivity(notificationWithActivity, Long.valueOf(j10), str, str2, z10, notifyAgdParameters);
                sNTimeOperator.replace(sNTimes);
                return true;
            }
            if (f10 > Float.valueOf(lessThan).floatValue() || f10 < Float.valueOf(morethan).floatValue()) {
                return false;
            }
            hiCloudNotificationManager.sendSpaceNotifyWithActivity(notificationWithActivity, Long.valueOf(j10), str, str2, z10, notifyAgdParameters);
            sNTimeOperator.replace(sNTimes);
            return true;
        } catch (NumberFormatException e10) {
            NotifyLogger.m29914e(TAG, "notifyActivityAvailableRatio " + e10.toString());
            return false;
        }
    }

    public static boolean notifyActivitySpaceUsedSize(HiCloudNotificationManager hiCloudNotificationManager, NotificationWithActivity notificationWithActivity, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, long j11, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters) throws JSONException, SQLException {
        String lessThan = notificationWithActivity.getRange().getLessThan();
        String morethan = notificationWithActivity.getRange().getMorethan();
        NotifyLogger.m29915i(TAG, "notifyActivitySpaceUsedSize lessThan=" + lessThan + ",moreThan=" + morethan + ",used=" + j10);
        NotificationReportManager.getInstance().addActivitySpaceCheckInfo(morethan, lessThan, String.valueOf(j10), notificationWithActivity.getActivityType(), "0004");
        if (C0241z.m1688f(lessThan) == -1) {
            if (j10 < C0241z.m1688f(morethan)) {
                return false;
            }
            hiCloudNotificationManager.sendSpaceNotifyWithActivity(notificationWithActivity, Long.valueOf(j11), str, str2, z10, notifyAgdParameters);
            sNTimeOperator.replace(sNTimes);
            return true;
        }
        if (j10 > C0241z.m1688f(lessThan) || j10 < C0241z.m1688f(morethan)) {
            return false;
        }
        hiCloudNotificationManager.sendSpaceNotifyWithActivity(notificationWithActivity, Long.valueOf(j11), str, str2, z10, notifyAgdParameters);
        sNTimeOperator.replace(sNTimes);
        return true;
    }

    public static boolean notifyAvailableDaysV2(HiCloudNotificationManager hiCloudNotificationManager, SpaceNotification spaceNotification, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, long j11, long j12) throws JSONException {
        String lessThan = spaceNotification.getRange().getLessThan();
        String morethan = spaceNotification.getRange().getMorethan();
        NotifyLogger.m29915i(TAG, "notifyAvailableDaysV2 lessThan=" + lessThan + ",moreThan=" + morethan + ",endtime=" + j10);
        NotificationReportManager.getInstance().addSpaceCheckInfo(morethan, lessThan, String.valueOf(j10), "0006");
        long j13 = spaceNotification.getTopupPackage() == 1 ? j11 : j10;
        if (j13 == 0) {
            NotifyLogger.m29914e(TAG, "end time is 0");
            return false;
        }
        long jCurrentTimeMillis = j13 - System.currentTimeMillis();
        NotifyLogger.m29915i(TAG, "timeLeft = " + jCurrentTimeMillis + "  lessThan = " + lessThan + "  moreThan = " + morethan);
        if (C0241z.m1688f(lessThan) == -1) {
            if (jCurrentTimeMillis >= C0241z.m1685c(morethan) * 86400000) {
                return startAvailableDaysV2Task(hiCloudNotificationManager, spaceNotification, sNTimes, sNTimeOperator, jCurrentTimeMillis, j13, j12);
            }
        } else if (C0241z.m1688f(morethan) == -1) {
            if (jCurrentTimeMillis <= C0241z.m1685c(lessThan) * 86400000) {
                return startAvailableDaysV2Task(hiCloudNotificationManager, spaceNotification, sNTimes, sNTimeOperator, jCurrentTimeMillis, j13, j12);
            }
        } else if (jCurrentTimeMillis <= C0241z.m1685c(lessThan) * 86400000 && jCurrentTimeMillis >= C0241z.m1685c(morethan) * 86400000) {
            return startAvailableDaysV2Task(hiCloudNotificationManager, spaceNotification, sNTimes, sNTimeOperator, jCurrentTimeMillis, j13, j12);
        }
        return false;
    }

    public static boolean notifyAvailableRatio(HiCloudNotificationManager hiCloudNotificationManager, SpaceNotification spaceNotification, SNTimes sNTimes, SNTimeOperator sNTimeOperator, float f10, long j10) throws JSONException {
        String lessThan = spaceNotification.getRange().getLessThan();
        String morethan = spaceNotification.getRange().getMorethan();
        NotifyLogger.m29915i(TAG, "notifyAvailableRatio lessThan=" + lessThan + ",moreThan=" + morethan + ",percentage=" + f10);
        NotificationReportManager.getInstance().addSpaceCheckInfo(morethan, lessThan, String.valueOf(f10), "0002");
        try {
            if (Float.valueOf(lessThan).floatValue() < 0.0f) {
                if (f10 >= Float.valueOf(morethan).floatValue()) {
                    return sendSpaceNotify(hiCloudNotificationManager, spaceNotification, j10, sNTimes, sNTimeOperator, NotifyConstants.SPACE_AVAILABLE_RATIO);
                }
                return false;
            }
            if (f10 > Float.valueOf(lessThan).floatValue() || f10 < Float.valueOf(morethan).floatValue()) {
                return false;
            }
            return sendSpaceNotify(hiCloudNotificationManager, spaceNotification, j10, sNTimes, sNTimeOperator, NotifyConstants.SPACE_AVAILABLE_RATIO);
        } catch (NumberFormatException e10) {
            NotifyLogger.m29914e(TAG, "notifyAvailableRatio " + e10.toString());
            return false;
        }
    }

    public static boolean notifyAvailableSize(HiCloudNotificationManager hiCloudNotificationManager, SpaceNotification spaceNotification, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, long j11) throws JSONException {
        String lessThan = spaceNotification.getRange().getLessThan();
        String morethan = spaceNotification.getRange().getMorethan();
        NotifyLogger.m29915i(TAG, "notifyAvailableSize lessThan=" + lessThan + ",moreThan=" + morethan + ",available=" + j10);
        NotificationReportManager.getInstance().addSpaceCheckInfo(morethan, lessThan, String.valueOf(j10), "0003");
        if (C0241z.m1688f(lessThan) == -1) {
            if (j10 >= C0241z.m1688f(morethan)) {
                return sendSpaceNotify(hiCloudNotificationManager, spaceNotification, j11, sNTimes, sNTimeOperator, NotifyConstants.SPACE_AVAILABLE_SIZE);
            }
            return false;
        }
        if (j10 > C0241z.m1688f(lessThan) || j10 < C0241z.m1688f(morethan)) {
            return false;
        }
        return sendSpaceNotify(hiCloudNotificationManager, spaceNotification, j11, sNTimes, sNTimeOperator, NotifyConstants.SPACE_AVAILABLE_SIZE);
    }

    public static boolean notifySpaceUsedSize(HiCloudNotificationManager hiCloudNotificationManager, SpaceNotification spaceNotification, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, long j11) throws JSONException {
        String lessThan = spaceNotification.getRange().getLessThan();
        String morethan = spaceNotification.getRange().getMorethan();
        NotifyLogger.m29915i(TAG, "notifySpaceUsedSize lessThan=" + lessThan + ",moreThan=" + morethan + ",used=" + j10);
        NotificationReportManager.getInstance().addSpaceCheckInfo(morethan, lessThan, String.valueOf(j10), "0004");
        if (C0241z.m1688f(lessThan) == -1) {
            if (j10 >= C0241z.m1688f(morethan)) {
                return sendSpaceNotify(hiCloudNotificationManager, spaceNotification, j11, sNTimes, sNTimeOperator, NotifyConstants.SPACE_USED_SIZE);
            }
            return false;
        }
        if (j10 > C0241z.m1688f(lessThan) || j10 < C0241z.m1688f(morethan)) {
            return false;
        }
        return sendSpaceNotify(hiCloudNotificationManager, spaceNotification, j11, sNTimes, sNTimeOperator, NotifyConstants.SPACE_USED_SIZE);
    }

    public static boolean notifyWithActivityAvailableSize(HiCloudNotificationManager hiCloudNotificationManager, NotificationWithActivity notificationWithActivity, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, long j11, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters) throws JSONException, SQLException {
        String lessThan = notificationWithActivity.getRange().getLessThan();
        String morethan = notificationWithActivity.getRange().getMorethan();
        NotifyLogger.m29915i(TAG, "notifyWithActivityAvailableSize lessThan=" + lessThan + ",moreThan=" + morethan + ",available=" + j10);
        NotificationReportManager.getInstance().addActivitySpaceCheckInfo(morethan, lessThan, String.valueOf(j10), notificationWithActivity.getActivityType(), "0003");
        if (C0241z.m1688f(lessThan) == -1) {
            if (j10 < C0241z.m1688f(morethan)) {
                return false;
            }
            hiCloudNotificationManager.sendSpaceNotifyWithActivity(notificationWithActivity, Long.valueOf(j11), str, str2, z10, notifyAgdParameters);
            sNTimeOperator.replace(sNTimes);
            return true;
        }
        if (j10 > C0241z.m1688f(lessThan) || j10 < C0241z.m1688f(morethan)) {
            return false;
        }
        hiCloudNotificationManager.sendSpaceNotifyWithActivity(notificationWithActivity, Long.valueOf(j11), str, str2, z10, notifyAgdParameters);
        sNTimeOperator.replace(sNTimes);
        return true;
    }

    public static boolean sendSpaceNotify(HiCloudNotificationManager hiCloudNotificationManager, SpaceNotification spaceNotification, long j10, SNTimes sNTimes, SNTimeOperator sNTimeOperator, String str) throws SQLException {
        if (MessageCenterManager.getInstance().featureSwitch()) {
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            long spaceReminderFailInterval = hiCloudSysParamMapM60757p.getSpaceReminderFailInterval();
            int spaceReminderFailTimes = hiCloudSysParamMapM60757p.getSpaceReminderFailTimes();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long spaceReminderFailTime = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTime();
            int spaceReminderFailTimes2 = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTimes();
            NotifyLogger.m29915i(TAG, "sendSpaceNotify configFailInterval = " + spaceReminderFailInterval + ", configFailTimes = " + spaceReminderFailTimes + ", curTime = " + jCurrentTimeMillis + ", spaceReminderFailTime = " + spaceReminderFailTime + ", spaceReminderFailTimes = " + spaceReminderFailTimes2);
            if (spaceReminderFailInterval != -1 && spaceReminderFailTimes != -1 && spaceReminderFailTime != -1) {
                if (!isOneDay(spaceReminderFailTime, jCurrentTimeMillis)) {
                    NotifyLogger.m29915i(TAG, "sendSpaceNotify spaceReminderFailTime and curTime is not one day.");
                    SpaceNoticeCommonSpUtil.getInstance().clearSpaceRemiderFailSP();
                    spaceReminderFailTime = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTime();
                } else if (jCurrentTimeMillis - spaceReminderFailTime >= spaceReminderFailInterval * 60000) {
                    SpaceNoticeCommonSpUtil.getInstance().clearSpaceRemiderFailSP();
                    spaceReminderFailTime = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTime();
                } else if (spaceReminderFailTimes2 >= spaceReminderFailTimes) {
                    NotifyLogger.m29914e(TAG, "sendSpaceNotify sendSpaceNotify spaceReminderFailTimes > configFailTimes in timeInterval.");
                    return false;
                }
            }
            if (!MessageCenterManager.getInstance().invokeEvent(spaceNotification, C11327e.m68061d("HiCloudSpaceNoticeConfigV3"), "HiCloudSpaceNoticeConfigV3", hiCloudNotificationManager.buildUserData(spaceNotification, Long.valueOf(j10)))) {
                NotifyLogger.m29916w(TAG, "sendSpaceNotify invokeEvent fail, notice type: " + str);
                if (spaceReminderFailInterval == -1 || spaceReminderFailTimes == -1) {
                    return false;
                }
                if (spaceReminderFailTime == -1) {
                    SpaceNoticeCommonSpUtil.getInstance().setSpaceReminderFailTime(jCurrentTimeMillis);
                }
                SpaceNoticeCommonSpUtil.getInstance().setSpaceReminderFailTimes();
                return false;
            }
            SpaceNoticeCommonSpUtil.getInstance().clearSpaceRemiderFailSP();
        } else {
            if (!LevelFrequencyController.getInstance().check(new Object[]{"notification_bar", spaceNotification.getRemindPurposes(), str})) {
                NotifyLogger.m29916w(TAG, "sendSpaceNotify level freq control check fail, notice type: " + str);
                return false;
            }
            hiCloudNotificationManager.sendSpaceNotify(spaceNotification, Long.valueOf(j10));
        }
        sNTimeOperator.replace(sNTimes);
        return true;
    }

    public static void setNotifyProxy(IPayNotifyProxy iPayNotifyProxy) {
        iNotifyProxy = iPayNotifyProxy;
    }

    public static boolean startAvailableDaysV2Task(HiCloudNotificationManager hiCloudNotificationManager, SpaceNotification spaceNotification, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, long j11, long j12) throws SQLException {
        NotifyLogger.m29915i(TAG, "startAvailableDaysV2Task");
        if (iNotifyProxy == null) {
            return false;
        }
        int topupPackage = spaceNotification.getTopupPackage();
        NotifyUserCapacity cloudSpace = iNotifyProxy.getCloudSpace(j10, topupPackage);
        if (cloudSpace == null) {
            NotifyLogger.m29915i(TAG, "notifyUserCapacity is null");
            return false;
        }
        int errorCode = cloudSpace.getErrorCode();
        long capacity = cloudSpace.getCapacity();
        NotifyLogger.m29915i(TAG, "errorCode: " + errorCode + " capacity: " + capacity + " toPupPackage: " + topupPackage);
        if (topupPackage == 1) {
            if (errorCode != -2) {
                NotifyLogger.m29915i(TAG, "autoPay condition false");
                return false;
            }
        } else if (errorCode == -1 || errorCode == -2) {
            return false;
        }
        iNotifyProxy.refreshTimeZone();
        if (MessageCenterManager.getInstance().featureSwitch()) {
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            long spaceReminderFailInterval = hiCloudSysParamMapM60757p.getSpaceReminderFailInterval();
            int spaceReminderFailTimes = hiCloudSysParamMapM60757p.getSpaceReminderFailTimes();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long spaceReminderFailTime = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTime();
            int spaceReminderFailTimes2 = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTimes();
            NotifyLogger.m29915i(TAG, "startAvailableDaysV2Task configFailInterval = " + spaceReminderFailInterval + ", configFailTimes = " + spaceReminderFailTimes + ", curTime = " + jCurrentTimeMillis + ", spaceReminderFailTime = " + spaceReminderFailTime + ", spaceReminderFailTimes = " + spaceReminderFailTimes2);
            if (spaceReminderFailInterval != -1 && spaceReminderFailTimes != -1 && spaceReminderFailTime != -1) {
                if (!isOneDay(spaceReminderFailTime, jCurrentTimeMillis)) {
                    NotifyLogger.m29915i(TAG, "startAvailableDaysV2Task spaceReminderFailTime and curTime is not one day.");
                    SpaceNoticeCommonSpUtil.getInstance().clearSpaceRemiderFailSP();
                    spaceReminderFailTime = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTime();
                } else if (jCurrentTimeMillis - spaceReminderFailTime >= spaceReminderFailInterval * 60000) {
                    SpaceNoticeCommonSpUtil.getInstance().clearSpaceRemiderFailSP();
                    spaceReminderFailTime = SpaceNoticeCommonSpUtil.getInstance().getSpaceReminderFailTime();
                } else if (spaceReminderFailTimes2 >= spaceReminderFailTimes) {
                    NotifyLogger.m29914e(TAG, "startAvailableDaysV2Task spaceReminderFailTimes > configFailTimes in timeInterval.");
                    return false;
                }
            }
            String strM68061d = C11327e.m68061d("HiCloudMsgNoticeConfig");
            MsgUserData msgUserDataBuildUserData = hiCloudNotificationManager.buildUserData(spaceNotification, -1L, Long.valueOf(capacity), j11);
            addParams(j12, msgUserDataBuildUserData);
            if (!MessageCenterManager.getInstance().invokeEvent(spaceNotification, strM68061d, "HiCloudMsgNoticeConfig", msgUserDataBuildUserData)) {
                NotifyLogger.m29916w(TAG, "startAvailableDaysV2Task invokeEvent fail, notice type: space_available_days_v3");
                if (spaceReminderFailInterval != -1 && spaceReminderFailTimes != -1) {
                    if (spaceReminderFailTime == -1) {
                        SpaceNoticeCommonSpUtil.getInstance().setSpaceReminderFailTime(jCurrentTimeMillis);
                    }
                    SpaceNoticeCommonSpUtil.getInstance().setSpaceReminderFailTimes();
                }
                return false;
            }
            SpaceNoticeCommonSpUtil.getInstance().clearSpaceRemiderFailSP();
        } else {
            if (!LevelFrequencyController.getInstance().check(new Object[]{"notification_bar", spaceNotification.getRemindPurposes(), NotifyConstants.SPACE_AVAILABLE_DAYS_V3})) {
                NotifyLogger.m29916w(TAG, "startAvailableDaysV2Task freq control check fail, notice type: space_available_days_v3");
                return false;
            }
            hiCloudNotificationManager.sendSpaceNotify(spaceNotification, -1L, capacity, j11);
        }
        sNTimeOperator.replace(sNTimes);
        return true;
    }
}
