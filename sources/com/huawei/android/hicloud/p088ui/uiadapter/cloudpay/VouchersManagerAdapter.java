package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import p454lj.C11290m;
import p454lj.C11296s;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class VouchersManagerAdapter extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f19084a;

    /* renamed from: b */
    public Context f19085b;

    /* renamed from: c */
    public List<Voucher> f19086c = new ArrayList();

    /* renamed from: d */
    public View.OnClickListener f19087d;

    /* renamed from: e */
    public int f19088e;

    /* renamed from: f */
    public int f19089f;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.VouchersManagerAdapter$a */
    public static class C4097a {

        /* renamed from: a */
        public RelativeLayout f19090a;

        /* renamed from: b */
        public RelativeLayout f19091b;

        /* renamed from: c */
        public RelativeLayout f19092c;

        /* renamed from: d */
        public TextView f19093d = null;

        /* renamed from: e */
        public TextView f19094e = null;

        /* renamed from: f */
        public TextView f19095f = null;

        /* renamed from: g */
        public TextView f19096g = null;

        /* renamed from: h */
        public TextView f19097h = null;

        /* renamed from: i */
        public TextView f19098i = null;

        /* renamed from: j */
        public ImageView f19099j = null;

        /* renamed from: k */
        public TextView f19100k = null;

        /* renamed from: l */
        public HwButton f19101l = null;

        /* renamed from: m */
        public ImageView f19102m = null;
    }

    public VouchersManagerAdapter(Context context) {
        this.f19085b = null;
        this.f19085b = context;
        this.f19084a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void mo25309a(List<? extends Voucher> list) {
        int i10 = this.f19088e;
        if (i10 == 1 || i10 == 2) {
            this.f19086c.addAll(list);
            return;
        }
        this.f19086c.addAll(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Voucher voucher : this.f19086c) {
            if (voucher.getOrderStatus() == 0) {
                arrayList.add(voucher);
            } else {
                arrayList2.add(voucher);
            }
        }
        this.f19086c.clear();
        this.f19086c.addAll(arrayList);
        this.f19086c.addAll(arrayList2);
    }

    /* renamed from: b */
    public void m25434b() {
        this.f19086c.clear();
    }

    /* renamed from: c */
    public void mo25310c(C4097a c4097a, Voucher voucher) {
        String useUrl = voucher.getUseUrl();
        if (TextUtils.isEmpty(useUrl)) {
            c4097a.f19101l.setVisibility(8);
            return;
        }
        String scheme = Uri.parse(useUrl).getScheme();
        if (scheme == null || !scheme.equals("hicloud")) {
            c4097a.f19101l.setVisibility(8);
        } else {
            c4097a.f19101l.setVisibility(0);
        }
    }

    /* renamed from: d */
    public final SpannableString m25435d(String str, Voucher voucher) {
        SpannableString spannableString = new SpannableString(str);
        int i10 = 0;
        spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, 0, null, null), 0, str.length(), 0);
        Resources resources = this.f19085b.getResources();
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
        int i11 = this.f19088e;
        if (i11 == 2 || i11 == 1 || voucher.getOrderStatus() != 0) {
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R$color.voucher_unuseable_currency_color)), i10, length, 33);
        }
        return spannableString;
    }

    /* renamed from: e */
    public final SpannableString m25436e(String str, Voucher voucher, String str2) {
        SpannableString spannableString = new SpannableString(str);
        Resources resources = this.f19085b.getResources();
        if (resources == null) {
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
        int i11 = this.f19088e;
        if (i11 == 2 || i11 == 1 || voucher.getOrderStatus() != 0) {
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R$color.voucher_unuseable_currency_color)), i10, length2, 33);
        }
        return spannableString;
    }

    /* renamed from: f */
    public final SpannableString m25437f(String str) {
        String strM25441l = Locale.getDefault().getLanguage().equals("zh") ? m25441l(new BigDecimal(str).multiply(new BigDecimal(10)).stripTrailingZeros().toPlainString()) : C2783d.m16144h(new BigDecimal(100).subtract(new BigDecimal(str).multiply(new BigDecimal(100))).intValue());
        String string = this.f19085b.getString(R$string.voucher_discount, strM25441l);
        SpannableString spannableString = new SpannableString(string);
        int iIndexOf = string.indexOf(strM25441l);
        int length = strM25441l.length() + iIndexOf;
        spannableString.setSpan(new AbsoluteSizeSpan(10, true), 0, string.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(25, true), iIndexOf, length, 33);
        spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, 0, null, null), 0, string.length(), 0);
        return spannableString;
    }

    @Override // android.widget.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Voucher getItem(int i10) {
        return this.f19086c.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19086c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        C4097a c4097a;
        if (view == null) {
            C4097a c4097a2 = new C4097a();
            View viewM76832e = C12809f.m76832e(this.f19084a, R$layout.pay_vouchers_list_item);
            c4097a2.f19090a = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.pay_vouchers_item_content);
            c4097a2.f19093d = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_vouchers_item_balance);
            c4097a2.f19092c = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.pay_vouchers_item_detail);
            c4097a2.f19094e = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_vouchers_item_balance_desc);
            c4097a2.f19095f = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_vouchers_item_info2);
            c4097a2.f19096g = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_vouchers_item_title);
            c4097a2.f19091b = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.rl_voucher_item_label);
            c4097a2.f19102m = (ImageView) C12809f.m76831d(viewM76832e, R$id.imag_voucher_cloud);
            c4097a2.f19097h = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_vouchers_item_eff_period);
            c4097a2.f19098i = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_vouchers_item_rule);
            c4097a2.f19100k = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_vouchers_item_label);
            HwButton hwButton = (HwButton) C12809f.m76831d(viewM76832e, R$id.bt_use);
            c4097a2.f19101l = hwButton;
            hwButton.setOnClickListener(this.f19087d);
            ImageView imageView = (ImageView) C12809f.m76831d(viewM76832e, R$id.ic_voucher_rule_expand);
            c4097a2.f19099j = imageView;
            imageView.setOnClickListener(this.f19087d);
            viewM76832e.setTag(c4097a2);
            viewM76832e.setOnClickListener(this.f19087d);
            c4097a = c4097a2;
            view = viewM76832e;
        } else {
            c4097a = (C4097a) view.getTag();
        }
        view.setAccessibilityDelegate(C2783d.m16078D0());
        if (this.f19089f != 0) {
            c4097a.f19090a.getLayoutParams().width = (int) C11842p.m70844o(this.f19085b, this.f19089f);
        }
        Voucher item = getItem(i10);
        c4097a.f19099j.setTag(Integer.valueOf(i10));
        if (item != null) {
            if (item.getVoucherCardType() == 1) {
                m25449u(c4097a, item);
            } else {
                mo25313r(c4097a, item);
            }
            c4097a.f19101l.setTag(Integer.valueOf(i10));
            int i11 = this.f19088e;
            if (i11 == 1 || i11 == 2) {
                c4097a.f19098i.setText(item.getVoucherSubTitle());
                m25448t(c4097a, item.getVoucherSubTitle());
                m25445p(c4097a);
                return view;
            }
            if (item.getOrderStatus() == 1) {
                String strMo25311i = mo25311i(item);
                c4097a.f19098i.setText(strMo25311i);
                m25445p(c4097a);
                c4097a.f19099j.setVisibility(8);
                m25448t(c4097a, strMo25311i);
                return view;
            }
            String strMo25312j = mo25312j(item);
            c4097a.f19098i.setText(strMo25312j);
            m25446q(c4097a);
            c4097a.f19099j.setVisibility(8);
            m25448t(c4097a, strMo25312j);
            if (item.getSuperScript() == 1) {
                c4097a.f19090a.setBackgroundResource(R$drawable.voucher_item_bg_new);
                c4097a.f19091b.setBackgroundResource(R$drawable.voucher_label_new_bg);
            } else {
                c4097a.f19090a.setBackgroundResource(R$drawable.voucher_item_bg_normal);
                c4097a.f19091b.setBackgroundResource(R$drawable.voucher_label_bg);
            }
            mo25310c(c4097a, item);
            m25443n(c4097a, item.getSuperScript());
        }
        C11296s.m67781E(this.f19085b, c4097a.f19090a);
        return view;
    }

    /* renamed from: h */
    public int m25439h() {
        Resources resources = this.f19085b.getResources();
        return (((((resources.getConfiguration().orientation == 2 ? C11842p.m70752O(this.f19085b) : C11842p.m70758Q(this.f19085b)) - (resources.getDimensionPixelSize(R$dimen.cloud_space_24_dp) * 2)) - resources.getDimensionPixelSize(R$dimen.cloud_space_10_dp)) * 2) / 3) - resources.getDimensionPixelSize(R$dimen.cloud_space_16_dp);
    }

    /* renamed from: i */
    public String mo25311i(Voucher voucher) {
        return this.f19085b.getString(R$string.voucher_unavailable_reason, voucher.getUbusableDesc());
    }

    /* renamed from: j */
    public String mo25312j(Voucher voucher) {
        return voucher.getVoucherSubTitle();
    }

    /* renamed from: k */
    public String m25440k(long j10, long j11) {
        TimeZone timeZoneM67755p = C11290m.m67755p(this.f19085b);
        return C11290m.m67745f(this.f19085b, j10, timeZoneM67755p) + "-" + C11290m.m67745f(this.f19085b, j11, timeZoneM67755p);
    }

    /* renamed from: l */
    public final String m25441l(String str) {
        return Pattern.compile("(\\d*)\\.[0]{1}").matcher(str).matches() ? str.replace(".0", "") : Pattern.compile("(\\d*)\\.[0]{2}").matcher(str).matches() ? str.replace(".00", "") : str;
    }

    /* renamed from: m */
    public void m25442m(Voucher voucher, Resources resources, ViewGroup.LayoutParams layoutParams) {
        if (mo25314w(voucher)) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(resources.getDimensionPixelSize(R$dimen.cloud_space_108_dp));
            }
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(resources.getDimensionPixelSize(R$dimen.cloud_space_8_dp));
        }
    }

    /* renamed from: n */
    public final void m25443n(C4097a c4097a, int i10) {
        if (i10 == 1) {
            c4097a.f19100k.setText(R$string.voucher_new_arrive);
            c4097a.f19091b.setVisibility(0);
            c4097a.f19091b.setBackgroundResource(R$drawable.voucher_label_new_bg);
            c4097a.f19100k.setMaxWidth(m25439h());
            return;
        }
        if (i10 != 2) {
            c4097a.f19091b.setVisibility(8);
            return;
        }
        c4097a.f19100k.setText(R$string.voucher_almost_expire);
        c4097a.f19091b.setVisibility(0);
        c4097a.f19091b.setBackgroundResource(R$drawable.voucher_label_bg);
        c4097a.f19100k.setMaxWidth(m25439h());
    }

    /* renamed from: o */
    public void m25444o(int i10) {
        this.f19089f = i10;
    }

    /* renamed from: p */
    public final void m25445p(C4097a c4097a) {
        int color = this.f19085b.getColor(R$color.voucher_unuseable_currency_color);
        int color2 = this.f19085b.getColor(R$color.voucher_unuseable_banlance_color);
        TextView textView = c4097a.f19093d;
        if (textView != null) {
            textView.setTextColor(color2);
        }
        TextView textView2 = c4097a.f19094e;
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
        c4097a.f19096g.setTextColor(color);
        c4097a.f19095f.setTextColor(color);
        c4097a.f19097h.setTextColor(color);
        c4097a.f19098i.setTextColor(color);
        c4097a.f19090a.setBackgroundResource(R$drawable.voucher_item_bg_expired);
        c4097a.f19102m.setImageResource(R$drawable.voucher_item_cloud_gray);
        c4097a.f19101l.setVisibility(8);
        c4097a.f19091b.setVisibility(8);
        C11296s.m67781E(this.f19085b, c4097a.f19090a);
    }

    /* renamed from: q */
    public final void m25446q(C4097a c4097a) {
        TextView textView = c4097a.f19093d;
        if (textView != null) {
            textView.setTextColor(this.f19085b.getColor(R$color.voucher_currency_color));
        }
        TextView textView2 = c4097a.f19094e;
        if (textView2 != null) {
            textView2.setTextColor(this.f19085b.getColor(R$color.voucher_currency_color));
        }
        TextView textView3 = c4097a.f19096g;
        Context context = this.f19085b;
        int i10 = R$color.voucher_currency_color;
        textView3.setTextColor(context.getColor(i10));
        c4097a.f19095f.setTextColor(this.f19085b.getColor(i10));
        c4097a.f19090a.setBackgroundResource(R$drawable.voucher_item_bg_normal);
        c4097a.f19102m.setImageResource(R$drawable.voucher_item_cloud_normal);
        TextView textView4 = c4097a.f19098i;
        Context context2 = this.f19085b;
        int i11 = R$color.voucher_period_color;
        textView4.setTextColor(context2.getColor(i11));
        c4097a.f19097h.setTextColor(this.f19085b.getColor(i11));
    }

    /* renamed from: r */
    public void mo25313r(C4097a c4097a, Voucher voucher) {
        RelativeLayout relativeLayout;
        String feeMode = voucher.getFeeMode();
        if (feeMode.equals("0")) {
            String strM67749j = C11290m.m67749j(voucher.getBalance(), voucher.getCurrency(), null);
            String string = this.f19085b.getString(R$string.voucher_balance_new, strM67749j);
            String string2 = this.f19085b.getString(R$string.voucher_facevalue, C11290m.m67749j(new BigDecimal(voucher.getFaceValue()), voucher.getCurrency(), null));
            c4097a.f19094e.setVisibility(8);
            c4097a.f19093d.setText(m25436e(string, voucher, strM67749j));
            c4097a.f19095f.setText(string2);
            c4097a.f19095f.setVisibility(0);
        } else if (feeMode.equals("1")) {
            String strM67749j2 = C11290m.m67749j(voucher.getSubFee(), voucher.getCurrency(), null);
            String strM67749j3 = C11290m.m67749j(voucher.getMinFee(), voucher.getCurrency(), null);
            c4097a.f19093d.setText(m25435d(strM67749j2, voucher));
            c4097a.f19094e.setVisibility(8);
            c4097a.f19095f.setText(this.f19085b.getString(R$string.voucher_min_fee, strM67749j3));
            c4097a.f19095f.setVisibility(0);
        } else {
            c4097a.f19093d.setText(m25437f(voucher.getDiscount()));
            c4097a.f19095f.setVisibility(8);
            c4097a.f19094e.setVisibility(8);
        }
        Resources resources = this.f19085b.getResources();
        if (resources != null && (relativeLayout = c4097a.f19092c) != null) {
            m25442m(voucher, resources, relativeLayout.getLayoutParams());
        }
        c4097a.f19096g.setText(voucher.getVoucherTitle());
        c4097a.f19096g.setVisibility(0);
        c4097a.f19097h.setText(m25440k(voucher.getEffectiveTime(), voucher.getExpireTime()));
    }

    /* renamed from: s */
    public void m25447s(int i10) {
        this.f19088e = i10;
    }

    /* renamed from: t */
    public final void m25448t(C4097a c4097a, String str) throws Resources.NotFoundException {
        int iM70844o;
        int dimensionPixelSize;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int desiredWidth = (int) Layout.getDesiredWidth(str, 0, str.length(), c4097a.f19098i.getPaint());
        Resources resources = this.f19085b.getResources();
        if (resources == null) {
            return;
        }
        int i10 = this.f19089f;
        if (i10 == 0) {
            iM70844o = C11842p.m70758Q(this.f19085b) - (resources.getDimensionPixelSize(R$dimen.cloud_space_24_dp) * 2);
            dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_10_dp);
        } else {
            iM70844o = (int) C11842p.m70844o(this.f19085b, i10);
            dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_56_dp);
        }
        int dimensionPixelSize2 = ((((iM70844o - resources.getDimensionPixelSize(R$dimen.cloud_space_16_dp)) - resources.getDimensionPixelSize(R$dimen.cloud_space_4_dp)) - resources.getDimensionPixelSize(R$dimen.cloud_space_56_dp)) - resources.getDimensionPixelSize(R$dimen.cloud_space_10_dp)) - dimensionPixelSize;
        int ruleStatus = getItem(((Integer) c4097a.f19099j.getTag()).intValue()).getRuleStatus();
        if (desiredWidth <= dimensionPixelSize2) {
            c4097a.f19098i.setMaxLines(1);
            c4097a.f19098i.setMaxWidth(dimensionPixelSize2);
            c4097a.f19099j.setImageResource(R$drawable.ic_16_arrow_down);
            c4097a.f19099j.setVisibility(8);
            return;
        }
        if (ruleStatus == 0) {
            c4097a.f19098i.setMaxLines(1);
            c4097a.f19099j.setImageResource(R$drawable.ic_16_arrow_down);
        } else {
            c4097a.f19098i.setMaxLines(10);
            c4097a.f19099j.setImageResource(R$drawable.ic_16_arrow_up);
        }
        c4097a.f19098i.setMaxWidth(dimensionPixelSize2);
        c4097a.f19099j.setVisibility(0);
    }

    /* renamed from: u */
    public void m25449u(C4097a c4097a, Voucher voucher) {
        RelativeLayout relativeLayout;
        String welfareName = voucher.getWelfareName();
        c4097a.f19094e.setVisibility(8);
        c4097a.f19095f.setVisibility(8);
        c4097a.f19093d.setText(welfareName);
        c4097a.f19093d.setTextSize(16.0f);
        Resources resources = this.f19085b.getResources();
        if (resources != null && (relativeLayout = c4097a.f19092c) != null) {
            m25442m(voucher, resources, relativeLayout.getLayoutParams());
        }
        c4097a.f19096g.setVisibility(4);
        c4097a.f19097h.setText(m25440k(voucher.getEffectiveTime(), voucher.getExpireTime()));
    }

    /* renamed from: v */
    public void m25450v(View.OnClickListener onClickListener) {
        this.f19087d = onClickListener;
    }

    /* renamed from: w */
    public boolean mo25314w(Voucher voucher) {
        int i10 = this.f19088e;
        return (i10 == 1 || i10 == 2 || voucher.getOrderStatus() == 1) ? false : true;
    }
}
