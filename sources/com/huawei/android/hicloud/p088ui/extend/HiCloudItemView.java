package com.huawei.android.hicloud.p088ui.extend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudEndTextLayout;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$styleable;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import gp.C10028c;
import p015ak.C0209d;
import p336he.C10155f;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class HiCloudItemView extends LinearLayout implements CompoundButton.OnCheckedChangeListener, InterfaceC12805b {

    /* renamed from: A */
    public String f17898A;

    /* renamed from: B */
    public UnionSwitch f17899B;

    /* renamed from: C */
    public boolean f17900C;

    /* renamed from: D */
    public RelativeLayout f17901D;

    /* renamed from: E */
    public HiCloudItemCheckedChangeListener f17902E;

    /* renamed from: F */
    public Context f17903F;

    /* renamed from: G */
    public boolean f17904G;

    /* renamed from: H */
    public boolean f17905H;

    /* renamed from: I */
    public View f17906I;

    /* renamed from: J */
    public View f17907J;

    /* renamed from: K */
    public boolean f17908K;

    /* renamed from: L */
    public boolean f17909L;

    /* renamed from: M */
    public int f17910M;

    /* renamed from: N */
    public int f17911N;

    /* renamed from: a */
    public RelativeLayout f17912a;

    /* renamed from: b */
    public ImageView f17913b;

    /* renamed from: c */
    public Drawable f17914c;

    /* renamed from: d */
    public TextView f17915d;

    /* renamed from: e */
    public String f17916e;

    /* renamed from: f */
    public int f17917f;

    /* renamed from: g */
    public int f17918g;

    /* renamed from: h */
    public int f17919h;

    /* renamed from: i */
    public ImageView f17920i;

    /* renamed from: j */
    public HiCloudListTipsLayout f17921j;

    /* renamed from: k */
    public String f17922k;

    /* renamed from: l */
    public TextView f17923l;

    /* renamed from: m */
    public String f17924m;

    /* renamed from: n */
    public View f17925n;

    /* renamed from: o */
    public View f17926o;

    /* renamed from: p */
    public View f17927p;

    /* renamed from: q */
    public View f17928q;

    /* renamed from: r */
    public String f17929r;

    /* renamed from: s */
    public ProgressBar f17930s;

    /* renamed from: t */
    public HiCloudEndTextLayout f17931t;

    /* renamed from: u */
    public RelativeLayout f17932u;

    /* renamed from: v */
    public boolean f17933v;

    /* renamed from: w */
    public boolean f17934w;

    /* renamed from: x */
    public boolean f17935x;

    /* renamed from: y */
    public ImageView f17936y;

    /* renamed from: z */
    public boolean f17937z;

    public HiCloudItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17929r = ParamConstants.CallbackMethod.ON_SHOW;
        this.f17905H = true;
        this.f17909L = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hicloud_item_attr);
        this.f17903F = context;
        m23960r(context);
        m23959l(typedArrayObtainStyledAttributes);
        this.f17910M = (int) C11842p.m70844o(this.f17903F, 8);
        this.f17911N = (int) C11842p.m70844o(this.f17903F, 4);
    }

    private int getMaxTitleViewWidthHasSwitch() {
        int iM70719D;
        float fM70844o;
        if (this.f17909L && C11829c.m70511E0(this.f17903F)) {
            return C11842p.m70722E();
        }
        if ((this.f17903F instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f17903F)) {
            if (this.f17914c != null) {
                return C11842p.m70773V();
            }
            iM70719D = C11842p.m70773V() + ((int) C11842p.m70844o(this.f17903F, 40));
            fM70844o = C11842p.m70844o(this.f17903F, 16);
        } else {
            if (this.f17914c != null) {
                return C11842p.m70719D();
            }
            iM70719D = C11842p.m70719D() + ((int) C11842p.m70844o(this.f17903F, 40));
            fM70844o = C11842p.m70844o(this.f17903F, 16);
        }
        return iM70719D + ((int) fM70844o);
    }

    private int getMaxTitleViewWidthHasTextRight() {
        int iM70713B;
        float fM70844o;
        if (this.f17909L && C11829c.m70511E0(this.f17903F)) {
            return C11842p.m70716C();
        }
        if ((this.f17903F instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f17903F)) {
            if (this.f17914c != null) {
                return C11842p.m70770U(this.f17903F);
            }
            iM70713B = C11842p.m70770U(this.f17903F);
            fM70844o = C11842p.m70844o(this.f17903F, 40);
        } else {
            if (this.f17914c != null) {
                return C11842p.m70713B(this.f17903F);
            }
            iM70713B = C11842p.m70713B(this.f17903F);
            fM70844o = C11842p.m70844o(this.f17903F, 40);
        }
        return iM70713B + ((int) fM70844o);
    }

    private int getMaxTitleViewWidthNoTextRight() {
        int iM70805e0;
        float fM70844o;
        if (this.f17909L && C11829c.m70511E0(this.f17903F)) {
            return C11842p.m70809f0();
        }
        if ((this.f17903F instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f17903F)) {
            if (this.f17914c == null) {
                return C11842p.m70782Y();
            }
            iM70805e0 = C11842p.m70782Y();
            fM70844o = C11842p.m70844o(this.f17903F, 40);
        } else {
            if (this.f17914c == null) {
                return C11842p.m70805e0();
            }
            iM70805e0 = C11842p.m70805e0();
            fM70844o = C11842p.m70844o(this.f17903F, 40);
        }
        return iM70805e0 - ((int) fM70844o);
    }

    /* renamed from: l */
    private void m23959l(TypedArray typedArray) {
        RelativeLayout relativeLayout;
        if (typedArray != null) {
            this.f17916e = typedArray.getString(R$styleable.hicloud_item_attr_item_title);
            this.f17917f = typedArray.getDimensionPixelSize(R$styleable.hicloud_item_attr_min_height, C11842p.m70840n(this.f17903F, 48));
            this.f17918g = typedArray.getDimensionPixelSize(R$styleable.hicloud_item_attr_title_text_size, 0);
            this.f17919h = typedArray.getDimensionPixelSize(R$styleable.hicloud_item_attr_icon_size, 0);
            this.f17924m = typedArray.getString(R$styleable.hicloud_item_attr_status_text);
            this.f17929r = typedArray.getString(R$styleable.hicloud_item_attr_item_divider);
            this.f17934w = typedArray.getBoolean(R$styleable.hicloud_item_attr_loading, false);
            this.f17937z = typedArray.getBoolean(R$styleable.hicloud_item_attr_sub_user_disable, false);
            this.f17908K = typedArray.getBoolean(R$styleable.hicloud_item_attr_no_need_notch_fit, false);
            this.f17933v = typedArray.getBoolean(R$styleable.hicloud_item_attr_show_end_status_frame_view, true);
            this.f17905H = typedArray.getBoolean(R$styleable.hicloud_item_attr_sub_title_width_limited, true);
            this.f17931t.setVisibility(this.f17933v ? 0 : 8);
            if (C0209d.m1195O(this.f17903F) >= 1.75f && (relativeLayout = this.f17932u) != null) {
                relativeLayout.setVisibility(this.f17933v ? 0 : 8);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17912a.getLayoutParams();
            Resources resources = this.f17903F.getResources();
            int i10 = R$dimen.cs_8_dp;
            marginLayoutParams.topMargin = (int) resources.getDimension(i10);
            marginLayoutParams.bottomMargin = (int) this.f17903F.getResources().getDimension(i10);
            if (this.f17933v) {
                marginLayoutParams.rightMargin = (int) this.f17903F.getResources().getDimension(R$dimen.cs_16_dp);
            } else {
                marginLayoutParams.rightMargin = 0;
            }
            this.f17912a.setLayoutParams(marginLayoutParams);
            this.f17907J.setMinimumHeight(this.f17917f);
            this.f17915d.setText(this.f17916e);
            this.f17915d.setContentDescription(this.f17916e);
            this.f17899B.setContentDescription(this.f17916e);
            int i11 = this.f17918g;
            if (i11 != 0) {
                this.f17915d.setTextSize(0, i11);
            }
            if (this.f17919h != 0) {
                ViewGroup.LayoutParams layoutParams = this.f17913b.getLayoutParams();
                int i12 = this.f17919h;
                layoutParams.height = i12;
                layoutParams.width = i12;
                this.f17913b.setLayoutParams(layoutParams);
            }
            this.f17923l.setText(this.f17924m);
            this.f17923l.setContentDescription(this.f17924m);
            if (this.f17934w) {
                m23963C();
            } else {
                m23975f();
            }
            if (this.f17937z && !C0209d.m1166E1()) {
                m23970a();
            }
            m23983o(typedArray);
            if (this.f17914c == null) {
                this.f17927p = this.f17926o;
            } else {
                this.f17927p = this.f17925n;
            }
            String str = this.f17929r;
            if (str == null || !str.equals("none")) {
                this.f17927p.setVisibility(0);
            } else {
                this.f17927p.setVisibility(8);
            }
            m23984p(typedArray);
            m23981m(typedArray);
            m23985q(typedArray);
            m23982n(typedArray);
            typedArray.recycle();
        }
    }

    /* renamed from: r */
    private void m23960r(Context context) {
        m23980k();
        this.f17907J = this.f17906I.findViewById(R$id.hicloud_item);
        this.f17913b = (ImageView) C12809f.m76831d(this, R$id.hicloud_item_icon);
        this.f17915d = (TextView) C12809f.m76831d(this, R$id.hicloud_item_title);
        this.f17921j = (HiCloudListTipsLayout) C12809f.m76831d(this, R$id.hicloud_sub_title);
        this.f17923l = (TextView) C12809f.m76831d(this, R$id.hicloud_item_status);
        this.f17925n = C12809f.m76831d(this, R$id.hicloud_item_divider);
        this.f17926o = C12809f.m76831d(this, R$id.hicloud_item_divider_no_icon);
        this.f17931t = (HiCloudEndTextLayout) C12809f.m76831d(this, R$id.hicloud_item_status_frame);
        if (C0209d.m1195O(this.f17903F) >= 1.75f) {
            this.f17932u = (RelativeLayout) C12809f.m76831d(this, R$id.hicloud_array_layout_scale);
        }
        this.f17930s = (ProgressBar) C12809f.m76831d(this, R$id.hicloud_item_loading_progress);
        this.f17936y = (ImageView) C12809f.m76831d(this, R$id.hicloud_item_right_arrow);
        this.f17899B = (UnionSwitch) C12809f.m76831d(this, R$id.hicloud_item_switch);
        this.f17920i = (ImageView) C12809f.m76831d(this, R$id.backup_redDot_icon);
        this.f17901D = (RelativeLayout) C12809f.m76831d(this, R$id.main_layout);
        this.f17912a = (RelativeLayout) C12809f.m76831d(this, R$id.hicloud_text_frame);
    }

    private void setViewGone(boolean z10) {
        if (z10) {
            setVisibility(8);
        }
    }

    /* renamed from: A */
    public void m23961A() {
        if (this.f17928q == null) {
            this.f17927p.setVisibility(0);
        } else {
            this.f17927p.setVisibility(8);
            this.f17928q.setVisibility(0);
        }
    }

    /* renamed from: B */
    public void m23962B() {
        this.f17913b.setVisibility(0);
        Resources resources = getResources();
        if (resources != null) {
            this.f17901D.setMinimumHeight(resources.getDimensionPixelSize(R$dimen.list_min_height_with_icon));
        }
    }

    /* renamed from: C */
    public void m23963C() {
        this.f17930s.setVisibility(0);
        this.f17936y.setVisibility(8);
        this.f17923l.setVisibility(8);
    }

    /* renamed from: D */
    public void m23964D() {
        m23973d();
        this.f17927p = this.f17925n;
        m23961A();
    }

    /* renamed from: E */
    public void m23965E() {
        this.f17899B.setVisibility(8);
        this.f17936y.setVisibility(0);
        this.f17923l.setVisibility(0);
        int iM70844o = (int) C11842p.m70844o(this.f17903F, 8);
        View view = this.f17907J;
        if (view != null) {
            view.setPaddingRelative(iM70844o, view.getPaddingTop(), iM70844o, this.f17907J.getPaddingBottom());
        }
        View view2 = this.f17925n;
        if (view2 != null) {
            C11842p.m70819h2(view2, 0);
        }
    }

    /* renamed from: F */
    public void m23966F() {
        this.f17921j.m23997d();
    }

    /* renamed from: G */
    public void m23967G() {
        this.f17930s.setVisibility(8);
        this.f17936y.setVisibility(8);
        this.f17923l.setVisibility(8);
        this.f17899B.setVisibility(0);
    }

    /* renamed from: H */
    public void m23968H() {
        this.f17899B.setVisibility(0);
        this.f17936y.setVisibility(8);
        this.f17923l.setVisibility(8);
        View view = this.f17907J;
        if (view != null) {
            view.setPaddingRelative(this.f17910M, view.getPaddingTop(), this.f17911N, this.f17907J.getPaddingBottom());
        }
        View view2 = this.f17925n;
        if (view2 != null) {
            C11842p.m70819h2(view2, this.f17911N);
        }
    }

    /* renamed from: I */
    public void m23969I() {
        this.f17899B.setOnCheckedChangeListener(this);
        m23967G();
    }

    /* renamed from: a */
    public void m23970a() {
        this.f17915d.setAlpha(0.62f);
        this.f17921j.setAlpha(0.62f);
        this.f17913b.setAlpha(0.62f);
        this.f17923l.setAlpha(0.62f);
        this.f17936y.setAlpha(0.62f);
        this.f17899B.setEnabled(false);
        setEnabled(false);
    }

    /* renamed from: b */
    public void m23971b() {
        this.f17915d.setAlpha(1.0f);
        this.f17921j.setAlpha(1.0f);
        this.f17923l.setAlpha(1.0f);
        this.f17936y.setAlpha(1.0f);
        this.f17913b.setAlpha(1.0f);
    }

    /* renamed from: c */
    public void m23972c() {
        this.f17915d.setAlpha(1.0f);
        this.f17921j.setAlpha(1.0f);
        this.f17913b.setAlpha(1.0f);
        this.f17923l.setAlpha(1.0f);
        this.f17936y.setAlpha(1.0f);
        this.f17899B.setEnabled(true);
        setEnabled(true);
    }

    /* renamed from: d */
    public void m23973d() {
        View view = this.f17928q;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f17927p.setVisibility(8);
    }

    /* renamed from: e */
    public void m23974e() {
        this.f17913b.setVisibility(8);
    }

    /* renamed from: f */
    public void m23975f() {
        this.f17930s.setVisibility(8);
        this.f17936y.setVisibility(0);
        this.f17923l.setVisibility(0);
    }

    /* renamed from: g */
    public void m23976g() {
        this.f17930s.setVisibility(8);
    }

    /* renamed from: h */
    public void m23977h() {
        this.f17921j.m23994a();
    }

    /* renamed from: i */
    public void m23978i() {
        this.f17899B.setVisibility(8);
    }

    /* renamed from: j */
    public void m23979j() {
        this.f17921j.m23994a();
    }

    /* renamed from: k */
    public final void m23980k() {
        if (C0209d.m1195O(this.f17903F) >= 1.75f) {
            this.f17906I = View.inflate(this.f17903F, R$layout.hicloud_item_font_scale, this);
        } else {
            this.f17906I = View.inflate(this.f17903F, R$layout.hicloud_item, this);
        }
    }

    /* renamed from: m */
    public void m23981m(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_item_attr_module_disable_hide);
        this.f17898A = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        m23993z();
    }

    /* renamed from: n */
    public void m23982n(TypedArray typedArray) {
        this.f17904G = typedArray.getBoolean(R$styleable.hicloud_item_attr_endtext_support_min_width, true);
        m23992y();
    }

    /* renamed from: o */
    public void m23983o(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(R$styleable.hicloud_item_attr_item_img);
        this.f17914c = drawable;
        this.f17913b.setImageDrawable(drawable);
        this.f17901D.setMinimumHeight(getResources().getDimensionPixelSize(R$dimen.list_min_height_with_icon));
        boolean z10 = typedArray.getBoolean(R$styleable.hicloud_item_attr_hide_img, false);
        this.f17935x = z10;
        if (z10) {
            this.f17913b.setVisibility(8);
            this.f17901D.setMinimumHeight(getResources().getDimensionPixelSize(R$dimen.list_min_height));
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        HiCloudItemCheckedChangeListener hiCloudItemCheckedChangeListener = this.f17902E;
        if (hiCloudItemCheckedChangeListener != null) {
            hiCloudItemCheckedChangeListener.mo21351d0(this, z10);
        }
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        if (this.f17908K) {
            return;
        }
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        if (this.f17908K) {
            return;
        }
        Context context = this.f17903F;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.f17903F), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        if (this.f17908K) {
            return;
        }
        Context context = this.f17903F;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        if (this.f17908K) {
            return;
        }
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    /* renamed from: p */
    public void m23984p(TypedArray typedArray) {
        String string = typedArray.getString(R$styleable.hicloud_item_attr_sub_title);
        this.f17922k = string;
        if (TextUtils.isEmpty(string)) {
            this.f17921j.m23995b();
        } else {
            this.f17921j.setText(this.f17922k);
            this.f17921j.setContentDescription(this.f17922k);
        }
    }

    /* renamed from: q */
    public void m23985q(TypedArray typedArray) {
        boolean z10 = typedArray.getBoolean(R$styleable.hicloud_item_attr_show_switch, false);
        this.f17900C = z10;
        if (!z10) {
            m23978i();
        } else {
            this.f17899B.setOnCheckedChangeListener(this);
            m23967G();
        }
    }

    /* renamed from: s */
    public boolean m23986s() {
        return this.f17899B.isChecked();
    }

    public void setChecked(boolean z10) {
        this.f17899B.setChecked(z10);
    }

    public void setCheckedProgrammatically(boolean z10) {
        this.f17899B.setCheckedProgrammatically(z10);
    }

    public void setDefaultSubTitle(String str) {
        this.f17921j.setDefaultTips(str);
    }

    public void setImage(Drawable drawable) {
        this.f17913b.setImageDrawable(drawable);
        this.f17913b.setVisibility(0);
        this.f17914c = drawable;
        m23992y();
    }

    public void setItemOnCheckedChangeListener(HiCloudItemCheckedChangeListener hiCloudItemCheckedChangeListener) {
        this.f17902E = hiCloudItemCheckedChangeListener;
    }

    public void setOutsideDivider(View view) {
        this.f17928q = view;
    }

    public void setShowSwitch(boolean z10) {
        this.f17900C = z10;
    }

    public void setStatusText(String str) {
        this.f17923l.setText(str);
        this.f17923l.setContentDescription(str);
    }

    public void setSubTitleLoadingText(String str) throws Resources.NotFoundException {
        this.f17921j.setLoadingText(str);
    }

    public void setSubTitleText(CharSequence charSequence) {
        this.f17921j.setText(charSequence);
        this.f17921j.setContentDescription(charSequence);
    }

    public void setSupportMinWidth(boolean z10) {
        this.f17904G = z10;
        m23992y();
    }

    public void setSwitchContentDescription(String str) {
        this.f17899B.setContentDescription(str);
    }

    public void setSyncItemView(boolean z10) {
        this.f17909L = z10;
    }

    public void setTitle(String str) {
        this.f17915d.setText(str);
        this.f17915d.setContentDescription(str);
    }

    /* renamed from: t */
    public void m23987t() {
        int maxTitleViewWidthHasSwitch = this.f17899B.getVisibility() == 0 ? getMaxTitleViewWidthHasSwitch() : !this.f17904G ? getMaxTitleViewWidthNoTextRight() : getMaxTitleViewWidthHasTextRight();
        this.f17915d.setMaxWidth(maxTitleViewWidthHasSwitch - C11842p.m70840n(this.f17903F, 10));
        if (this.f17905H) {
            this.f17921j.m23998e(maxTitleViewWidthHasSwitch);
        }
    }

    /* renamed from: u */
    public final void m23988u() {
        if (C10155f.m63248A()) {
            return;
        }
        setVisibility(8);
    }

    /* renamed from: v */
    public void m23989v() {
        View view = this.f17907J;
        if (view != null) {
            view.setBackground(null);
        }
    }

    /* renamed from: w */
    public void m23990w() {
        this.f17921j.m23995b();
    }

    /* renamed from: x */
    public void m23991x(String str, String str2, SpanClickText.ISpanClickListener iSpanClickListener) {
        this.f17921j.m23996c(str, str2, iSpanClickListener);
        this.f17921j.setContentDescription(str);
    }

    /* renamed from: y */
    public void m23992y() {
        this.f17931t.setSupportMinWidth(this.f17904G);
        this.f17931t.requestLayout();
        this.f17915d.requestLayout();
        int maxTitleViewWidthHasSwitch = !this.f17904G ? this.f17900C ? getMaxTitleViewWidthHasSwitch() : getMaxTitleViewWidthNoTextRight() : this.f17900C ? getMaxTitleViewWidthHasSwitch() : getMaxTitleViewWidthHasTextRight();
        this.f17915d.setMaxWidth(maxTitleViewWidthHasSwitch - C11842p.m70840n(this.f17903F, 10));
        if (this.f17905H) {
            this.f17921j.m23998e(maxTitleViewWidthHasSwitch);
        }
    }

    /* renamed from: z */
    public final void m23993z() {
        String str = this.f17898A;
        str.hashCode();
        switch (str) {
            case "funcfg_wlan":
                setViewGone(!C10028c.m62183d0(this.f17903F).m62395t1("funcfg_wlan"));
                break;
            case "funcfg_notes":
                setViewGone((C10155f.m63252E() && C11019b.m66371t().m66401U("funcfg_notes") && C0209d.m1215U1(this.f17903F)) ? false : true);
                break;
            case "funcfg_huawei_drive":
                m23988u();
                break;
            case "autorecordingkey":
                setViewGone(!C10155f.m63254G(this.f17903F));
                break;
            case "funcfg_contacts":
                setViewGone((C10155f.m63302z() && C11019b.m66371t().m66401U("funcfg_contacts")) ? false : true);
                break;
            case "funcfg_find_my_phone_globe":
                setViewGone(!C10028c.m62183d0(this.f17903F).m62395t1("funcfg_find_my_phone_globe"));
                break;
            case "funcfg_calendar":
                setViewGone((C10155f.m63297u() && C11019b.m66371t().m66401U("funcfg_calendar")) ? false : true);
                break;
            case "autosmslistkey":
                setViewGone(!C10155f.m63255H(this.f17903F));
                break;
            case "funcfg_cloud_backup":
                setViewGone(!C10028c.m62183d0(this.f17903F).m62395t1("funcfg_cloud_backup"));
                break;
            case "autophonemanagerkey":
                setViewGone(!C10155f.m63250C(this.f17903F));
                break;
            case "funcfg_gallery":
                setViewGone(!C10028c.m62183d0(this.f17903F).m62395t1("funcfg_gallery") || C0209d.m1293p1());
                break;
            case "funcfg_browser":
                setViewGone(!C10155f.m63296t(this.f17903F) || C0209d.m1293p1());
                break;
            case "autocallloglistkey":
                setViewGone(!C10155f.m63298v(this.f17903F));
                break;
        }
    }
}
