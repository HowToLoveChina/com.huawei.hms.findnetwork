package com.huawei.uikit.hwscrollbarview.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwrecyclerview.widget.HwOnOverScrollListener;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.hwscrollbarview.widget.HwScrollbarView;
import huawei.android.widget.HwSafeInsetsShareable;

/* loaded from: classes5.dex */
public class HwScrollbarHelper {

    /* renamed from: a */
    private static final String f44032a = "HwScrollbarHelper";

    public class aauaf implements HwOverScrollProxy {

        /* renamed from: a */
        final /* synthetic */ AbsListView f44033a;

        public aauaf(AbsListView absListView) {
            this.f44033a = absListView;
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwOverScrollProxy
        public int getOverScrollOffset() {
            return this.f44033a.getScrollY();
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwOverScrollProxy
        public boolean isOverScroll() {
            return this.f44033a.getScrollY() != 0;
        }
    }

    public class akxao implements HwOverScrollProxy {

        /* renamed from: a */
        final /* synthetic */ ScrollView f44034a;

        public akxao(ScrollView scrollView) {
            this.f44034a = scrollView;
        }

        /* renamed from: a */
        private int m55441a() {
            View childAt = this.f44034a.getChildAt(0);
            if (childAt != null) {
                return (childAt.getHeight() - this.f44034a.getHeight()) + this.f44034a.getPaddingTop() + this.f44034a.getPaddingBottom();
            }
            return 0;
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwOverScrollProxy
        public int getOverScrollOffset() {
            int scrollY = this.f44034a.getScrollY();
            if (scrollY <= 0) {
                return scrollY;
            }
            int iM55441a = m55441a();
            if (scrollY > iM55441a) {
                return scrollY - iM55441a;
            }
            return 0;
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwOverScrollProxy
        public boolean isOverScroll() {
            int iM55441a = m55441a();
            int scrollY = this.f44034a.getScrollY();
            return scrollY > iM55441a || scrollY < 0;
        }
    }

    public class avpbg implements HwScrollbarView.OnFastScrollListener {

        /* renamed from: a */
        final /* synthetic */ RecyclerView f44035a;

        public avpbg(RecyclerView recyclerView) {
            this.f44035a = recyclerView;
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollbarView.OnFastScrollListener
        public void onFastScrollChanged(int i10, int i11, float f10) {
            if (Math.abs(i11) < HwScrollbarHelper.m55436b(this.f44035a)) {
                this.f44035a.scrollBy(i10, i11);
            } else {
                HwScrollbarHelper.m55439b(this.f44035a, i10, i11, f10);
            }
        }
    }

    public class blfhz implements HwOverScrollProxy {

        /* renamed from: a */
        final /* synthetic */ RecyclerView f44036a;

        public blfhz(RecyclerView recyclerView) {
            this.f44036a = recyclerView;
        }

        /* renamed from: a */
        private int m55442a() {
            return (int) this.f44036a.getTranslationY();
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwOverScrollProxy
        public int getOverScrollOffset() {
            return -m55442a();
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwOverScrollProxy
        public boolean isOverScroll() {
            return m55442a() != 0;
        }
    }

    public class bqmxo implements HwScrollbarView.OnFastScrollListener {

        /* renamed from: a */
        final /* synthetic */ ScrollView f44037a;

        public bqmxo(ScrollView scrollView) {
            this.f44037a = scrollView;
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollbarView.OnFastScrollListener
        public void onFastScrollChanged(int i10, int i11, float f10) {
            this.f44037a.smoothScrollBy(i10, i11);
        }
    }

    public class brnby implements HwOnOverScrollListener {

        /* renamed from: a */
        final /* synthetic */ HwScrollbarView f44038a;

        public brnby(HwScrollbarView hwScrollbarView) {
            this.f44038a = hwScrollbarView;
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwOnOverScrollListener
        public void onOverScrollEnd() {
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwOnOverScrollListener
        public void onOverScrollStart() {
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwOnOverScrollListener
        public void onOverScrolled(float f10) {
            this.f44038a.onScrollChanged();
        }
    }

    public class bzrwd implements HwScrollbarView.OnFastScrollListener {

        /* renamed from: a */
        final /* synthetic */ AbsListView f44039a;

        public bzrwd(AbsListView absListView) {
            this.f44039a = absListView;
        }

        @Override // com.huawei.uikit.hwscrollbarview.widget.HwScrollbarView.OnFastScrollListener
        public void onFastScrollChanged(int i10, int i11, float f10) {
            HwScrollbarHelper.m55438b(this.f44039a, i10, i11, f10);
        }
    }

    private HwScrollbarHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m55438b(AbsListView absListView, int i10, int i11, float f10) {
        Adapter adapter;
        if (Float.compare(f10, 0.0f) == 0) {
            absListView.setSelection(0);
            return;
        }
        if (Float.compare(f10, 1.0f) != 0 || (adapter = absListView.getAdapter()) == null || adapter.getCount() <= 0) {
            if (Math.abs(i11) < m55436b(absListView)) {
                absListView.scrollListBy(i11);
                return;
            } else {
                m55440c(absListView, i10, i11, f10);
                return;
            }
        }
        View childAt = absListView.getChildAt(absListView.getChildCount() - 1);
        if (childAt == null) {
            return;
        }
        int height = ((absListView.getHeight() - absListView.getPaddingTop()) - absListView.getPaddingBottom()) - childAt.getHeight();
        int count = adapter.getCount() - 1;
        if (height >= 0) {
            absListView.setSelection(count);
        } else {
            m55432a(absListView, count, height);
        }
    }

    public static boolean bindListView(AbsListView absListView, HwScrollbarView hwScrollbarView) {
        return bindListView(absListView, hwScrollbarView, true);
    }

    public static boolean bindRecyclerView(RecyclerView recyclerView, HwScrollbarView hwScrollbarView) {
        return bindRecyclerView(recyclerView, hwScrollbarView, true);
    }

    public static boolean bindScrollView(ScrollView scrollView, HwScrollbarView hwScrollbarView) {
        return bindScrollView(scrollView, hwScrollbarView, true);
    }

    /* renamed from: c */
    private static void m55440c(AbsListView absListView, int i10, int i11, float f10) {
        int i12;
        int count;
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        int height = (absListView.getHeight() - absListView.getPaddingTop()) - absListView.getPaddingBottom();
        if (lastVisiblePosition > firstVisiblePosition && (i12 = height / (lastVisiblePosition - firstVisiblePosition)) > 0) {
            int i13 = firstVisiblePosition + (i11 / i12);
            int i14 = i11 % i12;
            if (i13 <= 0) {
                i13 = 0;
                i14 = 0;
            } else {
                if (((ListAdapter) absListView.getAdapter()) != null && i13 > r5.getCount() - 1) {
                    i13 = count;
                }
            }
            m55432a(absListView, i13, i14);
        }
    }

    public static void onScrollableViewTouchEvent(View view, HwScrollbarView hwScrollbarView, MotionEvent motionEvent) {
        HwScrollbarView.getHwScrollBindImpl().onScrollableViewTouchEvent(view, hwScrollbarView, motionEvent);
    }

    public static boolean bindListView(AbsListView absListView, HwScrollbarView hwScrollbarView, boolean z10) {
        if (!m55435a(absListView, hwScrollbarView)) {
            return false;
        }
        HwScrollbarView.getHwScrollBindImpl().bindListView(absListView, hwScrollbarView, z10);
        hwScrollbarView.setOnFastScrollListener(new bzrwd(absListView));
        hwScrollbarView.setHwOverScrollProxy(new aauaf(absListView));
        m55437b(absListView, hwScrollbarView);
        return true;
    }

    public static boolean bindRecyclerView(RecyclerView recyclerView, HwScrollbarView hwScrollbarView, boolean z10) {
        if (!m55435a(recyclerView, hwScrollbarView)) {
            return false;
        }
        HwScrollbarView.getHwScrollBindImpl().bindRecyclerView(recyclerView, hwScrollbarView, z10);
        hwScrollbarView.setOnFastScrollListener(new avpbg(recyclerView));
        hwScrollbarView.setHwOverScrollProxy(new blfhz(recyclerView));
        if (recyclerView instanceof HwRecyclerView) {
            ((HwRecyclerView) recyclerView).addOverScrollListener(new brnby(hwScrollbarView));
        }
        m55437b(recyclerView, hwScrollbarView);
        return true;
    }

    public static boolean bindScrollView(ScrollView scrollView, HwScrollbarView hwScrollbarView, boolean z10) {
        if (!m55435a(scrollView, hwScrollbarView)) {
            return false;
        }
        HwScrollbarView.getHwScrollBindImpl().bindScrollView(scrollView, hwScrollbarView, z10);
        hwScrollbarView.setOnFastScrollListener(new bqmxo(scrollView));
        hwScrollbarView.setHwOverScrollProxy(new akxao(scrollView));
        m55437b(scrollView, hwScrollbarView);
        return true;
    }

    /* renamed from: a */
    private static void m55432a(AbsListView absListView, int i10, int i11) {
        absListView.setSelectionFromTop(i10, i11);
    }

    /* renamed from: a */
    private static boolean m55435a(View view, HwScrollbarView hwScrollbarView) {
        return (view == null || hwScrollbarView == null || hwScrollbarView.getScrollableView() != null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static int m55436b(View view) {
        if (view == null) {
            return 0;
        }
        int measuredHeight = view.getMeasuredHeight();
        View rootView = view.getRootView();
        return rootView != null ? rootView.getMeasuredHeight() : measuredHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m55439b(RecyclerView recyclerView, int i10, int i11, float f10) {
        int itemCount;
        RecyclerView.AbstractC0846p layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null || layoutManager.getItemCount() <= 0 || (itemCount = layoutManager.getItemCount() - layoutManager.getChildCount()) < 0) {
            return;
        }
        int itemCount2 = (int) (f10 * itemCount);
        if (i11 > 0 && (itemCount2 = itemCount2 + (layoutManager.getItemCount() - itemCount)) >= layoutManager.getItemCount()) {
            itemCount2 = layoutManager.getItemCount() - 1;
        }
        recyclerView.scrollToPosition(itemCount2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private static void m55437b(View view, HwScrollbarView hwScrollbarView) {
        if (view instanceof HwSafeInsetsShareable) {
            ((HwSafeInsetsShareable) view).addSharedView(hwScrollbarView, 1);
        }
    }
}
