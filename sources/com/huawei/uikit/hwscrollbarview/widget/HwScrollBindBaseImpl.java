package com.huawei.uikit.hwscrollbarview.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class HwScrollBindBaseImpl implements HwScrollBind {

    public class aauaf extends RecyclerView.AbstractC0850t {

        /* renamed from: a */
        final /* synthetic */ HwScrollbarView f44004a;

        public aauaf(HwScrollbarView hwScrollbarView) {
            this.f44004a = hwScrollbarView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            this.f44004a.onScrollChanged();
        }
    }

    public class bzrwd implements AbsListView.OnScrollListener {

        /* renamed from: a */
        final /* synthetic */ HwScrollbarView f44006a;

        public bzrwd(HwScrollbarView hwScrollbarView) {
            this.f44006a = hwScrollbarView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            this.f44006a.onScrollChanged();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollBind
    public void bindListView(AbsListView absListView, HwScrollbarView hwScrollbarView, boolean z10) {
        if (absListView == null || hwScrollbarView == null) {
            return;
        }
        hwScrollbarView.setScrollableView(absListView, z10);
        absListView.setOnScrollListener(new bzrwd(hwScrollbarView));
    }

    @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollBind
    public void bindRecyclerView(RecyclerView recyclerView, HwScrollbarView hwScrollbarView, boolean z10) {
        if (recyclerView == null || hwScrollbarView == null) {
            return;
        }
        hwScrollbarView.setScrollableView(recyclerView, z10);
        recyclerView.addOnScrollListener(new aauaf(hwScrollbarView));
    }

    @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollBind
    public void bindScrollView(ScrollView scrollView, HwScrollbarView hwScrollbarView, boolean z10) {
    }

    @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollBind
    public void onScrollableViewTouchEvent(View view, HwScrollbarView hwScrollbarView, MotionEvent motionEvent) {
        if (view == null || hwScrollbarView == null || motionEvent == null) {
            return;
        }
        hwScrollbarView.onScrollableViewTouchEvent(view, motionEvent);
    }
}
