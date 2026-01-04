package com.huawei.phoneservice.faq.dispatch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.huawei.phoneservice.faq.FaqDisabledActivity;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.SdkListenerPoxy;
import com.huawei.phoneservice.faq.business.C8326a;
import com.huawei.phoneservice.faq.utils.C8412b;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;

/* renamed from: com.huawei.phoneservice.faq.dispatch.b */
/* loaded from: classes4.dex */
public class C8332b implements InterfaceC8334d {

    /* renamed from: b */
    public SdkListenerPoxy f38748b;

    /* renamed from: a */
    public Intent f38747a = null;

    /* renamed from: c */
    public boolean f38749c = false;

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: a */
    public boolean mo51908a(Activity activity, Intent intent) throws Throwable {
        String sdk;
        Intent intent2 = activity.getIntent();
        this.f38747a = intent2;
        if (intent2 == null) {
            return true;
        }
        Uri data = intent2.getData();
        if (data != null) {
            SdkFaqManager.getSdk().setUriFromFaq(data);
            try {
                sdk = data.getQueryParameter(FaqConstants.FAQ_CALLFLAG);
            } catch (UnsupportedOperationException | Exception e10) {
                FaqLogger.m51840e("FaqDispatchPresenter", e10.getMessage());
                sdk = null;
            }
        } else {
            sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CALLFLAG);
        }
        if (!"Y".equals(sdk)) {
            m51915e(activity);
            return true;
        }
        C8326a.m51894a().m51896c();
        activity.finish();
        return true;
    }

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: b */
    public boolean mo51909b() {
        return this.f38749c;
    }

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: c */
    public boolean mo51910c(Intent intent) {
        return true;
    }

    @Override // com.huawei.phoneservice.faq.dispatch.InterfaceC8334d
    /* renamed from: d */
    public void mo51911d(SdkListenerPoxy sdkListenerPoxy) {
        this.f38748b = sdkListenerPoxy;
    }

    /* renamed from: e */
    public final void m51915e(Activity activity) {
        if (FaqSdk.getSdk().init() && FaqSdk.getISdk().getSdkInitCode() == 0) {
            C8412b.m52369c(activity, true, null);
        } else {
            m51916f(activity, -1);
        }
    }

    /* renamed from: f */
    public final void m51916f(Activity activity, int i10) {
        if (this.f38748b != null) {
            FaqSdk.getSdk().setSdkListener(this.f38748b.getSdkListener());
            this.f38749c = true;
        }
        this.f38747a.setClassName(activity, FaqDisabledActivity.class.getName());
        if (i10 != -1) {
            this.f38747a.putExtra("code", i10);
        }
        activity.startActivity(this.f38747a);
        activity.finish();
    }
}
