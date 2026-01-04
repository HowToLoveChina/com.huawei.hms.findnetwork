package com.huawei.hicloud.messagecenter.constant;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class MessageAllowListManager {
    private static final HashSet<String> OPERATION_TYPE_ALLOW_LIST = new HashSet<String>() { // from class: com.huawei.hicloud.messagecenter.constant.MessageAllowListManager.1
        {
            add("package_will_expire");
            add("package_will_expire_new");
            add("package_already_expire");
            add("first_month_free");
            add("custom_marketing");
            add("beforeDeductFee");
            add("afterDeductFee");
            add("download_app");
            add("data_download");
            add("after_switching_notify");
            add("task_system_will_reset_score");
            add("SilenceDeviceCBSClear");
            add("DataPeriod1");
            add("DataPeriod2");
            add("DataRollback");
            add("GalleryFirstSynchronized");
            add("GallerySynchronized");
            add("backupRecordWillExpired");
        }
    };
    private static final HashSet<String> WEB_TYPE_ALLOW_LIST = new HashSet<String>() { // from class: com.huawei.hicloud.messagecenter.constant.MessageAllowListManager.2
        {
            add("package_will_expire");
            add("package_will_expire_new");
            add("package_already_expire");
            add("data_download");
            add(NotifyConstants.SPACE_AVAILABLE_DAYS_V3);
            add("custom_marketing");
        }
    };

    public static Set<String> getOperTypeAllowList() {
        return Collections.unmodifiableSet(OPERATION_TYPE_ALLOW_LIST);
    }

    public static Set<String> getWebTypeAllowList() {
        return Collections.unmodifiableSet(WEB_TYPE_ALLOW_LIST);
    }
}
