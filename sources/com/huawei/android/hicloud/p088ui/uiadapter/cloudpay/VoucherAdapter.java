package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.VoucherItemData;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import p054cj.C1442a;
import p454lj.C11290m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class VoucherAdapter extends RecyclerView.AbstractC0838h<C4096c> {

    /* renamed from: d */
    public Context f19058d;

    /* renamed from: e */
    public List<VoucherItemData> f19059e;

    /* renamed from: f */
    public HashMap<Integer, Integer> f19060f = new HashMap<>();

    /* renamed from: g */
    public UpdateVoucherDialogStateCallback f19061g;

    /* renamed from: h */
    public RecommendVouchers f19062h;

    /* renamed from: i */
    public CloudPackage f19063i;

    /* renamed from: j */
    public VoucherColumnCallback f19064j;

    /* renamed from: k */
    public Toast f19065k;

    public interface UpdateVoucherDialogStateCallback {
        /* renamed from: a */
        void mo23851a(List<Voucher> list, CloudPackage cloudPackage, RecommendVouchers recommendVouchers);
    }

    public interface VoucherColumnCallback {
        /* renamed from: a */
        void mo23831a(List<VoucherItemData> list, CloudPackage cloudPackage);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.VoucherAdapter$a */
    public class ViewOnClickListenerC4094a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C4096c f19066a;

        public ViewOnClickListenerC4094a(C4096c c4096c) {
            this.f19066a = c4096c;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            VoucherAdapter.this.m25415E(this.f19066a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.VoucherAdapter$b */
    public class ViewOnClickListenerC4095b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Voucher f19068a;

        public ViewOnClickListenerC4095b(Voucher voucher) {
            this.f19068a = voucher;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f19068a.getRuleStatus() == 0) {
                this.f19068a.setRuleStatus(1);
            } else {
                this.f19068a.setRuleStatus(0);
            }
            VoucherAdapter.this.m5213j();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.VoucherAdapter$c */
    public class C4096c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public TextView f19070A;

        /* renamed from: B */
        public TextView f19071B;

        /* renamed from: C */
        public TextView f19072C;

        /* renamed from: D */
        public TextView f19073D;

        /* renamed from: E */
        public HwButton f19074E;

        /* renamed from: F */
        public TextView f19075F;

        /* renamed from: G */
        public ImageView f19076G;

        /* renamed from: u */
        public TextView f19078u;

        /* renamed from: v */
        public View f19079v;

        /* renamed from: w */
        public RelativeLayout f19080w;

        /* renamed from: x */
        public RelativeLayout f19081x;

        /* renamed from: y */
        public RelativeLayout f19082y;

        /* renamed from: z */
        public TextView f19083z;

        public C4096c(View view) {
            super(view);
            this.f19078u = (TextView) C12809f.m76831d(view, R$id.voucher_list_title);
            this.f19079v = C12809f.m76831d(view, R$id.voucher_list_check_view);
            this.f19082y = (RelativeLayout) C12809f.m76831d(view, R$id.pay_vouchers_item_content);
            this.f19083z = (TextView) C12809f.m76831d(view, R$id.tv_vouchers_item_balance);
            this.f19071B = (TextView) C12809f.m76831d(view, R$id.tv_vouchers_item_balance_desc);
            this.f19070A = (TextView) C12809f.m76831d(view, R$id.tv_vouchers_item_info2);
            this.f19073D = (TextView) C12809f.m76831d(view, R$id.tv_vouchers_item_title);
            this.f19080w = (RelativeLayout) C12809f.m76831d(view, R$id.rl_voucher_item_label);
            this.f19072C = (TextView) C12809f.m76831d(view, R$id.tv_vouchers_item_eff_period);
            this.f19075F = (TextView) C12809f.m76831d(view, R$id.tv_vouchers_item_rule);
            this.f19074E = (HwButton) C12809f.m76831d(view, R$id.bt_use);
            this.f19076G = (ImageView) C12809f.m76831d(view, R$id.ic_voucher_rule_expand);
            this.f19081x = (RelativeLayout) C12809f.m76831d(view, R$id.pay_vouchers_item_detail);
        }
    }

    public VoucherAdapter(Context context, List<VoucherItemData> list, UpdateVoucherDialogStateCallback updateVoucherDialogStateCallback, RecommendVouchers recommendVouchers, CloudPackage cloudPackage, VoucherColumnCallback voucherColumnCallback) {
        this.f19058d = context;
        this.f19059e = list;
        this.f19061g = updateVoucherDialogStateCallback;
        this.f19062h = recommendVouchers;
        this.f19063i = cloudPackage;
        this.f19064j = voucherColumnCallback;
        m25422L();
    }

    /* renamed from: E */
    public final void m25415E(C4096c c4096c) throws Resources.NotFoundException {
        if (c4096c == null) {
            C1442a.m8289e("VoucherAdapter", "clickItem holder is null.");
            return;
        }
        if (this.f19059e == null) {
            C1442a.m8289e("VoucherAdapter", "clickItem voucherItemDataList is null.");
            return;
        }
        int iM5164k = c4096c.m5164k();
        if (iM5164k < 0) {
            C1442a.m8289e("VoucherAdapter", "clickItem clickPosition is invalid. clickPosition = " + iM5164k);
            return;
        }
        if (iM5164k >= this.f19059e.size()) {
            C1442a.m8289e("VoucherAdapter", "clickItem clickPosition >= voucherItemDataList.");
            return;
        }
        VoucherItemData voucherItemData = this.f19059e.get(iM5164k);
        if (voucherItemData == null) {
            C1442a.m8289e("VoucherAdapter", "voucherItemContainer click,voucherItemData is null.");
            return;
        }
        int itemType = voucherItemData.getItemType();
        if (this.f19060f.isEmpty()) {
            if (itemType == 1 || itemType == 2) {
                voucherItemData.setSelected(true);
                this.f19060f.put(Integer.valueOf(iM5164k), Integer.valueOf(itemType));
                m25423M();
                return;
            }
            return;
        }
        if (!this.f19060f.containsKey(Integer.valueOf(iM5164k))) {
            m25416F(voucherItemData, itemType, iM5164k);
            return;
        }
        voucherItemData.setSelected(false);
        this.f19060f.remove(Integer.valueOf(iM5164k));
        m25423M();
    }

    /* renamed from: F */
    public final void m25416F(VoucherItemData voucherItemData, int i10, int i11) throws Resources.NotFoundException {
        if (this.f19060f.containsValue(1)) {
            Integer next = this.f19060f.keySet().iterator().next();
            this.f19059e.get(next.intValue()).setSelected(false);
            this.f19060f.remove(next);
            voucherItemData.setSelected(true);
            this.f19060f.put(Integer.valueOf(i11), Integer.valueOf(i10));
            m25423M();
            return;
        }
        if (this.f19060f.containsValue(2)) {
            Iterator<Integer> it = this.f19060f.keySet().iterator();
            if (i10 == 1) {
                while (it.hasNext()) {
                    this.f19059e.get(it.next().intValue()).setSelected(false);
                }
                this.f19060f.clear();
                voucherItemData.setSelected(true);
                this.f19060f.put(Integer.valueOf(i11), Integer.valueOf(i10));
                m25423M();
                return;
            }
            if (i10 == 2) {
                if (this.f19060f.size() >= 10) {
                    Toast toast = this.f19065k;
                    if (toast != null) {
                        toast.cancel();
                    }
                    Toast toastMakeText = Toast.makeText(this.f19058d, R$string.cloudpay_voucher_choose_more, 0);
                    this.f19065k = toastMakeText;
                    toastMakeText.show();
                    return;
                }
                if (m25420J().compareTo((this.f19063i.getProductType() == 7 || this.f19063i.getProductType() == 8) ? this.f19063i.getSpPrice() : this.f19063i.getPrice()) < 0) {
                    voucherItemData.setSelected(true);
                    this.f19060f.put(Integer.valueOf(i11), Integer.valueOf(i10));
                    m25423M();
                } else {
                    Toast toast2 = this.f19065k;
                    if (toast2 != null) {
                        toast2.cancel();
                    }
                    Toast toastMakeText2 = Toast.makeText(this.f19058d, R$string.cloudpay_voucher_multiple_invalid, 0);
                    this.f19065k = toastMakeText2;
                    toastMakeText2.show();
                }
            }
        }
    }

    /* renamed from: G */
    public final SpannableString m25417G(String str, Voucher voucher) {
        SpannableString spannableString = new SpannableString(str);
        int i10 = 0;
        spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, 0, null, null), 0, str.length(), 0);
        Resources resources = this.f19058d.getResources();
        if (resources == null) {
            return spannableString;
        }
        String symbol = Currency.getInstance(voucher.getCurrency()).getSymbol();
        int iIndexOf = str.indexOf(symbol);
        int length = symbol.length() + iIndexOf;
        if ("CNY".equalsIgnoreCase(voucher.getCurrency())) {
            length = 1;
        } else {
            i10 = iIndexOf;
        }
        if (i10 == -1) {
            return spannableString;
        }
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), i10, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R$color.voucher_currency_color)), i10, length, 33);
        return spannableString;
    }

    /* renamed from: H */
    public final SpannableString m25418H(String str, Voucher voucher, String str2) {
        SpannableString spannableString = new SpannableString(str);
        if (this.f19058d.getResources() == null) {
            return spannableString;
        }
        int i10 = 0;
        spannableString.setSpan(new AbsoluteSizeSpan(10, true), 0, str.length(), 33);
        int iIndexOf = str.indexOf(str2);
        int length = str2.length() + iIndexOf;
        spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, 0, null, null), iIndexOf, length, 0);
        spannableString.setSpan(new AbsoluteSizeSpan(25, true), iIndexOf, length, 33);
        String symbol = Currency.getInstance(voucher.getCurrency()).getSymbol();
        int iIndexOf2 = str.indexOf(symbol);
        int length2 = symbol.length() + iIndexOf2;
        if ("CNY".equalsIgnoreCase(voucher.getCurrency())) {
            length2 = 1;
        } else {
            i10 = iIndexOf2;
        }
        if (i10 == -1) {
            return spannableString;
        }
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), i10, length2, 33);
        return spannableString;
    }

    /* renamed from: I */
    public final SpannableString m25419I(String str) {
        String strM25426P = Locale.getDefault().getLanguage().equals("zh") ? m25426P(new BigDecimal(str).multiply(new BigDecimal(10)).stripTrailingZeros().toPlainString()) : C2783d.m16144h(new BigDecimal(100).subtract(new BigDecimal(str).multiply(new BigDecimal(100))).intValue());
        String string = this.f19058d.getString(R$string.voucher_discount, strM25426P);
        SpannableString spannableString = new SpannableString(string);
        int iIndexOf = string.indexOf(strM25426P);
        int length = strM25426P.length() + iIndexOf;
        spannableString.setSpan(new AbsoluteSizeSpan(10, true), 0, string.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(25, true), iIndexOf, length, 33);
        spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, 0, null, null), 0, string.length(), 0);
        return spannableString;
    }

    /* renamed from: J */
    public final BigDecimal m25420J() {
        BigDecimal bigDecimal = new BigDecimal(0);
        List<VoucherItemData> list = this.f19059e;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("VoucherAdapter", "getOldMultipleChooseBalance voucherItemDataList is empty.");
            return bigDecimal;
        }
        for (VoucherItemData voucherItemData : this.f19059e) {
            if (voucherItemData.getItemType() == 2 && voucherItemData.isSelected()) {
                bigDecimal = bigDecimal.add(voucherItemData.getVoucher().getBalance());
            }
        }
        return bigDecimal;
    }

    /* renamed from: K */
    public final String m25421K(long j10, long j11) {
        TimeZone timeZoneM67755p = C11290m.m67755p(this.f19058d);
        return C11290m.m67745f(this.f19058d, j10, timeZoneM67755p) + "-" + C11290m.m67745f(this.f19058d, j11, timeZoneM67755p);
    }

    /* renamed from: L */
    public final void m25422L() {
        int i10 = 0;
        for (VoucherItemData voucherItemData : this.f19059e) {
            if (voucherItemData.isSelected()) {
                this.f19060f.put(Integer.valueOf(i10), Integer.valueOf(voucherItemData.getItemType()));
            }
            i10++;
        }
    }

    /* renamed from: M */
    public void m25423M() {
        Voucher voucher;
        m5213j();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.f19060f.keySet().iterator();
        while (it.hasNext()) {
            VoucherItemData voucherItemData = this.f19059e.get(it.next().intValue());
            if (voucherItemData != null && (voucher = voucherItemData.getVoucher()) != null) {
                arrayList.add(voucher);
            }
        }
        UpdateVoucherDialogStateCallback updateVoucherDialogStateCallback = this.f19061g;
        if (updateVoucherDialogStateCallback != null) {
            updateVoucherDialogStateCallback.mo23851a(arrayList, this.f19063i, this.f19062h);
        }
        VoucherColumnCallback voucherColumnCallback = this.f19064j;
        if (voucherColumnCallback != null) {
            voucherColumnCallback.mo23831a(this.f19059e, this.f19063i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4096c c4096c, int i10) throws Resources.NotFoundException {
        List<VoucherItemData> list = this.f19059e;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("VoucherAdapter", "onBindViewHolder voucherItemDataList is null.");
            return;
        }
        if (i10 >= this.f19059e.size()) {
            C1442a.m8289e("VoucherAdapter", "position > list size");
            return;
        }
        VoucherItemData voucherItemData = this.f19059e.get(i10);
        if (voucherItemData == null) {
            C1442a.m8289e("VoucherAdapter", "onBindViewHolder voucherItemData is null.");
            return;
        }
        c4096c.f19074E.setVisibility(8);
        c4096c.f19080w.setVisibility(8);
        if (voucherItemData.getItemType() == 0) {
            c4096c.f19078u.setText(voucherItemData.getTitle());
            c4096c.f19078u.setVisibility(0);
            c4096c.f19082y.setVisibility(8);
        } else {
            c4096c.f19078u.setVisibility(8);
            c4096c.f19082y.setVisibility(0);
            c4096c.f19082y.setOnClickListener(new ViewOnClickListenerC4094a(c4096c));
            m25427Q(c4096c, voucherItemData.getVoucher());
            m25430T(c4096c.f19082y, c4096c.f19079v, voucherItemData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public C4096c mo724u(ViewGroup viewGroup, int i10) {
        return new C4096c(LayoutInflater.from(this.f19058d).inflate(R$layout.vouchet_list_item, viewGroup, false));
    }

    /* renamed from: P */
    public final String m25426P(String str) {
        return Pattern.compile("(\\d*)\\.[0]{1}").matcher(str).matches() ? str.replace(".0", "") : Pattern.compile("(\\d*)\\.[0]{2}").matcher(str).matches() ? str.replace(".00", "") : str;
    }

    /* renamed from: Q */
    public final void m25427Q(C4096c c4096c, Voucher voucher) throws Resources.NotFoundException {
        String feeMode = voucher.getFeeMode();
        if (feeMode.equals("0")) {
            String strM67749j = C11290m.m67749j(voucher.getBalance(), voucher.getCurrency(), null);
            String strM67749j2 = C11290m.m67749j(new BigDecimal(voucher.getFaceValue()), voucher.getCurrency(), null);
            String string = this.f19058d.getString(R$string.voucher_balance_new, strM67749j);
            c4096c.f19071B.setVisibility(8);
            c4096c.f19083z.setText(m25418H(string, voucher, strM67749j));
            String string2 = this.f19058d.getString(R$string.voucher_facevalue, strM67749j2);
            c4096c.f19070A.setVisibility(0);
            c4096c.f19070A.setText(string2);
        } else if (feeMode.equals("1")) {
            String strM67749j3 = C11290m.m67749j(voucher.getSubFee(), voucher.getCurrency(), null);
            String strM67749j4 = C11290m.m67749j(voucher.getMinFee(), voucher.getCurrency(), null);
            c4096c.f19070A.setVisibility(0);
            c4096c.f19070A.setText(this.f19058d.getString(R$string.voucher_min_fee, strM67749j4));
            c4096c.f19083z.setText(m25417G(strM67749j3, voucher));
            c4096c.f19071B.setVisibility(8);
        } else {
            c4096c.f19071B.setVisibility(8);
            c4096c.f19070A.setVisibility(8);
            c4096c.f19083z.setText(m25419I(voucher.getDiscount()));
        }
        Resources resources = this.f19058d.getResources();
        if (resources != null) {
            ViewGroup.LayoutParams layoutParams = c4096c.f19081x.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(resources.getDimensionPixelSize(R$dimen.cloud_space_64_dp));
            }
        }
        String voucherSubTitle = voucher.getVoucherSubTitle();
        c4096c.f19075F.setText(voucherSubTitle);
        c4096c.f19072C.setText(m25421K(voucher.getEffectiveTime(), voucher.getExpireTime()));
        c4096c.f19073D.setText(voucher.getVoucherTitle());
        m25428R(c4096c, voucherSubTitle, voucher);
    }

    /* renamed from: R */
    public final void m25428R(C4096c c4096c, String str, Voucher voucher) throws Resources.NotFoundException {
        Resources resources;
        int iM70844o;
        int dimensionPixelSize;
        if (voucher == null || TextUtils.isEmpty(str) || (resources = this.f19058d.getResources()) == null) {
            return;
        }
        int ruleStatus = voucher.getRuleStatus();
        int desiredWidth = (int) Layout.getDesiredWidth(str, 0, str.length(), c4096c.f19075F.getPaint());
        int iM70829k0 = C11842p.m70829k0(this.f19058d);
        if (iM70829k0 == 0) {
            iM70844o = C11842p.m70758Q(this.f19058d) - (resources.getDimensionPixelSize(R$dimen.cloud_space_24_dp) * 2);
            dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_10_dp);
        } else {
            iM70844o = ((int) C11842p.m70844o(this.f19058d, iM70829k0)) - (resources.getDimensionPixelSize(R$dimen.cloud_space_24_dp) * 2);
            dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_56_dp);
        }
        int dimensionPixelSize2 = ((((iM70844o - resources.getDimensionPixelSize(R$dimen.cloud_space_16_dp)) - resources.getDimensionPixelSize(R$dimen.cloud_space_4_dp)) - resources.getDimensionPixelSize(R$dimen.cloud_space_56_dp)) - resources.getDimensionPixelSize(R$dimen.cloud_space_10_dp)) - dimensionPixelSize;
        if (desiredWidth > dimensionPixelSize2) {
            if (ruleStatus == 0) {
                c4096c.f19076G.setImageResource(R$drawable.ic_16_arrow_down);
                c4096c.f19075F.setMaxLines(1);
            } else {
                c4096c.f19076G.setImageResource(R$drawable.ic_16_arrow_up);
                c4096c.f19075F.setMaxLines(10);
            }
            c4096c.f19075F.setMaxWidth(dimensionPixelSize2);
            c4096c.f19076G.setVisibility(0);
        } else {
            c4096c.f19076G.setImageResource(R$drawable.ic_16_arrow_down);
            c4096c.f19075F.setMaxLines(1);
            c4096c.f19075F.setMaxWidth(dimensionPixelSize2);
            c4096c.f19076G.setVisibility(8);
        }
        c4096c.f19076G.setOnClickListener(new ViewOnClickListenerC4095b(voucher));
    }

    /* renamed from: S */
    public void m25429S() {
        Voucher voucher;
        if (this.f19062h == null) {
            C1442a.m8289e("VoucherAdapter", "showRecommendVouchers recommendVouchers is null.");
            return;
        }
        List<VoucherItemData> list = this.f19059e;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("VoucherAdapter", "showRecommendVouchers voucherItemDataList is empty.");
            return;
        }
        List<Voucher> voucherList = this.f19062h.getVoucherList();
        this.f19060f.clear();
        for (int i10 = 0; i10 < this.f19059e.size(); i10++) {
            VoucherItemData voucherItemData = this.f19059e.get(i10);
            if (voucherItemData != null && (voucher = voucherItemData.getVoucher()) != null) {
                String voucherCode = voucher.getVoucherCode();
                voucherItemData.setSelected(false);
                Iterator<Voucher> it = voucherList.iterator();
                while (it.hasNext()) {
                    if (voucherCode.equals(it.next().getVoucherCode())) {
                        voucherItemData.setSelected(true);
                        this.f19060f.put(Integer.valueOf(i10), Integer.valueOf(voucherItemData.getItemType()));
                    }
                }
            }
        }
        m25423M();
    }

    /* renamed from: T */
    public final void m25430T(View view, View view2, VoucherItemData voucherItemData) {
        if (view2 == null || view == null) {
            C1442a.m8289e("VoucherAdapter", "setCheckStatusView checkStatusView is null.");
            return;
        }
        if (this.f19058d == null) {
            C1442a.m8289e("VoucherAdapter", "setCheckStatusView mContext is null.");
            return;
        }
        int itemType = voucherItemData.getItemType();
        boolean zIsSelected = voucherItemData.isSelected();
        view2.setVisibility(0);
        view.setAccessibilityDelegate(C2783d.m16128b1(zIsSelected));
        if (itemType == 1) {
            if (zIsSelected) {
                view2.setBackground(this.f19058d.getDrawable(R$drawable.voucher_single_choose));
                return;
            } else {
                view2.setBackground(this.f19058d.getDrawable(R$drawable.voucher_single_unchoose));
                return;
            }
        }
        if (itemType == 2) {
            if (zIsSelected) {
                view2.setBackground(this.f19058d.getDrawable(R$drawable.voucher_multiple_choose));
            } else {
                view2.setBackground(this.f19058d.getDrawable(R$drawable.voucher_multiple_unchoose));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<VoucherItemData> list = this.f19059e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
