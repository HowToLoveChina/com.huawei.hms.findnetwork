package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: com.huawei.openalliance.ad.tr */
/* loaded from: classes8.dex */
public abstract class AbstractC7696tr extends RelativeLayout {

    /* renamed from: a */
    protected int f35717a;

    /* renamed from: b */
    protected int f35718b;

    /* renamed from: c */
    protected RelativeLayout f35719c;

    /* renamed from: d */
    protected int[] f35720d;

    /* renamed from: e */
    protected int[] f35721e;

    /* renamed from: f */
    protected float f35722f;

    /* renamed from: g */
    protected AbstractC8104h f35723g;

    /* renamed from: h */
    protected AbstractC8104h f35724h;

    /* renamed from: i */
    protected AbstractC8104h f35725i;

    /* renamed from: j */
    protected int f35726j;

    /* renamed from: k */
    protected View f35727k;

    /* renamed from: l */
    protected View f35728l;

    /* renamed from: m */
    protected ImageView f35729m;

    /* renamed from: n */
    protected ImageView f35730n;

    /* renamed from: o */
    protected ImageView f35731o;

    /* renamed from: p */
    protected Context f35732p;

    /* renamed from: q */
    protected Boolean f35733q;

    /* renamed from: r */
    protected int f35734r;

    /* renamed from: s */
    private int f35735s;

    /* renamed from: t */
    private boolean f35736t;

    /* renamed from: com.huawei.openalliance.ad.tr$a */
    public static class a implements View.OnClickListener {

        /* renamed from: a */
        private WeakReference<View> f35737a;

