package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.p106db.bean.DialogMarkPictures;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import id.C10469c;
import id.C10470d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10802p;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0234s;
import p054cj.C1442a;
import p336he.C10152c;
import p336he.C10155f;
import p364ib.C10465b;
import p450le.C11272a;
import p454lj.C11296s;
import p514o9.C11828b;
import p514o9.C11839m;
import p571q9.C12295b;
import p616rk.C12515a;
import p618rm.C12590s0;
import p676ud.AlertDialogC13154a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p778xk.C13823d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupNotificationTrebleBtnDialog extends AlertDialogC13154a implements View.OnClickListener {
    private static final int BTN_NUM = 3;
    private static final long MIN_AVALIABLE_SPACE = 1048576;
    private static final String TAG = "BackupNotificationTrebleBtnDialog";
    protected boolean autoBackup;
    protected long backupNeedSpace;
    protected C12295b backupNoticeNeedInfo;
    private String buttonFirstString;
    private String buttonSecondString;
    private String buttonThirdString;
    private Intent cloudSpaceIntent;
    protected String descriptionSecond;
    protected TextView firstButton;
    protected TextView firstDescription;
    private long galleryNum;

    /* renamed from: id */
    private int f19204id;
    private boolean isCouponFrequence;
    private int mActivityType;
    protected Context mContext;
    protected String mainText;
    protected long notUsedSpace;
    protected ImageView noticeImage;
    protected TextView noticeTextView;
    private int notificationType;
    private float percentage;
    private Map<Integer, Intent> popGotoIntent;
    private Map<Integer, String> popGotoUri;
    private GetPackagesBySpaceRuleResp recommendInfo;
    protected TextView secondButton;
    protected TextView secondDescription;
    protected TextView thirdButton;
    protected String title;
    protected long totalNeedSpace;
    protected View view;
    protected RelativeLayout viewDetailsArea;

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BackupNotificationTrebleBtnDialog.this.dismiss();
            BackupNotificationTrebleBtnDialog.this.finish();
        }
    }

    public BackupNotificationTrebleBtnDialog(Context context) {
        super(context);
        this.f19204id = 0;
        this.percentage = -1.0f;
        this.title = "";
        this.mainText = "";
        this.buttonFirstString = "";
        this.buttonSecondString = "";
        this.buttonThirdString = "";
        this.descriptionSecond = "";
        this.mActivityType = 0;
        this.popGotoIntent = new HashMap();
        this.popGotoUri = new HashMap();
        this.autoBackup = true;
        this.mContext = context;
        initView();
    }

    private void doSpaceNotEnoughReport() throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.mActivityType);
            jSONObjectM79482j.put("notify_id", this.f19204id);
            jSONObjectM79482j.put("notify_type", "2");
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, this.percentage);
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(C0213f.m1377a(), jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_SHOW", "4", "9", jSONObjectM79482j);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("notify_id", Integer.valueOf(this.f19204id));
        linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.mActivityType));
        linkedHashMapM79499C.put("dialog_btn_num", 3);
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(this.percentage));
        addExtraShowReportInfo(linkedHashMapM79499C);
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
        linkedHashMapM79499C2.put("isActivity", FaqConstants.DISABLE_HA_REPORT);
        C11839m.m70688i(TAG, "report space not enough");
        C13225d.m79490f1().m79603z0("cloudbackup_space_not_enough_dialog", linkedHashMapM79499C2);
    }

    public void finish() {
        Context context = this.mContext;
        if (context == null || !(context instanceof BackupNotificationActivity)) {
            return;
        }
        C11839m.m70689w(TAG, "finish activity.");
        ((BackupNotificationActivity) this.mContext).finish();
    }

    private Intent getDlappIntent() {
        C12295b c12295b = this.backupNoticeNeedInfo;
        Intent dlAppWebViewIntent = null;
        if (c12295b == null) {
            C11839m.m70687e(TAG, "getDlappIntent backupNoticeNeedInfo is null");
            return null;
        }
        ActivityEntry activityEntryM73874b = c12295b.m73874b();
        if (activityEntryM73874b == null) {
            C11839m.m70687e(TAG, "getDlappIntent activityEntry is null");
            return null;
        }
        try {
            dlAppWebViewIntent = NotifyUtil.getDlAppWebViewIntent(this.mContext, activityEntryM73874b.getUrl());
            dlAppWebViewIntent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
            C11272a.m67641a(dlAppWebViewIntent, activityEntryM73874b);
            return dlAppWebViewIntent;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getDlappIntent e:" + e10.toString());
            return dlAppWebViewIntent;
        }
    }

    private Intent getNoticeActivityGotoIntent(NotificationWithActivity notificationWithActivity, PopUpWithActivityGoto popUpWithActivityGoto) {
        Intent intentM65746a;
        String stringWithDefault;
        if (notificationWithActivity == null) {
            C11839m.m70688i(TAG, "getGotoIntent spaceNotification is null");
            return null;
        }
        String popupType = popUpWithActivityGoto.getPopupType();
        String popupUri = popUpWithActivityGoto.getPopupUri();
        String deeplinkUri = popUpWithActivityGoto.getDeeplinkUri();
        if (TextUtils.isEmpty(popupType)) {
            C11839m.m70689w(TAG, "uriType or uriStr is null.");
            return null;
        }
        if (C12590s0.m75807V0(deeplinkUri)) {
            C11839m.m70688i(TAG, "the deeplink is not null.");
            intentM65746a = C12590s0.m75832b0(deeplinkUri, null, true);
        } else if (NotifyConstants.HICLOUD_DLAPP.equals(popupUri)) {
            intentM65746a = getDlappIntent();
        } else if (NotifyConstants.HICLOUD_CENTER.equals(popupUri)) {
            intentM65746a = C13823d.m82904y().m82934r(6);
            intentM65746a.putExtra(NotifyConstants.BackupNotificationType.FIELD, 14);
        } else {
            intentM65746a = C10802p.m65746a(this.mContext, popupType, popupUri);
        }
        if (intentM65746a == null) {
            C11839m.m70688i(TAG, "intent is null");
            return null;
        }
        if ("detail".equals(popupType) || NotifyConstants.DETAIL2.equals(popupType) || NotifyConstants.DETAIL3.equals(popupType)) {
            NoticeDetail noticeDetailQueryBackupDetailNoticeContent = NoticeWithActivityUtil.queryBackupDetailNoticeContent(notificationWithActivity, false, popupType);
            if (noticeDetailQueryBackupDetailNoticeContent == null) {
                C11839m.m70688i(TAG, "detailContent is null");
                return null;
            }
            RecommendNeedData recommendNeedData = new RecommendNeedData();
            recommendNeedData.setId(this.f19204id);
            recommendNeedData.setTitle(getStringWithDefault(noticeDetailQueryBackupDetailNoticeContent.getTitle()));
            if (this.galleryNum <= 0 || this.backupNeedSpace <= 0 || C2783d.m16105R()) {
                NoticeDetail noticeDetailQueryBackupDetailNoticeContent2 = NoticeWithActivityUtil.queryBackupDetailNoticeContent(notificationWithActivity, true, popupType);
                stringWithDefault = noticeDetailQueryBackupDetailNoticeContent2 != null ? getStringWithDefault(noticeDetailQueryBackupDetailNoticeContent2.getMainText()) : "";
            } else {
                stringWithDefault = getStringWithDefault(noticeDetailQueryBackupDetailNoticeContent.getMainText());
            }
            recommendNeedData.setIsFormWithActivity(true);
            recommendNeedData.setActivityType(this.mActivityType);
            recommendNeedData.setMainText(stringWithDefault);
            recommendNeedData.setSubTitle(getStringWithDefault(noticeDetailQueryBackupDetailNoticeContent.getSbuTitle()));
            recommendNeedData.setSecondMainText(getStringWithDefault(noticeDetailQueryBackupDetailNoticeContent.getMainTextSecond()));
            recommendNeedData.setChooseOtherCaseText(getStringWithDefault(noticeDetailQueryBackupDetailNoticeContent.getButtonFirst()));
            recommendNeedData.setRecommendType(notificationWithActivity.getNoticeType());
            recommendNeedData.setTotalNeedSpace(this.totalNeedSpace);
            recommendNeedData.setBackupNeedSpace(this.backupNeedSpace);
            recommendNeedData.setNotUsedSpace(this.notUsedSpace);
            recommendNeedData.setGalleryNum(this.galleryNum);
            recommendNeedData.setActivityWithTaskCenter(this.backupNoticeNeedInfo.m73881j() == 2);
            intentM65746a.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        }
        putActivitiyBiIntent(intentM65746a, popupType, popupUri, notificationWithActivity.getPercentage());
        return intentM65746a;
    }

    private boolean isBtnStrEmpty() {
        if (!TextUtils.isEmpty(this.buttonFirstString) && !TextUtils.isEmpty(this.buttonSecondString) && !TextUtils.isEmpty(this.buttonThirdString)) {
            return false;
        }
        C11839m.m70687e(TAG, "isBtnStrEmpty buttonFirstString = " + this.buttonFirstString + " buttonSecondString = " + this.buttonSecondString + " buttonThirdString = " + this.buttonThirdString);
        return true;
    }

    private boolean isCanShowCoupon(int i10) {
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = this.recommendInfo;
        if (getPackagesBySpaceRuleResp == null) {
            return false;
        }
        List<Voucher> voucherList = getPackagesBySpaceRuleResp.getVoucherList();
        return this.isCouponFrequence && C11296s.m67787K() && C11296s.m67789M(this.mContext) && voucherList != null && !voucherList.isEmpty() && i10 == 1;
    }

    private void processBiUbaReport(int i10) throws JSONException {
        String str;
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
        String stringExtra = null;
        try {
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.mActivityType);
            Map<Integer, String> map = this.popGotoUri;
            if (map != null && map.size() > 0) {
                jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, this.popGotoUri.get(Integer.valueOf(i10)));
            }
            jSONObjectM79482j.put("notify_id", this.f19204id);
            jSONObjectM79482j.put("notify_type", "2");
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, this.percentage);
            Map<Integer, Intent> map2 = this.popGotoIntent;
            if (map2 != null && map2.get(Integer.valueOf(i10)) != null) {
                stringExtra = new SafeIntent(this.popGotoIntent.get(Integer.valueOf(i10))).getStringExtra("gotoDeeplink");
            }
            if (C12590s0.m75807V0(stringExtra)) {
                jSONObjectM79482j.put("gotoDeeplink", stringExtra);
            }
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(C0213f.m1377a(), jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "9", jSONObjectM79482j);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("notify_id", Integer.valueOf(this.f19204id));
        linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.mActivityType));
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(this.percentage));
        addExtraShowReportInfo(linkedHashMapM79499C);
        Map<Integer, String> map3 = this.popGotoUri;
        if (map3 == null || map3.get(Integer.valueOf(i10)) == null) {
            str = "mecloud_cloudspacedialog_notenough_default";
        } else {
            str = "mecloud_cloudspacedialog_notenough_" + this.popGotoUri.get(Integer.valueOf(i10));
        }
        if (C12590s0.m75807V0(stringExtra)) {
            linkedHashMapM79499C.put("gotoDeeplink", stringExtra);
        }
        C13225d.m79490f1().m79591l0(str, linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMapM79499C);
    }

    private void processClickIntent(int i10) throws JSONException {
        processBiUbaReport(i10);
        Map<Integer, Intent> map = this.popGotoIntent;
        if (map == null || map.get(Integer.valueOf(i10)) == null) {
            C11839m.m70689w(TAG, "negative button cloudSpaceIntent is null");
            finish();
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(this.popGotoIntent.get(Integer.valueOf(i10)));
        int intExtra = hiCloudSafeIntent.getIntExtra(NotifyConstants.BackupNotificationType.FIELD, 0);
        String stringExtra = hiCloudSafeIntent.getStringExtra("gotoDeeplink");
        if (intExtra == 7 || intExtra == 8 || C12590s0.m75807V0(stringExtra)) {
            C13230i.m79522d1(new Bundle(), "4", "9");
            C11839m.m70688i(TAG, "positive button jump guide,the deeplink is :" + stringExtra);
            this.mContext.startActivity(this.popGotoIntent.get(Integer.valueOf(i10)));
        } else {
            if (intExtra == 10) {
                C11839m.m70688i(TAG, "CLOSE pop");
                if (this.autoBackup) {
                    C11839m.m70688i(TAG, "click cancel, add record");
                    UserNegFeedbackManager.getInstance(this.mContext).addRecordCount(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
                }
                dismiss();
                finish();
                return;
            }
            if (intExtra == 14) {
                C11839m.m70688i(TAG, "jump task center");
                this.mContext.startActivity(hiCloudSafeIntent);
                dismiss();
                finish();
            } else {
                C11839m.m70687e(TAG, "SpaceOnClickListner invalid type = " + intExtra);
            }
        }
        dismiss();
        finish();
    }

    private void processCloseButtonIntent(Map<String, String> map, String str, String str2, String str3, Intent intent) {
        if (str.equals(str2)) {
            if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_FIRST)) {
                this.thirdButton.setText(this.buttonFirstString);
                this.popGotoIntent.put(Integer.valueOf(this.thirdButton.getId()), intent);
                this.popGotoUri.put(Integer.valueOf(this.thirdButton.getId()), str3);
                return;
            } else if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_SECOND)) {
                this.thirdButton.setText(this.buttonSecondString);
                this.popGotoIntent.put(Integer.valueOf(this.thirdButton.getId()), intent);
                this.popGotoUri.put(Integer.valueOf(this.thirdButton.getId()), str3);
                return;
            } else {
                if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_THIRD)) {
                    this.thirdButton.setText(this.buttonThirdString);
                    this.popGotoIntent.put(Integer.valueOf(this.thirdButton.getId()), intent);
                    this.popGotoUri.put(Integer.valueOf(this.thirdButton.getId()), str3);
                    return;
                }
                return;
            }
        }
        if (this.popGotoIntent.get(Integer.valueOf(this.firstButton.getId())) == null && this.popGotoIntent.get(Integer.valueOf(this.secondButton.getId())) == null) {
            this.popGotoIntent.put(Integer.valueOf(this.firstButton.getId()), intent);
            this.firstButton.setText(map.get(str2));
            this.popGotoUri.put(Integer.valueOf(this.firstButton.getId()), str3);
        } else if (this.popGotoIntent.get(Integer.valueOf(this.firstButton.getId())) == null && this.popGotoIntent.get(Integer.valueOf(this.secondButton.getId())) != null) {
            this.popGotoIntent.put(Integer.valueOf(this.firstButton.getId()), intent);
            this.firstButton.setText(map.get(str2));
            this.popGotoUri.put(Integer.valueOf(this.firstButton.getId()), str3);
        } else {
            if (this.popGotoIntent.get(Integer.valueOf(this.firstButton.getId())) == null || this.popGotoIntent.get(Integer.valueOf(this.secondButton.getId())) != null) {
                return;
            }
            this.popGotoIntent.put(Integer.valueOf(this.secondButton.getId()), intent);
            this.secondButton.setText(map.get(str2));
            this.popGotoUri.put(Integer.valueOf(this.secondButton.getId()), str3);
        }
    }

    private void processNoneCloseButtonIntent(String str, String str2, String str3, Intent intent) {
        if (NotifyConstants.POP_GOTO_BUTTON_FIRST.equals(str2)) {
            this.firstButton.setText(this.buttonFirstString);
            this.popGotoIntent.put(Integer.valueOf(this.firstButton.getId()), intent);
            this.popGotoUri.put(Integer.valueOf(this.firstButton.getId()), str3);
        } else if (NotifyConstants.POP_GOTO_BUTTON_SECOND.equals(str2)) {
            this.secondButton.setText(this.buttonSecondString);
            this.popGotoIntent.put(Integer.valueOf(this.secondButton.getId()), intent);
            this.popGotoUri.put(Integer.valueOf(this.secondButton.getId()), str3);
        } else if (NotifyConstants.POP_GOTO_BUTTON_THIRD.equals(str2)) {
            this.thirdButton.setText(this.buttonThirdString);
            this.popGotoIntent.put(Integer.valueOf(this.thirdButton.getId()), intent);
            this.popGotoUri.put(Integer.valueOf(this.thirdButton.getId()), str3);
        }
    }

    private void processNoticeAcitvityPopGotoIntent(NotificationWithActivity notificationWithActivity, int i10) {
        List<PopUpWithActivityGoto> popupeGoto = notificationWithActivity.getPopupeGoto();
        HashMap map = new HashMap();
        if (popupeGoto == null || popupeGoto.size() <= 0) {
            return;
        }
        String str = "";
        boolean z10 = false;
        for (PopUpWithActivityGoto popUpWithActivityGoto : popupeGoto) {
            String code = popUpWithActivityGoto.getCode();
            if ("close".equals(popUpWithActivityGoto.getPopupType())) {
                z10 = true;
                str = code;
            }
            if (code.equals(NotifyConstants.POP_GOTO_BUTTON_FIRST)) {
                map.put(code, this.buttonFirstString);
            } else if (code.equals(NotifyConstants.POP_GOTO_BUTTON_SECOND)) {
                map.put(code, this.buttonSecondString);
            } else if (code.equals(NotifyConstants.POP_GOTO_BUTTON_THIRD)) {
                map.put(code, this.buttonThirdString);
            }
        }
        this.cloudSpaceIntent = null;
        for (PopUpWithActivityGoto popUpWithActivityGoto2 : popupeGoto) {
            String code2 = popUpWithActivityGoto2.getCode();
            String popupType = popUpWithActivityGoto2.getPopupType();
            String popupUri = popUpWithActivityGoto2.getPopupUri();
            if (!TextUtils.isEmpty(popupType)) {
                String popUri = NoticeWithActivityUtil.getPopUri(popupType, popupUri);
                Intent intentM63230n = C10152c.m63230n(getNoticeActivityGotoIntent(notificationWithActivity, popUpWithActivityGoto2), popUpWithActivityGoto2, notificationWithActivity, i10);
                setIntent(intentM63230n);
                if (z10) {
                    processCloseButtonIntent(map, str, code2, popUri, intentM63230n);
                } else {
                    processNoneCloseButtonIntent(str, code2, popUri, intentM63230n);
                }
            }
        }
    }

    private void processRemoveTask() {
        C10469c.m64350p(this.mContext).m64349m(true);
        C10469c.m64350p(this.mContext).cancel();
        C12515a.m75110o().m75165a1(C10469c.m64350p(this.mContext));
        C10470d.m64355p(this.mContext).m64349m(true);
        C10470d.m64355p(this.mContext).cancel();
        C12515a.m75110o().m75165a1(C10470d.m64355p(this.mContext));
    }

    private void putActivitiyBiIntent(Intent intent, String str, String str2, float f10) {
        intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, true);
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
        Bundle bundle = new Bundle();
        if (!TextUtils.equals("detail", str) && !TextUtils.equals("close", str)) {
            str = str2;
        }
        bundle.putString(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, str);
        bundle.putInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.mActivityType);
        bundle.putFloat(HNConstants.C4906BI.BI_PERCENTAGE, f10);
        intent.putExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO, bundle);
    }

    private void setIntent(Intent intent) {
        if (this.cloudSpaceIntent == null) {
            this.cloudSpaceIntent = intent;
        }
    }

    private void showViewDetailsWithActivity(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity == null) {
            C11839m.m70687e(TAG, "notification is null");
            return;
        }
        C10152c.m63218b(this.mContext);
        C11828b c11828b = new C11828b(SpaceNoticeV3Manager.getDialogMarkIconPath());
        DialogMarkPictures dialogMarkPicturesM63221e = C10152c.m63221e(notificationWithActivity);
        if (dialogMarkPicturesM63221e == null) {
            C11839m.m70688i(TAG, "showViewDetailsWithActivity dialogMarkPictures is null");
            return;
        }
        String url = dialogMarkPicturesM63221e.getPicture().getUrl();
        String hash = dialogMarkPicturesM63221e.getPicture().getHash();
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(hash)) {
            C11839m.m70688i(TAG, "imgUrl or imgInfoSha256 is null");
            return;
        }
        if (!c11828b.m70492h(this.mContext, url)) {
            this.noticeImage.setBackground(this.mContext.getDrawable(R$drawable.backup_notice_detail));
        }
        c11828b.m70491g(url, hash, this.noticeImage);
        NoticeDetail noticeDetailM63223g = C10152c.m63223g(notificationWithActivity);
        if (noticeDetailM63223g == null) {
            C11839m.m70688i(TAG, "noticeDetail is null");
            return;
        }
        String stringWithDefault = getStringWithDefault(noticeDetailM63223g.getMark());
        if (TextUtils.isEmpty(stringWithDefault)) {
            C11839m.m70688i(TAG, "showViewDetailsWithActivity text is null");
        } else {
            this.noticeTextView.setText(stringWithDefault);
            this.viewDetailsArea.setVisibility(0);
        }
    }

    public void addExtraShowReportInfo(LinkedHashMap linkedHashMap) {
        linkedHashMap.put("is_new_dialog", Boolean.FALSE);
        linkedHashMap.put("recommend_space_needed", Long.valueOf(this.totalNeedSpace));
    }

    public String getStringWithDefault(String str) {
        String stringWithDefault = SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(str, this.f19204id);
        return !TextUtils.isEmpty(stringWithDefault) ? stringWithDefault : SpaceNoticeV3Manager.getInstance().getStringWithDefault(str);
    }

    public void initView() {
        setOnCancelListener(new DialogOnCancelListener());
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.space_not_enough_treble_dialog_message, (ViewGroup) null);
        this.view = viewInflate;
        this.firstDescription = (TextView) C12809f.m76831d(viewInflate, R$id.space_not_enough_dialog_text_1);
        this.secondDescription = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_dialog_text_2);
        this.firstButton = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_1);
        this.secondButton = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_2);
        this.thirdButton = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_3);
        this.viewDetailsArea = (RelativeLayout) C12809f.m76831d(this.view, R$id.view_details_area);
        this.noticeImage = (ImageView) C12809f.m76831d(this.view, R$id.view_details_image);
        this.noticeTextView = (TextView) C12809f.m76831d(this.view, R$id.view_details_text);
        this.firstButton.setOnClickListener(this);
        this.secondButton.setOnClickListener(this);
        this.thirdButton.setOnClickListener(this);
        float fM1195O = C0209d.m1195O(C0213f.m1377a());
        if (fM1195O >= 3.2f) {
            this.firstDescription.setMaxLines(2);
            this.secondDescription.setMaxLines(2);
        } else if (fM1195O >= 1.75f) {
            this.firstDescription.setMaxLines(3);
            this.secondDescription.setMaxLines(3);
        }
        setView(this.view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        int id2 = view.getId();
        if (R$id.space_not_enough_treble_dialog_button_1 == id2 || R$id.space_not_enough_treble_dialog_button_2 == id2 || R$id.space_not_enough_treble_dialog_button_3 == id2) {
            processClickIntent(id2);
        }
        processRemoveTask();
        C10152c.m63217a();
    }

    public void prepareTitleAndMainText(NoticeContent noticeContent) {
        this.title = getStringWithDefault(noticeContent.getTitle());
        this.mainText = getStringWithDefault(noticeContent.getMainText());
    }

    public void prepareTitleAndMainTextWithActivity(String str) {
        this.title = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_TITLE);
        this.mainText = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_MAIN_TEXT);
    }

    public boolean setBackupInfoView() {
        setTitle(this.title);
        setDialogTextFirst(this.firstDescription);
        if (TextUtils.isEmpty(this.descriptionSecond)) {
            C11839m.m70688i(TAG, "description_second is null");
            return false;
        }
        setDialogTextSecond(this.descriptionSecond, this.secondDescription);
        return true;
    }

    public void setDialogTextFirst(TextView textView) {
        long jM16190y = C2783d.m16190y();
        Resources resources = this.mContext.getResources();
        if (resources != null) {
            int i10 = (int) jM16190y;
            textView.setText(C10465b.m64293c(this.mainText, resources.getQuantityString(R$plurals.cloud_backup_fail_days, i10, Integer.valueOf(i10))));
        }
    }

    public void setDialogTextSecond(String str, TextView textView) {
        long j10 = this.notUsedSpace;
        if (j10 < 1048576) {
            long j11 = this.backupNeedSpace;
            if (j11 > 1048576) {
                textView.setText(C10465b.m64293c(str, C0223k.m1524g(this.mContext, j11), this.mContext.getString(R$string.left_space_less)));
                return;
            }
        }
        if (j10 < 0) {
            this.notUsedSpace = 0L;
        }
        Context context = this.mContext;
        textView.setText(C10465b.m64293c(str, C0223k.m1524g(this.mContext, this.backupNeedSpace), context.getString(R$string.left_space, C0223k.m1524g(context, this.notUsedSpace))));
    }

    public void show(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b) throws JSONException {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "show backupSpaceNotEnoughNeedData is null.");
            Context context = this.mContext;
            if (context == null || !(context instanceof BackupNotificationActivity)) {
                return;
            }
            dismiss();
            finish();
            return;
        }
        int iM73881j = c12295b.m73881j();
        this.notificationType = iM73881j;
        NotificationWithActivity notificationWithActivityM73882k = iM73881j == 1 ? c12295b.m73882k() : null;
        if (this.notificationType == 2) {
            notificationWithActivityM73882k = c12295b.m73883l();
        }
        if (notificationWithActivityM73882k == null) {
            C11839m.m70687e(TAG, "show notificationWithActivity is null.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            dismiss();
            finish();
            return;
        }
        this.totalNeedSpace = backupSpaceNotEnoughNeedData.getTotalNeedSpace();
        this.backupNeedSpace = backupSpaceNotEnoughNeedData.getBackupNeedSpace();
        this.notUsedSpace = backupSpaceNotEnoughNeedData.getNotUsedSpace();
        this.galleryNum = backupSpaceNotEnoughNeedData.getGalleryNum();
        this.recommendInfo = c12295b.m73885n();
        this.isCouponFrequence = c12295b.m73889r();
        this.mActivityType = notificationWithActivityM73882k.getActivityType();
        this.backupNoticeNeedInfo = c12295b;
        this.autoBackup = c12295b.m73875c();
        showSpaceNotEnoughDialog(notificationWithActivityM73882k);
    }

    public void showSpaceNotEnoughDialog(NotificationWithActivity notificationWithActivity) throws JSONException {
        boolean zIsCanShowCoupon;
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "showSpaceNotEnoughDialog account is not login.");
            finish();
            return;
        }
        if (notificationWithActivity == null) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog notification is null");
            finish();
            return;
        }
        this.f19204id = notificationWithActivity.getId();
        this.percentage = notificationWithActivity.getPercentage();
        ArrayList arrayList = new ArrayList();
        arrayList.add(notificationWithActivity);
        boolean zM63287k = C10155f.m63287k(arrayList);
        if (this.notificationType == 1 && zM63287k) {
            ActivityEntry activityEntryM73874b = this.backupNoticeNeedInfo.m73874b();
            if (activityEntryM73874b == null) {
                C11839m.m70688i(TAG, "backupNoticeNeedInfo activityEntry is null");
                finish();
                return;
            }
            String resource = activityEntryM73874b.getResource();
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog id = " + this.f19204id + " resourceid = " + resource);
            prepareTitleAndMainTextWithActivity(resource);
            this.buttonFirstString = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_BUTTON3_FIRST);
            this.buttonSecondString = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_BUTTON3_SECOND);
            this.buttonThirdString = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_BUTTON3_THIRD);
            this.descriptionSecond = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_DESCRIPTION_SECOND);
            zIsCanShowCoupon = false;
        } else {
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog id = " + this.f19204id + " mActivityType = " + this.mActivityType);
            zIsCanShowCoupon = isCanShowCoupon(notificationWithActivity.getEnableShowCoupon());
            NoticeContent noticeContentPopup = !zIsCanShowCoupon ? CloudSpaceNotifyUtil.getInstance().getNoticeContentPopup(notificationWithActivity) : CloudSpaceNotifyUtil.getInstance().getNoticeCouponContent(notificationWithActivity);
            if (noticeContentPopup == null) {
                C1442a.m8289e(TAG, "popContent is null.");
                finish();
                return;
            } else {
                prepareTitleAndMainText(noticeContentPopup);
                this.buttonFirstString = getStringWithDefault(noticeContentPopup.getButtonFirst());
                this.buttonSecondString = getStringWithDefault(noticeContentPopup.getButtonSecond());
                this.buttonThirdString = getStringWithDefault(noticeContentPopup.getButtonThird());
                this.descriptionSecond = getStringWithDefault(noticeContentPopup.getDescriptionSecond());
            }
        }
        if (isBtnStrEmpty()) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
            finish();
            return;
        }
        if (!setBackupInfoView()) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
            finish();
            return;
        }
        boolean zM63235s = C10152c.m63235s(notificationWithActivity, this.mContext, false);
        int iM63219c = C10152c.m63219c(this.mContext);
        if (zM63235s) {
            iM63219c++;
        }
        processNoticeAcitvityPopGotoIntent(notificationWithActivity, iM63219c);
        if (((BackupNotificationActivity) this.mContext).isFinishing()) {
            C11839m.m70688i(TAG, "BackupNotificationActivity is finished");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_SWITCH_CLOSE);
            return;
        }
        doSpaceNotEnoughReport();
        setCanceledOnTouchOutside(false);
        if (zM63235s) {
            showViewDetailsWithActivity(notificationWithActivity);
        } else {
            C10152c.m63236t(this.mContext);
        }
        if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog function item switch off");
            return;
        }
        if (zIsCanShowCoupon && this.notificationType == 2) {
            C0212e0.m1370t(this.mContext, FrequencyManager.CHECKBACKUPFAILNOTIFYSP, FrequencyManager.BACKUP_COUPON_SHOW_TIME, System.currentTimeMillis());
        }
        show();
        C11839m.m70688i(TAG, "Show backup SpaceNotEnoughDialog by notificationWithActivity end");
    }
}
