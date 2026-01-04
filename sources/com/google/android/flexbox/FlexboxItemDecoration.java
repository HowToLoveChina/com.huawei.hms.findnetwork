package com.google.android.flexbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class FlexboxItemDecoration extends RecyclerView.AbstractC0845o {

    /* renamed from: j0 */
    public static final int[] f7199j0 = {R.attr.listDivider};

    /* renamed from: h0 */
    public Drawable f7200h0;

    /* renamed from: i0 */
    public int f7201i0;

    public FlexboxItemDecoration(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f7199j0);
        this.f7200h0 = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        m9271s(3);
    }

    /* renamed from: a */
    public final void m9264a(Canvas canvas, RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i10;
        int iMin;
        int left2;
        if (m9267o()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left3 = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = recyclerView.getChildAt(i11);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    top = this.f7200h0.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    intrinsicHeight = top - this.f7200h0.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.mo9286n()) {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    right = childAt.getRight();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (flexboxLayoutManager.m9318K()) {
                    iMin = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.f7200h0.getIntrinsicWidth(), right2);
                    left2 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.f7200h0.setBounds(left2, intrinsicHeight, iMin, top);
                    this.f7200h0.draw(canvas);
                } else {
                    left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f7200h0.getIntrinsicWidth(), left3);
                    right = childAt.getRight();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i12 = left;
                iMin = right + i10;
                left2 = i12;
                this.f7200h0.setBounds(left2, intrinsicHeight, iMin, top);
                this.f7200h0.draw(canvas);
            }
        }
    }

    /* renamed from: b */
    public final void m9265b(Canvas canvas, RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        int iMax;
        int bottom;
        int i10;
        int i11;
        if (m9268p()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = recyclerView.getChildAt(i12);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.m9318K()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    left = this.f7200h0.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    intrinsicWidth = left - this.f7200h0.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.mo9286n()) {
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else if (flexDirection == 3) {
                    int iMin = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.f7200h0.getIntrinsicHeight(), bottom2);
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i11 = iMin;
                    this.f7200h0.setBounds(intrinsicWidth, iMax, left, i11);
                    this.f7200h0.draw(canvas);
                } else {
                    iMax = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f7200h0.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                i11 = bottom + i10;
                this.f7200h0.setBounds(intrinsicWidth, iMax, left, i11);
                this.f7200h0.draw(canvas);
            }
        }
    }

    /* renamed from: c */
    public final boolean m9266c(int i10, List<C1631b> list, FlexboxLayoutManager flexboxLayoutManager) {
        int iM9315H = flexboxLayoutManager.m9315H(i10);
        if ((iM9315H == -1 || iM9315H >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(iM9315H).f7299o != i10) && i10 != 0) {
            return list.size() != 0 && list.get(list.size() - 1).f7300p == i10 - 1;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!m9267o() && !m9268p()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
        List<C1631b> listM9314G = flexboxLayoutManager.m9314G();
        m9270r(rect, childAdapterPosition, flexboxLayoutManager, listM9314G, flexboxLayoutManager.getFlexDirection());
        m9269q(rect, childAdapterPosition, flexboxLayoutManager, listM9314G);
    }

    /* renamed from: o */
    public final boolean m9267o() {
        return (this.f7201i0 & 1) > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        m9264a(canvas, recyclerView);
        m9265b(canvas, recyclerView);
    }

    /* renamed from: p */
    public final boolean m9268p() {
        return (this.f7201i0 & 2) > 0;
    }

    /* renamed from: q */
    public final void m9269q(Rect rect, int i10, FlexboxLayoutManager flexboxLayoutManager, List<C1631b> list) {
        if (list.size() == 0 || flexboxLayoutManager.m9315H(i10) == 0) {
            return;
        }
        if (flexboxLayoutManager.mo9286n()) {
            if (m9267o()) {
                rect.top = this.f7200h0.getIntrinsicHeight();
                rect.bottom = 0;
                return;
            } else {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
        }
        if (m9268p()) {
            if (flexboxLayoutManager.m9318K()) {
                rect.right = this.f7200h0.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.f7200h0.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }

    /* renamed from: r */
    public final void m9270r(Rect rect, int i10, FlexboxLayoutManager flexboxLayoutManager, List<C1631b> list, int i11) {
        if (m9266c(i10, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.mo9286n()) {
            if (!m9268p()) {
                rect.left = 0;
                rect.right = 0;
                return;
            } else if (flexboxLayoutManager.m9318K()) {
                rect.right = this.f7200h0.getIntrinsicWidth();
                rect.left = 0;
                return;
            } else {
                rect.left = this.f7200h0.getIntrinsicWidth();
                rect.right = 0;
                return;
            }
        }
        if (!m9267o()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i11 == 3) {
            rect.bottom = this.f7200h0.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.f7200h0.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    /* renamed from: s */
    public void m9271s(int i10) {
        this.f7201i0 = i10;
    }
}
