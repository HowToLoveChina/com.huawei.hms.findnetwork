package com.huawei.phoneservice.feedback.p175ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.base.util.SdkListener;
import com.huawei.phoneservice.faq.base.util.SdkListenerPoxy;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.utils.SdkFeedbackProblemManager;
import com.huawei.phoneservice.feedback.widget.FeedbackNoticeView;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;

/* loaded from: classes5.dex */
public class FeedbackDisabledActivity extends FeedBaseActivity implements View.OnClickListener {

    /* renamed from: C */
    public FeedbackNoticeView f39786C;

    /* renamed from: D */
    public boolean f39787D;

    /* renamed from: E */
    public ProblemInfo f39788E;

    /* renamed from: F */
    public int f39789F;

    /* renamed from: G */
    public SdkListenerPoxy f39790G;

    /* renamed from: H */
    public boolean f39791H = false;

    /* renamed from: I */
    public boolean f39792I = true;

    /* renamed from: J */
    public boolean f39793J = false;

    /* renamed from: K */
    public boolean f39794K;

    /* renamed from: L */
    public Bundle f39795L;

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDisabledActivity$a */
    public class C8540a implements FeedbackNoticeView.InterfaceC8596b {
        public C8540a() {
        }

        @Override // com.huawei.phoneservice.feedback.widget.FeedbackNoticeView.InterfaceC8596b
        /* renamed from: a */
        public void mo52976a() throws Throwable {
            if (FeedbackDisabledActivity.this.f39794K) {
                FaqLogger.print("FeedbackDisabledActivity", "ONBACKPRESSED IS DEEPLINK RELEASE");
                FaqSdk.getSdk().release();
            }
            FeedbackDisabledActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDisabledActivity$b */
    public class C8541b extends SdkListenerPoxy {

        /* renamed from: com.huawei.phoneservice.feedback.ui.FeedbackDisabledActivity$b$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f39798a;

            /* renamed from: b */
            public final /* synthetic */ int f39799b;

            /* renamed from: c */
            public final /* synthetic */ String f39800c;

            public a(int i10, int i11, String str) {
                this.f39798a = i10;
                this.f39799b = i11;
                this.f39800c = str;
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                int i10;
                FaqLogger.print("FeedbackDisabledActivity", "result: " + this.f39798a + " code: " + this.f39799b + " msg: " + this.f39800c);
                if (this.f39798a == 0 && (i10 = this.f39799b) == 0) {
                    FeedbackDisabledActivity.this.m52972D0(i10);
                } else if (FeedbackDisabledActivity.this.f39794K && FeedbackDisabledActivity.this.f39793J) {
                    FeedbackDisabledActivity.this.m52974F0();
                } else {
                    FeedbackDisabledActivity.this.m52972D0(this.f39799b);
                }
            }
        }

        public C8541b(SdkListener sdkListener) {
            super(sdkListener);
        }

        @Override // com.huawei.phoneservice.faq.base.util.SdkListenerPoxy
        public void onSdkInitImpl(int i10, int i11, String str) {
            FeedbackDisabledActivity.this.runOnUiThread(new a(i10, i11, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: D0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m52972D0(int r7) throws java.lang.Throwable {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            int r1 = com.huawei.phoneservice.feedback.R$string.feedback_sdk_no_feedback_module
            java.lang.String r0 = r0.getString(r1)
            int r2 = com.huawei.phoneservice.feedback.R$drawable.ic_icon_deploy_disable
            r3 = -1
            if (r7 == r3) goto L74
            r3 = 6
            r4 = 5
            if (r7 == 0) goto L3b
            r5 = 2
            if (r7 == r5) goto L36
            r5 = 3
            if (r7 == r5) goto L36
            r1 = 4
            if (r7 == r1) goto L29
            if (r7 == r4) goto L21
            if (r7 == r3) goto L21
            goto L45
        L21:
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView r1 = r6.f39786C
            com.huawei.phoneservice.faq.base.constants.FaqConstants$FaqErrorCode r5 = com.huawei.phoneservice.faq.base.constants.FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR
            r1.m53143g(r5)
            goto L45
        L29:
            int r2 = com.huawei.phoneservice.feedback.R$drawable.ic_icon_initialize_disable
            android.content.res.Resources r0 = r6.getResources()
            int r1 = com.huawei.phoneservice.feedback.R$string.feedback_sdk_init_failed
        L31:
            java.lang.String r0 = r0.getString(r1)
            goto L45
        L36:
            android.content.res.Resources r0 = r6.getResources()
            goto L31
        L3b:
            boolean r0 = com.huawei.phoneservice.faq.base.util.ModuleConfigUtils.newFeedbackEnabled()
            if (r0 == 0) goto L36
            r6.m52973E0()
            return
        L45:
            if (r7 == r4) goto L73
            if (r7 == r3) goto L73
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView r7 = r6.f39786C
            com.huawei.phoneservice.faq.base.constants.FaqConstants$FaqErrorCode r1 = com.huawei.phoneservice.faq.base.constants.FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR
            r7.m53143g(r1)
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView r7 = r6.f39786C
            r7.m53144h(r1, r2)
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView r7 = r6.f39786C
            android.content.res.Resources r2 = r6.getResources()
            int r3 = com.huawei.phoneservice.feedback.R$dimen.feedback_sdk_loading_empty_icon_size
            int r2 = r2.getDimensionPixelOffset(r3)
            r7.m53151s(r1, r2)
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView r7 = r6.f39786C
            r1 = 1
            r7.setShouldHideContactUsButton(r1)
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView r6 = r6.f39786C
            android.widget.TextView r6 = r6.getNoticeTextView()
            r6.setText(r0)
        L73:
            return
        L74:
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView r6 = r6.f39786C
            com.huawei.phoneservice.feedback.widget.FeedbackNoticeView$c r7 = com.huawei.phoneservice.feedback.widget.FeedbackNoticeView.EnumC8597c.PROGRESS
            r6.m53146j(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.p175ui.FeedbackDisabledActivity.m52972D0(int):void");
    }

    /* renamed from: E0 */
    private void m52973E0() throws Throwable {
        if (!this.f39794K) {
            SdkFeedbackProblemManager.getManager().gotoFeedback(this, this.f39788E, this.f39789F);
        } else if (this.f39793J) {
            m52974F0();
        } else {
            SdkFeedbackProblemManager.getManager().gotoFeedbackByDeepLink(this, this.f39795L);
        }
        this.f39792I = false;
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public void m52974F0() throws Throwable {
        this.f39786C.m53143g(FaqConstants.FaqErrorCode.DIFFERENT_SITE);
        this.f39786C.setCallback(new C8540a());
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f39792I) {
            setResult(2);
        }
        super.finish();
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_feedback_disabled;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        setTitle(R$string.faq_sdk_feedback);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f39788E = safeIntent.hasExtra("problem_info") ? (ProblemInfo) safeIntent.getParcelableExtra("problem_info") : null;
        this.f39789F = safeIntent.getIntExtra("REQUEST_CODE", -1);
        Bundle extras = safeIntent.getExtras();
        this.f39795L = extras;
        String strM63694p = new C10343b(extras).m63694p("country");
        if (!FaqStringUtil.isEmpty(strM63694p) && strM63694p != null) {
            this.f39793J = !strM63694p.equals(FaqSdk.getSdk().getSdk("country"));
        }
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            this.f39786C.m53143g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            return;
        }
        this.f39794K = "Y".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_IS_DEEPLICK));
        if (this.f39793J) {
            m52974F0();
            return;
        }
        if (FaqSdk.getSdk().initIsDone()) {
            int sdkInitCode = FaqSdk.getISdk().getSdkInitCode();
            if (this.f39787D) {
                if (sdkInitCode == 5) {
                    this.f39786C.m53146j(FeedbackNoticeView.EnumC8597c.PROGRESS);
                    FaqSdk.getISdk().getServiceUrl();
                } else if (sdkInitCode == 6) {
                    this.f39786C.m53146j(FeedbackNoticeView.EnumC8597c.PROGRESS);
                    FaqSdk.getISdk().getModuleList();
                }
                this.f39791H = true;
            }
            if (this.f39791H) {
                return;
            }
            m52972D0(sdkInitCode);
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39786C.setOnClickListener(this);
        this.f39790G = new C8541b(FaqSdk.getSdk().getSdkListener());
        FaqSdk.getSdk().setSdkListener(this.f39790G);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        this.f39786C = (FeedbackNoticeView) findViewById(R$id.feedback_disabled_noticeView);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    public void onBackPressed(View view) throws Throwable {
        super.onBackPressed(view);
        if (this.f39794K) {
            FaqLogger.print("FeedbackDisabledActivity", "ONBACKPRESSED IS DEEPLINK RELEASE");
            FaqSdk.getSdk().release();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!NoDoubleClickUtil.isDoubleClick(view) && view.getId() == R$id.feedback_disabled_noticeView) {
            if (this.f39786C.getFaqErrorCode() == FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR || this.f39786C.getFaqErrorCode() == FaqConstants.FaqErrorCode.INTERNET_ERROR) {
                this.f39787D = true;
            }
            mo52896j0();
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws Throwable {
        super.onDestroy();
        if (this.f39790G != null) {
            FaqSdk.getSdk().setSdkListener(this.f39790G.getSdkListener());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) throws Throwable {
        if (i10 == 4 && this.f39794K) {
            FaqLogger.print("FeedbackDisabledActivity", "ONKEYDOWN IS DEEPLINK RELEASE");
            FaqSdk.getSdk().release();
        }
        return super.onKeyDown(i10, keyEvent);
    }
}
