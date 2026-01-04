package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes3.dex */
public class ObservableScrollView extends ScrollView {

    /* renamed from: a */
    public ScrollViewListener f17948a;

    /* renamed from: b */
    public boolean f17949b;

    public ObservableScrollView(Context context) {
        super(context);
        this.f17948a = null;
        this.f17949b = false;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        ScrollViewListener scrollViewListener = this.f17948a;
        if (scrollViewListener != null) {
            scrollViewListener.mo21542c(i11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L1b
            if (r0 == r1) goto L10
            r2 = 2
            if (r0 == r2) goto L1b
            r1 = 3
            if (r0 == r1) goto L10
            goto L28
        L10:
            com.huawei.android.hicloud.ui.extend.ScrollViewListener r0 = r3.f17948a
            if (r0 == 0) goto L28
            r1 = 0
            r3.f17949b = r1
            r0.mo21541b()
            goto L28
        L1b:
            com.huawei.android.hicloud.ui.extend.ScrollViewListener r0 = r3.f17948a
            if (r0 == 0) goto L28
            boolean r2 = r3.f17949b
            if (r2 != 0) goto L28
            r3.f17949b = r1
            r0.mo21540a()
        L28:
            boolean r3 = super.onTouchEvent(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.extend.ObservableScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.f17948a = scrollViewListener;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17948a = null;
        this.f17949b = false;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17948a = null;
        this.f17949b = false;
    }
}
