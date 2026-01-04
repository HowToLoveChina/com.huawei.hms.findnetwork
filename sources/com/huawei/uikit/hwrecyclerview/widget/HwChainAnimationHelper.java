package com.huawei.uikit.hwrecyclerview.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.OverScroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.animation.physical2.AbstractC4558g;
import com.huawei.animation.physical2.AbstractC4561j;
import com.huawei.animation.physical2.C4552a;
import com.huawei.animation.physical2.C4554c;
import com.huawei.animation.physical2.C4555d;
import com.huawei.animation.physical2.ChoreographerFrameCallbackC4556e;

/* loaded from: classes4.dex */
public class HwChainAnimationHelper extends HwChainAnimationListener implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: A */
    private static final float f43346A = 0.0f;

    /* renamed from: B */
    private static final float f43347B = -3.0f;

    /* renamed from: C */
    private static final float f43348C = 600.0f;

    /* renamed from: D */
    private static final float f43349D = 30.0f;

    /* renamed from: E */
    private static final float f43350E = 4.0f;

    /* renamed from: F */
    private static final int f43351F = 1800;

    /* renamed from: G */
    private static final float f43352G = 1.848f;

    /* renamed from: H */
    private static final float f43353H = -1.0f;

    /* renamed from: I */
    private static final float f43354I = 200.0f;

    /* renamed from: J */
    private static final int f43355J = 0;

    /* renamed from: K */
    private static final float f43356K = 0.2f;

    /* renamed from: L */
    private static final int f43357L = 0;

    /* renamed from: M */
    private static final int f43358M = 1;

    /* renamed from: N */
    private static final int f43359N = 2;

    /* renamed from: O */
    private static final int f43360O = 0;

    /* renamed from: P */
    private static final int f43361P = 1;

    /* renamed from: Q */
    private static final int f43362Q = -1;

    /* renamed from: w */
    private static final String f43363w = "HwChainHelper";

    /* renamed from: x */
    private static final int f43364x = 2;

    /* renamed from: y */
    private static final int f43365y = 101;

    /* renamed from: z */
    private static final int f43366z = 20;

    /* renamed from: a */
    private HwRecyclerView f43367a;

    /* renamed from: b */
    private RecyclerView.AbstractC0846p f43368b;

    /* renamed from: c */
    private boolean f43369c;

    /* renamed from: h */
    private C4555d f43374h;

    /* renamed from: n */
    private C4552a f43380n;

    /* renamed from: o */
    private ChoreographerFrameCallbackC4556e f43381o;

    /* renamed from: r */
    private int f43384r;

    /* renamed from: s */
    private int f43385s;

    /* renamed from: d */
    private int f43370d = -1;

    /* renamed from: e */
    private int f43371e = -1;

    /* renamed from: f */
    private boolean f43372f = true;

    /* renamed from: g */
    private int f43373g = 0;

    /* renamed from: i */
    private float f43375i = 0.0f;

    /* renamed from: j */
    private float f43376j = f43347B;

    /* renamed from: k */
    private float f43377k = f43348C;

    /* renamed from: l */
    private float f43378l = 30.0f;

    /* renamed from: m */
    private float f43379m = f43350E;

    /* renamed from: p */
    private SparseArray<Float> f43382p = new SparseArray<>();

    /* renamed from: q */
    private SparseArray<Float> f43383q = new SparseArray<>();

    /* renamed from: t */
    private float f43386t = 0.0f;

    /* renamed from: u */
    private int f43387u = 0;

    /* renamed from: v */
    private boolean f43388v = false;

    public class bzrwd extends AbstractC4558g {
        public bzrwd(int i10) {
            super(i10);
        }

        @Override // com.huawei.animation.physical2.AbstractC4561j
        public void onUpdate(float f10, float f11) {
            if (HwChainAnimationHelper.this.f43372f) {
                HwChainAnimationHelper.this.f43367a.invalidate();
                HwChainAnimationHelper.this.f43372f = false;
            }
            HwChainAnimationHelper.this.f43382p.put(getIndex() - HwChainAnimationHelper.this.f43374h.m27982h(), Float.valueOf(f10));
        }
    }

    public HwChainAnimationHelper(int i10, int i11) {
        int i12 = i10 - i11;
        this.f43384r = i12;
        this.f43385s = i12 * 2;
    }

    /* renamed from: e */
    private float m54900e() {
        boolean z10 = this.f43369c;
        HwRecyclerView hwRecyclerView = this.f43367a;
        return z10 ? hwRecyclerView.getTranslationY() : hwRecyclerView.getTranslationX();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54901f() {
        /*
            r4 = this;
            int r0 = r4.m54894c()
            if (r0 > 0) goto L7
            goto L25
        L7:
            boolean r1 = r4.f43369c
            if (r1 == 0) goto L12
            androidx.recyclerview.widget.RecyclerView$p r1 = r4.f43368b
            int r1 = r1.getHeight()
            goto L18
        L12:
            androidx.recyclerview.widget.RecyclerView$p r1 = r4.f43368b
            int r1 = r1.getWidth()
        L18:
            float r1 = (float) r1
            float r0 = (float) r0
            float r1 = r1 / r0
            double r0 = (double) r1
            double r0 = java.lang.Math.ceil(r0)
            int r0 = (int) r0
            int r0 = r0 * 2
            if (r0 != 0) goto L27
        L25:
            r0 = 20
        L27:
            com.huawei.animation.physical2.c r1 = new com.huawei.animation.physical2.c
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.<init>(r2)
            r2 = 1800(0x708, float:2.522E-42)
            r3 = 1072466756(0x3fec8b44, float:1.848)
            com.huawei.animation.physical2.a r0 = com.huawei.animation.physical2.C4552a.m27972a(r0, r2, r3, r1)
            r4.f43380n = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationHelper.m54901f():void");
    }

    /* renamed from: g */
    private boolean m54902g() {
        boolean z10 = this.f43369c;
        HwRecyclerView hwRecyclerView = this.f43367a;
        return !z10 ? hwRecyclerView.getTranslationX() <= 0.0f : hwRecyclerView.getTranslationY() <= 0.0f;
    }

    /* renamed from: h */
    private void m54903h() {
        if (isOverScrolled()) {
            this.f43371e = this.f43370d;
            boolean zM54902g = m54902g();
            View viewM54880a = m54880a(zM54902g);
            int position = viewM54880a == null ? this.f43370d : this.f43368b.getPosition(viewM54880a);
            this.f43370d = position;
            if (this.f43387u != 2) {
                if (this.f43371e != position) {
                    relocate();
                }
            } else {
                m54882a(this.f43383q.get(0, Float.valueOf(m54900e())).floatValue());
                m54893b(zM54902g);
                m54904i();
                this.f43387u = 1;
            }
        }
    }

    /* renamed from: i */
    private void m54904i() {
        this.f43383q.clear();
        this.f43386t = 0.0f;
    }

    /* renamed from: j */
    private void m54905j() {
        int childCount = this.f43368b.getChildCount();
        if (this.f43382p.size() <= 0) {
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.f43368b.getChildAt(i10);
            if (childAt != null) {
                int position = this.f43368b.getPosition(childAt) - this.f43370d;
                m54886a(childAt, (this.f43382p.indexOfKey(position) < 0 ? -this.f43373g : this.f43382p.get(position).floatValue()) + this.f43373g);
            }
        }
    }

    public void attachToRecyclerView(HwRecyclerView hwRecyclerView, LinearLayoutManager linearLayoutManager) {
        this.f43367a = hwRecyclerView;
        this.f43368b = linearLayoutManager;
        this.f43369c = hwRecyclerView.isLayoutVertical();
        this.f43367a.setChainAnimationListener(this);
        this.f43367a.setChainAnimationEnabled(true);
        if (this.f43367a.isAttachedToWindow()) {
            this.f43367a.getViewTreeObserver().addOnPreDrawListener(this);
            this.f43367a.addOnScrollListener(this);
        }
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationListener
    public void dispatchGenericMotionEvent(MotionEvent motionEvent) {
        this.f43388v = motionEvent != null && motionEvent.getAction() == 8;
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationListener
    public void dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.w(f43363w, "dispatchTouchEvent: event is null.");
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            m54885a(motionEvent);
        } else if (action == 1 || action == 3) {
            m54903h();
        }
    }

    public View findChildViewUnderWithDecoration(float f10, float f11) {
        int childCount = this.f43368b.getChildCount();
        float height = this.f43368b.getHeight();
        int i10 = 0;
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt = this.f43368b.getChildAt(i11);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    float translationX = childAt.getTranslationX();
                    float translationY = childAt.getTranslationY();
                    float decoratedLeft = (this.f43368b.getDecoratedLeft(childAt) + translationX) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    float decoratedRight = this.f43368b.getDecoratedRight(childAt) + translationX + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    float decoratedTop = (this.f43368b.getDecoratedTop(childAt) + translationY) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                    float decoratedBottom = this.f43368b.getDecoratedBottom(childAt) + translationY + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                    if (f10 >= decoratedLeft && f10 <= decoratedRight && f11 >= decoratedTop && f11 <= decoratedBottom) {
                        return childAt;
                    }
                    if (this.f43369c) {
                        float f12 = (((int) (decoratedBottom + decoratedTop)) / 2) - f11;
                        if (height > Math.abs(f12)) {
                            height = Math.abs(f12);
                            i10 = i11;
                        }
                    } else {
                        float f13 = (((int) (decoratedLeft + decoratedRight)) / 2) - f10;
                        if (height > Math.abs(f13)) {
                            height = Math.abs(f13);
                            i10 = i11;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return this.f43368b.getChildAt(i10);
    }

    public float getDamping() {
        return this.f43378l;
    }

    public float getDampingTransfer() {
        return this.f43376j;
    }

    public float getFrameDelta() {
        return this.f43379m;
    }

    public int getSpaceUpperLimit() {
        return this.f43385s;
    }

    public float getStiffness() {
        return this.f43377k;
    }

    public float getStiffnessTransfer() {
        return this.f43375i;
    }

    public void initChain() {
        if (this.f43381o == null) {
            this.f43382p.clear();
            int iM54897d = m54897d();
            Log.i(f43363w, "init SpringChain: nodes:" + iM54897d);
            m54896c(iM54897d);
        }
        if (this.f43380n == null) {
            this.f43383q.clear();
            m54901f();
        }
    }

    public boolean isBeingDragged() {
        HwRecyclerView hwRecyclerView = this.f43367a;
        return hwRecyclerView != null && hwRecyclerView.m55308k();
    }

    public boolean isNeedRelocate() {
        return true;
    }

    public boolean isOverScrolled() {
        boolean z10 = this.f43369c;
        HwRecyclerView hwRecyclerView = this.f43367a;
        return !z10 ? hwRecyclerView.getTranslationX() == 0.0f : hwRecyclerView.getTranslationY() == 0.0f;
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationListener
    public void onAttachedToWindow() {
        this.f43367a.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationListener
    public void onDetachedFromWindow() {
        this.f43367a.getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationListener
    public void onOverScroll(float f10, float f11) {
        HwRecyclerView hwRecyclerView = this.f43367a;
        if (hwRecyclerView == null || hwRecyclerView.isChainAnimationEnabled()) {
            if (this.f43388v) {
                this.f43388v = false;
                return;
            }
            if (this.f43381o == null || this.f43380n == null) {
                Log.w(f43363w, "onOverScroll: mSpringChain or mCurveChain is null");
                initChain();
            }
            int i10 = this.f43387u;
            if (i10 != 2) {
                if (i10 == 1) {
                    m54891b();
                }
                m54904i();
            }
            this.f43387u = 2;
            m54883a(f10, f11);
        }
    }

    public boolean onPreDraw() {
        initChain();
        if ((isOverScrolled() && this.f43367a.m55308k()) || !this.f43367a.isChainAnimationEnabled()) {
            return true;
        }
        startSpringAnimation();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        super.onScrollStateChanged(recyclerView, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
    public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        if (this.f43388v) {
            this.f43388v = false;
            return;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        if (this.f43381o == null) {
            Log.w(f43363w, "onScrolled: spring chain is null.");
            initChain();
        }
        int i12 = this.f43373g;
        if (this.f43369c) {
            i10 = i11;
        }
        this.f43373g = i12 + i10;
        this.f43381o.m28002o(-r2);
        this.f43387u = 1;
    }

    public void relocate() {
        this.f43382p.clear();
        this.f43372f = true;
        this.f43381o.m27992e(this.f43370d - this.f43371e);
        if (this.f43382p.indexOfKey(0) < 0) {
            Log.w(f43363w, "relocate: control node hasn't data.");
            return;
        }
        int iRound = Math.round(this.f43382p.get(0).floatValue());
        int i10 = this.f43373g + iRound;
        if (i10 != 0) {
            if (!isOverScrolled()) {
                if (this.f43369c) {
                    this.f43367a.scrollBy(0, -i10);
                    return;
                } else {
                    this.f43367a.scrollBy(-i10, 0);
                    return;
                }
            }
            float fM54900e = i10 + m54900e();
            this.f43373g = -iRound;
            if (m54899d((int) fM54900e)) {
                fM54900e = 0.0f;
            }
            m54882a(fM54900e);
        }
    }

    public void setDamping(float f10) {
        this.f43378l = f10;
    }

    public void setDampingTransfer(float f10) {
        this.f43376j = f10;
    }

    public void setFrameDelta(float f10) {
        this.f43379m = f10;
    }

    public void setSpaceUpperLimit(int i10) {
        this.f43385s = i10;
    }

    public void setStiffness(float f10) {
        this.f43377k = f10;
    }

    public void setStiffnessTransfer(float f10) {
        this.f43375i = f10;
    }

    public void startSpringAnimation() {
        if (this.f43387u != 1) {
            return;
        }
        m54905j();
        this.f43372f = true;
    }

    /* renamed from: b */
    private void m54892b(int i10) {
        this.f43374h = new C4555d();
        for (int i11 = 0; i11 < i10; i11++) {
            this.f43374h.m27981g(m54881a(i11));
        }
    }

    /* renamed from: c */
    private void m54896c(int i10) {
        m54892b(i10);
        this.f43381o = new ChoreographerFrameCallbackC4556e(this.f43374h).m28001n(new C4554c(this.f43375i)).m27995h(new C4554c(this.f43376j)).m27994g(this.f43377k).m27993f(this.f43378l).m27998k(this.f43379m).m27996i(this.f43384r, this.f43385s).m28003p();
    }

    /* renamed from: d */
    private int m54897d() {
        int finalX;
        int width;
        OverScroller overScroller = new OverScroller(this.f43367a.getContext());
        if (this.f43369c) {
            overScroller.fling(0, 0, 0, this.f43367a.getMaxFlingVelocity(), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            overScroller.fling(0, 0, this.f43367a.getMaxFlingVelocity(), 0, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        overScroller.forceFinished(true);
        int childCount = this.f43368b.getChildCount();
        if (childCount == 0) {
            Log.w(f43363w, "getNodesNum: child count is 0.");
            return 101;
        }
        View childAt = this.f43368b.getChildAt(0);
        View childAt2 = this.f43368b.getChildAt(childCount - 1);
        if (childAt == null || childAt2 == null) {
            Log.w(f43363w, "getNodesNum: firstView or lastView is null.");
            return 101;
        }
        int iM54894c = m54894c();
        if (iM54894c <= 0 || iM54894c == this.f43368b.getHeight()) {
            return 101;
        }
        if (this.f43369c) {
            finalX = overScroller.getFinalY();
            width = this.f43368b.getHeight();
        } else {
            finalX = overScroller.getFinalX();
            width = this.f43368b.getWidth();
        }
        return ((((int) Math.ceil((finalX + width) / iM54894c)) + 1 + childCount) * 2) + 1;
    }

    /* renamed from: a */
    private AbstractC4558g m54881a(int i10) {
        bzrwd bzrwdVar = new bzrwd(i10);
        bzrwdVar.setFixMode(0);
        bzrwdVar.setValueAccuracy(0.2f);
        return bzrwdVar;
    }

    /* renamed from: b */
    private void m54893b(boolean z10) {
        int size = this.f43383q.size();
        int iM27982h = this.f43374h.m27982h();
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = z10 ? i10 : (this.f43370d - 1) - i10;
            int i12 = (iM27982h + i11) - this.f43370d;
            AbstractC4561j abstractC4561jMo27979c = this.f43374h.mo27979c(i12);
            if (abstractC4561jMo27979c instanceof AbstractC4558g) {
                AbstractC4558g abstractC4558g = (AbstractC4558g) abstractC4561jMo27979c;
                abstractC4558g.resetNode((abstractC4558g.getValue() + this.f43383q.valueAt(i10).floatValue()) - m54900e(), 0.0f);
            } else {
                Log.w(f43363w, "transferData: index = " + i11 + ", nodeIndex = " + i12 + ", isOverStartEdge = " + z10);
            }
        }
    }

    /* renamed from: a */
    private void m54885a(MotionEvent motionEvent) {
        this.f43387u = 0;
        View viewFindChildViewUnderWithDecoration = findChildViewUnderWithDecoration(motionEvent.getX(), motionEvent.getY());
        if (viewFindChildViewUnderWithDecoration == null) {
            Log.w(f43363w, "onTouchDown: control item is null.");
            this.f43370d = -1;
            return;
        }
        this.f43371e = this.f43370d;
        this.f43370d = this.f43367a.getChildLayoutPosition(viewFindChildViewUnderWithDecoration);
        if (this.f43381o == null || this.f43380n == null) {
            Log.w(f43363w, "onTouchDown: mSpringChain or mCurveChain is null:");
            initChain();
        }
        int i10 = this.f43371e;
        if (i10 != -1 && i10 != this.f43370d && this.f43381o.m27991d() && isNeedRelocate()) {
            relocate();
        }
        AbstractC4561j abstractC4561jM27990c = this.f43381o.m27990c();
        if (abstractC4561jM27990c != null) {
            abstractC4561jM27990c.cancel();
        }
    }

    /* renamed from: c */
    private int m54894c() {
        int height = this.f43368b.getHeight();
        for (int i10 = 0; i10 < this.f43368b.getChildCount(); i10++) {
            View childAt = this.f43368b.getChildAt(i10);
            if (childAt != null) {
                if (this.f43369c && childAt.getHeight() < height) {
                    height = childAt.getHeight();
                } else if (!this.f43369c && childAt.getWidth() < height) {
                    height = childAt.getWidth();
                }
            }
        }
        return height;
    }

    /* renamed from: b */
    private void m54891b() {
        this.f43381o.m27989b();
        this.f43373g = 0;
        int iMo27980d = this.f43374h.mo27980d();
        for (int i10 = 0; i10 < iMo27980d; i10++) {
            AbstractC4561j abstractC4561jMo27979c = this.f43374h.mo27979c(i10);
            if (abstractC4561jMo27979c != null) {
                abstractC4561jMo27979c.resetValue(0.0f);
            }
        }
        this.f43382p.clear();
    }

    /* renamed from: d */
    private boolean m54899d(int i10) {
        if (!this.f43369c) {
            return m54887a();
        }
        if (!this.f43367a.canScrollVertically(1) || i10 >= 0) {
            return this.f43367a.canScrollVertically(-1) && i10 > 0;
        }
        return true;
    }

    /* renamed from: a */
    private View m54880a(boolean z10) {
        if (z10) {
            return this.f43368b.getChildAt(0);
        }
        return this.f43368b.getChildAt(r0.getChildCount() - 1);
    }

    /* renamed from: a */
    private boolean m54887a() {
        if (this.f43367a.getLayoutDirection() == 1) {
            if (this.f43367a.canScrollHorizontally(-1) && this.f43367a.getTranslationX() > 0.0f) {
                return true;
            }
        } else if (this.f43367a.canScrollHorizontally(1) && this.f43367a.getTranslationX() < 0.0f) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m54883a(float f10, float f11) {
        boolean zM54902g = m54902g();
        int childCount = this.f43368b.getChildCount();
        int iM54879a = m54879a(zM54902g, childCount, this.f43370d);
        this.f43380n.m27974c(iM54879a);
        float fM54900e = m54900e();
        m54884a(iM54879a, fM54900e, f10, f11, 0);
        for (int i10 = iM54879a - 1; i10 >= 0; i10--) {
            m54884a(i10, fM54900e, f10, f11, 1);
        }
        while (true) {
            iM54879a++;
            if (iM54879a < childCount) {
                m54884a(iM54879a, fM54900e, f10, f11, -1);
            } else {
                this.f43386t = fM54900e;
                return;
            }
        }
    }

    /* renamed from: a */
    private int m54879a(boolean z10, int i10, int i11) {
        View childAt;
        return (z10 || (childAt = this.f43368b.getChildAt(i10 + (-1))) == null) ? i11 : this.f43367a.getChildLayoutPosition(childAt) - i11;
    }

    /* renamed from: a */
    private void m54884a(int i10, float f10, float f11, float f12, int i11) {
        View childAt = this.f43368b.getChildAt(m54902g() ? i10 : (this.f43368b.getChildCount() - 1) - i10);
        if (childAt == null) {
            return;
        }
        float fM54877a = m54877a(i10, f12, i11);
        float translationY = this.f43369c ? childAt.getTranslationY() : childAt.getTranslationX();
        float fM54878a = m54878a(i10, m54876a(f10, translationY, this.f43383q.get(i10, Float.valueOf(f10 + translationY)).floatValue() + (fM54877a * f11)), i11, m54902g());
        this.f43383q.put(i10, Float.valueOf(fM54878a));
        m54886a(childAt, fM54878a - f10);
    }

    /* renamed from: a */
    private float m54877a(int i10, float f10, int i11) {
        float fM27973b;
        try {
            return this.f43380n.m27973b(i10, f10);
        } catch (IllegalArgumentException unused) {
            try {
            } catch (IllegalArgumentException unused2) {
                Log.e(f43363w, "getCurrentRate: get rate from curve chain failed. index = " + i10 + ", rate = 1.0");
            }
            if (i11 != 1) {
                if (i11 == -1) {
                    fM27973b = this.f43380n.m27973b(i10 - 1, f10);
                }
                return 1.0f;
            }
            fM27973b = this.f43380n.m27973b(i10 + 1, f10);
            return fM27973b;
        }
    }

    /* renamed from: a */
    private float m54876a(float f10, float f11, float f12) {
        return (Float.compare(Math.abs(f10), f43354I) >= 0 || Math.abs(this.f43386t) <= Math.abs(f10)) ? f12 : ((f11 * f10) / this.f43386t) + f10;
    }

    /* renamed from: a */
    private float m54878a(int i10, float f10, int i11, boolean z10) {
        if (i11 == 1) {
            float fFloatValue = this.f43383q.get(i10 + 1, Float.valueOf(f10)).floatValue();
            if (z10) {
                return Math.min(fFloatValue + this.f43384r, f10);
            }
            return Math.max(fFloatValue - this.f43384r, f10);
        }
        if (i11 != -1) {
            return f10;
        }
        float fFloatValue2 = this.f43383q.get(i10 - 1, Float.valueOf(f10)).floatValue();
        if (z10) {
            return Math.max(fFloatValue2 - this.f43384r, f10);
        }
        return Math.min(fFloatValue2 + this.f43384r, f10);
    }

    /* renamed from: a */
    private void m54886a(View view, float f10) {
        if (this.f43369c) {
            view.setTranslationY(f10);
        } else {
            view.setTranslationX(f10);
        }
    }

    /* renamed from: a */
    private void m54882a(float f10) {
        if (this.f43369c) {
            this.f43367a.setTranslationY(f10);
        } else {
            this.f43367a.setTranslationX(f10);
        }
    }
}
