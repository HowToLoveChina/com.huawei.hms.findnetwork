package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.huawei.android.p073ds.R$styleable;

/* loaded from: classes3.dex */
public class StretchTextView extends AppCompatTextView {

    /* renamed from: h */
    public CharSequence f19550h;

    /* renamed from: i */
    public float f19551i;

    /* renamed from: j */
    public float f19552j;

    /* renamed from: k */
    public int f19553k;

    /* renamed from: l */
    public Layout.Alignment f19554l;

    /* renamed from: m */
    public float f19555m;

    /* renamed from: n */
    public int f19556n;

    /* renamed from: o */
    public int f19557o;

    /* renamed from: p */
    public float f19558p;

    /* renamed from: q */
    public float f19559q;

    public StretchTextView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f19550h = getText();
        this.f19556n = ((i10 - i12) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        int compoundPaddingBottom = ((i11 - i13) - getCompoundPaddingBottom()) - getCompoundPaddingTop();
        this.f19557o = compoundPaddingBottom;
        m25812u(this.f19556n, compoundPaddingBottom);
    }

    /* renamed from: r */
    public void m25809r(float f10) {
        setTextSize(0, f10);
    }

    /* renamed from: s */
    public final StaticLayout m25810s(CharSequence charSequence, Layout.Alignment alignment, TextPaint textPaint, int i10, float f10) {
        textPaint.setTextSize(f10);
        float f11 = this.f19551i;
        float f12 = this.f19555m;
        if (f11 < f12) {
            f11 = f12;
        }
        this.f19551i = f11;
        return new StaticLayout(charSequence, textPaint, i10, alignment, this.f19551i, this.f19552j, true);
    }

    /* renamed from: t */
    public final float m25811t(String str, int i10, int i11, TextPaint textPaint, Layout.Alignment alignment) {
        float fM25813v = m25813v(str, i10, i11, textPaint, alignment, null);
        this.f19558p = fM25813v;
        return fM25813v;
    }

    /* renamed from: u */
    public final void m25812u(int i10, int i11) {
        CharSequence charSequence;
        this.f19556n = i10;
        this.f19557o = i11;
        if (i10 >= 0 && i11 >= 0 && (charSequence = this.f19550h) != null && charSequence.length() > 0) {
            this.f19559q = m25811t(this.f19550h.toString().trim(), i10, i11, new TextPaint(getPaint()), this.f19554l);
        }
        m25809r(this.f19559q);
    }

    /* renamed from: v */
    public float m25813v(String str, int i10, int i11, TextPaint textPaint, Layout.Alignment alignment, Canvas canvas) {
        float textSize = textPaint.getTextSize();
        this.f19558p = textSize;
        int height = m25810s(str, alignment, textPaint, i10, textSize).getHeight();
        while (height > i11) {
            float f10 = this.f19558p;
            float f11 = this.f19555m;
            if (f10 <= f11) {
                break;
            }
            float fMax = Math.max(f10 - f11, f11);
            this.f19558p = fMax;
            height = m25810s(str, alignment, textPaint, i10, fMax).getHeight();
        }
        if (canvas != null) {
            m25810s(str, alignment, textPaint, i10, this.f19558p).draw(canvas);
        }
        return this.f19558p;
    }

    public StretchTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StretchTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19551i = 1.0f;
        this.f19552j = 0.0f;
        this.f19553k = 0;
        this.f19555m = 1.0f;
        this.f19559q = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StretchTextView);
        this.f19553k = typedArrayObtainStyledAttributes.getInteger(R$styleable.StretchTextView_layoutalign, 0);
        this.f19551i = typedArrayObtainStyledAttributes.getInteger(R$styleable.StretchTextView_mSpacingMult, 1);
        this.f19552j = typedArrayObtainStyledAttributes.getInteger(R$styleable.StretchTextView_mSpacingAdd, 0);
        int i11 = this.f19553k;
        if (i11 == 0) {
            this.f19554l = Layout.Alignment.ALIGN_NORMAL;
        } else if (i11 == 1) {
            this.f19554l = Layout.Alignment.ALIGN_CENTER;
        } else if (i11 == 2) {
            this.f19554l = Layout.Alignment.ALIGN_OPPOSITE;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f19550h = getText();
    }
}
