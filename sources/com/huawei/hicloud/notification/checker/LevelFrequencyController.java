package com.huawei.hicloud.notification.checker;

import android.text.TextUtils;
import com.huawei.hicloud.notification.bean.FreqControlBean;
import com.huawei.hicloud.notification.bean.FrequencyItem;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import p684un.C13227f;

/* loaded from: classes6.dex */
public class LevelFrequencyController {
    private static final String TAG = "FrequencyController";
    private TreeMap<Integer, BaseFrequecyLevelChecker> checkerList;

    public static class Holder {
        private static final LevelFrequencyController INSTANCE = new LevelFrequencyController();

        private Holder() {
        }
    }

    public static LevelFrequencyController getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$0(Integer num, Integer num2) {
        return num.intValue() - num2.intValue();
    }

    public void addChecker(BaseFrequecyLevelChecker baseFrequecyLevelChecker) {
        this.checkerList.put(Integer.valueOf(baseFrequecyLevelChecker.getPriority()), baseFrequecyLevelChecker);
    }

    public boolean check(Object[] objArr) {
        Iterator<BaseFrequecyLevelChecker> it = this.checkerList.values().iterator();
        while (it.hasNext()) {
            if (!it.next().check(objArr)) {
                return false;
            }
        }
        return true;
    }

    public FrequencyItem getFrequencyItem(String str, String str2, FrequencyItem[] frequencyItemArr) {
        if (frequencyItemArr == null) {
            return null;
        }
        for (FrequencyItem frequencyItem : frequencyItemArr) {
            if (frequencyItem.getItemType().equals(str) && ((frequencyItem.getItemType().equals("way") && frequencyItem.getWay() != null && frequencyItem.getWay().equals(str2)) || (frequencyItem.getItemType().equals("purpose") && frequencyItem.getPurpose() != null && frequencyItem.getPurpose().equals(str2)))) {
                return frequencyItem;
            }
        }
        return null;
    }

    public void initChecker() {
        addChecker(new FullFreqChecker());
        addChecker(new RemindMethodChecker());
        addChecker(new RemindPurposeChecker());
    }

    public void report(FreqControlBean freqControlBean, FrequencyItem frequencyItem, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (freqControlBean != null) {
            linkedHashMap.put(NotifyConstants.NotificationReport.EVENT_NAME_LEVEL_CONTROL_POLICY_ID, freqControlBean.getId());
            linkedHashMap.put(NotifyConstants.NotificationReport.EVENT_NAME_LEVEL_CONTROL_POLICY_NAME, freqControlBean.getName());
        }
        if (frequencyItem != null) {
            linkedHashMap.put(NotifyConstants.NotificationReport.EVENT_NAME_LEVEL_CONTROL_TYPE, frequencyItem.getItemType());
            linkedHashMap.put(NotifyConstants.NotificationReport.EVENT_NAME_LEVEL_CONTROL_TYPE_VALUE, TextUtils.isEmpty(frequencyItem.getPurpose()) ? frequencyItem.getWay() : frequencyItem.getPurpose());
        }
        linkedHashMap.put(NotifyConstants.NotificationReport.EVENT_NAME_LEVEL_CONTROL_SCENES, str);
        linkedHashMap.put(NotifyConstants.NotificationReport.EVENT_NAME_LEVEL_CONTROL_RESULT, str2);
        NoticeFreqControlManager.getInstance().reportOMEvent(NotifyConstants.NotificationReport.OPERATION_LEVEL_FREQ_CONTROL, linkedHashMap);
        C13227f.m79492i1().m79591l0(NotifyConstants.NotificationReport.OPERATION_LEVEL_FREQ_CONTROL, linkedHashMap);
        UBAAnalyze.m29947H("PVC", NotifyConstants.NotificationReport.OPERATION_LEVEL_FREQ_CONTROL, linkedHashMap);
    }

    private LevelFrequencyController() {
        this.checkerList = new TreeMap<>(new Comparator() { // from class: com.huawei.hicloud.notification.checker.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LevelFrequencyController.lambda$new$0((Integer) obj, (Integer) obj2);
            }
        });
    }
}
