package com.huawei.hicloud.notification;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.bean.NotifyAgdParameters;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.bean.NotifyTimeBean;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.bean.VoucherNotiDisplayInfo;
import com.huawei.hicloud.notification.checker.LevelFrequencyController;
import com.huawei.hicloud.notification.config.FullFrequency;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.ExtraNoticeConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationReportManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeContentRoot;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SNTimes;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import com.huawei.hicloud.notification.p106db.operator.SNTimeOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyFrequencyOperator;
import com.huawei.hicloud.notification.util.AbstractCheckAppStatus;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import fk.C9721b;
import gp.C10028c;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0236u;
import p015ak.C0241z;
import p292fn.C9733f;
import p709vj.C13452e;
import p742wj.C13612b;
import p846zj.C14306d;

/* loaded from: classes6.dex */
public class CloudSpaceNotifyUtil {
    public static final String CHECK_CLOUD_PHOTO_FAIL_NOTIFY_SP = "check_cloudphoto_fail_notify_sp";
    public static final String CHECK_CLOUD_PHOTO_FAIL_NOTIFY_TIME = "check_cloudphoto_fail_notify_time";
    public static final String CHECK_CLOUD_PHOTO_FAIL_NOTIFY_TIME_LIST = "check_cloudphoto_fail_notify_time_list";
    private static final String DEFAULT_DAY = "-1";
    private static final String LAST_DAY = "0";
    private static final long MICRO_SEC_PERDAY = 86400000;
    private static final long PACKAGE_5GB = 5368709120L;
    private static final String REPLACE_LAST_DAY = "1";
    public static final int SPACE_CHECK_FAIL_GET_SPACE_ERROR = 1;
    public static final int SPACE_CHECK_FAIL_MAX_SPACE_ERROR = 2;
    public static final int SPACE_CHECK_SUCCESS = 0;
    private static final String TAG = "CloudSpaceNotifyUtil";
    private ICloudBackupNotifyProxy backupNotifyProxy;
    private long endTime2;
    private long endtime;
    private FrequencyManager frequencyChecker = new FrequencyManager();
    private Context mContext;
    private long mOldMaxPackageSize;
    private long maxPackageSize;
    private HiCloudNotificationManager notifyManager;
    private ICloudSpaceProxy spaceProxy;
    private long total;
    private long used;
    public static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("%\\{([^}]*)\\}%");
    public static final Pattern DEEP_LINK_PATTERN = Pattern.compile("__(.*?)__");
    private static final CloudSpaceNotifyUtil INSTANCE = new CloudSpaceNotifyUtil();

    public static class ExtraNotificationBeanComparator implements Comparator<ExtraNotificationBean>, Serializable {
        private static final long serialVersionUID = 2902329127356911540L;

        @Override // java.util.Comparator
        public int compare(ExtraNotificationBean extraNotificationBean, ExtraNotificationBean extraNotificationBean2) {
            return extraNotificationBean.getPriority() - extraNotificationBean2.getPriority();
        }
    }

    public static class NotificationComparator implements Comparator<SpaceNotification>, Serializable {
        private static final long serialVersionUID = 2902329127356911540L;

        @Override // java.util.Comparator
        public int compare(SpaceNotification spaceNotification, SpaceNotification spaceNotification2) {
            return spaceNotification.getPriority() - spaceNotification2.getPriority();
        }
    }

    public static class NotificationWithActivityComparator implements Comparator<NotificationWithActivity>, Serializable {
        private static final long serialVersionUID = 2902329127356911540L;

        @Override // java.util.Comparator
        public int compare(NotificationWithActivity notificationWithActivity, NotificationWithActivity notificationWithActivity2) {
            return notificationWithActivity.getPriority() - notificationWithActivity2.getPriority();
        }
    }

    public static class SpaceNotificationComparator implements Comparator<SpaceNotification>, Serializable {
        private static final long serialVersionUID = 2902329127356911540L;

        @Override // java.util.Comparator
        public int compare(SpaceNotification spaceNotification, SpaceNotification spaceNotification2) {
            return spaceNotification.getPriority() - spaceNotification2.getPriority();
        }
    }

    private CloudSpaceNotifyUtil() {
    }

