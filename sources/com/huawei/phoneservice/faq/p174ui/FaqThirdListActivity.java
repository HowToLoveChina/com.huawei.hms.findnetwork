package com.huawei.phoneservice.faq.p174ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
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
import com.huawei.phoneservice.faq.adapter.FaqExpendListAdapter;
import com.huawei.phoneservice.faq.adapter.FaqThirdListNoSubAdapter;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqOnDoubleClickUtil;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.p174ui.C8407b;
import com.huawei.phoneservice.faq.p174ui.ViewOnClickListenerC8408c;
import com.huawei.phoneservice.faq.response.C8342b;
import com.huawei.phoneservice.faq.response.FaqClassification;
import com.huawei.phoneservice.faq.response.FaqFastServicesResponse;
import com.huawei.phoneservice.faq.response.FaqIpccBean;
import com.huawei.phoneservice.faq.utils.C8413c;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import com.huawei.phoneservice.faq.widget.FaqSdkSearchInput;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqKnowledgeRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class FaqThirdListActivity extends FaqBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, FaqSdkSearchInput.InterfaceC8432c, C8407b.c, ViewOnClickListenerC8408c.g {

    /* renamed from: A */
    public ListView f39142A;

    /* renamed from: B */
    public ExpandableListView f39143B;

    /* renamed from: C */
    public FaqNoticeView f39144C;

    /* renamed from: D */
    public String f39145D;

    /* renamed from: E */
    public String f39146E;

    /* renamed from: F */
    public String f39147F;

    /* renamed from: G */
    public String f39148G;

    /* renamed from: H */
    public String f39149H;

    /* renamed from: I */
    public String f39150I;

    /* renamed from: J */
    public String f39151J;

    /* renamed from: K */
    public String f39152K;

    /* renamed from: L */
    public String f39153L;

    /* renamed from: M */
    public String f39154M;

    /* renamed from: O */
    public String f39156O;

    /* renamed from: P */
    public String f39157P;

    /* renamed from: Q */
    public String f39158Q;

    /* renamed from: R */
    public String f39159R;

    /* renamed from: S */
    public String f39160S;

    /* renamed from: T */
    public String f39161T;

    /* renamed from: U */
    public String f39162U;

    /* renamed from: V */
    public String f39163V;

    /* renamed from: W */
    public String f39164W;

    /* renamed from: X */
    public LinearLayout f39165X;

    /* renamed from: Z */
    public FaqSdkSearchInput f39167Z;

    /* renamed from: a0 */
    public FaqExpendListAdapter f39168a0;

    /* renamed from: f0 */
    public View f39173f0;

    /* renamed from: g0 */
    public ViewOnClickListenerC8408c f39174g0;

    /* renamed from: h0 */
    public C8407b f39175h0;

    /* renamed from: i0 */
    public Fragment f39176i0;

    /* renamed from: k0 */
    public EditText f39178k0;

    /* renamed from: N */
    public String f39155N = null;

    /* renamed from: Y */
    public boolean f39166Y = false;

    /* renamed from: b0 */
    public FaqThirdListNoSubAdapter f39169b0 = new FaqThirdListNoSubAdapter(this);

    /* renamed from: c0 */
    public Map<String, List<C8342b.a>> f39170c0 = new LinkedHashMap();

    /* renamed from: d0 */
    public Map<String, List<C8342b.a>> f39171d0 = new LinkedHashMap();

    /* renamed from: e0 */
    public List<FaqClassification.Classification> f39172e0 = new ArrayList();

    /* renamed from: j0 */
    public Handler f39177j0 = new Handler();

    /* renamed from: l0 */
    public boolean f39179l0 = false;

    /* renamed from: m0 */
    public FaqNoticeView.InterfaceC8428b f39180m0 = new C8398a();

    /* renamed from: n0 */
    public Runnable f39181n0 = new RunnableC8399b();

    /* renamed from: o0 */
    public FaqSdkSearchInput.InterfaceC8433d f39182o0 = new C8400c();

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$a */
    public class C8398a implements FaqNoticeView.InterfaceC8428b {
        public C8398a() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqNoticeView.InterfaceC8428b
        /* renamed from: a */
        public void mo52087a() throws Throwable {
            FaqThirdListActivity.this.m52291a1();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$b */
    public class RunnableC8399b implements Runnable {
        public RunnableC8399b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FaqThirdListActivity.this.f39178k0 != null) {
                String strTrim = FaqThirdListActivity.this.f39178k0.getText().toString().trim();
                if (FaqThirdListActivity.this.f39175h0 == null || strTrim.length() < 2) {
                    return;
                }
                FaqThirdListActivity.this.f39175h0.m52335J1(strTrim);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$c */
    public class C8400c implements FaqSdkSearchInput.InterfaceC8433d {
        public C8400c() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52088a() {
            FaqThirdListActivity faqThirdListActivity;
            Fragment fragment;
            String str;
            List<String> listM52380b = C8414d.m52380b(FaqThirdListActivity.this);
            boolean z10 = (ModuleConfigUtils.searchHotEnabled() || ModuleConfigUtils.searchHistoryEnabled()) ? false : true;
            if (FaqThirdListActivity.this.f39174g0 != null) {
                if (z10 && FaqCommonUtils.isEmpty(listM52380b)) {
                    FaqThirdListActivity.this.f39174g0.m52354O1(false);
                    FaqThirdListActivity.this.f39173f0.setVisibility(FaqThirdListActivity.this.f39175h0.m52338N1() ? 8 : 0);
                    FaqThirdListActivity.this.m52302k1();
                    return;
                }
                FaqThirdListActivity.this.f39174g0.m52354O1(true);
                FaqThirdListActivity.this.f39165X.setClickable(true);
                FaqThirdListActivity.this.f39165X.setVisibility(0);
                FaqThirdListActivity.this.f39142A.setVisibility(8);
                FaqThirdListActivity.this.f39143B.setVisibility(8);
                if (FaqThirdListActivity.this.f39176i0 == null || FaqThirdListActivity.this.f39176i0 != FaqThirdListActivity.this.f39175h0) {
                    faqThirdListActivity = FaqThirdListActivity.this;
                    fragment = faqThirdListActivity.f39174g0;
                    str = "mSearchHistoryFragment";
                } else {
                    FaqThirdListActivity.this.f39175h0.m52336K1(true);
                    faqThirdListActivity = FaqThirdListActivity.this;
                    fragment = faqThirdListActivity.f39175h0;
                    str = "mSearchAssociativeFragment";
                }
                faqThirdListActivity.m52321F0(fragment, str);
            }
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: b */
        public void mo52090b() {
            View view;
            int i10 = 8;
            if (FaqThirdListActivity.this.f39173f0.getVisibility() == 0) {
                view = FaqThirdListActivity.this.f39173f0;
            } else {
                FaqThirdListActivity.this.f39165X.setVisibility(8);
                FaqThirdListActivity.this.f39143B.setVisibility(FaqThirdListActivity.this.f39179l0 ? 8 : 0);
                view = FaqThirdListActivity.this.f39142A;
                if (FaqThirdListActivity.this.f39179l0) {
                    i10 = 0;
                }
            }
            view.setVisibility(i10);
            if (FaqThirdListActivity.this.f39174g0 != null) {
                FaqThirdListActivity.this.f39174g0.m52354O1(false);
            }
            if (FaqThirdListActivity.this.f39175h0 != null) {
                FaqThirdListActivity.this.f39175h0.m52336K1(false);
            }
            FaqCommonUtils.hideIme(FaqThirdListActivity.this);
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52089a(String str) throws Throwable {
            if (FaqStringUtil.isEmpty(str)) {
                FaqThirdListActivity faqThirdListActivity = FaqThirdListActivity.this;
                FaqToastUtils.makeText(faqThirdListActivity, faqThirdListActivity.getResources().getString(R$string.faq_sdk_search_input_nothing_toast));
                FaqThirdListActivity.this.m52300i1();
                FaqCommonUtils.hideIme(FaqThirdListActivity.this);
                return;
            }
            if (FaqThirdListActivity.this.m52294c1()) {
                FaqThirdListActivity.this.m52300i1();
                FaqCommonUtils.hideIme(FaqThirdListActivity.this);
            } else {
                FaqThirdListActivity.this.m52322c(str);
                C8414d.m52386h(FaqThirdListActivity.this, str);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$d */
    public class C8401d implements ExpandableListView.OnGroupExpandListener {
        public C8401d() {
        }

        @Override // android.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i10) throws Throwable {
            FaqClassification.Classification classification = (FaqClassification.Classification) FaqThirdListActivity.this.f39168a0.getGroup(i10);
            if (classification == null) {
                return;
            }
            String strM51921d = classification.m51921d();
            if (FaqThirdListActivity.this.f39170c0.containsKey(strM51921d)) {
                FaqThirdListActivity.this.f39168a0.m51691b(FaqThirdListActivity.this.m52320B0(strM51921d, (List) FaqThirdListActivity.this.f39170c0.get(strM51921d)));
                FaqThirdListActivity.this.f39168a0.notifyDataSetChanged();
            } else {
                classification.m51920c(false);
                FaqThirdListActivity.this.f39172e0.set(i10, classification);
                FaqThirdListActivity.this.f39168a0.notifyDataSetChanged();
                FaqThirdListActivity.this.m52273I0(strM51921d, i10);
            }
            FaqTrack.event(FaqThirdListActivity.this.f39157P + "+SDK", "Click on FAQ Category", classification.m51922e());
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$e */
    public class C8402e implements ExpandableListView.OnChildClickListener {
        public C8402e() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i10, int i11, long j10) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return false;
            }
            if (FaqThirdListActivity.this.f39168a0.getChildType(i10, i11) == 1) {
                FaqClassification.Classification classification = (FaqClassification.Classification) FaqThirdListActivity.this.f39168a0.getGroup(i10);
                if (classification != null && classification.m51924g()) {
                    classification.m51920c(false);
                    FaqThirdListActivity.this.f39172e0.set(i10, classification);
                    FaqThirdListActivity.this.f39168a0.notifyDataSetChanged();
                    FaqThirdListActivity.this.m52273I0(classification.m51921d(), i10);
                }
            } else {
                C8342b.a aVar = (C8342b.a) FaqThirdListActivity.this.f39168a0.getChild(i10, i11);
                FaqThirdListActivity faqThirdListActivity = FaqThirdListActivity.this;
                FaqQuestionDetailActivity.m52169z0(faqThirdListActivity, faqThirdListActivity.f39154M, FaqThirdListActivity.this.f39155N, aVar.m51995c(), aVar.m51997e(), FaqThirdListActivity.this.f39156O, aVar.m51994b(), FaqThirdListActivity.this.f39153L, FaqThirdListActivity.this.f39152K, FaqThirdListActivity.this.f39160S, FaqThirdListActivity.this.f39161T, FaqThirdListActivity.this.f39157P, FaqThirdListActivity.this.f39145D, FaqThirdListActivity.this.f39146E, FaqThirdListActivity.this.f39147F, FaqThirdListActivity.this.f39148G, FaqThirdListActivity.this.f39149H, FaqThirdListActivity.this.f39150I, FaqThirdListActivity.this.f39151J, false, FaqThirdListActivity.this.f39162U, FaqThirdListActivity.this.f39163V, FaqThirdListActivity.this.f39164W, aVar.m51996d());
                FaqTrack.event(FaqThirdListActivity.this.f39157P + "+SDK+Category", "Click on FAQ", FaqThirdListActivity.this.f39159R + "+" + aVar.m51995c());
            }
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$f */
    public class C8403f extends FaqCallback<FaqClassification> {
        public C8403f(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FaqClassification faqClassification) throws Throwable {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("null==error =");
            sb2.append(th2 == null);
            sb2.append(",null==result =");
            sb2.append(faqClassification == null);
            FaqLogger.m51836d("FaqTirdListActivity", sb2.toString());
            if (th2 != null) {
                FaqThirdListActivity.this.f39144C.m52471k(th2);
            } else {
                if (faqClassification != null && faqClassification.m51918a() != null && !faqClassification.m51918a().isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<FaqClassification.Classification> it = faqClassification.m51918a().iterator();
                    while (it.hasNext()) {
                        FaqClassification.Classification next = it.next();
                        if ("Y".equals(next.m51919a())) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                    FaqThirdListActivity.this.f39144C.setVisibility(8);
                    if (arrayList.size() > 0) {
                        FaqThirdListActivity.this.f39179l0 = true;
                        FaqThirdListActivity.this.f39143B.setVisibility(8);
                        FaqThirdListActivity.this.f39142A.setVisibility(0);
                        FaqThirdListActivity.this.f39169b0.m51741a(arrayList);
                        FaqThirdListActivity.this.f39169b0.notifyDataSetChanged();
                        return;
                    }
                    FaqThirdListActivity.this.f39179l0 = false;
                    FaqThirdListActivity.this.f39142A.setVisibility(8);
                    FaqThirdListActivity.this.f39143B.setVisibility(0);
                    FaqThirdListActivity.this.f39172e0 = arrayList2;
                    FaqThirdListActivity.this.f39168a0.m51690a(arrayList2);
                    FaqThirdListActivity.this.f39168a0.notifyDataSetChanged();
                    return;
                }
                FaqThirdListActivity.this.f39144C.m52468g(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
            }
            FaqThirdListActivity.this.f39144C.setEnabled(true);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$g */
    public class C8404g extends FaqCallback<C8342b> {

        /* renamed from: d */
        public final /* synthetic */ String f39189d;

        /* renamed from: e */
        public final /* synthetic */ int f39190e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8404g(Class cls, Activity activity, String str, int i10) {
            super(cls, activity);
            this.f39189d = str;
            this.f39190e = i10;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8342b c8342b) {
            if (th2 != null || c8342b == null || c8342b.m51992b() == null || c8342b.m51992b().isEmpty()) {
                FaqClassification.Classification classification = (FaqClassification.Classification) FaqThirdListActivity.this.f39172e0.get(this.f39190e);
                classification.m51920c(true);
                FaqThirdListActivity.this.f39172e0.set(this.f39190e, classification);
            } else {
                FaqThirdListActivity.this.f39168a0.m51691b(FaqThirdListActivity.this.m52320B0(this.f39189d, c8342b.m51992b()));
                FaqThirdListActivity.this.f39170c0.put(this.f39189d, c8342b.m51992b());
            }
            FaqThirdListActivity.this.f39168a0.notifyDataSetChanged();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqThirdListActivity$h */
    public static class C8405h implements ExpandableListView.OnGroupCollapseListener {
        @Override // android.widget.ExpandableListView.OnGroupCollapseListener
        public void onGroupCollapse(int i10) {
        }
    }

    /* renamed from: C0 */
    private void m52268C0(int i10, int i11) {
        ListView listView;
        this.f39173f0.setVisibility(i10);
        ExpandableListView expandableListView = this.f39143B;
        if (i10 == 0) {
            expandableListView.setVisibility(this.f39179l0 ? 8 : i10);
            listView = this.f39142A;
            if (!this.f39179l0) {
                i10 = 8;
            }
        } else {
            expandableListView.setVisibility(i10);
            listView = this.f39142A;
        }
        listView.setVisibility(i10);
        this.f39165X.setVisibility(i11);
    }

    /* renamed from: D0 */
    public static void m52269D0(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) FaqThirdListActivity.class);
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
        if (context instanceof FaqCategoryWebActivity) {
            intent.putExtra("IsFromCategory", true);
        }
        if (context instanceof FaqProblemClassifyActivity) {
            intent.putExtra("IsFromCategory", true);
        }
        context.startActivity(intent);
    }

    /* renamed from: E0 */
    public static void m52270E0(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        Intent intent = new Intent(context, (Class<?>) FaqThirdListActivity.class);
        intent.putExtra("isoLanguage", str);
        intent.putExtra("emuilanguage", str2);
        intent.putExtra("title", str3);
        intent.putExtra("countrycode", str4);
        intent.putExtra(FaqConstants.FAQ_LANGUAGE, str5);
        intent.putExtra(FaqConstants.FAQ_CHANNEL, str6);
        intent.putExtra("productCategoryCode", str7);
        intent.putExtra("country", str8);
        intent.putExtra("brands", str9);
        intent.putExtra(FaqConstants.FAQ_LEVEL, str10);
        intent.putExtra("accessToken", str11);
        intent.putExtra(FaqConstants.FAQ_REFRESH, str12);
        intent.putExtra("appVersion", str13);
        intent.putExtra(FaqConstants.FAQ_ROMVERSION, str14);
        intent.putExtra(FaqConstants.FAQ_EMUIVERSION, str15);
        intent.putExtra(FaqConstants.FAQ_OSVERSION, str16);
        intent.putExtra(FaqConstants.FAQ_CALLFUNCTION, str17);
        intent.putExtra(FaqConstants.FAQ_WECHATID, str18);
        intent.putExtra(FaqConstants.FAQ_WEIBOID, str19);
        intent.putExtra(FaqConstants.FAQ_PICID, str20);
        intent.putExtra(FaqConstants.FAQ_SHASN, str21);
        if (context instanceof FaqCategoryActivity) {
            intent.putExtra("IsFromCategory", true);
        }
        context.startActivity(intent);
    }

    /* renamed from: I0 */
    public void m52273I0(String str, int i10) {
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            FaqClassification.Classification classification = (FaqClassification.Classification) this.f39168a0.getGroup(i10);
            classification.m51920c(true);
            this.f39172e0.set(i10, classification);
            return;
        }
        FaqKnowledgeRequest faqKnowledgeRequest = new FaqKnowledgeRequest();
        faqKnowledgeRequest.setCountriesCode(this.f39153L);
        faqKnowledgeRequest.setLanguageCode(this.f39155N);
        faqKnowledgeRequest.setChannel(m51648n0());
        faqKnowledgeRequest.setProductCode(str);
        faqKnowledgeRequest.setDefaultCountry(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_COUNTRY));
        faqKnowledgeRequest.setDefaultLanguage(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_LANGUAGE));
        SdkFaqCommonManager.INSTANCE.getFAQKnowledge(this, faqKnowledgeRequest, new C8404g(C8342b.class, this, str, i10));
    }

    /* renamed from: Y0 */
    private void m52289Y0() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.setExtrasClassLoader(getClassLoader());
            this.f39154M = intent.getStringExtra("isoLanguage");
            this.f39155N = intent.getStringExtra("emuilanguage");
            this.f39156O = intent.getStringExtra("brands");
            this.f39159R = intent.getStringExtra("title");
            this.f39157P = intent.getStringExtra(FaqConstants.FAQ_CHANNEL);
            this.f39158Q = intent.getStringExtra("productCategoryCode");
            this.f39152K = intent.getStringExtra(FaqConstants.FAQ_LEVEL);
            this.f39153L = intent.getStringExtra("country");
            this.f39160S = intent.getStringExtra("accessToken");
            this.f39161T = intent.getStringExtra(FaqConstants.FAQ_REFRESH);
            this.f39145D = intent.getStringExtra("appVersion");
            this.f39146E = intent.getStringExtra(FaqConstants.FAQ_SHASN);
            this.f39147F = intent.getStringExtra(FaqConstants.FAQ_ROMVERSION);
            this.f39148G = intent.getStringExtra(FaqConstants.FAQ_EMUIVERSION);
            this.f39149H = intent.getStringExtra(FaqConstants.FAQ_OSVERSION);
            this.f39150I = intent.getStringExtra("countrycode");
            this.f39151J = intent.getStringExtra(FaqConstants.FAQ_CALLFUNCTION);
            this.f39162U = intent.getStringExtra(FaqConstants.FAQ_WECHATID);
            this.f39163V = intent.getStringExtra(FaqConstants.FAQ_WEIBOID);
            this.f39164W = intent.getStringExtra(FaqConstants.FAQ_PICID);
            this.f39166Y = intent.getBooleanExtra("IsFromCategory", false);
        }
    }

    /* renamed from: a1 */
    public void m52291a1() throws Throwable {
        FaqFastServicesResponse.ModuleListBean moduleListBean = new FaqFastServicesResponse.ModuleListBean();
        moduleListBean.m51928d(21);
        moduleListBean.m51929e(FaqConstants.OPEN_TYPE_IN);
        FaqIpccBean faqIpccBean = new FaqIpccBean();
        faqIpccBean.m51945c(this.f39160S);
        faqIpccBean.m51949g(this.f39157P);
        faqIpccBean.m51951i(this.f39153L);
        faqIpccBean.m51955n(this.f39152K);
        faqIpccBean.m51957p(this.f39154M);
        faqIpccBean.m51942O(this.f39162U);
        faqIpccBean.m51943P(this.f39163V);
        faqIpccBean.m51936A(this.f39164W);
        faqIpccBean.m51947e(this.f39145D);
        faqIpccBean.m51939L(this.f39146E);
        faqIpccBean.m51937I(this.f39147F);
        faqIpccBean.m51961t(this.f39156O);
        faqIpccBean.m51956o(this.f39148G);
        faqIpccBean.m51962v(this.f39149H);
        faqIpccBean.m51953l(this.f39150I);
        faqIpccBean.m51941N(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE));
        faqIpccBean.m51958q(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID));
        faqIpccBean.m51960s(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY));
        faqIpccBean.m51959r(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_LOG_PATH));
        C8406a.m52330f(this, moduleListBean, faqIpccBean, this.f39151J);
        FaqTrack.event(this.f39157P + "+SDK", "Click on Contact us", "contact us");
    }

    /* renamed from: b */
    private void m52292b(String str) {
        FragmentManager fragmentManagerM4473U = m4473U();
        Fragment fragmentM4571i0 = (TextUtils.isEmpty(str) || fragmentManagerM4473U == null) ? null : fragmentManagerM4473U.m4571i0(str);
        if (fragmentM4571i0 == null || fragmentManagerM4473U == null) {
            return;
        }
        fragmentManagerM4473U.m4585o().mo4655q(fragmentM4571i0).mo4648i();
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: c1 */
    public boolean m52294c1() throws Throwable {
        if (this.f39178k0.getText().toString().trim().length() >= 2) {
            return false;
        }
        FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_search_input_word_limits, 2));
        return true;
    }

    /* renamed from: e1 */
    private void m52296e1() {
        if (FaqCommonUtils.isConnectionAvailable(this)) {
            SdkFaqCommonManager.INSTANCE.getFAQType(this, this.f39153L, this.f39155N, m51648n0(), this.f39158Q, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_COUNTRY), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_LANGUAGE), new C8403f(FaqClassification.class, this));
        } else {
            this.f39144C.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            this.f39144C.setEnabled(true);
        }
    }

    /* renamed from: g1 */
    private void m52298g1() {
        this.f39143B.setOnChildClickListener(new C8402e());
    }

    /* renamed from: i1 */
    public void m52300i1() {
        this.f39165X.setVisibility(8);
        this.f39143B.setVisibility(this.f39179l0 ? 8 : 0);
        this.f39142A.setVisibility(this.f39179l0 ? 0 : 8);
        this.f39173f0.setVisibility(8);
        this.f39178k0.setText("");
        this.f39178k0.clearFocus();
        this.f39173f0.setVisibility(8);
        this.f39174g0.m52354O1(false);
        this.f39175h0.m52336K1(false);
        this.f39167Z.getTextViewCancel().setVisibility(8);
    }

    /* renamed from: k1 */
    public void m52302k1() {
        C8407b c8407b;
        Fragment fragment = this.f39176i0;
        if (fragment == null || fragment != (c8407b = this.f39175h0)) {
            return;
        }
        c8407b.m52336K1(true);
        m52321F0(this.f39175h0, "mSearchAssociativeFragment");
    }

    @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8432c
    /* renamed from: A */
    public void mo52070A(EditText editText) {
        if (ModuleConfigUtils.searchRemindEnabled()) {
            if (editText.getText().toString().trim().length() < 2) {
                C8407b c8407b = this.f39175h0;
                if (c8407b != null) {
                    c8407b.m52337M1();
                    return;
                }
                return;
            }
            Runnable runnable = this.f39181n0;
            if (runnable != null) {
                this.f39177j0.removeCallbacks(runnable);
                this.f39177j0.postDelayed(this.f39181n0, 500L);
            }
        }
    }

    /* renamed from: B0 */
    public final Map<String, List<C8342b.a>> m52320B0(String str, List<C8342b.a> list) {
        this.f39171d0.put(str, list);
        return this.f39171d0;
    }

    /* renamed from: F0 */
    public void m52321F0(Fragment fragment, String str) {
        AbstractC0735a0 abstractC0735a0Mo4657v;
        AbstractC0735a0 abstractC0735a0Mo4653o;
        Fragment fragment2 = this.f39176i0;
        if (fragment2 != null) {
            if (fragment2 != fragment) {
                AbstractC0735a0 abstractC0735a0M4585o = m4473U().m4585o();
                if (fragment.m4379X()) {
                    abstractC0735a0Mo4657v = abstractC0735a0M4585o.mo4653o(this.f39176i0).mo4657v(fragment);
                    abstractC0735a0Mo4657v.mo4648i();
                } else {
                    abstractC0735a0Mo4653o = abstractC0735a0M4585o.mo4653o(this.f39176i0);
                }
            }
            this.f39176i0 = fragment;
        }
        abstractC0735a0Mo4653o = m4473U().m4585o();
        abstractC0735a0Mo4657v = abstractC0735a0Mo4653o.m4663c(R$id.faq_sdk_mask, fragment, str);
        abstractC0735a0Mo4657v.mo4648i();
        this.f39176i0 = fragment;
    }

    @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8432c
    /* renamed from: a */
    public void mo52075a(int i10) throws Throwable {
        Fragment fragment;
        String str;
        FaqLogger.m51840e("FaqTirdListActivity", "length>>>>>" + i10);
        if (ModuleConfigUtils.searchRemindEnabled()) {
            if (i10 >= 2) {
                if (this.f39173f0.getVisibility() == 0) {
                    this.f39165X.setClickable(true);
                    m52268C0(8, 0);
                }
                this.f39175h0.m52336K1(true);
                fragment = this.f39175h0;
                str = "mSearchAssociativeFragment";
            } else if (!this.f39174g0.m52357Y1()) {
                m52268C0(0, 8);
                return;
            } else {
                fragment = this.f39174g0;
                str = "mSearchHistoryFragment";
            }
            m52321F0(fragment, str);
        }
    }

    /* renamed from: c */
    public void m52322c(String str) {
        String str2;
        FaqSearchActivity.m52210q0(this, this.f39154M, this.f39155N, this.f39150I, this.f39157P, this.f39158Q, this.f39153L, this.f39156O, this.f39152K, this.f39160S, this.f39161T, this.f39145D, this.f39146E, this.f39147F, this.f39148G, this.f39149H, this.f39151J, this.f39162U, this.f39163V, this.f39164W, str);
        C8413c c8413cM52372a = C8413c.m52372a();
        if (FaqConstants.CHANNEL_HICARE.equals(this.f39157P)) {
            str2 = FaqConstants.APP_HICARE;
        } else {
            str2 = "App_" + this.f39157P;
        }
        c8413cM52372a.m52377d(this, "searchClick", str, str2, this.f39153L, this.f39155N);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() {
        setTitle(this.f39159R);
        this.f39144C.setVisibility(0);
        this.f39144C.setCallback(this.f39180m0);
        this.f39144C.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
        m52296e1();
        this.f39174g0 = new ViewOnClickListenerC8408c();
        this.f39175h0 = new C8407b();
        this.f39174g0.m52352J1(this);
        this.f39175h0.m52334I1(this);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_activity_faq_third_list_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        this.f39144C.setOnClickListener(this);
        this.f39167Z.setOnclick(this.f39182o0);
        this.f39142A.setOnItemClickListener(this);
        this.f39143B.setOnGroupExpandListener(new C8401d());
        this.f39143B.setOnGroupCollapseListener(new C8405h());
        m52298g1();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        this.f39143B = (ExpandableListView) findViewById(R$id.faq_expand_listview);
        ListView listView = (ListView) findViewById(R$id.faq_nosub_listview);
        this.f39142A = listView;
        listView.setAdapter((ListAdapter) this.f39169b0);
        this.f39144C = (FaqNoticeView) findViewById(R$id.faq_error_noticeView);
        this.f39165X = (LinearLayout) findViewById(R$id.faq_sdk_mask);
        this.f39167Z = (FaqSdkSearchInput) findViewById(R$id.faq_sdk_searchinput);
        if (this.f39166Y && ModuleConfigUtils.searchViewEnabled()) {
            this.f39167Z.setVisibility(0);
        }
        FaqExpendListAdapter faqExpendListAdapter = new FaqExpendListAdapter(this);
        this.f39168a0 = faqExpendListAdapter;
        this.f39143B.setAdapter(faqExpendListAdapter);
        this.f39142A.setAdapter((ListAdapter) this.f39169b0);
        this.f39173f0 = findViewById(R$id.view_floating_layer);
        this.f39167Z.setOnClick(this);
        m52292b("mSearchHistoryFragment");
        m52292b("mSearchAssociativeFragment");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!NoDoubleClickUtil.isDoubleClick(view) && view.getId() == R$id.faq_error_noticeView) {
            mo51677f();
            FaqOnDoubleClickUtil.conClick(this.f39144C);
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        m52289Y0();
        super.onCreate(bundle);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f39174g0 != null) {
            this.f39174g0 = null;
        }
        if (this.f39175h0 != null) {
            this.f39175h0 = null;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) throws Throwable {
        FaqClassification.Classification classification = (FaqClassification.Classification) adapterView.getAdapter().getItem(i10);
        if (classification == null) {
            return;
        }
        m52270E0(this, this.f39154M, this.f39155N, classification.m51922e(), this.f39150I, null, this.f39157P, classification.m51921d(), this.f39153L, this.f39156O, this.f39152K, this.f39160S, this.f39161T, this.f39145D, this.f39146E, this.f39147F, this.f39148G, this.f39149H, this.f39151J, this.f39162U, this.f39163V, this.f39164W);
        FaqTrack.event(this.f39157P + "+SDK", "Click on FAQ Category", classification.m51922e());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f39178k0 = this.f39167Z.getEditTextContent();
        m52300i1();
    }

    @Override // com.huawei.phoneservice.faq.p174ui.ViewOnClickListenerC8408c.g
    /* renamed from: a */
    public void mo52076a(String str, String str2) throws Throwable {
        if (FaqStringUtil.isEmpty(str)) {
            FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_search_input_nothing_toast));
        } else {
            m52322c(str);
            C8414d.m52386h(this, str);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.C8407b.c
    /* renamed from: b */
    public void mo52077b(String str, String str2) {
        if (m52294c1()) {
            return;
        }
        m52322c(str);
        C8414d.m52386h(this, str);
    }
}
