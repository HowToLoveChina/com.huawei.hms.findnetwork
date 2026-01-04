package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.C1732f;
import p273f0.C9603h0;

/* renamed from: com.google.android.material.datepicker.k */
/* loaded from: classes.dex */
public class C1737k extends RecyclerView.AbstractC0838h<b> {

    /* renamed from: d */
    public final CalendarConstraints f8027d;

    /* renamed from: e */
    public final DateSelector<?> f8028e;

    /* renamed from: f */
    public final C1732f.l f8029f;

    /* renamed from: g */
    public final int f8030g;

    /* renamed from: com.google.android.material.datepicker.k$a */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        public final /* synthetic */ MaterialCalendarGridView f8031a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f8031a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (this.f8031a.getAdapter().m10363n(i10)) {
                C1737k.this.f8029f.mo10323a(this.f8031a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.k$b */
    public static class b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public final TextView f8033u;

        /* renamed from: v */
        public final MaterialCalendarGridView f8034v;

        public b(LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.f8033u = textView;
            C9603h0.m59904q0(textView, true);
            this.f8034v = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z10) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public C1737k(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, C1732f.l lVar) {
        Month monthM10213l = calendarConstraints.m10213l();
        Month monthM10210h = calendarConstraints.m10210h();
        Month monthM10212j = calendarConstraints.m10212j();
        if (monthM10213l.compareTo(monthM10212j) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthM10212j.compareTo(monthM10210h) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f8030g = (C1736j.f8021f * C1732f.m10308R1(context)) + (C1733g.m10335g2(context) ? C1732f.m10308R1(context) : 0);
        this.f8027d = calendarConstraints;
        this.f8028e = dateSelector;
        this.f8029f = lVar;
        m5205B(true);
    }

    /* renamed from: E */
    public Month m10365E(int i10) {
        return this.f8027d.m10213l().m10253t(i10);
    }

    /* renamed from: F */
    public CharSequence m10366F(int i10) {
        return m10365E(i10).m10251r();
    }

    /* renamed from: G */
    public int m10367G(Month month) {
        return this.f8027d.m10213l().m10254v(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: H */
    public void mo723s(b bVar, int i10) {
        Month monthM10253t = this.f8027d.m10213l().m10253t(i10);
        bVar.f8033u.setText(monthM10253t.m10251r());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f8034v.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthM10253t.equals(materialCalendarGridView.getAdapter().f8022a)) {
            C1736j c1736j = new C1736j(monthM10253t, this.f8028e, this.f8027d);
            materialCalendarGridView.setNumColumns(monthM10253t.f7900d);
            materialCalendarGridView.setAdapter((ListAdapter) c1736j);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().m10362m(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: I */
    public b mo724u(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!C1733g.m10335g2(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f8030g));
        return new b(linearLayout, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f8027d.m10211i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return this.f8027d.m10213l().m10253t(i10).m10252s();
    }
}
