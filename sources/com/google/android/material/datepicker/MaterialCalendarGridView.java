package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.material.R$id;
import com.google.android.material.internal.C1788s;
import java.util.Calendar;
import java.util.Iterator;
import p243e0.C9369d;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9832l;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: a */
    public final Calendar f7891a;

    /* renamed from: b */
    public final boolean f7892b;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendarGridView$a */
    public class C1720a extends C9582a {
        public C1720a() {
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61067W(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    /* renamed from: d */
    public static int m10239d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    /* renamed from: e */
    public static boolean m10240e(Long l10, Long l11, Long l12, Long l13) {
        return l10 == null || l11 == null || l12 == null || l13 == null || l12.longValue() > l11.longValue() || l13.longValue() < l10.longValue();
    }

    /* renamed from: a */
    public final void m10241a(int i10, Rect rect) {
        if (i10 == 33) {
            setSelection(getAdapter().m10358i());
        } else if (i10 == 130) {
            setSelection(getAdapter().m10351b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1736j getAdapter() {
        return (C1736j) super.getAdapter();
    }

    /* renamed from: c */
    public final View m10243c(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iM10350a;
        int iM10239d;
        int iM10350a2;
        int iM10239d2;
        int width;
        int i10;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        C1736j adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f8023b;
        C1728b c1728b = adapter.f8025d;
        int iMax = Math.max(adapter.m10351b(), getFirstVisiblePosition());
        int iMin = Math.min(adapter.m10358i(), getLastVisiblePosition());
        Long item = adapter.getItem(iMax);
        Long item2 = adapter.getItem(iMin);
        Iterator<C9369d<Long, Long>> it = dateSelector.mo10233u().iterator();
        while (it.hasNext()) {
            C9369d<Long, Long> next = it.next();
            Long l10 = next.f46769a;
            if (l10 == null) {
                materialCalendarGridView = this;
            } else if (next.f46770b != null) {
                Long l11 = l10;
                long jLongValue = l11.longValue();
                Long l12 = next.f46770b;
                long jLongValue2 = l12.longValue();
                if (!m10240e(item, item2, l11, l12)) {
                    boolean zM10788i = C1788s.m10788i(this);
                    if (jLongValue < item.longValue()) {
                        iM10239d = adapter.m10355f(iMax) ? 0 : !zM10788i ? materialCalendarGridView.m10243c(iMax - 1).getRight() : materialCalendarGridView.m10243c(iMax - 1).getLeft();
                        iM10350a = iMax;
                    } else {
                        materialCalendarGridView.f7891a.setTimeInMillis(jLongValue);
                        iM10350a = adapter.m10350a(materialCalendarGridView.f7891a.get(5));
                        iM10239d = m10239d(materialCalendarGridView.m10243c(iM10350a));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iM10239d2 = adapter.m10356g(iMin) ? getWidth() : !zM10788i ? materialCalendarGridView.m10243c(iMin).getRight() : materialCalendarGridView.m10243c(iMin).getLeft();
                        iM10350a2 = iMin;
                    } else {
                        materialCalendarGridView.f7891a.setTimeInMillis(jLongValue2);
                        iM10350a2 = adapter.m10350a(materialCalendarGridView.f7891a.get(5));
                        iM10239d2 = m10239d(materialCalendarGridView.m10243c(iM10350a2));
                    }
                    int itemId = (int) adapter.getItemId(iM10350a);
                    int i11 = iMax;
                    int i12 = iMin;
                    int itemId2 = (int) adapter.getItemId(iM10350a2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View viewM10243c = materialCalendarGridView.m10243c(numColumns);
                        int top = viewM10243c.getTop() + c1728b.f7927a.m10279c();
                        C1736j c1736j = adapter;
                        int bottom = viewM10243c.getBottom() - c1728b.f7927a.m10278b();
                        if (zM10788i) {
                            int i13 = iM10350a2 > numColumns2 ? 0 : iM10239d2;
                            width = numColumns > iM10350a ? getWidth() : iM10239d;
                            i10 = i13;
                        } else {
                            i10 = numColumns > iM10350a ? 0 : iM10239d;
                            width = iM10350a2 > numColumns2 ? getWidth() : iM10239d2;
                        }
                        canvas.drawRect(i10, top, width, bottom, c1728b.f7934h);
                        itemId++;
                        materialCalendarGridView = this;
                        it = it;
                        adapter = c1736j;
                    }
                    materialCalendarGridView = this;
                    iMax = i11;
                    iMin = i12;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            m10241a(i10, rect);
        } else {
            super.onFocusChanged(false, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().m10351b()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().m10351b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!this.f7892b) {
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i10) {
        if (i10 < getAdapter().m10351b()) {
            super.setSelection(getAdapter().m10351b());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof C1736j)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), C1736j.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7891a = C1742p.m10385l();
        if (C1733g.m10335g2(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.f7892b = C1733g.m10336h2(getContext());
        C9603h0.m59902p0(this, new C1720a());
    }
}
