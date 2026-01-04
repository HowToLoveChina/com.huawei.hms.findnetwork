package com.huawei.hicloud.notification.checker;

import com.huawei.hicloud.notification.bean.FreqControlBean;
import com.huawei.hicloud.notification.bean.FrequencyItem;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;

/* loaded from: classes6.dex */
public class RemindMethodChecker implements BaseFrequecyLevelChecker {
    private static final String TAG = "RemindMethodChecker";

    @Override // com.huawei.hicloud.notification.checker.BaseFrequecyLevelChecker
    public boolean check(Object[] objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[2];
        NotifyLogger.m29915i(TAG, "checkLevelFreqList checker remindMethod=" + str + ", senceId=" + str2);
        FreqControlBean matchedFreqControlBean = NoticeFreqControlManager.getInstance().getMatchedFreqControlBean();
        if (matchedFreqControlBean == null) {
            NotifyLogger.m29915i(TAG, "controlBean null");
            return true;
        }
        FrequencyItem frequencyItem = LevelFrequencyController.getInstance().getFrequencyItem("way", str, matchedFreqControlBean.getFrequencyItemList());
        if (frequencyItem == null) {
            NotifyLogger.m29915i(TAG, "items null");
            return true;
        }
        boolean zCheckLevelFreqList = NoticeFreqControlManager.getInstance().checkLevelFreqList(frequencyItem.getFrequencyList(), "way", str);
        LevelFrequencyController.getInstance().report(matchedFreqControlBean, frequencyItem, str2, String.valueOf(zCheckLevelFreqList));
        return zCheckLevelFreqList;
    }

    @Override // com.huawei.hicloud.notification.checker.BaseFrequecyLevelChecker
    public int getPriority() {
        return 2;
    }
}
