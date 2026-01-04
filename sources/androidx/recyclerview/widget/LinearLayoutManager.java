package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.AbstractC0846p implements InterfaceC0870i, RecyclerView.AbstractC0855y.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final C0824a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final C0825b mLayoutChunkResult;
    private C0826c mLayoutState;
    int mOrientation;
    AbstractC0875n mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0823a();

        /* renamed from: a */
        public int f4287a;

        /* renamed from: b */
        public int f4288b;

        /* renamed from: c */
        public boolean f4289c;

        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$SavedState$a */
        public class C0823a implements Parcelable.Creator<SavedState> {
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

        public SavedState() {
        }

        /* renamed from: a */
        public boolean m5109a() {
            return this.f4287a >= 0;
        }

        /* renamed from: c */
        public void m5110c() {
            this.f4287a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f4287a);
            parcel.writeInt(this.f4288b);
            parcel.writeInt(this.f4289c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f4287a = parcel.readInt();
            this.f4288b = parcel.readInt();
            this.f4289c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f4287a = savedState.f4287a;
            this.f4288b = savedState.f4288b;
            this.f4289c = savedState.f4289c;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$a */
    public static class C0824a {

        /* renamed from: a */
        public AbstractC0875n f4290a;

        /* renamed from: b */
        public int f4291b;

        /* renamed from: c */
        public int f4292c;

        /* renamed from: d */
        public boolean f4293d;

        /* renamed from: e */
        public boolean f4294e;

        public C0824a() {
            m5117e();
        }

        /* renamed from: a */
        public void m5113a() {
            this.f4292c = this.f4293d ? this.f4290a.mo5556i() : this.f4290a.mo5561n();
        }

        /* renamed from: b */
        public void m5114b(View view, int i10) {
            if (this.f4293d) {
                this.f4292c = this.f4290a.mo5551d(view) + this.f4290a.m5563p();
            } else {
                this.f4292c = this.f4290a.mo5554g(view);
            }
            this.f4291b = i10;
        }

        /* renamed from: c */
        public void m5115c(View view, int i10) {
            int iM5563p = this.f4290a.m5563p();
            if (iM5563p >= 0) {
                m5114b(view, i10);
                return;
            }
            this.f4291b = i10;
            if (this.f4293d) {
                int iMo5556i = (this.f4290a.mo5556i() - iM5563p) - this.f4290a.mo5551d(view);
                this.f4292c = this.f4290a.mo5556i() - iMo5556i;
                if (iMo5556i > 0) {
                    int iMo5552e = this.f4292c - this.f4290a.mo5552e(view);
                    int iMo5561n = this.f4290a.mo5561n();
                    int iMin = iMo5552e - (iMo5561n + Math.min(this.f4290a.mo5554g(view) - iMo5561n, 0));
                    if (iMin < 0) {
                        this.f4292c += Math.min(iMo5556i, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMo5554g = this.f4290a.mo5554g(view);
            int iMo5561n2 = iMo5554g - this.f4290a.mo5561n();
            this.f4292c = iMo5554g;
            if (iMo5561n2 > 0) {
                int iMo5556i2 = (this.f4290a.mo5556i() - Math.min(0, (this.f4290a.mo5556i() - iM5563p) - this.f4290a.mo5551d(view))) - (iMo5554g + this.f4290a.mo5552e(view));
                if (iMo5556i2 < 0) {
                    this.f4292c -= Math.min(iMo5561n2, -iMo5556i2);
                }
            }
        }

        /* renamed from: d */
        public boolean m5116d(View view, RecyclerView.C0856z c0856z) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.m5127d() && layoutParams.m5125a() >= 0 && layoutParams.m5125a() < c0856z.m5305b();
        }

        /* renamed from: e */
        public void m5117e() {
            this.f4291b = -1;
            this.f4292c = Integer.MIN_VALUE;
            this.f4293d = false;
            this.f4294e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f4291b + ", mCoordinate=" + this.f4292c + ", mLayoutFromEnd=" + this.f4293d + ", mValid=" + this.f4294e + '}';
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$b */
    public static class C0825b {

        /* renamed from: a */
        public int f4295a;

        /* renamed from: b */
        public boolean f4296b;

        /* renamed from: c */
        public boolean f4297c;

        /* renamed from: d */
        public boolean f4298d;

        /* renamed from: a */
        public void m5118a() {
            this.f4295a = 0;
            this.f4296b = false;
            this.f4297c = false;
            this.f4298d = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$c */
    public static class C0826c {

        /* renamed from: b */
        public int f4300b;

        /* renamed from: c */
        public int f4301c;

        /* renamed from: d */
        public int f4302d;

        /* renamed from: e */
        public int f4303e;

        /* renamed from: f */
        public int f4304f;

        /* renamed from: g */
        public int f4305g;

        /* renamed from: k */
        public int f4309k;

        /* renamed from: m */
        public boolean f4311m;

        /* renamed from: a */
        public boolean f4299a = true;

        /* renamed from: h */
        public int f4306h = 0;

        /* renamed from: i */
        public int f4307i = 0;

        /* renamed from: j */
        public boolean f4308j = false;

        /* renamed from: l */
        public List<RecyclerView.AbstractC0833c0> f4310l = null;

        /* renamed from: a */
        public void m5119a() {
            m5120b(null);
        }

        /* renamed from: b */
        public void m5120b(View view) {
            View viewM5124f = m5124f(view);
            if (viewM5124f == null) {
                this.f4302d = -1;
            } else {
                this.f4302d = ((RecyclerView.LayoutParams) viewM5124f.getLayoutParams()).m5125a();
            }
        }

        /* renamed from: c */
        public boolean m5121c(RecyclerView.C0856z c0856z) {
            int i10 = this.f4302d;
            return i10 >= 0 && i10 < c0856z.m5305b();
        }

        /* renamed from: d */
        public View m5122d(RecyclerView.C0852v c0852v) {
            if (this.f4310l != null) {
                return m5123e();
            }
            View viewM5285o = c0852v.m5285o(this.f4302d);
            this.f4302d += this.f4303e;
            return viewM5285o;
        }

        /* renamed from: e */
        public final View m5123e() {
            int size = this.f4310l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f4310l.get(i10).f4327a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.m5127d() && this.f4302d == layoutParams.m5125a()) {
                    m5120b(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: f */
        public View m5124f(View view) {
            int iM5125a;
            int size = this.f4310l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f4310l.get(i11).f4327a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.m5127d() && (iM5125a = (layoutParams.m5125a() - this.f4302d) * this.f4303e) >= 0 && iM5125a < i10) {
                    view2 = view3;
                    if (iM5125a == 0) {
                        break;
                    }
                    i10 = iM5125a;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0878q.m5579a(c0856z, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0878q.m5580b(c0856z, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return C0878q.m5581c(c0856z, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iMo5556i;
        int iMo5556i2 = this.mOrientationHelper.mo5556i() - i10;
        if (iMo5556i2 <= 0) {
            return 0;
        }
        int i11 = -scrollBy(-iMo5556i2, c0852v, c0856z);
        int i12 = i10 + i11;
        if (!z10 || (iMo5556i = this.mOrientationHelper.mo5556i() - i12) <= 0) {
            return i11;
        }
        this.mOrientationHelper.mo5566s(iMo5556i);
        return iMo5556i + i11;
    }

    private int fixLayoutStartGap(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, boolean z10) {
        int iMo5561n;
        int iMo5561n2 = i10 - this.mOrientationHelper.mo5561n();
        if (iMo5561n2 <= 0) {
            return 0;
        }
        int i11 = -scrollBy(iMo5561n2, c0852v, c0856z);
        int i12 = i10 + i11;
        if (!z10 || (iMo5561n = i12 - this.mOrientationHelper.mo5561n()) <= 0) {
            return i11;
        }
        this.mOrientationHelper.mo5566s(-iMo5561n);
        return i11 - iMo5561n;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10, int i11) {
        if (!c0856z.m5310g() || getChildCount() == 0 || c0856z.m5308e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.AbstractC0833c0> listM5281k = c0852v.m5281k();
        int size = listM5281k.size();
        int position = getPosition(getChildAt(0));
        int iMo5552e = 0;
        int iMo5552e2 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.AbstractC0833c0 abstractC0833c0 = listM5281k.get(i12);
            if (!abstractC0833c0.m5177x()) {
                if ((abstractC0833c0.m5168o() < position) != this.mShouldReverseLayout) {
                    iMo5552e += this.mOrientationHelper.mo5552e(abstractC0833c0.f4327a);
                } else {
                    iMo5552e2 += this.mOrientationHelper.mo5552e(abstractC0833c0.f4327a);
                }
            }
        }
        this.mLayoutState.f4310l = listM5281k;
        if (iMo5552e > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i10);
            C0826c c0826c = this.mLayoutState;
            c0826c.f4306h = iMo5552e;
            c0826c.f4301c = 0;
            c0826c.m5119a();
            fill(c0852v, this.mLayoutState, c0856z, false);
        }
        if (iMo5552e2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i11);
            C0826c c0826c2 = this.mLayoutState;
            c0826c2.f4306h = iMo5552e2;
            c0826c2.f4301c = 0;
            c0826c2.m5119a();
            fill(c0852v, this.mLayoutState, c0856z, false);
        }
        this.mLayoutState.f4310l = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.mo5554g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.C0852v c0852v, C0826c c0826c) {
        if (!c0826c.f4299a || c0826c.f4311m) {
            return;
        }
        int i10 = c0826c.f4305g;
        int i11 = c0826c.f4307i;
        if (c0826c.f4304f == -1) {
            recycleViewsFromEnd(c0852v, i10, i11);
        } else {
            recycleViewsFromStart(c0852v, i10, i11);
        }
    }

    private void recycleChildren(RecyclerView.C0852v c0852v, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                removeAndRecycleViewAt(i10, c0852v);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                removeAndRecycleViewAt(i12, c0852v);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.C0852v c0852v, int i10, int i11) {
        int childCount = getChildCount();
        if (i10 < 0) {
            return;
        }
        int iMo5555h = (this.mOrientationHelper.mo5555h() - i10) + i11;
        if (this.mShouldReverseLayout) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (this.mOrientationHelper.mo5554g(childAt) < iMo5555h || this.mOrientationHelper.mo5565r(childAt) < iMo5555h) {
                    recycleChildren(c0852v, 0, i12);
                    return;
                }
            }
            return;
        }
        int i13 = childCount - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            View childAt2 = getChildAt(i14);
            if (this.mOrientationHelper.mo5554g(childAt2) < iMo5555h || this.mOrientationHelper.mo5565r(childAt2) < iMo5555h) {
                recycleChildren(c0852v, i13, i14);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.C0852v c0852v, int i10, int i11) {
        if (i10 < 0) {
            return;
        }
        int i12 = i10 - i11;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (this.mOrientationHelper.mo5551d(childAt) > i12 || this.mOrientationHelper.mo5564q(childAt) > i12) {
                    recycleChildren(c0852v, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = childCount - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View childAt2 = getChildAt(i15);
            if (this.mOrientationHelper.mo5551d(childAt2) > i12 || this.mOrientationHelper.mo5564q(childAt2) > i12) {
                recycleChildren(c0852v, i14, i15);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, C0824a c0824a) {
        View viewFindReferenceChild;
        boolean z10 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && c0824a.m5116d(focusedChild, c0856z)) {
            c0824a.m5115c(focusedChild, getPosition(focusedChild));
            return true;
        }
        boolean z11 = this.mLastStackFromEnd;
        boolean z12 = this.mStackFromEnd;
        if (z11 != z12 || (viewFindReferenceChild = findReferenceChild(c0852v, c0856z, c0824a.f4293d, z12)) == null) {
            return false;
        }
        c0824a.m5114b(viewFindReferenceChild, getPosition(viewFindReferenceChild));
        if (!c0856z.m5308e() && supportsPredictiveItemAnimations()) {
            int iMo5554g = this.mOrientationHelper.mo5554g(viewFindReferenceChild);
            int iMo5551d = this.mOrientationHelper.mo5551d(viewFindReferenceChild);
            int iMo5561n = this.mOrientationHelper.mo5561n();
            int iMo5556i = this.mOrientationHelper.mo5556i();
            boolean z13 = iMo5551d <= iMo5561n && iMo5554g < iMo5561n;
            if (iMo5554g >= iMo5556i && iMo5551d > iMo5556i) {
                z10 = true;
            }
            if (z13 || z10) {
                if (c0824a.f4293d) {
                    iMo5561n = iMo5556i;
                }
                c0824a.f4292c = iMo5561n;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.C0856z c0856z, C0824a c0824a) {
        int i10;
        if (!c0856z.m5308e() && (i10 = this.mPendingScrollPosition) != -1) {
            if (i10 >= 0 && i10 < c0856z.m5305b()) {
                c0824a.f4291b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.m5109a()) {
                    boolean z10 = this.mPendingSavedState.f4289c;
                    c0824a.f4293d = z10;
                    if (z10) {
                        c0824a.f4292c = this.mOrientationHelper.mo5556i() - this.mPendingSavedState.f4288b;
                    } else {
                        c0824a.f4292c = this.mOrientationHelper.mo5561n() + this.mPendingSavedState.f4288b;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z11 = this.mShouldReverseLayout;
                    c0824a.f4293d = z11;
                    if (z11) {
                        c0824a.f4292c = this.mOrientationHelper.mo5556i() - this.mPendingScrollPositionOffset;
                    } else {
                        c0824a.f4292c = this.mOrientationHelper.mo5561n() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        c0824a.f4293d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    c0824a.m5113a();
                } else {
                    if (this.mOrientationHelper.mo5552e(viewFindViewByPosition) > this.mOrientationHelper.mo5562o()) {
                        c0824a.m5113a();
                        return true;
                    }
                    if (this.mOrientationHelper.mo5554g(viewFindViewByPosition) - this.mOrientationHelper.mo5561n() < 0) {
                        c0824a.f4292c = this.mOrientationHelper.mo5561n();
                        c0824a.f4293d = false;
                        return true;
                    }
                    if (this.mOrientationHelper.mo5556i() - this.mOrientationHelper.mo5551d(viewFindViewByPosition) < 0) {
                        c0824a.f4292c = this.mOrientationHelper.mo5556i();
                        c0824a.f4293d = true;
                        return true;
                    }
                    c0824a.f4292c = c0824a.f4293d ? this.mOrientationHelper.mo5551d(viewFindViewByPosition) + this.mOrientationHelper.m5563p() : this.mOrientationHelper.mo5554g(viewFindViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, C0824a c0824a) {
        if (updateAnchorFromPendingData(c0856z, c0824a) || updateAnchorFromChildren(c0852v, c0856z, c0824a)) {
            return;
        }
        c0824a.m5113a();
        c0824a.f4291b = this.mStackFromEnd ? c0856z.m5305b() - 1 : 0;
    }

    private void updateLayoutState(int i10, int i11, boolean z10, RecyclerView.C0856z c0856z) {
        int iMo5561n;
        this.mLayoutState.f4311m = resolveIsInfinite();
        this.mLayoutState.f4304f = i10;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0856z, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z11 = i10 == 1;
        C0826c c0826c = this.mLayoutState;
        int i12 = z11 ? iMax2 : iMax;
        c0826c.f4306h = i12;
        if (!z11) {
            iMax = iMax2;
        }
        c0826c.f4307i = iMax;
        if (z11) {
            c0826c.f4306h = i12 + this.mOrientationHelper.mo5557j();
            View childClosestToEnd = getChildClosestToEnd();
            C0826c c0826c2 = this.mLayoutState;
            c0826c2.f4303e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(childClosestToEnd);
            C0826c c0826c3 = this.mLayoutState;
            c0826c2.f4302d = position + c0826c3.f4303e;
            c0826c3.f4300b = this.mOrientationHelper.mo5551d(childClosestToEnd);
            iMo5561n = this.mOrientationHelper.mo5551d(childClosestToEnd) - this.mOrientationHelper.mo5556i();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f4306h += this.mOrientationHelper.mo5561n();
            C0826c c0826c4 = this.mLayoutState;
            c0826c4.f4303e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(childClosestToStart);
            C0826c c0826c5 = this.mLayoutState;
            c0826c4.f4302d = position2 + c0826c5.f4303e;
            c0826c5.f4300b = this.mOrientationHelper.mo5554g(childClosestToStart);
            iMo5561n = (-this.mOrientationHelper.mo5554g(childClosestToStart)) + this.mOrientationHelper.mo5561n();
        }
        C0826c c0826c6 = this.mLayoutState;
        c0826c6.f4301c = i11;
        if (z10) {
            c0826c6.f4301c = i11 - iMo5561n;
        }
        c0826c6.f4305g = iMo5561n;
    }

    private void updateLayoutStateToFillEnd(C0824a c0824a) {
        updateLayoutStateToFillEnd(c0824a.f4291b, c0824a.f4292c);
    }

    private void updateLayoutStateToFillStart(C0824a c0824a) {
        updateLayoutStateToFillStart(c0824a.f4291b, c0824a.f4292c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.C0856z c0856z, int[] iArr) {
        int i10;
        int extraLayoutSpace = getExtraLayoutSpace(c0856z);
        if (this.mLayoutState.f4304f == -1) {
            i10 = 0;
        } else {
            i10 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.C0856z c0856z, RecyclerView.AbstractC0846p.c cVar) {
        if (this.mOrientation != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i10 > 0 ? 1 : -1, Math.abs(i10), true, c0856z);
        collectPrefetchPositionsForLayoutState(c0856z, this.mLayoutState, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void collectInitialPrefetchPositions(int i10, RecyclerView.AbstractC0846p.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || !savedState.m5109a()) {
            resolveShouldLayoutReverse();
            z10 = this.mShouldReverseLayout;
            i11 = this.mPendingScrollPosition;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z10 = savedState2.f4289c;
            i11 = savedState2.f4287a;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.mInitialPrefetchItemCount && i11 >= 0 && i11 < i10; i13++) {
            cVar.mo5245a(i11, 0);
            i11 += i12;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.C0856z c0856z, C0826c c0826c, RecyclerView.AbstractC0846p.c cVar) {
        int i10 = c0826c.f4302d;
        if (i10 < 0 || i10 >= c0856z.m5305b()) {
            return;
        }
        cVar.mo5245a(i10, Math.max(0, c0826c.f4305g));
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

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0855y.b
    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        int i11 = (i10 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
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

    public int convertFocusDirectionToLayoutDirection(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public C0826c createLayoutState() {
        return new C0826c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.C0852v c0852v, C0826c c0826c, RecyclerView.C0856z c0856z, boolean z10) {
        int i10 = c0826c.f4301c;
        int i11 = c0826c.f4305g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                c0826c.f4305g = i11 + i10;
            }
            recycleByLayoutState(c0852v, c0826c);
        }
        int i12 = c0826c.f4301c + c0826c.f4306h;
        C0825b c0825b = this.mLayoutChunkResult;
        while (true) {
            if ((!c0826c.f4311m && i12 <= 0) || !c0826c.m5121c(c0856z)) {
                break;
            }
            c0825b.m5118a();
            layoutChunk(c0852v, c0856z, c0826c, c0825b);
            if (!c0825b.f4296b) {
                c0826c.f4300b += c0825b.f4295a * c0826c.f4304f;
                if (!c0825b.f4297c || c0826c.f4310l != null || !c0856z.m5308e()) {
                    int i13 = c0826c.f4301c;
                    int i14 = c0825b.f4295a;
                    c0826c.f4301c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = c0826c.f4305g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + c0825b.f4295a;
                    c0826c.f4305g = i16;
                    int i17 = c0826c.f4301c;
                    if (i17 < 0) {
                        c0826c.f4305g = i16 + i17;
                    }
                    recycleByLayoutState(c0852v, c0826c);
                }
                if (z10 && c0825b.f4298d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - c0826c.f4301c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z10, boolean z11) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z10, z11) : findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
    }

    public View findFirstVisibleChildClosestToStart(boolean z10, boolean z11) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z10, z11) : findOneVisibleChild(0, getChildCount(), z10, z11);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i10, int i11) {
        int i12;
        int i13;
        ensureLayoutState();
        if (i11 <= i10 && i11 >= i10) {
            return getChildAt(i10);
        }
        if (this.mOrientationHelper.mo5554g(getChildAt(i10)) < this.mOrientationHelper.mo5561n()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.m5582a(i10, i11, i12, i13) : this.mVerticalBoundCheck.m5582a(i10, i11, i12, i13);
    }

    public View findOneVisibleChild(int i10, int i11, boolean z10, boolean z11) {
        ensureLayoutState();
        int i12 = z10 ? 24579 : 320;
        int i13 = z11 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.m5582a(i10, i11, i12, i13) : this.mVerticalBoundCheck.m5582a(i10, i11, i12, i13);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findReferenceChild(androidx.recyclerview.widget.RecyclerView.C0852v r17, androidx.recyclerview.widget.RecyclerView.C0856z r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r16.ensureLayoutState()
            int r1 = r16.getChildCount()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r16.getChildCount()
            int r1 = r1 - r3
            r4 = -1
            r5 = r4
            goto L18
        L15:
            r4 = r1
            r1 = r2
            r5 = r3
        L18:
            int r6 = r18.m5305b()
            androidx.recyclerview.widget.n r7 = r0.mOrientationHelper
            int r7 = r7.mo5561n()
            androidx.recyclerview.widget.n r8 = r0.mOrientationHelper
            int r8 = r8.mo5556i()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7a
            android.view.View r12 = r0.getChildAt(r1)
            int r13 = r0.getPosition(r12)
            androidx.recyclerview.widget.n r14 = r0.mOrientationHelper
            int r14 = r14.mo5554g(r12)
            androidx.recyclerview.widget.n r15 = r0.mOrientationHelper
            int r15 = r15.mo5551d(r12)
            if (r13 < 0) goto L78
            if (r13 >= r6) goto L78
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r13 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r13
            boolean r13 = r13.m5127d()
            if (r13 == 0) goto L55
            if (r11 != 0) goto L78
            r11 = r12
            goto L78
        L55:
            if (r15 > r7) goto L5b
            if (r14 >= r7) goto L5b
            r13 = r3
            goto L5c
        L5b:
            r13 = r2
        L5c:
            if (r14 < r8) goto L62
            if (r15 <= r8) goto L62
            r14 = r3
            goto L63
        L62:
            r14 = r2
        L63:
            if (r13 != 0) goto L69
            if (r14 == 0) goto L68
            goto L69
        L68:
            return r12
        L69:
            if (r19 == 0) goto L71
            if (r14 == 0) goto L6e
            goto L73
        L6e:
            if (r9 != 0) goto L78
            goto L77
        L71:
            if (r13 == 0) goto L75
        L73:
            r10 = r12
            goto L78
        L75:
            if (r9 != 0) goto L78
        L77:
            r9 = r12
        L78:
            int r1 = r1 + r5
            goto L2b
        L7a:
            if (r9 == 0) goto L7d
            goto L82
        L7d:
            if (r10 == 0) goto L81
            r9 = r10
            goto L82
        L81:
            r9 = r11
        L82:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.findReferenceChild(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean, boolean):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public View findViewByPosition(int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i10 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i10) {
                return childAt;
            }
        }
        return super.findViewByPosition(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.C0856z c0856z) {
        if (c0856z.m5307d()) {
            return this.mOrientationHelper.mo5562o();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, C0826c c0826c, C0825b c0825b) {
        int i10;
        int i11;
        int i12;
        int paddingLeft;
        int iMo5553f;
        View viewM5122d = c0826c.m5122d(c0852v);
        if (viewM5122d == null) {
            c0825b.f4296b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewM5122d.getLayoutParams();
        if (c0826c.f4310l == null) {
            if (this.mShouldReverseLayout == (c0826c.f4304f == -1)) {
                addView(viewM5122d);
            } else {
                addView(viewM5122d, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (c0826c.f4304f == -1)) {
                addDisappearingView(viewM5122d);
            } else {
                addDisappearingView(viewM5122d, 0);
            }
        }
        measureChildWithMargins(viewM5122d, 0, 0);
        c0825b.f4295a = this.mOrientationHelper.mo5552e(viewM5122d);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iMo5553f = getWidth() - getPaddingRight();
                paddingLeft = iMo5553f - this.mOrientationHelper.mo5553f(viewM5122d);
            } else {
                paddingLeft = getPaddingLeft();
                iMo5553f = this.mOrientationHelper.mo5553f(viewM5122d) + paddingLeft;
            }
            if (c0826c.f4304f == -1) {
                int i13 = c0826c.f4300b;
                i12 = i13;
                i11 = iMo5553f;
                i10 = i13 - c0825b.f4295a;
            } else {
                int i14 = c0826c.f4300b;
                i10 = i14;
                i11 = iMo5553f;
                i12 = c0825b.f4295a + i14;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iMo5553f2 = this.mOrientationHelper.mo5553f(viewM5122d) + paddingTop;
            if (c0826c.f4304f == -1) {
                int i15 = c0826c.f4300b;
                i11 = i15;
                i10 = paddingTop;
                i12 = iMo5553f2;
                paddingLeft = i15 - c0825b.f4295a;
            } else {
                int i16 = c0826c.f4300b;
                i10 = paddingTop;
                i11 = c0825b.f4295a + i16;
                i12 = iMo5553f2;
                paddingLeft = i16;
            }
        }
        layoutDecoratedWithMargins(viewM5122d, paddingLeft, i10, i11, i12);
        if (layoutParams.m5127d() || layoutParams.m5126c()) {
            c0825b.f4297c = true;
        }
        c0825b.f4298d = viewM5122d.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, C0824a c0824a, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0852v c0852v) {
        super.onDetachedFromWindow(recyclerView, c0852v);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(c0852v);
            c0852v.m5273c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public View onFocusSearchFailed(View view, int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        int iConvertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.mo5562o() * MAX_SCROLL_FACTOR), false, c0856z);
        C0826c c0826c = this.mLayoutState;
        c0826c.f4305g = Integer.MIN_VALUE;
        c0826c.f4299a = false;
        fill(c0852v, c0826c, c0856z, true);
        View viewFindPartiallyOrCompletelyInvisibleChildClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        int i10;
        int i11;
        int i12;
        int i13;
        int iFixLayoutEndGap;
        int i14;
        View viewFindViewByPosition;
        int iMo5554g;
        int iMo5556i;
        int i15 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && c0856z.m5305b() == 0) {
            removeAndRecycleAllViews(c0852v);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.m5109a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f4287a;
        }
        ensureLayoutState();
        this.mLayoutState.f4299a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        C0824a c0824a = this.mAnchorInfo;
        if (!c0824a.f4294e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            c0824a.m5117e();
            C0824a c0824a2 = this.mAnchorInfo;
            c0824a2.f4293d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(c0852v, c0856z, c0824a2);
            this.mAnchorInfo.f4294e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.mo5554g(focusedChild) >= this.mOrientationHelper.mo5556i() || this.mOrientationHelper.mo5551d(focusedChild) <= this.mOrientationHelper.mo5561n())) {
            this.mAnchorInfo.m5115c(focusedChild, getPosition(focusedChild));
        }
        C0826c c0826c = this.mLayoutState;
        c0826c.f4304f = c0826c.f4309k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0856z, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.mo5561n();
        int iMax2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.mo5557j();
        if (c0856z.m5308e() && (i14 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i14)) != null) {
            if (this.mShouldReverseLayout) {
                iMo5556i = this.mOrientationHelper.mo5556i() - this.mOrientationHelper.mo5551d(viewFindViewByPosition);
                iMo5554g = this.mPendingScrollPositionOffset;
            } else {
                iMo5554g = this.mOrientationHelper.mo5554g(viewFindViewByPosition) - this.mOrientationHelper.mo5561n();
                iMo5556i = this.mPendingScrollPositionOffset;
            }
            int i16 = iMo5556i - iMo5554g;
            if (i16 > 0) {
                iMax += i16;
            } else {
                iMax2 -= i16;
            }
        }
        C0824a c0824a3 = this.mAnchorInfo;
        if (!c0824a3.f4293d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i15 = 1;
        }
        onAnchorReady(c0852v, c0856z, c0824a3, i15);
        detachAndScrapAttachedViews(c0852v);
        this.mLayoutState.f4311m = resolveIsInfinite();
        this.mLayoutState.f4308j = c0856z.m5308e();
        this.mLayoutState.f4307i = 0;
        C0824a c0824a4 = this.mAnchorInfo;
        if (c0824a4.f4293d) {
            updateLayoutStateToFillStart(c0824a4);
            C0826c c0826c2 = this.mLayoutState;
            c0826c2.f4306h = iMax;
            fill(c0852v, c0826c2, c0856z, false);
            C0826c c0826c3 = this.mLayoutState;
            i11 = c0826c3.f4300b;
            int i17 = c0826c3.f4302d;
            int i18 = c0826c3.f4301c;
            if (i18 > 0) {
                iMax2 += i18;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            C0826c c0826c4 = this.mLayoutState;
            c0826c4.f4306h = iMax2;
            c0826c4.f4302d += c0826c4.f4303e;
            fill(c0852v, c0826c4, c0856z, false);
            C0826c c0826c5 = this.mLayoutState;
            i10 = c0826c5.f4300b;
            int i19 = c0826c5.f4301c;
            if (i19 > 0) {
                updateLayoutStateToFillStart(i17, i11);
                C0826c c0826c6 = this.mLayoutState;
                c0826c6.f4306h = i19;
                fill(c0852v, c0826c6, c0856z, false);
                i11 = this.mLayoutState.f4300b;
            }
        } else {
            updateLayoutStateToFillEnd(c0824a4);
            C0826c c0826c7 = this.mLayoutState;
            c0826c7.f4306h = iMax2;
            fill(c0852v, c0826c7, c0856z, false);
            C0826c c0826c8 = this.mLayoutState;
            i10 = c0826c8.f4300b;
            int i20 = c0826c8.f4302d;
            int i21 = c0826c8.f4301c;
            if (i21 > 0) {
                iMax += i21;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            C0826c c0826c9 = this.mLayoutState;
            c0826c9.f4306h = iMax;
            c0826c9.f4302d += c0826c9.f4303e;
            fill(c0852v, c0826c9, c0856z, false);
            C0826c c0826c10 = this.mLayoutState;
            i11 = c0826c10.f4300b;
            int i22 = c0826c10.f4301c;
            if (i22 > 0) {
                updateLayoutStateToFillEnd(i20, i10);
                C0826c c0826c11 = this.mLayoutState;
                c0826c11.f4306h = i22;
                fill(c0852v, c0826c11, c0856z, false);
                i10 = this.mLayoutState.f4300b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i10, c0852v, c0856z, true);
                i12 = i11 + iFixLayoutEndGap2;
                i13 = i10 + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i12, c0852v, c0856z, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i11, c0852v, c0856z, true);
                i12 = i11 + iFixLayoutStartGap;
                i13 = i10 + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i13, c0852v, c0856z, false);
            }
            i11 = i12 + iFixLayoutEndGap;
            i10 = i13 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(c0852v, c0856z, i11, i10);
        if (c0856z.m5308e()) {
            this.mAnchorInfo.m5117e();
        } else {
            this.mOrientationHelper.m5567t();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutCompleted(RecyclerView.C0856z c0856z) {
        super.onLayoutCompleted(c0856z);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.m5117e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.m5110c();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z10 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f4289c = z10;
            if (z10) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.f4288b = this.mOrientationHelper.mo5556i() - this.mOrientationHelper.mo5551d(childClosestToEnd);
                savedState.f4287a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.f4287a = getPosition(childClosestToStart);
                savedState.f4288b = this.mOrientationHelper.mo5554g(childClosestToStart) - this.mOrientationHelper.mo5561n();
            }
        } else {
            savedState.m5110c();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.InterfaceC0870i
    public void prepareForDrop(View view, View view2, int i10, int i11) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c10 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c10 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo5556i() - (this.mOrientationHelper.mo5554g(view2) + this.mOrientationHelper.mo5552e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo5556i() - this.mOrientationHelper.mo5551d(view2));
                return;
            }
        }
        if (c10 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo5554g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo5551d(view2) - this.mOrientationHelper.mo5552e(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.mo5559l() == 0 && this.mOrientationHelper.mo5555h() == 0;
    }

    public int scrollBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f4299a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int iAbs = Math.abs(i10);
        updateLayoutState(i11, iAbs, true, c0856z);
        C0826c c0826c = this.mLayoutState;
        int iFill = c0826c.f4305g + fill(c0852v, c0826c, c0856z, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i10 = i11 * iFill;
        }
        this.mOrientationHelper.mo5566s(-i10);
        this.mLayoutState.f4309k = i10;
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollHorizontallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i10, c0852v, c0856z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void scrollToPosition(int i10) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.m5110c();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = i11;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.m5110c();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollVerticallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i10, c0852v, c0856z);
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.mInitialPrefetchItemCount = i10;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        if (i10 != this.mOrientation || this.mOrientationHelper == null) {
            AbstractC0875n abstractC0875nM5549b = AbstractC0875n.m5549b(this, i10);
            this.mOrientationHelper = abstractC0875nM5549b;
            this.mAnchorInfo.f4290a = abstractC0875nM5549b;
            this.mOrientation = i10;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.mRecycleChildrenOnDetach = z10;
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z10;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.mSmoothScrollbarEnabled = z10;
    }

    public void setStackFromEnd(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z10) {
            return;
        }
        this.mStackFromEnd = z10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0856z c0856z, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iMo5554g = this.mOrientationHelper.mo5554g(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i10 = 1; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                int position2 = getPosition(childAt);
                int iMo5554g2 = this.mOrientationHelper.mo5554g(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    sb2.append(iMo5554g2 < iMo5554g);
                    throw new RuntimeException(sb2.toString());
                }
                if (iMo5554g2 > iMo5554g) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i11 = 1; i11 < getChildCount(); i11++) {
            View childAt2 = getChildAt(i11);
            int position3 = getPosition(childAt2);
            int iMo5554g3 = this.mOrientationHelper.mo5554g(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("detected invalid position. loc invalid? ");
                sb3.append(iMo5554g3 < iMo5554g);
                throw new RuntimeException(sb3.toString());
            }
            if (iMo5554g3 < iMo5554g) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0824a();
        this.mLayoutChunkResult = new C0825b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i10);
        setReverseLayout(z10);
    }

    private void updateLayoutStateToFillEnd(int i10, int i11) {
        this.mLayoutState.f4301c = this.mOrientationHelper.mo5556i() - i11;
        C0826c c0826c = this.mLayoutState;
        c0826c.f4303e = this.mShouldReverseLayout ? -1 : 1;
        c0826c.f4302d = i10;
        c0826c.f4304f = 1;
        c0826c.f4300b = i11;
        c0826c.f4305g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i10, int i11) {
        this.mLayoutState.f4301c = i11 - this.mOrientationHelper.mo5561n();
        C0826c c0826c = this.mLayoutState;
        c0826c.f4302d = i10;
        c0826c.f4303e = this.mShouldReverseLayout ? 1 : -1;
        c0826c.f4304f = -1;
        c0826c.f4300b = i11;
        c0826c.f4305g = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0824a();
        this.mLayoutChunkResult = new C0825b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.AbstractC0846p.d properties = RecyclerView.AbstractC0846p.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f4364a);
        setReverseLayout(properties.f4366c);
        setStackFromEnd(properties.f4367d);
    }
}
