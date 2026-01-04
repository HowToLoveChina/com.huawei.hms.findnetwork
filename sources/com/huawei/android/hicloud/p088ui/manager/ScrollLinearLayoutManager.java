package com.huawei.android.hicloud.p088ui.manager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes3.dex */
public class ScrollLinearLayoutManager extends LinearLayoutManager {
    public ScrollLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
    public boolean canScrollVertically() {
        return false;
    }

    public ScrollLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