        public a(View view) {
            this.f35737a = new WeakReference<>(view);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View view2 = this.f35737a.get();
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public AbstractC7696tr(Context context, int[] iArr, int[] iArr2) {
        super(context);
        this.f35722f = 6.0f;
        this.f35734r = -1;
        this.f35720d = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        this.f35721e = iArr2 != null ? Arrays.copyOf(iArr2, iArr2.length) : null;
        m47290a(context);
    }

    /* renamed from: a */
    private void m47290a(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.f35732p = context.getApplicationContext();
        this.f35736t = AbstractC7811dd.m48309b(AbstractC7811dd.m48320d(this));
        mo47300d();
        m47294l();
        m47293k();
        m47298b();
    }

    /* renamed from: b */
    private RelativeLayout.LayoutParams m47292b(boolean z10) {
        int iMax;
        int i10;
        AbstractC8104h abstractC8104h = this.f35725i;
        if (abstractC8104h == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) abstractC8104h.getLayoutParams();
        boolean zM48587n = C7845x.m48587n(this.f35732p);
        boolean z11 = C7845x.m48590o(this.f35732p) && (1 == (i10 = this.f35735s) || 9 == i10);
        boolean z12 = C7845x.m48595q(this.f35732p) && C7845x.m48599r(this.f35732p);
        if (!z10) {
            if (this.f35736t) {
                iMax = AbstractC7811dd.m48349y(this.f35732p);
            } else {
                int iM47583h = AbstractC7741ao.m47583h(this.f35732p);
                iMax = C6982bz.m41148a(this.f35732p).mo41171a(this.f35732p) ? Math.max(iM47583h, C6982bz.m41148a(this.f35732p).mo41169a(this.f35719c)) : iM47583h;
            }
            layoutParams.setMargins(0, iMax, 0, 0);
        } else if (zM48587n || z11 || z12) {
            layoutParams.setMargins(0, 0, 0, Math.max(AbstractC7741ao.m47535a(this.f35732p, 40.0f), AbstractC7811dd.m48329g(this.f35732p)));
        }
        return layoutParams;
    }

    /* renamed from: k */
    private void m47293k() {
        if (m47302f() && AbstractC7811dd.m48315c()) {
            int[] iArr = this.f35720d;
            int i10 = (this.f35717a - iArr[0]) - this.f35721e[0];
            iArr[0] = i10;
            AbstractC7185ho.m43821b("PPSBaseDialog", "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(i10), Integer.valueOf(this.f35720d[1]));
        }
    }

    /* renamed from: l */
    private void m47294l() {
        mo47289a();
        this.f35719c.setForceDarkAllowed(false);
        RelativeLayout relativeLayout = this.f35719c;
        relativeLayout.setOnClickListener(new a(relativeLayout));
    }

    /* renamed from: m */
    private void m47295m() {
        if (!m47302f()) {
            m47299c();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f35727k.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            int[] iArr = this.f35720d;
            layoutParams2.width = iArr[0];
            layoutParams2.height = this.f35736t ? iArr[1] - this.f35721e[1] : iArr[1];
            this.f35727k.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.f35728l.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            int[] iArr2 = this.f35721e;
            layoutParams4.width = iArr2[0];
            layoutParams4.height = iArr2[1];
            this.f35728l.setLayoutParams(layoutParams4);
        }
    }

    /* renamed from: n */
    private void m47296n() {
        if (!m47302f()) {
            m47299c();
            return;
        }
        boolean zBooleanValue = this.f35720d[1] + (this.f35721e[1] / 2) <= this.f35718b / 2;
        Boolean bool = this.f35733q;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        }
        m47291a(zBooleanValue);
        AbstractC8104h abstractC8104h = this.f35725i;
        if (abstractC8104h != null) {
            abstractC8104h.m50256a(this.f35720d, this.f35721e);
            RelativeLayout.LayoutParams layoutParamsM47292b = m47292b(zBooleanValue);
            if (layoutParamsM47292b != null) {
                this.f35725i.setLayoutParams(layoutParamsM47292b);
            }
        }
    }

    /* renamed from: o */
    private void m47297o() {
        if (!m47302f()) {
            m47299c();
        } else if (m47303g()) {
            C7697ts.m47308a(this.f35732p, this.f35735s, this.f35725i, this.f35731o, this.f35717a, 12);
        } else {
            C7697ts.m47307a(this.f35732p, this.f35735s, this.f35725i, this.f35731o, this.f35717a);
        }
    }

    /* renamed from: a */
    public abstract void mo47289a();

    /* renamed from: c */
    public void m47299c() {
        RelativeLayout relativeLayout = this.f35719c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* renamed from: d */
    public void mo47300d() {
        this.f35717a = AbstractC7807d.m48215b(this.f35732p);
        this.f35718b = AbstractC7807d.m48202a(this.f35732p);
        this.f35735s = AbstractC7811dd.m48335k(this.f35732p);
        this.f35726j = AbstractC7741ao.m47535a(this.f35732p, this.f35722f + 16.0f);
    }

    /* renamed from: e */
    public void mo47301e() {
        if (!m47302f()) {
            m47299c();
            return;
        }
        int iM47535a = AbstractC7741ao.m47535a(this.f35732p, 36.0f);
        int i10 = this.f35726j;
        int i11 = (this.f35717a - i10) - iM47535a;
        int i12 = (this.f35720d[0] + (this.f35721e[0] / 2)) - (iM47535a / 2);
        if (i12 >= i10) {
            i10 = i12;
        }
        if (i10 <= i11) {
            i11 = i10;
        }
        this.f35731o.setX(AbstractC7811dd.m48315c() ? -i11 : i11);
    }

    /* renamed from: f */
    public boolean m47302f() {
        int[] iArr = this.f35720d;
        boolean z10 = iArr != null && iArr.length == 2;
        int[] iArr2 = this.f35721e;
        return z10 && (iArr2 != null && iArr2.length == 2);
    }

    /* renamed from: g */
    public boolean m47303g() {
        return this.f35734r == 1;
    }

    public AbstractC8104h getBottomDialogView() {
        return this.f35724h;
    }

    public abstract int getLayoutId();

    public AbstractC8104h getTopDialogView() {
        return this.f35723g;
    }

    /* renamed from: h */
    public void m47304h() {
        m47298b();
    }

    /* renamed from: i */
    public void m47305i() {
        m47299c();
    }

    /* renamed from: j */
    public boolean m47306j() {
        RelativeLayout relativeLayout = this.f35719c;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m47299c();
    }

    public void setAdContent(ContentRecord contentRecord) {
        this.f35725i.setAdContent(contentRecord);
        m47298b();
    }

    public void setScreenHeight(int i10) {
        if (i10 > 0) {
            this.f35718b = i10;
        }
    }

    public void setScreenWidth(int i10) {
        if (i10 > 0) {
            this.f35717a = i10;
        }
    }

    public AbstractC7696tr(Context context, int[] iArr, int[] iArr2, int i10) {
        super(context);
        this.f35722f = 6.0f;
        this.f35734r = i10;
        this.f35720d = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        this.f35721e = iArr2 != null ? Arrays.copyOf(iArr2, iArr2.length) : null;
        m47290a(context);
    }

    /* renamed from: a */
    private void m47291a(boolean z10) {
        AbstractC7185ho.m43821b("PPSBaseDialog", "config %s", Boolean.valueOf(z10));
        int i10 = z10 ? 8 : 0;
        int i11 = z10 ? 0 : 8;
        this.f35723g.setVisibility(i10);
        this.f35729m.setVisibility(i10);
        this.f35730n.setVisibility(i11);
        this.f35724h.setVisibility(i11);
        this.f35725i = z10 ? this.f35724h : this.f35723g;
        this.f35731o = z10 ? this.f35730n : this.f35729m;
    }

    /* renamed from: b */
    public void m47298b() {
        if (!m47302f()) {
            m47299c();
            return;
        }
        RelativeLayout relativeLayout = this.f35719c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        m47296n();
        m47295m();
        mo47301e();
        m47297o();
    }

    @Override // android.view.View
    public RelativeLayout getRootView() {
        return this.f35719c;
    }

    public AbstractC7696tr(Context context, int[] iArr, int[] iArr2, Boolean bool) {
        super(context);
        this.f35722f = 6.0f;
        this.f35734r = -1;
        if (bool != null) {
            this.f35733q = bool;
        }
        this.f35720d = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        this.f35721e = iArr2 != null ? Arrays.copyOf(iArr2, iArr2.length) : null;
        m47290a(context);
    }
}
