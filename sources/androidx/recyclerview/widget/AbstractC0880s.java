package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.s */
/* loaded from: classes.dex */
public abstract class AbstractC0880s extends RecyclerView.AbstractC0848r {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.AbstractC0850t mScrollListener = new a();

    /* renamed from: androidx.recyclerview.widget.s$a */
    public class a extends RecyclerView.AbstractC0850t {

        /* renamed from: c0 */
        public boolean f4633c0 = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && this.f4633c0) {
                this.f4633c0 = false;
                AbstractC0880s.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f4633c0 = true;
        }
    }

    /* renamed from: androidx.recyclerview.widget.s$b */
    public class b extends LinearSmoothScroller {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return AbstractC0880s.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.AbstractC0855y
        public void onTargetFound(View view, RecyclerView.C0856z c0856z, RecyclerView.AbstractC0855y.a aVar) {
            AbstractC0880s abstractC0880s = AbstractC0880s.this;
            RecyclerView recyclerView = abstractC0880s.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            int[] iArrCalculateDistanceToFinalSnap = abstractC0880s.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
            int i10 = iArrCalculateDistanceToFinalSnap[0];
            int i11 = iArrCalculateDistanceToFinalSnap[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iCalculateTimeForDeceleration > 0) {
                aVar.m5302d(i10, i11, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
    }

    private boolean snapFromFling(RecyclerView.AbstractC0846p abstractC0846p, int i10, int i11) {
        RecyclerView.AbstractC0855y abstractC0855yCreateScroller;
        int iFindTargetSnapPosition;
        if (!(abstractC0846p instanceof RecyclerView.AbstractC0855y.b) || (abstractC0855yCreateScroller = createScroller(abstractC0846p)) == null || (iFindTargetSnapPosition = findTargetSnapPosition(abstractC0846p, i10, i11)) == -1) {
            return false;
        }
        abstractC0855yCreateScroller.setTargetPosition(iFindTargetSnapPosition);
        abstractC0846p.startSmoothScroll(abstractC0855yCreateScroller);
        return true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.AbstractC0846p abstractC0846p, View view);

    public int[] calculateScrollDistance(int i10, int i11) {
        this.mGravityScroller.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    public RecyclerView.AbstractC0855y createScroller(RecyclerView.AbstractC0846p abstractC0846p) {
        return createSnapScroller(abstractC0846p);
    }

    @Deprecated
    public LinearSmoothScroller createSnapScroller(RecyclerView.AbstractC0846p abstractC0846p) {
        if (abstractC0846p instanceof RecyclerView.AbstractC0855y.b) {
            return new b(this.mRecyclerView.getContext());
        }
        return null;
    }

    public abstract View findSnapView(RecyclerView.AbstractC0846p abstractC0846p);

    public abstract int findTargetSnapPosition(RecyclerView.AbstractC0846p abstractC0846p, int i10, int i11);

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0848r
    public boolean onFling(int i10, int i11) {
        RecyclerView.AbstractC0846p layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && snapFromFling(layoutManager, i10, i11);
    }

    public void snapToTargetExistingView() {
        RecyclerView.AbstractC0846p layoutManager;
        View viewFindSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewFindSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
        int i10 = iArrCalculateDistanceToFinalSnap[0];
        if (i10 == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(i10, iArrCalculateDistanceToFinalSnap[1]);
    }
}
