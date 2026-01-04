package com.huawei.updatesdk.service.otaupdate;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p178a.p183d.p185j.C8792a;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p177a.p186b.p188b.AbstractC8794a;
import com.huawei.updatesdk.p177a.p186b.p188b.C8795b;
import com.huawei.updatesdk.p191b.p197d.AsyncTaskC8818c;
import com.huawei.updatesdk.p191b.p197d.C8816a;
import com.huawei.updatesdk.p191b.p197d.C8817b;
import com.huawei.updatesdk.p191b.p197d.C8821f;
import com.huawei.updatesdk.p191b.p198e.C8826e;
import com.huawei.updatesdk.p191b.p199f.C8829c;
import com.huawei.updatesdk.p191b.p199f.InterfaceC8828b;
import com.huawei.updatesdk.p191b.p200g.C8832c;
import com.huawei.updatesdk.p191b.p201h.C8833a;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import com.huawei.updatesdk.p191b.p201h.C8835c;
import com.huawei.updatesdk.p191b.p201h.C8836d;
import com.huawei.updatesdk.p191b.p202i.C8837a;
import com.huawei.updatesdk.p191b.p202i.InterfaceC8838b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.C8844c;
import com.huawei.updatesdk.service.otaupdate.C8868c;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* loaded from: classes9.dex */
public class AppUpdateActivity extends Activity implements InterfaceC8867b, InterfaceC8828b {

    /* renamed from: a */
    private String f45200a;

    /* renamed from: b */
    private AlertDialog f45201b;

    /* renamed from: c */
    private C8837a f45202c;

    /* renamed from: d */
    private C8837a f45203d;

    /* renamed from: e */
    private ProgressBar f45204e;

    /* renamed from: f */
    private TextView f45205f;

    /* renamed from: l */
    private AsyncTaskC8818c f45211l;

    /* renamed from: p */
    private C8863q f45215p;

    /* renamed from: g */
    private boolean f45206g = false;

    /* renamed from: h */
    private boolean f45207h = false;

    /* renamed from: i */
    private ApkUpgradeInfo f45208i = null;

    /* renamed from: j */
    private boolean f45209j = false;

    /* renamed from: k */
    private boolean f45210k = false;

    /* renamed from: m */
    private int f45212m = -99;

    /* renamed from: n */
    private int f45213n = -99;

    /* renamed from: o */
    private int f45214o = -99;

    /* renamed from: q */
    private boolean f45216q = false;

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$a */
    public class C8847a implements C8837a.e {
        public C8847a() {
        }

