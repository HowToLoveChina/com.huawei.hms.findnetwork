package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* renamed from: com.google.android.material.datepicker.i */
/* loaded from: classes.dex */
public final class C1735i<S> extends AbstractC1739m<S> {

    /* renamed from: d0 */
    public int f8017d0;

    /* renamed from: e0 */
    public DateSelector<S> f8018e0;

    /* renamed from: f0 */
    public CalendarConstraints f8019f0;

    /* renamed from: com.google.android.material.datepicker.i$a */
    public class a extends AbstractC1738l<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.AbstractC1738l
        /* renamed from: a */
        public void mo10346a() {
            Iterator<AbstractC1738l<S>> it = C1735i.this.f8035c0.iterator();
            while (it.hasNext()) {
                it.next().mo10346a();
            }
        }

        @Override // com.google.android.material.datepicker.AbstractC1738l
        /* renamed from: b */
        public void mo10347b(S s10) {
            Iterator<AbstractC1738l<S>> it = C1735i.this.f8035c0.iterator();
            while (it.hasNext()) {
                it.next().mo10347b(s10);
            }
        }
    }

    /* renamed from: E1 */
    public static <T> C1735i<T> m10349E1(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints) {
        C1735i<T> c1735i = new C1735i<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        c1735i.m4437s1(bundle);
        return c1735i;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: H0 */
    public void mo4350H0(Bundle bundle) {
        super.mo4350H0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f8017d0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f8018e0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f8019f0);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: l0 */
    public void mo4415l0(Bundle bundle) {
        super.mo4415l0(bundle);
        if (bundle == null) {
            bundle = m4420n();
        }
        this.f8017d0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f8018e0 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f8019f0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public View mo4427p0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f8018e0.mo10226C(layoutInflater.cloneInContext(new ContextThemeWrapper(m4426p(), this.f8017d0)), viewGroup, bundle, this.f8019f0, new a());
    }
}
