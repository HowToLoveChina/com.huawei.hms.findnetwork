package com.huawei.hicloud.notification.manager;

import android.text.TextUtils;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.log.NotifyLogger;

/* loaded from: classes6.dex */
public class LocalMsgProcessor {
    private static final String TAG = "LocalMsgProcessor";

    private MessageCenterMsgObj buildTxtMsgObj(String str, String str2, String str3, long j10) {
        MessageCenterMsgObj messageCenterMsgObj = new MessageCenterMsgObj();
        messageCenterMsgObj.setUniqueId(str);
        messageCenterMsgObj.setMsgType("txtMsg");
        messageCenterMsgObj.setTitleText(str2);
        messageCenterMsgObj.setMainText(str3);
        messageCenterMsgObj.setCategory("local");
        messageCenterMsgObj.setNeedShowBadge(1);
        messageCenterMsgObj.setNotifyTime(j10);
        return messageCenterMsgObj;
    }

    public void deleteLocalTextMessage(String str) {
        NotifyLogger.m29915i(TAG, "deleteLocalTextMessage, start");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MessageCenterManager.getInstance().deleteMessageCenterDataById(str);
    }

    public void processLocalTextMessage(String str, String str2, String str3, long j10) {
        NotifyLogger.m29915i(TAG, "processLocalTextMessage, start");
        MessageCenterManager.getInstance().insertMessageCenterData(buildTxtMsgObj(str, str2, str3, j10));
    }
}
