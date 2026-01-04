package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class FaqInScrollListView extends ListView {

    /* renamed from: a */
    public int f39296a;

    /* renamed from: b */
    public int f39297b;

    /* renamed from: c */
    public Map<View, Integer> f39298c;

    /* renamed from: d */
    public Map<View, Integer> f39299d;

    public FaqInScrollListView(Context context) {
        super(context);
        this.f39296a = 0;
        this.f39297b = 0;
        this.f39298c = new HashMap();
        this.f39299d = new HashMap();
    }

    /* renamed from: a */
    public final void m52450a(View view, int i10, int i11) {
        if (!this.f39298c.containsKey(view)) {
            this.f39298c.put(view, Integer.valueOf(view.getPaddingStart()));
            this.f39299d.put(view, Integer.valueOf(view.getPaddingEnd()));
        }
        int iIntValue = this.f39298c.get(view).intValue();
        int iIntValue2 = this.f39299d.get(view).intValue();
        if (i10 < 0 || i11 < 0) {
            return;
        }
        int i12 = i10 + iIntValue;
        int i13 = i11 + iIntValue2;
        boolean z10 = getLayoutDirection() == 1;
        int i14 = z10 ? i13 : i12;
        int paddingTop = view.getPaddingTop();
        if (!z10) {
            i12 = i13;
        }
        view.setPadding(i14, paddingTop, i12, view.getPaddingBottom());
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        m52450a(view, this.f39296a, this.f39297b);
        super.addView(view, i10, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        m52450a(view, this.f39296a, this.f39297b);
        return super.addViewInLayout(view, i10, layoutParams, z10);
    }

    /* renamed from: b */
    public void m52451b(ViewGroup viewGroup) {
        if (this.f39296a >= 0 && this.f39297b >= 0) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                m52450a(getChildAt(i10), this.f39296a, this.f39297b);
            }
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        m52451b(this);
        super.onMeasure(i10, iMakeMeasureSpec);
    }

    public void setInsetPaddingEnd(int i10) {
        this.f39297b = i10;
        m52451b(this);
    }

    public void setInsetPaddingStart(int i10) {
        this.f39296a = i10;
        m52451b(this);
    }

    public FaqInScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39296a = 0;
        this.f39297b = 0;
        this.f39298c = new HashMap();
        this.f39299d = new HashMap();
    }
}
