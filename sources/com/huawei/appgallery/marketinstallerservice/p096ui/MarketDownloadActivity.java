package com.huawei.appgallery.marketinstallerservice.p096ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.appgallery.marketinstallerservice.R$id;
import com.huawei.appgallery.marketinstallerservice.R$layout;
import com.huawei.appgallery.marketinstallerservice.R$string;
import com.huawei.appgallery.marketinstallerservice.api.Constant;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.p096ui.C4579a;
import com.huawei.secure.android.common.activity.SafeActivity;
import p810yh.C13985c;
import p810yh.InterfaceC13983a;
import p810yh.InterfaceC13984b;
import sh.C12798a;
import th.C13012a;

/* loaded from: classes4.dex */
public class MarketDownloadActivity extends SafeActivity implements InterfaceC13984b, C4579a.a {

    /* renamed from: b */
    public InterfaceC13983a f21026b = new C13985c(this, this);

    /* renamed from: c */
    public TextView f21027c = null;

    /* renamed from: d */
    public TextView f21028d = null;

    /* renamed from: e */
    public ProgressBar f21029e = null;

    /* renamed from: f */
    public View f21030f = null;

    /* renamed from: g */
    public AlertDialog f21031g = null;

    /* renamed from: h */
    public AlertDialog f21032h = null;

    /* renamed from: i */
    public AlertDialog f21033i = null;

    /* renamed from: j */
    public AlertDialog f21034j = null;

    /* renamed from: k */
    public int f21035k = 0;

