package com.huawei.hicloud.notification.checker;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;

/* loaded from: classes6.dex */
public class FullFreqChecker implements BaseFrequecyLevelChecker {
    private static final String TAG = "FullFreqChecker";

    @Override // com.huawei.hicloud.notification.checker.BaseFrequecyLevelChecker
    public boolean check(Object[] objArr) {
        NotifyLogger.m29915i(TAG, "check");
        if (NoticeFreqControlManager.getInstance().canShowNotice()) {
            return true;
        }
        String str = (String) objArr[2];
        NotifyLogger.m29916w(TAG, "freq control check fail, notice type: " + str);
        NoticeFreqControlManager.getInstance().reportFreqControlled(str);
        return false;
    }

    @Override // com.huawei.hicloud.notification.checker.BaseFrequecyLevelChecker
    public int getPriority() {
        return 3;
    }
}
