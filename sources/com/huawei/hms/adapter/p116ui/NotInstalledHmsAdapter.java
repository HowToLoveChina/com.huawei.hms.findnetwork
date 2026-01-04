package com.huawei.hms.adapter.p116ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p149ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: classes8.dex */
public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {

    /* renamed from: c */
    private static final Object f23134c = new Object();

    /* renamed from: d */
    private static boolean f23135d;

    /* renamed from: a */
    private Activity f23136a;

    /* renamed from: b */
    private Dialog f23137b;

    /* renamed from: com.huawei.hms.adapter.ui.NotInstalledHmsAdapter$a */
    public static class DialogInterfaceOnCancelListenerC5060a implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        private final Activity f23138a;

        public DialogInterfaceOnCancelListenerC5060a(Activity activity) {
            this.f23138a = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            HMSLog.m36988i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f23138a.finish();
        }
    }

    /* renamed from: com.huawei.hms.adapter.ui.NotInstalledHmsAdapter$b */
    public static class DialogInterfaceOnClickListenerC5061b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        private final Activity f23139a;

        public DialogInterfaceOnClickListenerC5061b(Activity activity) {
            this.f23139a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            HMSLog.m36988i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f23139a.finish();
        }
    }

    /* renamed from: a */
    private void m30218a(Activity activity) {
        Dialog dialog = this.f23137b;
        if (dialog != null && dialog.isShowing()) {
            this.f23137b.setOnCancelListener(null);
            this.f23137b.cancel();
        }
        AlertDialog alertDialogCreate = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new DialogInterfaceOnClickListenerC5061b(activity)).setOnCancelListener(new DialogInterfaceOnCancelListenerC5060a(activity)).create();
        this.f23137b = alertDialogCreate;
        UIUtil.enableFocusedForButtonsInTV(alertDialogCreate);
        this.f23137b.show();
    }

    public static boolean getShowLock() {
        synchronized (f23134c) {
            try {
                HMSLog.m36988i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + f23135d);
                if (f23135d) {
                    return false;
                }
                f23135d = true;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.m36988i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m36988i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
        } else {
            this.f23136a = activity;
            m30218a(activity);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m36988i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (f23134c) {
            f23135d = false;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        HMSLog.m36988i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m36988i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity activity = this.f23136a;
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        } else {
            m30218a(this.f23136a);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.m36988i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}
