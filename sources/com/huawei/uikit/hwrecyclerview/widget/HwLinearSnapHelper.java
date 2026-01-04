package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.OverScroller;
import androidx.recyclerview.widget.AbstractC0875n;
import androidx.recyclerview.widget.AbstractC0880s;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import p827z.C14059a;

/* loaded from: classes4.dex */
public class HwLinearSnapHelper extends AbstractC0880s {
    protected static final int SCROLL_DIRECTION_END = 1;
    protected static final int SCROLL_DIRECTION_START = -1;

    /* renamed from: g */
    private static final float f43702g = 1.0f;

    /* renamed from: h */
    private static final float f43703h = 300.0f;

    /* renamed from: i */
    private static final int f43704i = 2;

    /* renamed from: j */
    private static final int f43705j = 2;

    /* renamed from: k */
    private static final int f43706k = 10;

    /* renamed from: l */
    private static final int f43707l = 480;

    /* renamed from: a */
    private AbstractC0875n f43708a;

    /* renamed from: b */
    private AbstractC0875n f43709b;

    /* renamed from: c */
    private SnapListener f43710c;

    /* renamed from: d */
    private View f43711d;
    protected RecyclerView mRecyclerView;
    protected int mScrollDirection;
    protected int[] mSnapDistances;
    protected int mMaxPositionOffsetForFling = 10;

    /* renamed from: e */
    private boolean f43712e = false;

    /* renamed from: f */
    private final RecyclerView.AbstractC0850t f43713f = new bzrwd();

    public interface SnapListener {
        boolean isTargetNoSnap(int i10);
    }

