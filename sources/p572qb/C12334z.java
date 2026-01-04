package p572qb;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.common.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.DlAppCampInfo;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.UserTags;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.messagecenter.bean.BaseMsgObj;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj;
import com.huawei.hicloud.messagecenter.bean.H5WindowMsgObj;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.constant.MessageAllowListManager;
import com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.hicloud.messagecenter.manager.MessageNotificationManager;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.DeskTopPopup;
import com.huawei.hicloud.notification.bean.HiCloudMsgNoticeAction;
import com.huawei.hicloud.notification.bean.MsgJump;
import com.huawei.hicloud.notification.bean.NotifyAgdParameters;
import com.huawei.hicloud.notification.bean.NotifyBar;
import com.huawei.hicloud.notification.bean.NotifyMessageButtonData;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.router.R$drawable;
import com.huawei.openalliance.p169ad.constant.Constants;
import dk.C9162c;
import fj.C9718g;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p020ap.C1009d;
import p315gj.C9948a;
import p341hj.C10270w;
import p384j4.AbstractC10706e;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11289l;
import p514o9.C11839m;
import p709vj.C13452e;
import p743wk.C13616a;
import p778xk.C13823d;
import p836z8.C14157f;

/* renamed from: qb.z */
/* loaded from: classes3.dex */
public class C12334z extends BaseMsgProcessor {

    /* renamed from: a */
    public String f57094a;

    /* renamed from: b */
    public NotifyAgdParameters f57095b;

    /* renamed from: j */
    private NotifyNeedData m74160j(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        String stringFromDB;
        String stringFromDB2;
        NotifyLogger.m29915i("OperateMsgProcessor", "buildNotifyNeedData start");
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        HiCloudMsgNoticeAction actionById = HiCloudMsgNoticeConfigManager.getInstance().getActionById(cfgResourceId);
        if (actionById == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildNotifyNeedData, no action, config id: " + cfgResourceId);
            return null;
        }
        NotifyNeedData notifyNeedData = new NotifyNeedData();
        NotifyBar notifyBar = actionById.getNotifyBar();
        if (notifyBar == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildNotifyNeedData, notifyBar is null.");
            return null;
        }
        List<String> params = notifyBar.getParams();
        List<String> realtimeParams = notifyBar.getRealtimeParams();
        MsgJump msgJump = notifyBar.getMsgJump();
        if (msgJump == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildNotifyNeedData, jump msg is null");
            return null;
        }
        if (!m74177r(str, clientMessageBody, actionById, notifyWay)) {
            C11839m.m70687e("OperateMsgProcessor", "buildNotifyNeedData, param not satisfy");
            return null;
        }
        String notifyType = msgJump.getNotifyType();
        String notifyUri = msgJump.getNotifyUri();
        if ("download_app".equals(clientMessageBody.getNotifyType())) {
            notifyUri = NoticeWithActivityUtil.addLanguageType(this.f57094a);
            notifyType = NotifyConstants.HICLOUD_DLAPP;
        }
        boolean zContains = C13616a.m81911c().contains(clientMessageBody.getNotifyType());
        if (zContains) {
            notifyUri = C13823d.m82904y().m82937u(8, clientMessageBody.getNotifyType(), clientMessageBody.getParams());
            if (TextUtils.isEmpty(notifyUri)) {
                NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyNeedData,  no getNotifyUri, not show");
                return null;
            }
            notifyType = NotifyConstants.TYPE_DEEPLINK;
        }
        Intent intentM74162n = m74162n(notifyType, CloudSpaceNotifyUtil.getInstance().replaceDeepLinkParams(notifyUri, "NOTIFY_BAR", clientMessageBody.getContext()));
        if (intentM74162n == null) {
            NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyNeedData, intent is null");
            return null;
        }
        intentM74162n.putExtra("refresh_param", true);
        if (params != null) {
            intentM74162n.putStringArrayListExtra("refresh_param_list", (ArrayList) params);
        }
        if (realtimeParams != null) {
            intentM74162n.putStringArrayListExtra("refresh_realtime_param_list", (ArrayList) realtimeParams);
        }
        if ("package_will_expire".equals(clientMessageBody.getNotifyType()) || "package_will_expire_new".equals(clientMessageBody.getNotifyType()) || "package_already_expire".equals(clientMessageBody.getNotifyType())) {
            intentM74162n.putExtra("action_bar_color_hm_os_bg", true);
            intentM74162n.putExtra("is_support_dark_mode", true);
        }
        intentM74162n.putExtra("unique_id", str);
        intentM74162n.putExtra("action_type", String.valueOf(actionById.getAction()));
        intentM74162n.putExtra("message_category", clientMessageBody.getCategory());
        intentM74162n.putExtra("message_id", cfgResourceId);
        if (NotifyConstants.HICLOUD_DLAPP.equals(notifyType)) {
            m74165b(intentM74162n);
        }
        NotifyLogger.m29915i("OperateMsgProcessor", "buildNotifyNeedData action: " + actionById.getAction());
        int operateMsgNotifyIdByAction = MessageCenterManager.getInstance().getOperateMsgNotifyIdByAction(actionById.getAction());
        if (operateMsgNotifyIdByAction == -1) {
            NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyNeedData, get notifyId error.");
            return null;
        }
        if (zContains) {
            stringFromDB = C13823d.m82904y().m82936t(C0213f.m1377a(), HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(actionById.getTitle()), clientMessageBody);
            stringFromDB2 = C13823d.m82904y().m82936t(C0213f.m1377a(), HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(actionById.getText()), clientMessageBody);
        } else {
            stringFromDB = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(notifyBar.getNotifyTitle());
            stringFromDB2 = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(notifyBar.getNotifyText());
        }
        String strReplaceParams = CloudSpaceNotifyUtil.getInstance().replaceParams(stringFromDB, "NOTIFY_BAR", clientMessageBody.getContext());
        String strReplaceParams2 = CloudSpaceNotifyUtil.getInstance().replaceParams(stringFromDB2, "NOTIFY_BAR", clientMessageBody.getContext());
        if (TextUtils.isEmpty(strReplaceParams) || TextUtils.isEmpty(strReplaceParams2)) {
            NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyNeedData, no key resource, not show");
            return null;
        }
        String strM74178t = m74178t(clientMessageBody, strReplaceParams2);
        if (strM74178t == null) {
            return null;
        }
        if (TextUtils.isEmpty(strM74178t)) {
            strM74178t = strReplaceParams2;
        }
        if (operateMsgNotifyIdByAction == 776 || operateMsgNotifyIdByAction == 790 || operateMsgNotifyIdByAction == 791 || operateMsgNotifyIdByAction == 792) {
            intentM74162n.putExtra("user_operation_text", strReplaceParams);
            intentM74162n.putExtra("user_operation_type", "notifyBar");
        }
        PendingIntent pendingIntentM74163o = m74163o(notifyType, operateMsgNotifyIdByAction, intentM74162n);
        if (pendingIntentM74163o == null) {
            NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyNeedData getJumpIntent is null");
            return null;
        }
        notifyNeedData.setContentIntent(pendingIntentM74163o);
        notifyNeedData.setSilent(actionById.getMuteTimeControl() != 0 && NotifyUtil.isSilentNotifyTime());
        notifyNeedData.setMessageButtonData(m74171h(notifyBar, clientMessageBody.getCategory(), str, actionById.getAction(), cfgResourceId, operateMsgNotifyIdByAction, strReplaceParams));
        notifyNeedData.setTitleText(strReplaceParams);
        notifyNeedData.setMainText(strM74178t);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", C0213f.m1377a().getResources().getString(R$string.HiCloud_app_name));
        notifyNeedData.setIconId(R$drawable.logo_about_system);
        notifyNeedData.setExtraBundle(bundle);
        notifyNeedData.setGroupKey("com.huawei.android.hicloud");
        notifyNeedData.setAutoCancel(true);
        notifyNeedData.setId(operateMsgNotifyIdByAction);
        notifyNeedData.setResourceInfo(String.valueOf(actionById.getId()));
        return notifyNeedData;
    }

