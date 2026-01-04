package com.huawei.phoneservice.faq.p174ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huawei.phoneservice.faq.FaqBaseActivity;
import com.huawei.phoneservice.faq.R$dimen;
import com.huawei.phoneservice.faq.R$drawable;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.adapter.C8288b;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.response.C8345e;
import com.huawei.phoneservice.faq.response.C8347g;
import com.huawei.phoneservice.faq.response.FaqFastServicesResponse;
import com.huawei.phoneservice.faq.response.FaqIpccBean;
import com.huawei.phoneservice.faq.response.FaqKnowSearchDetail;
import com.huawei.phoneservice.faq.utils.C8411a;
import com.huawei.phoneservice.faq.utils.C8413c;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqFootOverScrollListView;
import com.huawei.phoneservice.faq.widget.FaqNoMoreDrawable;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import com.huawei.phoneservice.faq.widget.FaqSdkSearchInput;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqSearchRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqSearchActivity extends FaqBaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public FaqFootOverScrollListView f39032A;

    /* renamed from: B */
    public FaqNoticeView f39033B;

    /* renamed from: C */
    public View f39034C;

    /* renamed from: D */
    public FaqNoMoreDrawable f39035D;

    /* renamed from: E */
    public C8288b f39036E;

    /* renamed from: F */
    public String f39037F;

    /* renamed from: H */
    public String f39039H;

    /* renamed from: I */
    public String f39040I;

    /* renamed from: J */
    public String f39041J;

    /* renamed from: K */
    public String f39042K;

    /* renamed from: L */
    public String f39043L;

    /* renamed from: M */
    public String f39044M;

    /* renamed from: N */
    public String f39045N;

    /* renamed from: O */
    public String f39046O;

    /* renamed from: P */
    public String f39047P;

    /* renamed from: Q */
    public String f39048Q;

    /* renamed from: R */
    public String f39049R;

    /* renamed from: S */
    public String f39050S;

    /* renamed from: T */
    public String f39051T;

    /* renamed from: U */
    public String f39052U;

    /* renamed from: V */
    public String f39053V;

    /* renamed from: W */
    public String f39054W;

    /* renamed from: X */
    public String f39055X;

    /* renamed from: Y */
    public String f39056Y;

    /* renamed from: a0 */
    public String f39058a0;

    /* renamed from: c0 */
    public int f39060c0;

    /* renamed from: d0 */
    public FaqSdkSearchInput f39061d0;

    /* renamed from: e0 */
    public EditText f39062e0;

    /* renamed from: G */
    public String f39038G = null;

    /* renamed from: Z */
    public int f39057Z = 1;

    /* renamed from: b0 */
    public int f39059b0 = 0;

    /* renamed from: f0 */
    public FaqNoticeView.InterfaceC8428b f39063f0 = new C8385a();

    /* renamed from: g0 */
    public FaqSdkSearchInput.InterfaceC8433d f39064g0 = new C8386b();

    /* renamed from: h0 */
    public AbsListView.OnScrollListener f39065h0 = new C8387c();

    /* renamed from: i0 */
    public AdapterView.OnItemClickListener f39066i0 = new C8388d();

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSearchActivity$a */
    public class C8385a implements FaqNoticeView.InterfaceC8428b {
        public C8385a() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqNoticeView.InterfaceC8428b
        /* renamed from: a */
        public void mo52087a() throws Throwable {
            FaqSearchActivity.this.m52196W0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSearchActivity$b */
    public class C8386b implements FaqSdkSearchInput.InterfaceC8433d {
        public C8386b() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52088a() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: b */
        public void mo52090b() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52089a(String str) throws Throwable {
            if (FaqStringUtil.isEmpty(str)) {
                FaqSearchActivity.this.m52198Y0();
                FaqCommonUtils.hideIme(FaqSearchActivity.this);
                FaqSearchActivity faqSearchActivity = FaqSearchActivity.this;
                FaqToastUtils.makeText(faqSearchActivity, faqSearchActivity.getResources().getString(R$string.faq_sdk_search_input_nothing_toast));
                return;
            }
            if (FaqSearchActivity.this.m52217E0(str)) {
                FaqSearchActivity.this.m52198Y0();
                FaqCommonUtils.hideIme(FaqSearchActivity.this);
                return;
            }
            FaqSearchActivity.this.f39058a0 = str;
            FaqSearchActivity.this.f39057Z = 1;
            FaqSearchActivity.this.mo51677f();
            FaqSearchActivity.this.f39036E.setResource(null);
            FaqSearchActivity.this.f39036E.notifyDataSetChanged();
            C8413c c8413cM52372a = C8413c.m52372a();
            FaqSearchActivity faqSearchActivity2 = FaqSearchActivity.this;
            c8413cM52372a.m52377d(faqSearchActivity2, "searchClick", str, faqSearchActivity2.f39056Y, FaqSearchActivity.this.f39045N, FaqSearchActivity.this.f39038G);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSearchActivity$c */
    public class C8387c implements AbsListView.OnScrollListener {
        public C8387c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) throws Throwable {
            if (!FaqSearchActivity.this.m52216C0(i10) || FaqSearchActivity.this.f39057Z > FaqSearchActivity.this.f39060c0) {
                return;
            }
            FaqSearchActivity.this.m52200a1();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSearchActivity$d */
    public class C8388d implements AdapterView.OnItemClickListener {
        public C8388d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) throws Throwable {
            FaqKnowSearchDetail faqKnowSearchDetail;
            if (NoDoubleClickUtil.isDoubleClick(view) || (faqKnowSearchDetail = (FaqKnowSearchDetail) adapterView.getAdapter().getItem(i10)) == null) {
                return;
            }
            FaqSearchActivity faqSearchActivity = FaqSearchActivity.this;
            FaqQuestionDetailActivity.m52169z0(faqSearchActivity, faqSearchActivity.f39037F, FaqSearchActivity.this.f39038G, faqKnowSearchDetail.m51976n(), faqKnowSearchDetail.m51978p(), FaqSearchActivity.this.f39039H, faqKnowSearchDetail.m51974l(), FaqSearchActivity.this.f39045N, FaqSearchActivity.this.f39044M, FaqSearchActivity.this.f39042K, FaqSearchActivity.this.f39043L, FaqSearchActivity.this.f39040I, FaqSearchActivity.this.f39050S, FaqSearchActivity.this.f39051T, FaqSearchActivity.this.f39046O, FaqSearchActivity.this.f39047P, FaqSearchActivity.this.f39048Q, FaqSearchActivity.this.f39049R, FaqSearchActivity.this.f39052U, true, FaqSearchActivity.this.f39053V, FaqSearchActivity.this.f39054W, FaqSearchActivity.this.f39055X, null);
            C8413c c8413cM52372a = C8413c.m52372a();
            FaqSearchActivity faqSearchActivity2 = FaqSearchActivity.this;
            c8413cM52372a.m52375b(faqSearchActivity2, faqKnowSearchDetail, i10, faqSearchActivity2.f39056Y, FaqSearchActivity.this.f39045N);
            FaqTrack.event(FaqSearchActivity.this.f39040I + "+SDK+Search", "Click", faqKnowSearchDetail.m51976n());
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqSearchActivity$e */
    public class C8389e extends FaqCallback<C8347g> {

        /* renamed from: d */
        public final /* synthetic */ FaqSearchRequest f39071d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8389e(Class cls, Activity activity, FaqSearchRequest faqSearchRequest) {
            super(cls, activity);
            this.f39071d = faqSearchRequest;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8347g c8347g) throws Throwable {
            if (th2 != null) {
                FaqSearchActivity.this.f39033B.m52471k(th2);
                return;
            }
            if (c8347g != null) {
                JsonObject jsonObjectM52007a = c8347g.m52008a().m52007a();
                if (jsonObjectM52007a != null) {
                    FaqSearchActivity.this.m52219s0(jsonObjectM52007a, this.f39071d.getQ());
                    return;
                }
                FaqLogger.print("FaqSearchActivity", "startSearch getSearchServiceHitsResponse is null...");
            }
            FaqSearchActivity.this.m52192S0();
        }
    }

    /* renamed from: S0 */
    public void m52192S0() throws Throwable {
        if (this.f39057Z != 1) {
            this.f39033B.setVisibility(8);
            this.f39032A.setVisibility(0);
            FaqToastUtils.makeText(this, getString(R$string.faq_sdk_common_load_data_error_text_try_again_toast));
            return;
        }
        FaqNoticeView faqNoticeView = this.f39033B;
        FaqConstants.FaqErrorCode faqErrorCode = FaqConstants.FaqErrorCode.LOAD_DATA_ERROR;
        faqNoticeView.m52469h(faqErrorCode, R$drawable.faq_sdk_ic_no_search_result);
        this.f39033B.m52468g(faqErrorCode);
        this.f39033B.m52475r(faqErrorCode, getResources().getDimensionPixelOffset(R$dimen.faq_sdk_loading_error_icon_size));
        this.f39033B.setShouldHideContactUsButton(true);
        this.f39033B.getNoticeTextView().setText(getResources().getString(R$string.faq_sdk_load_data_empty_search));
    }

    /* renamed from: U0 */
    private void m52194U0() {
        String str;
        Intent intent = getIntent();
        if (intent != null) {
            this.f39037F = intent.getStringExtra("isoLanguage");
            this.f39038G = intent.getStringExtra("emuilanguage");
            this.f39049R = intent.getStringExtra("countrycode");
            this.f39040I = intent.getStringExtra(FaqConstants.FAQ_CHANNEL);
            this.f39041J = intent.getStringExtra("productCategoryCode");
            this.f39045N = intent.getStringExtra("country");
            this.f39039H = intent.getStringExtra("brands");
            this.f39044M = intent.getStringExtra(FaqConstants.FAQ_LEVEL);
            this.f39042K = intent.getStringExtra("accessToken");
            this.f39043L = intent.getStringExtra(FaqConstants.FAQ_REFRESH);
            this.f39050S = intent.getStringExtra("appVersion");
            this.f39051T = intent.getStringExtra(FaqConstants.FAQ_SHASN);
            this.f39046O = intent.getStringExtra(FaqConstants.FAQ_ROMVERSION);
            this.f39047P = intent.getStringExtra(FaqConstants.FAQ_EMUIVERSION);
            this.f39048Q = intent.getStringExtra(FaqConstants.FAQ_OSVERSION);
            this.f39052U = intent.getStringExtra(FaqConstants.FAQ_CALLFUNCTION);
            this.f39053V = intent.getStringExtra(FaqConstants.FAQ_WECHATID);
            this.f39054W = intent.getStringExtra(FaqConstants.FAQ_WEIBOID);
            this.f39055X = intent.getStringExtra(FaqConstants.FAQ_PICID);
            this.f39058a0 = intent.getStringExtra("FAQ_SEARCH");
            if (FaqConstants.CHANNEL_HICARE.equals(this.f39040I)) {
                str = FaqConstants.APP_HICARE;
            } else {
                str = "App_" + this.f39040I;
            }
            this.f39056Y = str;
        }
    }

    /* renamed from: W0 */
    public void m52196W0() throws Throwable {
        FaqFastServicesResponse.ModuleListBean moduleListBean = new FaqFastServicesResponse.ModuleListBean();
        moduleListBean.m51928d(21);
        moduleListBean.m51929e(FaqConstants.OPEN_TYPE_IN);
        FaqIpccBean faqIpccBean = new FaqIpccBean();
        faqIpccBean.m51947e(this.f39050S);
        faqIpccBean.m51939L(this.f39051T);
        faqIpccBean.m51937I(this.f39046O);
        faqIpccBean.m51961t(this.f39039H);
        faqIpccBean.m51956o(this.f39047P);
        faqIpccBean.m51962v(this.f39048Q);
        faqIpccBean.m51953l(this.f39049R);
        faqIpccBean.m51945c(this.f39042K);
        faqIpccBean.m51957p(this.f39037F);
        faqIpccBean.m51949g(this.f39040I);
        faqIpccBean.m51951i(this.f39045N);
        faqIpccBean.m51941N(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE));
        faqIpccBean.m51955n(this.f39044M);
        faqIpccBean.m51942O(this.f39053V);
        faqIpccBean.m51943P(this.f39054W);
        faqIpccBean.m51936A(this.f39055X);
        faqIpccBean.m51958q(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID));
        faqIpccBean.m51960s(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY));
        faqIpccBean.m51959r(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH));
        C8406a.m52330f(this, moduleListBean, faqIpccBean, this.f39052U);
        FaqTrack.event(this.f39040I + "+SDK", "Click on Contact us", "contact us");
    }

    /* renamed from: Y0 */
    public void m52198Y0() {
        EditText editText = this.f39062e0;
        if (editText != null) {
            editText.setText("");
            this.f39062e0.clearFocus();
            this.f39061d0.getTextViewCancel().setVisibility(8);
        }
    }

    /* renamed from: a1 */
    public void m52200a1() throws Throwable {
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            if (this.f39057Z == 1) {
                this.f39033B.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
                return;
            } else {
                FaqToastUtils.makeText(this, getString(R$string.faq_sdk_no_network_toast));
                return;
            }
        }
        if (this.f39057Z != 1) {
            this.f39032A.setOverscrollFooter(null);
            this.f39032A.addFooterView(this.f39034C);
        } else {
            FaqCommonUtils.hideIme(this);
            FaqTrack.event(this.f39040I + "+SDK+Search", "Click", this.f39058a0);
        }
        FaqSearchRequest faqSearchRequest = new FaqSearchRequest();
        m52222x0(faqSearchRequest);
        SdkFaqCommonManager.INSTANCE.getSearchData(this, faqSearchRequest, new C8389e(C8347g.class, this, faqSearchRequest));
        C8414d.m52386h(this, this.f39058a0);
    }

    /* renamed from: q0 */
    public static void m52210q0(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        Intent intent = new Intent(context, (Class<?>) FaqSearchActivity.class);
        intent.putExtra("isoLanguage", str);
        intent.putExtra("emuilanguage", str2);
        intent.putExtra("countrycode", str3);
        intent.putExtra(FaqConstants.FAQ_CHANNEL, str4);
        intent.putExtra("accessToken", str9);
        intent.putExtra("productCategoryCode", str5);
        intent.putExtra("country", str6);
        intent.putExtra("brands", str7);
        intent.putExtra(FaqConstants.FAQ_LEVEL, str8);
        intent.putExtra(FaqConstants.FAQ_EMUIVERSION, str14);
        intent.putExtra(FaqConstants.FAQ_REFRESH, str10);
        intent.putExtra("appVersion", str11);
        intent.putExtra(FaqConstants.FAQ_PICID, str19);
        intent.putExtra(FaqConstants.FAQ_SHASN, str12);
        intent.putExtra(FaqConstants.FAQ_ROMVERSION, str13);
        intent.putExtra(FaqConstants.FAQ_OSVERSION, str15);
        intent.putExtra(FaqConstants.FAQ_CALLFUNCTION, str16);
        intent.putExtra(FaqConstants.FAQ_WECHATID, str17);
        intent.putExtra(FaqConstants.FAQ_WEIBOID, str18);
        intent.putExtra("FAQ_SEARCH", str20);
        context.startActivity(intent);
    }

    /* renamed from: A0 */
    public final void m52215A0(C8345e c8345e) throws Throwable {
        this.f39060c0 = c8345e.m52005d();
        List<FaqKnowSearchDetail> listM52002a = c8345e.m52002a();
        if (listM52002a == null || listM52002a.size() <= 0) {
            m52192S0();
        } else {
            m52221u0(c8345e);
            C8413c.m52372a().m52378e(this, listM52002a, this.f39056Y, this.f39045N);
        }
    }

    /* renamed from: C0 */
    public final boolean m52216C0(int i10) {
        return i10 == 0 && this.f39036E != null && this.f39032A.getLastVisiblePosition() == this.f39036E.getCount() - 1;
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: E0 */
    public final boolean m52217E0(String str) throws Throwable {
        if (str == null || str.length() >= 2) {
            return false;
        }
        FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_search_input_word_limits, 2));
        return true;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Throwable {
        setTitle(getResources().getString(R$string.faq_sdk_search_title));
        this.f39033B.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
        C8288b c8288b = new C8288b();
        this.f39036E = c8288b;
        this.f39032A.setAdapter((ListAdapter) c8288b);
        m52200a1();
        this.f39061d0.setSearchInput(this.f39058a0);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_activity_search_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        this.f39033B.setOnClickListener(this);
        this.f39061d0.setOnclick(this.f39064g0);
        this.f39032A.setOnScrollListener(this.f39065h0);
        this.f39032A.setOnItemClickListener(this.f39066i0);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        FaqNoticeView faqNoticeView = (FaqNoticeView) findViewById(R$id.faq_sdk_search_noticeview);
        this.f39033B = faqNoticeView;
        faqNoticeView.setCallback(this.f39063f0);
        this.f39032A = (FaqFootOverScrollListView) findViewById(R$id.faq_sdk_search_content_list);
        this.f39061d0 = (FaqSdkSearchInput) findViewById(R$id.faq_sdk_searchinput);
        this.f39034C = LayoutInflater.from(this).inflate(R$layout.faq_sdk_footer_layout, (ViewGroup) null);
        this.f39035D = new FaqNoMoreDrawable(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!NoDoubleClickUtil.isDoubleClick(view) && view == this.f39033B) {
            mo51677f();
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        m52194U0();
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f39062e0 = this.f39061d0.getEditTextContent();
    }

    /* renamed from: r0 */
    public final void m52218r0(JsonArray jsonArray, List<FaqKnowSearchDetail> list) throws Throwable {
        List[] listArrM52366e;
        for (int i10 = 0; i10 < jsonArray.size(); i10++) {
            if (jsonArray.get(i10).getAsJsonObject().getAsJsonObject("_source").get("knowledge_type_id") != null) {
                FaqKnowSearchDetail faqKnowSearchDetail = new FaqKnowSearchDetail();
                List[] listArrM52366e2 = null;
                if (jsonArray.get(i10).getAsJsonObject().getAsJsonObject("highlight").getAsJsonArray("content") != null) {
                    String asString = jsonArray.get(i10).getAsJsonObject().getAsJsonObject("highlight").getAsJsonArray("content").get(0).getAsString();
                    listArrM52366e = C8411a.m52366e(asString);
                    faqKnowSearchDetail.m51968e(asString.replaceAll("<em>", "").replaceAll("</em>", ""));
                } else {
                    faqKnowSearchDetail.m51968e("");
                    listArrM52366e = null;
                }
                if (jsonArray.get(i10).getAsJsonObject().getAsJsonObject("highlight").getAsJsonArray("title") != null) {
                    String asString2 = jsonArray.get(i10).getAsJsonObject().getAsJsonObject("highlight").getAsJsonArray("title").get(0).getAsString();
                    listArrM52366e2 = C8411a.m52366e(asString2);
                    faqKnowSearchDetail.m51977o(asString2.replaceAll("<em>", "").replaceAll("</em>", ""));
                } else {
                    faqKnowSearchDetail.m51977o("");
                }
                faqKnowSearchDetail.m51973j(jsonArray.get(i10).getAsJsonObject().get("_id").getAsString());
                faqKnowSearchDetail.m51979q(jsonArray.get(i10).getAsJsonObject().getAsJsonObject("_source").get("status_flag").getAsString());
                faqKnowSearchDetail.m51980r(jsonArray.get(i10).getAsJsonObject().getAsJsonObject("_source").get("last_updated_date").getAsString());
                faqKnowSearchDetail.m51975m(jsonArray.get(i10).getAsJsonObject().getAsJsonObject("_source").get("knowledge_type_id").getAsString());
                if (jsonArray.get(i10).getAsJsonObject().toString().contains("interventions") && "1".equals(jsonArray.get(i10).getAsJsonObject().get("interventions").getAsString())) {
                    faqKnowSearchDetail.m51971h("1");
                } else {
                    faqKnowSearchDetail.m51971h("");
                }
                m52220t0(faqKnowSearchDetail, listArrM52366e, listArrM52366e2, list);
                this.f39059b0++;
            }
        }
    }

    /* renamed from: s0 */
    public final void m52219s0(JsonObject jsonObject, String str) throws Throwable {
        JsonArray asJsonArray = jsonObject.getAsJsonArray("hits");
        ArrayList arrayList = new ArrayList();
        m52218r0(asJsonArray, arrayList);
        if (this.f39032A.getFooterViewsCount() > 0) {
            this.f39032A.removeFooterView(this.f39034C);
        }
        if (this.f39057Z != 1 && asJsonArray.size() == 0) {
            this.f39032A.setOverscrollFooter(this.f39035D);
            return;
        }
        C8345e c8345e = new C8345e();
        c8345e.m52004c(arrayList);
        c8345e.m52003b(this.f39057Z);
        try {
            if (jsonObject.get("total") != null) {
                c8345e.m52006e((int) Math.ceil(r5.getAsInt() / 20.0d));
            }
        } catch (ClassCastException | IllegalStateException e10) {
            FaqLogger.m51840e("FaqSearchActivity", "parse total failed. " + e10.getMessage());
        }
        m52215A0(c8345e);
    }

    /* renamed from: t0 */
    public final void m52220t0(FaqKnowSearchDetail faqKnowSearchDetail, List[] listArr, List[] listArr2, List<FaqKnowSearchDetail> list) throws Throwable {
        try {
            list.add(C8411a.m52363b(this, C8411a.m52362a(this, faqKnowSearchDetail, listArr), listArr2, true));
        } catch (Throwable th2) {
            FaqLogger.m51840e("FaqSearchActivity", "Highlight knowLedgeColor failed because of " + th2.getMessage());
            list.add(faqKnowSearchDetail);
        }
    }

    /* renamed from: u0 */
    public final void m52221u0(C8345e c8345e) {
        if (this.f39057Z == 1) {
            this.f39036E.setResource(c8345e.m52002a());
        } else {
            this.f39036E.appendToList(c8345e.m52002a());
        }
        this.f39057Z++;
        this.f39036E.notifyDataSetChanged();
        if (this.f39057Z > this.f39060c0) {
            this.f39032A.setOverscrollFooter(this.f39035D);
        }
        this.f39033B.setVisibility(8);
        this.f39032A.setVisibility(0);
    }

    /* renamed from: x0 */
    public final void m52222x0(FaqSearchRequest faqSearchRequest) {
        faqSearchRequest.setQ(this.f39058a0);
        faqSearchRequest.setSiteCode(null);
        faqSearchRequest.setCountry(this.f39045N);
        faqSearchRequest.setExternal_model(FaqDeviceUtils.getModel());
        faqSearchRequest.setBrand(this.f39039H);
        faqSearchRequest.setqAppName(this.f39056Y);
        faqSearchRequest.setLanguage(this.f39038G);
        faqSearchRequest.setPageNo("" + this.f39057Z);
        faqSearchRequest.setPageSize("20");
        faqSearchRequest.setProduce_f_features(this.f39041J);
        faqSearchRequest.setApplicableRegion(SdkFaqManager.getSdk().getSdk("country"));
        faqSearchRequest.setReleaseChannel(m51648n0());
        faqSearchRequest.setKnowledge_type(null);
    }
}
