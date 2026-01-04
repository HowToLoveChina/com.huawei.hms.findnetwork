package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.google.android.material.datepicker.j */
/* loaded from: classes.dex */
public class C1736j extends BaseAdapter {

    /* renamed from: f */
    public static final int f8021f = C1742p.m10385l().getMaximum(4);

    /* renamed from: a */
    public final Month f8022a;

    /* renamed from: b */
    public final DateSelector<?> f8023b;

    /* renamed from: c */
    public Collection<Long> f8024c;

    /* renamed from: d */
    public C1728b f8025d;

    /* renamed from: e */
    public final CalendarConstraints f8026e;

    public C1736j(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f8022a = month;
        this.f8023b = dateSelector;
        this.f8026e = calendarConstraints;
        this.f8024c = dateSelector.mo10229X();
    }

    /* renamed from: a */
    public int m10350a(int i10) {
        return m10351b() + (i10 - 1);
    }

    /* renamed from: b */
    public int m10351b() {
        return this.f8022a.m10248i();
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public Long getItem(int i10) {
        if (i10 < this.f8022a.m10248i() || i10 > m10358i()) {
            return null;
        }
        return Long.valueOf(this.f8022a.m10249p(m10359j(i10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    @Override // android.widget.Adapter
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.m10354e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.m10351b()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.Month r8 = r5.f8022a
            int r2 = r8.f7901e
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.f8022a
            long r7 = r8.m10249p(r7)
            com.google.android.material.datepicker.Month r3 = r5.f8022a
            int r3 = r3.f7899c
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.m10246h()
            int r4 = r4.f7899c
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.C1730d.m10292g(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.C1730d.m10297l(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.m10360k(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.C1736j.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* renamed from: e */
    public final void m10354e(Context context) {
        if (this.f8025d == null) {
            this.f8025d = new C1728b(context);
        }
    }

    /* renamed from: f */
    public boolean m10355f(int i10) {
        return i10 % this.f8022a.f7900d == 0;
    }

    /* renamed from: g */
    public boolean m10356g(int i10) {
        return (i10 + 1) % this.f8022a.f7900d == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8022a.f7901e + m10351b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f8022a.f7900d;
    }

    /* renamed from: h */
    public final boolean m10357h(long j10) {
        Iterator<Long> it = this.f8023b.mo10229X().iterator();
        while (it.hasNext()) {
            if (C1742p.m10374a(j10) == C1742p.m10374a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* renamed from: i */
    public int m10358i() {
        return (this.f8022a.m10248i() + this.f8022a.f7901e) - 1;
    }

    /* renamed from: j */
    public int m10359j(int i10) {
        return (i10 - this.f8022a.m10248i()) + 1;
    }

    /* renamed from: k */
    public final void m10360k(TextView textView, long j10) {
        C1727a c1727a;
        if (textView == null) {
            return;
        }
        if (this.f8026e.m10209g().mo10216k(j10)) {
            textView.setEnabled(true);
            c1727a = m10357h(j10) ? this.f8025d.f7928b : C1742p.m10383j().getTimeInMillis() == j10 ? this.f8025d.f7929c : this.f8025d.f7927a;
        } else {
            textView.setEnabled(false);
            c1727a = this.f8025d.f7933g;
        }
        c1727a.m10280d(textView);
    }

    /* renamed from: l */
    public final void m10361l(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.m10245f(j10).equals(this.f8022a)) {
            m10360k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().m10350a(this.f8022a.m10250q(j10)) - materialCalendarGridView.getFirstVisiblePosition()), j10);
        }
    }

    /* renamed from: m */
    public void m10362m(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f8024c.iterator();
        while (it.hasNext()) {
            m10361l(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.f8023b;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.mo10229X().iterator();
            while (it2.hasNext()) {
                m10361l(materialCalendarGridView, it2.next().longValue());
            }
            this.f8024c = this.f8023b.mo10229X();
        }
    }

    /* renamed from: n */
    public boolean m10363n(int i10) {
        return i10 >= m10351b() && i10 <= m10358i();
    }
}
