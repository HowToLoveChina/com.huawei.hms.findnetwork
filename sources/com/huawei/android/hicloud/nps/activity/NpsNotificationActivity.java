package com.huawei.android.hicloud.nps.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.p088ui.activity.BaseActivity;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.hicloud.account.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NpsShowManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p684un.C13227f;
import p709vj.C13452e;
import p805yb.C13933c;

/* loaded from: classes3.dex */
public class NpsNotificationActivity extends BaseActivity {

    /* renamed from: p */
    public AlertDialog f12276p;

    /* renamed from: com.huawei.android.hicloud.nps.activity.NpsNotificationActivity$a */
    public class DialogInterfaceOnClickListenerC2811a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2811a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            NpsNotificationActivity.this.finish();
        }
    }

    /* renamed from: M1 */
    public AlertDialog m16516M1(Context context) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle(context.getString(R$string.alert)).setMessage(context.getString(com.huawei.hicloud.sync.R$string.nps_end_dlg_message)).setPositiveButton(com.huawei.hicloud.sync.R$string.hicloud_service_location_change_13, new DialogInterfaceOnClickListenerC2811a()).create();
        alertDialogCreate.show();
        return alertDialogCreate;
    }

    /* renamed from: N1 */
    public final void m16517N1() {
        Context contextM1377a = C0213f.m1377a();
        String strM83687u = C13933c.m83668n().m83687u(C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_URL, ""));
        NotifyLogger.m29913d("NpsNotificationActivity", "destUrl: " + strM83687u);
        String string = contextM1377a.getString(com.huawei.hicloud.sync.R$string.HiCloud_app_name);
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
        intent.putExtra("url", strM83687u);
        intent.putExtra("title", string);
        intent.putExtra("isEnableJs", true);
        try {
            startActivity(intent);
            finish();
        } catch (Exception e10) {
            NotifyLogger.m29914e("NpsNotificationActivity", "startNpsWebView exception: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (new HiCloudSafeIntent(getIntent()).getBooleanExtra(BackupNotification.FROM_NOTIFICATION, false)) {
            C13227f.m79492i1().m79585f0("click_to_nps_notification", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "click_to_nps_notification", "2", "83");
        }
        if (NpsShowManager.getInstance().checkOpenUrl(this)) {
            m16517N1();
        } else {
            this.f12276p = m16516M1(this);
        }
        C13933c.m83668n().m83675g();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f12276p;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f12276p = null;
        }
    }
}
