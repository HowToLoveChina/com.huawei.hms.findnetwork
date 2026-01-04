package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import be.C1168d;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.R$plurals;
import com.huawei.cloud.pay.config.bean.BannerAfterPayGoto;
import com.huawei.cloud.pay.config.bean.BannerAfterPayItem;
import com.huawei.cloud.pay.config.bean.BannerAfterPayRealtePackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GradePicture;
import com.huawei.cloud.pay.model.MemGradeRight;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.PackageGrade;
import com.huawei.cloud.pay.model.PaySuccessShowNeedData;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.HiCloudLink;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10342a;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import p014aj.C0202a;
import p015ak.C0213f;
import p015ak.C0223k;
import p054cj.C1442a;
import p252e9.C9436m;
import p336he.C10155f;
import p454lj.C11278a;
import p454lj.C11290m;
import p454lj.C11293p;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;
import tj.C13019a;

/* loaded from: classes3.dex */
public class CloudSpacePayActivity extends BasePayActivity implements View.OnClickListener {

    /* renamed from: A0 */
    public String f16812A0;

    /* renamed from: C */
    public NotchTopFitLinearLayout f16814C;

    /* renamed from: D */
    public NotchFitLinearLayout f16816D;

    /* renamed from: E */
    public NotchFitLinearLayout f16817E;

    /* renamed from: F */
    public TextView f16818F;

    /* renamed from: G */
    public TextView f16819G;

    /* renamed from: H */
    public TextView f16820H;

    /* renamed from: I */
    public TextView f16821I;

    /* renamed from: J */
    public TextView f16822J;

    /* renamed from: K */
    public TextView f16823K;

    /* renamed from: L */
    public TextView f16824L;

    /* renamed from: M */
    public TextView f16825M;

    /* renamed from: N */
    public TextView f16826N;

    /* renamed from: O */
    public TextView f16827O;

    /* renamed from: P */
    public TextView f16828P;

    /* renamed from: Q */
    public TextView f16829Q;

    /* renamed from: R */
    public TextView f16830R;

    /* renamed from: S */
    public TextView f16831S;

    /* renamed from: T */
    public AutoSizeButton f16832T;

    /* renamed from: U */
    public RelativeLayout f16833U;

    /* renamed from: V */
    public RelativeLayout f16834V;

    /* renamed from: W */
    public RelativeLayout f16835W;

    /* renamed from: X */
    public TextView f16836X;

    /* renamed from: Y */
    public View f16837Y;

    /* renamed from: Z */
    public PaySuccessShowNeedData f16838Z;

    /* renamed from: a0 */
    public TextView f16839a0;

    /* renamed from: b0 */
    public TextView f16840b0;

    /* renamed from: c0 */
    public RelativeLayout f16841c0;

    /* renamed from: d0 */
    public TextView f16842d0;

    /* renamed from: e0 */
    public TextView f16843e0;

    /* renamed from: f0 */
    public TextView f16844f0;

    /* renamed from: g0 */
    public TextView f16845g0;

    /* renamed from: h0 */
    public LinearLayout f16846h0;

    /* renamed from: i0 */
    public RecyclerView f16847i0;

    /* renamed from: j0 */
    public TextView f16848j0;

    /* renamed from: k0 */
    public TextView f16849k0;

    /* renamed from: l0 */
    public TextView f16850l0;

    /* renamed from: m0 */
    public TextView f16851m0;

    /* renamed from: n0 */
    public LinearLayout f16852n0;

    /* renamed from: o0 */
    public LinearLayout f16853o0;

    /* renamed from: p0 */
    public LinearLayout f16854p0;

    /* renamed from: q0 */
    public ScrollView f16855q0;

    /* renamed from: r0 */
    public TextView f16856r0;

    /* renamed from: s0 */
    public TextView f16857s0;

    /* renamed from: t0 */
    public TextView f16858t0;

    /* renamed from: u0 */
    public View f16859u0;

    /* renamed from: v0 */
    public ImageView f16860v0;

    /* renamed from: w0 */
    public String f16861w0;

    /* renamed from: x0 */
    public String f16862x0;

    /* renamed from: y0 */
    public String f16863y0;

    /* renamed from: z0 */
    public String f16864z0;

    /* renamed from: B0 */
    public String f16813B0 = "";

