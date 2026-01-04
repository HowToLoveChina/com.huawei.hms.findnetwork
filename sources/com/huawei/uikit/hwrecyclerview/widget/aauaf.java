package com.huawei.uikit.hwrecyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.R$id;
import androidx.recyclerview.widget.InterfaceC0871j;
import androidx.recyclerview.widget.RecyclerView;
import p273f0.C9603h0;

/* loaded from: classes4.dex */
class aauaf implements InterfaceC0871j {

    /* renamed from: a */
    static final InterfaceC0871j f43931a = new aauaf();

    /* renamed from: b */
    private static final float f43932b = 1.0f;

    /* renamed from: a */
    private static float m55346a(RecyclerView recyclerView, View view) {
        float f10 = 0.0f;
        if (recyclerView != null && view != null) {
            int childCount = recyclerView.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = recyclerView.getChildAt(i10);
                if (childAt != view) {
                    float fM59913v = C9603h0.m59913v(childAt);
                    if (fM59913v > f10) {
                        f10 = fM59913v;
                    }
                }
            }
        }
        return f10;
    }

    @Override // androidx.recyclerview.widget.InterfaceC0871j
    public void clearView(View view) {
        if (view == null) {
            return;
        }
        int i10 = R$id.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i10);
        if (tag != null && (tag instanceof Float)) {
            C9603h0.m59918x0(view, ((Float) tag).floatValue());
        }
        view.setTag(i10, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.InterfaceC0871j
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (recyclerView == null || view == null) {
            return;
        }
        if (z10) {
            int i11 = R$id.item_touch_helper_previous_elevation;
            if (view.getTag(i11) == null) {
                Float fValueOf = Float.valueOf(C9603h0.m59913v(view));
                C9603h0.m59918x0(view, m55346a(recyclerView, view) + 1.0f);
                view.setTag(i11, fValueOf);
            }
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }

    @Override // androidx.recyclerview.widget.InterfaceC0871j
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }

    @Override // androidx.recyclerview.widget.InterfaceC0871j
    public void onSelected(View view) {
    }
}
