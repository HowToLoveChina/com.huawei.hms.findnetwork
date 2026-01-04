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
import com.huawei.hicloud.notification.bean.DeskPopupJump;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import hu.C10342a;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12311h;
import p676ud.AlertDialogC13154a;
import p778xk.C13823d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ExpiredDeleteSecondDialog extends AlertDialogC13154a {
    private static final String BUT_CANCEL = "close";
    private static final String TAG = "ExpiredDeleteSecondDialog";
    protected LinkedHashMap<String, String> extras;
    protected TextView firstDescription;
    private boolean isClick;
    protected Activity mActivity;
    protected DeskPopupMsgObj mDeskPopupMsgObj;
    protected TextView secondDescription;
    private String sourceId;
    protected View view;

    public ExpiredDeleteSecondDialog(Activity activity, DeskPopupMsgObj deskPopupMsgObj) {
        super(activity);
        this.extras = new LinkedHashMap<>();
        this.sourceId = "";
        this.isClick = false;
        this.mActivity = activity;
        this.mDeskPopupMsgObj = deskPopupMsgObj;
        this.sourceId = C12311h.m74013c().m74016d(this.mDeskPopupMsgObj);
        this.extras.put("from_where", this.mActivity.getClass().getName());
        this.extras.put("startupSource", "SOURCE_DIALOG");
        this.extras.put("startupSourceId", this.sourceId);
        this.extras.put("cfgId", this.mDeskPopupMsgObj.getResourceInfo());
        this.extras.put(ContentRecord.UNIQUE_ID, this.mDeskPopupMsgObj.getUniqueId());
        this.extras.put("winType", this.mDeskPopupMsgObj.getWinType());
        initView();
        initData();
    }

    private void addButton(List<DeskPopupJump> list) {
        for (int i10 = 0; i10 < Math.min(list.size(), 2); i10++) {
            DeskPopupJump deskPopupJump = list.get(i10);
            final String notifyKey = deskPopupJump.getNotifyKey();
            final String notifyType = deskPopupJump.getNotifyType();
            final String notifyUri = deskPopupJump.getNotifyUri();
            TextView textView = new TextView(this.mActivity);
            if (i10 == 0) {
                textView = (TextView) this.view.findViewById(R$id.space_not_enough_treble_dialog_button_1);
            } else if (i10 == 1) {
                textView = (TextView) this.view.findViewById(R$id.space_not_enough_treble_dialog_button_2);
            }
            C11842p.m70721D1(textView, 2.0f);
            textView.setVisibility(0);
            textView.setText(notifyKey);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19235a.lambda$addButton$2(notifyKey, notifyUri, notifyType, view);
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
            this.view = LayoutInflater.from(this.mActivity).inflate(R$layout.expired_delete_second_dialog_font_scale, (ViewGroup) null);
        } else {
            this.view = LayoutInflater.from(this.mActivity).inflate(R$layout.expired_delete_second_dialog, (ViewGroup) null);
        }
        this.firstDescription = (TextView) C12809f.m76831d(this.view, R$id.title);
        this.secondDescription = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_dialog_text_1);
        C11842p.m70721D1(this.firstDescription, 2.0f);
        C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_1).setVisibility(8);
        C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_2).setVisibility(8);
        setView(this.view);
        setCanceledOnTouchOutside(false);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.n0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f19239a.lambda$initView$0(dialogInterface);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.o0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f19241a.lambda$initView$1(dialogInterface);
            }
        });
    }

    public /* synthetic */ void lambda$addButton$2(String str, String str2, String str3, View view) {
        C11839m.m70688i(TAG, "button click, notifyKey = " + str);
        this.isClick = true;
        NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete_second", str, this.extras);
        if (!TextUtils.equals("close", str2)) {
            Intent intentM82934r = ("application".equals(str3) && NotifyConstants.HICLOUD_CENTER.equals(str2)) ? C13823d.m82904y().m82934r(13) : ("application".equals(str3) && NotifyConstants.HICLOUD_DLAPP.equals(str2)) ? GeneralRedirectUtil.getCommonGotoIntent(NotifyConstants.HICLOUD_DLAPP, RecommendCardManager.getInstance().getH5JumpUrlFromSp(), false) : GeneralRedirectUtil.getCommonGotoIntent(str3, str2, false);
            intentM82934r.putExtra("from_where", 14);
            if (!TextUtils.equals(str3, NotifyConstants.TYPE_DEEPLINK)) {
                C0216g0.m1402e(C0213f.m1377a()).m1407E(intentM82934r, this.sourceId);
            }
            intentM82934r.putExtra("cfgId", this.mDeskPopupMsgObj.getResourceInfo());
            C10342a.m63676b(this.mActivity, new HiCloudSafeIntent(intentM82934r));
        }
        C11839m.m70688i(TAG, "desktop dialog click");
        dismiss();
    }

    public /* synthetic */ void lambda$initView$0(DialogInterface dialogInterface) {
        C11839m.m70688i(TAG, "dialog show");
        this.isClick = false;
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            C11839m.m70689w(TAG, "show, activity is finishing or destroyed");
        } else {
            NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete_second", ParamConstants.CallbackMethod.ON_SHOW, this.extras);
        }
    }

    public /* synthetic */ void lambda$initView$1(DialogInterface dialogInterface) {
        C11839m.m70688i(TAG, "dialog dismiss, isClick: " + this.isClick);
        if (!this.isClick) {
            NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete_second", "cancel", this.extras);
        }
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            C11839m.m70689w(TAG, "dismiss, activity is finishing or destroyed");
        } else {
            this.mActivity.finish();
        }
    }
}
