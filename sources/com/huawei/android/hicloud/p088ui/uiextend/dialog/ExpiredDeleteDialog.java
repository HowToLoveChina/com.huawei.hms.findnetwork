package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj;
import com.huawei.hicloud.messagecenter.operator.MessageDeskPopupDbOperator;
import com.huawei.hicloud.notification.bean.DeskPopupJump;
import com.huawei.hicloud.notification.bean.SecondWindows;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.request.notify.NotifyService;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import fk.C9721b;
import hu.C10342a;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0216g0;
import p431ko.C11081g;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12311h;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p676ud.AlertDialogC13154a;
import p815ym.AbstractC14026a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ExpiredDeleteDialog extends AlertDialogC13154a {
    private static final String BUT_CANCEL = "close";
    private static final String TAG = "ExpiredDeleteDialog";
    private ExpiredDeleteSecondDialog expiredDeleteSecondDialog;
    protected LinkedHashMap<String, String> extras;
    protected TextView firstDescription;
    private boolean isCancel;
    private boolean isClick;
    protected Activity mActivity;
    protected DeskPopupMsgObj mDeskPopupMsgObj;
    protected TextView secondDescription;
    private String sourceId;
    protected View view;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.ExpiredDeleteDialog$1 */
    public class C41921 extends AbstractC12367d {
        public C41921() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                boolean zExposureReport = new NotifyService().exposureReport(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getMessageId(), ExpiredDeleteDialog.this.mDeskPopupMsgObj.getResourceInfo());
                ExpiredDeleteDialog.this.extras.put("notify_result", zExposureReport + "");
                NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete", ParamConstants.CallbackMethod.ON_SHOW, ExpiredDeleteDialog.this.extras);
                new MessageDeskPopupDbOperator().setAlreadyRead(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getUniqueId());
            } catch (Exception e10) {
                NotifyLogger.m29914e(ExpiredDeleteDialog.TAG, "insertDeskPopupMsg exception, e: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.ExpiredDeleteDialog$2 */
    public class DialogInterfaceOnCancelListenerC41932 implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC41932() {
        }

        private DeskPopupMsgObj getSecondDeskPopupMsgObj(List<SecondWindows> list) {
            SecondWindows secondWindows = list.get(0);
            DeskPopupMsgObj deskPopupMsgObj = new DeskPopupMsgObj();
            deskPopupMsgObj.setResourceInfo(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getResourceInfo());
            deskPopupMsgObj.setUniqueId(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getUniqueId());
            deskPopupMsgObj.setDeskPopupAction(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getDeskPopupAction());
            deskPopupMsgObj.setDesktopTitle(secondWindows.getTitle());
            deskPopupMsgObj.setDesktopText(secondWindows.getMainText());
            deskPopupMsgObj.setDesktopGoto(secondWindows.getButtons());
            deskPopupMsgObj.setWinType(secondWindows.getWinType());
            return deskPopupMsgObj;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C11839m.m70688i(ExpiredDeleteDialog.TAG, "dialog cancel, isClick: " + ExpiredDeleteDialog.this.isClick);
            List<SecondWindows> secondWindows = ExpiredDeleteDialog.this.mDeskPopupMsgObj.getSecondWindows();
            ExpiredDeleteDialog.this.isCancel = true;
            if (AbstractC14026a.m84159a(secondWindows)) {
                C11839m.m70688i(ExpiredDeleteDialog.TAG, "dialog cancel, not need show second dialog");
                ExpiredDeleteDialog.this.mActivity.finish();
            } else {
                ExpiredDeleteDialog.this.expiredDeleteSecondDialog = new ExpiredDeleteSecondDialog(ExpiredDeleteDialog.this.mActivity, getSecondDeskPopupMsgObj(secondWindows));
                ExpiredDeleteDialog.this.expiredDeleteSecondDialog.show();
            }
        }
    }

    public ExpiredDeleteDialog(Activity activity, DeskPopupMsgObj deskPopupMsgObj) {
        super(activity);
        this.extras = new LinkedHashMap<>();
        this.sourceId = "";
        this.isClick = false;
        this.isCancel = false;
        this.mActivity = activity;
        this.mDeskPopupMsgObj = deskPopupMsgObj;
        this.sourceId = C12311h.m74013c().m74016d(this.mDeskPopupMsgObj);
        this.extras.put("from_where", this.mActivity.getClass().getName());
        this.extras.put("startupSource", "SOURCE_DIALOG");
        this.extras.put("startupSourceId", this.sourceId);
        this.extras.put("cfgId", this.mDeskPopupMsgObj.getResourceInfo());
        this.extras.put(ContentRecord.UNIQUE_ID, this.mDeskPopupMsgObj.getUniqueId());
        initView();
        initData();
    }

    private void addButton(List<DeskPopupJump> list) {
        for (int i10 = 0; i10 < Math.min(list.size(), 3); i10++) {
            DeskPopupJump deskPopupJump = list.get(i10);
            final String notifyKey = deskPopupJump.getNotifyKey();
            final String notifyType = deskPopupJump.getNotifyType();
            final String notifyUri = deskPopupJump.getNotifyUri();
            TextView textView = new TextView(this.mActivity);
            if (i10 == 0) {
                textView = (TextView) this.view.findViewById(R$id.space_not_enough_treble_dialog_button_1);
            } else if (i10 == 1) {
                textView = (TextView) this.view.findViewById(R$id.space_not_enough_treble_dialog_button_2);
            } else if (i10 == 2) {
                textView = (TextView) this.view.findViewById(R$id.space_not_enough_treble_dialog_button_3);
            }
            C11842p.m70721D1(textView, 2.0f);
            textView.setVisibility(0);
            textView.setText(notifyKey);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19230a.lambda$addButton$2(notifyKey, notifyUri, notifyType, view);
                }
            });
        }
    }

    private void initData() {
        this.firstDescription.setText(this.mDeskPopupMsgObj.getDesktopTitle());
        this.secondDescription.setText(this.mDeskPopupMsgObj.getDesktopText());
        addButton(this.mDeskPopupMsgObj.getDesktopGoto());
    }

    private void initView() {
        if (C0209d.m1195O(C0213f.m1377a()) >= 1.75f) {
            this.view = LayoutInflater.from(this.mActivity).inflate(R$layout.expired_delete_dialog_font_scale, (ViewGroup) null);
        } else {
            this.view = LayoutInflater.from(this.mActivity).inflate(R$layout.expired_delete_dialog, (ViewGroup) null);
        }
        this.firstDescription = (TextView) C12809f.m76831d(this.view, R$id.title);
        this.secondDescription = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_dialog_text_1);
        C11842p.m70721D1(this.firstDescription, 2.0f);
        C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_1).setVisibility(8);
        C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_2).setVisibility(8);
        C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_3).setVisibility(8);
        setView(this.view);
        setCanceledOnTouchOutside(false);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.j0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f19226a.lambda$initView$0(dialogInterface);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.k0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f19228a.lambda$initView$1(dialogInterface);
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.ExpiredDeleteDialog.2
            public DialogInterfaceOnCancelListenerC41932() {
            }

            private DeskPopupMsgObj getSecondDeskPopupMsgObj(List<SecondWindows> list) {
                SecondWindows secondWindows = list.get(0);
                DeskPopupMsgObj deskPopupMsgObj = new DeskPopupMsgObj();
                deskPopupMsgObj.setResourceInfo(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getResourceInfo());
                deskPopupMsgObj.setUniqueId(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getUniqueId());
                deskPopupMsgObj.setDeskPopupAction(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getDeskPopupAction());
                deskPopupMsgObj.setDesktopTitle(secondWindows.getTitle());
                deskPopupMsgObj.setDesktopText(secondWindows.getMainText());
                deskPopupMsgObj.setDesktopGoto(secondWindows.getButtons());
                deskPopupMsgObj.setWinType(secondWindows.getWinType());
                return deskPopupMsgObj;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                C11839m.m70688i(ExpiredDeleteDialog.TAG, "dialog cancel, isClick: " + ExpiredDeleteDialog.this.isClick);
                List<SecondWindows> secondWindows = ExpiredDeleteDialog.this.mDeskPopupMsgObj.getSecondWindows();
                ExpiredDeleteDialog.this.isCancel = true;
                if (AbstractC14026a.m84159a(secondWindows)) {
                    C11839m.m70688i(ExpiredDeleteDialog.TAG, "dialog cancel, not need show second dialog");
                    ExpiredDeleteDialog.this.mActivity.finish();
                } else {
                    ExpiredDeleteDialog.this.expiredDeleteSecondDialog = new ExpiredDeleteSecondDialog(ExpiredDeleteDialog.this.mActivity, getSecondDeskPopupMsgObj(secondWindows));
                    ExpiredDeleteDialog.this.expiredDeleteSecondDialog.show();
                }
            }
        });
    }

    public /* synthetic */ void lambda$addButton$2(String str, String str2, String str3, View view) {
        C11839m.m70688i(TAG, "button click, notifyKey = " + str);
        this.isClick = true;
        NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete", str, this.extras);
        if (!TextUtils.equals("close", str2)) {
            Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(str3, str2, false);
            if (commonGotoIntent != null) {
                commonGotoIntent.putExtra("from_where", 14);
                if (!TextUtils.equals(str3, NotifyConstants.TYPE_DEEPLINK)) {
                    C0216g0.m1402e(C0213f.m1377a()).m1407E(commonGotoIntent, this.sourceId);
                }
                commonGotoIntent.putExtra("cfgId", this.mDeskPopupMsgObj.getResourceInfo());
                C10342a.m63676b(this.mActivity, new HiCloudSafeIntent(commonGotoIntent));
            } else {
                C11839m.m70689w(TAG, "intent is null!");
            }
        }
        C11839m.m70688i(TAG, "desktop dialog click");
        C12515a.m75110o().m75172d(new C11081g(str, "desktopPopup", this.mDeskPopupMsgObj.getDeskPopupAction()));
        if (TextUtils.equals("close", str2)) {
            cancel();
        } else {
            dismiss();
        }
    }

    public /* synthetic */ void lambda$initView$0(DialogInterface dialogInterface) {
        C11839m.m70688i(TAG, "dialog show");
        this.isClick = false;
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            C11839m.m70689w(TAG, "show, activity is finishing or destroyed");
            return;
        }
        int iM1357g = C0212e0.m1357g(this.mActivity, "sp_desktop_dialog", "key_last_show_count", 0);
        C0212e0.m1370t(this.mActivity, "sp_desktop_dialog", "key_last_show_time", System.currentTimeMillis());
        C0212e0.m1368r(this.mActivity, "sp_desktop_dialog", "key_last_show_count", iM1357g + 1);
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.ExpiredDeleteDialog.1
            public C41921() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                try {
                    boolean zExposureReport = new NotifyService().exposureReport(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getMessageId(), ExpiredDeleteDialog.this.mDeskPopupMsgObj.getResourceInfo());
                    ExpiredDeleteDialog.this.extras.put("notify_result", zExposureReport + "");
                    NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete", ParamConstants.CallbackMethod.ON_SHOW, ExpiredDeleteDialog.this.extras);
                    new MessageDeskPopupDbOperator().setAlreadyRead(ExpiredDeleteDialog.this.mDeskPopupMsgObj.getUniqueId());
                } catch (Exception e10) {
                    NotifyLogger.m29914e(ExpiredDeleteDialog.TAG, "insertDeskPopupMsg exception, e: " + e10.toString());
                }
            }
        });
    }

    public /* synthetic */ void lambda$initView$1(DialogInterface dialogInterface) {
        C11839m.m70688i(TAG, "dialog dismiss, isClick: " + this.isClick);
        if (!this.isClick) {
            NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete", "cancel", this.extras);
        }
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            C11839m.m70689w(TAG, "dismiss, activity is finishing or destroyed");
        } else {
            if (this.isCancel) {
                return;
            }
            this.mActivity.finish();
        }
    }

    public ExpiredDeleteSecondDialog getExpiredDeleteSecondDialog() {
        return this.expiredDeleteSecondDialog;
    }
}
