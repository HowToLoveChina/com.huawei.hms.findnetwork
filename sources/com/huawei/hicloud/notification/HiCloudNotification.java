package com.huawei.hicloud.notification;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.config.CBPushConfigObject;
import com.huawei.hicloud.notification.config.CBPushContent;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyContentOperator;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import gp.C10028c;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p709vj.C13452e;
import p742wj.C13612b;
import p846zj.C14306d;

/* loaded from: classes6.dex */
public class HiCloudNotification {
    private static final HiCloudNotification INSTANCE = new HiCloudNotification();
    private static final String TAG = "HiCloudNotification";
    private HiCloudNotificationManager mManager;
    private CBPushHandlerThread mHandlerThread = new CBPushHandlerThread(CBPushHandlerThread.TAG);
    private long lastNotifyTime = 0;
    private long lastCloudNotifyTime = 0;

    private void execNotifyAlbumSpaceNotEnough(String str, long j10) {
        NotifyLogger.m29915i(TAG, "execNotifyAlbumSpaceNotEnough");
        Bundle bundle = new Bundle();
        bundle.putLong("needSpace", j10);
        bundle.putBoolean("isFromAlbum", true);
        bundle.putString("type", str);
        if (C0209d.m1202Q0() && C14306d.m85207h()) {
            sendCmd(6, bundle);
        } else {
            executeCloudSpaceNotify(bundle);
        }
    }

    private void executeCloudAlbumSpaceNotify(boolean z10, long j10) {
        NotifyLogger.m29915i(TAG, "executeCloudAlbumSpaceNotify");
        if (checkNotifyModuleEnable()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isAutoSync", z10);
            bundle.putLong("needSpace", j10);
            sendCmd(7, bundle);
        }
    }

    private void executeSpaceNotify(String str) {
        NotifyLogger.m29915i(TAG, "executeSpaceNotify");
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        if (C0209d.m1202Q0() && C14306d.m85207h()) {
            sendCmd(6, bundle);
        } else {
            executeCloudSpaceNotify();
        }
    }

