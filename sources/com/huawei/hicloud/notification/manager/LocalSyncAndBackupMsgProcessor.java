package com.huawei.hicloud.notification.manager;

import android.text.TextUtils;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.log.NotifyLogger;

/* loaded from: classes6.dex */
public class LocalSyncAndBackupMsgProcessor {
    private static final String TAG = "LocalSyncAndBackupMsgProcessor";

    private MessageCenterMsgObj buildLocalTxtMsgObj(String str, String str2, String str3, long j10, String str4) {
        MessageCenterMsgObj messageCenterMsgObj = new MessageCenterMsgObj();
        messageCenterMsgObj.setUniqueId(str);
        messageCenterMsgObj.setMsgType("txtMsg");
        messageCenterMsgObj.setTitleText(str2);
        messageCenterMsgObj.setMainText(str3);
        messageCenterMsgObj.setCategory("local_sync_backup");
        messageCenterMsgObj.setNeedShowBadge(1);
        messageCenterMsgObj.setNotifyTime(j10);
        messageCenterMsgObj.setIntroductionH5Url(str4);
        return messageCenterMsgObj;
    }

    public void deleteLocalTextMessage(String str) {
        NotifyLogger.m29915i(TAG, "LocalSyncAndBackupMsgProcessor deleteLocalTextMessage");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MessageCenterManager.getInstance().deleteMessageCenterDataById(str);
    }

    public void processLocalTextMessage(String str, String str2, String str3, long j10, String str4) {
        NotifyLogger.m29915i(TAG, "LocalSyncAndBackupMsgProcessor, start");
        MessageCenterManager.getInstance().insertMessageCenterData(buildLocalTxtMsgObj(str, str2, str3, j10, str4));
    }
}
