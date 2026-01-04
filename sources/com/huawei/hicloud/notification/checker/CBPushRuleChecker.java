package com.huawei.hicloud.notification.checker;

import android.database.SQLException;
import android.os.Bundle;
import com.huawei.hicloud.notification.CloudSpaceNotifyHelper;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.config.CBPushConfigObject;
import com.huawei.hicloud.notification.config.CBPushNotificationObject;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.data.AppDataCollector;
import com.huawei.hicloud.notification.data.BaseDataCollector;
import com.huawei.hicloud.notification.data.ContactDataCollector;
import com.huawei.hicloud.notification.data.MediaDataCollector;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import com.huawei.hicloud.notification.p106db.operator.SNTimeOperator;
import p742wj.C13612b;

/* loaded from: classes6.dex */
public class CBPushRuleChecker extends BaseRuleChecker {
    private static final String TAG = "NotificationRuleChecker";
    private BaseDataCollector mAppCollector;
    private NotificationConfigManager mConfigManager;
    private BaseDataCollector mContactCollector;
    private BaseDataCollector mMediaCollector;
    private NotificationConfig mNoticeObject;

    public CBPushRuleChecker(NotificationConfigManager notificationConfigManager) {
        this.mConfigManager = notificationConfigManager;
    }

    private boolean checkRule(String str, CBPushConfigObject cBPushConfigObject) throws SQLException {
        NotifyLogger.m29915i(TAG, "checkRule");
        boolean zCheckRuleFrequency = false;
        if (!checkLoginState(cBPushConfigObject)) {
            NotifyLogger.m29915i(TAG, "login state not consistent");
            return false;
        }
        if (!str.equals(cBPushConfigObject.getNoticeType())) {
            NotifyLogger.m29915i(TAG, "notice_type not consistent, invoke_sence=" + str + ", rule_sence=" + cBPushConfigObject.getNoticeType());
            return false;
        }
        if (cBPushConfigObject.getDataType().equals(HNConstants.DataType.MEDIA)) {
            NotifyLogger.m29915i(TAG, "rule data_type=MEDIA");
            if (this.mMediaCollector == null) {
                this.mMediaCollector = new MediaDataCollector(null);
            }
            zCheckRuleFrequency = cBPushConfigObject.check(this.mMediaCollector);
        } else if (cBPushConfigObject.getDataType().equals("application")) {
            NotifyLogger.m29915i(TAG, "rule data_type=APP");
            if (this.mAppCollector == null) {
                this.mAppCollector = new AppDataCollector();
            }
            zCheckRuleFrequency = cBPushConfigObject.check(this.mAppCollector);
        } else if (cBPushConfigObject.getDataType().equals(HNConstants.DataType.CONTACT)) {
            NotifyLogger.m29915i(TAG, "rule data_type=CONTACT");
            if (this.mContactCollector == null) {
                this.mContactCollector = new ContactDataCollector();
            }
            zCheckRuleFrequency = cBPushConfigObject.check(this.mContactCollector);
        } else if (cBPushConfigObject.getDataType().equals(HNConstants.DataType.f22634NA)) {
            NotifyLogger.m29915i(TAG, "rule data_type=NA");
            if (!C13612b.m81829B().isLogin()) {
                zCheckRuleFrequency = cBPushConfigObject.checkRuleFrequency();
            }
        }
        if (zCheckRuleFrequency) {
            NotifyLogger.m29915i(TAG, "rule check success");
            HiCloudNotification.getInstance().sendNotify(cBPushConfigObject);
            this.mConfigManager.recordFullFrequency();
            this.mConfigManager.recordRuleFrequency(cBPushConfigObject.getNoticeType(), cBPushConfigObject.getDataType());
        }
        return zCheckRuleFrequency;
    }

    @Override // com.huawei.hicloud.notification.checker.BaseRuleChecker
    public boolean check(String str) {
        NotifyLogger.m29915i(TAG, "check");
        NotificationConfig notificationConfig = this.mNoticeObject;
        CBPushNotificationObject hiCloudPullNewNotice = notificationConfig != null ? notificationConfig.getHiCloudPullNewNotice() : null;
        if (hiCloudPullNewNotice == null) {
            NotifyLogger.m29914e(TAG, "cbp object null");
            return false;
        }
        boolean z10 = false;
        for (CBPushConfigObject cBPushConfigObject : hiCloudPullNewNotice.getNotification()) {
            NotifyLogger.m29915i(TAG, "check n_type=" + cBPushConfigObject.getNoticeType() + ", d_type=" + cBPushConfigObject.getDataType());
            if (checkFullFrequency(this.mNoticeObject)) {
                NotifyLogger.m29915i(TAG, "full frequency ok");
                if (checkRule(str, cBPushConfigObject)) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public boolean checkFullFrequency(NotificationConfig notificationConfig) {
        NotifyLogger.m29915i(TAG, "checkFullFrequency");
        return !CloudSpaceNotifyHelper.isTooFrequent(notificationConfig.getFrequency(), new SNTimeOperator(), HNUtil.getNowTime());
    }

    public boolean checkLoginState(CBPushConfigObject cBPushConfigObject) {
        String loginState = cBPushConfigObject.getLoginState();
        if (C13612b.m81829B().isLogin()) {
            NotifyLogger.m29915i(TAG, "hicloud is login, rule is:" + loginState);
            return loginState.equals("login");
        }
        NotifyLogger.m29915i(TAG, "hicloud is logout, rule is:" + loginState);
        return loginState.equals("logout");
    }

    public void checkRules(NotificationConfig notificationConfig) {
    }

    @Override // com.huawei.hicloud.notification.checker.BaseRuleChecker
    public void precheck(NotificationConfig notificationConfig) {
        this.mNoticeObject = notificationConfig;
        CBPushNotificationObject hiCloudPullNewNotice = notificationConfig.getHiCloudPullNewNotice();
        if (hiCloudPullNewNotice == null) {
            return;
        }
        this.mPriority = hiCloudPullNewNotice.getPriority();
    }

    public void saveFrequency() {
    }

    @Override // com.huawei.hicloud.notification.checker.BaseRuleChecker
    public boolean check(Bundle bundle) {
        String string;
        if (bundle != null) {
            string = bundle.getString("type");
        } else {
            string = "";
        }
        return check(string);
    }
}
