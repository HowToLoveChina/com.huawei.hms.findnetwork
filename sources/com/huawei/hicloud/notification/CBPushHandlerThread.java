package com.huawei.hicloud.notification;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import com.huawei.hicloud.notification.checker.NotificationRuleChecker;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3LangDownloader;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.util.NotifyUtil;
import hu.C10343b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p015ak.C0206b0;
import p015ak.C0213f;
import p015ak.C0224k0;
import p709vj.C13452e;
import p742wj.C13612b;

/* loaded from: classes6.dex */
public class CBPushHandlerThread {
    public static final String TAG = "CBPushHandlerThread";
    private Handler.Callback mDispatcher = new DispatcherHandler();
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    /* renamed from: com.huawei.hicloud.notification.CBPushHandlerThread$1 */
    public class RunnableC49021 implements Runnable {
        final /* synthetic */ Message val$argMsg;

        public RunnableC49021(Message message) {
            message = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            CBPushHandlerThread.this.mDispatcher.handleMessage(message);
        }
    }

    public CBPushHandlerThread(String str) {
    }

    public void doTask(Message message) {
        NotifyLogger.m29915i(TAG, "doTask");
        if (this.executor.submit(new Runnable() { // from class: com.huawei.hicloud.notification.CBPushHandlerThread.1
            final /* synthetic */ Message val$argMsg;

            public RunnableC49021(Message message2) {
                message = message2;
            }

            @Override // java.lang.Runnable
            public void run() {
                CBPushHandlerThread.this.mDispatcher.handleMessage(message);
            }
        }) != null) {
            NotifyLogger.m29913d(TAG, "doTask submit success");
        }
    }

    public static class DispatcherHandler implements Handler.Callback {
        private NotificationRuleChecker mChecker;
        private NotificationConfigManager mConfigManager;

        public DispatcherHandler() {
            NotificationConfigManager notificationConfigManager = new NotificationConfigManager();
            this.mConfigManager = notificationConfigManager;
            this.mChecker = new NotificationRuleChecker(notificationConfigManager);
        }

