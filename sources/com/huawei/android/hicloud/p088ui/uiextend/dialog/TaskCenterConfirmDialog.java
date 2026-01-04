package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetailGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0216g0;
import p514o9.C11839m;
import p618rm.C12590s0;
import p676ud.AlertDialogC13154a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p778xk.C13823d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TaskCenterConfirmDialog extends AlertDialogC13154a {
    private static final String TAG = "ActivityConfirmDialog";
    protected boolean autoBackup;
    private TextView descTv;
    private Context mContext;
    private Button negtiveButton;
    private Button positiveButton;
    private TextView titleTv;

    public class TaskCenterConfirmDialogClickListener implements View.OnClickListener {
        private String h5Url;
        private NoticeDetailGoto noticeDetailGoto;

        public TaskCenterConfirmDialogClickListener(NoticeDetailGoto noticeDetailGoto) {
            this.noticeDetailGoto = noticeDetailGoto;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TaskCenterConfirmDialog.this.mContext == null) {
                C11839m.m70687e(TaskCenterConfirmDialog.TAG, "ActivitySpaceOnClickListner mContext is null");
                return;
            }
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            String type = this.noticeDetailGoto.getType();
            String deeplinkUri = this.noticeDetailGoto.getDeeplinkUri();
            String uri = this.noticeDetailGoto.getUri();
            Intent intentM82934r = null;
            if (C12590s0.m75807V0(deeplinkUri)) {
                C11839m.m70688i(TaskCenterConfirmDialog.TAG, "click deeplink.");
                Intent intentM75832b0 = C12590s0.m75832b0(deeplinkUri, null, false);
                C0216g0.m1402e(TaskCenterConfirmDialog.this.mContext).m1407E(intentM75832b0, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                linkedHashMapM79499C.put("acitivty_confirm_btn_type", type);
                linkedHashMapM79499C.put("acitivty_confirm_btn_uri", uri);
                linkedHashMapM79499C.put("activity_confirm_btn_deeplink", deeplinkUri);
                TaskCenterConfirmDialog.this.mContext.startActivity(intentM75832b0);
                TaskCenterConfirmDialog.this.dismiss();
            } else if (TextUtils.equals("application", type)) {
                if (NotifyConstants.HICLOUD_DLAPP.equals(uri)) {
                    if (TextUtils.isEmpty(this.h5Url)) {
                        NotifyLogger.m29914e(TaskCenterConfirmDialog.TAG, "getGotoIntent h5ActivityUrl is null");
                        TaskCenterConfirmDialog.this.dismiss();
                        return;
                    }
                    try {
                        intentM82934r = NotifyUtil.getDlAppWebViewIntent(TaskCenterConfirmDialog.this.mContext, this.h5Url);
                    } catch (Exception e10) {
                        NotifyLogger.m29914e(TaskCenterConfirmDialog.TAG, "getNoticeActivityGotoIntent e:" + e10.toString());
                        TaskCenterConfirmDialog.this.dismiss();
                        return;
                    }
                }
                if (NotifyConstants.HICLOUD_CENTER.equals(uri)) {
                    intentM82934r = C13823d.m82904y().m82934r(6);
                }
                C0216g0.m1402e(TaskCenterConfirmDialog.this.mContext).m1407E(intentM82934r, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                linkedHashMapM79499C.put("task_center_confirm_btn_type", type);
                linkedHashMapM79499C.put("task_center_confirm_btn_uri", uri);
                TaskCenterConfirmDialog.this.mContext.startActivity(intentM82934r);
                TaskCenterConfirmDialog.this.dismiss();
            } else if (TextUtils.equals("close", type)) {
                linkedHashMapM79499C.put("task_center_confirm_btn_type", type);
                if (TaskCenterConfirmDialog.this.autoBackup) {
                    C11839m.m70688i(TaskCenterConfirmDialog.TAG, "click cancel, add record");
                    UserNegFeedbackManager.getInstance(TaskCenterConfirmDialog.this.mContext).addRecordCount(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
                }
                TaskCenterConfirmDialog.this.dismiss();
            } else {
                C11839m.m70687e(TaskCenterConfirmDialog.TAG, "ActivitySpaceOnClickListner invalid type = " + type);
                TaskCenterConfirmDialog.this.dismiss();
            }
            C13227f.m79492i1().m79591l0("task_center_confirm_btn_click", linkedHashMapM79499C);
            UBAAnalyze.m29958S("PVC", "task_center_confirm_btn_click", "4", "9", linkedHashMapM79499C);
        }
    }

    public TaskCenterConfirmDialog(Context context, boolean z10) {
        super(context);
        this.mContext = context;
        this.autoBackup = z10;
    }

    private void finish() {
        Context context = this.mContext;
        if (context instanceof BackupNotificationActivity) {
            ((BackupNotificationActivity) context).finish();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        finish();
    }

    public void showDialog(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity == null) {
            C11839m.m70687e(TAG, "showDialog notification is null.");
            finish();
            return;
        }
        NoticeContent noticeContentQueryPopupNotificationContent = NoticeWithActivityUtil.queryPopupNotificationContent(notificationWithActivity, false);
        if (noticeContentQueryPopupNotificationContent == null) {
            C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog noticePopContent is null");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", NotifyConstants.NotificationReport.RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ);
            return;
        }
        if (!SpaceInsuffNoticeV4Manager.getInstance().checkMultiLanguage(notificationWithActivity.getId(), noticeContentQueryPopupNotificationContent.getPopupTitle(), noticeContentQueryPopupNotificationContent.getPopupMainText(), noticeContentQueryPopupNotificationContent.getPopupButtonFirst(), noticeContentQueryPopupNotificationContent.getPopupButtonSecond())) {
            C11839m.m70687e(TAG, "prepareSpaceActivityNotEnoughDialog checkMultiLanguage fail");
            NotificationReportUtil.reportCloudBackupNoSpace("0002", "0033");
            return;
        }
        String stringWithDefault = SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentQueryPopupNotificationContent.getPopupTitle(), notificationWithActivity.getId());
        String stringWithDefault2 = SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentQueryPopupNotificationContent.getPopupMainText(), notificationWithActivity.getId());
        String stringWithDefault3 = SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentQueryPopupNotificationContent.getPopupButtonFirst(), notificationWithActivity.getId());
        String stringWithDefault4 = SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(noticeContentQueryPopupNotificationContent.getPopupButtonSecond(), notificationWithActivity.getId());
        List<NoticeDetailGoto> activityGoto = notificationWithActivity.getActivityGoto();
        if (activityGoto == null || activityGoto.size() <= 1) {
            C11839m.m70687e(TAG, "activityGotoList is null.");
            finish();
            return;
        }
        View viewInflate = getLayoutInflater().inflate(R$layout.second_confirm_dialog, (ViewGroup) null);
        if (C0209d.m1195O(this.mContext) >= 1.75f) {
            viewInflate = getLayoutInflater().inflate(R$layout.second_confirm_dialog_scale, (ViewGroup) null);
        }
        setView(viewInflate);
        this.titleTv = (TextView) C12809f.m76831d(viewInflate, R$id.title);
        this.descTv = (TextView) C12809f.m76831d(viewInflate, R$id.description);
        this.negtiveButton = (Button) C12809f.m76831d(viewInflate, R$id.negtive_btn);
        this.positiveButton = (Button) C12809f.m76831d(viewInflate, R$id.positive_btn);
        this.titleTv.setText(stringWithDefault);
        this.descTv.setText(stringWithDefault2);
        this.negtiveButton.setText(stringWithDefault3);
        this.positiveButton.setText(stringWithDefault4);
        this.negtiveButton.setOnClickListener(new TaskCenterConfirmDialogClickListener(activityGoto.get(0)));
        this.positiveButton.setOnClickListener(new TaskCenterConfirmDialogClickListener(activityGoto.get(1)));
        setCanceledOnTouchOutside(false);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79591l0("mecloud_task_center_confirm_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_task_center_confirm_show", "4", "9", linkedHashMapM79499C);
        show();
    }
}
