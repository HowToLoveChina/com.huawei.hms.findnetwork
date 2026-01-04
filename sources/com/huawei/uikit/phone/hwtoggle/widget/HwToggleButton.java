package com.huawei.uikit.phone.hwtoggle.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.phone.hwtoggle.C8771R;

/* loaded from: classes9.dex */
public class HwToggleButton extends com.huawei.uikit.hwtoggle.widget.HwToggleButton {

    /* renamed from: a */
    private int f45063a;

    /* renamed from: b */
    private int f45064b;

    public HwToggleButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        Drawable focusedDrawable = getFocusedDrawable();
        if (isFocused() && focusedDrawable != null && hasWindowFocus()) {
            canvas.translate(getScrollX(), getScrollY());
            int i10 = (-this.f45063a) - this.f45064b;
            focusedDrawable.setBounds(i10, i10, getWidth() + this.f45063a + this.f45064b, getHeight() + this.f45063a + this.f45064b);
            focusedDrawable.draw(canvas);
            canvas.translate(-getScrollX(), -getScrollY());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (getFocusedDrawable() != null) {
            invalidate();
        }
    }

    public HwToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8771R.attr.hwToggleStyle);
    }

    public HwToggleButton(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.f45063a = (int) getResources().getDimension(C8771R.dimen.hwtoggle_focus_status_padding);
        this.f45064b = (int) getResources().getDimension(C8771R.dimen.hwtoggle_focus_status_stroke_width);
        if (Float.compare(AuxiliaryHelper.getFontSize(context), 1.75f) >= 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(C8771R.dimen.hwtoggle_button_padding_top_or_bottom);
            setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
        }
    }
}
