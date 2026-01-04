package com.huawei.hms.support.hwid.p147ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.android.hms.hwid.R$color;
import com.huawei.android.hms.hwid.R$drawable;
import com.huawei.android.hms.hwid.R$string;
import com.huawei.android.hms.hwid.R$styleable;

/* loaded from: classes8.dex */
public class HuaweiIdAuthButton extends RelativeLayout {
    public static final int COLOR_POLICY_BLACK = 3;
    public static final int COLOR_POLICY_GRAY = 4;
    public static final int COLOR_POLICY_RED = 0;
    public static final int COLOR_POLICY_WHITE = 1;
    public static final int COLOR_POLICY_WHITE_WITH_BORDER = 2;
    public static final int CORNER_RADIUS_LARGE = -1;
    public static final int CORNER_RADIUS_MEDIUM = -2;
    public static final int CORNER_RADIUS_SMALL = -3;
    public static final int THEME_FULL_TITLE = 1;
    public static final int THEME_NO_TITLE = 0;

    /* renamed from: a */
    private static final PorterDuffColorFilter f30108a;

    /* renamed from: b */
    private static final PorterDuffColorFilter f30109b;

    /* renamed from: c */
    private static final PorterDuffColorFilter f30110c;

    /* renamed from: d */
    private int f30111d;

    /* renamed from: e */
    private int f30112e;

    /* renamed from: f */
    private int f30113f;

    /* renamed from: g */
    private GradientDrawable f30114g;

    /* renamed from: h */
    private Button f30115h;

    /* renamed from: i */
    private ImageView f30116i;

    /* renamed from: j */
    private LinearLayout f30117j;

    static {
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        f30108a = new PorterDuffColorFilter(218103808, mode);
        f30109b = new PorterDuffColorFilter(436207616, mode);
        f30110c = new PorterDuffColorFilter(872415231, mode);
    }

    public HuaweiIdAuthButton(Context context) throws Resources.NotFoundException {
        super(context);
        m36975a((AttributeSet) null);
    }

