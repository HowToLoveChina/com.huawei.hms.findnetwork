package com.huawei.uikit.hwtoggle.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ToggleButton;
import com.huawei.uikit.animations.animator.HwHoverAnimationUtils;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtoggle.C8742R;

/* loaded from: classes5.dex */
public class HwToggleButton extends ToggleButton {

    /* renamed from: e */
    private static final int f44530e = 3;

    /* renamed from: f */
    private static final float f44531f = 1.0f;

    /* renamed from: a */
    private float f44532a;

    /* renamed from: b */
    private float f44533b;

    /* renamed from: c */
    private Drawable f44534c;

    /* renamed from: d */
    private int f44535d;

    public HwToggleButton(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m55756a(boolean z10) {
        HwHoverAnimationUtils.getScaleAnimator(this, z10 ? this.f44532a : this.f44533b).start();
    }

    public static HwToggleButton instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwToggleButton.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwToggleButton.class);
        if (objInstantiate instanceof HwToggleButton) {
            return (HwToggleButton) objInstantiate;
        }
        return null;
    }

    public int getFocusPathColor() {
        return this.f44535d;
    }

    public Drawable getFocusedDrawable() {
        return this.f44534c;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    @Override // android.view.View
    public void onHoverChanged(boolean z10) {
        super.onHoverChanged(z10);
        if (this.f44532a == 1.0f) {
            return;
        }
        m55756a(z10);
    }

    public void setFocusPathColor(int i10) {
        this.f44535d = i10;
    }

    public void setFocusedDrawable(Drawable drawable) {
        this.f44534c = drawable;
    }

    public HwToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8742R.attr.hwToggleStyle);
    }

    public HwToggleButton(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(m55754a(context, i10), attributeSet, i10);
        setDefaultFocusHighlightEnabled(false);
        m55755a(getContext(), attributeSet, i10);
    }

    /* renamed from: a */
    private void m55755a(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8742R.styleable.HwToggleButton, i10, C8742R.style.Widget_Emui_HwToggle);
        this.f44534c = typedArrayObtainStyledAttributes.getDrawable(C8742R.styleable.HwToggleButton_hwFocusedDrawable);
        this.f44535d = typedArrayObtainStyledAttributes.getColor(C8742R.styleable.HwToggleButton_hwFocusedPathColor, 0);
        typedArrayObtainStyledAttributes.recycle();
        TypedValue typedValue = new TypedValue();
        getResources().getValue(C8742R.dimen.hwtoggle_out_hover_zoom_scale, typedValue, true);
        this.f44532a = typedValue.getFloat();
        getResources().getValue(C8742R.dimen.hwtoggle_out_hover_status_scale, typedValue, true);
        this.f44533b = typedValue.getFloat();
    }

    /* renamed from: a */
    private static Context m55754a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8742R.style.Theme_Emui_HwToggle);
    }
}
