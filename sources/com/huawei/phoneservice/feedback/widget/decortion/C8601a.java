package com.huawei.phoneservice.feedback.widget.decortion;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.huawei.phoneservice.feedback.widget.decortion.a */
/* loaded from: classes5.dex */
public class C8601a extends RecyclerView.AbstractC0845o {

    /* renamed from: h0 */
    public int f40026h0;

    /* renamed from: i0 */
    public int f40027i0;

    /* renamed from: j0 */
    public int f40028j0 = Integer.MAX_VALUE;

    /* renamed from: a */
    public void m53168a(int i10) {
        this.f40028j0 = i10;
    }

    /* renamed from: b */
    public void m53169b(int i10) {
        this.f40027i0 = i10;
    }

    /* renamed from: c */
    public void m53170c(int i10) {
        this.f40026h0 = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        rect.top = this.f40026h0;
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i10 = this.f40028j0;
        if (childLayoutPosition < i10) {
            rect.top = 0;
        }
        if (i10 != Integer.MAX_VALUE) {
            float f10 = (((i10 - 1) * r1) * 1.0f) / i10;
            float f11 = (childLayoutPosition % i10) * (this.f40027i0 - f10);
            rect.left = (int) f11;
            rect.right = (int) (f10 - f11);
        }
    }
}
