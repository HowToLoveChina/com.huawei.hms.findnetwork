package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a */
    public boolean f1991a;

    /* renamed from: b */
    public int f1992b;

    /* renamed from: c */
    public int f1993c;

    /* renamed from: d */
    public int f1994d;

    /* renamed from: e */
    public int f1995e;

    /* renamed from: f */
    public int f1996f;

    /* renamed from: g */
    public float f1997g;

    /* renamed from: h */
    public boolean f1998h;

    /* renamed from: i */
    public int[] f1999i;

    /* renamed from: j */
    public int[] f2000j;

    /* renamed from: k */
    public Drawable f2001k;

    /* renamed from: l */
    public int f2002l;

    /* renamed from: m */
    public int f2003m;

    /* renamed from: n */
    public int f2004n;

    /* renamed from: o */
    public int f2005o;

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m2702A(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    /* renamed from: l */
    private void m2703l(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View viewM2712s = m2712s(i12);
            if (viewM2712s.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewM2712s.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i13 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = viewM2712s.getMeasuredHeight();
                    measureChildWithMargins(viewM2712s, iMakeMeasureSpec, 0, i11, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i13;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: g */
    public void m2704g(Canvas canvas) {
        int right;
        int left;
        int i10;
        int virtualChildCount = getVirtualChildCount();
        boolean zM3056b = C0535k0.m3056b(this);
        for (int i11 = 0; i11 < virtualChildCount; i11++) {
            View viewM2712s = m2712s(i11);
            if (viewM2712s != null && viewM2712s.getVisibility() != 8 && m2713t(i11)) {
                LayoutParams layoutParams = (LayoutParams) viewM2712s.getLayoutParams();
                m2707j(canvas, zM3056b ? viewM2712s.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (viewM2712s.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f2002l);
            }
        }
        if (m2713t(virtualChildCount)) {
            View viewM2712s2 = m2712s(virtualChildCount - 1);
            if (viewM2712s2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) viewM2712s2.getLayoutParams();
                if (zM3056b) {
                    left = viewM2712s2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i10 = this.f2002l;
                    right = left - i10;
                } else {
                    right = viewM2712s2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (zM3056b) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i10 = this.f2002l;
                right = left - i10;
            }
            m2707j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i10;
        if (this.f1992b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f1992b;
        if (childCount <= i11) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i11);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1992b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1993c;
        if (this.f1994d == 1 && (i10 = this.f1995e & 112) != 48) {
            if (i10 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1996f) / 2;
            } else if (i10 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1996f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1992b;
    }

    public Drawable getDividerDrawable() {
        return this.f2001k;
    }

    public int getDividerPadding() {
        return this.f2005o;
    }

    public int getDividerWidth() {
        return this.f2002l;
    }

    public int getGravity() {
        return this.f1995e;
    }

    public int getOrientation() {
        return this.f1994d;
    }

    public int getShowDividers() {
        return this.f2004n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1997g;
    }

    /* renamed from: h */
    public void m2705h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i10 = 0; i10 < virtualChildCount; i10++) {
            View viewM2712s = m2712s(i10);
            if (viewM2712s != null && viewM2712s.getVisibility() != 8 && m2713t(i10)) {
                m2706i(canvas, (viewM2712s.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) viewM2712s.getLayoutParams())).topMargin) - this.f2003m);
            }
        }
        if (m2713t(virtualChildCount)) {
            View viewM2712s2 = m2712s(virtualChildCount - 1);
            m2706i(canvas, viewM2712s2 == null ? (getHeight() - getPaddingBottom()) - this.f2003m : viewM2712s2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) viewM2712s2.getLayoutParams())).bottomMargin);
        }
    }

    /* renamed from: i */
    public void m2706i(Canvas canvas, int i10) {
        this.f2001k.setBounds(getPaddingLeft() + this.f2005o, i10, (getWidth() - getPaddingRight()) - this.f2005o, this.f2003m + i10);
        this.f2001k.draw(canvas);
    }

    /* renamed from: j */
    public void m2707j(Canvas canvas, int i10) {
        this.f2001k.setBounds(i10, getPaddingTop() + this.f2005o, this.f2002l + i10, (getHeight() - getPaddingBottom()) - this.f2005o);
        this.f2001k.draw(canvas);
    }

    /* renamed from: k */
    public final void m2708k(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View viewM2712s = m2712s(i12);
            if (viewM2712s.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewM2712s.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i13 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = viewM2712s.getMeasuredWidth();
                    measureChildWithMargins(viewM2712s, i11, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i13;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        int i10 = this.f1994d;
        if (i10 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i10 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f2001k == null) {
            return;
        }
        if (this.f1994d == 1) {
            m2705h(canvas);
        } else {
            m2704g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f1994d == 1) {
            m2715v(i10, i11, i12, i13);
        } else {
            m2714u(i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1994d == 1) {
            m2719z(i10, i11);
        } else {
            m2717x(i10, i11);
        }
    }

    /* renamed from: p */
    public int m2709p(View view, int i10) {
        return 0;
    }

    /* renamed from: q */
    public int m2710q(View view) {
        return 0;
    }

    /* renamed from: r */
    public int m2711r(View view) {
        return 0;
    }

    /* renamed from: s */
    public View m2712s(int i10) {
        return getChildAt(i10);
    }

    public void setBaselineAligned(boolean z10) {
        this.f1991a = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 >= 0 && i10 < getChildCount()) {
            this.f1992b = i10;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2001k) {
            return;
        }
        this.f2001k = drawable;
        if (drawable != null) {
            this.f2002l = drawable.getIntrinsicWidth();
            this.f2003m = drawable.getIntrinsicHeight();
        } else {
            this.f2002l = 0;
            this.f2003m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i10) {
        this.f2005o = i10;
    }

    public void setGravity(int i10) {
        if (this.f1995e != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f1995e = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f1995e;
        if ((8388615 & i12) != i11) {
            this.f1995e = i11 | ((-8388616) & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f1998h = z10;
    }

    public void setOrientation(int i10) {
        if (this.f1994d != i10) {
            this.f1994d = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f2004n) {
            requestLayout();
        }
        this.f2004n = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f1995e;
        if ((i12 & 112) != i11) {
            this.f1995e = i11 | (i12 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f1997g = Math.max(0.0f, f10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: t */
    public boolean m2713t(int i10) {
        if (i10 == 0) {
            return (this.f2004n & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.f2004n & 4) != 0;
        }
        if ((this.f2004n & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2714u(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.m2714u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2715v(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f1995e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f1996f
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f1996f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = r1
        L49:
            if (r12 >= r10) goto Lcb
            android.view.View r13 = r6.m2712s(r12)
            r14 = 1
            if (r13 != 0) goto L5a
            int r1 = r6.m2718y(r12)
            int r0 = r0 + r1
        L57:
            r1 = r14
            goto Lc8
        L5a:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L57
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L76
            r1 = r11
        L76:
            int r2 = p273f0.C9603h0.m59832A(r17)
            int r1 = p273f0.C9614n.m60102b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L90
            r2 = 5
            if (r1 == r2) goto L8a
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L88:
            r2 = r1
            goto L9b
        L8a:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
        L8e:
            int r1 = r1 - r2
            goto L88
        L90:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
            goto L8e
        L9b:
            boolean r1 = r6.m2713t(r12)
            if (r1 == 0) goto La4
            int r1 = r6.f2003m
            int r0 = r0 + r1
        La4:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.m2710q(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.m2702A(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.m2711r(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.m2709p(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            r1 = 1
        Lc8:
            int r12 = r12 + r1
            goto L49
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.m2715v(int, int, int, int):void");
    }

    /* renamed from: w */
    public void m2716w(View view, int i10, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d9  */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2717x(int r40, int r41) {
        /*
            Method dump skipped, instructions count: 1293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.m2717x(int, int):void");
    }

    /* renamed from: y */
    public int m2718y(int i10) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x032f  */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2719z(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.m2719z(int, int):void");
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1991a = true;
        this.f1992b = -1;
        this.f1993c = 0;
        this.f1995e = 8388659;
        int[] iArr = R$styleable.LinearLayoutCompat;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        C9603h0.m59898n0(this, context, iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        int iM2957k = c0523e0M2946v.m2957k(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (iM2957k >= 0) {
            setOrientation(iM2957k);
        }
        int iM2957k2 = c0523e0M2946v.m2957k(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (iM2957k2 >= 0) {
            setGravity(iM2957k2);
        }
        boolean zM2947a = c0523e0M2946v.m2947a(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zM2947a) {
            setBaselineAligned(zM2947a);
        }
        this.f1997g = c0523e0M2946v.m2955i(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1992b = c0523e0M2946v.m2957k(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1998h = c0523e0M2946v.m2947a(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(c0523e0M2946v.m2953g(R$styleable.LinearLayoutCompat_divider));
        this.f2004n = c0523e0M2946v.m2957k(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.f2005o = c0523e0M2946v.m2952f(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        c0523e0M2946v.m2966w();
    }
}