    public static boolean checkAlbumNotifyFrequency(Context context, float f10, int i10) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(context, CHECK_CLOUD_PHOTO_FAIL_NOTIFY_SP);
        long j10 = sharedPreferencesM1362l.getLong(CHECK_CLOUD_PHOTO_FAIL_NOTIFY_TIME, 0L);
        String string = sharedPreferencesM1362l.getString(CHECK_CLOUD_PHOTO_FAIL_NOTIFY_TIME_LIST, "");
        NotifyLogger.m29913d(TAG, "checkNotifyFrequency str:" + string);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(string)) {
            try {
                List<Long> notifyTimes = ((NotifyTimeBean) new Gson().fromJson(string, NotifyTimeBean.class)).getNotifyTimes();
                if (j10 > 0) {
                    notifyTimes.add(Long.valueOf(j10));
                }
                NotifyLogger.m29913d(TAG, "checkNotifyFrequency size:" + notifyTimes.size());
                for (Long l10 : notifyTimes) {
                    if (l10.longValue() >= jCurrentTimeMillis - f10) {
                        arrayList.add(l10);
                    }
                }
            } catch (JsonSyntaxException e10) {
                NotifyLogger.m29916w(TAG, "checkNotifyFrequency e is: " + e10.getMessage());
            }
        }
        if (arrayList.size() >= i10) {
            NotifyLogger.m29913d(TAG, "checkNotifyFrequency result false");
            return false;
        }
        NotifyLogger.m29913d(TAG, "checkNotifyFrequency result true");
        return true;
    }

    private boolean checkBackupCycleNotifyRule(Context context) {
        if (C0209d.m1173G1(context)) {
            NotifyLogger.m29915i(TAG, "sendCycleNotification, isPrivacyUser, now exit Cloud!");
            return false;
        }
        if (C0209d.m1293p1()) {
            NotifyLogger.m29915i(TAG, "checkBackupCycleNotifyRule, isInkScreen");
            return false;
        }
        if (!AbstractCheckAppStatus.isAppStatusAbnormal()) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "sendCycleNotification, AppStatusAbnormal");
        return false;
    }

    private boolean checkCloudPhotoFailFreq(List<SpaceNotification> list) {
        if (list == null || list.size() <= 0) {
            NotifyLogger.m29914e(TAG, "checkCloudPhotoFailFreq notifications is null or size is 0");
            return false;
        }
        for (SpaceNotification spaceNotification : list) {
            String noticeType = spaceNotification.getNoticeType();
            String strValueOf = String.valueOf(spaceNotification.getId());
            float frequency = spaceNotification.getFrequency();
            if (NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT.equals(noticeType)) {
                return checkSpaceNotifyRuleFrequency(noticeType, strValueOf, frequency, spaceNotification.getFrequencyTimes());
            }
        }
        return false;
    }

    private boolean checkSpaceUseNotifyRule() {
        Context context = this.mContext;
        if (context != null && C0209d.m1173G1(context)) {
            NotifyLogger.m29915i(TAG, "sendSpaceUsedNotify, checkSpaceUseNotifyRule, is privacy user");
            return false;
        }
        if (AbstractCheckAppStatus.isAppStatusAbnormal()) {
            NotifyLogger.m29915i(TAG, "sendSpaceUsedNotify, AppStatusAbnormal");
            return false;
        }
        if (isSpaceUseShowRecently()) {
            NotifyLogger.m29915i(TAG, "sendSpaceUsedNotify, space used notice has shown today");
            return false;
        }
        if (!C10028c.m62182c0().m62395t1("funcfg_manage_storage")) {
            NotifyLogger.m29915i(TAG, "sendSpaceUsedNotify stoarge module disable");
            return false;
        }
        if (isFirstDayInMonth()) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "today is not the first day of month");
        return false;
    }

    public static boolean checkUserTag(List<PortraitAndGrade.UserTag> list, NotificationWithActivity notificationWithActivity) {
        return doCheckUserTag(list, C0236u.m1651b(), notificationWithActivity.getUserGroupExtIDs(), notificationWithActivity.getNoticeType(), notificationWithActivity.getPercentage());
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkValid(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "checkValid, key = "
            r4.append(r0)
            r4.append(r5)
            java.lang.String r0 = ", value = "
            r4.append(r0)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "CloudSpaceNotifyUtil"
            com.huawei.hicloud.notification.log.NotifyLogger.m29913d(r0, r4)
            r4 = 0
            int r1 = r5.hashCode()     // Catch: java.lang.Exception -> L39
            r2 = -1638156949(0xffffffff9e5bb56b, float:-1.163128E-20)
            r3 = 1
            if (r1 == r2) goto L3b
            r2 = 1084396007(0x40a291e7, float:5.0803103)
            if (r1 == r2) goto L2f
            goto L45
        L2f:
            java.lang.String r1 = "bc.silencedevice.remaindays"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Exception -> L39
            if (r5 == 0) goto L45
            r5 = r4
            goto L46
        L39:
            r5 = move-exception
            goto L53
        L3b:
            java.lang.String r1 = "bc.silencedevice.count"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Exception -> L39
            if (r5 == 0) goto L45
            r5 = r3
            goto L46
        L45:
            r5 = -1
        L46:
            if (r5 == 0) goto L4b
            if (r5 == r3) goto L4b
            goto L51
        L4b:
            int r5 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> L39
            if (r5 <= 0) goto L6b
        L51:
            r4 = r3
            goto L6b
        L53:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "checkValid failed, exception: "
            r6.append(r1)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r0, r5)
        L6b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.CloudSpaceNotifyUtil.checkValid(java.lang.String, java.lang.String):boolean");
    }

    private boolean dealCloudPhotoSync(boolean z10, long j10) throws JSONException {
        NotifyLogger.m29915i(TAG, "CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT totalNeedSpace: " + j10);
        NotificationReportManager.getInstance().addSpaceCheckInfo("", "", "", "0005");
        ICloudBackupNotifyProxy iCloudBackupNotifyProxy = this.backupNotifyProxy;
        return iCloudBackupNotifyProxy != null && iCloudBackupNotifyProxy.showNotify(z10, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
    
        r15 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean dealNotifyCloudSpace(com.huawei.hicloud.notification.p106db.bean.SNTimes r28, com.huawei.hicloud.notification.p106db.operator.SNTimeOperator r29, float r30, long r31, java.util.List<com.huawei.hicloud.notification.p106db.bean.SpaceNotification> r33, int r34, long r35, boolean r37, java.lang.String r38, java.util.List<com.huawei.hicloud.notification.bean.PortraitAndGrade.UserTag> r39) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.CloudSpaceNotifyUtil.dealNotifyCloudSpace(com.huawei.hicloud.notification.db.bean.SNTimes, com.huawei.hicloud.notification.db.operator.SNTimeOperator, float, long, java.util.List, int, long, boolean, java.lang.String, java.util.List):boolean");
    }

    private boolean dealNotifyCloudSpaceForOther(SNTimes sNTimes, SNTimeOperator sNTimeOperator, float f10, long j10, long j11, String str, SpaceNotification spaceNotification) {
        if (NotifyConstants.SPACE_AVAILABLE_RATIO.equals(str)) {
            NotifyLogger.m29915i(TAG, "SPACE_AVAILABLE_RATIO");
            if (CloudSpaceNotifyHelper.notifyAvailableRatio(this.notifyManager, spaceNotification, sNTimes, sNTimeOperator, j10 / f10, getRecommendSize())) {
                NotificationReportUtil.reportCloudNoSpace("0013", "0003");
                return false;
            }
        } else if (NotifyConstants.SPACE_AVAILABLE_SIZE.equals(str)) {
            NotifyLogger.m29915i(TAG, "SPACE_AVAILABLE_SIZE");
            if (CloudSpaceNotifyHelper.notifyAvailableSize(this.notifyManager, spaceNotification, sNTimes, sNTimeOperator, j10, getRecommendSize())) {
                NotificationReportUtil.reportCloudNoSpace("0013", "0003");
                return false;
            }
        } else if (NotifyConstants.SPACE_USED_SIZE.equals(str)) {
            NotifyLogger.m29915i(TAG, "SPACE_USED_SIZE");
            if (CloudSpaceNotifyHelper.notifySpaceUsedSize(this.notifyManager, spaceNotification, sNTimes, sNTimeOperator, this.used, getRecommendSize())) {
                NotificationReportUtil.reportCloudNoSpace("0013", "0003");
                return false;
            }
        } else if (!NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT.equals(str)) {
            NotifyLogger.m29914e(TAG, "invalid notice type : " + str);
        } else if (dealCloudPhotoSync(true, j11)) {
            return false;
        }
        return true;
    }

    private boolean dealNotifyCloudSpaceResult(SpaceNotification spaceNotification, boolean z10) throws SQLException {
        if (!z10) {
            NotificationReportUtil.reportCloudNoSpace("0012", "0014");
            return false;
        }
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "dealNotifyCloudSpaceResult notification is null");
            return false;
        }
        recordSpaceNotifyRuleFrequency(spaceNotification);
        NoticeFreqControlManager.getInstance().recordLevelNoticeShow(spaceNotification.getRemindPurposes(), "notification_bar");
        return true;
    }

    private boolean dealNotifyCloudSpaceWithActivity(SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, List<NotificationWithActivity> list, int i10, List<PortraitAndGrade.UserTag> list2) {
        NotifyLogger.m29915i(TAG, "dealNotifyCloudSpaceWithActivity");
        if (i10 == 2) {
            NotifyLogger.m29916w(TAG, "dealNotifyCloudSpaceWithActivity checkSpaceResult is SPACE_CHECK_FAIL_MAX_SPACE_ERROR");
            return false;
        }
        if (list == null || list.size() <= 0) {
            NotificationReportUtil.reportCloudNoSpace("0010", "0004");
            NotifyLogger.m29916w(TAG, "dealNotifyCloudSpaceWithActivity notificationList is null");
            return false;
        }
        Map<String, List<NotificationWithActivity>> mapClassifyNotiListByNotiType = NoticeWithActivityUtil.classifyNotiListByNotiType(list);
        if (mapClassifyNotiListByNotiType.size() <= 0) {
            NotificationReportUtil.reportCloudNoSpace("0010", "0004");
            NotifyLogger.m29916w(TAG, "dealNotifyCloudSpaceWithActivity classifyList is null");
            return false;
        }
        filterRangeOfNotice(mapClassifyNotiListByNotiType, j10);
        if (mapClassifyNotiListByNotiType.size() <= 0) {
            NotifyLogger.m29916w(TAG, "fliterRangeOfNotice classifyList is null");
            NotificationReportUtil.reportCloudNoSpace("0010", "0013");
            return false;
        }
        filterUserTagNotice(mapClassifyNotiListByNotiType, list2);
        if (mapClassifyNotiListByNotiType.size() <= 0) {
            NotifyLogger.m29916w(TAG, "filterUserTagNotice classifyList is null");
            NotificationReportUtil.reportCloudNoSpace("0010", NotifyConstants.NotificationReport.RESULT_NAME_USER_TAG_CHECK_FAILED);
            return false;
        }
        if (this.notifyManager.isFamilyShareMember()) {
            NotificationReportUtil.reportCloudNoSpace("0010", "0012");
            NotifyLogger.m29914e(TAG, "newManualBackupFailNotifyWithActivity family share member not support NotificationWithActivity");
            return false;
        }
        NotificationWithActivity notificationWithActivityDoSpaceNoticeWithActivity = this.notifyManager.doSpaceNoticeWithActivity(mapClassifyNotiListByNotiType, sNTimes, sNTimeOperator, j10, list2, getRecommendSize(), list);
        NotificationReportUtil.reportSpaceNotifyCheck();
        NotificationReportManager.getInstance().reset();
        if (isShowSpaceNotificationActivitySuccess(notificationWithActivityDoSpaceNoticeWithActivity)) {
            NoticeFreqControlManager.getInstance().recordLevelNoticeShow(notificationWithActivityDoSpaceNoticeWithActivity.getRemindPurposes(), "notification_bar");
            return true;
        }
        NotificationReportUtil.reportCloudNoSpace("0010", "0014");
        return false;
    }

    private static boolean doCheckUserTag(List<PortraitAndGrade.UserTag> list, long j10, List<String> list2, String str, float f10) {
        if (list2 == null || list2.isEmpty()) {
            return f10 == -1.0f || ((float) (j10 % 100)) <= f10;
        }
        if (list != null && !list.isEmpty()) {
            for (String str2 : list2) {
                Iterator<PortraitAndGrade.UserTag> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserGroupExtID().equals(str2) && j10 % 100 <= f10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void doReport() {
        if (C10028c.m62182c0().m62253O0()) {
            NotificationReportUtil.reportLastSpaceNoticeInfo();
            NotificationBIReportUtil.reportLastCheckExceptionInfo();
        }
    }

    private void filterRangeOfNotice(Map<String, List<NotificationWithActivity>> map, long j10) {
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<String, List<NotificationWithActivity>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            List<NotificationWithActivity> list = map.get(key);
            if (list != null && list.size() > 0) {
                Iterator<NotificationWithActivity> it2 = list.iterator();
                while (it2.hasNext()) {
                    NotificationWithActivity next = it2.next();
                    if (next != null) {
                        String lessThan = next.getRange().getLessThan();
                        String morethan = next.getRange().getMorethan();
                        long j11 = this.total;
                        if (j11 != 0) {
                            processCheckRange(key, lessThan, morethan, j10 / j11, j10, it2);
                        }
                    }
                }
                if (list.size() <= 0) {
                    it.remove();
                }
            }
        }
    }

    private void filterUserTagNotice(Map<String, List<NotificationWithActivity>> map, List<PortraitAndGrade.UserTag> list) {
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<String, List<NotificationWithActivity>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            List<NotificationWithActivity> list2 = map.get(it.next().getKey());
            if (list2 != null && list2.size() > 0) {
                Iterator<NotificationWithActivity> it2 = list2.iterator();
                while (it2.hasNext()) {
                    NotificationWithActivity next = it2.next();
                    if (next == null) {
                        it2.remove();
                    } else if (!checkUserTag(list, next)) {
                        it2.remove();
                    }
                }
                if (list2.size() <= 0) {
                    it.remove();
                }
            }
        }
    }

    private CloudSpace getCloudSpace() throws JSONException {
        try {
            if (this.spaceProxy == null) {
                return null;
            }
            C14306d.m85218s();
            CloudSpace cloudSpace = this.spaceProxy.getCloudSpace();
            long total = cloudSpace.getTotal();
            if (!C13452e.m80781L().m80791C0() && total <= 0) {
                NotifyLogger.m29914e(TAG, "getCloudSpace totalSpace is 0");
                return null;
            }
            this.used = cloudSpace.getUsed();
            this.total = cloudSpace.getTotal();
            this.endtime = cloudSpace.getEndTime();
            this.endTime2 = cloudSpace.getWorryEndTime2();
            this.maxPackageSize = cloudSpace.getMaxPackageSize();
            this.mOldMaxPackageSize = cloudSpace.getOldMaxPackageSize();
            String str = "used=" + this.used + " total=" + this.total + " endtime=" + this.endtime + " maxPackageSize=" + this.maxPackageSize;
            NotifyLogger.m29915i(TAG, str + " endTime2 = " + this.endTime2 + " oldMaxPackageSize: " + this.mOldMaxPackageSize);
            NotificationReportManager.getInstance().addSpaceInfo(str);
            return cloudSpace;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "get cloud space error" + e10.getMessage());
            return null;
        } catch (NumberFormatException e11) {
            NotifyLogger.m29914e(TAG, "get cloud space parse response error" + e11.toString());
            return null;
        }
    }

    private List<ExtraNotificationBean> getFilterExtraNotificationBeans(List<ExtraNotificationBean> list) {
        ArrayList arrayList = new ArrayList();
        ExtraNotificationBean extraNotificationBean = list.get(0);
        List<String> userGroupExtIDs = extraNotificationBean.getUserGroupExtIDs();
        if (userGroupExtIDs == null || userGroupExtIDs.isEmpty()) {
            arrayList.addAll(list);
        } else {
            arrayList.add(extraNotificationBean);
        }
        return arrayList;
    }

    public static CloudSpaceNotifyUtil getInstance() {
        return INSTANCE;
    }

    private long getRecommendSize() {
        NotifyLogger.m29915i(TAG, "total = " + this.total + " used = " + this.used);
        long j10 = this.total;
        long j11 = this.used;
        return j10 >= j11 ? j10 : j11;
    }

    private SNTimes getSNTime() {
        return HNUtil.getNowTime();
    }

    private boolean isFirstDayInMonth() {
        int i10 = Calendar.getInstance().get(5);
        return i10 == 1 || i10 == 2;
    }

    private Boolean isNeedContinue(SpaceNotification spaceNotification, String str, List<PortraitAndGrade.UserTag> list) {
        if (spaceNotification == null) {
            return Boolean.TRUE;
        }
        NotifyLogger.m29915i(TAG, "dealNotifyCloudSpace noticeType=" + spaceNotification.getNoticeType());
        return (checkGradeCode(spaceNotification, str) && checkUserTag(list, spaceNotification)) ? Boolean.FALSE : Boolean.TRUE;
    }

    private boolean isSatifyAvaliableRatioRange(String str, String str2, float f10) {
        return Float.valueOf(str).floatValue() < 0.0f ? f10 >= Float.valueOf(str2).floatValue() : f10 <= Float.valueOf(str).floatValue() && f10 >= Float.valueOf(str2).floatValue();
    }

    private boolean isSatifyAvaliableSizeRange(String str, String str2, long j10) {
        return C0241z.m1688f(str) == -1 ? j10 >= C0241z.m1688f(str2) : j10 <= C0241z.m1688f(str) && j10 >= C0241z.m1688f(str2);
    }

    private boolean isSatifyUsedRange(String str, String str2, long j10) {
        return C0241z.m1688f(str) == -1 ? j10 >= C0241z.m1688f(str2) : j10 <= C0241z.m1688f(str) && j10 >= C0241z.m1688f(str2);
    }

    private boolean isShowSpaceNotificationActivitySuccess(NotificationWithActivity notificationWithActivity) throws SQLException {
        if (notificationWithActivity == null) {
            return false;
        }
        recordSpaceNotifyActivityRuleFrequency(notificationWithActivity);
        return true;
    }

    private boolean isSpaceUseShowRecently() {
        return System.currentTimeMillis() - C0214f0.m1382b(this.mContext, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).getLong(NotifyConstants.SPACE_DETAIL_NOTIFY_SHOW_TIME, 0L) < 172800000;
    }

    private String[] jsonArrayToStrArr(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            try {
                arrayList.add(jSONArray.getString(i10));
            } catch (JSONException e10) {
                NotifyLogger.m29914e(TAG, "jsonArrayToStrArr JSONException: " + e10.toString());
                arrayList.clear();
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private void processCheckRange(String str, String str2, String str3, float f10, long j10, Iterator<NotificationWithActivity> it) {
        str.hashCode();
        switch (str) {
            case "space_available_size":
                if (!isSatifyAvaliableSizeRange(str2, str3, j10)) {
                    it.remove();
                    break;
                }
                break;
            case "space_available_ratio":
                if (!isSatifyAvaliableRatioRange(str2, str3, f10)) {
                    it.remove();
                    break;
                }
                break;
            case "space_used_size":
                if (!isSatifyUsedRange(str2, str3, j10)) {
                    it.remove();
                    break;
                }
                break;
            default:
                NotifyLogger.m29914e(TAG, "fliterRangeOfNotice not satify : " + str);
                break;
        }
    }

    private void recordBackupCycleRuleFrequency(Context context) {
        C0212e0.m1370t(context, FrequencyManager.CHECKBACKUPFAILNOTIFYSP, FrequencyManager.CHECKBACKUPCYCLENOTIFYTIME, System.currentTimeMillis());
    }

    private void recordBackupNotifyLastSuccessTime(long j10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.mContext, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            sharedPreferencesM1382b.edit().putLong(NotifyConstants.BackupNotificationType.SP_BACKUP_NOT_COMPLETE_NOTIFY_FLAG, j10).commit();
        }
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy == null) {
            NotifyLogger.m29914e(TAG, "recordBackupNotifyLastSuccessTime error , spaceProxy is null");
        } else {
            iCloudSpaceProxy.setLastBackupNotifyTime(this.mContext);
        }
    }

    private void recordSpaceNotifyActivityRuleFrequency(NotificationWithActivity notificationWithActivity) throws SQLException {
        if (notificationWithActivity == null) {
            return;
        }
        new SpaceNotifyFrequencyOperator().updateCount(notificationWithActivity.getNoticeType(), String.valueOf(notificationWithActivity.getId()));
    }

    private void recordSpaceNotifyRuleFrequency(SpaceNotification spaceNotification) throws SQLException {
        if (spaceNotification == null) {
            return;
        }
        new SpaceNotifyFrequencyOperator().updateCount(spaceNotification.getNoticeType(), String.valueOf(spaceNotification.getId()));
    }

    private String replaceValue(String str, String str2) {
        NotifyLogger.m29913d(TAG, "replaceValue, key = " + str + ", value = " + str2);
        str.hashCode();
        switch (str) {
            case "bs.userdata.remainDays":
            case "bs.member.remain.days":
                if (!TextUtils.equals(str2, "0")) {
                    return str2;
                }
                break;
            case "bs.userdata.remain.dwnld1Days":
                if (!TextUtils.equals(str2, "0") && !TextUtils.equals(str2, "-1")) {
                    return str2;
                }
                break;
            default:
                return str2;
        }
        return "1";
    }

    public static void saveNotifyTime(Context context, float f10) {
        NotifyTimeBean notifyTimeBean;
        if (context == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(context, CHECK_CLOUD_PHOTO_FAIL_NOTIFY_SP);
        String string = sharedPreferencesM1362l.getString(CHECK_CLOUD_PHOTO_FAIL_NOTIFY_TIME_LIST, "");
        Gson gson = new Gson();
        if (TextUtils.isEmpty(string)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(jCurrentTimeMillis));
            NotifyTimeBean notifyTimeBean2 = new NotifyTimeBean();
            notifyTimeBean2.setNotifyTimes(arrayList);
            sharedPreferencesM1362l.edit().putString(CHECK_CLOUD_PHOTO_FAIL_NOTIFY_TIME_LIST, gson.toJson(notifyTimeBean2)).commit();
            return;
        }
        try {
            notifyTimeBean = (NotifyTimeBean) gson.fromJson(string, NotifyTimeBean.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "saveNotifyTime err : " + e10.getMessage());
            notifyTimeBean = null;
        }
        if (notifyTimeBean == null) {
            NotifyLogger.m29914e(TAG, "saveNotifyTime notifyTimeBean is null!");
            return;
        }
        List<Long> notifyTimes = notifyTimeBean.getNotifyTimes();
        ArrayList arrayList2 = new ArrayList();
        if (notifyTimes == null || notifyTimes.isEmpty()) {
            arrayList2.add(Long.valueOf(jCurrentTimeMillis));
        } else {
            for (Long l10 : notifyTimes) {
                if (l10.longValue() >= jCurrentTimeMillis - f10) {
                    arrayList2.add(l10);
                }
            }
            arrayList2.add(Long.valueOf(jCurrentTimeMillis));
        }
        NotifyTimeBean notifyTimeBean3 = new NotifyTimeBean();
        notifyTimeBean3.setNotifyTimes(arrayList2);
        sharedPreferencesM1362l.edit().putString(CHECK_CLOUD_PHOTO_FAIL_NOTIFY_TIME_LIST, gson.toJson(notifyTimeBean3)).commit();
    }

    private void sendBackupCycleNotice(int i10, boolean z10, long j10, List<PortraitAndGrade.UserTag> list) {
        if (this.mContext == null || this.notifyManager == null) {
            NotifyLogger.m29914e(TAG, "sendBackupCycleNotice mContext is null");
            return;
        }
        if (!C13612b.m81829B().m81854S()) {
            NotifyLogger.m29915i(TAG, "sendBackupCycleNotice all switch closed");
            NotificationReportUtil.reportAllSwitchOff(NotifyConstants.NotificationReport.NOTI_TYPE_BACKUP_CYCLE);
            NotificationReportUtil.reportBackupCycle("0017", "0021", i10);
        } else {
            C14306d.m85220u(i10, z10, (Serializable) list);
            recordBackupNotifyLastSuccessTime(j10);
            recordBackupCycleRuleFrequency(this.mContext);
        }
    }

    private static boolean sortNotifyConfig(SpaceNotifyConfig spaceNotifyConfig) {
        if (spaceNotifyConfig == null || spaceNotifyConfig.getConfiguration().getNotification() == null) {
            NotifyLogger.m29914e(TAG, "spaceNotifyConfig null or spaceNotifyConfig.getNotification() null");
            return false;
        }
        List<SpaceNotification> notification = spaceNotifyConfig.getConfiguration().getNotification();
        if (notification != null) {
            Collections.sort(notification, new NotificationComparator());
            return true;
        }
        NotifyLogger.m29916w(TAG, "notify config is null, sortNotifyWithActivity failed");
        return false;
    }

    private static boolean sortNotifyConfigWithActivity(SpaceNotifyConfig spaceNotifyConfig) {
        if (spaceNotifyConfig == null || spaceNotifyConfig.getConfiguration().getNotificationWithActivity() == null) {
            NotifyLogger.m29914e(TAG, "spaceNotifyConfig null or spaceNotifyConfig.getNotification() null");
            return false;
        }
        List<NotificationWithActivity> notificationWithActivity = spaceNotifyConfig.getConfiguration().getNotificationWithActivity();
        if (notificationWithActivity != null) {
            Collections.sort(notificationWithActivity, new NotificationWithActivityComparator());
            return true;
        }
        NotifyLogger.m29916w(TAG, "notify with activity config is null, sortNotifyWithActivity failed");
        return false;
    }

    private boolean startNotifyThread(NotificationConfig notificationConfig, long j10, boolean z10) {
        NotifyLogger.m29915i(TAG, "startNotifyThread");
        if (notificationConfig == null) {
            return false;
        }
        FullFrequency frequency = notificationConfig.getFrequency();
        if (frequency == null) {
            NotifyLogger.m29915i(TAG, "spaceNotifyConfig frequency is null");
            return false;
        }
        if (frequency.getEveryday() == 0) {
            NotifyLogger.m29915i(TAG, "spaceNotifyConfig getEveryday() is 0");
            return false;
        }
        SpaceNotifyConfig hiCloudSpaceNotice = notificationConfig.getHiCloudSpaceNotice();
        boolean zSortNotifyConfigWithActivity = sortNotifyConfigWithActivity(hiCloudSpaceNotice);
        boolean zSortNotifyConfig = sortNotifyConfig(hiCloudSpaceNotice);
        if (zSortNotifyConfigWithActivity || zSortNotifyConfig) {
            return doNotifyCloudSpace(frequency, hiCloudSpaceNotice, j10, z10);
        }
        NotifyLogger.m29916w(TAG, "sortSpaceNotifyConfig failed");
        return false;
    }

    public NotifyNeedData buildAlbumNotifyNeedData(SpaceNotification spaceNotification, String str, long j10) {
        ICloudBackupNotifyProxy iCloudBackupNotifyProxy = this.backupNotifyProxy;
        if (iCloudBackupNotifyProxy != null) {
            return iCloudBackupNotifyProxy.buildAlbumSpaceNeedData(spaceNotification, str, j10);
        }
        return null;
    }

    public NotifyNeedData buildBackupBeforeNoticeData(MsgUserData msgUserData, String str) {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            return iCloudSpaceProxy.buildBackupBeforeNoticeNotifyNeedData(msgUserData, str);
        }
        NotifyLogger.m29914e(TAG, "buildBackupBeforeNoticeData:spaceProxy is null");
        return null;
    }

    public NotifyNeedData buildBackupCycleNotifyNeedData(ExtraNotificationBean extraNotificationBean, boolean z10, int i10, String str) {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            return iCloudSpaceProxy.buildBackupCycleNotifyNeedData(extraNotificationBean, z10, i10, str);
        }
        return null;
    }

    public String buildBackupSuspendContent(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            return iCloudSpaceProxy.buildBackupSuspendContent(backupSpaceNotEnoughNeedData);
        }
        return null;
    }

    public MsgUserData buildUserDataActivity(NotificationWithActivity notificationWithActivity, String str, String str2, boolean z10, NotifyAgdParameters notifyAgdParameters) {
        return new HiCloudNotificationManager(C0213f.m1377a()).buildUserDataActivity(notificationWithActivity, Long.valueOf(getRecommendSize()), str, str2, z10, notifyAgdParameters);
    }

    public boolean checkCloudNoticeOffCondition(String str) {
        if (!C13612b.m81829B().m81854S()) {
            NotifyLogger.m29915i(TAG, "checkCloudNoticeOffCondition, all Switch Close");
            NotificationReportUtil.reportAllSwitchOff(str);
            return true;
        }
        boolean z10 = checkSpaceFitNotice(str) == 2;
        NotifyLogger.m29915i(TAG, "checkCloudNoticeOffCondition, isSpaceMax: " + z10);
        return z10;
    }

    public boolean checkDiamondUserNotify(String str) {
        if (this.spaceProxy == null) {
            NotifyLogger.m29915i(TAG, "checkDiamondUserNotify spaceProxy is null");
            return true;
        }
        if (TextUtils.equals(str, "D")) {
            return this.spaceProxy.diamondCanNotify(this.endTime2);
        }
        return true;
    }

    public boolean checkGradeCode(SpaceNotification spaceNotification, String str) {
        List<String> supportGradeCodes = spaceNotification.getSupportGradeCodes();
        int topupPackage = spaceNotification.getTopupPackage();
        if (supportGradeCodes == null) {
            NotifyLogger.m29915i(TAG, "checkGradeCode, supportGradeCodes is null, support all grade");
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29915i(TAG, "checkGradeCode， gradeCode is null or empty");
            return false;
        }
        if (supportGradeCodes.size() > 0) {
            Iterator<String> it = supportGradeCodes.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return true;
                }
            }
        }
        if (topupPackage != 1) {
            return false;
        }
        NotifyLogger.m29915i(TAG, "check worry-free notification pass");
        return true;
    }

    public boolean checkNotifyRule(NotificationConfig notificationConfig, long j10, boolean z10) {
        NotifyLogger.m29915i(TAG, "checkNotifyRule totalNeedSpace:" + j10 + "isFromAlbum" + z10);
        String strM80942m = C13452e.m80781L().m80942m();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyCloudSpace countryCode = ");
        sb2.append(strM80942m);
        NotifyLogger.m29915i(TAG, sb2.toString());
        if (C0209d.m1208S0(this.mContext)) {
            return startNotifyThread(notificationConfig, j10, z10);
        }
        NotifyLogger.m29915i(TAG, "network not connected!");
        return false;
    }

    public int checkSpaceFitNotice(String str) throws JSONException {
        int i10;
        long j10;
        long j11;
        long j12;
        long j13 = C13452e.m80781L().m80887a1() ? 0L : PACKAGE_5GB;
        CloudSpace cloudSpace = getCloudSpace();
        int i11 = 0;
        if (cloudSpace == null) {
            NotifyLogger.m29914e(TAG, "isCloudSpaceFit, space is null");
            i10 = 1;
            j12 = 0;
            j11 = 0;
            j10 = 0;
        } else {
            long used = cloudSpace.getUsed();
            long total = cloudSpace.getTotal();
            long maxPackageSize = cloudSpace.getMaxPackageSize();
            long oldMaxPackageSize = cloudSpace.getOldMaxPackageSize();
            if (maxPackageSize < 0) {
                i10 = 0;
                j10 = maxPackageSize;
                j11 = total;
                j12 = used;
            } else {
                if (oldMaxPackageSize < 0 || total >= oldMaxPackageSize) {
                    long j14 = j13 + maxPackageSize;
                    if (total >= j14 || used > j14) {
                        NotifyLogger.m29915i(TAG, "total/usedSize size is highest size, no need to show notice");
                        i10 = 2;
                    }
                    i10 = 0;
                } else {
                    long j15 = oldMaxPackageSize + j13;
                    if (total >= j15 || used > j15) {
                        NotifyLogger.m29915i(TAG, "not diamond total/usedSize size is highest size, no need to show notice");
                        i10 = 2;
                    }
                    i10 = 0;
                }
                j10 = maxPackageSize;
                j11 = total;
                j12 = used;
            }
        }
        if (C13452e.m80781L().m80791C0()) {
            NotifyLogger.m29914e(TAG, "new business base user space check success");
        } else {
            i11 = i10;
        }
        NotificationReportUtil.reportSpaceOverMaxCheck(str, i11, j12, j11, j10);
        return i11;
    }

    public boolean checkSpaceNotifyRuleFrequency(String str, String str2, float f10, int i10) {
        return NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT.equals(str) ? checkAlbumNotifyFrequency(C0213f.m1377a(), 24.0f * f10 * 3600000.0f, i10) : this.frequencyChecker.checkSpaceNotifyFrequency(str, str2, f10);
    }

    public void doNotifyBackupCycle(int i10, long j10) {
        NotifyLogger.m29915i(TAG, "doNotifyBackupCycle");
        if (!this.frequencyChecker.checkBackupFailedNotifyTime(this.mContext)) {
            NotifyLogger.m29915i(TAG, "doNotifyBackupCycle backup failed notification shown in last 24 hours");
            NotificationReportUtil.reportBackupCycle("0017", "0019", i10);
            return;
        }
        if (!checkBackupCycleNotifyRule(this.mContext)) {
            NotifyLogger.m29914e(TAG, "doNotifyBackupCycle rule check is false");
            NotificationReportUtil.reportBackupCycle("0017", "0020", i10);
            return;
        }
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy == null) {
            NotifyLogger.m29914e(TAG, "doNotifyBackupCycle error , spaceProxy is null.");
            return;
        }
        List<PortraitAndGrade.UserTag> userTagList = iCloudSpaceProxy.getUserTagList("doNotifyBackupCycle");
        List<ExtraNotificationBean> extraNotificationBean = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.BACKUP_CYCLE, userTagList);
        if (extraNotificationBean == null || extraNotificationBean.size() == 0) {
            sendBackupCycleNotice(i10, true, j10, userTagList);
            return;
        }
        for (ExtraNotificationBean extraNotificationBean2 : getFilterExtraNotificationBeans(extraNotificationBean)) {
            if (this.spaceProxy.checkNotifyCondition(this.mContext.getApplicationContext(), extraNotificationBean2.getUnBackupDays())) {
                float frequency = extraNotificationBean2.getFrequency();
                String noticeType = extraNotificationBean2.getNoticeType();
                String strValueOf = String.valueOf(extraNotificationBean2.getId());
                if (TextUtils.isEmpty(noticeType) || TextUtils.isEmpty(strValueOf) || frequency == 0.0f) {
                    NotifyLogger.m29915i(TAG, "doNotifyBackupCycle noticeType or datatype or frequency is null or 0");
                    sendBackupCycleNotice(i10, true, j10, userTagList);
                    return;
                } else if (this.frequencyChecker.checkBackupCycleNotifyFrequency(this.mContext, noticeType, frequency)) {
                    sendBackupCycleNotice(i10, false, j10, userTagList);
                    return;
                } else {
                    NotifyLogger.m29915i(TAG, "doNotifyBackupCycle frequency not match， not show");
                    NotificationReportUtil.reportBackupCycle("0017", "0022", i10);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean doNotifyCloudSpace(com.huawei.hicloud.notification.config.FullFrequency r20, com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig r21, long r22, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.CloudSpaceNotifyUtil.doNotifyCloudSpace(com.huawei.hicloud.notification.config.FullFrequency, com.huawei.hicloud.notification.db.bean.SpaceNotifyConfig, long, boolean):boolean");
    }

    public NotificationWithActivity doSpaceNoticeWithActivity(Map<String, List<NotificationWithActivity>> map, SNTimes sNTimes, SNTimeOperator sNTimeOperator, long j10, List<PortraitAndGrade.UserTag> list, long j11, List<NotificationWithActivity> list2) {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            return iCloudSpaceProxy.doSpaceNoticeWithActivity(map, sNTimes, sNTimeOperator, j10, list, j11, list2);
        }
        return null;
    }

    public void doSpaceUsedNotify() {
        NotifyLogger.m29915i(TAG, "doSpaceUsedNotify");
        if (checkSpaceUseNotifyRule()) {
            ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
            ExtraNotificationBean extraNotificationBean = null;
            List<PortraitAndGrade.UserTag> userTagList = iCloudSpaceProxy != null ? iCloudSpaceProxy.getUserTagList("doSpaceUsedNotify") : null;
            HiCloudNotificationManager hiCloudNotificationManager = new HiCloudNotificationManager(C0213f.m1377a());
            List<ExtraNotificationBean> extraNotificationBean2 = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.SPACE_QUERY_DETAIL, userTagList);
            if (extraNotificationBean2 != null && extraNotificationBean2.size() > 0) {
                extraNotificationBean = extraNotificationBean2.get(0);
            }
            if (extraNotificationBean != null) {
                if (LevelFrequencyController.getInstance().check(new Object[]{"notification_bar", extraNotificationBean.getRemindPurposes(), NotifyConstants.SPACE_QUERY_DETAIL})) {
                    hiCloudNotificationManager.sendSpaceUsedNotify(extraNotificationBean);
                } else {
                    NotifyLogger.m29916w(TAG, "level freq control check fail, notice type: cloud_query_detail");
                }
            }
        }
    }

    public ICloudBackupNotifyProxy getCloudBackupProxy() {
        return this.backupNotifyProxy;
    }

    public Intent getFamilyMemberNotifyIntent() {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            return iCloudSpaceProxy.getMemberSpaceNotifyIntent();
        }
        return null;
    }

    public NotificationWithActivity getMatchedNotificationBean(List<NotificationWithActivity> list, List<PortraitAndGrade.UserTag> list2) {
        NotificationWithActivity next;
        JsonArray jsonArray = new JsonArray();
        Iterator<NotificationWithActivity> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            String noticeType = next.getNoticeType();
            if (!TextUtils.isEmpty(noticeType) && checkUserTag(list2, next)) {
                int id2 = next.getId();
                if (!checkSpaceNotifyRuleFrequency(noticeType, String.valueOf(id2), next.getFrequency(), 0)) {
                    NotifyLogger.m29915i(TAG, "processCtypeNotificationList not satisfied rule id = " + id2);
                    NotificationBIReportUtil.addDayOnceCheckFailNotice(jsonArray, noticeType, String.valueOf(id2));
                    if (!C0209d.m1217V0(next.getUserGroupExtIDs())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        next = null;
        NotificationBIReportUtil.reportActivityDayonceCheckFail(jsonArray);
        return next;
    }

    public NoticeDetail getNoticeContentDetail(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (baseSpaceNotifyBean == null) {
            NotifyLogger.m29914e(TAG, "getNoticeContentDetail notification null");
            return null;
        }
        NoticeContentRoot noticeContent = baseSpaceNotifyBean.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticeDetail();
        }
        NotifyLogger.m29914e(TAG, "getNoticeContentDetail contentRoot notification null");
        return null;
    }

    public NoticeDetail getNoticeContentDetailByType(SpaceNotification spaceNotification, String str) {
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "getNoticeContentDetailByType notification null");
            return null;
        }
        NoticeContentRoot noticeContent = spaceNotification.getNoticeContent();
        if (noticeContent == null) {
            NotifyLogger.m29914e(TAG, "getNoticeContentDetailByType contentRoot notification null");
            return null;
        }
        NotifyLogger.m29913d(TAG, "getNoticeContentDetailByType type " + str);
        return NotifyConstants.DETAIL2.equals(str) ? noticeContent.getNoticeDetail2() : noticeContent.getNoticeDetail();
    }

    public NoticeDetail getNoticeContentDetailDefault(SpaceNotification spaceNotification, String str) {
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "getNoticeContentDetailDefault notification null");
            return null;
        }
        NoticeContentRoot noticeContentDefault = spaceNotification.getNoticeContentDefault();
        if (noticeContentDefault != null) {
            return NotifyConstants.DETAIL2.equals(str) ? noticeContentDefault.getNoticeDetail2() : noticeContentDefault.getNoticeDetail();
        }
        NotifyLogger.m29914e(TAG, "getNoticeContentDetailDefault contentRoot notification null");
        return null;
    }

    public NoticeDetail getNoticeContentDetailMember(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (baseSpaceNotifyBean == null) {
            NotifyLogger.m29914e(TAG, "getNoticeContentDetailMember notification null");
            return null;
        }
        NoticeContentRoot noticeContent = baseSpaceNotifyBean.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticeDetailMember();
        }
        NotifyLogger.m29914e(TAG, "getNoticeContentDetailMember contentRoot notification null");
        return null;
    }

    public NoticeContent getNoticeContentNotification(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "getNoticeContentNotification notification null");
            return null;
        }
        NoticeContentRoot noticeContent = spaceNotification.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticeContent();
        }
        NotifyLogger.m29914e(TAG, "getNoticeContentNotification contentRoot notification null");
        return null;
    }

    public NoticeContent getNoticeContentPopup(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (baseSpaceNotifyBean == null) {
            NotifyLogger.m29914e(TAG, "getNoticeContentPopup notification null");
            return null;
        }
        NoticeContentRoot noticeContent = baseSpaceNotifyBean.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticePopup();
        }
        NotifyLogger.m29914e(TAG, "getNoticeContentPopup contentRoot notification null");
        return null;
    }

    public NoticeContent getNoticeCouponContent(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "getNoticeCouponContent notification null");
            return null;
        }
        NoticeContentRoot noticeContent = spaceNotification.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticeCoupon();
        }
        NotifyLogger.m29914e(TAG, "getNoticeCouponContent contentRoot notification null");
        return null;
    }

    public NoticeDetail getNoticeDetailWithPlaceHolder(SpaceNotification spaceNotification) {
        return getNoticeContentDetail(spaceNotification);
    }

    public NoticeContent getNoticeNotification(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "getNoticeNotification notification null");
            return null;
        }
        NoticeContentRoot noticeContent = spaceNotification.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticeNotification();
        }
        NotifyLogger.m29914e(TAG, "getNoticeNotification contentRoot notification null");
        return null;
    }

    public ICloudSpaceProxy getSpaceProxy() {
        return this.spaceProxy;
    }

    public VoucherNotiDisplayInfo getVoucherInfo(SpaceNotification spaceNotification, Long l10) {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            return iCloudSpaceProxy.getVoucherInfo(spaceNotification, l10);
        }
        NotifyLogger.m29914e(TAG, "getVoucherInfo, spaceProxy is null");
        return null;
    }

    public void init(Context context) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "init context is null");
        } else {
            this.mContext = context;
            this.notifyManager = new HiCloudNotificationManager(context);
        }
    }

    public boolean isAlbumOn() {
        ICloudBackupNotifyProxy iCloudBackupNotifyProxy = this.backupNotifyProxy;
        if (iCloudBackupNotifyProxy == null) {
            return false;
        }
        return iCloudBackupNotifyProxy.isAlbumOn();
    }

    public boolean isFamilyShareMember() {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            return iCloudSpaceProxy.isFamilyShareMember();
        }
        return false;
    }

    public boolean isHasActivityEntry(int i10) {
        return this.backupNotifyProxy.isHasActivityEntry(i10);
    }

    public boolean isHasCampaignActivityData(int i10) {
        return this.backupNotifyProxy.isHasCampaignActivityData(i10);
    }

    public boolean needDelay() throws ParseException {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            NotifyLogger.m29915i(TAG, "hiCloudSysParamMap is null, no need delay");
            return false;
        }
        String noticeSuppressStartTimeList = hiCloudSysParamMapM60757p.getNoticeSuppressStartTimeList();
        String noticeSuppressEndTimeList = hiCloudSysParamMapM60757p.getNoticeSuppressEndTimeList();
        if (TextUtils.isEmpty(noticeSuppressStartTimeList) || TextUtils.isEmpty(noticeSuppressEndTimeList)) {
            NotifyLogger.m29915i(TAG, "suppressTimeList is null, no need delay");
            return false;
        }
        try {
            boolean zM1289o1 = C0209d.m1289o1(jsonArrayToStrArr(new JSONArray(noticeSuppressStartTimeList)), jsonArrayToStrArr(new JSONArray(noticeSuppressEndTimeList)));
            NotifyLogger.m29914e(TAG, "isInDelayTime: " + zM1289o1);
            return zM1289o1;
        } catch (JSONException e10) {
            NotifyLogger.m29914e(TAG, "needDelay catch exception: " + e10.toString());
            return false;
        }
    }

    public void notifyCloudSpace() {
        NotifyLogger.m29915i(TAG, "notifyCloudSpace");
        HiCloudNotification.getInstance().executeCloudSpaceNotify();
    }

    public void recordSpaceNotifyCouponFrequency(SpaceNotification spaceNotification) throws SQLException {
        if (spaceNotification == null) {
            return;
        }
        new SpaceNotifyFrequencyOperator().updateCount(spaceNotification.getNoticeType() + NotifyConstants.SPACE_NOTICE_FREQ_COUPON_SUFFIX, String.valueOf(spaceNotification.getId()));
    }

    public void recordSpaceUsedNoticeShow() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.mContext, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        sharedPreferencesM1382b.edit().putLong(NotifyConstants.SPACE_DETAIL_NOTIFY_SHOW_TIME, System.currentTimeMillis()).commit();
    }

    public String replaceDeepLinkParams(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29915i(TAG, "replaceParams, content is empty");
            return "";
        }
        NotifyLogger.m29915i(TAG, "replaceDeepLinkParams, pushContext " + str3);
        Matcher matcher = DEEP_LINK_PATTERN.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (TextUtils.isEmpty(strGroup)) {
                NotifyLogger.m29916w(TAG, "replaceParams, key is empty");
                return "";
            }
            String param = TextUtils.isEmpty(str3) ? this.spaceProxy.getParam(strGroup, str2) : this.spaceProxy.getParamRealTime(strGroup, str2, str3);
            if (TextUtils.isEmpty(param)) {
                NotifyLogger.m29916w(TAG, "replaceParams, value is empty");
                return "";
            }
            matcher.appendReplacement(stringBuffer, param);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String replaceParams(String str, String str2) {
        return replaceParams(str, str2, "");
    }

    public void saveForcedUpgradeConfig(Context context, boolean z10, ForcedUpgradeUtil.QueryUpdate queryUpdate) {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy == null) {
            NotifyLogger.m29915i(TAG, "saveForcedUpgradeConfig spaceProxy is null");
        } else {
            iCloudSpaceProxy.saveForcedUpgradeConfig(context, z10, queryUpdate);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00d0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean sendActivityNotice(com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity r16, com.huawei.hicloud.notification.p106db.bean.SNTimes r17, com.huawei.hicloud.notification.p106db.operator.SNTimeOperator r18, long r19, java.lang.String r21, java.lang.String r22, boolean r23, com.huawei.hicloud.notification.bean.NotifyAgdParameters r24) {
        /*
            r15 = this;
            r0 = r15
            r1 = 0
            if (r16 != 0) goto L5
            return r1
        L5:
            java.lang.String r2 = r16.getNoticeType()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L10
            return r1
        L10:
            r2.hashCode()
            int r3 = r2.hashCode()
            r14 = 1
            r4 = -1
            switch(r3) {
                case -1849560048: goto L33;
                case -1502954020: goto L28;
                case -372943030: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L3d
        L1d:
            java.lang.String r3 = "space_used_size"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L26
            goto L3d
        L26:
            r4 = 2
            goto L3d
        L28:
            java.lang.String r3 = "space_available_ratio"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L31
            goto L3d
        L31:
            r4 = r14
            goto L3d
        L33:
            java.lang.String r3 = "space_available_size"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L3c
            goto L3d
        L3c:
            r4 = r1
        L3d:
            java.lang.String r3 = "CloudSpaceNotifyUtil"
            switch(r4) {
                case 0: goto Lae;
                case 1: goto L7a;
                case 2: goto L58;
                default: goto L42;
            }
        L42:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "sendActivityNotice invalid notice type : "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r3, r0)
            goto Ld0
        L58:
            java.lang.String r2 = "sendActivityNotice SPACE_USED_SIZE"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r3, r2)
            com.huawei.hicloud.notification.manager.HiCloudNotificationManager r2 = r0.notifyManager
            long r6 = r0.used
            long r8 = r15.getRecommendSize()
            r3 = r16
            r4 = r17
            r5 = r18
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            boolean r0 = com.huawei.hicloud.notification.CloudSpaceNotifyHelper.notifyActivitySpaceUsedSize(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13)
            if (r0 == 0) goto Ld0
            return r14
        L7a:
            java.lang.String r2 = "sendActivityNotice SPACE_AVAILABLE_RATIO"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r3, r2)
            long r4 = r0.total
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L8d
            java.lang.String r0 = "sendActivityNotice SPACE_AVAILABLE_RATIO, total space is 0"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r3, r0)
            return r1
        L8d:
            r6 = r19
            float r2 = (float) r6
            float r3 = (float) r4
            float r6 = r2 / r3
            com.huawei.hicloud.notification.manager.HiCloudNotificationManager r2 = r0.notifyManager
            long r7 = r15.getRecommendSize()
            r3 = r16
            r4 = r17
            r5 = r18
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            boolean r0 = com.huawei.hicloud.notification.CloudSpaceNotifyHelper.notifyActivityAvailableRatio(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)
            if (r0 == 0) goto Ld0
            return r14
        Lae:
            r6 = r19
            java.lang.String r2 = "sendActivityNotice SPACE_AVAILABLE_SIZE"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r3, r2)
            com.huawei.hicloud.notification.manager.HiCloudNotificationManager r2 = r0.notifyManager
            long r8 = r15.getRecommendSize()
            r3 = r16
            r4 = r17
            r5 = r18
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            boolean r0 = com.huawei.hicloud.notification.CloudSpaceNotifyHelper.notifyWithActivityAvailableSize(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13)
            if (r0 == 0) goto Ld0
            return r14
        Ld0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.CloudSpaceNotifyUtil.sendActivityNotice(com.huawei.hicloud.notification.db.bean.NotificationWithActivity, com.huawei.hicloud.notification.db.bean.SNTimes, com.huawei.hicloud.notification.db.operator.SNTimeOperator, long, java.lang.String, java.lang.String, boolean, com.huawei.hicloud.notification.bean.NotifyAgdParameters):boolean");
    }

    public void sendFamilyShareEnableNotify(long j10) {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            iCloudSpaceProxy.sendFamilyShareEnableNotify(j10);
        }
    }

    public void sendFamilyShareStopNotify() {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            iCloudSpaceProxy.sendFamilyShareStopNotify();
        }
    }

    public void sendQuitOwnerFamilyShareNotify() {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            iCloudSpaceProxy.sendQuitOwnerFamilyShareNotify();
        }
    }

    public void sendSiteChangedNotification() {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            iCloudSpaceProxy.sendSiteChangedNotification();
        }
    }

    public void sendSiteOfflineNotification() {
        ICloudSpaceProxy iCloudSpaceProxy = this.spaceProxy;
        if (iCloudSpaceProxy != null) {
            iCloudSpaceProxy.sendSiteOfflineNotification();
        }
    }

    public void setBackupNotifyProxy(ICloudBackupNotifyProxy iCloudBackupNotifyProxy) {
        this.backupNotifyProxy = iCloudBackupNotifyProxy;
    }

    public void setSpaceProxy(ICloudSpaceProxy iCloudSpaceProxy) {
        this.spaceProxy = iCloudSpaceProxy;
    }

    public String replaceParams(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29915i(TAG, "replaceParams, content is empty");
            return "";
        }
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (TextUtils.isEmpty(strGroup)) {
                NotifyLogger.m29916w(TAG, "replaceParams, key is empty");
                return "";
            }
            String param = TextUtils.isEmpty(str3) ? this.spaceProxy.getParam(strGroup, str2) : this.spaceProxy.getParamRealTime(strGroup, str2, str3);
            if (TextUtils.isEmpty(param)) {
                NotifyLogger.m29916w(TAG, "replaceParams, value is empty");
                return "";
            }
            if (!checkValid(strGroup, param)) {
                NotifyLogger.m29916w(TAG, "replaceParams, the value of " + strGroup + " is invalid");
                return "";
            }
            matcher.appendReplacement(stringBuffer, replaceValue(strGroup, param));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean checkUserTag(List<PortraitAndGrade.UserTag> list, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        return doCheckUserTag(list, C0236u.m1651b(), backupSpaceInsuffNoticeV5Configuration.getUserGroupExtIDs(), backupSpaceInsuffNoticeV5Configuration.getNoticeType(), backupSpaceInsuffNoticeV5Configuration.getPercentage());
    }

    public NoticeContent getNoticeCouponContent(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "getNoticeCouponContent notification null");
            return null;
        }
        NoticeContentRoot noticeContent = notificationWithActivity.getNoticeContent();
        if (noticeContent == null) {
            NotifyLogger.m29914e(TAG, "getNoticeCouponContent contentRoot notification null");
            return null;
        }
        return noticeContent.getNoticeCoupon();
    }

    public static boolean checkUserTag(List<PortraitAndGrade.UserTag> list, SpaceNotification spaceNotification) {
        return doCheckUserTag(list, C0236u.m1651b(), spaceNotification.getUserGroupExtIDs(), spaceNotification.getNoticeType(), spaceNotification.getPercentage());
    }

    public static boolean checkUserTag(List<PortraitAndGrade.UserTag> list, ExtraNotificationBean extraNotificationBean) {
        return doCheckUserTag(list, C0236u.m1651b(), extraNotificationBean.getUserGroupExtIDs(), extraNotificationBean.getNoticeType(), extraNotificationBean.getPercentage());
    }
}
