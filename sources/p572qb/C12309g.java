package p572qb;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.common.R$string;
import com.huawei.hicloud.bean.NotifyJumpInfo;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.hicloud.messagecenter.manager.MessageNotificationManager;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.router.R$drawable;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;

/* renamed from: qb.g */
/* loaded from: classes3.dex */
public class C12309g extends BaseMsgProcessor {
    /* renamed from: a */
    public MessageCenterMsgObj m74007a(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        MessageCenterMsgObj messageCenterMsgObj = new MessageCenterMsgObj();
        messageCenterMsgObj.setCategory(clientMessageBody.getCategory());
        messageCenterMsgObj.setMsgType(notifyWay.getMsgType());
        if (notifyWay.isHasIcon()) {
            messageCenterMsgObj.setNeedShowBadge(1);
        }
        messageCenterMsgObj.setUniqueId(str);
        messageCenterMsgObj.setNotifyTime(clientMessageBody.getNotifyTime());
        messageCenterMsgObj.setReadValidityTime(clientMessageBody.getReadValidityTime());
        messageCenterMsgObj.setRemainValidityTime(clientMessageBody.getRemainValidityTime());
        return messageCenterMsgObj;
    }

    /* renamed from: b */
    public final NotifyNeedData m74008b(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "buildNotifyNeedData start");
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        String title = notifyWay.getTitle();
        String text = notifyWay.getText();
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(text)) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildNotifyNeedData, title or mainText is empty");
            return null;
        }
        notifyNeedData.setTitleText(title);
        notifyNeedData.setMainText(text);
        NotifyJumpInfo notifyJumpInfo = notifyWay.getNotifyJumpInfo();
        if (notifyJumpInfo == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildNotifyNeedData, jumpInfo is null");
            return null;
        }
        String notifyType = notifyJumpInfo.getNotifyType();
        Intent intentM74011e = m74011e(notifyType, notifyJumpInfo.getNotifyUri());
        if (intentM74011e == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildNotifyNeedData, intent is null");
            return null;
        }
        intentM74011e.putExtra("unique_id", str);
        intentM74011e.putExtra("action_type", String.valueOf(7));
        intentM74011e.putExtra("message_category", clientMessageBody.getCategory());
        int operateMsgNotifyIdByAction = MessageCenterManager.getInstance().getOperateMsgNotifyIdByAction(7);
        if (operateMsgNotifyIdByAction == -1) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildNotifyNeedData, get notifyId error.");
            return null;
        }
        try {
            if (GeneralRedirectUtil.TEMP_BACKUP_DEVICE_DETAIL.equals(intentM74011e.getStringExtra("pageType"))) {
                operateMsgNotifyIdByAction = m74010d(notifyWay.getGroup());
                NotifyLogger.m29913d("CommonMsgProcessor", "buildNotifyNeedData, notifyId：" + operateMsgNotifyIdByAction + ",Group：" + notifyWay.getGroup());
                notifyNeedData.setDelete(intentM74011e.getBooleanExtra(GeneralRedirectUtil.IS_DELETE, false));
                notifyNeedData.setDeleteStr(C0213f.m1377a().getResources().getString(R$string.temp_backup_notification_delete_btn));
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildNotifyNeedData createTempNotifyId has error:" + e10.getMessage());
        }
        PendingIntent pendingIntentM74012f = m74012f(notifyType, operateMsgNotifyIdByAction, intentM74011e);
        if (pendingIntentM74012f == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildNotifyNeedData getJumpIntent is null");
            return null;
        }
        notifyNeedData.setContentIntent(pendingIntentM74012f);
        notifyNeedData.setSilent(NotifyUtil.isSilentNotifyTime());
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", C0213f.m1377a().getResources().getString(R$string.HiCloud_app_name));
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setExtraBundle(bundle);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud");
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setId(operateMsgNotifyIdByAction);
        return notifyNeedData;
    }

    /* renamed from: c */
    public final MessageCenterMsgObj m74009c(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        String title = notifyWay.getTitle();
        String richMsgContent = notifyWay.getRichMsgContent();
        NotifyJumpInfo notifyJumpInfo = notifyWay.getNotifyJumpInfo();
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(richMsgContent)) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildTxtImgMsgObj, title or mainText is empty");
            return null;
        }
        if (notifyJumpInfo == null || TextUtils.isEmpty(notifyJumpInfo.getNotifyType()) || TextUtils.isEmpty(notifyJumpInfo.getNotifyUri())) {
            NotifyLogger.m29914e("CommonMsgProcessor", "buildTxtImgMsgObj, jumpInfo is invalid");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObjM74007a = m74007a(clientMessageBody, str, notifyWay);
        messageCenterMsgObjM74007a.setTitleText(title);
        messageCenterMsgObjM74007a.setMainText(richMsgContent);
        messageCenterMsgObjM74007a.setMsgGotoType(notifyJumpInfo.getNotifyType());
        messageCenterMsgObjM74007a.setMsgGotoUri(notifyJumpInfo.getNotifyUri());
        messageCenterMsgObjM74007a.setNotifyId(773);
        return messageCenterMsgObjM74007a;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean checkNotifyTypeAllowList(ClientMessageBody clientMessageBody) {
        String notifyType = clientMessageBody.getNotifyType();
        if ("common".equalsIgnoreCase(notifyType)) {
            return true;
        }
        NotifyLogger.m29914e("CommonMsgProcessor", "notifyType is invalid, notifyType: " + notifyType);
        return false;
    }

    /* renamed from: d */
    public int m74010d(String str) {
        return Integer.parseInt("4" + C0227m.m1593f(str).substring(0, 4), 16);
    }

    /* renamed from: e */
    public final Intent m74011e(String str, String str2) {
        if (!NotifyConstants.HICLOUD_KA.equals(str)) {
            return GeneralRedirectUtil.getCommonGotoIntent(str, str2, false);
        }
        Intent intent = new Intent();
        intent.setClass(C0213f.m1377a(), CommonNotifyReceiver.class);
        intent.setAction(CommonNotifyReceiver.COMMON_ACTION);
        intent.putExtra("requestId", 10005);
        intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, str);
        intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, str2);
        return intent;
    }

    /* renamed from: f */
    public final PendingIntent m74012f(String str, int i10, Intent intent) {
        return NotifyConstants.HICLOUD_KA.equals(str) ? PendingIntent.getBroadcast(C0213f.m1377a(), i10, intent, 1207959552) : C0209d.m1248e0(C0213f.m1377a(), i10, intent, 1207959552);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean isMsgValid(ClientMessageBody clientMessageBody) {
        if (clientMessageBody == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "isMsgValid, message is null");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long remainValidityTime = clientMessageBody.getRemainValidityTime();
        NotifyLogger.m29915i("CommonMsgProcessor", "isMsgValid, msg id: " + clientMessageBody.getCfgResourceId() + ", current time: " + jCurrentTimeMillis + ", remain time: " + remainValidityTime);
        return remainValidityTime == 0 || remainValidityTime >= jCurrentTimeMillis;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void process(ClientMessageBody clientMessageBody) {
        super.process(clientMessageBody);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processBannerNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "common type can't process banner message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processDeskPopup(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "common type can't process desk popup message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processH5Dialog(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "common type can't process H5Dialog message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processImgMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "common type can't process img message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processMenuNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "common type can't process menu message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        super.processMessage(clientMessageBody, str, notifyWay);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processNotification(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "processNotification, start");
        if (clientMessageBody == null || notifyWay == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "processNotification, message or notifyWay is null");
            return;
        }
        NotifyNeedData notifyNeedDataM74008b = m74008b(clientMessageBody, str, notifyWay);
        if (notifyNeedDataM74008b == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "processNotification, data process error, notifyNeedData is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_notify_failed");
        } else {
            MessageCenterReportUtil.reportCommonMsgProcSuccess(clientMessageBody, str, notifyWay);
            sendNotification(notifyNeedDataM74008b, clientMessageBody);
            NotifyLogger.m29915i("CommonMsgProcessor", "processNotification, end");
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processRichMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "common type can't process rich message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processTextMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        NotifyLogger.m29915i("CommonMsgProcessor", "processTextMessage, start");
        if (clientMessageBody == null || notifyWay == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "processTextMessage, message or notifyWay is null");
            return;
        }
        MessageCenterMsgObj messageCenterMsgObjM74009c = m74009c(clientMessageBody, str, notifyWay);
        if (messageCenterMsgObjM74009c == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "processTextMessage, data process error, msgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_text_msg_failed");
        } else {
            MessageCenterReportUtil.reportCommonMsgProcSuccess(clientMessageBody, str, notifyWay);
            MessageCenterManager.getInstance().insertMessageCenterData(messageCenterMsgObjM74009c);
            NotifyLogger.m29915i("CommonMsgProcessor", "processTextMessage, end");
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void sendNotification(NotifyNeedData notifyNeedData, ClientMessageBody clientMessageBody) {
        NotificationCompat.Builder notificationBuilder;
        MessageNotificationManager messageNotificationManager = new MessageNotificationManager(C0213f.m1377a());
        if (notifyNeedData == null || clientMessageBody == null) {
            NotifyLogger.m29914e("CommonMsgProcessor", "sendNotification, notifyNeedData or message is null");
            notificationBuilder = NotifyUtil.getNotificationBuilder(false, "com.huawei.android.hicloud");
        } else {
            notificationBuilder = NotifyUtil.getNotificationBuilder(notifyNeedData.isSilent(), "com.huawei.android.hicloud");
        }
        messageNotificationManager.sendNotification(notificationBuilder, notifyNeedData);
    }
}
