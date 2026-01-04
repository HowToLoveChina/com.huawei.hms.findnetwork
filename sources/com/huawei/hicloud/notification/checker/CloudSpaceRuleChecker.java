package com.huawei.hicloud.notification.checker;

import android.os.Bundle;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import hu.C10343b;

/* loaded from: classes6.dex */
public class CloudSpaceRuleChecker extends BaseRuleChecker {
    private NotificationConfig mNoticeObject;

    @Override // com.huawei.hicloud.notification.checker.BaseRuleChecker
    public boolean check(String str) {
        return CloudSpaceNotifyUtil.getInstance().checkNotifyRule(this.mNoticeObject, 0L, false);
    }

    @Override // com.huawei.hicloud.notification.checker.BaseRuleChecker
    public void precheck(NotificationConfig notificationConfig) {
        this.mNoticeObject = notificationConfig;
        this.mPriority = notificationConfig.getHiCloudSpaceNotice().getPriority();
    }

    @Override // com.huawei.hicloud.notification.checker.BaseRuleChecker
    public boolean check(Bundle bundle) {
        C10343b c10343b = new C10343b(bundle);
        return CloudSpaceNotifyUtil.getInstance().checkNotifyRule(this.mNoticeObject, c10343b.m63688j("needSpace"), c10343b.m63681c("isFromAlbum"));
    }
}
