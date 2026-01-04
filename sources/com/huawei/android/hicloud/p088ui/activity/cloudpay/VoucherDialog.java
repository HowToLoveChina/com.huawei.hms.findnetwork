package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VoucherAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$style;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.OnePackegeVouchers;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.VoucherItemData;
import com.huawei.cloud.pay.p098ui.decoration.VoucherItemDecoration;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import p015ak.C0219i;
import p054cj.C1442a;
import p454lj.C11290m;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11842p;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class VoucherDialog extends Dialog implements View.OnClickListener, VoucherAdapter.UpdateVoucherDialogStateCallback {

    /* renamed from: a */
    public Context f17456a;

    /* renamed from: b */
    public RecyclerView f17457b;

    /* renamed from: c */
    public TextView f17458c;

    /* renamed from: d */
    public View f17459d;

    /* renamed from: e */
    public TextView f17460e;

    /* renamed from: f */
    public VoucherAdapter f17461f;

    /* renamed from: g */
    public AutoSizeButton f17462g;

    /* renamed from: h */
    public NotchFitRelativeLayout f17463h;

    /* renamed from: i */
    public List<List<View>> f17464i;

    /* renamed from: j */
    public BigDecimal f17465j;

    public VoucherDialog(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context, R$style.CouponDialogTheme);
        this.f17456a = context;
        m23855e();
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.cloudpay.VoucherAdapter.UpdateVoucherDialogStateCallback
    /* renamed from: a */
    public void mo23851a(List<Voucher> list, CloudPackage cloudPackage, RecommendVouchers recommendVouchers) {
        m23861k(list, cloudPackage, recommendVouchers);
    }

    /* renamed from: b */
    public void m23852b() {
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this.f17456a)) {
            C12806c.m76820k(this.f17456a, this.f17464i.get(1));
        }
        C11842p.m70870u1(this.f17456a, this.f17462g);
        m23858h();
        VoucherAdapter voucherAdapter = this.f17461f;
        if (voucherAdapter != null) {
            voucherAdapter.m5213j();
        }
    }

    /* renamed from: c */
    public final BigDecimal m23853c(List<Voucher> list, CloudPackage cloudPackage) {
        BigDecimal bigDecimal = new BigDecimal(0);
        BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
        for (Voucher voucher : list) {
            String feeMode = voucher.getFeeMode();
            if ("2".equals(feeMode) || "1".equals(feeMode)) {
                return bigDecimal.add(C11296s.m67823k(cloudPackage, voucher, this.f17465j));
            }
            bigDecimal = bigDecimal.add(C11296s.m67823k(cloudPackage, voucher, this.f17465j));
            if (bigDecimal.compareTo(bigDecimalM67838v) >= 0) {
                return bigDecimalM67838v;
            }
        }
        return bigDecimal;
    }

    /* renamed from: d */
    public final SpannableStringBuilder m23854d(String str, String str2, String str3) {
        Context context;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = str.length();
        if (TextUtils.isEmpty(str) || (context = this.f17456a) == null) {
            C1442a.m8290i("VoucherDialog", "getSelectionTextStyle error valuses.");
            return spannableStringBuilder;
        }
        Resources resources = context.getResources();
        if (!TextUtils.isEmpty(str2)) {
            int iIndexOf = str.indexOf(str2);
            int length2 = str2.length() + iIndexOf;
            if (iIndexOf >= 0 && length2 <= length) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R$color.cloud_pay_A35919, null)), iIndexOf, length2, 33);
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            int iIndexOf2 = str.indexOf(str3);
            int length3 = str3.length() + iIndexOf2;
            if (iIndexOf2 >= 0 && length3 <= length) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R$color.cloud_pay_A35919, null)), iIndexOf2, length3, 33);
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: e */
    public final void m23855e() throws IllegalAccessException, IllegalArgumentException {
        C11829c.m70594l1(this.f17456a, this);
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.windowAnimations = R$style.BottomInAndOutStyle;
                attributes.gravity = 80;
                window.setAttributes(attributes);
            }
        }
        View viewM76832e = C12809f.m76832e(getLayoutInflater(), R$layout.coupon_dialog_layout);
        setContentView(viewM76832e);
        this.f17463h = (NotchFitRelativeLayout) C12809f.m76831d(viewM76832e, R$id.main_layout_voucher_dialog);
        this.f17460e = (TextView) C12809f.m76831d(viewM76832e, R$id.voucher_dialog_selection);
        m23858h();
        View viewM76831d = C12809f.m76831d(viewM76832e, R$id.coupon_cancel);
        this.f17459d = viewM76831d;
        viewM76831d.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.voucher_dialog_recommend);
        this.f17458c = textView;
        textView.setOnClickListener(this);
        this.f17457b = (RecyclerView) C12809f.m76831d(viewM76832e, R$id.voucher_list);
        this.f17457b.setLayoutManager(new LinearLayoutManager(this.f17456a));
        this.f17457b.addItemDecoration(new VoucherItemDecoration(this.f17456a));
        this.f17457b.setHasFixedSize(true);
        this.f17457b.setNestedScrollingEnabled(false);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(viewM76832e, R$id.buy_package_btn);
        this.f17462g = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        C11842p.m70870u1(this.f17456a, this.f17462g);
        m23856f();
    }

    /* renamed from: f */
    public void m23856f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17463h);
        this.f17464i = C11842p.m70887y2(arrayList);
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this.f17456a)) {
            return;
        }
        C12806c.m76821l(this.f17456a, arrayList);
        C12806c.m76820k(this.f17456a, this.f17464i.get(1));
    }

    /* renamed from: g */
    public void m23857g() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_RECOMMEND_BUTTON", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_RECOMMEND_BUTTON", "1", "31", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("VoucherDialog", "ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: h */
    public final void m23858h() {
        int iM70821i0 = C11842p.m70821i0((int) C11842p.m70844o(this.f17456a, C11842p.m70829k0(this.f17456a)), this.f17456a);
        TextView textView = this.f17460e;
        if (textView != null) {
            textView.setMaxWidth(iM70821i0);
        }
    }

    /* renamed from: i */
    public void m23859i(OnePackegeVouchers onePackegeVouchers, RecommendVouchers recommendVouchers, CloudPackage cloudPackage, VoucherAdapter.VoucherColumnCallback voucherColumnCallback, BigDecimal bigDecimal) {
        if (onePackegeVouchers == null) {
            C1442a.m8289e("VoucherDialog", "showDialog onePackegeVouchers is null.");
            return;
        }
        this.f17465j = bigDecimal;
        VoucherAdapter voucherAdapter = new VoucherAdapter(this.f17456a, C11296s.m67800X(onePackegeVouchers, recommendVouchers.getVoucherList(), this.f17456a), this, recommendVouchers, cloudPackage, voucherColumnCallback);
        this.f17461f = voucherAdapter;
        this.f17457b.setAdapter(voucherAdapter);
        m23861k(recommendVouchers.getVoucherList(), cloudPackage, recommendVouchers);
        show();
    }

    /* renamed from: j */
    public void m23860j(List<VoucherItemData> list, RecommendVouchers recommendVouchers, CloudPackage cloudPackage, VoucherAdapter.VoucherColumnCallback voucherColumnCallback, BigDecimal bigDecimal) {
        this.f17465j = bigDecimal;
        VoucherAdapter voucherAdapter = new VoucherAdapter(this.f17456a, list, this, recommendVouchers, cloudPackage, voucherColumnCallback);
        this.f17461f = voucherAdapter;
        this.f17457b.setAdapter(voucherAdapter);
        ArrayList arrayList = new ArrayList();
        for (VoucherItemData voucherItemData : list) {
            if (voucherItemData.isSelected()) {
                arrayList.add(voucherItemData.getVoucher());
            }
        }
        m23861k(arrayList, cloudPackage, recommendVouchers);
        show();
    }

    /* renamed from: k */
    public final void m23861k(List<Voucher> list, CloudPackage cloudPackage, RecommendVouchers recommendVouchers) {
        if (list == null) {
            C1442a.m8289e("VoucherDialog", "updateVoucherDialogState voucherList is null.");
            return;
        }
        if (this.f17460e == null) {
            C1442a.m8289e("VoucherDialog", "updateVoucherDialogState voucherDialogSelectionState is null.");
            return;
        }
        String strM67749j = C11290m.m67749j(m23853c(list, cloudPackage), cloudPackage.getCurrency(), cloudPackage.getSymbol());
        if (this.f17456a == null) {
            C1442a.m8289e("VoucherDialog", "showSelectionStateView mContext is null.");
            return;
        }
        if (C11296s.m67794R(list, recommendVouchers)) {
            this.f17460e.setText(m23854d(this.f17456a.getString(R$string.cloudpay_voucher_recommend_discount, strM67749j), null, strM67749j));
            TextView textView = this.f17458c;
            if (textView != null) {
                textView.setTextColor(this.f17456a.getColor(R$color.cloud_pay_66_A35919));
                this.f17458c.setClickable(false);
                return;
            }
            return;
        }
        int size = list.size();
        String str = String.format(Locale.ENGLISH, "%d", Integer.valueOf(size));
        this.f17460e.setText(m23854d(this.f17456a.getResources().getQuantityString(R$plurals.cloudpay_select_voucher_num, size, str, strM67749j), str, strM67749j));
        TextView textView2 = this.f17458c;
        if (textView2 != null) {
            textView2.setTextColor(this.f17456a.getColor(R$color.cloud_pay_A35919));
            this.f17458c.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            C1442a.m8289e("VoucherDialog", "onClick v is null.");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.coupon_cancel) {
            dismiss();
            return;
        }
        if (id2 != R$id.voucher_dialog_recommend) {
            if (id2 == R$id.buy_package_btn) {
                dismiss();
            }
        } else {
            VoucherAdapter voucherAdapter = this.f17461f;
            if (voucherAdapter != null) {
                voucherAdapter.m25429S();
            }
            m23857g();
        }
    }
}