    /* renamed from: l */
    private MessageCenterMsgObj m74161l(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        String stringFromDB;
        String stringFromDB2;
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        HiCloudMsgNoticeAction actionById = HiCloudMsgNoticeConfigManager.getInstance().getActionById(cfgResourceId);
        if (actionById == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildTxtImgMsgObj, no action, config id: " + cfgResourceId);
            return null;
        }
        if (!m74176q(str, clientMessageBody, actionById, notifyWay)) {
            C11839m.m70687e("OperateMsgProcessor", "buildTxtImgMsgObj, not satisfy param");
            return null;
        }
        boolean zContains = C13616a.m81911c().contains(clientMessageBody.getNotifyType());
        if (zContains) {
            stringFromDB = C13823d.m82904y().m82936t(C0213f.m1377a(), HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(actionById.getTitle()), clientMessageBody);
            stringFromDB2 = C13823d.m82904y().m82936t(C0213f.m1377a(), HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(actionById.getText()), clientMessageBody);
        } else {
            stringFromDB = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(actionById.getTitle());
            stringFromDB2 = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(actionById.getText());
        }
        String strReplaceParams = CloudSpaceNotifyUtil.getInstance().replaceParams(stringFromDB, "MSG_CENTER", clientMessageBody.getContext());
        String strReplaceParams2 = CloudSpaceNotifyUtil.getInstance().replaceParams(stringFromDB2, "MSG_CENTER", clientMessageBody.getContext());
        MsgJump msgJump = actionById.getMsgJump();
        if (TextUtils.isEmpty(strReplaceParams) || TextUtils.isEmpty(strReplaceParams2) || msgJump == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildTxtImgMsgObj, no key resource, not show");
            return null;
        }
        String strM74178t = m74178t(clientMessageBody, strReplaceParams2);
        if (strM74178t == null) {
            return null;
        }
        if (!TextUtils.isEmpty(strM74178t)) {
            strReplaceParams2 = strM74178t;
        }
        MessageCenterMsgObj messageCenterMsgObjM74168e = m74168e(clientMessageBody, str, notifyWay);
        m74179u(clientMessageBody, messageCenterMsgObjM74168e);
        messageCenterMsgObjM74168e.setTitleText(strReplaceParams);
        messageCenterMsgObjM74168e.setMainText(strReplaceParams2);
        if (zContains) {
            NotifyTypeAndUriGoto notifyTypeAndUriGotoM82905A = C13823d.m82904y().m82905A(8, clientMessageBody.getNotifyType(), clientMessageBody.getParams());
            messageCenterMsgObjM74168e.setMsgGotoType(notifyTypeAndUriGotoM82905A.getNotifyType());
            messageCenterMsgObjM74168e.setMsgGotoUri(notifyTypeAndUriGotoM82905A.getNotifyUri());
            if (TextUtils.isEmpty(notifyTypeAndUriGotoM82905A.getNotifyUri())) {
                NotifyLogger.m29914e("OperateMsgProcessor", "buildTxtImgMsgObj,  no getNotifyUri, not show");
                return null;
            }
        } else {
            String strReplaceDeepLinkParams = CloudSpaceNotifyUtil.getInstance().replaceDeepLinkParams(msgJump.getNotifyUri(), "NOTIFY_BAR", clientMessageBody.getContext());
            messageCenterMsgObjM74168e.setMsgGotoType(msgJump.getNotifyType());
            messageCenterMsgObjM74168e.setMsgGotoUri(strReplaceDeepLinkParams);
        }
        messageCenterMsgObjM74168e.setPictureUrl(actionById.getPicture());
        m74167d(clientMessageBody, messageCenterMsgObjM74168e);
        return messageCenterMsgObjM74168e;
    }

