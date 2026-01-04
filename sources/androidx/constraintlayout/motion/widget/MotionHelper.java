package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import p642t.C12908m;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.InterfaceC0564j {

    /* renamed from: j */
    public boolean f2556j;

    /* renamed from: k */
    public boolean f2557k;

    /* renamed from: l */
    public float f2558l;

    /* renamed from: m */
    public View[] f2559m;

    public MotionHelper(Context context) {
        super(context);
        this.f2556j = false;
        this.f2557k = false;
    }

    /* renamed from: A */
    public void m3266A(MotionLayout motionLayout) {
    }

    /* renamed from: B */
    public void m3267B(Canvas canvas) {
    }

    /* renamed from: C */
    public void m3268C(Canvas canvas) {
    }

    /* renamed from: D */
    public void mo3263D(MotionLayout motionLayout, HashMap<View, C12908m> map) {
    }

    /* renamed from: E */
    public void m3269E(View view, float f10) {
    }

    /* renamed from: a */
    public void mo3226a(MotionLayout motionLayout, int i10, int i11, float f10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0564j
    /* renamed from: b */
    public void mo3270b(MotionLayout motionLayout, int i10, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0564j
    /* renamed from: c */
    public void mo3271c(MotionLayout motionLayout, int i10, boolean z10, float f10) {
    }

    /* renamed from: d */
    public void mo3227d(MotionLayout motionLayout, int i10) {
    }

    public float getProgress() {
        return this.f2558l;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.f2556j = typedArrayObtainStyledAttributes.getBoolean(index, this.f2556j);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.f2557k = typedArrayObtainStyledAttributes.getBoolean(index, this.f2557k);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f2558l = f10;
        int i10 = 0;
        if (this.f2942b > 0) {
            this.f2559m = m3564n((ConstraintLayout) getParent());
            while (i10 < this.f2942b) {
                m3269E(this.f2559m[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof MotionHelper)) {
                m3269E(childAt, f10);
            }
            i10++;
        }
    }

    /* renamed from: x */
    public boolean mo3264x() {
        return false;
    }

    /* renamed from: y */
    public boolean m3272y() {
        return this.f2557k;
    }

    /* renamed from: z */
    public boolean m3273z() {
        return this.f2556j;
    }

    public MotionHelper(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f2556j = false;
        this.f2557k = false;
        mo3229o(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet, i10);
        this.f2556j = false;
        this.f2557k = false;
        mo3229o(attributeSet);
    }
}
