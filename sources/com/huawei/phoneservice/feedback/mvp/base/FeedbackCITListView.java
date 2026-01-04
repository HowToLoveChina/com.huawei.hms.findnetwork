package com.huawei.phoneservice.feedback.mvp.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.phoneservice.feedback.R$styleable;
import com.huawei.phoneservice.feedback.widget.AbstractC8599b;
import com.huawei.phoneservice.feedback.widget.decortion.C8601a;

/* loaded from: classes5.dex */
public class FeedbackCITListView extends RecyclerView {

    /* renamed from: n1 */
    public boolean f39605n1;

    /* renamed from: o1 */
    public RecyclerView.AbstractC0845o f39606o1;

    public FeedbackCITListView(Context context) {
        super(context);
        this.f39605n1 = false;
        this.f39606o1 = null;
        m52749a(context, null, 0);
    }

    /* renamed from: a */
    public final void m52749a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FeedbackCITListView, i10, 0);
        if (typedArrayObtainStyledAttributes.getInteger(R$styleable.FeedbackCITListView_fbsdkListMode, 0) != 1) {
            setLayoutManager(new LinearLayoutManager(context));
        } else {
            this.f39606o1 = new C8601a();
            int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.FeedbackCITListView_fbsdkColumns, 2);
            setLayoutManager(new GridLayoutManager(context, integer));
            addItemDecoration(this.f39606o1);
            setColumnCount(integer);
            m52750c(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.FeedbackCITListView_fbsdkVerticalGap, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.FeedbackCITListView_fbsdkHorizontalGap, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    public void m52750c(int i10, int i11) {
        RecyclerView.AbstractC0845o abstractC0845o = this.f39606o1;
        if (abstractC0845o instanceof C8601a) {
            ((C8601a) abstractC0845o).m53170c(i10);
            ((C8601a) this.f39606o1).m53169b(i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f39605n1 = getLayoutParams().height == -2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f39605n1) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.AbstractC0838h abstractC0838h) {
        if (!isInEditMode() && !(abstractC0838h instanceof AbstractC8599b)) {
            throw new IllegalArgumentException("MUST use CITListAdapter!");
        }
        super.setAdapter(abstractC0838h);
    }

    public void setColumnCount(int i10) {
        RecyclerView.AbstractC0845o abstractC0845o = this.f39606o1;
        if (abstractC0845o instanceof C8601a) {
            ((C8601a) abstractC0845o).m53168a(i10);
        }
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanCount(i10);
        }
    }

    public void setmDisableScroll(boolean z10) {
        this.f39605n1 = z10;
    }

    public FeedbackCITListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39605n1 = false;
        this.f39606o1 = null;
        m52749a(context, attributeSet, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public AbstractC8599b getAdapter() {
        return (AbstractC8599b) super.getAdapter();
    }

    public FeedbackCITListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f39605n1 = false;
        this.f39606o1 = null;
        m52749a(context, attributeSet, i10);
    }
}
