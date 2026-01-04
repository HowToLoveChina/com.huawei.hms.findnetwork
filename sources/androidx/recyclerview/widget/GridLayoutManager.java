package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p304g0.C9832l;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    AbstractC0822b mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$a */
    public static final class C0821a extends AbstractC0822b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.AbstractC0822b
        /* renamed from: e */
        public int mo5101e(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.AbstractC0822b
        /* renamed from: f */
        public int mo5102f(int i10) {
            return 1;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$b */
    public static abstract class AbstractC0822b {

        /* renamed from: a */
        public final SparseIntArray f4283a = new SparseIntArray();

        /* renamed from: b */
        public final SparseIntArray f4284b = new SparseIntArray();

        /* renamed from: c */
        public boolean f4285c = false;

        /* renamed from: d */
        public boolean f4286d = false;

        /* renamed from: a */
        public static int m5103a(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        /* renamed from: b */
        public int m5104b(int i10, int i11) {
            if (!this.f4286d) {
                return m5106d(i10, i11);
            }
            int i12 = this.f4284b.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int iM5106d = m5106d(i10, i11);
            this.f4284b.put(i10, iM5106d);
            return iM5106d;
        }

        /* renamed from: c */
        public int m5105c(int i10, int i11) {
            if (!this.f4285c) {
                return mo5101e(i10, i11);
            }
            int i12 = this.f4283a.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int iMo5101e = mo5101e(i10, i11);
            this.f4283a.put(i10, iMo5101e);
            return iMo5101e;
        }

        /* renamed from: d */
        public int m5106d(int i10, int i11) {
            int i12;
            int i13;
            int iM5105c;
            int iM5103a;
            if (!this.f4286d || (iM5103a = m5103a(this.f4284b, i10)) == -1) {
                i12 = 0;
                i13 = 0;
                iM5105c = 0;
            } else {
                i12 = this.f4284b.get(iM5103a);
                i13 = iM5103a + 1;
                iM5105c = m5105c(iM5103a, i11) + mo5102f(iM5103a);
                if (iM5105c == i11) {
                    i12++;
                    iM5105c = 0;
                }
            }
            int iMo5102f = mo5102f(i10);
            while (i13 < i10) {
                int iMo5102f2 = mo5102f(i13);
                iM5105c += iMo5102f2;
                if (iM5105c == i11) {
                    i12++;
                    iM5105c = 0;
                } else if (iM5105c > i11) {
                    i12++;
                    iM5105c = iMo5102f2;
                }
                i13++;
            }
            return iM5105c + iMo5102f > i11 ? i12 + 1 : i12;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x002b -> B:39:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x002d -> B:39:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x002f -> B:39:0x0030). Please report as a decompilation issue!!! */
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int mo5101e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.mo5102f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f4285c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f4283a
                int r2 = m5103a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f4283a
                int r3 = r3.get(r2)
                int r4 = r5.mo5102f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.mo5102f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.AbstractC0822b.mo5101e(int, int):int");
        }

        /* renamed from: f */
        public abstract int mo5102f(int i10);

        /* renamed from: g */
        public void m5107g() {
            this.f4284b.clear();
        }

        /* renamed from: h */
        public void m5108h() {
            this.f4283a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new C0821a();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.AbstractC0846p.getProperties(context, attributeSet, i10, i11).f4365b);
    }

    private void assignSpans(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (z10) {
            i13 = 1;
            i12 = i10;
            i11 = 0;
        } else {
            i11 = i10 - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View view = this.mSet[i11];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(c0852v, c0856z, getPosition(view));
            layoutParams.f4282f = spanSize;
            layoutParams.f4281e = i14;
            i14 += spanSize;
            i11 += i13;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            int iM5125a = layoutParams.m5125a();
            this.mPreLayoutSpanSizeCache.put(iM5125a, layoutParams.m5100g());
            this.mPreLayoutSpanIndexCache.put(iM5125a, layoutParams.m5099f());
        }
    }

    private void calculateItemBorders(int i10) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i10);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.C0856z c0856z) {
        if (getChildCount() != 0 && c0856z.m5305b() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int iM5104b = this.mSpanSizeLookup.m5104b(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount);
                int iM5104b2 = this.mSpanSizeLookup.m5104b(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount);
                int iMax = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.m5104b(c0856z.m5305b() - 1, this.mSpanCount) + 1) - Math.max(iM5104b, iM5104b2)) - 1) : Math.max(0, Math.min(iM5104b, iM5104b2));
                if (zIsSmoothScrollbarEnabled) {
                    return Math.round((iMax * (Math.abs(this.mOrientationHelper.mo5551d(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo5554g(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.m5104b(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.m5104b(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.mo5561n() - this.mOrientationHelper.mo5554g(viewFindFirstVisibleChildClosestToStart)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.C0856z c0856z) {
        if (getChildCount() != 0 && c0856z.m5305b() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.m5104b(c0856z.m5305b() - 1, this.mSpanCount) + 1;
                }
                int iMo5551d = this.mOrientationHelper.mo5551d(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo5554g(viewFindFirstVisibleChildClosestToStart);
                int iM5104b = this.mSpanSizeLookup.m5104b(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((iMo5551d / ((this.mSpanSizeLookup.m5104b(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - iM5104b) + 1)) * (this.mSpanSizeLookup.m5104b(c0856z.m5305b() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, LinearLayoutManager.C0824a c0824a, int i10) {
        boolean z10 = i10 == 1;
        int spanIndex = getSpanIndex(c0852v, c0856z, c0824a.f4291b);
        if (z10) {
            while (spanIndex > 0) {
                int i11 = c0824a.f4291b;
                if (i11 <= 0) {
                    return;
                }
                int i12 = i11 - 1;
                c0824a.f4291b = i12;
                spanIndex = getSpanIndex(c0852v, c0856z, i12);
            }
            return;
        }
        int iM5305b = c0856z.m5305b() - 1;
        int i13 = c0824a.f4291b;
        while (i13 < iM5305b) {
            int i14 = i13 + 1;
            int spanIndex2 = getSpanIndex(c0852v, c0856z, i14);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i13 = i14;
            spanIndex = spanIndex2;
        }
        c0824a.f4291b = i13;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10) {
        if (!c0856z.m5308e()) {
            return this.mSpanSizeLookup.m5104b(i10, this.mSpanCount);
        }
        int iM5276f = c0852v.m5276f(i10);
        if (iM5276f != -1) {
            return this.mSpanSizeLookup.m5104b(iM5276f, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    private int getSpanIndex(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10) {
        if (!c0856z.m5308e()) {
            return this.mSpanSizeLookup.m5105c(i10, this.mSpanCount);
        }
        int i11 = this.mPreLayoutSpanIndexCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iM5276f = c0852v.m5276f(i10);
        if (iM5276f != -1) {
            return this.mSpanSizeLookup.m5105c(iM5276f, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 0;
    }

    private int getSpanSize(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10) {
        if (!c0856z.m5308e()) {
            return this.mSpanSizeLookup.mo5102f(i10);
        }
        int i11 = this.mPreLayoutSpanSizeCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iM5276f = c0852v.m5276f(i10);
        if (iM5276f != -1) {
            return this.mSpanSizeLookup.mo5102f(iM5276f);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 1;
    }

    private void guessMeasurement(float f10, int i10) {
        calculateItemBorders(Math.max(Math.round(f10 * this.mSpanCount), i10));
    }

    private void measureChild(View view, int i10, boolean z10) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f4313b;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i12 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.f4281e, layoutParams.f4282f);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView.AbstractC0846p.getChildMeasureSpec(spaceForSpanRange, i10, i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            childMeasureSpec = RecyclerView.AbstractC0846p.getChildMeasureSpec(this.mOrientationHelper.mo5562o(), getHeightMode(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView.AbstractC0846p.getChildMeasureSpec(spaceForSpanRange, i10, i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec4 = RecyclerView.AbstractC0846p.getChildMeasureSpec(this.mOrientationHelper.mo5562o(), getWidthMode(), i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, z10);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i10, int i11, boolean z10) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z10 ? shouldReMeasureChild(view, i10, i11, layoutParams) : shouldMeasureChild(view, i10, i11, layoutParams)) {
            view.measure(i10, i11);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.C0856z c0856z, LinearLayoutManager.C0826c c0826c, RecyclerView.AbstractC0846p.c cVar) {
        int iMo5102f = this.mSpanCount;
        for (int i10 = 0; i10 < this.mSpanCount && c0826c.m5121c(c0856z) && iMo5102f > 0; i10++) {
            int i11 = c0826c.f4302d;
            cVar.mo5245a(i11, Math.max(0, c0826c.f4305g));
            iMo5102f -= this.mSpanSizeLookup.mo5102f(i11);
            c0826c.f4302d += c0826c.f4303e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollOffset(RecyclerView.C0856z c0856z) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(c0856z) : super.computeHorizontalScrollOffset(c0856z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeHorizontalScrollRange(RecyclerView.C0856z c0856z) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(c0856z) : super.computeHorizontalScrollRange(c0856z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollOffset(RecyclerView.C0856z c0856z) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(c0856z) : super.computeVerticalScrollOffset(c0856z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollRange(RecyclerView.C0856z c0856z) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(c0856z) : super.computeVerticalScrollRange(c0856z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10, boolean z11) {
        int i10;
        int childCount;
        int childCount2 = getChildCount();
        int i11 = 1;
        if (z11) {
            childCount = getChildCount() - 1;
            i10 = -1;
            i11 = -1;
        } else {
            i10 = childCount2;
            childCount = 0;
        }
        int iM5305b = c0856z.m5305b();
        ensureLayoutState();
        int iMo5561n = this.mOrientationHelper.mo5561n();
        int iMo5556i = this.mOrientationHelper.mo5556i();
        View view = null;
        View view2 = null;
        while (childCount != i10) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            if (position >= 0 && position < iM5305b && getSpanIndex(c0852v, c0856z, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).m5127d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.mo5554g(childAt) < iMo5556i && this.mOrientationHelper.mo5551d(childAt) >= iMo5561n) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            childCount += i11;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int getColumnCountForAccessibility(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (c0856z.m5305b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(c0852v, c0856z, c0856z.m5305b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int getRowCountForAccessibility(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (c0856z.m5305b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(c0852v, c0856z, c0856z.m5305b() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i10, int i11) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.mCachedBorders;
        int i12 = this.mSpanCount;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public AbstractC0822b getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, LinearLayoutManager.C0826c c0826c, LinearLayoutManager.C0825b c0825b) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int iMo5553f;
        int iMo5553f2;
        int iMo5553f3;
        int i17;
        int childMeasureSpec;
        int childMeasureSpec2;
        View viewM5122d;
        int iMo5560m = this.mOrientationHelper.mo5560m();
        boolean z10 = iMo5560m != 1073741824;
        int i18 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z10) {
            updateMeasurements();
        }
        boolean z11 = c0826c.f4303e == 1;
        int spanIndex = this.mSpanCount;
        if (!z11) {
            spanIndex = getSpanIndex(c0852v, c0856z, c0826c.f4302d) + getSpanSize(c0852v, c0856z, c0826c.f4302d);
        }
        int i19 = 0;
        while (i19 < this.mSpanCount && c0826c.m5121c(c0856z) && spanIndex > 0) {
            int i20 = c0826c.f4302d;
            int spanSize = getSpanSize(c0852v, c0856z, i20);
            if (spanSize > this.mSpanCount) {
                throw new IllegalArgumentException("Item at position " + i20 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
            spanIndex -= spanSize;
            if (spanIndex < 0 || (viewM5122d = c0826c.m5122d(c0852v)) == null) {
                break;
            }
            this.mSet[i19] = viewM5122d;
            i19++;
        }
        if (i19 == 0) {
            c0825b.f4296b = true;
            return;
        }
        assignSpans(c0852v, c0856z, i19, z11);
        float f10 = 0.0f;
        int i21 = 0;
        for (int i22 = 0; i22 < i19; i22++) {
            View view = this.mSet[i22];
            if (c0826c.f4310l == null) {
                if (z11) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z11) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, iMo5560m, false);
            int iMo5552e = this.mOrientationHelper.mo5552e(view);
            if (iMo5552e > i21) {
                i21 = iMo5552e;
            }
            float fMo5553f = (this.mOrientationHelper.mo5553f(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).f4282f;
            if (fMo5553f > f10) {
                f10 = fMo5553f;
            }
        }
        if (z10) {
            guessMeasurement(f10, i18);
            i21 = 0;
            for (int i23 = 0; i23 < i19; i23++) {
                View view2 = this.mSet[i23];
                measureChild(view2, 1073741824, true);
                int iMo5552e2 = this.mOrientationHelper.mo5552e(view2);
                if (iMo5552e2 > i21) {
                    i21 = iMo5552e2;
                }
            }
        }
        for (int i24 = 0; i24 < i19; i24++) {
            View view3 = this.mSet[i24];
            if (this.mOrientationHelper.mo5552e(view3) != i21) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f4313b;
                int i25 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i26 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.f4281e, layoutParams.f4282f);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView.AbstractC0846p.getChildMeasureSpec(spaceForSpanRange, 1073741824, i26, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i21 - i25, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i21 - i26, 1073741824);
                    childMeasureSpec = RecyclerView.AbstractC0846p.getChildMeasureSpec(spaceForSpanRange, 1073741824, i25, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        c0825b.f4295a = i21;
        if (this.mOrientation == 1) {
            if (c0826c.f4304f == -1) {
                i15 = c0826c.f4300b;
                i17 = i15 - i21;
            } else {
                i17 = c0826c.f4300b;
                i15 = i17 + i21;
            }
            i13 = i17;
            i14 = 0;
            i12 = 0;
        } else {
            if (c0826c.f4304f == -1) {
                i11 = c0826c.f4300b;
                i10 = i11 - i21;
            } else {
                i10 = c0826c.f4300b;
                i11 = i10 + i21;
            }
            i12 = i10;
            i13 = 0;
            i14 = i11;
            i15 = 0;
        }
        int i27 = 0;
        while (i27 < i19) {
            View view4 = this.mSet[i27];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.f4281e];
                    iMo5553f3 = i15;
                    iMo5553f = paddingLeft;
                    iMo5553f2 = paddingLeft - this.mOrientationHelper.mo5553f(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.f4281e];
                    iMo5553f3 = i15;
                    iMo5553f2 = paddingLeft2;
                    iMo5553f = this.mOrientationHelper.mo5553f(view4) + paddingLeft2;
                }
                i16 = i13;
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.f4281e];
                i16 = paddingTop;
                iMo5553f = i14;
                iMo5553f2 = i12;
                iMo5553f3 = this.mOrientationHelper.mo5553f(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, iMo5553f2, i16, iMo5553f, iMo5553f3);
            if (layoutParams2.m5127d() || layoutParams2.m5126c()) {
                c0825b.f4297c = true;
            }
            c0825b.f4298d |= view4.hasFocusable();
            i27++;
            i15 = iMo5553f3;
            i14 = iMo5553f;
            i12 = iMo5553f2;
            i13 = i16;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, LinearLayoutManager.C0824a c0824a, int i10) {
        super.onAnchorReady(c0852v, c0856z, c0824a, i10);
        updateMeasurements();
        if (c0856z.m5305b() > 0 && !c0856z.m5308e()) {
            ensureAnchorIsInCorrectSpan(c0852v, c0856z, c0824a, i10);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.C0852v r26, androidx.recyclerview.widget.RecyclerView.C0856z r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, View view, C9832l c9832l) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, c9832l);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(c0852v, c0856z, layoutParams2.m5125a());
        if (this.mOrientation == 0) {
            c9832l.m61068X(C9832l.c.m61127a(layoutParams2.m5099f(), layoutParams2.m5100g(), spanGroupIndex, 1, false, false));
        } else {
            c9832l.m61068X(C9832l.c.m61127a(spanGroupIndex, 1, layoutParams2.m5099f(), layoutParams2.m5100g(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.m5108h();
        this.mSpanSizeLookup.m5107g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.m5108h();
        this.mSpanSizeLookup.m5107g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.mSpanSizeLookup.m5108h();
        this.mSpanSizeLookup.m5107g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.m5108h();
        this.mSpanSizeLookup.m5107g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.mSpanSizeLookup.m5108h();
        this.mSpanSizeLookup.m5107g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (c0856z.m5308e()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(c0852v, c0856z);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutCompleted(RecyclerView.C0856z c0856z) {
        super.onLayoutCompleted(c0856z);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollHorizontallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i10, c0852v, c0856z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollVerticallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i10, c0852v, c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int iChooseSize;
        int iChooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i10, i11);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.AbstractC0846p.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            iChooseSize = RecyclerView.AbstractC0846p.chooseSize(i10, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.AbstractC0846p.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            iChooseSize2 = RecyclerView.AbstractC0846p.chooseSize(i11, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setSpanCount(int i10) {
        if (i10 == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i10 >= 1) {
            this.mSpanCount = i10;
            this.mSpanSizeLookup.m5108h();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void setSpanSizeLookup(AbstractC0822b abstractC0822b) {
        this.mSpanSizeLookup = abstractC0822b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z10) {
        this.mUsingSpansToEstimateScrollBarDimensions = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    public static int[] calculateItemBorders(int[] iArr, int i10, int i11) {
        int i12;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i11) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e */
        public int f4281e;

        /* renamed from: f */
        public int f4282f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4281e = -1;
            this.f4282f = 0;
        }

        /* renamed from: f */
        public int m5099f() {
            return this.f4281e;
        }

        /* renamed from: g */
        public int m5100g() {
            return this.f4282f;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f4281e = -1;
            this.f4282f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4281e = -1;
            this.f4282f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4281e = -1;
            this.f4282f = 0;
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new C0821a();
        this.mDecorInsets = new Rect();
        setSpanCount(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new C0821a();
        this.mDecorInsets = new Rect();
        setSpanCount(i10);
    }
}
