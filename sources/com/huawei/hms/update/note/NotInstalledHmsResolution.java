package com.huawei.hms.update.note;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.availableupdate.C5126b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p149ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: classes8.dex */
public class NotInstalledHmsResolution implements IBridgeActivityDelegate {

    /* renamed from: a */
    private Dialog f30134a;

    /* renamed from: b */
    private Activity f30135b;

    /* renamed from: com.huawei.hms.update.note.NotInstalledHmsResolution$a */
    public static class DialogInterfaceOnClickListenerC6516a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        private final Activity f30136a;

        public DialogInterfaceOnClickListenerC6516a(Activity activity) {
            this.f30136a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            HMSLog.m36988i("NotInstalledHmsResolution", "<Dialog onClick>");
            this.f30136a.finish();
        }
    }

    /* renamed from: a */
    private void m36996a(Activity activity) {
        m36995a();
        AlertDialog alertDialogCreate = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new DialogInterfaceOnClickListenerC6516a(activity)).create();
        this.f30134a = alertDialogCreate;
        UIUtil.enableFocusedForButtonsInTV(alertDialogCreate);
        this.f30134a.show();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.m36988i("NotInstalledHmsResolution", "<Resolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m36988i("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        this.f30135b = activity;
        C5126b.f23386b.m30610a(activity);
        m36996a(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m36988i("NotInstalledHmsResolution", "<Resolution onBridgeActivityDestroy>");
        m36995a();
        C5126b.f23386b.m30611b(this.f30135b);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        HMSLog.m36988i("NotInstalledHmsResolution", "<Resolution onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m36988i("NotInstalledHmsResolution", "<Resolution onBridgeConfigurationChanged>");
        Activity activity = this.f30135b;
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> mActivity is null or finishing");
        } else {
            m36996a(this.f30135b);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.m36988i("NotInstalledHmsResolution", "<Resolution onKeyUp>");
    }

    /* renamed from: a */
    private void m36995a() {
        Dialog dialog = this.f30134a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f30134a.cancel();
    }
}
