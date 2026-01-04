package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.VirtualLayout;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12265l;
import p561q.C12266m;
import p561q.InterfaceC12262i;

/* loaded from: classes.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* renamed from: l */
    public C12265l f2555l;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        this.f2944d = new C12265l();
        m3567w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i10, int i11) {
        mo3234x(this.f2555l, i10, i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: v */
    public void mo3265v(C12259f c12259f, InterfaceC12262i interfaceC12262i, SparseArray<C12258e> sparseArray) {
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    /* renamed from: x */
    public void mo3234x(C12266m c12266m, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (c12266m == null) {
            setMeasuredDimension(0, 0);
        } else {
            c12266m.mo73726H1(mode, size, mode2, size2);
            setMeasuredDimension(c12266m.m73775C1(), c12266m.m73774B1());
        }
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
