package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import be.C1165a;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherColumnView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GradeCardDisplayBean;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.SelectVouchers;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDefaultResourceBean;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisableGridView;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.secure.android.common.intent.SafeIntent;
import dj.C9158a;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p054cj.C1442a;
import p252e9.C9433j;
import p454lj.C11296s;
import p514o9.C11828b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PurchaseCloudCardActivity extends BuyPackageBaseActivity implements View.OnClickListener, VoucherColumnView.UpdatePackagePriceCallback {

    /* renamed from: A1 */
    public CloudPackage f17350A1;

    /* renamed from: B1 */
    public C11828b f17351B1 = C9433j.m59164c().m59165b();

    /* renamed from: C1 */
    public List<String> f17352C1 = new ArrayList();

    /* renamed from: D1 */
    public GetAvailableGradePackagesResp f17353D1;

    /* renamed from: E1 */
    public VoucherColumnView f17354E1;

    /* renamed from: F1 */
    public LinearLayout f17355F1;

    /* renamed from: G1 */
    public LinearLayout f17356G1;

    /* renamed from: H1 */
    public boolean f17357H1;

    /* renamed from: I1 */
    public LinearLayout f17358I1;

    /* renamed from: J1 */
    public LinearLayout f17359J1;

    /* renamed from: K1 */
    public LinearLayout f17360K1;

    /* renamed from: L1 */
    public TextView f17361L1;

    /* renamed from: M1 */
    public TextView f17362M1;

    /* renamed from: N1 */
    public ScrollView f17363N1;

    /* renamed from: O1 */
    public RelativeLayout f17364O1;

    /* renamed from: h1 */
    public GradeCardView f17365h1;

    /* renamed from: i1 */
    public ScrollDisableGridView f17366i1;

    /* renamed from: j1 */
    public C1165a f17367j1;

    /* renamed from: k1 */
    public NotchTopFitLinearLayout f17368k1;

    /* renamed from: l1 */
    public View f17369l1;

    /* renamed from: m1 */
    public RelativeLayout f17370m1;

    /* renamed from: n1 */
    public NotchFitRelativeLayout f17371n1;

    /* renamed from: o1 */
    public View f17372o1;

    /* renamed from: p1 */
    public View f17373p1;

    /* renamed from: q1 */
    public View f17374q1;

    /* renamed from: r1 */
    public TextView f17375r1;

    /* renamed from: s1 */
    public AutoSizeButton f17376s1;

    /* renamed from: t1 */
    public AutoSizeButton f17377t1;

    /* renamed from: u1 */
    public AutoSizeButton f17378u1;

    /* renamed from: v1 */
    public AutoSizeButton f17379v1;

    /* renamed from: w1 */
    public Voucher f17380w1;

    /* renamed from: x1 */
    public String f17381x1;

    /* renamed from: y1 */
    public List<CloudPackage> f17382y1;

    /* renamed from: z1 */
    public List<PackageGrades> f17383z1;

    /* renamed from: H5 */
    private void m23745H5() throws JSONException {
        VoucherColumnView voucherColumnView;
        if (C0209d.m1226Y0()) {
            C1442a.m8291w("PurchaseCloudCardActivity", "notch_fit_pay_card click too fast");
            return;
        }
        PackageGrades packageGradesM23756K5 = m23756K5(this.f17350A1, this.f17383z1);
        ArrayList arrayList = new ArrayList();
        if (!C11296s.m67787K() || !C11296s.m67789M(this) || (voucherColumnView = this.f17354E1) == null) {
            m22885v5(this.f17350A1, packageGradesM23756K5, "cloud_card_purchase", arrayList, m22882v2(), BigDecimal.ZERO);
        } else {
            arrayList.addAll(voucherColumnView.getSelectVouchers());
            m22880u5(this.f17350A1, packageGradesM23756K5, "cloud_card_purchase", arrayList, m22882v2(), this.f17354E1.getReportVoucherInfo(), BigDecimal.ZERO);
        }
    }

    /* renamed from: L5 */
    private void m23746L5(int i10, Intent intent) throws JSONException {
        if (i10 == 10002) {
            m22759E4();
            C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
            Intent intent2 = new Intent(this, (Class<?>) CloudSpaceUpgradeActivity.class);
            m28580X0(intent2);
            startActivity(intent2);
            finish();
            return;
        }
        if (i10 != 10011) {
            mo19453O4(i10, intent);
            return;
        }
        mo19460T3();
        Intent intent3 = new Intent();
        intent3.putExtra("is_refresh_upgrade", true);
        setResult(-1, intent3);
    }

    /* renamed from: N5 */
    private void m23747N5() {
        this.f17368k1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit);
        this.f17369l1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f17370m1 = (RelativeLayout) C12809f.m76829b(this, R$id.purchase_content_area);
        this.f17365h1 = (GradeCardView) C12809f.m76829b(this, R$id.card_view);
        ScrollDisableGridView scrollDisableGridView = (ScrollDisableGridView) C12809f.m76829b(this, R$id.card_grid_view);
        this.f17366i1 = scrollDisableGridView;
        scrollDisableGridView.setEnabled(false);
        this.f17366i1.setClickable(false);
        this.f17372o1 = C12809f.m76829b(this, R$id.layout_loading);
        this.f17373p1 = C12809f.m76829b(this, R$id.layout_nodata);
        this.f17371n1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.layout_main);
        this.f17363N1 = (ScrollView) C12809f.m76829b(this, R$id.purchase_content_sv);
        this.f17364O1 = (RelativeLayout) C12809f.m76829b(this, R$id.inner_main_layout);
        this.f17358I1 = (LinearLayout) C12809f.m76829b(this, R$id.purchase_package_area);
        this.f17359J1 = (LinearLayout) C12809f.m76829b(this, R$id.purchase_no_package_area);
        this.f17360K1 = (LinearLayout) C12809f.m76829b(this, R$id.purchase_sevice_diff_register);
        this.f17361L1 = (TextView) C12809f.m76829b(this, R$id.diff_current_register);
        this.f17362M1 = (TextView) C12809f.m76829b(this, R$id.diff_current_service);
        this.f17375r1 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f17374q1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f17376s1 = autoSizeButton;
        C11842p.m70866t1(this, autoSizeButton);
        this.f17373p1.setOnClickListener(this);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f17377t1 = autoSizeButton2;
        C11842p.m70866t1(this, autoSizeButton2);
        this.f17377t1.setOnClickListener(this);
        VoucherColumnView voucherColumnView = (VoucherColumnView) C12809f.m76829b(this, R$id.card_voucher_column);
        this.f17354E1 = voucherColumnView;
        voucherColumnView.setUseDardModeImg(true);
        this.f17354E1.setUpdatePackagePriceCallback(this);
        this.f17354E1.setOnClickListener(this);
        GradeCardDefaultResourceBean gradeCardDefaultResourceBean = new GradeCardDefaultResourceBean();
        gradeCardDefaultResourceBean.setVoucherColumnTextColor(R$color.voucher_card_select_color);
        gradeCardDefaultResourceBean.setVoucherArrowDrawable(R$drawable.voucher_arrow_for_purchase_cloud_card);
        gradeCardDefaultResourceBean.setVoucherNonClickableColumnTextColor(R$color.voucher_non_clickable_normal_color);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.voucher_colunm_container);
        this.f17355F1 = linearLayout;
        linearLayout.setBackground(getDrawable(R$drawable.voucher_column_card_bg));
        this.f17356G1 = (LinearLayout) C12809f.m76829b(this, R$id.package_btn_layout);
        AutoSizeButton autoSizeButton3 = (AutoSizeButton) C12809f.m76829b(this, R$id.buy_btn);
        this.f17378u1 = autoSizeButton3;
        autoSizeButton3.setOnClickListener(this);
        m23757M5();
        m23750W5();
    }

    /* renamed from: O5 */
    private void m23748O5() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f17380w1 = (Voucher) m22746B3(new SafeIntent(intent).getStringExtra("iap_intent_voucher_info"), Voucher.class);
        }
    }

    /* renamed from: U5 */
    private void m23749U5() {
        if (getActionBar() == null || this.f16538V == null) {
            return;
        }
        getActionBar().setTitle(this.f16538V.getBuyCardTitle());
    }

    /* renamed from: W5 */
    private void m23750W5() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f17372o1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: Z5 */
    private void m23751Z5() {
        this.f17357H1 = false;
        this.f17374q1.setVisibility(0);
        this.f17372o1.setVisibility(8);
        this.f17373p1.setVisibility(8);
        this.f17371n1.setVisibility(8);
    }

    /* renamed from: d6 */
    private void m23752d6() {
        if (C11296s.m67787K() && C11296s.m67789M(this) && !this.f16535T0.isEmpty()) {
            this.f17354E1.setVisibility(0);
        } else {
            this.f17354E1.setVisibility(8);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f17364O1, this.f17363N1);
        m23764X5(this.f17365h1, 8, this.f17366i1, 4);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f17364O1, this.f17363N1);
        m23764X5(this.f17365h1, 7, this.f17366i1, 4);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f17364O1, this.f17363N1);
        m23764X5(this.f17365h1, 10, this.f17366i1, 5);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f17364O1, this.f17363N1);
        m23764X5(this.f17365h1, 7, this.f17366i1, 4);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f17364O1, this.f17363N1);
        m23764X5(this.f17365h1, 7, this.f17366i1, 4);
    }

    /* renamed from: G5 */
    public final void m23753G5(CloudPackage cloudPackage, PackageGrades packageGrades) {
        if (cloudPackage == null) {
            C11839m.m70687e("PurchaseCloudCardActivity", "select package is null");
            return;
        }
        if (this.f21452m == null) {
            C1442a.m8289e("PurchaseCloudCardActivity", "startPay user is null.");
            return;
        }
        this.f16564k0 = cloudPackage;
        int productType = cloudPackage.getProductType();
        CloudSpace cloudSpace = new CloudSpace();
        this.f16520M = cloudSpace;
        cloudSpace.setId(cloudPackage.getId());
        this.f16520M.setProductName(cloudPackage.getProductName(this));
        this.f16520M.setProductType(productType);
        this.f16520M.setDurationMonth(cloudPackage.getDurationMonth());
        this.f16520M.setCapacity(cloudPackage.getCapacity());
        this.f16520M.setBaseCapacity(this.f21452m.getBaseCapacity());
        this.f16520M.setCurrency(cloudPackage.getCurrency());
        this.f16520M.setGrade(packageGrades);
        m22809W4(productType, cloudPackage.getPrice(), cloudPackage.getSpPrice());
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f17364O1, this.f17363N1);
        m23765Y5(this.f17365h1, this.f17366i1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
    }

    /* renamed from: I5 */
    public final int m23754I5(String str) {
        Iterator<CloudPackage> it = this.f17382y1.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getId().equals(str)) {
                return i10;
            }
            i10++;
        }
        return 0;
    }

    /* renamed from: J5 */
    public int m23755J5() {
        return C0209d.m1195O(this) >= 1.75f ? R$layout.purchase_cloud_card_layout_font_scale : R$layout.purchase_cloud_card_layout;
    }

    /* renamed from: K5 */
    public final PackageGrades m23756K5(CloudPackage cloudPackage, List<PackageGrades> list) {
        if (cloudPackage == null || list == null) {
            C1442a.m8289e("PurchaseCloudCardActivity", "getPackageGrade, param is null");
            return null;
        }
        String gradeCode = cloudPackage.getGradeCode();
        if (TextUtils.isEmpty(gradeCode)) {
            return null;
        }
        for (PackageGrades packageGrades : list) {
            if (gradeCode.equals(packageGrades.getGradeCode())) {
                return packageGrades;
            }
        }
        return null;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: L2 */
    public void mo22779L2(int i10) {
        if (i10 != 107) {
            super.mo22779L2(i10);
        } else {
            m28583a1();
            mo22716i5();
        }
    }

    /* renamed from: M5 */
    public final void m23757M5() {
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.gift_btn);
        this.f17379v1 = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            this.f17379v1.setVisibility(0);
        } else {
            this.f17379v1.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O2 */
    public void mo22788O2(int i10) {
        if (i10 != 107) {
            super.mo22788O2(i10);
        } else {
            m28583a1();
            mo22716i5();
        }
    }

    /* renamed from: P5 */
    public final void m23758P5() {
        Serializable serializableExtra;
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C1442a.m8289e("PurchaseCloudCardActivity", "preloadActionBarTitle actionBar is null.");
            return;
        }
        try {
            serializableExtra = new SafeIntent(getIntent()).getSerializableExtra("params");
        } catch (Exception e10) {
            C11839m.m70687e("PurchaseCloudCardActivity", "preloadActionBarTitle error " + e10.getMessage());
            serializableExtra = null;
        }
        if (serializableExtra instanceof GetClientUIConfigResp) {
            GetClientUIConfigResp getClientUIConfigResp = (GetClientUIConfigResp) serializableExtra;
            actionBar.setTitle(getClientUIConfigResp.getBuyCardTitle());
            setTitle(getClientUIConfigResp.getBuyCardTitle());
        } else {
            int i10 = R$string.cloudpay_app_name;
            actionBar.setTitle(i10);
            setTitle(i10);
        }
    }

    /* renamed from: Q5 */
    public void m23759Q5(int i10) {
        m23763V5(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: R2 */
    public void mo19456R2(Object obj) {
        List<Voucher> availableVouchers;
        List<String> relatedPackages;
        if (!(obj instanceof GetAvailableGradePackagesResp)) {
            C1442a.m8289e("PurchaseCloudCardActivity", "dealGetAvailableGradePackagesSuccess, resp obj error");
            mo19477k5();
            return;
        }
        GetAvailableGradePackagesResp getAvailableGradePackagesResp = (GetAvailableGradePackagesResp) obj;
        this.f17353D1 = getAvailableGradePackagesResp;
        m23769e6(getAvailableGradePackagesResp);
        if (C11296s.m67787K() && C11296s.m67789M(this)) {
            if (this.f17380w1 != null && (availableVouchers = this.f17353D1.getAvailableVouchers()) != null && !availableVouchers.isEmpty() && (relatedPackages = availableVouchers.get(0).getRelatedPackages()) != null && !relatedPackages.isEmpty()) {
                this.f17381x1 = relatedPackages.get(0);
            }
            List<CloudPackage> list = this.f17382y1;
            if (list == null || list.isEmpty()) {
                this.f16535T0 = new ArrayList();
            } else {
                C9158a.m57503F().m57556u(this.f16524O, this.f17352C1);
            }
        } else {
            this.f16535T0 = new ArrayList();
        }
        mo19479s5();
    }

    /* renamed from: R5 */
    public final void m23760R5(int i10, CloudPackage cloudPackage) {
        if (cloudPackage == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("card_position", String.valueOf(i10));
        linkedHashMapM79497A.put("package_id", cloudPackage.getId());
        linkedHashMapM79497A.put("capacity", String.valueOf(cloudPackage.getCapacity()));
        linkedHashMapM79497A.put("productType", String.valueOf(cloudPackage.getProductType()));
        linkedHashMapM79497A.put("duration_month", String.valueOf(cloudPackage.getDurationMonth()));
        linkedHashMapM79497A.put("price", String.valueOf(cloudPackage.getPrice()));
        VoucherColumnView voucherColumnView = this.f17354E1;
        if (voucherColumnView != null) {
            linkedHashMapM79497A.put("voucher_column_state", String.valueOf(voucherColumnView.getColumnState()));
        }
        m22842j4("UNIFORM_CLOUDPAY_PURCHASE_CARD_CHANGE_CARD", linkedHashMapM79497A);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        if (C11296s.m67786J(this)) {
            return false;
        }
        C11829c.m70612r1(this);
        return true;
    }

    /* renamed from: S5 */
    public final void m23761S5() {
        m22842j4("UNIFORM_CLOUDPAY_PURCHASE_CARD_CLICK_PRESENT", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        if (!C11296s.m67786J(this)) {
            C1442a.m8289e("PurchaseCloudCardActivity", "initData network is not ok.");
            m23751Z5();
            return;
        }
        if (this.f17357H1) {
            C1442a.m8291w("PurchaseCloudCardActivity", "initData is running , cancel.");
            return;
        }
        C1442a.m8290i("PurchaseCloudCardActivity", "initData");
        this.f17357H1 = true;
        mo19474g5();
        this.f21452m = null;
        this.f16538V = null;
        m28588o1("06012");
        this.f17353D1 = null;
        this.f16535T0 = null;
        List<String> list = this.f17352C1;
        if (list != null) {
            list.clear();
        }
        VoucherColumnView voucherColumnView = this.f17354E1;
        if (voucherColumnView != null) {
            voucherColumnView.m23838h();
        }
        Filter filter = new Filter();
        filter.setShowPlace(1);
        C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
        C9158a.m57503F().m57516N(this.f16524O, this.f21448i, false, "PurchaseActivity");
        Voucher voucher = this.f17380w1;
        String productId = voucher != null ? voucher.getProductId() : null;
        if (!C11296s.m67787K() || !C11296s.m67789M(this) || productId == null || productId.equals("0")) {
            C9158a.m57503F().m57557v(this.f16524O, filter, null, m22882v2(), false);
        } else {
            C9158a.m57503F().m57557v(this.f16524O, filter, this.f17380w1.getVoucherCode(), m22882v2(), false);
        }
        C1165a c1165a = new C1165a(this);
        this.f17367j1 = c1165a;
        this.f17366i1.setAdapter((ListAdapter) c1165a);
    }

    /* renamed from: T5 */
    public final void m23762T5() {
        m22842j4("UNIFORM_CLOUDPAY_ENTER_PURCHASE_CARD_ACTIVITY", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: U */
    public void mo23559U(BigDecimal bigDecimal, String str, List<Voucher> list) {
    }

    /* renamed from: V5 */
    public final void m23763V5(int i10) {
        String str;
        List<CloudPackage> list = this.f17382y1;
        if (list == null || this.f17383z1 == null || list.size() <= i10 || this.f17367j1 == null) {
            C11839m.m70687e("PurchaseCloudCardActivity", "spacePackages or packageGrades error");
            return;
        }
        CloudPackage cloudPackage = this.f17382y1.get(i10);
        GradeCardDisplayBean gradeCardDisplayBean = new GradeCardDisplayBean(cloudPackage, m23756K5(cloudPackage, this.f17383z1));
        GradeCardView gradeCardView = this.f17365h1;
        if (gradeCardView != null) {
            gradeCardView.setData(gradeCardDisplayBean, this.f16538V.getRightTitle(), this.f17351B1, false);
        }
        this.f17367j1.m7279d(i10);
        this.f17350A1 = cloudPackage;
        if (C11296s.m67787K() && C11296s.m67789M(this)) {
            if (this.f17380w1 == null || (str = this.f17381x1) == null) {
                this.f17354E1.m23842l(this.f16535T0, this.f17350A1, true, BigDecimal.ZERO);
            } else {
                this.f17354E1.m23841k(this.f16535T0, this.f17382y1.get(m23754I5(str)), true, this.f17380w1.getVoucherCode(), BigDecimal.ZERO);
            }
        }
        m23760R5(i10, cloudPackage);
    }

    /* renamed from: X5 */
    public final void m23764X5(GradeCardView gradeCardView, int i10, ScrollDisableGridView scrollDisableGridView, int i11) {
        if (gradeCardView != null) {
            gradeCardView.setRightColumns(i10);
        }
        if (scrollDisableGridView != null) {
            scrollDisableGridView.setNumColumns(i11);
        }
    }

    /* renamed from: Y5 */
    public final void m23765Y5(GradeCardView gradeCardView, ScrollDisableGridView scrollDisableGridView) {
        if (gradeCardView != null) {
            gradeCardView.setRightColumns(5);
        }
        if (scrollDisableGridView != null) {
            scrollDisableGridView.setNumColumns(3);
        }
    }

    /* renamed from: a6 */
    public final void m23766a6() {
        LinearLayout linearLayout = this.f17358I1;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.f17359J1;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        LinearLayout linearLayout3 = this.f17360K1;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        AutoSizeButton autoSizeButton = this.f17378u1;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(8);
        }
        AutoSizeButton autoSizeButton2 = this.f17379v1;
        if (autoSizeButton2 != null) {
            autoSizeButton2.setVisibility(8);
        }
    }

    /* renamed from: b6 */
    public final void m23767b6() {
        LinearLayout linearLayout = this.f17358I1;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f17359J1;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.f17360K1;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        AutoSizeButton autoSizeButton = this.f17378u1;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(0);
            this.f17378u1.setEnabled(true);
        }
        AutoSizeButton autoSizeButton2 = this.f17379v1;
        if (autoSizeButton2 != null) {
            autoSizeButton2.setVisibility(0);
            this.f17379v1.setEnabled(true);
        }
    }

    /* renamed from: c6 */
    public final void m23768c6() {
        LinearLayout linearLayout = this.f17358I1;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.f17359J1;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.f17360K1;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
            m22775J4("cloud_card_purchase");
        }
        AutoSizeButton autoSizeButton = this.f17378u1;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(8);
        }
        AutoSizeButton autoSizeButton2 = this.f17379v1;
        if (autoSizeButton2 != null) {
            autoSizeButton2.setVisibility(8);
        }
        boolean zM1224X1 = C0209d.m1224X1();
        if (this.f17361L1 != null) {
            String string = getString(R$string.cloudpay_current_register, C0209d.m1177I(C13452e.m80781L().m80942m()));
            TextView textView = this.f17361L1;
            if (zM1224X1) {
                string = getString(R$string.cloudpay_change_service_tw, string);
            }
            textView.setText(string);
        }
        TextView textView2 = this.f17362M1;
        if (textView2 != null) {
            if (zM1224X1) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(getString(R$string.cloudpay_current_service, C0209d.m1177I(C13452e.m80781L().m80921h0())));
            }
        }
    }

    /* renamed from: e6 */
    public final void m23769e6(GetAvailableGradePackagesResp getAvailableGradePackagesResp) {
        ArrayList arrayList = new ArrayList();
        List<CloudPackage> spacePackages = getAvailableGradePackagesResp.getSpacePackages();
        List<PackageGrades> packageGrades = getAvailableGradePackagesResp.getPackageGrades();
        List<String> list = this.f17352C1;
        if (list != null) {
            list.clear();
        }
        for (PackageGrades packageGrades2 : packageGrades) {
            String gradeCode = packageGrades2.getGradeCode();
            long capacity = packageGrades2.getCapacity();
            for (CloudPackage cloudPackage : spacePackages) {
                if (cloudPackage != null && cloudPackage.getGradeCode().equals(gradeCode) && capacity == cloudPackage.getCapacity()) {
                    arrayList.add(cloudPackage);
                    this.f17352C1.add(cloudPackage.getId());
                }
            }
        }
        this.f17382y1 = arrayList;
        this.f17383z1 = packageGrades;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f17372o1.setVisibility(0);
        this.f17373p1.setVisibility(8);
        this.f17371n1.setVisibility(8);
        this.f17374q1.setVisibility(8);
        this.f17375r1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17368k1);
        arrayList.add(this.f17369l1);
        arrayList.add(this.f17371n1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        this.f17371n1.setVisibility(0);
        this.f17372o1.setVisibility(8);
        this.f17373p1.setVisibility(8);
        this.f17374q1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "PurchaseCloudCardActivity";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: i4 */
    public void mo22839i4() {
        if (this.f16563j0.size() > 0) {
            C1442a.m8290i("PurchaseCloudCardActivity", "refresh vouchers");
            mo19460T3();
            Intent intent = new Intent();
            intent.putExtra("is_refresh_upgrade", true);
            setResult(-1, intent);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: i5 */
    public void mo22716i5() {
        super.mo22716i5();
        this.f17357H1 = false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f17357H1 = false;
        this.f17373p1.setVisibility(0);
        this.f17372o1.setVisibility(8);
        this.f17371n1.setVisibility(8);
        this.f17374q1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: l1 */
    public void mo23770l1() {
        super.mo23770l1();
        C11842p.m70862s1(this, this.f17378u1);
        C11842p.m70862s1(this, this.f17379v1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f17372o1.setVisibility(0);
        this.f17373p1.setVisibility(8);
        this.f17371n1.setVisibility(8);
        this.f17374q1.setVisibility(8);
        this.f17375r1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: m */
    public void mo23575m() {
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: n0 */
    public void mo23577n0(String str) {
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        C1442a.m8290i("PurchaseCloudCardActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (i11 == -1) {
            m23746L5(i10, hiCloudSafeIntent);
        }
        super.onActivityResult(i10, i11, hiCloudSafeIntent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        int id2 = view.getId();
        if (R$id.layout_nonetwork == id2 || R$id.layout_nodata == id2) {
            mo19460T3();
            return;
        }
        if (R$id.set_no_net_btn == id2) {
            mo19446D1();
            return;
        }
        if (id2 == R$id.buy_btn) {
            m23745H5();
            return;
        }
        if (id2 != R$id.gift_btn) {
            if (id2 == R$id.card_voucher_column) {
                this.f17354E1.m23850t(this.f16535T0, this.f17350A1, BigDecimal.ZERO);
                return;
            }
            C11839m.m70686d("PurchaseCloudCardActivity", "some view clicked, view id is " + id2);
            return;
        }
        if (C0209d.m1226Y0()) {
            C1442a.m8291w("PurchaseCloudCardActivity", "notch_fit_pay_card click too fast");
            return;
        }
        CloudPackage cloudPackage = this.f17350A1;
        PackageGrades packageGradesM23756K5 = m23756K5(cloudPackage, this.f17383z1);
        if (packageGradesM23756K5 == null) {
            C1442a.m8289e("PurchaseCloudCardActivity", "click gift button error, no package grade");
            return;
        }
        Serializable gradeCardDisplayBean = new GradeCardDisplayBean(cloudPackage, packageGradesM23756K5);
        m23753G5(cloudPackage, packageGradesM23756K5);
        m23761S5();
        Intent intent = new Intent();
        intent.setClass(this, PresentCloudCardActivity.class);
        intent.putExtra("selected_card_data", gradeCardDisplayBean);
        intent.putExtra("selected_package", this.f16520M);
        intent.putExtra("params", this.f16538V);
        intent.putExtra("package_for_present", cloudPackage);
        intent.putExtra("user", this.f21452m);
        if (this.f17354E1 != null) {
            SelectVouchers selectVouchers = new SelectVouchers();
            selectVouchers.setSelectVoucherList(this.f17354E1.getSelectVouchers());
            intent.putExtra("select_vouchers", selectVouchers);
        }
        m28580X0(intent);
        startActivityForResult(intent, RequestManager.NOTIFY_CONNECT_SUCCESS);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VoucherColumnView voucherColumnView = this.f17354E1;
        if (voucherColumnView != null) {
            voucherColumnView.m23833c();
        }
        m23750W5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        m23762T5();
        m23748O5();
        setContentView(m23755J5());
        m23758P5();
        m23747N5();
        mo19460T3();
        mo23770l1();
        m28587n1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        List<CloudPackage> list;
        C1165a c1165a;
        if (this.f17353D1 == null || this.f16535T0 == null || this.f16538V == null || this.f21452m == null) {
            C1442a.m8291w("PurchaseCloudCardActivity", "showView data is not ready.");
            return;
        }
        C1442a.m8290i("PurchaseCloudCardActivity", "showView start");
        this.f17357H1 = false;
        m23749U5();
        mo19476h5();
        List<PackageGrades> list2 = this.f17383z1;
        if (list2 == null || list2.isEmpty() || (list = this.f17382y1) == null || list.isEmpty()) {
            C1442a.m8289e("PurchaseCloudCardActivity", "packageGrades or spacePackages is null or empty.");
            if (C11296s.m67795S()) {
                m23768c6();
                return;
            } else {
                m23766a6();
                return;
            }
        }
        m23767b6();
        if (this.f17366i1 != null && (c1165a = this.f17367j1) != null) {
            c1165a.m7278c(this.f17382y1, this.f17383z1, this.f16538V.getRightTitle(), this.f17351B1);
        }
        m23752d6();
        if (TextUtils.isEmpty(this.f17381x1)) {
            m23763V5(0);
        } else {
            m23763V5(m23754I5(this.f17381x1));
        }
        this.f17380w1 = null;
        this.f17381x1 = null;
        m22784M4("cloud_card_purchase");
        C1442a.m8290i("PurchaseCloudCardActivity", "showView end");
    }
}
