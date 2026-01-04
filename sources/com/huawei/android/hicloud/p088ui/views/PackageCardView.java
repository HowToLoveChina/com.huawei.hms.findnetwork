package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.views.CountDownTimerView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CountDownConfig;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import java.math.BigDecimal;
import java.util.HashMap;
import p015ak.C0209d;
import p054cj.C1442a;
import p454lj.C11290m;
import p514o9.C11842p;
import p572qb.C12312h0;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PackageCardView extends RelativeLayout {

    /* renamed from: a */
    public View f19511a;

    /* renamed from: b */
    public RelativeLayout f19512b;

    /* renamed from: c */
    public TextView f19513c;

    /* renamed from: d */
    public TextView f19514d;

    /* renamed from: e */
    public TextView f19515e;

    /* renamed from: f */
    public TextView f19516f;

    /* renamed from: g */
    public CountDownTimerView f19517g;

    /* renamed from: h */
    public CloudPackage f19518h;

    /* renamed from: i */
    public GetClientUIConfigResp f19519i;

    /* renamed from: j */
    public String f19520j;

    /* renamed from: k */
    public Context f19521k;

    /* renamed from: l */
    public float f19522l;

    /* renamed from: m */
    public int f19523m;

    /* renamed from: n */
    public int f19524n;

    /* renamed from: o */
    public int f19525o;

    /* renamed from: p */
    public View f19526p;

    /* renamed from: q */
    public boolean f19527q;

    /* renamed from: r */
    public CountDownConfig f19528r;

    /* renamed from: s */
    public CountDownEndListener f19529s;

    public interface CountDownEndListener {
        /* renamed from: a */
        void mo23904a();
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.PackageCardView$a */
    public class C4286a extends View.AccessibilityDelegate {
        public C4286a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(true);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.PackageCardView$b */
    public class C4287b extends View.AccessibilityDelegate {
        public C4287b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(false);
            accessibilityNodeInfo.setChecked(false);
        }
    }

    public PackageCardView(Context context) {
        this(context, null);
        m25785e(context);
        this.f19521k = context;
        this.f19518h = null;
        this.f19519i = null;
    }

    /* renamed from: b */
    public final SpannableStringBuilder m25782b(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.f19521k == null) {
            C1442a.m8290i("PackageCardView", "buildPriceDisplayText error, resource is null");
            return spannableStringBuilder;
        }
        int iIndexOf = str.indexOf(str2);
        int length = str2.length();
        Resources resources = this.f19521k.getResources();
        String currencySymbol = this.f19518h.getCurrencySymbol();
        int length2 = currencySymbol.length();
        int iIndexOf2 = str.indexOf(currencySymbol, iIndexOf);
        this.f19522l = C0209d.m1195O(this.f19521k);
        m25794n(spannableStringBuilder, iIndexOf, length, iIndexOf2, length2, resources);
        if (!TextUtils.isEmpty(str3)) {
            int iIndexOf3 = str.indexOf(str3, iIndexOf + length);
            m25793m(spannableStringBuilder, iIndexOf3, str3.length(), str.indexOf(currencySymbol, iIndexOf3), length2, resources);
        }
        return spannableStringBuilder;
    }

    /* renamed from: c */
    public void m25783c() {
        this.f19518h = null;
    }

    /* renamed from: d */
    public final void m25784d() {
        if (this.f19528r == null) {
            C1442a.m8290i("PackageCardView", "countDownTimer is null");
            return;
        }
        if (this.f19517g == null) {
            C1442a.m8289e("PackageCardView", "mCountDownTimer is  null");
            return;
        }
        long jM74028c = C12312h0.m74027b().m74028c();
        long endTime = this.f19528r.getEndTime();
        long j10 = endTime - jM74028c;
        if (j10 >= 0) {
            this.f19517g.m25747v(j10, 1000L);
            this.f19517g.setVisibility(0);
            this.f19513c.setVisibility(8);
            this.f19517g.setOnCountDownFinishListener(new CountDownTimerView.CountDownFinishListener() { // from class: de.s
                @Override // com.huawei.android.hicloud.ui.views.CountDownTimerView.CountDownFinishListener
                public final void onFinish() {
                    this.f45852a.m25788h();
                }
            });
            this.f19517g.m25750y();
            return;
        }
        C1442a.m8289e("PackageCardView", "leftTime = " + j10 + ", serverTime " + jM74028c + "- endTime " + endTime);
    }

    /* renamed from: e */
    public final void m25785e(Context context) {
        if (C0209d.m1195O(context) >= 1.75f) {
            View.inflate(context, R$layout.package_card_layout_font_scale, this);
        } else {
            View.inflate(context, R$layout.package_card_layout, this);
        }
        this.f19511a = C12809f.m76831d(this, R$id.package_card_main_layout);
        this.f19512b = (RelativeLayout) C12809f.m76831d(this, R$id.package_card_detail_container);
        this.f19513c = (TextView) C12809f.m76831d(this, R$id.package_card_label);
        this.f19514d = (TextView) C12809f.m76831d(this, R$id.package_card_product_name);
        this.f19515e = (TextView) C12809f.m76831d(this, R$id.package_price_display_text);
        this.f19516f = (TextView) C12809f.m76831d(this, R$id.package_card_remarks);
        this.f19526p = C12809f.m76831d(this, R$id.view_label_place);
        this.f19517g = (CountDownTimerView) C12809f.m76831d(this, R$id.count_down_timer);
    }

    /* renamed from: f */
    public final boolean m25786f() {
        return (this.f19511a == null || this.f19512b == null || this.f19513c == null || this.f19514d == null || this.f19515e == null || this.f19516f == null) ? false : true;
    }

    /* renamed from: g */
    public boolean m25787g() {
        return this.f19518h != null;
    }

    public boolean getIsHasWorryFreeMonth() {
        return this.f19527q;
    }

    public CloudPackage getPackage() {
        CloudPackage cloudPackage = this.f19518h;
        if (cloudPackage != null) {
            return cloudPackage;
        }
        return null;
    }

    public RelativeLayout getPackageCardDetailContainer() {
        return this.f19512b;
    }

    /* renamed from: h */
    public final /* synthetic */ void m25788h() {
        CountDownTimerView countDownTimerView = this.f19517g;
        if (countDownTimerView != null) {
            countDownTimerView.setVisibility(4);
        }
        CountDownEndListener countDownEndListener = this.f19529s;
        if (countDownEndListener != null) {
            countDownEndListener.mo23904a();
        }
    }

    /* renamed from: i */
    public void m25789i() {
        m25790j();
    }

    /* renamed from: j */
    public void m25790j() {
        Context context = this.f19521k;
        if (context == null) {
            C1442a.m8289e("PackageCardView", "setCardResource failed context is null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C1442a.m8289e("PackageCardView", "setCardResource failed resource is null");
            return;
        }
        this.f19524n = R$drawable.package_card_selected_state;
        int i10 = R$drawable.package_card_unselected_state;
        this.f19525o = i10;
        this.f19512b.setBackground(this.f19521k.getDrawable(i10));
        this.f19513c.setBackground(this.f19521k.getDrawable(R$drawable.operation_tag_silver_background));
        this.f19513c.setTextColor(resources.getColor(R$color.text_color_operation_tag_silver));
    }

    /* renamed from: k */
    public void m25791k() {
        RelativeLayout relativeLayout = this.f19512b;
        if (relativeLayout == null || this.f19521k == null) {
            return;
        }
        C11842p.m70730G1(relativeLayout);
    }

    /* renamed from: l */
    public void m25792l(TextView textView, int i10) {
        if (textView == null) {
            C1442a.m8289e("PackageCardView", "setGravityByPackageNum textView is null.");
        } else if (i10 == 2) {
            textView.setGravity(8388611);
        } else if (i10 == 1) {
            textView.setGravity(1);
        }
    }

    /* renamed from: m */
    public final void m25793m(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, Resources resources) {
        if (spannableStringBuilder == null) {
            C1442a.m8289e("PackageCardView", "buildPriceDisplayText error, priceSpan is null");
            return;
        }
        if (i10 < 0 || i12 < 0 || i13 <= 0 || i11 <= i13) {
            return;
        }
        int i14 = i11 - i13;
        if (i13 <= 3) {
            if (i14 <= 6) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
            } else {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(10, true), i10, i10 + i11, 33);
            }
        } else if (i14 <= 4) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
        } else {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(10, true), i10, i10 + i11, 33);
        }
        int i15 = i11 + i10;
        spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), i10, i15, 33);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), i10, i15, 33);
        if (resources != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R$color.package_card_old_price, null)), i10, i15, 33);
        }
        int i16 = i13 + i12;
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i12, i16, 33);
        float f10 = this.f19522l;
        int i17 = (f10 < 2.0f || f10 >= 3.2f) ? f10 >= 3.2f ? 38 : 20 : 24;
        if (f10 >= 1.75f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i17, true), i10, i15, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i17, true), i12, i16, 33);
        }
    }

    /* renamed from: n */
    public final void m25794n(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, Resources resources) {
        int i14;
        if (spannableStringBuilder == null) {
            C1442a.m8289e("PackageCardView", "setRealPriceSpan error, priceSpan is null");
            return;
        }
        if (i10 < 0 || i12 < 0 || i13 <= 0 || i11 <= i13) {
            return;
        }
        int i15 = i11 - i13;
        int i16 = 32;
        if (i13 <= 3) {
            if (i15 <= 6) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(32, true), i10, i10 + i11, 33);
            } else {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
            }
        } else if (i15 <= 4) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(32, true), i10, i10 + i11, 33);
        } else {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
        }
        int i17 = i11 + i10;
        spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-medium"), i10, i17, 33);
        if (resources != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R$color.package_card_real_price_color, null)), i10, i17, 33);
        }
        int i18 = i13 + i12;
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i12, i18, 33);
        float f10 = this.f19522l;
        if (f10 >= 2.0f && f10 < 3.2f) {
            i14 = 68;
        } else if (f10 >= 3.2f) {
            i14 = 100;
            i16 = 51;
        } else {
            i14 = 34;
            i16 = 16;
        }
        if (f10 >= 1.75f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i14, true), i10, i17, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i16, true), i12, i18, 33);
        }
    }

    /* renamed from: o */
    public final void m25795o() {
        if (this.f19518h == null) {
            C1442a.m8289e("PackageCardView", "currentPackage is null.");
            return;
        }
        if (!m25786f()) {
            C1442a.m8289e("PackageCardView", "initView is null.");
            return;
        }
        m25797q(this.f19513c, this.f19518h.getDurationTag());
        m25799s(this.f19514d, this.f19518h);
        m25798r(this.f19515e, this.f19518h);
        m25800t(this.f19516f, this.f19518h);
        m25784d();
        m25789i();
    }

    /* renamed from: p */
    public void m25796p(CloudPackage cloudPackage, GetClientUIConfigResp getClientUIConfigResp, String str, int i10) {
        this.f19518h = cloudPackage;
        this.f19519i = getClientUIConfigResp;
        this.f19520j = str;
        this.f19523m = i10;
        this.f19528r = cloudPackage.getCountDownConfig();
        m25795o();
    }

    /* renamed from: q */
    public final void m25797q(TextView textView, String str) {
        if (textView == null) {
            C1442a.m8289e("PackageCardView", "showLabel labelTV is null.");
            return;
        }
        if (this.f19527q) {
            textView.setVisibility(0);
            textView.setText(R$string.cloudpay_worry_free_current_package);
        } else if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    /* renamed from: r */
    public final void m25798r(TextView textView, CloudPackage cloudPackage) {
        String strM67749j;
        String strM67749j2;
        String string;
        if (textView == null) {
            C1442a.m8289e("PackageCardView", "showPrice priceDisTv is null.");
            return;
        }
        String currency = cloudPackage.getCurrency();
        String symbol = cloudPackage.getSymbol();
        BigDecimal spPrice = cloudPackage.getSpPrice();
        BigDecimal price = cloudPackage.getPrice();
        cloudPackage.getProductType();
        if (spPrice == null || spPrice.compareTo(price) >= 0) {
            strM67749j = C11290m.m67749j(price, currency, symbol);
            strM67749j2 = "";
            string = strM67749j;
        } else {
            strM67749j = C11290m.m67749j(spPrice, currency, symbol);
            strM67749j2 = C11290m.m67749j(price, currency, symbol);
            string = this.f19521k.getString(R$string.cloudpay_package_urse_space_detail, strM67749j, strM67749j2);
        }
        textView.setText(m25782b(string, strM67749j, strM67749j2));
        textView.setContentDescription(strM67749j);
        m25792l(textView, this.f19523m);
    }

    /* renamed from: s */
    public final void m25799s(TextView textView, CloudPackage cloudPackage) {
        if (textView == null || this.f19519i == null) {
            C1442a.m8289e("PackageCardView", "showProductName productNameTV or params is null.");
            return;
        }
        m25792l(textView, this.f19523m);
        int productType = cloudPackage.getProductType();
        textView.setText((productType == 5 || productType == 7) ? this.f19519i.getFixedTimeProductName(cloudPackage.getDurationMonth(), cloudPackage.getDurationUnit()) : (productType == 6 || productType == 8 || productType == 12) ? this.f19519i.getMonthPayProductName(cloudPackage.getDurationMonth(), cloudPackage.getDurationUnit()) : "");
        textView.requestLayout();
        textView.invalidate();
    }

    public void setCardSelected(boolean z10) {
        RelativeLayout relativeLayout;
        if (this.f19521k == null || (relativeLayout = this.f19512b) == null) {
            C1442a.m8289e("PackageCardView", "setCardSelected error, context or view is null");
        } else if (z10) {
            relativeLayout.setAccessibilityDelegate(new C4286a());
            this.f19512b.setBackground(this.f19521k.getDrawable(this.f19524n));
        } else {
            relativeLayout.setAccessibilityDelegate(new C4287b());
            this.f19512b.setBackground(this.f19521k.getDrawable(this.f19525o));
        }
    }

    public void setDetailHeight(int i10) {
        RelativeLayout relativeLayout = this.f19512b;
        if (relativeLayout == null || this.f19521k == null) {
            return;
        }
        C11842p.m70727F1(relativeLayout, i10);
    }

    public void setIsHasWorryFreeMonth(boolean z10) {
        this.f19527q = z10;
    }

    public void setOnCountDownEndListener(CountDownEndListener countDownEndListener) {
        this.f19529s = countDownEndListener;
    }

    /* renamed from: t */
    public final void m25800t(TextView textView, CloudPackage cloudPackage) {
        String remark3;
        if (textView == null) {
            C1442a.m8289e("PackageCardView", "showRemark remarkTV is null.");
            return;
        }
        m25792l(textView, this.f19523m);
        int productType = cloudPackage.getProductType();
        if (productType == 8 || productType == 7 || productType == 12) {
            remark3 = productType == 12 ? cloudPackage.getRemark3() : cloudPackage.getPackageTitle();
        } else {
            remark3 = "";
            if (productType == 6 && this.f19519i != null) {
                HashMap<String, String> extendTagMap = cloudPackage.getExtendTagMap();
                remark3 = extendTagMap != null ? extendTagMap.get("desc") : "";
                if (TextUtils.isEmpty(remark3)) {
                    remark3 = this.f19519i.getRecommendBasicPackageRemarak(cloudPackage.getDurationMonth());
                }
            }
        }
        if (TextUtils.isEmpty(remark3)) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
            textView.setText(remark3);
        }
    }

    public PackageCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m25785e(context);
        this.f19521k = context;
        this.f19518h = null;
        this.f19519i = null;
    }

    public PackageCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25785e(context);
        this.f19521k = context;
        this.f19518h = null;
        this.f19519i = null;
    }
}
