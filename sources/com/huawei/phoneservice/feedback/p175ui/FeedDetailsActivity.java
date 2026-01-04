package com.huawei.phoneservice.feedback.p175ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.base.util.VideoCallBack;
import com.huawei.phoneservice.feedback.R$dimen;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter;
import com.huawei.phoneservice.feedback.entity.C8472c;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackCITListView;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8500b;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c;
import com.huawei.phoneservice.feedback.mvp.presenter.C8506b;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8510b;
import com.huawei.phoneservice.feedback.utils.SdkFeedbackProblemManager;
import com.huawei.phoneservice.feedback.widget.FeedbackNoticeView;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRateRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemInfo;
import com.huawei.phoneservice.feedbackcommon.photolibrary.MimeType;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import com.huawei.phoneservice.feedbackcommon.utils.NetworkUtils;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class FeedDetailsActivity extends FeedbackBaseActivity<InterfaceC8500b> implements InterfaceC8501c, FeedDetailAdapter.InterfaceC8458f, View.OnClickListener {

    /* renamed from: D */
    public FeedbackCITListView f39706D;

    /* renamed from: E */
    public Button f39707E;

    /* renamed from: F */
    public C8506b f39708F;

    /* renamed from: G */
    public FeedDetailAdapter f39709G;

    /* renamed from: H */
    public FeedbackNoticeView f39710H;

    /* renamed from: I */
    public FeedBackResponse.ProblemEnity f39711I;

    /* renamed from: J */
    public String f39712J;

    /* renamed from: K */
    public boolean f39713K;

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedDetailsActivity$a */
    public class ViewOnClickListenerC8515a implements View.OnClickListener {
        public ViewOnClickListenerC8515a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedDetailsActivity.this.mo52896j0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedDetailsActivity$b */
    public class C8516b implements VideoCallBack {

        /* renamed from: a */
        public final /* synthetic */ ImageView f39715a;

        /* renamed from: b */
        public final /* synthetic */ ImageView f39716b;

        /* renamed from: c */
        public final /* synthetic */ RelativeLayout f39717c;

        /* renamed from: d */
        public final /* synthetic */ RelativeLayout f39718d;

        /* renamed from: com.huawei.phoneservice.feedback.ui.FeedDetailsActivity$b$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ File f39720a;

            public a(File file) {
                this.f39720a = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f39720a != null) {
                    C8516b.this.f39715a.setVisibility(0);
                    ComponentCallbacks2C1546b.m8904t(FeedDetailsActivity.this.getApplicationContext()).m8984r(this.f39720a).m8965n(C8516b.this.f39715a);
                } else {
                    C8516b.this.f39716b.setVisibility(0);
                    C8516b.this.f39717c.setVisibility(0);
                }
                C8516b.this.f39718d.setVisibility(8);
            }
        }

        public C8516b(ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
            this.f39715a = imageView;
            this.f39716b = imageView2;
            this.f39717c = relativeLayout;
            this.f39718d = relativeLayout2;
        }

        @Override // com.huawei.phoneservice.faq.base.util.VideoCallBack
        public void setChangeImage(File file, boolean z10) {
            FeedDetailsActivity.this.runOnUiThread(new a(file));
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedDetailsActivity$c */
    public class ViewOnClickListenerC8517c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f39722a;

        /* renamed from: b */
        public final /* synthetic */ ImageView f39723b;

        /* renamed from: c */
        public final /* synthetic */ RelativeLayout f39724c;

        /* renamed from: d */
        public final /* synthetic */ RelativeLayout f39725d;

        /* renamed from: e */
        public final /* synthetic */ ImageView f39726e;

        /* renamed from: f */
        public final /* synthetic */ String f39727f;

        public ViewOnClickListenerC8517c(String str, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2, String str2) {
            this.f39722a = str;
            this.f39723b = imageView;
            this.f39724c = relativeLayout;
            this.f39725d = relativeLayout2;
            this.f39726e = imageView2;
            this.f39727f = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedDetailsActivity.this.m52744D0();
            FeedDetailsActivity.this.f39708F.m52833e(this.f39722a, FeedDetailsActivity.this.m52891M0(this.f39723b, this.f39724c, this.f39725d, this.f39726e), this.f39727f, SdkProblemManager.getSdk().getSdk("accessToken"));
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedDetailsActivity$d */
    public class ViewOnClickListenerC8518d implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ImageView f39729a;

        public ViewOnClickListenerC8518d(ImageView imageView) {
            this.f39729a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedDetailsActivity.this.m52744D0();
            this.f39729a.setVisibility(0);
        }
    }

    /* renamed from: H0 */
    private void m52882H0() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f39712J = safeIntent.getStringExtra("questionId");
        this.f39713K = safeIntent.getBooleanExtra("COME_FROM", false);
    }

    /* renamed from: J0 */
    private void m52883J0() {
        this.f39708F.m52830b(this);
        m52882H0();
        this.f39706D.setLayoutManager(new LinearLayoutManager(this));
        this.f39709G.m52590T(this);
        this.f39706D.setAdapter(this.f39709G);
        this.f39708F.m52834g(m52889I0());
    }

    /* renamed from: L0 */
    private void m52884L0() {
        if (this.f39707E.getMeasuredWidth() < FaqCommonUtils.getScreenWidthHeight(this)) {
            C8510b.m52864a(this, this.f39707E);
        }
    }

    /* renamed from: I0 */
    public final FeedBackRequest m52889I0() {
        FeedBackRequest feedBackRequest = new FeedBackRequest();
        feedBackRequest.setAccessToken(SdkProblemManager.getSdk().getSdk("accessToken"));
        feedBackRequest.setProblemId(this.f39712J);
        feedBackRequest.setStartWith(null);
        feedBackRequest.setPageSize(50);
        feedBackRequest.setProblemSourceCode(SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        feedBackRequest.setOrderType(1);
        return feedBackRequest;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public InterfaceC8500b mo52746F0() {
        C8506b c8506b = new C8506b(this);
        this.f39708F = c8506b;
        return c8506b;
    }

    /* renamed from: M0 */
    public final VideoCallBack m52891M0(ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2) {
        relativeLayout.setVisibility(8);
        relativeLayout2.setVisibility(0);
        return new C8516b(imageView, imageView2, relativeLayout, relativeLayout2);
    }

    /* renamed from: P0 */
    public final void m52892P0(String str, String str2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, ImageView imageView2, long j10) {
        m52873q0(j10, new ViewOnClickListenerC8517c(str, imageView, relativeLayout, relativeLayout2, imageView2, str2), new ViewOnClickListenerC8518d(imageView2));
    }

    /* renamed from: Q0 */
    public final void m52893Q0(String str, boolean z10, C8472c c8472c) throws Throwable {
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            FaqToastUtils.makeText(this, getResources().getString(R$string.feedback_sdk_no_network_toast));
            return;
        }
        FeedBackRateRequest feedBackRateRequest = new FeedBackRateRequest();
        feedBackRateRequest.setAccessToken(SdkProblemManager.getSdk().getSdk("accessToken"));
        feedBackRateRequest.setProblemId(c8472c.m52645m());
        feedBackRateRequest.setScore(str);
        c8472c.m52635b().setEnabled(false);
        c8472c.m52641h().setEnabled(false);
        this.f39708F.m52831c(feedBackRateRequest, z10, c8472c);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c
    /* renamed from: a */
    public void mo52773a(FeedBackResponse.ProblemEnity problemEnity) {
        this.f39711I = problemEnity;
        this.f39708F.m52832d(m52889I0());
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c
    /* renamed from: d */
    public void mo52775d() {
        if (this.f39711I != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f39711I);
            this.f39709G.m53163K(arrayList);
        }
        this.f39710H.setVisibility(8);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_feeddetails;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: i0 */
    public int[] mo52895i0() {
        return new int[]{R$id.lv_chatlist};
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        this.f39710H.m53146j(FeedbackNoticeView.EnumC8597c.PROGRESS);
        boolean booleanExtra = new SafeIntent(getIntent()).getBooleanExtra("COME_FROM", false);
        this.f39713K = booleanExtra;
        this.f39709G = new FeedDetailAdapter(this, booleanExtra);
        if (FaqCommonUtils.isConnectionAvailable(this)) {
            m52883J0();
            m52884L0();
        } else {
            this.f39710H.m53143g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            this.f39710H.setEnabled(true);
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39710H.setOnClickListener(new ViewOnClickListenerC8515a());
        this.f39707E.setOnClickListener(this);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        setTitle(getResources().getString(R$string.feedback_sdk_question_detail_title));
        this.f39706D = (FeedbackCITListView) findViewById(R$id.lv_chatlist);
        this.f39707E = (Button) findViewById(R$id.continuefeed_btn);
        this.f39710H = (FeedbackNoticeView) findViewById(R$id.noticeview_feeddetail);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 1) {
            this.f39708F.m52832d(m52889I0());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (NoDoubleClickUtil.isDoubleClick(view) || this.f39707E != view || this.f39711I == null) {
            return;
        }
        ProblemInfo problemInfo = new ProblemInfo(this.f39712J, this.f39711I.getProblemCatalogCode());
        problemInfo.setContact(this.f39711I.getContact());
        if (this.f39713K) {
            SdkFeedbackProblemManager.getManager().gotoProductSuggest(this, problemInfo, 1);
        } else {
            SdkFeedbackProblemManager.getManager().gotoFeedback(this, problemInfo, 1);
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        super.onConfigurationChanged(configuration);
        m52884L0();
        if (FaqCommonUtils.isPad()) {
            this.f39709G.m5213j();
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (bundle != null) {
            FaqSdk.getSdk().saveMapOnSaveInstanceState(new C10343b(bundle).m63694p("CacheMap"));
        }
        super.onCreate(bundle);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("CacheMap", FaqSdk.getSdk().getMapOnSaveInstance());
    }

    @Override // com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter.InterfaceC8458f
    /* renamed from: p */
    public void mo52602p(String str, String str2, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2, long j10) throws Throwable {
        if (!NetworkUtils.isNetworkConnected(this)) {
            FaqToastUtils.makeText(this, getResources().getString(R$string.feedback_sdk_no_network));
            imageView2.setVisibility(0);
        } else if (!MimeType.isVideoFromUrl(str) || NetworkUtils.isWifiConnected(this)) {
            this.f39708F.m52833e(str, m52891M0(imageView, relativeLayout, relativeLayout2, imageView2), str2, SdkProblemManager.getSdk().getSdk("accessToken"));
        } else {
            m52892P0(str, str2, relativeLayout, relativeLayout2, imageView, imageView2, j10);
        }
    }

    @Override // com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter.InterfaceC8458f
    /* renamed from: q */
    public void mo52603q(C8472c c8472c) throws Throwable {
        m52893Q0("0", false, c8472c);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c
    public void setErrorView(FaqConstants.FaqErrorCode faqErrorCode) throws Throwable {
        FaqConstants.FaqErrorCode faqErrorCode2 = FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR;
        if (faqErrorCode2.equals(faqErrorCode)) {
            this.f39710H.m53144h(faqErrorCode2, R$drawable.feedback_sdk_ic_no_search_result);
            this.f39710H.m53143g(faqErrorCode2);
            this.f39710H.m53151s(faqErrorCode2, getResources().getDimensionPixelOffset(R$dimen.feedback_sdk_loading_empty_icon_size));
            this.f39710H.setShouldHideContactUsButton(true);
            this.f39710H.getNoticeTextView().setText(getResources().getString(R$string.faq_sdk_data_error_text));
        } else {
            this.f39710H.m53143g(faqErrorCode);
        }
        this.f39710H.setEnabled(true);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c
    public void setThrowableView(Throwable th2) throws Throwable {
        this.f39710H.m53147l(th2);
        this.f39710H.setEnabled(true);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c
    /* renamed from: u */
    public void mo52776u(C8472c c8472c) throws Throwable {
        c8472c.m52641h().setEnabled(true);
        c8472c.m52635b().setEnabled(true);
        FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_common_server_disconnected));
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c
    /* renamed from: x */
    public void mo52777x(boolean z10, C8472c c8472c) throws Throwable {
        TextView textViewM52647o;
        Resources resources;
        int i10;
        if (c8472c.m52644l() == 0) {
            try {
                this.f39709G.m53157E(0).setScore(c8472c.m52646n());
            } catch (Exception e10) {
                FaqLogger.m51840e("FeedDetailsActivity", e10.getMessage());
            }
        }
        c8472c.m52648p().setVisibility(0);
        if (z10) {
            c8472c.m52635b().setVisibility(8);
            c8472c.m52641h().setImageResource(R$drawable.feedback_sdk_ic_comment_useful_gray);
            textViewM52647o = c8472c.m52647o();
            resources = getResources();
            i10 = R$string.feedback_sdk_question_details_evalua_yes;
        } else {
            c8472c.m52641h().setVisibility(8);
            c8472c.m52635b().setImageResource(R$drawable.feedback_sdk_ic_comment_useless_gray);
            textViewM52647o = c8472c.m52647o();
            resources = getResources();
            i10 = R$string.feedback_sdk_question_details_evalua_no;
        }
        textViewM52647o.setText(resources.getString(i10));
    }

    @Override // com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter.InterfaceC8458f
    /* renamed from: y */
    public void mo52604y(C8472c c8472c) throws Throwable {
        m52893Q0("1", true, c8472c);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8501c
    /* renamed from: a */
    public void mo52774a(List<FeedBackResponse.ProblemEnity> list) {
        ArrayList arrayList = new ArrayList();
        this.f39710H.setVisibility(8);
        FeedBackResponse.ProblemEnity problemEnity = this.f39711I;
        if (problemEnity != null) {
            arrayList.add(problemEnity);
        }
        arrayList.addAll(list);
        this.f39709G.m53163K(arrayList);
    }

    @Override // com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter.InterfaceC8458f
    /* renamed from: a */
    public void mo52601a(List<MediaItem> list, int i10) throws Throwable {
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        m52743C0(list.get(i10));
    }
}
