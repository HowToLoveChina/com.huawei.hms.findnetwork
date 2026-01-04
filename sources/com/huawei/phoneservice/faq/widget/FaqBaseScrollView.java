package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* loaded from: classes4.dex */
public class FaqBaseScrollView extends ScrollView {

    /* renamed from: a */
    public float f39272a;

    /* renamed from: b */
    public int f39273b;

    /* renamed from: c */
    public int f39274c;

    /* renamed from: d */
    public InterfaceC8423b f39275d;

    /* renamed from: e */
    public boolean f39276e;

    /* renamed from: f */
    public int f39277f;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqBaseScrollView$a */
    public interface InterfaceC8422a {
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqBaseScrollView$b */
    public interface InterfaceC8423b {
        /* renamed from: a */
        void mo52091a();
    }

    public FaqBaseScrollView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m52437a() {
        this.f39274c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.widget.ScrollView
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    @Override // android.widget.ScrollView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "FaqBaseScrollView"
            r1 = 0
            boolean r2 = super.onInterceptTouchEvent(r7)     // Catch: java.lang.Exception -> L8
            goto L11
        L8:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r2)
            r2 = r1
        L11:
            int r3 = r7.getAction()
            r3 = r3 & 255(0xff, float:3.57E-43)
            if (r3 == 0) goto L45
            r1 = 1
            r4 = -1
            if (r3 == r1) goto L42
            r5 = 2
            if (r3 == r5) goto L24
            r1 = 3
            if (r3 == r1) goto L42
            goto L51
        L24:
            int r3 = r6.f39273b
            if (r3 != r4) goto L29
            goto L51
        L29:
            int r3 = r7.findPointerIndex(r3)
            if (r3 != r4) goto L30
            goto L51
        L30:
            float r3 = r7.getY(r3)
            int r3 = (int) r3
            float r4 = r6.f39272a
            int r4 = (int) r4
            int r3 = r3 - r4
            int r3 = java.lang.Math.abs(r3)
            int r4 = r6.f39274c
            if (r3 <= r4) goto L51
            return r1
        L42:
            r6.f39273b = r4
            goto L51
        L45:
            float r3 = r7.getY()
            r6.f39272a = r3
            int r1 = r7.getPointerId(r1)
            r6.f39273b = r1
        L51:
            if (r2 != 0) goto L5f
            r6.onTouchEvent(r7)     // Catch: java.lang.Exception -> L57
            goto L5f
        L57:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r6)
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.widget.FaqBaseScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        if (i11 < 0) {
            i11 = 0;
        }
        super.onOverScrolled(i10, i11, z10, z11);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        this.f39276e = true;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        InterfaceC8423b interfaceC8423b;
        super.onScrollChanged(i10, i11, i12, i13);
        if (i11 + getHeight() < computeVerticalScrollRange() || (interfaceC8423b = this.f39275d) == null) {
            return;
        }
        interfaceC8423b.mo52091a();
    }

    @Override // android.view.View
    public boolean overScrollBy(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        return super.overScrollBy(i10, i11, i12, i13, i14, i15, i16, this.f39277f, z10);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void scrollTo(int i10, int i11) {
        super.scrollTo(i10, i11);
        if (this.f39276e) {
            this.f39276e = false;
        }
    }

    public void setScrollListener(InterfaceC8422a interfaceC8422a) {
    }

    public void setScrollToBottomListener(InterfaceC8423b interfaceC8423b) {
        this.f39275d = interfaceC8423b;
    }

    public FaqBaseScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaqBaseScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f39273b = -1;
        this.f39276e = false;
        this.f39277f = 140;
        this.f39277f = (int) (140 * context.getResources().getDisplayMetrics().density);
        m52437a();
    }
}
