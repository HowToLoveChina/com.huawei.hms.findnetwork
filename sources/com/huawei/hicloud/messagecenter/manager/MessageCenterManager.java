package com.huawei.hicloud.messagecenter.manager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.bean.NotifyExtend;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj;
import com.huawei.hicloud.messagecenter.bean.H5WindowMsgObj;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.operator.MessageCenterDbOperator;
import com.huawei.hicloud.messagecenter.operator.MessageDeskPopupDbOperator;
import com.huawei.hicloud.messagecenter.operator.MessageH5DbOperator;
import com.huawei.hicloud.notification.bean.FreqControlBean;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.UnReadNumManager;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.request.notify.NotifyService;
import com.huawei.hicloud.request.notify.bean.NotifyResult;
import gp.C10028c;
import java.util.HashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9729b;
import p429kk.C11058a;
import p429kk.C11060c;
import p664u0.C13108a;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class MessageCenterManager {
    private static final String TAG = "MessageCenterManager";
    public static final int UNKNOW_MESSAGE_NOTIFY = -1;

    public static class Holder {
        private static final MessageCenterManager INSTANCE = new MessageCenterManager();

        private Holder() {
        }
    }

    public /* synthetic */ MessageCenterManager(C49011 c49011) {
        this();
    }

    private void cancelProductMsgNotification(List<MessageCenterMsgObj> list) {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "cancelProductMsgNotification but messages is empty");
            return;
        }
        MessageNotificationManager messageNotificationManager = new MessageNotificationManager(C0213f.m1377a());
        for (MessageCenterMsgObj messageCenterMsgObj : list) {
            if (messageCenterMsgObj != null) {
                int notifyId = messageCenterMsgObj.getNotifyId();
                if (notifyId == 0) {
                    NotifyLogger.m29914e(TAG, "cancelProductMsgNotification notifyId is default 0");
                    return;
                }
                NotifyLogger.m29915i(TAG, "cancelProductMsgNotification, try to clear notify, id: " + notifyId);
                messageNotificationManager.cancelNotify(notifyId);
            }
        }
    }

    public static MessageCenterManager getInstance() {
        return Holder.INSTANCE;
    }

    private NotifyExtend getNotifyExtend(BaseNotifyBean baseNotifyBean, String str) {
        NotifyExtend notifyExtend = new NotifyExtend();
        notifyExtend.setAccountSetVer(getSettingsVersion());
        boolean z10 = NotifyConstants.SPACE_AVAILABLE_RATIO.equals(str) || NotifyConstants.SPACE_AVAILABLE_SIZE.equals(str) || NotifyConstants.SPACE_USED_SIZE.equals(str);
        if (baseNotifyBean instanceof SpaceNotification) {
            int spaceType = ((SpaceNotification) baseNotifyBean).getSpaceType();
            if (z10) {
                notifyExtend.setSpaceType(spaceType);
            }
        }
        if (baseNotifyBean instanceof NotificationWithActivity) {
            int spaceType2 = ((NotificationWithActivity) baseNotifyBean).getSpaceType();
            if (z10) {
                notifyExtend.setSpaceType(spaceType2);
            }
        }
        return notifyExtend;
    }

    private static String getSettingsVersion() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "getPackageVersion context is null");
            return "";
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        if (packageManager == null) {
            NotifyLogger.m29914e(TAG, "getPackageVersion packageManager is null");
            return "";
        }
        try {
            return String.valueOf(packageManager.getPackageInfo("com.android.settings", 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            NotifyLogger.m29914e(TAG, "getPackageVersion PackageManager.NameNotFoundException");
            return "";
        }
    }

    private void notifyMessageNumChanged() {
        NotifyLogger.m29915i(TAG, "notifyMessageNumChanged");
        sendLocalBroadcast("com.huawei.hicloud.action.ACTION_MESSAGE_NUM_CHANGED");
        UnReadNumManager.getInstance().refreshLauncherIconInTask();
    }

    private void notifyMessageStatusChanged() {
        sendLocalBroadcast("com.huawei.hicloud.action.ACTION_MESSAGE_STATUS_CHANGED");
        UnReadNumManager.getInstance().refreshLauncherIconInTask();
    }

    private void reportInvokeNotifyEvent(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("resource_id", str);
            map.put(NotifyConstants.NotificationReport.KEY_NOTICE_TYPE, str2);
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07008"), "07008", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(NotifyConstants.NotificationReport.OPERATION_NAME_INVOKE_NOTIFY_EVENT);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportOMEvent exception:" + e10.toString());
        }
    }

    private void sendLocalBroadcast(String str) {
        C13108a c13108aM78878b = C13108a.m78878b(C0213f.m1377a());
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction(str);
        c13108aM78878b.m78881d(intent);
    }

    public void cancelCampaignMsgNotification() {
        new MessageNotificationManager(C0213f.m1377a()).cancelNotify(389);
    }

    public void cancelCampaignMsgTypeSixNotification() {
        new MessageNotificationManager(C0213f.m1377a()).cancelNotify(391);
    }

    public void cancelMarketingMsgNotification() {
        MessageNotificationManager messageNotificationManager = new MessageNotificationManager(C0213f.m1377a());
        messageNotificationManager.cancelNotify(768);
        messageNotificationManager.cancelNotify(769);
        messageNotificationManager.cancelNotify(770);
        messageNotificationManager.cancelNotify(771);
        messageNotificationManager.cancelNotify(772);
        messageNotificationManager.cancelNotify(773);
        messageNotificationManager.cancelNotify(774);
    }

    public void cancelMarketingMsgNotificationByAction(int i10) {
        int operateMsgNotifyIdByAction = getOperateMsgNotifyIdByAction(i10);
        if (operateMsgNotifyIdByAction == -1) {
            NotifyLogger.m29915i(TAG, "cancelMarketingMsgNotificationByAction action not support.");
        } else {
            new MessageNotificationManager(C0213f.m1377a()).cancelNotify(operateMsgNotifyIdByAction);
        }
    }

    public boolean checkIntentAvailable(Intent intent) {
        if (intent == null) {
            NotifyLogger.m29914e(TAG, "checkIntentAvailable, intent is null");
            return false;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return intent.resolveActivity(contextM1377a.getPackageManager()) != null;
        }
        NotifyLogger.m29914e(TAG, "checkIntentAvailable, context is null");
        return false;
    }

    public void clearAllMessages() {
        MessageCenterDbOperator messageCenterDbOperator = new MessageCenterDbOperator();
        List<MessageCenterMsgObj> listQueryProductMessage = messageCenterDbOperator.queryProductMessage();
        messageCenterDbOperator.clear();
        new MessageH5DbOperator().clear();
        new MessageDeskPopupDbOperator().clear();
        notifyMessageNumChanged();
        cancelProductMsgNotification(listQueryProductMessage);
        cancelCampaignMsgNotification();
        cancelCampaignMsgTypeSixNotification();
        cancelMarketingMsgNotification();
    }

    public void deleteMessageCenterDataById(String str) {
        new MessageCenterDbOperator().deleteMsgById(str);
        notifyMessageNumChanged();
    }

    public boolean featureSwitch() {
        return !C9729b.m60694a().m60696c("Common", "Notify");
    }

    public List<MessageCenterMsgObj> getAllMessages() {
        return new MessageCenterDbOperator().queryAllMessage();
    }

    public int getBadgeCount() {
        try {
            return new MessageCenterDbOperator().queryBadgeCount();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getBadgeCount exception, e: " + e10.toString());
            return 0;
        }
    }

    public List<H5WindowMsgObj> getH5WindowMsgList() throws SQLException {
        List<H5WindowMsgObj> listQueryUnReadWindows = new MessageH5DbOperator().queryUnReadWindows();
        if (listQueryUnReadWindows == null || listQueryUnReadWindows.isEmpty()) {
            return null;
        }
        return listQueryUnReadWindows;
    }

    public boolean getNoDisturbStatus() {
        return C10028c.m62182c0().m62185A0();
    }

    public int getOperateMsgNotifyIdByAction(int i10) {
        switch (i10) {
            case 0:
                return 768;
            case 1:
                return 769;
            case 2:
                return 770;
            case 3:
                return 771;
            case 4:
                return 772;
            case 5:
                return 774;
            case 6:
            case 15:
            case 16:
            case 17:
            case 20:
            case 21:
            default:
                return -1;
            case 7:
                return 773;
            case 8:
                return 776;
            case 9:
                return 785;
            case 10:
                return 784;
            case 11:
                return 786;
            case 12:
                return 790;
            case 13:
                return 791;
            case 14:
                return 792;
            case 18:
                return 789;
            case 19:
                return (int) System.currentTimeMillis();
            case 22:
                return 793;
            case 23:
                return 800;
        }
    }

    public void insertDeskPopupMsg(DeskPopupMsgObj deskPopupMsgObj) {
        try {
            new MessageDeskPopupDbOperator().insertDeskPopupMsg(deskPopupMsgObj);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "insertDeskPopupMsg exception, e: " + e10.toString());
        }
    }

    public void insertH5DialogMsg(H5WindowMsgObj h5WindowMsgObj) {
        try {
            new MessageH5DbOperator().insertH5WindowMsg(h5WindowMsgObj);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "insertH5DialogMsg exception, e: " + e10.toString());
        }
    }

    public void insertMessageCenterData(MessageCenterMsgObj messageCenterMsgObj) {
        try {
            new MessageCenterDbOperator().insertMessage(messageCenterMsgObj);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "insertMessageData exception, e: " + e10.toString());
        }
        notifyMessageNumChanged();
    }

    public boolean invokeEvent(FreqControlBean freqControlBean, String str, String str2, MsgUserData msgUserData, List<NotifyWay> list) throws NumberFormatException {
        try {
            if (freqControlBean == null) {
                NotifyLogger.m29914e(TAG, "notifyBean is null");
                return false;
            }
            if (msgUserData == null) {
                NotifyLogger.m29914e(TAG, "userData is null");
                return false;
            }
            int i10 = Integer.parseInt(freqControlBean.getId());
            String json = new Gson().toJson(msgUserData);
            NotifyExtend notifyExtend = new NotifyExtend();
            notifyExtend.setAccountSetVer(getSettingsVersion());
            return invokeEvent(str, str2, i10, null, "cloudbackup_failed_suppression", list, json, notifyExtend);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "invokeEvent exception, e: " + e10.toString());
            return false;
        }
    }

    public String isH5AlreadyRead(String str) {
        return new MessageH5DbOperator().isMsgAlreadyRead(str);
    }

    public void processNotifyClickEvent(Intent intent) {
        if (intent == null) {
            NotifyLogger.m29914e(TAG, "intent is null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("unique_id");
            if (TextUtils.isEmpty(stringExtra)) {
                NotifyLogger.m29914e(TAG, "no unique id");
            } else {
                MessageCenterReportUtil.reportNotifyClickEvent(intent);
                setMsgAsRead(stringExtra);
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "processNotifyClickEvent error:" + e10.getMessage());
        }
    }

    public void setAllMsgAsRead() {
        NotifyLogger.m29915i(TAG, "setAllMsgAsRead");
        MessageCenterDbOperator messageCenterDbOperator = new MessageCenterDbOperator();
        messageCenterDbOperator.setAllAlreadyRead();
        List<String> uniqueIdsByAlreadyRead = messageCenterDbOperator.getUniqueIdsByAlreadyRead("1");
        if (uniqueIdsByAlreadyRead != null && !uniqueIdsByAlreadyRead.isEmpty()) {
            new MessageH5DbOperator().batchSetAlreadyRead(uniqueIdsByAlreadyRead);
        }
        notifyMessageStatusChanged();
    }

    public void setH5AsRead(String str) {
        new MessageH5DbOperator().setAlreadyRead(str);
    }

    public void setMsgAsRead(String str) {
        new MessageCenterDbOperator().setAlreadyRead(str);
        setH5AsRead(str);
        notifyMessageStatusChanged();
    }

    public void setNoDisturbStatus(boolean z10) {
        C10028c.m62182c0().m62382q3(z10);
    }

    private MessageCenterManager() {
    }

    public boolean invokeEvent(BaseNotifyBean baseNotifyBean, String str, String str2, MsgUserData msgUserData) {
        try {
            if (baseNotifyBean == null) {
                NotifyLogger.m29914e(TAG, "notifyBean is null");
                return false;
            }
            if (msgUserData == null) {
                NotifyLogger.m29914e(TAG, "userData is null");
                return false;
            }
            int id2 = baseNotifyBean.getId();
            List<String> remindPurposes = baseNotifyBean.getRemindPurposes();
            List<NotifyWay> remindWays = baseNotifyBean.getRemindWays();
            String noticeType = baseNotifyBean.getNoticeType();
            String json = new Gson().toJson(msgUserData);
            NotifyExtend notifyExtend = getNotifyExtend(baseNotifyBean, noticeType);
            notifyExtend.setParams(msgUserData.getParams());
            NotifyLogger.m29913d(TAG, "==================== notifyType : " + noticeType);
            NotifyLogger.m29913d(TAG, "==================== remindWays : " + new Gson().toJson(remindWays));
            NotifyLogger.m29913d(TAG, "==================== userDataJson : " + json);
            NotifyLogger.m29913d(TAG, "==================== notifyExtend : " + new Gson().toJson(notifyExtend));
            boolean zInvokeEvent = invokeEvent(str, str2, id2, remindPurposes, noticeType, remindWays, json, notifyExtend);
            NotifyLogger.m29913d(TAG, "==================== invokeEvent : " + zInvokeEvent);
            reportInvokeNotifyEvent(String.valueOf(id2), noticeType);
            return zInvokeEvent;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "invokeEvent exception, e: " + e10.toString());
            return false;
        }
    }

    public boolean invokeEvent(String str, String str2, int i10, List<String> list, String str3, List<NotifyWay> list2, String str4, NotifyExtend notifyExtend) {
        try {
            NotifyResult[] notifyWays = new NotifyService().queryEvent(str, str2, i10, list, str3, list2, str4, notifyExtend).getNotifyWays();
            if (notifyWays != null && notifyWays.length != 0) {
                for (NotifyResult notifyResult : notifyWays) {
                    if (notifyResult != null && notifyResult.isNeedNotify()) {
                        return true;
                    }
                }
                return false;
            }
            NotifyLogger.m29915i(TAG, "no fit notifyWays, notifyType: " + str3 + ", id: " + i10);
            return false;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "invokeEvent exception, e: " + e10.toString());
            return false;
        }
    }
}
