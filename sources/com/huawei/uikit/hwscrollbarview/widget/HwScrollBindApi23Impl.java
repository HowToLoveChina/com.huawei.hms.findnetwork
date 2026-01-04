package com.huawei.uikit.hwscrollbarview.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class HwScrollBindApi23Impl extends HwScrollBindBaseImpl {

    public class bzrwd implements View.OnScrollChangeListener {

        /* renamed from: a */
        final /* synthetic */ HwScrollbarView f44002a;

        public bzrwd(HwScrollbarView hwScrollbarView) {
            this.f44002a = hwScrollbarView;
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            this.f44002a.onScrollChanged();
        }
    }

    /* renamed from: a */
    private void m55421a(View view, HwScrollbarView hwScrollbarView, boolean z10) {
        if (view == null || hwScrollbarView == null) {
            return;
        }
        hwScrollbarView.setScrollableView(view, z10);
        view.setOnScrollChangeListener(new bzrwd(hwScrollbarView));
    }

    @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollBindBaseImpl, com.huawei.uikit.hwscrollbarview.widget.HwScrollBind
    public void bindListView(AbsListView absListView, HwScrollbarView hwScrollbarView, boolean z10) {
        m55421a(absListView, hwScrollbarView, z10);
    }

    @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollBindBaseImpl, com.huawei.uikit.hwscrollbarview.widget.HwScrollBind
    public void bindRecyclerView(RecyclerView recyclerView, HwScrollbarView hwScrollbarView, boolean z10) {
        m55421a(recyclerView, hwScrollbarView, z10);
    }

    @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollBindBaseImpl, com.huawei.uikit.hwscrollbarview.widget.HwScrollBind
    public void bindScrollView(ScrollView scrollView, HwScrollbarView hwScrollbarView, boolean z10) {
        m55421a(scrollView, hwScrollbarView, z10);
    }
}
