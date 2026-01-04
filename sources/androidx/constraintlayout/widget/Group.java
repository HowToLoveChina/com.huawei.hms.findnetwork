package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: j */
    public void mo3256j(ConstraintLayout constraintLayout) {
        m3560i(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        this.f2945e = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        m3559h();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: r */
    public void mo3257r(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f3019v0.m73638p1(0);
        layoutParams.f3019v0.m73579Q0(0);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        m3559h();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        m3559h();
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
