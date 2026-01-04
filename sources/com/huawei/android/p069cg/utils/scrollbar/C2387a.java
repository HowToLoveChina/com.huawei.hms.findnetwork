package com.huawei.android.p069cg.utils.scrollbar;

import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter;
import com.huawei.android.p069cg.utils.scrollbar.FMScrollBar;
import p031b7.C1120a;
import p514o9.C11842p;

/* renamed from: com.huawei.android.cg.utils.scrollbar.a */
/* loaded from: classes2.dex */
public class C2387a {

    /* renamed from: a */
    public static int f11424a;

    /* renamed from: b */
    public static int f11425b;

    /* renamed from: c */
    public static int f11426c;

    /* renamed from: com.huawei.android.cg.utils.scrollbar.a$a */
    public class a implements FMScrollBar.InterfaceC2386f {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView f11427a;

        public a(RecyclerView recyclerView) {
            this.f11427a = recyclerView;
        }

        @Override // com.huawei.android.p069cg.utils.scrollbar.FMScrollBar.InterfaceC2386f
        /* renamed from: a */
        public void mo14956a(int i10, int i11, boolean z10, int i12) {
            RecyclerView.AbstractC0846p layoutManager;
            if (i12 == 0) {
                return;
            }
            C1120a.m6675d("FMScrollBarHelper", "onTouchOffset, range = " + i10 + ", offset = " + i11 + ", isArrowDown = " + z10 + ", dy = " + i12);
            RecyclerView.AbstractC0838h adapter = this.f11427a.getAdapter();
            if (adapter == null || (layoutManager = this.f11427a.getLayoutManager()) == null || layoutManager.getItemCount() <= 0) {
                return;
            }
            int childCount = layoutManager.getChildCount();
            float itemCount = layoutManager.getItemCount() - childCount;
            if (itemCount >= 0.0f) {
                int height = (this.f11427a.getHeight() - this.f11427a.getPaddingTop()) - this.f11427a.getPaddingBottom();
                int height2 = layoutManager.getChildAt(0).getHeight();
                boolean z11 = layoutManager instanceof GridLayoutManager;
                if (z11) {
                    int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
                    int unused = C2387a.f11426c = spanCount;
                    float f10 = spanCount;
                    itemCount = (float) Math.ceil(itemCount / f10);
                    childCount = (int) Math.ceil((childCount * 1.0f) / f10);
                }
                int i13 = (childCount * height2) - height;
                float f11 = ((i11 * 1.0f) / i10) * (itemCount + (i13 > 0 ? (i13 * 1.0f) / height2 : 0.0f));
                int iFloor = (int) Math.floor(f11);
                int i14 = (int) (height2 * (f11 - iFloor));
                if (z11) {
                    iFloor *= ((GridLayoutManager) layoutManager).getSpanCount();
                }
                if (adapter instanceof EmptyLoadRecyclerMediaAdapter) {
                    C1120a.m6675d("FMScrollBarHelper", "onTouchOffset, lastPosition = " + C2387a.f11424a + ", position = " + iFloor + ", off =" + i14);
                    if (z10) {
                        if (iFloor < C2387a.f11424a) {
                            return;
                        }
                        if (iFloor == C2387a.f11424a && i14 < C2387a.f11425b) {
                            return;
                        }
                    } else {
                        if (iFloor > C2387a.f11424a) {
                            return;
                        }
                        if (iFloor == C2387a.f11424a && i14 > C2387a.f11425b) {
                            return;
                        }
                    }
                }
                int unused2 = C2387a.f11424a = iFloor;
                int unused3 = C2387a.f11425b = i14;
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(iFloor, -i14);
            }
        }
    }

    static {
        f11426c = C11842p.m70771U0() ? 6 : 4;
    }

    /* renamed from: f */
    public static boolean m14962f(RecyclerView recyclerView, FMScrollBar fMScrollBar, Handler handler) {
        return m14963g(recyclerView, fMScrollBar, true, handler);
    }

    /* renamed from: g */
    public static boolean m14963g(RecyclerView recyclerView, FMScrollBar fMScrollBar, boolean z10, Handler handler) {
        if (!m14964h(recyclerView, fMScrollBar)) {
            return false;
        }
        FMScrollBar.getHwScrollBindImpl().mo7964a(recyclerView, fMScrollBar, z10);
        fMScrollBar.setHandler(handler);
        fMScrollBar.setOnTouchOffsetListener(new a(recyclerView));
        return true;
    }

    /* renamed from: h */
    public static boolean m14964h(View view, FMScrollBar fMScrollBar) {
        return (view == null || fMScrollBar == null || fMScrollBar.getScrollableView() != null) ? false : true;
    }

    /* renamed from: i */
    public static void m14965i(int i10) {
        if (Math.abs(i10 - f11424a) > f11426c) {
            f11424a = i10;
        }
    }
}
