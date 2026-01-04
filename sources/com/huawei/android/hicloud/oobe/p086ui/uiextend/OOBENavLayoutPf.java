package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import p015ak.C0219i;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBENavLayoutPf extends OOBENavLayout {

    /* renamed from: r */
    public static final String f12681r = "OOBENavLayoutPf";

    /* renamed from: n */
    public ProgressBar f12682n;

    /* renamed from: o */
    public EnumC2866b f12683o;

    /* renamed from: p */
    public OOBENavButton f12684p;

    /* renamed from: q */
    public Drawable[] f12685q;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.OOBENavLayoutPf$a */
    public static /* synthetic */ class C2865a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f12686a;

        static {
            int[] iArr = new int[EnumC2866b.values().length];
            f12686a = iArr;
            try {
                iArr[EnumC2866b.SKIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12686a[EnumC2866b.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12686a[EnumC2866b.NEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.OOBENavLayoutPf$b */
    public enum EnumC2866b {
        NEXT,
        LOADING,
        SKIP
    }

    public OOBENavLayoutPf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout
    /* renamed from: e */
    public void mo17043e(TypedArray typedArray) {
        super.mo17043e(typedArray);
        OOBENavButton oOBENavButton = (OOBENavButton) C12809f.m76831d(this, R$id.oobe_nav_next);
        this.f12684p = oOBENavButton;
        if (oOBENavButton != null) {
            this.f12685q = oOBENavButton.getCompoundDrawables();
        }
        setNextButtonState(EnumC2866b.NEXT);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout
    /* renamed from: g */
    public void mo17045g(Context context) {
        super.mo17045g(context);
        if (C0219i.m1463a() >= 17) {
            View.inflate(getContext(), R$layout.pf_view_nav_progress90, this);
        } else {
            View.inflate(getContext(), R$layout.pf_view_nav_progress80, this);
        }
        setMarginHorizontal(C11842p.m70840n(getContext(), 16));
        this.f12682n = (ProgressBar) C12809f.m76831d(this, R$id.oobe_nav_next_progress);
    }

    public EnumC2866b getmNextButtonState() {
        return this.f12683o;
    }

    /* renamed from: l */
    public void m17050l() {
        this.f12682n.setVisibility(8);
        m17049k();
    }

    /* renamed from: m */
    public void m17051m() {
        this.f12682n.setVisibility(0);
        m17042d();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.62f);
        }
        C12809f.m76831d(this, R$id.oobe_nav_back_layout).setEnabled(z10);
        C12809f.m76831d(this, R$id.oobe_nav_next_layout).setEnabled(z10);
    }

    public void setNextButtonState(EnumC2866b enumC2866b) {
        C11839m.m70686d(f12681r, "setNextButtonState--state=" + enumC2866b);
        this.f12683o = enumC2866b;
        int i10 = C2865a.f12686a[enumC2866b.ordinal()];
        if (i10 == 1) {
            m17050l();
            setNextBtnText(getResources().getString(R$string.oobe_skip));
            setNextDrawableVisible(false);
            setEnabled(true);
            return;
        }
        if (i10 == 2) {
            m17051m();
            setAlpha(0.62f);
            setEnabled(false);
        } else {
            m17050l();
            setNextBtnText(getResources().getString(R$string.next_step));
            setNextDrawableVisible(true);
            setEnabled(true);
        }
    }

    public void setNextDrawableVisible(boolean z10) {
        OOBENavButton oOBENavButton = this.f12684p;
        if (oOBENavButton == null) {
            return;
        }
        if (!z10) {
            oOBENavButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else if (C0219i.m1463a() >= 17) {
            this.f12684p.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R$drawable.arrow_right_oobe_eumi9, 0);
        } else {
            this.f12684p.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R$drawable.arrow_right_selector, 0);
        }
    }
}