    /* renamed from: a */
    private void m36975a(AttributeSet attributeSet) throws Resources.NotFoundException {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R$drawable.hwid_auth_button_background);
        this.f30114g = gradientDrawable;
        setBackground(gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f30117j = linearLayout;
        int i10 = 0;
        linearLayout.setOrientation(0);
        this.f30117j.setGravity(17);
        m36976b();
        m36972a();
        addView(this.f30117j);
        int iM36970a = m36970a(8.0f);
        int i11 = 1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.HuaweiIdAuthButton);
            i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.HuaweiIdAuthButton_hwid_button_theme, 1);
            i10 = typedArrayObtainStyledAttributes.getInt(R$styleable.HuaweiIdAuthButton_hwid_color_policy, 0);
            iM36970a = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.HuaweiIdAuthButton_hwid_corner_radius, m36970a(8.0f));
            typedArrayObtainStyledAttributes.recycle();
        }
        setLayoutParams(generateDefaultLayoutParams());
        setUIMode(i11, i10, iM36970a);
    }

    /* renamed from: b */
    private void m36976b() {
        if (this.f30115h == null) {
            this.f30115h = new Button(getContext());
        }
        this.f30115h.setStateListAnimator(null);
        this.f30115h.setBackground(null);
        int intrinsicWidth = m36971a(R$drawable.hwid_auth_button_white).getIntrinsicWidth();
        int iM36970a = m36970a(8.0f);
        this.f30115h.setCompoundDrawablePadding(iM36970a);
        m36973a(intrinsicWidth, iM36970a);
        this.f30115h.setLayoutParams(new ViewGroup.LayoutParams(-2, m36970a(36.0f)));
        this.f30117j.addView(this.f30115h);
    }

    private void setBackgroundCornerRadius(int i10) {
        this.f30114g.mutate();
        this.f30114g.setCornerRadius(i10);
    }

    private void setBackgroundDrawableColor(int i10) {
        this.f30114g.mutate();
        this.f30114g.setColor(getResources().getColor(i10));
    }

    public int getColorPolicy() {
        return this.f30112e;
    }

    public int getCornerRadius() {
        return this.f30113f;
    }

    public int getTheme() {
        return this.f30111d;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0029  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 != 0) goto L39
            android.graphics.drawable.GradientDrawable r0 = r3.f30114g
            if (r0 == 0) goto L46
            boolean r0 = r3.isEnabled()
            if (r0 == 0) goto L46
            int r0 = r3.f30112e
            if (r0 == 0) goto L31
            if (r0 == r1) goto L29
            r2 = 2
            if (r0 == r2) goto L29
            r2 = 3
            if (r0 == r2) goto L21
            r2 = 4
            if (r0 == r2) goto L29
            goto L46
        L21:
            android.graphics.drawable.GradientDrawable r0 = r3.f30114g
            android.graphics.PorterDuffColorFilter r2 = com.huawei.hms.support.hwid.p147ui.HuaweiIdAuthButton.f30110c
            r0.setColorFilter(r2)
            goto L46
        L29:
            android.graphics.drawable.GradientDrawable r0 = r3.f30114g
            android.graphics.PorterDuffColorFilter r2 = com.huawei.hms.support.hwid.p147ui.HuaweiIdAuthButton.f30108a
            r0.setColorFilter(r2)
            goto L46
        L31:
            android.graphics.drawable.GradientDrawable r0 = r3.f30114g
            android.graphics.PorterDuffColorFilter r2 = com.huawei.hms.support.hwid.p147ui.HuaweiIdAuthButton.f30109b
            r0.setColorFilter(r2)
            goto L46
        L39:
            int r0 = r4.getAction()
            if (r1 != r0) goto L46
            android.graphics.drawable.GradientDrawable r0 = r3.f30114g
            if (r0 == 0) goto L46
            r0.clearColorFilter()
        L46:
            boolean r0 = r3.hasOnClickListeners()
            if (r0 == 0) goto L51
            boolean r3 = super.onTouchEvent(r4)
            return r3
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.hwid.p147ui.HuaweiIdAuthButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setColorPolicy(int i10) throws Resources.NotFoundException {
        if (i10 == 0) {
            m36974a(i10, R$color.hwid_auth_button_color_red, R$color.hwid_auth_button_color_text_white, R$drawable.hwid_auth_button_white);
            this.f30116i.setImageDrawable(getResources().getDrawable(R$drawable.hwid_auth_button_round_white));
            return;
        }
        if (i10 == 1) {
            m36974a(i10, R$color.hwid_auth_button_color_white, R$color.hwid_auth_button_color_text_black, R$drawable.hwid_auth_button_normal);
            this.f30116i.setImageDrawable(getResources().getDrawable(R$drawable.hwid_auth_button_round_normal));
            return;
        }
        if (i10 == 2) {
            m36974a(i10, R$color.hwid_auth_button_color_white, R$color.hwid_auth_button_color_text_black, R$drawable.hwid_auth_button_normal);
            if (this.f30111d == 1) {
                m36977b(m36970a(1.0f), getResources().getColor(R$color.hwid_auth_button_color_border));
                return;
            }
            return;
        }
        if (i10 == 3) {
            m36974a(i10, R$color.hwid_auth_button_color_black, R$color.hwid_auth_button_color_text_white, R$drawable.hwid_auth_button_white);
            this.f30116i.setImageDrawable(getResources().getDrawable(R$drawable.hwid_auth_button_round_white));
        } else {
            if (i10 != 4) {
                return;
            }
            m36974a(i10, R$color.hwid_auth_button_color_gray, R$color.hwid_auth_button_color_text_black, R$drawable.hwid_auth_button_normal);
        }
    }

    public void setCornerRadius(int i10) {
        if (i10 == -3) {
            i10 = m36970a(3.0f);
        } else if (i10 == -2) {
            i10 = m36970a(8.0f);
        } else if (i10 == -1) {
            i10 = m36970a(24.0f);
        }
        if (i10 < 0) {
            return;
        }
        this.f30113f = i10;
        setBackgroundCornerRadius(i10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.38f);
        }
    }

    public void setTheme(int i10) {
        if (i10 == 0) {
            this.f30111d = i10;
            this.f30116i.setVisibility(0);
            this.f30115h.setVisibility(8);
            setMinimumWidth(m36970a(48.0f));
            setMinimumHeight(m36970a(48.0f));
            this.f30117j.setMinimumWidth(m36970a(48.0f));
            this.f30117j.setMinimumHeight(m36970a(48.0f));
            return;
        }
        if (i10 != 1) {
            return;
        }
        this.f30111d = i10;
        this.f30116i.setVisibility(8);
        this.f30115h.setVisibility(0);
        setMinimumWidth(m36970a(200.0f));
        setMinimumHeight(m36970a(36.0f));
        this.f30117j.setMinimumWidth(m36970a(200.0f));
        this.f30117j.setMinimumHeight(m36970a(36.0f));
    }

    public void setUIMode(int i10, int i11, int i12) throws Resources.NotFoundException {
        setTheme(i10);
        setColorPolicy(i11);
        setCornerRadius(i12);
    }

    public HuaweiIdAuthButton(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        m36975a(attributeSet);
    }

    public HuaweiIdAuthButton(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        m36975a(attributeSet);
    }

    /* renamed from: b */
    private void m36977b(int i10, int i11) {
        this.f30114g.mutate();
        this.f30114g.setStroke(i10, i11);
    }

    /* renamed from: a */
    private void m36972a() {
        if (this.f30116i == null) {
            this.f30116i = new ImageView(getContext());
        }
        this.f30116i.setImageDrawable(getResources().getDrawable(R$drawable.hwid_auth_button_round_normal));
        setBackgroundDrawableColor(R$color.hwid_auth_button_color_white);
        this.f30117j.addView(this.f30116i);
    }

    /* renamed from: a */
    private void m36973a(int i10, int i11) {
        this.f30115h.setTextSize(16.0f);
        this.f30115h.setText(getResources().getText(R$string.hwid_huawei_login_button_text));
        this.f30115h.setSingleLine();
        int i12 = getResources().getDisplayMetrics().widthPixels;
        int iM36970a = m36970a(16.0f);
        int i13 = iM36970a + iM36970a;
        int i14 = i12 - i13;
        this.f30115h.setMaxWidth(i14);
        float fMeasureText = this.f30115h.getPaint().measureText(this.f30115h.getText().toString());
        while (((int) fMeasureText) + i10 + i11 + i13 > i14 && this.f30115h.getTextSize() > m36970a(9.0f)) {
            Button button = this.f30115h;
            button.setTextSize(0, button.getTextSize() - 1.0f);
            fMeasureText = this.f30115h.getPaint().measureText(this.f30115h.getText().toString());
        }
        this.f30115h.setEllipsize(TextUtils.TruncateAt.END);
        this.f30115h.setPadding(iM36970a, 0, iM36970a, 0);
    }

    /* renamed from: a */
    private Drawable m36971a(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f30115h.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        return drawable;
    }

    /* renamed from: a */
    private void m36974a(int i10, int i11, int i12, int i13) throws Resources.NotFoundException {
        this.f30112e = i10;
        if (this.f30111d != 1 && i10 != 0 && i10 != 3 && i10 != 1) {
            setBackgroundDrawableColor(R$color.hwid_auth_button_color_white);
            this.f30116i.setImageDrawable(getResources().getDrawable(R$drawable.hwid_auth_button_round_normal));
        } else {
            setBackgroundDrawableColor(i11);
        }
        m36977b(0, 0);
        this.f30115h.setTextColor(getResources().getColor(i12));
        m36971a(i13);
    }

    /* renamed from: a */
    private int m36970a(float f10) {
        return (int) ((f10 * getResources().getDisplayMetrics().density) + 0.5f);
    }
}