    /* renamed from: n */
    private Intent m74162n(String str, String str2) {
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

    /* renamed from: o */
    private PendingIntent m74163o(String str, int i10, Intent intent) {
        return NotifyConstants.HICLOUD_KA.equals(str) ? PendingIntent.getBroadcast(C0213f.m1377a(), i10, intent, 1207959552) : C0209d.m1248e0(C0213f.m1377a(), i10, intent, 1207959552);
    }

    /* renamed from: s */
    public static /* synthetic */ void m74164s(CountDownLatch countDownLatch, GetCampaignActivityEntryResp getCampaignActivityEntryResp) {
        if (getCampaignActivityEntryResp != null && getCampaignActivityEntryResp.getResultCode() == 0) {
            C9718g.m60602t().m60620V(C0213f.m1377a(), getCampaignActivityEntryResp);
        }
        countDownLatch.countDown();
    }

    /* renamed from: b */
    public final void m74165b(Intent intent) {
        if (intent == null) {
            NotifyLogger.m29914e("OperateMsgProcessor", "addAgdParameter, intent is null");
            return;
        }
        NotifyAgdParameters notifyAgdParameters = this.f57095b;
        if (notifyAgdParameters == null) {
            NotifyLogger.m29914e("OperateMsgProcessor", "addAgdParameter, parameters is null");
            return;
        }
        intent.putExtra("agd_resource_enable", notifyAgdParameters.getEnabled());
        intent.putExtra("agd_resource_slot_id", this.f57095b.getSlotId());
        intent.putExtra("pps_threshold", this.f57095b.getThreshold());
    }

    /* renamed from: c */
    public final void m74166c(BaseMsgObj baseMsgObj) {
        C11839m.m70688i("OperateMsgProcessor", "addDownloadAppParam");
        baseMsgObj.setMsgGotoType(NotifyConstants.HICLOUD_DLAPP);
        baseMsgObj.setMsgGotoUri(this.f57094a);
        baseMsgObj.setAgdParameters(new Gson().toJson(this.f57095b));
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean checkNotifyTypeAllowList(ClientMessageBody clientMessageBody) {
        String notifyType = clientMessageBody.getNotifyType();
        if (!TextUtils.isEmpty(notifyType)) {
            return MessageAllowListManager.getOperTypeAllowList().contains(notifyType) || C13616a.m81911c().contains(notifyType);
        }
        C11839m.m70687e("OperateMsgProcessor", "notifyType is null");
        return false;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void checkPreCondition(ClientMessageBody clientMessageBody) throws InterruptedException {
        String notifyType = clientMessageBody.getNotifyType();
        if (TextUtils.isEmpty(notifyType)) {
            C11839m.m70687e("OperateMsgProcessor", "notifyType is null");
            return;
        }
        if (!C13616a.m81911c().contains(notifyType)) {
            C11839m.m70688i("OperateMsgProcessor", "not campaign msg");
            return;
        }
        checkConfigUpdate(clientMessageBody.getCfgKey(), clientMessageBody.getCfgInstanceId());
        if (C9718g.m60602t().m60607E(C0213f.m1377a(), false)) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        C10270w c10270w = new C10270w(new Consumer() { // from class: qb.y
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12334z.m74164s(countDownLatch, (GetCampaignActivityEntryResp) obj);
            }
        }, 5);
        c10270w.m63434i("OperateMsgProcessor");
        c10270w.m63381g();
        try {
            NotifyLogger.m29915i("OperateMsgProcessor", "checkPreCondition await");
            NotifyLogger.m29913d("OperateMsgProcessor", "checkPreCondition await=" + countDownLatch.await(60L, TimeUnit.SECONDS));
        } catch (Exception e10) {
            NotifyLogger.m29914e("OperateMsgProcessor", "checkPreCondition exception: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public final void m74167d(ClientMessageBody clientMessageBody, BaseMsgObj baseMsgObj) {
        if (clientMessageBody == null || baseMsgObj == null) {
            C11839m.m70687e("OperateMsgProcessor", "addExtraParamByNotifyType, message or msgObj is null");
            return;
        }
        String notifyType = clientMessageBody.getNotifyType();
        C11839m.m70688i("OperateMsgProcessor", "addExtraParamByNotifyType, notify type: " + notifyType);
        try {
            if ("download_app".equals(notifyType)) {
                m74166c(baseMsgObj);
            }
        } catch (Exception e10) {
            C11839m.m70688i("OperateMsgProcessor", "addExtraParamByNotifyType, exception: " + e10.toString());
        }
    }

    /* renamed from: e */
    public MessageCenterMsgObj m74168e(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
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
        messageCenterMsgObj.setResourceInfo(clientMessageBody.getCfgResourceId());
        messageCenterMsgObj.setNotifyType(clientMessageBody.getNotifyType());
        messageCenterMsgObj.setContext(clientMessageBody.getContext());
        return messageCenterMsgObj;
    }

    /* renamed from: f */
    public final DeskPopupMsgObj m74169f(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        HiCloudMsgNoticeAction actionById = HiCloudMsgNoticeConfigManager.getInstance().getActionById(cfgResourceId);
        if (actionById == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildDeskPopupMsgObj, no action, config id: " + cfgResourceId);
            return null;
        }
        DeskPopupMsgObj deskPopupMsgObj = new DeskPopupMsgObj();
        DeskTopPopup desktopPopup = actionById.getDesktopPopup();
        if (desktopPopup == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildDeskPopupMsgObj, desktopPopup is null");
            return null;
        }
        if (AbstractC10706e.m65374a(desktopPopup.getDesktopGotos())) {
            C11839m.m70687e("OperateMsgProcessor", "buildDeskPopupMsgObj, popup button size is 0, not show popup");
            return null;
        }
        if (!m74175p(str, clientMessageBody, actionById, notifyWay)) {
            C11839m.m70687e("OperateMsgProcessor", "buildDeskPopupMsgObj, param not satisfy");
            return null;
        }
        deskPopupMsgObj.setUniqueId(str);
        deskPopupMsgObj.setMessageId(notifyWay.getMessageId());
        deskPopupMsgObj.setParam(actionById.getParams());
        deskPopupMsgObj.setRealTimeParam(actionById.getRealTimeParams());
        deskPopupMsgObj.setTrigger(actionById.getTrigger());
        deskPopupMsgObj.setReadValidityTime(clientMessageBody.getReadValidityTime());
        deskPopupMsgObj.setRemainValidityTime(clientMessageBody.getRemainValidityTime());
        deskPopupMsgObj.setNotifyTime(clientMessageBody.getNotifyTime());
        deskPopupMsgObj.setResourceInfo(clientMessageBody.getCfgResourceId());
        deskPopupMsgObj.setPriority(clientMessageBody.getPriority());
        deskPopupMsgObj.setCfgInstanceId(clientMessageBody.getCfgInstanceId());
        deskPopupMsgObj.setDeskPopupAction(actionById.getAction());
        deskPopupMsgObj.setDesktopTitle(desktopPopup.getDesktopTitle());
        deskPopupMsgObj.setDesktopText(desktopPopup.getDesktopText());
        deskPopupMsgObj.setDesktopGoto(desktopPopup.getDesktopGotos());
        deskPopupMsgObj.setSecondWindows(desktopPopup.getSecondWindows());
        deskPopupMsgObj.setExtras(desktopPopup.getExtras());
        deskPopupMsgObj.setContext(clientMessageBody.getContext());
        List<Integer> triggerScope = actionById.getTriggerScope();
        if (triggerScope == null || !triggerScope.contains(4)) {
            deskPopupMsgObj.setSupportTrigger(0);
        } else {
            deskPopupMsgObj.setSupportTrigger(1);
        }
        return deskPopupMsgObj;
    }

    /* renamed from: g */
    public final H5WindowMsgObj m74170g(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        HiCloudMsgNoticeAction actionById = HiCloudMsgNoticeConfigManager.getInstance().getActionById(cfgResourceId);
        if (actionById == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildH5WindowMsgObj, no action, config id: " + cfgResourceId);
            return null;
        }
        String url = actionById.getUrl();
        MsgJump msgJump = actionById.getMsgJump();
        if (TextUtils.isEmpty(url) || msgJump == null) {
            C11839m.m70687e("OperateMsgProcessor", "buildH5WindowMsgObj, no key resource, not show");
            return null;
        }
        H5WindowMsgObj h5WindowMsgObj = new H5WindowMsgObj();
        h5WindowMsgObj.setUniqueId(str);
        if (C13616a.m81911c().contains(clientMessageBody.getNotifyType())) {
            NotifyTypeAndUriGoto notifyTypeAndUriGotoM82905A = C13823d.m82904y().m82905A(8, clientMessageBody.getNotifyType(), clientMessageBody.getParams());
            h5WindowMsgObj.setMsgGotoType(notifyTypeAndUriGotoM82905A.getNotifyType());
            h5WindowMsgObj.setMsgGotoUri(notifyTypeAndUriGotoM82905A.getNotifyUri());
            if (TextUtils.isEmpty(notifyTypeAndUriGotoM82905A.getNotifyUri())) {
                NotifyLogger.m29914e("OperateMsgProcessor", "buildH5WindowMsgObj,  no getNotifyUri, not show");
                return null;
            }
        } else {
            h5WindowMsgObj.setMsgGotoType(msgJump.getNotifyType());
            h5WindowMsgObj.setMsgGotoUri(msgJump.getNotifyUri());
        }
        h5WindowMsgObj.setH5DialogAction(actionById.getAction());
        h5WindowMsgObj.setH5DialogUrl(url);
        h5WindowMsgObj.setReadValidityTime(clientMessageBody.getReadValidityTime());
        h5WindowMsgObj.setRemainValidityTime(clientMessageBody.getRemainValidityTime());
        h5WindowMsgObj.setNotifyTime(clientMessageBody.getNotifyTime());
        h5WindowMsgObj.setResourceInfo(clientMessageBody.getCfgResourceId());
        h5WindowMsgObj.setPriority(clientMessageBody.getPriority());
        m74167d(clientMessageBody, h5WindowMsgObj);
        h5WindowMsgObj.setParam(actionById.getParams());
        h5WindowMsgObj.setRealTimeParam(actionById.getRealTimeParams());
        h5WindowMsgObj.setTrigger(actionById.getTrigger());
        List<Integer> triggerScope = actionById.getTriggerScope();
        if (triggerScope == null || !triggerScope.contains(1)) {
            h5WindowMsgObj.setSupportTrigger(0);
        } else {
            h5WindowMsgObj.setSupportTrigger(1);
        }
        return h5WindowMsgObj;
    }

    /* renamed from: h */
    public final NotifyMessageButtonData m74171h(NotifyBar notifyBar, String str, String str2, int i10, String str3, int i11, String str4) {
        NotifyLogger.m29915i("OperateMsgProcessor", "buildNotifyDownloadButtonData start");
        NotifyMessageButtonData notifyMessageButtonData = new NotifyMessageButtonData();
        String stringFromDB = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(notifyBar.getBtnOneText());
        String stringFromDB2 = HiCloudMsgNoticeConfigManager.getInstance().getStringFromDB(notifyBar.getBtnTwoText());
        notifyMessageButtonData.setFirstButtonText(stringFromDB);
        notifyMessageButtonData.setSecondButtonText(stringFromDB2);
        int i12 = i11 << 4;
        PendingIntent pendingIntentM74172i = m74172i(notifyBar.getBtnOneGoto(), str, str2, i10, str3, true, i11, i12 | 1, str4 + "_" + stringFromDB);
        PendingIntent pendingIntentM74172i2 = m74172i(notifyBar.getBtnTwoGoto(), str, str2, i10, str3, true, i11, i12 | 2, str4 + "_" + stringFromDB2);
        notifyMessageButtonData.setFirstBtnIntent(pendingIntentM74172i);
        notifyMessageButtonData.setSecondBtnIntent(pendingIntentM74172i2);
        return notifyMessageButtonData;
    }

    /* renamed from: i */
    public final PendingIntent m74172i(MsgJump msgJump, String str, String str2, int i10, String str3, boolean z10, int i11, int i12, String str4) {
        if (msgJump == null) {
            NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyMsgIntent, jump msg is null");
            return null;
        }
        NotifyLogger.m29915i("OperateMsgProcessor", "buildNotifyMsgIntent, notifyId is " + i11 + " buttonNotifyId is " + i12);
        String notifyType = msgJump.getNotifyType();
        Intent intentM74162n = m74162n(notifyType, msgJump.getNotifyUri());
        if (intentM74162n == null) {
            NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyMsgIntent, intent is null");
            return null;
        }
        intentM74162n.putExtra("refresh_param", true);
        intentM74162n.putExtra("unique_id", str2);
        intentM74162n.putExtra("action_type", String.valueOf(i10));
        intentM74162n.putExtra("message_category", str);
        intentM74162n.putExtra("message_id", str3);
        if (z10) {
            intentM74162n.putExtra("notify_id", i11);
            intentM74162n.putExtra("notify_cancel_manual", true);
        }
        if (i11 == 776) {
            intentM74162n.putExtra("user_operation_text", str4);
            intentM74162n.putExtra("user_operation_type", "notifyBar");
        }
        PendingIntent pendingIntentM74163o = m74163o(notifyType, i12, intentM74162n);
        if (pendingIntentM74163o != null) {
            return pendingIntentM74163o;
        }
        NotifyLogger.m29914e("OperateMsgProcessor", "buildNotifyMsgIntent getJumpIntent is null");
        return null;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean isMsgValid(ClientMessageBody clientMessageBody) {
        if (clientMessageBody == null) {
            C11839m.m70687e("OperateMsgProcessor", "isMsgValid, message is null");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long remainValidityTime = clientMessageBody.getRemainValidityTime();
        C11839m.m70688i("OperateMsgProcessor", "isMsgValid, msg id: " + clientMessageBody.getCfgResourceId() + ", current time: " + jCurrentTimeMillis + ", remain time: " + remainValidityTime);
        return remainValidityTime == 0 || remainValidityTime >= jCurrentTimeMillis;
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public boolean isNotifyTypeCustPass(ClientMessageBody clientMessageBody) {
        String notifyType = clientMessageBody.getNotifyType();
        if (C13616a.m81911c().contains(notifyType) && C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("OperateMsgProcessor", "Campaign can not show in child account");
            return false;
        }
        if (!"download_app".equals(notifyType)) {
            return true;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("OperateMsgProcessor", "checkDownloadAppSupport can not show in child account");
            return false;
        }
        boolean zM74174m = m74174m();
        C11839m.m70688i("OperateMsgProcessor", "checkDownloadAppSupport, result: " + zM74174m);
        return zM74174m;
    }

    /* renamed from: k */
    public MessageCenterMsgObj m74173k(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        String richMsgContent = notifyWay.getRichMsgContent();
        if (TextUtils.isEmpty(richMsgContent)) {
            C11839m.m70687e("OperateMsgProcessor", "buildRichMsgObj, no rich content, not show");
            return null;
        }
        MessageCenterMsgObj messageCenterMsgObjM74168e = m74168e(clientMessageBody, str, notifyWay);
        messageCenterMsgObjM74168e.setRichMsgContent(richMsgContent);
        return messageCenterMsgObjM74168e;
    }

    /* renamed from: m */
    public final boolean m74174m() {
        GetActivityEntryResp getActivityEntryRespM61691r;
        C11839m.m70688i("OperateMsgProcessor", "checkDownloadAppSupport");
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07046"), "getActivityEntry", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        try {
            getActivityEntryRespM61691r = C9948a.m61631C().m61691r(new UserTags(), 415, c11060cM66626a, false);
        } catch (C9721b e10) {
            C11839m.m70687e("OperateMsgProcessor", "checkDownloadAppSupport getActivityEntry exception: " + e10.toString());
            getActivityEntryRespM61691r = null;
        }
        if (getActivityEntryRespM61691r == null) {
            C11839m.m70687e("OperateMsgProcessor", "checkDownloadAppSupport getActivityEntryResp is null");
            return false;
        }
        ActivityEntry entry = getActivityEntryRespM61691r.getEntry();
        if (entry == null) {
            C11839m.m70687e("OperateMsgProcessor", "checkDownloadAppSupport activityEntry is null");
            return false;
        }
        this.f57094a = entry.getUrl();
        DlAppCampInfo campaignInfo = entry.getCampaignInfo();
        if (campaignInfo != null && campaignInfo.getAdParametersExt() != null) {
            AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
            this.f57095b = new NotifyAgdParameters(adParametersExt.getEnabled().intValue(), adParametersExt.getAgdAdid(), adParametersExt.getThreshold().intValue());
        }
        return C11289l.m67731e(entry, "", 1004, false);
    }

    /* renamed from: p */
    public final boolean m74175p(String str, ClientMessageBody clientMessageBody, HiCloudMsgNoticeAction hiCloudMsgNoticeAction, NotifyWay notifyWay) {
        String trigger = hiCloudMsgNoticeAction.getTrigger();
        List<Integer> triggerScope = hiCloudMsgNoticeAction.getTriggerScope();
        int i10 = (triggerScope == null || !triggerScope.contains(4)) ? 0 : 1;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("unique_id", str);
        linkedHashMap.put("resource_id", clientMessageBody.getCfgResourceId());
        linkedHashMap.put(Constants.AUTOCONTENT_CATEGORY, clientMessageBody.getCategory());
        linkedHashMap.put("desk_popup_type", clientMessageBody.getNotifyType());
        linkedHashMap.put("desk_popup_name", notifyWay.getName());
        linkedHashMap.put("actionType", String.valueOf(hiCloudMsgNoticeAction.getAction()));
        return C1009d.m6109e().m6119k(new ArrayList(), new ArrayList(), trigger, i10, linkedHashMap);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void process(ClientMessageBody clientMessageBody) {
        super.process(clientMessageBody);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processBannerNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("OperateMsgProcessor", "operation type can't process banner message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processDeskPopup(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        C11839m.m70688i("OperateMsgProcessor", "processDeskPopup, start");
        checkConfigUpdate(clientMessageBody.getCfgKey(), clientMessageBody.getCfgInstanceId());
        DeskPopupMsgObj deskPopupMsgObjM74169f = m74169f(clientMessageBody, str, notifyWay);
        if (deskPopupMsgObjM74169f == null) {
            C11839m.m70687e("OperateMsgProcessor", "processDeskPopup, deskPopupMsgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_desk_popup_failed");
        } else {
            MessageCenterReportUtil.reportOperateMsgProcSuccess(clientMessageBody, str, notifyWay);
            MessageCenterManager.getInstance().insertDeskPopupMsg(deskPopupMsgObjM74169f);
            C12311h.m74013c().m74019g();
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processH5Dialog(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        C11839m.m70688i("OperateMsgProcessor", "processH5Dialog, start");
        H5WindowMsgObj h5WindowMsgObjM74170g = m74170g(clientMessageBody, str, notifyWay);
        if (h5WindowMsgObjM74170g == null) {
            C11839m.m70687e("OperateMsgProcessor", "processH5Dialog, h5msgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_h5_window_failed");
        } else {
            MessageCenterReportUtil.reportOperateMsgProcSuccess(clientMessageBody, str, notifyWay);
            MessageCenterManager.getInstance().insertH5DialogMsg(h5WindowMsgObjM74170g);
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processImgMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        C11839m.m70688i("OperateMsgProcessor", "processImgMessage, start");
        checkConfigUpdate(clientMessageBody.getCfgKey(), clientMessageBody.getCfgInstanceId());
        MessageCenterMsgObj messageCenterMsgObjM74161l = m74161l(clientMessageBody, str, notifyWay);
        if (messageCenterMsgObjM74161l == null) {
            C11839m.m70687e("OperateMsgProcessor", "processImgMessage, data process error, msgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_image_msg_failed");
        } else {
            MessageCenterReportUtil.reportOperateMsgProcSuccess(clientMessageBody, str, notifyWay);
            MessageCenterManager.getInstance().insertMessageCenterData(messageCenterMsgObjM74161l);
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processMenuNotifyWay(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        C11839m.m70688i("OperateMsgProcessor", "operation type can't process menu message");
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) {
        super.processMessage(clientMessageBody, str, notifyWay);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processNotification(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        C11839m.m70688i("OperateMsgProcessor", "processNotification, start");
        checkConfigUpdate(clientMessageBody.getCfgKey(), clientMessageBody.getCfgInstanceId());
        NotifyNeedData notifyNeedDataM74160j = m74160j(clientMessageBody, str, notifyWay);
        if (notifyNeedDataM74160j == null) {
            C11839m.m70687e("OperateMsgProcessor", "processNotification, data process error, notifyNeedData is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_notify_failed");
        } else {
            MessageCenterReportUtil.reportOperateMsgProcSuccess(clientMessageBody, str, notifyWay);
            sendNotification(notifyNeedDataM74160j, clientMessageBody);
            C11839m.m70688i("OperateMsgProcessor", "processNotification, end");
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processRichMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        C11839m.m70688i("OperateMsgProcessor", "processRichMessage, start");
        MessageCenterMsgObj messageCenterMsgObjM74173k = m74173k(clientMessageBody, str, notifyWay);
        if (messageCenterMsgObjM74173k == null) {
            C11839m.m70687e("OperateMsgProcessor", "processRichMessage, data process error, msgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_rich_msg_failed");
        } else {
            m74179u(clientMessageBody, messageCenterMsgObjM74173k);
            MessageCenterReportUtil.reportOperateMsgProcSuccess(clientMessageBody, str, notifyWay);
            MessageCenterManager.getInstance().insertMessageCenterData(messageCenterMsgObjM74173k);
        }
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void processTextMessage(ClientMessageBody clientMessageBody, String str, NotifyWay notifyWay) throws IOException {
        C11839m.m70688i("OperateMsgProcessor", "processTextMessage, start");
        checkConfigUpdate(clientMessageBody.getCfgKey(), clientMessageBody.getCfgInstanceId());
        MessageCenterMsgObj messageCenterMsgObjM74161l = m74161l(clientMessageBody, str, notifyWay);
        if (messageCenterMsgObjM74161l == null) {
            C11839m.m70687e("OperateMsgProcessor", "processTextMessage, data process error, msgObj is null");
            MessageCenterReportUtil.reportMsgProcInterrupted(clientMessageBody, str, "build_text_msg_failed");
        } else {
            MessageCenterReportUtil.reportOperateMsgProcSuccess(clientMessageBody, str, notifyWay);
            MessageCenterManager.getInstance().insertMessageCenterData(messageCenterMsgObjM74161l);
        }
    }

    /* renamed from: q */
    public final boolean m74176q(String str, ClientMessageBody clientMessageBody, HiCloudMsgNoticeAction hiCloudMsgNoticeAction, NotifyWay notifyWay) {
        List<String> params = hiCloudMsgNoticeAction.getParams();
        List<String> realTimeParams = hiCloudMsgNoticeAction.getRealTimeParams();
        String trigger = hiCloudMsgNoticeAction.getTrigger();
        List<Integer> triggerScope = hiCloudMsgNoticeAction.getTriggerScope();
        int i10 = (triggerScope == null || !triggerScope.contains(3)) ? 0 : 1;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("unique_id", str);
        linkedHashMap.put("resource_id", clientMessageBody.getCfgResourceId());
        linkedHashMap.put(Constants.AUTOCONTENT_CATEGORY, clientMessageBody.getCategory());
        linkedHashMap.put("notify_type", clientMessageBody.getNotifyType());
        linkedHashMap.put("notify_way_name", notifyWay.getName());
        linkedHashMap.put("notify_way_msg_type", notifyWay.getMsgType());
        linkedHashMap.put("actionType", String.valueOf(hiCloudMsgNoticeAction.getAction()));
        return C1009d.m6109e().m6119k(params, realTimeParams, trigger, i10, linkedHashMap);
    }

    /* renamed from: r */
    public final boolean m74177r(String str, ClientMessageBody clientMessageBody, HiCloudMsgNoticeAction hiCloudMsgNoticeAction, NotifyWay notifyWay) {
        String trigger = hiCloudMsgNoticeAction.getTrigger();
        List<Integer> triggerScope = hiCloudMsgNoticeAction.getTriggerScope();
        int i10 = (triggerScope == null || !triggerScope.contains(2)) ? 0 : 1;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("unique_id", str);
        linkedHashMap.put("resource_id", clientMessageBody.getCfgResourceId());
        linkedHashMap.put(Constants.AUTOCONTENT_CATEGORY, clientMessageBody.getCategory());
        linkedHashMap.put("notify_type", clientMessageBody.getNotifyType());
        linkedHashMap.put("notify_way_name", notifyWay.getName());
        linkedHashMap.put("actionType", String.valueOf(hiCloudMsgNoticeAction.getAction()));
        return C1009d.m6109e().m6119k(new ArrayList(), new ArrayList(), trigger, i10, linkedHashMap);
    }

    @Override // com.huawei.hicloud.messagecenter.manager.BaseMsgProcessor
    public void sendNotification(NotifyNeedData notifyNeedData, ClientMessageBody clientMessageBody) throws IOException {
        MessageNotificationManager messageNotificationManager = new MessageNotificationManager(C0213f.m1377a());
        if (notifyNeedData == null || clientMessageBody == null) {
            NotifyLogger.m29916w("OperateMsgProcessor", "processNotifyCompatBuilder, notifyNeedData or message is null");
            messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(false, "com.huawei.android.hicloud"), notifyNeedData);
            return;
        }
        String notifyType = clientMessageBody.getNotifyType();
        boolean zIsSilent = notifyNeedData.isSilent();
        if (C13616a.m81911c().contains(clientMessageBody.getNotifyType())) {
            if (C9162c.m57580a().contains(notifyType)) {
                messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(zIsSilent, "com.huawei.android.hicloud"), notifyNeedData);
                return;
            } else {
                messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(zIsSilent, "com.huawei.android.hicloud", 2, "promo"), notifyNeedData, 2, "promo");
                return;
            }
        }
        if (!TextUtils.equals(notifyType, "download_app")) {
            messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(zIsSilent, "com.huawei.android.hicloud"), notifyNeedData);
            return;
        }
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        HiCloudMsgNoticeAction actionById = HiCloudMsgNoticeConfigManager.getInstance().getActionById(cfgResourceId);
        if (actionById != null) {
            if (C9162c.m57583d(actionById.getIncentiveScenes())) {
                messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(zIsSilent, "com.huawei.android.hicloud", 4, "reminder"), notifyNeedData, 4, "reminder");
                return;
            } else {
                messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(zIsSilent, "com.huawei.android.hicloud", 2, "promo"), notifyNeedData, 2, "promo");
                return;
            }
        }
        NotifyLogger.m29916w("OperateMsgProcessor", "processNotifyCompatBuilder, no action, config id: " + cfgResourceId);
        messageNotificationManager.sendNotification(NotifyUtil.getNotificationBuilder(zIsSilent, "com.huawei.android.hicloud"), notifyNeedData);
    }

    /* renamed from: t */
    public final String m74178t(ClientMessageBody clientMessageBody, String str) {
        if (!TextUtils.equals(clientMessageBody.getNotifyType(), "custom_marketing") || !str.contains("%{usage}")) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.dsu.cloud.usage");
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(arrayList, null, "OperateMsg");
        if (listM84949i == null || listM84949i.size() == 0) {
            NotifyLogger.m29916w("OperateMsgProcessor", "custom msg getParam return empty");
            return null;
        }
        return str.replace("%{usage}", C0223k.m1524g(C0213f.m1377a(), C0241z.m1688f(listM84949i.get(0).m30027c())));
    }

    /* renamed from: u */
    public final void m74179u(ClientMessageBody clientMessageBody, MessageCenterMsgObj messageCenterMsgObj) throws IOException {
        if (clientMessageBody == null || messageCenterMsgObj == null) {
            C11839m.m70688i("OperateMsgProcessor", "setOperateMsgNotifyId, param is null.");
            return;
        }
        if (!messageContainsNotify(clientMessageBody)) {
            C11839m.m70688i("OperateMsgProcessor", "setOperateMsgNotifyId, message not contain notify.");
            return;
        }
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        HiCloudMsgNoticeAction actionById = HiCloudMsgNoticeConfigManager.getInstance().getActionById(cfgResourceId);
        if (actionById == null) {
            C11839m.m70688i("OperateMsgProcessor", "setOperateMsgNotifyId, no action, config id: " + cfgResourceId);
            return;
        }
        int operateMsgNotifyIdByAction = MessageCenterManager.getInstance().getOperateMsgNotifyIdByAction(actionById.getAction());
        if (operateMsgNotifyIdByAction == -1) {
            C11839m.m70687e("OperateMsgProcessor", "setOperateMsgNotifyId, get notifyId error.");
        } else {
            messageCenterMsgObj.setNotifyId(operateMsgNotifyIdByAction);
        }
    }
}
