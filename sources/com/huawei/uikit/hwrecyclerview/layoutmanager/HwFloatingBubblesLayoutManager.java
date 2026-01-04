package com.huawei.uikit.hwrecyclerview.layoutmanager;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class HwFloatingBubblesLayoutManager extends LinearLayoutManager {

    /* renamed from: A */
    private static final long f43272A = 500;

    /* renamed from: B */
    private static final long f43273B = 200;

    /* renamed from: C */
    private static final int f43274C = 4;

    /* renamed from: D */
    private static final float f43275D = 0.5f;

    /* renamed from: E */
    private static final float f43276E = 0.5f;

    /* renamed from: F */
    private static final int[] f43277F = {1, 2, 0, 1, 0, 2};

    /* renamed from: G */
    private static final int f43278G = 1;

    /* renamed from: t */
    private static final String f43279t = "HwFloatingBubblesLayoutManager";

    /* renamed from: u */
    private static final float f43280u = 0.5f;

    /* renamed from: v */
    private static final int f43281v = 10;

    /* renamed from: w */
    private static final int f43282w = -1;

    /* renamed from: x */
    private static final float f43283x = 2.0f;

    /* renamed from: y */
    private static final float f43284y = 0.5f;

    /* renamed from: z */
    private static final float f43285z = 0.005f;

    /* renamed from: a */
    private final HwFloatingBubblesScrollFinishedCallback f43286a;

    /* renamed from: b */
    private final int f43287b;

    /* renamed from: c */
    private int f43288c;

    /* renamed from: d */
    private int f43289d;

    /* renamed from: e */
    private int f43290e;

    /* renamed from: f */
    private int f43291f;

    /* renamed from: g */
    private HwFloatingBubblesAnimatorParams f43292g;

    /* renamed from: h */
    private SparseArray<Rect> f43293h;

    /* renamed from: i */
    private int f43294i;

    /* renamed from: j */
    private HwLayoutFinishedCallback f43295j;

    /* renamed from: k */
    private int f43296k;

    /* renamed from: l */
    private int f43297l;

    /* renamed from: m */
    private int f43298m;

    /* renamed from: n */
    private int f43299n;

    /* renamed from: o */
    private SparseArray<aauaf> f43300o;

    /* renamed from: p */
    private int f43301p;

    /* renamed from: q */
    private int f43302q;

    /* renamed from: r */
    private ValueAnimator f43303r;

    /* renamed from: s */
    private int f43304s;

    public static abstract class HwFloatingBubblesScrollFinishedCallback {
        public abstract void onScrollByFinished(View view, RecyclerView recyclerView);
    }

    public static abstract class HwLayoutFinishedCallback {
        public abstract void onLayoutFinished(boolean z10);
    }

    public class aauaf {

        /* renamed from: a */
        int f43305a;

        /* renamed from: b */
        int f43306b;

        /* renamed from: c */
        int f43307c;

        /* renamed from: d */
        int f43308d;

        /* renamed from: e */
        float f43309e;

        public aauaf(int i10, int i11, int i12, int i13, float f10) {
            this.f43305a = i10;
            this.f43307c = i11;
            this.f43306b = i12;
            this.f43308d = i13;
            this.f43309e = f10;
        }
    }

    public static class bzrwd extends LinearSmoothScroller {

        /* renamed from: b */
        private static final int f43311b = 1000;

        /* renamed from: c */
        private static final float f43312c = 0.4f;

        /* renamed from: d */
        private static final float f43313d = 0.0f;

        /* renamed from: e */
        private static final float f43314e = 0.4f;

        /* renamed from: f */
        private static final float f43315f = 1.0f;

        /* renamed from: a */
        private HwCubicBezierInterpolator f43316a;

        public bzrwd(Context context) {
            super(context);
            this.f43316a = new HwCubicBezierInterpolator(0.4f, 0.0f, 0.4f, 1.0f);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i10, int i11, int i12, int i13, int i14) {
            return (int) ((i12 + ((i13 - i12) / 2.0f)) - (i10 + ((i11 - i10) / 2.0f)));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForDeceleration(int i10) {
            return 1000;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i10) {
            return 1000;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.AbstractC0855y
        public void onTargetFound(View view, RecyclerView.C0856z c0856z, RecyclerView.AbstractC0855y.a aVar) {
            int iCalculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
            int iCalculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((iCalculateDxToMakeVisible * iCalculateDxToMakeVisible) + (iCalculateDyToMakeVisible * iCalculateDyToMakeVisible)));
            if (iCalculateTimeForDeceleration > 0) {
                aVar.m5302d(-iCalculateDxToMakeVisible, -iCalculateDyToMakeVisible, iCalculateTimeForDeceleration, this.f43316a);
            }
        }
    }

    public HwFloatingBubblesLayoutManager(Context context, HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams) {
        this(context, hwFloatingBubblesAnimatorParams, null);
    }

    /* renamed from: a */
    private void m54813a(boolean z10, int i10, boolean z11) {
        if (getChildCount() == 0 || getHeight() == 0) {
            return;
        }
        boolean zM54817a = true;
        for (int i11 = 0; zM54817a && i11 < 10; i11++) {
            zM54817a = m54817a(z11, com.huawei.uikit.hwrecyclerview.layoutmanager.aauaf.m54847a(z10, i10, this, this.f43292g));
        }
    }

    /* renamed from: b */
    private void m54820b(RecyclerView.C0852v c0852v, int i10) {
        for (int i11 = this.f43294i; i11 < getItemCount(); i11++) {
            Rect rect = this.f43293h.get(i11);
            if (rect != null) {
                Rect rect2 = new Rect(rect.left, rect.top + i10, rect.right, rect.bottom + i10);
                if (Rect.intersects(m54805a(0), rect2)) {
                    m54814a(false, rect2, c0852v.m5285o(i11), i11);
                }
            }
        }
        m54813a(false, 0, true);
        m54829a(true);
    }

    /* renamed from: c */
    private void m54822c(RecyclerView.C0852v c0852v, int i10) {
        int itemCount = getItemCount();
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null) {
                int position = getPosition(childAt);
                if (position > i11) {
                    i11 = position;
                }
                if (position < itemCount) {
                    itemCount = position;
                }
            }
        }
        m54824d(c0852v, i10);
        Rect rectM54805a = m54805a(i10);
        if (i10 > 0) {
            for (int i13 = i11 + 1; i13 < getItemCount(); i13++) {
                m54811a(c0852v, rectM54805a, i13, false);
            }
            return;
        }
        for (int i14 = itemCount - 1; i14 >= 0; i14--) {
            m54811a(c0852v, rectM54805a, i14, true);
        }
    }

    /* renamed from: d */
    private void m54824d(RecyclerView.C0852v c0852v, int i10) {
        int position;
        ArrayList arrayList = new ArrayList();
        int itemCount = getItemCount();
        boolean zM54827g = m54827g();
        boolean zM54825e = m54825e();
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null) {
                float translationY = childAt.getTranslationY();
                if (i10 <= 0 || (getDecoratedBottom(childAt) - i10) + (translationY * 0.5f) >= 0.0f) {
                    if (i10 >= 0 || (getDecoratedTop(childAt) - i10) + (translationY * 0.5f) <= m54823d()) {
                        int position2 = getPosition(childAt);
                        if (position2 > i11) {
                            i11 = position2;
                        }
                        if (position2 < itemCount) {
                            itemCount = position2;
                        }
                    } else if (!zM54827g) {
                        arrayList.add(childAt);
                    }
                } else if (!zM54825e) {
                    arrayList.add(childAt);
                }
            }
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            View view = (View) arrayList.get(i12);
            if (view != null && ((position = getPosition(view)) < itemCount || position > i11)) {
                removeAndRecycleView(view, c0852v);
            }
        }
    }

    /* renamed from: e */
    private boolean m54825e() {
        Pair<Boolean, Integer> pairM54806a = m54806a();
        if (((Boolean) pairM54806a.first).booleanValue()) {
            return ((Integer) pairM54806a.second).intValue() <= ((int) (((float) getHeight()) * 0.5f));
        }
        return false;
    }

    /* renamed from: f */
    private boolean m54826f() {
        ValueAnimator valueAnimator = this.f43303r;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: g */
    private boolean m54827g() {
        Pair<Boolean, Integer> pairM54821c = m54821c();
        if (((Boolean) pairM54821c.first).booleanValue()) {
            return ((Integer) pairM54821c.second).intValue() >= ((int) (((float) getHeight()) * 0.5f));
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public final boolean canScrollHorizontally() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public final boolean canScrollVertically() {
        return true;
    }

    public boolean canVerticalScrollOnDirection(RecyclerView recyclerView, int i10) {
        if (getChildCount() == 0 || recyclerView.computeVerticalScrollRange() - recyclerView.computeVerticalScrollExtent() == 0) {
            return false;
        }
        return i10 > 0 ? this.f43291f + getHeight() < this.f43288c : this.f43291f > 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollExtent(RecyclerView.C0856z c0856z) {
        int top = this.f43288c;
        if (getChildCount() == 0) {
            return 0;
        }
        int bottom = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                if (childAt.getTop() < top) {
                    top = childAt.getTop();
                }
                if (childAt.getBottom() > bottom) {
                    bottom = childAt.getBottom();
                }
            }
        }
        return bottom - top;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollOffset(RecyclerView.C0856z c0856z) {
        if (getChildCount() == 0) {
            return 0;
        }
        return this.f43291f;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int computeVerticalScrollRange(RecyclerView.C0856z c0856z) {
        return (this.f43288c - getPaddingTop()) - getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int getPaddingBottom() {
        return super.getPaddingBottom() + m54818b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int getPaddingTop() {
        return super.getPaddingTop() + m54818b();
    }

    /* renamed from: h */
    public void m54830h() {
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                if (childAt.getTop() + this.f43291f < top) {
                    top = childAt.getTop() + this.f43291f;
                }
                if (childAt.getBottom() + this.f43291f > bottom) {
                    bottom = childAt.getBottom() + this.f43291f;
                }
            }
        }
        if (top == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE) {
            return;
        }
        if (this.f43291f + top < getPaddingTop()) {
            this.f43291f = getPaddingTop() - top;
        }
        if (getPaddingBottom() + bottom > this.f43289d) {
            this.f43288c = bottom + getPaddingBottom();
        } else {
            if (getPaddingBottom() + bottom >= this.f43289d || !((Boolean) m54806a().first).booleanValue()) {
                return;
            }
            this.f43288c = bottom + getPaddingBottom();
        }
    }

    public void offsetPosition(boolean z10, int i10) {
        m54813a(z10, i10, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onAdapterChanged(RecyclerView.AbstractC0838h abstractC0838h, RecyclerView.AbstractC0838h abstractC0838h2) {
        removeAllViews();
        this.f43293h.clear();
        this.f43291f = 0;
        this.f43288c = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onItemsChanged(RecyclerView recyclerView) {
        m54812a(recyclerView);
        super.onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(c0852v);
            return;
        }
        if (c0856z.m5305b() == 0 || c0856z.m5308e()) {
            return;
        }
        if (this.f43304s != 0 && getItemCount() != 1) {
            Log.w(f43279t, "Scroll state illegal.");
            return;
        }
        this.f43301p = getItemCount();
        detachAndScrapAttachedViews(c0852v);
        int i10 = 0;
        View viewM5285o = c0852v.m5285o(0);
        measureChildWithMargins(viewM5285o, 0, 0);
        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewM5285o);
        this.f43302q = getDecoratedMeasuredHeight(viewM5285o);
        m54819b(decoratedMeasuredWidth);
        if (this.f43293h.size() > 0) {
            Rect rect = this.f43293h.get(0);
            SparseArray<Rect> sparseArray = this.f43293h;
            Rect rect2 = sparseArray.get(sparseArray.size() - 1);
            if (rect == null || rect2 == null) {
                return;
            }
            int i11 = rect2.bottom - rect.top;
            int paddingTop = getPaddingTop();
            int paddingBottom = i11 + paddingTop + getPaddingBottom();
            m54807a(rect);
            if (this.f43300o.size() != 0) {
                m54810a(c0852v, paddingTop);
            } else {
                m54820b(c0852v, paddingTop);
            }
            i10 = paddingBottom;
        }
        int iMax = Math.max(m54823d(), i10);
        this.f43289d = iMax;
        this.f43288c = Math.max(iMax, this.f43288c);
        if (this.f43300o.size() != 0) {
            this.f43300o.clear();
        }
        m54830h();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutCompleted(RecyclerView.C0856z c0856z) {
        super.onLayoutCompleted(c0856z);
        HwLayoutFinishedCallback hwLayoutFinishedCallback = this.f43295j;
        if (hwLayoutFinishedCallback != null) {
            hwLayoutFinishedCallback.onLayoutFinished(true);
        }
    }

    public void onLocateChanged(RecyclerView recyclerView) {
        m54812a(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onScrollStateChanged(int i10) {
        super.onScrollStateChanged(i10);
        this.f43304s = i10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollVerticallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        if (getItemCount() != 0 && c0852v != null) {
            c0852v.m5273c();
            int i11 = this.f43291f;
            int i12 = i11 + i10;
            int i13 = this.f43290e;
            if (i12 < i13) {
                i10 = i13 - i11;
            } else if (i12 > this.f43288c - m54823d()) {
                i10 = (this.f43288c - m54823d()) - this.f43291f;
            }
            m54822c(c0852v, i10);
            this.f43291f += i10;
        }
        return i10;
    }

    public void setLayoutFinishedCallback(HwLayoutFinishedCallback hwLayoutFinishedCallback) {
        this.f43295j = hwLayoutFinishedCallback;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0856z c0856z, int i10) {
        bzrwd bzrwdVar = new bzrwd(recyclerView.getContext());
        bzrwdVar.setTargetPosition(i10);
        startSmoothScroll(bzrwdVar);
    }

    public HwFloatingBubblesLayoutManager(Context context, HwFloatingBubblesAnimatorParams hwFloatingBubblesAnimatorParams, HwFloatingBubblesScrollFinishedCallback hwFloatingBubblesScrollFinishedCallback) {
        super(context);
        this.f43290e = 0;
        this.f43293h = new SparseArray<>();
        this.f43294i = 0;
        this.f43300o = new SparseArray<>();
        this.f43301p = 0;
        this.f43302q = 0;
        this.f43304s = 0;
        this.f43286a = hwFloatingBubblesScrollFinishedCallback;
        this.f43292g = hwFloatingBubblesAnimatorParams;
        this.f43287b = m54803a(context, hwFloatingBubblesAnimatorParams.getMaxMargin());
    }

    /* renamed from: a */
    private boolean m54817a(boolean z10, int[][] iArr) {
        boolean z11 = false;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null) {
                if (z10 && (iArr[0][i10] != 0 || iArr[1][i10] != 0)) {
                    z11 = true;
                }
                childAt.offsetLeftAndRight(iArr[0][i10]);
                childAt.offsetTopAndBottom(iArr[1][i10]);
            }
        }
        return z11;
    }

    /* renamed from: b */
    private void m54819b(int i10) {
        boolean z10 = (this.f43297l == getWidth() && this.f43296k == getHeight()) ? false : true;
        boolean z11 = (this.f43298m == getPaddingLeft() && this.f43299n == getPaddingRight()) ? false : true;
        if (this.f43293h.size() == 0 || z10 || z11) {
            this.f43296k = getHeight();
            this.f43297l = getWidth();
            this.f43298m = getPaddingLeft();
            this.f43299n = getPaddingRight();
            this.f43293h.clear();
            List<com.huawei.uikit.hwrecyclerview.layoutmanager.bzrwd> listM54839a = com.huawei.uikit.hwrecyclerview.layoutmanager.aauaf.m54839a(getItemCount() - 1, (getWidth() - getPaddingLeft()) - getPaddingRight(), getHeight(), i10, this.f43287b);
            for (int i11 = 0; i11 < listM54839a.size(); i11++) {
                com.huawei.uikit.hwrecyclerview.layoutmanager.bzrwd bzrwdVar = listM54839a.get(i11);
                this.f43293h.put(i11, new Rect((bzrwdVar.m54850b() - bzrwdVar.m54848a()) + getPaddingLeft(), bzrwdVar.m54851c() - bzrwdVar.m54848a(), bzrwdVar.m54850b() + bzrwdVar.m54848a() + getPaddingLeft(), bzrwdVar.m54851c() + bzrwdVar.m54848a()));
            }
        }
    }

    /* renamed from: a */
    private void m54811a(RecyclerView.C0852v c0852v, Rect rect, int i10, boolean z10) {
        Rect rect2 = this.f43293h.get(i10);
        if (rect2 == null) {
            return;
        }
        int paddingTop = getPaddingTop();
        Rect rect3 = new Rect(rect2.left, rect2.top + paddingTop, rect2.right, rect2.bottom + paddingTop);
        if (Rect.intersects(rect, rect3)) {
            m54814a(z10, rect3, c0852v.m5285o(i10), -1);
        }
    }

    /* renamed from: c */
    private Pair<Boolean, Integer> m54821c() {
        boolean z10;
        int childCount = getChildCount();
        if (childCount == 0) {
            return new Pair<>(Boolean.TRUE, Integer.valueOf(getHeight()));
        }
        int decoratedBottom = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                z10 = false;
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt != null && getPosition(childAt) == 0) {
                decoratedBottom = getDecoratedBottom(childAt);
                z10 = true;
                break;
            }
            i10++;
        }
        return new Pair<>(Boolean.valueOf(z10), Integer.valueOf(decoratedBottom));
    }

    /* renamed from: a */
    private void m54814a(boolean z10, Rect rect, View view, int i10) {
        SparseArray<aauaf> sparseArray;
        int i11 = rect.bottom - rect.top;
        if (view instanceof ViewGroup) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams.width != i11 || layoutParams.height != i11) {
                layoutParams.width = i11;
                layoutParams.height = i11;
                view.setLayoutParams(layoutParams);
            }
        }
        if (z10) {
            addView(view, 0);
        } else {
            addView(view);
        }
        int i12 = rect.top;
        int iM54804a = m54804a(view, getWidth(), i11);
        measureChildWithMargins(view, 0, 0);
        if (i10 != -1 && (sparseArray = this.f43300o) != null && sparseArray.get(i10) != null) {
            aauaf aauafVar = this.f43300o.get(i10);
            layoutDecorated(view, aauafVar.f43305a, aauafVar.f43307c, aauafVar.f43306b, aauafVar.f43308d);
        } else {
            int i13 = this.f43291f;
            layoutDecorated(view, iM54804a, i12 - i13, iM54804a + i11, (i12 + i11) - i13);
        }
    }

    /* renamed from: d */
    private int m54823d() {
        return getHeight();
    }

    /* renamed from: b */
    private int m54818b() {
        return (int) ((getHeight() * 0.5f) - (this.f43302q * 0.5f));
    }

    /* renamed from: a */
    private int m54804a(View view, int i10, int i11) {
        float fNextFloat;
        if ((view == null ? 0 : getPosition(view)) == this.f43292g.getInitialCenterPosition()) {
            fNextFloat = i10 * 0.5f;
        } else {
            int[] iArr = f43277F;
            fNextFloat = (((iArr[r3 % iArr.length] + 0.5f) + new SecureRandom().nextFloat()) * i10) / 4.0f;
        }
        return (int) (fNextFloat - (i11 * 0.5f));
    }

    /* renamed from: a */
    private Rect m54805a(int i10) {
        return new Rect(getPaddingLeft(), this.f43291f + i10, getWidth() - getPaddingRight(), m54823d() + this.f43291f + i10);
    }

    /* renamed from: a */
    private void m54810a(RecyclerView.C0852v c0852v, int i10) {
        for (int i11 = 0; i11 < this.f43300o.size(); i11++) {
            int iKeyAt = this.f43300o.keyAt(i11);
            Rect rect = this.f43293h.get(iKeyAt);
            if (rect != null) {
                Rect rect2 = new Rect(rect.left, rect.top + i10, rect.right, rect.bottom + i10);
                View viewM5285o = c0852v.m5285o(iKeyAt);
                m54814a(false, rect2, viewM5285o, iKeyAt);
                aauaf aauafVar = this.f43300o.get(iKeyAt);
                if (aauafVar != null) {
                    float f10 = aauafVar.f43309e;
                    viewM5285o.setScaleX(f10);
                    viewM5285o.setScaleY(f10);
                    com.huawei.uikit.hwrecyclerview.layoutmanager.aauaf.m54841a(viewM5285o, getWidth());
                }
            }
        }
    }

    /* renamed from: a */
    private void m54812a(RecyclerView recyclerView) {
        this.f43300o.clear();
        if (recyclerView.getAdapter() != null && recyclerView.getAdapter().mo721e() == this.f43301p) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt != null) {
                    this.f43300o.put(getPosition(childAt), new aauaf(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom(), childAt.getScaleX()));
                }
            }
            return;
        }
        removeAllViews();
        this.f43293h.clear();
        this.f43291f = 0;
        this.f43288c = 0;
    }

    /* renamed from: a */
    private void m54807a(Rect rect) {
        Rect rect2;
        int initialCenterPosition = this.f43292g.getInitialCenterPosition();
        if (initialCenterPosition >= getItemCount() || initialCenterPosition < 0 || (rect2 = this.f43293h.get(initialCenterPosition)) == null) {
            return;
        }
        this.f43291f = rect2.top - rect.top;
    }

    /* renamed from: a */
    private Pair<Boolean, Integer> m54806a() {
        boolean z10;
        int childCount = getChildCount();
        int decoratedTop = 0;
        if (childCount == 0) {
            return new Pair<>(Boolean.TRUE, 0);
        }
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                z10 = false;
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt != null) {
                z10 = true;
                if (getPosition(childAt) == getItemCount() - 1) {
                    decoratedTop = getDecoratedTop(childAt);
                    break;
                }
            }
            i10++;
        }
        return new Pair<>(Boolean.valueOf(z10), Integer.valueOf(decoratedTop));
    }

    /* renamed from: a */
    private int m54803a(Context context, int i10) {
        return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public void m54829a(boolean z10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        View childAt = getChildAt(0);
        if (childAt != null && (childAt.getParent() instanceof RecyclerView)) {
            RecyclerView recyclerView = (RecyclerView) childAt.getParent();
            float height = getHeight() / 2.0f;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt2 = getChildAt(i10);
                if (childAt2 != null) {
                    if (!m54816a(z10, childAt2, height)) {
                        com.huawei.uikit.hwrecyclerview.layoutmanager.aauaf.m54842a(this, childAt2, height, this.f43292g);
                    }
                    HwFloatingBubblesScrollFinishedCallback hwFloatingBubblesScrollFinishedCallback = this.f43286a;
                    if (hwFloatingBubblesScrollFinishedCallback != null) {
                        hwFloatingBubblesScrollFinishedCallback.onScrollByFinished(childAt2, recyclerView);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m54816a(boolean z10, View view, float f10) {
        float translationY = view.getTranslationY() + (view.getHeight() * 0.5f) + view.getTop();
        if (z10 || !view.isSelected() || Float.compare(translationY, getHeight()) >= 0 || Float.compare(translationY, 0.0f) <= 0) {
            return false;
        }
        float fM54835a = com.huawei.uikit.hwrecyclerview.layoutmanager.aauaf.m54835a(this.f43292g, view, Math.abs(translationY - f10) / f10);
        if (m54815a((f43285z + fM54835a) - view.getScaleX(), (this.f43292g.getSelectedScaleRelativeOther() - 1.0f) * this.f43292g.getMaxScale())) {
            m54808a(view, fM54835a, getWidth());
            return true;
        }
        return m54826f();
    }

    /* renamed from: a */
    private boolean m54815a(float f10, float f11) {
        return SystemClock.uptimeMillis() - this.f43292g.getSelectedTime() < 500 && Float.compare(f10, f11) >= 0 && !m54826f();
    }

    /* renamed from: a */
    private void m54808a(final View view, float f10, final int i10) {
        ValueAnimator valueAnimator = this.f43303r;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(view.getScaleX(), f10);
            this.f43303r = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            this.f43303r.setInterpolator(new LinearInterpolator());
            this.f43303r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.uikit.hwrecyclerview.layoutmanager.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    HwFloatingBubblesLayoutManager.m54809a(view, i10, valueAnimator2);
                }
            });
            this.f43303r.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m54809a(View view, int i10, ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            float fFloatValue = ((Float) animatedValue).floatValue();
            view.setScaleX(fFloatValue);
            view.setScaleY(fFloatValue);
            com.huawei.uikit.hwrecyclerview.layoutmanager.aauaf.m54841a(view, i10);
        }
    }
}
