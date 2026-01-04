package com.huawei.phoneservice.faq;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqWebActivityUtil;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;

/* loaded from: classes4.dex */
public abstract class FaqCommonWebActivity extends FaqBaseWebActivity {
    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: E0 */
    public void mo51663E0() {
        super.mo51663E0();
        if (TextUtils.isEmpty(this.f38508B)) {
            return;
        }
        FaqWebActivityUtil.removeWebViewJavascriptInterface(this.f38511E);
        this.f38511E.addJavascriptInterface(this.f38509C, "memberJSObject");
        this.f38507A = false;
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: G0 */
    public void mo51665G0() throws Throwable {
        FaqLogger.m51836d("CommonWebActivity", "onPageFinish");
    }

    /* renamed from: J0 */
    public void mo51676J0(String str) {
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: V */
    public void mo51668V() {
        super.mo51668V();
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: b */
    public void mo51669b(int i10) {
        if (i10 > 10) {
            this.f38511E.setVisibility(0);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Throwable {
        FaqNoticeView faqNoticeView;
        FaqConstants.FaqErrorCode faqErrorCode;
        if (FaqCommonUtils.isConnectionAvailable(this)) {
            this.f38511E.setVisibility(4);
            if (FaqWebActivityUtil.isUrl(this.f38508B)) {
                this.f38512F.setVisibility(4);
                String str = this.f38508B;
                if (str != null && str.equals(this.f38511E.getUrl())) {
                    this.f38511E.reload();
                    return;
                } else if (FaqWebActivityUtil.isInWhiteList(this.f38508B, this)) {
                    this.f38511E.loadUrl(this.f38508B);
                    return;
                } else {
                    FaqWebActivityUtil.goToBrowserWebUrl(this, this.f38508B, true);
                    return;
                }
            }
            faqNoticeView = this.f38512F;
            faqErrorCode = FaqConstants.FaqErrorCode.LOAD_DATA_ERROR;
        } else {
            faqNoticeView = this.f38512F;
            faqErrorCode = FaqConstants.FaqErrorCode.INTERNET_ERROR;
        }
        faqNoticeView.m52468g(faqErrorCode);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_activity_faq_common_web_layout;
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        super.mo51672i0();
        this.f38512F.setShouldHideContactUsButton(true);
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: z0 */
    public boolean mo51675z0(String str) throws Throwable {
        if (str.startsWith(NavigationUtils.MAIL_SCHEMA_PREF) || str.startsWith("geo:") || str.startsWith(NavigationUtils.TEL_SCHEMA_PREF)) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (ActivityNotFoundException unused) {
                FaqLogger.m51840e("CommonWebActivity", "can not open in browser");
            }
            return true;
        }
        m51674u0(this.f38511E);
        if (FaqWebActivityUtil.isInWhiteList(str, this)) {
            return false;
        }
        FaqWebActivityUtil.goToBrowserWebUrl(this, str, false);
        return true;
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseWebActivity
    /* renamed from: b */
    public void mo51670b(String str) {
        mo51676J0(str);
        if (TextUtils.isEmpty(str)) {
            this.f38511E.removeJavascriptInterface("memberJSObject");
            this.f38511E.getSettings().setJavaScriptEnabled(false);
            this.f38507A = true;
        } else {
            this.f38511E.getSettings().setJavaScriptEnabled(true);
            FaqWebActivityUtil.removeWebViewJavascriptInterface(this.f38511E);
            this.f38511E.addJavascriptInterface(this.f38509C, "memberJSObject");
            this.f38507A = false;
        }
    }
}
