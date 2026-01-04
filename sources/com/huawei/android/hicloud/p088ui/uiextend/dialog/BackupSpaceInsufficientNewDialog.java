package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice.BackupSpaceInsufficientNotifyUtil;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceMemberShareActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.util.HiCloudLink;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import id.C10469c;
import id.C10470d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0234s;
import p336he.C10152c;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p676ud.AlertDialogC13154a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;
import tl.C13026e;

/* loaded from: classes3.dex */
public class BackupSpaceInsufficientNewDialog extends AlertDialogC13154a implements View.OnClickListener {
    private static final int CORRECT_CODE = 7777;
    private static final int DEFAULT_NUM = 2;
    private static final String DIALIG_POPUP_TYPE = "dialog_type";
    private static final int ERROR_CODE = 1111;
    private static final String POPUP_TYPE_CLOSE = "close";
    private static final String TAG = "BackupSpaceInsufficientNewDialog";
    private C12295b backupNoticeNeedInfo;
    private BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData;
    private String buttonFirst;
    private String buttonSecond;
    private AutoSizeButton cancelButton;
    private AutoSizeButton confirmButton;
    private TextView dialogContent;
    private String dialogContentStr;
    private final Handler dialogHandler;
    private TextView dialogTitle;
    private String dialogTitleStr;
    private float fontScale;
    private String gotoButtonWhich;
    private boolean isFamilyShareMember;
    private final Context mContext;
    private int notificationActivityType;
    private final BackupSpaceInsufficientNotifyUtil notifyUtil;
    private final Map<String, PopUpWithActivityGoto> popUpWithActivityGotoMap;
    private Intent positiveGotoIntent;
    private BaseSpaceNotifyBean spaceNotifyBean;
    private View view;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientNewDialog$1 */
    public class HandlerC41801 extends Handler {
        public HandlerC41801() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == BackupSpaceInsufficientNewDialog.ERROR_CODE) {
                C11839m.m70687e(BackupSpaceInsufficientNewDialog.TAG, "Get configuration is empty");
                NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC, "Get configuration is empty, 1111");
                BackupSpaceInsufficientNewDialog.this.finish();
            } else {
                if (i10 != BackupSpaceInsufficientNewDialog.CORRECT_CODE) {
                    BackupSpaceInsufficientNewDialog.this.finish();
                    return;
                }
                Object obj = message.obj;
                try {
                    BackupSpaceInsufficientNewDialog.this.showSpaceNotEnoughDialog(obj instanceof SpaceNotification ? (SpaceNotification) obj : null);
                } catch (Exception e10) {
                    C11839m.m70687e(BackupSpaceInsufficientNewDialog.TAG, "handleMessage CORRECT_CODE err: " + e10.getMessage());
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC, e10.getMessage());
                    BackupSpaceInsufficientNewDialog.this.finish();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientNewDialog$2 */
    public class C41812 extends AbstractC12367d {
        final /* synthetic */ BaseSpaceNotifyBean val$notification;

        public C41812(BaseSpaceNotifyBean baseSpaceNotifyBean) {
            baseSpaceNotifyBean = baseSpaceNotifyBean;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Message message = new Message();
            try {
                BaseSpaceNotifyBean baseSpaceNotifyBeanPrepareIncentiveDialog = (BackupSpaceInsufficientNewDialog.this.notificationActivityType == 1 || BackupSpaceInsufficientNewDialog.this.notificationActivityType == 4) ? BackupSpaceInsufficientNewDialog.this.prepareIncentiveDialog(baseSpaceNotifyBean) : BackupSpaceInsufficientNewDialog.this.prepareNormalDialog(baseSpaceNotifyBean);
                if (baseSpaceNotifyBeanPrepareIncentiveDialog != null) {
                    message.obj = baseSpaceNotifyBeanPrepareIncentiveDialog;
                    message.what = BackupSpaceInsufficientNewDialog.CORRECT_CODE;
                } else {
                    message.what = BackupSpaceInsufficientNewDialog.ERROR_CODE;
                }
                BackupSpaceInsufficientNewDialog.this.dialogHandler.sendMessage(message);
            } catch (Exception e10) {
                message.what = BackupSpaceInsufficientNewDialog.ERROR_CODE;
                BackupSpaceInsufficientNewDialog.this.dialogHandler.sendMessage(message);
                NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0001", "0032", "exception: " + e10);
            }
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BackupSpaceInsufficientNewDialog.this.finish();
        }
    }

    public BackupSpaceInsufficientNewDialog(Context context) {
        super(context);
        this.gotoButtonWhich = "";
        this.buttonFirst = "";
        this.buttonSecond = "";
        this.popUpWithActivityGotoMap = new HashMap();
        this.dialogHandler = new Handler() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientNewDialog.1
            public HandlerC41801() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i10 = message.what;
                if (i10 == BackupSpaceInsufficientNewDialog.ERROR_CODE) {
                    C11839m.m70687e(BackupSpaceInsufficientNewDialog.TAG, "Get configuration is empty");
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC, "Get configuration is empty, 1111");
                    BackupSpaceInsufficientNewDialog.this.finish();
                } else {
                    if (i10 != BackupSpaceInsufficientNewDialog.CORRECT_CODE) {
                        BackupSpaceInsufficientNewDialog.this.finish();
                        return;
                    }
                    Object obj = message.obj;
                    try {
                        BackupSpaceInsufficientNewDialog.this.showSpaceNotEnoughDialog(obj instanceof SpaceNotification ? (SpaceNotification) obj : null);
                    } catch (Exception e10) {
                        C11839m.m70687e(BackupSpaceInsufficientNewDialog.TAG, "handleMessage CORRECT_CODE err: " + e10.getMessage());
                        NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC, e10.getMessage());
                        BackupSpaceInsufficientNewDialog.this.finish();
                    }
                }
            }
        };
        this.mContext = context;
        this.notifyUtil = new BackupSpaceInsufficientNotifyUtil();
        setCanceledOnTouchOutside(false);
        initView();
    }

    private boolean checkBtnStrValid() {
        if (!TextUtils.isEmpty(this.buttonFirst) && !TextUtils.isEmpty(this.buttonSecond)) {
            return true;
        }
        C11839m.m70687e(TAG, "checkBtnStrValid btn str is empty , buttonFirst = " + this.buttonFirst + " buttonSecond = " + this.buttonSecond);
        return false;
    }

    private void clickCancel() throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put("notify_id", this.spaceNotifyBean.getId());
            jSONObjectM79482j.put("notify_type", "2");
            jSONObjectM79482j.put("click_upgrade_later", true);
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, this.spaceNotifyBean.getPercentage());
            jSONObjectM79482j.put("dialog_type", 2);
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.notificationActivityType);
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(C0213f.m1377a(), jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "9", jSONObjectM79482j);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("is_auto_backup", String.valueOf(this.backupNoticeNeedInfo.m73875c()));
        linkedHashMapM79499C.put("user_type", C13452e.m80781L().m80790C());
        linkedHashMapM79499C.put("is_third_app_switch_open", String.valueOf(new C13026e().m78395p()));
        linkedHashMapM79499C.put("click_text", String.valueOf(-2));
        linkedHashMapM79499C.put("recommend_space_needed", Long.valueOf(this.backupSpaceNotEnoughNeedData.getTotalNeedSpace()));
        linkedHashMapM79499C.put("dialog_type", 2);
        linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.notificationActivityType));
        SafeIntent safeIntent = new SafeIntent(getNegativeGotoIntent(this.spaceNotifyBean));
        String stringExtra = safeIntent.getStringExtra("gotoType");
        String stringExtra2 = safeIntent.getStringExtra("gotoUri");
        String stringExtra3 = safeIntent.getStringExtra("gotoDeeplink");
        linkedHashMapM79499C.put("gotoType", stringExtra);
        linkedHashMapM79499C.put("gotoUri", stringExtra2);
        if (C12590s0.m75807V0(stringExtra3)) {
            linkedHashMapM79499C.put("gotoDeeplink", stringExtra3);
        }
        C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_notenough_later", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacedialog_notenough_later", "4", "10", linkedHashMapM79499C);
        if (this.backupNoticeNeedInfo.m73875c()) {
            C11839m.m70688i(TAG, "click cancel, add record");
            UserNegFeedbackManager.getInstance(this.mContext).addRecordCount(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
        }
        jumpToActivity(safeIntent);
        finish();
        processRemoveTask();
        C10152c.m63217a();
    }

    private void clickConfirm() throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put("notify_id", this.spaceNotifyBean.getId());
            jSONObjectM79482j.put("notify_type", "2");
            jSONObjectM79482j.put("click_upgrade_cloudSpace", true);
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, this.spaceNotifyBean.getPercentage());
            jSONObjectM79482j.put("dialog_type", 2);
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.notificationActivityType);
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(C0213f.m1377a(), jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "1", "43", jSONObjectM79482j);
        if (this.positiveGotoIntent == null) {
            C11839m.m70689w(TAG, "positive button positiveGotoIntent is null");
            finish();
            return;
        }
        reportSpaceNotEnoughDialogButtonClick();
        jumpToActivity(this.positiveGotoIntent);
        reportViewDetails();
        finish();
        processRemoveTask();
        C10152c.m63217a();
    }

    private void doSpaceNotEnoughReport(LinkedHashMap linkedHashMap, float f10) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.notificationActivityType);
            jSONObjectM79482j.put("dialog_type", 2);
            jSONObjectM79482j.put("notify_id", this.spaceNotifyBean.getId());
            jSONObjectM79482j.put("notify_type", "2");
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, f10);
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(C0213f.m1377a(), jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_SHOW", "4", "9", jSONObjectM79482j);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("notify_id", Integer.valueOf(this.spaceNotifyBean.getId()));
        linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.notificationActivityType));
        linkedHashMapM79499C.put("dialog_btn_num", 2);
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(f10));
        linkedHashMapM79499C.put("is_auto_backup", String.valueOf(this.backupNoticeNeedInfo.m73875c()));
        linkedHashMapM79499C.put("user_type", C13452e.m80781L().m80790C());
        linkedHashMapM79499C.put("is_third_app_switch_open", String.valueOf(new C13026e().m78395p()));
        linkedHashMapM79499C.put("is_new_dialog", Boolean.TRUE);
        linkedHashMapM79499C.put("recommend_space_needed", Long.valueOf(this.backupSpaceNotEnoughNeedData.getTotalNeedSpace()));
        linkedHashMapM79499C.put("dialog_type", 2);
        linkedHashMapM79499C.put("current_language", C0234s.m1631i());
        if (!TextUtils.isEmpty(this.backupNoticeNeedInfo.m73879g())) {
            linkedHashMapM79499C.put("forground_activity", this.backupNoticeNeedInfo.m73879g());
        }
        C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_not_enough_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacedialog_not_enough_show", "4", "9", linkedHashMapM79499C);
        Long lValueOf = Long.valueOf(new SettingOperator().queryinitopentime());
        LinkedHashMap<String, String> linkedHashMapM79499C2 = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C2.put("deviceId", C13452e.m80781L().m80954p());
        linkedHashMapM79499C2.put("initOpenTime", lValueOf.toString());
        linkedHashMapM79499C2.put("dialog_time", "1");
        linkedHashMapM79499C2.put("dialog_type", String.valueOf(2));
        if (this.notificationActivityType == 1) {
            linkedHashMapM79499C2.put("is_support_activity", FaqConstants.DISABLE_HA_REPORT);
        } else {
            linkedHashMapM79499C2.put("is_support_activity", "false");
        }
        C11839m.m70688i(TAG, "report space not enough");
        C13225d.m79490f1().m79603z0("cloudbackup_space_not_enough_dialog", linkedHashMapM79499C2);
    }

    public void finish() {
        if (isShowing()) {
            dismiss();
        }
        Context context = this.mContext;
        if (context == null || !(context instanceof BackupNotificationActivity)) {
            return;
        }
        ((BackupNotificationActivity) context).finish();
    }

    private Intent getGotoIntent(BaseSpaceNotifyBean baseSpaceNotifyBean, boolean z10) {
        String popupType;
        String popupUri;
        String deeplinkUri;
        PopUpWithActivityGoto popUpWithActivityGoto;
        C12295b c12295b;
        NoticeDetail noticeContentDetail = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetail(baseSpaceNotifyBean);
        NoticeGoto noticeGoto = baseSpaceNotifyBean.getNoticeGoto();
        if (noticeContentDetail == null) {
            C11839m.m70689w(TAG, "getGotoIntent detailContent is null");
            return null;
        }
        if (noticeGoto != null) {
            if (NotifyConstants.DETAIL2.equals(noticeGoto.getPopupType())) {
                noticeContentDetail = C10152c.m63224h(baseSpaceNotifyBean);
            }
            popupType = noticeGoto.getPopupType();
            popupUri = noticeGoto.getPopupUri();
            deeplinkUri = noticeGoto.getPopupDeeplink();
        } else {
            popupType = "";
            popupUri = "";
            deeplinkUri = popupUri;
        }
        if ((baseSpaceNotifyBean.getActivityType() == 1 || baseSpaceNotifyBean.getActivityType() == 4) && (popUpWithActivityGoto = getPopUpWithActivityGoto(z10)) != null) {
            popupType = popUpWithActivityGoto.getPopupType();
            popupUri = popUpWithActivityGoto.getPopupUri();
            deeplinkUri = popUpWithActivityGoto.getDeeplinkUri();
            if (TextUtils.isEmpty(popupType)) {
                return null;
            }
        }
        if (!NotifyConstants.DETAIL2.equals(popupType) && !NotifyConstants.DETAIL3.equals(popupType) && (TextUtils.isEmpty(popupType) || (TextUtils.isEmpty(popupUri) && !"detail".equals(popupType)))) {
            C11839m.m70689w(TAG, "uriType or uriStr is null.");
            if (noticeGoto != null) {
                popupType = noticeGoto.getType();
                popupUri = noticeGoto.getUri();
                deeplinkUri = noticeGoto.getPopupDeeplink();
            }
            if (!new HiCloudLink(this.mContext).checkModuleEnable(popupType, popupUri)) {
                C11839m.m70688i(TAG, "link disable type=" + popupType + ", uri=" + popupUri);
                return null;
            }
        }
        Intent gotoPopup = this.notifyUtil.getGotoPopup(this.mContext, popupType, popupUri, deeplinkUri);
        if (gotoPopup == null) {
            C11839m.m70688i(TAG, "intent is null");
            return null;
        }
        if (NotifyConstants.BUY_MORE.equals(popupUri)) {
            gotoPopup.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        } else {
            if (NotifyConstants.HICLOUD_DLAPP.equals(popupUri) && (c12295b = this.backupNoticeNeedInfo) != null && c12295b.m73874b() != null) {
                String url = this.backupNoticeNeedInfo.m73874b().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    gotoPopup.putExtra("url", url + "&clientVersion=" + C1443a.f6213a);
                }
            }
            gotoPopup.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        }
        if ("detail".equals(popupType)) {
            gotoPopup.putExtra("backup_notification_type", 12);
        } else if (NotifyConstants.DETAIL2.equals(popupType)) {
            gotoPopup.putExtra("backup_notification_type", 13);
        } else if (NotifyConstants.DETAIL3.equals(popupType)) {
            gotoPopup.putExtra("backup_notification_type", 15);
        }
        gotoPopup.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        recommendNeedData.setId(baseSpaceNotifyBean.getId());
        recommendNeedData.setTitle(SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentDetail.getTitle(), baseSpaceNotifyBean.getId()));
        recommendNeedData.setMainText(SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentDetail.getMainText(), baseSpaceNotifyBean.getId()));
        recommendNeedData.setSubTitle(SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentDetail.getSbuTitle(), baseSpaceNotifyBean.getId()));
        recommendNeedData.setSecondMainText(SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentDetail.getMainTextSecond(), baseSpaceNotifyBean.getId()));
        recommendNeedData.setChooseOtherCaseText(SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentDetail.getButtonFirst(), baseSpaceNotifyBean.getId()));
        recommendNeedData.setRecommendType(baseSpaceNotifyBean.getNoticeType());
        recommendNeedData.setEnterType(1);
        recommendNeedData.setTotalNeedSpace(this.backupSpaceNotEnoughNeedData.getTotalNeedSpace());
        recommendNeedData.setBackupNeedSpace(this.backupSpaceNotEnoughNeedData.getBackupNeedSpace());
        recommendNeedData.setNotUsedSpace(this.backupSpaceNotEnoughNeedData.getNotUsedSpace());
        recommendNeedData.setActivityType(this.notificationActivityType);
        recommendNeedData.setActivityWithTaskCenter(this.backupNoticeNeedInfo.m73881j() == 2);
        gotoPopup.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        return gotoPopup;
    }

    private Intent getMemberIntent(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (baseSpaceNotifyBean == null) {
            C11839m.m70687e(TAG, "getMemberIntent spaceNotification is null.");
            return null;
        }
        NoticeDetail noticeContentDetailMember = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailMember(baseSpaceNotifyBean);
        if (noticeContentDetailMember == null) {
            C11839m.m70687e(TAG, "getMemberIntent memberNoticeContent is null.");
            return null;
        }
        MemberShareDetail memberShareDetail = new MemberShareDetail();
        memberShareDetail.setTitle(SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeContentDetailMember.getTitle(), baseSpaceNotifyBean.getId()));
        memberShareDetail.setMainText(SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeContentDetailMember.getMainText(), baseSpaceNotifyBean.getId()));
        memberShareDetail.setButtonText(SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeContentDetailMember.getButtonFirst(), baseSpaceNotifyBean.getId()));
        memberShareDetail.setNotifyType(baseSpaceNotifyBean.getNoticeType());
        Intent intent = new Intent();
        intent.setClass(this.mContext, CloudSpaceMemberShareActivity.class);
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL, memberShareDetail);
        intent.putExtra("gotoType", CloudSpaceMemberShareActivity.class.getSimpleName());
        return intent;
    }

    private Intent getNegativeGotoIntent(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        int activityType = baseSpaceNotifyBean.getActivityType();
        if (activityType != 1 && activityType != 4) {
            return null;
        }
        Intent gotoIntent = getGotoIntent(baseSpaceNotifyBean, false);
        C0216g0.m1402e(this.mContext).m1407E(gotoIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
        return gotoIntent;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto getPopUpWithActivityGoto(boolean r5) {
        /*
            r4 = this;
            java.lang.String r0 = "button_first"
            java.lang.String r1 = "button_which1"
            java.lang.String r2 = "button_second"
            java.lang.String r3 = "button_which2"
            if (r5 == 0) goto L1d
            java.lang.String r5 = r4.gotoButtonWhich
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L14
        L12:
            r0 = r2
            goto L31
        L14:
            java.lang.String r5 = r4.gotoButtonWhich
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L2f
            goto L31
        L1d:
            java.lang.String r5 = r4.gotoButtonWhich
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L26
            goto L31
        L26:
            java.lang.String r5 = r4.gotoButtonWhich
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L2f
            goto L12
        L2f:
            java.lang.String r0 = ""
        L31:
            java.util.Map<java.lang.String, com.huawei.hicloud.notification.db.bean.PopUpWithActivityGoto> r5 = r4.popUpWithActivityGotoMap
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto L42
            java.util.Map<java.lang.String, com.huawei.hicloud.notification.db.bean.PopUpWithActivityGoto> r4 = r4.popUpWithActivityGotoMap
            java.lang.Object r4 = r4.get(r0)
            com.huawei.hicloud.notification.db.bean.PopUpWithActivityGoto r4 = (com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto) r4
            return r4
        L42:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientNewDialog.getPopUpWithActivityGoto(boolean):com.huawei.hicloud.notification.db.bean.PopUpWithActivityGoto");
    }

    private Intent getPositiveGotoIntent(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        Intent memberIntent = this.isFamilyShareMember ? getMemberIntent(baseSpaceNotifyBean) : getGotoIntent(baseSpaceNotifyBean, true);
        C0216g0.m1402e(this.mContext).m1407E(memberIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
        return memberIntent;
    }

    private NoticeGoto initDialogNomalButtonInfo(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        NoticeGoto noticeGoto = baseSpaceNotifyBean.getNoticeGoto();
        if (noticeGoto == null) {
            noticeGoto = new NoticeGoto();
            noticeGoto.setPopupType(NotifyConstants.DETAIL3);
            noticeGoto.setGotoButtonWhich(NotifyConstants.GOTO_BUTTON_FIRST);
            baseSpaceNotifyBean.setNoticeGoto(noticeGoto);
        }
        if (TextUtils.isEmpty(noticeGoto.getGotoButtonWhich())) {
            C11839m.m70688i(TAG, "initDialogNomalButtonInfo noticegoto or gotoButtonWhich is null");
            return null;
        }
        this.gotoButtonWhich = noticeGoto.getGotoButtonWhich();
        return noticeGoto;
    }

    private boolean initIncentiveDialogText(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (baseSpaceNotifyBean.getActivityType() == 1) {
            C12295b c12295b = this.backupNoticeNeedInfo;
            if (c12295b != null && c12295b.m73874b() != null) {
                String resource = this.backupNoticeNeedInfo.m73874b().getResource();
                if (HicloudH5ConfigManager.getInstance().getH5ResourceById(resource) != null) {
                    this.dialogTitleStr = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V5_POP_TITLE);
                    this.dialogContentStr = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V5_MAIN_TEXT);
                    this.buttonFirst = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V5_POP_BUTTON_FIRST);
                    this.buttonSecond = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V5_POP_BUTTON_SECOND);
                    if (!TextUtils.isEmpty(this.dialogTitleStr) && !TextUtils.isEmpty(this.dialogContentStr) && !TextUtils.isEmpty(this.buttonFirst) && !TextUtils.isEmpty(this.buttonSecond)) {
                        C11839m.m70687e(TAG, "initIncentiveDialogText init success.");
                        return true;
                    }
                }
            }
        } else if (baseSpaceNotifyBean.getActivityType() == 4) {
            NoticeContent noticeContentPopup = CloudSpaceNotifyUtil.getInstance().getNoticeContentPopup(baseSpaceNotifyBean);
            if (!prepareDialogTitleAndContent(noticeContentPopup, baseSpaceNotifyBean.getId())) {
                C11839m.m70688i(TAG, "prepareDialogTitleAndContent is null");
                return false;
            }
            if (prepareBtnAndDescription(noticeContentPopup, baseSpaceNotifyBean.getId())) {
                return true;
            }
            C11839m.m70688i(TAG, "prepareBtnAndDescription is null");
            return false;
        }
        C11839m.m70687e(TAG, "initIncentiveDialogText error.");
        return false;
    }

    private void initView() {
        setOnCancelListener(new DialogOnCancelListener());
        this.fontScale = C0209d.m1195O(C0213f.m1377a());
        this.view = LayoutInflater.from(this.mContext).inflate(R$layout.space_not_enough_new_dialog_msg_with_icon, (ViewGroup) null);
        if (this.fontScale >= 3.2f) {
            this.view = LayoutInflater.from(this.mContext).inflate(R$layout.space_not_enough_new_dialog_msg_with_icon_3dot2, (ViewGroup) null);
        }
        this.dialogTitle = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_dialog_tittle);
        this.dialogContent = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_dialog_content);
        this.cancelButton = (AutoSizeButton) C12809f.m76831d(this.view, R$id.bt_cancel);
        this.confirmButton = (AutoSizeButton) C12809f.m76831d(this.view, R$id.bt_confirm);
        setView(this.view);
    }

    private void jumpToActivity(Intent intent) {
        if (intent == null) {
            C11839m.m70687e(TAG, "jumpToActivity intent null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("gotoDeeplink");
            int intExtra = intent.getIntExtra(NotifyConstants.BackupNotificationType.FIELD, 0);
            if (intExtra == 7 || intExtra == 8 || C12590s0.m75807V0(stringExtra)) {
                C13230i.m79522d1(new Bundle(), "4", "9");
                C11839m.m70688i(TAG, "positive button jump guide, the deeplink is :" + stringExtra);
                this.mContext.startActivity(intent);
            } else {
                C11839m.m70687e(TAG, "jumpToActivity invalid type = " + intExtra);
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "jumpToActivity exception " + e10);
        }
    }

    private boolean prepareBtnAndDescription(NoticeContent noticeContent, int i10) {
        if (SpaceInsuffNoticeV4Manager.getInstance().checkMultiLanguage(i10, noticeContent.getButtonFirst(), noticeContent.getButtonSecond())) {
            this.buttonFirst = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeContent.getButtonFirst(), i10);
            this.buttonSecond = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeContent.getButtonSecond(), i10);
            return true;
        }
        C11839m.m70687e(TAG, "prepareBtnAndDescription checkMultiLanguage fail");
        this.buttonFirst = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeContent.getButtonFirst(), i10);
        this.buttonSecond = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(noticeContent.getButtonSecond(), i10);
        if (TextUtils.isEmpty(this.buttonFirst) || TextUtils.isEmpty(this.buttonSecond)) {
            return false;
        }
        C11839m.m70687e(TAG, "prepareBtnAndDescription get defaul language");
        return true;
    }

    private boolean prepareDialogTitleAndContent(NoticeContent noticeContent, int i10) {
        if (noticeContent == null) {
            C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog popupContent null");
            return false;
        }
        boolean zM80897c1 = C13452e.m80781L().m80897c1();
        this.dialogTitleStr = NotifyUtil.filterNoticeTitle(noticeContent, zM80897c1, this.backupNoticeNeedInfo.m73875c(), NotifyUtil.TITLE_V4, i10);
        String strFilterNoticeMainText = NotifyUtil.filterNoticeMainText(noticeContent, zM80897c1, this.backupNoticeNeedInfo.m73875c(), NotifyUtil.MAIN_TEXT_V4, i10);
        this.dialogContentStr = strFilterNoticeMainText;
        if (!TextUtils.isEmpty(strFilterNoticeMainText) && !TextUtils.isEmpty(this.dialogTitleStr)) {
            return true;
        }
        C11839m.m70687e(TAG, "prepareDialogTitleAndContent mainText = " + this.dialogContentStr + " or title = " + this.dialogTitleStr + " is null.");
        return false;
    }

    public BaseSpaceNotifyBean prepareIncentiveDialog(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "prepareIncentiveDialog account is not login.");
            return null;
        }
        if (baseSpaceNotifyBean == null || baseSpaceNotifyBean.getPopupeGoto() == null || baseSpaceNotifyBean.getPopupeGoto().isEmpty()) {
            C11839m.m70688i(TAG, "prepareIncentiveDialog spaceNotification is null");
            return null;
        }
        C11839m.m70688i(TAG, "prepareIncentiveDialog id = " + baseSpaceNotifyBean.getId());
        String str = "";
        for (PopUpWithActivityGoto popUpWithActivityGoto : baseSpaceNotifyBean.getPopupeGoto()) {
            String code = popUpWithActivityGoto.getCode();
            if (NotifyConstants.POP_GOTO_BUTTON_FIRST.equalsIgnoreCase(code) || NotifyConstants.POP_GOTO_BUTTON_SECOND.equalsIgnoreCase(code)) {
                this.popUpWithActivityGotoMap.put(code, popUpWithActivityGoto);
            }
            if ("close".equalsIgnoreCase(popUpWithActivityGoto.getPopupType())) {
                str = code;
            }
        }
        if (this.popUpWithActivityGotoMap.isEmpty()) {
            C11839m.m70688i(TAG, "popUpWithActivityGotoMap is empty");
            return null;
        }
        if (NotifyConstants.POP_GOTO_BUTTON_SECOND.equalsIgnoreCase(str)) {
            this.gotoButtonWhich = NotifyConstants.GOTO_BUTTON_FIRST;
        } else {
            this.gotoButtonWhich = NotifyConstants.GOTO_BUTTON_SECOND;
        }
        if (initIncentiveDialogText(baseSpaceNotifyBean)) {
            this.positiveGotoIntent = getPositiveGotoIntent(baseSpaceNotifyBean);
            return baseSpaceNotifyBean;
        }
        C11839m.m70688i(TAG, "initIncentiveDialogText error, return null");
        return null;
    }

    public BaseSpaceNotifyBean prepareNormalDialog(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "prepareSpaceInsufficientDialog account is not login.");
            return null;
        }
        if (baseSpaceNotifyBean == null) {
            C11839m.m70688i(TAG, "prepareSpaceInsufficientDialog spaceNotification is null");
            return null;
        }
        C11839m.m70688i(TAG, "prepareSpaceInsufficientDialog id = " + baseSpaceNotifyBean.getId());
        if (initDialogNomalButtonInfo(baseSpaceNotifyBean) == null) {
            C11839m.m70688i(TAG, "initDialogButtonInfo is null");
            return null;
        }
        NoticeContent noticeContentPopup = CloudSpaceNotifyUtil.getInstance().getNoticeContentPopup(baseSpaceNotifyBean);
        if (!prepareDialogTitleAndContent(noticeContentPopup, baseSpaceNotifyBean.getId())) {
            C11839m.m70688i(TAG, "prepareDialogTitleAndContent is null");
            return null;
        }
        if (prepareBtnAndDescription(noticeContentPopup, baseSpaceNotifyBean.getId())) {
            this.positiveGotoIntent = getPositiveGotoIntent(baseSpaceNotifyBean);
            return baseSpaceNotifyBean;
        }
        C11839m.m70688i(TAG, "prepareBtnAndDescription is null");
        return null;
    }

    private void processRemoveTask() {
        C10469c.m64350p(this.mContext).m64349m(true);
        C10469c.m64350p(this.mContext).cancel();
        C12515a.m75110o().m75165a1(C10469c.m64350p(this.mContext));
        C10470d.m64355p(this.mContext).m64349m(true);
        C10470d.m64355p(this.mContext).cancel();
        C12515a.m75110o().m75165a1(C10470d.m64355p(this.mContext));
    }

    private void processSpaceNotEnough(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        int activityType = baseSpaceNotifyBean.getActivityType();
        C11839m.m70688i(TAG, "Is From isActivityType = " + activityType);
        this.backupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
        this.backupNoticeNeedInfo = c12295b;
        this.spaceNotifyBean = baseSpaceNotifyBean;
        this.isFamilyShareMember = backupSpaceNotEnoughNeedData.isFamilyShareMember();
        this.notificationActivityType = activityType;
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientNewDialog.2
            final /* synthetic */ BaseSpaceNotifyBean val$notification;

            public C41812(BaseSpaceNotifyBean baseSpaceNotifyBean2) {
                baseSpaceNotifyBean = baseSpaceNotifyBean2;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                Message message = new Message();
                try {
                    BaseSpaceNotifyBean baseSpaceNotifyBeanPrepareIncentiveDialog = (BackupSpaceInsufficientNewDialog.this.notificationActivityType == 1 || BackupSpaceInsufficientNewDialog.this.notificationActivityType == 4) ? BackupSpaceInsufficientNewDialog.this.prepareIncentiveDialog(baseSpaceNotifyBean) : BackupSpaceInsufficientNewDialog.this.prepareNormalDialog(baseSpaceNotifyBean);
                    if (baseSpaceNotifyBeanPrepareIncentiveDialog != null) {
                        message.obj = baseSpaceNotifyBeanPrepareIncentiveDialog;
                        message.what = BackupSpaceInsufficientNewDialog.CORRECT_CODE;
                    } else {
                        message.what = BackupSpaceInsufficientNewDialog.ERROR_CODE;
                    }
                    BackupSpaceInsufficientNewDialog.this.dialogHandler.sendMessage(message);
                } catch (Exception e10) {
                    message.what = BackupSpaceInsufficientNewDialog.ERROR_CODE;
                    BackupSpaceInsufficientNewDialog.this.dialogHandler.sendMessage(message);
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0001", "0032", "exception: " + e10);
                }
            }
        });
    }

    private void reportSpaceNotEnoughDialogButtonClick() {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("is_auto_backup", String.valueOf(this.backupNoticeNeedInfo.m73875c()));
        linkedHashMapM79499C.put("user_type", C13452e.m80781L().m80790C());
        linkedHashMapM79499C.put("is_third_app_switch_open", String.valueOf(new C13026e().m78395p()));
        linkedHashMapM79499C.put("click_text", String.valueOf(-1));
        linkedHashMapM79499C.put("recommend_space_needed", Long.valueOf(this.backupSpaceNotEnoughNeedData.getTotalNeedSpace()));
        linkedHashMapM79499C.put("dialog_type", 2);
        if (this.positiveGotoIntent != null) {
            SafeIntent safeIntent = new SafeIntent(this.positiveGotoIntent);
            linkedHashMapM79499C.put("gotoType", safeIntent.getStringExtra("gotoType"));
            linkedHashMapM79499C.put("gotoUri", safeIntent.getStringExtra("gotoUri"));
            String stringExtra = safeIntent.getStringExtra("gotoDeeplink");
            if (C12590s0.m75807V0(stringExtra)) {
                linkedHashMapM79499C.put("gotoDeeplink", stringExtra);
            }
        }
        C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_notenough_upgrade", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacedialog_notenough_upgrade", "4", "10", linkedHashMapM79499C);
    }

    private void reportViewDetails() {
        Intent intent = this.positiveGotoIntent;
        if (intent == null) {
            C11839m.m70689w(TAG, "positive button positiveGotoIntent is null");
            return;
        }
        try {
            int intExtra = intent.getIntExtra("backup_notification_type", 0);
            String str = 15 == intExtra ? NotifyConstants.DETAIL3 : "";
            if (13 == intExtra) {
                str = NotifyConstants.DETAIL2;
            }
            if (12 == intExtra) {
                str = "detail";
            }
            if (TextUtils.isEmpty(str)) {
                C11839m.m70689w(TAG, "popType is null,not report");
                return;
            }
            C13225d.m79490f1().m79585f0("action_code_cloudspacedialog_notenough_view_" + str, C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_cloudspacedialog_notenough_view_" + str, "4", "10");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "reportViewDetails error " + e10);
        }
    }

    private void setDialogButton() {
        if (NotifyConstants.GOTO_BUTTON_SECOND.equals(this.gotoButtonWhich)) {
            this.confirmButton.setText(this.buttonSecond);
            this.cancelButton.setText(this.buttonFirst);
            this.confirmButton.setOnClickListener(this);
        } else if (NotifyConstants.GOTO_BUTTON_FIRST.equals(this.gotoButtonWhich)) {
            this.confirmButton.setText(this.buttonFirst);
            this.cancelButton.setText(this.buttonSecond);
        }
        this.confirmButton.setOnClickListener(this);
        this.cancelButton.setOnClickListener(this);
    }

    private void setDialogTittleAndContent(TextView textView, TextView textView2) {
        if (this.mContext.getResources() != null) {
            textView.setText(this.dialogTitleStr);
            textView2.setText(this.dialogContentStr);
        }
    }

    public void showSpaceNotEnoughDialog(BaseSpaceNotifyBean baseSpaceNotifyBean) throws JSONException {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "showSpaceNotEnoughDialog account is not login.");
            finish();
            return;
        }
        if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog function item switch off");
            finish();
            return;
        }
        if (((BackupNotificationActivity) this.mContext).isFinishing()) {
            C11839m.m70688i(TAG, "BackupNotificationActivity is finished");
            finish();
            return;
        }
        if (!checkBtnStrValid()) {
            NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ, "checkBtnStrValid btn str is empty, buttonFirst = " + this.buttonFirst + " buttonSecond = " + this.buttonSecond);
            finish();
            return;
        }
        C11839m.m70688i(TAG, "showSpaceNotEnoughDialog id = " + (baseSpaceNotifyBean != null ? baseSpaceNotifyBean.getId() : -1));
        setDialogTittleAndContent(this.dialogTitle, this.dialogContent);
        setDialogButton();
        doSpaceNotEnoughReport(null, this.spaceNotifyBean.getPercentage());
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        int id2 = view.getId();
        if (C0209d.m1226Y0()) {
            C11839m.m70689w(TAG, "click too fast");
            return;
        }
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "mContext is null");
        } else if (id2 == R$id.bt_confirm) {
            clickConfirm();
        } else if (id2 == R$id.bt_cancel) {
            clickCancel();
        }
    }

    public void show(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "show backupSpaceNotEnoughNeedData is null.");
            finish();
        } else {
            if (baseSpaceNotifyBean != null) {
                processSpaceNotEnough(backupSpaceNotEnoughNeedData, c12295b, baseSpaceNotifyBean);
                return;
            }
            C11839m.m70687e(TAG, "show space insufficient new dialog notification is null.");
            NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0001", "0001", "new dialog notification is null");
            finish();
        }
    }
}
