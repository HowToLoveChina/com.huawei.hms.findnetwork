package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p273f0.C9603h0;
import p276f3.C9649c;
import p757x.C13669a;

/* loaded from: classes.dex */
public class MaterialDividerItemDecoration extends RecyclerView.AbstractC0845o {

    /* renamed from: p0 */
    public static final int f8056p0 = R$style.Widget_MaterialComponents_MaterialDivider;

    /* renamed from: h0 */
    public Drawable f8057h0;

    /* renamed from: i0 */
    public int f8058i0;

    /* renamed from: j0 */
    public int f8059j0;

    /* renamed from: k0 */
    public int f8060k0;

    /* renamed from: l0 */
    public int f8061l0;

    /* renamed from: m0 */
    public int f8062m0;

    /* renamed from: n0 */
    public boolean f8063n0;

    /* renamed from: o0 */
    public final Rect f8064o0;

    public MaterialDividerItemDecoration(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, R$attr.materialDividerStyle, i10);
    }

    /* renamed from: a */
    public final void m10404a(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int i10 = paddingTop + this.f8061l0;
        int i11 = height - this.f8062m0;
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f8064o0);
            int iRound = this.f8064o0.right + Math.round(childAt.getTranslationX());
            this.f8057h0.setBounds((iRound - this.f8057h0.getIntrinsicWidth()) - this.f8058i0, i10, iRound, i11);
            this.f8057h0.draw(canvas);
        }
        canvas.restore();
    }

    /* renamed from: b */
    public final void m10405b(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        boolean z10 = C9603h0.m59832A(recyclerView) == 1;
        int i10 = paddingLeft + (z10 ? this.f8062m0 : this.f8061l0);
        int i11 = width - (z10 ? this.f8061l0 : this.f8062m0);
        int childCount = recyclerView.getChildCount();
        if (!this.f8063n0) {
            childCount--;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.f8064o0);
            int iRound = this.f8064o0.bottom + Math.round(childAt.getTranslationY());
            this.f8057h0.setBounds(i10, (iRound - this.f8057h0.getIntrinsicHeight()) - this.f8058i0, i11, iRound);
            this.f8057h0.draw(canvas);
        }
        canvas.restore();
    }

    /* renamed from: c */
    public void m10406c(int i10) {
        this.f8059j0 = i10;
        Drawable drawableM82231l = C13669a.m82231l(this.f8057h0);
        this.f8057h0 = drawableM82231l;
        C13669a.m82227h(drawableM82231l, i10);
    }

    /* renamed from: d */
    public void m10407d(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f8060k0 = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i10 + ". It should be either HORIZONTAL or VERTICAL");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        rect.set(0, 0, 0, 0);
        if (this.f8060k0 == 1) {
            rect.bottom = this.f8057h0.getIntrinsicHeight() + this.f8058i0;
        } else {
            rect.right = this.f8057h0.getIntrinsicWidth() + this.f8058i0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        if (this.f8060k0 == 1) {
            m10405b(canvas, recyclerView);
        } else {
            m10404a(canvas, recyclerView);
        }
    }

    public MaterialDividerItemDecoration(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f8064o0 = new Rect();
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.MaterialDivider, i10, f8056p0, new int[0]);
        this.f8059j0 = C9649c.m60265a(context, typedArrayM10770h, R$styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.f8058i0 = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialDivider_dividerThickness, context.getResources().getDimensionPixelSize(R$dimen.material_divider_thickness));
        this.f8061l0 = typedArrayM10770h.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetStart, 0);
        this.f8062m0 = typedArrayM10770h.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetEnd, 0);
        this.f8063n0 = typedArrayM10770h.getBoolean(R$styleable.MaterialDivider_lastItemDecorated, true);
        typedArrayM10770h.recycle();
        this.f8057h0 = new ShapeDrawable();
        m10406c(this.f8059j0);
        m10407d(i11);
    }
}