    public class aauaf extends LinearSmoothScroller {
        public aauaf(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            int i10 = displayMetrics.densityDpi;
            if (i10 > 0) {
                return HwLinearSnapHelper.f43703h / i10;
            }
            return 0.625f;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.AbstractC0855y
        public void onTargetFound(View view, RecyclerView.C0856z c0856z, RecyclerView.AbstractC0855y.a aVar) {
            HwLinearSnapHelper hwLinearSnapHelper = HwLinearSnapHelper.this;
            RecyclerView recyclerView = hwLinearSnapHelper.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            int[] iArrCalculateDistanceToFinalSnap = hwLinearSnapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
            int i10 = iArrCalculateDistanceToFinalSnap[0];
            int i11 = iArrCalculateDistanceToFinalSnap[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iCalculateTimeForDeceleration > 0) {
                aVar.m5302d(i10, i11, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    public class bzrwd extends RecyclerView.AbstractC0850t {
        public bzrwd() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 1) {
                HwLinearSnapHelper.this.mSnapDistances = null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            HwLinearSnapHelper hwLinearSnapHelper = HwLinearSnapHelper.this;
            hwLinearSnapHelper.mScrollDirection = i10 + i11 > 0 ? 1 : -1;
            hwLinearSnapHelper.m55157a();
        }
    }

    /* renamed from: b */
    private boolean m55160b() {
        int[] iArr = this.mSnapDistances;
        if (iArr == null || iArr.length != 2) {
            return false;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f43713f);
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.f43713f);
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public int[] calculateDistanceToFinalSnap(RecyclerView.AbstractC0846p abstractC0846p, View view) {
        int[] iArr = new int[2];
        if (abstractC0846p.canScrollHorizontally()) {
            iArr[0] = m55154a(abstractC0846p, view, m55156a(abstractC0846p));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0846p.canScrollVertically()) {
            iArr[1] = m55154a(abstractC0846p, view, m55159b(abstractC0846p));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public int calculateNextPositionDiffForFling(RecyclerView.AbstractC0846p abstractC0846p, AbstractC0875n abstractC0875n, int i10, int i11) {
        int[] iArrCalculateScrollDistance = calculateScrollDistance(i10, i11);
        float fComputeDistancePerChild = computeDistancePerChild(abstractC0846p, abstractC0875n);
        int i12 = 0;
        if (Float.compare(fComputeDistancePerChild, 0.0f) <= 0) {
            return 0;
        }
        int i13 = Math.abs(iArrCalculateScrollDistance[0]) > Math.abs(iArrCalculateScrollDistance[1]) ? iArrCalculateScrollDistance[0] : iArrCalculateScrollDistance[1];
        int iRound = Math.round(i13 / fComputeDistancePerChild);
        if (i13 < 0) {
            i12 = -1;
        } else if (i13 > 0) {
            i12 = 1;
        }
        this.mScrollDirection = i12;
        int i14 = this.mMaxPositionOffsetForFling;
        return C14059a.m84263b(iRound, -i14, i14);
    }

    public float computeDistancePerChild(RecyclerView.AbstractC0846p abstractC0846p, AbstractC0875n abstractC0875n) {
        int position;
        int childCount = abstractC0846p.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = abstractC0846p.getChildAt(i12);
            if (childAt != null && (position = abstractC0846p.getPosition(childAt)) != -1) {
                if (position < i11) {
                    view = childAt;
                    i11 = position;
                }
                if (position > i10) {
                    view2 = childAt;
                    i10 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(abstractC0875n.mo5551d(view), abstractC0875n.mo5551d(view2)) - Math.min(abstractC0875n.mo5554g(view), abstractC0875n.mo5554g(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i10 - i11) + 1);
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public LinearSmoothScroller createSnapScroller(RecyclerView.AbstractC0846p abstractC0846p) {
        if (abstractC0846p instanceof RecyclerView.AbstractC0855y.b) {
            return new aauaf(this.mRecyclerView.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s
    public View findSnapView(RecyclerView.AbstractC0846p abstractC0846p) {
        if (abstractC0846p == null) {
            return null;
        }
        if (abstractC0846p.canScrollHorizontally()) {
            return m55155a(abstractC0846p, m55156a(abstractC0846p));
        }
        if (abstractC0846p.canScrollVertically() && this.mRecyclerView.canScrollVertically(1) && this.mRecyclerView.canScrollVertically(-1)) {
            return m55155a(abstractC0846p, m55159b(abstractC0846p));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.AbstractC0880s
    public int findTargetSnapPosition(RecyclerView.AbstractC0846p abstractC0846p, int i10, int i11) {
        int itemCount;
        View viewFindSnapView;
        int position;
        int i12;
        PointF pointFComputeScrollVectorForPosition;
        if (!(abstractC0846p instanceof RecyclerView.AbstractC0855y.b) || (itemCount = abstractC0846p.getItemCount()) == 0 || (viewFindSnapView = findSnapView(abstractC0846p)) == null || (position = abstractC0846p.getPosition(viewFindSnapView)) == -1 || (pointFComputeScrollVectorForPosition = ((RecyclerView.AbstractC0855y.b) abstractC0846p).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        int deltaJump = getDeltaJump(abstractC0846p, i10, i11, pointFComputeScrollVectorForPosition);
        if (deltaJump == 0) {
            this.mSnapDistances = calculateDistanceToFinalSnap(abstractC0846p, viewFindSnapView);
            return -1;
        }
        int i13 = position + deltaJump;
        if (i13 < 0) {
            i13 = 0;
        }
        if (i13 < itemCount) {
            i12 = i13;
        }
        return verifyTargetPosition(itemCount, i12);
    }

    public int getDeltaJump(RecyclerView.AbstractC0846p abstractC0846p, int i10, int i11, PointF pointF) {
        int iCalculateNextPositionDiffForFling;
        int iCalculateNextPositionDiffForFling2 = 0;
        if (abstractC0846p.canScrollHorizontally()) {
            iCalculateNextPositionDiffForFling = calculateNextPositionDiffForFling(abstractC0846p, m55156a(abstractC0846p), i10, 0);
            if (pointF.x < 0.0f) {
                iCalculateNextPositionDiffForFling = -iCalculateNextPositionDiffForFling;
            }
        } else {
            iCalculateNextPositionDiffForFling = 0;
        }
        if (abstractC0846p.canScrollVertically()) {
            iCalculateNextPositionDiffForFling2 = calculateNextPositionDiffForFling(abstractC0846p, m55159b(abstractC0846p), 0, i11);
            if (pointF.y < 0.0f) {
                iCalculateNextPositionDiffForFling2 = -iCalculateNextPositionDiffForFling2;
            }
        }
        return abstractC0846p.canScrollVertically() ? iCalculateNextPositionDiffForFling2 : iCalculateNextPositionDiffForFling;
    }

    public SnapListener getSnapListener() {
        return this.f43710c;
    }

    @Override // androidx.recyclerview.widget.AbstractC0880s, androidx.recyclerview.widget.RecyclerView.AbstractC0848r
    public boolean onFling(int i10, int i11) {
        OverScroller overScroller;
        boolean zOnFling = super.onFling(i10, i11);
        if (!zOnFling) {
            RecyclerView recyclerView = this.mRecyclerView;
            if ((recyclerView instanceof HwRecyclerView) && (overScroller = ((HwRecyclerView) recyclerView).getOverScroller()) != null) {
                overScroller.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                return false;
            }
        }
        if (!zOnFling && m55160b()) {
            RecyclerView recyclerView2 = this.mRecyclerView;
            int[] iArr = this.mSnapDistances;
            recyclerView2.smoothScrollBy(iArr[0], iArr[1]);
        }
        return true;
    }

    public void setCheckToVibrateEnabled(boolean z10) {
        this.f43712e = z10;
    }

    public void setMaxPositionOffsetForFling(int i10) {
        if (i10 > 0) {
            this.mMaxPositionOffsetForFling = i10;
        }
    }

    public void setSnapListener(SnapListener snapListener) {
        this.f43710c = snapListener;
    }

    public boolean snapToTargetExistingViewEx() {
        RecyclerView.AbstractC0846p layoutManager;
        View viewFindSnapView;
        int[] iArrCalculateDistanceToFinalSnap;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewFindSnapView = findSnapView(layoutManager)) == null || (iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindSnapView)) == null || iArrCalculateDistanceToFinalSnap.length < 2) {
            return false;
        }
        int i10 = iArrCalculateDistanceToFinalSnap[0];
        if (i10 == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return false;
        }
        this.mRecyclerView.smoothScrollBy(i10, iArrCalculateDistanceToFinalSnap[1]);
        return true;
    }

    public int verifyTargetPosition(int i10, int i11) {
        RecyclerView.AbstractC0838h adapter = this.mRecyclerView.getAdapter();
        SnapListener snapListener = this.f43710c;
        if (snapListener != null) {
            if (!snapListener.isTargetNoSnap(i11)) {
                return i11;
            }
        } else if (adapter == null || (adapter.mo749g(i11) & HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK) == 0) {
            return i11;
        }
        int i12 = this.mScrollDirection;
        if (i12 == -1) {
            return i11 > 0 ? i11 - 1 : i10 > 1 ? 0 : -1;
        }
        if (i12 != 1) {
            return i11;
        }
        int i13 = i10 - 1;
        return i11 < i13 ? i11 + 1 : i13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m55157a() {
        if (!this.f43712e) {
            this.f43711d = null;
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        View viewFindSnapView = findSnapView(recyclerView.getLayoutManager());
        View view = this.f43711d;
        if (view != null && viewFindSnapView != view) {
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 instanceof HwRecyclerView) {
                ((HwRecyclerView) recyclerView2).performVibrate();
            }
        }
        this.f43711d = viewFindSnapView;
    }

    /* renamed from: b */
    private AbstractC0875n m55159b(RecyclerView.AbstractC0846p abstractC0846p) {
        AbstractC0875n abstractC0875n = this.f43708a;
        if (abstractC0875n == null || abstractC0875n.m5558k() != abstractC0846p) {
            this.f43708a = AbstractC0875n.m5550c(abstractC0846p);
        }
        return this.f43708a;
    }

    /* renamed from: a */
    private int m55154a(RecyclerView.AbstractC0846p abstractC0846p, View view, AbstractC0875n abstractC0875n) {
        return (abstractC0875n.mo5554g(view) + (abstractC0875n.mo5552e(view) / 2)) - (abstractC0875n.mo5555h() / 2);
    }

    /* renamed from: a */
    private View m55155a(RecyclerView.AbstractC0846p abstractC0846p, AbstractC0875n abstractC0875n) {
        RecyclerView.AbstractC0838h adapter;
        int childCount = abstractC0846p.getChildCount();
        if (childCount == 0) {
            return null;
        }
        int iMo5555h = abstractC0875n.mo5555h() >> 1;
        View view = null;
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = abstractC0846p.getChildAt(i12);
            int iAbs = Math.abs((abstractC0875n.mo5554g(childAt) + (abstractC0875n.mo5552e(childAt) >> 1)) - iMo5555h);
            if (iAbs < i10) {
                i11 = i12;
                view = childAt;
                i10 = iAbs;
            }
        }
        int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1 || (adapter = this.mRecyclerView.getAdapter()) == null) {
            return null;
        }
        SnapListener snapListener = this.f43710c;
        if (snapListener != null) {
            if (!snapListener.isTargetNoSnap(childAdapterPosition)) {
                return view;
            }
        } else if ((adapter.mo749g(childAdapterPosition) & HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK) == 0) {
            return view;
        }
        int i13 = this.mScrollDirection;
        if (i13 == -1) {
            if (i11 > 0) {
                return abstractC0846p.getChildAt(i11 - 1);
            }
            return null;
        }
        if (i13 != 1 || i11 >= childCount - 1) {
            return null;
        }
        return abstractC0846p.getChildAt(i11 + 1);
    }

    /* renamed from: a */
    private AbstractC0875n m55156a(RecyclerView.AbstractC0846p abstractC0846p) {
        AbstractC0875n abstractC0875n = this.f43709b;
        if (abstractC0875n == null || abstractC0875n.m5558k() != abstractC0846p) {
            this.f43709b = AbstractC0875n.m5548a(abstractC0846p);
        }
        return this.f43709b;
    }
}
