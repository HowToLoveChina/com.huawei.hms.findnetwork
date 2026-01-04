package com.huawei.hicloud.notification.checker;

import com.huawei.hicloud.notification.bean.FreqControlBean;
import com.huawei.hicloud.notification.bean.FrequencyItem;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class RemindPurposeChecker implements BaseFrequecyLevelChecker {
    private static final String TAG = "RemindPurposeChecker";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hicloud.notification.checker.BaseFrequecyLevelChecker
    public boolean check(Object[] objArr) {
        boolean z10;
        FreqControlBean freqControlBean;
        FrequencyItem frequencyItem;
        NotifyLogger.m29915i(TAG, "check");
        List list = (List) objArr[1];
        String str = (String) objArr[2];
        FrequencyItem frequencyItem2 = null;
        if (list != null) {
            Iterator it = list.iterator();
            FrequencyItem frequencyItem3 = null;
            while (true) {
                if (!it.hasNext()) {
                    z10 = true;
                    frequencyItem = frequencyItem2;
                    break;
                }
                String str2 = (String) it.next();
                NotifyLogger.m29915i(TAG, "checkLevelFreqList checker remindPurposes=" + str2 + ", senceId=" + str);
                FreqControlBean matchedFreqControlBean = NoticeFreqControlManager.getInstance().getMatchedFreqControlBean();
                if (matchedFreqControlBean == 0) {
                    NotifyLogger.m29915i(TAG, "controlBean null");
                    z10 = true;
                    frequencyItem = matchedFreqControlBean;
                    break;
                }
                frequencyItem3 = LevelFrequencyController.getInstance().getFrequencyItem("purpose", str2, matchedFreqControlBean.getFrequencyItemList());
                if (frequencyItem3 == null) {
                    NotifyLogger.m29915i(TAG, "items null");
                } else {
                    if (!NoticeFreqControlManager.getInstance().checkLevelFreqList(frequencyItem3.getFrequencyList(), "purpose", str2)) {
                        z10 = false;
                        LevelFrequencyController.getInstance().report(matchedFreqControlBean, frequencyItem3, str, String.valueOf(false));
                        frequencyItem = matchedFreqControlBean;
                        break;
                    }
                }
                frequencyItem2 = matchedFreqControlBean;
            }
            frequencyItem2 = frequencyItem3;
            freqControlBean = frequencyItem;
        } else {
            z10 = true;
            freqControlBean = 0;
        }
        if (z10 && frequencyItem2 != null) {
            LevelFrequencyController.getInstance().report(freqControlBean, frequencyItem2, str, String.valueOf(true));
        }
        return z10;
    }

    @Override // com.huawei.hicloud.notification.checker.BaseFrequecyLevelChecker
    public int getPriority() {
        return 1;
    }
}
