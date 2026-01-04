package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.Tickets;
import com.huawei.cloud.pay.model.Voucher;
import java.util.ArrayList;
import java.util.List;
import p054cj.C1442a;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class TicketsManagerAdapter extends VouchersManagerAdapter {
    public TicketsManagerAdapter(Context context) {
        super(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter
    /* renamed from: a */
    public void mo25309a(List<? extends Voucher> list) {
        List<Voucher> list2 = this.f19086c;
        if (list2 == null) {
            return;
        }
        int i10 = this.f19088e;
        if (i10 == 1 || i10 == 2) {
            list2.addAll(list);
            return;
        }
        list2.addAll(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Voucher voucher : this.f19086c) {
            if (voucher instanceof Tickets) {
                String exchangeCode = ((Tickets) voucher).getExchangeCode();
                voucher.setVoucherSubTitle(exchangeCode);
                voucher.setUbusableDesc(exchangeCode);
                voucher.setOrderStatus(voucher.getStatus());
                if (voucher.getStatus() == 0) {
                    arrayList.add(voucher);
                } else {
                    arrayList2.add(voucher);
                }
            } else if (voucher.getOrderStatus() == 0) {
                arrayList.add(voucher);
            } else {
                arrayList2.add(voucher);
            }
        }
        this.f19086c.clear();
        this.f19086c.addAll(arrayList);
        this.f19086c.addAll(arrayList2);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter
    /* renamed from: c */
    public void mo25310c(VouchersManagerAdapter.C4097a c4097a, Voucher voucher) {
        if (voucher instanceof Tickets) {
            c4097a.f19101l.setVisibility(8);
        } else {
            super.mo25310c(c4097a, voucher);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter
    /* renamed from: i */
    public String mo25311i(Voucher voucher) {
        Context context = this.f19085b;
        return context == null ? "" : context.getString(R$string.card_expired);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter
    /* renamed from: j */
    public String mo25312j(Voucher voucher) {
        Context context = this.f19085b;
        return context == null ? "" : context.getString(R$string.cloudpay_card_code, voucher.getUbusableDesc());
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter
    /* renamed from: r */
    public void mo25313r(VouchersManagerAdapter.C4097a c4097a, Voucher voucher) {
        RelativeLayout relativeLayout;
        Context context = this.f19085b;
        if (context == null) {
            return;
        }
        c4097a.f19095f.setText(context.getString(R$string.cloudpay_card_text));
        c4097a.f19095f.setTextColor(this.f19085b.getResources().getColor(R$color.voucher_balance_value_color));
        c4097a.f19095f.setVisibility(0);
        c4097a.f19101l.setText(this.f19085b.getString(R$string.cloudpay_copy_card));
        c4097a.f19101l.setVisibility(8);
        if (voucher instanceof Tickets) {
            c4097a.f19093d.setText(m25315x(((Tickets) voucher).getName(), voucher.getStatus() == 0));
            c4097a.f19094e.setVisibility(8);
            c4097a.f19093d.setMaxWidth(m25316y(voucher));
        }
        Resources resources = this.f19085b.getResources();
        if (resources != null && (relativeLayout = c4097a.f19092c) != null) {
            m25442m(voucher, resources, relativeLayout.getLayoutParams());
        }
        c4097a.f19096g.setText(voucher.getVoucherTitle());
        c4097a.f19097h.setText(m25440k(voucher.getEffectiveTime(), voucher.getExpireTime()));
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter
    /* renamed from: w */
    public boolean mo25314w(Voucher voucher) {
        return true;
    }

    /* renamed from: x */
    public SpannableString m25315x(String str, boolean z10) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new TextAppearanceSpan("HwChinese-semibold", 0, 0, null, null), 0, str.length(), 0);
        spannableString.setSpan(new AbsoluteSizeSpan(16, true), 0, str.length(), 33);
        if (this.f19085b == null) {
            return spannableString;
        }
        spannableString.setSpan(z10 ? new ForegroundColorSpan(this.f19085b.getResources().getColor(R$color.voucher_balance_value_color)) : new ForegroundColorSpan(this.f19085b.getResources().getColor(R$color.voucher_unuseable_currency_color)), 0, str.length(), 33);
        return spannableString;
    }

    /* renamed from: y */
    public int m25316y(Voucher voucher) throws Resources.NotFoundException {
        int iM70844o;
        int dimensionPixelSize;
        Context context = this.f19085b;
        if (context == null) {
            C1442a.m8289e("TicketsManagerAdapter", "getTicketMaxWidth mContext is null");
            return 0;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C1442a.m8289e("TicketsManagerAdapter", "getTicketMaxWidth Resources is null");
            return 0;
        }
        if (resources.getConfiguration().orientation == 1) {
            iM70844o = (((C11842p.m70758Q(this.f19085b) - (resources.getDimensionPixelSize(R$dimen.cloud_space_24_dp) * 2)) - resources.getDimensionPixelSize(R$dimen.cloud_space_10_dp)) * 2) / 3;
            dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_16_dp);
        } else {
            iM70844o = (((int) C11842p.m70844o(this.f19085b, C11842p.m70829k0(this.f19085b))) * 2) / 3;
            dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_16_dp);
        }
        return iM70844o - dimensionPixelSize;
    }
}
