package com.huawei.uikit.hwspinner.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.huawei.uikit.hwspinner.C8734R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class HwSpinnerTextView extends CheckedTextView {

    /* renamed from: e */
    private static final int f44210e = -1;

    /* renamed from: a */
    private float f44211a;

    /* renamed from: b */
    private float f44212b;

    /* renamed from: c */
    private float f44213c;

    /* renamed from: d */
    private TextPaint f44214d;

    public HwSpinnerTextView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m55544a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8734R.styleable.HwSpinnerTextView, i10, 0);
        this.f44212b = typedArrayObtainStyledAttributes.getDimension(C8734R.styleable.HwSpinnerTextView_hwAutoSizeMinTextSize, 0.0f);
        this.f44213c = typedArrayObtainStyledAttributes.getDimension(C8734R.styleable.HwSpinnerTextView_hwAutoSizeStepGranularity, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f44212b == 0.0f && this.f44213c == 0.0f) {
            this.f44212b = getAutoSizeMinTextSize();
            this.f44213c = getAutoSizeStepGranularity();
            setAutoSizeTextTypeWithDefaults(0);
        }
        TextPaint textPaint = new TextPaint();
        this.f44214d = textPaint;
        textPaint.set(getPaint());
        this.f44211a = getTextSize();
    }

    /* renamed from: b */
    private void m55545b(int i10, int i11, int i12) {
        int maxLines;
        if (i12 != 0 && (maxLines = getMaxLines()) > 1) {
            int totalPaddingLeft = (i11 - getTotalPaddingLeft()) - getTotalPaddingRight();
            int extendedPaddingBottom = (i10 - getExtendedPaddingBottom()) - getExtendedPaddingTop();
            if (extendedPaddingBottom <= 0) {
                return;
            }
            StaticLayout staticLayout = new StaticLayout(getText(), getPaint(), totalPaddingLeft, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
            int lineCount = staticLayout.getLineCount();
            if (staticLayout.getHeight() <= extendedPaddingBottom || lineCount <= 1 || lineCount > maxLines + 1) {
                return;
            }
            setMaxLines(lineCount - 1);
        }
    }

    @Override // android.view.View
    public boolean isClickable() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        return !(accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) && super.isClickable();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        m55543a(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11), View.MeasureSpec.getMode(i11));
        super.onMeasure(i10, i11);
    }

    public void setAutoTextInfo(int i10, int i11, int i12) {
        Context context = getContext();
        Resources system = context == null ? Resources.getSystem() : context.getResources();
        this.f44212b = TypedValue.applyDimension(i12, i10, system.getDisplayMetrics());
        this.f44213c = TypedValue.applyDimension(i12, i11, system.getDisplayMetrics());
    }

    public void setAutoTextSize(float f10) {
        setAutoTextSize(2, f10);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z10) {
        boolean zIsPressed = isPressed();
        super.setSelected(z10);
        if (z10 || zIsPressed == isPressed()) {
            return;
        }
        setPressed(zIsPressed);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (Float.compare(this.f44212b, 0.0f) <= 0 || Float.compare(this.f44213c, 0.0f) <= 0) {
            return;
        }
        requestLayout();
    }

    public HwSpinnerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m55544a(context, attributeSet, 0);
    }

    public void setAutoTextSize(int i10, float f10) {
        Context context = getContext();
        this.f44211a = TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        super.setTextSize(i10, f10);
    }

    public HwSpinnerTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m55544a(context, attributeSet, i10);
    }

    /* renamed from: a */
    private void m55543a(int i10, int i11, int i12) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (maxWidth != -1 && maxWidth < i10) {
            i10 = maxWidth;
        }
        if (maxHeight != -1 && maxHeight < i11) {
            i11 = maxHeight;
        }
        int totalPaddingLeft = (i10 - getTotalPaddingLeft()) - getTotalPaddingRight();
        if (totalPaddingLeft < 0) {
            return;
        }
        if (this.f44214d == null) {
            this.f44214d = new TextPaint();
        }
        this.f44214d.set(getPaint());
        if (this.f44212b <= 0.0f || this.f44213c <= 0.0f) {
            return;
        }
        float f10 = this.f44211a;
        CharSequence text = getText();
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, this);
        }
        this.f44214d.setTextSize(f10);
        float fMeasureText = this.f44214d.measureText(text.toString());
        while (Float.compare(fMeasureText, totalPaddingLeft) > 0 && Float.compare(f10, this.f44212b) > 0) {
            f10 -= this.f44213c;
            this.f44214d.setTextSize(f10);
            fMeasureText = this.f44214d.measureText(text.toString());
        }
        float f11 = this.f44212b;
        if (f10 < f11) {
            f10 = f11;
        }
        setTextSize(0, f10);
        m55545b(i11, i10, i12);
    }
}
