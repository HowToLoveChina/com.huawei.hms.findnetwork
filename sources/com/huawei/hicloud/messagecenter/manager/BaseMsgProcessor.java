package com.huawei.hicloud.messagecenter.manager;

import android.text.TextUtils;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import gp.C10028c;
import p459lp.C11327e;

/* loaded from: classes6.dex */
public abstract class BaseMsgProcessor {
    private static final String TAG = "BaseMsgProcessor";

    public void checkConfigUpdate(String str, String str2) {
        NotifyLogger.m29915i(TAG, "check need update config, config point is " + str);
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29915i(TAG, "configPoint is null, no need update");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            NotifyLogger.m29915i(TAG, "configPoint is null, no need update");
            return;
        }
        if (str2.equals(C11327e.m68061d(str))) {
            NotifyLogger.m29915i(TAG, "etag equal, no need update");
        } else {
            HiCloudAllOMConfigManager.getInstance().queryConfigSync(str);
        }
        NotifyLogger.m29915i(TAG, "check need update config end, config point is " + str);
    }

    public boolean checkDisturbStatus(NotifyWay[] notifyWayArr) {
        for (NotifyWay notifyWay : notifyWayArr) {
            if (notifyWay != null) {
                String name = notifyWay.getName();
                if (!TextUtils.isEmpty(name) && "message".equals(name)) {
                    return MessageCenterManager.getInstance().getNoDisturbStatus();
                }
            }
        }
        return false;
    }

    public boolean checkExtendFuncSwitch() {
        boolean zM62413x = C10028c.m62182c0().m62413x();
        NotifyLogger.m29915i(TAG, "checkExtendFuncSwitch, extendFuncSwitch: " + zM62413x);
        return zM62413x;
    }

    public boolean checkNotifyTypeAllowList(ClientMessageBody clientMessageBody) {
        return true;
    }

    public void checkPreCondition(ClientMessageBody clientMessageBody) {
    }

    public abstract boolean isMsgValid(ClientMessageBody clientMessageBody);

    public boolean isNotifyTypeCustPass(ClientMessageBody clientMessageBody) {
        return true;
    }

    public boolean messageContainsNotify(ClientMessageBody clientMessageBody) {
        NotifyWay[] notifyWays = clientMessageBody.getNotifyWays();
        if (notifyWays == null || notifyWays.length == 0) {
            NotifyLogger.m29914e(TAG, "messageContainsNotify, no notify way");
            return false;
        }
        for (NotifyWay notifyWay : notifyWays) {
            if (notifyWay != null) {
                String name = notifyWay.getName();
                if (!TextUtils.isEmpty(name) && "notification_bar".equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void process(com.huawei.hicloud.messagecenter.bean.ClientMessageBody r15) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor.process(com.huawei.hicloud.messagecenter.bean.ClientMessageBody):void");
    }

    public abstract void processBannerNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public abstract void processDeskPopup(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public abstract void processH5Dialog(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public abstract void processImgMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public abstract void processMenuNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public void processMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        String msgType;
        msgType = notifyWay.getMsgType();
        msgType.hashCode();
        switch (msgType) {
            case "imgMsg":
                processImgMessage(clientMessageBody, str, notifyWay);
                break;
            case "txtMsg":
                processTextMessage(clientMessageBody, str, notifyWay);
                break;
            case "richMsg":
                processRichMessage(clientMessageBody, str, notifyWay);
                break;
            default:
                NotifyLogger.m29914e(TAG, "unknown msg type: " + msgType);
                break;
        }
    }

    public abstract void processNotification(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public abstract void processRichMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public abstract void processTextMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay);

    public abstract void sendNotification(NotifyNeedData notifyNeedData, ClientMessageBody clientMessageBody);
}
