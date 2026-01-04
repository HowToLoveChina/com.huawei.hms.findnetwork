package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.o */
/* loaded from: classes.dex */
public class C0876o extends AbstractC0880s {

    /* renamed from: m */
    public AbstractC0875n f4626m;

    /* renamed from: n */
    public AbstractC0875n f4627n;

    /* renamed from: androidx.recyclerview.widget.o$a */
    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i10) {
            return Math.min(100, super.calculateTimeForScrolling(i10));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.AbstractC0855y
        public void onTargetFound(View view, RecyclerView.C0856z c0856z, RecyclerView.AbstractC0855y.a aVar) {
            C0876o c0876o = C0876o.this;
            int[] iArrCalculateDistanceToFinalSnap = c0876o.calculateDistanceToFinalSnap(c0876o.mRecyclerView.getLayoutManager(), view);
            int i10 = iArrCalculateDistanceToFinalSnap[0];
            int i11 = iArrCalculateDistanceToFinalSnap[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iCalculateTimeForDeceleration > 0) {
                aVar.m5302d(i10, i11, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    /* renamed from: a */
    public final int m5568a(View view, AbstractC0875n abstractC0875n) {
        return (abstractC0875n.mo5554g(view) + (abstractC0875n.mo5552e(view) / 2)) - (abstractC0875n.mo5561n() + (abstractC0875n.mo5562o() / 2));
    }

    /* renamed from: b */
    public final View m5569b(RecyclerView.AbstractC0846p abstractC0846p, AbstractC0875n abstractC0875n) {
        int childCount = abstractC0846p.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int iMo5561n = abstractC0875n.mo5561n() + (abstractC0875n.mo5562o() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = abstractC0846p.getChildAt(i11);
            int iAbs = Math.abs((abstractC0875n.mo5554g(childAt) + (abstractC0875n.mo5552e(childAt) / 2)) - iMo5561n);
            if (iAbs < i10) {
                view = childAt;
                i10 = iAbs;
            }
        }
        return view;
    }

    /* renamed from: c */
    public final AbstractC0875n m5570c(RecyclerView.AbstractC0846p abstractC0846p) {
        AbstractC0875n abstractC0875n = this.f4627n;
        if (abstractC0875n == null || abstractC0875n.f4623a != abstractC0846p) {
            this.f4627n = AbstractC0875n.m5548a(abstractC0846p);
        }
        return this.f4627n;
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public int[] calculateDistanceToFinalSnap(RecyclerView.AbstractC0846p abstractC0846p, View view) {
        int[] iArr = new int[2];
        if (abstractC0846p.canScrollHorizontally()) {
            iArr[0] = m5568a(view, m5570c(abstractC0846p));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0846p.canScrollVertically()) {
            iArr[1] = m5568a(view, m5572e(abstractC0846p));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public RecyclerView.AbstractC0855y createScroller(RecyclerView.AbstractC0846p abstractC0846p) {
        if (abstractC0846p instanceof RecyclerView.AbstractC0855y.b) {
            return new a(this.mRecyclerView.getContext());
        }
        return null;
    }

    /* renamed from: d */
    public final AbstractC0875n m5571d(RecyclerView.AbstractC0846p abstractC0846p) {
        if (abstractC0846p.canScrollVertically()) {
            return m5572e(abstractC0846p);
        }
        if (abstractC0846p.canScrollHorizontally()) {
            return m5570c(abstractC0846p);
        }
        return null;
    }

    /* renamed from: e */
    public final AbstractC0875n m5572e(RecyclerView.AbstractC0846p abstractC0846p) {
        AbstractC0875n abstractC0875n = this.f4626m;
        if (abstractC0875n == null || abstractC0875n.f4623a != abstractC0846p) {
            this.f4626m = AbstractC0875n.m5550c(abstractC0846p);
        }
        return this.f4626m;
    }

    /* renamed from: f */
    public final boolean m5573f(RecyclerView.AbstractC0846p abstractC0846p, int i10, int i11) {
        return abstractC0846p.canScrollHorizontally() ? i10 > 0 : i11 > 0;
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public View findSnapView(RecyclerView.AbstractC0846p abstractC0846p) {
        if (abstractC0846p.canScrollVertically()) {
            return m5569b(abstractC0846p, m5572e(abstractC0846p));
        }
        if (abstractC0846p.canScrollHorizontally()) {
            return m5569b(abstractC0846p, m5570c(abstractC0846p));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public int findTargetSnapPosition(RecyclerView.AbstractC0846p abstractC0846p, int i10, int i11) {
        AbstractC0875n abstractC0875nM5571d;
        int itemCount = abstractC0846p.getItemCount();
        if (itemCount == 0 || (abstractC0875nM5571d = m5571d(abstractC0846p)) == null) {
            return -1;
        }
        int childCount = abstractC0846p.getChildCount();
        View view = null;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = abstractC0846p.getChildAt(i14);
            if (childAt != null) {
                int iM5568a = m5568a(childAt, abstractC0875nM5571d);
                if (iM5568a <= 0 && iM5568a > i13) {
                    view2 = childAt;
                    i13 = iM5568a;
                }
                if (iM5568a >= 0 && iM5568a < i12) {
                    view = childAt;
                    i12 = iM5568a;
                }
            }
        }
        boolean zM5573f = m5573f(abstractC0846p, i10, i11);
        if (zM5573f && view != null) {
            return abstractC0846p.getPosition(view);
        }
        if (!zM5573f && view2 != null) {
            return abstractC0846p.getPosition(view2);
        }
        if (zM5573f) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = abstractC0846p.getPosition(view) + (m5574g(abstractC0846p) == zM5573f ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public final boolean m5574g(RecyclerView.AbstractC0846p abstractC0846p) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = abstractC0846p.getItemCount();
        if (!(abstractC0846p instanceof RecyclerView.AbstractC0855y.b) || (pointFComputeScrollVectorForPosition = ((RecyclerView.AbstractC0855y.b) abstractC0846p).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return pointFComputeScrollVectorForPosition.x < 0.0f || pointFComputeScrollVectorForPosition.y < 0.0f;
    }
}