    private long getAlbumNoticeTriggerTime() {
        NotificationConfig configFromFile = new NotificationConfigManager().getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29915i(TAG, "getAlbumNoticeTriggerTime config is null");
            return 1800000L;
        }
        SpaceNotifyConfig hiCloudSpaceNotice = configFromFile.getHiCloudSpaceNotice();
        if (hiCloudSpaceNotice == null) {
            NotifyLogger.m29915i(TAG, "getAlbumNoticeTriggerTime spaceNotifyConfig is null");
            return 1800000L;
        }
        HiCloudSpaceNoticeConfiguration configuration = hiCloudSpaceNotice.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29915i(TAG, "getAlbumNoticeTriggerTime configuration is null");
            return 1800000L;
        }
        List<SpaceNotification> notification = configuration.getNotification();
        if (notification == null || notification.size() <= 0) {
            NotifyLogger.m29915i(TAG, "getAlbumNoticeTriggerTime spaceNotifications is null");
            return 1800000L;
        }
        Iterator<SpaceNotification> it = notification.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SpaceNotification next = it.next();
            if (next != null) {
                String noticeType = next.getNoticeType();
                if (!TextUtils.isEmpty(noticeType) && NotifyConstants.NotificationType.CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT.equals(noticeType)) {
                    int checkMinutes = next.getCheckMinutes();
                    if (checkMinutes != 0) {
                        return checkMinutes * 60000;
                    }
                }
            }
        }
        return 1800000L;
    }

    public static HiCloudNotification getInstance() {
        return INSTANCE;
    }

    private CBPushContent getNoticeContent(int i10) throws Throwable {
        SpaceNotifyContentOperator spaceNotifyContentOperator = new SpaceNotifyContentOperator();
        String currentLanguage = HNUtil.getCurrentLanguage();
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        if (TextUtils.isEmpty(currentLanguage)) {
            NotifyLogger.m29914e(TAG, "getNoticeContent language null");
            return null;
        }
        NoticeContent noticeContentQueryPullNewContent = spaceNotifyContentOperator.queryPullNewContent(1, i10, currentLanguage);
        if (noticeContentQueryPullNewContent == null) {
            NotifyLogger.m29915i(TAG, "cannot find content by language-contry=" + currentLanguage);
            noticeContentQueryPullNewContent = spaceNotifyContentOperator.queryPullNewContentByLanguage(1, i10, currentBaseLanguage);
        }
        if (noticeContentQueryPullNewContent == null) {
            return null;
        }
        CBPushContent cBPushContent = new CBPushContent();
        cBPushContent.setTitle(noticeContentQueryPullNewContent.getTitle());
        cBPushContent.setLanguage(noticeContentQueryPullNewContent.getLanguage());
        cBPushContent.setSubTitle(noticeContentQueryPullNewContent.getSubTitle());
        return cBPushContent;
    }

    private boolean isDisabled(int i10) {
        if (ModuleConfigUtil.getInstance().isLocalVersion()) {
            NotifyLogger.m29915i(TAG, "sendCmd local version, not send");
            return true;
        }
        if (C0209d.m1166E1() || i10 == 2 || i10 == 8) {
            return false;
        }
        NotifyLogger.m29915i(TAG, "sendCmd not owner user, not send");
        return true;
    }

    public boolean checkNotifyModuleEnable() {
        if (!C13612b.m81829B().isLogin()) {
            return true;
        }
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("user_in_red_list");
        NotifyLogger.m29915i(TAG, "checkNotifyModuleEnable isInRedList=" + zM62395t1);
        return !zM62395t1;
    }

    public void clearCloudConfigFile() {
        new NotificationConfigManager().clear();
    }

    public void clearCloudConfigFileAndDB() throws SQLException {
        new NotificationConfigManager().clearConfigAndDB();
    }

    public void execute(String str) {
        NotifyLogger.m29915i(TAG, "execute type=" + str);
        if (checkNotifyModuleEnable()) {
            if (!C0209d.m1202Q0()) {
                NotifyLogger.m29915i(TAG, "sendCmd not china region rom, not send");
            } else if (!C13452e.m80781L().m80842P0() || C14306d.m85207h()) {
                sendCmd(3, str);
            } else {
                NotifyLogger.m29915i(TAG, "contry code not china");
            }
        }
    }

    public void executeBackupCycleNotify(int i10, long j10) {
        NotifyLogger.m29915i(TAG, "executeBackupCycleNotify");
        if (checkNotifyModuleEnable()) {
            Bundle bundle = new Bundle();
            bundle.putInt("noBackupDays", i10);
            bundle.putLong("lastBackupSuccessTime", j10);
            sendCmd(9, bundle);
        }
    }

    public void executeCheckDatabase() {
        NotifyLogger.m29915i(TAG, "executeCheckDatabase");
        sendCmd(11, null);
    }

    public void executeCloudAlbumNotify(HiCloudSafeIntent hiCloudSafeIntent) {
        if (hiCloudSafeIntent != null) {
            long longExtra = hiCloudSafeIntent.getLongExtra("totalNeedSpace", 0L);
            executeFromAlbum(HNConstants.NotifyType.SCENE_SYNC, hiCloudSafeIntent.getBooleanExtra("isAutoSync", false), hiCloudSafeIntent.getBooleanExtra("isSpaceNotEnough", false), longExtra);
        }
    }

    public void executeCloudSpaceNotify() {
        NotifyLogger.m29915i(TAG, "executeCloudSpaceNotify");
        if (checkNotifyModuleEnable()) {
            sendCmd(4, null);
        }
    }

    public void executeFromAlbum(String str, boolean z10, boolean z11, long j10) {
        NotifyLogger.m29915i(TAG, "executeFromAlbum, isAutoSync: " + z10 + ", isSpaceNotEnough: " + z11 + ", totalNeedSpace is: " + j10);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (checkNotifyModuleEnable()) {
            if (!z11) {
                NotifyLogger.m29915i(TAG, "executeFromAlbum current time is: " + jCurrentTimeMillis + ", lastCloudNotifyTime time is: " + this.lastCloudNotifyTime);
                long j11 = this.lastCloudNotifyTime;
                if (jCurrentTimeMillis - j11 < 1800000 && jCurrentTimeMillis >= j11) {
                    NotifyLogger.m29915i(TAG, "space enough notify too frequently!");
                    return;
                }
                NotificationReportUtil.reportTriggerSrc("0002");
                this.lastCloudNotifyTime = jCurrentTimeMillis;
                executeSpaceNotify(str);
                return;
            }
            long albumNoticeTriggerTime = getAlbumNoticeTriggerTime();
            NotifyLogger.m29915i(TAG, "executeFromAlbum check time is: " + albumNoticeTriggerTime + ", current time is: " + jCurrentTimeMillis + ", lastNotify time is: " + this.lastNotifyTime);
            long j12 = this.lastNotifyTime;
            if (jCurrentTimeMillis - j12 < albumNoticeTriggerTime && jCurrentTimeMillis >= j12) {
                NotifyLogger.m29915i(TAG, "space not enough notify too frequently!");
                return;
            }
            NotificationReportUtil.reportTriggerSrc("0002");
            if (z10) {
                execNotifyAlbumSpaceNotEnough(str, j10);
            } else {
                executeCloudAlbumSpaceNotify(false, j10);
            }
        }
    }

    public void executeFromDailyCheck() {
        NotifyLogger.m29915i(TAG, "start daily notice check");
        NotificationReportUtil.reportTriggerSrc("0005");
        if (!C0209d.m1202Q0() || !C14306d.m85207h()) {
            executeCloudSpaceNotify();
        } else if (checkNotifyModuleEnable()) {
            sendCmd(3, HNConstants.NotifyType.SCENE_DAILY_CHECK);
        }
    }

    public void executeFromDataUse() {
        NotificationReportUtil.reportTriggerSrc("0003");
        if (!C0209d.m1202Q0() || !C14306d.m85207h()) {
            executeCloudSpaceNotify();
        } else if (checkNotifyModuleEnable()) {
            sendCmd(3, HNConstants.NotifyType.SCENE_SYNC);
        }
    }

    public void executeSpaceUsedNotify() {
        NotifyLogger.m29915i(TAG, "executeSpaceUsedNotify");
        if (checkNotifyModuleEnable()) {
            sendCmd(10, null);
        }
    }

    public void getConfigVersion() {
        NotifyLogger.m29915i(TAG, "getConfigVersion");
        sendCmd(2, null);
    }

    public long getLastNotifyTime() {
        return this.lastNotifyTime;
    }

    public void getNoticeConfig() {
        NotifyLogger.m29915i(TAG, "getNoticeConfig");
        sendCmd(8, null);
    }

    public void resetNotifyTime() {
        this.lastNotifyTime = 0L;
        this.lastCloudNotifyTime = 0L;
    }

    public void sendCmd(int i10, Object obj) {
        if (isDisabled(i10)) {
            return;
        }
        if (this.mHandlerThread == null) {
            NotifyLogger.m29914e(TAG, "handler thread is null");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        if (obj != null) {
            messageObtain.obj = obj;
        }
        this.mHandlerThread.doTask(messageObtain);
        NotifyLogger.m29915i(TAG, "send cmd: " + i10);
    }

    public synchronized void sendDataRetentionNotify(Context context, int i10) {
        NotifyLogger.m29915i(TAG, "sendNotify");
        if (context == null) {
            NotifyLogger.m29914e(TAG, "sendDataRetentionNotify context is null");
            return;
        }
        if (this.mManager == null) {
            this.mManager = new HiCloudNotificationManager(context);
        }
        this.mManager.sendDataRecoveryNotify(i10);
    }

    public synchronized void sendNotify(CBPushConfigObject cBPushConfigObject) {
        NotifyLogger.m29915i(TAG, "sendNotify");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "sendNotify context is null");
            return;
        }
        if (cBPushConfigObject == null) {
            NotifyLogger.m29914e(TAG, "sendNotify rule null");
            return;
        }
        if (this.mManager == null) {
            this.mManager = new HiCloudNotificationManager(contextM1377a);
        }
        CBPushContent noticeContent = getNoticeContent(cBPushConfigObject.getId());
        if (noticeContent != null) {
            this.mManager.sendCBPNotification(contextM1377a, noticeContent, cBPushConfigObject);
        } else {
            NotifyLogger.m29914e(TAG, "sendNotify notifyContent null");
        }
    }

    public void setLastNotifyTime(long j10) {
        this.lastNotifyTime = j10;
    }

    public void executeCloudSpaceNotify(Bundle bundle) {
        NotifyLogger.m29915i(TAG, "executeCloudSpaceNotify");
        if (checkNotifyModuleEnable()) {
            sendCmd(4, bundle);
        }
    }
}
