package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class HwLinearLayoutManager extends HwLinearLayoutManagerEx {

    /* renamed from: U */
    private LayoutCallback f43624U;

    public static abstract class LayoutCallback {
        public abstract void onLayoutFinished(View view, RecyclerView recyclerView);
    }

    public HwLinearLayoutManager(Context context, LayoutCallback layoutCallback) {
        super(context, 1, false);
        this.f43624U = layoutCallback;
    }

    /* renamed from: m */
    private void m55083m() {
        if (this.f43624U == null) {
            return;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && (childAt.getParent() instanceof RecyclerView)) {
                this.f43624U.onLayoutFinished(childAt, (RecyclerView) childAt.getParent());
            }
        }
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx
    public void calculateExtraLayoutSpace(RecyclerView.C0856z c0856z, int[] iArr) {
        super.calculateExtraLayoutSpace(c0856z, iArr);
        iArr[0] = iArr[0] + getExtraLayoutSpace()[0];
        iArr[1] = iArr[1] + getExtraLayoutSpace()[1];
    }

    public LayoutCallback getLayoutCallback() {
        return this.f43624U;
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public void onLayoutChildren(RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        super.onLayoutChildren(c0852v, c0856z);
        if (getChildCount() == 0) {
            return;
        }
        m55083m();
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public int scrollVerticallyBy(int i10, RecyclerView.C0852v c0852v, RecyclerView.C0856z c0856z) {
        int iScrollVerticallyBy = super.scrollVerticallyBy(i10, c0852v, c0856z);
        m55083m();
        return iScrollVerticallyBy;
    }

    public void setLayoutCallback(LayoutCallback layoutCallback) {
        this.f43624U = layoutCallback;
    }

    public HwLinearLayoutManager(Context context) {
        this(context, HwDeviceAdapter.instantiate(context).getScaleLayoutCallback(context));
    }

    public HwLinearLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public HwLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