    /* renamed from: C0 */
    public Handler f16815C0 = new HandlerC3610a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpacePayActivity$a */
    public class HandlerC3610a extends Handler {
        public HandlerC3610a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 7030) {
                C1442a.m8290i("CloudSpacePayActivity", "GET_BANNER_AFTER_PAY_PARAMS_SUCCESS");
                CloudSpacePayActivity.this.m23254j2((BannerAfterPayItem) message.obj);
            } else if (i10 == 7031) {
                C1442a.m8290i("CloudSpacePayActivity", "GET_BANNER_AFTER_PAY_PARAMS_FAIL");
                CloudSpacePayActivity.this.m23254j2(null);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpacePayActivity$b */
    public class ViewTreeObserverOnGlobalLayoutListenerC3611b implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC3611b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            CloudSpacePayActivity.this.f16860v0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredWidth = CloudSpacePayActivity.this.f16860v0.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = CloudSpacePayActivity.this.f16860v0.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.height = Math.round(measuredWidth * CloudSpacePayActivity.this.m23242U1());
                CloudSpacePayActivity.this.f16860v0.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpacePayActivity$c */
    public class ViewOnClickListenerC3612c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ BannerAfterPayItem f16867a;

        public ViewOnClickListenerC3612c(BannerAfterPayItem bannerAfterPayItem) {
            this.f16867a = bannerAfterPayItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BannerAfterPayGoto bannerAfterPayGoto = this.f16867a.getBannerAfterPayGoto();
            long bannerId = this.f16867a.getBannerId();
            if (bannerAfterPayGoto == null) {
                C1442a.m8289e("CloudSpacePayActivity", "onClick bannerAfterPayGoto is null.");
                return;
            }
            String type = bannerAfterPayGoto.getType();
            String uri = bannerAfterPayGoto.getUri();
            String bannerName = this.f16867a.getBannerName();
            float percentage = this.f16867a.getPercentage();
            HiCloudLink hiCloudLink = new HiCloudLink(CloudSpacePayActivity.this);
            if (hiCloudLink.checkModuleEnable(type, uri)) {
                try {
                    hiCloudLink.flyTo(type, uri);
                    CloudSpacePayActivity.this.m23255k2(bannerName, type, uri, bannerId, percentage);
                    return;
                } catch (ActivityNotFoundException e10) {
                    C1442a.m8289e("CloudSpacePayActivity", "initBanner ActivityNotFoundException : " + e10.toString());
                    return;
                }
            }
            C1442a.m8288d("CloudSpacePayActivity", "initBanner disable type=" + type + ", uri=" + uri + ", bannerName= " + bannerName);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpacePayActivity$d */
    public class C3613d extends RecyclerView.AbstractC0845o {

        /* renamed from: h0 */
        public int f16869h0;

        /* renamed from: i0 */
        public int f16870i0;

        public C3613d(int i10, int i11) {
            this.f16869h0 = i10;
            this.f16870i0 = i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
            if (this.f16870i0 == 0) {
                C1442a.m8289e("CloudSpacePayActivity", "columnCount is 0.");
            } else if (recyclerView == null) {
                C1442a.m8289e("CloudSpacePayActivity", "parent is null.");
            } else if (recyclerView.getChildAdapterPosition(view) / this.f16870i0 > 0) {
                rect.top = this.f16869h0;
            }
        }
    }

    /* renamed from: d2 */
    public static int m23233d2(Context context) {
        if (C11842p.m70771U0()) {
            C11842p.m70753O0(context);
            return 32;
        }
        if (!C11842p.m70747M0(context)) {
            return C11842p.m70753O0(context) ? 32 : 20;
        }
        C11842p.m70753O0(context);
        return 32;
    }

    /* renamed from: e2 */
    public static int m23234e2(Context context) {
        if (C11842p.m70771U0()) {
            return C11842p.m70753O0(context) ? 6 : 5;
        }
        if (!C11842p.m70747M0(context)) {
            return C11842p.m70753O0(context) ? 5 : 3;
        }
        C11842p.m70753O0(context);
        return 5;
    }

    /* renamed from: g2 */
    private void m23235g2() {
        this.f16814C = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.cloudpay_success_view);
        this.f16816D = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_fit_layout);
        this.f16817E = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.bottom_layout);
        this.f16855q0 = (ScrollView) C12809f.m76829b(this, R$id.pay_suc_scroll_view);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.pay_ok_btn);
        this.f16832T = autoSizeButton;
        C11842p.m70866t1(this, autoSizeButton);
        this.f16832T.setOnClickListener(this);
        this.f16856r0 = (TextView) C12809f.m76829b(this, R$id.pay_success_text);
        this.f16833U = (RelativeLayout) C12809f.m76829b(this, R$id.total_cost_layout);
        this.f16834V = (RelativeLayout) C12809f.m76829b(this, R$id.plan_layout);
        this.f16835W = (RelativeLayout) C12809f.m76829b(this, R$id.next_renewal_layout);
        this.f16836X = (TextView) C12809f.m76829b(this, R$id.perks_text_veiw);
        this.f16837Y = C12809f.m76829b(this, R$id.pay_divider_view);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.pay_origin_view);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.pay_current_view);
        this.f16857s0 = (TextView) C12809f.m76831d(linearLayout, R$id.pay_success_original_grade);
        int i10 = R$id.current_title;
        this.f16818F = (TextView) C12809f.m76831d(linearLayout, i10);
        int i11 = R$id.used_capacity_title;
        this.f16820H = (TextView) C12809f.m76831d(linearLayout, i11);
        int i12 = R$id.base_capacity_title;
        this.f16822J = (TextView) C12809f.m76831d(linearLayout, i12);
        int i13 = R$id.pay_capacity_title;
        this.f16824L = (TextView) C12809f.m76831d(linearLayout, i13);
        int i14 = R$id.used_capacity_value;
        this.f16821I = (TextView) C12809f.m76831d(linearLayout, i14);
        int i15 = R$id.base_capacity_value;
        this.f16823K = (TextView) C12809f.m76831d(linearLayout, i15);
        int i16 = R$id.pay_capacity_value;
        this.f16825M = (TextView) C12809f.m76831d(linearLayout, i16);
        this.f16858t0 = (TextView) C12809f.m76831d(linearLayout2, R$id.pay_success_current_grade);
        this.f16819G = (TextView) C12809f.m76831d(linearLayout2, i10);
        this.f16826N = (TextView) C12809f.m76831d(linearLayout2, i11);
        this.f16828P = (TextView) C12809f.m76831d(linearLayout2, i12);
        View viewM76831d = C12809f.m76831d(linearLayout2, R$id.layout_basespace);
        this.f16830R = (TextView) C12809f.m76831d(linearLayout2, i13);
        this.f16827O = (TextView) C12809f.m76831d(linearLayout2, i14);
        this.f16829Q = (TextView) C12809f.m76831d(linearLayout2, i15);
        this.f16831S = (TextView) C12809f.m76831d(linearLayout2, i16);
        this.f16839a0 = (TextView) C12809f.m76829b(this, R$id.pay_success_amount_title);
        this.f16841c0 = (RelativeLayout) C12809f.m76829b(this, R$id.pay_success_amount_container);
        this.f16840b0 = (TextView) C12809f.m76829b(this, R$id.pay_success_amount);
        this.f16842d0 = (TextView) C12809f.m76829b(this, R$id.pay_success_buy_member_title);
        this.f16843e0 = (TextView) C12809f.m76829b(this, R$id.pay_success_buy_member);
        this.f16844f0 = (TextView) C12809f.m76829b(this, R$id.pay_success_next_renewal_time_title);
        this.f16845g0 = (TextView) C12809f.m76829b(this, R$id.pay_success_next_renewal_time);
        this.f16846h0 = (LinearLayout) C12809f.m76829b(this, R$id.pay_success_privileges_area);
        this.f16847i0 = (RecyclerView) C12809f.m76829b(this, R$id.pay_success_privileges_list);
        this.f16848j0 = (TextView) C12809f.m76829b(this, R$id.give_member_title);
        this.f16849k0 = (TextView) C12809f.m76829b(this, R$id.give_member);
        this.f16850l0 = (TextView) C12809f.m76829b(this, R$id.give_time_title);
        this.f16851m0 = (TextView) C12809f.m76829b(this, R$id.give_time);
        this.f16852n0 = (LinearLayout) C12809f.m76829b(this, R$id.fixed_time_order_info_area);
        this.f16853o0 = (LinearLayout) C12809f.m76829b(this, R$id.month_order_info_area);
        this.f16854p0 = (LinearLayout) C12809f.m76829b(this, R$id.give_order_info_area);
        if (C10155f.m63293q(500L)) {
            linearLayout.setVisibility(8);
            viewM76831d.setVisibility(8);
        }
        Intent intent = new Intent();
        intent.putExtra(MapKeyNames.RESULT_CODE, 0);
        setResult(-1, intent);
        m23252h2();
        m28587n1();
        this.f16859u0 = C12809f.m76829b(this, R$id.after_banner_divider);
        this.f16860v0 = (ImageView) C12809f.m76829b(this, R$id.after_pay_banner);
        m23238s2();
        mo23770l1();
    }

    /* renamed from: n2 */
    public static void m23236n2(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(i10);
                layoutParams2.setMarginEnd(i10);
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: o2 */
    private void m23237o2(int i10) {
        Intent intent = new Intent();
        intent.putExtra(MapKeyNames.RESULT_CODE, i10);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: s2 */
    private void m23238s2() {
        C1442a.m8290i("CloudSpacePayActivity", "showView");
        if (this.f16838Z == null) {
            C1442a.m8289e("CloudSpacePayActivity", "initView needData is null.");
            m23239R1();
            return;
        }
        ActionBar actionBar = getActionBar();
        int subType = this.f16838Z.getSubType();
        if (subType != 0) {
            if (subType == 1) {
                m23260r2(actionBar);
                return;
            }
            C1442a.m8289e("CloudSpacePayActivity", "showView invalid subType = " + subType);
            m23239R1();
            return;
        }
        this.f16856r0.setText(R$string.cloudpay_pay_success_text);
        if (actionBar != null) {
            int i10 = R$string.cloudpay_upgrade_storage;
            actionBar.setTitle(i10);
            setTitle(i10);
        }
        int productType = this.f16838Z.getProductType();
        boolean zM67772p = C11293p.m67772p(this.f21452m);
        C1442a.m8290i("CloudSpacePayActivity", "hasWorryFree: " + zM67772p);
        if (productType == 5 || productType == 7 || productType == 12 || zM67772p) {
            this.f16852n0.setVisibility(0);
            this.f16853o0.setVisibility(8);
            this.f16854p0.setVisibility(8);
            m23249b2();
            m23248a2();
            m23247Z1();
            return;
        }
        if (productType == 6 || productType == 8) {
            this.f16852n0.setVisibility(8);
            this.f16853o0.setVisibility(0);
            this.f16854p0.setVisibility(8);
            m23259q2();
            m23247Z1();
            return;
        }
        C1442a.m8290i("CloudSpacePayActivity", "showView invalid mProductType = " + productType);
        m28583a1();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f16855q0, this.f16817E);
        m23236n2(this.f16837Y, C11842p.m70840n(this, 24));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f16855q0, this.f16817E);
        m23236n2(this.f16837Y, C11842p.m70840n(this, 24));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f16855q0, this.f16817E);
        m23236n2(this.f16837Y, C11842p.m70840n(this, 24));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f16855q0, this.f16817E);
        m23236n2(this.f16837Y, C11842p.m70840n(this, 24));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f16855q0, this.f16817E);
        m23236n2(this.f16837Y, C11842p.m70840n(this, 24));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f16855q0, this.f16817E);
        m23236n2(this.f16837Y, C11842p.m70840n(this, 0));
    }

    /* renamed from: R1 */
    public final void m23239R1() {
        setResult(0, getIntent());
        finish();
    }

    /* renamed from: S1 */
    public String m23240S1(String str) {
        UserPackage userPackage;
        MemGradeRights gradeRights;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || (userPackage = this.f21452m) == null || (gradeRights = userPackage.getGradeRights()) == null || !language.equalsIgnoreCase(Constants.URDU_LANG) || !TextUtils.equals(gradeRights.getGradeCode(), "D")) {
            return str;
        }
        return "\u200f\u200e" + str;
    }

    /* renamed from: T1 */
    public int m23241T1() {
        return R$layout.pay_upgrade_detail_activity;
    }

    /* renamed from: U1 */
    public final float m23242U1() {
        return (C11842p.m70771U0() || C11842p.m70753O0(this) || C11842p.m70747M0(this)) ? C11278a.m67683a() : C11278a.m67684b();
    }

    /* renamed from: V1 */
    public final GradePicture m23243V1(List<GradePicture> list) {
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("CloudSpacePayActivity", "getQualifiedPic gradePictureList is invalid.");
            return null;
        }
        for (GradePicture gradePicture : list) {
            if ("1".equals(gradePicture.getPictureType())) {
                return gradePicture;
            }
        }
        return null;
    }

    /* renamed from: W1 */
    public final List<MemGradeRight> m23244W1(List<MemGradeRight> list) {
        ArrayList arrayList = new ArrayList();
        for (MemGradeRight memGradeRight : list) {
            if (memGradeRight != null && memGradeRight.getStatus() == 1) {
                if (TextUtils.isEmpty(memGradeRight.getRightName())) {
                    C1442a.m8289e("CloudSpacePayActivity", "rightName is null.");
                } else {
                    GradePicture gradePictureM23243V1 = m23243V1(memGradeRight.getPictures());
                    if (gradePictureM23243V1 == null) {
                        C1442a.m8289e("CloudSpacePayActivity", "gradePicture is null.");
                    } else {
                        String url = gradePictureM23243V1.getUrl();
                        String hash = gradePictureM23243V1.getHash();
                        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(hash)) {
                            C1442a.m8289e("CloudSpacePayActivity", "pic url or hash is invalid.");
                        } else {
                            arrayList.add(memGradeRight);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: X1 */
    public final void m23245X1() {
        String stringExtra;
        boolean booleanExtra;
        Intent intent = getIntent();
        if (intent != null) {
            booleanExtra = intent.getBooleanExtra("is_finish_for_result", false);
            stringExtra = intent.getStringExtra("forOtherPage");
        } else {
            stringExtra = "";
            booleanExtra = false;
        }
        C1442a.m8290i("CloudSpacePayActivity", "isFinishForResult " + booleanExtra);
        if (booleanExtra) {
            m23237o2(0);
            return;
        }
        C1442a.m8290i("CloudSpacePayActivity", "forOtherPage " + stringExtra);
        if ("BackupOptionsActivity".equals(stringExtra)) {
            Activity last = C13019a.m78347n().m78349k().getLast();
            if (last != null && "BackupOptionsActivity".equals(last.getClass().getSimpleName())) {
                finish();
                return;
            }
            SafeIntent safeIntent = new SafeIntent(new Intent(this, (Class<?>) BackupOptionsActivity.class));
            safeIntent.putExtra("forOtherPage", stringExtra);
            C10342a.m63676b(this, safeIntent);
            finish();
            return;
        }
        if (TextUtils.equals("1", new SafeIntent(getIntent()).getStringExtra("showToast"))) {
            C1442a.m8290i("CloudSpacePayActivity", "show toast");
            String string = getString(com.huawei.cloud.pay.R$string.cloudpay_bm_pay_success, C0223k.m1524g(this, this.f16838Z.getCapacity()));
            C9436m.m59180d().m59182b();
            C11841o.m70708d(this, string, 0);
        }
        if (m23253i2()) {
            C11839m.m70688i("CloudSpacePayActivity", "is from temp backup");
            finish();
            return;
        }
        try {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpacePayActivity", "start MainAcitity error: " + e10.toString());
            m23261t2();
            m23237o2(0);
        }
        finish();
    }

    /* renamed from: Y1 */
    public final void m23246Y1() {
        View view = this.f16859u0;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.f16860v0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        PaySuccessShowNeedData paySuccessShowNeedData = this.f16838Z;
        if (paySuccessShowNeedData == null) {
            C1442a.m8289e("CloudSpacePayActivity", "hideBannerArea needData is null.");
            return;
        }
        int productType = paySuccessShowNeedData.getProductType();
        if (productType == 6 || productType == 8) {
            m23251f2();
        }
    }

    /* renamed from: Z1 */
    public final void m23247Z1() {
        if (this.f16860v0 == null) {
            C1442a.m8289e("CloudSpacePayActivity", "initBanner payAfterBanner is null.");
            m23246Y1();
        } else {
            if (this.f16838Z == null) {
                C1442a.m8289e("CloudSpacePayActivity", "initBanner select is null.");
                m23246Y1();
                return;
            }
            BannerAfterPayRealtePackage bannerAfterPayRealtePackage = new BannerAfterPayRealtePackage();
            bannerAfterPayRealtePackage.setCycleType(this.f16838Z.getProductType());
            bannerAfterPayRealtePackage.setDurationMonth(this.f16838Z.getDurationMonth());
            bannerAfterPayRealtePackage.setDurationUnit(this.f16838Z.getDurationUnit());
            bannerAfterPayRealtePackage.setSize(this.f16838Z.getCapacity());
            C0202a.m1119c().m1122d(bannerAfterPayRealtePackage, this.f16815C0);
        }
    }

    /* renamed from: a2 */
    public final void m23248a2() {
        String string;
        UserPackage user = this.f16838Z.getUser();
        GetClientUIConfigResp params = this.f16838Z.getParams();
        if (user == null || params == null) {
            C1442a.m8289e("CloudSpacePayActivity", "initCurrent userPackage or uiParams is null.");
            m23239R1();
            return;
        }
        boolean z10 = this.f16838Z.getProductType() == 12;
        C1442a.m8290i("CloudSpacePayActivity", "scheme: " + this.f16838Z.getScheme());
        PackageGrade packageGrade = this.f16838Z.getPackageGrade();
        if (packageGrade != null) {
            if (!z10) {
                this.f16858t0.setText(packageGrade.getGradeName());
            } else if (user.getEffectivePackage() != null) {
                String gradeName = TextUtils.isEmpty(this.f16812A0) ? packageGrade.getGradeName() : getString(R$string.worry_free_product_pay_success_name, packageGrade.getGradeName(), this.f16812A0);
                this.f16858t0.setText(gradeName);
                C1442a.m8290i("CloudSpacePayActivity", "gradeCode: " + gradeName);
            }
        }
        this.f16819G.setText(getString(R$string.cloudpay_after_upgrade));
        this.f16826N.setText(params.getPlanDetailUesdSpaceTile());
        this.f16828P.setText(params.getPlanDetailFreeSpaceTile());
        this.f16830R.setText(params.getPlanDetailPaySpaceTile());
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
        if (cloudSpaceM67757a == null) {
            C1442a.m8289e("CloudSpacePayActivity", "initCurrent normalPackage is null.");
            m23239R1();
            return;
        }
        this.f16827O.setText(C11290m.m67751l(this, user.getUsed(), this.f16838Z.getTotalCapacity()));
        this.f16829Q.setText(C0223k.m1524g(this, cloudSpaceM67757a.getBaseCapacity()));
        int isAutoPay = this.f16838Z.getIsAutoPay();
        String strM67741b = C11290m.m67741b(this, this.f16838Z.getRenewalTime());
        if (z10) {
            String string2 = isAutoPay == 1 ? getString(R$string.next_renewal_time, this.f16812A0, strM67741b) : getString(R$string.valid_until, this.f16812A0, strM67741b);
            String strM67741b2 = C11290m.m67741b(this, cloudSpaceM67757a.getEndTime());
            string = getString(R$string.cloudpay_package_urse_space_detail, m23240S1(C0223k.m1524g(this, this.f16838Z.getCapacity() + cloudSpaceM67757a.getCapacity())), getString(R$string.parentheses, this.f21452m.getIsAutoPay() == 1 ? getString(R$string.next_renewal_time, cloudSpaceM67757a.getGradeName(), strM67741b2) : getString(R$string.valid_until, cloudSpaceM67757a.getGradeName(), strM67741b2), string2));
        } else if (C11293p.m67772p(this.f21452m)) {
            CloudSpace cloudSpaceM67758b = C11293p.m67758b(this.f21452m);
            if (cloudSpaceM67758b != null) {
                if (packageGrade != null) {
                    if (this.f16838Z.getCapacity() >= -2199023255552L) {
                        this.f16858t0.setText(packageGrade.getGradeName());
                    } else {
                        this.f16858t0.setText(getString(R$string.worry_free_product_pay_success_name, packageGrade.getGradeName(), cloudSpaceM67758b.getProductName()));
                    }
                }
                String string3 = isAutoPay == 1 ? getString(R$string.next_renewal_time, packageGrade.getGradeName(), strM67741b) : getString(R$string.valid_until, packageGrade.getGradeName(), strM67741b);
                String strM67741b3 = C11290m.m67741b(this, cloudSpaceM67758b.getEndTime());
                string = this.f16838Z.getCapacity() >= -2199023255552L ? getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, this.f16838Z.getCapacity()), string3) : getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, this.f16838Z.getCapacity() + cloudSpaceM67758b.getCapacity()), getString(R$string.parentheses, string3, cloudSpaceM67758b.getIsAutoPay() == 1 ? getString(R$string.next_renewal_time, cloudSpaceM67758b.getProductName(), strM67741b3) : getString(R$string.valid_until, cloudSpaceM67758b.getProductName(), strM67741b3)));
            } else {
                string = "";
            }
        } else {
            string = getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, this.f16838Z.getCapacity()), isAutoPay == 1 ? getString(R$string.cloudpay_parenthesis, getString(R$string.cloudpay_continuous_monthly_title_new)) : getString(R$string.package_info_capacity_package, strM67741b));
        }
        this.f16831S.setText(string);
    }

    /* renamed from: b2 */
    public final void m23249b2() {
        String string;
        UserPackage user = this.f16838Z.getUser();
        GetClientUIConfigResp params = this.f16838Z.getParams();
        if (user == null || params == null) {
            C1442a.m8289e("CloudSpacePayActivity", "initForward userPackage or uiParams is null.");
            m23239R1();
            return;
        }
        String strM67763g = C11293p.m67763g(this.f21452m);
        this.f16857s0.setText(strM67763g);
        this.f16818F.setText(getString(R$string.cloudpay_forward_upgrade));
        this.f16820H.setText(params.getPlanDetailUesdSpaceTile());
        this.f16822J.setText(params.getPlanDetailFreeSpaceTile());
        this.f16824L.setText(params.getPlanDetailPaySpaceTile());
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(user);
        this.f16821I.setText(C11290m.m67751l(this, user.getUsed(), user.getTotalCapacity()));
        this.f16823K.setText(C0223k.m1524g(this, cloudSpaceM67757a.getBaseCapacity()));
        if (cloudSpaceM67757a.getCapacity() > 0) {
            if (!m28589p1()) {
                string = getString(R$string.package_info_capacity_package, C11290m.m67741b(this, cloudSpaceM67757a.getEndTime()));
            } else if (m28590q1()) {
                string = getString(R$string.package_info_capacity_package, C11290m.m67741b(this, cloudSpaceM67757a.getEndTime()));
            } else {
                string = getString(R$string.cloudpay_parenthesis, getString(R$string.cloudpay_continuous_monthly_title_new));
            }
            this.f16825M.setText(getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, cloudSpaceM67757a.getCapacity()), string));
        }
        m23250c2(strM67763g, cloudSpaceM67757a);
    }

    /* renamed from: c2 */
    public final void m23250c2(String str, CloudSpace cloudSpace) {
        boolean zM67772p = C11293p.m67772p(this.f21452m);
        CloudSpace cloudSpaceM67758b = C11293p.m67758b(this.f21452m);
        String string = "";
        if (!zM67772p || cloudSpaceM67758b == null) {
            if (this.f16838Z.getProductType() == 12) {
                if (cloudSpace != null) {
                    String strM67741b = C11290m.m67741b(this, cloudSpace.getEndTime());
                    string = this.f21452m.getIsAutoPay() == 1 ? getString(R$string.cloudpay_parenthesis, getString(R$string.auto_pay_member_tip, strM67741b)) : getString(R$string.package_info_capacity_package, strM67741b);
                }
                this.f16825M.setText(getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, cloudSpace.getCapacity()), string));
                return;
            }
            return;
        }
        String productName = cloudSpaceM67758b.getProductName();
        if (C11293p.m67767k(this.f21452m) != 1) {
            if (C11293p.m67767k(this.f21452m) == 0) {
                this.f16857s0.setText(cloudSpaceM67758b.getGradeName());
                String strM67741b2 = C11290m.m67741b(this, cloudSpaceM67758b.getEndTime());
                this.f16825M.setText(getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, cloudSpaceM67758b.getCapacity()), getString(R$string.cloudpay_parenthesis, cloudSpaceM67758b.getIsAutoPay() == 1 ? getString(R$string.next_renewal_time, productName, strM67741b2) : getString(R$string.valid_until, productName, strM67741b2))));
                return;
            }
            return;
        }
        this.f16857s0.setText(getString(R$string.worry_free_product_pay_success_name, str, productName));
        String strM67741b3 = C11290m.m67741b(this, cloudSpaceM67758b.getEndTime());
        String string2 = cloudSpaceM67758b.getIsAutoPay() == 1 ? getString(R$string.next_renewal_time, productName, strM67741b3) : getString(R$string.valid_until, productName, strM67741b3);
        if (cloudSpace != null) {
            String strM67741b4 = C11290m.m67741b(this, cloudSpace.getEndTime());
            string = this.f21452m.getIsAutoPay() == 1 ? getString(R$string.next_renewal_time, cloudSpace.getGradeName(), strM67741b4) : getString(R$string.valid_until, cloudSpace.getGradeName(), strM67741b4);
        }
        this.f16825M.setText(getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, cloudSpace.getCapacity() + cloudSpaceM67758b.getCapacity()), getString(R$string.parentheses, string, string2)));
    }

    /* renamed from: f2 */
    public final void m23251f2() {
        PackageGrade packageGrade = this.f16838Z.getPackageGrade();
        if (packageGrade == null) {
            C1442a.m8291w("CloudSpacePayActivity", "initPrivilegesListView memGradeRights is null.");
            return;
        }
        List<MemGradeRight> rights = packageGrade.getRights();
        if (rights == null || rights.size() == 0) {
            C1442a.m8291w("CloudSpacePayActivity", "initPrivilegesListView has no Privileges.");
            LinearLayout linearLayout = this.f16846h0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, m23234e2(this));
        List<MemGradeRight> listM23244W1 = m23244W1(rights);
        if (listM23244W1.isEmpty()) {
            C1442a.m8289e("CloudSpacePayActivity", "validList is empty.");
            return;
        }
        C1168d c1168d = new C1168d(this, listM23244W1, packageGrade.getGradeCode());
        if (this.f16847i0 != null) {
            this.f16846h0.setVisibility(0);
            this.f16847i0.setLayoutManager(gridLayoutManager);
            this.f16847i0.setAdapter(c1168d);
            this.f16847i0.addItemDecoration(new C3613d(C11842p.m70840n(this, m23233d2(this)), m23234e2(this)));
            c1168d.m5213j();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16814C);
        arrayList.add(this.f16816D);
        arrayList.add(this.f16817E);
        return arrayList;
    }

    /* renamed from: h2 */
    public final void m23252h2() {
        float fM70844o = C11842p.m70876w(this).widthPixels - (C11842p.m70844o(this, 24) * 2.0f);
        int i10 = (int) ((fM70844o * 2.0f) / 3.0f);
        int i11 = (int) (fM70844o / 3.0f);
        int i12 = (int) (fM70844o / 2.0f);
        TextView textView = this.f16839a0;
        if (textView != null) {
            textView.setWidth(i10);
        }
        RelativeLayout relativeLayout = this.f16841c0;
        if (relativeLayout != null) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.width = i11;
                this.f16841c0.setLayoutParams(layoutParams2);
            }
        }
        TextView textView2 = this.f16842d0;
        if (textView2 != null) {
            textView2.setWidth(i10);
        }
        TextView textView3 = this.f16843e0;
        if (textView3 != null) {
            textView3.setWidth(i11);
        }
        TextView textView4 = this.f16844f0;
        if (textView4 != null) {
            textView4.setWidth(i12);
        }
        TextView textView5 = this.f16845g0;
        if (textView5 != null) {
            textView5.setWidth(i12);
        }
        TextView textView6 = this.f16848j0;
        if (textView6 != null) {
            textView6.setWidth(i10);
        }
        TextView textView7 = this.f16849k0;
        if (textView7 != null) {
            textView7.setWidth(i11);
        }
        TextView textView8 = this.f16850l0;
        if (textView8 != null) {
            textView8.setWidth(i10);
        }
        TextView textView9 = this.f16851m0;
        if (textView9 != null) {
            textView9.setWidth(i11);
        }
        C11842p.m70866t1(this, this.f16832T);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "CloudSpacePayActivity";
    }

    /* renamed from: i2 */
    public final boolean m23253i2() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        int intExtra = safeIntent.getIntExtra("page_type", 0);
        C1442a.m8290i("CloudSpacePayActivity", "isJumpOtherPage fromWhere: " + intExtra);
        if (intExtra != 13) {
            return false;
        }
        String stringExtra = safeIntent.getStringExtra("page_detail");
        if (TextUtils.isEmpty(stringExtra)) {
            C11839m.m70689w("CloudSpacePayActivity", "pageDetail is empty");
            return false;
        }
        try {
            LinkedList<Activity> linkedListM78349k = C13019a.m78347n().m78349k();
            int size = linkedListM78349k.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Activity activity = linkedListM78349k.get(size);
                if (TextUtils.equals(activity.getClass().getName(), getClass().getName())) {
                    C1442a.m8290i("CloudSpacePayActivity", "current activity not finish");
                } else {
                    if (TextUtils.equals(activity.getClass().getName(), stringExtra)) {
                        activity.finish();
                        break;
                    }
                    activity.finish();
                }
                size--;
            }
            Intent intent = new Intent();
            intent.setClassName(this, stringExtra);
            intent.putExtra("isTempBackup", true);
            startActivity(intent);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpacePayActivity", "start acitity error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: j2 */
    public final void m23254j2(BannerAfterPayItem bannerAfterPayItem) {
        if (bannerAfterPayItem == null) {
            C1442a.m8290i("CloudSpacePayActivity", "has no banner info.");
            m23246Y1();
            return;
        }
        Bitmap bitmapM1121b = C0202a.m1119c().m1121b(bannerAfterPayItem);
        if (bitmapM1121b == null) {
            C1442a.m8289e("CloudSpacePayActivity", "initBanner bitmap is null.");
            m23246Y1();
        } else {
            this.f16860v0.setImageBitmap(bitmapM1121b);
            m23256l2(bannerAfterPayItem.getBannerId(), bannerAfterPayItem.getPercentage());
            this.f16860v0.setOnClickListener(new ViewOnClickListenerC3612c(bannerAfterPayItem));
            m23258p2();
        }
    }

    /* renamed from: k2 */
    public void m23255k2(String str, String str2, String str3, long j10, float f10) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("banner_name", str);
            linkedHashMapM79497A.put("banner_goto_type", str2);
            linkedHashMapM79497A.put("banner_goto_uri", str3);
            linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(f10));
            linkedHashMapM79497A.put("banner_id", String.valueOf(j10));
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_AFTER_PAY_BANNER_CLICK", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_AFTER_PAY_BANNER_CLICK", "1", "35", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_AFTER_PAY_BANNER_CLICK", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpacePayActivity", "reportBannerClickEvent error occur:" + e10.getMessage());
        }
    }

    /* renamed from: l2 */
    public void m23256l2(long j10, float f10) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("banner_id", String.valueOf(j10));
            linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(f10));
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_AFTER_PAY_BANNER_SHOW", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_AFTER_PAY_BANNER_SHOW", "1", "35", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_AFTER_PAY_BANNER_SHOW", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpacePayActivity", "reportBannerShowEvent error occur:" + e10.getMessage());
        }
    }

    /* renamed from: m2 */
    public final void m23257m2() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            if (!TextUtils.isEmpty(this.f16813B0)) {
                linkedHashMapM79497A.put("forOtherPage", this.f16813B0);
            }
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_ENTER_PAY_SUCCESS_ACITIVY", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_ENTER_PAY_SUCCESS_ACITIVY", "1", "7", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_ENTER_PAY_SUCCESS_ACITIVY", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpacePayActivity", "reportEnterPaySuccessActivity error occur:" + e10.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m23245X1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R$id.pay_ok_btn == view.getId()) {
            m23245X1();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(m23241T1());
        if (this.f16838Z == null) {
            C1442a.m8289e("CloudSpacePayActivity", "onConfigurationChanged needData is null ");
        } else {
            m23235g2();
            C11842p.m70866t1(this, this.f16832T);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            C1442a.m8289e("CloudSpacePayActivity", "intent is null");
            setResult(0, new Intent());
            finish();
            return;
        }
        try {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            this.f16838Z = (PaySuccessShowNeedData) hiCloudSafeIntent.getSerializableExtra("pay_sucess_show_need_data");
            this.f16861w0 = hiCloudSafeIntent.getStringExtra("url");
            this.f16862x0 = hiCloudSafeIntent.getStringExtra("srcChannel");
            this.f16863y0 = hiCloudSafeIntent.getStringExtra("salChannel");
            this.f16864z0 = hiCloudSafeIntent.getStringExtra("activityCode");
            this.f16812A0 = hiCloudSafeIntent.getStringExtra("pay_success_show_worry_free_product_name");
            this.f16813B0 = hiCloudSafeIntent.getStringExtra("forOtherPage");
            PaySuccessShowNeedData paySuccessShowNeedData = this.f16838Z;
            if (paySuccessShowNeedData == null) {
                C1442a.m8289e("CloudSpacePayActivity", "intent data is null");
                setResult(0, intent);
                finish();
            } else {
                this.f21452m = paySuccessShowNeedData.getUser();
                setContentView(m23241T1());
                m23235g2();
                m23257m2();
            }
        } catch (Exception unused) {
            C1442a.m8289e("CloudSpacePayActivity", "intent data is not valid");
            setResult(0, intent);
            finish();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f16815C0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f16815C0 = null;
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* renamed from: p2 */
    public final void m23258p2() {
        View view = this.f16859u0;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.f16860v0;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f16860v0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC3611b());
        }
    }

    /* renamed from: q2 */
    public final void m23259q2() {
        PackageGrade packageGrade;
        PaySuccessShowNeedData paySuccessShowNeedData = this.f16838Z;
        if (paySuccessShowNeedData == null) {
            C1442a.m8289e("CloudSpacePayActivity", "showBaseInfoView needData is null.");
            m23239R1();
            return;
        }
        if (this.f16840b0 != null) {
            BigDecimal amount = paySuccessShowNeedData.getAmount();
            String currency = this.f16838Z.getCurrency();
            this.f16840b0.setText(C11290m.m67749j(amount, currency, C11290m.m67740a(currency)));
        }
        if (this.f16843e0 != null && (packageGrade = this.f16838Z.getPackageGrade()) != null) {
            this.f16843e0.setText(packageGrade.getGradeName());
        }
        TextView textView = this.f16845g0;
        if (textView != null) {
            textView.setText(C11290m.m67741b(this, this.f16838Z.getRenewalTime()));
        }
    }

    /* renamed from: r2 */
    public final void m23260r2(ActionBar actionBar) {
        PackageGrade packageGrade;
        if (actionBar != null) {
            int i10 = R$string.cloudpay_purchase_cloud_card_button_present;
            actionBar.setTitle(i10);
            setTitle(i10);
        }
        TextView textView = this.f16856r0;
        if (textView != null) {
            textView.setText(R$string.cloudpay_give_success_text);
        }
        LinearLayout linearLayout = this.f16852n0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.f16853o0;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.f16854p0;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        if (this.f16849k0 != null && (packageGrade = this.f16838Z.getPackageGrade()) != null) {
            this.f16849k0.setText(packageGrade.getGradeName());
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        int durationMonth = this.f16838Z.getDurationMonth();
        TextView textView2 = this.f16851m0;
        if (textView2 != null) {
            textView2.setText(getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, durationMonth, numberFormat.format(durationMonth)));
        }
        m23247Z1();
    }

    /* renamed from: t2 */
    public final void m23261t2() {
        String str = this.f16861w0;
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            Uri uri = Uri.parse(this.f16861w0);
            if (uri == null) {
                C1442a.m8289e("CloudSpacePayActivity", "PaySuccessUri is null");
                return;
            }
            String scheme = uri.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                C1442a.m8289e("CloudSpacePayActivity", "illegal scheme:" + scheme);
                return;
            }
            Intent intent = new Intent(this, (Class<?>) OperationWebViewActivity.class);
            String string = C0213f.m1377a().getString(R$string.HiCloud_app_name);
            intent.putExtra("url", this.f16861w0);
            intent.putExtra("srcChannel", this.f16862x0);
            intent.putExtra("salChannel", this.f16863y0);
            intent.putExtra("activityCode", this.f16864z0);
            intent.putExtra("title", string);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("launch_web_type", 2);
            startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e("CloudSpacePayActivity", "browser ActivityNotFoundException : " + e10.toString());
        }
    }
}
