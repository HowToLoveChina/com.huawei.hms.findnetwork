package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$plurals;
import com.huawei.hicloud.sync.R$string;
import java.util.ArrayList;
import java.util.Locale;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class GradientActionBar extends RelativeLayout {

    /* renamed from: A */
    public boolean f17867A;

    /* renamed from: B */
    public View f17868B;

    /* renamed from: a */
    public Context f17869a;

    /* renamed from: b */
    public NotchFitRelativeLayout f17870b;

    /* renamed from: c */
    public RelativeLayout f17871c;

    /* renamed from: d */
    public RelativeLayout f17872d;

    /* renamed from: e */
    public RelativeLayout f17873e;

    /* renamed from: f */
    public RelativeLayout f17874f;

    /* renamed from: g */
    public ImageView f17875g;

    /* renamed from: h */
    public ImageView f17876h;

    /* renamed from: i */
    public ImageView f17877i;

    /* renamed from: j */
    public ImageView f17878j;

    /* renamed from: k */
    public TextView f17879k;

    /* renamed from: l */
    public RelativeLayout f17880l;

    /* renamed from: m */
    public RelativeLayout f17881m;

    /* renamed from: n */
    public RelativeLayout f17882n;

    /* renamed from: o */
    public TextView f17883o;

    /* renamed from: p */
    public TextView f17884p;

    /* renamed from: q */
    public AbstractC3943a f17885q;

    /* renamed from: r */
    public RelativeLayout f17886r;

    /* renamed from: s */
    public NotchFitRelativeLayout f17887s;

    /* renamed from: t */
    public RelativeLayout f17888t;

    /* renamed from: u */
    public RelativeLayout f17889u;

    /* renamed from: v */
    public TextView f17890v;

    /* renamed from: w */
    public TextView f17891w;

    /* renamed from: x */
    public RelativeLayout f17892x;

    /* renamed from: y */
    public ImageView f17893y;

    /* renamed from: z */
    public boolean f17894z;

    /* renamed from: com.huawei.android.hicloud.ui.extend.GradientActionBar$a */
    public class ViewOnClickListenerC3935a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f17895a;

        /* renamed from: b */
        public final /* synthetic */ VipRightsListener f17896b;

        public ViewOnClickListenerC3935a(boolean z10, VipRightsListener vipRightsListener) {
            this.f17895a = z10;
            this.f17896b = vipRightsListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f17895a) {
                this.f17896b.mo21547a();
            }
        }
    }

    public GradientActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17894z = true;
        this.f17867A = false;
        this.f17869a = context;
        m23943e(context);
    }

    /* renamed from: a */
    public void m23939a() {
        RelativeLayout relativeLayout = this.f17880l;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* renamed from: b */
    public final boolean m23940b() {
        return this.f17872d == null || this.f17873e == null || this.f17874f == null || this.f17869a == null || this.f17888t == null || this.f17889u == null;
    }

    /* renamed from: c */
    public final void m23941c() {
        if (m23940b()) {
            return;
        }
        int iM70852q = C11842p.m70852q(this.f17869a);
        int iM70789a0 = C11842p.m70789a0(this.f17869a);
        if (!C11842p.m70753O0(this.f17869a) || C11842p.m70771U0()) {
            C11842p.m70727F1(this.f17872d, iM70789a0);
            C11842p.m70727F1(this.f17888t, iM70789a0);
            C11842p.m70727F1(this.f17873e, iM70852q);
            C11842p.m70727F1(this.f17889u, iM70852q);
            C11842p.m70727F1(this.f17874f, iM70852q + iM70789a0);
            return;
        }
        C11842p.m70727F1(this.f17872d, 0);
        C11842p.m70727F1(this.f17888t, 0);
        C11842p.m70727F1(this.f17873e, iM70852q);
        C11842p.m70727F1(this.f17889u, iM70852q);
        C11842p.m70727F1(this.f17874f, iM70852q);
    }

    /* renamed from: d */
    public final void m23942d() {
        this.f17886r = (RelativeLayout) C12809f.m76831d(this, R$id.tool_actionbar_main_layout);
        this.f17887s = (NotchFitRelativeLayout) C12809f.m76831d(this, R$id.tool_notch_main_layout);
        this.f17888t = (RelativeLayout) C12809f.m76831d(this, R$id.tool_status_bar_region);
        this.f17889u = (RelativeLayout) C12809f.m76831d(this, R$id.tool_action_bar_region);
        this.f17890v = (TextView) C12809f.m76831d(this, R$id.tool_action_bar_title);
    }

    /* renamed from: e */
    public void m23943e(Context context) {
        View.inflate(context, R$layout.gradient_action_bar_layout, this);
        this.f17870b = (NotchFitRelativeLayout) C12809f.m76831d(this, R$id.notch_main_layout);
        m23942d();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17870b);
        arrayList.add(this.f17887s);
        C12806c.m76817h(this.f17869a, arrayList);
        this.f17871c = (RelativeLayout) C12809f.m76831d(this, R$id.actionbar_main_layout);
        this.f17872d = (RelativeLayout) C12809f.m76831d(this, R$id.status_bar_region);
        this.f17873e = (RelativeLayout) C12809f.m76831d(this, R$id.action_bar_region);
        this.f17874f = (RelativeLayout) C12809f.m76831d(this, R$id.actionbar_background_view);
        this.f17875g = (ImageView) C12809f.m76831d(this, R$id.ic_back_image);
        this.f17876h = (ImageView) C12809f.m76831d(this, R$id.ic_more_image);
        this.f17877i = (ImageView) C12809f.m76831d(this, R$id.ic_more_image_red_dot);
        this.f17878j = (ImageView) C12809f.m76831d(this, R$id.ic_sns_info_image);
        this.f17879k = (TextView) C12809f.m76831d(this, R$id.action_bar_title);
        this.f17880l = (RelativeLayout) C12809f.m76831d(this, R$id.ic_back_hot_space);
        this.f17881m = (RelativeLayout) C12809f.m76831d(this, R$id.ic_more_hot_space);
        this.f17882n = (RelativeLayout) C12809f.m76831d(this, R$id.ic_sns_info_hot_space);
        this.f17883o = (TextView) C12809f.m76831d(this, R$id.sns_info_single_num);
        this.f17884p = (TextView) C12809f.m76831d(this, R$id.sns_info_double_num);
        this.f17892x = (RelativeLayout) C12809f.m76831d(this, R$id.rlay_vip_grade);
        this.f17891w = (TextView) C12809f.m76831d(this, R$id.tv_vip_grade);
        this.f17893y = (ImageView) C12809f.m76831d(this, R$id.iv_avator_vip_bg);
        this.f17868B = C12809f.m76831d(this, R$id.tv_inactive);
        m23941c();
        this.f17885q = C3944b.m24060a(context);
        m23952n();
        this.f17880l.setAccessibilityDelegate(C11842p.m70804e());
        this.f17881m.setAccessibilityDelegate(C11842p.m70804e());
        this.f17882n.setAccessibilityDelegate(C11842p.m70804e());
    }

    /* renamed from: f */
    public boolean m23944f() {
        RelativeLayout relativeLayout = this.f17880l;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    /* renamed from: g */
    public boolean m23945g() {
        RelativeLayout relativeLayout = this.f17881m;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public RelativeLayout getMoreHotSpace() {
        return this.f17881m;
    }

    /* renamed from: h */
    public boolean m23946h() {
        RelativeLayout relativeLayout = this.f17882n;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    /* renamed from: i */
    public void m23947i() {
        m23941c();
    }

    /* renamed from: j */
    public void m23948j(int i10) {
        if (this.f17894z) {
            setActionBarTheme(i10);
            return;
        }
        m23951m();
        RelativeLayout relativeLayout = this.f17871c;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(1.0f);
        }
    }

    /* renamed from: k */
    public void m23949k(int i10) {
        if (i10 == 0) {
            TextView textView = this.f17883o;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.f17884p;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        if (i10 > 0 && i10 < 10) {
            TextView textView3 = this.f17883o;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.f17883o.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i10)));
            }
            TextView textView4 = this.f17884p;
            if (textView4 != null) {
                textView4.setVisibility(8);
                return;
            }
            return;
        }
        if (i10 >= 10) {
            TextView textView5 = this.f17883o;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.f17884p;
            if (textView6 != null) {
                textView6.setVisibility(0);
                this.f17884p.setText(i10 <= 99 ? String.format(Locale.getDefault(), "%d", Integer.valueOf(i10)) : "99+");
            }
        }
    }

    /* renamed from: l */
    public void m23950l(int i10, boolean z10) {
        m23948j(i10);
        this.f17894z = z10;
    }

    /* renamed from: m */
    public final void m23951m() {
        AbstractC3943a abstractC3943a = this.f17885q;
        if (abstractC3943a == null) {
            return;
        }
        this.f17874f.setBackgroundColor(abstractC3943a.m24052c());
        this.f17875g.setImageDrawable(this.f17885q.m24050a());
        this.f17879k.setTextColor(this.f17885q.m24058i());
        this.f17876h.setImageDrawable(this.f17885q.m24054e());
        this.f17878j.setImageDrawable(this.f17885q.m24056g());
    }

    /* renamed from: n */
    public final void m23952n() {
        AbstractC3943a abstractC3943a = this.f17885q;
        if (abstractC3943a == null) {
            return;
        }
        this.f17874f.setBackgroundColor(abstractC3943a.m24053d());
        this.f17875g.setImageDrawable(this.f17885q.m24051b());
        this.f17879k.setTextColor(this.f17885q.m24059j());
        this.f17876h.setImageDrawable(this.f17885q.m24055f());
        this.f17878j.setImageDrawable(this.f17885q.m24057h());
    }

    /* renamed from: o */
    public void m23953o() {
        int iM70758Q;
        int iM76823b;
        Context context = this.f17869a;
        if (context == null) {
            return;
        }
        if (C0209d.m1297q1(context)) {
            iM70758Q = C11842p.m70752O(this.f17869a);
            iM76823b = C11842p.m70789a0(this.f17869a);
        } else {
            iM70758Q = C11842p.m70758Q(this.f17869a);
            iM76823b = C12808e.m76823b() * 2;
        }
        int iM70844o = (((iM70758Q - iM76823b) - (((int) C11842p.m70844o(this.f17869a, 12)) * 2)) - ((int) C11842p.m70844o(this.f17869a, 38))) - (((int) C11842p.m70844o(this.f17869a, 12)) * 2);
        if (m23945g()) {
            iM70844o -= (int) C11842p.m70844o(this.f17869a, 48);
        }
        if (m23946h()) {
            iM70844o -= (int) C11842p.m70844o(this.f17869a, 46);
        }
        if (m23944f()) {
            iM70844o = (iM70844o - ((int) C11842p.m70844o(this.f17869a, 32))) - ((int) C11842p.m70844o(this.f17869a, 12));
        }
        setTitleMaxWidth(iM70844o);
    }

    /* renamed from: p */
    public void m23954p(int i10, int i11) {
        TextView textView = this.f17891w;
        if (textView != null) {
            textView.setText(i10);
            this.f17891w.setTextSize(1, C11829c.m70590k0() ? 8.0f : 6.0f);
            this.f17891w.setTextColor(getResources().getColor(i11));
        }
    }

    /* renamed from: q */
    public final void m23955q(String str, float f10, boolean z10) {
        if (z10) {
            setAvatorVipBgShowStatus(8);
        } else {
            setAvatorVipBgShowStatus(0);
        }
        setVipIconLayoutShowStatus(0);
        setVipIconAlphaRatio(f10);
        m23953o();
    }

    /* renamed from: r */
    public void m23956r(boolean z10, VipRightsListener vipRightsListener) {
        RelativeLayout relativeLayout = this.f17892x;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new ViewOnClickListenerC3935a(z10, vipRightsListener));
        }
    }

    /* renamed from: s */
    public void m23957s() {
        RelativeLayout relativeLayout = this.f17880l;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    public void setActionBarAlpha(int i10) {
        float f10 = 1.0f;
        if (i10 >= 1 && i10 < 50) {
            f10 = (i10 - 1.0f) / 49.0f;
        }
        RelativeLayout relativeLayout = this.f17871c;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(f10);
        }
    }

    public void setActionBarTheme(int i10) {
        if (i10 > 1 && !this.f17867A) {
            this.f17867A = true;
            m23951m();
        } else {
            if (i10 > 1 || !this.f17867A) {
                return;
            }
            this.f17867A = false;
            m23952n();
        }
    }

    public void setActionBarTitle(String str) {
        if (this.f17879k == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f17879k.setText(str);
    }

    public void setAvatorVipBgShowStatus(int i10) {
        ImageView imageView = this.f17893y;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
    }

    public void setInactiveTVVisible(boolean z10) {
        View view = this.f17868B;
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void setMainLayoutVisibility(int i10) {
        RelativeLayout relativeLayout = this.f17871c;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(i10);
    }

    public void setMoreIconRedDot(int i10) {
        ImageView imageView = this.f17877i;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
    }

    public void setMoreIconVisibility(boolean z10) {
        RelativeLayout relativeLayout = this.f17881m;
        if (relativeLayout == null) {
            C11839m.m70687e("GradientActionBar", "setMoreIconVisibility error, mMoreHotSpace is null");
        } else if (z10) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(4);
        }
    }

    public void setOnInActiveTVClick(View.OnClickListener onClickListener) {
        View view = this.f17868B;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout = this.f17880l;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
        RelativeLayout relativeLayout2 = this.f17881m;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(onClickListener);
        }
        RelativeLayout relativeLayout3 = this.f17882n;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(onClickListener);
        }
    }

    public void setScrollChangeEnable(boolean z10) {
        this.f17894z = z10;
    }

    public void setSnSInfoViewVisible(boolean z10) {
        RelativeLayout relativeLayout = this.f17882n;
        if (relativeLayout == null) {
            return;
        }
        if (z10) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
    }

    public void setText(String str) {
        TextView textView = this.f17879k;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTitleMaxWidth(int i10) {
        TextView textView;
        if (i10 > 0 && (textView = this.f17879k) != null) {
            textView.setMaxWidth(i10);
        }
    }

    public void setToolActionMainVisibility(int i10) {
        RelativeLayout relativeLayout = this.f17886r;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(i10);
        TextView textView = this.f17890v;
        if (textView == null) {
            return;
        }
        textView.setText(R$string.tool_tab);
    }

    public void setToolStatusBarRegion(int i10) {
        RelativeLayout relativeLayout = this.f17888t;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i10);
        }
    }

    public void setVipIconAlphaRatio(float f10) {
        RelativeLayout relativeLayout = this.f17892x;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(f10);
        }
    }

    public void setVipIconLayoutShowStatus(int i10) {
        RelativeLayout relativeLayout = this.f17892x;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i10);
        }
    }

    public void setVipIconResource(int i10) {
        RelativeLayout relativeLayout = this.f17892x;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(i10);
        }
    }

    /* renamed from: t */
    public void m23958t(int i10) {
        C11839m.m70686d("GradientActionBar", "showVipRightsInEffect vipRightsNo " + i10);
        RelativeLayout relativeLayout = this.f17892x;
        if (relativeLayout != null) {
            boolean z10 = relativeLayout.getVisibility() == 0;
            C11839m.m70686d("GradientActionBar", "showVipRightsInEffect isVipRightsShow " + z10);
            String quantityString = getResources().getQuantityString(R$plurals.effective_vip_rights, i10, Integer.valueOf(i10));
            if (z10) {
                m23955q(quantityString, 1.0f, false);
            }
        }
    }
}
