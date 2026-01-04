package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceUnEnoughActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudBackupSpaceInsufficientNewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceMemberShareActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.DialogMarkPictures;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipData;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipInfo;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.util.HiCloudLink;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import id.C10469c;
import id.C10470d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0223k;
import p015ak.C0234s;
import p336he.C10152c;
import p364ib.C10465b;
import p450le.C11272a;
import p514o9.C11828b;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p676ud.AlertDialogC13154a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p778xk.C13823d;
import sk.C12809f;
import tl.C13026e;

/* loaded from: classes3.dex */
public class BackupNotificationDoubleBtnDialog extends AlertDialogC13154a implements View.OnClickListener {
    protected static final int ACTIVITY_CORRECT_CODE = 0;
    protected static final int ACTIVITY_ERROR_CODE = 6666;
    protected static final int BTN_NUM = 2;
    protected static final int CORRECT_CODE = 7777;
    protected static final int ERROR_CODE = 1111;
    protected static final long MIN_AVALIABLE_SPACE = 1048576;
    protected static final int SHOW_BACKUP_DATA = 1;
    private static final String TAG = "BackupNotificationDoubleBtnDialog";
    protected static final int TASK_CENTER_CORRECT_CODE = 2222;
    protected static final int TASK_CENTER_ERROR_CODE = 8888;
    protected ActivitySpaceOnClickListner activitySpaceOnClickListner;
    protected boolean autoBackup;
    protected FrameLayout backupManageArea;
    protected long backupNeedSpace;
    protected C12295b backupNoticeNeedInfo;
    protected String buttonFirst;
    protected String buttonSecond;
    protected Intent cloudSpaceIntent;
    protected String descriptionSecond;
    protected String dialogBtnGoto;
    protected TextView dialogTextFirst;
    protected TextView dialogTextSecond;
    protected float fontScale;
    protected int frontAppNumber;
    protected long galleryNum;
    protected String gotoButtonWhich;
    protected Handler handler;