        @Override // com.huawei.updatesdk.p191b.p202i.C8837a.e
        /* renamed from: a */
        public void mo56361a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$b */
    public class DialogInterfaceOnKeyListenerC8848b implements DialogInterface.OnKeyListener {
        public DialogInterfaceOnKeyListenerC8848b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            C8774a.m56009b("AppUpdateActivity", "onKeyBack");
            if (i10 != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            AppUpdateActivity.this.f45212m = 4;
            AppUpdateActivity.this.finish();
            return true;
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$c */
    public class C8849c implements InterfaceC8838b {

        /* renamed from: a */
        final /* synthetic */ C8844c f45219a;

        /* renamed from: b */
        final /* synthetic */ C8837a f45220b;

        public C8849c(C8844c c8844c, C8837a c8837a) {
            this.f45219a = c8844c;
            this.f45220b = c8837a;
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: a */
        public void mo56362a() {
            AppUpdateActivity.this.m56421d(this.f45219a);
            this.f45220b.m56350a();
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: b */
        public void mo56363b() {
            this.f45220b.m56350a();
            if (AppUpdateActivity.this.f45209j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m56417c(appUpdateActivity.f45208i);
            } else {
                AppUpdateActivity.this.f45212m = 4;
                AppUpdateActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$d */
    public class C8850d implements C8837a.e {
        public C8850d() {
        }

        @Override // com.huawei.updatesdk.p191b.p202i.C8837a.e
        /* renamed from: a */
        public void mo56361a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$e */
    public class RunnableC8851e implements Runnable {
        public RunnableC8851e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppUpdateActivity.this.m56406b();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$f */
    public class RunnableC8852f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f45224a;

        public RunnableC8852f(boolean z10) {
            this.f45224a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10 = this.f45224a;
            AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
            if (z10) {
                appUpdateActivity.m56408b(appUpdateActivity.f45208i);
            } else {
                appUpdateActivity.m56417c(appUpdateActivity.f45208i);
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$g */
    public class RunnableC8853g implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C8795b f45226a;

        public RunnableC8853g(C8795b c8795b) {
            this.f45226a = c8795b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundleM56142b = this.f45226a.m56142b();
            if (bundleM56142b == null) {
                return;
            }
            int i10 = bundleM56142b.getInt("INSTALL_STATE");
            C8869d.m56446a().m56448a(AppUpdateActivity.this.m56391a(i10, bundleM56142b.getInt("INSTALL_TYPE"), -1));
            AppUpdateActivity.this.m56415c(i10);
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$h */
    public class C8854h implements InterfaceC8838b {
        public C8854h() {
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: a */
        public void mo56362a() {
            AppUpdateActivity.this.f45204e.setProgress(0);
            AppUpdateActivity.this.f45204e.setMax(0);
            AppUpdateActivity.this.f45205f.setText("");
            AppUpdateActivity.this.m56393a();
            if (AppUpdateActivity.this.f45211l != null) {
                AppUpdateActivity.this.f45211l.m56257a();
            }
            AppUpdateActivity.this.f45202c.m56350a();
            if (AppUpdateActivity.this.f45209j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m56417c(appUpdateActivity.f45208i);
            } else {
                AppUpdateActivity.this.f45212m = 4;
                AppUpdateActivity.this.finish();
            }
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: b */
        public void mo56363b() {
            AppUpdateActivity.this.f45202c.m56350a();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$i */
    public class C8855i implements C8837a.e {
        public C8855i() {
        }

        @Override // com.huawei.updatesdk.p191b.p202i.C8837a.e
        /* renamed from: a */
        public void mo56361a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$j */
    public class ViewOnClickListenerC8856j implements View.OnClickListener {
        public ViewOnClickListenerC8856j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppUpdateActivity.this.m56423e();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$k */
    public class C8857k implements InterfaceC8838b {

        /* renamed from: a */
        final /* synthetic */ C8844c f45231a;

        /* renamed from: b */
        final /* synthetic */ C8837a f45232b;

        public C8857k(C8844c c8844c, C8837a c8837a) {
            this.f45231a = c8844c;
            this.f45232b = c8837a;
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: a */
        public void mo56362a() {
            if (!C8792a.m56130d(AppUpdateActivity.this)) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                Toast.makeText(appUpdateActivity, C8835c.m56335c(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
                AppUpdateActivity.this.finish();
            } else if (C8792a.m56129c(AppUpdateActivity.this) != 1) {
                AppUpdateActivity.this.m56418c(this.f45231a);
            } else {
                AppUpdateActivity.this.m56421d(this.f45231a);
                this.f45232b.m56350a();
            }
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: b */
        public void mo56363b() {
            this.f45232b.m56350a();
            if (AppUpdateActivity.this.f45209j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m56417c(appUpdateActivity.f45208i);
            } else {
                AppUpdateActivity.this.f45212m = 4;
                AppUpdateActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$l */
    public class C8858l implements C8837a.e {
        public C8858l() {
        }

        @Override // com.huawei.updatesdk.p191b.p202i.C8837a.e
        /* renamed from: a */
        public void mo56361a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$m */
    public class C8859m implements InterfaceC8838b {
        public C8859m() {
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: a */
        public void mo56362a() {
            C8774a.m56009b("AppUpdateActivity", "performConfirm");
            AppUpdateActivity.this.f45214o = 101;
            if (C8792a.m56130d(AppUpdateActivity.this)) {
                AppUpdateActivity.this.m56428g();
                return;
            }
            AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
            Toast.makeText(appUpdateActivity, C8835c.m56335c(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
            AppUpdateActivity.this.f45212m = 2;
            AppUpdateActivity.this.finish();
        }

        @Override // com.huawei.updatesdk.p191b.p202i.InterfaceC8838b
        /* renamed from: b */
        public void mo56363b() {
            C8774a.m56009b("AppUpdateActivity", "performCancel");
            AppUpdateActivity.this.f45203d.m56350a();
            AppUpdateActivity.this.f45212m = 4;
            AppUpdateActivity.this.f45214o = 100;
            if (AppUpdateActivity.this.f45209j) {
                AppUpdateActivity.this.finish();
                return;
            }
            C8868c c8868c = new C8868c();
            AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
            c8868c.m56442a(appUpdateActivity, appUpdateActivity.f45200a, AppUpdateActivity.this.new C8860n(), AppUpdateActivity.this.f45216q);
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$n */
    public class C8860n implements C8868c.a {
        public C8860n() {
        }

        @Override // com.huawei.updatesdk.service.otaupdate.C8868c.a
        /* renamed from: a */
        public void mo56438a(Boolean bool) {
            if (bool.booleanValue()) {
                try {
                    Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateRemindAction");
                    intent.setPackage(AppUpdateActivity.this.f45200a);
                    AppUpdateActivity.this.startActivity(intent);
                } catch (ActivityNotFoundException e10) {
                    C8777a.m56028b("AppUpdateActivity", "goHiappUpgrade error: " + e10.getMessage());
                }
            }
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$o */
    public static class DialogInterfaceOnDismissListenerC8861o implements DialogInterface.OnDismissListener {
        private DialogInterfaceOnDismissListenerC8861o() {
        }

        public /* synthetic */ DialogInterfaceOnDismissListenerC8861o(RunnableC8851e runnableC8851e) {
            this();
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.DIALOG_STATUS, 10001);
            C8869d.m56446a().m56450b(intent);
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$p */
    public static class DialogInterfaceOnShowListenerC8862p implements DialogInterface.OnShowListener {
        private DialogInterfaceOnShowListenerC8862p() {
        }

        public /* synthetic */ DialogInterfaceOnShowListenerC8862p(RunnableC8851e runnableC8851e) {
            this();
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.DIALOG_STATUS, 10002);
            C8869d.m56446a().m56450b(intent);
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$q */
    public class C8863q extends AbstractC8794a {
        private C8863q() {
        }

        @Override // com.huawei.updatesdk.p177a.p186b.p188b.AbstractC8794a
        /* renamed from: a */
        public void mo56135a(Context context, C8795b c8795b) {
            if (c8795b.m56144d()) {
                if (AppUpdateActivity.this.f45202c != null) {
                    AppUpdateActivity.this.f45202c.m56350a();
                }
                AppUpdateActivity.this.m56393a();
                String strM56138a = c8795b.m56138a();
                String dataString = c8795b.m56143c().getDataString();
                if (dataString == null || dataString.length() < 9) {
                    return;
                }
                String strSubstring = dataString.substring(8);
                if ("android.intent.action.PACKAGE_ADDED".equals(strM56138a) && TextUtils.equals(AppUpdateActivity.this.f45200a, strSubstring)) {
                    C8869d.m56446a().m56448a(AppUpdateActivity.this.m56391a(6, 0, -1));
                    C8834b.m56315a();
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    appUpdateActivity.m56402a(appUpdateActivity.f45208i.getPackage_(), AppUpdateActivity.this.f45208i.getDetailId_());
                    if (AppUpdateActivity.this.f45209j) {
                        AppUpdateActivity appUpdateActivity2 = AppUpdateActivity.this;
                        appUpdateActivity2.m56417c(appUpdateActivity2.f45208i);
                    }
                }
            }
        }

        public /* synthetic */ C8863q(AppUpdateActivity appUpdateActivity, RunnableC8851e runnableC8851e) {
            this();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$r */
    public static class DialogInterfaceOnKeyListenerC8864r implements DialogInterface.OnKeyListener {

        /* renamed from: a */
        private final WeakReference<AppUpdateActivity> f45238a;

        /* renamed from: b */
        private final C8837a f45239b;

        public DialogInterfaceOnKeyListenerC8864r(AppUpdateActivity appUpdateActivity, C8837a c8837a) {
            this.f45238a = new WeakReference<>(appUpdateActivity);
            this.f45239b = c8837a;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            AppUpdateActivity appUpdateActivity = this.f45238a.get();
            if (appUpdateActivity == null || i10 != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            C8774a.m56009b("AppUpdateActivity", "press back");
            if (appUpdateActivity.f45209j) {
                this.f45239b.m56350a();
                appUpdateActivity.m56417c(appUpdateActivity.f45208i);
                return true;
            }
            appUpdateActivity.f45212m = 4;
            appUpdateActivity.finish();
            return true;
        }
    }

    /* renamed from: d */
    private void m56420d() {
        C8837a c8837a = this.f45203d;
        if (c8837a != null) {
            c8837a.m56352a(new DialogInterfaceOnDismissListenerC8861o(null));
            this.f45203d.m56354a(new DialogInterfaceOnShowListenerC8862p(null));
        }
    }

    /* renamed from: e */
    public void m56423e() {
        C8837a c8837aM56344a = C8837a.m56344a(this, null, getString(C8835c.m56335c(this, "upsdk_third_app_dl_cancel_download_prompt_ex")));
        this.f45202c = c8837aM56344a;
        c8837aM56344a.m56357a(new C8854h());
        String string = getString(C8835c.m56335c(this, "upsdk_third_app_dl_sure_cancel_download"));
        this.f45202c.m56356a(new C8855i());
        this.f45202c.m56351a(-1, string);
    }

    /* renamed from: f */
    private void m56425f() {
        AbstractC8866a.m56439a(this, this.f45215p);
        C8829c.m56291a().mo56289b(this);
        AsyncTaskC8818c asyncTaskC8818c = this.f45211l;
        if (asyncTaskC8818c != null) {
            asyncTaskC8818c.m56258b();
        }
        C8821f.m56267a((InterfaceC8867b) null);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f45206g) {
            overridePendingTransition(0, 0);
        }
        Intent intent = new Intent();
        intent.putExtra("status", this.f45212m);
        intent.putExtra(UpdateKey.FAIL_CODE, this.f45213n);
        intent.putExtra(UpdateKey.MUST_UPDATE, this.f45206g);
        intent.putExtra(UpdateKey.BUTTON_STATUS, this.f45214o);
        C8869d.m56446a().m56450b(intent);
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C8774a.m56009b("AppUpdateActivity", "get from market requestCode: " + i10 + ", resultCode: " + i11);
        if (i10 == 1002) {
            if (intent != null) {
                this.f45212m = i11;
                m56394a(intent);
            }
            this.f45214o = i11 == 4 ? 100 : 101;
            if (this.f45207h) {
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        requestWindowFeature(1);
        C8789c.m56105f().m56120a(getWindow());
        super.onCreate(bundle);
        Bundle bundleM56142b = C8795b.m56136a(getIntent()).m56142b();
        C8793a.m56131a(this);
        if (bundleM56142b != null) {
            try {
                serializable = bundleM56142b.getSerializable("app_update_parm");
                this.f45216q = bundleM56142b.getBoolean("is_apptouch", false);
                this.f45210k = bundleM56142b.getBoolean("app_must_btn", false);
            } catch (Throwable th2) {
                C8774a.m56008a("AppUpdateActivity", "Type Conversion Error: " + th2.getMessage());
                super.finish();
                return;
            }
        } else {
            serializable = null;
        }
        String strMo56278b = C8826e.m56286a(this.f45216q).mo56278b();
        this.f45200a = strMo56278b;
        if (TextUtils.isEmpty(strMo56278b)) {
            C8774a.m56008a("AppUpdateActivity", "finish activity and appStorePkgName is: " + this.f45200a);
            super.finish();
            return;
        }
        if (!(serializable instanceof ApkUpgradeInfo)) {
            this.f45212m = 3;
            finish();
            return;
        }
        ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) serializable;
        this.f45208i = apkUpgradeInfo;
        if (apkUpgradeInfo.getIsCompulsoryUpdate_() == 1) {
            this.f45209j = true;
        }
        if (1 == this.f45208i.getDevType_() && C8834b.m56329i(this, this.f45200a)) {
            m56408b(this.f45208i);
        } else if (2 == this.f45208i.getDevType_() && C8834b.m56328h(this, this.f45200a)) {
            C8832c.f45173b.execute(new RunnableC8851e());
        } else {
            m56417c(this.f45208i);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C8837a c8837a = this.f45202c;
        if (c8837a != null) {
            c8837a.m56350a();
            this.f45202c = null;
        }
        C8837a c8837a2 = this.f45203d;
        if (c8837a2 != null) {
            c8837a2.m56350a();
            this.f45203d = null;
        }
        m56393a();
        m56425f();
        super.onDestroy();
        finishActivity(1002);
    }

    /* renamed from: a */
    private long m56390a(ApkUpgradeInfo apkUpgradeInfo) {
        long longSize_ = apkUpgradeInfo.getLongSize_();
        if (apkUpgradeInfo.getPackingType_() == 1 && apkUpgradeInfo.getBundleSize_() > 0) {
            return apkUpgradeInfo.getBundleSize_();
        }
        if (apkUpgradeInfo.getPackingType_() == 3 && apkUpgradeInfo.getObbSize_() > 0) {
            longSize_ += apkUpgradeInfo.getObbSize_();
        }
        if (apkUpgradeInfo.getDiffSize_() <= 0) {
            return longSize_;
        }
        long diffSize_ = apkUpgradeInfo.getDiffSize_();
        return (apkUpgradeInfo.getPackingType_() != 3 || apkUpgradeInfo.getObbSize_() <= 0) ? diffSize_ : diffSize_ + apkUpgradeInfo.getObbSize_();
    }

    /* renamed from: c */
    private void m56414c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        C8863q c8863q = new C8863q(this, null);
        this.f45215p = c8863q;
        AbstractC8866a.m56440a(this, intentFilter, c8863q);
    }

    /* renamed from: d */
    public void m56421d(C8844c c8844c) {
        m56414c();
        m56412b(c8844c.m56368a());
        C8817b c8817b = new C8817b(c8844c.m56369b(), c8844c.m56370c(), c8844c.m56372e());
        c8817b.m56241a(c8844c.m56371d());
        AsyncTaskC8818c asyncTaskC8818c = new AsyncTaskC8818c(c8817b);
        this.f45211l = asyncTaskC8818c;
        asyncTaskC8818c.executeOnExecutor(C8832c.f45172a, new Void[0]);
    }

    /* renamed from: g */
    public void m56428g() {
        if (C8834b.m56327g(this, this.f45200a)) {
            m56402a(this.f45208i.getPackage_(), this.f45208i.getDetailId_());
            return;
        }
        C8821f.m56267a(this);
        C8821f.m56268a(this.f45216q);
        this.f45203d.m56350a();
    }

    /* renamed from: a */
    public Intent m56391a(int i10, int i11, int i12) {
        Intent intent = new Intent();
        intent.putExtra(UpdateKey.MARKET_DLD_STATUS, i12);
        intent.putExtra(UpdateKey.MARKET_INSTALL_STATE, i10);
        intent.putExtra(UpdateKey.MARKET_INSTALL_TYPE, i11);
        return intent;
    }

    /* renamed from: b */
    public void m56406b() {
        runOnUiThread(new RunnableC8852f(C8834b.m56317a(this.f45200a)));
    }

    /* renamed from: c */
    public void m56415c(int i10) {
        if (i10 == 5 || i10 == 4) {
            Toast.makeText(this, getString(C8835c.m56335c(this, "upsdk_third_app_dl_install_failed")), 0).show();
            C8834b.m56315a();
            finish();
        }
        if (i10 == 7) {
            C8834b.m56315a();
            if (this.f45206g) {
                m56417c(this.f45208i);
            } else {
                finish();
            }
        }
    }

    /* renamed from: c */
    private void m56416c(C8795b c8795b) {
        new Handler(Looper.getMainLooper()).post(new RunnableC8853g(c8795b));
    }

    @Override // com.huawei.updatesdk.service.otaupdate.InterfaceC8867b
    /* renamed from: b */
    public void mo56437b(int i10) {
        Toast.makeText(this, getString(C8835c.m56335c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        C8869d.m56446a().m56447a(i10);
        finish();
    }

    /* renamed from: a */
    public void m56393a() {
        try {
            AlertDialog alertDialog = this.f45201b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.f45201b.dismiss();
            this.f45201b = null;
        } catch (IllegalArgumentException unused) {
            C8777a.m56026a("AppUpdateActivity", "progressDialog dismiss IllegalArgumentException");
        }
    }

    /* renamed from: b */
    private void m56407b(C8795b c8795b) {
        if (this.f45204e == null) {
            return;
        }
        this.f45204e.setProgress(C8836d.m56336a(c8795b.m56141b("download_apk_already", 0), c8795b.m56141b("download_apk_size", 0)));
        this.f45205f.setText(C8836d.m56337a((int) ((this.f45204e.getProgress() / this.f45204e.getMax()) * 100.0f)));
    }

    /* renamed from: c */
    public void m56417c(ApkUpgradeInfo apkUpgradeInfo) {
        C8774a.m56009b("AppUpdateActivity", "showOtaDialog");
        if (apkUpgradeInfo == null) {
            finish();
            return;
        }
        String string = getString(C8835c.m56335c(this, "upsdk_ota_title"));
        String string2 = getString(C8835c.m56335c(this, "upsdk_ota_notify_updatebtn"));
        String string3 = getString(C8835c.m56335c(this, "upsdk_ota_cancel"));
        if (!m56403a(string)) {
            C8774a.m56008a("AppUpdateActivity", "UpdateSDK show update dialog error and resource is proguard, please add ignore proguard rules!");
            finish();
            return;
        }
        if (1 == apkUpgradeInfo.getIsCompulsoryUpdate_()) {
            string3 = getString(C8835c.m56335c(this, "upsdk_ota_force_cancel_new"));
            if (this.f45210k) {
                this.f45203d.m56360c();
            }
            this.f45206g = true;
        }
        this.f45203d.m56357a(new C8859m());
        m56420d();
        this.f45203d.m56356a(new C8847a());
        if (this.f45206g) {
            this.f45203d.m56358a(false);
        } else {
            this.f45203d.m56353a(new DialogInterfaceOnKeyListenerC8848b());
        }
        this.f45203d.m56351a(-1, string2);
        this.f45203d.m56351a(-2, string3);
    }

    /* renamed from: b */
    public void m56408b(ApkUpgradeInfo apkUpgradeInfo) {
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage(this.f45200a);
        intent.putExtra("APP_PACKAGENAME", apkUpgradeInfo.getPackage_());
        intent.putExtra("devType", apkUpgradeInfo.getDevType_());
        intent.putExtra("version", apkUpgradeInfo.getVersion_());
        intent.putExtra("longSize", apkUpgradeInfo.getLongSize_());
        intent.putExtra("newFeature", apkUpgradeInfo.getNewFeatures_());
        intent.putExtra("IsCompulsoryUpdate", apkUpgradeInfo.getIsCompulsoryUpdate_());
        intent.putExtra("APP_MUST_UPDATE_BTN", this.f45210k);
        intent.putExtra("VersionCode", apkUpgradeInfo.getVersionCode_());
        intent.putExtra("detailId", apkUpgradeInfo.getDetailId_());
        intent.putExtra("name", apkUpgradeInfo.getName_());
        try {
            this.f45207h = false;
            startActivityForResult(intent, 1002);
        } catch (ActivityNotFoundException unused) {
            C8774a.m56008a("AppUpdateActivity", "goHiappUpgrade error: ActivityNotFoundException");
            this.f45207h = true;
            Intent intent2 = new Intent();
            intent2.putExtra("status", 8);
            C8869d.m56446a().m56450b(intent2);
            m56417c(apkUpgradeInfo);
        }
    }

    /* renamed from: c */
    public void m56418c(C8844c c8844c) {
        C8837a c8837aM56344a = C8837a.m56344a(this, null, getString(C8835c.m56335c(this, "upsdk_mobile_dld_warn"), C8836d.m56338a(this, c8844c.m56370c())));
        c8837aM56344a.m56357a(new C8849c(c8844c, c8837aM56344a));
        String string = getString(C8835c.m56335c(this, "upsdk_app_download_info_new"));
        c8837aM56344a.m56356a(new C8850d());
        c8837aM56344a.m56351a(-1, string);
        c8837aM56344a.m56353a(new DialogInterfaceOnKeyListenerC8864r(this, c8837aM56344a));
    }

    @Override // com.huawei.updatesdk.service.otaupdate.InterfaceC8867b
    /* renamed from: a */
    public void mo56435a(int i10) {
        Toast.makeText(this, getString(C8835c.m56335c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        C8869d.m56446a().m56447a(i10);
        finish();
    }

    /* renamed from: b */
    private void m56409b(C8844c c8844c) {
        C8837a c8837aM56344a = C8837a.m56344a(this, null, getString(C8835c.m56335c(this, "upsdk_appstore_install"), c8844c.m56368a()));
        c8837aM56344a.m56357a(new C8857k(c8844c, c8837aM56344a));
        String string = getString(C8835c.m56335c(this, "upsdk_app_download_info_new"));
        c8837aM56344a.m56356a(new C8858l());
        c8837aM56344a.m56351a(-1, string);
        c8837aM56344a.m56353a(new DialogInterfaceOnKeyListenerC8864r(this, c8837aM56344a));
    }

    @Override // com.huawei.updatesdk.p191b.p199f.InterfaceC8828b
    /* renamed from: a */
    public void mo56290a(int i10, C8795b c8795b) {
        if (c8795b == null) {
            return;
        }
        if (i10 == 0) {
            m56396a(c8795b);
        } else if (1 == i10) {
            m56407b(c8795b);
        } else {
            m56416c(c8795b);
        }
    }

    /* renamed from: a */
    private void m56394a(Intent intent) {
        try {
            C8795b c8795bM56136a = C8795b.m56136a(intent);
            this.f45213n = c8795bM56136a.m56137a("installResultCode", -99);
            this.f45206g = c8795bM56136a.m56140a(UpdateKey.MUST_UPDATE, false);
        } catch (Throwable th2) {
            this.f45213n = -99;
            this.f45206g = false;
            C8774a.m56008a("AppUpdateActivity", "get result error, e: " + th2.getMessage());
        }
    }

    /* renamed from: a */
    private void m56395a(View view) {
        if (C8789c.m56116l()) {
            try {
                ScrollView scrollView = (ScrollView) view.findViewById(C8835c.m56331a(this, "scroll_layout"));
                TypedValue typedValue = new TypedValue();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getTheme().resolveAttribute(R.attr.dialogPreferredPadding, typedValue, true);
                ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
                int iComplexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, displayMetrics);
                scrollView.setPadding(iComplexToDimensionPixelSize, 0, iComplexToDimensionPixelSize, 0);
            } catch (Exception e10) {
                C8777a.m56028b("AppUpdateActivity", e10.toString());
            }
        }
    }

    /* renamed from: a */
    private void m56396a(C8795b c8795b) {
        Bundle bundleM56142b = c8795b.m56142b();
        if (bundleM56142b != null) {
            int i10 = bundleM56142b.getInt("download_status_param", -1);
            C8869d.m56446a().m56448a(m56391a(-1, -1, i10));
            if (C8816a.m56236a(i10)) {
                return;
            }
            m56393a();
            if (C8816a.m56237b(i10)) {
                Toast.makeText(this, getString(C8835c.m56335c(this, "upsdk_third_app_dl_install_failed")), 0).show();
                finish();
            }
        }
    }

    /* renamed from: b */
    private void m56412b(String str) {
        AlertDialog alertDialog = this.f45201b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.f45201b = (C8789c.m56116l() ? new AlertDialog.Builder(this) : (getResources().getConfiguration().uiMode & 48) == 32 ? new AlertDialog.Builder(this, R.style.Theme.DeviceDefault.Dialog.Alert) : new AlertDialog.Builder(this, R.style.Theme.DeviceDefault.Light.Dialog.Alert)).create();
            C8789c.m56105f().m56120a(this.f45201b.getWindow());
            View viewInflate = LayoutInflater.from(this).inflate(C8835c.m56334b(this, "upsdk_app_dl_progress_dialog"), (ViewGroup) null);
            ((TextView) viewInflate.findViewById(C8835c.m56331a(this, "third_app_warn_text"))).setText(getString(C8835c.m56335c(this, "upsdk_app_download_installing"), str));
            ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(C8835c.m56331a(this, "third_app_dl_progressbar"));
            this.f45204e = progressBar;
            progressBar.setMax(100);
            this.f45205f = (TextView) viewInflate.findViewById(C8835c.m56331a(this, "third_app_dl_progress_text"));
            viewInflate.findViewById(C8835c.m56331a(this, "cancel_bg")).setOnClickListener(new ViewOnClickListenerC8856j());
            this.f45201b.setView(viewInflate);
            this.f45201b.setCancelable(false);
            this.f45201b.setCanceledOnTouchOutside(false);
            if (!AbstractC8866a.m56441a(this)) {
                this.f45201b.show();
            }
            this.f45205f.setText(C8836d.m56337a(0));
        }
    }

    /* renamed from: a */
    private void m56397a(ApkUpgradeInfo apkUpgradeInfo, TextView textView) {
        if (textView == null) {
            return;
        }
        if (apkUpgradeInfo.getDiffSize_() <= 0) {
            textView.setVisibility(8);
            return;
        }
        String strM56338a = C8836d.m56338a(this, (apkUpgradeInfo.getPackingType_() != 3 || apkUpgradeInfo.getObbSize_() <= 0) ? apkUpgradeInfo.getLongSize_() : apkUpgradeInfo.getLongSize_() + apkUpgradeInfo.getObbSize_());
        SpannableString spannableString = new SpannableString(strM56338a);
        spannableString.setSpan(new StrikethroughSpan(), 0, strM56338a.length(), 33);
        spannableString.setSpan(new TextAppearanceSpan(C8833a.m56305f().m56309b() > 0 ? "HnChinese-medium" : "HwChinese-medium", 0, (int) textView.getTextSize(), null, null), 0, spannableString.length(), 33);
        textView.setText(spannableString);
    }

    @Override // com.huawei.updatesdk.service.otaupdate.InterfaceC8867b
    /* renamed from: a */
    public void mo56436a(C8844c c8844c) {
        if (c8844c == null || !c8844c.m56373f()) {
            Toast.makeText(this, getString(C8835c.m56335c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
            finish();
        } else {
            C8829c.m56291a().mo56288a(this);
            this.f45200a = c8844c.m56371d();
            m56409b(c8844c);
        }
    }

    /* renamed from: a */
    public void m56402a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f45212m = 1;
            finish();
            return;
        }
        Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId");
        intent.setPackage(this.f45200a);
        intent.putExtra("appDetailId", str2);
        intent.putExtra("thirdId", str);
        intent.addFlags(268468224);
        try {
            startActivity(intent);
            if (this.f45209j) {
                return;
            }
            finish();
        } catch (Exception e10) {
            C8774a.m56008a("AppUpdateActivity", "openMarketUpdateDetail error: " + e10.getMessage());
            C8821f.m56267a(this);
            C8821f.m56268a(this.f45216q);
            Intent intent2 = new Intent();
            intent2.putExtra("status", 8);
            C8869d.m56446a().m56450b(intent2);
            C8837a c8837a = this.f45203d;
            if (c8837a != null) {
                c8837a.m56350a();
            }
        }
    }

    /* renamed from: a */
    private boolean m56403a(String str) {
        TextView textView;
        View viewInflate = LayoutInflater.from(this).inflate(C8835c.m56334b(this, "upsdk_ota_update_view"), (ViewGroup) null);
        String string = TextUtils.isEmpty(this.f45208i.getNewFeatures_()) ? getString(C8835c.m56335c(this, "upsdk_choice_update")) : this.f45208i.getNewFeatures_();
        if (viewInflate == null || (textView = (TextView) viewInflate.findViewById(C8835c.m56331a(this, "content_textview"))) == null) {
            return false;
        }
        textView.setText(string);
        String version_ = this.f45208i.getVersion_();
        TextView textView2 = (TextView) viewInflate.findViewById(C8835c.m56331a(this, "version_textview"));
        if (textView2 == null) {
            return false;
        }
        textView2.setText(version_);
        C8836d.m56340a(textView2);
        String strM56338a = C8836d.m56338a(this, m56390a(this.f45208i));
        TextView textView3 = (TextView) viewInflate.findViewById(C8835c.m56331a(this, "appsize_textview"));
        textView3.setText(strM56338a);
        C8836d.m56340a(textView3);
        TextView textView4 = (TextView) viewInflate.findViewById(C8835c.m56331a(this, "name_textview"));
        textView4.setText(this.f45208i.getName_());
        C8836d.m56340a(textView4);
        TextView textView5 = (TextView) viewInflate.findViewById(C8835c.m56331a(this, "allsize_textview"));
        m56397a(this.f45208i, textView5);
        C8836d.m56340a(textView5);
        ((TextView) viewInflate.findViewById(C8835c.m56331a(this, "download_install_textview"))).setVisibility(TextUtils.equals("CN", C8871f.m56464e().m56465a()) ? 0 : 8);
        m56395a(viewInflate);
        C8837a c8837aM56344a = C8837a.m56344a(this, str, null);
        this.f45203d = c8837aM56344a;
        c8837aM56344a.m56355a(viewInflate);
        return true;
    }
}
