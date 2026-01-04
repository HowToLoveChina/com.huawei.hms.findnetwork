package com.huawei.appgallery.coreservice.internal.service.installhiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.appgallery.coreservice.R$string;
import com.huawei.appgallery.coreservice.ServiceConnectionC4564e;
import com.huawei.appgallery.coreservice.api.ConnectConfig;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.InstallerApi;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import p257eh.C9487i;
import p257eh.C9490l;

/* loaded from: classes4.dex */
public class GuideInstallAppGallery extends Activity {

    /* renamed from: a */
    public AlertDialog f20989a = null;

    /* renamed from: b */
    public boolean f20990b;

    /* renamed from: c */
    public ConnectConfig f20991c;

    /* renamed from: com.huawei.appgallery.coreservice.internal.service.installhiapp.GuideInstallAppGallery$a */
    public class DialogInterfaceOnKeyListenerC4566a implements DialogInterface.OnKeyListener {
        public DialogInterfaceOnKeyListenerC4566a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (4 != i10 || keyEvent.getAction() != 1) {
                return false;
            }
            C9490l.m59352d("GuideInstallAppGallery", "use cancel download market by KEYCODE_BACK!");
            GuideInstallAppGallery.this.setResult(0);
            GuideInstallAppGallery.this.finish();
            return true;
        }
    }

    /* renamed from: com.huawei.appgallery.coreservice.internal.service.installhiapp.GuideInstallAppGallery$b */
    public class DialogInterfaceOnClickListenerC4567b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4567b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C9490l.m59352d("GuideInstallAppGallery", "use cancel download market by NegativeButton!");
            GuideInstallAppGallery.this.setResult(0);
            GuideInstallAppGallery.this.finish();
        }
    }

    /* renamed from: com.huawei.appgallery.coreservice.internal.service.installhiapp.GuideInstallAppGallery$c */
    public class DialogInterfaceOnClickListenerC4568c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4568c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            String strM59345c = C9487i.m59345c(GuideInstallAppGallery.this, "STORE");
            InstallParamSpec installParamSpec = new InstallParamSpec();
            installParamSpec.setServerUrl(strM59345c);
            installParamSpec.setSubsystem("agdsdk");
            installParamSpec.setFailResultPromptType(2);
            installParamSpec.setUpdate(GuideInstallAppGallery.this.f20990b);
            if (GuideInstallAppGallery.this.f20991c != null) {
                installParamSpec.setMarketPkg(GuideInstallAppGallery.this.f20991c.getConnectAppPkg());
            }
            GuideInstallAppGallery guideInstallAppGallery = GuideInstallAppGallery.this;
            InstallerApi.installMarket(guideInstallAppGallery, installParamSpec, guideInstallAppGallery.new C4569d());
        }
    }

    /* renamed from: com.huawei.appgallery.coreservice.internal.service.installhiapp.GuideInstallAppGallery$d */
    public class C4569d implements InstallCallback {
        public C4569d() {
        }

        @Override // com.huawei.appgallery.marketinstallerservice.api.InstallCallback
        public void onFailed(FailResultParam failResultParam) {
            if (failResultParam != null) {
                C9490l.m59352d("GuideInstallAppGallery", "can not download market: result:" + failResultParam.getResult() + ", reason:" + failResultParam.getReason() + ", responseCode:" + failResultParam.getResponseCode() + ", rtnCode:" + failResultParam.getRtnCode());
                GuideInstallAppGallery.this.setResult(0);
            }
            GuideInstallAppGallery.this.finish();
        }

        @Override // com.huawei.appgallery.marketinstallerservice.api.InstallCallback
        public void onSuccess(MarketInfo marketInfo) {
            C9490l.m59352d("GuideInstallAppGallery", "download market succeed!");
            GuideInstallAppGallery.this.setResult(-1);
            GuideInstallAppGallery.this.finish();
        }
    }

    /* renamed from: a */
    public static PendingIntent m28058a(Context context) {
        if (context == null) {
            return null;
        }
        String strM28037h = ServiceConnectionC4564e.m28037h(context);
        Intent intent = new Intent(context, (Class<?>) GuideInstallAppGallery.class);
        intent.putExtra("is_app_market_exist", !TextUtils.isEmpty(strM28037h));
        return PendingIntent.getActivity(context, 90001, intent, Build.VERSION.SDK_INT >= 30 ? 1140850688 : 1073741824);
    }

    /* renamed from: b */
    public static PendingIntent m28059b(Context context, ConnectConfig connectConfig, String str) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) GuideInstallAppGallery.class);
        intent.putExtra("is_app_market_exist", !TextUtils.isEmpty(str));
        intent.putExtra("vendor_app_connect_config", connectConfig);
        return PendingIntent.getActivity(context, 90001, intent, Build.VERSION.SDK_INT >= 30 ? 1140850688 : 1073741824);
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
            overridePendingTransition(0, 0);
        } catch (Exception e10) {
            C9490l.m59351c("GuideInstallAppGallery", "activity finish exception:" + e10.getMessage());
        }
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return new SafeIntent(super.getIntent());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        requestWindowFeature(1);
        super.onCreate(bundle);
        C9490l.m59352d("GuideInstallAppGallery", "onCreate");
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20990b = safeIntent.getBooleanExtra("is_app_market_exist", false);
        this.f20991c = (ConnectConfig) safeIntent.getSerializableExtra("vendor_app_connect_config");
        boolean z10 = this.f20990b;
        int i10 = z10 ? R$string.coreservicesdk_guide_update_appmarket : R$string.coreservicesdk_guide_download_appmarket;
        int i11 = z10 ? R$string.agdsdk_update : R$string.agdsdk_download;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) null);
        String string = getResources().getString(R$string.coreservicesdk_appmarket_name);
        ConnectConfig connectConfig = this.f20991c;
        if (connectConfig != null) {
            string = connectConfig.getInstallAppName();
        }
        builder.setMessage(getResources().getString(i10, string));
        builder.setPositiveButton(getResources().getText(i11), new DialogInterfaceOnClickListenerC4568c());
        builder.setNegativeButton(getResources().getText(R$string.agdsdk_cancel), new DialogInterfaceOnClickListenerC4567b());
        builder.setOnKeyListener(new DialogInterfaceOnKeyListenerC4566a());
        AlertDialog alertDialogCreate = builder.create();
        this.f20989a = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        if (isDestroyed() || isFinishing()) {
            return;
        }
        this.f20989a.show();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f20989a;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f20989a.dismiss();
    }
}
