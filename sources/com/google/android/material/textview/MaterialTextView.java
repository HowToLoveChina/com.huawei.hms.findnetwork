package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import p276f3.C9648b;
import p276f3.C9649c;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    /* renamed from: s */
    public static boolean m11378s(Context context) {
        return C9648b.m60261b(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    /* renamed from: t */
    public static int m11379t(Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* renamed from: u */
    public static int m11380u(Context context, TypedArray typedArray, int... iArr) {
        int iM60268d = -1;
        for (int i10 = 0; i10 < iArr.length && iM60268d < 0; i10++) {
            iM60268d = C9649c.m60268d(context, typedArray, iArr[i10], -1);
        }
        return iM60268d;
    }

    /* renamed from: v */
    public static boolean m11381v(Context context, Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i10, i11);
        int iM11380u = m11380u(context, typedArrayObtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iM11380u != -1;
    }

    /* renamed from: r */
    public final void m11382r(Resources.Theme theme, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i10, R$styleable.MaterialTextAppearance);
        int iM11380u = m11380u(getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iM11380u >= 0) {
            setLineHeight(iM11380u);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i10) throws Resources.NotFoundException {
        super.setTextAppearance(context, i10);
        if (m11378s(context)) {
            m11382r(context.getTheme(), i10);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        int iM11379t;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        if (m11378s(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (m11381v(context2, theme, attributeSet, i10, i11) || (iM11379t = m11379t(theme, attributeSet, i10, i11)) == -1) {
                return;
            }
            m11382r(theme, iM11379t);
        }
    }
}
