package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AbstractC0875n;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.C1632c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.AbstractC0846p implements InterfaceC1630a, RecyclerView.AbstractC0855y.b {

    /* renamed from: v0 */
    public static final Rect f7229v0 = new Rect();

    /* renamed from: V */
    public int f7230V;

    /* renamed from: W */
    public int f7231W;

    /* renamed from: X */
    public int f7232X;

    /* renamed from: Y */
    public int f7233Y;

    /* renamed from: Z */
    public int f7234Z;

    /* renamed from: a0 */
    public boolean f7235a0;

    /* renamed from: b0 */
    public boolean f7236b0;

    /* renamed from: c0 */
    public List<C1631b> f7237c0;

    /* renamed from: d0 */
    public final C1632c f7238d0;

    /* renamed from: e0 */
    public RecyclerView.C0852v f7239e0;

    /* renamed from: f0 */
    public RecyclerView.C0856z f7240f0;

    /* renamed from: g0 */
    public C1629c f7241g0;

    /* renamed from: h0 */
    public C1628b f7242h0;

    /* renamed from: i0 */
    public AbstractC0875n f7243i0;

    /* renamed from: j0 */
    public AbstractC0875n f7244j0;

    /* renamed from: k0 */
    public SavedState f7245k0;

    /* renamed from: l0 */
    public int f7246l0;

    /* renamed from: m0 */
    public int f7247m0;

    /* renamed from: n0 */
    public int f7248n0;

    /* renamed from: o0 */
    public int f7249o0;

    /* renamed from: p0 */
    public boolean f7250p0;

    /* renamed from: q0 */
    public SparseArray<View> f7251q0;

    /* renamed from: r0 */
    public final Context f7252r0;

    /* renamed from: s0 */
    public View f7253s0;

    /* renamed from: t0 */
    public int f7254t0;

    /* renamed from: u0 */
    public C1632c.b f7255u0;

    /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$b */
    public class C1628b {

        /* renamed from: a */
        public int f7267a;

        /* renamed from: b */
        public int f7268b;

        /* renamed from: c */
        public int f7269c;

        /* renamed from: d */
        public int f7270d;

        /* renamed from: e */
        public boolean f7271e;

        /* renamed from: f */
        public boolean f7272f;

        /* renamed from: g */
        public boolean f7273g;

        public C1628b() {
            this.f7270d = 0;
        }

        /* renamed from: l */
        public static /* synthetic */ int m9371l(C1628b c1628b, int i10) {
            int i11 = c1628b.f7270d + i10;
            c1628b.f7270d = i11;
            return i11;
        }

        /* renamed from: r */
        public final void m9377r() {
            if (FlexboxLayoutManager.this.mo9286n() || !FlexboxLayoutManager.this.f7235a0) {
                this.f7269c = this.f7271e ? FlexboxLayoutManager.this.f7243i0.mo5556i() : FlexboxLayoutManager.this.f7243i0.mo5561n();
            } else {
                this.f7269c = this.f7271e ? FlexboxLayoutManager.this.f7243i0.mo5556i() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f7243i0.mo5561n();
            }
        }

        /* renamed from: s */
        public final void m9378s(View view) {
            AbstractC0875n abstractC0875n = FlexboxLayoutManager.this.f7231W == 0 ? FlexboxLayoutManager.this.f7244j0 : FlexboxLayoutManager.this.f7243i0;
            if (FlexboxLayoutManager.this.mo9286n() || !FlexboxLayoutManager.this.f7235a0) {
                if (this.f7271e) {
                    this.f7269c = abstractC0875n.mo5551d(view) + abstractC0875n.m5563p();
                } else {
                    this.f7269c = abstractC0875n.mo5554g(view);
                }
            } else if (this.f7271e) {
                this.f7269c = abstractC0875n.mo5554g(view) + abstractC0875n.m5563p();
            } else {
                this.f7269c = abstractC0875n.mo5551d(view);
            }
            this.f7267a = FlexboxLayoutManager.this.getPosition(view);
            this.f7273g = false;
            int[] iArr = FlexboxLayoutManager.this.f7238d0.f7305c;
            int i10 = this.f7267a;
            if (i10 == -1) {
                i10 = 0;
            }
            int i11 = iArr[i10];
            this.f7268b = i11 != -1 ? i11 : 0;
            if (FlexboxLayoutManager.this.f7237c0.size() > this.f7268b) {
                this.f7267a = ((C1631b) FlexboxLayoutManager.this.f7237c0.get(this.f7268b)).f7299o;
            }
        }

        /* renamed from: t */
        public final void m9379t() {
            this.f7267a = -1;
            this.f7268b = -1;
            this.f7269c = Integer.MIN_VALUE;
            this.f7272f = false;
            this.f7273g = false;
            if (FlexboxLayoutManager.this.mo9286n()) {
                if (FlexboxLayoutManager.this.f7231W == 0) {
                    this.f7271e = FlexboxLayoutManager.this.f7230V == 1;
                    return;
                } else {
                    this.f7271e = FlexboxLayoutManager.this.f7231W == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f7231W == 0) {
                this.f7271e = FlexboxLayoutManager.this.f7230V == 3;
            } else {
                this.f7271e = FlexboxLayoutManager.this.f7231W == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f7267a + ", mFlexLinePosition=" + this.f7268b + ", mCoordinate=" + this.f7269c + ", mPerpendicularCoordinate=" + this.f7270d + ", mLayoutFromEnd=" + this.f7271e + ", mValid=" + this.f7272f + ", mAssignedFromSavedState=" + this.f7273g + '}';
        }
    }

    /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$c */
    public static class C1629c {

        /* renamed from: a */
        public int f7275a;

        /* renamed from: b */
        public boolean f7276b;

        /* renamed from: c */
        public int f7277c;

        /* renamed from: d */
        public int f7278d;

        /* renamed from: e */
        public int f7279e;

        /* renamed from: f */
        public int f7280f;

        /* renamed from: g */
        public int f7281g;

        /* renamed from: h */
        public int f7282h;

        /* renamed from: i */
        public int f7283i;

        /* renamed from: j */
        public boolean f7284j;

        public C1629c() {
            this.f7282h = 1;
            this.f7283i = 1;
        }

        /* renamed from: c */
        public static /* synthetic */ int m9385c(C1629c c1629c, int i10) {
            int i11 = c1629c.f7279e + i10;
            c1629c.f7279e = i11;
            return i11;
        }

        /* renamed from: d */
        public static /* synthetic */ int m9386d(C1629c c1629c, int i10) {
            int i11 = c1629c.f7279e - i10;
            c1629c.f7279e = i11;
            return i11;
        }

        /* renamed from: i */
        public static /* synthetic */ int m9391i(C1629c c1629c, int i10) {
            int i11 = c1629c.f7275a - i10;
            c1629c.f7275a = i11;
            return i11;
        }

        /* renamed from: l */
        public static /* synthetic */ int m9394l(C1629c c1629c) {
            int i10 = c1629c.f7277c;
            c1629c.f7277c = i10 + 1;
            return i10;
        }

        /* renamed from: m */
        public static /* synthetic */ int m9395m(C1629c c1629c) {
            int i10 = c1629c.f7277c;
            c1629c.f7277c = i10 - 1;
            return i10;
        }

        /* renamed from: n */
        public static /* synthetic */ int m9396n(C1629c c1629c, int i10) {
            int i11 = c1629c.f7277c + i10;
            c1629c.f7277c = i11;
            return i11;
        }

        /* renamed from: q */
        public static /* synthetic */ int m9399q(C1629c c1629c, int i10) {
            int i11 = c1629c.f7280f + i10;
            c1629c.f7280f = i11;
            return i11;
        }

        /* renamed from: u */
        public static /* synthetic */ int m9403u(C1629c c1629c, int i10) {
            int i11 = c1629c.f7278d + i10;
            c1629c.f7278d = i11;
            return i11;
        }

        /* renamed from: v */
        public static /* synthetic */ int m9404v(C1629c c1629c, int i10) {
            int i11 = c1629c.f7278d - i10;
            c1629c.f7278d = i11;
            return i11;
        }

        /* renamed from: D */
        public final boolean m9409D(RecyclerView.C0856z c0856z, List<C1631b> list) {
            int i10;
            int i11 = this.f7278d;
            return i11 >= 0 && i11 < c0856z.m5305b() && (i10 = this.f7277c) >= 0 && i10 < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f7275a + ", mFlexLinePosition=" + this.f7277c + ", mPosition=" + this.f7278d + ", mOffset=" + this.f7279e + ", mScrollingOffset=" + this.f7280f + ", mLastScrollDelta=" + this.f7281g + ", mItemDirection=" + this.f7282h + ", mLayoutDirection=" + this.f7283i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private void ensureLayoutState() {
        if (this.f7241g0 == null) {
            this.f7241g0 = new C1629c();
        }
    }

    public static boolean isMeasurementUpToDate(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (i12 > 0 && i10 != i12) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i10;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i10;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i10, int i11, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    /* renamed from: A */
    public final View m9308A(int i10, int i11, boolean z10) {
        int i12 = i11 > i10 ? 1 : -1;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (m9319L(childAt, z10)) {
                return childAt;
            }
            i10 += i12;
        }
        return null;
    }

    /* renamed from: B */
    public final View m9309B(int i10, int i11, int i12) {
        int position;
        m9342u();
        ensureLayoutState();
        int iMo5561n = this.f7243i0.mo5561n();
        int iMo5556i = this.f7243i0.mo5556i();
        int i13 = i11 > i10 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i12) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).m5127d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f7243i0.mo5554g(childAt) >= iMo5561n && this.f7243i0.mo5551d(childAt) <= iMo5556i) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i10 += i13;
        }
        return view != null ? view : view2;
    }

    /* renamed from: C */
    public final int m9310C(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    /* renamed from: D */
    public final int m9311D(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    /* renamed from: E */
    public final int m9312E(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    /* renamed from: F */
    public final int m9313F(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    /* renamed from: G */
    public List<C1631b> m9314G() {
        ArrayList arrayList = new ArrayList(this.f7237c0.size());
        int size = this.f7237c0.size();
        for (int i10 = 0; i10 < size; i10++) {
            C1631b c1631b = this.f7237c0.get(i10);
            if (c1631b.m9411b() != 0) {
                arrayList.add(c1631b);
            }
        }
        return arrayList;
    }

    /* renamed from: H */
    public int m9315H(int i10) {
        return this.f7238d0.f7305c[i10];
    }

    /* renamed from: I */
    public final int m9316I(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        m9342u();
        int i11 = 1;
        this.f7241g0.f7284j = true;
        boolean z10 = !mo9286n() && this.f7235a0;
        if (!z10 ? i10 <= 0 : i10 >= 0) {
            i11 = -1;
        }
        int iAbs = Math.abs(i10);
        m9336c0(i11, iAbs);
        int iM9343v = this.f7241g0.f7280f + m9343v(c0852v, c0856z, this.f7241g0);
        if (iM9343v < 0) {
            return 0;
        }
        if (z10) {
            if (iAbs > iM9343v) {
                i10 = (-i11) * iM9343v;
            }
        } else if (iAbs > iM9343v) {
            i10 = i11 * iM9343v;
        }
        this.f7243i0.mo5566s(-i10);
        this.f7241g0.f7281g = i10;
        return i10;
    }

    /* renamed from: J */
    public final int m9317J(int i10) {
        int i11;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        m9342u();
        boolean zMo9286n = mo9286n();
        View view = this.f7253s0;
        int width = zMo9286n ? view.getWidth() : view.getHeight();
        int width2 = zMo9286n ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i10);
            if (i10 < 0) {
                return -Math.min((width2 + this.f7242h0.f7270d) - width, iAbs);
            }
            if (this.f7242h0.f7270d + i10 > 0) {
                i11 = this.f7242h0.f7270d;
                i10 = -i11;
            }
        } else {
            if (i10 > 0) {
                return Math.min((width2 - this.f7242h0.f7270d) - width, i10);
            }
            if (this.f7242h0.f7270d + i10 < 0) {
                i11 = this.f7242h0.f7270d;
                i10 = -i11;
            }
        }
        return i10;
    }

    /* renamed from: K */
    public boolean m9318K() {
        return this.f7235a0;
    }

    /* renamed from: L */
    public final boolean m9319L(View view, boolean z10) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iM9311D = m9311D(view);
        int iM9313F = m9313F(view);
        int iM9312E = m9312E(view);
        int iM9310C = m9310C(view);
        return z10 ? (paddingLeft <= iM9311D && width >= iM9312E) && (paddingTop <= iM9313F && height >= iM9310C) : (iM9311D >= width || iM9312E >= paddingLeft) && (iM9313F >= height || iM9310C >= paddingTop);
    }

    /* renamed from: M */
    public final int m9320M(C1631b c1631b, C1629c c1629c) {
        return mo9286n() ? m9321N(c1631b, c1629c) : m9322O(c1631b, c1629c);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m9321N(com.google.android.flexbox.C1631b r22, com.google.android.flexbox.FlexboxLayoutManager.C1629c r23) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.m9321N(com.google.android.flexbox.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m9322O(com.google.android.flexbox.C1631b r26, com.google.android.flexbox.FlexboxLayoutManager.C1629c r27) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.m9322O(com.google.android.flexbox.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* renamed from: P */
    public final void m9323P(RecyclerView.C0852v c0852v, C1629c c1629c) {
        if (c1629c.f7284j) {
            if (c1629c.f7283i == -1) {
                m9324Q(c0852v, c1629c);
            } else {
                m9325R(c0852v, c1629c);
            }
        }
    }

    /* renamed from: Q */
    public final void m9324Q(RecyclerView.C0852v c0852v, C1629c c1629c) {
        int childCount;
        int i10;
        View childAt;
        int i11;
        if (c1629c.f7280f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i11 = this.f7238d0.f7305c[getPosition(childAt)]) == -1) {
            return;
        }
        C1631b c1631b = this.f7237c0.get(i11);
        int i12 = i10;
        while (true) {
            if (i12 < 0) {
                break;
            }
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!m9339r(childAt2, c1629c.f7280f)) {
                    break;
                }
                if (c1631b.f7299o != getPosition(childAt2)) {
                    continue;
                } else if (i11 <= 0) {
                    childCount = i12;
                    break;
                } else {
                    i11 += c1629c.f7283i;
                    c1631b = this.f7237c0.get(i11);
                    childCount = i12;
                }
            }
            i12--;
        }
        recycleChildren(c0852v, childCount, i10);
    }

    /* renamed from: R */
    public final void m9325R(RecyclerView.C0852v c0852v, C1629c c1629c) {
        int childCount;
        View childAt;
        if (c1629c.f7280f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i10 = this.f7238d0.f7305c[getPosition(childAt)];
        int i11 = -1;
        if (i10 == -1) {
            return;
        }
        C1631b c1631b = this.f7237c0.get(i10);
        int i12 = 0;
        while (true) {
            if (i12 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!m9340s(childAt2, c1629c.f7280f)) {
                    break;
                }
                if (c1631b.f7300p != getPosition(childAt2)) {
                    continue;
                } else if (i10 >= this.f7237c0.size() - 1) {
                    i11 = i12;
                    break;
                } else {
                    i10 += c1629c.f7283i;
                    c1631b = this.f7237c0.get(i10);
                    i11 = i12;
                }
            }
            i12++;
        }
        recycleChildren(c0852v, 0, i11);
    }

    /* renamed from: S */
    public final void m9326S() {
        int heightMode = mo9286n() ? getHeightMode() : getWidthMode();
        this.f7241g0.f7276b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    /* renamed from: T */
    public final void m9327T() {
        int layoutDirection = getLayoutDirection();
        int i10 = this.f7230V;
        if (i10 == 0) {
            this.f7235a0 = layoutDirection == 1;
            this.f7236b0 = this.f7231W == 2;
            return;
        }
        if (i10 == 1) {
            this.f7235a0 = layoutDirection != 1;
            this.f7236b0 = this.f7231W == 2;
            return;
        }
        if (i10 == 2) {
            boolean z10 = layoutDirection == 1;
            this.f7235a0 = z10;
            if (this.f7231W == 2) {
                this.f7235a0 = !z10;
            }
            this.f7236b0 = false;
            return;
        }
        if (i10 != 3) {
            this.f7235a0 = false;
            this.f7236b0 = false;
            return;
        }
        boolean z11 = layoutDirection == 1;
        this.f7235a0 = z11;
        if (this.f7231W == 2) {
            this.f7235a0 = !z11;
        }
        this.f7236b0 = true;
    }

    /* renamed from: U */
    public void m9328U(int i10) {
        int i11 = this.f7233Y;
        if (i11 != i10) {
            if (i11 == 4 || i10 == 4) {
                removeAllViews();
                m9341t();
            }
            this.f7233Y = i10;
            requestLayout();
        }
    }

    /* renamed from: V */
    public void m9329V(int i10) {
        if (this.f7230V != i10) {
            removeAllViews();
            this.f7230V = i10;
            this.f7243i0 = null;
            this.f7244j0 = null;
            m9341t();
            requestLayout();
        }
    }

    /* renamed from: W */
    public void m9330W(int i10) {
        if (i10 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i11 = this.f7231W;
        if (i11 != i10) {
            if (i11 == 0 || i10 == 0) {
                removeAllViews();
                m9341t();
            }
            this.f7231W = i10;
            this.f7243i0 = null;
            this.f7244j0 = null;
            requestLayout();
        }
    }

    /* renamed from: X */
    public final boolean m9331X(RecyclerView.C0856z c0856z, C1628b c1628b) {
        if (getChildCount() == 0) {
            return false;
        }
        View viewM9346y = c1628b.f7271e ? m9346y(c0856z.m5305b()) : m9344w(c0856z.m5305b());
        if (viewM9346y == null) {
            return false;
        }
        c1628b.m9378s(viewM9346y);
        if (c0856z.m5308e() || !supportsPredictiveItemAnimations()) {
            return true;
        }
        if (this.f7243i0.mo5554g(viewM9346y) < this.f7243i0.mo5556i() && this.f7243i0.mo5551d(viewM9346y) >= this.f7243i0.mo5561n()) {
            return true;
        }
        c1628b.f7269c = c1628b.f7271e ? this.f7243i0.mo5556i() : this.f7243i0.mo5561n();
        return true;
    }

    /* renamed from: Y */
    public final boolean m9332Y(RecyclerView.C0856z c0856z, C1628b c1628b, SavedState savedState) {
        int i10;
        View childAt;
        if (!c0856z.m5308e() && (i10 = this.f7246l0) != -1) {
            if (i10 >= 0 && i10 < c0856z.m5305b()) {
                c1628b.f7267a = this.f7246l0;
                c1628b.f7268b = this.f7238d0.f7305c[c1628b.f7267a];
                SavedState savedState2 = this.f7245k0;
                if (savedState2 != null && savedState2.m9356h(c0856z.m5305b())) {
                    c1628b.f7269c = this.f7243i0.mo5561n() + savedState.f7266b;
                    c1628b.f7273g = true;
                    c1628b.f7268b = -1;
                    return true;
                }
                if (this.f7247m0 != Integer.MIN_VALUE) {
                    if (mo9286n() || !this.f7235a0) {
                        c1628b.f7269c = this.f7243i0.mo5561n() + this.f7247m0;
                    } else {
                        c1628b.f7269c = this.f7247m0 - this.f7243i0.mo5557j();
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.f7246l0);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        c1628b.f7271e = this.f7246l0 < getPosition(childAt);
                    }
                    c1628b.m9377r();
                } else {
                    if (this.f7243i0.mo5552e(viewFindViewByPosition) > this.f7243i0.mo5562o()) {
                        c1628b.m9377r();
                        return true;
                    }
                    if (this.f7243i0.mo5554g(viewFindViewByPosition) - this.f7243i0.mo5561n() < 0) {
                        c1628b.f7269c = this.f7243i0.mo5561n();
                        c1628b.f7271e = false;
                        return true;
                    }
                    if (this.f7243i0.mo5556i() - this.f7243i0.mo5551d(viewFindViewByPosition) < 0) {
                        c1628b.f7269c = this.f7243i0.mo5556i();
                        c1628b.f7271e = true;
                        return true;
                    }
                    c1628b.f7269c = c1628b.f7271e ? this.f7243i0.mo5551d(viewFindViewByPosition) + this.f7243i0.m5563p() : this.f7243i0.mo5554g(viewFindViewByPosition);
                }
                return true;
            }
            this.f7246l0 = -1;
            this.f7247m0 = Integer.MIN_VALUE;
        }
        return false;
    }

    /* renamed from: Z */
    public final void m9333Z(RecyclerView.C0856z c0856z, C1628b c1628b) {
        if (m9332Y(c0856z, c1628b, this.f7245k0) || m9331X(c0856z, c1628b)) {
            return;
        }
        c1628b.m9377r();
        c1628b.f7267a = 0;
        c1628b.f7268b = 0;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: a */
    public void mo9273a(View view, int i10, int i11, C1631b c1631b) {
        calculateItemDecorationsForChild(view, f7229v0);
        if (mo9286n()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            c1631b.f7289e += leftDecorationWidth;
            c1631b.f7290f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            c1631b.f7289e += topDecorationHeight;
            c1631b.f7290f += topDecorationHeight;
        }
    }

    /* renamed from: a0 */
    public final void m9334a0(int i10) {
        if (i10 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f7238d0.m9459t(childCount);
        this.f7238d0.m9460u(childCount);
        this.f7238d0.m9458s(childCount);
        if (i10 >= this.f7238d0.f7305c.length) {
            return;
        }
        this.f7254t0 = i10;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.f7246l0 = getPosition(childClosestToStart);
        if (mo9286n() || !this.f7235a0) {
            this.f7247m0 = this.f7243i0.mo5554g(childClosestToStart) - this.f7243i0.mo5561n();
        } else {
            this.f7247m0 = this.f7243i0.mo5551d(childClosestToStart) + this.f7243i0.mo5557j();
        }
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: b */
    public void mo9274b(C1631b c1631b) {
    }

    /* renamed from: b0 */
    public final void m9335b0(int i10) {
        int i11;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z10 = false;
        if (mo9286n()) {
            int i12 = this.f7248n0;
            if (i12 != Integer.MIN_VALUE && i12 != width) {
                z10 = true;
            }
            i11 = this.f7241g0.f7276b ? this.f7252r0.getResources().getDisplayMetrics().heightPixels : this.f7241g0.f7275a;
        } else {
            int i13 = this.f7249o0;
            if (i13 != Integer.MIN_VALUE && i13 != height) {
                z10 = true;
            }
            i11 = this.f7241g0.f7276b ? this.f7252r0.getResources().getDisplayMetrics().widthPixels : this.f7241g0.f7275a;
        }
        int i14 = i11;
        this.f7248n0 = width;
        this.f7249o0 = height;
        int i15 = this.f7254t0;
        if (i15 == -1 && (this.f7246l0 != -1 || z10)) {
            if (this.f7242h0.f7271e) {
                return;
            }
            this.f7237c0.clear();
            this.f7255u0.m9466a();
            if (mo9286n()) {
                this.f7238d0.m9444e(this.f7255u0, iMakeMeasureSpec, iMakeMeasureSpec2, i14, this.f7242h0.f7267a, this.f7237c0);
            } else {
                this.f7238d0.m9447h(this.f7255u0, iMakeMeasureSpec, iMakeMeasureSpec2, i14, this.f7242h0.f7267a, this.f7237c0);
            }
            this.f7237c0 = this.f7255u0.f7308a;
            this.f7238d0.m9455p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.f7238d0.m9437X();
            C1628b c1628b = this.f7242h0;
            c1628b.f7268b = this.f7238d0.f7305c[c1628b.f7267a];
            this.f7241g0.f7277c = this.f7242h0.f7268b;
            return;
        }
        int iMin = i15 != -1 ? Math.min(i15, this.f7242h0.f7267a) : this.f7242h0.f7267a;
        this.f7255u0.m9466a();
        if (mo9286n()) {
            if (this.f7237c0.size() > 0) {
                this.f7238d0.m9449j(this.f7237c0, iMin);
                this.f7238d0.m9441b(this.f7255u0, iMakeMeasureSpec, iMakeMeasureSpec2, i14, iMin, this.f7242h0.f7267a, this.f7237c0);
            } else {
                this.f7238d0.m9458s(i10);
                this.f7238d0.m9443d(this.f7255u0, iMakeMeasureSpec, iMakeMeasureSpec2, i14, 0, this.f7237c0);
            }
        } else if (this.f7237c0.size() > 0) {
            this.f7238d0.m9449j(this.f7237c0, iMin);
            this.f7238d0.m9441b(this.f7255u0, iMakeMeasureSpec2, iMakeMeasureSpec, i14, iMin, this.f7242h0.f7267a, this.f7237c0);
        } else {
            this.f7238d0.m9458s(i10);
            this.f7238d0.m9446g(this.f7255u0, iMakeMeasureSpec, iMakeMeasureSpec2, i14, 0, this.f7237c0);
        }
        this.f7237c0 = this.f7255u0.f7308a;
        this.f7238d0.m9456q(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
        this.f7238d0.m9438Y(iMin);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: c */
    public View mo9275c(int i10) {
        return mo9278f(i10);
    }

    /* renamed from: c0 */
    public final void m9336c0(int i10, int i11) {
        this.f7241g0.f7283i = i10;
        boolean zMo9286n = mo9286n();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z10 = !zMo9286n && this.f7235a0;
        if (i10 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f7241g0.f7279e = this.f7243i0.mo5551d(childAt);
            int position = getPosition(childAt);
            View viewM9347z = m9347z(childAt, this.f7237c0.get(this.f7238d0.f7305c[position]));
            this.f7241g0.f7282h = 1;
            C1629c c1629c = this.f7241g0;
            c1629c.f7278d = position + c1629c.f7282h;
            if (this.f7238d0.f7305c.length <= this.f7241g0.f7278d) {
                this.f7241g0.f7277c = -1;
            } else {
                C1629c c1629c2 = this.f7241g0;
                c1629c2.f7277c = this.f7238d0.f7305c[c1629c2.f7278d];
            }
            if (z10) {
                this.f7241g0.f7279e = this.f7243i0.mo5554g(viewM9347z);
                this.f7241g0.f7280f = (-this.f7243i0.mo5554g(viewM9347z)) + this.f7243i0.mo5561n();
                C1629c c1629c3 = this.f7241g0;
                c1629c3.f7280f = Math.max(c1629c3.f7280f, 0);
            } else {
                this.f7241g0.f7279e = this.f7243i0.mo5551d(viewM9347z);
                this.f7241g0.f7280f = this.f7243i0.mo5551d(viewM9347z) - this.f7243i0.mo5556i();
            }
            if ((this.f7241g0.f7277c == -1 || this.f7241g0.f7277c > this.f7237c0.size() - 1) && this.f7241g0.f7278d <= getFlexItemCount()) {
                int i12 = i11 - this.f7241g0.f7280f;
                this.f7255u0.m9466a();
                if (i12 > 0) {
                    if (zMo9286n) {
                        this.f7238d0.m9443d(this.f7255u0, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f7241g0.f7278d, this.f7237c0);
                    } else {
                        this.f7238d0.m9446g(this.f7255u0, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f7241g0.f7278d, this.f7237c0);
                    }
                    this.f7238d0.m9456q(iMakeMeasureSpec, iMakeMeasureSpec2, this.f7241g0.f7278d);
                    this.f7238d0.m9438Y(this.f7241g0.f7278d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f7241g0.f7279e = this.f7243i0.mo5554g(childAt2);
            int position2 = getPosition(childAt2);
            View viewM9345x = m9345x(childAt2, this.f7237c0.get(this.f7238d0.f7305c[position2]));
            this.f7241g0.f7282h = 1;
            int i13 = this.f7238d0.f7305c[position2];
            if (i13 == -1) {
                i13 = 0;
            }
            if (i13 > 0) {
                this.f7241g0.f7278d = position2 - this.f7237c0.get(i13 - 1).m9411b();
            } else {
                this.f7241g0.f7278d = -1;
            }
            this.f7241g0.f7277c = i13 > 0 ? i13 - 1 : 0;
            if (z10) {
                this.f7241g0.f7279e = this.f7243i0.mo5551d(viewM9345x);
                this.f7241g0.f7280f = this.f7243i0.mo5551d(viewM9345x) - this.f7243i0.mo5556i();
                C1629c c1629c4 = this.f7241g0;
                c1629c4.f7280f = Math.max(c1629c4.f7280f, 0);
            } else {
                this.f7241g0.f7279e = this.f7243i0.mo5554g(viewM9345x);
                this.f7241g0.f7280f = (-this.f7243i0.mo5554g(viewM9345x)) + this.f7243i0.mo5561n();
            }
        }
        C1629c c1629c5 = this.f7241g0;
        c1629c5.f7275a = i11 - c1629c5.f7280f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollHorizontally() {
        if (this.f7231W == 0) {
            return mo9286n();
        }
        if (mo9286n()) {
            int width = getWidth();
            View view = this.f7253s0;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollVertically() {
        if (this.f7231W == 0) {
            return !mo9286n();
        }
        if (mo9286n()) {
            return true;
        }
        int height = getHeight();
        View view = this.f7253s0;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollExtent(RecyclerView.C0856z c0856z) {
        return computeScrollExtent(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollOffset(RecyclerView.C0856z c0856z) {
        return computeScrollOffset(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollRange(RecyclerView.C0856z c0856z) {
        return computeScrollRange(c0856z);
    }

    public final int computeScrollExtent(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iM5305b = c0856z.m5305b();
        m9342u();
        View viewM9344w = m9344w(iM5305b);
        View viewM9346y = m9346y(iM5305b);
        if (c0856z.m5305b() == 0 || viewM9344w == null || viewM9346y == null) {
            return 0;
        }
        return Math.min(this.f7243i0.mo5562o(), this.f7243i0.mo5551d(viewM9346y) - this.f7243i0.mo5554g(viewM9344w));
    }

    public final int computeScrollOffset(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iM5305b = c0856z.m5305b();
        View viewM9344w = m9344w(iM5305b);
        View viewM9346y = m9346y(iM5305b);
        if (c0856z.m5305b() != 0 && viewM9344w != null && viewM9346y != null) {
            int position = getPosition(viewM9344w);
            int position2 = getPosition(viewM9346y);
            int iAbs = Math.abs(this.f7243i0.mo5551d(viewM9346y) - this.f7243i0.mo5554g(viewM9344w));
            int i10 = this.f7238d0.f7305c[position];
            if (i10 != 0 && i10 != -1) {
                return Math.round((i10 * (iAbs / ((r4[position2] - i10) + 1))) + (this.f7243i0.mo5561n() - this.f7243i0.mo5554g(viewM9344w)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        int iM5305b = c0856z.m5305b();
        View viewM9344w = m9344w(iM5305b);
        View viewM9346y = m9346y(iM5305b);
        if (c0856z.m5305b() == 0 || viewM9344w == null || viewM9346y == null) {
            return 0;
        }
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.f7243i0.mo5551d(viewM9346y) - this.f7243i0.mo5554g(viewM9344w)) / ((findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1)) * c0856z.m5305b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0855y.b
    public PointF computeScrollVectorForPosition(int i10) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i11 = i10 < getPosition(childAt) ? -1 : 1;
        return mo9286n() ? new PointF(0.0f, i11) : new PointF(i11, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollExtent(RecyclerView.C0856z c0856z) {
        return computeScrollExtent(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollOffset(RecyclerView.C0856z c0856z) {
        return computeScrollOffset(c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollRange(RecyclerView.C0856z c0856z) {
        return computeScrollRange(c0856z);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: d */
    public int mo9276d(int i10, int i11, int i12) {
        return RecyclerView.AbstractC0846p.getChildMeasureSpec(getWidth(), getWidthMode(), i11, i12, canScrollHorizontally());
    }

    /* renamed from: d0 */
    public final void m9337d0(C1628b c1628b, boolean z10, boolean z11) {
        if (z11) {
            m9326S();
        } else {
            this.f7241g0.f7276b = false;
        }
        if (mo9286n() || !this.f7235a0) {
            this.f7241g0.f7275a = this.f7243i0.mo5556i() - c1628b.f7269c;
        } else {
            this.f7241g0.f7275a = c1628b.f7269c - getPaddingRight();
        }
        this.f7241g0.f7278d = c1628b.f7267a;
        this.f7241g0.f7282h = 1;
        this.f7241g0.f7283i = 1;
        this.f7241g0.f7279e = c1628b.f7269c;
        this.f7241g0.f7280f = Integer.MIN_VALUE;
        this.f7241g0.f7277c = c1628b.f7268b;
        if (!z10 || this.f7237c0.size() <= 1 || c1628b.f7268b < 0 || c1628b.f7268b >= this.f7237c0.size() - 1) {
            return;
        }
        C1631b c1631b = this.f7237c0.get(c1628b.f7268b);
        C1629c.m9394l(this.f7241g0);
        C1629c.m9403u(this.f7241g0, c1631b.m9411b());
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: e */
    public void mo9277e(int i10, View view) {
        this.f7251q0.put(i10, view);
    }

    /* renamed from: e0 */
    public final void m9338e0(C1628b c1628b, boolean z10, boolean z11) {
        if (z11) {
            m9326S();
        } else {
            this.f7241g0.f7276b = false;
        }
        if (mo9286n() || !this.f7235a0) {
            this.f7241g0.f7275a = c1628b.f7269c - this.f7243i0.mo5561n();
        } else {
            this.f7241g0.f7275a = (this.f7253s0.getWidth() - c1628b.f7269c) - this.f7243i0.mo5561n();
        }
        this.f7241g0.f7278d = c1628b.f7267a;
        this.f7241g0.f7282h = 1;
        this.f7241g0.f7283i = -1;
        this.f7241g0.f7279e = c1628b.f7269c;
        this.f7241g0.f7280f = Integer.MIN_VALUE;
        this.f7241g0.f7277c = c1628b.f7268b;
        if (!z10 || c1628b.f7268b <= 0 || this.f7237c0.size() <= c1628b.f7268b) {
            return;
        }
        C1631b c1631b = this.f7237c0.get(c1628b.f7268b);
        C1629c.m9395m(this.f7241g0);
        C1629c.m9404v(this.f7241g0, c1631b.m9411b());
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: f */
    public View mo9278f(int i10) {
        View view = this.f7251q0.get(i10);
        return view != null ? view : this.f7239e0.m5285o(i10);
    }

    public int findFirstVisibleItemPosition() {
        View viewM9308A = m9308A(0, getChildCount(), false);
        if (viewM9308A == null) {
            return -1;
        }
        return getPosition(viewM9308A);
    }

    public int findLastVisibleItemPosition() {
        View viewM9308A = m9308A(getChildCount() - 1, -1, false);
        if (viewM9308A == null) {
            return -1;
        }
        return getPosition(viewM9308A);
    }

    public final int fixLayoutEndGap(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iM9316I;
        int iMo5556i;
        if (mo9286n() || !this.f7235a0) {
            int iMo5556i2 = this.f7243i0.mo5556i() - i10;
            if (iMo5556i2 <= 0) {
                return 0;
            }
            iM9316I = -m9316I(-iMo5556i2, c0852v, c0856z);
        } else {
            int iMo5561n = i10 - this.f7243i0.mo5561n();
            if (iMo5561n <= 0) {
                return 0;
            }
            iM9316I = m9316I(iMo5561n, c0852v, c0856z);
        }
        int i11 = i10 + iM9316I;
        if (!z10 || (iMo5556i = this.f7243i0.mo5556i() - i11) <= 0) {
            return iM9316I;
        }
        this.f7243i0.mo5566s(iMo5556i);
        return iMo5556i + iM9316I;
    }

    public final int fixLayoutStartGap(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iM9316I;
        int iMo5561n;
        if (mo9286n() || !this.f7235a0) {
            int iMo5561n2 = i10 - this.f7243i0.mo5561n();
            if (iMo5561n2 <= 0) {
                return 0;
            }
            iM9316I = -m9316I(iMo5561n2, c0852v, c0856z);
        } else {
            int iMo5556i = this.f7243i0.mo5556i() - i10;
            if (iMo5556i <= 0) {
                return 0;
            }
            iM9316I = m9316I(-iMo5556i, c0852v, c0856z);
        }
        int i11 = i10 + iM9316I;
        if (!z10 || (iMo5561n = i11 - this.f7243i0.mo5561n()) <= 0) {
            return iM9316I;
        }
        this.f7243i0.mo5566s(-iMo5561n);
        return iM9316I - iMo5561n;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: g */
    public int mo9279g(View view, int i10, int i11) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (mo9286n()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getAlignItems() {
        return this.f7233Y;
    }

    public final View getChildClosestToStart() {
        return getChildAt(0);
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getFlexDirection() {
        return this.f7230V;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getFlexItemCount() {
        return this.f7240f0.m5305b();
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public List<C1631b> getFlexLinesInternal() {
        return this.f7237c0;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getFlexWrap() {
        return this.f7231W;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getLargestMainSize() {
        if (this.f7237c0.size() == 0) {
            return 0;
        }
        int size = this.f7237c0.size();
        int iMax = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            iMax = Math.max(iMax, this.f7237c0.get(i10).f7289e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getMaxLine() {
        return this.f7234Z;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public int getSumOfCrossSize() {
        int size = this.f7237c0.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += this.f7237c0.get(i11).f7291g;
        }
        return i10;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: h */
    public int mo9280h(int i10, int i11, int i12) {
        return RecyclerView.AbstractC0846p.getChildMeasureSpec(getHeight(), getHeightMode(), i11, i12, canScrollVertically());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: n */
    public boolean mo9286n() {
        int i10 = this.f7230V;
        return i10 == 0 || i10 == 1;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    /* renamed from: o */
    public int mo9287o(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (mo9286n()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onAdapterChanged(RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0838h abstractC0838h2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f7253s0 = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0852v c0852v) {
        super.onDetachedFromWindow(recyclerView, c0852v);
        if (this.f7250p0) {
            removeAndRecycleAllViews(c0852v);
            c0852v.m5273c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        m9334a0(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        super.onItemsMoved(recyclerView, i10, i11, i12);
        m9334a0(Math.min(i10, i11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        m9334a0(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        super.onItemsUpdated(recyclerView, i10, i11, obj);
        m9334a0(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        int i10;
        int i11;
        this.f7239e0 = c0852v;
        this.f7240f0 = c0856z;
        int iM5305b = c0856z.m5305b();
        if (iM5305b == 0 && c0856z.m5308e()) {
            return;
        }
        m9327T();
        m9342u();
        ensureLayoutState();
        this.f7238d0.m9459t(iM5305b);
        this.f7238d0.m9460u(iM5305b);
        this.f7238d0.m9458s(iM5305b);
        this.f7241g0.f7284j = false;
        SavedState savedState = this.f7245k0;
        if (savedState != null && savedState.m9356h(iM5305b)) {
            this.f7246l0 = this.f7245k0.f7265a;
        }
        if (!this.f7242h0.f7272f || this.f7246l0 != -1 || this.f7245k0 != null) {
            this.f7242h0.m9379t();
            m9333Z(c0856z, this.f7242h0);
            this.f7242h0.f7272f = true;
        }
        detachAndScrapAttachedViews(c0852v);
        if (this.f7242h0.f7271e) {
            m9338e0(this.f7242h0, false, true);
        } else {
            m9337d0(this.f7242h0, false, true);
        }
        m9335b0(iM5305b);
        m9343v(c0852v, c0856z, this.f7241g0);
        if (this.f7242h0.f7271e) {
            i11 = this.f7241g0.f7279e;
            m9337d0(this.f7242h0, true, false);
            m9343v(c0852v, c0856z, this.f7241g0);
            i10 = this.f7241g0.f7279e;
        } else {
            i10 = this.f7241g0.f7279e;
            m9338e0(this.f7242h0, true, false);
            m9343v(c0852v, c0856z, this.f7241g0);
            i11 = this.f7241g0.f7279e;
        }
        if (getChildCount() > 0) {
            if (this.f7242h0.f7271e) {
                fixLayoutStartGap(i11 + fixLayoutEndGap(i10, c0852v, c0856z, true), c0852v, c0856z, false);
            } else {
                fixLayoutEndGap(i10 + fixLayoutStartGap(i11, c0852v, c0856z, true), c0852v, c0856z, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutCompleted(RecyclerView.C0856z c0856z) {
        super.onLayoutCompleted(c0856z);
        this.f7245k0 = null;
        this.f7246l0 = -1;
        this.f7247m0 = Integer.MIN_VALUE;
        this.f7254t0 = -1;
        this.f7242h0.m9379t();
        this.f7251q0.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f7245k0 = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public Parcelable onSaveInstanceState() {
        if (this.f7245k0 != null) {
            return new SavedState(this.f7245k0);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.f7265a = getPosition(childClosestToStart);
            savedState.f7266b = this.f7243i0.mo5554g(childClosestToStart) - this.f7243i0.mo5561n();
        } else {
            savedState.m9357i();
        }
        return savedState;
    }

    /* renamed from: r */
    public final boolean m9339r(View view, int i10) {
        return (mo9286n() || !this.f7235a0) ? this.f7243i0.mo5554g(view) >= this.f7243i0.mo5555h() - i10 : this.f7243i0.mo5551d(view) <= i10;
    }

    public final void recycleChildren(RecyclerView.C0852v c0852v, int i10, int i11) {
        while (i11 >= i10) {
            removeAndRecycleViewAt(i11, c0852v);
            i11--;
        }
    }

    /* renamed from: s */
    public final boolean m9340s(View view, int i10) {
        return (mo9286n() || !this.f7235a0) ? this.f7243i0.mo5551d(view) <= i10 : this.f7243i0.mo5555h() - this.f7243i0.mo5554g(view) <= i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollHorizontallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (!mo9286n() || this.f7231W == 0) {
            int iM9316I = m9316I(i10, c0852v, c0856z);
            this.f7251q0.clear();
            return iM9316I;
        }
        int iM9317J = m9317J(i10);
        C1628b.m9371l(this.f7242h0, iM9317J);
        this.f7244j0.mo5566s(-iM9317J);
        return iM9317J;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void scrollToPosition(int i10) {
        this.f7246l0 = i10;
        this.f7247m0 = Integer.MIN_VALUE;
        SavedState savedState = this.f7245k0;
        if (savedState != null) {
            savedState.m9357i();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollVerticallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (mo9286n() || (this.f7231W == 0 && !mo9286n())) {
            int iM9316I = m9316I(i10, c0852v, c0856z);
            this.f7251q0.clear();
            return iM9316I;
        }
        int iM9317J = m9317J(i10);
        C1628b.m9371l(this.f7242h0, iM9317J);
        this.f7244j0.mo5566s(-iM9317J);
        return iM9317J;
    }

    @Override // com.google.android.flexbox.InterfaceC1630a
    public void setFlexLines(List<C1631b> list) {
        this.f7237c0 = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0856z c0856z, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    /* renamed from: t */
    public final void m9341t() {
        this.f7237c0.clear();
        this.f7242h0.m9379t();
        this.f7242h0.f7270d = 0;
    }

    /* renamed from: u */
    public final void m9342u() {
        if (this.f7243i0 != null) {
            return;
        }
        if (mo9286n()) {
            if (this.f7231W == 0) {
                this.f7243i0 = AbstractC0875n.m5548a(this);
                this.f7244j0 = AbstractC0875n.m5550c(this);
                return;
            } else {
                this.f7243i0 = AbstractC0875n.m5550c(this);
                this.f7244j0 = AbstractC0875n.m5548a(this);
                return;
            }
        }
        if (this.f7231W == 0) {
            this.f7243i0 = AbstractC0875n.m5550c(this);
            this.f7244j0 = AbstractC0875n.m5548a(this);
        } else {
            this.f7243i0 = AbstractC0875n.m5548a(this);
            this.f7244j0 = AbstractC0875n.m5550c(this);
        }
    }

    /* renamed from: v */
    public final int m9343v(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, C1629c c1629c) {
        if (c1629c.f7280f != Integer.MIN_VALUE) {
            if (c1629c.f7275a < 0) {
                C1629c.m9399q(c1629c, c1629c.f7275a);
            }
            m9323P(c0852v, c1629c);
        }
        int i10 = c1629c.f7275a;
        int iM9410a = c1629c.f7275a;
        boolean zMo9286n = mo9286n();
        int iM9320M = 0;
        while (true) {
            if ((iM9410a <= 0 && !this.f7241g0.f7276b) || !c1629c.m9409D(c0856z, this.f7237c0)) {
                break;
            }
            C1631b c1631b = this.f7237c0.get(c1629c.f7277c);
            c1629c.f7278d = c1631b.f7299o;
            iM9320M += m9320M(c1631b, c1629c);
            if (zMo9286n || !this.f7235a0) {
                C1629c.m9385c(c1629c, c1631b.m9410a() * c1629c.f7283i);
            } else {
                C1629c.m9386d(c1629c, c1631b.m9410a() * c1629c.f7283i);
            }
            iM9410a -= c1631b.m9410a();
        }
        C1629c.m9391i(c1629c, iM9320M);
        if (c1629c.f7280f != Integer.MIN_VALUE) {
            C1629c.m9399q(c1629c, iM9320M);
            if (c1629c.f7275a < 0) {
                C1629c.m9399q(c1629c, c1629c.f7275a);
            }
            m9323P(c0852v, c1629c);
        }
        return i10 - c1629c.f7275a;
    }

    /* renamed from: w */
    public final View m9344w(int i10) {
        View viewM9309B = m9309B(0, getChildCount(), i10);
        if (viewM9309B == null) {
            return null;
        }
        int i11 = this.f7238d0.f7305c[getPosition(viewM9309B)];
        if (i11 == -1) {
            return null;
        }
        return m9345x(viewM9309B, this.f7237c0.get(i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View m9345x(android.view.View r6, com.google.android.flexbox.C1631b r7) {
        /*
            r5 = this;
            boolean r0 = r5.mo9286n()
            int r7 = r7.f7292h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.getChildAt(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.f7235a0
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.n r3 = r5.f7243i0
            int r3 = r3.mo5551d(r6)
            androidx.recyclerview.widget.n r4 = r5.f7243i0
            int r4 = r4.mo5551d(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.n r3 = r5.f7243i0
            int r3 = r3.mo5554g(r6)
            androidx.recyclerview.widget.n r4 = r5.f7243i0
            int r4 = r4.mo5554g(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.m9345x(android.view.View, com.google.android.flexbox.b):android.view.View");
    }

    /* renamed from: y */
    public final View m9346y(int i10) {
        View viewM9309B = m9309B(getChildCount() - 1, -1, i10);
        if (viewM9309B == null) {
            return null;
        }
        return m9347z(viewM9309B, this.f7237c0.get(this.f7238d0.f7305c[getPosition(viewM9309B)]));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View m9347z(android.view.View r6, com.google.android.flexbox.C1631b r7) {
        /*
            r5 = this;
            boolean r0 = r5.mo9286n()
            int r1 = r5.getChildCount()
            int r1 = r1 + (-2)
            int r2 = r5.getChildCount()
            int r7 = r7.f7292h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.getChildAt(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.f7235a0
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.n r3 = r5.f7243i0
            int r3 = r3.mo5554g(r6)
            androidx.recyclerview.widget.n r4 = r5.f7243i0
            int r4 = r4.mo5554g(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.n r3 = r5.f7243i0
            int r3 = r3.mo5551d(r6)
            androidx.recyclerview.widget.n r4 = r5.f7243i0
            int r4 = r4.mo5551d(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.m9347z(android.view.View, com.google.android.flexbox.b):android.view.View");
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1626a();

        /* renamed from: a */
        public int f7265a;

        /* renamed from: b */
        public int f7266b;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$SavedState$a */
        public class C1626a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: h */
        public final boolean m9356h(int i10) {
            int i11 = this.f7265a;
            return i11 >= 0 && i11 < i10;
        }

        /* renamed from: i */
        public final void m9357i() {
            this.f7265a = -1;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f7265a + ", mAnchorOffset=" + this.f7266b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f7265a);
            parcel.writeInt(this.f7266b);
        }

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.f7265a = parcel.readInt();
            this.f7266b = parcel.readInt();
        }

        public SavedState(SavedState savedState) {
            this.f7265a = savedState.f7265a;
            this.f7266b = savedState.f7266b;
        }
    }

    public FlexboxLayoutManager(Context context, int i10, int i11) {
        this.f7234Z = -1;
        this.f7237c0 = new ArrayList();
        this.f7238d0 = new C1632c(this);
        this.f7242h0 = new C1628b();
        this.f7246l0 = -1;
        this.f7247m0 = Integer.MIN_VALUE;
        this.f7248n0 = Integer.MIN_VALUE;
        this.f7249o0 = Integer.MIN_VALUE;
        this.f7251q0 = new SparseArray<>();
        this.f7254t0 = -1;
        this.f7255u0 = new C1632c.b();
        m9329V(i10);
        m9330W(i11);
        m9328U(4);
        this.f7252r0 = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsUpdated(recyclerView, i10, i11);
        m9334a0(i10);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new C1625a();

        /* renamed from: e */
        public float f7256e;

        /* renamed from: f */
        public float f7257f;

        /* renamed from: g */
        public int f7258g;

        /* renamed from: h */
        public float f7259h;

        /* renamed from: i */
        public int f7260i;

        /* renamed from: j */
        public int f7261j;

        /* renamed from: k */
        public int f7262k;

        /* renamed from: l */
        public int f7263l;

        /* renamed from: m */
        public boolean f7264m;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$LayoutParams$a */
        public class C1625a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i10) {
                return new LayoutParams[i10];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7256e = 0.0f;
            this.f7257f = 1.0f;
            this.f7258g = -1;
            this.f7259h = -1.0f;
            this.f7262k = 16777215;
            this.f7263l = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: B */
        public int mo9250B() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: D */
        public int mo9251D() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: E */
        public void mo9252E(int i10) {
            this.f7261j = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: F */
        public float mo9253F() {
            return this.f7256e;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: H */
        public float mo9254H() {
            return this.f7259h;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: Z */
        public int mo9255Z() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: j0 */
        public int mo9256j0() {
            return this.f7261j;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: m0 */
        public boolean mo9257m0() {
            return this.f7264m;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: n0 */
        public int mo9258n0() {
            return this.f7263l;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: r0 */
        public int mo9259r0() {
            return this.f7262k;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i10) {
            this.f7260i = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: w */
        public int mo9260w() {
            return this.f7258g;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeFloat(this.f7256e);
            parcel.writeFloat(this.f7257f);
            parcel.writeInt(this.f7258g);
            parcel.writeFloat(this.f7259h);
            parcel.writeInt(this.f7260i);
            parcel.writeInt(this.f7261j);
            parcel.writeInt(this.f7262k);
            parcel.writeInt(this.f7263l);
            parcel.writeByte(this.f7264m ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: x */
        public float mo9261x() {
            return this.f7257f;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: y */
        public int mo9262y() {
            return this.f7260i;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: z */
        public int mo9263z() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f7256e = 0.0f;
            this.f7257f = 1.0f;
            this.f7258g = -1;
            this.f7259h = -1.0f;
            this.f7262k = 16777215;
            this.f7263l = 16777215;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f7256e = 0.0f;
            this.f7257f = 1.0f;
            this.f7258g = -1;
            this.f7259h = -1.0f;
            this.f7262k = 16777215;
            this.f7263l = 16777215;
            this.f7256e = parcel.readFloat();
            this.f7257f = parcel.readFloat();
            this.f7258g = parcel.readInt();
            this.f7259h = parcel.readFloat();
            this.f7260i = parcel.readInt();
            this.f7261j = parcel.readInt();
            this.f7262k = parcel.readInt();
            this.f7263l = parcel.readInt();
            this.f7264m = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f7234Z = -1;
        this.f7237c0 = new ArrayList();
        this.f7238d0 = new C1632c(this);
        this.f7242h0 = new C1628b();
        this.f7246l0 = -1;
        this.f7247m0 = Integer.MIN_VALUE;
        this.f7248n0 = Integer.MIN_VALUE;
        this.f7249o0 = Integer.MIN_VALUE;
        this.f7251q0 = new SparseArray<>();
        this.f7254t0 = -1;
        this.f7255u0 = new C1632c.b();
        RecyclerView.AbstractC0846p.d properties = RecyclerView.AbstractC0846p.getProperties(context, attributeSet, i10, i11);
        int i12 = properties.f4364a;
        if (i12 != 0) {
            if (i12 == 1) {
                if (properties.f4366c) {
                    m9329V(3);
                } else {
                    m9329V(2);
                }
            }
        } else if (properties.f4366c) {
            m9329V(1);
        } else {
            m9329V(0);
        }
        m9330W(1);
        m9328U(4);
        this.f7252r0 = context;
    }
}
