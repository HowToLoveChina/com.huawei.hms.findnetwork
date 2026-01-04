package com.huawei.android.hicloud.p088ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import ge.C9913h;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0234s;
import p514o9.C11839m;
import sk.C12808e;
import tj.C13019a;

/* loaded from: classes3.dex */
public class UpgradeEmptyActivity extends Activity {

    /* renamed from: a */
    public int f13430a = 24;

    /* renamed from: b */
    public AlertDialog f13431b;

    /* renamed from: com.huawei.android.hicloud.ui.UpgradeEmptyActivity$a */
    public class DialogInterfaceOnClickListenerC3105a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3105a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            UpgradeEmptyActivity.this.m18483a();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.UpgradeEmptyActivity$b */
    public static class RunnableC3106b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            C11839m.m70688i(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY, "removeAllActivity run");
            C13019a.m78347n().m78355r();
        }
    }

    /* renamed from: a */
    public void m18483a() {
        C11839m.m70688i(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY, "exitAPP");
        finish();
        new Handler().postDelayed(new RunnableC3106b(), 200L);
    }

    /* renamed from: b */
    public final void m18484b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.hicloud_update_bottom_dialog, (ViewGroup) null);
        ((HwTextView) viewInflate.findViewById(R$id.hicloud_bottom_dialog_message)).setText(R$string.alert_net_disconnect_new);
        builder.setPositiveButton(R$string.conform, new DialogInterfaceOnClickListenerC3105a());
        AlertDialog alertDialogCreate = builder.create();
        this.f13431b = alertDialogCreate;
        int i10 = this.f13430a;
        alertDialogCreate.setView(viewInflate, i10, 0, i10, 0);
        try {
            this.f13431b.setCanceledOnTouchOutside(false);
            this.f13431b.show();
        } catch (RuntimeException e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY, e10.getMessage());
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY, "onCreate");
        super.onCreate(bundle);
        C12808e.m76822a(this);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        if (C0209d.m1208S0(this)) {
            C9913h.m61574q().m61600x(this);
            C9913h.m61574q().m61589P(true);
        } else if (hiCloudSafeIntent.getBooleanExtra("isFromFileManager", false)) {
            finish();
        } else {
            m18484b();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C11839m.m70688i(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY, "onDestroy");
        AlertDialog alertDialog = this.f13431b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        ForcedUpgradeUtil.getInstance().setForcedUpgradeIsShowing(false);
        C9913h.m61574q().m61577D();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        C11839m.m70688i(NotifyConstants.ActivityName.UPGRADE_EMPTY_ACTIVITY, "onResume");
        ForcedUpgradeUtil.getInstance().setForcedUpgradeIsShowing(true);
        super.onResume();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        if (C0209d.m1208S0(this)) {
            C9913h.m61574q().m61600x(this);
            C9913h.m61574q().m61589P(true);
        } else if (hiCloudSafeIntent.getBooleanExtra("isFromFileManager", false)) {
            finish();
        } else {
            m18484b();
        }
    }
}
