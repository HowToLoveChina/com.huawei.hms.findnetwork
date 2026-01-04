package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.C0587e;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class ReactiveGuide extends View implements C0587e.a {

    /* renamed from: a */
    public int f3055a;

    /* renamed from: b */
    public boolean f3056b;

    /* renamed from: c */
    public int f3057c;

    /* renamed from: d */
    public boolean f3058d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f3055a = -1;
        this.f3056b = false;
        this.f3057c = 0;
        this.f3058d = true;
        super.setVisibility(8);
        m3582a(null);
    }

    /* renamed from: a */
    public final void m3582a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f3055a = typedArrayObtainStyledAttributes.getResourceId(index, this.f3055a);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f3056b = typedArrayObtainStyledAttributes.getBoolean(index, this.f3056b);
                } else if (index == R$styleable.f3054x2694048c) {
                    this.f3057c = typedArrayObtainStyledAttributes.getResourceId(index, this.f3057c);
                } else if (index == R$styleable.f3053xfdeff96) {
                    this.f3058d = typedArrayObtainStyledAttributes.getBoolean(index, this.f3058d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f3055a != -1) {
            ConstraintLayout.getSharedValues().m3670a(this.f3055a, this);
        }
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f3057c;
    }

    public int getAttributeId() {
        return this.f3055a;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z10) {
        this.f3056b = z10;
    }

    public void setApplyToConstraintSetId(int i10) {
        this.f3057c = i10;
    }

    public void setAttributeId(int i10) {
        C0587e sharedValues = ConstraintLayout.getSharedValues();
        int i11 = this.f3055a;
        if (i11 != -1) {
            sharedValues.m3671b(i11, this);
        }
        this.f3055a = i10;
        if (i10 != -1) {
            sharedValues.m3670a(i10, this);
        }
    }

    public void setGuidelineBegin(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2976a = i10;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2978b = i10;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2980c = f10;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3055a = -1;
        this.f3056b = false;
        this.f3057c = 0;
        this.f3058d = true;
        super.setVisibility(8);
        m3582a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3055a = -1;
        this.f3056b = false;
        this.f3057c = 0;
        this.f3058d = true;
        super.setVisibility(8);
        m3582a(attributeSet);
    }
}
