package com.huawei.phoneservice.feedback.mvp.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;
import com.huawei.phoneservice.faq.base.util.FaqRefectUtils;
import com.huawei.phoneservice.feedback.R$styleable;

/* loaded from: classes5.dex */
public class FeedbackFootOverScrollListView extends ListView {

    /* renamed from: a */
    public int f39607a;

    /* renamed from: b */
    public int f39608b;

    /* renamed from: c */
    public int f39609c;

    /* renamed from: d */
    public float f39610d;

    /* renamed from: e */
    public boolean f39611e;

    /* renamed from: f */
    public boolean f39612f;

    /* renamed from: g */
    public InterfaceC8491a f39613g;

    /* renamed from: h */
    public int f39614h;

    /* renamed from: com.huawei.phoneservice.feedback.mvp.base.FeedbackFootOverScrollListView$a */
    public interface InterfaceC8491a {
        /* renamed from: a */
        void mo52752a(int i10, int i11, int i12, int i13);
    }

    public FeedbackFootOverScrollListView(Context context) {
        super(context);
        this.f39607a = -1;
        this.f39611e = false;
        this.f39612f = true;
        this.f39614h = -1;
        m52751a(context);
    }

    /* renamed from: a */
    public final void m52751a(Context context) {
        this.f39608b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f39609c = (int) (context.getResources().getDisplayMetrics().density * 140.0f);
        setOverScrollMode(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = super.onInterceptTouchEvent(r6)
            int r1 = r6.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L3c
            r2 = 1
            r3 = -1
            if (r1 == r2) goto L37
            r4 = 2
            if (r1 == r4) goto L17
            r2 = 3
            if (r1 == r2) goto L37
            goto L49
        L17:
            int r1 = r5.f39607a
            if (r1 != r3) goto L1c
            goto L49
        L1c:
            int r1 = r6.findPointerIndex(r1)
            if (r1 != r3) goto L23
            goto L49
        L23:
            r5.f39607a = r1
            float r1 = r6.getY(r1)
            int r1 = (int) r1
            float r3 = r5.f39610d
            int r3 = (int) r3
            int r1 = r1 - r3
            int r1 = java.lang.Math.abs(r1)
            int r3 = r5.f39608b
            if (r1 <= r3) goto L49
            return r2
        L37:
            r5.f39607a = r3
            r5.f39614h = r3
            goto L49
        L3c:
            float r1 = r6.getY()
            r5.f39610d = r1
            r1 = 0
            int r1 = r6.getPointerId(r1)
            r5.f39607a = r1
        L49:
            if (r0 != 0) goto L4e
            r5.onTouchEvent(r6)
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.mvp.base.FeedbackFootOverScrollListView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        if (i11 < 0 && !this.f39612f) {
            i11 = 0;
        }
        super.onOverScrolled(i10, i11, z10, z11);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        this.f39611e = true;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        InterfaceC8491a interfaceC8491a = this.f39613g;
        if (interfaceC8491a != null) {
            interfaceC8491a.mo52752a(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Throwable {
        int iFindPointerIndex;
        if (motionEvent.getAction() == 0) {
            int i10 = this.f39607a;
            if (i10 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i10)) != -1) {
                int iPointToPosition = pointToPosition((int) motionEvent.getX(iFindPointerIndex), (int) motionEvent.getY(iFindPointerIndex));
                this.f39614h = iPointToPosition;
                if (iPointToPosition == -1) {
                    FaqRefectUtils.setIntFiled(this, AbsListView.class, "mTouchMode", 5);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        return super.overScrollBy(i10, i11, i12, i13, i14, i15, i16, this.f39609c, z10);
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        super.scrollTo(i10, i11);
        if (this.f39611e) {
            this.f39611e = false;
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        super.setOnScrollListener(onScrollListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.ListView
    public void setOverscrollFooter(Drawable drawable) {
        super.setOverscrollFooter(drawable);
        if (drawable instanceof InterfaceC8491a) {
            InterfaceC8491a interfaceC8491a = (InterfaceC8491a) drawable;
            this.f39613g = interfaceC8491a;
            interfaceC8491a.mo52752a(getWidth(), getHeight(), getWidth(), getHeight());
        }
    }

    public FeedbackFootOverScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39607a = -1;
        this.f39611e = false;
        this.f39612f = true;
        this.f39614h = -1;
        m52751a(context);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FeedbackFootOverScrollListView);
            this.f39612f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FeedbackFootOverScrollListView_feedbacksdkheadOverScroll, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
