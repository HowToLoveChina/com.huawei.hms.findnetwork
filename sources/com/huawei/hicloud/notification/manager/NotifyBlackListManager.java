package com.huawei.hicloud.notification.manager;

import android.content.Context;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.HiCLoudNotifyBlackListConfig;
import com.huawei.hicloud.notification.p106db.bean.NotifyBlackList;
import com.huawei.hicloud.notification.p106db.bean.NotifyBlackListConfig;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p618rm.C12540b1;
import p684un.C13227f;
import p815ym.AbstractC14026a;

/* loaded from: classes6.dex */
public class NotifyBlackListManager {
    private static final Object LOCK = new Object();
    private static final HashMap<Integer, String> OPERATION_TYPE_BLACK_LIST_ACTION = new HashMap<Integer, String>() { // from class: com.huawei.hicloud.notification.manager.NotifyBlackListManager.1
        public C49341() {
            put(0, "0");
            put(2, "1");
            put(1, "2");
            put(5, "3");
            put(7, "4");
            put(9, "5");
        }
    };
    private static final String TAG = "NotifyBlackListManager";
    private static NotifyBlackListManager instance;

    /* renamed from: com.huawei.hicloud.notification.manager.NotifyBlackListManager$1 */
    public class C49341 extends HashMap<Integer, String> {
        public C49341() {
            put(0, "0");
            put(2, "1");
            put(1, "2");
            put(5, "3");
            put(7, "4");
            put(9, "5");
        }
    }

    private NotifyBlackListManager() {
    }

    public static NotifyBlackListManager getInstance() {
        NotifyBlackListManager notifyBlackListManager;
        synchronized (LOCK) {
            try {
                if (instance == null) {
                    instance = new NotifyBlackListManager();
                }
                notifyBlackListManager = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return notifyBlackListManager;
    }

    private void reportBlackListDialogType(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(NotifyConstants.NotificationBIReport.BLACK_INHIBITED_DIALOG_TYPE, str);
        linkedHashMap.put(NotifyConstants.NotificationBIReport.BLACK_INHIBITED_USER_TAG, str2);
        C13227f.m79492i1().m79567R(NotifyConstants.NotificationBIReport.BI_OM_BLACK_INHIBITED, linkedHashMap);
        UBAAnalyze.m29947H("PVC", NotifyConstants.NotificationBIReport.BI_OM_BLACK_INHIBITED, linkedHashMap);
    }

    public void clearBackListConfig() {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "clearBackListConfig context is null.");
                return;
            }
            File file = new File(contextM1377a.getFilesDir() + "/HiCloudNotifyBlackList.json");
            if (!file.exists()) {
                NotifyLogger.m29915i(TAG, "clearBackListConfig file not exist");
            } else {
                if (file.delete()) {
                    return;
                }
                NotifyLogger.m29914e(TAG, "clearBackListConfig deleteResult is false");
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearBackListConfig exception:" + e10.toString());
        }
    }

    public HiCLoudNotifyBlackListConfig getConfigRaw(String str) {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            return (HiCLoudNotifyBlackListConfig) C12540b1.m75483a(C0209d.m1290o2(new FileInputStream(new File(C0213f.m1377a().getFilesDir() + str))), HiCLoudNotifyBlackListConfig.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "cloud config file not exist, msg:" + e10.getMessage());
            return null;
        }
    }

    public HiCLoudNotifyBlackListConfig getNotifyBackListConfigLocal() {
        return getConfigRaw("/HiCloudNotifyBlackList.json");
    }

    public boolean isInBlackDialogList(HiCLoudNotifyBlackListConfig hiCLoudNotifyBlackListConfig, int i10, List<PortraitAndGrade.UserTag> list) {
        if (hiCLoudNotifyBlackListConfig == null || AbstractC14026a.m84159a(list)) {
            NotifyLogger.m29916w(TAG, "isInBlackDialogList, cLoudNotifyBlackListConfig or userTagList is null!");
            return false;
        }
        NotifyBlackListConfig configurations = hiCLoudNotifyBlackListConfig.getConfigurations();
        if (configurations == null || configurations.getNotifyBlackList() == null) {
            NotifyLogger.m29916w(TAG, "isInBlackDialogList, notifyBlackListConfig is null!");
            return false;
        }
        List<NotifyBlackList> notifyBlackList = configurations.getNotifyBlackList();
        if (notifyBlackList == null) {
            NotifyLogger.m29916w(TAG, "isInBlackDialogList, notifyBlackList is null!");
            return false;
        }
        for (NotifyBlackList notifyBlackList2 : notifyBlackList) {
            if (notifyBlackList2 != null) {
                List<String> msgTypes = notifyBlackList2.getMsgTypes();
                List<String> userGroupIds = notifyBlackList2.getUserGroupIds();
                if (AbstractC14026a.m84159a(msgTypes) || AbstractC14026a.m84159a(userGroupIds)) {
                    NotifyLogger.m29916w(TAG, "isInBlackDialogList, blackList or userGroupIds is null!");
                } else if (msgTypes.contains(OPERATION_TYPE_BLACK_LIST_ACTION.get(Integer.valueOf(i10)))) {
                    NotifyLogger.m29916w(TAG, "isInBlackDialogList, in dialogType is: " + i10);
                    for (String str : userGroupIds) {
                        Iterator<PortraitAndGrade.UserTag> it = list.iterator();
                        while (it.hasNext()) {
                            if (it.next().getUserGroupExtID().contains(str)) {
                                NotifyLogger.m29913d(TAG, "isInBlackDialogList, userTag in blackList");
                                reportBlackListDialogType(OPERATION_TYPE_BLACK_LIST_ACTION.get(Integer.valueOf(i10)), str);
                                return true;
                            }
                        }
                    }
                } else {
                    NotifyLogger.m29916w(TAG, "isInBlackDialogList, dialogType not in blackList");
                }
            }
        }
        return false;
    }
}
