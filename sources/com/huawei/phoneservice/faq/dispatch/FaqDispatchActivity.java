package com.huawei.phoneservice.faq.dispatch;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.SdkAppInfo;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;
import com.huawei.phoneservice.faq.base.util.SdkListener;
import com.huawei.phoneservice.faq.base.util.SdkListenerPoxy;

/* loaded from: classes4.dex */
public class FaqDispatchActivity extends Activity {

    /* renamed from: a */
    public ProgressDialog f38733a;

    /* renamed from: b */
    public SdkListenerPoxy f38734b;

    /* renamed from: c */
    public InterfaceC8334d f38735c;

    /* renamed from: com.huawei.phoneservice.faq.dispatch.FaqDispatchActivity$a */
    public class C8329a extends SdkListenerPoxy {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC8334d f38736a;

        /* renamed from: b */
        public final /* synthetic */ Intent f38737b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8329a(SdkListener sdkListener, InterfaceC8334d interfaceC8334d, Intent intent) {
            super(sdkListener);
            this.f38736a = interfaceC8334d;
            this.f38737b = intent;
        }

        @Override // com.huawei.phoneservice.faq.base.util.SdkListenerPoxy
        public void onSdkInitImpl(int i10, int i11, String str) throws Throwable {
            FaqLogger.print("FaqDispatchActivity", "result: " + i10 + " code: " + i11 + " msg: " + str);
            FaqDispatchActivity.this.m51903c(this.f38736a, this.f38737b);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.dispatch.FaqDispatchActivity$b */
    public class DialogInterfaceOnCancelListenerC8330b implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC8330b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            FaqDispatchActivity.this.finish();
        }
    }

    /* renamed from: a */
    public void m51902a() {
        ProgressDialog progressDialog = this.f38733a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.f38733a.dismiss();
    }

    /* renamed from: c */
    public final void m51903c(InterfaceC8334d interfaceC8334d, Intent intent) throws Throwable {
        interfaceC8334d.mo51911d(this.f38734b);
        if (interfaceC8334d.mo51908a(this, intent)) {
            return;
        }
        FaqLogger.m51840e("FaqDispatchActivity", "Do not support this URI");
        finish();
    }

    /* renamed from: d */
    public final void m51904d(InterfaceC8334d interfaceC8334d, Intent intent) throws Throwable {
        if (FaqSdk.getSdk().initIsDone()) {
            m51903c(interfaceC8334d, intent);
        } else {
            this.f38734b = new C8329a(FaqSdk.getSdk().getSdkListener(), interfaceC8334d, intent);
            FaqSdk.getSdk().setSdkListener(this.f38734b);
        }
    }

    /* renamed from: e */
    public final int[] m51905e() {
        return new int[]{R.id.content};
    }

    /* renamed from: f */
    public void m51906f() {
        if (isFinishing()) {
            return;
        }
        ProgressDialog progressDialog = this.f38733a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            ProgressDialog progressDialog2 = new ProgressDialog(this);
            this.f38733a = progressDialog2;
            progressDialog2.setMessage(getString(R$string.faq_sdk_common_loading));
            this.f38733a.setOnCancelListener(new DialogInterfaceOnCancelListenerC8330b());
            this.f38733a.setCanceledOnTouchOutside(false);
            this.f38733a.setCancelable(true);
            this.f38733a.show();
            if (getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null) != 0) {
                return;
            }
            this.f38733a.setContentView(getLayoutInflater().inflate(R$layout.faq_sdk_progress_dialog, (ViewGroup) null));
            Window window = this.f38733a.getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            window.setGravity(80);
            attributes.y = 50;
            attributes.dimAmount = 0.2f;
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ProgressDialog progressDialog = this.f38733a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        m51902a();
        m51906f();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        SdkAppInfo.initAppInfo(getApplication());
        requestWindowFeature(1);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        Intent intent = getIntent();
        if (FaqCommonUtils.isPad()) {
            FaqUiUtils.setPadPadding(this, m51905e());
        }
        super.onCreate(bundle);
        InterfaceC8334d interfaceC8334dM51917a = C8333c.m51917a(intent);
        this.f38735c = interfaceC8334dM51917a;
        if (interfaceC8334dM51917a == null) {
            finish();
            return;
        }
        m51904d(interfaceC8334dM51917a, intent);
        if (this.f38735c.mo51910c(intent) && "1".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHOW_PROGRESS))) {
            m51906f();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        InterfaceC8334d interfaceC8334d = this.f38735c;
        if (interfaceC8334d != null && !interfaceC8334d.mo51909b() && this.f38734b != null) {
            FaqSdk.getSdk().setSdkListener(this.f38734b.getSdkListener());
        }
        m51902a();
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        super.setRequestedOrientation(i10);
    }
}