    /* renamed from: id */
    protected int f19203id;
    protected String imgHash;
    protected String imgUrl;
    protected boolean isDisplayBackUpData;
    protected boolean isFamilyShareMember;
    protected boolean isShowViewDetails;
    protected boolean isThirdAppSwitchOpen;
    protected int isThreeButtonPopup;
    protected int mActivityType;
    protected Context mContext;
    SpaceNotification mNotification;
    protected int mNotificationType;
    NotificationWithActivity mNotificationWithActivityOrTaskCenter;
    protected String mainText;
    protected String markText;
    protected long notUsedSpace;
    protected ImageView noticeImage;
    protected TextView noticeTextView;
    protected String packageSubscribeButtonFirst;
    protected String packageSubscribeButtonSecond;
    protected String packageSubscribeDesc;
    protected String packageSubscribeDialogDesc;
    protected String packageSubscribeDialogTitle;
    protected String packageSubscribeTitle;
    protected float percentage;
    protected Map<Integer, Intent> popGotoIntent;
    protected Map<Integer, String> popGotoUri;
    protected SpaceOnClickListner spaceOnClickListner;
    protected String standByButtonFirstText;
    protected TextView standByButtonFirstTv;
    protected String standByButtonSecondText;
    protected TextView standByButtonSecondTv;
    protected String standByButtonThirdText;
    protected TextView standByButtonThirdTv;
    protected LinearLayout threeButtonArea;
    protected String title;
    protected long totalNeedSpace;
    protected long totalSpace;
    protected long usedSpace;
    protected View view;
    protected RelativeLayout viewDetailsArea;
    protected WlanBtnOnClickListner wlanOnClicklistner;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog$1 */
    public class HandlerC41761 extends Handler {
        public HandlerC41761() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 0) {
                Object obj = message.obj;
                NotificationWithActivity notificationWithActivity = obj instanceof NotificationWithActivity ? (NotificationWithActivity) obj : null;
                try {
                    if (notificationWithActivity == null) {
                        NotificationReportUtil.reportCloudBackupNoSpace("0019", "0001");
                    } else {
                        NotificationReportUtil.reportCloudBackupNoSpace("0019", "0003");
                    }
                    BackupNotificationDoubleBtnDialog.this.showSpaceActivityNotEnoughDialog(notificationWithActivity);
                    return;
                } catch (Exception e10) {
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "handleMessage ACTIVITY_CORRECT_CODE err: " + e10.getMessage());
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_USER_TAG_CHECK_FAILED, "exception in correct code: " + e10.toString());
                    BackupNotificationDoubleBtnDialog.this.dismiss();
                    BackupNotificationDoubleBtnDialog.this.finish();
                    return;
                }
            }
            if (i10 == BackupNotificationDoubleBtnDialog.ERROR_CODE) {
                C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "Get configuration is empty");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC);
                BackupNotificationDoubleBtnDialog.this.dismiss();
                BackupNotificationDoubleBtnDialog.this.finish();
                return;
            }
            if (i10 == BackupNotificationDoubleBtnDialog.TASK_CENTER_CORRECT_CODE) {
                Object obj2 = message.obj;
                NotificationWithActivity notificationWithActivity2 = obj2 instanceof NotificationWithActivity ? (NotificationWithActivity) obj2 : null;
                if (notificationWithActivity2 == null) {
                    NotificationReportUtil.reportCloudBackupNoSpace("0019", "0001");
                } else {
                    NotificationReportUtil.reportCloudBackupNoSpace("0019", "0003");
                }
                BackupNotificationDoubleBtnDialog.this.showSpaceActivityNotEnoughDialog(notificationWithActivity2);
                return;
            }
            if (i10 == BackupNotificationDoubleBtnDialog.ACTIVITY_ERROR_CODE) {
                C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "Get activity configuration is empty");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_FAIL);
                BackupNotificationDoubleBtnDialog.this.dismiss();
                BackupNotificationDoubleBtnDialog.this.finish();
                return;
            }
            if (i10 != BackupNotificationDoubleBtnDialog.CORRECT_CODE) {
                if (i10 != 8888) {
                    return;
                }
                C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "Get notificationWithTaskCenter configuration is empty");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_FAIL);
                BackupNotificationDoubleBtnDialog.this.dismiss();
                BackupNotificationDoubleBtnDialog.this.finish();
                return;
            }
            Object obj3 = message.obj;
            try {
                BackupNotificationDoubleBtnDialog.this.showSpaceNotEnoughDialog(obj3 instanceof SpaceNotification ? (SpaceNotification) obj3 : null);
            } catch (Exception e11) {
                C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "handleMessage CORRECT_CODE err: " + e11.getMessage());
                NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC, e11.getMessage());
                BackupNotificationDoubleBtnDialog.this.dismiss();
                BackupNotificationDoubleBtnDialog.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog$2 */
    public class C41772 extends AbstractC12367d {
        public C41772() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Message message = new Message();
            try {
                BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = BackupNotificationDoubleBtnDialog.this;
                NotificationWithActivity notificationWithActivityPrepareSpaceActivityNotEnoughDialog = backupNotificationDoubleBtnDialog.prepareSpaceActivityNotEnoughDialog(backupNotificationDoubleBtnDialog.mNotificationWithActivityOrTaskCenter);
                if (notificationWithActivityPrepareSpaceActivityNotEnoughDialog != null) {
                    message.obj = notificationWithActivityPrepareSpaceActivityNotEnoughDialog;
                    message.what = BackupNotificationDoubleBtnDialog.TASK_CENTER_CORRECT_CODE;
                } else {
                    message.what = 8888;
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", "0034", "notification == null");
                }
                BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
            } catch (Exception e10) {
                message.what = 8888;
                BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", "0034", "exception: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog$3 */
    public class C41783 extends AbstractC12367d {
        public C41783() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Message message = new Message();
            try {
                BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = BackupNotificationDoubleBtnDialog.this;
                NotificationWithActivity notificationWithActivityPrepareSpaceActivityNotEnoughDialog = backupNotificationDoubleBtnDialog.prepareSpaceActivityNotEnoughDialog(backupNotificationDoubleBtnDialog.mNotificationWithActivityOrTaskCenter);
                if (notificationWithActivityPrepareSpaceActivityNotEnoughDialog != null) {
                    message.obj = notificationWithActivityPrepareSpaceActivityNotEnoughDialog;
                    message.what = 0;
                } else {
                    message.what = BackupNotificationDoubleBtnDialog.ACTIVITY_ERROR_CODE;
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_USER_TAG_CHECK_FAILED, "notification == null");
                }
                BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
            } catch (Exception e10) {
                message.what = BackupNotificationDoubleBtnDialog.ACTIVITY_ERROR_CODE;
                BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_USER_TAG_CHECK_FAILED, "exception: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog$4 */
    public class C41794 extends AbstractC12367d {
        public C41794() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Message message = new Message();
            try {
                BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = BackupNotificationDoubleBtnDialog.this;
                SpaceNotification spaceNotificationPrepareSpaceNotEnoughDialog = backupNotificationDoubleBtnDialog.prepareSpaceNotEnoughDialog(backupNotificationDoubleBtnDialog.mNotification);
                if (spaceNotificationPrepareSpaceNotEnoughDialog != null) {
                    message.obj = spaceNotificationPrepareSpaceNotEnoughDialog;
                    message.what = BackupNotificationDoubleBtnDialog.CORRECT_CODE;
                } else {
                    message.what = BackupNotificationDoubleBtnDialog.ERROR_CODE;
                }
                BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
            } catch (Exception e10) {
                message.what = BackupNotificationDoubleBtnDialog.ERROR_CODE;
                BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", "0032", "exception: " + e10.toString());
            }
        }
    }

    public class ActivitySpaceOnClickListner implements DialogInterface.OnClickListener {
        public ActivitySpaceOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws JSONException {
            BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = BackupNotificationDoubleBtnDialog.this;
            if (backupNotificationDoubleBtnDialog.mContext == null) {
                C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "ActivitySpaceOnClickListner mContext is null");
                return;
            }
            if (-1 == i10 || -2 == i10) {
                backupNotificationDoubleBtnDialog.processClickIntent(i10);
            }
            BackupNotificationDoubleBtnDialog.this.processRemoveTask();
            C10152c.m63217a();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BackupNotificationDoubleBtnDialog.this.dismiss();
            BackupNotificationDoubleBtnDialog.this.finish();
        }
    }

    public class SpaceOnClickListner implements DialogInterface.OnClickListener {
        public SpaceOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws JSONException {
            if (BackupNotificationDoubleBtnDialog.this.mContext == null) {
                C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "SpaceOnClickListner mContext is null");
                return;
            }
            if (-1 == i10) {
                JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
                try {
                    jSONObjectM79482j.put("notify_id", BackupNotificationDoubleBtnDialog.this.f19203id);
                    jSONObjectM79482j.put("notify_type", "2");
                    jSONObjectM79482j.put("click_upgrade_cloudSpace", true);
                    jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, BackupNotificationDoubleBtnDialog.this.percentage);
                } catch (JSONException e10) {
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "ERROR OCCUR:" + e10.getMessage());
                }
                C13225d.m79490f1().m79602z(jSONObjectM79482j);
                UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "1", "43", jSONObjectM79482j);
                if (BackupNotificationDoubleBtnDialog.this.cloudSpaceIntent == null) {
                    C11839m.m70689w(BackupNotificationDoubleBtnDialog.TAG, "positive button cloudSpaceIntent is null");
                    BackupNotificationDoubleBtnDialog.this.finish();
                    return;
                }
                HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(BackupNotificationDoubleBtnDialog.this.cloudSpaceIntent);
                BackupNotificationDoubleBtnDialog.this.reportSpaceNotEnoughDialogButtonClick();
                int intExtra = hiCloudSafeIntent.getIntExtra(NotifyConstants.BackupNotificationType.FIELD, 0);
                String stringExtra = hiCloudSafeIntent.getStringExtra("gotoDeeplink");
                if (intExtra == 7 || intExtra == 8 || C12590s0.m75807V0(stringExtra)) {
                    C13230i.m79522d1(new Bundle(), "4", "9");
                    C11839m.m70688i(BackupNotificationDoubleBtnDialog.TAG, "positive button jump guide,the deeplink is :" + stringExtra);
                    BackupNotificationDoubleBtnDialog.this.mContext.startActivity(hiCloudSafeIntent);
                } else {
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "SpaceOnClickListner invalid type = " + intExtra);
                }
                BackupNotificationDoubleBtnDialog.this.reportViewDetails();
                BackupNotificationDoubleBtnDialog.this.finish();
            } else if (-2 == i10) {
                JSONObject jSONObjectM79482j2 = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
                try {
                    jSONObjectM79482j2.put("notify_id", BackupNotificationDoubleBtnDialog.this.f19203id);
                    jSONObjectM79482j2.put("notify_type", "2");
                    jSONObjectM79482j2.put("click_upgrade_later", true);
                    jSONObjectM79482j2.put(HNConstants.C4906BI.BI_PERCENTAGE, BackupNotificationDoubleBtnDialog.this.percentage);
                } catch (JSONException e11) {
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "ERROR OCCUR:" + e11.getMessage());
                }
                C13225d.m79490f1().m79602z(jSONObjectM79482j2);
                UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "9", jSONObjectM79482j2);
                LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C.put("is_auto_backup", String.valueOf(BackupNotificationDoubleBtnDialog.this.autoBackup));
                linkedHashMapM79499C.put("user_type", C13452e.m80781L().m80790C());
                linkedHashMapM79499C.put("is_third_app_switch_open", String.valueOf(BackupNotificationDoubleBtnDialog.this.isThirdAppSwitchOpen));
                linkedHashMapM79499C.put("click_text", String.valueOf(-2));
                BackupNotificationDoubleBtnDialog.this.addExtraRecommendReportInfo(linkedHashMapM79499C);
                C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_notenough_later", linkedHashMapM79499C);
                UBAAnalyze.m29954O("PVC", "mecloud_cloudspacedialog_notenough_later", "4", "10");
                if (BackupNotificationDoubleBtnDialog.this.autoBackup) {
                    C11839m.m70688i(BackupNotificationDoubleBtnDialog.TAG, "click cancel, add record");
                    UserNegFeedbackManager.getInstance(BackupNotificationDoubleBtnDialog.this.mContext).addRecordCount(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
                }
                BackupNotificationDoubleBtnDialog.this.dismiss();
                BackupNotificationDoubleBtnDialog.this.finish();
            }
            BackupNotificationDoubleBtnDialog.this.processRemoveTask();
            C10152c.m63217a();
        }
    }

    public class WlanBtnOnClickListner implements DialogInterface.OnClickListener {
        public WlanBtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                C2783d.m16149i1(BackupNotificationDoubleBtnDialog.this.mContext);
                BackupNotificationDoubleBtnDialog.this.finish();
            } else if (-2 == i10) {
                BackupNotificationDoubleBtnDialog.this.dismiss();
                BackupNotificationDoubleBtnDialog.this.finish();
            }
        }
    }

    public BackupNotificationDoubleBtnDialog(Context context) {
        super(context);
        this.wlanOnClicklistner = new WlanBtnOnClickListner();
        this.spaceOnClickListner = new SpaceOnClickListner();
        this.activitySpaceOnClickListner = new ActivitySpaceOnClickListner();
        this.f19203id = 0;
        this.title = "";
        this.mainText = "";
        this.buttonFirst = "";
        this.buttonSecond = "";
        this.gotoButtonWhich = "";
        this.descriptionSecond = "";
        this.percentage = 0.0f;
        this.imgUrl = "";
        this.imgHash = "";
        this.markText = "";
        this.isShowViewDetails = false;
        this.mActivityType = 0;
        this.mNotificationWithActivityOrTaskCenter = null;
        this.mNotification = null;
        this.popGotoIntent = new HashMap();
        this.popGotoUri = new HashMap();
        this.autoBackup = true;
        this.isDisplayBackUpData = false;
        this.standByButtonFirstText = "";
        this.standByButtonSecondText = "";
        this.standByButtonThirdText = "";
        this.isThreeButtonPopup = -1;
        this.frontAppNumber = 1;
        this.packageSubscribeDialogTitle = "";
        this.packageSubscribeDialogDesc = "";
        this.packageSubscribeTitle = "";
        this.packageSubscribeDesc = "";
        this.packageSubscribeButtonFirst = "";
        this.packageSubscribeButtonSecond = "";
        this.handler = new Handler() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog.1
            public HandlerC41761() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i10 = message.what;
                if (i10 == 0) {
                    Object obj = message.obj;
                    NotificationWithActivity notificationWithActivity = obj instanceof NotificationWithActivity ? (NotificationWithActivity) obj : null;
                    try {
                        if (notificationWithActivity == null) {
                            NotificationReportUtil.reportCloudBackupNoSpace("0019", "0001");
                        } else {
                            NotificationReportUtil.reportCloudBackupNoSpace("0019", "0003");
                        }
                        BackupNotificationDoubleBtnDialog.this.showSpaceActivityNotEnoughDialog(notificationWithActivity);
                        return;
                    } catch (Exception e10) {
                        C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "handleMessage ACTIVITY_CORRECT_CODE err: " + e10.getMessage());
                        NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_USER_TAG_CHECK_FAILED, "exception in correct code: " + e10.toString());
                        BackupNotificationDoubleBtnDialog.this.dismiss();
                        BackupNotificationDoubleBtnDialog.this.finish();
                        return;
                    }
                }
                if (i10 == BackupNotificationDoubleBtnDialog.ERROR_CODE) {
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "Get configuration is empty");
                    NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC);
                    BackupNotificationDoubleBtnDialog.this.dismiss();
                    BackupNotificationDoubleBtnDialog.this.finish();
                    return;
                }
                if (i10 == BackupNotificationDoubleBtnDialog.TASK_CENTER_CORRECT_CODE) {
                    Object obj2 = message.obj;
                    NotificationWithActivity notificationWithActivity2 = obj2 instanceof NotificationWithActivity ? (NotificationWithActivity) obj2 : null;
                    if (notificationWithActivity2 == null) {
                        NotificationReportUtil.reportCloudBackupNoSpace("0019", "0001");
                    } else {
                        NotificationReportUtil.reportCloudBackupNoSpace("0019", "0003");
                    }
                    BackupNotificationDoubleBtnDialog.this.showSpaceActivityNotEnoughDialog(notificationWithActivity2);
                    return;
                }
                if (i10 == BackupNotificationDoubleBtnDialog.ACTIVITY_ERROR_CODE) {
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "Get activity configuration is empty");
                    NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_FAIL);
                    BackupNotificationDoubleBtnDialog.this.dismiss();
                    BackupNotificationDoubleBtnDialog.this.finish();
                    return;
                }
                if (i10 != BackupNotificationDoubleBtnDialog.CORRECT_CODE) {
                    if (i10 != 8888) {
                        return;
                    }
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "Get notificationWithTaskCenter configuration is empty");
                    NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_FAIL);
                    BackupNotificationDoubleBtnDialog.this.dismiss();
                    BackupNotificationDoubleBtnDialog.this.finish();
                    return;
                }
                Object obj3 = message.obj;
                try {
                    BackupNotificationDoubleBtnDialog.this.showSpaceNotEnoughDialog(obj3 instanceof SpaceNotification ? (SpaceNotification) obj3 : null);
                } catch (Exception e11) {
                    C11839m.m70687e(BackupNotificationDoubleBtnDialog.TAG, "handleMessage CORRECT_CODE err: " + e11.getMessage());
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC, e11.getMessage());
                    BackupNotificationDoubleBtnDialog.this.dismiss();
                    BackupNotificationDoubleBtnDialog.this.finish();
                }
            }
        };
        this.mContext = context;
        setCanceledOnTouchOutside(false);
        initView();
    }

    private NoticeDetail checkGetNoticeDetail(SpaceNotification spaceNotification, NoticeDetail noticeDetail, NoticeGoto noticeGoto) {
        return NotifyConstants.DETAIL2.equals(noticeGoto.getPopupType()) ? C10152c.m63224h(spaceNotification) : noticeDetail;
    }

    private Intent getGotoIntent(SpaceNotification spaceNotification) {
        Intent gotoPopup;
        String mainText;
        NoticeDetail noticeContentDetail = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetail(spaceNotification);
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        NoticeDetail noticeDetailCheckGetNoticeDetail = checkGetNoticeDetail(spaceNotification, noticeContentDetail, noticeGoto);
        if (noticeDetailCheckGetNoticeDetail == null) {
            C11839m.m70689w(TAG, "getGotoIntent detailContent is null");
            return null;
        }
        String popupType = noticeGoto.getPopupType();
        String popupUri = noticeGoto.getPopupUri();
        String popupDeeplink = noticeGoto.getPopupDeeplink();
        if (!NotifyConstants.DETAIL2.equals(popupType) && !NotifyConstants.DETAIL3.equals(popupType) && (TextUtils.isEmpty(popupType) || (TextUtils.isEmpty(popupUri) && !"detail".equals(popupType)))) {
            C11839m.m70689w(TAG, "uriType or uriStr is null.");
            popupType = noticeGoto.getType();
            popupUri = noticeGoto.getUri();
            if (!new HiCloudLink(this.mContext).checkModuleEnable(popupType, popupUri)) {
                C11839m.m70688i(TAG, "link disable type=" + noticeGoto.getType() + ", uri=" + noticeGoto.getUri());
                return null;
            }
        }
        if (C12590s0.m75807V0(popupDeeplink)) {
            gotoPopup = C12590s0.m75832b0(popupDeeplink, null, true);
            gotoPopup.putExtra("gotoType", popupType);
            gotoPopup.putExtra("gotoUri", popupUri);
            C11839m.m70688i(TAG, "getGotoPopup deeplink, the deeplink is:" + popupDeeplink);
        } else {
            gotoPopup = getGotoPopup(popupType, popupUri);
        }
        if (gotoPopup == null) {
            C11839m.m70688i(TAG, "intent is null");
            return null;
        }
        if (NotifyConstants.BUY_MORE.equals(popupUri)) {
            gotoPopup.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        } else {
            gotoPopup.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        }
        setUriType(popupType, gotoPopup);
        gotoPopup.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        recommendNeedData.setId(this.f19203id);
        recommendNeedData.setTitle(getStringWithDefault(noticeDetailCheckGetNoticeDetail.getTitle()));
        if (this.galleryNum <= 0 || this.backupNeedSpace <= 0 || C2783d.m16105R()) {
            NoticeDetail noticeContentDetailDefault = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailDefault(spaceNotification, popupType);
            mainText = noticeContentDetailDefault != null ? noticeContentDetailDefault.getMainText() : "";
        } else {
            mainText = noticeDetailCheckGetNoticeDetail.getMainText();
        }
        recommendNeedData.setMainText(getStringWithDefault(mainText));
        recommendNeedData.setChooseOtherCaseText(getStringWithDefault(noticeDetailCheckGetNoticeDetail.getButtonFirst()));
        recommendNeedData.setRecommendType(spaceNotification.getNoticeType());
        recommendNeedData.setEnterType(1);
        recommendNeedData.setTotalNeedSpace(this.totalNeedSpace);
        recommendNeedData.setBackupNeedSpace(this.backupNeedSpace);
        recommendNeedData.setNotUsedSpace(this.notUsedSpace);
        recommendNeedData.setGalleryNum(this.galleryNum);
        recommendNeedData.setSubTitle(getStringWithDefault(noticeDetailCheckGetNoticeDetail.getSbuTitle()));
        recommendNeedData.setSecondMainText(getStringWithDefault(noticeDetailCheckGetNoticeDetail.getMainTextSecond()));
        recommendNeedData.setActivityWithTaskCenter(this.backupNoticeNeedInfo.m73881j() == 2);
        gotoPopup.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        return gotoPopup;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Intent getGotoPopup(String str, String str2) {
        Intent intent;
        intent = new Intent();
        intent.putExtra("gotoType", str);
        intent.putExtra("gotoUri", str2);
        str.hashCode();
        switch (str) {
            case "activity_popup":
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 11);
                return intent;
            case "detail":
                intent.setClass(this.mContext, CloudSpaceGuideActivity.class);
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                intent.putExtra("gotoUri", CloudSpaceGuideActivity.class.getSimpleName());
                return intent;
            case "web":
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                return intent;
            case "close":
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 10);
                return intent;
            case "deeplink":
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                return intent;
            case "application":
                if (NotifyConstants.BUY_MORE.equals(str2)) {
                    intent.setClass(this.mContext, CloudSpaceUpgradeActivity.class);
                    intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
                    addRecommendInfo(intent);
                } else {
                    Class<?> cls = NotifyConstants.getGotoAppMapping().get(str2);
                    if (cls == null) {
                        C11839m.m70687e(TAG, "no uri match, return null, uri is: " + str2);
                        return null;
                    }
                    intent.setClass(this.mContext, cls);
                    intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                }
                return intent;
            case "detail2":
                intent.setClass(this.mContext, CloudBackupSpaceUnEnoughActivity.class);
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                intent.putExtra("gotoUri", CloudBackupSpaceUnEnoughActivity.class.getSimpleName());
                return intent;
            case "detail3":
                intent.setClass(this.mContext, CloudBackupSpaceInsufficientNewActivity.class);
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                intent.putExtra("gotoUri", CloudBackupSpaceInsufficientNewActivity.class.getSimpleName());
                return intent;
            default:
                return intent;
        }
    }

    private Intent getMemberIntent(SpaceNotification spaceNotification) {
        if (spaceNotification == null) {
            C11839m.m70687e(TAG, "getMemberIntent spaceNotification is null.");
            return null;
        }
        NoticeDetail noticeContentDetailMember = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetailMember(spaceNotification);
        if (noticeContentDetailMember == null) {
            C11839m.m70687e(TAG, "getMemberIntent memberNoticeContent is null.");
            return null;
        }
        MemberShareDetail memberShareDetail = new MemberShareDetail();
        memberShareDetail.setTitle(getStringUseLock(noticeContentDetailMember.getTitle()));
        memberShareDetail.setMainText(getStringUseLock(noticeContentDetailMember.getMainText()));
        memberShareDetail.setButtonText(getStringUseLock(noticeContentDetailMember.getButtonFirst()));
        memberShareDetail.setNotifyType(spaceNotification.getNoticeType());
        Intent intent = new Intent();
        intent.setClass(this.mContext, CloudSpaceMemberShareActivity.class);
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL, memberShareDetail);
        intent.putExtra("gotoType", CloudSpaceMemberShareActivity.class.getSimpleName());
        return intent;
    }

    private String getMultiLanguage(String str) {
        str.hashCode();
        return !str.equals(NotifyConstants.POP_GOTO_BUTTON_FIRST) ? !str.equals(NotifyConstants.POP_GOTO_BUTTON_SECOND) ? "" : this.buttonSecond : this.buttonFirst;
    }

    private String getMultiLanguageForPurchaseTwoButton(String str) {
        C11839m.m70688i(TAG, "getMultiLanguageForPurchaseTwoButton start");
        str.hashCode();
        return !str.equals(NotifyConstants.POP_GOTO_BUTTON_FIRST) ? !str.equals(NotifyConstants.POP_GOTO_BUTTON_SECOND) ? "" : this.packageSubscribeButtonSecond : this.packageSubscribeButtonFirst;
    }

    private String getMultiLanguageForThreeButton(String str) {
        C11839m.m70688i(TAG, "getMultiLanguageForThreeButton start");
        str.hashCode();
        switch (str) {
            case "button_first":
                return this.standByButtonFirstText;
            case "button_third":
                return this.standByButtonThirdText;
            case "button_second":
                return this.standByButtonSecondText;
            default:
                return "";
        }
    }

    private Intent getNoticeActivityGotoIntent(BaseSpaceNotifyBean baseSpaceNotifyBean, PopUpWithActivityGoto popUpWithActivityGoto, int i10) {
        Intent gotoPopup;
        String stringWithDefault;
        if (baseSpaceNotifyBean == null) {
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
            gotoPopup = C12590s0.m75832b0(deeplinkUri, null, true);
            gotoPopup.putExtra("gotoType", popupType);
            gotoPopup.putExtra("gotoUri", popupUri);
            C11839m.m70688i(TAG, "getGotoPopup deeplink, the deeplink is:" + deeplinkUri);
        } else if (NotifyConstants.HICLOUD_DLAPP.equals(popupUri)) {
            gotoPopup = getDlappIntent();
        } else if (NotifyConstants.HICLOUD_CENTER.equals(popupUri)) {
            gotoPopup = C13823d.m82904y().m82934r(6);
            gotoPopup.putExtra(NotifyConstants.BackupNotificationType.FIELD, 14);
        } else {
            gotoPopup = getGotoPopup(popupType, popupUri);
        }
        if (gotoPopup == null) {
            C11839m.m70688i(TAG, "getNoticeActivityGotoIntent intent is null");
            return null;
        }
        if ("detail".equals(popupType) || NotifyConstants.DETAIL2.equals(popupType) || NotifyConstants.DETAIL3.equals(popupType)) {
            NoticeDetail noticeDetailQueryBackupDetailNoticeContent = NoticeWithActivityUtil.queryBackupDetailNoticeContent(baseSpaceNotifyBean, false, popupType);
            if (noticeDetailQueryBackupDetailNoticeContent == null) {
                C11839m.m70688i(TAG, "detailContent is null");
                return null;
            }
            RecommendNeedData recommendNeedData = new RecommendNeedData();
            recommendNeedData.setId(this.f19203id);
            recommendNeedData.setTitle(getStringWithDefault(noticeDetailQueryBackupDetailNoticeContent.getTitle()));
            if (this.galleryNum <= 0 || this.backupNeedSpace <= 0 || C2783d.m16105R()) {
                NoticeDetail noticeDetailQueryBackupDetailNoticeContent2 = NoticeWithActivityUtil.queryBackupDetailNoticeContent(baseSpaceNotifyBean, true, popupType);
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
            recommendNeedData.setRecommendType(baseSpaceNotifyBean.getNoticeType());
            recommendNeedData.setEnterType(1);
            recommendNeedData.setTotalNeedSpace(this.totalNeedSpace);
            recommendNeedData.setBackupNeedSpace(this.backupNeedSpace);
            recommendNeedData.setNotUsedSpace(this.notUsedSpace);
            recommendNeedData.setGalleryNum(this.galleryNum);
            recommendNeedData.setActivityWithTaskCenter(this.backupNoticeNeedInfo.m73881j() == 2);
            gotoPopup = C10152c.m63230n(gotoPopup, popUpWithActivityGoto, baseSpaceNotifyBean, i10);
            gotoPopup.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        }
        putActivitiyBiIntent(gotoPopup, popupType, popupUri, baseSpaceNotifyBean.getPercentage());
        return gotoPopup;
    }

    private String getStringWithDefault(String str) {
        String stringWithDefault = SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(str, this.f19203id);
        return !TextUtils.isEmpty(stringWithDefault) ? stringWithDefault : SpaceNoticeV3Manager.getInstance().getStringWithDefault(str);
    }

    private boolean prepareBtnAndDescription(NoticeContent noticeContent, int i10) {
        if (checkMultiLanguage(i10, noticeContent.getDescriptionSecond(), noticeContent.getButtonFirst(), noticeContent.getButtonSecond())) {
            this.descriptionSecond = getStringUseLock(noticeContent.getDescriptionSecond());
            this.buttonFirst = getStringUseLock(noticeContent.getButtonFirst());
            this.buttonSecond = getStringUseLock(noticeContent.getButtonSecond());
            if (!TextUtils.isEmpty(this.descriptionSecond)) {
                return true;
            }
            C11839m.m70688i(TAG, "prepareSpaceNotEnoughDialog description_second is null");
            return false;
        }
        this.descriptionSecond = getStringUseLock(noticeContent.getDescriptionSecond());
        this.buttonFirst = getStringUseLock(noticeContent.getButtonFirst());
        this.buttonSecond = getStringUseLock(noticeContent.getButtonSecond());
        if (TextUtils.isEmpty(this.descriptionSecond) || TextUtils.isEmpty(this.buttonFirst) || TextUtils.isEmpty(this.buttonSecond)) {
            C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog checkMultiLanguage fail");
            return false;
        }
        C11839m.m70687e(TAG, "prepareBtnAndDescription get defaul language");
        return true;
    }

    private boolean prepareTitleAndMainText(NoticeContent noticeContent) {
        if (noticeContent == null) {
            C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog popupContent null");
            return false;
        }
        boolean zM80897c1 = C13452e.m80781L().m80897c1();
        this.title = NotifyUtil.filterNoticeTitle(noticeContent, zM80897c1, this.autoBackup, "title", this.f19203id);
        String strFilterNoticeMainText = NotifyUtil.filterNoticeMainText(noticeContent, zM80897c1, this.autoBackup, NotifyUtil.MAIN_TEXT_TYPE_DEFAULT, this.f19203id);
        this.mainText = strFilterNoticeMainText;
        if (!TextUtils.isEmpty(strFilterNoticeMainText) && !TextUtils.isEmpty(this.title)) {
            return true;
        }
        C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog mainText = " + this.mainText + " or title = " + this.title + " is null.");
        return false;
    }

    private void processBiUbaReport(int i10) throws JSONException {
        String str;
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
        String stringExtra = null;
        try {
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.mActivityType);
            Map<Integer, String> map = this.popGotoUri;
            if (map != null) {
                jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, map.get(Integer.valueOf(this.f19203id)));
            }
            jSONObjectM79482j.put("notify_type", "2");
            jSONObjectM79482j.put("notify_id", this.f19203id);
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, this.percentage);
            Map<Integer, Intent> map2 = this.popGotoIntent;
            if (map2 != null && map2.get(Integer.valueOf(i10)) != null) {
                stringExtra = new SafeIntent(this.popGotoIntent.get(Integer.valueOf(i10))).getStringExtra("gotoDeeplink");
                if (C12590s0.m75807V0(stringExtra)) {
                    jSONObjectM79482j.put("gotoDeeplink", stringExtra);
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13225d.m79490f1().m79602z(jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "9", jSONObjectM79482j);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("notify_id", Integer.valueOf(this.f19203id));
        linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.mActivityType));
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(this.percentage));
        if (isShowRecommendPackageWithSubscribeUser()) {
            linkedHashMapM79499C.put("is_dialog_show_package_subscribe_show", Boolean.TRUE);
        }
        addExtraRecommendReportInfo(linkedHashMapM79499C);
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

    public void processClickIntent(int i10) throws JSONException {
        processBiUbaReport(i10);
        Map<Integer, Intent> map = this.popGotoIntent;
        if (map == null || map.get(Integer.valueOf(i10)) == null) {
            C11839m.m70689w(TAG, "processClickIntent popGotoIntentis null");
            dismiss();
            finish();
            return;
        }
        Intent intent = this.popGotoIntent.get(Integer.valueOf(i10));
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        int intExtra = hiCloudSafeIntent.getIntExtra(NotifyConstants.BackupNotificationType.FIELD, 0);
        String stringExtra = hiCloudSafeIntent.getStringExtra("gotoDeeplink");
        processButtonClick(intExtra);
        if (intExtra == 7 || intExtra == 8 || C12590s0.m75807V0(stringExtra)) {
            C13230i.m79522d1(new Bundle(), "4", "9");
            C11839m.m70688i(TAG, "positive button jump guide,the deeplink is:" + stringExtra);
            this.mContext.startActivity(intent);
            dismiss();
            finish();
            return;
        }
        if (intExtra == 14) {
            C11839m.m70688i(TAG, "jump task center");
            this.mContext.startActivity(intent);
            dismiss();
            finish();
            return;
        }
        if (intExtra == 10) {
            C11839m.m70688i(TAG, "close pop");
            if (this.autoBackup) {
                C11839m.m70688i(TAG, "click cancel, add record");
                UserNegFeedbackManager.getInstance(this.mContext).addRecordCount(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
            }
            dismiss();
            finish();
            return;
        }
        if (intExtra == 11) {
            C11839m.m70688i(TAG, "show SPACE_NOT_ENOUGH_ACITIVTY_DIALOG");
            if (this.mNotificationType == 1) {
                showActivityConfirmDialog();
            }
            if (this.mNotificationType == 2) {
                showTaskCenterConfirmDialog();
                return;
            }
            return;
        }
        C11839m.m70687e(TAG, "SpaceOnClickListner invalid type = " + intExtra);
        dismiss();
        finish();
    }

    private void processHasClose(String str, String str2, String str3, Intent intent) {
        if (!str.equals(str2)) {
            this.popGotoIntent.put(-1, intent);
            this.popGotoUri.put(-1, str3);
            return;
        }
        this.popGotoIntent.put(-2, intent);
        this.popGotoUri.put(-2, str3);
        if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_FIRST)) {
            setButton(-2, this.buttonFirst, this.activitySpaceOnClickListner);
            setButton(-1, this.buttonSecond, this.activitySpaceOnClickListner);
        } else if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_SECOND)) {
            setButton(-2, this.buttonSecond, this.activitySpaceOnClickListner);
            setButton(-1, this.buttonFirst, this.activitySpaceOnClickListner);
        }
    }

    private void processHasCloseForThreeButton(Map<String, String> map, String str, String str2, String str3, Intent intent) {
        C11839m.m70688i(TAG, "processHasCloseForThreeButton start");
        if (str.equals(str2)) {
            if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_FIRST)) {
                this.standByButtonThirdTv.setText(this.standByButtonFirstText);
                this.popGotoIntent.put(Integer.valueOf(this.standByButtonThirdTv.getId()), intent);
                this.popGotoUri.put(Integer.valueOf(this.standByButtonThirdTv.getId()), str3);
                return;
            } else if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_SECOND)) {
                this.standByButtonThirdTv.setText(this.standByButtonSecondText);
                this.popGotoIntent.put(Integer.valueOf(this.standByButtonThirdTv.getId()), intent);
                this.popGotoUri.put(Integer.valueOf(this.standByButtonThirdTv.getId()), str3);
                return;
            } else {
                if (str2.equals(NotifyConstants.POP_GOTO_BUTTON_THIRD)) {
                    this.standByButtonThirdTv.setText(this.standByButtonThirdText);
                    this.popGotoIntent.put(Integer.valueOf(this.standByButtonThirdTv.getId()), intent);
                    this.popGotoUri.put(Integer.valueOf(this.standByButtonThirdTv.getId()), str3);
                    return;
                }
                return;
            }
        }
        if (this.popGotoIntent.get(Integer.valueOf(this.standByButtonFirstTv.getId())) == null && this.popGotoIntent.get(Integer.valueOf(this.standByButtonSecondTv.getId())) == null) {
            this.popGotoIntent.put(Integer.valueOf(this.standByButtonFirstTv.getId()), intent);
            this.standByButtonFirstTv.setText(map.get(str2));
            this.popGotoUri.put(Integer.valueOf(this.standByButtonFirstTv.getId()), str3);
        } else if (this.popGotoIntent.get(Integer.valueOf(this.standByButtonFirstTv.getId())) == null && this.popGotoIntent.get(Integer.valueOf(this.standByButtonSecondTv.getId())) != null) {
            this.popGotoIntent.put(Integer.valueOf(this.standByButtonFirstTv.getId()), intent);
            this.standByButtonFirstTv.setText(map.get(str2));
            this.popGotoUri.put(Integer.valueOf(this.standByButtonFirstTv.getId()), str3);
        } else {
            if (this.popGotoIntent.get(Integer.valueOf(this.standByButtonFirstTv.getId())) == null || this.popGotoIntent.get(Integer.valueOf(this.standByButtonSecondTv.getId())) != null) {
                return;
            }
            this.popGotoIntent.put(Integer.valueOf(this.standByButtonSecondTv.getId()), intent);
            this.standByButtonSecondTv.setText(map.get(str2));
            this.popGotoUri.put(Integer.valueOf(this.standByButtonSecondTv.getId()), str3);
        }
    }

    private void processNoneClose(String str, String str2, Intent intent) {
        if (NotifyConstants.POP_GOTO_BUTTON_FIRST.equals(str)) {
            this.popGotoIntent.put(-1, intent);
            this.popGotoUri.put(-1, str2);
            setButton(-1, this.buttonFirst, this.activitySpaceOnClickListner);
        } else if (NotifyConstants.POP_GOTO_BUTTON_SECOND.equals(str)) {
            this.popGotoIntent.put(-2, intent);
            this.popGotoUri.put(-2, str2);
            setButton(-2, this.buttonSecond, this.activitySpaceOnClickListner);
        }
    }

    private void processNoneCloseForThreeButton(String str, String str2, Intent intent) {
        C11839m.m70688i(TAG, "processNoneCloseForThreeButton start");
        if (NotifyConstants.POP_GOTO_BUTTON_FIRST.equals(str)) {
            this.standByButtonFirstTv.setText(this.standByButtonFirstText);
            this.popGotoIntent.put(Integer.valueOf(this.standByButtonFirstTv.getId()), intent);
            this.popGotoUri.put(Integer.valueOf(this.standByButtonFirstTv.getId()), str2);
        } else if (NotifyConstants.POP_GOTO_BUTTON_SECOND.equals(str)) {
            this.standByButtonSecondTv.setText(this.standByButtonSecondText);
            this.popGotoIntent.put(Integer.valueOf(this.standByButtonSecondTv.getId()), intent);
            this.popGotoUri.put(Integer.valueOf(this.standByButtonSecondTv.getId()), str2);
        } else if (NotifyConstants.POP_GOTO_BUTTON_THIRD.equals(str)) {
            this.standByButtonThirdTv.setText(this.standByButtonThirdText);
            this.popGotoIntent.put(Integer.valueOf(this.standByButtonThirdTv.getId()), intent);
            this.popGotoUri.put(Integer.valueOf(this.standByButtonThirdTv.getId()), str2);
        }
    }

    private void putActivitiyBiIntent(Intent intent, String str, String str2, float f10) {
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "3");
        intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, true);
        Bundle bundle = new Bundle();
        if (!TextUtils.equals("detail", str) && !TextUtils.equals("close", str)) {
            str = str2;
        }
        bundle.putInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.mActivityType);
        bundle.putString(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, str);
        bundle.putFloat(HNConstants.C4906BI.BI_PERCENTAGE, f10);
        intent.putExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO, bundle);
        C0216g0.m1402e(this.mContext).m1407E(intent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
    }

    private List<PopUpWithActivityGoto> realEfectGotoButton(NotificationWithActivity notificationWithActivity) {
        List<PopUpWithActivityGoto> popupeGoto = notificationWithActivity.getPopupeGoto();
        if (C0209d.m1205R0(popupeGoto)) {
            return null;
        }
        Iterator<PopUpWithActivityGoto> it = popupeGoto.iterator();
        while (it.hasNext()) {
            PopUpWithActivityGoto next = it.next();
            String code = next.getCode();
            if (TextUtils.isEmpty(next.getPopupType())) {
                it.remove();
            } else if (TextUtils.isEmpty(getMultiLanguage(code))) {
                it.remove();
            }
        }
        C11839m.m70688i(TAG, "realEfectGotoButton Count = " + popupeGoto.size());
        return popupeGoto;
    }

    public void reportSpaceNotEnoughDialogButtonClick() {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("is_auto_backup", String.valueOf(this.autoBackup));
        linkedHashMapM79499C.put("user_type", C13452e.m80781L().m80790C());
        linkedHashMapM79499C.put("is_third_app_switch_open", String.valueOf(this.isThirdAppSwitchOpen));
        linkedHashMapM79499C.put("click_text", String.valueOf(-1));
        linkedHashMapM79499C.put("recommend_space_needed", Long.valueOf(this.totalNeedSpace));
        try {
            Intent intent = this.cloudSpaceIntent;
            if (intent != null) {
                linkedHashMapM79499C.put("gotoType", intent.getStringExtra("gotoType"));
                linkedHashMapM79499C.put("gotoUri", this.cloudSpaceIntent.getStringExtra("gotoUri"));
                if (C12590s0.m75807V0(this.cloudSpaceIntent.getStringExtra("gotoDeeplink"))) {
                    linkedHashMapM79499C.put("gotoDeeplink", this.cloudSpaceIntent.getStringExtra("gotoDeeplink"));
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "reportSpaceNotEnoughDialogButtonClick error " + e10);
        }
        C13225d.m79490f1().m79591l0("mecloud_cloudspacedialog_notenough_upgrade", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacedialog_notenough_upgrade", "4", "10", linkedHashMapM79499C);
    }

    private void setUriType(String str, Intent intent) {
        if ("detail".equals(str)) {
            intent.putExtra("backup_notification_type", 12);
        }
        if (NotifyConstants.DETAIL2.equals(str)) {
            intent.putExtra("backup_notification_type", 13);
        }
        if (NotifyConstants.DETAIL3.equals(str)) {
            intent.putExtra("backup_notification_type", 15);
        }
    }

    private void showActivityConfirmDialog() {
        try {
            new ActivityConfirmDialog(this.mContext, this.backupNoticeNeedInfo.m73874b(), this.autoBackup).showDialog(this.mNotificationWithActivityOrTaskCenter);
            dismiss();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "showActivityConfirmDialog exception: " + e10.toString());
            dismiss();
            finish();
        }
    }

    private void showNotificationDialog() {
        this.mActivityType = this.mNotification.getActivityType();
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog.4
            public C41794() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                Message message = new Message();
                try {
                    BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = BackupNotificationDoubleBtnDialog.this;
                    SpaceNotification spaceNotificationPrepareSpaceNotEnoughDialog = backupNotificationDoubleBtnDialog.prepareSpaceNotEnoughDialog(backupNotificationDoubleBtnDialog.mNotification);
                    if (spaceNotificationPrepareSpaceNotEnoughDialog != null) {
                        message.obj = spaceNotificationPrepareSpaceNotEnoughDialog;
                        message.what = BackupNotificationDoubleBtnDialog.CORRECT_CODE;
                    } else {
                        message.what = BackupNotificationDoubleBtnDialog.ERROR_CODE;
                    }
                    BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                } catch (Exception e10) {
                    message.what = BackupNotificationDoubleBtnDialog.ERROR_CODE;
                    BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", "0032", "exception: " + e10.toString());
                }
            }
        }, false);
    }

    private void showNotificationWithActivityDialog() {
        this.mActivityType = this.mNotificationWithActivityOrTaskCenter.getActivityType();
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog.3
            public C41783() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                Message message = new Message();
                try {
                    BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = BackupNotificationDoubleBtnDialog.this;
                    NotificationWithActivity notificationWithActivityPrepareSpaceActivityNotEnoughDialog = backupNotificationDoubleBtnDialog.prepareSpaceActivityNotEnoughDialog(backupNotificationDoubleBtnDialog.mNotificationWithActivityOrTaskCenter);
                    if (notificationWithActivityPrepareSpaceActivityNotEnoughDialog != null) {
                        message.obj = notificationWithActivityPrepareSpaceActivityNotEnoughDialog;
                        message.what = 0;
                    } else {
                        message.what = BackupNotificationDoubleBtnDialog.ACTIVITY_ERROR_CODE;
                        NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_USER_TAG_CHECK_FAILED, "notification == null");
                    }
                    BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                } catch (Exception e10) {
                    message.what = BackupNotificationDoubleBtnDialog.ACTIVITY_ERROR_CODE;
                    BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", NotifyConstants.NotificationReport.RESULT_NAME_USER_TAG_CHECK_FAILED, "exception: " + e10.toString());
                }
            }
        });
    }

    private void showNotificationWithTaskCenterDialog() {
        this.mActivityType = this.mNotificationWithActivityOrTaskCenter.getActivityType();
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupNotificationDoubleBtnDialog.2
            public C41772() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                Message message = new Message();
                try {
                    BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = BackupNotificationDoubleBtnDialog.this;
                    NotificationWithActivity notificationWithActivityPrepareSpaceActivityNotEnoughDialog = backupNotificationDoubleBtnDialog.prepareSpaceActivityNotEnoughDialog(backupNotificationDoubleBtnDialog.mNotificationWithActivityOrTaskCenter);
                    if (notificationWithActivityPrepareSpaceActivityNotEnoughDialog != null) {
                        message.obj = notificationWithActivityPrepareSpaceActivityNotEnoughDialog;
                        message.what = BackupNotificationDoubleBtnDialog.TASK_CENTER_CORRECT_CODE;
                    } else {
                        message.what = 8888;
                        NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", "0034", "notification == null");
                    }
                    BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                } catch (Exception e10) {
                    message.what = 8888;
                    BackupNotificationDoubleBtnDialog.this.handler.sendMessage(message);
                    NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0002", "0034", "exception: " + e10.toString());
                }
            }
        });
    }

    private void showTaskCenterConfirmDialog() {
        try {
            new TaskCenterConfirmDialog(this.mContext, this.autoBackup).showDialog(this.mNotificationWithActivityOrTaskCenter);
            dismiss();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "showActivityConfirmDialog exception: " + e10.toString());
            dismiss();
            finish();
        }
    }

    public void addExtraRecommendReportInfo(LinkedHashMap linkedHashMap) {
        if (linkedHashMap == null) {
            C11839m.m70687e(TAG, "addExtraRecommendReportInfo extraKeyValues is null.");
        } else {
            linkedHashMap.put("recommend_space_needed", Long.valueOf(this.totalNeedSpace));
        }
    }

    public void addExtraShowReportInfo(LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        linkedHashMap.put("is_new_dialog", Boolean.FALSE);
    }

    public void addRecommendInfo(Intent intent) {
    }

    public boolean checkBtnStrValid() {
        if (!TextUtils.isEmpty(this.buttonFirst) && !TextUtils.isEmpty(this.buttonSecond)) {
            return true;
        }
        C11839m.m70687e(TAG, "checkBtnStrValid btn str is empty , buttonFirst = " + this.buttonFirst + " buttonSecond = " + this.buttonSecond);
        finish();
        return false;
    }

    public boolean checkMultiLanguage(int i10, String... strArr) {
        if (SpaceInsuffNoticeV4Manager.getInstance().checkMultiLanguage(i10, strArr)) {
            return true;
        }
        return SpaceNoticeV3Manager.getInstance().checkMultiLanguage(strArr);
    }

    public void checkShowView(boolean z10) {
        if (!z10) {
            C10152c.m63236t(this.mContext);
        } else {
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog showViewDetails");
            showViewDetails();
        }
    }

    public void doSpaceNotEnoughReport(LinkedHashMap linkedHashMap, float f10) {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            if (this.mNotificationType == 1) {
                jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.mActivityType);
            }
            jSONObjectM79482j.put("notify_id", this.f19203id);
            jSONObjectM79482j.put("notify_type", "2");
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, f10);
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13225d.m79490f1().m79602z(jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_SHOW", "4", "9", jSONObjectM79482j);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        if (this.mNotificationType == 1) {
            linkedHashMapM79499C.put("notify_id", Integer.valueOf(this.f19203id));
            linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.mActivityType));
        }
        linkedHashMapM79499C.put("dialog_btn_num", 2);
        linkedHashMapM79499C.put(HNConstants.C4906BI.BI_PERCENTAGE, Float.valueOf(f10));
        linkedHashMapM79499C.put("is_auto_backup", String.valueOf(this.autoBackup));
        linkedHashMapM79499C.put("user_type", C13452e.m80781L().m80790C());
        linkedHashMapM79499C.put("is_third_app_switch_open", String.valueOf(this.isThirdAppSwitchOpen));
        addExtraShowReportInfo(linkedHashMapM79499C, linkedHashMap);
        addExtraRecommendReportInfo(linkedHashMapM79499C);
        linkedHashMapM79499C.put("current_language", C0234s.m1631i());
        C11839m.m70688i(TAG, "doSpaceNotEnoughReport = " + TextUtils.isEmpty(this.backupNoticeNeedInfo.m73879g()));
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
        if (this.mNotificationType == 1) {
            linkedHashMapM79499C2.put("is_support_activity", FaqConstants.DISABLE_HA_REPORT);
        } else {
            linkedHashMapM79499C2.put("is_support_activity", "false");
        }
        C11839m.m70688i(TAG, "report space not enough");
        C13225d.m79490f1().m79603z0("cloudbackup_space_not_enough_dialog", linkedHashMapM79499C2);
    }

    public void finish() {
        Context context = this.mContext;
        if (context == null || !(context instanceof BackupNotificationActivity)) {
            return;
        }
        ((BackupNotificationActivity) context).finish();
    }

    public Intent getActivityEntryIntent(String str, String str2, String str3, NoticeDetail noticeDetail, String str4, boolean z10, RecommendTipInfo recommendTipInfo) {
        Intent dlappIntent = NotifyConstants.HICLOUD_DLAPP.equals(str2) ? getDlappIntent() : NotifyConstants.HICLOUD_CENTER.equals(str2) ? C13823d.m82904y().m82934r(6) : getGotoPopup(str, str2);
        if ("detail".equals(str) || NotifyConstants.DETAIL2.equals(str) || NotifyConstants.DETAIL3.equals(str)) {
            RecommendNeedData recommendNeedData = new RecommendNeedData();
            recommendNeedData.setId(this.f19203id);
            recommendNeedData.setTitle(getStringWithDefault(noticeDetail.getTitle()));
            if (this.galleryNum > 0 && this.backupNeedSpace > 0 && !C2783d.m16105R()) {
                str3 = noticeDetail.getMainText();
            }
            recommendNeedData.setMainText(getStringWithDefault(str3));
            recommendNeedData.setSubTitle(getStringWithDefault(noticeDetail.getSbuTitle()));
            recommendNeedData.setSecondMainText(getStringWithDefault(noticeDetail.getMainTextSecond()));
            recommendNeedData.setChooseOtherCaseText(getStringWithDefault(noticeDetail.getButtonFirst()));
            recommendNeedData.setTotalNeedSpace(this.totalNeedSpace);
            recommendNeedData.setRecommendType(str4);
            recommendNeedData.setBackupNeedSpace(this.backupNeedSpace);
            recommendNeedData.setEnterType(1);
            recommendNeedData.setGalleryNum(this.galleryNum);
            recommendNeedData.setNotUsedSpace(this.notUsedSpace);
            if (z10) {
                recommendNeedData.setIsFormWithActivity(true);
                recommendNeedData.setActivityType(this.mActivityType);
            }
            if (recommendTipInfo != null) {
                RecommendTipData recommendTipData = new RecommendTipData();
                if (NotifyConstants.DETAIL2.equals(str)) {
                    recommendTipData.setDisplayClearCard(recommendTipInfo.getDisplayClearCard());
                }
                recommendTipData.setDisplayHelp(recommendTipInfo.getDisplayHelp());
                recommendTipData.setHelpUrl(recommendTipInfo.getHelpUrl());
                dlappIntent.putExtra("recommend_tip_info_key", recommendTipData);
            }
            dlappIntent.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        }
        C0216g0.m1402e(this.mContext).m1407E(dlappIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
        return dlappIntent;
    }

    public Intent getCloudSpaceIntent(SpaceNotification spaceNotification) {
        Intent memberIntent = this.isFamilyShareMember ? getMemberIntent(spaceNotification) : getGotoIntent(spaceNotification);
        C0216g0.m1402e(this.mContext).m1407E(memberIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
        return memberIntent;
    }

    public Intent getDlappIntent() {
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

    public String getStringUseLock(String str) {
        String stringUseLock = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(str, this.f19203id);
        return !TextUtils.isEmpty(stringUseLock) ? stringUseLock : SpaceNoticeV3Manager.getInstance().getStringUseLock(str);
    }

    public void initDialogTextFirst(View view) {
        TextView textView = (TextView) C12809f.m76831d(view, R$id.space_not_enough_dialog_text_1);
        this.dialogTextFirst = textView;
        if (this.fontScale >= 1.75f) {
            textView.setMaxLines(2);
        }
    }

    public void initDialogTextSecond(View view) {
        this.dialogTextSecond = (TextView) C12809f.m76831d(view, R$id.space_not_enough_dialog_text_2);
    }

    public void initView() {
        setOnCancelListener(new DialogOnCancelListener());
        this.fontScale = C0209d.m1195O(C0213f.m1377a());
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.space_not_enough_dialog_message, (ViewGroup) null);
        this.view = viewInflate;
        this.viewDetailsArea = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.view_details_area);
        this.noticeImage = (ImageView) C12809f.m76831d(this.view, R$id.view_details_image);
        this.noticeTextView = (TextView) C12809f.m76831d(this.view, R$id.view_details_text);
        initDialogTextFirst(this.view);
        initDialogTextSecond(this.view);
        setView(this.view);
    }

    public boolean isShowRecommendPackageWithSubscribeUser() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "ActivitySpaceOnClickListner mContext is null");
            return;
        }
        int id2 = view.getId();
        if (R$id.three_button_scene_button_1 == id2 || R$id.three_button_scene_button_2 == id2 || R$id.three_button_scene_button_3 == id2) {
            processClickIntent(id2);
        }
        processRemoveTask();
        C10152c.m63217a();
    }

    public void prepareActivityViewDetail(boolean z10, NotificationWithActivity notificationWithActivity) {
        DialogMarkPictures dialogMarkPicturesM63221e;
        if (notificationWithActivity == null) {
            C11839m.m70687e(TAG, "notification is null");
            return;
        }
        if (!z10 || (dialogMarkPicturesM63221e = C10152c.m63221e(notificationWithActivity)) == null) {
            return;
        }
        this.imgUrl = dialogMarkPicturesM63221e.getPicture().getUrl();
        this.imgHash = dialogMarkPicturesM63221e.getPicture().getHash();
        NoticeDetail noticeDetailM63223g = C10152c.m63223g(notificationWithActivity);
        if (noticeDetailM63223g != null) {
            this.markText = getStringUseLock(noticeDetailM63223g.getMark());
        }
    }

    public NotificationWithActivity prepareSpaceActivityNotEnoughDialog(NotificationWithActivity notificationWithActivity) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog account is not login.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0029");
            return null;
        }
        if (this.backupNoticeNeedInfo == null) {
            C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog backupNoticeNeedInfo is null.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0030");
            return null;
        }
        if (notificationWithActivity == null) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog notification is null");
            return null;
        }
        this.f19203id = notificationWithActivity.getId();
        this.percentage = notificationWithActivity.getPercentage();
        new ArrayList().add(notificationWithActivity);
        if (this.backupNoticeNeedInfo.m73881j() == 1) {
            ActivityEntry activityEntryM73874b = this.backupNoticeNeedInfo.m73874b();
            if (activityEntryM73874b == null) {
                C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog activityEntry is null.");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
                return null;
            }
            String resource = activityEntryM73874b.getResource();
            C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog id = " + this.f19203id + " reSourceId = " + resource);
            this.title = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_TITLE);
            this.mainText = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_MAIN_TEXT);
            this.buttonFirst = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_BUTTON2_FIRST);
            this.buttonSecond = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_BUTTON2_SECOND);
            String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_POP_DESCRIPTION_SECOND);
            this.descriptionSecond = strFromDBByResource;
            if (TextUtils.isEmpty(strFromDBByResource)) {
                C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog description_second is null");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", "0033");
                return null;
            }
        } else {
            C11839m.m70688i(TAG, "prepareSpaceActivityNotEnoughDialog id = " + this.f19203id + " mActivityType = " + this.mActivityType);
            NoticeContent noticeContentQueryPopupNotificationContent = NoticeWithActivityUtil.queryPopupNotificationContent(notificationWithActivity, false);
            if (noticeContentQueryPopupNotificationContent == null) {
                C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog noticePopContent is null");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
                return null;
            }
            this.title = getStringWithDefault(noticeContentQueryPopupNotificationContent.getTitle());
            this.mainText = getStringWithDefault(noticeContentQueryPopupNotificationContent.getMainText());
            this.buttonFirst = getStringWithDefault(noticeContentQueryPopupNotificationContent.getButtonFirst());
            this.buttonSecond = getStringWithDefault(noticeContentQueryPopupNotificationContent.getButtonSecond());
            this.descriptionSecond = getStringWithDefault(noticeContentQueryPopupNotificationContent.getDescriptionSecond());
            if (TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.mainText) || TextUtils.isEmpty(this.buttonFirst) || TextUtils.isEmpty(this.buttonSecond)) {
                C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog checkMultiLanguage fail");
                NotificationReportUtil.reportCloudBackupNoSpace("0002", "0033");
                return null;
            }
        }
        this.isShowViewDetails = C10152c.m63235s(notificationWithActivity, this.mContext, this.isFamilyShareMember);
        this.isDisplayBackUpData = notificationWithActivity.getIsDisplayBackUpData() == 1;
        prepareActivityViewDetail(this.isShowViewDetails, notificationWithActivity);
        return notificationWithActivity;
    }

    public SpaceNotification prepareSpaceNotEnoughDialog(SpaceNotification spaceNotification) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "prepareSpaceNotEnoughDialog account is not login.");
            return null;
        }
        if (spaceNotification == null) {
            C11839m.m70688i(TAG, "prepareSpaceNotEnoughDialog spaceNotification is null");
            return null;
        }
        this.f19203id = spaceNotification.getId();
        C11839m.m70688i(TAG, "prepareSpaceNotEnoughDialog id = " + this.f19203id);
        NoticeGoto noticeGoto = spaceNotification.getNoticeGoto();
        this.gotoButtonWhich = noticeGoto.getGotoButtonWhich();
        this.cloudSpaceIntent = getCloudSpaceIntent(spaceNotification);
        this.isDisplayBackUpData = spaceNotification.getIsDisplayBackUpData() == 1;
        NoticeContent noticeContentPopup = CloudSpaceNotifyUtil.getInstance().getNoticeContentPopup(spaceNotification);
        this.isShowViewDetails = C10152c.m63234r(this.mContext, spaceNotification, this.isFamilyShareMember);
        int iM63219c = C10152c.m63219c(this.mContext);
        if (this.isShowViewDetails) {
            iM63219c++;
        }
        this.cloudSpaceIntent = C10152c.m63229m(this.cloudSpaceIntent, spaceNotification, noticeGoto, iM63219c, true);
        if (!prepareTitleAndMainText(noticeContentPopup) || !prepareBtnAndDescription(noticeContentPopup, spaceNotification.getId())) {
            return null;
        }
        prepareViewDetail(this.isShowViewDetails, spaceNotification);
        return spaceNotification;
    }

    public void prepareViewDetail(boolean z10, SpaceNotification spaceNotification) {
        DialogMarkPictures dialogMarkPicturesM63220d;
        if (!z10 || (dialogMarkPicturesM63220d = C10152c.m63220d(spaceNotification)) == null) {
            return;
        }
        this.imgUrl = dialogMarkPicturesM63220d.getPicture().getUrl();
        this.imgHash = dialogMarkPicturesM63220d.getPicture().getHash();
        NoticeDetail noticeDetailM63222f = C10152c.m63222f(spaceNotification);
        if (noticeDetailM63222f != null) {
            this.markText = getStringUseLock(noticeDetailM63222f.getMark());
        }
    }

    public void processButtonClick(int i10) {
    }

    public void processNoticeAcitvityPopGotoIntent(NotificationWithActivity notificationWithActivity, int i10) {
        String code;
        boolean z10;
        List<PopUpWithActivityGoto> listRealEfectGotoButton = realEfectGotoButton(notificationWithActivity);
        if (C0209d.m1205R0(listRealEfectGotoButton)) {
            return;
        }
        Iterator<PopUpWithActivityGoto> it = listRealEfectGotoButton.iterator();
        while (true) {
            if (!it.hasNext()) {
                code = "";
                z10 = false;
                break;
            }
            PopUpWithActivityGoto next = it.next();
            code = next.getCode();
            String popupType = next.getPopupType();
            if (!TextUtils.isEmpty(popupType) && "close".equals(popupType)) {
                z10 = true;
                break;
            }
        }
        for (PopUpWithActivityGoto popUpWithActivityGoto : listRealEfectGotoButton) {
            String code2 = popUpWithActivityGoto.getCode();
            String popupType2 = popUpWithActivityGoto.getPopupType();
            String popupUri = popUpWithActivityGoto.getPopupUri();
            if (!TextUtils.isEmpty(popupType2)) {
                String popUri = NoticeWithActivityUtil.getPopUri(popupType2, popupUri);
                Intent noticeActivityGotoIntent = getNoticeActivityGotoIntent(notificationWithActivity, popUpWithActivityGoto, i10);
                if (z10) {
                    processHasClose(code, code2, popUri, noticeActivityGotoIntent);
                } else {
                    processNoneClose(code2, popUri, noticeActivityGotoIntent);
                }
            }
        }
    }

    public void processNoticeAcitvityPopGotoIntentForSubscribe(NotificationWithActivity notificationWithActivity, int i10) {
        String code;
        boolean z10;
        List<PopUpWithActivityGoto> listRealEfectGotoButtonForPurchasePackageSubscribe = realEfectGotoButtonForPurchasePackageSubscribe(notificationWithActivity);
        if (C0209d.m1205R0(listRealEfectGotoButtonForPurchasePackageSubscribe)) {
            return;
        }
        Iterator<PopUpWithActivityGoto> it = listRealEfectGotoButtonForPurchasePackageSubscribe.iterator();
        while (true) {
            if (!it.hasNext()) {
                code = "";
                z10 = false;
                break;
            }
            PopUpWithActivityGoto next = it.next();
            code = next.getCode();
            String popupType = next.getPopupType();
            if (!TextUtils.isEmpty(popupType) && "close".equals(popupType)) {
                z10 = true;
                break;
            }
        }
        for (PopUpWithActivityGoto popUpWithActivityGoto : listRealEfectGotoButtonForPurchasePackageSubscribe) {
            String code2 = popUpWithActivityGoto.getCode();
            String popupType2 = popUpWithActivityGoto.getPopupType();
            String popupUri = popUpWithActivityGoto.getPopupUri();
            if (!TextUtils.isEmpty(popupType2)) {
                String popUri = NoticeWithActivityUtil.getPopUri(popupType2, popupUri);
                Intent noticeActivityGotoIntent = getNoticeActivityGotoIntent(notificationWithActivity, popUpWithActivityGoto, i10);
                if (z10) {
                    processHasClose(code, code2, popUri, noticeActivityGotoIntent);
                } else {
                    processNoneClose(code2, popUri, noticeActivityGotoIntent);
                }
            }
        }
    }

    public void processNoticeAcitvityPopGotoIntentForThreeButton(NotificationWithActivity notificationWithActivity, int i10) {
        C11839m.m70688i(TAG, "processNoticeAcitvityPopGotoIntentForThreeButton start");
        List<PopUpWithActivityGoto> listRealEfectGotoButtonForThreeButton = realEfectGotoButtonForThreeButton(notificationWithActivity);
        HashMap map = new HashMap();
        if (C0209d.m1205R0(listRealEfectGotoButtonForThreeButton)) {
            return;
        }
        String str = "";
        boolean z10 = false;
        for (PopUpWithActivityGoto popUpWithActivityGoto : listRealEfectGotoButtonForThreeButton) {
            String code = popUpWithActivityGoto.getCode();
            String popupType = popUpWithActivityGoto.getPopupType();
            if (!TextUtils.isEmpty(popupType)) {
                if ("close".equals(popupType)) {
                    z10 = true;
                    str = code;
                }
                if (code.equals(NotifyConstants.POP_GOTO_BUTTON_FIRST)) {
                    map.put(code, this.standByButtonFirstText);
                } else if (code.equals(NotifyConstants.POP_GOTO_BUTTON_SECOND)) {
                    map.put(code, this.standByButtonSecondText);
                } else if (code.equals(NotifyConstants.POP_GOTO_BUTTON_THIRD)) {
                    map.put(code, this.standByButtonThirdText);
                }
            }
        }
        for (PopUpWithActivityGoto popUpWithActivityGoto2 : listRealEfectGotoButtonForThreeButton) {
            String code2 = popUpWithActivityGoto2.getCode();
            String popupType2 = popUpWithActivityGoto2.getPopupType();
            String popupUri = popUpWithActivityGoto2.getPopupUri();
            if (!TextUtils.isEmpty(popupType2)) {
                String popUri = NoticeWithActivityUtil.getPopUri(popupType2, popupUri);
                Intent noticeActivityGotoIntent = getNoticeActivityGotoIntent(notificationWithActivity, popUpWithActivityGoto2, i10);
                C11839m.m70688i(TAG, "isHasCloseButton = " + z10);
                if (z10) {
                    processHasCloseForThreeButton(map, str, code2, popUri, noticeActivityGotoIntent);
                } else {
                    processNoneCloseForThreeButton(code2, popUri, noticeActivityGotoIntent);
                }
            }
        }
    }

    public void processRemoveTask() {
        C10469c.m64350p(this.mContext).m64349m(true);
        C10469c.m64350p(this.mContext).cancel();
        C12515a.m75110o().m75165a1(C10469c.m64350p(this.mContext));
        C10470d.m64355p(this.mContext).m64349m(true);
        C10470d.m64355p(this.mContext).cancel();
        C12515a.m75110o().m75165a1(C10470d.m64355p(this.mContext));
    }

    public void processSpaceNotEnough(int i10) {
        this.mNotificationType = i10;
        C11839m.m70688i(TAG, "Is From NotificationWithActivity = " + this.mNotificationType);
        int i11 = this.mNotificationType;
        if (i11 == 0) {
            showNotificationDialog();
        } else if (i11 == 1) {
            showNotificationWithActivityDialog();
        } else {
            if (i11 != 2) {
                return;
            }
            showNotificationWithTaskCenterDialog();
        }
    }

    public List<PopUpWithActivityGoto> realEfectGotoButtonForPurchasePackageSubscribe(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        C11839m.m70688i(TAG, "realEfectGotoButtonForPurchasePackageSubscribe start");
        if (baseSpaceNotifyBean == null) {
            C11839m.m70688i(TAG, "realEfectGotoButtonForPurchasePackageSubscribe activityNotification is null");
            return null;
        }
        List<PopUpWithActivityGoto> purchasePackageGoto = baseSpaceNotifyBean.getPurchasePackageGoto();
        if (C0209d.m1205R0(purchasePackageGoto)) {
            return null;
        }
        Iterator<PopUpWithActivityGoto> it = purchasePackageGoto.iterator();
        while (it.hasNext()) {
            PopUpWithActivityGoto next = it.next();
            String code = next.getCode();
            if (TextUtils.isEmpty(next.getPopupType())) {
                it.remove();
            } else if (TextUtils.isEmpty(getMultiLanguageForPurchaseTwoButton(code))) {
                it.remove();
            }
        }
        C11839m.m70688i(TAG, "realEfectGotoButtonForPurchasePackageSubscribe Count = " + purchasePackageGoto.size());
        return purchasePackageGoto;
    }

    public List<PopUpWithActivityGoto> realEfectGotoButtonForThreeButton(NotificationWithActivity notificationWithActivity) {
        C11839m.m70688i(TAG, "realEfectGotoButtonForThreeButton start");
        List<PopUpWithActivityGoto> popupGoto3 = notificationWithActivity.getPopupGoto3();
        if (C0209d.m1205R0(popupGoto3)) {
            return null;
        }
        Iterator<PopUpWithActivityGoto> it = popupGoto3.iterator();
        while (it.hasNext()) {
            PopUpWithActivityGoto next = it.next();
            String code = next.getCode();
            if (TextUtils.isEmpty(next.getPopupType())) {
                it.remove();
            } else if (TextUtils.isEmpty(getMultiLanguageForThreeButton(code))) {
                it.remove();
            }
        }
        C11839m.m70688i(TAG, "realEfectGotoButton3 Count = " + popupGoto3.size());
        return popupGoto3;
    }

    public void reportViewDetails() {
        if (this.cloudSpaceIntent == null) {
            C11839m.m70689w(TAG, "positive button cloudSpaceIntent is null");
            return;
        }
        int intExtra = new SafeIntent(this.cloudSpaceIntent).getIntExtra("backup_notification_type", 0);
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
    }

    public void setDialogButton() {
        if (NotifyConstants.GOTO_BUTTON_SECOND.equals(this.gotoButtonWhich)) {
            setButton(-1, this.buttonSecond, this.spaceOnClickListner);
            setButton(-2, this.buttonFirst, this.spaceOnClickListner);
        } else if (NotifyConstants.GOTO_BUTTON_FIRST.equals(this.gotoButtonWhich)) {
            setButton(-1, this.buttonFirst, this.spaceOnClickListner);
            setButton(-2, this.buttonSecond, this.spaceOnClickListner);
        }
    }

    public void setDialogButtonForRecommendPackageWithSubscribe(SpaceNotification spaceNotification, int i10) {
        String code;
        boolean z10;
        List<PopUpWithActivityGoto> listRealEfectGotoButtonForPurchasePackageSubscribe = realEfectGotoButtonForPurchasePackageSubscribe(spaceNotification);
        if (C0209d.m1205R0(listRealEfectGotoButtonForPurchasePackageSubscribe)) {
            return;
        }
        Iterator<PopUpWithActivityGoto> it = listRealEfectGotoButtonForPurchasePackageSubscribe.iterator();
        while (true) {
            if (!it.hasNext()) {
                code = "";
                z10 = false;
                break;
            }
            PopUpWithActivityGoto next = it.next();
            code = next.getCode();
            String popupType = next.getPopupType();
            if (!TextUtils.isEmpty(popupType) && "close".equals(popupType)) {
                z10 = true;
                break;
            }
        }
        for (PopUpWithActivityGoto popUpWithActivityGoto : listRealEfectGotoButtonForPurchasePackageSubscribe) {
            String code2 = popUpWithActivityGoto.getCode();
            String popupType2 = popUpWithActivityGoto.getPopupType();
            String popupUri = popUpWithActivityGoto.getPopupUri();
            if (!TextUtils.isEmpty(popupType2)) {
                String popUri = NoticeWithActivityUtil.getPopUri(popupType2, popupUri);
                Intent noticeActivityGotoIntent = getNoticeActivityGotoIntent(spaceNotification, popUpWithActivityGoto, i10);
                if (z10) {
                    processHasClose(code, code2, popUri, noticeActivityGotoIntent);
                } else {
                    processNoneClose(code2, popUri, noticeActivityGotoIntent);
                }
            }
        }
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

    public void show(int i10) {
        if (2 == i10) {
            setTitle(this.mContext.getString(C2783d.m16179s1(R$string.restoring_app_by_wlan_title, R$string.restoring_app_by_wifi_title)));
            setMessage(this.mContext.getString(C2783d.m16179s1(R$string.restoring_app_by_wlan_message, R$string.restoring_app_by_wifi_message)));
            setButton(-1, this.mContext.getString(R$string.set_wlan), this.wlanOnClicklistner);
            setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), this.wlanOnClicklistner);
            show();
        }
    }

    public void showSpaceActivityNotEnoughDialog(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity == null) {
            C11839m.m70687e(TAG, "showSpaceActivityNotEnoughDialog notification is null.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            finish();
            return;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "showSpaceActivityNotEnoughDialog account is not login.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0029");
            finish();
            return;
        }
        C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog id = " + this.f19203id);
        setDialogTextFirst(this.dialogTextFirst);
        int iM63219c = C10152c.m63219c(this.mContext);
        if (this.isShowViewDetails) {
            iM63219c++;
        }
        if (TextUtils.isEmpty(this.descriptionSecond)) {
            C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog description_second is null");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
            finish();
            return;
        }
        setDialogTextSecond(this.descriptionSecond, this.dialogTextSecond);
        processNoticeAcitvityPopGotoIntent(notificationWithActivity, iM63219c);
        setTitle(this.title);
        if (((BackupNotificationActivity) this.mContext).isFinishing()) {
            C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog is finished");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0031");
            finish();
            return;
        }
        if (this.isShowViewDetails) {
            C11839m.m70688i(TAG, "showSpaceActivityNotEnoughDialog showViewDetails");
            showViewDetails();
        } else {
            C10152c.m63236t(this.mContext);
        }
        if (!checkBtnStrValid()) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
        } else {
            doSpaceNotEnoughReport(null, this.percentage);
            show();
        }
    }

    public void showSpaceNotEnoughDialog(SpaceNotification spaceNotification) {
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "showSpaceNotEnoughDialog account is not login.");
            finish();
            return;
        }
        C11839m.m70688i(TAG, "showSpaceNotEnoughDialog id = " + this.f19203id);
        setDialogTextFirst(this.dialogTextFirst);
        setDialogTextSecond(this.descriptionSecond, this.dialogTextSecond);
        setTitle(this.title);
        setDialogButton();
        if (((BackupNotificationActivity) this.mContext).isFinishing()) {
            C11839m.m70688i(TAG, "BackupNotificationActivity is finished");
            finish();
            return;
        }
        checkShowView(this.isShowViewDetails);
        if (!checkBtnStrValid()) {
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
        } else if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i(TAG, "showSpaceNotEnoughDialog function item switch off");
        } else {
            doSpaceNotEnoughReport(null, this.percentage);
            show();
        }
    }

    public void showViewDetails() {
        C10152c.m63218b(this.mContext);
        if (TextUtils.isEmpty(this.imgUrl) || TextUtils.isEmpty(this.imgHash) || TextUtils.isEmpty(this.markText)) {
            C11839m.m70689w(TAG, "imgUrl or imgHash or  mainText is null");
            return;
        }
        C11828b c11828b = new C11828b(SpaceNoticeV3Manager.getDialogMarkIconPath());
        if (!c11828b.m70492h(this.mContext, this.imgUrl)) {
            this.noticeImage.setBackground(this.mContext.getDrawable(R$drawable.backup_notice_detail));
        }
        c11828b.m70491g(this.imgUrl, this.imgHash, this.noticeImage);
        this.noticeTextView.setText(this.markText);
        this.viewDetailsArea.setVisibility(0);
    }

    public void show(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b) {
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "show backupSpaceNotEnoughNeedData is null.");
            finish();
            return;
        }
        int iM73881j = c12295b.m73881j();
        if (iM73881j == 2 && backupSpaceNotEnoughNeedData.isFamilyShareMember()) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0021", "0012");
            finish();
            return;
        }
        if (iM73881j == 1) {
            this.mNotificationWithActivityOrTaskCenter = c12295b.m73882k();
        }
        if (iM73881j == 2) {
            this.mNotificationWithActivityOrTaskCenter = c12295b.m73883l();
        }
        SpaceNotification spaceNotificationM73886o = c12295b.m73886o();
        this.mNotification = spaceNotificationM73886o;
        if (this.mNotificationWithActivityOrTaskCenter == null && spaceNotificationM73886o == null) {
            C11839m.m70687e(TAG, "show double alert notification is null.");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0001");
            finish();
            return;
        }
        this.totalNeedSpace = backupSpaceNotEnoughNeedData.getTotalNeedSpace();
        this.backupNeedSpace = backupSpaceNotEnoughNeedData.getBackupNeedSpace();
        this.notUsedSpace = backupSpaceNotEnoughNeedData.getNotUsedSpace();
        this.totalSpace = backupSpaceNotEnoughNeedData.getTotalSpace();
        this.usedSpace = backupSpaceNotEnoughNeedData.getUsedSpace();
        this.isFamilyShareMember = backupSpaceNotEnoughNeedData.isFamilyShareMember();
        this.galleryNum = backupSpaceNotEnoughNeedData.getGalleryNum();
        this.backupNoticeNeedInfo = c12295b;
        this.dialogBtnGoto = c12295b.m73877e();
        this.autoBackup = c12295b.m73875c();
        this.isThirdAppSwitchOpen = new C13026e().m78395p();
        processSpaceNotEnough(iM73881j);
    }
}
