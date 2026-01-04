package com.huawei.uikit.hwhorizontalscrollview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.huawei.uikit.hwclickanimation.anim.HwSpringBackHelper;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwhorizontalscrollview.C8716R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class HwHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: e */
    private static final int f42851e = 1;

    /* renamed from: f */
    private static final int f42852f = -1;

    /* renamed from: g */
    private static final String f42853g = "HwHorizontalScrollView";

    /* renamed from: a */
    private HwSpringBackHelper f42854a;

    /* renamed from: b */
    private OverScroller f42855b;

    /* renamed from: c */
    private HwGenericEventDetector f42856c;

    /* renamed from: d */
    private boolean f42857d;

    public class bzrwd implements HwGenericEventDetector.OnScrollListener {
        public bzrwd() {
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector.OnScrollListener
        public boolean onScrollBy(float f10, float f11, MotionEvent motionEvent) {
            return HwHorizontalScrollView.this.m54689a(f10, f11);
        }
    }

    public HwHorizontalScrollView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private void m54692b(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet == null) {
            Log.w(f42853g, "Attribute set is null");
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8716R.styleable.HwHorizontalScrollView, i10, 0);
        int i11 = typedArrayObtainStyledAttributes.getInt(C8716R.styleable.HwHorizontalScrollView_hwSensitivityMode, 1);
        typedArrayObtainStyledAttributes.recycle();
        HwGenericEventDetector hwGenericEventDetectorCreateGenericEventDetector = createGenericEventDetector();
        this.f42856c = hwGenericEventDetectorCreateGenericEventDetector;
        if (hwGenericEventDetectorCreateGenericEventDetector != null) {
            hwGenericEventDetectorCreateGenericEventDetector.setSensitivityMode(i11);
            this.f42856c.setOnScrollListener(this, createOnScrollListener());
        }
    }

    /* renamed from: c */
    private boolean m54693c() {
        return getScrollRange() <= getScrollX();
    }

    /* renamed from: d */
    private boolean m54694d() {
        return getScrollX() < 0;
    }

    /* renamed from: e */
    private void m54695e() {
        HwSpringBackHelper hwSpringBackHelper = this.f42854a;
        if (hwSpringBackHelper != null && !hwSpringBackHelper.isFinished()) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.f42854a.abortAnimation();
        }
        if (this.f42855b.isFinished()) {
            return;
        }
        this.f42855b.abortAnimation();
    }

    private int getScrollRange() {
        int width;
        if (getChildCount() <= 0 || (width = getChildAt(0).getWidth() - ((getWidth() - getPaddingEnd()) - getPaddingStart())) < 0) {
            return 0;
        }
        return width;
    }

    public static HwHorizontalScrollView instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwHorizontalScrollView.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwHorizontalScrollView.class);
        if (objInstantiate instanceof HwHorizontalScrollView) {
            return (HwHorizontalScrollView) objInstantiate;
        }
        return null;
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

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void computeScroll() {
        HwSpringBackHelper hwSpringBackHelper = this.f42854a;
        if (hwSpringBackHelper != null && hwSpringBackHelper.computeScrollOffset()) {
            m54691b();
        } else if (this.f42855b.computeScrollOffset()) {
            m54686a();
        } else {
            super.computeScroll();
        }
    }

    public HwGenericEventDetector createGenericEventDetector() {
        return new HwGenericEventDetector(getContext());
    }

    public HwGenericEventDetector.OnScrollListener createOnScrollListener() {
        return new bzrwd();
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (!this.f42857d) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        HwGenericEventDetector hwGenericEventDetector = this.f42856c;
        if (hwGenericEventDetector == null || !hwGenericEventDetector.interceptGenericMotionEvent(motionEvent)) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i10) {
        if (getChildCount() <= 0 || !this.f42854a.isFinished()) {
            return;
        }
        int width = (getWidth() - getPaddingEnd()) - getPaddingStart();
        this.f42855b.fling(getScrollX(), 0, i10, 0, -width, getScrollRange() + width, 0, 0, 0, 0);
        postInvalidateOnAnimation();
    }

    public OverScroller getOverScroller() {
        return this.f42855b;
    }

    public float getSensitivity() {
        HwGenericEventDetector hwGenericEventDetector = this.f42856c;
        if (hwGenericEventDetector != null) {
            return hwGenericEventDetector.getSensitivity();
        }
        return 1.0f;
    }

    public boolean isExtendScrollEnabled() {
        return this.f42857d;
    }

    public boolean isSpringBack() {
        return this.f42854a.springBack(getScrollX(), 0, getScrollRange());
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!this.f42857d) {
            return super.onGenericMotionEvent(motionEvent);
        }
        HwGenericEventDetector hwGenericEventDetector = this.f42856c;
        if (hwGenericEventDetector == null || !hwGenericEventDetector.onGenericMotionEvent(motionEvent)) {
            return super.onGenericMotionEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        m54688a(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        m54688a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        int iM54684a = ((m54694d() || m54693c()) && z10) ? m54684a(i10, i12) : i10;
        int width = getWidth();
        invalidate();
        return super.overScrollBy(iM54684a, i11, i12, i13, i14, i15, width, i17, z10);
    }

    public void setExtendScrollEnabled(boolean z10) {
        this.f42857d = z10;
    }

    public void setSensitivity(float f10) {
        HwGenericEventDetector hwGenericEventDetector = this.f42856c;
        if (hwGenericEventDetector != null) {
            hwGenericEventDetector.setSensitivity(f10);
        }
    }

    public HwHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8716R.attr.hwHorizontalScrollViewStyle);
    }

    /* renamed from: a */
    private void m54687a(Context context, AttributeSet attributeSet, int i10) {
        m54692b(context, attributeSet, i10);
        this.f42854a = new HwSpringBackHelper();
        this.f42855b = new OverScroller(context);
        setValueFromPlume(context);
    }

    public HwHorizontalScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(m54685a(context, i10), attributeSet, i10);
        this.f42857d = true;
        m54687a(super.getContext(), attributeSet, i10);
    }

    /* renamed from: a */
    private static Context m54685a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8716R.style.Theme_Emui_HwHorizontalScrollView);
    }

    /* renamed from: a */
    private void m54688a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && isSpringBack()) {
                postInvalidateOnAnimation();
                return;
            }
            return;
        }
        m54695e();
    }

    /* renamed from: b */
    private void m54691b() {
        if (this.f42854a == null) {
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currentOffset = this.f42854a.getCurrentOffset();
        if (scrollX != currentOffset) {
            overScrollBy(currentOffset - scrollX, 0, scrollX, scrollY, getScrollRange(), 0, getWidth(), 0, false);
            onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
        }
        if (awakenScrollBars()) {
            return;
        }
        postInvalidateOnAnimation();
    }

    /* renamed from: a */
    private void m54686a() {
        HwSpringBackHelper hwSpringBackHelper;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f42855b.getCurrX();
        int currY = this.f42855b.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            int scrollRange = getScrollRange();
            int overScrollMode = getOverScrollMode();
            boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
            overScrollBy(currX - scrollX, currY - scrollY, scrollX, scrollY, scrollRange, 0, getWidth(), 0, false);
            onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
            if (z10 && (hwSpringBackHelper = this.f42854a) != null) {
                if (currX < 0 && scrollX >= 0) {
                    hwSpringBackHelper.overFling(-this.f42855b.getCurrVelocity(), -1, 0);
                    this.f42855b.abortAnimation();
                } else if (currX > scrollRange && scrollX <= scrollRange) {
                    hwSpringBackHelper.overFling(this.f42855b.getCurrVelocity(), scrollRange + 1, scrollRange);
                    this.f42855b.abortAnimation();
                }
            }
        }
        if (awakenScrollBars()) {
            return;
        }
        postInvalidateOnAnimation();
    }

    /* renamed from: a */
    private int m54684a(int i10, int i11) {
        if (m54693c()) {
            i11 -= getScrollRange();
        }
        return this.f42854a.getDynamicCurvedRateDelta(getWidth(), i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m54689a(float f10, float f11) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (Float.compare(f10, 0.0f) != 0) {
            scrollTo(scrollX + ((int) f10), scrollY);
            return true;
        }
        scrollTo(scrollX + ((int) f11), scrollY);
        return true;
    }
}
