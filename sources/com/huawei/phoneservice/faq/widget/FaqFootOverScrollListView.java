package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;
import com.huawei.phoneservice.faq.R$styleable;
import com.huawei.phoneservice.faq.base.util.FaqRefectUtils;

/* loaded from: classes4.dex */
public class FaqFootOverScrollListView extends ListView {

    /* renamed from: a */
    public float f39288a;

    /* renamed from: b */
    public boolean f39289b;

    /* renamed from: c */
    public int f39290c;

    /* renamed from: d */
    public int f39291d;

    /* renamed from: e */
    public int f39292e;

    /* renamed from: f */
    public boolean f39293f;

    /* renamed from: g */
    public InterfaceC8425a f39294g;

    /* renamed from: h */
    public int f39295h;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqFootOverScrollListView$a */
    public interface InterfaceC8425a {
        /* renamed from: a */
        void mo52449a(int i10, int i11, int i12, int i13);
    }

    public FaqFootOverScrollListView(Context context) {
        super(context);
        this.f39289b = false;
        this.f39290c = -1;
        this.f39293f = true;
        this.f39295h = -1;
        m52448a(context);
    }

    /* renamed from: a */
    public final void m52448a(Context context) {
        this.f39291d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f39292e = (int) (context.getResources().getDisplayMetrics().density * 140.0f);
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
            int r1 = r5.f39290c
            if (r1 != r3) goto L1c
            goto L49
        L1c:
            int r1 = r6.findPointerIndex(r1)
            if (r1 != r3) goto L23
            goto L49
        L23:
            r5.f39290c = r1
            float r1 = r6.getY(r1)
            int r1 = (int) r1
            float r3 = r5.f39288a
            int r3 = (int) r3
            int r1 = r1 - r3
            int r1 = java.lang.Math.abs(r1)
            int r3 = r5.f39291d
            if (r1 <= r3) goto L49
            return r2
        L37:
            r5.f39290c = r3
            r5.f39295h = r3
            goto L49
        L3c:
            float r1 = r6.getY()
            r5.f39288a = r1
            r1 = 0
            int r1 = r6.getPointerId(r1)
            r5.f39290c = r1
        L49:
            if (r0 != 0) goto L4e
            r5.onTouchEvent(r6)
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.widget.FaqFootOverScrollListView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        if (i11 < 0 && !this.f39293f) {
            i11 = 0;
        }
        super.onOverScrolled(i10, i11, z10, z11);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        this.f39289b = true;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        InterfaceC8425a interfaceC8425a = this.f39294g;
        if (interfaceC8425a != null) {
            interfaceC8425a.mo52449a(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Throwable {
        int iFindPointerIndex;
        if (motionEvent.getAction() == 0) {
            int i10 = this.f39290c;
            if (i10 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i10)) != -1) {
                int iPointToPosition = pointToPosition((int) motionEvent.getX(iFindPointerIndex), (int) motionEvent.getY(iFindPointerIndex));
                this.f39295h = iPointToPosition;
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
        return super.overScrollBy(i10, i11, i12, i13, i14, i15, i16, this.f39292e, z10);
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        super.scrollTo(i10, i11);
        if (this.f39289b) {
            this.f39289b = false;
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
        if (drawable instanceof InterfaceC8425a) {
            InterfaceC8425a interfaceC8425a = (InterfaceC8425a) drawable;
            this.f39294g = interfaceC8425a;
            interfaceC8425a.mo52449a(getWidth(), getHeight(), getWidth(), getHeight());
        }
    }

    public FaqFootOverScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39289b = false;
        this.f39290c = -1;
        this.f39293f = true;
        this.f39295h = -1;
        m52448a(context);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FaqFootOverScrollListView);
            this.f39293f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FaqFootOverScrollListView_faqsdkheadOverScroll, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
