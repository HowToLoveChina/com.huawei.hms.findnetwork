package com.huawei.uikit.hwtextview.widget;

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
import android.widget.TextView;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtextview.C8740R;

/* loaded from: classes5.dex */
public class HwTextView extends TextView {

    /* renamed from: g */
    private static final int f44399g = 15;

    /* renamed from: h */
    private static final int f44400h = -1;

    /* renamed from: i */
    private static final int f44401i = 1;

    /* renamed from: j */
    private static final int f44402j = 0;

    /* renamed from: a */
    private float f44403a;

    /* renamed from: b */
    private float f44404b;

    /* renamed from: c */
    private float f44405c;

    /* renamed from: d */
    private boolean f44406d;

    /* renamed from: e */
    private StaticLayout f44407e;

    /* renamed from: f */
    private TextPaint f44408f;

    public HwTextView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private static Context m55649a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8740R.style.Theme_Emui_HwTextView);
    }

    /* renamed from: b */
    private void m55654b(int i10, int i11, int i12) {
        int maxLines;
        if (i12 != 0 && (maxLines = getMaxLines()) > 1) {
            int totalPaddingLeft = (i11 - getTotalPaddingLeft()) - getTotalPaddingRight();
            int extendedPaddingBottom = (i10 - getExtendedPaddingBottom()) - getExtendedPaddingTop();
            if (extendedPaddingBottom <= 0) {
                return;
            }
            StaticLayout staticLayout = new StaticLayout(getText(), this.f44408f, totalPaddingLeft, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
            this.f44407e = staticLayout;
            int lineCount = staticLayout.getLineCount();
            if (this.f44407e.getHeight() <= extendedPaddingBottom || lineCount <= 1 || lineCount > maxLines + 1) {
                return;
            }
            setMaxLines(lineCount - 1);
        }
    }

    public static HwTextView instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwTextView.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwTextView.class);
        if (objInstantiate instanceof HwTextView) {
            return (HwTextView) objInstantiate;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        m55650a(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11), View.MeasureSpec.getMode(i11));
        super.onMeasure(i10, i11);
    }

    public void setAutoTextInfo(int i10, int i11, int i12) {
        Context context = getContext();
        Resources system = context == null ? Resources.getSystem() : context.getResources();
        this.f44404b = TypedValue.applyDimension(i12, i10, system.getDisplayMetrics());
        this.f44405c = TypedValue.applyDimension(i12, i11, system.getDisplayMetrics());
    }

    public void setAutoTextSize(float f10) {
        setAutoTextSize(2, f10);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.f44404b <= 0.0f || this.f44405c <= 0.0f) {
            return;
        }
        requestLayout();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
    }

    public HwTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8740R.attr.hwTextViewStyle);
    }

    /* renamed from: a */
    private void m55652a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8740R.styleable.HwTextView, i10, C8740R.style.Widget_Emui_HwTextView);
        this.f44404b = typedArrayObtainStyledAttributes.getDimension(C8740R.styleable.HwTextView_hwAutoSizeMinTextSize, 0.0f);
        this.f44405c = typedArrayObtainStyledAttributes.getDimension(C8740R.styleable.HwTextView_hwAutoSizeStepGranularity, 0.0f);
        this.f44406d = typedArrayObtainStyledAttributes.getInt(C8740R.styleable.HwTextView_hwAutoSizeTextType, 0) == 1;
        typedArrayObtainStyledAttributes.recycle();
        if (Float.compare(this.f44404b, 0.0f) == 0 && Float.compare(this.f44405c, 0.0f) == 0) {
            this.f44404b = getAutoSizeMinTextSize();
            this.f44405c = getAutoSizeStepGranularity();
            setAutoSizeTextTypeWithDefaults(0);
        }
        TextPaint textPaint = new TextPaint();
        this.f44408f = textPaint;
        textPaint.set(getPaint());
        this.f44403a = getTextSize();
    }

    public void setAutoTextSize(int i10, float f10) {
        Context context = getContext();
        this.f44403a = TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        super.setTextSize(i10, f10);
    }

    public HwTextView(Context context, AttributeSet attributeSet, int i10) {
        super(m55649a(context, i10), attributeSet, i10);
        m55652a(super.getContext(), attributeSet, i10);
    }

    /* renamed from: a */
    private void m55650a(int i10, int i11, int i12) {
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
        if (this.f44408f == null) {
            this.f44408f = new TextPaint();
        }
        this.f44408f.set(getPaint());
        m55651a(i10, i11, totalPaddingLeft, i12);
    }

    /* renamed from: a */
    private void m55651a(int i10, int i11, int i12, int i13) {
        if (!(this.f44406d && getMaxLines() == Integer.MAX_VALUE) && Float.compare(this.f44404b, 0.0f) > 0 && Float.compare(this.f44405c, 0.0f) > 0) {
            float f10 = this.f44403a;
            CharSequence text = getText();
            TransformationMethod transformationMethod = getTransformationMethod();
            if (transformationMethod != null) {
                text = transformationMethod.getTransformation(text, this);
            }
            this.f44408f.setTextSize(f10);
            float fMeasureText = this.f44408f.measureText(text.toString());
            while (m55653a(fMeasureText, i12, f10)) {
                f10 -= this.f44405c;
                this.f44408f.setTextSize(f10);
                fMeasureText = this.f44408f.measureText(text.toString());
            }
            float f11 = this.f44404b;
            if (f10 < f11) {
                f10 = f11;
            }
            setTextSize(0, f10);
            m55654b(i11, i10, i13);
        }
    }

    /* renamed from: a */
    private boolean m55653a(float f10, int i10, float f11) {
        return (!this.f44406d || getMaxLines() == 1) ? Float.compare(f10, (float) i10) > 0 && Float.compare(f11, this.f44404b) > 0 : m55648a(i10) > getMaxLines() && f11 > this.f44404b;
    }

    /* renamed from: a */
    private int m55648a(int i10) {
        CharSequence text = getText();
        if (text == null) {
            return 0;
        }
        return StaticLayout.Builder.obtain(text, 0, text.length(), this.f44408f, i10).build().getLineCount();
    }
}
