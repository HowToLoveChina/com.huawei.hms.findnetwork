package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.C1732f;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.google.android.material.datepicker.q */
/* loaded from: classes.dex */
public class C1743q extends RecyclerView.AbstractC0838h<b> {

    /* renamed from: d */
    public final C1732f<?> f8041d;

    /* renamed from: com.google.android.material.datepicker.q$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f8042a;

        public a(int i10) {
            this.f8042a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1743q.this.f8041d.m10320W1(C1743q.this.f8041d.m10314N1().m10208f(Month.m10244e(this.f8042a, C1743q.this.f8041d.m10316P1().f7898b)));
            C1743q.this.f8041d.m10321X1(C1732f.k.DAY);
        }
    }

    /* renamed from: com.google.android.material.datepicker.q$b */
    public static class b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public final TextView f8044u;

        public b(TextView textView) {
            super(textView);
            this.f8044u = textView;
        }
    }

    public C1743q(C1732f<?> c1732f) {
        this.f8041d = c1732f;
    }

    /* renamed from: E */
    public final View.OnClickListener m10390E(int i10) {
        return new a(i10);
    }

    /* renamed from: F */
    public int m10391F(int i10) {
        return i10 - this.f8041d.m10314N1().m10213l().f7899c;
    }

    /* renamed from: G */
    public int m10392G(int i10) {
        return this.f8041d.m10314N1().m10213l().f7899c + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: H */
    public void mo723s(b bVar, int i10) {
        int iM10392G = m10392G(i10);
        String string = bVar.f8044u.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        bVar.f8044u.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iM10392G)));
        bVar.f8044u.setContentDescription(String.format(string, Integer.valueOf(iM10392G)));
        C1728b c1728bM10315O1 = this.f8041d.m10315O1();
        Calendar calendarM10383j = C1742p.m10383j();
        C1727a c1727a = calendarM10383j.get(1) == iM10392G ? c1728bM10315O1.f7932f : c1728bM10315O1.f7930d;
        Iterator<Long> it = this.f8041d.m10317Q1().mo10229X().iterator();
        while (it.hasNext()) {
            calendarM10383j.setTimeInMillis(it.next().longValue());
            if (calendarM10383j.get(1) == iM10392G) {
                c1727a = c1728bM10315O1.f7931e;
            }
        }
        c1727a.m10280d(bVar.f8044u);
        bVar.f8044u.setOnClickListener(m10390E(iM10392G));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: I */
    public b mo724u(ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f8041d.m10314N1().m10214m();
    }
}
