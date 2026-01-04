package com.huawei.uikit.hwrecyclerview.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;

/* loaded from: classes4.dex */
public class HwPageTurningScrollHelper {
    public static final float DEFAULT_THRESHOLD_RATIO = 0.125f;

    /* renamed from: g */
    private static final String f43722g = "HwPageTurningScrollHelper";

    /* renamed from: a */
    private float f43723a;

    /* renamed from: b */
    private float f43724b;

    /* renamed from: c */
    private float f43725c;

    /* renamed from: d */
    private float f43726d;

    /* renamed from: e */
    private HwRecyclerView f43727e;

    /* renamed from: f */
    private Deque<Integer> f43728f;

    public HwPageTurningScrollHelper(HwRecyclerView hwRecyclerView) {
        if (hwRecyclerView == null) {
            Log.e(f43722g, "The given hwRecyclerView can not be null!");
            return;
        }
        this.f43727e = hwRecyclerView;
        this.f43728f = new LinkedList();
        this.f43723a = 0.125f;
        this.f43724b = 0.125f;
    }

    /* renamed from: c */
    private void m55173c(RecyclerView.AbstractC0846p abstractC0846p, float f10) {
        int height = (this.f43727e.getHeight() - this.f43727e.getPaddingTop()) - this.f43727e.getPaddingBottom();
        if (Float.compare(Math.abs(f10), height * this.f43723a) < 0) {
            return;
        }
        if (!(abstractC0846p instanceof LinearLayoutManager)) {
            HwRecyclerView hwRecyclerView = this.f43727e;
            if (((int) f10) <= 0) {
                height = -height;
            }
            hwRecyclerView.scrollBy(0, height);
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) abstractC0846p;
        if (Float.compare(f10, 0.0f) <= 0) {
            m55167a(linearLayoutManager);
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition) == null) {
            Log.e(f43722g, "Page turning scroll vertically error, first visible item view is null.");
            return;
        }
        if (!m55171a(true)) {
            this.f43728f.push(Integer.valueOf(iFindFirstVisibleItemPosition));
        }
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindLastVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            Log.e(f43722g, "Page turning scroll vertically error, last visible item view is null.");
        } else if (m55170a(linearLayoutManager, viewFindViewByPosition, true)) {
            linearLayoutManager.scrollToPositionWithOffset(iFindLastVisibleItemPosition, 0);
        } else {
            linearLayoutManager.scrollToPositionWithOffset(iFindLastVisibleItemPosition + 1, 0);
        }
    }

    /* renamed from: a */
    public void m55175a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.e(f43722g, "The given motionEvent can not be null!");
        } else {
            this.f43725c = motionEvent.getX();
            this.f43726d = motionEvent.getY();
        }
    }

    /* renamed from: b */
    public void m55177b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.e(f43722g, "The given motionEvent can not be null!");
            return;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.AbstractC0846p layoutManager = this.f43727e.getLayoutManager();
        if (layoutManager == null) {
            Log.e(f43722g, "onMotionTouchUp error, the layout manager is null.");
            return;
        }
        boolean zCanScrollVertically = layoutManager.canScrollVertically();
        boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
        if (zCanScrollVertically) {
            m55173c(layoutManager, this.f43726d - y10);
            return;
        }
        if (!zCanScrollHorizontally) {
            Log.i(f43722g, "The RecyclerView can neither scroll horizontally nor vertically, do nothing.");
        } else if (m55169a()) {
            m55172b(layoutManager, this.f43725c - x10);
        } else {
            m55168a(layoutManager, this.f43725c - x10);
        }
    }

    /* renamed from: a */
    public void m55174a(float f10) {
        this.f43724b = f10;
    }

    /* renamed from: a */
    private void m55167a(LinearLayoutManager linearLayoutManager) {
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        Integer numPeek = this.f43728f.peek();
        while (numPeek != null && numPeek.intValue() > iFindFirstVisibleItemPosition) {
            this.f43728f.pop();
            numPeek = this.f43728f.peek();
        }
        if (!this.f43728f.isEmpty()) {
            linearLayoutManager.scrollToPositionWithOffset(this.f43728f.pop().intValue(), 0);
        } else {
            linearLayoutManager.scrollToPositionWithOffset(0, 0);
        }
    }

    /* renamed from: a */
    private boolean m55170a(RecyclerView.AbstractC0846p abstractC0846p, View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            return false;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        return z10 ? abstractC0846p.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin > this.f43727e.getHeight() - this.f43727e.getPaddingBottom() : m55169a() ? abstractC0846p.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin < this.f43727e.getPaddingLeft() : abstractC0846p.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin > this.f43727e.getWidth() - this.f43727e.getPaddingRight();
    }

    /* renamed from: b */
    public void m55176b(float f10) {
        this.f43723a = f10;
    }

    /* renamed from: b */
    private void m55172b(RecyclerView.AbstractC0846p abstractC0846p, float f10) {
        int width = (this.f43727e.getWidth() - this.f43727e.getPaddingRight()) - this.f43727e.getPaddingLeft();
        if (Float.compare(Math.abs(f10), width * this.f43724b) < 0) {
            return;
        }
        if (!(abstractC0846p instanceof LinearLayoutManager)) {
            HwRecyclerView hwRecyclerView = this.f43727e;
            if (((int) f10) > 0) {
                width = -width;
            }
            hwRecyclerView.scrollBy(width, 0);
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) abstractC0846p;
        if (Float.compare(f10, 0.0f) < 0) {
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition) == null) {
                Log.e(f43722g, "Page turning scroll horizontally rtl error, first visible item view is null.");
                return;
            }
            if (!m55171a(false)) {
                this.f43728f.push(Integer.valueOf(iFindFirstVisibleItemPosition));
            }
            int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindLastVisibleItemPosition);
            if (viewFindViewByPosition == null) {
                Log.e(f43722g, "Page turning scroll horizontally rtl error, last visible item view is null.");
                return;
            } else if (m55170a(linearLayoutManager, viewFindViewByPosition, false)) {
                linearLayoutManager.scrollToPositionWithOffset(iFindLastVisibleItemPosition, 0);
                return;
            } else {
                linearLayoutManager.scrollToPositionWithOffset(iFindLastVisibleItemPosition + 1, 0);
                return;
            }
        }
        m55167a(linearLayoutManager);
    }

    /* renamed from: a */
    private void m55168a(RecyclerView.AbstractC0846p abstractC0846p, float f10) {
        int width = (this.f43727e.getWidth() - this.f43727e.getPaddingRight()) - this.f43727e.getPaddingLeft();
        if (Float.compare(Math.abs(f10), width * this.f43724b) < 0) {
            return;
        }
        if (!(abstractC0846p instanceof LinearLayoutManager)) {
            HwRecyclerView hwRecyclerView = this.f43727e;
            if (Float.compare(f10, 0.0f) <= 0) {
                width = -width;
            }
            hwRecyclerView.scrollBy(width, 0);
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) abstractC0846p;
        if (Float.compare(f10, 0.0f) > 0) {
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition) == null) {
                Log.e(f43722g, "Page turning scroll horizontally error, first visible item view is null.");
                return;
            }
            if (!m55171a(false)) {
                this.f43728f.push(Integer.valueOf(iFindFirstVisibleItemPosition));
            }
            int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindLastVisibleItemPosition);
            if (viewFindViewByPosition == null) {
                Log.e(f43722g, "Page turning scroll horizontally error, last visible item view is null.");
                return;
            } else if (m55170a(linearLayoutManager, viewFindViewByPosition, false)) {
                linearLayoutManager.scrollToPositionWithOffset(iFindLastVisibleItemPosition, 0);
                return;
            } else {
                linearLayoutManager.scrollToPositionWithOffset(iFindLastVisibleItemPosition + 1, 0);
                return;
            }
        }
        m55167a(linearLayoutManager);
    }

    /* renamed from: a */
    private boolean m55169a() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    /* renamed from: a */
    private boolean m55171a(boolean z10) {
        return z10 ? this.f43727e.computeVerticalScrollOffset() + this.f43727e.computeVerticalScrollExtent() >= this.f43727e.computeVerticalScrollRange() : this.f43727e.computeHorizontalScrollOffset() + this.f43727e.computeHorizontalScrollExtent() >= this.f43727e.computeHorizontalScrollRange();
    }
}
