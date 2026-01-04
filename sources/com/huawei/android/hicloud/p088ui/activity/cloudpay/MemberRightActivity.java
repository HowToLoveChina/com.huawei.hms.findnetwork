package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VipRightRecycleViewAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.GetGradeRightDetailResp;
import com.huawei.cloud.pay.model.MemGradeRightDetail;
import com.huawei.cloud.pay.model.MemGradeRightDetails;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import dj.C9158a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p054cj.C1442a;
import p252e9.C9433j;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11296s;
import p514o9.C11842p;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MemberRightActivity extends BuyPackageBaseActivity implements View.OnClickListener {

    /* renamed from: h1 */
    public VipRightRecycleViewAdapter f17150h1;

    /* renamed from: i1 */
    public NotchTopFitLinearLayout f17151i1;

    /* renamed from: j1 */
    public NotchFitLinearLayout f17152j1;

    /* renamed from: k1 */
    public View f17153k1;

    /* renamed from: l1 */
    public View f17154l1;

    /* renamed from: m1 */
    public View f17155m1;

    /* renamed from: n1 */
    public TextView f17156n1;

    /* renamed from: o1 */
    public AutoSizeButton f17157o1;

    /* renamed from: p1 */
    public AutoSizeButton f17158p1;

    /* renamed from: q1 */
    public String f17159q1;

    /* renamed from: r1 */
    public String f17160r1;

    /* renamed from: s1 */
    public boolean f17161s1;

    /* renamed from: t1 */
    public String f17162t1;

    /* renamed from: u1 */
    public String f17163u1;

    /* renamed from: v1 */
    public List<MemGradeRightDetail> f17164v1;

    /* renamed from: w1 */
    public RecyclerView f17165w1;

    /* renamed from: x1 */
    public View f17166x1;

    /* renamed from: y1 */
    public int f17167y1 = -1;

    /* renamed from: z1 */
    public ViewTreeObserver.OnPreDrawListener f17168z1;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.MemberRightActivity$a */
    public class C3635a extends LinearSmoothScroller {
        public C3635a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            return -1;
        }
    }

    /* renamed from: M5 */
    private void m23592M5() {
        this.f17151i1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f17152j1 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.layout_main);
        this.f17166x1 = getLayoutInflater().inflate(R$layout.member_right_activity_header, (ViewGroup) null);
        this.f17165w1 = (RecyclerView) C12809f.m76829b(this, R$id.diamend_right_card);
        this.f17153k1 = C12809f.m76829b(this, R$id.layout_loading);
        this.f17154l1 = C12809f.m76829b(this, R$id.layout_nodata);
        this.f17156n1 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f17155m1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f17157o1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f17154l1.setOnClickListener(this);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f17158p1 = autoSizeButton2;
        C11842p.m70874v1(this, autoSizeButton2);
        this.f17158p1.setOnClickListener(this);
        mo23770l1();
        m23595W5();
        m28587n1();
        m23598L5();
    }

    /* renamed from: N5 */
    public static /* synthetic */ boolean m23593N5(MemGradeRightDetail memGradeRightDetail) {
        return memGradeRightDetail.getStatus() == 1;
    }

    /* renamed from: R5 */
    private void m23594R5(Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        this.f17159q1 = hiCloudSafeIntent.getStringExtra("rightGradeCode");
        this.f17160r1 = hiCloudSafeIntent.getStringExtra("rightRightCode");
        this.f17161s1 = hiCloudSafeIntent.getBooleanExtra("isavailable", false);
        this.f17162t1 = hiCloudSafeIntent.getStringExtra("fromActivity");
        this.f17163u1 = hiCloudSafeIntent.getStringExtra("clickSourceType");
    }

    /* renamed from: W5 */
    private void m23595W5() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f17153k1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: X5 */
    private void m23596X5() {
        this.f17155m1.setVisibility(0);
        this.f17153k1.setVisibility(8);
        this.f17154l1.setVisibility(8);
        this.f17152j1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
        C11060c c11060c = new C11060c();
        this.f21448i = c11060c;
        c11060c.m66636B("06008");
        this.f21448i.m66643I(C11058a.m66627b("06008"));
        this.f21448i.m66637C("com.huawei.hidisk\u0001_cloudspace");
        this.f21448i.m66670z("2.0");
        C9158a.m57503F().m57516N(this.f16524O, this.f21448i, false, "MemberRightActivity");
        C9158a.m57503F().m57508E(this.f16524O, this.f17159q1);
        C9158a.m57503F().m57505B(this.f16524O, this.f21448i, true);
    }

    /* renamed from: K5 */
    public final void m23597K5(List<MemGradeRightDetail> list) {
        this.f17164v1 = new ArrayList();
        if (list == null) {
            C1442a.m8289e("MemberRightActivity", "initShowDetail error, allRightList is null");
        } else {
            this.f17164v1 = (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.g0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return MemberRightActivity.m23593N5((MemGradeRightDetail) obj);
                }
            }).collect(Collectors.toList());
        }
    }

    /* renamed from: L5 */
    public final void m23598L5() {
        if (C0213f.m1377a() == null) {
            return;
        }
        View viewM76831d = C12809f.m76831d(this.f17166x1, R$id.head_member_right_table);
        TextView textView = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow2_size_5);
        TextView textView2 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow2_size_50);
        TextView textView3 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow2_size_200);
        TextView textView4 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow2_size_2048);
        TextView textView5 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow2_size_6144);
        TextView textView6 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow2_size_12288);
        C12809f.m76841n(textView, C0223k.m1524g(this, 5368709120L));
        C12809f.m76841n(textView2, C0223k.m1524g(this, 53687091200L));
        C12809f.m76841n(textView3, C0223k.m1524g(this, RecommendCardConstants.Num.GB_200));
        C12809f.m76841n(textView4, C0223k.m1524g(this, 2199023255552L));
        C12809f.m76841n(textView5, C0223k.m1524g(this, 6597069766656L));
        C12809f.m76841n(textView6, C0223k.m1524g(this, 13194139533312L));
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        TextView textView7 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow3_frequency_1);
        TextView textView8 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow3_frequency_2);
        TextView textView9 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow3_frequency_3);
        TextView textView10 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow3_frequency_4);
        int i10 = R$plurals.member_right_backup_frequency;
        C12809f.m76841n(textView7, resources.getQuantityString(i10, 7, 7));
        C12809f.m76841n(textView8, resources.getQuantityString(i10, 5, 5));
        C12809f.m76841n(textView9, resources.getQuantityString(i10, 3, 3));
        C12809f.m76841n(textView10, resources.getString(R$string.member_right_backup_frequency_one));
        TextView textView11 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow6_strip_1);
        TextView textView12 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow6_strip_2);
        TextView textView13 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow6_strip_3);
        TextView textView14 = (TextView) C12809f.m76831d(viewM76831d, R$id.member_right_tablerow6_strip_4);
        int i11 = R$plurals.free_multiple_backups;
        C12809f.m76841n(textView12, resources.getQuantityString(i11, 3, 3));
        C12809f.m76841n(textView13, resources.getQuantityString(i11, 3, 3));
        C12809f.m76841n(textView14, resources.getQuantityString(i11, 3, 3));
        View viewM76831d2 = C12809f.m76831d(viewM76831d, R$id.member_right_tablerow5);
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            C12809f.m76843p(viewM76831d2, true);
            C12809f.m76841n(textView11, resources.getQuantityString(i11, 1, 1));
        } else {
            C12809f.m76843p(viewM76831d2, false);
            C12809f.m76841n(textView11, resources.getQuantityString(i11, 3, 3));
        }
    }

    /* renamed from: O5 */
    public final /* synthetic */ boolean m23599O5(RecyclerView.AbstractC0846p abstractC0846p, LinearSmoothScroller linearSmoothScroller) {
        this.f17165w1.getViewTreeObserver().removeOnPreDrawListener(this.f17168z1);
        abstractC0846p.startSmoothScroll(linearSmoothScroller);
        return true;
    }

    /* renamed from: P5 */
    public final /* synthetic */ boolean m23600P5(int i10) {
        return TextUtils.equals(this.f17160r1, this.f17164v1.get(i10).getRightCode());
    }

    /* renamed from: Q5 */
    public final /* synthetic */ void m23601Q5(VipRightRecycleViewAdapter.C4093b c4093b, int i10) {
        boolean z10 = c4093b.f19053v.getVisibility() != 0;
        c4093b.m25413T(z10);
        this.f17150h1.m25408M(i10);
        m23602S5(this.f17150h1.m25404I(i10).getRightCode(), z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    /* renamed from: S5 */
    public final void m23602S5(String str, boolean z10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("right_code", str);
        linkedHashMapM79497A.put("grade_code", this.f17159q1);
        linkedHashMapM79497A.put("is_expand", String.valueOf(z10));
        m22842j4("UNIFORM_CLOUDPAY_RIGHT_DETAIL_CHANGE", linkedHashMapM79497A);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        Bundle bundle = new Bundle();
        if (!C11296s.m67786J(this)) {
            m23596X5();
            return;
        }
        C1442a.m8290i("MemberRightActivity", "initData");
        mo19474g5();
        mo19451H3(bundle);
    }

    /* renamed from: T5 */
    public final void m23603T5() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("grade_code", this.f17159q1);
        linkedHashMapM79497A.put("right_code", this.f17160r1);
        linkedHashMapM79497A.put("clickSourceActivity", this.f17162t1);
        linkedHashMapM79497A.put("click_source_type", this.f17163u1);
        m22842j4("UNIFORM_CLOUDPAY_ENTER_RIGHT_DETAIL_ACTIVITY", linkedHashMapM79497A);
    }

    /* renamed from: U5 */
    public final void m23604U5() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar == null || getResources() == null) {
            return;
        }
        int color = getColor(R$color.pay_activity_harmony_bg);
        C0209d.m1306s2(actionBar, this, color);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(color);
            window.getDecorView().setBackgroundColor(color);
        }
    }

    /* renamed from: V5 */
    public final void m23605V5() {
        if (this.f17167y1 < 0) {
            return;
        }
        final C3635a c3635a = new C3635a(this);
        c3635a.setTargetPosition(this.f17167y1 + this.f17150h1.m25406K());
        final RecyclerView.AbstractC0846p layoutManager = this.f17165w1.getLayoutManager();
        this.f17150h1.m25408M(this.f17167y1);
        this.f17168z1 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.h0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f17546a.m23599O5(layoutManager, c3635a);
            }
        };
        this.f17165w1.getViewTreeObserver().addOnPreDrawListener(this.f17168z1);
    }

    /* renamed from: Y5 */
    public final void m23606Y5(List<MemGradeRightDetail> list, String str) {
        List<MemGradeRightDetail> list2;
        this.f17165w1.setVerticalScrollBarEnabled(false);
        VipRightRecycleViewAdapter vipRightRecycleViewAdapter = new VipRightRecycleViewAdapter(list, getLayoutInflater(), this, C9433j.m59164c().m59165b(), str);
        this.f17150h1 = vipRightRecycleViewAdapter;
        vipRightRecycleViewAdapter.m25403H(this.f17166x1);
        if (!TextUtils.isEmpty(this.f17160r1) && (list2 = this.f17164v1) != null) {
            this.f17167y1 = IntStream.range(0, list2.size()).filter(new IntPredicate() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.e0
                @Override // java.util.function.IntPredicate
                public final boolean test(int i10) {
                    return this.f17541a.m23600P5(i10);
                }
            }).findFirst().orElse(-1);
        }
        this.f17165w1.setAdapter(this.f17150h1);
        this.f17165w1.setLayoutManager(new LinearLayoutManager(this));
        m23605V5();
        this.f17150h1.m25407L(new VipRightRecycleViewAdapter.OnItemClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.f0
            @Override // com.huawei.android.hicloud.ui.uiadapter.cloudpay.VipRightRecycleViewAdapter.OnItemClickListener
            /* renamed from: a */
            public final void mo23905a(VipRightRecycleViewAdapter.C4093b c4093b, int i10) {
                this.f17543a.m23601Q5(c4093b, i10);
            }
        });
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f17153k1.setVisibility(0);
        this.f17154l1.setVisibility(8);
        this.f17152j1.setVisibility(8);
        this.f17155m1.setVisibility(8);
        this.f17156n1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17151i1);
        arrayList.add(this.f17152j1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        this.f17155m1.setVisibility(8);
        this.f17153k1.setVisibility(8);
        this.f17154l1.setVisibility(8);
        this.f17152j1.setVisibility(0);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "MemberRightActivity";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f17155m1.setVisibility(8);
        this.f17153k1.setVisibility(8);
        this.f17154l1.setVisibility(0);
        this.f17152j1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f17153k1.setVisibility(0);
        this.f17154l1.setVisibility(8);
        this.f17152j1.setVisibility(8);
        this.f17155m1.setVisibility(8);
        this.f17156n1.setText(R$string.cloudpay_loading);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.layout_nonetwork == id2) {
            mo19460T3();
        } else if (R$id.layout_nodata == id2) {
            mo19460T3();
        } else if (R$id.set_no_net_btn == id2) {
            mo19446D1();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m23595W5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.member_right_activity);
        m23604U5();
        Intent intent = getIntent();
        if (intent == null) {
            C1442a.m8288d("MemberRightActivity", "intent is null");
            mo19477k5();
            return;
        }
        m23594R5(intent);
        m23603T5();
        m23592M5();
        mo19460T3();
        m28587n1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1442a.m8290i("MemberRightActivity", "onNewIntent");
        setIntent(intent);
        m23594R5(intent);
        m23603T5();
        mo19460T3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        GetGradeRightDetailResp getGradeRightDetailResp = this.f16567n0;
        if (getGradeRightDetailResp == null) {
            C1442a.m8288d("MemberRightActivity", "gradeRightDetailResp is null");
            return;
        }
        if (this.f21452m == null) {
            C1442a.m8288d("MemberRightActivity", "showView() --> user is null");
            return;
        }
        MemGradeRightDetails gradeRights = getGradeRightDetailResp.getGradeRights();
        if (gradeRights == null) {
            C1442a.m8288d("MemberRightActivity", "memGradeRightDetails is null");
            mo19477k5();
        } else {
            m23597K5(gradeRights.getRights());
            m23606Y5(this.f17164v1, gradeRights.getGradeCode());
            mo19476h5();
        }
    }
}
