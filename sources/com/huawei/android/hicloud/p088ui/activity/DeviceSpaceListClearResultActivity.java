package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.cloudbackup.util.PackageParamUtil;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.HotTitleTextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.sync.R$color;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0223k;
import p454lj.C11290m;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p807yd.C13948d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DeviceSpaceListClearResultActivity extends BuyPackageBaseActivity implements View.OnClickListener {

    /* renamed from: B1 */
    public String f14699B1;

    /* renamed from: h1 */
    public NotchTopFitRelativeLayout f14700h1;

    /* renamed from: i1 */
    public NotchFitLinearLayout f14701i1;

    /* renamed from: j1 */
    public View f14702j1;

    /* renamed from: k1 */
    public TextView f14703k1;

    /* renamed from: l1 */
    public SpanClickText f14704l1;

    /* renamed from: m1 */
    public RelativeLayout f14705m1;

    /* renamed from: n1 */
    public TextView f14706n1;

    /* renamed from: o1 */
    public TextView f14707o1;

    /* renamed from: p1 */
    public TextView f14708p1;

    /* renamed from: q1 */
    public TextView f14709q1;

    /* renamed from: r1 */
    public TextView f14710r1;

    /* renamed from: s1 */
    public AutoSizeButton f14711s1;

    /* renamed from: t1 */
    public LinearLayout f14712t1;

    /* renamed from: u1 */
    public HotTitleTextView f14713u1;

    /* renamed from: v1 */
    public CloudPackage f14714v1 = null;

    /* renamed from: w1 */
    public PackageGrades f14715w1 = null;

    /* renamed from: x1 */
    public CloudPackage f14716x1 = null;

    /* renamed from: y1 */
    public PackageGrades f14717y1 = null;

    /* renamed from: z1 */
    public boolean f14718z1 = false;

    /* renamed from: A1 */
    public boolean f14698A1 = true;

    /* renamed from: H5 */
    private void m20347H5() {
        C11839m.m70688i("DeviceSpaceListClearResultActivity", "getPackageInfo");
        this.f16546Z = C13948d.m83788f().m83798k();
        this.f16538V = C13948d.m83788f().m83797j();
        this.f21452m = C13948d.m83788f().m83800m();
        this.f16540W = C13948d.m83788f().m83792d();
        this.f16535T0 = C13948d.m83788f().m83801n();
        this.f16570q0 = C13948d.m83788f().m83799l();
        this.f16571r0 = C13948d.m83788f().m83793e();
        this.f16572s0 = C13948d.m83788f().m83796i();
        this.f16573t0 = C13948d.m83788f().m83794g();
        this.f16574u0 = C13948d.m83788f().m83791c();
        this.f14699B1 = C13948d.m83788f().m83795h();
        mo19479s5();
    }

    /* renamed from: J5 */
    private void m20348J5() {
        if (TextUtils.isEmpty(this.f16571r0)) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "gotoUri is empty");
            return;
        }
        try {
            C11839m.m70686d("DeviceSpaceListClearResultActivity", "gotoUri: " + this.f16571r0);
            startActivityForResult(NotifyUtil.getDlAppWebViewIntent(this, this.f16571r0), NotifyConstants.RequestCode.REQUESTCODE_CAMPAIGN);
        } catch (Exception e10) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "gotoDownloadApp Exception : " + e10.toString());
        }
    }

    /* renamed from: L5 */
    private void m20349L5() {
        HotTitleTextView hotTitleTextView = this.f14713u1;
        if (hotTitleTextView != null) {
            hotTitleTextView.setVisibility(8);
            this.f14713u1.setRedDotVisibility(8);
            this.f14713u1.setText("");
            this.f14713u1.setOnClickListener(null);
        }
    }

    /* renamed from: P5 */
    private void m20350P5() {
        this.f14700h1 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14701i1 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_fit_layout);
        this.f14702j1 = C12809f.m76829b(this, R$id.rl_loading_view);
        this.f14703k1 = (TextView) C12809f.m76829b(this, R$id.tv_clear_size);
        this.f14704l1 = (SpanClickText) C12809f.m76829b(this, R$id.tv_clear_switch_manager);
        this.f14705m1 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_recommend_package);
        this.f14706n1 = (TextView) C12809f.m76829b(this, R$id.tv_package_tag);
        this.f14707o1 = (TextView) C12809f.m76829b(this, R$id.tv_package_name);
        this.f14708p1 = (TextView) C12809f.m76829b(this, R$id.tv_package_price_real);
        this.f14709q1 = (TextView) C12809f.m76829b(this, R$id.tv_package_price_old);
        this.f14710r1 = (TextView) C12809f.m76829b(this, R$id.tv_package_mark);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.btn_buy_now);
        this.f14711s1 = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f14712t1 = (LinearLayout) C12809f.m76829b(this, R$id.ll_activity_entrance);
        this.f14713u1 = (HotTitleTextView) C12809f.m76829b(this, R$id.tv_activity_entrance);
    }

    /* renamed from: Q5 */
    public static boolean m20351Q5(int i10) {
        return 8 == i10 || 6 == i10;
    }

    /* renamed from: Y5 */
    private void m20352Y5(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("DeviceSpaceListClearResultActivity", "linkContent is empty");
            return;
        }
        C11839m.m70686d("DeviceSpaceListClearResultActivity", "linkContent: " + str);
        HotTitleTextView hotTitleTextView = this.f14713u1;
        if (hotTitleTextView != null) {
            if (this.f14698A1) {
                hotTitleTextView.setRedDotVisibility(0);
            } else {
                hotTitleTextView.setRedDotVisibility(8);
            }
            this.f14713u1.setText(str);
            this.f14713u1.setOnClickListener(this);
        }
    }

    /* renamed from: Z5 */
    public static void m20353Z5(TextView textView, String str) {
        if (textView == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "showLabel labelTV is null.");
        } else if (TextUtils.isEmpty(str)) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    /* renamed from: a6 */
    private void m20354a6() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
        C11839m.m70688i("DeviceSpaceListClearResultActivity", "getSpaceInfo");
    }

    /* renamed from: I5 */
    public final void m20355I5(long j10, PackageGrades packageGrades, List<CloudPackage> list) {
        for (CloudPackage cloudPackage : list) {
            if (cloudPackage != null) {
                long capacity = cloudPackage.getCapacity();
                int productType = cloudPackage.getProductType();
                int durationMonth = cloudPackage.getDurationMonth();
                if (m20351Q5(productType) && capacity > j10) {
                    CloudPackage cloudPackage2 = this.f14716x1;
                    if (cloudPackage2 == null || this.f14717y1 == null) {
                        this.f14716x1 = cloudPackage;
                        this.f14717y1 = packageGrades;
                    } else {
                        long capacity2 = cloudPackage2.getCapacity();
                        int durationMonth2 = this.f14716x1.getDurationMonth();
                        if (capacity < capacity2) {
                            this.f14716x1 = cloudPackage;
                            this.f14717y1 = packageGrades;
                        } else if (capacity == capacity2 && durationMonth <= durationMonth2) {
                            this.f14716x1 = cloudPackage;
                            this.f14717y1 = packageGrades;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: K5 */
    public final void m20356K5() {
        C11839m.m70688i("DeviceSpaceListClearResultActivity", "click gotoSwitchManager");
        try {
            startActivityForResult(new Intent(this, (Class<?>) CloudSpaceBackupActivity.class), 1);
        } catch (Exception e10) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "gotoSwitchManager Exception : " + e10.toString());
        }
    }

    /* renamed from: M5 */
    public void m20357M5() {
        View view = this.f14702j1;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: N5 */
    public final void m20358N5() {
        RelativeLayout relativeLayout = this.f14705m1;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.f14712t1;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: O5 */
    public final void m20359O5() {
        SpanClickText spanClickText = this.f14704l1;
        if (spanClickText != null) {
            spanClickText.setVisibility(8);
        }
    }

    /* renamed from: R5 */
    public final /* synthetic */ void m20360R5() {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("DeviceSpaceListClearResultActivity", "click too fast");
        } else {
            m20356K5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    /* renamed from: S5 */
    public final void m20361S5() {
        C11839m.m70688i("DeviceSpaceListClearResultActivity", "notifySpaceSizeChanged");
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.SPACE_DELETED_CHANGED");
        C13108a.m78878b(this).m78881d(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        if (!C11296s.m67786J(this)) {
            m20354a6();
            return;
        }
        this.f16546Z = null;
        this.f16538V = null;
        this.f21452m = null;
        this.f16540W = null;
        this.f16535T0 = null;
        this.f14714v1 = null;
        this.f14715w1 = null;
        m28588o1("06008");
        m20347H5();
    }

    /* renamed from: T5 */
    public final void m20362T5() throws JSONException {
        if (this.f14714v1 == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "recommendPackage null");
        } else if (this.f14715w1 == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "recommendPackageGrade null");
        } else {
            C11839m.m70688i("DeviceSpaceListClearResultActivity", "startPay");
            m22885v5(this.f14714v1, this.f14715w1, "backup_clear_purchase", this.f16535T0, m22882v2(), null);
        }
    }

    /* renamed from: U5 */
    public final void m20363U5() {
        this.f14716x1 = null;
        this.f14717y1 = null;
        if (this.f16540W == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "availablePackages null");
            return;
        }
        UserPackage userPackage = this.f21452m;
        if (userPackage == null) {
            return;
        }
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(userPackage);
        if (cloudSpaceM67757a == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "user effectivePackage null");
            return;
        }
        long capacity = cloudSpaceM67757a.getCapacity();
        Iterator<FilterAvailabalGradePackage> it = this.f16540W.iterator();
        while (it.hasNext()) {
            FilterAvailabalGradePackage next = it.next();
            if (next != null) {
                PackageGrades packageGrades = next.getPackageGrades();
                List<CloudPackage> monthlyPackageList = next.getMonthlyPackageList();
                if (packageGrades != null && monthlyPackageList != null) {
                    m20355I5(capacity, packageGrades, monthlyPackageList);
                }
            }
        }
        this.f14714v1 = this.f14716x1;
        this.f14715w1 = this.f14717y1;
    }

    /* renamed from: V5 */
    public final void m20364V5() {
        String strM1524g = C0223k.m1524g(getApplicationContext(), new HiCloudSafeIntent(getIntent()).getLongExtra("key_result_clear_size", 0L));
        if (strM1524g == null) {
            strM1524g = "";
        }
        String string = getString(R$string.backup_space_clear_size, strM1524g);
        TextView textView = this.f14703k1;
        if (textView != null) {
            textView.setText(string);
        }
    }

    /* renamed from: W5 */
    public final void m20365W5(TextView textView, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StrikethroughSpan(), 0, str.length(), 33);
        textView.setContentDescription(str);
        textView.setText(spannableString);
        textView.setVisibility(0);
    }

    /* renamed from: X5 */
    public final void m20366X5(SpannableString spannableString, int i10, int i11, int i12, int i13, Context context) {
        if (spannableString == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "setRealPriceSpan error, priceSpan is null");
            return;
        }
        int iM70840n = C11842p.m70840n(context, 36);
        if (i10 >= 0 && i12 >= 0 && i13 > 0 && i11 > i13) {
            spannableString.setSpan(new AbsoluteSizeSpan(iM70840n, false), i10, i11 + i10, 33);
        }
        int i14 = i13 + i12;
        spannableString.setSpan(new SuperscriptSpan(), i12, i14, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(C11842p.m70840n(context, 10), false), i12, i14, 33);
    }

    /* renamed from: b6 */
    public final void m20367b6() {
        if (this.f14714v1 == null || this.f16538V == null) {
            return;
        }
        String strM1524g = C0223k.m1524g(getApplicationContext(), this.f14714v1.getCapacity());
        if (strM1524g == null) {
            strM1524g = "";
        }
        this.f14707o1.setText(getString(R$string.payment_renewal_package_size, strM1524g, PackageParamUtil.getProductName(this.f14714v1, this.f16538V)));
    }

    /* renamed from: c6 */
    public final void m20368c6(TextView textView, TextView textView2, CloudPackage cloudPackage, Context context) {
        String strM67749j;
        if (context == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "showPrice context is null.");
            return;
        }
        if (textView == null || textView2 == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "showPrice tvPrice is null.");
            return;
        }
        if (cloudPackage == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "cloudPackage is null.");
            return;
        }
        String currency = cloudPackage.getCurrency();
        String symbol = cloudPackage.getSymbol();
        BigDecimal spPrice = cloudPackage.getSpPrice();
        BigDecimal price = cloudPackage.getPrice();
        int productType = cloudPackage.getProductType();
        if ((productType == 7 || productType == 8) && spPrice != null && spPrice.compareTo(price) < 0) {
            strM67749j = C11290m.m67749j(spPrice, currency, symbol);
            m20365W5(textView2, C11290m.m67749j(price, currency, symbol));
        } else {
            strM67749j = C11290m.m67749j(price, currency, symbol);
            textView2.setVisibility(4);
        }
        int iIndexOf = strM67749j.indexOf(strM67749j);
        int length = strM67749j.length();
        String currencySymbol = cloudPackage.getCurrencySymbol();
        int iIndexOf2 = strM67749j.indexOf(currencySymbol, iIndexOf);
        int length2 = currencySymbol.length();
        SpannableString spannableString = new SpannableString(strM67749j);
        m20366X5(spannableString, iIndexOf, length, iIndexOf2, length2, context);
        textView.setContentDescription(strM67749j);
        textView.setText(spannableString);
    }

    /* renamed from: d6 */
    public final void m20369d6() {
        if (this.f14714v1 == null || this.f14715w1 == null) {
            C11839m.m70687e("DeviceSpaceListClearResultActivity", "recommendPackage null");
            return;
        }
        if (this.f14718z1) {
            C11839m.m70688i("DeviceSpaceListClearResultActivity", "recommendPackage has dealPayStateSuccess");
            return;
        }
        this.f14705m1.setVisibility(0);
        this.f14712t1.setVisibility(0);
        m20367b6();
        m20368c6(this.f14708p1, this.f14709q1, this.f14714v1, this);
        PackageParamUtil.showReMemark(this.f14710r1, this.f14714v1, this.f16538V);
        m20353Z5(this.f14706n1, this.f14714v1.getDurationTag());
        C11839m.m70688i("DeviceSpaceListClearResultActivity", "show recommendPackage");
        m20352Y5(this.f14699B1);
    }

    /* renamed from: e6 */
    public final void m20370e6() {
        if (this.f14704l1 == null) {
            return;
        }
        String string = getString(R$string.backup_auto_clear_switch_manager);
        String string2 = getString(R$string.backup_auto_clear_has_open, string);
        this.f14704l1.m15931c(string, new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.activity.e5
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f17597a.m20360R5();
            }
        });
        this.f14704l1.m15934g(string2, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        View view = this.f14702j1;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14700h1);
        arrayList.add(this.f14701i1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        m20357M5();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: k1 */
    public void mo20371k1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo20371k1();
        int color = ContextCompat.getColor(this, R$color.hicloud_hmos_bg);
        C0209d.m1306s2(getActionBar(), this, color);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(color);
        }
        ActionBar actionBar = this.f21447h;
        if (actionBar != null) {
            actionBar.setTitle(R$string.cloud_backup_clear);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: m3 */
    public void mo20372m3(Intent intent, String str) {
        this.f14718z1 = true;
        m20358N5();
        super.mo20372m3(intent, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) throws org.json.JSONException {
        /*
            r4 = this;
            com.huawei.hicloud.base.common.HiCloudSafeIntent r0 = new com.huawei.hicloud.base.common.HiCloudSafeIntent
            r0.<init>(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "onActivityResult requestCode = "
            r7.append(r1)
            r7.append(r5)
            java.lang.String r1 = ", resultCode = "
            r7.append(r1)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            java.lang.String r1 = "DeviceSpaceListClearResultActivity"
            p514o9.C11839m.m70688i(r1, r7)
            r4.m20357M5()
            r7 = 1
            if (r7 != r5) goto L3c
            e9.c r2 = p252e9.C9426c.m59108d()
            boolean r2 = r2.m59111c()
            if (r2 != 0) goto L4c
            java.lang.String r2 = "switch close, hideSwitchOpenText"
            p514o9.C11839m.m70688i(r1, r2)
            r4.m20359O5()
            goto L4c
        L3c:
            r2 = 10008(0x2718, float:1.4024E-41)
            if (r2 != r5) goto L4c
            r2 = 0
            r4.f14698A1 = r2
            com.huawei.android.hicloud.ui.uiextend.HotTitleTextView r2 = r4.f14713u1
            if (r2 == 0) goto L4c
            r3 = 8
            r2.setRedDotVisibility(r3)
        L4c:
            r2 = -1
            if (r6 == r2) goto La0
            if (r6 == 0) goto L83
            if (r6 == r7) goto L83
            r7 = 201(0xc9, float:2.82E-43)
            if (r6 == r7) goto L63
            r7 = 802(0x322, float:1.124E-42)
            if (r6 == r7) goto L63
            switch(r6) {
                case 7101: goto L63;
                case 7102: goto L5f;
                case 7103: goto L63;
                default: goto L5e;
            }
        L5e:
            goto La3
        L5f:
            r4.m20349L5()
            goto La3
        L63:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "refresh data by requestCode:"
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = ", resultCode:"
            r7.append(r2)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            p054cj.C1442a.m8288d(r1, r7)
            r4.mo19460T3()
            goto La3
        L83:
            r4.m28583a1()
            com.huawei.cloud.pay.model.GetClientUIConfigResp r7 = r4.f16538V
            if (r7 == 0) goto L97
            com.huawei.cloud.pay.model.UserPackage r7 = r4.f21452m
            if (r7 == 0) goto L97
            java.util.ArrayList<com.huawei.cloud.pay.model.FilterAvailabalGradePackage> r7 = r4.f16540W
            if (r7 != 0) goto L93
            goto L97
        L93:
            r4.mo19476h5()
            goto La3
        L97:
            java.lang.String r5 = " data no prepare ok"
            p054cj.C1442a.m8288d(r1, r5)
            r4.mo19460T3()
            return
        La0:
            r4.mo19453O4(r5, r0)
        La3:
            super.onActivityResult(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.DeviceSpaceListClearResultActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("DeviceSpaceListClearResultActivity", "click too fast");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.btn_buy_now) {
            m20362T5();
        } else if (id2 == R$id.tv_activity_entrance) {
            m20348J5();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_space_clear_result);
        mo20371k1();
        m20350P5();
        m28587n1();
        mo19460T3();
        m20364V5();
        if (C13948d.m83788f().m83789a()) {
            m20370e6();
        } else {
            m20359O5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        m20361S5();
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        if (this.f16546Z == null || this.f16538V == null || this.f21452m == null || this.f16540W == null || this.f16535T0 == null) {
            C11839m.m70688i("DeviceSpaceListClearResultActivity", "data no prepare ok");
            return;
        }
        C11839m.m70688i("DeviceSpaceListClearResultActivity", "showView");
        this.f14714v1 = null;
        this.f14715w1 = null;
        m20363U5();
        m20369d6();
        mo19476h5();
        C11839m.m70688i("DeviceSpaceListClearResultActivity", "showView finish.");
    }
}
