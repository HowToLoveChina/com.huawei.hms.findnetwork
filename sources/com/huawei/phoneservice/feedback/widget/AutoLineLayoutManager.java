package com.huawei.phoneservice.feedback.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class AutoLineLayoutManager extends RecyclerView.AbstractC0846p {

    /* renamed from: V */
    public int f39976V;

    public AutoLineLayoutManager() {
        setAutoMeasureEnabled(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        int i10;
        int i11;
        AutoLineLayoutManager autoLineLayoutManager;
        int i12;
        detachAndScrapAttachedViews(c0852v);
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < getItemCount(); i15++) {
            View viewM5285o = c0852v.m5285o(i15);
            measureChildWithMargins(viewM5285o, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewM5285o);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewM5285o);
            addView(viewM5285o);
            if (i13 + decoratedMeasuredWidth > this.f39976V) {
                i14 += decoratedMeasuredHeight;
                i13 = 0;
            }
            measureChildWithMargins(viewM5285o, 0, 0);
            if (m53127p()) {
                int i16 = this.f39976V;
                i10 = i16 - i13;
                i11 = i14 + decoratedMeasuredHeight;
                autoLineLayoutManager = this;
                i12 = i16 - (i13 + decoratedMeasuredWidth);
            } else {
                i10 = i13 + decoratedMeasuredWidth;
                i11 = i14 + decoratedMeasuredHeight;
                autoLineLayoutManager = this;
                i12 = i13;
            }
            autoLineLayoutManager.layoutDecoratedWithMargins(viewM5285o, i12, i14, i10, i11);
            i13 += decoratedMeasuredWidth;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onMeasure(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z, int i10, int i11) {
        super.onMeasure(c0852v, c0856z, i10, i11);
        this.f39976V = (View.MeasureSpec.getSize(i10) - getPaddingEnd()) - getPaddingStart();
    }

    /* renamed from: p */
    public boolean m53127p() {
        return getLayoutDirection() == 1;
    }
}
