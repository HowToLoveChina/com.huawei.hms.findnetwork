package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.ConstraintLayout;
import p561q.C12254a;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12263j;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: j */
    public int f2938j;

    /* renamed from: k */
    public int f2939k;

    /* renamed from: l */
    public C12254a f2940l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f2940l.m73518z1();
    }

    public int getMargin() {
        return this.f2940l.m73506B1();
    }

    public int getType() {
        return this.f2938j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        this.f2940l = new C12254a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2940l.m73509E1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f2940l.m73511G1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2944d = this.f2940l;
        m3567w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: p */
    public void mo3232p(C0585c.a aVar, C12263j c12263j, ConstraintLayout.LayoutParams layoutParams, SparseArray<C12258e> sparseArray) {
        super.mo3232p(aVar, c12263j, layoutParams, sparseArray);
        if (c12263j instanceof C12254a) {
            C12254a c12254a = (C12254a) c12263j;
            m3555x(c12254a, aVar.f3109e.f3167h0, ((C12259f) c12263j.m73570M()).m73687V1());
            c12254a.m73509E1(aVar.f3109e.f3183p0);
            c12254a.m73511G1(aVar.f3109e.f3169i0);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: q */
    public void mo3233q(C12258e c12258e, boolean z10) {
        m3555x(c12258e, this.f2938j, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f2940l.m73509E1(z10);
    }

    public void setDpMargin(int i10) {
        this.f2940l.m73511G1((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f2940l.m73511G1(i10);
    }

    public void setType(int i10) {
        this.f2938j = i10;
    }

    /* renamed from: x */
    public final void m3555x(C12258e c12258e, int i10, boolean z10) {
        this.f2939k = i10;
        if (z10) {
            int i11 = this.f2938j;
            if (i11 == 5) {
                this.f2939k = 1;
            } else if (i11 == 6) {
                this.f2939k = 0;
            }
        } else {
            int i12 = this.f2938j;
            if (i12 == 5) {
                this.f2939k = 0;
            } else if (i12 == 6) {
                this.f2939k = 1;
            }
        }
        if (c12258e instanceof C12254a) {
            ((C12254a) c12258e).m73510F1(this.f2939k);
        }
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        super.setVisibility(8);
    }
}
