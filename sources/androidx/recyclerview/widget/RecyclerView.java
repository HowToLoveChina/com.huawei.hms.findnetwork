package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.C0862a;
import androidx.recyclerview.widget.C0865d;
import androidx.recyclerview.widget.C0877p;
import androidx.recyclerview.widget.C0881t;
import androidx.recyclerview.widget.C0882u;
import androidx.recyclerview.widget.RunnableC0869h;
import com.huawei.hms.network.embedded.C6051p9;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p024b0.C1094j;
import p243e0.C9373h;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9607j0;
import p273f0.C9630v;
import p273f0.C9634x;
import p273f0.InterfaceC9632w;
import p304g0.C9822b;
import p304g0.C9832l;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements InterfaceC9632w {
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    C0877p mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    AbstractC0838h mAdapter;
    C0862a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private InterfaceC0841k mChildDrawingOrderCallback;
    C0865d mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private C0842l mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    RunnableC0869h mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private InterfaceC0849s mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    AbstractC0843m mItemAnimator;
    private AbstractC0843m.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<AbstractC0845o> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    AbstractC0846p mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C0854x mObserver;
    private List<InterfaceC0847q> mOnChildAttachStateListeners;
    private AbstractC0848r mOnFlingListener;
    private final ArrayList<InterfaceC0849s> mOnItemTouchListeners;
    final List<AbstractC0833c0> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    RunnableC0869h.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final C0852v mRecycler;
    InterfaceC0853w mRecyclerListener;
    final List<InterfaceC0853w> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private AbstractC0850t mScrollListener;
    private List<AbstractC0850t> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private C9634x mScrollingChildHelper;
    final C0856z mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final RunnableC0831b0 mViewFlinger;
    private final C0882u.b mViewInfoProcessCallback;
    final C0882u mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a */
    public class RunnableC0828a implements Runnable {
        public RunnableC0828a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.mIsAttached) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.mLayoutSuppressed) {
                recyclerView2.mLayoutWasDefered = true;
            } else {
                recyclerView2.consumePendingUpdateOperations();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a0 */
    public static abstract class AbstractC0829a0 {
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b */
    public class RunnableC0830b implements Runnable {
        public RunnableC0830b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0843m abstractC0843m = RecyclerView.this.mItemAnimator;
            if (abstractC0843m != null) {
                abstractC0843m.runPendingAnimations();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b0 */
    public class RunnableC0831b0 implements Runnable {

        /* renamed from: a */
        public int f4319a;

        /* renamed from: b */
        public int f4320b;

        /* renamed from: c */
        public OverScroller f4321c;

        /* renamed from: d */
        public Interpolator f4322d;

        /* renamed from: e */
        public boolean f4323e;

        /* renamed from: f */
        public boolean f4324f;

        public RunnableC0831b0() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f4322d = interpolator;
            this.f4323e = false;
            this.f4324f = false;
            this.f4321c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        /* renamed from: a */
        public final int m5133a(int i10, int i11) {
            int iAbs = Math.abs(i10);
            int iAbs2 = Math.abs(i11);
            boolean z10 = iAbs > iAbs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z10) {
                iAbs = iAbs2;
            }
            return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }

        /* renamed from: c */
        public void m5134c(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f4320b = 0;
            this.f4319a = 0;
            Interpolator interpolator = this.f4322d;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f4322d = interpolator2;
                this.f4321c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f4321c.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m5136e();
        }

        /* renamed from: d */
        public final void m5135d() {
            RecyclerView.this.removeCallbacks(this);
            C9603h0.m59886h0(RecyclerView.this, this);
        }

        /* renamed from: e */
        public void m5136e() {
            if (this.f4323e) {
                this.f4324f = true;
            } else {
                m5135d();
            }
        }

        /* renamed from: f */
        public void m5137f(int i10, int i11, int i12, Interpolator interpolator) {
            if (i12 == Integer.MIN_VALUE) {
                i12 = m5133a(i10, i11);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f4322d != interpolator) {
                this.f4322d = interpolator;
                this.f4321c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f4320b = 0;
            this.f4319a = 0;
            RecyclerView.this.setScrollState(2);
            this.f4321c.startScroll(0, 0, i10, i11, i13);
            m5136e();
        }

        /* renamed from: g */
        public void m5138g() {
            RecyclerView.this.removeCallbacks(this);
            this.f4321c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            int i11;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                m5138g();
                return;
            }
            this.f4324f = false;
            this.f4323e = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f4321c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i12 = currX - this.f4319a;
                int i13 = currY - this.f4320b;
                this.f4319a = currX;
                this.f4320b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i12, i13, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i12 -= iArr2[0];
                    i13 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i12, i13);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i12, i13, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i11 = iArr4[0];
                    i10 = iArr4[1];
                    i12 -= i11;
                    i13 -= i10;
                    AbstractC0855y abstractC0855y = recyclerView4.mLayout.mSmoothScroller;
                    if (abstractC0855y != null && !abstractC0855y.isPendingInitialRun() && abstractC0855y.isRunning()) {
                        int iM5305b = RecyclerView.this.mState.m5305b();
                        if (iM5305b == 0) {
                            abstractC0855y.stop();
                        } else if (abstractC0855y.getTargetPosition() >= iM5305b) {
                            abstractC0855y.setTargetPosition(iM5305b - 1);
                            abstractC0855y.onAnimation(i11, i10);
                        } else {
                            abstractC0855y.onAnimation(i11, i10);
                        }
                    }
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i11, i10, i12, i13, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i14 = i12 - iArr6[0];
                int i15 = i13 - iArr6[1];
                if (i11 != 0 || i10 != 0) {
                    recyclerView6.dispatchOnScrolled(i11, i10);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i14 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i15 != 0));
                AbstractC0855y abstractC0855y2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((abstractC0855y2 == null || !abstractC0855y2.isPendingInitialRun()) && z10) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i16 = i14 < 0 ? -currVelocity : i14 > 0 ? currVelocity : 0;
                        if (i15 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i15 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i16, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.m5535b();
                    }
                } else {
                    m5136e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    RunnableC0869h runnableC0869h = recyclerView7.mGapWorker;
                    if (runnableC0869h != null) {
                        runnableC0869h.m5529g(recyclerView7, i11, i10);
                    }
                }
            }
            AbstractC0855y abstractC0855y3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (abstractC0855y3 != null && abstractC0855y3.isPendingInitialRun()) {
                abstractC0855y3.onAnimation(0, 0);
            }
            this.f4323e = false;
            if (this.f4324f) {
                m5135d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c */
    public class InterpolatorC0832c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c0 */
    public static abstract class AbstractC0833c0 {

        /* renamed from: t */
        public static final List<Object> f4326t = Collections.emptyList();

        /* renamed from: a */
        public final View f4327a;

        /* renamed from: b */
        public WeakReference<RecyclerView> f4328b;

        /* renamed from: j */
        public int f4336j;

        /* renamed from: r */
        public RecyclerView f4344r;

        /* renamed from: s */
        public AbstractC0838h<? extends AbstractC0833c0> f4345s;

        /* renamed from: c */
        public int f4329c = -1;

        /* renamed from: d */
        public int f4330d = -1;

        /* renamed from: e */
        public long f4331e = -1;

        /* renamed from: f */
        public int f4332f = -1;

        /* renamed from: g */
        public int f4333g = -1;

        /* renamed from: h */
        public AbstractC0833c0 f4334h = null;

        /* renamed from: i */
        public AbstractC0833c0 f4335i = null;

        /* renamed from: k */
        public List<Object> f4337k = null;

        /* renamed from: l */
        public List<Object> f4338l = null;

        /* renamed from: m */
        public int f4339m = 0;

        /* renamed from: n */
        public C0852v f4340n = null;

        /* renamed from: o */
        public boolean f4341o = false;

        /* renamed from: p */
        public int f4342p = 0;

        /* renamed from: q */
        public int f4343q = -1;

        public AbstractC0833c0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f4327a = view;
        }

        /* renamed from: A */
        public boolean m5139A() {
            return (this.f4336j & 2) != 0;
        }

        /* renamed from: B */
        public boolean m5140B() {
            return (this.f4336j & 2) != 0;
        }

        /* renamed from: C */
        public void m5141C(int i10, boolean z10) {
            if (this.f4330d == -1) {
                this.f4330d = this.f4329c;
            }
            if (this.f4333g == -1) {
                this.f4333g = this.f4329c;
            }
            if (z10) {
                this.f4333g += i10;
            }
            this.f4329c += i10;
            if (this.f4327a.getLayoutParams() != null) {
                ((LayoutParams) this.f4327a.getLayoutParams()).f4314c = true;
            }
        }

        /* renamed from: D */
        public void m5142D(RecyclerView recyclerView) {
            int i10 = this.f4343q;
            if (i10 != -1) {
                this.f4342p = i10;
            } else {
                this.f4342p = C9603h0.m59919y(this.f4327a);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* renamed from: E */
        public void m5143E(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.f4342p);
            this.f4342p = 0;
        }

        /* renamed from: F */
        public void m5144F() {
            this.f4336j = 0;
            this.f4329c = -1;
            this.f4330d = -1;
            this.f4331e = -1L;
            this.f4333g = -1;
            this.f4339m = 0;
            this.f4334h = null;
            this.f4335i = null;
            m5157d();
            this.f4342p = 0;
            this.f4343q = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* renamed from: G */
        public void m5145G() {
            if (this.f4330d == -1) {
                this.f4330d = this.f4329c;
            }
        }

        /* renamed from: H */
        public void m5146H(int i10, int i11) {
            this.f4336j = (i10 & i11) | (this.f4336j & (~i11));
        }

        /* renamed from: I */
        public final void m5147I(boolean z10) {
            int i10 = this.f4339m;
            int i11 = z10 ? i10 - 1 : i10 + 1;
            this.f4339m = i11;
            if (i11 < 0) {
                this.f4339m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z10 && i11 == 1) {
                this.f4336j |= 16;
            } else if (z10 && i11 == 0) {
                this.f4336j &= -17;
            }
        }

        /* renamed from: J */
        public void m5148J(C0852v c0852v, boolean z10) {
            this.f4340n = c0852v;
            this.f4341o = z10;
        }

        /* renamed from: K */
        public boolean m5149K() {
            return (this.f4336j & 16) != 0;
        }

        /* renamed from: L */
        public boolean m5150L() {
            return (this.f4336j & 128) != 0;
        }

        /* renamed from: M */
        public void m5151M() {
            this.f4336j &= -129;
        }

        /* renamed from: N */
        public void m5152N() {
            this.f4340n.m5267J(this);
        }

        /* renamed from: O */
        public boolean m5153O() {
            return (this.f4336j & 32) != 0;
        }

        /* renamed from: a */
        public void m5154a(Object obj) {
            if (obj == null) {
                m5155b(1024);
            } else if ((1024 & this.f4336j) == 0) {
                m5160g();
                this.f4337k.add(obj);
            }
        }

        /* renamed from: b */
        public void m5155b(int i10) {
            this.f4336j = i10 | this.f4336j;
        }

        /* renamed from: c */
        public void m5156c() {
            this.f4330d = -1;
            this.f4333g = -1;
        }

        /* renamed from: d */
        public void m5157d() {
            List<Object> list = this.f4337k;
            if (list != null) {
                list.clear();
            }
            this.f4336j &= -1025;
        }

        /* renamed from: e */
        public void m5158e() {
            this.f4336j &= -33;
        }

        /* renamed from: f */
        public void m5159f() {
            this.f4336j &= -257;
        }

        /* renamed from: g */
        public final void m5160g() {
            if (this.f4337k == null) {
                ArrayList arrayList = new ArrayList();
                this.f4337k = arrayList;
                this.f4338l = Collections.unmodifiableList(arrayList);
            }
        }

        /* renamed from: h */
        public boolean m5161h() {
            return (this.f4336j & 16) == 0 && C9603h0.m59861Q(this.f4327a);
        }

        /* renamed from: i */
        public void m5162i(int i10, int i11, boolean z10) {
            m5155b(8);
            m5141C(i11, z10);
            this.f4329c = i10;
        }

        /* renamed from: j */
        public final int m5163j() {
            RecyclerView recyclerView = this.f4344r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        /* renamed from: k */
        public final int m5164k() {
            return m5165l();
        }

        /* renamed from: l */
        public final int m5165l() {
            RecyclerView recyclerView;
            AbstractC0838h adapter;
            int adapterPositionInRecyclerView;
            if (this.f4345s == null || (recyclerView = this.f4344r) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.f4344r.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.m5210d(this.f4345s, this, adapterPositionInRecyclerView);
        }

        /* renamed from: m */
        public final long m5166m() {
            return this.f4331e;
        }

        /* renamed from: n */
        public final int m5167n() {
            return this.f4332f;
        }

        /* renamed from: o */
        public final int m5168o() {
            int i10 = this.f4333g;
            return i10 == -1 ? this.f4329c : i10;
        }

        /* renamed from: p */
        public final int m5169p() {
            return this.f4330d;
        }

        /* renamed from: q */
        public List<Object> m5170q() {
            if ((this.f4336j & 1024) != 0) {
                return f4326t;
            }
            List<Object> list = this.f4337k;
            return (list == null || list.size() == 0) ? f4326t : this.f4338l;
        }

        /* renamed from: r */
        public boolean m5171r(int i10) {
            return (this.f4336j & i10) != 0;
        }

        /* renamed from: s */
        public boolean m5172s() {
            return (this.f4336j & 512) != 0 || m5175v();
        }

        /* renamed from: t */
        public boolean m5173t() {
            return (this.f4327a.getParent() == null || this.f4327a.getParent() == this.f4344r) ? false : true;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f4329c + " id=" + this.f4331e + ", oldPos=" + this.f4330d + ", pLpos:" + this.f4333g);
            if (m5178y()) {
                sb2.append(" scrap ");
                sb2.append(this.f4341o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m5175v()) {
                sb2.append(" invalid");
            }
            if (!m5174u()) {
                sb2.append(" unbound");
            }
            if (m5140B()) {
                sb2.append(" update");
            }
            if (m5177x()) {
                sb2.append(" removed");
            }
            if (m5150L()) {
                sb2.append(" ignored");
            }
            if (m5179z()) {
                sb2.append(" tmpDetached");
            }
            if (!m5176w()) {
                sb2.append(" not recyclable(" + this.f4339m + ")");
            }
            if (m5172s()) {
                sb2.append(" undefined adapter position");
            }
            if (this.f4327a.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        /* renamed from: u */
        public boolean m5174u() {
            return (this.f4336j & 1) != 0;
        }

        /* renamed from: v */
        public boolean m5175v() {
            return (this.f4336j & 4) != 0;
        }

        /* renamed from: w */
        public final boolean m5176w() {
            return (this.f4336j & 16) == 0 && !C9603h0.m59861Q(this.f4327a);
        }

        /* renamed from: x */
        public boolean m5177x() {
            return (this.f4336j & 8) != 0;
        }

        /* renamed from: y */
        public boolean m5178y() {
            return this.f4340n != null;
        }

        /* renamed from: z */
        public boolean m5179z() {
            return (this.f4336j & 256) != 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$d */
    public class C0834d implements C0882u.b {
        public C0834d() {
        }

        @Override // androidx.recyclerview.widget.C0882u.b
        /* renamed from: a */
        public void mo5180a(AbstractC0833c0 abstractC0833c0) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.removeAndRecycleView(abstractC0833c0.f4327a, recyclerView.mRecycler);
        }

        @Override // androidx.recyclerview.widget.C0882u.b
        /* renamed from: b */
        public void mo5181b(AbstractC0833c0 abstractC0833c0, AbstractC0843m.c cVar, AbstractC0843m.c cVar2) {
            RecyclerView.this.animateAppearance(abstractC0833c0, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.C0882u.b
        /* renamed from: c */
        public void mo5182c(AbstractC0833c0 abstractC0833c0, AbstractC0843m.c cVar, AbstractC0843m.c cVar2) {
            RecyclerView.this.mRecycler.m5267J(abstractC0833c0);
            RecyclerView.this.animateDisappearance(abstractC0833c0, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.C0882u.b
        /* renamed from: d */
        public void mo5183d(AbstractC0833c0 abstractC0833c0, AbstractC0843m.c cVar, AbstractC0843m.c cVar2) {
            abstractC0833c0.m5147I(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.animateChange(abstractC0833c0, abstractC0833c0, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.animatePersistence(abstractC0833c0, cVar, cVar2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$e */
    public class C0835e implements C0865d.b {
        public C0835e() {
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: a */
        public View mo5184a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: b */
        public void mo5185b(View view) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.m5142D(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: c */
        public int mo5186c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: d */
        public void mo5187d() {
            int iMo5186c = mo5186c();
            for (int i10 = 0; i10 < iMo5186c; i10++) {
                View viewMo5184a = mo5184a(i10);
                RecyclerView.this.dispatchChildDetached(viewMo5184a);
                viewMo5184a.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: e */
        public int mo5188e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: f */
        public AbstractC0833c0 mo5189f(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: g */
        public void mo5190g(int i10) {
            AbstractC0833c0 childViewHolderInt;
            View viewMo5184a = mo5184a(i10);
            if (viewMo5184a != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(viewMo5184a)) != null) {
                if (childViewHolderInt.m5179z() && !childViewHolderInt.m5150L()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.m5155b(256);
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: h */
        public void mo5191h(View view) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.m5143E(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: i */
        public void mo5192i(View view, int i10) {
            RecyclerView.this.addView(view, i10);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: j */
        public void mo5193j(int i10) {
            View childAt = RecyclerView.this.getChildAt(i10);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i10);
        }

        @Override // androidx.recyclerview.widget.C0865d.b
        /* renamed from: k */
        public void mo5194k(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.m5179z() && !childViewHolderInt.m5150L()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.m5159f();
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$f */
    public class C0836f implements C0862a.a {
        public C0836f() {
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: a */
        public void mo5195a(int i10, int i11) {
            RecyclerView.this.offsetPositionRecordsForMove(i10, i11);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: b */
        public void mo5196b(C0862a.b bVar) {
            m5203i(bVar);
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: c */
        public void mo5197c(int i10, int i11, Object obj) {
            RecyclerView.this.viewRangeUpdate(i10, i11, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: d */
        public void mo5198d(C0862a.b bVar) {
            m5203i(bVar);
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: e */
        public AbstractC0833c0 mo5199e(int i10) {
            AbstractC0833c0 abstractC0833c0FindViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i10, true);
            if (abstractC0833c0FindViewHolderForPosition == null || RecyclerView.this.mChildHelper.m5452n(abstractC0833c0FindViewHolderForPosition.f4327a)) {
                return null;
            }
            return abstractC0833c0FindViewHolderForPosition;
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: f */
        public void mo5200f(int i10, int i11) {
            RecyclerView.this.offsetPositionRecordsForRemove(i10, i11, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: g */
        public void mo5201g(int i10, int i11) {
            RecyclerView.this.offsetPositionRecordsForInsert(i10, i11);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.C0862a.a
        /* renamed from: h */
        public void mo5202h(int i10, int i11) {
            RecyclerView.this.offsetPositionRecordsForRemove(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f4393d += i11;
        }

        /* renamed from: i */
        public void m5203i(C0862a.b bVar) {
            int i10 = bVar.f4471a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.onItemsAdded(recyclerView, bVar.f4472b, bVar.f4474d);
                return;
            }
            if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.onItemsRemoved(recyclerView2, bVar.f4472b, bVar.f4474d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.onItemsUpdated(recyclerView3, bVar.f4472b, bVar.f4474d, bVar.f4473c);
            } else {
                if (i10 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsMoved(recyclerView4, bVar.f4472b, bVar.f4474d, 1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$g */
    public static /* synthetic */ class C0837g {

        /* renamed from: a */
        public static final /* synthetic */ int[] f4349a;

        static {
            int[] iArr = new int[AbstractC0838h.a.values().length];
            f4349a = iArr;
            try {
                iArr[AbstractC0838h.a.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4349a[AbstractC0838h.a.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$h */
    public static abstract class AbstractC0838h<VH extends AbstractC0833c0> {

        /* renamed from: a */
        public final C0839i f4350a = new C0839i();

        /* renamed from: b */
        public boolean f4351b = false;

        /* renamed from: c */
        public a f4352c = a.ALLOW;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$h$a */
        public enum a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        /* renamed from: A */
        public void m5204A(AbstractC0840j abstractC0840j) {
            this.f4350a.registerObserver(abstractC0840j);
        }

        /* renamed from: B */
        public void m5205B(boolean z10) {
            if (m5211h()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f4351b = z10;
        }

        /* renamed from: C */
        public void m5206C(AbstractC0840j abstractC0840j) {
            this.f4350a.unregisterObserver(abstractC0840j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public final void m5207a(VH vh2, int i10) {
            boolean z10 = vh2.f4345s == null;
            if (z10) {
                vh2.f4329c = i10;
                if (m5212i()) {
                    vh2.f4331e = mo722f(i10);
                }
                vh2.m5146H(1, 519);
                C1094j.m6490a(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh2.f4345s = this;
            mo5222t(vh2, i10, vh2.m5170q());
            if (z10) {
                vh2.m5157d();
                ViewGroup.LayoutParams layoutParams = vh2.f4327a.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f4314c = true;
                }
                C1094j.m6491b();
            }
        }

        /* renamed from: b */
        public boolean m5208b() {
            int i10 = C0837g.f4349a[this.f4352c.ordinal()];
            if (i10 != 1) {
                return i10 != 2 || mo721e() > 0;
            }
            return false;
        }

        /* renamed from: c */
        public final VH m5209c(ViewGroup viewGroup, int i10) {
            try {
                C1094j.m6490a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh2 = (VH) mo724u(viewGroup, i10);
                if (vh2.f4327a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh2.f4332f = i10;
                return vh2;
            } finally {
                C1094j.m6491b();
            }
        }

        /* renamed from: d */
        public int m5210d(AbstractC0838h<? extends AbstractC0833c0> abstractC0838h, AbstractC0833c0 abstractC0833c0, int i10) {
            if (abstractC0838h == this) {
                return i10;
            }
            return -1;
        }

        /* renamed from: e */
        public abstract int mo721e();

        /* renamed from: f */
        public long mo722f(int i10) {
            return -1L;
        }

        /* renamed from: g */
        public int mo749g(int i10) {
            return 0;
        }

        /* renamed from: h */
        public final boolean m5211h() {
            return this.f4350a.m5228a();
        }

        /* renamed from: i */
        public final boolean m5212i() {
            return this.f4351b;
        }

        /* renamed from: j */
        public final void m5213j() {
            this.f4350a.m5229b();
        }

        /* renamed from: k */
        public final void m5214k(int i10) {
            this.f4350a.m5231d(i10, 1);
        }

        /* renamed from: l */
        public final void m5215l(int i10, Object obj) {
            this.f4350a.m5232e(i10, 1, obj);
        }

        /* renamed from: m */
        public final void m5216m(int i10, int i11) {
            this.f4350a.m5230c(i10, i11);
        }

        /* renamed from: n */
        public final void m5217n(int i10, int i11, Object obj) {
            this.f4350a.m5232e(i10, i11, obj);
        }

        /* renamed from: o */
        public final void m5218o(int i10, int i11) {
            this.f4350a.m5233f(i10, i11);
        }

        /* renamed from: p */
        public final void m5219p(int i10, int i11) {
            this.f4350a.m5234g(i10, i11);
        }

        /* renamed from: q */
        public final void m5220q(int i10) {
            this.f4350a.m5234g(i10, 1);
        }

        /* renamed from: r */
        public void mo5221r(RecyclerView recyclerView) {
        }

        /* renamed from: s */
        public abstract void mo723s(VH vh2, int i10);

        /* renamed from: t */
        public void mo5222t(VH vh2, int i10, List<Object> list) {
            mo723s(vh2, i10);
        }

        /* renamed from: u */
        public abstract VH mo724u(ViewGroup viewGroup, int i10);

        /* renamed from: v */
        public void m5223v(RecyclerView recyclerView) {
        }

        /* renamed from: w */
        public boolean m5224w(VH vh2) {
            return false;
        }

        /* renamed from: x */
        public void m5225x(VH vh2) {
        }

        /* renamed from: y */
        public void m5226y(VH vh2) {
        }

        /* renamed from: z */
        public void mo5227z(VH vh2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$i */
    public static class C0839i extends Observable<AbstractC0840j> {
        /* renamed from: a */
        public boolean m5228a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        /* renamed from: b */
        public void m5229b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0840j) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        /* renamed from: c */
        public void m5230c(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0840j) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i10, i11, 1);
            }
        }

        /* renamed from: d */
        public void m5231d(int i10, int i11) {
            m5232e(i10, i11, null);
        }

        /* renamed from: e */
        public void m5232e(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0840j) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11, obj);
            }
        }

        /* renamed from: f */
        public void m5233f(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0840j) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i10, i11);
            }
        }

        /* renamed from: g */
        public void m5234g(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0840j) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i10, i11);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$j */
    public static abstract class AbstractC0840j {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i10, int i11) {
        }

        public void onItemRangeInserted(int i10, int i11) {
        }

        public void onItemRangeMoved(int i10, int i11, int i12) {
        }

        public void onItemRangeRemoved(int i10, int i11) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i10, int i11, Object obj) {
            onItemRangeChanged(i10, i11);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$k */
    public interface InterfaceC0841k {
        int onGetChildDrawingOrder(int i10, int i11);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$l */
    public static class C0842l {
        /* renamed from: a */
        public EdgeEffect m5235a(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$m */
    public static abstract class AbstractC0843m {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private b mListener = null;
        private ArrayList<a> mFinishedListeners = new ArrayList<>();
        private long mAddDuration = 120;
        private long mRemoveDuration = 120;
        private long mMoveDuration = 250;
        private long mChangeDuration = 250;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$m$a */
        public interface a {
            /* renamed from: a */
            void m5236a();
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$m$b */
        public interface b {
            /* renamed from: a */
            void mo5237a(AbstractC0833c0 abstractC0833c0);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$m$c */
        public static class c {

            /* renamed from: a */
            public int f4357a;

            /* renamed from: b */
            public int f4358b;

            /* renamed from: c */
            public int f4359c;

            /* renamed from: d */
            public int f4360d;

            /* renamed from: a */
            public c m5238a(AbstractC0833c0 abstractC0833c0) {
                return m5239b(abstractC0833c0, 0);
            }

            /* renamed from: b */
            public c m5239b(AbstractC0833c0 abstractC0833c0, int i10) {
                View view = abstractC0833c0.f4327a;
                this.f4357a = view.getLeft();
                this.f4358b = view.getTop();
                this.f4359c = view.getRight();
                this.f4360d = view.getBottom();
                return this;
            }
        }

        public static int buildAdapterChangeFlagsForAnimations(AbstractC0833c0 abstractC0833c0) {
            int i10 = abstractC0833c0.f4336j;
            int i11 = i10 & 14;
            if (abstractC0833c0.m5175v()) {
                return 4;
            }
            if ((i10 & 4) != 0) {
                return i11;
            }
            int iM5169p = abstractC0833c0.m5169p();
            int iM5163j = abstractC0833c0.m5163j();
            return (iM5169p == -1 || iM5163j == -1 || iM5169p == iM5163j) ? i11 : i11 | 2048;
        }

        public abstract boolean animateAppearance(AbstractC0833c0 abstractC0833c0, c cVar, c cVar2);

        public abstract boolean animateChange(AbstractC0833c0 abstractC0833c0, AbstractC0833c0 abstractC0833c02, c cVar, c cVar2);

        public abstract boolean animateDisappearance(AbstractC0833c0 abstractC0833c0, c cVar, c cVar2);

        public abstract boolean animatePersistence(AbstractC0833c0 abstractC0833c0, c cVar, c cVar2);

        public boolean canReuseUpdatedViewHolder(AbstractC0833c0 abstractC0833c0) {
            return true;
        }

        public final void dispatchAnimationFinished(AbstractC0833c0 abstractC0833c0) {
            onAnimationFinished(abstractC0833c0);
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.mo5237a(abstractC0833c0);
            }
        }

        public final void dispatchAnimationStarted(AbstractC0833c0 abstractC0833c0) {
            onAnimationStarted(abstractC0833c0);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mFinishedListeners.get(i10).m5236a();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(AbstractC0833c0 abstractC0833c0);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(a aVar) {
            boolean zIsRunning = isRunning();
            if (aVar != null) {
                if (zIsRunning) {
                    this.mFinishedListeners.add(aVar);
                } else {
                    aVar.m5236a();
                }
            }
            return zIsRunning;
        }

        public c obtainHolderInfo() {
            return new c();
        }

        public void onAnimationFinished(AbstractC0833c0 abstractC0833c0) {
        }

        public void onAnimationStarted(AbstractC0833c0 abstractC0833c0) {
        }

        public c recordPostLayoutInformation(C0856z c0856z, AbstractC0833c0 abstractC0833c0) {
            return obtainHolderInfo().m5238a(abstractC0833c0);
        }

        public c recordPreLayoutInformation(C0856z c0856z, AbstractC0833c0 abstractC0833c0, int i10, List<Object> list) {
            return obtainHolderInfo().m5238a(abstractC0833c0);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j10) {
            this.mAddDuration = j10;
        }

        public void setChangeDuration(long j10) {
            this.mChangeDuration = j10;
        }

        public void setListener(b bVar) {
            this.mListener = bVar;
        }

        public void setMoveDuration(long j10) {
            this.mMoveDuration = j10;
        }

        public void setRemoveDuration(long j10) {
            this.mRemoveDuration = j10;
        }

        public boolean canReuseUpdatedViewHolder(AbstractC0833c0 abstractC0833c0, List<Object> list) {
            return canReuseUpdatedViewHolder(abstractC0833c0);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$n */
    public class C0844n implements AbstractC0843m.b {
        public C0844n() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m.b
        /* renamed from: a */
        public void mo5237a(AbstractC0833c0 abstractC0833c0) {
            abstractC0833c0.m5147I(true);
            if (abstractC0833c0.f4334h != null && abstractC0833c0.f4335i == null) {
                abstractC0833c0.f4334h = null;
            }
            abstractC0833c0.f4335i = null;
            if (abstractC0833c0.m5149K() || RecyclerView.this.removeAnimatingView(abstractC0833c0.f4327a) || !abstractC0833c0.m5179z()) {
                return;
            }
            RecyclerView.this.removeDetachedView(abstractC0833c0.f4327a, false);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$o */
    public static abstract class AbstractC0845o {
        @Deprecated
        public void getItemOffsets(Rect rect, int i10, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C0856z c0856z) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).m5125a(), recyclerView);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, C0856z c0856z) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C0856z c0856z) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$p */
    public static abstract class AbstractC0846p {
        boolean mAutoMeasure;
        C0865d mChildHelper;
        private int mHeight;
        private int mHeightMode;
        C0881t mHorizontalBoundCheck;
        private final C0881t.b mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;
        AbstractC0855y mSmoothScroller;
        C0881t mVerticalBoundCheck;
        private final C0881t.b mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$p$a */
        public class a implements C0881t.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: a */
            public View mo5240a(int i10) {
                return AbstractC0846p.this.getChildAt(i10);
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: b */
            public int mo5241b(View view) {
                return AbstractC0846p.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: c */
            public int mo5242c() {
                return AbstractC0846p.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: d */
            public int mo5243d() {
                return AbstractC0846p.this.getWidth() - AbstractC0846p.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: e */
            public int mo5244e(View view) {
                return AbstractC0846p.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$p$b */
        public class b implements C0881t.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: a */
            public View mo5240a(int i10) {
                return AbstractC0846p.this.getChildAt(i10);
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: b */
            public int mo5241b(View view) {
                return AbstractC0846p.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: c */
            public int mo5242c() {
                return AbstractC0846p.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: d */
            public int mo5243d() {
                return AbstractC0846p.this.getHeight() - AbstractC0846p.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.C0881t.b
            /* renamed from: e */
            public int mo5244e(View view) {
                return AbstractC0846p.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$p$c */
        public interface c {
            /* renamed from: a */
            void mo5245a(int i10, int i11);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$p$d */
        public static class d {

            /* renamed from: a */
            public int f4364a;

            /* renamed from: b */
            public int f4365b;

            /* renamed from: c */
            public boolean f4366c;

            /* renamed from: d */
            public boolean f4367d;
        }

        public AbstractC0846p() {
            a aVar = new a();
            this.mHorizontalBoundCheckCallback = aVar;
            b bVar = new b();
            this.mVerticalBoundCheckCallback = bVar;
            this.mHorizontalBoundCheck = new C0881t(aVar);
            this.mVerticalBoundCheck = new C0881t(bVar);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int i10, boolean z10) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z10 || childViewHolderInt.m5177x()) {
                this.mRecyclerView.mViewInfoStore.m5590b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m5604p(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.m5153O() || childViewHolderInt.m5178y()) {
                if (childViewHolderInt.m5178y()) {
                    childViewHolderInt.m5152N();
                } else {
                    childViewHolderInt.m5158e();
                }
                this.mChildHelper.m5441c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iM5451m = this.mChildHelper.m5451m(view);
                if (i10 == -1) {
                    i10 = this.mChildHelper.m5445g();
                }
                if (iM5451m == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (iM5451m != i10) {
                    this.mRecyclerView.mLayout.moveView(iM5451m, i10);
                }
            } else {
                this.mChildHelper.m5439a(view, i10, false);
                layoutParams.f4314c = true;
                AbstractC0855y abstractC0855y = this.mSmoothScroller;
                if (abstractC0855y != null && abstractC0855y.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.f4315d) {
                childViewHolderInt.f4327a.invalidate();
                layoutParams.f4315d = false;
            }
        }

        public static int chooseSize(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
        }

        private void detachViewInternal(int i10, View view) {
            this.mChildHelper.m5442d(i10);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x000c A[PHI: r3
  0x000c: PHI (r3v5 int) = (r3v0 int), (r3v2 int), (r3v0 int) binds: [B:24:0x0010, B:28:0x0016, B:21:0x000a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x000e  */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L10
                if (r3 < 0) goto Le
            Lc:
                r2 = r0
                goto L1e
            Le:
                r3 = r2
                goto L1e
            L10:
                if (r3 < 0) goto L13
                goto Lc
            L13:
                r4 = -1
                if (r3 != r4) goto L18
                r3 = r1
                goto Lc
            L18:
                r4 = -2
                if (r3 != r4) goto Le
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1
            L1e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AbstractC0846p.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i10 = left - paddingLeft;
            int iMin = Math.min(0, i10);
            int i11 = top - paddingTop;
            int iMin2 = Math.min(0, i11);
            int i12 = iWidth - width;
            int iMax = Math.max(0, i12);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i10, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i12);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i11, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public static d getProperties(Context context, AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i10, i11);
            dVar.f4364a = typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
            dVar.f4365b = typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
            dVar.f4366c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            dVar.f4367d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i10 < width && rect.right - i10 > paddingLeft && rect.top - i11 < height && rect.bottom - i11 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i10, int i11, int i12) {
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

        private void scrapOrRecycleView(C0852v c0852v, int i10, View view) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.m5150L()) {
                return;
            }
            if (childViewHolderInt.m5175v() && !childViewHolderInt.m5177x() && !this.mRecyclerView.mAdapter.m5212i()) {
                removeViewAt(i10);
                c0852v.m5260C(childViewHolderInt);
            } else {
                detachViewAt(i10);
                c0852v.m5261D(view);
                this.mRecyclerView.mViewInfoStore.m5599k(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i10, LayoutParams layoutParams) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.m5177x()) {
                this.mRecyclerView.mViewInfoStore.m5590b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m5604p(childViewHolderInt);
            }
            this.mChildHelper.m5441c(view, i10, layoutParams, childViewHolderInt.m5177x());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i10, int i11, C0856z c0856z, c cVar) {
        }

        public void collectInitialPrefetchPositions(int i10, c cVar) {
        }

        public int computeHorizontalScrollExtent(C0856z c0856z) {
            return 0;
        }

        public int computeHorizontalScrollOffset(C0856z c0856z) {
            return 0;
        }

        public int computeHorizontalScrollRange(C0856z c0856z) {
            return 0;
        }

        public int computeVerticalScrollExtent(C0856z c0856z) {
            return 0;
        }

        public int computeVerticalScrollOffset(C0856z c0856z) {
            return 0;
        }

        public int computeVerticalScrollRange(C0856z c0856z) {
            return 0;
        }

        public void detachAndScrapAttachedViews(C0852v c0852v) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(c0852v, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, C0852v c0852v) {
            scrapOrRecycleView(c0852v, this.mChildHelper.m5451m(view), view);
        }

        public void detachAndScrapViewAt(int i10, C0852v c0852v) {
            scrapOrRecycleView(c0852v, i10, getChildAt(i10));
        }

        public void detachView(View view) {
            int iM5451m = this.mChildHelper.m5451m(view);
            if (iM5451m >= 0) {
                detachViewInternal(iM5451m, view);
            }
        }

        public void detachViewAt(int i10) {
            detachViewInternal(i10, getChildAt(i10));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, C0852v c0852v) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, c0852v);
        }

        public void endAnimation(View view) {
            AbstractC0843m abstractC0843m = this.mRecyclerView.mItemAnimator;
            if (abstractC0843m != null) {
                abstractC0843m.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.m5452n(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public View findViewByPosition(int i10) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.m5168o() == i10 && !childViewHolderInt.m5150L() && (this.mRecyclerView.mState.m5308e() || !childViewHolderInt.m5177x())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4313b.bottom;
        }

        public View getChildAt(int i10) {
            C0865d c0865d = this.mChildHelper;
            if (c0865d != null) {
                return c0865d.m5444f(i10);
            }
            return null;
        }

        public int getChildCount() {
            C0865d c0865d = this.mChildHelper;
            if (c0865d != null) {
                return c0865d.m5445g();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(C0852v c0852v, C0856z c0856z) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4313b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4313b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.m5452n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            AbstractC0838h adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.mo721e();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).m5167n();
        }

        public int getLayoutDirection() {
            return C9603h0.m59832A(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4313b.left;
        }

        public int getMinimumHeight() {
            return C9603h0.m59834B(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return C9603h0.m59836C(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return C9603h0.m59840E(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return C9603h0.m59842F(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).m5125a();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4313b.right;
        }

        public int getRowCountForAccessibility(C0852v c0852v, C0856z c0856z) {
            return -1;
        }

        public int getSelectionModeForAccessibility(C0852v c0852v, C0856z c0856z) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4313b.top;
        }

        public void getTransformedBoundingBox(View view, boolean z10, Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f4313b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.m5155b(128);
            this.mRecyclerView.mViewInfoStore.m5605q(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(C0852v c0852v, C0856z c0856z) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            AbstractC0855y abstractC0855y = this.mSmoothScroller;
            return abstractC0855y != null && abstractC0855y.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z10, boolean z11) {
            boolean z12 = this.mHorizontalBoundCheck.m5583b(view, 24579) && this.mVerticalBoundCheck.m5583b(view, 24579);
            return z10 ? z12 : !z12;
        }

        public void layoutDecorated(View view, int i10, int i11, int i12, int i13) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4313b;
            view.layout(i10 + rect.left, i11 + rect.top, i12 - rect.right, i13 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i10, int i11, int i12, int i13) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f4313b;
            view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(View view, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i12 = i10 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i13 = i11 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i13, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i12 = i10 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i13 = i11 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i13, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i10, int i11) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                detachViewAt(i10);
                attachView(childAt, i11);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(int i10) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i10);
            }
        }

        public void offsetChildrenVertical(int i10) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i10);
            }
        }

        public void onAdapterChanged(AbstractC0838h abstractC0838h, AbstractC0838h abstractC0838h2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i10, int i11) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i10, C0852v c0852v, C0856z c0856z) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(C9832l c9832l) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, c9832l);
        }

        public void onInitializeAccessibilityNodeInfoForItem(C0852v c0852v, C0856z c0856z, View view, C9832l c9832l) {
        }

        public View onInterceptFocusSearch(View view, int i10) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11) {
        }

        public void onLayoutChildren(C0852v c0852v, C0856z c0856z) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(C0856z c0856z) {
        }

        public void onMeasure(C0852v c0852v, C0856z c0856z, int i10, int i11) {
            this.mRecyclerView.defaultOnMeasure(i10, i11);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i10) {
        }

        public void onSmoothScrollerStopped(AbstractC0855y abstractC0855y) {
            if (this.mSmoothScroller == abstractC0855y) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i10, bundle);
        }

        public boolean performAccessibilityActionForItem(C0852v c0852v, C0856z c0856z, View view, int i10, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                C9603h0.m59886h0(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.m5455q(childCount);
            }
        }

        public void removeAndRecycleAllViews(C0852v c0852v) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).m5150L()) {
                    removeAndRecycleViewAt(childCount, c0852v);
                }
            }
        }

        public void removeAndRecycleScrapInt(C0852v c0852v) {
            int iM5280j = c0852v.m5280j();
            for (int i10 = iM5280j - 1; i10 >= 0; i10--) {
                View viewM5284n = c0852v.m5284n(i10);
                AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM5284n);
                if (!childViewHolderInt.m5150L()) {
                    childViewHolderInt.m5147I(false);
                    if (childViewHolderInt.m5179z()) {
                        this.mRecyclerView.removeDetachedView(viewM5284n, false);
                    }
                    AbstractC0843m abstractC0843m = this.mRecyclerView.mItemAnimator;
                    if (abstractC0843m != null) {
                        abstractC0843m.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.m5147I(true);
                    c0852v.m5295y(viewM5284n);
                }
            }
            c0852v.m5275e();
            if (iM5280j > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, C0852v c0852v) {
            removeView(view);
            c0852v.m5259B(view);
        }

        public void removeAndRecycleViewAt(int i10, C0852v c0852v) {
            View childAt = getChildAt(i10);
            removeViewAt(i10);
            c0852v.m5259B(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.mChildHelper.m5454p(view);
        }

        public void removeViewAt(int i10) {
            if (getChildAt(i10) != null) {
                this.mChildHelper.m5455q(i10);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z10, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i10, C0852v c0852v, C0856z c0856z) {
            return 0;
        }

        public void scrollToPosition(int i10) {
        }

        public int scrollVerticallyBy(int i10, C0852v c0852v, C0856z c0856z) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z10) {
            this.mAutoMeasure = z10;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z10) {
            if (z10 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z10;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.m5268K();
                }
            }
        }

        public void setMeasureSpecs(int i10, int i11) {
            this.mWidth = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(Rect rect, int i10, int i11) {
            setMeasuredDimension(chooseSize(i10, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i11, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i10, int i11) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MAX_VALUE;
            int i14 = Integer.MIN_VALUE;
            int i15 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i17 = rect.left;
                if (i17 < i15) {
                    i15 = i17;
                }
                int i18 = rect.right;
                if (i18 > i12) {
                    i12 = i18;
                }
                int i19 = rect.top;
                if (i19 < i13) {
                    i13 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i14) {
                    i14 = i20;
                }
            }
            this.mRecyclerView.mTempRect.set(i15, i13, i12, i14);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i10, i11);
        }

        public void setMeasurementCacheEnabled(boolean z10) {
            this.mMeasurementCacheEnabled = z10;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i10, int i11, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i10, int i11, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C0856z c0856z, int i10) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(AbstractC0855y abstractC0855y) {
            AbstractC0855y abstractC0855y2 = this.mSmoothScroller;
            if (abstractC0855y2 != null && abstractC0855y != abstractC0855y2 && abstractC0855y2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = abstractC0855y;
            abstractC0855y.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.m5151M();
            childViewHolderInt.m5144F();
            childViewHolderInt.m5155b(4);
        }

        public void stopSmoothScroller() {
            AbstractC0855y abstractC0855y = this.mSmoothScroller;
            if (abstractC0855y != null) {
                abstractC0855y.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i10) {
            addViewInt(view, i10, true);
        }

        public void addView(View view, int i10) {
            addViewInt(view, i10, false);
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, C0852v c0852v) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(C0852v c0852v, C0856z c0856z, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            AbstractC0838h abstractC0838h = this.mRecyclerView.mAdapter;
            if (abstractC0838h != null) {
                accessibilityEvent.setItemCount(abstractC0838h.mo721e());
            }
        }

        public void onInitializeAccessibilityNodeInfo(C0852v c0852v, C0856z c0856z, C9832l c9832l) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                c9832l.m61071a(8192);
                c9832l.m61102q0(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                c9832l.m61071a(4096);
                c9832l.m61102q0(true);
            }
            c9832l.m61067W(C9832l.b.m61126b(getRowCountForAccessibility(c0852v, c0856z), getColumnCountForAccessibility(c0852v, c0856z), isLayoutHierarchical(c0852v, c0856z), getSelectionModeForAccessibility(c0852v, c0856z)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, C9832l c9832l) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.m5177x() || this.mChildHelper.m5452n(childViewHolderInt.f4327a)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, c9832l);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
            onItemsUpdated(recyclerView, i10, i11);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, C0856z c0856z, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(C0852v c0852v, C0856z c0856z, int i10, Bundle bundle) {
            int height;
            int width;
            int i11;
            int i12;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i10 == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i11 = height;
                    i12 = width;
                }
                i11 = height;
                i12 = 0;
            } else if (i10 != 8192) {
                i12 = 0;
                i11 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i11 = height;
                    i12 = width;
                }
                i11 = height;
                i12 = 0;
            }
            if (i11 == 0 && i12 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i12, i11, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i10, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i10 = childRectangleOnScreenScrollAmount[0];
            int i11 = childRectangleOnScreenScrollAmount[1];
            if ((z11 && !isFocusedChildVisibleAfterScrolling(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.smoothScrollBy(i10, i11);
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1d
                if (r7 < 0) goto L12
            L10:
                r5 = r3
                goto L30
            L12:
                if (r7 != r1) goto L1a
                if (r5 == r2) goto L22
                if (r5 == 0) goto L1a
                if (r5 == r3) goto L22
            L1a:
                r5 = r6
                r7 = r5
                goto L30
            L1d:
                if (r7 < 0) goto L20
                goto L10
            L20:
                if (r7 != r1) goto L24
            L22:
                r7 = r4
                goto L30
            L24:
                if (r7 != r0) goto L1a
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2b
                goto L2e
            L2b:
                r7 = r4
                r5 = r6
                goto L30
            L2e:
                r7 = r4
                r5 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AbstractC0846p.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void attachView(View view, int i10) {
            attachView(view, i10, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i10, int i11) {
            this.mRecyclerView.setMeasuredDimension(i10, i11);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$q */
    public interface InterfaceC0847q {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$r */
    public static abstract class AbstractC0848r {
        public abstract boolean onFling(int i10, int i11);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$s */
    public interface InterfaceC0849s {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z10);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$t */
    public static abstract class AbstractC0850t {
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$u */
    public static class C0851u {

        /* renamed from: a */
        public SparseArray<a> f4368a = new SparseArray<>();

        /* renamed from: b */
        public int f4369b = 0;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$u$a */
        public static class a {

            /* renamed from: a */
            public final ArrayList<AbstractC0833c0> f4370a = new ArrayList<>();

            /* renamed from: b */
            public int f4371b = 5;

            /* renamed from: c */
            public long f4372c = 0;

            /* renamed from: d */
            public long f4373d = 0;
        }

        /* renamed from: a */
        public void m5246a() {
            this.f4369b++;
        }

        /* renamed from: b */
        public void m5247b() {
            for (int i10 = 0; i10 < this.f4368a.size(); i10++) {
                this.f4368a.valueAt(i10).f4370a.clear();
            }
        }

        /* renamed from: c */
        public void m5248c() {
            this.f4369b--;
        }

        /* renamed from: d */
        public void m5249d(int i10, long j10) {
            a aVarM5252g = m5252g(i10);
            aVarM5252g.f4373d = m5255j(aVarM5252g.f4373d, j10);
        }

        /* renamed from: e */
        public void m5250e(int i10, long j10) {
            a aVarM5252g = m5252g(i10);
            aVarM5252g.f4372c = m5255j(aVarM5252g.f4372c, j10);
        }

        /* renamed from: f */
        public AbstractC0833c0 m5251f(int i10) {
            a aVar = this.f4368a.get(i10);
            if (aVar == null || aVar.f4370a.isEmpty()) {
                return null;
            }
            ArrayList<AbstractC0833c0> arrayList = aVar.f4370a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).m5173t()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* renamed from: g */
        public final a m5252g(int i10) {
            a aVar = this.f4368a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f4368a.put(i10, aVar2);
            return aVar2;
        }

        /* renamed from: h */
        public void m5253h(AbstractC0838h abstractC0838h, AbstractC0838h abstractC0838h2, boolean z10) {
            if (abstractC0838h != null) {
                m5248c();
            }
            if (!z10 && this.f4369b == 0) {
                m5247b();
            }
            if (abstractC0838h2 != null) {
                m5246a();
            }
        }

        /* renamed from: i */
        public void m5254i(AbstractC0833c0 abstractC0833c0) {
            int iM5167n = abstractC0833c0.m5167n();
            ArrayList<AbstractC0833c0> arrayList = m5252g(iM5167n).f4370a;
            if (this.f4368a.get(iM5167n).f4371b <= arrayList.size()) {
                return;
            }
            abstractC0833c0.m5144F();
            arrayList.add(abstractC0833c0);
        }

        /* renamed from: j */
        public long m5255j(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        /* renamed from: k */
        public boolean m5256k(int i10, long j10, long j11) {
            long j12 = m5252g(i10).f4373d;
            return j12 == 0 || j10 + j12 < j11;
        }

        /* renamed from: l */
        public boolean m5257l(int i10, long j10, long j11) {
            long j12 = m5252g(i10).f4372c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$v */
    public final class C0852v {

        /* renamed from: a */
        public final ArrayList<AbstractC0833c0> f4374a;

        /* renamed from: b */
        public ArrayList<AbstractC0833c0> f4375b;

        /* renamed from: c */
        public final ArrayList<AbstractC0833c0> f4376c;

        /* renamed from: d */
        public final List<AbstractC0833c0> f4377d;

        /* renamed from: e */
        public int f4378e;

        /* renamed from: f */
        public int f4379f;

        /* renamed from: g */
        public C0851u f4380g;

        public C0852v() {
            ArrayList<AbstractC0833c0> arrayList = new ArrayList<>();
            this.f4374a = arrayList;
            this.f4375b = null;
            this.f4376c = new ArrayList<>();
            this.f4377d = Collections.unmodifiableList(arrayList);
            this.f4378e = 2;
            this.f4379f = 2;
        }

        /* renamed from: A */
        public void m5258A(int i10) {
            m5271a(this.f4376c.get(i10), true);
            this.f4376c.remove(i10);
        }

        /* renamed from: B */
        public void m5259B(View view) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.m5179z()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.m5178y()) {
                childViewHolderInt.m5152N();
            } else if (childViewHolderInt.m5153O()) {
                childViewHolderInt.m5158e();
            }
            m5260C(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.m5176w()) {
                return;
            }
            RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
        }

        /* renamed from: C */
        public void m5260C(AbstractC0833c0 abstractC0833c0) {
            boolean z10;
            boolean z11 = true;
            if (abstractC0833c0.m5178y() || abstractC0833c0.f4327a.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(abstractC0833c0.m5178y());
                sb2.append(" isAttached:");
                sb2.append(abstractC0833c0.f4327a.getParent() != null);
                sb2.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (abstractC0833c0.m5179z()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + abstractC0833c0 + RecyclerView.this.exceptionLabel());
            }
            if (abstractC0833c0.m5150L()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean zM5161h = abstractC0833c0.m5161h();
            AbstractC0838h abstractC0838h = RecyclerView.this.mAdapter;
            if ((abstractC0838h != null && zM5161h && abstractC0838h.m5224w(abstractC0833c0)) || abstractC0833c0.m5176w()) {
                if (this.f4379f <= 0 || abstractC0833c0.m5171r(526)) {
                    z10 = false;
                } else {
                    int size = this.f4376c.size();
                    if (size >= this.f4379f && size > 0) {
                        m5258A(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.m5537d(abstractC0833c0.f4329c)) {
                        int i10 = size - 1;
                        while (i10 >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.m5537d(this.f4376c.get(i10).f4329c)) {
                                break;
                            } else {
                                i10--;
                            }
                        }
                        size = i10 + 1;
                    }
                    this.f4376c.add(size, abstractC0833c0);
                    z10 = true;
                }
                if (z10) {
                    z11 = false;
                } else {
                    m5271a(abstractC0833c0, true);
                }
                z = z10;
            } else {
                z11 = false;
            }
            RecyclerView.this.mViewInfoStore.m5605q(abstractC0833c0);
            if (z || z11 || !zM5161h) {
                return;
            }
            abstractC0833c0.f4345s = null;
            abstractC0833c0.f4344r = null;
        }

        /* renamed from: D */
        public void m5261D(View view) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.m5171r(12) && childViewHolderInt.m5139A() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f4375b == null) {
                    this.f4375b = new ArrayList<>();
                }
                childViewHolderInt.m5148J(this, true);
                this.f4375b.add(childViewHolderInt);
                return;
            }
            if (!childViewHolderInt.m5175v() || childViewHolderInt.m5177x() || RecyclerView.this.mAdapter.m5212i()) {
                childViewHolderInt.m5148J(this, false);
                this.f4374a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        /* renamed from: E */
        public void m5262E(C0851u c0851u) {
            C0851u c0851u2 = this.f4380g;
            if (c0851u2 != null) {
                c0851u2.m5248c();
            }
            this.f4380g = c0851u;
            if (c0851u == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f4380g.m5246a();
        }

        /* renamed from: F */
        public void m5263F(AbstractC0829a0 abstractC0829a0) {
        }

        /* renamed from: G */
        public void m5264G(int i10) {
            this.f4378e = i10;
            m5268K();
        }

        /* renamed from: H */
        public final boolean m5265H(AbstractC0833c0 abstractC0833c0, int i10, int i11, long j10) {
            abstractC0833c0.f4345s = null;
            abstractC0833c0.f4344r = RecyclerView.this;
            int iM5167n = abstractC0833c0.m5167n();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != RecyclerView.FOREVER_NS && !this.f4380g.m5256k(iM5167n, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.mAdapter.m5207a(abstractC0833c0, i10);
            this.f4380g.m5249d(abstractC0833c0.m5167n(), RecyclerView.this.getNanoTime() - nanoTime);
            m5272b(abstractC0833c0);
            if (!RecyclerView.this.mState.m5308e()) {
                return true;
            }
            abstractC0833c0.f4333g = i11;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x00f5 A[PHI: r1 r4
  0x00f5: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$c0) = (r1v11 androidx.recyclerview.widget.RecyclerView$c0), (r1v30 androidx.recyclerview.widget.RecyclerView$c0) binds: [B:127:0x005d, B:144:0x00ad] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:127:0x005d, B:144:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:167:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x01d4 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:193:0x01d7  */
        /* renamed from: I */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.recyclerview.widget.RecyclerView.AbstractC0833c0 m5266I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 531
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C0852v.m5266I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$c0");
        }

        /* renamed from: J */
        public void m5267J(AbstractC0833c0 abstractC0833c0) {
            if (abstractC0833c0.f4341o) {
                this.f4375b.remove(abstractC0833c0);
            } else {
                this.f4374a.remove(abstractC0833c0);
            }
            abstractC0833c0.f4340n = null;
            abstractC0833c0.f4341o = false;
            abstractC0833c0.m5158e();
        }

        /* renamed from: K */
        public void m5268K() {
            AbstractC0846p abstractC0846p = RecyclerView.this.mLayout;
            this.f4379f = this.f4378e + (abstractC0846p != null ? abstractC0846p.mPrefetchMaxCountObserved : 0);
            for (int size = this.f4376c.size() - 1; size >= 0 && this.f4376c.size() > this.f4379f; size--) {
                m5258A(size);
            }
        }

        /* renamed from: L */
        public boolean m5269L(AbstractC0833c0 abstractC0833c0) {
            if (abstractC0833c0.m5177x()) {
                return RecyclerView.this.mState.m5308e();
            }
            int i10 = abstractC0833c0.f4329c;
            if (i10 >= 0 && i10 < RecyclerView.this.mAdapter.mo721e()) {
                if (RecyclerView.this.mState.m5308e() || RecyclerView.this.mAdapter.mo749g(abstractC0833c0.f4329c) == abstractC0833c0.m5167n()) {
                    return !RecyclerView.this.mAdapter.m5212i() || abstractC0833c0.m5166m() == RecyclerView.this.mAdapter.mo722f(abstractC0833c0.f4329c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + abstractC0833c0 + RecyclerView.this.exceptionLabel());
        }

        /* renamed from: M */
        public void m5270M(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f4376c.size() - 1; size >= 0; size--) {
                AbstractC0833c0 abstractC0833c0 = this.f4376c.get(size);
                if (abstractC0833c0 != null && (i12 = abstractC0833c0.f4329c) >= i10 && i12 < i13) {
                    abstractC0833c0.m5155b(2);
                    m5258A(size);
                }
            }
        }

        /* renamed from: a */
        public void m5271a(AbstractC0833c0 abstractC0833c0, boolean z10) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(abstractC0833c0);
            View view = abstractC0833c0.f4327a;
            C0877p c0877p = RecyclerView.this.mAccessibilityDelegate;
            if (c0877p != null) {
                C9582a c9582aM5575b = c0877p.m5575b();
                C9603h0.m59902p0(view, c9582aM5575b instanceof C0877p.a ? ((C0877p.a) c9582aM5575b).m5577a(view) : null);
            }
            if (z10) {
                m5277g(abstractC0833c0);
            }
            abstractC0833c0.f4345s = null;
            abstractC0833c0.f4344r = null;
            m5279i().m5254i(abstractC0833c0);
        }

        /* renamed from: b */
        public final void m5272b(AbstractC0833c0 abstractC0833c0) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = abstractC0833c0.f4327a;
                if (C9603h0.m59919y(view) == 0) {
                    C9603h0.m59833A0(view, 1);
                }
                C0877p c0877p = RecyclerView.this.mAccessibilityDelegate;
                if (c0877p == null) {
                    return;
                }
                C9582a c9582aM5575b = c0877p.m5575b();
                if (c9582aM5575b instanceof C0877p.a) {
                    ((C0877p.a) c9582aM5575b).m5578b(view);
                }
                C9603h0.m59902p0(view, c9582aM5575b);
            }
        }

        /* renamed from: c */
        public void m5273c() {
            this.f4374a.clear();
            m5296z();
        }

        /* renamed from: d */
        public void m5274d() {
            int size = this.f4376c.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f4376c.get(i10).m5156c();
            }
            int size2 = this.f4374a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f4374a.get(i11).m5156c();
            }
            ArrayList<AbstractC0833c0> arrayList = this.f4375b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    this.f4375b.get(i12).m5156c();
                }
            }
        }

        /* renamed from: e */
        public void m5275e() {
            this.f4374a.clear();
            ArrayList<AbstractC0833c0> arrayList = this.f4375b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* renamed from: f */
        public int m5276f(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.mState.m5305b()) {
                return !RecyclerView.this.mState.m5308e() ? i10 : RecyclerView.this.mAdapterHelper.m5419m(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.mState.m5305b() + RecyclerView.this.exceptionLabel());
        }

        /* renamed from: g */
        public void m5277g(AbstractC0833c0 abstractC0833c0) {
            InterfaceC0853w interfaceC0853w = RecyclerView.this.mRecyclerListener;
            if (interfaceC0853w != null) {
                interfaceC0853w.m5297a(abstractC0833c0);
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView.this.mRecyclerListeners.get(i10).m5297a(abstractC0833c0);
            }
            AbstractC0838h abstractC0838h = RecyclerView.this.mAdapter;
            if (abstractC0838h != null) {
                abstractC0838h.mo5227z(abstractC0833c0);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.m5605q(abstractC0833c0);
            }
        }

        /* renamed from: h */
        public AbstractC0833c0 m5278h(int i10) {
            int size;
            int iM5419m;
            ArrayList<AbstractC0833c0> arrayList = this.f4375b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    AbstractC0833c0 abstractC0833c0 = this.f4375b.get(i11);
                    if (!abstractC0833c0.m5153O() && abstractC0833c0.m5168o() == i10) {
                        abstractC0833c0.m5155b(32);
                        return abstractC0833c0;
                    }
                }
                if (RecyclerView.this.mAdapter.m5212i() && (iM5419m = RecyclerView.this.mAdapterHelper.m5419m(i10)) > 0 && iM5419m < RecyclerView.this.mAdapter.mo721e()) {
                    long jMo722f = RecyclerView.this.mAdapter.mo722f(iM5419m);
                    for (int i12 = 0; i12 < size; i12++) {
                        AbstractC0833c0 abstractC0833c02 = this.f4375b.get(i12);
                        if (!abstractC0833c02.m5153O() && abstractC0833c02.m5166m() == jMo722f) {
                            abstractC0833c02.m5155b(32);
                            return abstractC0833c02;
                        }
                    }
                }
            }
            return null;
        }

        /* renamed from: i */
        public C0851u m5279i() {
            if (this.f4380g == null) {
                this.f4380g = new C0851u();
            }
            return this.f4380g;
        }

        /* renamed from: j */
        public int m5280j() {
            return this.f4374a.size();
        }

        /* renamed from: k */
        public List<AbstractC0833c0> m5281k() {
            return this.f4377d;
        }

        /* renamed from: l */
        public AbstractC0833c0 m5282l(long j10, int i10, boolean z10) {
            for (int size = this.f4374a.size() - 1; size >= 0; size--) {
                AbstractC0833c0 abstractC0833c0 = this.f4374a.get(size);
                if (abstractC0833c0.m5166m() == j10 && !abstractC0833c0.m5153O()) {
                    if (i10 == abstractC0833c0.m5167n()) {
                        abstractC0833c0.m5155b(32);
                        if (abstractC0833c0.m5177x() && !RecyclerView.this.mState.m5308e()) {
                            abstractC0833c0.m5146H(2, 14);
                        }
                        return abstractC0833c0;
                    }
                    if (!z10) {
                        this.f4374a.remove(size);
                        RecyclerView.this.removeDetachedView(abstractC0833c0.f4327a, false);
                        m5295y(abstractC0833c0.f4327a);
                    }
                }
            }
            int size2 = this.f4376c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                AbstractC0833c0 abstractC0833c02 = this.f4376c.get(size2);
                if (abstractC0833c02.m5166m() == j10 && !abstractC0833c02.m5173t()) {
                    if (i10 == abstractC0833c02.m5167n()) {
                        if (!z10) {
                            this.f4376c.remove(size2);
                        }
                        return abstractC0833c02;
                    }
                    if (!z10) {
                        m5258A(size2);
                        return null;
                    }
                }
            }
        }

        /* renamed from: m */
        public AbstractC0833c0 m5283m(int i10, boolean z10) {
            View viewM5443e;
            int size = this.f4374a.size();
            for (int i11 = 0; i11 < size; i11++) {
                AbstractC0833c0 abstractC0833c0 = this.f4374a.get(i11);
                if (!abstractC0833c0.m5153O() && abstractC0833c0.m5168o() == i10 && !abstractC0833c0.m5175v() && (RecyclerView.this.mState.f4397h || !abstractC0833c0.m5177x())) {
                    abstractC0833c0.m5155b(32);
                    return abstractC0833c0;
                }
            }
            if (z10 || (viewM5443e = RecyclerView.this.mChildHelper.m5443e(i10)) == null) {
                int size2 = this.f4376c.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    AbstractC0833c0 abstractC0833c02 = this.f4376c.get(i12);
                    if (!abstractC0833c02.m5175v() && abstractC0833c02.m5168o() == i10 && !abstractC0833c02.m5173t()) {
                        if (!z10) {
                            this.f4376c.remove(i12);
                        }
                        return abstractC0833c02;
                    }
                }
                return null;
            }
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM5443e);
            RecyclerView.this.mChildHelper.m5457s(viewM5443e);
            int iM5451m = RecyclerView.this.mChildHelper.m5451m(viewM5443e);
            if (iM5451m != -1) {
                RecyclerView.this.mChildHelper.m5442d(iM5451m);
                m5261D(viewM5443e);
                childViewHolderInt.m5155b(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        /* renamed from: n */
        public View m5284n(int i10) {
            return this.f4374a.get(i10).f4327a;
        }

        /* renamed from: o */
        public View m5285o(int i10) {
            return m5286p(i10, false);
        }

        /* renamed from: p */
        public View m5286p(int i10, boolean z10) {
            return m5266I(i10, z10, RecyclerView.FOREVER_NS).f4327a;
        }

        /* renamed from: q */
        public final void m5287q(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m5287q((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* renamed from: r */
        public final void m5288r(AbstractC0833c0 abstractC0833c0) {
            View view = abstractC0833c0.f4327a;
            if (view instanceof ViewGroup) {
                m5287q((ViewGroup) view, false);
            }
        }

        /* renamed from: s */
        public void m5289s() {
            int size = this.f4376c.size();
            for (int i10 = 0; i10 < size; i10++) {
                LayoutParams layoutParams = (LayoutParams) this.f4376c.get(i10).f4327a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f4314c = true;
                }
            }
        }

        /* renamed from: t */
        public void m5290t() {
            int size = this.f4376c.size();
            for (int i10 = 0; i10 < size; i10++) {
                AbstractC0833c0 abstractC0833c0 = this.f4376c.get(i10);
                if (abstractC0833c0 != null) {
                    abstractC0833c0.m5155b(6);
                    abstractC0833c0.m5154a(null);
                }
            }
            AbstractC0838h abstractC0838h = RecyclerView.this.mAdapter;
            if (abstractC0838h == null || !abstractC0838h.m5212i()) {
                m5296z();
            }
        }

        /* renamed from: u */
        public void m5291u(int i10, int i11) {
            int size = this.f4376c.size();
            for (int i12 = 0; i12 < size; i12++) {
                AbstractC0833c0 abstractC0833c0 = this.f4376c.get(i12);
                if (abstractC0833c0 != null && abstractC0833c0.f4329c >= i10) {
                    abstractC0833c0.m5141C(i11, false);
                }
            }
        }

        /* renamed from: v */
        public void m5292v(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (i10 < i11) {
                i12 = -1;
                i14 = i10;
                i13 = i11;
            } else {
                i12 = 1;
                i13 = i10;
                i14 = i11;
            }
            int size = this.f4376c.size();
            for (int i16 = 0; i16 < size; i16++) {
                AbstractC0833c0 abstractC0833c0 = this.f4376c.get(i16);
                if (abstractC0833c0 != null && (i15 = abstractC0833c0.f4329c) >= i14 && i15 <= i13) {
                    if (i15 == i10) {
                        abstractC0833c0.m5141C(i11 - i10, false);
                    } else {
                        abstractC0833c0.m5141C(i12, false);
                    }
                }
            }
        }

        /* renamed from: w */
        public void m5293w(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f4376c.size() - 1; size >= 0; size--) {
                AbstractC0833c0 abstractC0833c0 = this.f4376c.get(size);
                if (abstractC0833c0 != null) {
                    int i13 = abstractC0833c0.f4329c;
                    if (i13 >= i12) {
                        abstractC0833c0.m5141C(-i11, z10);
                    } else if (i13 >= i10) {
                        abstractC0833c0.m5155b(8);
                        m5258A(size);
                    }
                }
            }
        }

        /* renamed from: x */
        public void m5294x(AbstractC0838h abstractC0838h, AbstractC0838h abstractC0838h2, boolean z10) {
            m5273c();
            m5279i().m5253h(abstractC0838h, abstractC0838h2, z10);
        }

        /* renamed from: y */
        public void m5295y(View view) {
            AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.f4340n = null;
            childViewHolderInt.f4341o = false;
            childViewHolderInt.m5158e();
            m5260C(childViewHolderInt);
        }

        /* renamed from: z */
        public void m5296z() {
            for (int size = this.f4376c.size() - 1; size >= 0; size--) {
                m5258A(size);
            }
            this.f4376c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.m5535b();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$w */
    public interface InterfaceC0853w {
        /* renamed from: a */
        void m5297a(AbstractC0833c0 abstractC0833c0);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$x */
    public class C0854x extends AbstractC0840j {
        public C0854x() {
        }

        /* renamed from: a */
        public void m5298a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    C9603h0.m59886h0(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f4396g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.m5422p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m5424r(i10, i11, obj)) {
                m5298a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeInserted(int i10, int i11) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m5425s(i10, i11)) {
                m5298a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeMoved(int i10, int i11, int i12) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m5426t(i10, i11, i12)) {
                m5298a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeRemoved(int i10, int i11) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m5427u(i10, i11)) {
                m5298a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onStateRestorationPolicyChanged() {
            AbstractC0838h abstractC0838h;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState == null || (abstractC0838h = recyclerView.mAdapter) == null || !abstractC0838h.m5208b()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$y */
    public static abstract class AbstractC0855y {
        private AbstractC0846p mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final a mRecyclingAction = new a(0, 0);

        /* renamed from: androidx.recyclerview.widget.RecyclerView$y$a */
        public static class a {

            /* renamed from: a */
            public int f4383a;

            /* renamed from: b */
            public int f4384b;

            /* renamed from: c */
            public int f4385c;

            /* renamed from: d */
            public int f4386d;

            /* renamed from: e */
            public Interpolator f4387e;

            /* renamed from: f */
            public boolean f4388f;

            /* renamed from: g */
            public int f4389g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, null);
            }

            /* renamed from: a */
            public boolean m5299a() {
                return this.f4386d >= 0;
            }

            /* renamed from: b */
            public void m5300b(int i10) {
                this.f4386d = i10;
            }

            /* renamed from: c */
            public void m5301c(RecyclerView recyclerView) {
                int i10 = this.f4386d;
                if (i10 >= 0) {
                    this.f4386d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i10);
                    this.f4388f = false;
                } else {
                    if (!this.f4388f) {
                        this.f4389g = 0;
                        return;
                    }
                    m5303e();
                    recyclerView.mViewFlinger.m5137f(this.f4383a, this.f4384b, this.f4385c, this.f4387e);
                    int i11 = this.f4389g + 1;
                    this.f4389g = i11;
                    if (i11 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f4388f = false;
                }
            }

            /* renamed from: d */
            public void m5302d(int i10, int i11, int i12, Interpolator interpolator) {
                this.f4383a = i10;
                this.f4384b = i11;
                this.f4385c = i12;
                this.f4387e = interpolator;
                this.f4388f = true;
            }

            /* renamed from: e */
            public final void m5303e() {
                if (this.f4387e != null && this.f4385c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f4385c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f4386d = -1;
                this.f4388f = false;
                this.f4389g = 0;
                this.f4383a = i10;
                this.f4384b = i11;
                this.f4385c = i12;
                this.f4387e = interpolator;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$y$b */
        public interface b {
            PointF computeScrollVectorForPosition(int i10);
        }

        public PointF computeScrollVectorForPosition(int i10) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).computeScrollVectorForPosition(i10);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i10) {
            return this.mRecyclerView.mLayout.findViewByPosition(i10);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public AbstractC0846p getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i10) {
            this.mRecyclerView.scrollToPosition(i10);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float fSqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void onAnimation(int i10, int i11) {
            PointF pointFComputeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f10 = pointFComputeScrollVectorForPosition.x;
                if (f10 != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f10), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.m5301c(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i10, i11, recyclerView.mState, this.mRecyclingAction);
                boolean zM5299a = this.mRecyclingAction.m5299a();
                this.mRecyclingAction.m5301c(recyclerView);
                if (zM5299a && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.m5136e();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        public abstract void onSeekTargetStep(int i10, int i11, C0856z c0856z, a aVar);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, C0856z c0856z, a aVar);

        public void setTargetPosition(int i10) {
            this.mTargetPosition = i10;
        }

        public void start(RecyclerView recyclerView, AbstractC0846p abstractC0846p) {
            recyclerView.mViewFlinger.m5138g();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = abstractC0846p;
            int i10 = this.mTargetPosition;
            if (i10 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f4390a = i10;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.m5136e();
            this.mStarted = true;
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f4390a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$z */
    public static class C0856z {

        /* renamed from: b */
        public SparseArray<Object> f4391b;

        /* renamed from: m */
        public int f4402m;

        /* renamed from: n */
        public long f4403n;

        /* renamed from: o */
        public int f4404o;

        /* renamed from: p */
        public int f4405p;

        /* renamed from: q */
        public int f4406q;

        /* renamed from: a */
        public int f4390a = -1;

        /* renamed from: c */
        public int f4392c = 0;

        /* renamed from: d */
        public int f4393d = 0;

        /* renamed from: e */
        public int f4394e = 1;

        /* renamed from: f */
        public int f4395f = 0;

        /* renamed from: g */
        public boolean f4396g = false;

        /* renamed from: h */
        public boolean f4397h = false;

        /* renamed from: i */
        public boolean f4398i = false;

        /* renamed from: j */
        public boolean f4399j = false;

        /* renamed from: k */
        public boolean f4400k = false;

        /* renamed from: l */
        public boolean f4401l = false;

        /* renamed from: a */
        public void m5304a(int i10) {
            if ((this.f4394e & i10) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f4394e));
        }

        /* renamed from: b */
        public int m5305b() {
            return this.f4397h ? this.f4392c - this.f4393d : this.f4395f;
        }

        /* renamed from: c */
        public int m5306c() {
            return this.f4390a;
        }

        /* renamed from: d */
        public boolean m5307d() {
            return this.f4390a != -1;
        }

        /* renamed from: e */
        public boolean m5308e() {
            return this.f4397h;
        }

        /* renamed from: f */
        public void m5309f(AbstractC0838h abstractC0838h) {
            this.f4394e = 1;
            this.f4395f = abstractC0838h.mo721e();
            this.f4397h = false;
            this.f4398i = false;
            this.f4399j = false;
        }

        /* renamed from: g */
        public boolean m5310g() {
            return this.f4401l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4390a + ", mData=" + this.f4391b + ", mItemCount=" + this.f4395f + ", mIsMeasuring=" + this.f4399j + ", mPreviousLayoutItemCount=" + this.f4392c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4393d + ", mStructureChanged=" + this.f4396g + ", mInPreLayout=" + this.f4397h + ", mRunSimpleAnimations=" + this.f4400k + ", mRunPredictiveAnimations=" + this.f4401l + '}';
        }
    }

    static {
        Class cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new InterpolatorC0832c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(AbstractC0833c0 abstractC0833c0) {
        View view = abstractC0833c0.f4327a;
        boolean z10 = view.getParent() == this;
        this.mRecycler.m5267J(getChildViewHolder(view));
        if (abstractC0833c0.m5179z()) {
            this.mChildHelper.m5441c(view, -1, view.getLayoutParams(), true);
        } else if (z10) {
            this.mChildHelper.m5449k(view);
        } else {
            this.mChildHelper.m5440b(view, true);
        }
    }

    private void animateChange(AbstractC0833c0 abstractC0833c0, AbstractC0833c0 abstractC0833c02, AbstractC0843m.c cVar, AbstractC0843m.c cVar2, boolean z10, boolean z11) {
        abstractC0833c0.m5147I(false);
        if (z10) {
            addAnimatingView(abstractC0833c0);
        }
        if (abstractC0833c0 != abstractC0833c02) {
            if (z11) {
                addAnimatingView(abstractC0833c02);
            }
            abstractC0833c0.f4334h = abstractC0833c02;
            addAnimatingView(abstractC0833c0);
            this.mRecycler.m5267J(abstractC0833c0);
            abstractC0833c02.m5147I(false);
            abstractC0833c02.f4335i = abstractC0833c0;
        }
        if (this.mItemAnimator.animateChange(abstractC0833c0, abstractC0833c02, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(AbstractC0833c0 abstractC0833c0) {
        WeakReference<RecyclerView> weakReference = abstractC0833c0.f4328b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == abstractC0833c0.f4327a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            abstractC0833c0.f4328b = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i10, int i11) throws NoSuchMethodException, SecurityException {
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(AbstractC0846p.class);
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                } catch (NoSuchMethodException e10) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    } catch (NoSuchMethodException e11) {
                        e11.initCause(e10);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e11);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((AbstractC0846p) constructor.newInstance(objArr));
            } catch (ClassCastException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e12);
            } catch (ClassNotFoundException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e13);
            } catch (IllegalAccessException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e14);
            } catch (InstantiationException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e15);
            } catch (InvocationTargetException e16) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e16);
            }
        }
    }

    private boolean didChildRangeChange(int i10, int i11) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i10 && iArr[1] == i11) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i10 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i10 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        C9822b.m61027b(accessibilityEventObtain, i10);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.m5304a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f4399j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.m5594f();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C0856z c0856z = this.mState;
        c0856z.f4398i = c0856z.f4400k && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        c0856z.f4397h = c0856z.f4401l;
        c0856z.f4395f = this.mAdapter.mo721e();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f4400k) {
            int iM5445g = this.mChildHelper.m5445g();
            for (int i10 = 0; i10 < iM5445g; i10++) {
                AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5444f(i10));
                if (!childViewHolderInt.m5150L() && (!childViewHolderInt.m5175v() || this.mAdapter.m5212i())) {
                    this.mViewInfoStore.m5593e(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, AbstractC0843m.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.m5170q()));
                    if (this.mState.f4398i && childViewHolderInt.m5139A() && !childViewHolderInt.m5177x() && !childViewHolderInt.m5150L() && !childViewHolderInt.m5175v()) {
                        this.mViewInfoStore.m5591c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f4401l) {
            saveOldPositions();
            C0856z c0856z2 = this.mState;
            boolean z10 = c0856z2.f4396g;
            c0856z2.f4396g = false;
            this.mLayout.onLayoutChildren(this.mRecycler, c0856z2);
            this.mState.f4396g = z10;
            for (int i11 = 0; i11 < this.mChildHelper.m5445g(); i11++) {
                AbstractC0833c0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m5444f(i11));
                if (!childViewHolderInt2.m5150L() && !this.mViewInfoStore.m5597i(childViewHolderInt2)) {
                    int iBuildAdapterChangeFlagsForAnimations = AbstractC0843m.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean zM5171r = childViewHolderInt2.m5171r(8192);
                    if (!zM5171r) {
                        iBuildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    AbstractC0843m.c cVarRecordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, iBuildAdapterChangeFlagsForAnimations, childViewHolderInt2.m5170q());
                    if (zM5171r) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, cVarRecordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.m5589a(childViewHolderInt2, cVarRecordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f4394e = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m5304a(6);
        this.mAdapterHelper.m5416j();
        this.mState.f4395f = this.mAdapter.mo721e();
        this.mState.f4393d = 0;
        if (this.mPendingSavedState != null && this.mAdapter.m5208b()) {
            Parcelable parcelable = this.mPendingSavedState.f4316d;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        C0856z c0856z = this.mState;
        c0856z.f4397h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, c0856z);
        C0856z c0856z2 = this.mState;
        c0856z2.f4396g = false;
        c0856z2.f4400k = c0856z2.f4400k && this.mItemAnimator != null;
        c0856z2.f4394e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.m5304a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C0856z c0856z = this.mState;
        c0856z.f4394e = 1;
        if (c0856z.f4400k) {
            for (int iM5445g = this.mChildHelper.m5445g() - 1; iM5445g >= 0; iM5445g--) {
                AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5444f(iM5445g));
                if (!childViewHolderInt.m5150L()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    AbstractC0843m.c cVarRecordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    AbstractC0833c0 abstractC0833c0M5595g = this.mViewInfoStore.m5595g(changedHolderKey);
                    if (abstractC0833c0M5595g == null || abstractC0833c0M5595g.m5150L()) {
                        this.mViewInfoStore.m5592d(childViewHolderInt, cVarRecordPostLayoutInformation);
                    } else {
                        boolean zM5596h = this.mViewInfoStore.m5596h(abstractC0833c0M5595g);
                        boolean zM5596h2 = this.mViewInfoStore.m5596h(childViewHolderInt);
                        if (zM5596h && abstractC0833c0M5595g == childViewHolderInt) {
                            this.mViewInfoStore.m5592d(childViewHolderInt, cVarRecordPostLayoutInformation);
                        } else {
                            AbstractC0843m.c cVarM5602n = this.mViewInfoStore.m5602n(abstractC0833c0M5595g);
                            this.mViewInfoStore.m5592d(childViewHolderInt, cVarRecordPostLayoutInformation);
                            AbstractC0843m.c cVarM5601m = this.mViewInfoStore.m5601m(childViewHolderInt);
                            if (cVarM5602n == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, abstractC0833c0M5595g);
                            } else {
                                animateChange(abstractC0833c0M5595g, childViewHolderInt, cVarM5602n, cVarM5601m, zM5596h, zM5596h2);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.m5603o(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        C0856z c0856z2 = this.mState;
        c0856z2.f4392c = c0856z2.f4395f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        c0856z2.f4400k = false;
        c0856z2.f4401l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<AbstractC0833c0> arrayList = this.mRecycler.f4375b;
        if (arrayList != null) {
            arrayList.clear();
        }
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p.mPrefetchMaxObservedInInitialPrefetch) {
            abstractC0846p.mPrefetchMaxCountObserved = 0;
            abstractC0846p.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.m5268K();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.m5594f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        InterfaceC0849s interfaceC0849s = this.mInterceptingOnItemTouchListener;
        if (interfaceC0849s == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        interfaceC0849s.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            InterfaceC0849s interfaceC0849s = this.mOnItemTouchListeners.get(i10);
            if (interfaceC0849s.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = interfaceC0849s;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iM5445g = this.mChildHelper.m5445g();
        if (iM5445g == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < iM5445g; i12++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5444f(i12));
            if (!childViewHolderInt.m5150L()) {
                int iM5168o = childViewHolderInt.m5168o();
                if (iM5168o < i10) {
                    i10 = iM5168o;
                }
                if (iM5168o > i11) {
                    i11 = iM5168o;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i10));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition;
        C0856z c0856z = this.mState;
        int i10 = c0856z.f4402m;
        if (i10 == -1) {
            i10 = 0;
        }
        int iM5305b = c0856z.m5305b();
        for (int i11 = i10; i11 < iM5305b; i11++) {
            AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i11);
            if (abstractC0833c0FindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (abstractC0833c0FindViewHolderForAdapterPosition2.f4327a.hasFocusable()) {
                return abstractC0833c0FindViewHolderForAdapterPosition2.f4327a;
            }
        }
        int iMin = Math.min(iM5305b, i10);
        do {
            iMin--;
            if (iMin < 0 || (abstractC0833c0FindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!abstractC0833c0FindViewHolderForAdapterPosition.f4327a.hasFocusable());
        return abstractC0833c0FindViewHolderForAdapterPosition.f4327a;
    }

    public static AbstractC0833c0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f4312a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f4313b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private C9634x getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new C9634x(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j10, AbstractC0833c0 abstractC0833c0, AbstractC0833c0 abstractC0833c02) {
        int iM5445g = this.mChildHelper.m5445g();
        for (int i10 = 0; i10 < iM5445g; i10++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5444f(i10));
            if (childViewHolderInt != abstractC0833c0 && getChangedHolderKey(childViewHolderInt) == j10) {
                AbstractC0838h abstractC0838h = this.mAdapter;
                if (abstractC0838h == null || !abstractC0838h.m5212i()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + abstractC0833c0 + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + abstractC0833c0 + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + abstractC0833c02 + " cannot be found but it is necessary for " + abstractC0833c0 + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int iM5445g = this.mChildHelper.m5445g();
        for (int i10 = 0; i10 < iM5445g; i10++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5444f(i10));
            if (childViewHolderInt != null && !childViewHolderInt.m5150L() && childViewHolderInt.m5139A()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (C9603h0.m59921z(this) == 0) {
            C9603h0.m59835B0(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new C0865d(new C0835e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i10) {
        int i11;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c10 = 65535;
        int i12 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i13 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i11 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            i11 = ((i15 > i16 || i13 >= i16) && i13 > i14) ? -1 : 0;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            c10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                c10 = 0;
            }
        }
        if (i10 == 1) {
            return c10 < 0 || (c10 == 0 && i11 * i12 < 0);
        }
        if (i10 == 2) {
            return c10 > 0 || (c10 == 0 && i11 * i12 > 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return c10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return c10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + exceptionLabel());
    }

    private void nestedScrollByInternal(int i10, int i11, MotionEvent motionEvent, int i12) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zCanScrollHorizontally = abstractC0846p.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        startNestedScroll(zCanScrollVertically ? (zCanScrollHorizontally ? 1 : 0) | 2 : zCanScrollHorizontally ? 1 : 0, i12);
        if (dispatchNestedPreScroll(zCanScrollHorizontally ? i10 : 0, zCanScrollVertically ? i11 : 0, this.mReusableIntPair, this.mScrollOffset, i12)) {
            int[] iArr2 = this.mReusableIntPair;
            i10 -= iArr2[0];
            i11 -= iArr2[1];
        }
        scrollByInternal(zCanScrollHorizontally ? i10 : 0, zCanScrollVertically ? i11 : 0, motionEvent, i12);
        RunnableC0869h runnableC0869h = this.mGapWorker;
        if (runnableC0869h != null && (i10 != 0 || i11 != 0)) {
            runnableC0869h.m5529g(this, i10, i11);
        }
        stopNestedScroll(i12);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z10;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m5431y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m5429w();
        } else {
            this.mAdapterHelper.m5416j();
        }
        boolean z11 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f4400k = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z10 = this.mDataSetHasChangedAfterLayout) || z11 || this.mLayout.mRequestedSimpleAnimations) && (!z10 || this.mAdapter.m5212i());
        C0856z c0856z = this.mState;
        c0856z.f4401l = c0856z.f4400k && z11 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled();
    }

    private void pullGlows(float f10, float f11, float f12, float f13) {
        boolean z10 = true;
        if (f11 < 0.0f) {
            ensureLeftGlow();
            EdgeEffectCompat.m3946c(this.mLeftGlow, (-f11) / getWidth(), 1.0f - (f12 / getHeight()));
        } else if (f11 > 0.0f) {
            ensureRightGlow();
            EdgeEffectCompat.m3946c(this.mRightGlow, f11 / getWidth(), f12 / getHeight());
        } else {
            z10 = false;
        }
        if (f13 < 0.0f) {
            ensureTopGlow();
            EdgeEffectCompat.m3946c(this.mTopGlow, (-f13) / getHeight(), f10 / getWidth());
        } else if (f13 > 0.0f) {
            ensureBottomGlow();
            EdgeEffectCompat.m3946c(this.mBottomGlow, f13 / getHeight(), 1.0f - (f10 / getWidth()));
        } else if (!z10 && f11 == 0.0f && f13 == 0.0f) {
            return;
        }
        C9603h0.m59884g0(this);
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.m5452n(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.m5445g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        AbstractC0833c0 abstractC0833c0FindViewHolderForItemId = (this.mState.f4403n == -1 || !this.mAdapter.m5212i()) ? null : findViewHolderForItemId(this.mState.f4403n);
        if (abstractC0833c0FindViewHolderForItemId != null && !this.mChildHelper.m5452n(abstractC0833c0FindViewHolderForItemId.f4327a) && abstractC0833c0FindViewHolderForItemId.f4327a.hasFocusable()) {
            viewFindNextViewToFocus = abstractC0833c0FindViewHolderForItemId.f4327a;
        } else if (this.mChildHelper.m5445g() > 0) {
            viewFindNextViewToFocus = findNextViewToFocus();
        }
        if (viewFindNextViewToFocus != null) {
            int i10 = this.mState.f4404o;
            if (i10 != -1 && (viewFindViewById = viewFindNextViewToFocus.findViewById(i10)) != null && viewFindViewById.isFocusable()) {
                viewFindNextViewToFocus = viewFindViewById;
            }
            viewFindNextViewToFocus.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            C9603h0.m59884g0(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f4314c) {
                Rect rect = layoutParams2.f4313b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        C0856z c0856z = this.mState;
        c0856z.f4403n = -1L;
        c0856z.f4402m = -1;
        c0856z.f4404o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        AbstractC0833c0 abstractC0833c0FindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (abstractC0833c0FindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f4403n = this.mAdapter.m5212i() ? abstractC0833c0FindContainingViewHolder.m5166m() : -1L;
        this.mState.f4402m = this.mDataSetHasChangedAfterLayout ? -1 : abstractC0833c0FindContainingViewHolder.m5177x() ? abstractC0833c0FindContainingViewHolder.f4330d : abstractC0833c0FindContainingViewHolder.m5163j();
        this.mState.f4404o = getDeepestFocusedViewWithId(abstractC0833c0FindContainingViewHolder.f4327a);
    }

    private void setAdapterInternal(AbstractC0838h abstractC0838h, boolean z10, boolean z11) {
        AbstractC0838h abstractC0838h2 = this.mAdapter;
        if (abstractC0838h2 != null) {
            abstractC0838h2.m5206C(this.mObserver);
            this.mAdapter.m5223v(this);
        }
        if (!z10 || z11) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.m5431y();
        AbstractC0838h abstractC0838h3 = this.mAdapter;
        this.mAdapter = abstractC0838h;
        if (abstractC0838h != null) {
            abstractC0838h.m5204A(this.mObserver);
            abstractC0838h.mo5221r(this);
        }
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.onAdapterChanged(abstractC0838h3, this.mAdapter);
        }
        this.mRecycler.m5294x(abstractC0838h3, this.mAdapter, z10);
        this.mState.f4396g = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m5138g();
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.stopSmoothScroller();
        }
    }

    public void absorbGlows(int i10, int i11) {
        if (i10 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i11);
            }
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        C9603h0.m59884g0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null || !abstractC0846p.onAddFocusables(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public void addItemDecoration(AbstractC0845o abstractC0845o, int i10) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.mItemDecorations.add(abstractC0845o);
        } else {
            this.mItemDecorations.add(i10, abstractC0845o);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(InterfaceC0847q interfaceC0847q) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(interfaceC0847q);
    }

    public void addOnItemTouchListener(InterfaceC0849s interfaceC0849s) {
        this.mOnItemTouchListeners.add(interfaceC0849s);
    }

    public void addOnScrollListener(AbstractC0850t abstractC0850t) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(abstractC0850t);
    }

    public void addRecyclerListener(InterfaceC0853w interfaceC0853w) {
        C9373h.m58740a(interfaceC0853w != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(interfaceC0853w);
    }

    public void animateAppearance(AbstractC0833c0 abstractC0833c0, AbstractC0843m.c cVar, AbstractC0843m.c cVar2) {
        abstractC0833c0.m5147I(false);
        if (this.mItemAnimator.animateAppearance(abstractC0833c0, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(AbstractC0833c0 abstractC0833c0, AbstractC0843m.c cVar, AbstractC0843m.c cVar2) {
        addAnimatingView(abstractC0833c0);
        abstractC0833c0.m5147I(false);
        if (this.mItemAnimator.animateDisappearance(abstractC0833c0, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public boolean canReuseUpdatedViewHolder(AbstractC0833c0 abstractC0833c0) {
        AbstractC0843m abstractC0843m = this.mItemAnimator;
        return abstractC0843m == null || abstractC0843m.canReuseUpdatedViewHolder(abstractC0833c0, abstractC0833c0.m5170q());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int iM5448j = this.mChildHelper.m5448j();
        for (int i10 = 0; i10 < iM5448j; i10++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i10));
            if (!childViewHolderInt.m5150L()) {
                childViewHolderInt.m5156c();
            }
        }
        this.mRecycler.m5274d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<InterfaceC0847q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<AbstractC0850t> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null && abstractC0846p.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null && abstractC0846p.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null && abstractC0846p.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null && abstractC0846p.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null && abstractC0846p.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null && abstractC0846p.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i10, int i11) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            C9603h0.m59884g0(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            C1094j.m6490a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            C1094j.m6491b();
            return;
        }
        if (this.mAdapterHelper.m5422p()) {
            if (!this.mAdapterHelper.m5421o(4) || this.mAdapterHelper.m5421o(11)) {
                if (this.mAdapterHelper.m5422p()) {
                    C1094j.m6490a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    C1094j.m6491b();
                    return;
                }
                return;
            }
            C1094j.m6490a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.m5429w();
            if (!this.mLayoutWasDefered) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.m5415i();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            C1094j.m6491b();
        }
    }

    public void defaultOnMeasure(int i10, int i11) {
        setMeasuredDimension(AbstractC0846p.chooseSize(i10, getPaddingLeft() + getPaddingRight(), C9603h0.m59836C(this)), AbstractC0846p.chooseSize(i11, getPaddingTop() + getPaddingBottom(), C9603h0.m59834B(this)));
    }

    public void dispatchChildAttached(View view) {
        AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        AbstractC0838h abstractC0838h = this.mAdapter;
        if (abstractC0838h != null && childViewHolderInt != null) {
            abstractC0838h.m5225x(childViewHolderInt);
        }
        List<InterfaceC0847q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        AbstractC0838h abstractC0838h = this.mAdapter;
        if (abstractC0838h != null && childViewHolderInt != null) {
            abstractC0838h.m5226y(childViewHolderInt);
        }
        List<InterfaceC0847q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        this.mState.f4399j = false;
        boolean z10 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.f4394e == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.m5423q() || z10 || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        dispatchLayoutStep3();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().m60232a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().m60233b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m60234c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().m60237f(i10, i11, i12, i13, iArr);
    }

    public void dispatchOnScrollStateChanged(int i10) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.onScrollStateChanged(i10);
        }
        onScrollStateChanged(i10);
        AbstractC0850t abstractC0850t = this.mScrollListener;
        if (abstractC0850t != null) {
            abstractC0850t.onScrollStateChanged(this, i10);
        }
        List<AbstractC0850t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i10);
            }
        }
    }

    public void dispatchOnScrolled(int i10, int i11) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        onScrolled(i10, i11);
        AbstractC0850t abstractC0850t = this.mScrollListener;
        if (abstractC0850t != null) {
            abstractC0850t.onScrolled(this, i10, i11);
        }
        List<AbstractC0850t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i10, i11);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i10;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            AbstractC0833c0 abstractC0833c0 = this.mPendingAccessibilityImportanceChange.get(size);
            if (abstractC0833c0.f4327a.getParent() == this && !abstractC0833c0.m5150L() && (i10 = abstractC0833c0.f4343q) != -1) {
                C9603h0.m59833A0(abstractC0833c0.f4327a, i10);
                abstractC0833c0.f4343q = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            this.mItemDecorations.get(i10).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(iSave4);
        }
        if ((z10 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) && !z10) {
            return;
        }
        C9603h0.m59884g0(this);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect edgeEffectM5235a = this.mEdgeEffectFactory.m5235a(this, 3);
        this.mBottomGlow = edgeEffectM5235a;
        if (this.mClipToPadding) {
            edgeEffectM5235a.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectM5235a.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect edgeEffectM5235a = this.mEdgeEffectFactory.m5235a(this, 0);
        this.mLeftGlow = edgeEffectM5235a;
        if (this.mClipToPadding) {
            edgeEffectM5235a.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectM5235a.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect edgeEffectM5235a = this.mEdgeEffectFactory.m5235a(this, 2);
        this.mRightGlow = edgeEffectM5235a;
        if (this.mClipToPadding) {
            edgeEffectM5235a.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectM5235a.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect edgeEffectM5235a = this.mEdgeEffectFactory.m5235a(this, 1);
        this.mTopGlow = edgeEffectM5235a;
        if (this.mClipToPadding) {
            edgeEffectM5235a.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectM5235a.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(C0856z c0856z) {
        if (getScrollState() != 2) {
            c0856z.f4405p = 0;
            c0856z.f4406q = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.f4321c;
            c0856z.f4405p = overScroller.getFinalX() - overScroller.getCurrX();
            c0856z.f4406q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View findChildViewUnder(float f10, float f11) {
        for (int iM5445g = this.mChildHelper.m5445g() - 1; iM5445g >= 0; iM5445g--) {
            View viewM5444f = this.mChildHelper.m5444f(iM5445g);
            float translationX = viewM5444f.getTranslationX();
            float translationY = viewM5444f.getTranslationY();
            if (f10 >= viewM5444f.getLeft() + translationX && f10 <= viewM5444f.getRight() + translationX && f11 >= viewM5444f.getTop() + translationY && f11 <= viewM5444f.getBottom() + translationY) {
                return viewM5444f;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public AbstractC0833c0 findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public AbstractC0833c0 findViewHolderForAdapterPosition(int i10) {
        AbstractC0833c0 abstractC0833c0 = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iM5448j = this.mChildHelper.m5448j();
        for (int i11 = 0; i11 < iM5448j; i11++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i11));
            if (childViewHolderInt != null && !childViewHolderInt.m5177x() && getAdapterPositionInRecyclerView(childViewHolderInt) == i10) {
                if (!this.mChildHelper.m5452n(childViewHolderInt.f4327a)) {
                    return childViewHolderInt;
                }
                abstractC0833c0 = childViewHolderInt;
            }
        }
        return abstractC0833c0;
    }

    public AbstractC0833c0 findViewHolderForItemId(long j10) {
        AbstractC0838h abstractC0838h = this.mAdapter;
        AbstractC0833c0 abstractC0833c0 = null;
        if (abstractC0838h != null && abstractC0838h.m5212i()) {
            int iM5448j = this.mChildHelper.m5448j();
            for (int i10 = 0; i10 < iM5448j; i10++) {
                AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i10));
                if (childViewHolderInt != null && !childViewHolderInt.m5177x() && childViewHolderInt.m5166m() == j10) {
                    if (!this.mChildHelper.m5452n(childViewHolderInt.f4327a)) {
                        return childViewHolderInt;
                    }
                    abstractC0833c0 = childViewHolderInt;
                }
            }
        }
        return abstractC0833c0;
    }

    public AbstractC0833c0 findViewHolderForLayoutPosition(int i10) {
        return findViewHolderForPosition(i10, false);
    }

    @Deprecated
    public AbstractC0833c0 findViewHolderForPosition(int i10) {
        return findViewHolderForPosition(i10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int i10, int i11) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        int iCanScrollHorizontally = abstractC0846p.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (iCanScrollHorizontally == 0 || Math.abs(i10) < this.mMinFlingVelocity) {
            i10 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i11) < this.mMinFlingVelocity) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return false;
        }
        float f10 = i10;
        float f11 = i11;
        if (!dispatchNestedPreFling(f10, f11)) {
            boolean z10 = iCanScrollHorizontally != 0 || zCanScrollVertically;
            dispatchNestedFling(f10, f11, z10);
            AbstractC0848r abstractC0848r = this.mOnFlingListener;
            if (abstractC0848r != null && abstractC0848r.onFling(i10, i11)) {
                return true;
            }
            if (z10) {
                if (zCanScrollVertically) {
                    iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                }
                startNestedScroll(iCanScrollHorizontally, 1);
                int i12 = this.mMaxFlingVelocity;
                int iMax = Math.max(-i12, Math.min(i10, i12));
                int i13 = this.mMaxFlingVelocity;
                this.mViewFlinger.m5134c(iMax, Math.max(-i13, Math.min(i11, i13)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View viewOnFocusSearchFailed;
        boolean z10;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i10);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z11 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z11 && (i10 == 2 || i10 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i11 = i10 == 2 ? 130 : 33;
                z10 = focusFinder.findNextFocus(this, view, i11) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i10 = i11;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.mLayout.canScrollHorizontally()) {
                int i12 = (this.mLayout.getLayoutDirection() == 1) ^ (i10 == 2) ? 66 : 17;
                boolean z12 = focusFinder.findNextFocus(this, view, i12) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i10 = i12;
                }
                z10 = z12;
            }
            if (z10) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i10, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i10);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i10);
            if (viewFindNextFocus == null && z11) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i10, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, i10) ? viewOnFocusSearchFailed : super.focusSearch(view, i10);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            return abstractC0846p.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            return abstractC0846p.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public AbstractC0838h getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(AbstractC0833c0 abstractC0833c0) {
        if (abstractC0833c0.m5171r(524) || !abstractC0833c0.m5174u()) {
            return -1;
        }
        return this.mAdapterHelper.m5411e(abstractC0833c0.f4329c);
    }

    @Override // android.view.View
    public int getBaseline() {
        AbstractC0846p abstractC0846p = this.mLayout;
        return abstractC0846p != null ? abstractC0846p.getBaseline() : super.getBaseline();
    }

    public long getChangedHolderKey(AbstractC0833c0 abstractC0833c0) {
        return this.mAdapter.m5212i() ? abstractC0833c0.m5166m() : abstractC0833c0.f4329c;
    }

    public int getChildAdapterPosition(View view) {
        AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.m5163j();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        InterfaceC0841k interfaceC0841k = this.mChildDrawingOrderCallback;
        return interfaceC0841k == null ? super.getChildDrawingOrder(i10, i11) : interfaceC0841k.onGetChildDrawingOrder(i10, i11);
    }

    public long getChildItemId(View view) {
        AbstractC0833c0 childViewHolderInt;
        AbstractC0838h abstractC0838h = this.mAdapter;
        if (abstractC0838h == null || !abstractC0838h.m5212i() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.m5166m();
    }

    public int getChildLayoutPosition(View view) {
        AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.m5168o();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public AbstractC0833c0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public C0877p getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public C0842l getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public AbstractC0843m getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f4314c) {
            return layoutParams.f4313b;
        }
        if (this.mState.m5308e() && (layoutParams.m5126c() || layoutParams.m5128e())) {
            return layoutParams.f4313b;
        }
        Rect rect = layoutParams.f4313b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i10).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i11 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f4314c = false;
        return rect;
    }

    public AbstractC0845o getItemDecorationAt(int i10) {
        int itemDecorationCount = getItemDecorationCount();
        if (i10 >= 0 && i10 < itemDecorationCount) {
            return this.mItemDecorations.get(i10);
        }
        throw new IndexOutOfBoundsException(i10 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public AbstractC0846p getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public AbstractC0848r getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public C0851u getRecycledViewPool() {
        return this.mRecycler.m5279i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m60242k();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.m5422p();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new C0862a(new C0836f());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new C0868g(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        AbstractC0843m abstractC0843m = this.mItemAnimator;
        return abstractC0843m != null && abstractC0843m.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m60244m();
    }

    public void jumpToPositionForSmoothScroller(int i10) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i10);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int iM5448j = this.mChildHelper.m5448j();
        for (int i10 = 0; i10 < iM5448j; i10++) {
            ((LayoutParams) this.mChildHelper.m5447i(i10).getLayoutParams()).f4314c = true;
        }
        this.mRecycler.m5289s();
    }

    public void markKnownViewsInvalid() {
        int iM5448j = this.mChildHelper.m5448j();
        for (int i10 = 0; i10 < iM5448j; i10++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i10));
            if (childViewHolderInt != null && !childViewHolderInt.m5150L()) {
                childViewHolderInt.m5155b(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.m5290t();
    }

    public void nestedScrollBy(int i10, int i11) {
        nestedScrollByInternal(i10, i11, null, 1);
    }

    public void offsetChildrenHorizontal(int i10) {
        int iM5445g = this.mChildHelper.m5445g();
        for (int i11 = 0; i11 < iM5445g; i11++) {
            this.mChildHelper.m5444f(i11).offsetLeftAndRight(i10);
        }
    }

    public void offsetChildrenVertical(int i10) {
        int iM5445g = this.mChildHelper.m5445g();
        for (int i11 = 0; i11 < iM5445g; i11++) {
            this.mChildHelper.m5444f(i11).offsetTopAndBottom(i10);
        }
    }

    public void offsetPositionRecordsForInsert(int i10, int i11) {
        int iM5448j = this.mChildHelper.m5448j();
        for (int i12 = 0; i12 < iM5448j; i12++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i12));
            if (childViewHolderInt != null && !childViewHolderInt.m5150L() && childViewHolderInt.f4329c >= i10) {
                childViewHolderInt.m5141C(i11, false);
                this.mState.f4396g = true;
            }
        }
        this.mRecycler.m5291u(i10, i11);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int iM5448j = this.mChildHelper.m5448j();
        if (i10 < i11) {
            i14 = -1;
            i13 = i10;
            i12 = i11;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i16 = 0; i16 < iM5448j; i16++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i16));
            if (childViewHolderInt != null && (i15 = childViewHolderInt.f4329c) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    childViewHolderInt.m5141C(i11 - i10, false);
                } else {
                    childViewHolderInt.m5141C(i14, false);
                }
                this.mState.f4396g = true;
            }
        }
        this.mRecycler.m5292v(i10, i11);
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int iM5448j = this.mChildHelper.m5448j();
        for (int i13 = 0; i13 < iM5448j; i13++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i13));
            if (childViewHolderInt != null && !childViewHolderInt.m5150L()) {
                int i14 = childViewHolderInt.f4329c;
                if (i14 >= i12) {
                    childViewHolderInt.m5141C(-i11, z10);
                    this.mState.f4396g = true;
                } else if (i14 >= i10) {
                    childViewHolderInt.m5162i(i10 - 1, -i11, z10);
                    this.mState.f4396g = true;
                }
            }
        }
        this.mRecycler.m5293w(i10, i11, z10);
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$p r1 = r5.mLayout
            if (r1 == 0) goto L1e
            r1.dispatchAttachedToWindow(r5)
        L1e:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L61
            java.lang.ThreadLocal<androidx.recyclerview.widget.h> r0 = androidx.recyclerview.widget.RunnableC0869h.f4598e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.h r1 = (androidx.recyclerview.widget.RunnableC0869h) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.h r1 = new androidx.recyclerview.widget.h
            r1.<init>()
            r5.mGapWorker = r1
            android.view.Display r1 = p273f0.C9603h0.m59911u(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.h r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f4602c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.h r0 = r5.mGapWorker
            r0.m5525a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        RunnableC0869h runnableC0869h;
        super.onDetachedFromWindow();
        AbstractC0843m abstractC0843m = this.mItemAnimator;
        if (abstractC0843m != null) {
            abstractC0843m.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.m5598j();
        if (!ALLOW_THREAD_GAP_WORK || (runnableC0869h = this.mGapWorker) == null) {
            return;
        }
        runnableC0869h.m5533k(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mItemDecorations.get(i10).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$p r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$p r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.nestedScrollByInternal(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            return false;
        }
        boolean zCanScrollHorizontally = abstractC0846p.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = zCanScrollHorizontally;
            if (zCanScrollVertically) {
                i10 = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i10, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i11 = x11 - this.mInitialTouchX;
                int i12 = y11 - this.mInitialTouchY;
                if (zCanScrollHorizontally == 0 || Math.abs(i11) <= this.mTouchSlop) {
                    z10 = false;
                } else {
                    this.mLastTouchX = x11;
                    z10 = true;
                }
                if (zCanScrollVertically && Math.abs(i12) > this.mTouchSlop) {
                    this.mLastTouchY = y11;
                } else if (z10) {
                }
                setScrollState(1);
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x12;
            this.mInitialTouchX = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y12;
            this.mInitialTouchY = y12;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        C1094j.m6490a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        C1094j.m6491b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            defaultOnMeasure(i10, i11);
            return;
        }
        boolean z10 = false;
        if (abstractC0846p.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z10;
            if (z10 || this.mAdapter == null) {
                return;
            }
            if (this.mState.f4394e == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i10, i11);
            this.mState.f4399j = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i10, i11);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f4399j = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i10, i11);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i10, i11);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            C0856z c0856z = this.mState;
            if (c0856z.f4401l) {
                c0856z.f4397h = true;
            } else {
                this.mAdapterHelper.m5416j();
                this.mState.f4397h = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f4401l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        AbstractC0838h abstractC0838h = this.mAdapter;
        if (abstractC0838h != null) {
            this.mState.f4395f = abstractC0838h.mo721e();
        } else {
            this.mState.f4395f = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i10, i11);
        stopInterceptRequestLayout(false);
        this.mState.f4397h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.m5129a(savedState2);
        } else {
            AbstractC0846p abstractC0846p = this.mLayout;
            if (abstractC0846p != null) {
                savedState.f4316d = abstractC0846p.onSaveInstanceState();
            } else {
                savedState.f4316d = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i10) {
    }

    public void onScrolled(int i10, int i11) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 == i12 && i11 == i13) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00df A[PHI: r0
  0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:147:0x00c8, B:151:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        C9603h0.m59886h0(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z10) {
        this.mDispatchItemsChangedEvent = z10 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(AbstractC0833c0 abstractC0833c0, AbstractC0843m.c cVar) {
        abstractC0833c0.m5146H(0, 8192);
        if (this.mState.f4398i && abstractC0833c0.m5139A() && !abstractC0833c0.m5177x() && !abstractC0833c0.m5150L()) {
            this.mViewInfoStore.m5591c(getChangedHolderKey(abstractC0833c0), abstractC0833c0);
        }
        this.mViewInfoStore.m5593e(abstractC0833c0, cVar);
    }

    public void removeAndRecycleViews() {
        AbstractC0843m abstractC0843m = this.mItemAnimator;
        if (abstractC0843m != null) {
            abstractC0843m.endAnimations();
        }
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.m5273c();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zM5456r = this.mChildHelper.m5456r(view);
        if (zM5456r) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m5267J(childViewHolderInt);
            this.mRecycler.m5260C(childViewHolderInt);
        }
        stopInterceptRequestLayout(!zM5456r);
        return zM5456r;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z10) {
        AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.m5179z()) {
                childViewHolderInt.m5159f();
            } else if (!childViewHolderInt.m5150L()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z10);
    }

    public void removeItemDecoration(AbstractC0845o abstractC0845o) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            abstractC0846p.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(abstractC0845o);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i10) {
        int itemDecorationCount = getItemDecorationCount();
        if (i10 >= 0 && i10 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i10));
            return;
        }
        throw new IndexOutOfBoundsException(i10 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(InterfaceC0847q interfaceC0847q) {
        List<InterfaceC0847q> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(interfaceC0847q);
    }

    public void removeOnItemTouchListener(InterfaceC0849s interfaceC0849s) {
        this.mOnItemTouchListeners.remove(interfaceC0849s);
        if (this.mInterceptingOnItemTouchListener == interfaceC0849s) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(AbstractC0850t abstractC0850t) {
        List<AbstractC0850t> list = this.mScrollListeners;
        if (list != null) {
            list.remove(abstractC0850t);
        }
    }

    public void removeRecyclerListener(InterfaceC0853w interfaceC0853w) {
        this.mRecyclerListeners.remove(interfaceC0853w);
    }

    public void repositionShadowingViews() {
        AbstractC0833c0 abstractC0833c0;
        int iM5445g = this.mChildHelper.m5445g();
        for (int i10 = 0; i10 < iM5445g; i10++) {
            View viewM5444f = this.mChildHelper.m5444f(i10);
            AbstractC0833c0 childViewHolder = getChildViewHolder(viewM5444f);
            if (childViewHolder != null && (abstractC0833c0 = childViewHolder.f4335i) != null) {
                View view = abstractC0833c0.f4327a;
                int left = viewM5444f.getLeft();
                int top = viewM5444f.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.mOnItemTouchListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mOnItemTouchListeners.get(i10).onRequestDisallowInterceptTouchEvent(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int iM5448j = this.mChildHelper.m5448j();
        for (int i10 = 0; i10 < iM5448j; i10++) {
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m5447i(i10));
            if (!childViewHolderInt.m5150L()) {
                childViewHolderInt.m5145G();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = abstractC0846p.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i10 = 0;
            }
            if (!zCanScrollVertically) {
                i11 = 0;
            }
            scrollByInternal(i10, i11, null, 0);
        }
    }

    public boolean scrollByInternal(int i10, int i11, MotionEvent motionEvent, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i10, i11, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i17 = iArr2[0];
            int i18 = iArr2[1];
            i13 = i18;
            i14 = i17;
            i15 = i10 - i17;
            i16 = i11 - i18;
        } else {
            i13 = 0;
            i14 = 0;
            i15 = 0;
            i16 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i14, i13, i15, i16, this.mScrollOffset, i12, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i19 = iArr4[0];
        int i20 = i15 - i19;
        int i21 = iArr4[1];
        int i22 = i16 - i21;
        boolean z10 = (i19 == 0 && i21 == 0) ? false : true;
        int i23 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i24 = iArr5[0];
        this.mLastTouchX = i23 - i24;
        int i25 = this.mLastTouchY;
        int i26 = iArr5[1];
        this.mLastTouchY = i25 - i26;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i24;
        iArr6[1] = iArr6[1] + i26;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !C9630v.m60229a(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i20, motionEvent.getY(), i22);
            }
            considerReleasingGlowsOnScroll(i10, i11);
        }
        if (i14 != 0 || i13 != 0) {
            dispatchOnScrolled(i14, i13);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z10 && i14 == 0 && i13 == 0) ? false : true;
    }

    public void scrollStep(int i10, int i11, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C1094j.m6490a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i10 != 0 ? this.mLayout.scrollHorizontallyBy(i10, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i11 != 0 ? this.mLayout.scrollVerticallyBy(i11, this.mRecycler, this.mState) : 0;
        C1094j.m6491b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i10) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0846p.scrollToPosition(i10);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C0877p c0877p) {
        this.mAccessibilityDelegate = c0877p;
        C9603h0.m59902p0(this, c0877p);
    }

    public void setAdapter(AbstractC0838h abstractC0838h) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC0838h, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC0841k interfaceC0841k) {
        if (interfaceC0841k == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = interfaceC0841k;
        setChildrenDrawingOrderEnabled(interfaceC0841k != null);
    }

    public boolean setChildImportantForAccessibilityInternal(AbstractC0833c0 abstractC0833c0, int i10) {
        if (!isComputingLayout()) {
            C9603h0.m59833A0(abstractC0833c0.f4327a, i10);
            return true;
        }
        abstractC0833c0.f4343q = i10;
        this.mPendingAccessibilityImportanceChange.add(abstractC0833c0);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z10;
        super.setClipToPadding(z10);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(C0842l c0842l) {
        C9373h.m58745f(c0842l);
        this.mEdgeEffectFactory = c0842l;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z10) {
        this.mHasFixedSize = z10;
    }

    public void setItemAnimator(AbstractC0843m abstractC0843m) {
        AbstractC0843m abstractC0843m2 = this.mItemAnimator;
        if (abstractC0843m2 != null) {
            abstractC0843m2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = abstractC0843m;
        if (abstractC0843m != null) {
            abstractC0843m.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.mRecycler.m5264G(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(AbstractC0846p abstractC0846p) {
        if (abstractC0846p == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            AbstractC0843m abstractC0843m = this.mItemAnimator;
            if (abstractC0843m != null) {
                abstractC0843m.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.m5273c();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.m5273c();
        }
        this.mChildHelper.m5453o();
        this.mLayout = abstractC0846p;
        if (abstractC0846p != null) {
            if (abstractC0846p.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + abstractC0846p + " is already attached to a RecyclerView:" + abstractC0846p.mRecyclerView.exceptionLabel());
            }
            abstractC0846p.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.m5268K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().m60245n(z10);
    }

    public void setOnFlingListener(AbstractC0848r abstractC0848r) {
        this.mOnFlingListener = abstractC0848r;
    }

    @Deprecated
    public void setOnScrollListener(AbstractC0850t abstractC0850t) {
        this.mScrollListener = abstractC0850t;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.mPreserveFocusAfterLayout = z10;
    }

    public void setRecycledViewPool(C0851u c0851u) {
        this.mRecycler.m5262E(c0851u);
    }

    @Deprecated
    public void setRecyclerListener(InterfaceC0853w interfaceC0853w) {
        this.mRecyclerListener = interfaceC0853w;
    }

    public void setScrollState(int i10) {
        if (i10 == this.mScrollState) {
            return;
        }
        this.mScrollState = i10;
        if (i10 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i10);
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC0829a0 abstractC0829a0) {
        this.mRecycler.m5263F(abstractC0829a0);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iM61026a = accessibilityEvent != null ? C9822b.m61026a(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= iM61026a != 0 ? iM61026a : 0;
        return true;
    }

    public void smoothScrollBy(int i10, int i11) {
        smoothScrollBy(i10, i11, null);
    }

    public void smoothScrollToPosition(int i10) {
        if (this.mLayoutSuppressed) {
            return;
        }
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0846p.smoothScrollToPosition(this, this.mState, i10);
        }
    }

    public void startInterceptRequestLayout() {
        int i10 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i10;
        if (i10 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().m60247p(i10);
    }

    public void stopInterceptRequestLayout(boolean z10) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z10 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z10 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().m60249r();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(AbstractC0838h abstractC0838h, boolean z10) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC0838h, true, z10);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i10, int i11, Object obj) {
        int i12;
        int iM5448j = this.mChildHelper.m5448j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < iM5448j; i14++) {
            View viewM5447i = this.mChildHelper.m5447i(i14);
            AbstractC0833c0 childViewHolderInt = getChildViewHolderInt(viewM5447i);
            if (childViewHolderInt != null && !childViewHolderInt.m5150L() && (i12 = childViewHolderInt.f4329c) >= i10 && i12 < i13) {
                childViewHolderInt.m5155b(2);
                childViewHolderInt.m5154a(obj);
                ((LayoutParams) viewM5447i.getLayoutParams()).f4314c = true;
            }
        }
        this.mRecycler.m5270M(i10, i11);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().m60235d(i10, i11, iArr, iArr2, i12);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return getScrollingChildHelper().m60238g(i10, i11, i12, i13, iArr, i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.recyclerview.widget.RecyclerView.AbstractC0833c0 findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.d r0 = r5.mChildHelper
            int r0 = r0.m5448j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.d r3 = r5.mChildHelper
            android.view.View r3 = r3.m5447i(r2)
            androidx.recyclerview.widget.RecyclerView$c0 r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.m5177x()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f4329c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m5168o()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.d r1 = r5.mChildHelper
            android.view.View r4 = r3.f4327a
            boolean r1 = r1.m5452n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$c0");
    }

    public boolean hasNestedScrollingParent(int i10) {
        return getScrollingChildHelper().m60243l(i10);
    }

    public void onExitLayoutOrScroll(boolean z10) {
        int i10 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i10;
        if (i10 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z10) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator) {
        smoothScrollBy(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i10, int i11) {
        return getScrollingChildHelper().m60248q(i10, i11);
    }

    public void stopNestedScroll(int i10) {
        getScrollingChildHelper().m60250s(i10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0827a();

        /* renamed from: d */
        public Parcelable f4316d;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$SavedState$a */
        public class C0827a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4316d = parcel.readParcelable(classLoader == null ? AbstractC0846p.class.getClassLoader() : classLoader);
        }

        /* renamed from: a */
        public void m5129a(SavedState savedState) {
            this.f4316d = savedState.f4316d;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f4316d, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i10);
        this.mObserver = new C0854x();
        this.mRecycler = new C0852v();
        this.mViewInfoStore = new C0882u();
        this.mUpdateChildViewsRunnable = new RunnableC0828a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new C0842l();
        this.mItemAnimator = new C0866e();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new RunnableC0831b0();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new RunnableC0869h.b() : null;
        this.mState = new C0856z();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C0844n();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new RunnableC0830b();
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new C0834d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = C9607j0.m60062a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = C9607j0.m60063b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (C9603h0.m59919y(this) == 0) {
            C9603h0.m59833A0(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C0877p(this));
        int[] iArr = R$styleable.RecyclerView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        C9603h0.m59898n0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(C6051p9.f27764p);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z10;
        if (z10) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i10, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i10, 0);
        C9603h0.m59898n0(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i10, 0);
        boolean z11 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z11);
    }

    public final void dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().m60236e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator, int i12) {
        smoothScrollBy(i10, i11, interpolator, i12, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public AbstractC0833c0 f4312a;

        /* renamed from: b */
        public final Rect f4313b;

        /* renamed from: c */
        public boolean f4314c;

        /* renamed from: d */
        public boolean f4315d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4313b = new Rect();
            this.f4314c = true;
            this.f4315d = false;
        }

        /* renamed from: a */
        public int m5125a() {
            return this.f4312a.m5168o();
        }

        /* renamed from: c */
        public boolean m5126c() {
            return this.f4312a.m5139A();
        }

        /* renamed from: d */
        public boolean m5127d() {
            return this.f4312a.m5177x();
        }

        /* renamed from: e */
        public boolean m5128e() {
            return this.f4312a.m5175v();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f4313b = new Rect();
            this.f4314c = true;
            this.f4315d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4313b = new Rect();
            this.f4314c = true;
            this.f4315d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4313b = new Rect();
            this.f4314c = true;
            this.f4315d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f4313b = new Rect();
            this.f4314c = true;
            this.f4315d = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p != null) {
            return abstractC0846p.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        AbstractC0846p abstractC0846p = this.mLayout;
        if (abstractC0846p == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!abstractC0846p.canScrollHorizontally()) {
            i10 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        if (i12 != Integer.MIN_VALUE && i12 <= 0) {
            scrollBy(i10, i11);
            return;
        }
        if (z10) {
            int i13 = i10 != 0 ? 1 : 0;
            if (i11 != 0) {
                i13 |= 2;
            }
            startNestedScroll(i13, 1);
        }
        this.mViewFlinger.m5137f(i10, i11, i12, interpolator);
    }

    public void addItemDecoration(AbstractC0845o abstractC0845o) {
        addItemDecoration(abstractC0845o, -1);
    }
}
