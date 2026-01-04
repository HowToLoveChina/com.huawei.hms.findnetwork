package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManager;

/* loaded from: classes4.dex */
public class HwScaleLayoutCallback extends HwLinearLayoutManager.LayoutCallback {

    /* renamed from: c */
    private static final float f43918c = 2.0f;

    /* renamed from: d */
    private static final float f43919d = 1.08f;

    /* renamed from: e */
    private static final float f43920e = 0.0f;

    /* renamed from: f */
    private static final float f43921f = -0.34f;

    /* renamed from: g */
    private static final float f43922g = 3.0f;

    /* renamed from: h */
    private static final float f43923h = 1.5f;

    /* renamed from: i */
    private static final int f43924i = 85;

    /* renamed from: j */
    private static final float f43925j = 0.38f;

    /* renamed from: a */
    private float f43926a = 0.25f;

    /* renamed from: b */
    private float f43927b;

    public class bzrwd implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RecyclerView f43928a;

        public bzrwd(RecyclerView recyclerView) {
            this.f43928a = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43928a.requestLayout();
        }
    }

    public HwScaleLayoutCallback(Context context) {
        float f10 = context.getResources().getDisplayMetrics().density;
        float f11 = (f10 <= 0.0f ? f43922g : f10) * 85.0f;
        this.f43927b = f43921f / (f11 * f11);
    }

    /* renamed from: a */
    private float m55343a(float f10) {
        return (float) (1.0d - Math.pow(1.0f - f10, 3.0d));
    }

    /* renamed from: b */
    private void m55345b(View view, float f10) {
        int layerType = view.getLayerType();
        if (Float.compare(f10, 0.0f) == 0 && layerType != 0) {
            view.setLayerType(0, null);
        } else {
            if (Float.compare(f10, 0.0f) <= 0 || layerType == 2) {
                return;
            }
            view.setLayerType(2, null);
        }
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManager.LayoutCallback
    public void onLayoutFinished(View view, RecyclerView recyclerView) {
        int height = recyclerView.getHeight();
        if (height == 0) {
            recyclerView.post(new bzrwd(recyclerView));
            return;
        }
        RecyclerView.AbstractC0838h adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if ((adapter.mo749g(childAdapterPosition) & HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK) != 0) {
            return;
        }
        float y10 = (view.getY() + (view.getHeight() / 2.0f)) - (height / 2.0f);
        float fAbs = Math.abs(y10);
        float fMax = Math.max((this.f43927b * fAbs * fAbs) + f43919d, 0.38f);
        m55344a(view, fMax);
        if ((adapter.mo749g(childAdapterPosition) & 16777216) != 0) {
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY((view.getHeight() / 2.0f) - (((Math.signum(y10) * view.getHeight()) * m55343a(Math.min(fAbs / (recyclerView.getHeight() / 2.0f), 1.0f))) * this.f43926a));
        }
        view.setScaleX(fMax);
        view.setScaleY(fMax);
    }

    /* renamed from: a */
    private void m55344a(View view, float f10) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt instanceof ViewGroup) {
                    m55344a(childAt, f10);
                } else if (childAt instanceof TextView) {
                    m55345b(childAt, f10);
                }
            }
        }
    }
}
