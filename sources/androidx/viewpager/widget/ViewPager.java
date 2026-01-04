package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import com.huawei.hms.network.embedded.C6051p9;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p304g0.C9832l;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    AbstractC0984a mAdapter;
    private List<InterfaceC0979h> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private InterfaceC0980i mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<C0977f> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private C0982k mObserver;
    private int mOffscreenPageLimit;
    private InterfaceC0980i mOnPageChangeListener;
    private List<InterfaceC0980i> mOnPageChangeListeners;
    private int mPageMargin;
    private InterfaceC0981j mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final C0977f mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<C0977f> COMPARATOR = new C0972a();
    private static final Interpolator sInterpolator = new InterpolatorC0973b();
    private static final C0983l sPositionComparator = new C0983l();

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0971a();

        /* renamed from: d */
        public int f4950d;

        /* renamed from: e */
        public Parcelable f4951e;

        /* renamed from: f */
        public ClassLoader f4952f;

        /* renamed from: androidx.viewpager.widget.ViewPager$SavedState$a */
        public static class C0971a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f4950d + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4950d);
            parcel.writeParcelable(this.f4951e, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f4950d = parcel.readInt();
            this.f4951e = parcel.readParcelable(classLoader);
            this.f4952f = classLoader;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$a */
    public static class C0972a implements Comparator<C0977f> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0977f c0977f, C0977f c0977f2) {
            return c0977f.f4957b - c0977f2.f4957b;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$b */
    public static class InterpolatorC0973b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$c */
    public class RunnableC0974c implements Runnable {
        public RunnableC0974c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$d */
    public class C0975d implements InterfaceC9586b0 {

        /* renamed from: a */
        public final Rect f4954a = new Rect();

        public C0975d() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            C9625s0 c9625s0M59874b0 = C9603h0.m59874b0(view, c9625s0);
            if (c9625s0M59874b0.m60163p()) {
                return c9625s0M59874b0;
            }
            Rect rect = this.f4954a;
            rect.left = c9625s0M59874b0.m60158j();
            rect.top = c9625s0M59874b0.m60160l();
            rect.right = c9625s0M59874b0.m60159k();
            rect.bottom = c9625s0M59874b0.m60157i();
            int childCount = ViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                C9625s0 c9625s0M59885h = C9603h0.m59885h(ViewPager.this.getChildAt(i10), c9625s0M59874b0);
                rect.left = Math.min(c9625s0M59885h.m60158j(), rect.left);
                rect.top = Math.min(c9625s0M59885h.m60160l(), rect.top);
                rect.right = Math.min(c9625s0M59885h.m60159k(), rect.right);
                rect.bottom = Math.min(c9625s0M59885h.m60157i(), rect.bottom);
            }
            return c9625s0M59874b0.m60164q(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.viewpager.widget.ViewPager$e */
    public @interface InterfaceC0976e {
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$f */
    public static class C0977f {

        /* renamed from: a */
        public Object f4956a;

        /* renamed from: b */
        public int f4957b;

        /* renamed from: c */
        public boolean f4958c;

        /* renamed from: d */
        public float f4959d;

        /* renamed from: e */
        public float f4960e;
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$g */
    public class C0978g extends C9582a {
        public C0978g() {
        }

        /* renamed from: b */
        public final boolean m5858b() {
            AbstractC0984a abstractC0984a = ViewPager.this.mAdapter;
            return abstractC0984a != null && abstractC0984a.getCount() > 1;
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AbstractC0984a abstractC0984a;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m5858b());
            if (accessibilityEvent.getEventType() != 4096 || (abstractC0984a = ViewPager.this.mAdapter) == null) {
                return;
            }
            accessibilityEvent.setItemCount(abstractC0984a.getCount());
            accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
            accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61065U(ViewPager.class.getName());
            c9832l.m61102q0(m5858b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                c9832l.m61071a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                c9832l.m61071a(8192);
            }
        }

        @Override // p273f0.C9582a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) throws Resources.NotFoundException {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (i10 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem + 1);
                return true;
            }
            if (i10 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.mCurItem - 1);
            return true;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$h */
    public interface InterfaceC0979h {
        /* renamed from: a */
        void mo5853a(ViewPager viewPager, AbstractC0984a abstractC0984a, AbstractC0984a abstractC0984a2);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$i */
    public interface InterfaceC0980i {
        void onPageScrollStateChanged(int i10);

        void onPageScrolled(int i10, float f10, int i11);

        void onPageSelected(int i10);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$j */
    public interface InterfaceC0981j {
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$k */
    public class C0982k extends DataSetObserver {
        public C0982k() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.dataSetChanged();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$l */
    public static class C0983l implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z10 = layoutParams.f4944a;
            return z10 != layoutParams2.f4944a ? z10 ? 1 : -1 : layoutParams.f4948e - layoutParams2.f4948e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new C0977f();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new RunnableC0974c();
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(C0977f c0977f, int i10, C0977f c0977f2) {
        int i11;
        int i12;
        C0977f c0977f3;
        C0977f c0977f4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f10 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        if (c0977f2 != null) {
            int i13 = c0977f2.f4957b;
            int i14 = c0977f.f4957b;
            if (i13 < i14) {
                float pageWidth = c0977f2.f4960e + c0977f2.f4959d + f10;
                int i15 = i13 + 1;
                int i16 = 0;
                while (i15 <= c0977f.f4957b && i16 < this.mItems.size()) {
                    C0977f c0977f5 = this.mItems.get(i16);
                    while (true) {
                        c0977f4 = c0977f5;
                        if (i15 <= c0977f4.f4957b || i16 >= this.mItems.size() - 1) {
                            break;
                        }
                        i16++;
                        c0977f5 = this.mItems.get(i16);
                    }
                    while (i15 < c0977f4.f4957b) {
                        pageWidth += this.mAdapter.getPageWidth(i15) + f10;
                        i15++;
                    }
                    c0977f4.f4960e = pageWidth;
                    pageWidth += c0977f4.f4959d + f10;
                    i15++;
                }
            } else if (i13 > i14) {
                int size = this.mItems.size() - 1;
                float pageWidth2 = c0977f2.f4960e;
                while (true) {
                    i13--;
                    if (i13 < c0977f.f4957b || size < 0) {
                        break;
                    }
                    C0977f c0977f6 = this.mItems.get(size);
                    while (true) {
                        c0977f3 = c0977f6;
                        if (i13 >= c0977f3.f4957b || size <= 0) {
                            break;
                        }
                        size--;
                        c0977f6 = this.mItems.get(size);
                    }
                    while (i13 > c0977f3.f4957b) {
                        pageWidth2 -= this.mAdapter.getPageWidth(i13) + f10;
                        i13--;
                    }
                    pageWidth2 -= c0977f3.f4959d + f10;
                    c0977f3.f4960e = pageWidth2;
                }
            }
        }
        int size2 = this.mItems.size();
        float pageWidth3 = c0977f.f4960e;
        int i17 = c0977f.f4957b;
        int i18 = i17 - 1;
        this.mFirstOffset = i17 == 0 ? pageWidth3 : -3.4028235E38f;
        int i19 = count - 1;
        this.mLastOffset = i17 == i19 ? (c0977f.f4959d + pageWidth3) - 1.0f : Float.MAX_VALUE;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            C0977f c0977f7 = this.mItems.get(i20);
            while (true) {
                i12 = c0977f7.f4957b;
                if (i18 <= i12) {
                    break;
                }
                pageWidth3 -= this.mAdapter.getPageWidth(i18) + f10;
                i18--;
            }
            pageWidth3 -= c0977f7.f4959d + f10;
            c0977f7.f4960e = pageWidth3;
            if (i12 == 0) {
                this.mFirstOffset = pageWidth3;
            }
            i20--;
            i18--;
        }
        float pageWidth4 = c0977f.f4960e + c0977f.f4959d + f10;
        int i21 = c0977f.f4957b + 1;
        int i22 = i10 + 1;
        while (i22 < size2) {
            C0977f c0977f8 = this.mItems.get(i22);
            while (true) {
                i11 = c0977f8.f4957b;
                if (i21 >= i11) {
                    break;
                }
                pageWidth4 += this.mAdapter.getPageWidth(i21) + f10;
                i21++;
            }
            if (i11 == i19) {
                this.mLastOffset = (c0977f8.f4959d + pageWidth4) - 1.0f;
            }
            c0977f8.f4960e = pageWidth4;
            pageWidth4 += c0977f8.f4959d + f10;
            i22++;
            i21++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z10) {
        boolean z11 = this.mScrollState == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            C0977f c0977f = this.mItems.get(i10);
            if (c0977f.f4958c) {
                c0977f.f4958c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                C9603h0.m59886h0(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int i10, float f10, int i11, int i12) {
        if (Math.abs(i12) <= this.mFlingDistance || Math.abs(i11) <= this.mMinimumVelocity) {
            i10 += (int) (f10 + (i10 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.mItems.size() <= 0) {
            return i10;
        }
        return Math.max(this.mItems.get(0).f4957b, Math.min(i10, this.mItems.get(r1.size() - 1).f4957b));
    }

    private void dispatchOnPageScrolled(int i10, float f10, int i11) {
        InterfaceC0980i interfaceC0980i = this.mOnPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageScrolled(i10, f10, i11);
        }
        List<InterfaceC0980i> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                InterfaceC0980i interfaceC0980i2 = this.mOnPageChangeListeners.get(i12);
                if (interfaceC0980i2 != null) {
                    interfaceC0980i2.onPageScrolled(i10, f10, i11);
                }
            }
        }
        InterfaceC0980i interfaceC0980i3 = this.mInternalPageChangeListener;
        if (interfaceC0980i3 != null) {
            interfaceC0980i3.onPageScrolled(i10, f10, i11);
        }
    }

    private void dispatchOnPageSelected(int i10) {
        InterfaceC0980i interfaceC0980i = this.mOnPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageSelected(i10);
        }
        List<InterfaceC0980i> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                InterfaceC0980i interfaceC0980i2 = this.mOnPageChangeListeners.get(i11);
                if (interfaceC0980i2 != null) {
                    interfaceC0980i2.onPageSelected(i10);
                }
            }
        }
        InterfaceC0980i interfaceC0980i3 = this.mInternalPageChangeListener;
        if (interfaceC0980i3 != null) {
            interfaceC0980i3.onPageSelected(i10);
        }
    }

    private void dispatchOnScrollStateChanged(int i10) {
        InterfaceC0980i interfaceC0980i = this.mOnPageChangeListener;
        if (interfaceC0980i != null) {
            interfaceC0980i.onPageScrollStateChanged(i10);
        }
        List<InterfaceC0980i> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                InterfaceC0980i interfaceC0980i2 = this.mOnPageChangeListeners.get(i11);
                if (interfaceC0980i2 != null) {
                    interfaceC0980i2.onPageScrollStateChanged(i10);
                }
            }
        }
        InterfaceC0980i interfaceC0980i3 = this.mInternalPageChangeListener;
        if (interfaceC0980i3 != null) {
            interfaceC0980i3.onPageScrollStateChanged(i10);
        }
    }

    private void enableLayers(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.mPageTransformerLayerType : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private C0977f infoForCurrentScrollPosition() {
        int i10;
        int clientWidth = getClientWidth();
        float f10 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f11 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        int i11 = 0;
        boolean z10 = true;
        C0977f c0977f = null;
        int i12 = -1;
        float f12 = 0.0f;
        while (i11 < this.mItems.size()) {
            C0977f c0977f2 = this.mItems.get(i11);
            if (!z10 && c0977f2.f4957b != (i10 = i12 + 1)) {
                c0977f2 = this.mTempItem;
                c0977f2.f4960e = f10 + f12 + f11;
                c0977f2.f4957b = i10;
                c0977f2.f4959d = this.mAdapter.getPageWidth(i10);
                i11--;
            }
            C0977f c0977f3 = c0977f2;
            f10 = c0977f3.f4960e;
            float f13 = c0977f3.f4959d + f10 + f11;
            if (!z10 && scrollX < f10) {
                return c0977f;
            }
            if (scrollX < f13 || i11 == this.mItems.size() - 1) {
                return c0977f3;
            }
            int i13 = c0977f3.f4957b;
            float f14 = c0977f3.f4959d;
            i11++;
            z10 = false;
            i12 = i13;
            f12 = f14;
            c0977f = c0977f3;
        }
        return c0977f;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(InterfaceC0976e.class) != null;
    }

    private boolean isGutterDrag(float f10, float f11) {
        return (f10 < ((float) this.mGutterSize) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.mGutterSize)) && f11 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i10);
            this.mActivePointerId = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i10) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0977f c0977fInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i11 = this.mPageMargin;
        int i12 = clientWidth + i11;
        float f10 = clientWidth;
        int i13 = c0977fInfoForCurrentScrollPosition.f4957b;
        float f11 = ((i10 / f10) - c0977fInfoForCurrentScrollPosition.f4960e) / (c0977fInfoForCurrentScrollPosition.f4959d + (i11 / f10));
        this.mCalledSuper = false;
        onPageScrolled(i13, f11, (int) (i12 * f11));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.mLastMotionX - f10;
        this.mLastMotionX = f10;
        float scrollX = getScrollX() + f11;
        float clientWidth = getClientWidth();
        float f12 = this.mFirstOffset * clientWidth;
        float f13 = this.mLastOffset * clientWidth;
        boolean z12 = false;
        C0977f c0977f = this.mItems.get(0);
        ArrayList<C0977f> arrayList = this.mItems;
        C0977f c0977f2 = arrayList.get(arrayList.size() - 1);
        if (c0977f.f4957b != 0) {
            f12 = c0977f.f4960e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (c0977f2.f4957b != this.mAdapter.getCount() - 1) {
            f13 = c0977f2.f4960e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.mLeftEdge.onPull(Math.abs(f12 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.mRightEdge.onPull(Math.abs(scrollX - f13) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.mLastMotionX += scrollX - i10;
        scrollTo(i10, getScrollY());
        pageScrolled(i10);
        return z12;
    }

    private void recomputeScrollPosition(int i10, int i11, int i12, int i13) {
        if (i11 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)) * (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)), getScrollY());
                return;
            }
        }
        C0977f c0977fInfoForPosition = infoForPosition(this.mCurItem);
        int iMin = (int) ((c0977fInfoForPosition != null ? Math.min(c0977fInfoForPosition.f4960e, this.mLastOffset) : 0.0f) * ((i10 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            completeScroll(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i10).getLayoutParams()).f4944a) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void scrollToItem(int i10, boolean z10, int i11, boolean z11) throws Resources.NotFoundException {
        C0977f c0977fInfoForPosition = infoForPosition(i10);
        int clientWidth = c0977fInfoForPosition != null ? (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(c0977fInfoForPosition.f4960e, this.mLastOffset))) : 0;
        if (z10) {
            smoothScrollTo(clientWidth, 0, i11);
            if (z11) {
                dispatchOnPageSelected(i10);
                return;
            }
            return;
        }
        if (z11) {
            dispatchOnPageSelected(i10);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.mScrollingCacheEnabled != z10) {
            this.mScrollingCacheEnabled = z10;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.mDrawingOrderedChildren.add(getChildAt(i10));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        C0977f c0977fInfoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (c0977fInfoForChild = infoForChild(childAt)) != null && c0977fInfoForChild.f4957b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public C0977f addNewItem(int i10, int i11) {
        C0977f c0977f = new C0977f();
        c0977f.f4957b = i10;
        c0977f.f4956a = this.mAdapter.instantiateItem((ViewGroup) this, i10);
        c0977f.f4959d = this.mAdapter.getPageWidth(i10);
        if (i11 < 0 || i11 >= this.mItems.size()) {
            this.mItems.add(c0977f);
        } else {
            this.mItems.add(i11, c0977f);
        }
        return c0977f;
    }

    public void addOnAdapterChangeListener(InterfaceC0979h interfaceC0979h) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(interfaceC0979h);
    }

    public void addOnPageChangeListener(InterfaceC0980i interfaceC0980i) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(interfaceC0980i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C0977f c0977fInfoForChild;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (c0977fInfoForChild = infoForChild(childAt)) != null && c0977fInfoForChild.f4957b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean zIsDecorView = layoutParams2.f4944a | isDecorView(view);
        layoutParams2.f4944a = zIsDecorView;
        if (!this.mInLayout) {
            super.addView(view, i10, layoutParams);
        } else {
            if (zIsDecorView) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f4947d = true;
            addViewInLayout(view, i10, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean arrowScroll(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L63
        L9:
            if (r0 == 0) goto L63
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L63
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L63:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lb3
            if (r1 == r0) goto Lb3
            if (r5 != r3) goto L93
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.getChildRectInPagerCoordinates(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.getChildRectInPagerCoordinates(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8e
            if (r2 < r3) goto L8e
            boolean r0 = r4.pageLeft()
            goto Lca
        L8e:
            boolean r0 = r1.requestFocus()
            goto Lca
        L93:
            if (r5 != r2) goto Lbf
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.getChildRectInPagerCoordinates(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.getChildRectInPagerCoordinates(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r4.pageRight()
            goto Lca
        Lae:
            boolean r0 = r1.requestFocus()
            goto Lca
        Lb3:
            if (r5 == r3) goto Lc6
            r0 = 1
            if (r5 != r0) goto Lb9
            goto Lc6
        Lb9:
            if (r5 == r2) goto Lc1
            r0 = 2
            if (r5 != r0) goto Lbf
            goto Lc1
        Lbf:
            r0 = 0
            goto Lca
        Lc1:
            boolean r0 = r4.pageRight()
            goto Lca
        Lc6:
            boolean r0 = r4.pageLeft()
        Lca:
            if (r0 == 0) goto Ld3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.mFakeDragBeginTime = jUptimeMillis;
        return true;
    }

    public boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && canScroll(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i10);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i10 < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i10 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<InterfaceC0980i> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C9603h0.m59884g0(this);
    }

    public void dataSetChanged() throws Resources.NotFoundException {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z10 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int iMax = this.mCurItem;
        int i10 = 0;
        boolean z11 = false;
        while (i10 < this.mItems.size()) {
            C0977f c0977f = this.mItems.get(i10);
            int itemPosition = this.mAdapter.getItemPosition(c0977f.f4956a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i10);
                    i10--;
                    if (!z11) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z11 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, c0977f.f4957b, c0977f.f4956a);
                    int i11 = this.mCurItem;
                    if (i11 == c0977f.f4957b) {
                        iMax = Math.max(0, Math.min(i11, count - 1));
                    }
                } else {
                    int i12 = c0977f.f4957b;
                    if (i12 != itemPosition) {
                        if (i12 == this.mCurItem) {
                            iMax = itemPosition;
                        }
                        c0977f.f4957b = itemPosition;
                    }
                }
                z10 = true;
            }
            i10++;
        }
        if (z11) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z10) {
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i13).getLayoutParams();
                if (!layoutParams.f4944a) {
                    layoutParams.f4946c = 0.0f;
                }
            }
            setCurrentItemInternal(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0977f c0977fInfoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (c0977fInfoForChild = infoForChild(childAt)) != null && c0977fInfoForChild.f4957b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public float distanceInfluenceForSnapDuration(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean zDraw;
        AbstractC0984a abstractC0984a;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0 && (overScrollMode != 1 || (abstractC0984a = this.mAdapter) == null || abstractC0984a.getCount() <= 1)) {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
            return;
        }
        if (this.mLeftEdge.isFinished()) {
            zDraw = false;
        } else {
            int iSave = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
            this.mLeftEdge.setSize(height, width);
            zDraw = this.mLeftEdge.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (!this.mRightEdge.isFinished()) {
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
            this.mRightEdge.setSize(height2, width2);
            zDraw |= this.mRightEdge.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (zDraw) {
            C9603h0.m59884g0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() throws Resources.NotFoundException {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            C0977f c0977fInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(c0977fInfoForCurrentScrollPosition.f4957b, ((scrollX / clientWidth) - c0977fInfoForCurrentScrollPosition.f4960e) / c0977fInfoForCurrentScrollPosition.f4959d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? pageLeft() : arrowScroll(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? pageRight() : arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f10) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f10;
        float scrollX = getScrollX() - f10;
        float clientWidth = getClientWidth();
        float f11 = this.mFirstOffset * clientWidth;
        float f12 = this.mLastOffset * clientWidth;
        C0977f c0977f = this.mItems.get(0);
        C0977f c0977f2 = this.mItems.get(r4.size() - 1);
        if (c0977f.f4957b != 0) {
            f11 = c0977f.f4960e * clientWidth;
        }
        if (c0977f2.f4957b != this.mAdapter.getCount() - 1) {
            f12 = c0977f2.f4960e * clientWidth;
        }
        if (scrollX < f11) {
            scrollX = f11;
        } else if (scrollX > f12) {
            scrollX = f12;
        }
        int i10 = (int) scrollX;
        this.mLastMotionX += scrollX - i10;
        scrollTo(i10, getScrollY());
        pageScrolled(i10);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public AbstractC0984a getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.mDrawingOrder == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i11).getLayoutParams()).f4949f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public C0977f infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public C0977f infoForChild(View view) {
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            C0977f c0977f = this.mItems.get(i10);
            if (this.mAdapter.isViewFromObject(view, c0977f.f4956a)) {
                return c0977f;
            }
        }
        return null;
    }

    public C0977f infoForPosition(int i10) {
        for (int i11 = 0; i11 < this.mItems.size(); i11++) {
            C0977f c0977f = this.mItems.get(i11);
            if (c0977f.f4957b == i10) {
                return c0977f;
            }
        }
        return null;
    }

    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(C6051p9.f27764p);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f10);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f10);
        this.mCloseEnough = (int) (2.0f * f10);
        this.mDefaultGutterSize = (int) (f10 * 16.0f);
        C9603h0.m59902p0(this, new C0978g());
        if (C9603h0.m59919y(this) == 0) {
            C9603h0.m59833A0(this, 1);
        }
        C9603h0.m59837C0(this, new C0975d());
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f12 = this.mPageMargin / width;
        int i11 = 0;
        C0977f c0977f = this.mItems.get(0);
        float f13 = c0977f.f4960e;
        int size = this.mItems.size();
        int i12 = c0977f.f4957b;
        int i13 = this.mItems.get(size - 1).f4957b;
        while (i12 < i13) {
            while (true) {
                i10 = c0977f.f4957b;
                if (i12 <= i10 || i11 >= size) {
                    break;
                }
                i11++;
                c0977f = this.mItems.get(i11);
            }
            if (i12 == i10) {
                float f14 = c0977f.f4960e;
                float f15 = c0977f.f4959d;
                f10 = (f14 + f15) * width;
                f13 = f14 + f15 + f12;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i12);
                f10 = (f13 + pageWidth) * width;
                f13 += pageWidth + f12;
            }
            if (this.mPageMargin + f10 > scrollX) {
                f11 = f12;
                this.mMarginDrawable.setBounds(Math.round(f10), this.mTopPageBounds, Math.round(this.mPageMargin + f10), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            } else {
                f11 = f12;
            }
            if (f10 > scrollX + r2) {
                return;
            }
            i12++;
            f12 = f11;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.mActivePointerId;
            if (i10 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                float x11 = motionEvent.getX(iFindPointerIndex);
                float f10 = x11 - this.mLastMotionX;
                float fAbs = Math.abs(f10);
                float y11 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y11 - this.mInitialMotionY);
                if (f10 != 0.0f && !isGutterDrag(this.mLastMotionX, f10) && canScroll(this, false, (int) f10, (int) x11, (int) y11)) {
                    this.mLastMotionX = x11;
                    this.mLastMotionY = y11;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                int i11 = this.mTouchSlop;
                if (fAbs > i11 && fAbs * 0.5f > fAbs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    float f11 = this.mInitialMotionX;
                    float f12 = this.mTouchSlop;
                    this.mLastMotionX = f10 > 0.0f ? f11 + f12 : f11 - f12;
                    this.mLastMotionY = y11;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i11) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x11)) {
                    C9603h0.m59884g0(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i12;
        setMeasuredDimension(View.getDefaultSize(0, i10), View.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            boolean z10 = true;
            int i14 = 1073741824;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f4944a) {
                int i15 = layoutParams2.f4945b;
                int i16 = i15 & 7;
                int i17 = i15 & 112;
                boolean z11 = i17 == 48 || i17 == 80;
                if (i16 != 3 && i16 != 5) {
                    z10 = false;
                }
                int i18 = Integer.MIN_VALUE;
                if (z11) {
                    i12 = Integer.MIN_VALUE;
                    i18 = 1073741824;
                } else {
                    i12 = z10 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i19 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i19 != -2) {
                    if (i19 == -1) {
                        i19 = paddingLeft;
                    }
                    i18 = 1073741824;
                } else {
                    i19 = paddingLeft;
                }
                int i20 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i20 == -2) {
                    i20 = measuredHeight;
                    i14 = i12;
                } else if (i20 == -1) {
                    i20 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, i18), View.MeasureSpec.makeMeasureSpec(i20, i14));
                if (z11) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z10) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i13++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f4944a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f4946c), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPageScrolled(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.mDecorChildCount
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r8 = (androidx.viewpager.widget.ViewPager.LayoutParams) r8
            boolean r9 = r8.f4944a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f4945b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.dispatchOnPageScrolled(r12, r13, r14)
            r11.mCalledSuper = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        C0977f c0977fInfoForChild;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (c0977fInfoForChild = infoForChild(childAt)) != null && c0977fInfoForChild.f4957b == this.mCurItem && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        AbstractC0984a abstractC0984a = this.mAdapter;
        if (abstractC0984a != null) {
            abstractC0984a.restoreState(savedState.f4951e, savedState.f4952f);
            setCurrentItemInternal(savedState.f4950d, false, true);
        } else {
            this.mRestoredCurItem = savedState.f4950d;
            this.mRestoredAdapterState = savedState.f4951e;
            this.mRestoredClassLoader = savedState.f4952f;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4950d = this.mCurItem;
        AbstractC0984a abstractC0984a = this.mAdapter;
        if (abstractC0984a != null) {
            savedState.f4951e = abstractC0984a.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.mPageMargin;
            recomputeScrollPosition(i10, i12, i14, i14);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean pageLeft() throws Resources.NotFoundException {
        int i10 = this.mCurItem;
        if (i10 <= 0) {
            return false;
        }
        setCurrentItem(i10 - 1, true);
        return true;
    }

    public boolean pageRight() throws Resources.NotFoundException {
        AbstractC0984a abstractC0984a = this.mAdapter;
        if (abstractC0984a == null || this.mCurItem >= abstractC0984a.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void populate() throws Resources.NotFoundException {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(InterfaceC0979h interfaceC0979h) {
        List<InterfaceC0979h> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(interfaceC0979h);
        }
    }

    public void removeOnPageChangeListener(InterfaceC0980i interfaceC0980i) {
        List<InterfaceC0980i> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(interfaceC0980i);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(AbstractC0984a abstractC0984a) throws Resources.NotFoundException {
        AbstractC0984a abstractC0984a2 = this.mAdapter;
        if (abstractC0984a2 != null) {
            abstractC0984a2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i10 = 0; i10 < this.mItems.size(); i10++) {
                C0977f c0977f = this.mItems.get(i10);
                this.mAdapter.destroyItem((ViewGroup) this, c0977f.f4957b, c0977f.f4956a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        AbstractC0984a abstractC0984a3 = this.mAdapter;
        this.mAdapter = abstractC0984a;
        this.mExpectedAdapterCount = 0;
        if (abstractC0984a != null) {
            if (this.mObserver == null) {
                this.mObserver = new C0982k();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z10 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z10) {
                requestLayout();
            } else {
                populate();
            }
        }
        List<InterfaceC0979h> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mAdapterChangeListeners.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mAdapterChangeListeners.get(i11).mo5853a(this, abstractC0984a3, abstractC0984a);
        }
    }

    public void setCurrentItem(int i10) throws Resources.NotFoundException {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, !this.mFirstLayout, false);
    }

    public void setCurrentItemInternal(int i10, boolean z10, boolean z11) throws Resources.NotFoundException {
        setCurrentItemInternal(i10, z10, z11, 0);
    }

    public InterfaceC0980i setInternalPageChangeListener(InterfaceC0980i interfaceC0980i) {
        InterfaceC0980i interfaceC0980i2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = interfaceC0980i;
        return interfaceC0980i2;
    }

    public void setOffscreenPageLimit(int i10) throws Resources.NotFoundException {
        if (i10 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i10 + " too small; defaulting to 1");
            i10 = 1;
        }
        if (i10 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i10;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC0980i interfaceC0980i) {
        this.mOnPageChangeListener = interfaceC0980i;
    }

    public void setPageMargin(int i10) {
        int i11 = this.mPageMargin;
        this.mPageMargin = i10;
        int width = getWidth();
        recomputeScrollPosition(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z10, InterfaceC0981j interfaceC0981j) throws Resources.NotFoundException {
        setPageTransformer(z10, interfaceC0981j, 2);
    }

    public void setScrollState(int i10) {
        if (this.mScrollState == i10) {
            return;
        }
        this.mScrollState = i10;
        dispatchOnScrollStateChanged(i10);
    }

    public void smoothScrollTo(int i10, int i11) throws Resources.NotFoundException {
        smoothScrollTo(i10, i11, 0);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public boolean f4944a;

        /* renamed from: b */
        public int f4945b;

        /* renamed from: c */
        public float f4946c;

        /* renamed from: d */
        public boolean f4947d;

        /* renamed from: e */
        public int f4948e;

        /* renamed from: f */
        public int f4949f;

        public LayoutParams() {
            super(-1, -1);
            this.f4946c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4946c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f4945b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb A[PHI: r7 r10 r15
  0x00cb: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00cb: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00cb: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void populate(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 615
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.populate(int):void");
    }

    public void setCurrentItemInternal(int i10, boolean z10, boolean z11, int i11) throws Resources.NotFoundException {
        AbstractC0984a abstractC0984a = this.mAdapter;
        if (abstractC0984a == null || abstractC0984a.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z11 && this.mCurItem == i10 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 >= this.mAdapter.getCount()) {
            i10 = this.mAdapter.getCount() - 1;
        }
        int i12 = this.mOffscreenPageLimit;
        int i13 = this.mCurItem;
        if (i10 > i13 + i12 || i10 < i13 - i12) {
            for (int i14 = 0; i14 < this.mItems.size(); i14++) {
                this.mItems.get(i14).f4958c = true;
            }
        }
        boolean z12 = this.mCurItem != i10;
        if (!this.mFirstLayout) {
            populate(i10);
            scrollToItem(i10, z10, i11, z12);
        } else {
            this.mCurItem = i10;
            if (z12) {
                dispatchOnPageSelected(i10);
            }
            requestLayout();
        }
    }

    public void setPageTransformer(boolean z10, InterfaceC0981j interfaceC0981j, int i10) throws Resources.NotFoundException {
        boolean z11 = interfaceC0981j != null;
        setChildrenDrawingOrderEnabled(z11);
        if (z11) {
            this.mDrawingOrder = z10 ? 2 : 1;
            this.mPageTransformerLayerType = i10;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z11) {
            populate();
        }
    }

    public void smoothScrollTo(int i10, int i11, int i12) throws Resources.NotFoundException {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i13 = scrollX;
        int scrollY = getScrollY();
        int i14 = i10 - i13;
        int i15 = i11 - scrollY;
        if (i14 == 0 && i15 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i16 = clientWidth / 2;
        float f10 = clientWidth;
        float f11 = i16;
        float fDistanceInfluenceForSnapDuration = f11 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i14) * 1.0f) / f10)) * f11);
        int iAbs = Math.abs(i12);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i14) / ((f10 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f), 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i13, scrollY, i14, i15, iMin);
        C9603h0.m59884g0(this);
    }

    public void setCurrentItem(int i10, boolean z10) throws Resources.NotFoundException {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, z10, false);
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i10));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new C0977f();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new RunnableC0974c();
        this.mScrollState = 0;
        initViewPager();
    }
}