        private void checkRuleForLogin(String str, NotificationConfig notificationConfig) {
            String strM80942m = C13452e.m80781L().m80942m();
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "contryCode=" + strM80942m);
            if ("CN".equals(strM80942m)) {
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "contry code CN");
                if (isCloudBackupEnable()) {
                    NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdCheckRule cloudbackup enable, execute cloud space notify");
                    executeCmdNotifyCloudSpace();
                } else {
                    NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdCheckRule cloudbackup not enable");
                    this.mChecker.check(str, notificationConfig);
                }
            }
        }

        private void exeCmdCheckRule(String str, NotificationConfig notificationConfig) {
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdCheckRule sence=" + str);
            if (!str.equals(HNConstants.NotifyType.SCENE_HIDISK) && !str.equals(HNConstants.NotifyType.SCENE_BOOT)) {
                checkRuleForLogin(str, notificationConfig);
            } else if (C13612b.m81829B().m81853R()) {
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdCheckRule sence_h_b already login");
                checkRuleForLogin(str, notificationConfig);
            } else {
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdCheckRule sence_h_b not login");
                this.mChecker.check(str, notificationConfig);
            }
        }

        private void exeCmdCheckRuleForAlbum(Message message) {
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdCheckRuleForAlbum");
            NotificationConfig configFromFile = this.mConfigManager.getConfigFromFile();
            if (configFromFile != null) {
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "config not null");
                Bundle bundle = (Bundle) message.obj;
                String strM80942m = C13452e.m80781L().m80942m();
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "contryCode=" + strM80942m);
                if ("CN".equals(strM80942m)) {
                    NotifyLogger.m29915i(CBPushHandlerThread.TAG, "contry code CN");
                    this.mChecker.checkForAlbum(configFromFile, bundle);
                }
            }
        }

        private void exeCmdGetConfigVersion() {
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdGetConfigVersion");
            if (C13612b.m81829B().isLogin()) {
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdGetConfigVersion already login exeCmdGetConfigVersion");
                this.mConfigManager.queryConfigVersion();
                SpaceNoticeV3Manager.getInstance().requestConfig();
            }
        }

        private void exeCmdGetNoticeConfig() throws SQLException {
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdGetNoticeConfig");
            Context contextM1377a = C0213f.m1377a();
            if (C13612b.m81829B().isLogin()) {
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdGetConfigVersion already login exeCmdGetNoticeConfig");
                this.mConfigManager.getNoticeConfig();
                SpaceNoticeV3Manager.getInstance().requestConfig();
                new Thread(new SyncLimitConfigRunnable(contextM1377a, this.mConfigManager.getConfigFromFile())).start();
                this.mConfigManager.processRiskCfg();
            }
        }

        private void exeCmdNotify(Message message) {
            NotificationConfig configFromFile;
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "exeCmdNotify");
            String str = (String) message.obj;
            if (isOOBEProcessing(str) || (configFromFile = this.mConfigManager.getConfigFromFile()) == null) {
                return;
            }
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "config not null");
            exeCmdCheckRule(str, configFromFile);
        }

        private void exeCmdShowNotifyForAlbum(Message message) {
            NotifyUtil.sendShowNotifyBroadcast((Bundle) message.obj);
        }

        private void executeCmdCheckDatabase() {
            SpaceNotifyConfig hiCloudSpaceNotice;
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "executeCmdCheckDatabase");
            NotificationConfig configFromFile = this.mConfigManager.getConfigFromFile();
            if (configFromFile == null || (hiCloudSpaceNotice = configFromFile.getHiCloudSpaceNotice()) == null) {
                return;
            }
            SpaceNoticeV3LangDownloader.getInstance().checkLanguageDataBase(hiCloudSpaceNotice.getConfiguration());
        }

        private void executeCmdNotifyBackupCycle(Message message) {
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "executeCmdNotifyBackupCycle");
            if (message == null) {
                NotifyLogger.m29914e(CBPushHandlerThread.TAG, "executeCmdNotifyBackupCycle, msg is null");
                return;
            }
            Bundle bundle = (Bundle) message.obj;
            CloudSpaceNotifyUtil.getInstance().doNotifyBackupCycle(bundle.getInt("noBackupDays"), bundle.getLong("lastBackupSuccessTime"));
        }

        private void executeCmdNotifyCloudSpace(Message message) {
            long jM63688j;
            boolean zM63681c;
            Object obj = message.obj;
            if (obj != null) {
                C10343b c10343b = new C10343b((Bundle) obj);
                jM63688j = c10343b.m63688j("needSpace");
                zM63681c = c10343b.m63681c("isFromAlbum");
            } else {
                jM63688j = 0;
                zM63681c = false;
            }
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "executeCmdNotifyCloudSpace with msg");
            CloudSpaceNotifyUtil.getInstance().checkNotifyRule(this.mConfigManager.getConfigFromFile(), jM63688j, zM63681c);
        }

        private void executeCmdSpaceUsedNotify() {
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "executeCmdSpaceUsedNotify");
            CloudSpaceNotifyUtil.getInstance().doSpaceUsedNotify();
        }

        private boolean isCloudBackupEnable() {
            boolean zM1131c = C0206b0.m1131c("backup_key", C0213f.m1377a().getApplicationContext());
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "isCloudBackupEnable : " + zM1131c);
            return zM1131c;
        }

        private boolean isOOBEProcessing(String str) throws Settings.SettingNotFoundException {
            int i10;
            int i11;
            if (!HNConstants.NotifyType.SCENE_BOOT.equals(str)) {
                return false;
            }
            try {
                SystemClock.sleep(10000L);
                i10 = Settings.Secure.getInt(C0213f.m1377a().getContentResolver(), C0224k0.f834b);
                i11 = Settings.Secure.getInt(C0213f.m1377a().getContentResolver(), "device_provisioned");
                NotifyLogger.m29915i(CBPushHandlerThread.TAG, "userSetupComplete=" + i11 + ",userSetupComplete=" + i10);
            } catch (Exception e10) {
                NotifyLogger.m29914e(CBPushHandlerThread.TAG, "checkOOBE error:" + e10.toString());
            }
            return (i10 == 1 && i11 == 1) ? false : true;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws SQLException {
            switch (message.what) {
                case 2:
                    exeCmdGetConfigVersion();
                    break;
                case 3:
                    exeCmdNotify(message);
                    break;
                case 4:
                    executeCmdNotifyCloudSpace(message);
                    break;
                case 6:
                    exeCmdCheckRuleForAlbum(message);
                    break;
                case 7:
                    exeCmdShowNotifyForAlbum(message);
                    break;
                case 8:
                    exeCmdGetNoticeConfig();
                    break;
                case 9:
                    executeCmdNotifyBackupCycle(message);
                    break;
                case 10:
                    executeCmdSpaceUsedNotify();
                    break;
                case 11:
                    executeCmdCheckDatabase();
                    break;
            }
            return false;
        }

        private void executeCmdNotifyCloudSpace() {
            NotifyLogger.m29915i(CBPushHandlerThread.TAG, "executeCmdNotifyCloudSpace");
            CloudSpaceNotifyUtil.getInstance().checkNotifyRule(this.mConfigManager.getConfigFromFile(), 0L, false);
        }
    }
}
