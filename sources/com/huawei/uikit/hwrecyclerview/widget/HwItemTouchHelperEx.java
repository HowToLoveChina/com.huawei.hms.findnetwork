package com.huawei.uikit.hwrecyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.widget.InterfaceC0870i;
import androidx.recyclerview.widget.InterfaceC0871j;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwanimations.C8701R;
import com.huawei.uikit.hwgraphiceffect.widget.HwShadowEngine;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;
import p273f0.C9612m;

/* loaded from: classes4.dex */
public class HwItemTouchHelperEx extends RecyclerView.AbstractC0845o implements RecyclerView.InterfaceC0847q {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;

    /* renamed from: R */
    static final int f43498R = 8;
    public static final int RIGHT = 8;

    /* renamed from: S */
    private static final String f43499S = "HwItemTouchHelper";
    public static final int START = 16;

    /* renamed from: T */
    private static final boolean f43500T = false;

    /* renamed from: U */
    private static final int f43501U = -1;

    /* renamed from: UP */
    public static final int f43502UP = 1;

    /* renamed from: V */
    private static final int f43503V = 255;

    /* renamed from: W */
    private static final int f43504W = 65280;

    /* renamed from: X */
    private static final int f43505X = 16711680;

    /* renamed from: Y */
    private static final int f43506Y = 1000;

    /* renamed from: Z */
    private static final float f43507Z = 1.0f;

    /* renamed from: a0 */
    private static final long f43508a0 = 500;

    /* renamed from: b0 */
    private static final float f43509b0 = 0.1f;

    /* renamed from: c0 */
    private static final long f43510c0 = 200;

    /* renamed from: d0 */
    private static final long f43511d0 = 50;

    /* renamed from: A */
    private ValueAnimator f43512A;

    /* renamed from: B */
    private RecyclerView.AbstractC0833c0 f43513B;

    /* renamed from: C */
    private bxac f43514C;

    /* renamed from: M */
    private HwShadowEngine f43524M;

    /* renamed from: N */
    private Object f43525N;

    /* renamed from: O */
    private Rect f43526O;

    /* renamed from: P */
    private long f43527P;

    /* renamed from: c */
    float f43531c;

    /* renamed from: d */
    float f43532d;

    /* renamed from: e */
    float f43533e;

    /* renamed from: f */
    float f43534f;

    /* renamed from: h */
    int f43536h;

    /* renamed from: i */
    Callback f43537i;

    /* renamed from: k */
    RecyclerView f43539k;

    /* renamed from: l */
    VelocityTracker f43540l;

    /* renamed from: o */
    C9612m f43543o;

    /* renamed from: q */
    private float f43545q;

    /* renamed from: r */
    private float f43546r;

    /* renamed from: t */
    private float f43548t;

    /* renamed from: u */
    private float f43549u;

    /* renamed from: w */
    private int f43551w;

    /* renamed from: x */
    private List<RecyclerView.AbstractC0833c0> f43552x;

    /* renamed from: y */
    private List<Integer> f43553y;

    /* renamed from: a */
    final List<View> f43529a = new ArrayList();

    /* renamed from: b */
    RecyclerView.AbstractC0833c0 f43530b = null;

    /* renamed from: g */
    int f43535g = -1;

    /* renamed from: j */
    List<bfscp> f43538j = new ArrayList();

    /* renamed from: m */
    View f43541m = null;

    /* renamed from: n */
    int f43542n = -1;

    /* renamed from: p */
    final Runnable f43544p = new bzrwd();

    /* renamed from: s */
    private final float[] f43547s = new float[2];

    /* renamed from: v */
    private int f43550v = 0;

    /* renamed from: z */
    private RecyclerView.InterfaceC0841k f43554z = null;

    /* renamed from: D */
    private boolean f43515D = false;

    /* renamed from: E */
    private long f43516E = 400;

    /* renamed from: F */
    private long f43517F = 600;

    /* renamed from: G */
    private boolean f43518G = false;

    /* renamed from: H */
    private boolean f43519H = false;

    /* renamed from: I */
    private boolean f43520I = false;

    /* renamed from: J */
    private float f43521J = 1.0f;

    /* renamed from: K */
    private int f43522K = 0;

    /* renamed from: L */
    private int f43523L = 0;

    /* renamed from: Q */
    private final RecyclerView.InterfaceC0849s f43528Q = new aauaf();

    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        /* renamed from: f */
        static final int f43555f = 3158064;

        /* renamed from: g */
        private static final int f43556g = 789516;

