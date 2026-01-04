package com.huawei.cloud.pay.p098ui.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p054cj.C1442a;
import p514o9.C11842p;

/* loaded from: classes5.dex */
public class VoucherItemDecoration extends RecyclerView.AbstractC0845o {

    /* renamed from: h0 */
    public Context f21468h0;

    public VoucherItemDecoration(Context context) {
        this.f21468h0 = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
        super.getItemOffsets(rect, view, recyclerView, c0856z);
        if (recyclerView == null || c0856z == null) {
            C1442a.m8291w("VoucherItemDecoration", "parent or state is null.");
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int iM5305b = c0856z.m5305b() - 1;
        if (childAdapterPosition != iM5305b) {
            rect.bottom = C11842p.m70840n(this.f21468h0, 0);
        } else if (childAdapterPosition == iM5305b) {
            rect.bottom = C11842p.m70840n(this.f21468h0, 68);
        }
    }
}
