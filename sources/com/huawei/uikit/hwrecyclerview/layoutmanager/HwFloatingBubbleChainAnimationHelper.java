package com.huawei.uikit.hwrecyclerview.layoutmanager;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationHelper;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* loaded from: classes4.dex */
public class HwFloatingBubbleChainAnimationHelper extends HwChainAnimationHelper {

    /* renamed from: X */
    private static final String f43237X = "HwChainHelper";

    /* renamed from: Y */
    private static final float f43238Y = 1.0f;

    /* renamed from: Z */
    private static final float f43239Z = 1.0f;

    /* renamed from: a0 */
    private static final double f43240a0 = 2.0d;

    /* renamed from: b0 */
    private static final int f43241b0 = 2;

    /* renamed from: R */
    private HwRecyclerView f43242R;

    /* renamed from: S */
    private HwFloatingBubblesLayoutManager f43243S;

    /* renamed from: T */
    private boolean f43244T;

    /* renamed from: U */
    private boolean f43245U;

    /* renamed from: V */
    private int f43246V;

    /* renamed from: W */
    private boolean f43247W;

    public HwFloatingBubbleChainAnimationHelper(int i10, int i11) {
        super(i10, i11);
        this.f43244T = false;
        this.f43245U = true;
        this.f43246V = 0;
    }

    /* renamed from: e */
    private void m54798e(int i10) {
        HwFloatingBubblesLayoutManager hwFloatingBubblesLayoutManager = this.f43243S;
        if (hwFloatingBubblesLayoutManager != null) {
            boolean zIsOverScrolled = isOverScrolled();
            if (isOverScrolled()) {
                i10 = 0;
            }
            hwFloatingBubblesLayoutManager.offsetPosition(zIsOverScrolled, i10);
            this.f43243S.m54829a(false);
            this.f43243S.m54830h();
        }
    }

    public void attachToRecyclerView(HwRecyclerView hwRecyclerView, HwFloatingBubblesLayoutManager hwFloatingBubblesLayoutManager) {
        this.f43242R = hwRecyclerView;
        this.f43243S = hwFloatingBubblesLayoutManager;
        setStiffnessTransfer(1.0f);
        setFrameDelta(1.0f);
        super.attachToRecyclerView(hwRecyclerView, (LinearLayoutManager) hwFloatingBubblesLayoutManager);
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationHelper
    public View findChildViewUnderWithDecoration(float f10, float f11) {
        HwFloatingBubblesLayoutManager hwFloatingBubblesLayoutManager = this.f43243S;
        if (hwFloatingBubblesLayoutManager == null || hwFloatingBubblesLayoutManager.getChildCount() <= 0) {
            return null;
        }
        int childCount = this.f43243S.getChildCount() - 1;
        int i10 = 0;
        double d10 = 0.0d;
        for (int i11 = childCount; i11 >= 0; i11--) {
            View childAt = this.f43243S.getChildAt(i11);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.LayoutParams) {
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    float translationX = childAt.getTranslationX();
                    float translationY = childAt.getTranslationY();
                    float decoratedLeft = (this.f43243S.getDecoratedLeft(childAt) + translationX) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    float decoratedRight = this.f43243S.getDecoratedRight(childAt) + translationX + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    float decoratedTop = (this.f43243S.getDecoratedTop(childAt) + translationY) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                    double dSqrt = Math.sqrt(Math.pow(f10 - (decoratedLeft + ((decoratedRight - decoratedLeft) / 2.0f)), 2.0d) + Math.pow(f11 - (decoratedTop + ((((this.f43243S.getDecoratedBottom(childAt) + translationY) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - decoratedTop) / 2.0f)), 2.0d)) / childAt.getScaleX();
                    if (i11 == childCount) {
                        d10 = dSqrt;
                    } else if (dSqrt < d10) {
                        i10 = i11;
                        d10 = dSqrt;
                    }
                }
            }
        }
        return this.f43243S.getChildAt(i10);
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationHelper
    public boolean isNeedRelocate() {
        return !isOverScrolled();
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationHelper, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        initChain();
        if (this.f43243S == null) {
            return false;
        }
        if ((!isOverScrolled() || !isBeingDragged()) && this.f43242R.isChainAnimationEnabled()) {
            startSpringAnimation();
        }
        if (this.f43244T && !this.f43245U) {
            m54798e(0);
            return true;
        }
        if (!this.f43247W) {
            m54798e(0);
            this.f43247W = false;
            return true;
        }
        m54798e(this.f43242R.getScrollState() == 0 ? 0 : -this.f43246V);
        this.f43245U = !this.f43244T;
        this.f43247W = false;
        return true;
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationHelper, androidx.recyclerview.widget.RecyclerView.AbstractC0850t
    public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        super.onScrolled(recyclerView, i10, i11);
        this.f43244T = false;
        this.f43246V = i11;
        this.f43247W = true;
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwChainAnimationHelper
    public void relocate() {
        super.relocate();
        this.f43244T = true;
    }
}
