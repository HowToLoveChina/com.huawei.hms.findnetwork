package com.huawei.uikit.hwrecyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.OverScroller;
import androidx.recyclerview.widget.AbstractC0875n;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.huawei.dynamicanimation.AbstractC4672b;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwrecyclerview.C8721R;
import com.huawei.uikit.hwrecyclerview.layoutmanager.HwFloatingBubblesLayoutManager;
import com.huawei.uikit.hwrecyclerview.widget.HwDefaultItemAnimator;
import com.huawei.uikit.hwrecyclerview.widget.HwRollbackRuleDetector;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwunifiedinteract.widget.HwCompoundEventDetector;
import com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector;
import com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector;
import com.huawei.uikit.hwunifiedinteract.widget.HwRotaryConverter;
import com.huawei.uikit.hwwidgetsafeinsets.widget.HwSafeInsetsShareImpl;
import com.huawei.uikit.hwwidgetsafeinsets.widget.HwWidgetSafeInsets;
import huawei.android.widget.HwSafeInsetsShareable;
import huawei.android.widget.ScrollCallback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p493nj.C11716c;
import p524oj.C11906a;

/* loaded from: classes4.dex */
public class HwRecyclerView extends RecyclerView implements ScrollCallback, HwSafeInsetsShareable {

    /* renamed from: C0 */
    static final int f43729C0 = -1;
    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    public static final int CHOICE_MODE_NONE = 0;

    /* renamed from: D0 */
    static final int f43730D0 = 1;

    /* renamed from: E0 */
    private static final String f43731E0 = "HwRecyclerView";

    /* renamed from: F0 */
    private static final int f43732F0 = Integer.MIN_VALUE;

    /* renamed from: G0 */
    private static final int f43733G0 = 15;

    /* renamed from: H0 */
    private static final String f43734H0 = "translationX";

    /* renamed from: I0 */
    private static final String f43735I0 = "translationY";
    public static final int ITEM_TYPE_BIG_CARD_TWO_MASK = 33554432;
    public static final int ITEM_TYPE_NORMAL_CARD_MASK = 16777216;
    public static final int ITEM_TYPE_NO_SCALE_CARD_MASK = 67108864;
    public static final int ITEM_TYPE_NO_SCALE_TITLE_MASK = 134217728;
    public static final int ITEM_TYPE_NO_SNAP_MASK = 268435456;

    /* renamed from: J0 */
    private static final int f43736J0 = 90;

    /* renamed from: K0 */
    private static final int f43737K0 = 0;

    /* renamed from: L0 */
    private static final int f43738L0 = 10;
    public static final int LINKVIEW_COLLAPSED = 2;
    public static final int LINKVIEW_EXPAND = 0;
    public static final int LINKVIEW_EXPANDING = 1;
    public static final int LINKVIEW_INVALID = -1;
    public static final int LINKVIEW_OVERCROLL = 3;

    /* renamed from: M0 */
    private static final int f43739M0 = 38;

    /* renamed from: N0 */
    private static final int f43740N0 = 300;

    /* renamed from: O0 */
    private static final int f43741O0 = 4;

    /* renamed from: P0 */
    private static final int f43742P0 = 90;

    /* renamed from: Q0 */
    private static final int f43743Q0 = -1;

    /* renamed from: R0 */
    private static final float f43744R0 = 228.0f;

    /* renamed from: S0 */
    private static final float f43745S0 = 30.0f;

    /* renamed from: T0 */
    private static final float f43746T0 = 200.0f;

    /* renamed from: U0 */
    private static final float f43747U0 = 28.0f;

    /* renamed from: V0 */
    private static final float f43748V0 = 0.5f;

    /* renamed from: W0 */
    private static final int f43749W0 = 10;

    /* renamed from: X0 */
    private static final int f43750X0 = 300;

    /* renamed from: Y0 */
    private static final int f43751Y0 = 200;

    /* renamed from: Z0 */
    private static final int f43752Z0 = 255;

    /* renamed from: a1 */
    private static final int f43753a1 = 150;

    /* renamed from: b1 */
    private static final int f43754b1 = 2;

    /* renamed from: c1 */
    private static final int f43755c1 = 1000;

    /* renamed from: d1 */
    private static final int f43756d1 = -1;

    /* renamed from: e1 */
    private static final int f43757e1 = -1;

    /* renamed from: f1 */
    private static final float f43758f1 = 8.0f;

    /* renamed from: g1 */
    private static final float f43759g1 = 0.5f;

    /* renamed from: h1 */
    private static final float f43760h1 = 1.0f;

    /* renamed from: i1 */
    private static final float f43761i1 = 0.6f;

    /* renamed from: j1 */
    private static final float f43762j1 = 0.6f;

    /* renamed from: k1 */
    private static final int f43763k1 = 5;

    /* renamed from: l1 */
    private static final int f43764l1 = 6;

    /* renamed from: m1 */
    private static final Interpolator f43765m1 = new blfhz();

    /* renamed from: A */
    private int f43766A;

    /* renamed from: A0 */
    private HwPageTurningScrollHelper f43767A0;

    /* renamed from: B */
    private int f43768B;

    /* renamed from: B0 */
    private RecyclerView.AbstractC0850t f43769B0;

    /* renamed from: C */
    private int f43770C;

    /* renamed from: D */
    private boolean f43771D;

    /* renamed from: E */
    private boolean f43772E;

    /* renamed from: F */
    private int f43773F;

    /* renamed from: G */
    private boqdu f43774G;

    /* renamed from: H */
    private Field f43775H;

    /* renamed from: I */
    private HwLinkedViewCallBack f43776I;

    /* renamed from: J */
    private alzfb f43777J;

    /* renamed from: K */
    private int f43778K;

    /* renamed from: L */
    private OverScroller f43779L;

    /* renamed from: M */
    private boolean f43780M;

    /* renamed from: N */
    private int f43781N;

    /* renamed from: O */
    private int f43782O;

    /* renamed from: P */
    private boolean f43783P;

    /* renamed from: Q */
    private boolean f43784Q;

    /* renamed from: R */
    private final int[] f43785R;

    /* renamed from: S */
    private int f43786S;

    /* renamed from: T */
    private int f43787T;

    /* renamed from: U */
    private int f43788U;

    /* renamed from: V */
    private int f43789V;

    /* renamed from: W */
    private long f43790W;

    /* renamed from: a */
    private GestureDetector f43791a;

    /* renamed from: a0 */
    private ContextMenu.ContextMenuInfo f43792a0;

    /* renamed from: b */
    private DeleteAnimatorCallback f43793b;

    /* renamed from: b0 */
    private boolean f43794b0;

    /* renamed from: c */
    private List<anbq> f43795c;

    /* renamed from: c0 */
    private HwGenericEventDetector f43796c0;

    /* renamed from: d */
    private int f43797d;

    /* renamed from: d0 */
    private boolean f43798d0;

    /* renamed from: e */
    private int f43799e;

    /* renamed from: e0 */
    private HwKeyEventDetector f43800e0;

    /* renamed from: f */
    private Runnable f43801f;

    /* renamed from: f0 */
    private AbstractC0875n f43802f0;

    /* renamed from: g */
    private HwOnOverScrollListener f43803g;

    /* renamed from: g0 */
    private int f43804g0;

    /* renamed from: h */
    private List<HwOnOverScrollListener> f43805h;

    /* renamed from: h0 */
    private int f43806h0;

    /* renamed from: i */
    private boolean f43807i;

    /* renamed from: i0 */
    private float f43808i0;

    /* renamed from: j */
    private boolean f43809j;

    /* renamed from: j0 */
    private boolean f43810j0;

    /* renamed from: k */
    private boolean f43811k;

    /* renamed from: k0 */
    private Method f43812k0;

    /* renamed from: l */
    private boolean f43813l;

    /* renamed from: l0 */
    private com.huawei.uikit.hwrecyclerview.widget.bqmxo f43814l0;

    /* renamed from: m */
    private boolean f43815m;

    /* renamed from: m0 */
    private HwCompoundEventDetector f43816m0;
    protected HwRollbackRuleDetectorProxy mRollbackRuleDetectorProxy;

    /* renamed from: n */
    private boolean f43817n;

    /* renamed from: n0 */
    private float f43818n0;

    /* renamed from: o */
    private VelocityTracker f43819o;

    /* renamed from: o0 */
    private int f43820o0;

    /* renamed from: p */
    private boolean f43821p;

    /* renamed from: p0 */
    private float f43822p0;

    /* renamed from: q */
    private boolean f43823q;

    /* renamed from: q0 */
    private boolean f43824q0;

    /* renamed from: r */
    private boolean f43825r;

    /* renamed from: r0 */
    private boolean f43826r0;

    /* renamed from: s */
    private boolean f43827s;

    /* renamed from: s0 */
    private boolean f43828s0;

    /* renamed from: t */
    private afdzw f43829t;

    /* renamed from: t0 */
    private int f43830t0;

    /* renamed from: u */
    private HwSafeInsetsShareImpl f43831u;

    /* renamed from: u0 */
    private int f43832u0;

    /* renamed from: v */
    private HwWidgetSafeInsets f43833v;

    /* renamed from: v0 */
    private HwChainAnimationListener f43834v0;

    /* renamed from: w */
    private Rect f43835w;

    /* renamed from: w0 */
    private boolean f43836w0;

    /* renamed from: x */
    private Rect f43837x;

    /* renamed from: x0 */
    private final ViewTreeObserver.OnPreDrawListener f43838x0;

    /* renamed from: y */
    private Map<Integer, Rect> f43839y;

    /* renamed from: y0 */
    private boolean f43840y0;

    /* renamed from: z */
    private ValueAnimator f43841z;

    /* renamed from: z0 */
    private Interpolator f43842z0;

    public interface DeleteAnimatorCallback {
        int getItemPosition(Object obj);

        int getPositionByView(View view);

        void notifyResult(boolean z10);

        void remove(Object obj);
    }

