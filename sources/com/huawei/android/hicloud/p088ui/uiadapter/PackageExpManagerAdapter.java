package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
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
import com.huawei.cloud.pay.model.reward.Reward;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import p054cj.C1442a;
import p454lj.C11290m;
import p454lj.C11296s;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PackageExpManagerAdapter extends BaseAdapter {

    /* renamed from: a */
    public int f18765a;

    /* renamed from: b */
    public View.OnClickListener f18766b;

    /* renamed from: c */
    public final Context f18767c;

    /* renamed from: d */
    public final Resources f18768d;

    /* renamed from: e */
    public final LayoutInflater f18769e;

    /* renamed from: f */
    public int f18770f;

    /* renamed from: g */
    public List<Reward> f18771g = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.PackageExpManagerAdapter$a */
    public static class C4055a {

        /* renamed from: a */
        public RelativeLayout f18772a;

        /* renamed from: b */
        public RelativeLayout f18773b;

        /* renamed from: c */
        public RelativeLayout f18774c;

        /* renamed from: d */
        public TextView f18775d = null;

        /* renamed from: e */
        public TextView f18776e = null;

        /* renamed from: f */
        public TextView f18777f = null;

        /* renamed from: g */
        public HwButton f18778g = null;

        /* renamed from: h */
        public ImageView f18779h = null;

        /* renamed from: i */
        public ImageView f18780i = null;
    }

    public PackageExpManagerAdapter(Context context) {
        this.f18767c = context;
        this.f18769e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18768d = context.getResources();
        this.f18765a = C11842p.m70829k0(context);
    }

    /* renamed from: a */
    public void m25058a(List<Reward> list) {
        List<Reward> list2 = this.f18771g;
        if (list2 == null) {
            return;
        }
        list2.addAll(list);
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Reward getItem(int i10) {
        return this.f18771g.get(i10);
    }

    /* renamed from: c */
    public final int m25060c() throws Resources.NotFoundException {
        int iM70844o;
        int dimensionPixelSize;
        if (this.f18767c == null) {
            C1442a.m8289e("PackageExpManagerAdapter", "getTicketMaxWidth mContext is null");
            return 0;
        }
        Resources resources = this.f18768d;
        if (resources == null) {
            C1442a.m8289e("PackageExpManagerAdapter", "getTicketMaxWidth Resources is null");
            return 0;
        }
        if (resources.getConfiguration().orientation == 1) {
            iM70844o = (((C11842p.m70758Q(this.f18767c) - (this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_24_dp) * 2)) - this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_10_dp)) * 2) / 3;
            dimensionPixelSize = this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_16_dp);
        } else {
            Context context = this.f18767c;
            iM70844o = (((int) C11842p.m70844o(context, C11842p.m70829k0(context))) * 2) / 3;
            dimensionPixelSize = this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_16_dp);
        }
        return iM70844o - dimensionPixelSize;
    }

    /* renamed from: d */
    public final String m25061d(long j10, long j11) {
        TimeZone timeZoneM67755p = C11290m.m67755p(this.f18767c);
        return C11290m.m67745f(this.f18767c, j10, timeZoneM67755p) + "-" + C11290m.m67745f(this.f18767c, j11, timeZoneM67755p);
    }

    /* renamed from: e */
    public final void m25062e(Resources resources, ViewGroup.LayoutParams layoutParams) {
        if (m25069l()) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(resources.getDimensionPixelSize(R$dimen.cloud_space_108_dp));
            }
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(resources.getDimensionPixelSize(R$dimen.cloud_space_8_dp));
        }
    }

    /* renamed from: f */
    public void m25063f(int i10) {
        this.f18765a = i10;
    }

    /* renamed from: g */
    public void m25064g(View.OnClickListener onClickListener) {
        this.f18766b = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18771g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        C4055a c4055a;
        C1442a.m8290i("PackageExpManagerAdapter", "getView:" + i10);
        if (view == null) {
            C4055a c4055a2 = new C4055a();
            View viewM76832e = C12809f.m76832e(this.f18769e, R$layout.package_exp_list_item);
            c4055a2.f18772a = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.package_exp_item_content);
            c4055a2.f18775d = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_package_exp_item_label);
            c4055a2.f18773b = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.package_exp_item_detail);
            c4055a2.f18776e = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_package_exp_item_eff_period);
            c4055a2.f18777f = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_package_exp_item_rule);
            c4055a2.f18774c = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.package_exp_item_rule);
            c4055a2.f18778g = (HwButton) C12809f.m76831d(viewM76832e, R$id.bt_use);
            ImageView imageView = (ImageView) C12809f.m76831d(viewM76832e, R$id.ic_package_exp_rule_expand);
            c4055a2.f18780i = imageView;
            imageView.setOnClickListener(this.f18766b);
            c4055a2.f18780i.setTag(Integer.valueOf(i10));
            c4055a2.f18779h = (ImageView) C12809f.m76831d(viewM76832e, R$id.imag_package_exp_cloud);
            c4055a2.f18778g.setOnClickListener(this.f18766b);
            viewM76832e.setTag(c4055a2);
            viewM76832e.setOnClickListener(this.f18766b);
            c4055a = c4055a2;
            view = viewM76832e;
        } else {
            c4055a = (C4055a) view.getTag();
        }
        view.setAccessibilityDelegate(C2783d.m16078D0());
        if (this.f18765a != 0) {
            c4055a.f18772a.getLayoutParams().width = (int) C11842p.m70844o(this.f18767c, this.f18765a);
        }
        Reward item = getItem(i10);
        if (item != null) {
            m25065h(c4055a, item);
            c4055a.f18778g.setTag(Integer.valueOf(i10));
            int i11 = this.f18770f;
            if (i11 == 1 || i11 == 2) {
                m25068k(c4055a);
                m25066i(c4055a);
                return view;
            }
        }
        C11296s.m67781E(this.f18767c, c4055a.f18772a);
        return view;
    }

    /* renamed from: h */
    public final void m25065h(C4055a c4055a, Reward reward) {
        if (this.f18767c == null || this.f18768d == null || reward == null) {
            return;
        }
        c4055a.f18775d.setText(reward.getAwardName());
        c4055a.f18775d.setTextColor(this.f18768d.getColor(R$color.voucher_balance_value_color));
        c4055a.f18775d.setMaxWidth(m25060c());
        c4055a.f18775d.setVisibility(0);
        RelativeLayout relativeLayout = c4055a.f18773b;
        if (relativeLayout != null) {
            m25062e(this.f18768d, relativeLayout.getLayoutParams());
        }
        c4055a.f18776e.setText(m25061d(reward.getCreatedTime(), reward.getExpirationTime()));
        c4055a.f18777f.setText(R$string.package_exp_use_rule);
        C11842p.m70712A2(c4055a.f18774c, reward.isSupportSub());
    }

    /* renamed from: i */
    public final void m25066i(C4055a c4055a) throws Resources.NotFoundException {
        int iM70844o;
        int dimensionPixelSize;
        if (this.f18768d == null) {
            return;
        }
        String string = this.f18770f == 1 ? this.f18767c.getString(R$string.voucher_used) : null;
        if (this.f18770f == 2) {
            string = this.f18767c.getString(R$string.card_expired);
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        int desiredWidth = (int) Layout.getDesiredWidth(string, 0, string.length(), c4055a.f18777f.getPaint());
        int i10 = this.f18765a;
        if (i10 == 0) {
            iM70844o = C11842p.m70758Q(this.f18767c) - (this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_24_dp) * 2);
            dimensionPixelSize = this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_10_dp);
        } else {
            iM70844o = (int) C11842p.m70844o(this.f18767c, i10);
            dimensionPixelSize = this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_56_dp);
        }
        int dimensionPixelSize2 = ((((iM70844o - this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_16_dp)) - this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_4_dp)) - this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_56_dp)) - this.f18768d.getDimensionPixelSize(R$dimen.cloud_space_10_dp)) - dimensionPixelSize;
        int expandState = getItem(((Integer) c4055a.f18780i.getTag()).intValue()).getExpandState();
        if (desiredWidth <= dimensionPixelSize2) {
            c4055a.f18777f.setMaxLines(1);
            c4055a.f18777f.setMaxWidth(dimensionPixelSize2);
            c4055a.f18780i.setImageResource(R$drawable.ic_16_arrow_down);
            c4055a.f18780i.setVisibility(8);
            return;
        }
        if (expandState == 0) {
            c4055a.f18777f.setMaxLines(1);
            c4055a.f18780i.setImageResource(R$drawable.ic_16_arrow_down);
        } else {
            c4055a.f18777f.setMaxLines(10);
            c4055a.f18780i.setImageResource(R$drawable.ic_16_arrow_up);
        }
        c4055a.f18777f.setMaxWidth(dimensionPixelSize2);
        c4055a.f18780i.setVisibility(0);
    }

    /* renamed from: j */
    public void m25067j(int i10) {
        this.f18770f = i10;
    }

    /* renamed from: k */
    public final void m25068k(C4055a c4055a) {
        int color = this.f18767c.getColor(R$color.voucher_unuseable_currency_color);
        int color2 = this.f18767c.getColor(R$color.voucher_unuseable_banlance_color);
        TextView textView = c4055a.f18775d;
        if (textView != null) {
            textView.setTextColor(color2);
        }
        c4055a.f18776e.setTextColor(color);
        if (this.f18770f == 1) {
            c4055a.f18777f.setText(R$string.voucher_used);
        }
        if (this.f18770f == 2) {
            c4055a.f18777f.setText(R$string.card_expired);
        }
        c4055a.f18777f.setTextColor(color);
        c4055a.f18772a.setBackgroundResource(R$drawable.voucher_item_bg_expired);
        c4055a.f18779h.setImageResource(R$drawable.voucher_item_cloud_gray);
        c4055a.f18778g.setVisibility(8);
        C11296s.m67781E(this.f18767c, c4055a.f18772a);
    }

    /* renamed from: l */
    public final boolean m25069l() {
        return this.f18770f == 0;
    }
}
