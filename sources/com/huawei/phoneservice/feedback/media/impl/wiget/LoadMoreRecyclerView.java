package com.huawei.phoneservice.feedback.media.impl.wiget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class LoadMoreRecyclerView extends RecyclerView {

    /* renamed from: n1 */
    public boolean f39546n1;

    /* renamed from: o1 */
    public boolean f39547o1;

    /* renamed from: p1 */
    public int f39548p1;

    /* renamed from: q1 */
    public int f39549q1;

    /* renamed from: r1 */
    public int f39550r1;

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.LoadMoreRecyclerView$a */
    public interface InterfaceC8477a {
    }

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.LoadMoreRecyclerView$b */
    public interface InterfaceC8478b {
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        this.f39546n1 = false;
        this.f39547o1 = false;
        this.f39550r1 = 1;
    }

    private void setLayoutManagerPosition(RecyclerView.AbstractC0846p abstractC0846p) {
        LinearLayoutManager linearLayoutManager;
        if (abstractC0846p instanceof GridLayoutManager) {
            linearLayoutManager = (GridLayoutManager) abstractC0846p;
        } else if (!(abstractC0846p instanceof LinearLayoutManager)) {
            return;
        } else {
            linearLayoutManager = (LinearLayoutManager) abstractC0846p;
        }
        this.f39548p1 = linearLayoutManager.findFirstVisibleItemPosition();
        this.f39549q1 = linearLayoutManager.findLastVisibleItemPosition();
    }

    public int getFirstVisiblePosition() {
        return this.f39548p1;
    }

    public int getLastVisiblePosition() {
        return this.f39549q1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i10) {
        super.onScrollStateChanged(i10);
        if (i10 == 0 || i10 == 1) {
            setLayoutManagerPosition(getLayoutManager());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i10, int i11) {
        super.onScrolled(i10, i11);
        RecyclerView.AbstractC0846p layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        setLayoutManagerPosition(layoutManager);
    }

    public void setEnabledLoadMore(boolean z10) {
        this.f39547o1 = z10;
    }

    public void setOnRecyclerViewPreloadListener(InterfaceC8477a interfaceC8477a) {
    }

    public void setOnRecyclerViewScrollStateListener(InterfaceC8478b interfaceC8478b) {
    }

    public void setReachBottomRow(int i10) {
        if (i10 < 1) {
            i10 = 1;
        }
        this.f39550r1 = i10;
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39546n1 = false;
        this.f39547o1 = false;
        this.f39550r1 = 1;
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f39546n1 = false;
        this.f39547o1 = false;
        this.f39550r1 = 1;
    }
}
