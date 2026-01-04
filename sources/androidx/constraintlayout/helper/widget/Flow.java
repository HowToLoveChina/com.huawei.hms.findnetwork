package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import p561q.C12258e;
import p561q.C12260g;
import p561q.C12263j;
import p561q.C12266m;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: l */
    public C12260g f2507l;

    public Flow(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        this.f2507l = new C12260g();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f2507l.m73728I2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_padding) {
                    this.f2507l.m73785N1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f2507l.m73790S1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f2507l.m73787P1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f2507l.m73788Q1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f2507l.m73791T1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f2507l.m73789R1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f2507l.m73786O1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f2507l.m73733N2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f2507l.m73721C2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f2507l.m73732M2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f2507l.m73742w2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f2507l.m73723E2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f2507l.m73744y2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f2507l.m73725G2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f2507l.m73719A2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f2507l.m73741v2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f2507l.m73722D2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f2507l.m73743x2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f2507l.m73724F2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f2507l.m73730K2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f2507l.m73745z2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f2507l.m73729J2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f2507l.m73720B2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f2507l.m73731L2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f2507l.m73727H2(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2944d = this.f2507l;
        m3567w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i10, int i11) {
        mo3234x(this.f2507l, i10, i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: p */
    public void mo3232p(C0585c.a aVar, C12263j c12263j, ConstraintLayout.LayoutParams layoutParams, SparseArray<C12258e> sparseArray) {
        super.mo3232p(aVar, c12263j, layoutParams, sparseArray);
        if (c12263j instanceof C12260g) {
            C12260g c12260g = (C12260g) c12263j;
            int i10 = layoutParams.f2975Z;
            if (i10 != -1) {
                c12260g.m73728I2(i10);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: q */
    public void mo3233q(C12258e c12258e, boolean z10) {
        this.f2507l.m73792y1(z10);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f2507l.m73741v2(f10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f2507l.m73742w2(i10);
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f2507l.m73743x2(f10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f2507l.m73744y2(i10);
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f2507l.m73745z2(i10);
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f2507l.m73719A2(f10);
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f2507l.m73720B2(i10);
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f2507l.m73721C2(i10);
        requestLayout();
    }

    public void setLastHorizontalBias(float f10) {
        this.f2507l.m73722D2(f10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f2507l.m73723E2(i10);
        requestLayout();
    }

    public void setLastVerticalBias(float f10) {
        this.f2507l.m73724F2(f10);
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f2507l.m73725G2(i10);
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f2507l.m73727H2(i10);
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f2507l.m73728I2(i10);
        requestLayout();
    }

    public void setPadding(int i10) {
        this.f2507l.m73785N1(i10);
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f2507l.m73786O1(i10);
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f2507l.m73788Q1(i10);
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f2507l.m73789R1(i10);
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f2507l.m73791T1(i10);
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f2507l.m73729J2(i10);
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f2507l.m73730K2(f10);
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f2507l.m73731L2(i10);
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f2507l.m73732M2(i10);
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f2507l.m73733N2(i10);
        requestLayout();
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

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
