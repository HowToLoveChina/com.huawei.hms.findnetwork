package com.huawei.phoneservice.faq;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.base.util.SdkListener;
import com.huawei.phoneservice.faq.base.util.SdkListenerPoxy;
import com.huawei.phoneservice.faq.p174ui.FaqCategoryActivity;
import com.huawei.phoneservice.faq.p174ui.FaqCategoryWebActivity;
import com.huawei.phoneservice.faq.response.C8343c;
import com.huawei.phoneservice.faq.utils.IFaqManager;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;

/* loaded from: classes4.dex */
public class FaqDisabledActivity extends FaqBaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public FaqNoticeView f38532A;

    /* renamed from: B */
    public boolean f38533B;

    /* renamed from: C */
    public SdkListenerPoxy f38534C;

    /* renamed from: D */
    public boolean f38535D = false;

    /* renamed from: com.huawei.phoneservice.faq.FaqDisabledActivity$a */
    public class C8273a extends SdkListenerPoxy {

        /* renamed from: com.huawei.phoneservice.faq.FaqDisabledActivity$a$a */
        public class a extends FaqCallback<C8343c> {
            public a(Class cls, Activity activity) {
                super(cls, activity);
            }

            @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
            /* renamed from: h */
            public void onResult(Throwable th2, C8343c c8343c) {
                FaqDisabledActivity.this.m51680b((th2 != null || c8343c == null) ? FaqConstants.DEFAULT_ISO_LANGUAGE : c8343c.m51998a());
            }
        }

        /* renamed from: com.huawei.phoneservice.faq.FaqDisabledActivity$a$b */
        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f38538a;

            public b(int i10) {
                this.f38538a = i10;
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                FaqDisabledActivity.this.m51679b(this.f38538a);
            }
        }

        public C8273a(SdkListener sdkListener) {
            super(sdkListener);
        }

        @Override // com.huawei.phoneservice.faq.base.util.SdkListenerPoxy
        public void onSdkInitImpl(int i10, int i11, String str) {
            if (i10 != 0 || i11 != 0) {
                FaqDisabledActivity.this.runOnUiThread(new b(i11));
                return;
            }
            IFaqManager manager = SdkFaqManager.getManager();
            FaqDisabledActivity faqDisabledActivity = FaqDisabledActivity.this;
            manager.getIsoLanguage(faqDisabledActivity, new a(C8343c.class, faqDisabledActivity));
        }
    }

    /* renamed from: b */
    public void m51679b(int i10) throws Resources.NotFoundException {
        Resources resources;
        Resources resources2 = getResources();
        int i11 = R$string.faq_sdk_no_feedback_module;
        String string = resources2.getString(i11);
        int i12 = R$drawable.faq_sdk_ic_icon_deploy_disable;
        if (i10 == -1) {
            this.f38532A.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
            return;
        }
        if (i10 == 2 || i10 == 3) {
            resources = getResources();
        } else {
            if (i10 != 4) {
                if (i10 == 5 || i10 == 6) {
                    this.f38532A.m52468g(FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
                }
                if (i10 != 5 || i10 == 6) {
                }
                FaqNoticeView faqNoticeView = this.f38532A;
                FaqConstants.FaqErrorCode faqErrorCode = FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR;
                faqNoticeView.m52468g(faqErrorCode);
                this.f38532A.m52469h(faqErrorCode, i12);
                this.f38532A.m52475r(faqErrorCode, getResources().getDimensionPixelOffset(R$dimen.faq_sdk_loading_empty_icon_size));
                this.f38532A.setShouldHideContactUsButton(true);
                this.f38532A.getNoticeTextView().setText(string);
                return;
            }
            i12 = R$drawable.faq_sdk_ic_icon_initialize_disable;
            resources = getResources();
            i11 = R$string.faq_sdk_init_failed;
        }
        string = resources.getString(i11);
        if (i10 != 5) {
        }
    }

    /* renamed from: q0 */
    private void m51683q0() {
        Intent intent = getIntent();
        if (intent == null || intent.getIntExtra("code", -1) != 6) {
            return;
        }
        this.f38532A.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
        FaqSdk.getISdk().getModuleList();
        this.f38535D = true;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Resources.NotFoundException {
        setTitle(R$string.faq_sdk_category_activity_title);
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            this.f38532A.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            return;
        }
        if (FaqSdk.getSdk().initIsDone()) {
            int sdkInitCode = FaqSdk.getISdk().getSdkInitCode();
            if (this.f38533B) {
                if (sdkInitCode != 0) {
                    if (sdkInitCode == 5) {
                        this.f38532A.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
                        FaqSdk.getISdk().getServiceUrl();
                    } else if (sdkInitCode == 6) {
                        this.f38532A.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
                        FaqSdk.getISdk().getModuleList();
                    }
                    this.f38535D = true;
                } else {
                    m51683q0();
                }
            }
            if (this.f38535D) {
                return;
            }
            m51679b(sdkInitCode);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_disabled_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        this.f38532A.setOnClickListener(this);
        this.f38534C = new C8273a(FaqSdk.getSdk().getSdkListener());
        FaqSdk.getSdk().setSdkListener(this.f38534C);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        this.f38532A = (FaqNoticeView) findViewById(R$id.faq_disabled_noticeView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (!NoDoubleClickUtil.isDoubleClick(view) && view.getId() == R$id.faq_disabled_noticeView) {
            if (this.f38532A.getFaqErrorCode() == FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR || this.f38532A.getFaqErrorCode() == FaqConstants.FaqErrorCode.INTERNET_ERROR) {
                this.f38533B = true;
            }
            mo51677f();
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f38534C != null) {
            FaqSdk.getSdk().setSdkListener(this.f38534C.getSdkListener());
        }
    }

    /* renamed from: b */
    public void m51680b(String str) {
        Intent intent;
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (ModuleConfigUtils.isHasFaq()) {
            String[] faqOpenTypeConfig = ModuleConfigUtils.getFaqOpenTypeConfig();
            intent = (faqOpenTypeConfig.length <= 1 || TextUtils.isEmpty(faqOpenTypeConfig[1])) ? new Intent(this, (Class<?>) FaqCategoryActivity.class) : new Intent(this, (Class<?>) FaqCategoryWebActivity.class);
        } else {
            intent = new Intent(this, (Class<?>) FaqCategoryActivity.class);
        }
        intent.putExtra(FaqConstants.FAQ_ISOLANGUAGE, str);
        startActivity(intent);
        finish();
    }
}
