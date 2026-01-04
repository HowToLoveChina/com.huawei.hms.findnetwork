package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.C5125a;
import com.huawei.hms.p148ui.AbstractDialog;
import com.huawei.hms.p148ui.AbstractPromptDialog;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: classes8.dex */
public class AppSpoofResolution implements IBridgeActivityDelegate {

    /* renamed from: a */
    private Activity f30131a;

    /* renamed from: b */
    private C6515b f30132b;

    /* renamed from: com.huawei.hms.update.note.AppSpoofResolution$a */
    public class C6514a implements AbstractDialog.Callback {
        public C6514a() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            C5125a.f23382c.m30608a(true);
            AppSpoofResolution.this.f30132b = null;
            AppSpoofResolution.this.m36992a();
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            C5125a.f23382c.m30608a(true);
            AppSpoofResolution.this.f30132b = null;
            AppSpoofResolution.this.m36992a();
        }
    }

    /* renamed from: com.huawei.hms.update.note.AppSpoofResolution$b */
    public static class C6515b extends AbstractPromptDialog {
        private C6515b() {
        }

        @Override // com.huawei.hms.p148ui.AbstractDialog
        public String onGetMessageString(Context context) throws PackageManager.NameNotFoundException {
            String applicationName = new PackageManagerHelper(context).getApplicationName("com.huawei.hwid");
            String str = TextUtils.isEmpty(applicationName) ? "com.huawei.hwid" : applicationName;
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_is_spoof", str);
        }

        @Override // com.huawei.hms.p148ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        @Override // com.huawei.hms.p148ui.AbstractPromptDialog, com.huawei.hms.p148ui.AbstractDialog
        public String onGetTitleString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_spoof_hints");
        }

        public /* synthetic */ C6515b(C6514a c6514a) {
            this();
        }
    }

    /* renamed from: b */
    private void m36994b() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        C6515b c6515b = this.f30132b;
        if (c6515b == null) {
            this.f30132b = new C6515b(null);
        } else {
            c6515b.dismiss();
        }
        HMSLog.m36988i("AppSpoofResolution", "enter AppSpoofResolution showPromptdlg to resolve conn error");
        this.f30132b.show(activity, new C6514a());
    }

    public Activity getActivity() {
        return this.f30131a;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m36988i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityCreate");
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("AppSpoofResolution", "activity is null or finishing");
            return;
        }
        this.f30131a = activity;
        C5125a c5125a = C5125a.f23382c;
        c5125a.m30607a(activity);
        c5125a.m30608a(false);
        m36994b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m36988i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityDestroy");
        C5125a c5125a = C5125a.f23382c;
        if (c5125a.m30606a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        c5125a.m30609b(this.f30131a);
        this.f30131a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        if (i10 != getRequestCode()) {
            return false;
        }
        HMSLog.m36988i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityResult");
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.f30132b == null) {
            return;
        }
        HMSLog.m36988i("AppSpoofResolution", "enter AppSpoofResolution re show prompt dialog");
        m36994b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.m36988i("AppSpoofResolution", "enter AppSpoofResolution On key up when resolve spoof error");
    }

    /* renamed from: a */
    public void m36992a() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        HMSLog.m36988i("AppSpoofResolution", "enter AppSpoofResolution finishBridgeActivity：");
        if (C5125a.f23382c.m30606a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        activity.finish();
    }
}
