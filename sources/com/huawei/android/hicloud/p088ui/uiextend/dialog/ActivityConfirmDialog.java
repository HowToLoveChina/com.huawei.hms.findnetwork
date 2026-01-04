package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetailGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0216g0;
import p450le.C11272a;
import p514o9.C11839m;
import p618rm.C12590s0;
import p676ud.AlertDialogC13154a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ActivityConfirmDialog extends AlertDialogC13154a {
    private static final String TAG = "ActivityConfirmDialog";
    private ActivityEntry activityEntry;
    protected boolean autoBackup;
    private TextView descTv;
    private Context mContext;
    private Button negtiveButton;
    private Button positiveButton;
    private TextView titleTv;

    public class ActivityConfirmDialogClickListner implements View.OnClickListener {
        private String h5Url;
        private NoticeDetailGoto noticeDetailGoto;

        public ActivityConfirmDialogClickListner(NoticeDetailGoto noticeDetailGoto, String str) {
            this.noticeDetailGoto = noticeDetailGoto;
            this.h5Url = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ActivityConfirmDialog.this.mContext == null) {
                C11839m.m70687e(ActivityConfirmDialog.TAG, "ActivitySpaceOnClickListner mContext is null");
                return;
            }
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            String type = this.noticeDetailGoto.getType();
            String deeplinkUri = this.noticeDetailGoto.getDeeplinkUri();
            String uri = this.noticeDetailGoto.getUri();
            Intent dlAppWebViewIntent = null;
            if (C12590s0.m75807V0(deeplinkUri)) {
                C11839m.m70688i(ActivityConfirmDialog.TAG, "click deeplink.");
                Intent intentM75832b0 = C12590s0.m75832b0(deeplinkUri, null, false);
                linkedHashMapM79499C.put("acitivty_confirm_btn_type", type);
                linkedHashMapM79499C.put("acitivty_confirm_btn_uri", uri);
                linkedHashMapM79499C.put("activity_confirm_btn_deeplink", deeplinkUri);
                ActivityConfirmDialog.this.mContext.startActivity(intentM75832b0);
                ActivityConfirmDialog.this.dismiss();
            } else if (TextUtils.equals("application", type)) {
                if (NotifyConstants.HICLOUD_DLAPP.equals(uri)) {
                    if (TextUtils.isEmpty(this.h5Url)) {
                        NotifyLogger.m29914e(ActivityConfirmDialog.TAG, "getGotoIntent h5ActivityUrl is null");
                        return;
                    }
                    try {
                        dlAppWebViewIntent = NotifyUtil.getDlAppWebViewIntent(ActivityConfirmDialog.this.mContext, this.h5Url);
                        C11272a.m67641a(dlAppWebViewIntent, ActivityConfirmDialog.this.activityEntry);
                    } catch (Exception e10) {
                        NotifyLogger.m29914e(ActivityConfirmDialog.TAG, "getNoticeActivityGotoIntent e:" + e10.toString());
                        return;
                    }
                }
                C0216g0.m1402e(ActivityConfirmDialog.this.mContext).m1407E(dlAppWebViewIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG");
                linkedHashMapM79499C.put("acitivty_confirm_btn_type", type);
                linkedHashMapM79499C.put("acitivty_confirm_btn_uri", uri);
                ActivityConfirmDialog.this.mContext.startActivity(dlAppWebViewIntent);
                ActivityConfirmDialog.this.dismiss();
            } else if (TextUtils.equals("close", type)) {
                linkedHashMapM79499C.put("acitivty_confirm_btn_type", type);
                if (ActivityConfirmDialog.this.autoBackup) {
                    C11839m.m70688i(ActivityConfirmDialog.TAG, "click cancel, add record");
                    UserNegFeedbackManager.getInstance(ActivityConfirmDialog.this.mContext).addRecordCount(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT);
                }
                ActivityConfirmDialog.this.dismiss();
            } else {
                C11839m.m70687e(ActivityConfirmDialog.TAG, "ActivitySpaceOnClickListner invalid type = " + type);
                ActivityConfirmDialog.this.dismiss();
            }
            C13227f.m79492i1().m79591l0("acitivty_confirm_btn_click", linkedHashMapM79499C);
            UBAAnalyze.m29958S("PVC", "acitivty_confirm_btn_click", "4", "9", linkedHashMapM79499C);
        }
    }

    public static class ActivityTypeToken extends TypeToken<List<PortraitAndGrade.UserTag>> {
    }

    public ActivityConfirmDialog(Context context, ActivityEntry activityEntry, boolean z10) {
        super(context);
        this.mContext = context;
        this.activityEntry = activityEntry;
        this.autoBackup = z10;
    }

    private void finish() {
        Context context = this.mContext;
        if (context == null || !(context instanceof BackupNotificationActivity)) {
            return;
        }
        ((BackupNotificationActivity) context).finish();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        finish();
    }

    public void showDialog(NotificationWithActivity notificationWithActivity) {
        if (this.activityEntry == null) {
            C11839m.m70687e(TAG, "showDialog activityEntry is null.");
            finish();
            return;
        }
        if (notificationWithActivity == null) {
            C11839m.m70687e(TAG, "showDialog notification is null.");
            finish();
            return;
        }
        C11839m.m70688i(TAG, "showDialog notification id = " + notificationWithActivity.getId());
        String resource = this.activityEntry.getResource();
        String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_TITLE);
        String strFromDBByResource2 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_MAIN_TEXT);
        String strFromDBByResource3 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_BUTTON_FIRST);
        String strFromDBByResource4 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5BackupNotEnoughNoticeKey.ACTIVE_POP_BUTTON_SECOND);
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
        this.titleTv.setText(strFromDBByResource);
        this.descTv.setText(strFromDBByResource2);
        this.negtiveButton.setText(strFromDBByResource3);
        this.positiveButton.setText(strFromDBByResource4);
        String url = this.activityEntry.getUrl();
        this.negtiveButton.setOnClickListener(new ActivityConfirmDialogClickListner(activityGoto.get(0), url));
        this.positiveButton.setOnClickListener(new ActivityConfirmDialogClickListner(activityGoto.get(1), url));
        setCanceledOnTouchOutside(false);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79591l0("mecloud_acitivty_confirm_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_acitivty_confirm_show", "4", "9", linkedHashMapM79499C);
        show();
    }
}
