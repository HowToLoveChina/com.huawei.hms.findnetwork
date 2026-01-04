package com.huawei.android.hicloud.cloudbackup.process.util;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.BasicDataRestoreUtil;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class BasicDataRestoreUtil {
    private static final Map<String, Integer> APP_PRIORITY_MAP = new HashMap<String, Integer>() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.BasicDataRestoreUtil.1
        {
            put("setting", 20);
            put("com.ohos.settingsdata", 20);
            put("HWlanucher", 19);
            put("com.ohos.sceneboard", 19);
            put("thirdApp", 18);
            put("appList", 18);
            put(HNConstants.DataType.CONTACT, 17);
            put("oh_contact", 17);
            put("Memo", 16);
            put("com.huawei.hmos.notepad", 16);
            put("calllog", 15);
            put("oh_calllog", 15);
            put("weather", 14);
            put("com.huawei.hmsapp.totemweather", 14);
            put(NavigationUtils.SMS_SCHEMA_PREF, 13);
            put("com.ohos.mms", 13);
            put("clock", 12);
            put("com.huawei.hmos.clock", 12);
            put("alarm", 11);
            put("harassment", 10);
            put("com.huawei.hmos.spamshield", 10);
            put("soundrecorder", 9);
            put("com.huawei.hmos.soundrecorder", 9);
            put("wallpaper", 8);
            put("phoneManager", 7);
        }
    };

    public static class BasicItemInfo {
        private String appId;
        private String appName;

        public BasicItemInfo(String str, String str2) {
            this.appId = str;
            this.appName = str2;
        }

        public String getAppId() {
            return this.appId;
        }

        public String getAppName() {
            return this.appName;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setAppName(String str) {
            this.appName = str;
        }
    }

    public static ArrayList<BasicItemInfo> getBasicPriorityApps(CloudRestoreItem cloudRestoreItem, final boolean z10) {
        final ArrayList<BasicItemInfo> arrayList = new ArrayList<>();
        if (cloudRestoreItem != null && cloudRestoreItem.m29202r() != null) {
            cloudRestoreItem.m29202r().forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.m
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    BasicDataRestoreUtil.lambda$getBasicPriorityApps$0(z10, arrayList, (CloudRestoreItem) obj);
                }
            });
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.n
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BasicDataRestoreUtil.lambda$getBasicPriorityApps$1((BasicDataRestoreUtil.BasicItemInfo) obj, (BasicDataRestoreUtil.BasicItemInfo) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBasicPriorityApps$0(boolean z10, ArrayList arrayList, CloudRestoreItem cloudRestoreItem) {
        boolean z11 = false;
        if (!z10 ? cloudRestoreItem.getAction() == 2 : cloudRestoreItem.getAction() != 2) {
            z11 = true;
        }
        if (cloudRestoreItem.isCompatible() && z11) {
            arrayList.add(new BasicItemInfo(cloudRestoreItem.getAppId(), cloudRestoreItem.getAppName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getBasicPriorityApps$1(BasicItemInfo basicItemInfo, BasicItemInfo basicItemInfo2) {
        if (TextUtils.isEmpty(basicItemInfo.getAppId()) || TextUtils.isEmpty(basicItemInfo2.getAppId())) {
            return -1;
        }
        Map<String, Integer> map = APP_PRIORITY_MAP;
        return (map.get(basicItemInfo2.getAppId()) != null ? map.get(basicItemInfo2.getAppId()).intValue() : 1) - (map.get(basicItemInfo.getAppId()) == null ? 1 : map.get(basicItemInfo.getAppId()).intValue());
    }
}