        /* renamed from: h */
        private static final Interpolator f43557h = new Interpolator() { // from class: com.huawei.uikit.hwrecyclerview.widget.e
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f10) {
                return HwItemTouchHelperEx.Callback.m55040a(f10);
            }
        };

        /* renamed from: i */
        private static final Interpolator f43558i = new Interpolator() { // from class: com.huawei.uikit.hwrecyclerview.widget.f
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f10) {
                return HwItemTouchHelperEx.Callback.m55049b(f10);
            }
        };

        /* renamed from: j */
        private static final long f43559j = 2000;

        /* renamed from: a */
        private int f43560a = -1;

        /* renamed from: b */
        private float f43561b = 1.0f;

        /* renamed from: c */
        private boolean f43562c = false;

        /* renamed from: d */
        private int f43563d = 0;

        /* renamed from: e */
        private int f43564e = 0;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ float m55040a(float f10) {
            return f10 * f10 * f10 * f10 * f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static /* synthetic */ float m55049b(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }

        public static int convertToRelativeDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & f43556g;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 << 2;
            } else {
                int i15 = i13 << 1;
                i14 |= (-789517) & i15;
                i12 = (i15 & f43556g) << 2;
            }
            return i14 | i12;
        }

        public static InterfaceC0871j getDefaultUIUtil() {
            return com.huawei.uikit.hwrecyclerview.widget.aauaf.f43931a;
        }

        public static int makeFlag(int i10, int i11) {
            return i11 << (i10 * 8);
        }

        public static int makeMovementFlags(int i10, int i11) {
            return makeFlag(2, i10) | makeFlag(1, i11) | makeFlag(0, i11 | i10);
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02) {
            return true;
        }

        public boolean canScaleOverlappedItem(RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return true;
        }

        public RecyclerView.AbstractC0833c0 chooseDropTarget(RecyclerView.AbstractC0833c0 abstractC0833c0, List<RecyclerView.AbstractC0833c0> list, int i10, int i11) {
            awsks awsksVar = new awsks();
            awsksVar.f43576b = -1;
            awsksVar.f43577c = i10;
            awsksVar.f43578d = i11;
            RecyclerView.AbstractC0833c0 abstractC0833c0M55044a = m55044a(abstractC0833c0, list, awsksVar);
            awsksVar.f43575a = abstractC0833c0M55044a;
            if (abstractC0833c0M55044a != null && !this.f43562c && canScaleOverlappedItem(abstractC0833c0M55044a)) {
                m55051b(awsksVar.f43575a.f4327a);
            }
            return awsksVar.f43575a;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            com.huawei.uikit.hwrecyclerview.widget.aauaf.f43931a.clearView(abstractC0833c0.f4327a);
            abstractC0833c0.f4327a.setScaleX(1.0f);
            abstractC0833c0.f4327a.setScaleY(1.0f);
        }

        public int convertToAbsoluteDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & f43555f;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 >> 2;
            } else {
                int i15 = i13 >> 1;
                i14 |= (-3158065) & i15;
                i12 = (f43555f & i15) >> 2;
            }
            return i12 | i14;
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.AbstractC0843m itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i10 == 8 ? 200L : 250L : i10 == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return 0.0f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0);

        public float getSwipeEscapeVelocity(float f10) {
            return f10;
        }

        public float getSwipeThreshold(RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f10) {
            return f10;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            int iSignum = (int) (((int) (((int) Math.signum(i11)) * m55041a(recyclerView) * f43558i.getInterpolation(Math.min(1.0f, Math.abs(i11) / i10)))) * f43557h.getInterpolation(j10 <= 2000 ? j10 / 2000.0f : 1.0f));
            return iSignum == 0 ? i11 > 0 ? 1 : -1 : iSignum;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0, float f10, float f11, int i10, boolean z10) {
            com.huawei.uikit.hwrecyclerview.widget.aauaf.f43931a.onDraw(canvas, recyclerView, abstractC0833c0.f4327a, f10, f11, i10, z10);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0, float f10, float f11, int i10, boolean z10) {
            com.huawei.uikit.hwrecyclerview.widget.aauaf.f43931a.onDrawOver(canvas, recyclerView, abstractC0833c0.f4327a, f10, f11, i10, z10);
        }

        public boolean onMove(RecyclerView recyclerView, int i10, int i11) {
            return false;
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, RecyclerView.AbstractC0833c0 abstractC0833c02, int i11, int i12, int i13) {
            RecyclerView.AbstractC0846p layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof InterfaceC0870i) {
                ((InterfaceC0870i) layoutManager).prepareForDrop(abstractC0833c0.f4327a, abstractC0833c02.f4327a, i12, i13);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(abstractC0833c02.f4327a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i11);
                }
                if (layoutManager.getDecoratedRight(abstractC0833c02.f4327a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i11);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(abstractC0833c02.f4327a) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i11);
                }
                if (layoutManager.getDecoratedBottom(abstractC0833c02.f4327a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i11);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
            if (abstractC0833c0 != null) {
                com.huawei.uikit.hwrecyclerview.widget.aauaf.f43931a.onSelected(abstractC0833c0.f4327a);
            }
        }

        public abstract void onSwiped(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10);

        public void updateSelectedScale(float f10) {
            this.f43561b = f10;
        }

        /* renamed from: c */
        public boolean m55060c(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return (m55056a(recyclerView, abstractC0833c0) & HwItemTouchHelperEx.f43504W) != 0;
        }

        /* renamed from: b */
        public boolean m55059b(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return (m55056a(recyclerView, abstractC0833c0) & HwItemTouchHelperEx.f43505X) != 0;
        }

        /* renamed from: b */
        private void m55052b(RecyclerView.AbstractC0833c0 abstractC0833c0, awsks awsksVar, int i10, int i11, RecyclerView.AbstractC0833c0 abstractC0833c02) {
            int left;
            int iAbs;
            int right;
            int iAbs2;
            if (i11 > 0 && (right = abstractC0833c02.f4327a.getRight() - i10) < 0 && abstractC0833c02.f4327a.getRight() > abstractC0833c0.f4327a.getRight() && (iAbs2 = Math.abs(right)) > awsksVar.f43576b) {
                awsksVar.f43576b = iAbs2;
                awsksVar.f43575a = abstractC0833c02;
            }
            if (i11 >= 0 || (left = abstractC0833c02.f4327a.getLeft() - awsksVar.f43577c) <= 0 || abstractC0833c02.f4327a.getLeft() >= abstractC0833c0.f4327a.getLeft() || (iAbs = Math.abs(left)) <= awsksVar.f43576b) {
                return;
            }
            awsksVar.f43576b = iAbs;
            awsksVar.f43575a = abstractC0833c02;
        }

        /* renamed from: a */
        public final int m55056a(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, abstractC0833c0), C9603h0.m59832A(recyclerView));
        }

        /* renamed from: a */
        private RecyclerView.AbstractC0833c0 m55044a(RecyclerView.AbstractC0833c0 abstractC0833c0, List<RecyclerView.AbstractC0833c0> list, awsks awsksVar) {
            int width = awsksVar.f43577c + abstractC0833c0.f4327a.getWidth();
            int height = awsksVar.f43578d + abstractC0833c0.f4327a.getHeight();
            int left = awsksVar.f43577c - abstractC0833c0.f4327a.getLeft();
            int top = awsksVar.f43578d - abstractC0833c0.f4327a.getTop();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView.AbstractC0833c0 abstractC0833c02 = list.get(i10);
                if (this.f43562c) {
                    awsksVar.f43576b = (int) (abstractC0833c02.f4327a.getHeight() * 0.1f);
                }
                m55052b(abstractC0833c0, awsksVar, width, left, abstractC0833c02);
                m55047a(abstractC0833c0, awsksVar, top, abstractC0833c02);
                m55046a(abstractC0833c0, awsksVar, height, top, abstractC0833c02);
            }
            return awsksVar.f43575a;
        }

        /* renamed from: b */
        private void m55051b(View view) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), C8701R.interpolator.cubic_bezier_interpolator_type_20_80));
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.addUpdateListener(m55043a(view));
            valueAnimatorOfFloat.start();
        }

        /* renamed from: a */
        private void m55046a(RecyclerView.AbstractC0833c0 abstractC0833c0, awsks awsksVar, int i10, int i11, RecyclerView.AbstractC0833c0 abstractC0833c02) {
            int iAbs;
            int iAbs2;
            if (i11 <= 0) {
                return;
            }
            int bottom = abstractC0833c02.f4327a.getBottom() - i10;
            if (this.f43562c && this.f43563d < this.f43564e && (bottom = abstractC0833c02.f4327a.getTop() - i10) < 0 && (iAbs2 = Math.abs(bottom)) > awsksVar.f43576b) {
                awsksVar.f43576b = iAbs2;
                awsksVar.f43575a = abstractC0833c02;
            }
            if (bottom >= 0 || abstractC0833c02.f4327a.getBottom() <= abstractC0833c0.f4327a.getBottom() || (iAbs = Math.abs(bottom)) <= awsksVar.f43576b) {
                return;
            }
            awsksVar.f43576b = iAbs;
            awsksVar.f43575a = abstractC0833c02;
        }

        /* renamed from: a */
        private void m55047a(RecyclerView.AbstractC0833c0 abstractC0833c0, awsks awsksVar, int i10, RecyclerView.AbstractC0833c0 abstractC0833c02) {
            int iAbs;
            int iAbs2;
            if (i10 >= 0) {
                return;
            }
            int top = abstractC0833c02.f4327a.getTop() - awsksVar.f43578d;
            if (this.f43562c && this.f43563d > this.f43564e) {
                int bottom = abstractC0833c02.f4327a.getBottom() - awsksVar.f43578d;
                if (bottom <= 0 || (iAbs2 = Math.abs(bottom)) <= awsksVar.f43576b) {
                    return;
                }
                awsksVar.f43576b = iAbs2;
                awsksVar.f43575a = abstractC0833c02;
                return;
            }
            if (top <= 0 || abstractC0833c02.f4327a.getTop() >= abstractC0833c0.f4327a.getTop() || (iAbs = Math.abs(top)) <= awsksVar.f43576b) {
                return;
            }
            awsksVar.f43576b = iAbs;
            awsksVar.f43575a = abstractC0833c02;
        }

        /* renamed from: a */
        private ValueAnimator.AnimatorUpdateListener m55043a(final View view) {
            return new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.uikit.hwrecyclerview.widget.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HwItemTouchHelperEx.Callback.m55045a(view, valueAnimator);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ void m55045a(View view, ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwItemTouchHelperEx.f43499S, "getAlphaListener: onAnimationUpdate: animation is null");
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            view.setScaleX(fFloatValue);
            view.setScaleY(fFloatValue);
        }

        /* renamed from: a */
        private int m55041a(RecyclerView recyclerView) {
            if (this.f43560a == -1) {
                this.f43560a = recyclerView.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f43560a;
        }

        /* renamed from: a */
        public void m55058a(Canvas canvas, RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0, List<bfscp> list, aayti aaytiVar) throws Resources.NotFoundException {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                bfscp bfscpVar = list.get(i10);
                bfscpVar.m55074d();
                int iSave = canvas.save();
                bfscpVar.m55068b();
                onChildDraw(canvas, recyclerView, bfscpVar.f43583b, bfscpVar.f43590i, bfscpVar.f43589h, bfscpVar.f43582a, false);
                canvas.restoreToCount(iSave);
            }
            if (abstractC0833c0 != null) {
                int iSave2 = canvas.save();
                abstractC0833c0.f4327a.setScaleX(this.f43561b);
                abstractC0833c0.f4327a.setScaleY(this.f43561b);
                onChildDraw(canvas, recyclerView, abstractC0833c0, aaytiVar.f43569b, aaytiVar.f43570c, aaytiVar.f43568a, true);
                canvas.restoreToCount(iSave2);
            }
        }

        /* renamed from: a */
        public void m55057a(Canvas canvas, RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0, List<bfscp> list, int i10, float f10, float f11) {
            int size = list.size();
            boolean z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                bfscp bfscpVar = list.get(i11);
                int iSave = canvas.save();
                onChildDrawOver(canvas, recyclerView, bfscpVar.f43583b, bfscpVar.f43590i, bfscpVar.f43589h, bfscpVar.f43582a, false);
                canvas.restoreToCount(iSave);
            }
            if (abstractC0833c0 != null) {
                int iSave2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, abstractC0833c0, f10, f11, i10, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i12 = size - 1; i12 >= 0; i12--) {
                bfscp bfscpVar2 = list.get(i12);
                boolean z11 = bfscpVar2.f43592k;
                if (z11 && !bfscpVar2.f43588g) {
                    list.remove(i12);
                } else if (!z11) {
                    z10 = true;
                }
            }
            if (z10) {
                recyclerView.invalidate();
            }
        }
    }

    public static abstract class SimpleCallback extends Callback {

        /* renamed from: k */
        private int f43565k;

        /* renamed from: l */
        private int f43566l;

        public SimpleCallback(int i10, int i11) {
            this.f43566l = i10;
            this.f43565k = i11;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return this.f43565k;
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, abstractC0833c0), getSwipeDirs(recyclerView, abstractC0833c0));
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            return this.f43566l;
        }

        public void setDefaultDragDirs(int i10) {
            this.f43565k = i10;
        }

        public void setDefaultSwipeDirs(int i10) {
            this.f43566l = i10;
        }
    }

    public static class aayti {

        /* renamed from: a */
        int f43568a;

        /* renamed from: b */
        float f43569b;

        /* renamed from: c */
        float f43570c;
    }

    public class akxao implements Runnable {

        /* renamed from: a */
        final /* synthetic */ bfscp f43571a;

        /* renamed from: b */
        final /* synthetic */ int f43572b;

        public akxao(bfscp bfscpVar, int i10) {
            this.f43571a = bfscpVar;
            this.f43572b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = HwItemTouchHelperEx.this.f43539k;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            bfscp bfscpVar = this.f43571a;
            if (bfscpVar.f43593l || bfscpVar.f43583b.m5164k() == -1) {
                return;
            }
            RecyclerView.AbstractC0843m itemAnimator = HwItemTouchHelperEx.this.f43539k.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !HwItemTouchHelperEx.this.m55038k()) {
                HwItemTouchHelperEx.this.f43537i.onSwiped(this.f43571a.f43583b, this.f43572b);
            } else {
                HwItemTouchHelperEx.this.f43539k.post(this);
            }
        }
    }

    public class avpbg implements RecyclerView.InterfaceC0841k {
        public avpbg() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0841k
        public int onGetChildDrawingOrder(int i10, int i11) {
            HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
            View view = hwItemTouchHelperEx.f43541m;
            if (view == null) {
                return i11;
            }
            int iIndexOfChild = hwItemTouchHelperEx.f43542n;
            if (iIndexOfChild == -1) {
                iIndexOfChild = hwItemTouchHelperEx.f43539k.indexOfChild(view);
                HwItemTouchHelperEx.this.f43542n = iIndexOfChild;
            }
            return i11 == i10 + (-1) ? iIndexOfChild : i11 < iIndexOfChild ? i11 : i11 + 1;
        }
    }

    public static class awsks {

        /* renamed from: a */
        RecyclerView.AbstractC0833c0 f43575a;

        /* renamed from: b */
        int f43576b;

        /* renamed from: c */
        int f43577c;

        /* renamed from: d */
        int f43578d;
    }

    public class bfscp implements Animator.AnimatorListener {

        /* renamed from: t */
        static final float f43579t = 1.05f;

        /* renamed from: u */
        static final float f43580u = 0.05f;

        /* renamed from: v */
        static final float f43581v = 550.0f;

        /* renamed from: a */
        final int f43582a;

        /* renamed from: b */
        final RecyclerView.AbstractC0833c0 f43583b;

        /* renamed from: c */
        final float f43584c;

        /* renamed from: d */
        final float f43585d;

        /* renamed from: e */
        final float f43586e;

        /* renamed from: f */
        final float f43587f;

        /* renamed from: g */
        boolean f43588g;

        /* renamed from: h */
        float f43589h;

        /* renamed from: i */
        float f43590i;

        /* renamed from: j */
        final int f43591j;

        /* renamed from: k */
        boolean f43592k = false;

        /* renamed from: l */
        boolean f43593l = false;

        /* renamed from: m */
        boolean f43594m = false;

        /* renamed from: n */
        boolean f43595n = true;

        /* renamed from: o */
        private final ValueAnimator f43596o;

        /* renamed from: p */
        private float f43597p;

        /* renamed from: q */
        private List<aauaf> f43598q;

        /* renamed from: r */
        private HwShadowEngine f43599r;

        public class aauaf {

            /* renamed from: a */
            RecyclerView.AbstractC0833c0 f43601a;

            /* renamed from: b */
            private float f43602b;

            /* renamed from: c */
            private float f43603c;

            /* renamed from: d */
            private float f43604d;

            /* renamed from: e */
            private float f43605e;

            public aauaf(RecyclerView.AbstractC0833c0 abstractC0833c0) {
                this.f43601a = abstractC0833c0;
                this.f43602b = abstractC0833c0.f4327a.getScaleX();
                this.f43603c = this.f43601a.f4327a.getScaleY();
            }
        }

        public class bzrwd implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a */
            final /* synthetic */ HwItemTouchHelperEx f43607a;

            public bzrwd(HwItemTouchHelperEx hwItemTouchHelperEx) {
                this.f43607a = hwItemTouchHelperEx;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                bfscp.this.m55072b(valueAnimator.getAnimatedFraction());
            }
        }

        public bfscp(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f43584c = f13;
            this.f43585d = f12;
            this.f43586e = f11;
            this.f43587f = f10;
            this.f43583b = abstractC0833c0;
            this.f43591j = i10;
            this.f43582a = i11;
            this.f43599r = new HwShadowEngine(abstractC0833c0.f4327a.getContext(), abstractC0833c0.f4327a, 1, 0);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f43596o = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new bzrwd(HwItemTouchHelperEx.this));
            valueAnimatorOfFloat.setTarget(abstractC0833c0.f4327a);
            valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(abstractC0833c0.f4327a.getContext(), R.anim.linear_interpolator));
            valueAnimatorOfFloat.addListener(this);
            m55069c(0.0f);
        }

        /* renamed from: a */
        private boolean m55067a(float f10) {
            return f10 < Float.MAX_VALUE && f10 > -3.4028235E38f;
        }

        /* renamed from: b */
        public void m55072b(float f10) {
            m55069c(f10);
        }

        /* renamed from: c */
        public void m55073c() {
            this.f43583b.m5147I(false);
            this.f43596o.start();
        }

        /* renamed from: d */
        public void m55074d() throws Resources.NotFoundException {
            float f10 = this.f43597p / 0.36363637f;
            Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(this.f43583b.f4327a.getContext(), C8701R.interpolator.cubic_bezier_interpolator_type_33_33);
            if (this.f43597p < 0.36363637f) {
                float interpolation = interpolatorLoadInterpolator.getInterpolation(f10);
                float f11 = this.f43587f;
                float f12 = this.f43585d;
                if (f11 == f12) {
                    this.f43590i = this.f43583b.f4327a.getTranslationX();
                } else {
                    this.f43590i = f11 + ((f12 - f11) * interpolation);
                }
                float f13 = this.f43586e;
                float f14 = this.f43584c;
                if (f13 == f14) {
                    this.f43589h = this.f43583b.f4327a.getTranslationY();
                } else {
                    this.f43589h = f13 + ((f14 - f13) * interpolation);
                }
                if (this.f43594m) {
                    for (aauaf aauafVar : this.f43598q) {
                        aauafVar.f43604d = aauafVar.f43602b + ((1.0f - aauafVar.f43602b) * interpolation);
                        aauafVar.f43605e = aauafVar.f43603c + ((1.0f - aauafVar.f43603c) * interpolation);
                    }
                }
            }
            if (this.f43597p > 0.27272728f) {
                float f15 = this.f43587f;
                float f16 = this.f43585d;
                if (f15 == f16) {
                    this.f43590i = this.f43583b.f4327a.getTranslationX();
                } else {
                    this.f43590i = f16;
                }
                float f17 = this.f43586e;
                float f18 = this.f43584c;
                if (f17 == f18) {
                    this.f43589h = this.f43583b.f4327a.getTranslationY();
                } else {
                    this.f43589h = f18;
                }
                if (this.f43594m) {
                    for (aauaf aauafVar2 : this.f43598q) {
                        aauafVar2.f43604d = 1.0f;
                        aauafVar2.f43605e = 1.0f;
                    }
                }
                m55063a(this.f43583b, 0.27272728f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            List<aauaf> list = this.f43598q;
            if (list != null) {
                for (aauaf aauafVar : list) {
                    aauafVar.f43601a.f4327a.setScaleX(1.0f);
                    aauafVar.f43601a.f4327a.setScaleY(1.0f);
                }
            }
            m55072b(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f43592k) {
                this.f43583b.m5147I(true);
            }
            RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f43583b;
            if (abstractC0833c0 != null) {
                abstractC0833c0.f4327a.setScaleX(1.0f);
                this.f43583b.f4327a.setScaleY(1.0f);
                this.f43583b.f4327a.setTranslationY(0.0f);
            }
            this.f43592k = true;
            HwItemTouchHelperEx.this.f43518G = false;
            HwItemTouchHelperEx.this.f43519H = false;
            HwItemTouchHelperEx.this.f43515D = false;
            HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
            hwItemTouchHelperEx.f43516E = hwItemTouchHelperEx.f43517F;
            if (this.f43595n) {
                this.f43599r.setShadowEnabled(true);
                this.f43599r.setShadowEnabled(false);
                this.f43595n = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m55068b() {
            if (HwItemTouchHelperEx.this.f43519H) {
                for (aauaf aauafVar : this.f43598q) {
                    aauafVar.f43601a.f4327a.setScaleX(1.0f);
                    aauafVar.f43601a.f4327a.setScaleY(1.0f);
                }
            }
            if (!this.f43594m || HwItemTouchHelperEx.this.f43519H) {
                return;
            }
            for (aauaf aauafVar2 : this.f43598q) {
                if (aauafVar2.f43602b < 1.0f) {
                    aauafVar2.f43601a.f4327a.setScaleX(aauafVar2.f43604d);
                    aauafVar2.f43601a.f4327a.setScaleY(aauafVar2.f43605e);
                }
            }
        }

        /* renamed from: c */
        private void m55069c(float f10) {
            this.f43597p = f10;
        }

        /* renamed from: a */
        public void m55071a(long j10) {
            this.f43596o.setDuration(j10);
        }

        /* renamed from: a */
        public void m55070a() {
            this.f43596o.cancel();
        }

        /* renamed from: a */
        private void m55063a(RecyclerView.AbstractC0833c0 abstractC0833c0, float f10) {
            if (this.f43582a != 2) {
                return;
            }
            float interpolation = AnimationUtils.loadInterpolator(this.f43583b.f4327a.getContext(), C8701R.interpolator.cubic_bezier_interpolator_type_onshot_bounce).getInterpolation((this.f43597p - f10) / (1.0f - f10));
            HwItemTouchHelperEx.this.f43521J = f43579t - (interpolation * 0.05f);
            if (this.f43595n) {
                this.f43599r.setShadowEnabled(true);
                this.f43599r.setShadowEnabled(false);
                this.f43595n = false;
            }
            if (abstractC0833c0 == null || !m55067a(HwItemTouchHelperEx.this.f43521J)) {
                return;
            }
            abstractC0833c0.f4327a.setScaleX(HwItemTouchHelperEx.this.f43521J);
            abstractC0833c0.f4327a.setScaleY(HwItemTouchHelperEx.this.f43521J);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m55066a(boolean z10) {
            this.f43594m = z10;
            if (z10) {
                ArrayList arrayList = new ArrayList();
                this.f43598q = arrayList;
                arrayList.add(new aauaf(this.f43583b));
                Iterator it = HwItemTouchHelperEx.this.m54978a(this.f43583b).iterator();
                while (it.hasNext()) {
                    this.f43598q.add(new aauaf((RecyclerView.AbstractC0833c0) it.next()));
                }
                HwItemTouchHelperEx.this.f43552x.clear();
                HwItemTouchHelperEx.this.f43553y.clear();
            }
        }
    }

    public class blfhz extends AnimatorListenerAdapter {

        /* renamed from: a */
        boolean f43609a = true;

        /* renamed from: b */
        final /* synthetic */ RecyclerView.AbstractC0833c0 f43610b;

        /* renamed from: c */
        final /* synthetic */ int f43611c;

        /* renamed from: d */
        final /* synthetic */ HwLinearLayoutManager f43612d;

        public class bzrwd implements Runnable {
            public bzrwd() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int iM5164k = HwItemTouchHelperEx.this.f43513B.m5164k();
                int iFindFirstVisibleItemPosition = blfhz.this.f43612d.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = blfhz.this.f43612d.findLastVisibleItemPosition();
                blfhz blfhzVar = blfhz.this;
                boolean z10 = blfhzVar.f43609a && iM5164k >= 0 && iM5164k != blfhzVar.f43611c;
                int i10 = blfhzVar.f43611c;
                if ((i10 <= iFindFirstVisibleItemPosition || i10 >= iFindLastVisibleItemPosition) && z10) {
                    HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
                    hwItemTouchHelperEx.f43537i.onMove(hwItemTouchHelperEx.f43539k, iM5164k, i10);
                    HwItemTouchHelperEx.this.f43539k.post(this);
                } else {
                    HwItemTouchHelperEx.this.f43512A = null;
                    HwItemTouchHelperEx.this.m55036d((RecyclerView.AbstractC0833c0) null, 0);
                    HwItemTouchHelperEx.this.f43513B.m5147I(true);
                    HwItemTouchHelperEx.this.f43513B = null;
                }
                blfhz.this.f43609a = false;
            }
        }

        public blfhz(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, HwLinearLayoutManager hwLinearLayoutManager) {
            this.f43610b = abstractC0833c0;
            this.f43611c = i10;
            this.f43612d = hwLinearLayoutManager;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            HwItemTouchHelperEx.this.m54985a(this.f43610b, this.f43611c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwItemTouchHelperEx.this.f43539k.post(new bzrwd());
            if (HwItemTouchHelperEx.this.f43518G) {
                HwItemTouchHelperEx.this.f43524M.setShadowEnabled(false);
            }
        }
    }

    public class bqmxo extends bfscp {

        /* renamed from: w */
        final /* synthetic */ int f43615w;

        /* renamed from: x */
        final /* synthetic */ RecyclerView.AbstractC0833c0 f43616x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public bqmxo(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, float f10, float f11, float f12, float f13, int i12, RecyclerView.AbstractC0833c0 abstractC0833c02) {
            super(abstractC0833c0, i10, i11, f10, f11, f12, f13);
            this.f43615w = i12;
            this.f43616x = abstractC0833c02;
        }

        /* renamed from: e */
        private void m55081e() {
            int i10 = this.f43615w;
            if (i10 > 0) {
                HwItemTouchHelperEx.this.m55032a(this, i10);
            }
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx.bfscp, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f43593l) {
                return;
            }
            if (this.f43615w <= 0) {
                HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
                hwItemTouchHelperEx.f43537i.clearView(hwItemTouchHelperEx.f43539k, this.f43616x);
            } else {
                HwItemTouchHelperEx.this.f43529a.add(this.f43616x.f4327a);
                this.f43588g = true;
                m55081e();
            }
            HwItemTouchHelperEx hwItemTouchHelperEx2 = HwItemTouchHelperEx.this;
            View view = hwItemTouchHelperEx2.f43541m;
            View view2 = this.f43616x.f4327a;
            if (view == view2) {
                hwItemTouchHelperEx2.m55034b(view2);
            }
        }
    }

    public class brnby implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f43618a;

        /* renamed from: b */
        final /* synthetic */ int f43619b;

        public brnby(int i10, int i11) {
            this.f43618a = i10;
            this.f43619b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f43618a;
            if (i10 >= 0) {
                HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
                hwItemTouchHelperEx.f43537i.onMove(hwItemTouchHelperEx.f43539k, i10, this.f43619b);
            }
        }
    }

    public class bxac extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a */
        private boolean f43621a = true;

        public bxac() {
        }

        /* renamed from: a */
        public void m55082a() {
            this.f43621a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewM55033b;
            RecyclerView.AbstractC0833c0 childViewHolder;
            if (HwItemTouchHelperEx.this.isMovingToDesignatedPos() || !this.f43621a || (viewM55033b = HwItemTouchHelperEx.this.m55033b(motionEvent)) == null || (childViewHolder = HwItemTouchHelperEx.this.f43539k.getChildViewHolder(viewM55033b)) == null) {
                return;
            }
            HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
            if (hwItemTouchHelperEx.f43537i.m55059b(hwItemTouchHelperEx.f43539k, childViewHolder)) {
                HwItemTouchHelperEx.this.m54983a(motionEvent, childViewHolder);
            }
        }
    }

    public class bzrwd implements Runnable {
        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
            if (hwItemTouchHelperEx.f43530b == null || !hwItemTouchHelperEx.m55039l()) {
                return;
            }
            HwItemTouchHelperEx hwItemTouchHelperEx2 = HwItemTouchHelperEx.this;
            RecyclerView.AbstractC0833c0 abstractC0833c0 = hwItemTouchHelperEx2.f43530b;
            if (abstractC0833c0 != null) {
                hwItemTouchHelperEx2.m55035b(abstractC0833c0);
            }
            HwItemTouchHelperEx hwItemTouchHelperEx3 = HwItemTouchHelperEx.this;
            hwItemTouchHelperEx3.f43539k.removeCallbacks(hwItemTouchHelperEx3.f43544p);
            C9603h0.m59886h0(HwItemTouchHelperEx.this.f43539k, this);
        }
    }

    public HwItemTouchHelperEx(Callback callback) {
        this.f43537i = callback;
    }

    /* renamed from: a */
    private int m54972a(int i10, int i11) {
        if (i10 == 2) {
            return 8;
        }
        return i11 > 0 ? 2 : 4;
    }

    /* renamed from: m */
    private void m55026m() {
        VelocityTracker velocityTracker = this.f43540l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f43540l = null;
        }
    }

    /* renamed from: n */
    private void m55027n() {
        this.f43551w = ViewConfiguration.get(this.f43539k.getContext()).getScaledTouchSlop();
        this.f43539k.addItemDecoration(this);
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: com.huawei.uikit.hwrecyclerview.widget.c
            @Override // android.view.View.OnUnhandledKeyEventListener
            public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
                return this.f43983a.m54993a(view, keyEvent);
            }
        };
        this.f43525N = onUnhandledKeyEventListener;
        this.f43539k.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        this.f43539k.addOnItemTouchListener(this.f43528Q);
        this.f43539k.addOnChildAttachStateChangeListener(this);
        m55014e();
    }

    @SuppressLint({"PrivateResource"})
    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f43539k;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m55010d();
        }
        this.f43539k = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f43548t = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
            this.f43549u = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
            m55027n();
        }
        m55023i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        rect.setEmpty();
    }

    public boolean isMovingToDesignatedPos() {
        return this.f43515D || this.f43512A != null;
    }

    public boolean isRunningRecoverAnim() {
        return m55038k();
    }

    /* renamed from: k */
    public boolean m55038k() {
        int size = this.f43538j.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f43538j.get(i10).f43592k) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public boolean m55039l() {
        int width;
        int i10;
        if (this.f43530b == null) {
            this.f43527P = Long.MIN_VALUE;
            return false;
        }
        RecyclerView.AbstractC0846p layoutManager = this.f43539k.getLayoutManager();
        if (this.f43526O == null) {
            this.f43526O = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(this.f43530b.f4327a, this.f43526O);
        if (layoutManager.canScrollHorizontally()) {
            int i11 = (int) (this.f43545q + this.f43533e);
            int paddingLeft = (i11 - this.f43526O.left) - this.f43539k.getPaddingLeft();
            float f10 = this.f43533e;
            if (f10 >= 0.0f || paddingLeft >= 0) {
                if (f10 > 0.0f) {
                    width = ((i11 + this.f43530b.f4327a.getWidth()) + this.f43526O.right) - (this.f43539k.getWidth() - this.f43539k.getPaddingRight());
                    if (width <= 0) {
                    }
                } else {
                    Log.d(f43499S, "do nothing");
                }
                width = 0;
            } else {
                width = paddingLeft;
            }
        } else {
            width = 0;
        }
        if (layoutManager.canScrollVertically()) {
            int i12 = (int) (this.f43546r + this.f43534f);
            int paddingTop = (i12 - this.f43526O.top) - this.f43539k.getPaddingTop();
            float f11 = this.f43534f;
            if (f11 >= 0.0f || paddingTop >= 0) {
                if (f11 > 0.0f) {
                    int height = ((i12 + this.f43530b.f4327a.getHeight()) + this.f43526O.bottom) - (this.f43539k.getHeight() - this.f43539k.getPaddingBottom());
                    if (height > 0) {
                        i10 = height;
                    }
                } else {
                    Log.d(f43499S, "do nothing");
                }
                i10 = 0;
            } else {
                i10 = paddingTop;
            }
        } else {
            i10 = 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.f43527P;
        return m54990a(jCurrentTimeMillis, j10 == Long.MIN_VALUE ? 0L : jCurrentTimeMillis - j10, width, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0847q
    public void onChildViewAttachedToWindow(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0847q
    public void onChildViewDetachedFromWindow(View view) {
        m55034b(view);
        RecyclerView.AbstractC0833c0 childViewHolder = this.f43539k.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f43530b;
        if (abstractC0833c0 != null && childViewHolder == abstractC0833c0) {
            this.f43519H = true;
            m55036d((RecyclerView.AbstractC0833c0) null, 0);
        } else {
            m55031a(childViewHolder, false);
            if (this.f43529a.remove(childViewHolder.f4327a)) {
                this.f43537i.clearView(this.f43539k, childViewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0856z c0856z) throws Resources.NotFoundException {
        float f10;
        float f11;
        this.f43542n = -1;
        if (this.f43530b != null) {
            m54988a(this.f43547s);
            float[] fArr = this.f43547s;
            f10 = fArr[0];
            f11 = fArr[1];
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        aayti aaytiVar = new aayti();
        aaytiVar.f43568a = this.f43550v;
        aaytiVar.f43569b = f10;
        aaytiVar.f43570c = f11;
        this.f43537i.m55058a(canvas, recyclerView, this.f43530b, this.f43538j, aaytiVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        float f10;
        float f11;
        if (this.f43530b != null) {
            m54988a(this.f43547s);
            float[] fArr = this.f43547s;
            float f12 = fArr[0];
            f11 = fArr[1];
            f10 = f12;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        this.f43537i.m55057a(canvas, recyclerView, this.f43530b, this.f43538j, this.f43550v, f10, f11);
    }

    public void scaleItemAccordingOverlapping(RecyclerView.AbstractC0833c0 abstractC0833c0, List<RecyclerView.AbstractC0833c0> list, Callback callback, float f10, float f11) {
    }

    public void startDrag(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (!this.f43537i.m55059b(this.f43539k, abstractC0833c0)) {
            Log.e(f43499S, "Start drag was called, but drag was not enabled");
            return;
        }
        if (abstractC0833c0.f4327a.getParent() != this.f43539k) {
            Log.e(f43499S, "Start dragging was called with a view holder that is notThe RecyclerView controlled by this HwItemTouchHelper.");
            return;
        }
        m55037g();
        this.f43534f = 0.0f;
        this.f43533e = 0.0f;
        m55036d(abstractC0833c0, 2);
    }

    public void startDragSelectedAnimation(View view, Callback callback, HwShadowEngine hwShadowEngine) {
    }

    public void startMoveItem(int i10, int i11) {
        RecyclerView recyclerView = this.f43539k;
        if (recyclerView == null || recyclerView.getAdapter() == null) {
            Log.e(f43499S, "RecyclerView is null!");
            return;
        }
        if (!(this.f43539k.getLayoutManager() instanceof HwLinearLayoutManager)) {
            Log.e(f43499S, "Invalid layout manager!");
            return;
        }
        HwLinearLayoutManager hwLinearLayoutManager = (HwLinearLayoutManager) this.f43539k.getLayoutManager();
        if (hwLinearLayoutManager.getOrientation() == 0) {
            return;
        }
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition = this.f43539k.findViewHolderForAdapterPosition(i10);
        this.f43513B = abstractC0833c0FindViewHolderForAdapterPosition;
        if (abstractC0833c0FindViewHolderForAdapterPosition == null) {
            Log.e(f43499S, "From position viewHolder is null!");
            return;
        }
        if (!this.f43537i.m55059b(this.f43539k, abstractC0833c0FindViewHolderForAdapterPosition)) {
            Log.e(f43499S, "From position viewHolder doesn't has drag flag!");
            return;
        }
        if (this.f43512A != null || this.f43550v != 0) {
            Log.e(f43499S, "Last animation is not finished or under drag and swipe state.");
            return;
        }
        int iMo721e = this.f43539k.getAdapter().mo721e();
        if (i10 < 0 || i11 < 0 || i10 >= iMo721e || i11 >= iMo721e) {
            Log.e(f43499S, "From position or to position out of bound!");
            return;
        }
        this.f43522K = i10;
        this.f43523L = i11;
        this.f43515D = true;
        m54999b(i10, i11);
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition2 = this.f43539k.findViewHolderForAdapterPosition(i11);
        this.f43512A.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.uikit.hwrecyclerview.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f43930a.m54982a(valueAnimator);
            }
        });
        this.f43512A.addListener(m54975a(abstractC0833c0FindViewHolderForAdapterPosition2, i11, hwLinearLayoutManager));
        this.f43513B.m5147I(false);
        this.f43512A.start();
    }

    public void startSwipe(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (!this.f43537i.m55060c(this.f43539k, abstractC0833c0)) {
            Log.e(f43499S, "Start swipe was called, but swipe was not enabled");
            return;
        }
        if (abstractC0833c0.f4327a.getParent() != this.f43539k) {
            Log.e(f43499S, "Start sliding was called with a view holder that is notRecyclerView controlled by this HwItemTouchHelper.");
            return;
        }
        m55037g();
        this.f43534f = 0.0f;
        this.f43533e = 0.0f;
        m55036d(abstractC0833c0, 1);
    }

    public void stopCurrentProcess() {
        ValueAnimator valueAnimator = this.f43512A;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
    }

    /* renamed from: a */
    private void m54980a() {
    }

    /* renamed from: e */
    private void m55014e() {
        this.f43514C = new bxac();
        this.f43543o = new C9612m(this.f43539k.getContext(), this.f43514C);
    }

    /* renamed from: f */
    private void m55018f() {
        if (this.f43514C != null) {
            Log.d(f43499S, "mItemTouchHelperGestureListener is not empty.");
            this.f43514C.m55082a();
            this.f43514C = null;
        }
        if (this.f43543o != null) {
            Log.d(f43499S, "mGestureDetector is not empty.");
            this.f43543o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m55021h() {
        if (!(this.f43539k.getLayoutManager() instanceof HwLinearLayoutManager)) {
            Log.e(f43499S, "Invalid layout manager!");
            return;
        }
        HwLinearLayoutManager hwLinearLayoutManager = (HwLinearLayoutManager) this.f43539k.getLayoutManager();
        int iM54973a = m54973a(hwLinearLayoutManager);
        hwLinearLayoutManager.setExtraLayoutSpace(iM54973a, iM54973a);
    }

    /* renamed from: i */
    private void m55023i() {
        RecyclerView recyclerView = this.f43539k;
        if (recyclerView == null || recyclerView.getAdapter() == null || this.f43539k.getAdapter() == null) {
            return;
        }
        RecyclerView.AbstractC0846p layoutManager = this.f43539k.getLayoutManager();
        if (layoutManager instanceof HwLinearLayoutManager) {
            ((HwLinearLayoutManager) layoutManager).setOnReferenceItemListener(new HwLinearLayoutManagerEx.OnReferenceItemListener() { // from class: com.huawei.uikit.hwrecyclerview.widget.b
                @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx.OnReferenceItemListener
                public final boolean isNeedRefreshReferenceLayout(View view) {
                    return this.f43941a.m54991a(view);
                }
            });
        }
    }

    /* renamed from: j */
    private void m55025j() {
        this.f43518G = true;
        this.f43517F = this.f43516E;
        this.f43516E = 0L;
    }

    /* renamed from: g */
    public void m55037g() {
        VelocityTracker velocityTracker = this.f43540l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        Log.d(f43499S, "getSpeedTracker is null");
        this.f43540l = VelocityTracker.obtain();
    }

    /* renamed from: c */
    private RecyclerView.AbstractC0833c0 m55006c(MotionEvent motionEvent) {
        int i10 = this.f43535g;
        if (i10 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i10);
        float x10 = motionEvent.getX(iFindPointerIndex) - this.f43531c;
        float y10 = motionEvent.getY(iFindPointerIndex) - this.f43532d;
        float fAbs = Math.abs(x10);
        float fAbs2 = Math.abs(y10);
        float f10 = this.f43551w;
        if (fAbs < f10 && fAbs2 < f10) {
            return null;
        }
        RecyclerView.AbstractC0846p layoutManager = this.f43539k.getLayoutManager();
        if (fAbs > fAbs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if (fAbs2 > fAbs && layoutManager.canScrollVertically()) {
            return null;
        }
        Log.d(f43499S, "do noting");
        View viewM55033b = m55033b(motionEvent);
        if (viewM55033b == null) {
            return null;
        }
        return this.f43539k.getChildViewHolder(viewM55033b);
    }

    /* renamed from: d */
    private void m55010d() {
        this.f43539k.removeItemDecoration(this);
        Object obj = this.f43525N;
        if (obj instanceof View.OnUnhandledKeyEventListener) {
            this.f43539k.removeOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener) obj);
        }
        this.f43539k.removeOnItemTouchListener(this.f43528Q);
        this.f43539k.removeOnChildAttachStateChangeListener(this);
        for (int size = this.f43538j.size() - 1; size >= 0; size--) {
            this.f43537i.clearView(this.f43539k, this.f43538j.get(0).f43583b);
        }
        this.f43538j.clear();
        this.f43541m = null;
        this.f43542n = -1;
        m55026m();
        m55018f();
    }

    /* renamed from: e */
    private void m55015e(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (i10 == 2) {
            if (abstractC0833c0 != null) {
                HwShadowEngine hwShadowEngine = new HwShadowEngine(abstractC0833c0.f4327a.getContext(), abstractC0833c0.f4327a, 1, 0);
                this.f43524M = hwShadowEngine;
                startDragSelectedAnimation(abstractC0833c0.f4327a, this.f43537i, hwShadowEngine);
                this.f43541m = abstractC0833c0.f4327a;
                m54980a();
                return;
            }
            throw new IllegalArgumentException("ViewHolder must be passed when dragging");
        }
    }

    /* renamed from: b */
    public void m55035b(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (!this.f43539k.isLayoutRequested() && this.f43550v == 2) {
            float moveThreshold = this.f43537i.getMoveThreshold(abstractC0833c0);
            int i10 = (int) (this.f43545q + this.f43533e);
            int i11 = (int) (this.f43546r + this.f43534f);
            if (Math.abs(i11 - abstractC0833c0.f4327a.getTop()) >= abstractC0833c0.f4327a.getHeight() * moveThreshold || Math.abs(i10 - abstractC0833c0.f4327a.getLeft()) >= abstractC0833c0.f4327a.getWidth() * moveThreshold) {
                List<RecyclerView.AbstractC0833c0> listM54978a = m54978a(abstractC0833c0);
                if (listM54978a.size() == 0) {
                    return;
                }
                scaleItemAccordingOverlapping(abstractC0833c0, listM54978a, this.f43537i, this.f43546r, this.f43534f);
                this.f43537i.f43562c = this.f43512A != null;
                this.f43537i.f43563d = this.f43522K;
                this.f43537i.f43564e = this.f43523L;
                RecyclerView.AbstractC0833c0 abstractC0833c0ChooseDropTarget = this.f43537i.chooseDropTarget(abstractC0833c0, listM54978a, i10, i11);
                if (abstractC0833c0ChooseDropTarget == null) {
                    this.f43552x.clear();
                    this.f43553y.clear();
                    return;
                }
                int iM5164k = abstractC0833c0ChooseDropTarget.m5164k();
                int iM5164k2 = abstractC0833c0.m5164k();
                if (this.f43537i.onMove(this.f43539k, abstractC0833c0, abstractC0833c0ChooseDropTarget)) {
                    this.f43537i.onMoved(this.f43539k, abstractC0833c0, iM5164k2, abstractC0833c0ChooseDropTarget, iM5164k, i10, i11);
                }
            }
        }
    }

    public class aauaf implements RecyclerView.InterfaceC0849s {
        public aauaf() {
        }

        /* renamed from: a */
        private void m55061a(MotionEvent motionEvent) {
            bfscp bfscpVarM55028a;
            HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
            if (hwItemTouchHelperEx.f43530b != null || (bfscpVarM55028a = hwItemTouchHelperEx.m55028a(motionEvent)) == null) {
                return;
            }
            HwItemTouchHelperEx hwItemTouchHelperEx2 = HwItemTouchHelperEx.this;
            hwItemTouchHelperEx2.f43531c -= bfscpVarM55028a.f43590i;
            hwItemTouchHelperEx2.f43532d -= bfscpVarM55028a.f43589h;
            hwItemTouchHelperEx2.m55031a(bfscpVarM55028a.f43583b, true);
            if (HwItemTouchHelperEx.this.f43529a.remove(bfscpVarM55028a.f43583b.f4327a)) {
                HwItemTouchHelperEx hwItemTouchHelperEx3 = HwItemTouchHelperEx.this;
                hwItemTouchHelperEx3.f43537i.clearView(hwItemTouchHelperEx3.f43539k, bfscpVarM55028a.f43583b);
            }
            HwItemTouchHelperEx.this.m55036d(bfscpVarM55028a.f43583b, bfscpVarM55028a.f43582a);
            HwItemTouchHelperEx hwItemTouchHelperEx4 = HwItemTouchHelperEx.this;
            hwItemTouchHelperEx4.m55030a(motionEvent, hwItemTouchHelperEx4.f43536h, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            if (HwItemTouchHelperEx.this.isMovingToDesignatedPos()) {
                return true;
            }
            if (!HwItemTouchHelperEx.this.f43520I) {
                HwItemTouchHelperEx.this.m55021h();
                HwItemTouchHelperEx.this.f43520I = true;
            }
            HwItemTouchHelperEx.this.f43543o.m60099a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                HwItemTouchHelperEx.this.f43535g = motionEvent.getPointerId(0);
                HwItemTouchHelperEx.this.f43531c = motionEvent.getX();
                HwItemTouchHelperEx.this.f43532d = motionEvent.getY();
                HwItemTouchHelperEx.this.m55037g();
                m55061a(motionEvent);
            } else if (actionMasked == 3 || actionMasked == 1) {
                HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
                hwItemTouchHelperEx.f43535g = -1;
                hwItemTouchHelperEx.m55036d((RecyclerView.AbstractC0833c0) null, 0);
            } else {
                int i10 = HwItemTouchHelperEx.this.f43535g;
                if (i10 != -1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                    if (iFindPointerIndex >= 0) {
                        HwItemTouchHelperEx.this.m55029a(actionMasked, motionEvent, iFindPointerIndex);
                    }
                } else {
                    Log.d(HwItemTouchHelperEx.f43499S, "The above conditions are not true.");
                }
            }
            if (HwItemTouchHelperEx.this.f43540l != null) {
                Log.d(HwItemTouchHelperEx.f43499S, "mVelocityTracker is not empty.");
                HwItemTouchHelperEx.this.f43540l.addMovement(motionEvent);
            }
            return HwItemTouchHelperEx.this.f43530b != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
        public void onRequestDisallowInterceptTouchEvent(boolean z10) {
            if (z10) {
                HwItemTouchHelperEx.this.m55036d((RecyclerView.AbstractC0833c0) null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            HwItemTouchHelperEx.this.f43543o.m60099a(motionEvent);
            if (HwItemTouchHelperEx.this.isMovingToDesignatedPos()) {
                return;
            }
            if (HwItemTouchHelperEx.this.f43540l != null) {
                Log.d(HwItemTouchHelperEx.f43499S, "mVelocityTracker is not empty.");
                HwItemTouchHelperEx.this.f43540l.addMovement(motionEvent);
            }
            if (HwItemTouchHelperEx.this.f43535g == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(HwItemTouchHelperEx.this.f43535g);
            if (iFindPointerIndex >= 0) {
                HwItemTouchHelperEx.this.m55029a(actionMasked, motionEvent, iFindPointerIndex);
            }
            RecyclerView.AbstractC0833c0 abstractC0833c0 = HwItemTouchHelperEx.this.f43530b;
            if (abstractC0833c0 == null) {
                return;
            }
            m55062a(motionEvent, actionMasked, iFindPointerIndex, abstractC0833c0);
        }

        /* renamed from: a */
        private void m55062a(MotionEvent motionEvent, int i10, int i11, RecyclerView.AbstractC0833c0 abstractC0833c0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    if (i11 >= 0) {
                        HwItemTouchHelperEx hwItemTouchHelperEx = HwItemTouchHelperEx.this;
                        hwItemTouchHelperEx.m55030a(motionEvent, hwItemTouchHelperEx.f43536h, i11);
                        HwItemTouchHelperEx.this.m55035b(abstractC0833c0);
                        HwItemTouchHelperEx hwItemTouchHelperEx2 = HwItemTouchHelperEx.this;
                        hwItemTouchHelperEx2.f43539k.removeCallbacks(hwItemTouchHelperEx2.f43544p);
                        HwItemTouchHelperEx.this.f43544p.run();
                        HwItemTouchHelperEx.this.f43539k.invalidate();
                        return;
                    }
                    return;
                }
                if (i10 != 3) {
                    if (i10 != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    HwItemTouchHelperEx hwItemTouchHelperEx3 = HwItemTouchHelperEx.this;
                    if (pointerId == hwItemTouchHelperEx3.f43535g) {
                        hwItemTouchHelperEx3.f43535g = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        HwItemTouchHelperEx hwItemTouchHelperEx4 = HwItemTouchHelperEx.this;
                        hwItemTouchHelperEx4.m55030a(motionEvent, hwItemTouchHelperEx4.f43536h, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker = HwItemTouchHelperEx.this.f43540l;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
            HwItemTouchHelperEx.this.m55036d((RecyclerView.AbstractC0833c0) null, 0);
            HwItemTouchHelperEx.this.f43535g = -1;
        }
    }

    /* renamed from: a */
    private static boolean m54992a(View view, float f10, float f11, float f12, float f13) {
        return f10 >= f12 && f10 <= f12 + ((float) view.getWidth()) && f11 >= f13 && f11 <= f13 + ((float) view.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m54993a(View view, KeyEvent keyEvent) {
        if (this.f43520I) {
            return false;
        }
        m55021h();
        this.f43520I = true;
        return false;
    }

    /* renamed from: a */
    private void m54988a(float[] fArr) {
        if ((this.f43536h & 12) != 0) {
            fArr[0] = (this.f43545q + this.f43533e) - this.f43530b.f4327a.getLeft();
        } else {
            fArr[0] = this.f43530b.f4327a.getTranslationX();
        }
        if ((this.f43536h & 3) != 0) {
            fArr[1] = (this.f43546r + this.f43534f) - this.f43530b.f4327a.getTop();
        } else {
            fArr[1] = this.f43530b.f4327a.getTranslationY();
        }
    }

    /* renamed from: c */
    private int m55004c(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (this.f43550v == 2) {
            return 0;
        }
        int movementFlags = this.f43537i.getMovementFlags(this.f43539k, abstractC0833c0);
        int iConvertToAbsoluteDirection = (this.f43537i.convertToAbsoluteDirection(movementFlags, C9603h0.m59832A(this.f43539k)) & f43504W) >> 8;
        if (iConvertToAbsoluteDirection == 0) {
            return 0;
        }
        int i10 = (movementFlags & f43504W) >> 8;
        if (Math.abs(this.f43533e) > Math.abs(this.f43534f)) {
            int iM54996b = m54996b(abstractC0833c0, iConvertToAbsoluteDirection);
            if (iM54996b > 0) {
                return (i10 & iM54996b) == 0 ? Callback.convertToRelativeDirection(iM54996b, C9603h0.m59832A(this.f43539k)) : iM54996b;
            }
            int iM55005c = m55005c(abstractC0833c0, iConvertToAbsoluteDirection);
            if (iM55005c > 0) {
                return iM55005c;
            }
        } else {
            int iM55005c2 = m55005c(abstractC0833c0, iConvertToAbsoluteDirection);
            if (iM55005c2 > 0) {
                return iM55005c2;
            }
            int iM54996b2 = m54996b(abstractC0833c0, iConvertToAbsoluteDirection);
            if (iM54996b2 > 0) {
                return (i10 & iM54996b2) == 0 ? Callback.convertToRelativeDirection(iM54996b2, C9603h0.m59832A(this.f43539k)) : iM54996b2;
            }
        }
        return 0;
    }

    /* renamed from: d */
    public void m55036d(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (abstractC0833c0 == this.f43530b && i10 == this.f43550v) {
            return;
        }
        ValueAnimator valueAnimator = this.f43512A;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            return;
        }
        this.f43527P = Long.MIN_VALUE;
        int i11 = this.f43550v;
        m55031a(abstractC0833c0, true);
        this.f43550v = i10;
        m55015e(abstractC0833c0, i10);
        boolean zM54989a = m54989a(i11, false);
        int i12 = (1 << ((i10 * 8) + 8)) - 1;
        if (abstractC0833c0 != null) {
            Log.d(f43499S, "selected is not empty.");
            this.f43536h = (i12 & this.f43537i.m55056a(this.f43539k, abstractC0833c0)) >> (this.f43550v * 8);
            this.f43545q = abstractC0833c0.f4327a.getLeft();
            this.f43546r = abstractC0833c0.f4327a.getTop();
            this.f43530b = abstractC0833c0;
            if (i10 == 2 && !this.f43515D) {
                abstractC0833c0.f4327a.performHapticFeedback(0);
            }
        }
        ViewParent parent = this.f43539k.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.f43530b != null);
        }
        if (!zM54989a) {
            this.f43539k.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        this.f43537i.onSelectedChanged(this.f43530b, this.f43550v);
        this.f43539k.invalidate();
    }

    /* renamed from: a */
    private boolean m54989a(int i10, boolean z10) {
        float fSignum;
        RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f43530b;
        if (abstractC0833c0 != null) {
            if (abstractC0833c0.f4327a.getParent() != null) {
                int iM55004c = i10 == 2 ? 0 : m55004c(abstractC0833c0);
                m55026m();
                float fSignum2 = 0.0f;
                if (iM55004c == 1 || iM55004c == 2) {
                    fSignum = Math.signum(this.f43534f) * this.f43539k.getHeight();
                } else if (iM55004c == 4 || iM55004c == 8 || iM55004c == 16 || iM55004c == 32) {
                    fSignum = 0.0f;
                    fSignum2 = Math.signum(this.f43533e) * this.f43539k.getWidth();
                } else {
                    fSignum = 0.0f;
                }
                int iM54972a = m54972a(i10, iM55004c);
                m54988a(this.f43547s);
                bfscp bfscpVarM54977a = m54977a(i10, fSignum2, fSignum, iM54972a);
                bfscpVarM54977a.m55071a(this.f43516E + 150);
                if (i10 == 2) {
                    bfscpVarM54977a.m55066a(true);
                }
                this.f43538j.add(bfscpVarM54977a);
                bfscpVarM54977a.m55073c();
                z10 = true;
            } else {
                m55034b(abstractC0833c0.f4327a);
                this.f43537i.clearView(this.f43539k, abstractC0833c0);
            }
            this.f43530b = null;
        }
        return z10;
    }

    /* renamed from: b */
    public View m55033b(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f43530b;
        if (abstractC0833c0 != null) {
            View view = abstractC0833c0.f4327a;
            if (m54992a(view, x10, y10, this.f43545q + this.f43533e, this.f43546r + this.f43534f)) {
                return view;
            }
        }
        for (int size = this.f43538j.size() - 1; size > 0; size--) {
            bfscp bfscpVar = this.f43538j.get(size);
            View view2 = bfscpVar.f43583b.f4327a;
            if (m54992a(view2, x10, y10, bfscpVar.f43590i, bfscpVar.f43589h)) {
                return view2;
            }
        }
        return this.f43539k.findChildViewUnder(x10, y10);
    }

    /* renamed from: c */
    private int m55005c(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if ((i10 & 3) == 0) {
            return 0;
        }
        int i11 = this.f43534f > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f43540l;
        if (velocityTracker != null && this.f43535g > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f43537i.getSwipeVelocityThreshold(this.f43549u));
            float xVelocity = this.f43540l.getXVelocity(this.f43535g);
            float yVelocity = this.f43540l.getYVelocity(this.f43535g);
            int i12 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i12 & i10) != 0 && i12 == i11 && fAbs >= this.f43537i.getSwipeEscapeVelocity(this.f43548t) && fAbs > Math.abs(xVelocity)) {
                return i12;
            }
        }
        float height = this.f43539k.getHeight() * this.f43537i.getSwipeThreshold(abstractC0833c0);
        if ((i10 & i11) == 0 || Math.abs(this.f43534f) <= height) {
            return 0;
        }
        return i11;
    }

    /* renamed from: b */
    private int m54996b(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if ((i10 & 12) == 0) {
            return 0;
        }
        int i11 = ((int) this.f43533e) > 0 ? 8 : 4;
        VelocityTracker velocityTracker = this.f43540l;
        if (velocityTracker != null && this.f43535g > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f43537i.getSwipeVelocityThreshold(this.f43549u));
            float xVelocity = this.f43540l.getXVelocity(this.f43535g);
            float yVelocity = this.f43540l.getYVelocity(this.f43535g);
            int i12 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i12 & i10) != 0 && i11 == i12 && fAbs >= this.f43537i.getSwipeEscapeVelocity(this.f43548t) && fAbs > Math.abs(yVelocity)) {
                return i12;
            }
        }
        float width = this.f43539k.getWidth() * this.f43537i.getSwipeThreshold(abstractC0833c0);
        if ((i10 & i11) == 0 || Math.abs(this.f43533e) <= width) {
            return 0;
        }
        return i11;
    }

    /* renamed from: a */
    private bfscp m54977a(int i10, float f10, float f11, int i11) {
        RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f43530b;
        float[] fArr = this.f43547s;
        return new bqmxo(abstractC0833c0, i11, i10, fArr[0], fArr[1], f10, f11, i10 == 2 ? 0 : m55004c(abstractC0833c0), abstractC0833c0);
    }

    /* renamed from: a */
    public void m55032a(bfscp bfscpVar, int i10) {
        this.f43539k.post(new akxao(bfscpVar, i10));
    }

    /* renamed from: a */
    private boolean m54990a(long j10, long j11, int i10, int i11) {
        if (i10 != 0) {
            i10 = this.f43537i.interpolateOutOfBoundsScroll(this.f43539k, this.f43530b.f4327a.getWidth(), i10, this.f43539k.getWidth(), j11);
        }
        if (i11 != 0) {
            i11 = this.f43537i.interpolateOutOfBoundsScroll(this.f43539k, this.f43530b.f4327a.getHeight(), i11, this.f43539k.getHeight(), j11);
        }
        if (i10 == 0 && i11 == 0) {
            this.f43527P = Long.MIN_VALUE;
            return false;
        }
        if (this.f43527P == Long.MIN_VALUE) {
            this.f43527P = j10;
        }
        this.f43539k.scrollBy(i10, i11);
        return true;
    }

    /* renamed from: c */
    private void m55007c() {
        this.f43518G = false;
        this.f43516E = this.f43517F;
    }

    /* renamed from: b */
    private void m54998b() {
        this.f43554z = new avpbg();
    }

    /* renamed from: b */
    public void m55034b(View view) {
        if (view == this.f43541m) {
            this.f43541m = null;
            Callback callback = this.f43537i;
            if (callback != null) {
                callback.updateSelectedScale(1.0f);
            }
            if (this.f43554z != null) {
                this.f43539k.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<RecyclerView.AbstractC0833c0> m54978a(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        List<RecyclerView.AbstractC0833c0> list = this.f43552x;
        if (list == null) {
            this.f43552x = new ArrayList();
            this.f43553y = new ArrayList();
        } else {
            list.clear();
            this.f43553y.clear();
        }
        int boundingBoxMargin = this.f43537i.getBoundingBoxMargin();
        int iRound = Math.round(this.f43545q + this.f43533e) - boundingBoxMargin;
        int iRound2 = Math.round(this.f43546r + this.f43534f) - boundingBoxMargin;
        int i10 = boundingBoxMargin * 2;
        int width = abstractC0833c0.f4327a.getWidth() + iRound + i10;
        int height = abstractC0833c0.f4327a.getHeight() + iRound2 + i10;
        int i11 = (iRound + width) / 2;
        int i12 = (iRound2 + height) / 2;
        RecyclerView.AbstractC0846p layoutManager = this.f43539k.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = layoutManager.getChildAt(i13);
            if (childAt != abstractC0833c0.f4327a) {
                if (childAt.getBottom() >= iRound2 && childAt.getTop() <= height && childAt.getRight() >= iRound && childAt.getLeft() <= width) {
                    m54981a(i11, i12, childAt);
                } else {
                    childAt.setScaleX(1.0f);
                    childAt.setScaleY(1.0f);
                }
            }
        }
        return this.f43552x;
    }

    /* renamed from: b */
    private void m54999b(int i10, int i11) {
        this.f43531c = 0.0f;
        this.f43532d = 0.0f;
        this.f43533e = 0.0f;
        this.f43534f = 0.0f;
        m55036d(this.f43513B, 2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, m54970a(this.f43539k.findViewHolderForAdapterPosition(i11), i11, i10));
        this.f43512A = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
    }

    /* renamed from: a */
    private void m54981a(int i10, int i11, View view) {
        RecyclerView.AbstractC0833c0 childViewHolder = this.f43539k.getChildViewHolder(view);
        if (this.f43537i.canDropOver(this.f43539k, this.f43530b, childViewHolder)) {
            int iAbs = Math.abs(i10 - ((view.getLeft() + view.getRight()) / 2));
            int iAbs2 = Math.abs(i11 - ((view.getTop() + view.getBottom()) / 2));
            int i12 = (iAbs * iAbs) + (iAbs2 * iAbs2);
            int size = this.f43552x.size();
            int i13 = 0;
            for (int i14 = 0; i14 < size && i12 > this.f43553y.get(i14).intValue(); i14++) {
                i13++;
            }
            this.f43552x.add(i13, childViewHolder);
            this.f43553y.add(i13, Integer.valueOf(i12));
        }
    }

    /* renamed from: a */
    public void m55031a(RecyclerView.AbstractC0833c0 abstractC0833c0, boolean z10) {
        for (int size = this.f43538j.size() - 1; size >= 0; size--) {
            bfscp bfscpVar = this.f43538j.get(size);
            if (bfscpVar.f43583b == abstractC0833c0) {
                bfscpVar.f43593l |= z10;
                if (!bfscpVar.f43592k) {
                    bfscpVar.m55070a();
                }
                this.f43538j.remove(size);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m55029a(int i10, MotionEvent motionEvent, int i11) {
        RecyclerView.AbstractC0833c0 abstractC0833c0M55006c;
        int iM55056a;
        if (this.f43530b != null || i10 != 2 || this.f43550v == 2 || !this.f43537i.isItemViewSwipeEnabled() || this.f43539k.getScrollState() == 1 || (abstractC0833c0M55006c = m55006c(motionEvent)) == null || (iM55056a = (this.f43537i.m55056a(this.f43539k, abstractC0833c0M55006c) & f43504W) >> 8) == 0) {
            return;
        }
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f43531c;
        float f11 = y10 - this.f43532d;
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        float f12 = this.f43551w;
        if (fAbs >= f12 || fAbs2 >= f12) {
            if (fAbs > fAbs2) {
                if (f10 < 0.0f && (iM55056a & 4) == 0) {
                    return;
                }
                if (f10 > 0.0f && (iM55056a & 8) == 0) {
                    return;
                }
            } else {
                if (f11 < 0.0f && (iM55056a & 1) == 0) {
                    return;
                }
                if (f11 > 0.0f && (iM55056a & 2) == 0) {
                    return;
                }
            }
            this.f43534f = 0.0f;
            this.f43533e = 0.0f;
            this.f43535g = motionEvent.getPointerId(0);
            m55036d(abstractC0833c0M55006c, 1);
        }
    }

    /* renamed from: a */
    public bfscp m55028a(MotionEvent motionEvent) {
        if (this.f43538j.isEmpty()) {
            return null;
        }
        View viewM55033b = m55033b(motionEvent);
        for (int size = this.f43538j.size() - 1; size > 0; size--) {
            bfscp bfscpVar = this.f43538j.get(size);
            if (bfscpVar.f43583b.f4327a == viewM55033b) {
                return bfscpVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m55030a(MotionEvent motionEvent, int i10, int i11) {
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f43531c;
        this.f43533e = f10;
        this.f43534f = y10 - this.f43532d;
        if ((i10 & 4) == 0) {
            this.f43533e = Math.max(0.0f, f10);
        }
        if ((i10 & 8) == 0) {
            this.f43533e = Math.min(0.0f, this.f43533e);
        }
        if ((i10 & 1) == 0) {
            this.f43534f = Math.max(0.0f, this.f43534f);
        }
        if ((i10 & 2) == 0) {
            this.f43534f = Math.min(0.0f, this.f43534f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54983a(MotionEvent motionEvent, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        int pointerId = motionEvent.getPointerId(0);
        int i10 = this.f43535g;
        if (pointerId == i10) {
            int iFindPointerIndex = motionEvent.findPointerIndex(i10);
            float x10 = motionEvent.getX(iFindPointerIndex);
            float y10 = motionEvent.getY(iFindPointerIndex);
            this.f43531c = x10;
            this.f43532d = y10;
            this.f43534f = 0.0f;
            this.f43533e = 0.0f;
            if (this.f43537i.isLongPressDragEnabled()) {
                m55036d(abstractC0833c0, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m54982a(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            m54984a(this.f43513B, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: a */
    private int m54973a(HwLinearLayoutManager hwLinearLayoutManager) {
        int height;
        int childCount = hwLinearLayoutManager.getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            if (hwLinearLayoutManager.getChildAt(i11) != null && (height = hwLinearLayoutManager.getChildAt(i11).getHeight()) > i10) {
                i10 = height;
            }
        }
        return i10;
    }

    /* renamed from: a */
    private AnimatorListenerAdapter m54975a(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, HwLinearLayoutManager hwLinearLayoutManager) {
        return new blfhz(abstractC0833c0, i10, hwLinearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54985a(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        int iM5164k = this.f43513B.m5164k();
        if (abstractC0833c0 != null && iM5164k != i10) {
            this.f43539k.post(new brnby(iM5164k, i10));
        }
        this.f43515D = false;
        this.f43519H = false;
        this.f43524M.setShadowEnabled(false);
        m55007c();
    }

    /* renamed from: a */
    private float m54970a(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11) {
        int bottom;
        int top;
        int top2;
        int bottom2;
        int i12;
        if (this.f43539k.getLayoutManager() instanceof HwLinearLayoutManager) {
            HwLinearLayoutManager hwLinearLayoutManager = (HwLinearLayoutManager) this.f43539k.getLayoutManager();
            int iFindFirstVisibleItemPosition = hwLinearLayoutManager.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = hwLinearLayoutManager.findLastVisibleItemPosition();
            if (abstractC0833c0 == null || i10 < iFindFirstVisibleItemPosition || i10 > iFindLastVisibleItemPosition) {
                m55025j();
                if (i11 > i10) {
                    top2 = this.f43539k.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition).f4327a.getTop();
                    bottom2 = this.f43513B.f4327a.getBottom();
                    i12 = (top2 - bottom2) - 1;
                } else {
                    RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition = this.f43539k.findViewHolderForAdapterPosition(hwLinearLayoutManager.findLastVisibleItemPosition());
                    if (abstractC0833c0FindViewHolderForAdapterPosition == null) {
                        return 0.0f;
                    }
                    bottom = abstractC0833c0FindViewHolderForAdapterPosition.f4327a.getBottom();
                    top = this.f43513B.f4327a.getTop();
                    i12 = (bottom - top) + 1;
                }
            } else if (i11 > i10) {
                top2 = abstractC0833c0.f4327a.getTop();
                bottom2 = this.f43513B.f4327a.getTop();
                i12 = (top2 - bottom2) - 1;
            } else {
                bottom = abstractC0833c0.f4327a.getBottom();
                top = this.f43513B.f4327a.getBottom();
                i12 = (bottom - top) + 1;
            }
            return i12;
        }
        Log.e(f43499S, "Invalid layout manager!");
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m54991a(View view) {
        RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f43530b;
        if (abstractC0833c0 != null && abstractC0833c0.f4327a == view) {
            return false;
        }
        if (this.f43538j.isEmpty()) {
            return true;
        }
        for (int size = this.f43538j.size() - 1; size >= 0; size--) {
            if (this.f43538j.get(size).f43583b.f4327a == view) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m54984a(RecyclerView.AbstractC0833c0 abstractC0833c0, float f10) {
        if (abstractC0833c0 == null) {
            return;
        }
        this.f43534f = f10;
        m55035b(abstractC0833c0);
        this.f43539k.invalidate();
    }
}