    public interface MultiChoiceModeListener extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode actionMode, int i10, long j10, boolean z10);
    }

    @Deprecated
    public interface OnItemClickListener {
        boolean onItemClick(View view, int i10, long j10);
    }

    @Deprecated
    public interface OnItemLongClickListener {
        boolean onItemLongClick(View view, int i10, long j10);
    }

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {
        public aauaf() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HwRecyclerView.this.m55265d(valueAnimator);
        }
    }

    public class aayti extends RecyclerView.AbstractC0850t {

        /* renamed from: a */
        private int f43844a = 0;

        /* renamed from: b */
        private int f43845b = 0;

        /* renamed from: c */
        private int f43846c = 0;

        public aayti() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            OverScroller overScroller;
            if (!HwRecyclerView.this.canScrollVertically(-1)) {
                HwRecyclerView.this.f43804g0 = 0;
            }
            int i11 = this.f43844a;
            this.f43844a = i10;
            if (i11 == 2 && i10 == 0) {
                if (HwRecyclerView.this.f43841z == null || !HwRecyclerView.this.f43841z.isRunning()) {
                    RecyclerView.AbstractC0846p layoutManager = HwRecyclerView.this.getLayoutManager();
                    if (layoutManager == null) {
                        Log.e(HwRecyclerView.f43731E0, "onScrollStateChanged: call getLayoutManager failed");
                        return;
                    }
                    if (!layoutManager.canScrollVertically() || HwRecyclerView.this.m55299r()) {
                        if ((layoutManager.canScrollHorizontally() && !HwRecyclerView.this.m55298q()) || (overScroller = HwRecyclerView.this.getOverScroller()) == null || HwRecyclerView.this.f43784Q) {
                            return;
                        }
                        HwRecyclerView.this.m55207a(overScroller, this.f43845b, this.f43846c, 0L);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.f43845b = i10;
            this.f43846c = i11;
            HwRecyclerView.m55270e(HwRecyclerView.this, i11);
            HwRecyclerView.this.m55262d();
        }
    }

    public class afdzw implements Runnable {

        /* renamed from: a */
        private int f43848a;

        private afdzw() {
        }

        /* renamed from: a */
        public void m55310a(int i10) {
            m55309a();
            this.f43848a = i10;
            HwRecyclerView.this.postOnAnimation(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            HwRecyclerView.this.smoothScrollBy(0, this.f43848a, new LinearInterpolator());
            HwRecyclerView.this.postOnAnimation(this);
        }

        public /* synthetic */ afdzw(HwRecyclerView hwRecyclerView, blfhz blfhzVar) {
            this();
        }

        /* renamed from: a */
        public void m55309a() {
            HwRecyclerView.this.removeCallbacks(this);
        }
    }

    public class aijfr extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.AbstractC0838h f43850a;

        public aijfr(RecyclerView.AbstractC0838h abstractC0838h) {
            this.f43850a = abstractC0838h;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwRecyclerView.this.m55267d(this.f43850a);
        }
    }

    public class akxao extends AnimatorListenerAdapter {
        public akxao() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            HwRecyclerView.this.onOverScrollEnd();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HwRecyclerView.this.onOverScrollStart();
        }
    }

    public class alzfb implements Runnable {

        /* renamed from: h */
        private static final int f43853h = 0;

        /* renamed from: i */
        private static final int f43854i = 1;

        /* renamed from: j */
        private static final int f43855j = 2;

        /* renamed from: k */
        private static final int f43856k = 2;

        /* renamed from: a */
        private final int[] f43857a;

        /* renamed from: b */
        private int f43858b;

        /* renamed from: c */
        private int f43859c;

        /* renamed from: d */
        private int f43860d;

        /* renamed from: e */
        private boolean f43861e;

        /* renamed from: f */
        private long f43862f;

        private alzfb() {
            this.f43857a = new int[2];
            this.f43858b = 0;
            this.f43861e = true;
            this.f43862f = 0L;
        }

        /* renamed from: c */
        private void m55315c() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (HwRecyclerView.this.f43790W == 0) {
                long j10 = this.f43862f;
                if (jCurrentAnimationTimeMillis != j10) {
                    HwRecyclerView.this.f43790W = jCurrentAnimationTimeMillis - j10;
                }
            }
            int[] iArr = this.f43857a;
            int currY = HwRecyclerView.this.f43779L.getCurrY();
            int i10 = currY - HwRecyclerView.this.f43778K;
            HwRecyclerView.this.f43778K = currY;
            if (i10 == 0 && HwRecyclerView.this.f43778K == 0) {
                HwRecyclerView.this.postOnAnimation(this);
                return;
            }
            int iLinkedViewHeight = HwRecyclerView.this.f43776I.linkedViewHeight();
            HwRecyclerView.this.startNestedScroll(2, 0);
            if (HwRecyclerView.this.dispatchNestedPreScroll(0, i10, iArr, null, 0)) {
                i10 -= iArr[1];
            }
            if (i10 != 0 && HwRecyclerView.this.dispatchNestedScroll(0, 0, 0, i10, null, 0)) {
                int currVelocity = (int) HwRecyclerView.this.f43779L.getCurrVelocity();
                int iLinkedViewState = HwRecyclerView.this.f43776I.linkedViewState();
                boolean z10 = currVelocity > 0;
                boolean z11 = (iLinkedViewState == 0 && this.f43859c < 0) || (iLinkedViewState == 2 && this.f43859c > 0);
                if (z10 && z11) {
                    int iLinkedViewHeight2 = (HwRecyclerView.this.f43776I.linkedViewHeight() - iLinkedViewHeight) + i10;
                    this.f43860d = iLinkedViewHeight2;
                    if (iLinkedViewHeight2 < 0) {
                        this.f43858b = 2;
                        run();
                    } else {
                        HwRecyclerView hwRecyclerView = HwRecyclerView.this;
                        hwRecyclerView.m55207a(hwRecyclerView.f43779L, 0, this.f43859c, HwRecyclerView.this.f43790W);
                        m55311a();
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f43861e) {
                return;
            }
            if (HwRecyclerView.this.f43776I == null) {
                m55311a();
                return;
            }
            if (this.f43860d < 0 && this.f43858b == 2) {
                HwRecyclerView.this.onOverScrollRunning(Math.abs(r0));
                HwRecyclerView hwRecyclerView = HwRecyclerView.this;
                hwRecyclerView.m55207a(hwRecyclerView.f43779L, 0, this.f43859c, HwRecyclerView.this.f43790W);
                m55311a();
                this.f43860d = 0;
                return;
            }
            if (!HwRecyclerView.this.f43779L.computeScrollOffset()) {
                m55311a();
                return;
            }
            m55315c();
            if (HwRecyclerView.this.f43779L.isFinished()) {
                m55311a();
            } else {
                HwRecyclerView.this.postOnAnimation(this);
            }
        }

        /* renamed from: b */
        public boolean m55314b() {
            return this.f43861e;
        }

        /* renamed from: a */
        public void m55316a(OverScroller overScroller, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.f43859c = i10;
            this.f43858b = 1;
            this.f43861e = false;
            this.f43862f = AnimationUtils.currentAnimationTimeMillis();
            run();
        }

        public /* synthetic */ alzfb(HwRecyclerView hwRecyclerView, blfhz blfhzVar) {
            this();
        }

        /* renamed from: a */
        public void m55311a() {
            HwRecyclerView.this.stopNestedScroll();
            HwRecyclerView.this.f43780M = false;
            this.f43858b = 0;
            HwRecyclerView.this.f43778K = 0;
            this.f43861e = true;
        }
    }

    public class anbq {

        /* renamed from: a */
        Object f43864a;

        /* renamed from: b */
        int f43865b;

        /* renamed from: c */
        View f43866c;

        /* renamed from: l */
        com.huawei.uikit.hwrecyclerview.widget.bzrwd f43875l;

        /* renamed from: m */
        ViewGroupOverlay f43876m;

        /* renamed from: o */
        boolean f43878o;

        /* renamed from: p */
        RecyclerView.AbstractC0838h f43879p;

        /* renamed from: d */
        boolean f43867d = false;

        /* renamed from: e */
        boolean f43868e = false;

        /* renamed from: f */
        int f43869f = 0;

        /* renamed from: g */
        int f43870g = 0;

        /* renamed from: h */
        int f43871h = 0;

        /* renamed from: i */
        float f43872i = 1.0f;

        /* renamed from: j */
        int f43873j = 0;

        /* renamed from: k */
        int f43874k = 0;

        /* renamed from: n */
        boolean f43877n = false;

        public anbq(RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0846p abstractC0846p, int i10) {
            this.f43879p = abstractC0838h;
            this.f43865b = i10;
            if (abstractC0846p != null) {
                this.f43866c = abstractC0846p.findViewByPosition(i10);
            }
        }

        /* renamed from: b */
        private ViewGroupOverlay m55326b(View view) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                Log.e(HwRecyclerView.f43731E0, "getParentViewOverlay: viewParent is null");
                return null;
            }
            if (parent instanceof ViewGroup) {
                return ((ViewGroup) parent).getOverlay();
            }
            Log.e(HwRecyclerView.f43731E0, "getParentViewOverlay: viewParent is not instance of ViewGroup");
            return null;
        }

        /* renamed from: a */
        public void m55325a(Object obj, boolean z10) {
            this.f43864a = obj;
            this.f43867d = obj != null;
            View view = this.f43866c;
            if (view == null || !z10) {
                return;
            }
            this.f43875l = m55319a(view);
            this.f43876m = m55326b(this.f43866c);
            this.f43874k = this.f43866c.getTop();
        }

        /* renamed from: a */
        private com.huawei.uikit.hwrecyclerview.widget.bzrwd m55319a(View view) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0) {
                width = view.getLayoutParams().width;
            }
            if (height <= 0) {
                height = view.getLayoutParams().height;
            }
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(bitmapCreateBitmap));
                com.huawei.uikit.hwrecyclerview.widget.bzrwd bzrwdVar = new com.huawei.uikit.hwrecyclerview.widget.bzrwd(view.getResources(), bitmapCreateBitmap, 0);
                bzrwdVar.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                bzrwdVar.m55419a(view.getLeft(), view.getTop());
                return bzrwdVar;
            }
            Log.w(HwRecyclerView.f43731E0, "getAnimDrawable: width or height is invalid.");
            return null;
        }

        /* renamed from: a */
        public void m55321a(float f10) {
            this.f43872i = f10;
            if (this.f43873j == 0) {
                this.f43872i = 0.0f;
            }
            com.huawei.uikit.hwrecyclerview.widget.bzrwd bzrwdVar = this.f43875l;
            if (bzrwdVar != null) {
                bzrwdVar.setAlpha(((int) this.f43872i) * 255);
            }
            View view = this.f43866c;
            if (view != null) {
                if (this.f43877n) {
                    view.setAlpha(0.0f);
                } else {
                    view.setAlpha(this.f43872i);
                }
            }
        }

        /* renamed from: a */
        public int m55317a(int i10, int i11) {
            com.huawei.uikit.hwrecyclerview.widget.bzrwd bzrwdVar;
            int i12 = this.f43873j;
            this.f43873j = i10;
            View view = this.f43866c;
            if (view == null) {
                return 0;
            }
            int top = view.getTop();
            ViewGroupOverlay viewGroupOverlay = this.f43876m;
            if (viewGroupOverlay != null && (bzrwdVar = this.f43875l) != null) {
                int i13 = this.f43873j;
                if (i13 > 0) {
                    if (!this.f43877n) {
                        viewGroupOverlay.add(bzrwdVar);
                        this.f43877n = true;
                        this.f43866c.setAlpha(0.0f);
                    }
                    int i14 = this.f43874k;
                    if (i14 > top) {
                        this.f43875l.m55419a(this.f43866c.getLeft(), top - i11);
                    } else if (i14 < top) {
                        this.f43875l.m55419a(this.f43866c.getLeft(), (i12 - this.f43873j) + top);
                    } else {
                        this.f43875l.m55419a(this.f43866c.getLeft(), top);
                    }
                    this.f43875l.m55420b(0, this.f43873j - this.f43869f);
                    i12 -= this.f43873j;
                } else if (i13 == 0 && this.f43877n) {
                    viewGroupOverlay.remove(bzrwdVar);
                    this.f43875l = null;
                } else {
                    Log.e(HwRecyclerView.f43731E0, "invalid height");
                }
                i11 += i12;
            }
            if (this.f43873j == 0) {
                RecyclerView.AbstractC0833c0 childViewHolder = HwRecyclerView.this.getChildViewHolder(this.f43866c);
                this.f43878o = childViewHolder.m5176w();
                childViewHolder.m5147I(false);
            }
            this.f43874k = top;
            this.f43866c.getLayoutParams().height = this.f43873j;
            this.f43866c.requestLayout();
            return i11;
        }

        /* renamed from: a */
        public void m55320a() {
            ViewGroupOverlay viewGroupOverlay;
            com.huawei.uikit.hwrecyclerview.widget.bzrwd bzrwdVar;
            if (this.f43867d) {
                if (this.f43877n && (viewGroupOverlay = this.f43876m) != null && (bzrwdVar = this.f43875l) != null) {
                    viewGroupOverlay.remove(bzrwdVar);
                }
                View view = this.f43866c;
                if (view != null) {
                    view.setAlpha(1.0f);
                    this.f43866c.getLayoutParams().height = this.f43869f;
                    this.f43866c.requestLayout();
                    if (this.f43873j == 0) {
                        HwRecyclerView.this.getChildViewHolder(this.f43866c).m5147I(this.f43878o);
                    }
                }
                this.f43868e = true;
            }
        }
    }

    public class avpbg implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        int f43881a;

        public avpbg() {
            this.f43881a = (int) (HwRecyclerView.this.isLayoutVertical() ? HwRecyclerView.this.getTranslationY() : HwRecyclerView.this.getTranslationX());
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwRecyclerView.f43731E0, "mSpringBackAnimator: onAnimationUpdate: animation is null");
                return;
            }
            if (HwRecyclerView.this.isChainAnimationEnabled()) {
                int iFloatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HwRecyclerView.this.m55277f(this.f43881a - iFloatValue);
                this.f43881a = iFloatValue;
            }
            HwRecyclerView.this.onOverScrollRunning(((Float) valueAnimator.getAnimatedValue()).floatValue());
            HwRecyclerView.this.invalidate();
        }
    }

    public class awsks implements Runnable {
        public awsks() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            HwRecyclerView.this.m55306y();
            HwRecyclerView.this.smoothScrollToPosition(0);
            if (HwRecyclerView.this.f43821p) {
                return;
            }
            HwRecyclerView.this.mRollbackRuleDetectorProxy.postScrollUsedEvent();
            HwRecyclerView.this.f43821p = true;
        }
    }

    public class bfscp implements HwGenericEventDetector.OnScrollListener {
        public bfscp() {
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector.OnScrollListener
        public boolean onScrollBy(float f10, float f11, MotionEvent motionEvent) {
            return HwRecyclerView.this.performScroll(f10, f11);
        }
    }

    public class blfhz implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class boqdu implements Runnable {

        /* renamed from: a */
        private boolean f43885a;

        /* renamed from: b */
        private com.huawei.uikit.hwrecyclerview.widget.avpbg f43886b;

        /* renamed from: c */
        private int f43887c;

        private boqdu() {
            this.f43885a = true;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f43885a || this.f43886b == null || HwRecyclerView.this.m55297p()) {
                return;
            }
            this.f43885a = this.f43886b.m55353c();
            float fM55350a = this.f43886b.m55350a();
            if (HwRecyclerView.this.isChainAnimationEnabled()) {
                HwRecyclerView.this.m55277f((int) ((this.f43887c == 1 ? HwRecyclerView.this.getTranslationY() : HwRecyclerView.this.getTranslationX()) - fM55350a));
            }
            HwRecyclerView.this.m55198a(this.f43887c, fM55350a);
            HwRecyclerView.this.invalidate();
            if (this.f43885a) {
                HwRecyclerView.this.onOverScrollEnd();
            } else {
                HwRecyclerView.this.onOverScrollRunning(fM55350a);
                HwRecyclerView.this.postOnAnimation(this);
            }
        }

        /* renamed from: b */
        public boolean m55330b() {
            return this.f43885a;
        }

        /* renamed from: a */
        public void m55331a(int i10, float f10, int i11, int i12, long j10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Float.compare(f10, 0.0f) == 0) {
                this.f43885a = true;
                return;
            }
            com.huawei.uikit.hwrecyclerview.widget.avpbg avpbgVar = new com.huawei.uikit.hwrecyclerview.widget.avpbg(!HwRecyclerView.this.isChainAnimationEnabled() ? HwRecyclerView.f43744R0 : HwRecyclerView.f43746T0, !HwRecyclerView.this.isChainAnimationEnabled() ? 30.0f : HwRecyclerView.f43747U0, i11, i12, f10);
            this.f43886b = avpbgVar;
            avpbgVar.m55351a(j10);
            this.f43885a = false;
            this.f43887c = i10;
            HwRecyclerView.this.onOverScrollStart();
            run();
        }

        public /* synthetic */ boqdu(HwRecyclerView hwRecyclerView, blfhz blfhzVar) {
            this();
        }

        /* renamed from: a */
        public void m55327a() {
            this.f43885a = true;
        }
    }

    public class bqmxo implements HwDefaultItemAnimator.ItemDeleteCallBack {

        /* renamed from: a */
        final /* synthetic */ HwDefaultItemAnimator f43889a;

        /* renamed from: b */
        final /* synthetic */ List f43890b;

        public bqmxo(HwDefaultItemAnimator hwDefaultItemAnimator, List list) {
            this.f43889a = hwDefaultItemAnimator;
            this.f43890b = list;
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwDefaultItemAnimator.ItemDeleteCallBack
        public Animator playDisappearAnimator() {
            return HwRecyclerView.this.m55191a(this.f43889a, (List<anbq>) this.f43890b);
        }
    }

    public class brnby implements ViewTreeObserver.OnPreDrawListener {
        public brnby() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!HwRecyclerView.this.f43824q0 || HwRecyclerView.this.getChildCount() <= 0) {
                return true;
            }
            HwRecyclerView.this.m55180C();
            HwRecyclerView.this.f43824q0 = false;
            return true;
        }
    }

    public class bwuqo implements Comparator<HwPositionPair> {
        public bwuqo() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(HwPositionPair hwPositionPair, HwPositionPair hwPositionPair2) {
            if (hwPositionPair == null && hwPositionPair2 == null) {
                return 0;
            }
            return (hwPositionPair == null || hwPositionPair2 == null) ? hwPositionPair == null ? 1 : -1 : hwPositionPair2.compareTo(hwPositionPair);
        }
    }

    public class bxac extends RecyclerView.AbstractC0850t {
        public bxac() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int childCount;
            View viewFindViewByPosition;
            RecyclerView.AbstractC0846p layoutManager = HwRecyclerView.this.getLayoutManager();
            if (layoutManager == null || (childCount = layoutManager.getChildCount()) < 1 || (viewFindViewByPosition = layoutManager.findViewByPosition(childCount - 1)) == null) {
                return;
            }
            int height = (int) ((HwRecyclerView.this.getHeight() * 0.5f) - (viewFindViewByPosition.getHeight() * 0.5f));
            if (HwRecyclerView.this.getPaddingBottom() == height || height <= 0) {
                return;
            }
            HwRecyclerView hwRecyclerView = HwRecyclerView.this;
            hwRecyclerView.f43832u0 = hwRecyclerView.getPaddingBottom();
            HwRecyclerView hwRecyclerView2 = HwRecyclerView.this;
            hwRecyclerView2.setPadding(hwRecyclerView2.getPaddingLeft(), HwRecyclerView.this.getPaddingTop(), HwRecyclerView.this.getPaddingRight(), height);
        }
    }

    public class bzqlh implements HwRollbackRuleDetector.RollBackScrollListener {
        public bzqlh() {
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwRollbackRuleDetector.RollBackScrollListener
        public int getScrollYDistance() {
            return HwRecyclerView.this.computeVerticalScrollOffset();
        }
    }

    public class bzrwd extends AnimatorListenerAdapter {
        public bzrwd() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwRecyclerView.this.m55301t();
        }
    }

    public HwRecyclerView(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m55178A() {
        HwLinkedViewCallBack hwLinkedViewCallBack = this.f43776I;
        if (hwLinkedViewCallBack == null || this.f43781N != Integer.MIN_VALUE) {
            return;
        }
        this.f43781N = hwLinkedViewCallBack.linkedViewHeight();
    }

    /* renamed from: B */
    private void m55179B() {
        addOnScrollListener(new aayti());
    }

    /* renamed from: C */
    public void m55180C() {
        if (getChildCount() < 1 || !this.f43826r0) {
            return;
        }
        if (getChildAt(0) == null) {
            return;
        }
        int height = (int) ((getHeight() * 0.5f) - (r1.getHeight() * 0.5f));
        if (getPaddingTop() == height || height <= 0) {
            return;
        }
        this.f43830t0 = getPaddingTop();
        setPadding(getPaddingLeft(), height, getPaddingRight(), getPaddingBottom());
        View focusedChild = getFocusedChild();
        getLayoutManager().scrollToPosition(focusedChild != null ? getLayoutManager().getPosition(focusedChild) : 0);
    }

    /* renamed from: D */
    private void m55181D() {
        if (this.f43830t0 != Integer.MIN_VALUE) {
            setPadding(getPaddingLeft(), this.f43830t0, getPaddingRight(), this.f43832u0);
        }
    }

    /* renamed from: E */
    private void m55182E() {
        if (this.f43831u == null || !m55300s()) {
            return;
        }
        this.f43831u.shareSafeInsets(this.f43833v);
    }

    /* renamed from: F */
    private Animator m55183F() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.setDuration(150L);
        valueAnimatorOfInt.setInterpolator(AnimationUtils.loadInterpolator(getContext(), C8721R.interpolator.cubic_bezier_interpolator_type_33_33));
        valueAnimatorOfInt.addListener(getDisappearAnimatorListener());
        valueAnimatorOfInt.addUpdateListener(new aauaf());
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    private ValueAnimator.AnimatorUpdateListener getAlphaListener() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.uikit.hwrecyclerview.widget.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f43988a.m55237b(valueAnimator);
            }
        };
    }

    private Animator.AnimatorListener getDisappearAnimatorListener() {
        return new bzrwd();
    }

    private View getFirstVisibleView() {
        int firstVisibleViewIndex = getFirstVisibleViewIndex();
        if (firstVisibleViewIndex < 0) {
            return null;
        }
        return getChildAt(firstVisibleViewIndex);
    }

    private Field getFlingerField() throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mViewFlinger");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (ClassNotFoundException unused) {
            Log.e(f43731E0, "getFlingerField: class not found.");
            return null;
        } catch (NoSuchFieldException unused2) {
            Log.e(f43731E0, "getFlingerField: no such field.");
            return null;
        }
    }

    private ValueAnimator.AnimatorUpdateListener getHeightListener() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.uikit.hwrecyclerview.widget.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f43987a.m55256c(valueAnimator);
            }
        };
    }

    public static HwRecyclerView instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwRecyclerView.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwRecyclerView.class);
        if (objInstantiate instanceof HwRecyclerView) {
            return (HwRecyclerView) objInstantiate;
        }
        return null;
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f43786S) {
            try {
                this.f43786S = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
            } catch (IllegalArgumentException unused) {
                Log.e(f43731E0, "HwRecyclerView get pointerId error!");
            }
        }
    }

    /* renamed from: p */
    public boolean m55297p() {
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return true;
        }
        if (!layoutManager.canScrollVertically() || computeVerticalScrollRange() == 0) {
            return !layoutManager.canScrollHorizontally() || computeHorizontalScrollRange() == 0;
        }
        return false;
    }

    /* renamed from: q */
    public boolean m55298q() {
        return (canScrollHorizontally(1) && canScrollHorizontally(-1)) ? false : true;
    }

    /* renamed from: r */
    public boolean m55299r() {
        return (canScrollVertically(1) && canScrollVertically(-1)) ? false : true;
    }

    /* renamed from: s */
    private boolean m55300s() {
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        return !this.f43833v.isCutoutModeNever() && (layoutManager != null && layoutManager.getClass().isAssignableFrom(LinearLayoutManager.class));
    }

    private void setFirstItemCenteringEnabledInternal(boolean z10) {
        this.f43826r0 = z10;
        if (!z10) {
            m55181D();
            this.f43824q0 = false;
        } else if (getChildCount() > 0) {
            m55180C();
        } else {
            this.f43824q0 = true;
        }
    }

    private void setIntegerTranslationX(float f10) {
        setTranslationX((int) f10);
    }

    private void setIntegerTranslationY(float f10) {
        setTranslationY((int) f10);
    }

    private void setSensitivityMode(int i10) {
        if (i10 == 0) {
            this.f43822p0 = 1.0f;
        } else if (i10 == 2) {
            this.f43822p0 = 0.6f;
        } else {
            this.f43822p0 = 0.6f;
        }
    }

    private void setValueFromPlume(Context context) {
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            return;
        }
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, this, "listScrollEnabled", Boolean.TRUE});
        if (objInvokeMethod instanceof Boolean) {
            setExtendScrollEnabled(((Boolean) objInvokeMethod).booleanValue());
        }
    }

    /* renamed from: t */
    public void m55301t() {
        com.huawei.uikit.hwrecyclerview.widget.bzrwd bzrwdVar;
        List<anbq> list = this.f43795c;
        if (list == null) {
            Log.e(f43731E0, "getDisappearAnimatorListener: onAnimationEnd: mVisibleItemInfos is null");
            m55276f();
            this.f43793b.notifyResult(false);
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            anbq anbqVar = this.f43795c.get(i10);
            if (anbqVar.f43877n) {
                ViewGroupOverlay viewGroupOverlay = anbqVar.f43876m;
                if (viewGroupOverlay == null || (bzrwdVar = anbqVar.f43875l) == null) {
                    Log.w(f43731E0, "getDisappearAnimatorListener: onAnimationEnd: mViewOverlay/mAnimDrawable is null.");
                } else {
                    viewGroupOverlay.remove(bzrwdVar);
                }
                anbqVar.f43877n = false;
            }
        }
        m55276f();
        this.f43793b.notifyResult(true);
    }

    /* renamed from: u */
    private void m55302u() {
        afdzw afdzwVar = this.f43829t;
        if (afdzwVar != null) {
            afdzwVar.m55309a();
            stopScroll();
        }
    }

    /* renamed from: v */
    private void m55303v() {
        this.f43768B = 0;
        this.f43770C = 0;
    }

    /* renamed from: w */
    private boolean m55304w() {
        int size = this.f43795c.size();
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < size; i12++) {
            if (this.f43795c.get(i12).f43867d) {
                if (i10 == -1) {
                    i10 = i12;
                    i11 = i10;
                } else {
                    int i13 = i11 + 1;
                    if (i12 == i13) {
                        i11 = i13;
                    }
                }
            } else if (i10 != -1) {
                m55236b(i10, i11);
                i10 = -1;
                i11 = i10;
            }
        }
        if (i10 == -1) {
            return true;
        }
        m55236b(i10, i11);
        return true;
    }

    /* renamed from: x */
    private void m55305x() {
        OverScroller overScroller = this.f43779L;
        if (overScroller != null) {
            overScroller.abortAnimation();
        }
        if (!this.f43774G.m55330b()) {
            this.f43774G.m55327a();
        }
        if (this.f43777J.m55314b()) {
            return;
        }
        this.f43777J.m55311a();
    }

    /* renamed from: y */
    public void m55306y() {
        int i10 = ((int) ((this.f43806h0 * this.f43808i0) + 0.5f)) - this.f43804g0;
        if (m55275e(i10)) {
            scrollBy(0, i10);
        }
    }

    /* renamed from: z */
    private Class<?> m55307z() {
        Class<?> superclass = getClass();
        String name = RecyclerView.class.getName();
        for (int i10 = 0; i10 < 5; i10++) {
            if (name.equals(superclass.getName())) {
                return superclass;
            }
            superclass = superclass.getSuperclass();
        }
        return null;
    }

    public void addOverScrollListener(HwOnOverScrollListener hwOnOverScrollListener) {
        if (this.f43805h == null) {
            this.f43805h = new ArrayList();
        }
        if (hwOnOverScrollListener != null) {
            this.f43805h.add(hwOnOverScrollListener);
        }
    }

    @Override // huawei.android.widget.HwSafeInsetsShareable
    public void addSharedView(View view, int i10) {
        if (view == null || this.f43833v == null || !m55300s()) {
            return;
        }
        m55280g();
        this.f43831u.addSharedView(view, i10);
        if (isAttachedToWindow()) {
            this.f43831u.shareSafeInsets(view, this.f43833v);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) throws NoSuchFieldException, SecurityException {
        boolean z10 = layoutParams instanceof RecyclerView.LayoutParams;
        if (m55300s() && z10) {
            Object object = HwReflectUtil.getObject(layoutParams, "mViewHolder", RecyclerView.LayoutParams.class);
            if (object instanceof RecyclerView.AbstractC0833c0) {
                m55205a(view, ((RecyclerView.AbstractC0833c0) object).m5167n());
            }
        }
        super.addView(view, i10, layoutParams);
    }

    public void adjustVerticalScrollBarBounds(Rect rect) {
        int i10;
        if (rect == null || rect.isEmpty() || !m55300s()) {
            return;
        }
        int verticalScrollbarPosition = getVerticalScrollbarPosition();
        if (verticalScrollbarPosition == 0) {
            verticalScrollbarPosition = getLayoutDirection() == 1 ? 1 : 2;
        }
        Rect rect2 = this.f43837x;
        Rect rect3 = this.f43835w;
        int i11 = rect3.left;
        int i12 = rect2.left;
        if (i11 == i12 || verticalScrollbarPosition != 1) {
            int i13 = rect3.right;
            int i14 = rect2.right;
            i10 = (i13 == i14 || verticalScrollbarPosition != 2) ? 0 : i13 - i14;
        } else {
            i10 = i12 - i11;
        }
        rect.offset(i10, 0);
    }

    public boolean canHorizontalOverScroll(int i10) {
        if (this.f43807i && !this.f43771D) {
            if (i10 < 0 && !canScrollHorizontally(1) && this.f43811k) {
                onOverScrollStart();
            } else if (i10 <= 0 || canScrollHorizontally(-1) || !this.f43809j) {
                Log.e(f43731E0, "invalid scroll, do not onOverScrollStart");
            } else {
                onOverScrollStart();
            }
        }
        return this.f43771D;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        RecyclerView.AbstractC0838h adapter = getAdapter();
        if (this.f43802f0 == null || adapter == null) {
            return super.canScrollHorizontally(i10);
        }
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        return (layoutManager == null || !layoutManager.canScrollHorizontally()) ? super.canScrollHorizontally(i10) : i10 > 0 ? m55229a(adapter) : m55244b();
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        RecyclerView.AbstractC0838h adapter = getAdapter();
        if (getLayoutManager() instanceof HwFloatingBubblesLayoutManager) {
            return ((HwFloatingBubblesLayoutManager) getLayoutManager()).canVerticalScrollOnDirection(this, i10);
        }
        if (this.f43802f0 == null || adapter == null) {
            return super.canScrollVertically(i10);
        }
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        return (layoutManager == null || !layoutManager.canScrollVertically()) ? super.canScrollVertically(i10) : i10 > 0 ? m55229a(adapter) : m55244b();
    }

    public boolean canVerticalOverScroll(int i10, int i11) {
        if (this.f43807i && !this.f43771D) {
            HwLinkedViewCallBack hwLinkedViewCallBack = this.f43776I;
            if (hwLinkedViewCallBack != null) {
                if (hwLinkedViewCallBack.linkedViewState() != 2 && i10 < 0) {
                    this.f43770C = i11;
                    return false;
                }
                if (this.f43776I.linkedViewState() != 0 && i10 > 0 && getTranslationY() >= 0.0f) {
                    this.f43770C = i11;
                    return false;
                }
            }
            m55254c(i10);
        }
        return this.f43771D;
    }

    public boolean checkOverScrollEnabled(int i10) {
        HwLinkedViewCallBack hwLinkedViewCallBack;
        if (!this.f43784Q || (hwLinkedViewCallBack = this.f43776I) == null) {
            return true;
        }
        int iLinkedViewState = hwLinkedViewCallBack.linkedViewState();
        if ((iLinkedViewState == 0 || m55295o()) && getTranslationY() >= 0.0f) {
            return true;
        }
        if (iLinkedViewState != 2 || getTranslationY() > 0.0f) {
            return iLinkedViewState == 0 && getTranslationY() <= 0.0f && i10 > 0;
        }
        return true;
    }

    public void clearChoices() {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            bqmxoVar.m55385b();
        }
    }

    public HwCompoundEventDetector createCompoundEventDetector() {
        return new HwCompoundEventDetector(getContext());
    }

    public HwGenericEventDetector createGenericEventDetector() {
        return new HwGenericEventDetector(getContext());
    }

    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(getContext());
    }

    public HwGenericEventDetector.OnScrollListener createOnScrollListener() {
        return new bfscp();
    }

    public HwRotaryConverter createRotaryConverter() {
        Log.i(f43731E0, "Overwrite createRotaryConverter in the watch package.");
        return null;
    }

    public void deleteItemsWithAnimator(List<Object> list, DeleteAnimatorCallback deleteAnimatorCallback) {
        if (deleteAnimatorCallback == null) {
            Log.e(f43731E0, "deleteItemsWithAnimator: callback is null.");
            return;
        }
        this.f43793b = deleteAnimatorCallback;
        if (list == null || list.size() == 0) {
            Log.w(f43731E0, "deleteItemsWithAnimator: deleteItems is null.");
            deleteAnimatorCallback.notifyResult(false);
            return;
        }
        RecyclerView.AbstractC0843m itemAnimator = getItemAnimator();
        if (itemAnimator == null || itemAnimator.isRunning()) {
            Log.w(f43731E0, "deleteItemsWithAnimator: deleteItems is null.");
            deleteAnimatorCallback.notifyResult(false);
            return;
        }
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager == null) {
            Log.e(f43731E0, "deleteItemsWithAnimator: layoutManager is null.");
            deleteAnimatorCallback.notifyResult(false);
            return;
        }
        RecyclerView.AbstractC0838h adapter = getAdapter();
        if (adapter == null) {
            Log.e(f43731E0, "deleteItemsWithAnimator: adapter is null.");
            deleteAnimatorCallback.notifyResult(false);
            return;
        }
        if (layoutManager instanceof GridLayoutManager) {
            m55209a(layoutManager, adapter, itemAnimator, list);
            return;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            m55241b(layoutManager, adapter, itemAnimator, list);
        } else if (layoutManager instanceof LinearLayoutManager) {
            m55208a(adapter, layoutManager, list);
        } else {
            Log.e(f43731E0, "deleteItemsWithAnimator: do't support custom LayoutManager.");
            deleteAnimatorCallback.notifyResult(false);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (!this.f43798d0) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        HwChainAnimationListener hwChainAnimationListener = this.f43834v0;
        if (hwChainAnimationListener != null) {
            hwChainAnimationListener.dispatchGenericMotionEvent(motionEvent);
        }
        HwGenericEventDetector hwGenericEventDetector = this.f43796c0;
        if (hwGenericEventDetector == null || !hwGenericEventDetector.interceptGenericMotionEvent(motionEvent)) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        HwKeyEventDetector hwKeyEventDetector;
        List<anbq> list = this.f43795c;
        if (list != null && list.size() != 0) {
            return true;
        }
        if (keyEvent == null) {
            return false;
        }
        boolean zDispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (zDispatchKeyEvent || (hwKeyEventDetector = this.f43800e0) == null) ? zDispatchKeyEvent : hwKeyEventDetector.onKeyEvent(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        boolean zDispatchNestedPreScroll = super.dispatchNestedPreScroll(i10, i11, iArr, iArr2, i12);
        if (this.f43784Q && zDispatchNestedPreScroll && iArr2 != null) {
            int[] iArr3 = this.f43785R;
            iArr3[0] = iArr3[0] + iArr2[0];
            iArr3[1] = iArr3[1] + iArr2[1];
        }
        return zDispatchNestedPreScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        boolean zDispatchNestedScroll = super.dispatchNestedScroll(i10, i11, i12, i13, iArr, i14);
        if (this.f43784Q && zDispatchNestedScroll && iArr != null) {
            int[] iArr2 = this.f43785R;
            iArr2[0] = iArr2[0] + iArr[0];
            iArr2[1] = iArr2[1] + iArr[1];
        }
        return zDispatchNestedScroll;
    }

    public boolean dispatchStatusBarTop() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        List<anbq> list = this.f43795c;
        if (list != null && list.size() != 0) {
            return true;
        }
        HwChainAnimationListener hwChainAnimationListener = this.f43834v0;
        if (hwChainAnimationListener != null) {
            hwChainAnimationListener.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        m55201a(canvas);
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            bqmxoVar.m55400q();
        }
        super.draw(canvas);
    }

    public void enableBottomOverScroll(boolean z10) {
        this.f43811k = z10;
    }

    public void enableOverScroll(boolean z10) {
        this.f43807i = z10;
    }

    public void enablePhysicalFling(boolean z10) {
        this.f43817n = z10;
    }

    public void enableTopOverScroll(boolean z10) {
        this.f43809j = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i10, int i11) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f43784Q && this.f43779L.isFinished()) {
            VelocityTracker velocityTracker = this.f43819o;
            if (velocityTracker == null) {
                Log.w(f43731E0, "fling without velocityTracker");
                return super.fling(i10, i11);
            }
            velocityTracker.computeCurrentVelocity(1000, this.f43787T);
            int i12 = (int) (-this.f43819o.getYVelocity(this.f43786S));
            this.f43789V = i12;
            this.f43779L.fling(0, 0, 0, i12, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return super.fling(i10, i11);
            }
            if (layoutManager.canScrollVertically()) {
                if (((!canScrollVertically(-1) && this.f43789V < 0) || (!canScrollVertically(-1) && !canScrollVertically(1) && this.f43789V > 0)) && !this.f43780M && Math.abs(this.f43789V) >= this.f43788U && getTranslationY() == 0.0f) {
                    int i13 = this.f43789V > 0 ? 1 : -1;
                    this.f43780M = true;
                    this.f43778K = 0;
                    m55206a(this.f43779L, i13);
                }
            }
        }
        if (!this.f43827s) {
            return super.fling(i10, i11);
        }
        this.f43827s = false;
        return super.fling(0, 0);
    }

    public HwChainAnimationListener getChainAnimationListener() {
        return this.f43834v0;
    }

    public int getCheckedItemCount() {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar == null) {
            return 0;
        }
        return bqmxoVar.m55392g();
    }

    public long[] getCheckedItemIds() {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        return bqmxoVar == null ? new long[0] : bqmxoVar.m55393h();
    }

    public SparseBooleanArray getCheckedItemPositions() {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            return bqmxoVar.m55398n();
        }
        Log.e(f43731E0, "mHwMultipleChoiceModeHelper: is null");
        return null;
    }

    public ActionMode getChoiceActionMode() {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            return bqmxoVar.m55394i();
        }
        Log.e(f43731E0, "mHwMultipleChoiceModeHelper: is null");
        return null;
    }

    public int getChoiceMode() {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar == null) {
            return 0;
        }
        return bqmxoVar.m55395j();
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.f43792a0;
    }

    public float getDividerAlphaWhenDeleting(View view, float f10) {
        int size;
        if (view == null) {
            return f10;
        }
        if (view.getHeight() == 0) {
            return 0.0f;
        }
        if (this.f43795c == null) {
            return f10;
        }
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if ((layoutManager instanceof GridLayoutManager) || !(layoutManager instanceof LinearLayoutManager) || (size = this.f43795c.size()) == 0) {
            return f10;
        }
        anbq anbqVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            anbqVar = this.f43795c.get(i10);
            if (anbqVar.f43867d && view == anbqVar.f43866c) {
                break;
            }
        }
        if (anbqVar == null || anbqVar.f43866c != view) {
            return f10;
        }
        float f11 = anbqVar.f43872i;
        return f11 >= 1.0f ? f10 : f11;
    }

    public int getFirstVisibleViewIndex() {
        int childCount = getChildCount();
        if (childCount == 0 || this.f43795c == null) {
            return -1;
        }
        int paddingTop = getPaddingTop();
        int size = this.f43795c.size();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && !childAt.isDirty() && childAt.getBottom() >= paddingTop) {
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        i11 = 0;
                        break;
                    }
                    if (this.f43795c.get(i11).f43866c == childAt) {
                        break;
                    }
                    i11++;
                }
                if (i11 == size || !this.f43795c.get(i11).f43867d) {
                    return i10;
                }
            }
        }
        return -1;
    }

    public HwLinkedViewCallBack getLinkedViewCallBack() {
        return this.f43776I;
    }

    public MultiChoiceModeListener getMultiChoiceModeListener() {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            return bqmxoVar.m55396l();
        }
        Log.e(f43731E0, "mHwMultipleChoiceModeHelper: is null");
        return null;
    }

    public HwKeyEventDetector.OnEditEventListener getOnEditEventListener() {
        HwKeyEventDetector hwKeyEventDetector = this.f43800e0;
        if (hwKeyEventDetector != null) {
            return hwKeyEventDetector.getOnEditEventListener();
        }
        return null;
    }

    @Deprecated
    public OnItemClickListener getOnItemClickListener() {
        return null;
    }

    @Deprecated
    public OnItemLongClickListener getOnItemLongClickListener() {
        return null;
    }

    public HwKeyEventDetector.OnSearchEventListener getOnSearchEventListener() {
        HwKeyEventDetector hwKeyEventDetector = this.f43800e0;
        if (hwKeyEventDetector != null) {
            return hwKeyEventDetector.getOnSearchEventListener();
        }
        return null;
    }

    public float getOverScrollFactor() {
        return this.f43818n0;
    }

    @Deprecated
    public HwOnOverScrollListener getOverScrollListener() {
        return this.f43803g;
    }

    public float getOverScrollPosition(int i10, boolean z10) {
        float translationY = z10 ? getTranslationY() : getTranslationX();
        return translationY + m55184a(i10, Math.abs(translationY), (int) ((z10 ? getHeight() : getWidth()) * this.f43818n0));
    }

    public OverScroller getOverScroller() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field field = this.f43775H;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            Object object = HwReflectUtil.getObject(obj, "mScroller", this.f43775H.getType());
            if (object == null) {
                object = HwReflectUtil.getObject(obj, "mOverScroller", this.f43775H.getType());
            }
            if (object instanceof OverScroller) {
                return (OverScroller) object;
            }
        } catch (IllegalAccessException unused) {
            Log.e(f43731E0, "getOverScroller: illegal access.");
        }
        return null;
    }

    public float getScrollTopFactor() {
        return this.f43808i0;
    }

    public float getSensitivity() {
        HwGenericEventDetector hwGenericEventDetector = this.f43796c0;
        if (hwGenericEventDetector != null) {
            return hwGenericEventDetector.getSensitivity();
        }
        return 0.6f;
    }

    public void handleScrollToTop() {
        ValueAnimator valueAnimator = this.f43841z;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && isLayoutVertical() && canScrollVertically(-1) && getWindowVisibility() == 0 && hasWindowFocus()) {
            post(new awsks());
        }
    }

    public boolean isAdaptScrollBarEnabled() {
        return this.f43813l;
    }

    public boolean isBackToEdge(float f10, float f11) {
        return ((f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1)) < 0 && (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1)) >= 0) || ((f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1)) > 0 && (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1)) <= 0);
    }

    public boolean isChainAnimationEnabled() {
        return this.f43834v0 != null && this.f43836w0;
    }

    public boolean isExtendScrollConsumedEvent() {
        return this.f43810j0;
    }

    public boolean isExtendScrollEnabled() {
        return this.f43798d0;
    }

    public boolean isExtendedMultiChoiceEnabled(boolean z10) {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar == null) {
            return false;
        }
        return bqmxoVar.m55383a(z10);
    }

    public boolean isFirstItemCenteringEnabled() {
        return this.f43826r0;
    }

    public boolean isItemChecked(int i10) {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar == null) {
            return false;
        }
        return bqmxoVar.m55381a(i10);
    }

    public boolean isLastItemCenteringEnabled() {
        return this.f43828s0;
    }

    public boolean isLayoutVertical() {
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        return (layoutManager == null || !layoutManager.canScrollVertically() || layoutManager.canScrollHorizontally()) ? false : true;
    }

    public boolean isNeedResetOverScrollVelocity() {
        return true;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (m55300s()) {
            this.f43833v.updateWindowInsets(windowInsets);
        }
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        HwCompoundEventDetector hwCompoundEventDetector;
        super.onAttachedToWindow();
        this.f43833v.updateOriginPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        this.f43835w.set(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        m55271e();
        if (this.f43816m0 == null) {
            this.f43816m0 = createCompoundEventDetector();
        }
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null && (hwCompoundEventDetector = this.f43816m0) != null) {
            hwCompoundEventDetector.setOnMultiSelectEventListener(this, bqmxoVar.m55397m());
        }
        if (this.f43826r0) {
            getViewTreeObserver().addOnPreDrawListener(this.f43838x0);
        }
        HwChainAnimationListener hwChainAnimationListener = this.f43834v0;
        if (hwChainAnimationListener != null) {
            hwChainAnimationListener.onAttachedToWindow();
            addOnScrollListener(this.f43834v0);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getLayoutManager() instanceof HwFloatingBubblesLayoutManager) {
            ((HwFloatingBubblesLayoutManager) getLayoutManager()).onLocateChanged(this);
        }
        HwSafeInsetsShareImpl hwSafeInsetsShareImpl = this.f43831u;
        if (hwSafeInsetsShareImpl != null) {
            hwSafeInsetsShareImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onDetachedFromWindow();
        this.mRollbackRuleDetectorProxy.stop();
        m55253c();
        HwCompoundEventDetector hwCompoundEventDetector = this.f43816m0;
        if (hwCompoundEventDetector != null) {
            hwCompoundEventDetector.onDetachedFromWindow();
        }
        if (this.f43826r0) {
            getViewTreeObserver().removeOnPreDrawListener(this.f43838x0);
        }
        HwChainAnimationListener hwChainAnimationListener = this.f43834v0;
        if (hwChainAnimationListener != null) {
            hwChainAnimationListener.onDetachedFromWindow();
            removeOnScrollListener(this.f43834v0);
        }
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        float[] fArr = {0.0f, 0.0f};
        if (!m55234a(fArr)) {
            super.onDrawForeground(canvas);
            return;
        }
        float scrollX = getScrollX() - fArr[0];
        float scrollY = getScrollY() - fArr[1];
        canvas.translate(scrollX, scrollY);
        super.onDrawForeground(canvas);
        canvas.translate(-scrollX, -scrollY);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        HwGenericEventDetector hwGenericEventDetector;
        if (motionEvent == null) {
            return false;
        }
        HwCompoundEventDetector hwCompoundEventDetector = this.f43816m0;
        if (hwCompoundEventDetector != null && hwCompoundEventDetector.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        if (this.f43798d0 && (hwGenericEventDetector = this.f43796c0) != null && hwGenericEventDetector.onGenericMotionEvent(motionEvent)) {
            return this.f43810j0;
        }
        if (motionEvent.getAction() == 11 && motionEvent.isFromSource(2)) {
            int buttonState = motionEvent.getButtonState();
            com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
            if (bqmxoVar != null && (buttonState == 32 || buttonState == 2)) {
                bqmxoVar.m55389c(motionEvent);
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.e(f43731E0, "onInterceptTouchEvent: motionEvent is null");
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        this.f43782O = actionMasked;
        if (actionMasked == 0) {
            if (this.f43840y0) {
                this.f43767A0.m55175a(motionEvent);
            }
            m55305x();
        }
        if ((actionMasked == 2 && this.f43772E) || super.onInterceptTouchEvent(motionEvent) || this.f43771D) {
            return true;
        }
        if (!this.f43807i) {
            return false;
        }
        int actionIndex = motionEvent.getActionIndex();
        if (!m55299r() && !m55298q()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        m55203a(motionEvent, actionMasked, actionIndex);
        return this.f43772E;
    }

    public boolean onItemClick(View view, int i10, long j10) {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar;
        if (this.f43771D) {
            return false;
        }
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar2 = this.f43814l0;
        if (bqmxoVar2 != null && bqmxoVar2.m55399p()) {
            return true;
        }
        if (view == null || (bqmxoVar = this.f43814l0) == null) {
            return false;
        }
        return bqmxoVar.m55382a(i10, j10);
    }

    public void onItemLongClick(View view) {
        if (this.f43771D || view == null) {
            return;
        }
        int childAdapterPosition = getChildAdapterPosition(view);
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            bqmxoVar.m55387b(childAdapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        RecyclerView.AbstractC0838h adapter;
        super.onLayout(z10, i10, i11, i12, i13);
        if (m55300s() && (adapter = getAdapter()) != null) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (childAt != null) {
                    int childAdapterPosition = getChildAdapterPosition(childAt);
                    if (childAdapterPosition == -1 || childAdapterPosition >= adapter.mo721e()) {
                        Log.w(f43731E0, "the position is " + childAdapterPosition);
                        break;
                    }
                    m55205a(childAt, adapter.mo749g(childAdapterPosition));
                    com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
                    if (bqmxoVar != null) {
                        bqmxoVar.m55377a(childAt, childAdapterPosition);
                    }
                }
            }
            Rect displaySafeInsets = this.f43833v.getDisplaySafeInsets(this);
            if (displaySafeInsets != null) {
                this.f43837x.set(displaySafeInsets);
            }
            m55178A();
            m55182E();
        }
    }

    public void onOverScrollEnd() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (getTranslationY() == 0.0f && getTranslationX() == 0.0f && this.f43771D) {
            this.f43771D = false;
            HwOnOverScrollListener hwOnOverScrollListener = this.f43803g;
            if (hwOnOverScrollListener != null) {
                hwOnOverScrollListener.onOverScrollEnd();
            }
            List<HwOnOverScrollListener> list = this.f43805h;
            if (list != null) {
                Iterator<HwOnOverScrollListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onOverScrollEnd();
                }
            }
            setScrollStateExtend(0);
        }
    }

    public void onOverScrollRunning(float f10) {
        if (this.f43771D) {
            HwOnOverScrollListener hwOnOverScrollListener = this.f43803g;
            if (hwOnOverScrollListener != null) {
                hwOnOverScrollListener.onOverScrolled(f10);
            }
            List<HwOnOverScrollListener> list = this.f43805h;
            if (list != null) {
                Iterator<HwOnOverScrollListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onOverScrolled(f10);
                }
            }
        }
    }

    public void onOverScrollStart() {
        if (this.f43771D) {
            return;
        }
        this.f43771D = true;
        HwOnOverScrollListener hwOnOverScrollListener = this.f43803g;
        if (hwOnOverScrollListener != null) {
            hwOnOverScrollListener.onOverScrollStart();
        }
        List<HwOnOverScrollListener> list = this.f43805h;
        if (list != null) {
            Iterator<HwOnOverScrollListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onOverScrollStart();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        Parcelable parcelableM55374a = bqmxoVar != null ? bqmxoVar.m55374a(parcelable) : null;
        if (parcelableM55374a != null) {
            super.onRestoreInstanceState(parcelableM55374a);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        return bqmxoVar == null ? parcelableOnSaveInstanceState : bqmxoVar.m55384b(parcelableOnSaveInstanceState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.w(f43731E0, "onTouchEvent(): motionEvent can not be null!");
            return false;
        }
        this.mRollbackRuleDetectorProxy.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        this.f43782O = actionMasked;
        if (m55225a(motionEvent, actionMasked)) {
            return true;
        }
        int actionIndex = motionEvent.getActionIndex();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        m55197a(actionMasked);
        int[] iArr = this.f43785R;
        motionEventObtain.offsetLocation(iArr[0], iArr[1]);
        return m55226a(motionEvent, actionMasked, actionIndex, motionEventObtain);
    }

    public void pauseAllAnimations() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m55302u();
        this.f43779L.abortAnimation();
        fling(0, 0);
        m55253c();
    }

    @Deprecated
    public boolean performItemClick(View view, int i10, long j10) {
        return false;
    }

    public boolean performScroll(float f10, float f11) {
        if (isLayoutVertical()) {
            scrollBy(0, (int) f11);
            return true;
        }
        if (Float.compare(f10, 0.0f) == 0) {
            f10 = f11;
        }
        scrollBy((int) f10, 0);
        return true;
    }

    public void performVibrate() {
    }

    public void removeOverScrollListener(HwOnOverScrollListener hwOnOverScrollListener) {
        List<HwOnOverScrollListener> list;
        int iIndexOf;
        if (hwOnOverScrollListener == null || (list = this.f43805h) == null || (iIndexOf = list.indexOf(hwOnOverScrollListener)) < 0) {
            return;
        }
        this.f43805h.remove(iIndexOf);
    }

    @Override // huawei.android.widget.HwSafeInsetsShareable
    public void removeSharedView(View view) {
        HwSafeInsetsShareImpl hwSafeInsetsShareImpl = this.f43831u;
        if (hwSafeInsetsShareImpl != null) {
            hwSafeInsetsShareImpl.removeSharedView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View childAt;
        if (isChainAnimationEnabled() && (childAt = getChildAt(i10)) != null) {
            childAt.setTranslationY(0.0f);
            childAt.setTranslationX(0.0f);
        }
        super.removeViewAt(i10);
    }

    @Override // huawei.android.widget.ScrollCallback
    public void scrollToTop() {
        handleScrollToTop();
    }

    public void setAdaptOverScrollEnabled(boolean z10) {
        this.f43813l = z10;
        if (z10) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).setClipChildren(false);
            } else {
                Log.w(f43731E0, "setAdaptScrollBarEnabled: parent is invalid.");
                this.f43813l = false;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.AbstractC0838h abstractC0838h) {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            bqmxoVar.m55378a(abstractC0838h);
        }
        super.setAdapter(abstractC0838h);
    }

    public void setAutoScrollEnable(boolean z10) {
        this.f43823q = z10;
    }

    public void setChainAnimationEnabled(boolean z10) {
        if (this.f43836w0 == z10) {
            return;
        }
        this.f43836w0 = z10;
        if (z10) {
            return;
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                childAt.setTranslationY(0.0f);
                childAt.setTranslationX(0.0f);
            }
        }
    }

    public void setChainAnimationListener(HwChainAnimationListener hwChainAnimationListener) {
        this.f43834v0 = hwChainAnimationListener;
    }

    public void setChoiceMode(int i10) {
        if (this.f43814l0 == null) {
            this.f43814l0 = new com.huawei.uikit.hwrecyclerview.widget.bqmxo(this);
        }
        this.f43814l0.m55388c(i10);
    }

    public void setDetectoredLongpressEnabled(boolean z10) {
        GestureDetector gestureDetector = this.f43791a;
        if (gestureDetector != null) {
            gestureDetector.setIsLongpressEnabled(z10);
        }
    }

    public void setExtendScrollConsumedEvent(boolean z10) {
        this.f43810j0 = z10;
    }

    public void setExtendScrollEnabled(boolean z10) {
        this.f43798d0 = z10;
    }

    public void setExtendedMultiChoiceEnabled(boolean z10, boolean z11) {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar == null) {
            Log.e(f43731E0, "mHwMultipleChoiceModeHelper: is null");
        } else {
            bqmxoVar.m55380a(z10, z11);
        }
    }

    public void setFirstItemCenteringEnabled(boolean z10) {
        setFirstItemCenteringEnabledInternal(z10);
    }

    public void setItemChecked(int i10, boolean z10) {
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar == null) {
            Log.e(f43731E0, "mHwMultipleChoiceModeHelper: is null");
        } else {
            bqmxoVar.m55376a(i10, z10);
        }
    }

    public void setLastItemCenteringEnabled(boolean z10) {
        this.f43828s0 = z10;
        removeOnScrollListener(this.f43769B0);
        if (this.f43828s0) {
            addOnScrollListener(this.f43769B0);
        } else if (this.f43832u0 != Integer.MIN_VALUE) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.f43832u0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.AbstractC0846p abstractC0846p) {
        if (abstractC0846p instanceof StaggeredGridLayoutManager) {
            this.f43802f0 = AbstractC0875n.m5549b(abstractC0846p, ((StaggeredGridLayoutManager) abstractC0846p).getOrientation());
        } else {
            this.f43802f0 = null;
        }
        super.setLayoutManager(abstractC0846p);
    }

    public void setLinkedViewCallBack(HwLinkedViewCallBack hwLinkedViewCallBack) {
        this.f43776I = hwLinkedViewCallBack;
        m55271e();
    }

    public void setMaxFlingVelocity(int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Class<?> clsM55307z;
        if (this.f43787T == i10 || (clsM55307z = m55307z()) == null) {
            return;
        }
        try {
            Field declaredField = clsM55307z.getDeclaredField("mMaxFlingVelocity");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i10));
            this.f43787T = getMaxFlingVelocity();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.e(f43731E0, "set max fling velocity failed.");
        }
    }

    public void setMinFlingVelocity(int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Class<?> clsM55307z;
        if (this.f43788U == i10 || (clsM55307z = m55307z()) == null) {
            return;
        }
        try {
            Field declaredField = clsM55307z.getDeclaredField("mMinFlingVelocity");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i10));
            this.f43788U = getMinFlingVelocity();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.e(f43731E0, "set min fling velocity failed.");
        }
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        if (this.f43814l0 == null) {
            this.f43814l0 = new com.huawei.uikit.hwrecyclerview.widget.bqmxo(this);
        }
        this.f43814l0.m55379a(multiChoiceModeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        if (this.f43784Q && isAttachedToWindow() && !this.f43783P) {
            return;
        }
        super.setNestedScrollingEnabled(z10);
    }

    public void setOnEditEventListener(HwKeyEventDetector.OnEditEventListener onEditEventListener) {
        m55282h();
        HwKeyEventDetector hwKeyEventDetector = this.f43800e0;
        if (hwKeyEventDetector != null) {
            hwKeyEventDetector.setOnEditEventListener(onEditEventListener);
        }
    }

    @Deprecated
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    }

    @Deprecated
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
    }

    public void setOnSearchEventListener(HwKeyEventDetector.OnSearchEventListener onSearchEventListener) {
        m55282h();
        HwKeyEventDetector hwKeyEventDetector = this.f43800e0;
        if (hwKeyEventDetector != null) {
            hwKeyEventDetector.setOnSearchEventListener(onSearchEventListener);
        }
    }

    public void setOverScrollFactor(float f10) {
        if (Float.compare(f10, 0.0f) <= 0 || Float.compare(f10, 1.0f) > 0) {
            Log.w(f43731E0, "setOverScrollFactor: input is invalid.");
        } else {
            this.f43818n0 = f10;
        }
    }

    @Deprecated
    public void setOverScrollListener(HwOnOverScrollListener hwOnOverScrollListener) {
        this.f43803g = hwOnOverScrollListener;
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        this.f43833v.updateOriginPadding(i10, i11, i12, i13);
    }

    public void setPageTurningScrollEnabled(boolean z10) {
        this.f43840y0 = z10;
        if (z10 && this.f43767A0 == null) {
            this.f43767A0 = new HwPageTurningScrollHelper(this);
        }
    }

    public void setPageTurningThresholdRatioHorizontal(float f10) {
        if (Float.compare(f10, 0.0f) < 0 || Float.compare(f10, 1.0f) > 0) {
            Log.e(f43731E0, "Please ensure that the value of ratio is greater than 0.0f and less than 1.0f.");
            return;
        }
        HwPageTurningScrollHelper hwPageTurningScrollHelper = this.f43767A0;
        if (hwPageTurningScrollHelper != null) {
            hwPageTurningScrollHelper.m55174a(f10);
        }
    }

    public void setPageTurningThresholdRatioVertical(float f10) {
        if (Float.compare(f10, 0.0f) < 0 || Float.compare(f10, 1.0f) > 0) {
            Log.e(f43731E0, "Please ensure that the value of ratio is greater than 0.0f and less than 1.0f.");
            return;
        }
        HwPageTurningScrollHelper hwPageTurningScrollHelper = this.f43767A0;
        if (hwPageTurningScrollHelper != null) {
            hwPageTurningScrollHelper.m55176b(f10);
        }
    }

    public void setScrollStateExtend(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f43812k0 == null) {
            try {
                Method declaredMethod = RecyclerView.class.getDeclaredMethod("setScrollState", Integer.TYPE);
                this.f43812k0 = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException unused) {
                Log.w(f43731E0, "setScrollStateExtend not found method");
            } catch (NoSuchMethodException unused2) {
                Log.w(f43731E0, "setScrollStateExtend no such method");
            }
        }
        Method method = this.f43812k0;
        if (method == null) {
            return;
        }
        try {
            method.invoke(this, Integer.valueOf(i10));
        } catch (IllegalAccessException unused3) {
            Log.w(f43731E0, "setScrollStateExtend illegal access");
        } catch (InvocationTargetException unused4) {
            Log.w(f43731E0, "setScrollStateExtend invocation target");
        }
    }

    public void setScrollTopEnable(boolean z10) {
    }

    public void setScrollTopFactor(float f10) {
        this.f43808i0 = f10;
    }

    public void setScroller(OverScroller overScroller) {
        if (overScroller == null) {
            return;
        }
        this.f43779L = overScroller;
    }

    public void setSensitivity(float f10) {
        HwGenericEventDetector hwGenericEventDetector = this.f43796c0;
        if (hwGenericEventDetector != null) {
            hwGenericEventDetector.setSensitivity(f10);
        }
    }

    public void setSmoothScrollInterpolator(Interpolator interpolator) {
        this.f43842z0 = interpolator;
    }

    public void setSubHeaderDeleteUpdate(Runnable runnable) {
        this.f43801f = runnable;
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        return m55222a(0.0f, 0.0f, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        if (this.f43794b0) {
            return false;
        }
        return m55228a(view, 0.0f, 0.0f, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i10, int i11) {
        OverScroller overScroller;
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager == null) {
            super.smoothScrollBy(i10, i11);
            return;
        }
        Interpolator interpolator = this.f43842z0;
        if (interpolator != null) {
            if (interpolator instanceof C11716c) {
                super.smoothScrollBy(i10, i11, interpolator, (int) ((C11716c) interpolator).m69894b());
                return;
            } else {
                super.smoothScrollBy(i10, i11, interpolator);
                return;
            }
        }
        if ((!layoutManager.canScrollHorizontally() || i10 == 0) && (!layoutManager.canScrollVertically() || i11 == 0)) {
            super.smoothScrollBy(i10, i11);
            return;
        }
        if (isNeedResetOverScrollVelocity() && (overScroller = getOverScroller()) != null) {
            overScroller.fling(0, 0, 0, 0, 0, 0, 0, 0);
            overScroller.abortAnimation();
        }
        super.smoothScrollBy(i10, i11);
    }

    public boolean tryToSpringBack() {
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return false;
        }
        return layoutManager.canScrollVertically() ? m55233a(f43735I0, 0.0f, 0.0f) : m55233a(f43734H0, 0.0f, 0.0f);
    }

    public HwRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8721R.attr.hwRecyclerViewStyle);
    }

    /* renamed from: e */
    public static /* synthetic */ int m55270e(HwRecyclerView hwRecyclerView, int i10) {
        int i11 = hwRecyclerView.f43804g0 + i10;
        hwRecyclerView.f43804g0 = i11;
        return i11;
    }

    /* renamed from: f */
    private boolean m55279f(MotionEvent motionEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.f43840y0) {
            return false;
        }
        setScrollStateExtend(1);
        motionEvent.recycle();
        return true;
    }

    /* renamed from: g */
    private void m55280g() {
        if (this.f43831u == null) {
            this.f43831u = new HwSafeInsetsShareImpl();
        }
    }

    /* renamed from: h */
    private void m55282h() {
        if (this.f43800e0 == null) {
            this.f43800e0 = createKeyEventDetector();
        }
    }

    /* renamed from: i */
    private void m55284i() throws NoSuchFieldException, SecurityException {
        Field flingerField = getFlingerField();
        this.f43775H = flingerField;
        if (flingerField == null) {
            Log.e(f43731E0, "mFlingerField: getFlingerField failed!");
        } else {
            m55179B();
        }
    }

    /* renamed from: j */
    private void m55286j() {
        this.mRollbackRuleDetectorProxy = new HwRollbackRuleDetectorProxy(new bzqlh());
    }

    /* renamed from: l */
    private boolean m55290l() {
        return this.f43777J.m55314b() && this.f43774G.m55330b();
    }

    /* renamed from: m */
    private boolean m55291m() {
        int size = this.f43795c.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f43795c.get(i10).f43867d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    private boolean m55293n() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: o */
    private boolean m55295o() {
        HwLinkedViewCallBack hwLinkedViewCallBack = this.f43776I;
        return hwLinkedViewCallBack != null && hwLinkedViewCallBack.linkedViewHeight() > this.f43781N;
    }

    /* renamed from: k */
    public boolean m55308k() {
        return this.f43772E;
    }

    @Override // android.view.View
    public boolean showContextMenu(float f10, float f11) {
        return m55222a(f10, f11, true);
    }

    public HwRecyclerView(Context context, AttributeSet attributeSet, int i10) throws NoSuchFieldException, SecurityException {
        super(m55193a(context, i10), attributeSet, i10);
        this.f43793b = null;
        this.f43795c = null;
        this.f43797d = -1;
        this.f43799e = -1;
        this.f43801f = null;
        this.f43807i = true;
        this.f43809j = true;
        this.f43811k = true;
        this.f43813l = false;
        this.f43817n = true;
        this.f43833v = new HwWidgetSafeInsets(this);
        this.f43835w = new Rect();
        this.f43837x = new Rect();
        this.f43839y = new HashMap(0);
        this.f43766A = -1;
        this.f43771D = false;
        this.f43772E = false;
        this.f43774G = new boqdu(this, null);
        this.f43777J = new alzfb(this, null);
        this.f43779L = new OverScroller(getContext(), f43765m1);
        this.f43780M = false;
        this.f43781N = Integer.MIN_VALUE;
        this.f43783P = false;
        this.f43784Q = false;
        this.f43785R = new int[2];
        this.f43786S = -1;
        this.f43789V = Integer.MIN_VALUE;
        this.f43790W = 0L;
        this.f43792a0 = null;
        this.f43794b0 = false;
        this.f43798d0 = true;
        this.f43800e0 = null;
        this.f43802f0 = null;
        this.f43804g0 = 0;
        this.f43808i0 = 8.0f;
        this.f43810j0 = false;
        this.f43812k0 = null;
        this.f43818n0 = 0.5f;
        this.f43822p0 = 0.6f;
        this.f43830t0 = Integer.MIN_VALUE;
        this.f43832u0 = Integer.MIN_VALUE;
        this.f43836w0 = false;
        this.f43838x0 = new brnby();
        this.f43769B0 = new bxac();
        m55200a(super.getContext(), attributeSet, i10);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f43787T = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f43788U = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    /* renamed from: e */
    private boolean m55275e(int i10) {
        return this.f43808i0 >= 0.0f && this.f43804g0 > 0 && i10 < 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view, float f10, float f11) {
        return m55228a(view, f10, f11, true);
    }

    /* renamed from: b */
    private void m55238b(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet == null) {
            Log.w(f43731E0, "Attribute set is null");
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8721R.styleable.HwRecyclerView, i10, 0);
        this.f43820o0 = typedArrayObtainStyledAttributes.getInt(C8721R.styleable.HwRecyclerView_hwSensitivityMode, 1);
        int i11 = typedArrayObtainStyledAttributes.getInt(C8721R.styleable.HwRecyclerView_android_choiceMode, 0);
        if (i11 != 0) {
            setChoiceMode(i11);
        }
        typedArrayObtainStyledAttributes.recycle();
        HwGenericEventDetector hwGenericEventDetectorCreateGenericEventDetector = createGenericEventDetector();
        this.f43796c0 = hwGenericEventDetectorCreateGenericEventDetector;
        if (hwGenericEventDetectorCreateGenericEventDetector != null) {
            setSensitivityMode(this.f43820o0);
            this.f43796c0.setSensitivity(this.f43822p0);
            this.f43796c0.setOnScrollListener(this, createOnScrollListener());
            this.f43796c0.setRotaryConverter(createRotaryConverter());
        }
    }

    /* renamed from: d */
    public void m55262d() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z10 = !this.f43780M && this.f43779L.getCurrVelocity() > 0.0f;
        boolean z11 = this.f43782O == 1 && Math.abs(this.f43789V) >= this.f43788U;
        boolean z12 = getTranslationY() == 0.0f;
        boolean z13 = !canScrollVertically(-1) && this.f43789V < 0;
        boolean z14 = !canScrollVertically(1) && this.f43789V > 0;
        boolean z15 = z10 && z11 && z12;
        boolean z16 = z13 || z14;
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager != null && this.f43784Q && layoutManager.canScrollVertically()) {
            if (!m55299r()) {
                this.f43779L.computeScrollOffset();
                this.f43778K = this.f43779L.getCurrY();
            } else if (z15 && z16) {
                this.f43780M = true;
                m55206a(this.f43779L, this.f43789V <= 0 ? -1 : 1);
            }
        }
    }

    /* renamed from: e */
    private void m55273e(MotionEvent motionEvent) {
        if (this.f43771D || !this.f43823q || motionEvent == null) {
            return;
        }
        int y10 = (int) motionEvent.getY(motionEvent.getActionIndex());
        double dApplyDimension = TypedValue.applyDimension(1, 90.0f, getContext().getResources().getDisplayMetrics());
        double d10 = y10;
        if (getHeight() - dApplyDimension < d10) {
            this.f43825r = true;
            this.f43827s = true;
            m55263d(m55189a(false, y10));
        } else if (d10 < dApplyDimension) {
            this.f43825r = true;
            this.f43827s = true;
            m55263d(m55189a(true, y10));
        } else if (this.f43825r) {
            m55302u();
        }
    }

    /* renamed from: c */
    private void m55253c() {
        ValueAnimator valueAnimator = this.f43841z;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f43841z.cancel();
        }
        boqdu boqduVar = this.f43774G;
        if (boqduVar != null) {
            boqduVar.m55327a();
        }
    }

    /* renamed from: f */
    private void m55276f() {
        List<anbq> list = this.f43795c;
        if (list != null) {
            list.clear();
        }
        com.huawei.uikit.hwrecyclerview.widget.bqmxo bqmxoVar = this.f43814l0;
        if (bqmxoVar != null) {
            bqmxoVar.m55375a();
        }
        this.f43797d = -1;
        this.f43799e = -1;
    }

    /* renamed from: c */
    private void m55257c(MotionEvent motionEvent) {
        onPointerUp(motionEvent);
        m55303v();
    }

    /* renamed from: a */
    private static Context m55193a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8721R.style.Theme_Emui_HwRecyclerView);
    }

    /* renamed from: c */
    private void m55255c(int i10, MotionEvent motionEvent) {
        this.f43766A = motionEvent.getPointerId(i10);
        this.f43768B = (int) motionEvent.getRawX();
        this.f43770C = (int) motionEvent.getRawY();
        int i11 = getTranslationY() > 0.0f ? 1 : -1;
        if ((getTranslationY() > 0.0f && checkOverScrollEnabled(i11)) || getTranslationX() > 0.0f) {
            this.f43772E = true;
            this.f43771D = true;
        } else if ((getTranslationY() < 0.0f && checkOverScrollEnabled(i11)) || getTranslationX() < 0.0f) {
            this.f43772E = true;
            this.f43771D = true;
        } else {
            this.f43772E = false;
            this.f43771D = false;
        }
        if (this.f43819o == null) {
            this.f43819o = VelocityTracker.obtain();
        }
        m55253c();
        this.f43819o.clear();
        this.f43819o.addMovement(motionEvent);
    }

    /* renamed from: f */
    public void m55277f(int i10) {
        if (isLayoutVertical()) {
            this.f43834v0.onScrolled(this, 0, i10);
        } else {
            this.f43834v0.onScrolled(this, i10, 0);
        }
    }

    /* renamed from: a */
    private void m55200a(Context context, AttributeSet attributeSet, int i10) throws NoSuchFieldException, SecurityException {
        m55238b(context, attributeSet, i10);
        if (isInEditMode() && super.getLayoutManager() == null) {
            super.setLayoutManager(new LinearLayoutManager(context, 1, false));
        }
        this.f43815m = true;
        this.f43806h0 = context.getResources().getDisplayMetrics().densityDpi;
        this.f43773F = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f43833v.parseHwDisplayCutout(context, attributeSet);
        m55286j();
        m55284i();
        setValueFromPlume(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8721R.styleable.HwRecyclerView, i10, C8721R.style.Widget_Emui_HwRecyclerView);
        this.f43840y0 = typedArrayObtainStyledAttributes.getBoolean(C8721R.styleable.HwRecyclerView_hwPageTurningScrollEnabled, false);
        float f10 = typedArrayObtainStyledAttributes.getFloat(C8721R.styleable.HwRecyclerView_hwPageTurningThresholdRatioVertical, 0.125f);
        float f11 = typedArrayObtainStyledAttributes.getFloat(C8721R.styleable.HwRecyclerView_hwPageTurningThresholdRatioHorizontal, 0.125f);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f43840y0) {
            HwPageTurningScrollHelper hwPageTurningScrollHelper = new HwPageTurningScrollHelper(this);
            this.f43767A0 = hwPageTurningScrollHelper;
            hwPageTurningScrollHelper.m55176b(f10);
            this.f43767A0.m55174a(f11);
        }
    }

    /* renamed from: b */
    private boolean m55245b(int i10) {
        afdzw afdzwVar;
        if (this.f43825r && i10 == 1) {
            this.f43825r = false;
            m55302u();
        }
        if ((!this.f43825r || i10 == 1) && (afdzwVar = this.f43829t) != null) {
            afdzwVar.m55309a();
        }
        return false;
    }

    /* renamed from: d */
    private void m55266d(MotionEvent motionEvent) {
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean zCanScrollVertically = layoutManager.canScrollVertically();
        if (Math.abs(rawY - this.f43770C) > this.f43773F && zCanScrollVertically) {
            this.f43772E = true;
        }
        if (Math.abs(rawX - this.f43768B) <= this.f43773F || !zCanScrollHorizontally) {
            return;
        }
        this.f43772E = true;
    }

    /* renamed from: e */
    public void m55256c(ValueAnimator valueAnimator) {
        int i10;
        if (valueAnimator == null) {
            Log.e(f43731E0, "getHeightListener: onAnimationUpdate: animation is null");
            return;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int size = this.f43795c.size();
        int iM55317a = 0;
        for (int i11 = 0; i11 < size; i11++) {
            anbq anbqVar = this.f43795c.get(i11);
            if (anbqVar.f43867d) {
                int i12 = anbqVar.f43871h;
                if (i12 > 0 && (i10 = anbqVar.f43869f) > 0) {
                    int i13 = (int) (i12 * fFloatValue);
                    int i14 = anbqVar.f43870g;
                    if (i13 > i14) {
                        if (anbqVar.f43866c == null) {
                            Log.e(f43731E0, "getHeightListener: view is null.");
                        } else {
                            int i15 = (i14 + i10) - i13;
                            if (i15 > 0) {
                                iM55317a = anbqVar.m55317a(i15, iM55317a);
                            } else if (anbqVar.f43873j > 0) {
                                iM55317a = anbqVar.m55317a(0, iM55317a);
                            }
                        }
                    }
                } else {
                    Log.e(f43731E0, "getHeightListener: mHeightTotal or mHeightOriginal is invalid.");
                }
            }
        }
        Runnable runnable = this.f43801f;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: b */
    private void m55239b(MotionEvent motionEvent, int i10, MotionEvent motionEvent2) {
        this.f43786S = motionEvent.getPointerId(0);
        m55253c();
        m55255c(i10, motionEvent2);
        if (!motionEvent.isFromSource(8194) || (motionEvent.getButtonState() & 2) == 0) {
            return;
        }
        showContextMenu(motionEvent.getX(), motionEvent.getY());
    }

    /* renamed from: d */
    private void m55264d(int i10, MotionEvent motionEvent) {
        afdzw afdzwVar;
        VelocityTracker velocityTracker = this.f43819o;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
            this.f43819o.computeCurrentVelocity(1000, this.f43787T);
        }
        if (i10 < 0) {
            return;
        }
        if (!this.f43825r && (afdzwVar = this.f43829t) != null) {
            afdzwVar.m55309a();
        }
        if (getLayoutManager() == null) {
            return;
        }
        tryToSpringBack();
        this.f43772E = false;
    }

    /* renamed from: b */
    private boolean m55246b(int i10, MotionEvent motionEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iM55185a = m55185a(i10, this.f43770C);
        if (this.f43772E && this.f43807i) {
            if (m55247b(motionEvent)) {
                return true;
            }
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (computeVerticalScrollRange() != 0 && canVerticalOverScroll(iM55185a, i10)) {
                float translationY = getTranslationY();
                float overScrollPosition = getOverScrollPosition(iM55185a, true);
                int i11 = (int) overScrollPosition;
                if (isBackToEdge(translationY, i11)) {
                    setIntegerTranslationY(0.0f);
                    if (this.f43834v0 != null) {
                        m55277f((int) translationY);
                    }
                    scrollBy(0, -i11);
                    onOverScrollEnd();
                    setScrollStateExtend(1);
                    invalidate();
                    this.f43785R[1] = (int) (r8[1] - translationY);
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(0);
                    return super.onTouchEvent(motionEventObtain);
                }
                this.f43770C = i10;
                float fAbs = Math.abs(getTranslationY());
                setIntegerTranslationY(overScrollPosition);
                HwChainAnimationListener hwChainAnimationListener = this.f43834v0;
                if (hwChainAnimationListener != null) {
                    hwChainAnimationListener.onOverScroll(iM55185a, (int) fAbs);
                }
                this.f43785R[1] = (int) (r8[1] - (translationY - overScrollPosition));
                onOverScrollRunning(overScrollPosition);
                invalidate();
                return true;
            }
            this.f43770C = i10;
        }
        return false;
    }

    /* renamed from: c */
    private void m55254c(int i10) {
        if (i10 < 0 && !canScrollVertically(1) && this.f43811k) {
            onOverScrollStart();
        } else if (i10 > 0 && !canScrollVertically(-1) && this.f43809j) {
            onOverScrollStart();
        } else {
            Log.d(f43731E0, "do nothing.");
        }
    }

    /* renamed from: a */
    public void m55207a(OverScroller overScroller, int i10, int i11, long j10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f43807i && this.f43817n) {
            if (i11 >= 0 || this.f43809j) {
                if (i11 <= 0 || this.f43811k) {
                    if (i10 >= 0 || this.f43809j) {
                        if (i10 <= 0 || this.f43811k) {
                            float currVelocity = overScroller.getCurrVelocity();
                            if (Float.isNaN(currVelocity)) {
                                return;
                            }
                            RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
                            if (layoutManager == null) {
                                Log.e(f43731E0, "startOverFling: call getLayoutManager failed");
                                return;
                            }
                            if (layoutManager.canScrollHorizontally()) {
                                if (i10 < 0) {
                                    currVelocity = -currVelocity;
                                }
                                this.f43774G.m55331a(0, -currVelocity, 0, 0, 0L);
                                overScroller.abortAnimation();
                            }
                            if (layoutManager.canScrollVertically()) {
                                if (i11 < 0) {
                                    currVelocity = -currVelocity;
                                }
                                this.f43774G.m55331a(1, -currVelocity, 0, 0, j10);
                                overScroller.abortAnimation();
                            }
                        }
                    }
                }
            }
        }
    }

    @TargetApi(11)
    /* renamed from: e */
    private void m55274e(RecyclerView.AbstractC0838h abstractC0838h) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.interpolator.fast_out_slow_in));
        valueAnimatorOfFloat2.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.interpolator.fast_out_slow_in));
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.addUpdateListener(getAlphaListener());
        valueAnimatorOfFloat2.setDuration(300L);
        valueAnimatorOfFloat2.addUpdateListener(getHeightListener());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.addListener(m55251c(abstractC0838h));
        animatorSet.start();
    }

    /* renamed from: c */
    private Animator.AnimatorListener m55251c(RecyclerView.AbstractC0838h abstractC0838h) {
        return new aijfr(abstractC0838h);
    }

    /* renamed from: d */
    private void m55263d(int i10) {
        if (this.f43829t == null) {
            this.f43829t = new afdzw(this, null);
        }
        this.f43829t.m55310a(i10);
    }

    /* renamed from: d */
    public void m55267d(RecyclerView.AbstractC0838h abstractC0838h) {
        List<anbq> list;
        if (abstractC0838h == null || (list = this.f43795c) == null || list.size() == 0) {
            return;
        }
        View firstVisibleView = getFirstVisibleView();
        int size = this.f43795c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f43795c.get(i10).m55320a();
        }
        m55186a(abstractC0838h, 0, size - 1, false);
        abstractC0838h.m5213j();
        if (firstVisibleView == null) {
            m55276f();
            DeleteAnimatorCallback deleteAnimatorCallback = this.f43793b;
            if (deleteAnimatorCallback != null) {
                deleteAnimatorCallback.notifyResult(true);
                return;
            }
            return;
        }
        int positionByView = this.f43793b.getPositionByView(firstVisibleView);
        if (positionByView >= 0) {
            scrollToPosition(positionByView);
            scrollBy(0, -(firstVisibleView.getTop() - getPaddingTop()));
        }
        m55276f();
        DeleteAnimatorCallback deleteAnimatorCallback2 = this.f43793b;
        if (deleteAnimatorCallback2 != null) {
            deleteAnimatorCallback2.notifyResult(true);
        }
    }

    /* renamed from: a */
    private void m55206a(OverScroller overScroller, int i10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!m55290l()) {
            m55305x();
        }
        OverScroller overScroller2 = getOverScroller();
        if (overScroller2 != null) {
            overScroller2.abortAnimation();
        }
        startNestedScroll(2, 0);
        this.f43777J.m55316a(overScroller, i10);
    }

    /* renamed from: e */
    private void m55271e() {
        HwLinkedViewCallBack hwLinkedViewCallBack = this.f43776I;
        if (hwLinkedViewCallBack == null) {
            this.f43784Q = false;
        } else if (hwLinkedViewCallBack.linkedViewState() != -1 && getOverScrollMode() != 2 && isNestedScrollingEnabled()) {
            this.f43784Q = true;
        } else {
            this.f43784Q = false;
        }
    }

    /* renamed from: a */
    private void m55205a(View view, int i10) {
        Rect rect;
        if (view == null) {
            return;
        }
        int layoutDirection = getLayoutDirection();
        if (view.getLayoutDirection() != layoutDirection) {
            view.setLayoutDirection(layoutDirection);
        }
        Rect rect2 = this.f43839y.get(Integer.valueOf(i10));
        if (rect2 == null) {
            rect2 = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            this.f43839y.put(Integer.valueOf(i10), rect2);
            rect = rect2;
        } else {
            rect = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        Rect displaySafeInsets = this.f43833v.getDisplaySafeInsets(this, rect2);
        if (displaySafeInsets == null) {
            displaySafeInsets = new Rect(rect2);
            Log.w(f43731E0, "HwWidgetSafeInsets.getDisplaySafeInsets() is null!");
        }
        Rect rect3 = new Rect(displaySafeInsets.left, view.getPaddingTop(), displaySafeInsets.right, view.getPaddingBottom());
        if (rect.equals(rect3)) {
            return;
        }
        this.f43833v.applyDisplaySafeInsets(view, rect3, false);
    }

    /* renamed from: d */
    public void m55265d(ValueAnimator valueAnimator) {
        if (this.f43795c == null) {
            Log.e(f43731E0, "startDisappearAnimator: onAnimationUpdate: mVisibleItemInfos is null");
            return;
        }
        if (valueAnimator == null) {
            Log.e(f43731E0, "addUpdateListener: onAnimationUpdate: animation is null");
            return;
        }
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int size = this.f43795c.size();
        for (int i10 = 0; i10 < size; i10++) {
            anbq anbqVar = this.f43795c.get(i10);
            if (anbqVar.f43877n) {
                com.huawei.uikit.hwrecyclerview.widget.bzrwd bzrwdVar = anbqVar.f43875l;
                if (bzrwdVar != null) {
                    bzrwdVar.setAlpha(iIntValue);
                } else {
                    Log.w(f43731E0, "startDisappearAnimator: onAnimationUpdate: mAnimDrawable is null.");
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m55247b(MotionEvent motionEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (canScrollVertically(1) && getTranslationY() < 0.0f && this.f43771D) {
            m55202a(motionEvent);
            return true;
        }
        if (!(getLayoutManager() instanceof HwFloatingBubblesLayoutManager) || !canScrollVertically(-1) || getTranslationY() <= 0.0f || !this.f43771D) {
            return false;
        }
        m55202a(motionEvent);
        return true;
    }

    /* renamed from: b */
    private void m55236b(int i10, int i11) {
        int size = this.f43795c.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = i10; i14 <= i11; i14++) {
            if (i14 >= size) {
                Log.e(f43731E0, "updateSavedDeleteItemInfo: position invalid.");
                return;
            }
            anbq anbqVar = this.f43795c.get(i14);
            if (!anbqVar.f43867d) {
                Log.e(f43731E0, "updateSavedDeleteItemInfo: item will not been delete");
                return;
            }
            View view = anbqVar.f43866c;
            if (view == null) {
                Log.e(f43731E0, "updateSavedDeleteItemInfo: mItemView is null.");
                return;
            }
            int height = view.getHeight();
            anbqVar.f43869f = height;
            anbqVar.f43873j = height;
            anbqVar.f43870g = i13;
            i13 += height;
            i12 += height;
        }
        while (i10 <= i11) {
            anbq anbqVar2 = this.f43795c.get(i10);
            if (anbqVar2.f43869f == 0) {
                Log.w(f43731E0, "updateSavedDeleteItemInfo: mHeightOriginal is zero.");
            } else {
                anbqVar2.f43871h = i12;
            }
            i10++;
        }
    }

    /* renamed from: a */
    private void m55203a(MotionEvent motionEvent, int i10, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    if (getLayoutManager() == null) {
                        return;
                    }
                    m55266d(motionEvent);
                    return;
                } else if (i10 != 3) {
                    if (i10 == 5) {
                        this.f43786S = motionEvent.getPointerId(i11);
                        return;
                    } else {
                        if (i10 != 6) {
                            return;
                        }
                        onPointerUp(motionEvent);
                        return;
                    }
                }
            }
            this.f43766A = -1;
            if (this.f43772E) {
                return;
            }
            tryToSpringBack();
            return;
        }
        this.f43786S = motionEvent.getPointerId(0);
        m55255c(i11, motionEvent);
    }

    /* renamed from: b */
    public /* synthetic */ void m55237b(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            Log.e(f43731E0, "getAlphaListener: onAnimationUpdate: animation is null");
            return;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int size = this.f43795c.size();
        for (int i10 = 0; i10 < size; i10++) {
            anbq anbqVar = this.f43795c.get(i10);
            if (anbqVar.f43867d) {
                View view = anbqVar.f43866c;
                if (view != null) {
                    view.setAlpha(fFloatValue);
                }
                anbqVar.m55321a(fFloatValue);
            }
        }
    }

    /* renamed from: a */
    private boolean m55225a(MotionEvent motionEvent, int i10) {
        if (m55245b(i10)) {
            return true;
        }
        if (motionEvent.getActionMasked() != 2) {
            return false;
        }
        m55273e(motionEvent);
        return false;
    }

    /* renamed from: a */
    private boolean m55226a(MotionEvent motionEvent, int i10, int i11, MotionEvent motionEvent2) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 5) {
                            m55204a(motionEvent, i11, motionEvent2);
                        } else if (i10 == 6) {
                            m55257c(motionEvent2);
                        }
                    }
                } else {
                    if (m55279f(motionEvent2)) {
                        return false;
                    }
                    if (m55224a(i11, motionEvent, motionEvent2)) {
                        motionEvent2.recycle();
                        return true;
                    }
                }
            } else if (m55227a(motionEvent, motionEvent2)) {
                return true;
            }
            m55264d(i11, motionEvent2);
        } else {
            m55239b(motionEvent, i11, motionEvent2);
            if (this.f43840y0) {
                this.f43767A0.m55175a(motionEvent);
            }
        }
        motionEvent2.recycle();
        GestureDetector gestureDetector = this.f43791a;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: b */
    private void m55240b(RecyclerView.AbstractC0838h abstractC0838h) {
        for (int size = this.f43795c.size() - 1; size >= 0; size--) {
            anbq anbqVar = this.f43795c.get(size);
            if (!anbqVar.f43867d) {
                anbqVar.m55325a((Object) null, true);
            } else {
                this.f43793b.remove(anbqVar.f43864a);
                abstractC0838h.m5220q(anbqVar.f43865b);
            }
        }
    }

    /* renamed from: b */
    private boolean m55248b(RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0846p abstractC0846p, List<Object> list, boolean z10) {
        int i10;
        int childCount = getChildCount();
        if (childCount == 0) {
            Log.w(f43731E0, "transmitItemToPosition: childCount is zero");
            return false;
        }
        int position = abstractC0846p.getPosition(getChildAt(0));
        this.f43797d = position;
        this.f43799e = (position + childCount) - 1;
        this.f43795c = new ArrayList(childCount);
        for (int i11 = 0; i11 < childCount; i11++) {
            this.f43795c.add(new anbq(abstractC0838h, abstractC0846p, this.f43797d + i11));
        }
        ArrayMap arrayMap = new ArrayMap(10);
        ArrayMap arrayMap2 = new ArrayMap(10);
        int iMo721e = abstractC0838h.mo721e();
        for (Object obj : list) {
            int itemPosition = this.f43793b.getItemPosition(obj);
            if (itemPosition < 0 || itemPosition >= iMo721e) {
                Log.e(f43731E0, "transmitItemToPosition: position is invalid. position " + itemPosition + ", item " + obj);
                return false;
            }
            int i12 = this.f43799e;
            if (itemPosition <= i12 && itemPosition >= (i10 = this.f43797d)) {
                anbq anbqVar = this.f43795c.get(itemPosition - i10);
                if (anbqVar.f43867d) {
                    Log.w(f43731E0, "transmitItemToPosition: repeat delete item, position " + itemPosition);
                } else {
                    anbqVar.m55325a(obj, z10);
                }
            } else {
                m55219a(itemPosition > i12 ? arrayMap2 : arrayMap, itemPosition, obj);
            }
        }
        m55220a(arrayMap2, abstractC0838h, iMo721e - 1, this.f43799e + 1);
        if (!z10) {
            m55240b(abstractC0838h);
        }
        m55220a(arrayMap, abstractC0838h, this.f43797d - 1, 0);
        return true;
    }

    /* renamed from: a */
    private boolean m55227a(MotionEvent motionEvent, MotionEvent motionEvent2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.f43840y0) {
            return false;
        }
        this.f43767A0.m55177b(motionEvent);
        setScrollStateExtend(0);
        motionEvent2.recycle();
        return true;
    }

    /* renamed from: a */
    private void m55197a(int i10) {
        if (i10 == 0) {
            int[] iArr = this.f43785R;
            iArr[0] = 0;
            iArr[1] = 0;
        }
    }

    /* renamed from: a */
    private void m55204a(MotionEvent motionEvent, int i10, MotionEvent motionEvent2) {
        this.f43786S = motionEvent.getPointerId(i10);
        m55253c();
        m55255c(i10, motionEvent2);
    }

    /* renamed from: a */
    private boolean m55224a(int i10, MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent.getButtonState() == 2 || i10 < 0 || getLayoutManager() == null) {
            return false;
        }
        VelocityTracker velocityTracker = this.f43819o;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent2);
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (this.f43770C == 0 && this.f43768B == 0) {
            this.f43770C = rawY;
            this.f43768B = rawX;
        }
        boolean zCanScrollHorizontally = getLayoutManager().canScrollHorizontally();
        if (getLayoutManager().canScrollVertically()) {
            return m55246b(rawY, motionEvent);
        }
        if (zCanScrollHorizontally) {
            return m55223a(rawX, motionEvent);
        }
        return false;
    }

    /* renamed from: b */
    private void m55241b(RecyclerView.AbstractC0846p abstractC0846p, RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0843m abstractC0843m, List<Object> list) {
        boolean zM55248b;
        if (!(abstractC0843m instanceof HwDefaultItemAnimator)) {
            Log.w(f43731E0, "deleteForStaggeredGridLayout: itemAnimator is not instance of HwDefaultItemAnimator.");
            m55276f();
            this.f43793b.notifyResult(false);
            return;
        }
        HwDefaultItemAnimator hwDefaultItemAnimator = (HwDefaultItemAnimator) abstractC0843m;
        hwDefaultItemAnimator.m54951a(3);
        if (!list.isEmpty() && (list.get(0) instanceof HwPositionPair)) {
            zM55248b = m55230a(abstractC0838h, abstractC0846p, list, false);
        } else {
            zM55248b = m55248b(abstractC0838h, abstractC0846p, list, false);
        }
        if (!zM55248b) {
            Log.w(f43731E0, "deleteForStaggeredGridLayout: fail to get items position.");
            m55276f();
            this.f43793b.notifyResult(false);
        } else {
            if (!m55291m()) {
                Log.w(f43731E0, "deleteForStaggeredGridLayout: no visible item to delete");
                m55276f();
                this.f43793b.notifyResult(true);
                return;
            }
            m55231a(hwDefaultItemAnimator);
        }
    }

    /* renamed from: a */
    private boolean m55223a(int i10, MotionEvent motionEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f43772E && this.f43807i) {
            if (m55221a() && this.f43771D) {
                int i11 = -((int) getTranslationX());
                setTranslationX(0.0f);
                scrollBy(i11, 0);
                onOverScrollEnd();
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getEventTime(), motionEvent.getEventTime(), 0, motionEvent.getX() - i11, motionEvent.getY(), 0);
                motionEventObtain.setAction(0);
                super.onTouchEvent(motionEventObtain);
                return true;
            }
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            int iM55185a = m55185a(i10, this.f43768B);
            if (computeHorizontalScrollRange() != 0 && canHorizontalOverScroll(iM55185a)) {
                float translationX = getTranslationX();
                float overScrollPosition = getOverScrollPosition(iM55185a, false);
                int i12 = (int) overScrollPosition;
                if (isBackToEdge(translationX, i12)) {
                    setIntegerTranslationX(0.0f);
                    if (this.f43834v0 != null) {
                        m55277f((int) translationX);
                    }
                    scrollBy(-i12, 0);
                    onOverScrollEnd();
                    setScrollStateExtend(1);
                    invalidate();
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                    motionEventObtain2.setAction(0);
                    return super.onTouchEvent(motionEventObtain2);
                }
                this.f43768B = i10;
                float fAbs = Math.abs(getTranslationX());
                setIntegerTranslationX(overScrollPosition);
                HwChainAnimationListener hwChainAnimationListener = this.f43834v0;
                if (hwChainAnimationListener != null) {
                    hwChainAnimationListener.onOverScroll(iM55185a, (int) fAbs);
                }
                onOverScrollRunning(overScrollPosition);
                invalidate();
                return true;
            }
            this.f43768B = i10;
        }
        return false;
    }

    /* renamed from: b */
    private void m55242b(HwDefaultItemAnimator hwDefaultItemAnimator, List<anbq> list) {
        hwDefaultItemAnimator.m54952a(new bqmxo(hwDefaultItemAnimator, list));
    }

    /* renamed from: b */
    private boolean m55244b() {
        int iMo5561n = this.f43802f0.mo5561n();
        int childCount = getChildCount();
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                if (this.f43802f0.mo5554g(childAt) < iMo5561n) {
                    return true;
                }
                int childAdapterPosition = getChildAdapterPosition(childAt);
                if (i10 > childAdapterPosition) {
                    i10 = childAdapterPosition;
                }
            }
        }
        return i10 > 0;
    }

    /* renamed from: a */
    private boolean m55221a() {
        if (m55293n()) {
            if (canScrollHorizontally(-1) && getTranslationX() > 0.0f) {
                return true;
            }
        } else if (canScrollHorizontally(1) && getTranslationX() < 0.0f) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m55202a(MotionEvent motionEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i10 = -((int) getTranslationY());
        setTranslationY(0.0f);
        scrollBy(0, i10);
        onOverScrollEnd();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getEventTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY() - i10, 0);
        motionEventObtain.setAction(0);
        super.onTouchEvent(motionEventObtain);
    }

    /* renamed from: a */
    private int m55185a(int i10, int i11) {
        int i12 = i10 - i11;
        if (this.f43772E) {
            return i12;
        }
        int iAbs = Math.abs(i12);
        int i13 = this.f43773F;
        if (iAbs <= i13) {
            return i12;
        }
        this.f43772E = true;
        return i12 > 0 ? i12 - i13 : i12 + i13;
    }

    /* renamed from: a */
    public void m55198a(int i10, float f10) {
        if (i10 == 1) {
            setIntegerTranslationY(f10);
        } else {
            setIntegerTranslationX(f10);
        }
    }

    /* renamed from: a */
    private int m55189a(boolean z10, int i10) {
        int height = getHeight();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 90.0f, getContext().getResources().getDisplayMetrics());
        double dApplyDimension = TypedValue.applyDimension(1, 4.0f, getContext().getResources().getDisplayMetrics());
        double dApplyDimension2 = TypedValue.applyDimension(1, 0.0f, getContext().getResources().getDisplayMetrics());
        if (z10) {
            double d10 = i10 + dApplyDimension2;
            double dDoubleValue = BigDecimal.valueOf(height).divide(BigDecimal.valueOf((dApplyDimension / (((d10 > 0.0d ? d10 / iApplyDimension : 0.0d) * 38.0d) + 10.0d)) * 300.0d), 6, 4).doubleValue();
            if (dDoubleValue != 1.0d) {
                return -((int) (height / (dDoubleValue - 1.0d)));
            }
            return 0;
        }
        double dDoubleValue2 = BigDecimal.valueOf(height).divide(BigDecimal.valueOf((dApplyDimension / (((((double) (getHeight() - i10)) + dApplyDimension2 > 0.0d ? ((getHeight() - i10) + dApplyDimension2) / iApplyDimension : 0.0d) * 38.0d) + 10.0d)) * 300.0d), 6, 4).doubleValue();
        if (dDoubleValue2 != 1.0d) {
            return (int) (height / (dDoubleValue2 - 1.0d));
        }
        return 0;
    }

    @TargetApi(5)
    /* renamed from: a */
    private int m55186a(RecyclerView.AbstractC0838h abstractC0838h, int i10, int i11, boolean z10) {
        int size = this.f43795c.size();
        if (i11 >= size) {
            i11 = size - 1;
        }
        int i12 = 0;
        if (this.f43793b == null || abstractC0838h == null) {
            Log.e(f43731E0, "deleteItemsProc: mDeleteInterface is null.");
            return 0;
        }
        if (i10 < 0) {
            Log.e(f43731E0, "deleteItemsProc: firstIdx is less than 0.");
            return 0;
        }
        while (i11 >= i10) {
            anbq anbqVar = this.f43795c.get(i11);
            if (anbqVar.f43867d) {
                Object obj = anbqVar.f43864a;
                if (obj == null) {
                    Log.e(f43731E0, "deleteItemsProc: saved item is null.");
                } else {
                    int iIntValue = obj instanceof HwPositionPair ? ((Integer) ((Pair) ((HwPositionPair) obj)).first).intValue() : this.f43793b.getItemPosition(obj);
                    this.f43793b.remove(anbqVar.f43864a);
                    i12++;
                    anbqVar.f43864a = null;
                    if (z10) {
                        abstractC0838h.m5220q(iIntValue);
                    }
                }
            }
            i11--;
        }
        return i12;
    }

    /* renamed from: a */
    private void m55208a(RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0846p abstractC0846p, List<Object> list) {
        boolean zM55248b;
        List<anbq> list2 = this.f43795c;
        if (list2 != null && list2.size() != 0) {
            Log.e(f43731E0, "deleteForLinearLayout:last animator has not end.");
            return;
        }
        if (!list.isEmpty() && (list.get(0) instanceof HwPositionPair)) {
            zM55248b = m55230a(abstractC0838h, abstractC0846p, list, true);
        } else {
            zM55248b = m55248b(abstractC0838h, abstractC0846p, list, true);
        }
        if (!zM55248b) {
            Log.w(f43731E0, "deleteForLinearLayout: fail to get items position.");
            m55276f();
            this.f43793b.notifyResult(false);
        } else if (!m55291m()) {
            m55276f();
            this.f43793b.notifyResult(true);
        } else {
            m55304w();
            m55274e(abstractC0838h);
        }
    }

    /* renamed from: a */
    private void m55209a(RecyclerView.AbstractC0846p abstractC0846p, RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0843m abstractC0843m, List<Object> list) {
        if (!(abstractC0843m instanceof HwDefaultItemAnimator)) {
            Log.w(f43731E0, "deleteForGridLayout: itemAnimator is not instance of HwDefaultItemAnimator.");
            this.f43793b.notifyResult(false);
            return;
        }
        ((HwDefaultItemAnimator) abstractC0843m).m54951a(2);
        if (!list.isEmpty() && (list.get(0) instanceof HwPositionPair)) {
            m55230a(abstractC0838h, abstractC0846p, list, false);
        } else {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = list.get(i10);
                int itemPosition = this.f43793b.getItemPosition(obj);
                this.f43793b.remove(obj);
                abstractC0838h.m5220q(itemPosition);
            }
        }
        m55276f();
        this.f43793b.notifyResult(true);
    }

    /* renamed from: a */
    private void m55219a(Map<Integer, Object> map, int i10, Object obj) {
        if (map.containsKey(Integer.valueOf(i10))) {
            Log.e(f43731E0, "saveItemsInfo: repeat to delete position " + i10);
            return;
        }
        map.put(Integer.valueOf(i10), obj);
    }

    /* renamed from: a */
    private void m55220a(Map<Integer, Object> map, RecyclerView.AbstractC0838h abstractC0838h, int i10, int i11) {
        if (map == null || map.size() == 0) {
            return;
        }
        int i12 = -1;
        int i13 = -1;
        while (i10 >= i11) {
            Object obj = map.get(Integer.valueOf(i10));
            if (obj != null) {
                this.f43793b.remove(obj);
                if (i12 == -1) {
                    i12 = i10;
                    i13 = i12;
                } else if (i13 == i10 + 1) {
                    i13 = i10;
                } else {
                    abstractC0838h.m5219p(i13, (i12 - i13) + 1);
                    i12 = i10;
                    i13 = i12;
                }
            }
            i10--;
        }
        if (i12 != -1) {
            abstractC0838h.m5219p(i13, (i12 - i13) + 1);
        }
    }

    /* renamed from: a */
    private boolean m55230a(RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0846p abstractC0846p, List<Object> list, boolean z10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            Log.w(f43731E0, "removeItemInPositionRange: childCount is zero");
            return false;
        }
        int position = abstractC0846p.getPosition(getChildAt(0));
        this.f43797d = position;
        this.f43799e = (position + childCount) - 1;
        this.f43795c = new ArrayList(childCount);
        for (int i10 = 0; i10 < childCount; i10++) {
            this.f43795c.add(new anbq(abstractC0838h, abstractC0846p, this.f43797d + i10));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof HwPositionPair) {
                HwPositionPair hwPositionPair = (HwPositionPair) obj;
                HwPositionPair hwPositionPairM55196a = m55196a(hwPositionPair, new HwPositionPair(-1, Integer.valueOf(this.f43797d - 1)));
                if (hwPositionPairM55196a != null) {
                    arrayList.add(hwPositionPairM55196a);
                }
                HwPositionPair hwPositionPairM55196a2 = m55196a(hwPositionPair, new HwPositionPair(Integer.valueOf(this.f43799e + 1), Integer.MAX_VALUE));
                if (hwPositionPairM55196a2 != null) {
                    arrayList2.add(hwPositionPairM55196a2);
                }
                HwPositionPair hwPositionPairM55196a3 = m55196a(hwPositionPair, new HwPositionPair(Integer.valueOf(this.f43797d), Integer.valueOf(this.f43799e)));
                if (hwPositionPairM55196a3 != null) {
                    arrayList3.add(hwPositionPairM55196a3);
                }
            }
        }
        m55217a(arrayList3, m55188a(arrayList), z10);
        m55218a(arrayList2, abstractC0838h);
        m55218a(arrayList, abstractC0838h);
        if (!z10) {
            m55240b(abstractC0838h);
        }
        return true;
    }

    /* renamed from: a */
    private void m55217a(List<HwPositionPair> list, int i10, boolean z10) {
        for (HwPositionPair hwPositionPair : list) {
            for (int iIntValue = ((Integer) ((Pair) hwPositionPair).first).intValue(); iIntValue <= ((Integer) ((Pair) hwPositionPair).second).intValue(); iIntValue++) {
                anbq anbqVar = this.f43795c.get(iIntValue - this.f43797d);
                if (anbqVar != null) {
                    int i11 = iIntValue - i10;
                    anbqVar.m55325a(new HwPositionPair(Integer.valueOf(i11), Integer.valueOf(i11)), z10);
                    anbqVar.f43865b = i11;
                }
            }
        }
    }

    /* renamed from: a */
    private int m55188a(List<HwPositionPair> list) {
        int iIntValue = 0;
        for (HwPositionPair hwPositionPair : list) {
            iIntValue += (((Integer) ((Pair) hwPositionPair).second).intValue() - ((Integer) ((Pair) hwPositionPair).first).intValue()) + 1;
        }
        return iIntValue;
    }

    /* renamed from: a */
    private void m55218a(List<HwPositionPair> list, RecyclerView.AbstractC0838h abstractC0838h) {
        Collections.sort(list, new bwuqo());
        for (HwPositionPair hwPositionPair : list) {
            this.f43793b.remove(hwPositionPair);
            abstractC0838h.m5219p(((Integer) ((Pair) hwPositionPair).first).intValue(), (((Integer) ((Pair) hwPositionPair).second).intValue() - ((Integer) ((Pair) hwPositionPair).first).intValue()) + 1);
        }
    }

    /* renamed from: a */
    private HwPositionPair m55196a(HwPositionPair hwPositionPair, HwPositionPair hwPositionPair2) {
        Integer num = (Integer) (((Integer) ((Pair) hwPositionPair).first).intValue() < ((Integer) ((Pair) hwPositionPair2).first).intValue() ? ((Pair) hwPositionPair2).first : ((Pair) hwPositionPair).first);
        int iIntValue = num.intValue();
        Integer num2 = (Integer) (((Integer) ((Pair) hwPositionPair).second).intValue() < ((Integer) ((Pair) hwPositionPair2).second).intValue() ? ((Pair) hwPositionPair).second : ((Pair) hwPositionPair2).second);
        if (iIntValue > num2.intValue()) {
            return null;
        }
        return new HwPositionPair(num, num2);
    }

    /* renamed from: a */
    public Animator m55191a(HwDefaultItemAnimator hwDefaultItemAnimator, List<anbq> list) {
        View view;
        ViewGroupOverlay viewGroupOverlay;
        com.huawei.uikit.hwrecyclerview.widget.bzrwd bzrwdVar;
        if (hwDefaultItemAnimator != null) {
            hwDefaultItemAnimator.m54952a((HwDefaultItemAnimator.ItemDeleteCallBack) null);
        }
        if (this.f43799e < 0) {
            Log.w(f43731E0, "setDeleteAnimatorInfoCallBack: mLastVisiblePosForDelete is size is 0");
            m55276f();
            this.f43793b.notifyResult(false);
            return null;
        }
        if (list != null && list.size() != 0) {
            int size = list.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                anbq anbqVar = list.get(i11);
                if (!anbqVar.f43867d && (view = anbqVar.f43866c) != null && view.getAlpha() == 0.0f && (viewGroupOverlay = anbqVar.f43876m) != null && (bzrwdVar = anbqVar.f43875l) != null) {
                    viewGroupOverlay.add(bzrwdVar);
                    anbqVar.f43877n = true;
                    i10++;
                }
            }
            if (i10 <= 0) {
                m55276f();
                this.f43793b.notifyResult(true);
                return null;
            }
            return m55183F();
        }
        Log.w(f43731E0, "setDeleteAnimatorInfoCallBack: size of deleteItemInfos is 0");
        m55276f();
        this.f43793b.notifyResult(false);
        return null;
    }

    /* renamed from: a */
    private boolean m55231a(HwDefaultItemAnimator hwDefaultItemAnimator) {
        if (hwDefaultItemAnimator == null) {
            Log.e(f43731E0, "setAnimatorInfoCallBack: itemAnimator is null.");
            return false;
        }
        List<anbq> list = this.f43795c;
        if (list == null) {
            Log.e(f43731E0, "setAnimatorInfoCallBack: mAllItemInfos is null.");
            return false;
        }
        m55242b(hwDefaultItemAnimator, list);
        return true;
    }

    /* renamed from: a */
    private float m55184a(int i10, float f10, int i11) {
        return i10 * new C11906a(i11).m71440a(f10);
    }

    /* renamed from: a */
    private boolean m55233a(final String str, float f10, float f11) {
        float fAbs;
        AbstractC4672b.s sVar;
        if (f43735I0.equals(str)) {
            fAbs = Math.abs(getTranslationY());
            sVar = AbstractC4672b.f21514q;
        } else {
            fAbs = Math.abs(getTranslationX());
            sVar = AbstractC4672b.f21513p;
        }
        AbstractC4672b.s sVar2 = sVar;
        if (Float.compare(fAbs, 0.0f) == 0) {
            return false;
        }
        ValueAnimator valueAnimator = this.f43841z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (f43735I0.equals(str)) {
            this.f43841z = ValueAnimator.ofFloat(getTranslationY(), f11);
        } else {
            this.f43841z = ValueAnimator.ofFloat(getTranslationX(), f11);
        }
        this.f43841z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.uikit.hwrecyclerview.widget.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f43985a.m55216a(str, valueAnimator2);
            }
        });
        C11716c c11716c = new C11716c(sVar2, !isChainAnimationEnabled() ? f43744R0 : f43746T0, !isChainAnimationEnabled() ? 30.0f : f43747U0, Math.abs(fAbs), f10);
        this.f43841z.setInterpolator(c11716c);
        this.f43841z.setDuration((long) c11716c.m69894b());
        this.f43841z.addListener(new akxao());
        m55199a(this.f43841z);
        this.f43841z.start();
        return true;
    }

    /* renamed from: a */
    public /* synthetic */ void m55216a(String str, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (f43735I0.equals(str)) {
            setIntegerTranslationY(fFloatValue);
        } else {
            setIntegerTranslationX(fFloatValue);
        }
        invalidate();
    }

    /* renamed from: a */
    private void m55199a(ValueAnimator valueAnimator) {
        valueAnimator.addUpdateListener(new avpbg());
    }

    /* renamed from: a */
    private ContextMenu.ContextMenuInfo m55194a(View view, int i10, long j10) {
        return new AdapterView.AdapterContextMenuInfo(view, i10, j10);
    }

    /* renamed from: a */
    private boolean m55222a(float f10, float f11, boolean z10) {
        View viewFindChildViewUnder = findChildViewUnder(f10, f11);
        int childAdapterPosition = viewFindChildViewUnder != null ? getChildAdapterPosition(viewFindChildViewUnder) : -1;
        this.f43792a0 = null;
        if (childAdapterPosition != -1 && viewFindChildViewUnder != null) {
            this.f43792a0 = m55194a(viewFindChildViewUnder, childAdapterPosition, getChildItemId(viewFindChildViewUnder));
            if (z10 && this.f43815m) {
                this.f43794b0 = true;
                return super.showContextMenuForChild(this, f10, f11);
            }
            return super.showContextMenuForChild(this);
        }
        Log.e(f43731E0, "position: invalid position");
        if (z10 && this.f43815m) {
            return super.showContextMenu(f10, f11);
        }
        return super.showContextMenu();
    }

    /* renamed from: a */
    private boolean m55228a(View view, float f10, float f11, boolean z10) {
        View viewM55195a = m55195a(view);
        int childAdapterPosition = viewM55195a == null ? -1 : getChildAdapterPosition(viewM55195a);
        this.f43792a0 = null;
        if (childAdapterPosition >= 0) {
            this.f43792a0 = m55194a(viewM55195a, childAdapterPosition, getChildItemId(viewM55195a));
        } else {
            Log.e(f43731E0, "longPressPosition: invalid longPressPosition");
        }
        if (z10 && this.f43815m) {
            this.f43794b0 = true;
            return super.showContextMenuForChild(view, f10, f11);
        }
        return super.showContextMenuForChild(view);
    }

    /* renamed from: a */
    private View m55195a(View view) {
        View view2;
        if (view == null || !(view.getParent() instanceof View)) {
            return null;
        }
        Object parent = view.getParent();
        while (true) {
            View view3 = (View) parent;
            view2 = view;
            view = view3;
            if (view == null || view.equals(this)) {
                break;
            }
            if (!(view.getParent() instanceof View)) {
                return null;
            }
            parent = view.getParent();
        }
        return view2;
    }

    /* renamed from: a */
    private boolean m55229a(RecyclerView.AbstractC0838h abstractC0838h) {
        int iMo5556i = this.f43802f0.mo5556i();
        int i10 = Integer.MIN_VALUE;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null) {
                if (this.f43802f0.mo5551d(childAt) > iMo5556i) {
                    return true;
                }
                int childAdapterPosition = getChildAdapterPosition(childAt);
                if (i10 < childAdapterPosition) {
                    i10 = childAdapterPosition;
                }
            }
        }
        return i10 < abstractC0838h.mo721e() - 1;
    }

    /* renamed from: a */
    private boolean m55234a(float[] fArr) {
        float translationX;
        float translationY;
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (!this.f43807i || !this.f43813l || layoutManager == null) {
            return false;
        }
        if (layoutManager.canScrollVertically()) {
            translationY = getTranslationY();
            translationX = 0.0f;
        } else {
            translationX = getTranslationX();
            translationY = 0.0f;
        }
        if (Float.compare(translationX, 0.0f) == 0 && Float.compare(translationY, 0.0f) == 0) {
            return false;
        }
        fArr[0] = translationX;
        fArr[1] = translationY;
        return true;
    }

    /* renamed from: a */
    private void m55201a(Canvas canvas) {
        Drawable background;
        float[] fArr = {0.0f, 0.0f};
        if (!m55234a(fArr) || (background = getBackground()) == null) {
            return;
        }
        float scrollX = getScrollX() - fArr[0];
        float scrollY = getScrollY() - fArr[1];
        canvas.translate(scrollX, scrollY);
        background.draw(canvas);
        canvas.translate(-scrollX, -scrollY);
    }
}
