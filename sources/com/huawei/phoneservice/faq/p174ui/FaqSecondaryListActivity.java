package com.huawei.phoneservice.faq.p174ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huawei.phoneservice.faq.FaqBaseActivity;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.adapter.FaqSecondaryListAdapter;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLanguageUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqOnDoubleClickUtil;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.p174ui.C8407b;
import com.huawei.phoneservice.faq.p174ui.ViewOnClickListenerC8408c;
import com.huawei.phoneservice.faq.response.C8342b;
import com.huawei.phoneservice.faq.response.FaqFastServicesResponse;
import com.huawei.phoneservice.faq.response.FaqIpccBean;
import com.huawei.phoneservice.faq.utils.C8413c;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqNoMoreDrawable;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import com.huawei.phoneservice.faq.widget.FaqSdkSearchInput;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqKnowledgeRequest;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqSecondaryListActivity extends FaqBaseActivity implements FaqSdkSearchInput.InterfaceC8432c, ViewOnClickListenerC8408c.g, C8407b.c {

    /* renamed from: D */
    public ListView f39076D;

    /* renamed from: E */
    public FaqNoticeView f39077E;

    /* renamed from: F */
    public View f39078F;

    /* renamed from: H */
    public String f39080H;

    /* renamed from: J */
    public String f39082J;

    /* renamed from: K */
    public String f39083K;

    /* renamed from: L */
    public String f39084L;

    /* renamed from: M */
    public String f39085M;

    /* renamed from: N */
    public String f39086N;

    /* renamed from: O */
    public String f39087O;

    /* renamed from: P */
    public String f39088P;

    /* renamed from: Q */
    public String f39089Q;

    /* renamed from: R */
    public String f39090R;

    /* renamed from: S */
    public String f39091S;

    /* renamed from: T */
    public String f39092T;

    /* renamed from: U */
    public String f39093U;

    /* renamed from: V */
    public String f39094V;

    /* renamed from: W */
    public String f39095W;

    /* renamed from: X */
    public String f39096X;

    /* renamed from: Y */
    public FaqNoMoreDrawable f39097Y;

    /* renamed from: a0 */
    public int f39099a0;

    /* renamed from: b0 */
    public View f39100b0;

    /* renamed from: c0 */
    public String f39101c0;

    /* renamed from: d0 */
    public String f39102d0;

    /* renamed from: e0 */
    public String f39103e0;

    /* renamed from: f0 */
    public FaqSdkSearchInput f39104f0;

    /* renamed from: g0 */
    public LinearLayout f39105g0;

    /* renamed from: h0 */
    public Intent f39106h0;

    /* renamed from: j0 */
    public ViewOnClickListenerC8408c f39108j0;

    /* renamed from: k0 */
    public C8407b f39109k0;

    /* renamed from: l0 */
    public Fragment f39110l0;

    /* renamed from: m0 */
    public AbstractC0735a0 f39111m0;

    /* renamed from: n0 */
    public EditText f39112n0;

    /* renamed from: A */
    public String f39073A = "1";

    /* renamed from: B */
    public String f39074B = "20";

    /* renamed from: C */
    public String f39075C = "2";

    /* renamed from: G */
    public FaqSecondaryListAdapter f39079G = new FaqSecondaryListAdapter(this);

    /* renamed from: I */
    public String f39081I = null;

    /* renamed from: Z */
    public int f39098Z = 0;

    /* renamed from: i0 */
    public Handler f39107i0 = new Handler();

    /* renamed from: o0 */
    public FaqNoticeView.InterfaceC8428b f39113o0 = new C8390a();

    /* renamed from: p0 */
    public FaqSdkSearchInput.InterfaceC8433d f39114p0 = new C8391b();

    /* renamed from: q0 */
    public Runnable f39115q0 = new RunnableC8392c();

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSecondaryListActivity$a */
    public class C8390a implements FaqNoticeView.InterfaceC8428b {
        public C8390a() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqNoticeView.InterfaceC8428b
        /* renamed from: a */
        public void mo52087a() throws Throwable {
            FaqSecondaryListActivity.this.m52236M0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSecondaryListActivity$b */
    public class C8391b implements FaqSdkSearchInput.InterfaceC8433d {
        public C8391b() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52088a() {
            FaqSecondaryListActivity faqSecondaryListActivity;
            Fragment fragment;
            String str;
            List<String> listM52380b = C8414d.m52380b(FaqSecondaryListActivity.this);
            boolean z10 = (ModuleConfigUtils.searchHotEnabled() || ModuleConfigUtils.searchHistoryEnabled()) ? false : true;
            if (FaqSecondaryListActivity.this.f39108j0 != null) {
                if (z10 && FaqCommonUtils.isEmpty(listM52380b)) {
                    FaqSecondaryListActivity.this.f39108j0.m52354O1(false);
                    FaqSecondaryListActivity.this.f39100b0.setVisibility(FaqSecondaryListActivity.this.f39109k0.m52338N1() ? 8 : 0);
                    FaqSecondaryListActivity.this.m52242T0();
                    return;
                }
                FaqSecondaryListActivity.this.f39108j0.m52354O1(true);
                FaqSecondaryListActivity.this.f39105g0.setClickable(true);
                FaqSecondaryListActivity.this.f39105g0.setVisibility(0);
                FaqSecondaryListActivity.this.f39076D.setVisibility(8);
                if (FaqSecondaryListActivity.this.f39110l0 == null || FaqSecondaryListActivity.this.f39110l0 != FaqSecondaryListActivity.this.f39109k0) {
                    faqSecondaryListActivity = FaqSecondaryListActivity.this;
                    fragment = faqSecondaryListActivity.f39108j0;
                    str = "mSearchHistoryFragment";
                } else {
                    FaqSecondaryListActivity.this.f39109k0.m52336K1(true);
                    faqSecondaryListActivity = FaqSecondaryListActivity.this;
                    fragment = faqSecondaryListActivity.f39109k0;
                    str = "mSearchAssociativeFragment";
                }
                faqSecondaryListActivity.m52256s0(fragment, str);
            }
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: b */
        public void mo52090b() {
            if (FaqSecondaryListActivity.this.f39100b0.getVisibility() == 0) {
                FaqSecondaryListActivity.this.f39100b0.setVisibility(8);
            } else {
                FaqSecondaryListActivity.this.f39105g0.setVisibility(8);
                FaqSecondaryListActivity.this.f39076D.setVisibility(0);
            }
            if (FaqSecondaryListActivity.this.f39108j0 != null) {
                FaqSecondaryListActivity.this.f39108j0.m52354O1(false);
            }
            if (FaqSecondaryListActivity.this.f39109k0 != null) {
                FaqSecondaryListActivity.this.f39109k0.m52336K1(false);
            }
            FaqCommonUtils.hideIme(FaqSecondaryListActivity.this);
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52089a(String str) throws Throwable {
            if (FaqStringUtil.isEmpty(str)) {
                FaqSecondaryListActivity faqSecondaryListActivity = FaqSecondaryListActivity.this;
                FaqToastUtils.makeText(faqSecondaryListActivity, faqSecondaryListActivity.getResources().getString(R$string.faq_sdk_search_input_nothing_toast));
                FaqSecondaryListActivity.this.m52240R0();
                FaqCommonUtils.hideIme(FaqSecondaryListActivity.this);
                return;
            }
            if (FaqSecondaryListActivity.this.m52254O0()) {
                FaqSecondaryListActivity.this.m52240R0();
                FaqCommonUtils.hideIme(FaqSecondaryListActivity.this);
            } else {
                FaqSecondaryListActivity.this.m52255c(str);
                C8414d.m52386h(FaqSecondaryListActivity.this, str);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSecondaryListActivity$c */
    public class RunnableC8392c implements Runnable {
        public RunnableC8392c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FaqSecondaryListActivity.this.f39112n0 != null) {
                String strTrim = FaqSecondaryListActivity.this.f39112n0.getText().toString().trim();
                if (FaqSecondaryListActivity.this.f39109k0 == null || strTrim.length() < 2) {
                    return;
                }
                FaqSecondaryListActivity.this.f39109k0.m52335J1(strTrim);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSecondaryListActivity$d */
    public class ViewOnClickListenerC8393d implements View.OnClickListener {
        public ViewOnClickListenerC8393d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqSecondaryListActivity.this.m52238P0();
            FaqOnDoubleClickUtil.conClick(FaqSecondaryListActivity.this.f39077E);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSecondaryListActivity$e */
    public class C8394e implements AbsListView.OnScrollListener {
        public C8394e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && FaqSecondaryListActivity.this.f39098Z < FaqSecondaryListActivity.this.f39099a0) {
                FaqSecondaryListActivity.this.f39076D.addFooterView(FaqSecondaryListActivity.this.f39078F);
                if (TextUtils.isDigitsOnly(FaqSecondaryListActivity.this.f39073A)) {
                    int i11 = Integer.parseInt(FaqSecondaryListActivity.this.f39073A) + 1;
                    FaqSecondaryListActivity.this.f39073A = i11 + "";
                }
                FaqSecondaryListActivity.this.m52238P0();
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSecondaryListActivity$f */
    public class C8395f extends FaqCallback<C8342b> {
        public C8395f(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8342b c8342b) throws Throwable {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("null==error =");
            sb2.append(th2 == null);
            sb2.append(",null==result =");
            sb2.append(c8342b == null);
            FaqLogger.m51836d("FaqSecondaryList", sb2.toString());
            if (th2 == null) {
                FaqSecondaryListActivity.this.f39076D.removeFooterView(FaqSecondaryListActivity.this.f39078F);
                if (c8342b != null && c8342b.m51992b() != null && !c8342b.m51992b().isEmpty()) {
                    if (TextUtils.isDigitsOnly(c8342b.m51991a())) {
                        FaqSecondaryListActivity.this.f39099a0 = Integer.parseInt(c8342b.m51991a());
                    }
                    FaqSecondaryListActivity.this.f39079G.m51721e(c8342b.m51992b());
                    FaqSecondaryListActivity.m52244o0(FaqSecondaryListActivity.this, c8342b.m51992b().size());
                    FaqSecondaryListActivity.this.f39077E.setVisibility(8);
                    if (FaqSecondaryListActivity.this.f39098Z != FaqSecondaryListActivity.this.f39099a0) {
                        return;
                    }
                } else if (FaqSecondaryListActivity.this.f39098Z == 0) {
                    FaqSecondaryListActivity.this.f39077E.m52468g(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
                }
                FaqSecondaryListActivity.this.f39076D.setOverscrollFooter(FaqSecondaryListActivity.this.f39097Y);
                return;
            }
            if (FaqSecondaryListActivity.this.f39098Z != 0) {
                return;
            } else {
                FaqSecondaryListActivity.this.f39077E.m52471k(th2);
            }
            FaqSecondaryListActivity.this.f39077E.setEnabled(true);
        }
    }

    /* renamed from: K0 */
    private void m52234K0() {
        Intent intent = getIntent();
        this.f39106h0 = intent;
        if (intent != null) {
            intent.setExtrasClassLoader(getClassLoader());
            this.f39080H = this.f39106h0.getStringExtra("isoLanguage");
            this.f39081I = this.f39106h0.getStringExtra("emuilanguage");
            this.f39082J = this.f39106h0.getStringExtra("brands");
            this.f39085M = this.f39106h0.getStringExtra("title");
            this.f39083K = this.f39106h0.getStringExtra(FaqConstants.FAQ_CHANNEL);
            this.f39084L = this.f39106h0.getStringExtra("productCategoryCode");
            this.f39088P = this.f39106h0.getStringExtra(FaqConstants.FAQ_LEVEL);
            this.f39089Q = this.f39106h0.getStringExtra("country");
            this.f39086N = this.f39106h0.getStringExtra("accessToken");
            this.f39087O = this.f39106h0.getStringExtra(FaqConstants.FAQ_REFRESH);
            this.f39090R = this.f39106h0.getStringExtra("appVersion");
            this.f39091S = this.f39106h0.getStringExtra(FaqConstants.FAQ_SHASN);
            this.f39092T = this.f39106h0.getStringExtra(FaqConstants.FAQ_ROMVERSION);
            this.f39093U = this.f39106h0.getStringExtra(FaqConstants.FAQ_EMUIVERSION);
            this.f39094V = this.f39106h0.getStringExtra(FaqConstants.FAQ_OSVERSION);
            this.f39095W = this.f39106h0.getStringExtra("countrycode");
            this.f39096X = this.f39106h0.getStringExtra(FaqConstants.FAQ_CALLFUNCTION);
            this.f39101c0 = this.f39106h0.getStringExtra(FaqConstants.FAQ_WECHATID);
            this.f39102d0 = this.f39106h0.getStringExtra(FaqConstants.FAQ_WEIBOID);
            this.f39103e0 = this.f39106h0.getStringExtra(FaqConstants.FAQ_PICID);
        }
    }

    /* renamed from: M0 */
    public void m52236M0() throws Throwable {
        FaqFastServicesResponse.ModuleListBean moduleListBean = new FaqFastServicesResponse.ModuleListBean();
        moduleListBean.m51928d(21);
        moduleListBean.m51929e(FaqConstants.OPEN_TYPE_IN);
        FaqIpccBean faqIpccBean = new FaqIpccBean();
        faqIpccBean.m51945c(this.f39086N);
        faqIpccBean.m51957p(this.f39080H);
        faqIpccBean.m51949g(this.f39083K);
        faqIpccBean.m51956o(this.f39093U);
        faqIpccBean.m51962v(this.f39094V);
        faqIpccBean.m51953l(this.f39095W);
        faqIpccBean.m51951i(this.f39089Q);
        faqIpccBean.m51955n(this.f39088P);
        faqIpccBean.m51947e(this.f39090R);
        faqIpccBean.m51939L(this.f39091S);
        faqIpccBean.m51937I(this.f39092T);
        faqIpccBean.m51961t(this.f39082J);
        faqIpccBean.m51941N(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE));
        faqIpccBean.m51943P(this.f39102d0);
        faqIpccBean.m51942O(this.f39101c0);
        faqIpccBean.m51936A(this.f39103e0);
        faqIpccBean.m51958q(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID));
        faqIpccBean.m51960s(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY));
        faqIpccBean.m51959r(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH));
        C8406a.m52330f(this, moduleListBean, faqIpccBean, this.f39096X);
        FaqTrack.event(this.f39083K + "+SDK", "Click on Contact us", "contact us");
    }

    /* renamed from: P0 */
    public void m52238P0() {
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            this.f39077E.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            this.f39077E.setEnabled(true);
            this.f39076D.removeFooterView(this.f39078F);
        } else {
            if (this.f39098Z == 0) {
                this.f39077E.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
                this.f39077E.setEnabled(false);
            }
            FaqKnowledgeRequest faqKnowledgeRequest = new FaqKnowledgeRequest();
            m52257u0(faqKnowledgeRequest);
            SdkFaqCommonManager.INSTANCE.getFAQKnowledge(this, faqKnowledgeRequest, new C8395f(C8342b.class, this));
        }
    }

    /* renamed from: R0 */
    public void m52240R0() {
        this.f39105g0.setVisibility(8);
        this.f39076D.setVisibility(0);
        this.f39100b0.setVisibility(8);
        this.f39112n0.setText("");
        this.f39112n0.clearFocus();
        this.f39100b0.setVisibility(8);
        this.f39108j0.m52354O1(false);
        this.f39109k0.m52336K1(false);
        this.f39104f0.getTextViewCancel().setVisibility(8);
    }

    /* renamed from: T0 */
    public void m52242T0() {
        C8407b c8407b;
        Fragment fragment = this.f39110l0;
        if (fragment == null || fragment != (c8407b = this.f39109k0)) {
            return;
        }
        c8407b.m52336K1(true);
        m52256s0(this.f39109k0, "mSearchAssociativeFragment");
    }

    /* renamed from: b */
    private void m52243b(String str) {
        FragmentManager fragmentManagerM4473U = m4473U();
        Fragment fragmentM4571i0 = (TextUtils.isEmpty(str) || fragmentManagerM4473U == null) ? null : fragmentManagerM4473U.m4571i0(str);
        if (fragmentM4571i0 == null || fragmentManagerM4473U == null) {
            return;
        }
        fragmentManagerM4473U.m4585o().mo4655q(fragmentM4571i0).mo4648i();
    }

    /* renamed from: o0 */
    public static /* synthetic */ int m52244o0(FaqSecondaryListActivity faqSecondaryListActivity, int i10) {
        int i11 = faqSecondaryListActivity.f39098Z + i10;
        faqSecondaryListActivity.f39098Z = i11;
        return i11;
    }

    /* renamed from: q0 */
    private void m52246q0(int i10, int i11) {
        this.f39100b0.setVisibility(i10);
        this.f39076D.setVisibility(i10);
        this.f39105g0.setVisibility(i11);
    }

    /* renamed from: r0 */
    public static void m52247r0(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) FaqSecondaryListActivity.class);
        intent.putExtra("isoLanguage", SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ISOLANGUAGE));
        intent.putExtra("emuilanguage", SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE));
        intent.putExtra("title", str);
        intent.putExtra("countrycode", SdkFaqManager.getSdk().getSdk("countryCode"));
        intent.putExtra(FaqConstants.FAQ_LANGUAGE, str2);
        intent.putExtra(FaqConstants.FAQ_CHANNEL, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        intent.putExtra("productCategoryCode", str3);
        intent.putExtra("country", SdkFaqManager.getSdk().getSdk("country"));
        intent.putExtra("brands", SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_MODEL));
        intent.putExtra(FaqConstants.FAQ_LEVEL, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LEVEL));
        intent.putExtra("accessToken", SdkFaqManager.getSdk().getSdk("accessToken"));
        intent.putExtra(FaqConstants.FAQ_REFRESH, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_REFRESH));
        intent.putExtra("appVersion", SdkFaqManager.getSdk().getSdk("appVersion"));
        intent.putExtra(FaqConstants.FAQ_SHASN, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_SHASN));
        intent.putExtra(FaqConstants.FAQ_ROMVERSION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION));
        intent.putExtra(FaqConstants.FAQ_EMUIVERSION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION));
        intent.putExtra(FaqConstants.FAQ_OSVERSION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_OSVERSION));
        intent.putExtra(FaqConstants.FAQ_CALLFUNCTION, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CALLFUNCTION));
        intent.putExtra(FaqConstants.FAQ_WECHATID, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WECHATID));
        intent.putExtra(FaqConstants.FAQ_WEIBOID, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WEIBOID));
        intent.putExtra(FaqConstants.FAQ_PICID, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_PICID));
        if (context instanceof FaqCategoryActivity) {
            intent.putExtra("IsFromCategory", true);
        }
        context.startActivity(intent);
    }

    @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8432c
    /* renamed from: A */
    public void mo52070A(EditText editText) {
        if (ModuleConfigUtils.searchRemindEnabled()) {
            if (editText.getText().toString().trim().length() >= 2) {
                Runnable runnable = this.f39115q0;
                if (runnable != null) {
                    this.f39107i0.removeCallbacks(runnable);
                }
                this.f39107i0.postDelayed(this.f39115q0, 500L);
                return;
            }
            C8407b c8407b = this.f39109k0;
            if (c8407b != null) {
                c8407b.m52337M1();
            }
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: O0 */
    public final boolean m52254O0() throws Throwable {
        if (this.f39112n0.getText().toString().trim().length() >= 2) {
            return false;
        }
        FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_search_input_word_limits, 2));
        return true;
    }

    @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8432c
    /* renamed from: a */
    public void mo52075a(int i10) throws Throwable {
        Fragment fragment;
        String str;
        FaqLogger.m51840e("FaqSecondaryList", "length>>>>>" + i10);
        if (ModuleConfigUtils.searchRemindEnabled()) {
            if (i10 >= 2) {
                if (this.f39100b0.getVisibility() == 0) {
                    this.f39105g0.setClickable(true);
                    m52246q0(8, 0);
                }
                this.f39109k0.m52336K1(true);
                fragment = this.f39109k0;
                str = "mSearchAssociativeFragment";
            } else if (!this.f39108j0.m52357Y1()) {
                m52246q0(0, 8);
                return;
            } else {
                fragment = this.f39108j0;
                str = "mSearchHistoryFragment";
            }
            m52256s0(fragment, str);
        }
    }

    /* renamed from: c */
    public void m52255c(String str) {
        String str2;
        FaqSearchActivity.m52210q0(this, this.f39080H, this.f39081I, this.f39095W, this.f39083K, this.f39084L, this.f39089Q, this.f39082J, this.f39088P, this.f39086N, this.f39087O, this.f39090R, this.f39091S, this.f39092T, this.f39093U, this.f39094V, this.f39096X, this.f39101c0, this.f39102d0, this.f39103e0, str);
        C8413c c8413cM52372a = C8413c.m52372a();
        if (FaqConstants.CHANNEL_HICARE.equals(this.f39083K)) {
            str2 = FaqConstants.APP_HICARE;
        } else {
            str2 = "App_" + this.f39083K;
        }
        c8413cM52372a.m52377d(this, "searchClick", str, str2, this.f39089Q, this.f39081I);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Throwable {
        FaqLogger.m51836d("FaqSecondaryList", "initData()");
        this.f39079G.m51739y(this.f39080H);
        this.f39079G.m51717R(this.f39081I);
        this.f39079G.m51731q(this.f39083K);
        this.f39079G.m51725k(this.f39082J);
        this.f39079G.m51733s(this.f39089Q);
        this.f39079G.m51700A(this.f39088P);
        this.f39079G.m51720d(this.f39086N);
        this.f39079G.m51706G(this.f39087O);
        this.f39079G.m51723h(this.f39090R);
        this.f39079G.m51710K(this.f39091S);
        this.f39079G.m51708I(this.f39092T);
        this.f39079G.m51737w(this.f39093U);
        this.f39079G.m51702C(this.f39094V);
        this.f39079G.m51735u(this.f39095W);
        this.f39079G.m51727m(this.f39096X);
        this.f39079G.m51729o(this.f39085M);
        this.f39079G.m51714O(this.f39101c0);
        this.f39079G.m51716Q(this.f39102d0);
        this.f39079G.m51704E(this.f39103e0);
        this.f39077E.setVisibility(8);
        m52238P0();
        this.f39079G.m51712M(this.f39085M);
        this.f39076D.setAdapter((ListAdapter) this.f39079G);
        setTitle(this.f39085M);
        this.f39108j0 = new ViewOnClickListenerC8408c();
        C8407b c8407b = new C8407b();
        this.f39109k0 = c8407b;
        c8407b.m52334I1(this);
        this.f39108j0.m52352J1(this);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_activity_faq_secondary_list_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        this.f39104f0.setOnclick(this.f39114p0);
        this.f39077E.setOnClickListener(new ViewOnClickListenerC8393d());
        this.f39076D.setOnScrollListener(new C8394e());
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        this.f39076D = (ListView) findViewById(R$id.lv_fault_list);
        this.f39077E = (FaqNoticeView) findViewById(R$id.notice_view);
        this.f39105g0 = (LinearLayout) findViewById(R$id.faq_sdk_mask);
        this.f39100b0 = findViewById(R$id.view_floating_layer);
        FaqSdkSearchInput faqSdkSearchInput = (FaqSdkSearchInput) findViewById(R$id.faq_sdk_searchinput);
        this.f39104f0 = faqSdkSearchInput;
        faqSdkSearchInput.setOnClick(this);
        if (!ModuleConfigUtils.searchViewEnabled()) {
            this.f39104f0.setVisibility(8);
        }
        this.f39077E.setCallback(this.f39113o0);
        this.f39077E.setEnabled(false);
        this.f39078F = LayoutInflater.from(this).inflate(R$layout.faq_sdk_footer_layout, (ViewGroup) this.f39076D, false);
        m52243b("mSearchHistoryFragment");
        m52243b("mSearchAssociativeFragment");
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != getResources().getConfiguration().orientation) {
            FaqLanguageUtils.changeAppLanguage(this, this.f39080H, this.f39089Q, configuration);
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        m52234K0();
        this.f39097Y = new FaqNoMoreDrawable(this);
        super.onCreate(bundle);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f39109k0 != null) {
            this.f39109k0 = null;
        }
        if (this.f39108j0 != null) {
            this.f39108j0 = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f39112n0 = this.f39104f0.getEditTextContent();
        m52240R0();
    }

    /* renamed from: s0 */
    public void m52256s0(Fragment fragment, String str) {
        AbstractC0735a0 abstractC0735a0Mo4657v;
        AbstractC0735a0 abstractC0735a0Mo4653o;
        Fragment fragment2 = this.f39110l0;
        if (fragment2 != null) {
            if (fragment2 != fragment) {
                this.f39111m0 = m4473U().m4585o();
                if (fragment.m4379X()) {
                    abstractC0735a0Mo4657v = this.f39111m0.mo4653o(this.f39110l0).mo4657v(fragment);
                    abstractC0735a0Mo4657v.mo4648i();
                } else {
                    abstractC0735a0Mo4653o = this.f39111m0.mo4653o(this.f39110l0);
                }
            }
            this.f39110l0 = fragment;
        }
        abstractC0735a0Mo4653o = m4473U().m4585o();
        this.f39111m0 = abstractC0735a0Mo4653o;
        abstractC0735a0Mo4657v = abstractC0735a0Mo4653o.m4663c(R$id.faq_sdk_mask, fragment, str);
        abstractC0735a0Mo4657v.mo4648i();
        this.f39110l0 = fragment;
    }

    /* renamed from: u0 */
    public void m52257u0(FaqKnowledgeRequest faqKnowledgeRequest) {
        faqKnowledgeRequest.setCountriesCode(this.f39089Q);
        faqKnowledgeRequest.setLanguageCode(this.f39081I);
        faqKnowledgeRequest.setChannel(m51648n0());
        faqKnowledgeRequest.setProductCode(this.f39084L);
        faqKnowledgeRequest.setPageSize(this.f39074B);
        faqKnowledgeRequest.setPageNum(this.f39073A);
        faqKnowledgeRequest.setDefaultCountry(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_COUNTRY));
        faqKnowledgeRequest.setDefaultLanguage(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_LANGUAGE));
    }

    @Override // com.huawei.phoneservice.faq.p174ui.ViewOnClickListenerC8408c.g
    /* renamed from: a */
    public void mo52076a(String str, String str2) throws Throwable {
        if (FaqStringUtil.isEmpty(str)) {
            FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_search_input_nothing_toast));
        } else {
            m52255c(str);
            C8414d.m52386h(this, str);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.C8407b.c
    /* renamed from: b */
    public void mo52077b(String str, String str2) {
        if (m52254O0()) {
            return;
        }
        m52255c(str);
        C8414d.m52386h(this, str);
    }
}
