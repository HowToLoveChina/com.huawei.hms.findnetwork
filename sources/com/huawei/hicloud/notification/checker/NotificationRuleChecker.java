package com.huawei.hicloud.notification.checker;

import android.os.Bundle;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p015ak.C0206b0;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public class NotificationRuleChecker {
    private static final String TAG = "NotificationRuleChecker";
    private List<BaseRuleChecker> mCheckers = new ArrayList();
    private NotificationConfigManager mConfigManager;
    private CBPushRuleChecker pushChecker;
    private CloudSpaceRuleChecker spaceChecker;

    public NotificationRuleChecker(NotificationConfigManager notificationConfigManager) {
        this.mConfigManager = notificationConfigManager;
        this.pushChecker = new CBPushRuleChecker(notificationConfigManager);
        CloudSpaceRuleChecker cloudSpaceRuleChecker = new CloudSpaceRuleChecker();
        this.spaceChecker = cloudSpaceRuleChecker;
        this.mCheckers.add(cloudSpaceRuleChecker);
    }

    private boolean isCloudBackupEnable() {
        boolean zM1131c = C0206b0.m1131c("backup_key", C0213f.m1377a());
        NotifyLogger.m29915i(TAG, "isCloudBackupEnable : " + zM1131c);
        return zM1131c;
    }

    public void check(String str, NotificationConfig notificationConfig) {
        this.pushChecker.precheck(notificationConfig);
        this.spaceChecker.precheck(notificationConfig);
        Collections.sort(this.mCheckers);
        for (BaseRuleChecker baseRuleChecker : this.mCheckers) {
            if (baseRuleChecker.getPriority() != -1 && baseRuleChecker.check(str)) {
                return;
            }
        }
    }

    public void checkForAlbum(NotificationConfig notificationConfig, Bundle bundle) {
        this.pushChecker.precheck(notificationConfig);
        this.spaceChecker.precheck(notificationConfig);
        Collections.sort(this.mCheckers);
        for (BaseRuleChecker baseRuleChecker : this.mCheckers) {
            if (!(baseRuleChecker instanceof CBPushRuleChecker) || !isCloudBackupEnable()) {
                if (baseRuleChecker.check(bundle)) {
                    return;
                }
            }
        }
    }
}
