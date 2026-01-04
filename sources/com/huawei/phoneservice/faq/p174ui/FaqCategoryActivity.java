package com.huawei.phoneservice.faq.p174ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.phoneservice.faq.FaqBaseActivity;
import com.huawei.phoneservice.faq.R$dimen;
import com.huawei.phoneservice.faq.R$drawable;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$menu;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.adapter.FaqHotAdapter;
import com.huawei.phoneservice.faq.adapter.FaqOtherAdapter;
import com.huawei.phoneservice.faq.adapter.FaqProblemTypeAdapter;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.FaqLanguageUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqOnDoubleClickUtil;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter;
import com.huawei.phoneservice.faq.p174ui.C8407b;
import com.huawei.phoneservice.faq.p174ui.ViewOnClickListenerC8408c;
import com.huawei.phoneservice.faq.response.C8342b;
import com.huawei.phoneservice.faq.response.C8343c;
import com.huawei.phoneservice.faq.response.FaqClassification;
import com.huawei.phoneservice.faq.utils.C8412b;
import com.huawei.phoneservice.faq.utils.C8413c;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.phoneservice.faq.utils.C8416f;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.BadgeHelper;
import com.huawei.phoneservice.faq.widget.FaqBaseScrollView;
import com.huawei.phoneservice.faq.widget.FaqInScrollListView;
import com.huawei.phoneservice.faq.widget.FaqListGridView;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import com.huawei.phoneservice.faq.widget.FaqSdkSearchInput;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;
import com.huawei.phoneservice.faqcommon.webapi.request.FaqKnowledgeRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqCategoryActivity extends FaqBaseActivity implements View.OnClickListener, FaqSdkSearchInput.InterfaceC8432c, ViewOnClickListenerC8408c.g, C8407b.c {

    /* renamed from: D */
    public LinearLayout f38866D;

    /* renamed from: E */
    public LinearLayout f38867E;

    /* renamed from: F */
    public LinearLayout f38868F;

    /* renamed from: G */
    public FaqNoticeView f38869G;

    /* renamed from: H */
    public LinearLayout f38870H;

    /* renamed from: I */
    public LinearLayout f38871I;

    /* renamed from: J */
    public LinearLayout f38872J;

    /* renamed from: K */
    public FaqListGridView f38873K;

    /* renamed from: L */
    public FaqBaseScrollView f38874L;

    /* renamed from: M */
    public LinearLayout f38875M;

    /* renamed from: N */
    public Button f38876N;

    /* renamed from: O */
    public Button f38877O;

    /* renamed from: P */
    public Button f38878P;

    /* renamed from: Q */
    public View f38879Q;

    /* renamed from: R */
    public View f38880R;

    /* renamed from: U */
    public boolean f38883U;

    /* renamed from: V */
    public boolean f38884V;

    /* renamed from: W */
    public boolean f38885W;

    /* renamed from: Y */
    public int f38887Y;

    /* renamed from: Z */
    public int f38888Z;

    /* renamed from: b0 */
    public FaqInScrollListView f38890b0;

    /* renamed from: c0 */
    public FaqInScrollListView f38891c0;

    /* renamed from: d0 */
    public List<C8342b.a> f38892d0;

    /* renamed from: e0 */
    public ArrayList<FaqClassification.Classification> f38893e0;

    /* renamed from: h0 */
    public FaqProblemTypeAdapter f38896h0;

    /* renamed from: i0 */
    public FaqSdkSearchInput f38897i0;

    /* renamed from: j0 */
    public LinearLayout f38898j0;

    /* renamed from: k0 */
    public ViewOnClickListenerC8408c f38899k0;

    /* renamed from: l0 */
    public C8407b f38900l0;

    /* renamed from: n0 */
    public View f38902n0;

    /* renamed from: o0 */
    public View f38903o0;

    /* renamed from: p0 */
    public Fragment f38904p0;

    /* renamed from: q0 */
    public EditText f38905q0;

    /* renamed from: r0 */
    public BadgeHelper f38906r0;

    /* renamed from: A */
    public AdapterView.OnItemClickListener f38863A = new C8356d();

    /* renamed from: B */
    public AdapterView.OnItemClickListener f38864B = new C8357e();

    /* renamed from: C */
    public View.OnClickListener f38865C = new ViewOnClickListenerC8358f();

    /* renamed from: S */
    public int f38881S = 1;

    /* renamed from: T */
    public int f38882T = 20;

    /* renamed from: X */
    public long f38886X = 0;

    /* renamed from: a0 */
    public boolean f38889a0 = false;

    /* renamed from: f0 */
    public FaqHotAdapter f38894f0 = new FaqHotAdapter(this);

    /* renamed from: g0 */
    public FaqOtherAdapter f38895g0 = new FaqOtherAdapter(this);

    /* renamed from: m0 */
    public Handler f38901m0 = new Handler();

    /* renamed from: s0 */
    public FaqNoticeView.InterfaceC8428b f38907s0 = new C8359g();

    /* renamed from: t0 */
    public Runnable f38908t0 = new RunnableC8360h();

    /* renamed from: u0 */
    public FaqSdkSearchInput.InterfaceC8433d f38909u0 = new C8361i();

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$a */
    public class C8353a extends FaqCallback<C8342b> {
        public C8353a(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8342b c8342b) throws Throwable {
            FaqCategoryActivity faqCategoryActivity;
            int i10;
            String str;
            FaqCategoryActivity.m52041a1(FaqCategoryActivity.this);
            if (th2 != null) {
                FaqLogger.m51836d("FaqActivity", "noticeView" + FaqCategoryActivity.this.f38887Y + " getFAQKnowledge");
                faqCategoryActivity = FaqCategoryActivity.this;
                i10 = faqCategoryActivity.f38887Y;
                str = "service_is_error";
            } else {
                if (c8342b != null && c8342b.m51992b() != null && !c8342b.m51992b().isEmpty()) {
                    FaqCategoryActivity.this.f38892d0 = c8342b.m51992b();
                    Iterator it = FaqCategoryActivity.this.f38892d0.iterator();
                    int i11 = 0;
                    int i12 = 0;
                    while (it.hasNext()) {
                        if ("Y".equals(((C8342b.a) it.next()).m51993a())) {
                            i11++;
                        } else {
                            i12++;
                        }
                    }
                    FaqCategoryActivity faqCategoryActivity2 = FaqCategoryActivity.this;
                    faqCategoryActivity2.m52053n(faqCategoryActivity2.f38892d0, FaqCategoryActivity.this.f38893e0);
                    FaqCategoryActivity faqCategoryActivity3 = FaqCategoryActivity.this;
                    faqCategoryActivity3.f38883U = i11 >= faqCategoryActivity3.f38882T;
                    FaqCategoryActivity faqCategoryActivity4 = FaqCategoryActivity.this;
                    faqCategoryActivity4.f38884V = i12 >= faqCategoryActivity4.f38882T;
                    FaqLogger.m51836d("FaqActivity", FaqCategoryActivity.this.f38887Y + " getFAQKnowledge" + FaqCategoryActivity.this.f38892d0.size());
                    return;
                }
                FaqLogger.m51836d("FaqActivity", "layout_error " + FaqCategoryActivity.this.f38887Y + " getFAQKnowledge");
                faqCategoryActivity = FaqCategoryActivity.this;
                i10 = faqCategoryActivity.f38887Y;
                str = "data_is_empty";
            }
            faqCategoryActivity.m52073F0(str, i10);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$b */
    public class C8354b extends FaqCallback<FaqClassification> {
        public C8354b(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, FaqClassification faqClassification) throws Throwable {
            FaqCategoryActivity faqCategoryActivity;
            int i10;
            String str;
            FaqCategoryActivity.m52041a1(FaqCategoryActivity.this);
            if (th2 != null) {
                FaqLogger.m51836d("FaqActivity", "noticeView " + FaqCategoryActivity.this.f38887Y + " getFAQType");
                faqCategoryActivity = FaqCategoryActivity.this;
                i10 = faqCategoryActivity.f38887Y;
                str = "service_is_error";
            } else {
                if (faqClassification != null && faqClassification.m51918a() != null && !faqClassification.m51918a().isEmpty()) {
                    FaqCategoryActivity.this.f38893e0 = faqClassification.m51918a();
                    FaqLogger.m51836d("FaqActivity", FaqCategoryActivity.this.f38887Y + " getFAQType" + FaqCategoryActivity.this.f38893e0.size());
                    FaqCategoryActivity faqCategoryActivity2 = FaqCategoryActivity.this;
                    faqCategoryActivity2.m52053n(faqCategoryActivity2.f38892d0, FaqCategoryActivity.this.f38893e0);
                    return;
                }
                FaqLogger.m51836d("FaqActivity", "layout_error " + FaqCategoryActivity.this.f38887Y + " getFAQType");
                faqCategoryActivity = FaqCategoryActivity.this;
                i10 = faqCategoryActivity.f38887Y;
                str = "data_is_empty";
            }
            faqCategoryActivity.m52073F0(str, i10);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$c */
    public class C8355c extends FaqCallback<C8342b> {
        public C8355c(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8342b c8342b) throws Throwable {
            FaqCategoryActivity faqCategoryActivity;
            Date date;
            if (th2 != null) {
                FaqCategoryActivity.this.f38883U = true;
                FaqCategoryActivity.this.f38884V = true;
                FaqCategoryActivity.m52031P0(FaqCategoryActivity.this);
                FaqCategoryActivity faqCategoryActivity2 = FaqCategoryActivity.this;
                FaqToastUtils.makeText(faqCategoryActivity2, faqCategoryActivity2.getString(R$string.faq_sdk_common_server_disconnected_toast));
                faqCategoryActivity = FaqCategoryActivity.this;
                date = new Date();
            } else {
                if (c8342b != null) {
                    if (c8342b.m51992b() == null || c8342b.m51992b().isEmpty()) {
                        FaqCategoryActivity.this.f38883U = false;
                        FaqCategoryActivity.this.f38884V = false;
                    } else {
                        FaqCategoryActivity.this.m52072B0(c8342b);
                    }
                    FaqCategoryActivity.this.f38885W = false;
                    FaqCategoryActivity.this.f38890b0.removeFooterView(FaqCategoryActivity.this.f38880R);
                    FaqCategoryActivity.this.f38891c0.removeFooterView(FaqCategoryActivity.this.f38880R);
                }
                FaqCategoryActivity.this.f38883U = true;
                FaqCategoryActivity.this.f38884V = true;
                FaqCategoryActivity.m52031P0(FaqCategoryActivity.this);
                FaqCategoryActivity faqCategoryActivity3 = FaqCategoryActivity.this;
                FaqToastUtils.makeText(faqCategoryActivity3, faqCategoryActivity3.getString(R$string.faq_sdk_common_server_disconnected_toast));
                faqCategoryActivity = FaqCategoryActivity.this;
                date = new Date();
            }
            faqCategoryActivity.f38886X = date.getTime();
            FaqCategoryActivity.this.f38885W = false;
            FaqCategoryActivity.this.f38890b0.removeFooterView(FaqCategoryActivity.this.f38880R);
            FaqCategoryActivity.this.f38891c0.removeFooterView(FaqCategoryActivity.this.f38880R);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$d */
    public class C8356d implements AdapterView.OnItemClickListener {
        public C8356d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) throws Throwable {
            C8342b.a aVar;
            if (NoDoubleClickUtil.isDoubleClick(view) || (aVar = (C8342b.a) adapterView.getAdapter().getItem(i10)) == null) {
                return;
            }
            FaqQuestionDetailActivity.m52116A0(FaqCategoryActivity.this, aVar.m51995c(), aVar.m51997e(), aVar.m51994b(), false, aVar.m51996d());
            FaqTrack.event(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL) + "+SDK", "Click on FAQ", aVar.m51995c());
            FaqOnDoubleClickUtil.conClick(view);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$e */
    public class C8357e implements AdapterView.OnItemClickListener {
        public C8357e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) throws Throwable {
            C8342b.a aVar;
            if (NoDoubleClickUtil.isDoubleClick(view) || (aVar = (C8342b.a) adapterView.getAdapter().getItem(i10)) == null) {
                return;
            }
            FaqQuestionDetailActivity.m52116A0(FaqCategoryActivity.this, aVar.m51995c(), aVar.m51997e(), aVar.m51994b(), false, aVar.m51996d());
            FaqTrack.event(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL) + "+SDK", "Click on FAQ", aVar.m51995c());
            FaqOnDoubleClickUtil.conClick(view);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$f */
    public class ViewOnClickListenerC8358f implements View.OnClickListener {
        public ViewOnClickListenerC8358f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqClassification.Classification classification = (FaqClassification.Classification) view.getTag();
            if (classification != null) {
                String strM51922e = classification.m51922e();
                String strM51921d = classification.m51921d();
                boolean zEquals = "Y".equals(classification.m51919a());
                FaqCategoryActivity faqCategoryActivity = FaqCategoryActivity.this;
                if (zEquals) {
                    FaqThirdListActivity.m52269D0(faqCategoryActivity, strM51922e, null, strM51921d);
                } else {
                    FaqSecondaryListActivity.m52247r0(faqCategoryActivity, strM51922e, null, strM51921d);
                }
                FaqTrack.event(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL) + "+SDK", "Click on FAQ Category", classification.m51922e());
            }
            FaqOnDoubleClickUtil.conClick(view);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$g */
    public class C8359g implements FaqNoticeView.InterfaceC8428b {
        public C8359g() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqNoticeView.InterfaceC8428b
        /* renamed from: a */
        public void mo52087a() throws Throwable {
            C8412b.m52367a(FaqCategoryActivity.this);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$h */
    public class RunnableC8360h implements Runnable {
        public RunnableC8360h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FaqCategoryActivity.this.f38905q0 != null) {
                String strTrim = FaqCategoryActivity.this.f38905q0.getText().toString().trim();
                if (FaqCategoryActivity.this.f38900l0 == null || strTrim.length() < 2) {
                    return;
                }
                FaqCategoryActivity.this.f38900l0.m52335J1(strTrim);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$i */
    public class C8361i implements FaqSdkSearchInput.InterfaceC8433d {
        public C8361i() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52088a() throws Throwable {
            FaqCategoryActivity faqCategoryActivity;
            Fragment fragment;
            String str;
            boolean z10 = (ModuleConfigUtils.searchHotEnabled() || ModuleConfigUtils.searchHistoryEnabled()) ? false : true;
            List<String> listM52380b = C8414d.m52380b(FaqCategoryActivity.this);
            if (FaqCategoryActivity.this.f38899k0 != null) {
                if (z10 && FaqCommonUtils.isEmpty(listM52380b)) {
                    FaqCategoryActivity.this.f38899k0.m52354O1(false);
                    FaqCategoryActivity.this.f38903o0.setVisibility(FaqCategoryActivity.this.f38900l0.m52338N1() ? 8 : 0);
                    FaqCategoryActivity.this.m52064u0();
                    return;
                }
                FaqCategoryActivity.this.f38866D.setVisibility(8);
                FaqCategoryActivity.this.f38870H.setVisibility(8);
                FaqCategoryActivity.this.f38899k0.m52354O1(true);
                FaqCategoryActivity.this.f38898j0.setClickable(true);
                FaqCategoryActivity.this.f38898j0.setVisibility(0);
                if (FaqCategoryActivity.this.f38904p0 == null || FaqCategoryActivity.this.f38904p0 != FaqCategoryActivity.this.f38900l0) {
                    faqCategoryActivity = FaqCategoryActivity.this;
                    fragment = faqCategoryActivity.f38899k0;
                    str = "mSearchHistoryFragment";
                } else {
                    FaqCategoryActivity.this.f38900l0.m52336K1(true);
                    faqCategoryActivity = FaqCategoryActivity.this;
                    fragment = faqCategoryActivity.f38900l0;
                    str = "mSearchAssociativeFragment";
                }
                faqCategoryActivity.m52071A0(fragment, str);
            }
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: b */
        public void mo52090b() {
            if (FaqCategoryActivity.this.f38903o0.getVisibility() == 0) {
                FaqCategoryActivity.this.f38903o0.setVisibility(8);
            } else {
                FaqCategoryActivity.this.f38898j0.setVisibility(8);
                FaqCategoryActivity.this.f38866D.setVisibility(0);
                FaqCategoryActivity.this.f38870H.setVisibility(0);
            }
            if (FaqCategoryActivity.this.f38899k0 != null) {
                FaqCategoryActivity.this.f38899k0.m52354O1(false);
            }
            if (FaqCategoryActivity.this.f38900l0 != null) {
                FaqCategoryActivity.this.f38900l0.m52336K1(false);
            }
            FaqCommonUtils.hideIme(FaqCategoryActivity.this);
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8433d
        /* renamed from: a */
        public void mo52089a(String str) throws Throwable {
            if (FaqStringUtil.isEmpty(str)) {
                FaqCategoryActivity faqCategoryActivity = FaqCategoryActivity.this;
                FaqToastUtils.makeText(faqCategoryActivity, faqCategoryActivity.getResources().getString(R$string.faq_sdk_search_input_nothing_toast));
                FaqCategoryActivity.this.m52055o0();
                FaqCommonUtils.hideIme(FaqCategoryActivity.this);
                return;
            }
            if (FaqCategoryActivity.this.m52083r1()) {
                FaqCategoryActivity.this.m52055o0();
                FaqCommonUtils.hideIme(FaqCategoryActivity.this);
            } else {
                FaqCategoryActivity.this.m52078c(str);
                C8414d.m52386h(FaqCategoryActivity.this, str);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$j */
    public class C8362j implements FaqBaseScrollView.InterfaceC8423b {
        public C8362j() {
        }

        @Override // com.huawei.phoneservice.faq.widget.FaqBaseScrollView.InterfaceC8423b
        /* renamed from: a */
        public void mo52091a() throws Throwable {
            if (new Date().getTime() - FaqCategoryActivity.this.f38886X < RippleView.SINGLE_RIPPLE_TIME) {
                return;
            }
            if (!FaqCommonUtils.isConnectionAvailable(FaqCategoryActivity.this)) {
                FaqCategoryActivity faqCategoryActivity = FaqCategoryActivity.this;
                FaqToastUtils.makeText(faqCategoryActivity, faqCategoryActivity.getString(R$string.faq_sdk_no_network_toast));
                FaqCategoryActivity.this.f38886X = new Date().getTime();
                return;
            }
            if (FaqCategoryActivity.this.f38885W) {
                return;
            }
            if (FaqCategoryActivity.this.f38883U) {
                FaqCategoryActivity.m52030O0(FaqCategoryActivity.this);
                FaqCategoryActivity.this.f38890b0.addFooterView(FaqCategoryActivity.this.f38880R);
                FaqCategoryActivity.this.m52043b1();
            }
            if (FaqCategoryActivity.this.f38884V) {
                FaqCategoryActivity.m52030O0(FaqCategoryActivity.this);
                FaqCategoryActivity.this.f38891c0.addFooterView(FaqCategoryActivity.this.f38880R);
                FaqCategoryActivity.this.m52043b1();
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$k */
    public class C8363k extends FaqCallback<C8343c> {
        public C8363k(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8343c c8343c) {
            String strM51998a = (th2 != null || c8343c == null || c8343c.m51998a() == null) ? FaqConstants.DEFAULT_ISO_LANGUAGE : c8343c.m51998a();
            FaqSdk.getSdk().saveSdk(FaqConstants.FAQ_LANGUAGE, strM51998a);
            FaqSdk.getSdk().saveSdk(FaqConstants.FAQ_ISOLANGUAGE, strM51998a);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqCategoryActivity$l */
    public class C8364l extends FaqCallback<C8343c> {
        public C8364l(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8343c c8343c) {
            if (th2 == null) {
                if (FaqCategoryActivity.this.isFinishing() || FaqCategoryActivity.this.isDestroyed()) {
                    return;
                }
                String strM51998a = c8343c != null ? c8343c.m51998a() : FaqConstants.DEFAULT_ISO_LANGUAGE;
                if (!FaqStringUtil.isEmpty(strM51998a)) {
                    Intent intent = new Intent(FaqCategoryActivity.this, (Class<?>) FaqCategoryActivity.class);
                    intent.putExtra(FaqConstants.FAQ_ISOLANGUAGE, strM51998a);
                    FaqCategoryActivity.this.startActivity(intent);
                    FaqCategoryActivity.this.finish();
                    return;
                }
            }
            FaqCategoryActivity.this.f38869G.m52468g(FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
        }
    }

    /* renamed from: O0 */
    public static /* synthetic */ int m52030O0(FaqCategoryActivity faqCategoryActivity) {
        int i10 = faqCategoryActivity.f38881S;
        faqCategoryActivity.f38881S = i10 + 1;
        return i10;
    }

    /* renamed from: P0 */
    public static /* synthetic */ int m52031P0(FaqCategoryActivity faqCategoryActivity) {
        int i10 = faqCategoryActivity.f38881S;
        faqCategoryActivity.f38881S = i10 - 1;
        return i10;
    }

    /* renamed from: X0 */
    private void m52039X0() throws Throwable {
        FaqKnowledgeRequest faqKnowledgeRequest = new FaqKnowledgeRequest();
        faqKnowledgeRequest.setCountriesCode(SdkFaqManager.getSdk().getSdk("country"));
        faqKnowledgeRequest.setLanguageCode(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE));
        faqKnowledgeRequest.setChannel(m51648n0());
        faqKnowledgeRequest.setProductCode(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE));
        faqKnowledgeRequest.setDefaultCountry(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_COUNTRY));
        faqKnowledgeRequest.setDefaultLanguage(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_LANGUAGE));
        faqKnowledgeRequest.setPageNum(String.valueOf(this.f38881S));
        faqKnowledgeRequest.setPageSize(String.valueOf(this.f38882T));
        FaqLogger.print("FaqActivity", faqKnowledgeRequest.toString());
        SdkFaqCommonManager.INSTANCE.getFAQKnowledge(this, faqKnowledgeRequest, new C8353a(C8342b.class, this));
    }

    /* renamed from: a1 */
    public static /* synthetic */ int m52041a1(FaqCategoryActivity faqCategoryActivity) {
        int i10 = faqCategoryActivity.f38887Y;
        faqCategoryActivity.f38887Y = i10 - 1;
        return i10;
    }

    /* renamed from: b */
    private void m52042b(String str) {
        FragmentManager fragmentManagerM4473U = m4473U();
        Fragment fragmentM4571i0 = (TextUtils.isEmpty(str) || fragmentManagerM4473U == null) ? null : fragmentManagerM4473U.m4571i0(str);
        if (fragmentM4571i0 == null || fragmentManagerM4473U == null) {
            return;
        }
        fragmentManagerM4473U.m4585o().mo4655q(fragmentM4571i0).mo4648i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1 */
    public void m52043b1() throws Throwable {
        this.f38885W = true;
        FaqKnowledgeRequest faqKnowledgeRequest = new FaqKnowledgeRequest();
        faqKnowledgeRequest.setCountriesCode(SdkFaqManager.getSdk().getSdk("country"));
        faqKnowledgeRequest.setLanguageCode(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE));
        faqKnowledgeRequest.setChannel(m51648n0());
        faqKnowledgeRequest.setProductCode(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE));
        faqKnowledgeRequest.setDefaultCountry(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_COUNTRY));
        faqKnowledgeRequest.setDefaultLanguage(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_LANGUAGE));
        faqKnowledgeRequest.setPageNum(String.valueOf(this.f38881S));
        faqKnowledgeRequest.setPageSize(String.valueOf(this.f38882T));
        FaqLogger.print("FaqActivity", faqKnowledgeRequest.toString());
        SdkFaqCommonManager.INSTANCE.getFAQKnowledge(this, faqKnowledgeRequest, new C8355c(C8342b.class, this));
    }

    /* renamed from: d1 */
    private void m52045d1() throws Throwable {
        if (getIntent() != null) {
            if (FaqSdk.getSdk().init()) {
                SdkFaqManager.getManager().getIsoLanguage(this, new C8363k(C8343c.class, null));
            } else {
                FaqLogger.print("FaqActivity", "init is fail");
                finish();
            }
        }
    }

    /* renamed from: f1 */
    private void m52047f1() throws Throwable {
        m52074Z0();
        m52039X0();
    }

    /* renamed from: h1 */
    private void m52049h1() throws Throwable {
        if (FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ISOLANGUAGE)) && !FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE)) && this.f38869G.getFaqErrorCode() == FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR) {
            this.f38869G.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
            C8406a.m52329e(this, new C8364l(C8343c.class, this));
        } else if (this.f38869G.getFaqErrorCode() == FaqConstants.FaqErrorCode.LOAD_DATA_ERROR || this.f38869G.getFaqErrorCode() == FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR) {
            FaqLogger.m51840e("FaqActivity", "CAN NOT CLICK");
        } else {
            mo51677f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m52053n(List<C8342b.a> list, List<FaqClassification.Classification> list2) throws Throwable {
        if (list != null) {
            this.f38894f0.m51692a(list, true);
            this.f38894f0.notifyDataSetChanged();
            this.f38867E.setVisibility(0);
            this.f38890b0.setVisibility(0);
            this.f38871I.setVisibility(8);
            this.f38902n0.setVisibility(8);
            this.f38873K.setVisibility(8);
            if (this.f38894f0.getCount() <= 0) {
                this.f38872J.setVisibility(0);
                this.f38891c0.setVisibility(0);
            }
        }
        if (list2 != null) {
            this.f38875M.setVisibility(list2.size() > 12 ? 0 : 8);
            this.f38896h0.setResource(list2);
            this.f38873K.setNumColumns(4);
            this.f38873K.setAdapter((SimpleBaseAdapter) this.f38896h0);
            this.f38872J.setVisibility(8);
            this.f38871I.setVisibility(0);
            this.f38902n0.setVisibility(8);
            this.f38891c0.setVisibility(8);
            this.f38873K.setVisibility(0);
        }
        if (this.f38887Y == 0) {
            this.f38866D.setVisibility(0);
            if (this.f38891c0.getVisibility() == 0) {
                this.f38891c0.setAdapter((ListAdapter) this.f38895g0);
                this.f38895g0.m51693a(this.f38892d0);
                this.f38895g0.notifyDataSetChanged();
                this.f38891c0.setOnItemClickListener(this.f38864B);
            } else if (this.f38873K.getVisibility() == 0) {
                this.f38896h0.notifyDataSetChanged();
            }
            if (this.f38894f0.getCount() <= 0) {
                this.f38867E.setVisibility(8);
                this.f38890b0.setVisibility(8);
            }
            if (this.f38895g0.getCount() <= 0 && this.f38872J.getVisibility() == 0) {
                this.f38872J.setVisibility(8);
            }
            if (this.f38896h0.getCount() <= 0 && this.f38871I.getVisibility() == 0) {
                this.f38871I.setVisibility(8);
            }
            this.f38869G.setVisibility(8);
        }
    }

    /* renamed from: n1 */
    private void m52054n1() {
        C8416f.m52391c(this, this.f38906r0, ModuleConfigUtils.getFeedbackOpenTypeConfig()[0], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void m52055o0() {
        this.f38898j0.setVisibility(8);
        this.f38866D.setVisibility(0);
        this.f38870H.setVisibility(0);
        this.f38903o0.setVisibility(8);
        this.f38905q0.setText("");
        this.f38905q0.clearFocus();
        this.f38903o0.setVisibility(8);
        ViewOnClickListenerC8408c viewOnClickListenerC8408c = this.f38899k0;
        if (viewOnClickListenerC8408c != null) {
            viewOnClickListenerC8408c.m52354O1(false);
        }
        C8407b c8407b = this.f38900l0;
        if (c8407b != null) {
            c8407b.m52336K1(false);
        }
        this.f38897i0.getTextViewCancel().setVisibility(8);
    }

    /* renamed from: p1 */
    private void m52058p1() {
        C8416f.m52391c(this, this.f38906r0, ModuleConfigUtils.getFeedbackOpenTypeConfig()[0], false);
    }

    /* renamed from: s0 */
    private void m52060s0() throws Throwable {
        invalidateOptionsMenu();
        if (ModuleConfigUtils.knowledgeEnabled()) {
            m52047f1();
        } else {
            m52082r0();
        }
        m52063t1();
        if (!ModuleConfigUtils.searchViewEnabled()) {
            this.f38897i0.setVisibility(8);
        }
        this.f38890b0.setAdapter((ListAdapter) this.f38894f0);
        this.f38890b0.setOnItemClickListener(this.f38863A);
    }

    /* renamed from: t0 */
    private void m52062t0() {
        FaqNoticeView faqNoticeView = this.f38869G;
        FaqConstants.FaqErrorCode faqErrorCode = FaqConstants.FaqErrorCode.LOAD_DATA_ERROR;
        faqNoticeView.m52469h(faqErrorCode, R$drawable.faq_sdk_no_data_disable);
        this.f38869G.m52468g(faqErrorCode);
        this.f38869G.m52475r(faqErrorCode, getResources().getDimensionPixelOffset(R$dimen.faq_sdk_loading_error_icon_size));
        this.f38869G.getNoticeTextView().setText(getResources().getString(R$string.faq_sdk_data_error_toast));
        this.f38869G.setCallback(this.f38907s0);
    }

    /* renamed from: t1 */
    private void m52063t1() {
        if (ModuleConfigUtils.feedbackEnabled() && !ModuleConfigUtils.feedbackVisible() && C8416f.m52392d()) {
            this.f38870H.setVisibility(0);
            this.f38877O.setVisibility(0);
            this.f38877O.setText(getString(R$string.faq_sdk_goto_feedback));
            this.f38889a0 = true;
        } else if (ModuleConfigUtils.productSuggestEnabled() && C8416f.m52392d()) {
            this.f38870H.setVisibility(0);
            this.f38877O.setVisibility(0);
            this.f38877O.setText(getString(R$string.faq_sdk_question));
            this.f38889a0 = false;
        }
        if (ModuleConfigUtils.contactEnabled()) {
            this.f38870H.setVisibility(0);
            this.f38878P.setVisibility(0);
        }
        if (this.f38877O.getVisibility() == 0 && this.f38878P.getVisibility() == 0) {
            this.f38879Q.setVisibility(0);
        } else {
            this.f38879Q.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m52064u0() throws Throwable {
        C8407b c8407b;
        Fragment fragment = this.f38904p0;
        if (fragment == null || fragment != (c8407b = this.f38900l0)) {
            return;
        }
        c8407b.m52336K1(true);
        m52071A0(this.f38900l0, "mSearchAssociativeFragment");
    }

    /* renamed from: z0 */
    private void m52069z0(int i10, int i11) {
        this.f38903o0.setVisibility(i10);
        this.f38866D.setVisibility(i10);
        this.f38870H.setVisibility(i10);
        this.f38898j0.setVisibility(i11);
    }

    @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8432c
    /* renamed from: A */
    public void mo52070A(EditText editText) {
        if (ModuleConfigUtils.searchRemindEnabled()) {
            if (editText.getText().toString().trim().length() >= 2) {
                Runnable runnable = this.f38908t0;
                if (runnable != null) {
                    this.f38901m0.removeCallbacks(runnable);
                }
                this.f38901m0.postDelayed(this.f38908t0, 500L);
                return;
            }
            C8407b c8407b = this.f38900l0;
            if (c8407b != null) {
                c8407b.m52337M1();
            }
        }
    }

    /* renamed from: A0 */
    public void m52071A0(Fragment fragment, String str) throws Throwable {
        Fragment fragment2 = this.f38904p0;
        if (fragment2 == null) {
            m4473U().m4585o().m4663c(R$id.faq_sdk_mask, fragment, str).mo4648i();
        } else {
            if (fragment2 != fragment) {
                AbstractC0735a0 abstractC0735a0M4585o = m4473U().m4585o();
                (!fragment.m4379X() ? abstractC0735a0M4585o.mo4653o(this.f38904p0).m4663c(R$id.faq_sdk_mask, fragment, str) : abstractC0735a0M4585o.mo4653o(this.f38904p0).mo4657v(fragment)).mo4648i();
            }
            ViewOnClickListenerC8408c viewOnClickListenerC8408c = this.f38899k0;
            if (viewOnClickListenerC8408c != null && viewOnClickListenerC8408c == this.f38904p0 && viewOnClickListenerC8408c.m4379X()) {
                this.f38899k0.mo51688F1();
            }
        }
        this.f38904p0 = fragment;
    }

    /* renamed from: B0 */
    public final void m52072B0(C8342b c8342b) {
        Iterator<C8342b.a> it = c8342b.m51992b().iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            if ("Y".equals(it.next().m51993a())) {
                i10++;
            } else {
                i11++;
            }
        }
        this.f38894f0.m51692a(c8342b.m51992b(), false);
        this.f38894f0.notifyDataSetChanged();
        this.f38895g0.m51693a(c8342b.m51992b());
        this.f38895g0.notifyDataSetChanged();
        int i12 = this.f38882T;
        this.f38883U = i10 >= i12;
        this.f38884V = i11 >= i12;
    }

    /* renamed from: F0 */
    public final void m52073F0(String str, int i10) throws Throwable {
        int i11 = this.f38888Z + 1;
        this.f38888Z = i11;
        if (i10 == 0 && i11 == 2) {
            m52081q0();
        } else if (i10 == 0) {
            m52053n(this.f38892d0, this.f38893e0);
        }
    }

    /* renamed from: Z0 */
    public final void m52074Z0() {
        SdkFaqCommonManager.INSTANCE.getFAQType(this, SdkFaqManager.getSdk().getSdk("country"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE), m51648n0(), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_COUNTRY), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_DEFAULT_LANGUAGE), new C8354b(FaqClassification.class, this));
    }

    @Override // com.huawei.phoneservice.faq.widget.FaqSdkSearchInput.InterfaceC8432c
    /* renamed from: a */
    public void mo52075a(int i10) throws Throwable {
        Fragment fragment;
        String str;
        FaqLogger.m51840e("FaqActivity", "length>>>>>" + i10);
        if (ModuleConfigUtils.searchRemindEnabled()) {
            if (i10 >= 2) {
                if (this.f38903o0.getVisibility() == 0) {
                    this.f38898j0.setClickable(true);
                    m52069z0(8, 0);
                }
                C8407b c8407b = this.f38900l0;
                if (c8407b == null) {
                    return;
                }
                c8407b.m52336K1(true);
                fragment = this.f38900l0;
                str = "mSearchAssociativeFragment";
            } else {
                ViewOnClickListenerC8408c viewOnClickListenerC8408c = this.f38899k0;
                if (viewOnClickListenerC8408c == null || !viewOnClickListenerC8408c.m52357Y1()) {
                    m52069z0(0, 8);
                    return;
                } else {
                    fragment = this.f38899k0;
                    str = "mSearchHistoryFragment";
                }
            }
            m52071A0(fragment, str);
        }
    }

    /* renamed from: c */
    public void m52078c(String str) {
        String str2;
        FaqSearchActivity.m52210q0(this, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ISOLANGUAGE), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE), SdkFaqManager.getSdk().getSdk("countryCode"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE), SdkFaqManager.getSdk().getSdk("country"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_MODEL), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LEVEL), SdkFaqManager.getSdk().getSdk("accessToken"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_REFRESH), SdkFaqManager.getSdk().getSdk("appVersion"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_SHASN), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_OSVERSION), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CALLFUNCTION), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WECHATID), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_WEIBOID), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_PICID), str);
        C8413c c8413cM52372a = C8413c.m52372a();
        if (FaqConstants.CHANNEL_HICARE.equals(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL))) {
            str2 = FaqConstants.APP_HICARE;
        } else {
            str2 = "App_" + SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL);
        }
        c8413cM52372a.m52377d(this, "searchClick", str, str2, SdkFaqManager.getSdk().getSdk("country"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE));
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Throwable {
        this.f38887Y = 2;
        this.f38888Z = 0;
        setTitle(getResources().getString(R$string.faq_sdk_category_activity_title));
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            this.f38869G.m52468g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            return;
        }
        this.f38869G.m52470i(FaqNoticeView.EnumC8429c.PROGRESS);
        if (!m52080l1()) {
            m52060s0();
        }
        SdkFaqManager.getSdk().apply();
        this.f38899k0 = new ViewOnClickListenerC8408c();
        this.f38900l0 = new C8407b();
        this.f38899k0.m52352J1(this);
        this.f38900l0.m52334I1(this);
        this.f38906r0 = new BadgeHelper(this);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_activity_faq_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: g0 */
    public int[] mo52017g0() {
        return new int[]{R$id.faq_sdk_category_menu, R$id.faq_hot_ll, R$id.faq_other_ll, R$id.list_type};
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        this.f38869G.setOnClickListener(this);
        this.f38897i0.setOnclick(this.f38909u0);
        this.f38875M.setOnClickListener(this);
        this.f38876N.setOnClickListener(this);
        this.f38877O.setOnClickListener(this);
        this.f38878P.setOnClickListener(this);
        this.f38874L.setScrollToBottomListener(new C8362j());
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        this.f38866D = (LinearLayout) findViewById(R$id.faq_content_ll);
        this.f38867E = (LinearLayout) findViewById(R$id.faq_hot_ll);
        this.f38868F = (LinearLayout) findViewById(R$id.faq_sdk_noKnowledge_ll);
        this.f38871I = (LinearLayout) findViewById(R$id.faq_type_ll);
        this.f38872J = (LinearLayout) findViewById(R$id.faq_other_ll);
        this.f38870H = (LinearLayout) findViewById(R$id.faq_sdk_category_menu);
        this.f38874L = (FaqBaseScrollView) findViewById(R$id.faq_sdk_category_scroll_view);
        this.f38875M = (LinearLayout) findViewById(R$id.faq_sdk_category_more_host);
        this.f38876N = (Button) findViewById(R$id.faq_sdk_category_more);
        this.f38877O = (Button) findViewById(R$id.faq_sdk_category_feedback);
        this.f38878P = (Button) findViewById(R$id.faq_sdk_category_online);
        this.f38879Q = findViewById(R$id.faq_sdk_category_gap);
        this.f38880R = LayoutInflater.from(this).inflate(R$layout.faq_sdk_load_more_layout, (ViewGroup) null);
        this.f38869G = (FaqNoticeView) findViewById(R$id.faq_error_noticeView);
        this.f38890b0 = (FaqInScrollListView) findViewById(R$id.hot_list);
        this.f38891c0 = (FaqInScrollListView) findViewById(R$id.other_list);
        this.f38873K = (FaqListGridView) findViewById(R$id.list_type);
        this.f38902n0 = findViewById(R$id.split_line);
        FaqProblemTypeAdapter faqProblemTypeAdapter = new FaqProblemTypeAdapter(this);
        this.f38896h0 = faqProblemTypeAdapter;
        faqProblemTypeAdapter.setOnClickListener(this.f38865C);
        this.f38903o0 = findViewById(R$id.view_floating_layer);
        FaqSdkSearchInput faqSdkSearchInput = (FaqSdkSearchInput) findViewById(R$id.faq_sdk_searchinput);
        this.f38897i0 = faqSdkSearchInput;
        faqSdkSearchInput.setOnClick(this);
        this.f38898j0 = (LinearLayout) findViewById(R$id.faq_sdk_mask);
        m52042b("mSearchHistoryFragment");
        m52042b("mSearchAssociativeFragment");
    }

    /* renamed from: j1 */
    public final boolean m52079j1() {
        if (FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE)) || FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk("country")) || FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL)) || FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk("appVersion")) || FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_SHASN)) || FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION)) || FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_TYPECODE))) {
            m52062t0();
            return true;
        }
        if (FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_MODEL))) {
            SdkFaqManager.getSdk().saveSdk(FaqConstants.FAQ_MODEL, FaqDeviceUtils.getModel());
        }
        if (FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION))) {
            SdkFaqManager.getSdk().saveSdk(FaqConstants.FAQ_EMUIVERSION, FaqDeviceUtils.getEmui());
        }
        if (!FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_OSVERSION))) {
            return false;
        }
        SdkFaqManager.getSdk().saveSdk(FaqConstants.FAQ_OSVERSION, FaqDeviceUtils.getAndroidVersion());
        return false;
    }

    /* renamed from: l1 */
    public final boolean m52080l1() throws Throwable {
        if (!FaqStringUtil.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE))) {
            return m52079j1();
        }
        FaqLogger.m51836d("FaqActivity", "emuiLanguage------NULL");
        m52062t0();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        if (view.getId() == R$id.faq_error_noticeView) {
            m52049h1();
            return;
        }
        if (view.getId() == R$id.faq_sdk_category_online) {
            C8412b.m52367a(this);
            return;
        }
        if (view.getId() == R$id.faq_sdk_category_feedback) {
            if (this.f38889a0) {
                m52054n1();
                return;
            } else {
                m52058p1();
                return;
            }
        }
        if (view.getId() == R$id.faq_sdk_category_more_host || view.getId() == R$id.faq_sdk_category_more) {
            Intent intent = new Intent(this, (Class<?>) FaqProblemClassifyActivity.class);
            intent.putParcelableArrayListExtra("data", this.f38893e0);
            startActivity(intent);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != getResources().getConfiguration().orientation) {
            FaqLanguageUtils.changeAppLanguage(this, SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_ISOLANGUAGE), SdkFaqManager.getSdk().getSdk("country"), configuration);
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (bundle != null) {
            FaqSdk.getSdk().saveMapOnSaveInstanceState(bundle.getString("CacheMap"));
        }
        m52045d1();
        super.onCreate(bundle);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f38900l0 != null) {
            this.f38900l0 = null;
        }
        if (this.f38899k0 != null) {
            this.f38899k0 = null;
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        if (menuItem.getItemId() != R$id.faq_sdk_upload_log) {
            return super.onOptionsItemSelected(menuItem);
        }
        C8416f.m52390b(this);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        new MenuInflater(this).inflate(R$menu.faq_sdk_help_more_menu, menu);
        menu.findItem(R$id.faq_sdk_upload_log).setVisible(ModuleConfigUtils.productUploadLogEnabled() && !TextUtils.isEmpty(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID)));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f38905q0 = this.f38897i0.getEditTextContent();
        m52055o0();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("CacheMap", FaqSdk.getSdk().getMapOnSaveInstance());
    }

    /* renamed from: q0 */
    public final void m52081q0() {
        m52082r0();
        m52063t1();
    }

    /* renamed from: r0 */
    public final void m52082r0() {
        this.f38869G.setVisibility(8);
        this.f38866D.setVisibility(8);
        this.f38868F.setVisibility(0);
        this.f38897i0.setVisibility(8);
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: r1 */
    public final boolean m52083r1() throws Throwable {
        if (this.f38905q0.getText().toString().trim().length() >= 2) {
            return false;
        }
        FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_search_input_word_limits, 2));
        return true;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.ViewOnClickListenerC8408c.g
    /* renamed from: a */
    public void mo52076a(String str, String str2) throws Throwable {
        if (FaqStringUtil.isEmpty(str)) {
            FaqToastUtils.makeText(this, getResources().getString(R$string.faq_sdk_search_input_nothing_toast));
        } else {
            m52078c(str);
            C8414d.m52386h(this, str);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.C8407b.c
    /* renamed from: b */
    public void mo52077b(String str, String str2) {
        if (m52083r1()) {
            return;
        }
        m52078c(str);
        C8414d.m52386h(this, str);
    }
}
