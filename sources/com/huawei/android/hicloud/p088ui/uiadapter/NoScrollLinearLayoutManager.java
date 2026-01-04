package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes3.dex */
public class NoScrollLinearLayoutManager extends LinearLayoutManager {
    public NoScrollLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollHorizontally() {
        return false;
    }

    public NoScrollLinearLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public NoScrollLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