    /* renamed from: l */
    public boolean f21036l = false;

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity$a */
    public class ViewOnClickListenerC4574a implements View.OnClickListener {
        public ViewOnClickListenerC4574a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarketDownloadActivity.this.m28085i();
        }
    }

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity$b */
    public class DialogInterfaceOnClickListenerC4575b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4575b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            MarketDownloadActivity.this.m28086j();
        }
    }

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity$c */
    public class DialogInterfaceOnDismissListenerC4576c implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC4576c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (dialogInterface == null || MarketDownloadActivity.this.isFinishing()) {
                return;
            }
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity$d */
    public class DialogInterfaceOnClickListenerC4577d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4577d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
            intent.putExtra("use_emui_ui", true);
            intent.setPackage("com.android.settings");
            try {
                MarketDownloadActivity.this.startActivity(intent);
            } catch (ActivityNotFoundException e10) {
                C13012a.m78316b("MarketDownloadActivity", "can not go Settings", e10);
            }
        }
    }

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.MarketDownloadActivity$e */
    public class DialogInterfaceOnDismissListenerC4578e implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC4578e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (MarketDownloadActivity.this.f21026b != null) {
                MarketDownloadActivity.this.f21026b.mo83997b(-1, 0, 0);
            }
            MarketDownloadActivity.this.finish();
        }
    }

    @Override // com.huawei.appgallery.marketinstallerservice.p096ui.C4579a.a
    /* renamed from: a */
    public void mo28076a() {
        this.f21026b.mo83995a();
    }

    @Override // p810yh.InterfaceC13984b
    /* renamed from: b */
    public void mo28080b(MarketInfo marketInfo) {
        TextView textView = this.f21027c;
        if (textView != null) {
            boolean z10 = this.f21036l;
            Resources resources = getResources();
            textView.setText(z10 ? resources.getString(R$string.market_install_updating_market) : resources.getString(R$string.market_install_app_dl_installing, ""));
        }
    }

    @Override // p810yh.InterfaceC13984b
    /* renamed from: c */
    public void mo28081c() {
        C13012a.m78318d("MarketDownloadActivity", "show net setting dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R$string.market_install_no_available_network_prompt);
        builder.setPositiveButton(R$string.market_install_net_setting, new DialogInterfaceOnClickListenerC4577d());
        builder.setNegativeButton(R$string.market_install_cancel, (DialogInterface.OnClickListener) null);
        builder.setOnDismissListener(new DialogInterfaceOnDismissListenerC4578e());
        AlertDialog alertDialogCreate = builder.create();
        this.f21032h = alertDialogCreate;
        alertDialogCreate.setCancelable(true);
        m28083e(this.f21032h);
    }

    @Override // p810yh.InterfaceC13984b
    /* renamed from: d */
    public void mo28082d() {
        C13012a.m78318d("MarketDownloadActivity", "show market download dialog.");
        this.f21031g = new AlertDialog.Builder(this).create();
        View viewInflate = LayoutInflater.from(this).inflate(getResources().getLayout(R$layout.market_install_app_dl_progress_dialog), (ViewGroup) null);
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R$id.third_app_dl_progressbar);
        this.f21029e = progressBar;
        progressBar.setMax(100);
        this.f21027c = (TextView) viewInflate.findViewById(R$id.third_app_warn_text);
        this.f21028d = (TextView) viewInflate.findViewById(R$id.third_app_dl_progress_text);
        View viewFindViewById = viewInflate.findViewById(R$id.cancel_bg);
        this.f21030f = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC4574a());
        this.f21031g.setView(viewInflate);
        this.f21031g.setCancelable(false);
        this.f21031g.setCanceledOnTouchOutside(false);
        this.f21028d.setText(C12798a.m76786a(0));
        m28083e(this.f21031g);
    }

    /* renamed from: e */
    public final void m28083e(Dialog dialog) {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        dialog.show();
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void finish() {
        if (isFinishing()) {
            return;
        }
        super.finish();
    }

    /* renamed from: h */
    public final void m28084h(int i10) {
        AlertDialog alertDialog = this.f21031g;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f21031g.dismiss();
        }
        AlertDialog alertDialog2 = this.f21032h;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.f21032h.dismiss();
        }
        int i11 = this.f21035k;
        if (i11 == 0) {
            Toast.makeText(this, getResources().getString(R$string.market_install_install_failed), 0).show();
        } else if (i11 == 2) {
            AlertDialog alertDialogM28087a = C4579a.m28087a(this, i10, this, this.f21026b.mo84000d().getAppName());
            this.f21033i = alertDialogM28087a;
            m28083e(alertDialogM28087a);
            return;
        }
        finish();
    }

    /* renamed from: i */
    public void m28085i() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getText(R$string.market_install_app_download_cancels));
        builder.setPositiveButton(getResources().getText(R$string.market_install_confirm), new DialogInterfaceOnClickListenerC4575b());
        builder.setNegativeButton(R$string.market_install_cancel, (DialogInterface.OnClickListener) null);
        builder.setOnDismissListener(new DialogInterfaceOnDismissListenerC4576c());
        AlertDialog alertDialogCreate = builder.create();
        this.f21034j = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: j */
    public final void m28086j() {
        C13012a.m78318d("MarketDownloadActivity", "market cancelDownload");
        InterfaceC13983a interfaceC13983a = this.f21026b;
        if (interfaceC13983a != null) {
            interfaceC13983a.mo83998c();
            this.f21026b.mo83997b(-5, 0, 0);
        }
        this.f21031g.dismiss();
        finish();
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (1000 == i10 && this.f21026b != null) {
            int intExtra = Constant.INSTALL_FAILED_UNKNOW;
            if (intent != null) {
                intExtra = intent.getIntExtra("android.intent.extra.INSTALL_RESULT", Constant.INSTALL_FAILED_UNKNOW);
            }
            if (i11 == -1) {
                C13012a.m78318d("MarketDownloadActivity", "market install succeed");
                this.f21026b.mo83997b(0, 0, 0);
            } else {
                if (i11 != 0) {
                    C13012a.m78318d("MarketDownloadActivity", "market install failed");
                    m28084h(-2);
                    this.f21026b.mo83996a(-2, 0, 0, intExtra);
                    return;
                }
                C13012a.m78318d("MarketDownloadActivity", "market install userCancel");
                this.f21026b.mo83997b(-5, 0, 0);
            }
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            r0 = 1
            r8.requestWindowFeature(r0)
            super.onCreate(r9)
            com.huawei.secure.android.common.intent.SafeIntent r9 = new com.huawei.secure.android.common.intent.SafeIntent
            android.content.Intent r0 = r8.getIntent()
            r9.<init>(r0)
            java.lang.String r0 = "callback_key"
            java.lang.String r0 = r9.getStringExtra(r0)
            java.lang.String r1 = "market_info_key"
            java.util.ArrayList r1 = r9.getParcelableArrayListExtra(r1)
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L33
            int r4 = r1.size()
            if (r4 == 0) goto L33
            java.lang.Object r1 = r1.get(r2)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            boolean r4 = r1 instanceof com.huawei.appgallery.marketinstallerservice.api.MarketInfo
            if (r4 == 0) goto L33
            com.huawei.appgallery.marketinstallerservice.api.MarketInfo r1 = (com.huawei.appgallery.marketinstallerservice.api.MarketInfo) r1
            goto L34
        L33:
            r1 = r3
        L34:
            if (r1 != 0) goto L4c
            java.lang.String r3 = "service_url_key"
            java.lang.String r3 = r9.getStringExtra(r3)
            java.lang.String r4 = "sub_system_key"
            java.lang.String r4 = r9.getStringExtra(r4)
            java.lang.String r5 = "market_pkg_key"
            java.lang.String r5 = r9.getStringExtra(r5)
            r7 = r5
            r5 = r3
            r3 = r7
            goto L4e
        L4c:
            r4 = r3
            r5 = r4
        L4e:
            java.lang.String r6 = "fail_result_type_key"
            int r6 = r9.getIntExtra(r6, r2)
            r8.f21035k = r6
            com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec r6 = new com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec
            r6.<init>()
            r6.setMarketInfo(r1)
            r6.setServerUrl(r5)
            r6.setSubsystem(r4)
            r6.setMarketPkg(r3)
            int r1 = r8.f21035k
            r6.setFailResultPromptType(r1)
            java.lang.String r1 = "is_update_key"
            boolean r9 = r9.getBooleanExtra(r1, r2)
            r8.f21036l = r9
            yh.a r8 = r8.f21026b
            if (r8 == 0) goto L7b
            r8.mo83999c(r6, r0)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.marketinstallerservice.p096ui.MarketDownloadActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f21031g;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f21031g.dismiss();
        }
        AlertDialog alertDialog2 = this.f21032h;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.f21032h.dismiss();
        }
        AlertDialog alertDialog3 = this.f21033i;
        if (alertDialog3 == null || !alertDialog3.isShowing()) {
            return;
        }
        this.f21033i.dismiss();
    }

    @Override // com.huawei.secure.android.common.activity.SafeActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.f21026b != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            int i10 = extras.getInt("android.content.pm.extra.STATUS");
            if (i10 != 0) {
                this.f21026b.mo83996a(-2, 0, 0, i10);
                m28084h(-2);
                return;
            }
            this.f21026b.mo83997b(0, 0, 0);
        }
        finish();
    }

    @Override // p810yh.InterfaceC13984b
    /* renamed from: a */
    public void mo28077a(int i10) {
        m28084h(i10);
    }

    @Override // com.huawei.appgallery.marketinstallerservice.p096ui.C4579a.a
    /* renamed from: b */
    public void mo28079b() {
        this.f21026b.mo84001e();
        finish();
    }

    @Override // p810yh.InterfaceC13984b
    /* renamed from: a */
    public void mo28078a(int i10, int i11) {
        View view;
        TextView textView;
        if (i10 == 1 && this.f21029e != null && (textView = this.f21028d) != null) {
            textView.setText(C12798a.m76786a(i11));
            this.f21029e.setProgress(i11);
            return;
        }
        if (i10 != 3 || (view = this.f21030f) == null) {
            return;
        }
        view.setClickable(false);
        TextView textView2 = this.f21027c;
        if (textView2 != null && this.f21028d != null) {
            textView2.setText(getResources().getString(R$string.market_install_installing_market));
            this.f21028d.setVisibility(8);
        }
        AlertDialog alertDialog = this.f21034j;
        if (alertDialog == null || !alertDialog.isShowing() || isFinishing()) {
            return;
        }
        this.f21034j.setCancelable(false);
        this.f21034j.dismiss();
    }
}
