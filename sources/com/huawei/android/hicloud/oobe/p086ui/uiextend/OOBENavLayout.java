package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$styleable;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import p015ak.C0209d;
import p015ak.C0219i;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9832l;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12809f;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class OOBENavLayout extends RelativeLayout implements InterfaceC12805b {

    /* renamed from: m */
    public static C9582a f12668m = new C2864a();

    /* renamed from: a */
    public LinearLayout f12669a;

    /* renamed from: b */
    public LinearLayout f12670b;

    /* renamed from: c */
    public OOBENavButton f12671c;

    /* renamed from: d */
    public OOBENavButton f12672d;

    /* renamed from: e */
    public HwProgressBar f12673e;

    /* renamed from: f */
    public boolean f12674f;

    /* renamed from: g */
    public boolean f12675g;

    /* renamed from: h */
    public String f12676h;

    /* renamed from: i */
    public String f12677i;

    /* renamed from: j */
    public int f12678j;

    /* renamed from: k */
    public int f12679k;

    /* renamed from: l */
    public Context f12680l;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.OOBENavLayout$a */
    public class C2864a extends C9582a {
        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61065U(Button.class.getName());
        }
    }

    public OOBENavLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12680l = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.oobe_nav_attr);
        mo17045g(context);
        try {
            mo17043e(typedArrayObtainStyledAttributes);
        } finally {
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: a */
    public void m17039a() {
        this.f12669a.setVisibility(8);
    }

    /* renamed from: b */
    public void m17040b() {
        HwProgressBar hwProgressBar = this.f12673e;
        if (hwProgressBar != null) {
            hwProgressBar.setVisibility(8);
        }
        m17049k();
    }

    /* renamed from: c */
    public void m17041c() {
        this.f12672d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
    }

    /* renamed from: d */
    public void m17042d() {
        this.f12670b.setVisibility(8);
    }

    /* renamed from: e */
    public void mo17043e(TypedArray typedArray) {
        if (typedArray != null) {
            this.f12675g = typedArray.getBoolean(R$styleable.oobe_nav_attr_oobeNavShowDrawableNext, true);
            this.f12674f = typedArray.getBoolean(R$styleable.oobe_nav_attr_oobeNavShowDrawableBack, true);
            this.f12676h = typedArray.getString(R$styleable.oobe_nav_attr_oobeNavBackText);
            this.f12677i = typedArray.getString(R$styleable.oobe_nav_attr_oobeNavNextText);
            if (!this.f12674f) {
                this.f12671c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (!this.f12675g) {
                this.f12672d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.f12671c.setText(this.f12676h);
            this.f12672d.setText(this.f12677i);
            int i10 = R$styleable.oobe_nav_attr_oobeNavBackColor;
            if (typedArray.hasValue(i10)) {
                int color = typedArray.getColor(i10, Color.parseColor("#FFF000"));
                this.f12678j = color;
                this.f12671c.setTextColor(color);
            }
            int i11 = R$styleable.oobe_nav_attr_oobeNavNextColor;
            if (typedArray.hasValue(i11)) {
                int color2 = typedArray.getColor(i11, Color.parseColor("#FFF000"));
                this.f12679k = color2;
                this.f12672d.setTextColor(color2);
            }
        }
    }

    /* renamed from: f */
    public final void m17044f(View view) {
        C9603h0.m59902p0(view, f12668m);
    }

    /* renamed from: g */
    public void mo17045g(Context context) {
        if (C0219i.m1463a() >= 27) {
            if (C0209d.m1269j1()) {
                View.inflate(context, R$layout.oobe_nav_view_honor, this);
            } else {
                View.inflate(context, R$layout.oobe_nav_view_harmony, this);
            }
            this.f12673e = (HwProgressBar) C12809f.m76831d(this, R$id.oobe_nav_next_progress);
        } else if (C0219i.m1463a() >= 23) {
            View.inflate(context, R$layout.oobe_nav_view_emui, this);
            this.f12673e = (HwProgressBar) C12809f.m76831d(this, R$id.oobe_nav_next_progress);
        } else if (C0219i.m1463a() >= 21) {
            View.inflate(context, R$layout.oobe_nav_view_emui10, this);
            this.f12673e = (HwProgressBar) C12809f.m76831d(this, R$id.oobe_nav_next_progress);
        } else if (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) {
            View.inflate(context, R$layout.oobe_nav_view, this);
        } else {
            View.inflate(context, R$layout.oobe_nav_view_emui90, this);
        }
        this.f12669a = (LinearLayout) C12809f.m76831d(this, R$id.oobe_nav_back_layout);
        this.f12670b = (LinearLayout) C12809f.m76831d(this, R$id.oobe_nav_next_layout);
        this.f12671c = (OOBENavButton) C12809f.m76831d(this, R$id.oobe_nav_back);
        this.f12672d = (OOBENavButton) C12809f.m76831d(this, R$id.oobe_nav_next);
        m17044f(this.f12671c);
        m17044f(this.f12672d);
    }

    /* renamed from: h */
    public void m17046h() {
        this.f12669a.setVisibility(0);
    }

    /* renamed from: i */
    public void m17047i() {
        HwProgressBar hwProgressBar = this.f12673e;
        if (hwProgressBar != null) {
            hwProgressBar.setVisibility(0);
        }
        m17042d();
    }

    /* renamed from: j */
    public void m17048j() {
        if (C0219i.m1463a() < 17) {
            this.f12672d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R$drawable.arrow_right_selector, 0);
        } else {
            this.f12672d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R$drawable.arrow_right_oobe_eumi9, 0);
        }
    }

    /* renamed from: k */
    public void m17049k() {
        this.f12670b.setVisibility(0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        Context context = this.f12680l;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.f12680l), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        Context context = this.f12680l;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }

    public void setBackBtnClickListener(View.OnClickListener onClickListener) {
        this.f12669a.setOnClickListener(onClickListener);
    }

    public void setBackBtnText(String str) {
        this.f12671c.setText(str);
    }

    public void setMarginHorizontal(int i10) {
        if (C0219i.m1463a() >= 17) {
            C11842p.m70823i2(this, i10 - this.f12671c.getPaddingStart());
        } else {
            C11842p.m70823i2(this, i10);
        }
    }

    public void setNextBtnClickListener(View.OnClickListener onClickListener) {
        this.f12670b.setOnClickListener(onClickListener);
    }

    public void setNextBtnText(String str) {
        this.f12672d.setText(str);
    }
}
