package com.huawei.uikit.phone.hwbutton.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.uikit.hwbutton.C8704R;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;

/* loaded from: classes9.dex */
public class HwButton extends com.huawei.uikit.hwbutton.widget.HwButton {

    /* renamed from: a */
    private static final int f44953a = 13;

    /* renamed from: b */
    private static final int f44954b = 1;

    /* renamed from: c */
    private static final int f44955c = 2;

    public HwButton(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m55991a(Canvas canvas) {
        Drawable focusedDrawable;
        if (isFocusable() && hasWindowFocus() && (focusedDrawable = getFocusedDrawable()) != null && isFocused()) {
            canvas.translate(getScrollX(), getScrollY());
            focusedDrawable.setBounds((-getFocusedPathPadding()) - getFocusedPathWidth(), (-getFocusedPathPadding()) - getFocusedPathWidth(), getWidth() + getFocusedPathPadding() + getFocusedPathWidth(), getHeight() + getFocusedPathPadding() + getFocusedPathWidth());
            focusedDrawable.draw(canvas);
            canvas.translate(-getScrollX(), -getScrollY());
        }
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

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        m55991a(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (getFocusedDrawable() != null) {
            invalidate();
        }
    }

    public HwButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8704R.attr.hwButtonStyle);
    }

    public HwButton(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C8704R.styleable.HwButton, i10, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(C8704R.styleable.HwButton_hwAuxiliaryEnable, true) && Float.compare(AuxiliaryHelper.getFontSize(context), 1.75f) >= 0) {
            setMaxLines(2);
            int i11 = typedArrayObtainStyledAttributes.getInt(C8704R.styleable.HwButton_hwButtonStyleType, 0);
            if (i11 == 0) {
                setAutoTextInfo(13, 1, 2);
                int dimensionPixelSize = getResources().getDimensionPixelSize(C8704R.dimen.hwbutton_big_padding_top_or_bottom);
                setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
            }
            if (i11 == 1) {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(C8704R.dimen.hwbutton_small_padding_top_or_bottom);
                setPadding(getPaddingLeft(), dimensionPixelSize2, getPaddingRight(), dimensionPixelSize2);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
