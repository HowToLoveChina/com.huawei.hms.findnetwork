package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.internal.C1775f;
import com.google.android.material.internal.C1788s;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import p243e0.C9369d;
import p276f3.C9648b;

/* loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<C9369d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new C1724c();

    /* renamed from: a */
    public String f7904a;

    /* renamed from: b */
    public final String f7905b = " ";

    /* renamed from: c */
    public Long f7906c = null;

    /* renamed from: d */
    public Long f7907d = null;

    /* renamed from: e */
    public Long f7908e = null;

    /* renamed from: f */
    public Long f7909f = null;

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$a */
    public class C1722a extends AbstractC1729c {

        /* renamed from: g */
        public final /* synthetic */ TextInputLayout f7910g;

        /* renamed from: h */
        public final /* synthetic */ TextInputLayout f7911h;

        /* renamed from: i */
        public final /* synthetic */ AbstractC1738l f7912i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1722a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, AbstractC1738l abstractC1738l) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f7910g = textInputLayout2;
            this.f7911h = textInputLayout3;
            this.f7912i = abstractC1738l;
        }

        @Override // com.google.android.material.datepicker.AbstractC1729c
        /* renamed from: e */
        public void mo10267e() {
            RangeDateSelector.this.f7908e = null;
            RangeDateSelector.this.m10266l(this.f7910g, this.f7911h, this.f7912i);
        }

        @Override // com.google.android.material.datepicker.AbstractC1729c
        /* renamed from: f */
        public void mo10268f(Long l10) {
            RangeDateSelector.this.f7908e = l10;
            RangeDateSelector.this.m10266l(this.f7910g, this.f7911h, this.f7912i);
        }
    }

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$b */
    public class C1723b extends AbstractC1729c {

        /* renamed from: g */
        public final /* synthetic */ TextInputLayout f7914g;

        /* renamed from: h */
        public final /* synthetic */ TextInputLayout f7915h;

        /* renamed from: i */
        public final /* synthetic */ AbstractC1738l f7916i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1723b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, AbstractC1738l abstractC1738l) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f7914g = textInputLayout2;
            this.f7915h = textInputLayout3;
            this.f7916i = abstractC1738l;
        }

        @Override // com.google.android.material.datepicker.AbstractC1729c
        /* renamed from: e */
        public void mo10267e() {
            RangeDateSelector.this.f7909f = null;
            RangeDateSelector.this.m10266l(this.f7914g, this.f7915h, this.f7916i);
        }

        @Override // com.google.android.material.datepicker.AbstractC1729c
        /* renamed from: f */
        public void mo10268f(Long l10) {
            RangeDateSelector.this.f7909f = l10;
            RangeDateSelector.this.m10266l(this.f7914g, this.f7915h, this.f7916i);
        }
    }

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$c */
    public class C1724c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f7906c = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f7907d = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: C */
    public View mo10226C(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, AbstractC1738l<C9369d<Long, Long>> abstractC1738l) throws Resources.NotFoundException {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (C1775f.m10684a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f7904a = viewInflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatM10379f = C1742p.m10379f();
        Long l10 = this.f7906c;
        if (l10 != null) {
            editText.setText(simpleDateFormatM10379f.format(l10));
            this.f7908e = this.f7906c;
        }
        Long l11 = this.f7907d;
        if (l11 != null) {
            editText2.setText(simpleDateFormatM10379f.format(l11));
            this.f7909f = this.f7907d;
        }
        String strM10380g = C1742p.m10380g(viewInflate.getResources(), simpleDateFormatM10379f);
        textInputLayout.setPlaceholderText(strM10380g);
        textInputLayout2.setPlaceholderText(strM10380g);
        editText.addTextChangedListener(new C1722a(strM10380g, simpleDateFormatM10379f, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, abstractC1738l));
        editText2.addTextChangedListener(new C1723b(strM10380g, simpleDateFormatM10379f, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, abstractC1738l));
        C1788s.m10791l(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: G */
    public int mo10227G(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return C9648b.m60263d(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, C1733g.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: J */
    public boolean mo10228J() {
        Long l10 = this.f7906c;
        return (l10 == null || this.f7907d == null || !m10264i(l10.longValue(), this.f7907d.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: X */
    public Collection<Long> mo10229X() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f7906c;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.f7907d;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: b */
    public String mo10230b(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f7906c;
        if (l10 == null && this.f7907d == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l11 = this.f7907d;
        if (l11 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, C1730d.m10288c(l10.longValue()));
        }
        if (l10 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, C1730d.m10288c(l11.longValue()));
        }
        C9369d<String, String> c9369dM10286a = C1730d.m10286a(l10, l11);
        return resources.getString(R$string.mtrl_picker_range_header_selected, c9369dM10286a.f46769a, c9369dM10286a.f46770b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: g */
    public final void m10262g(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f7904a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C9369d<Long, Long> mo10231i0() {
        return new C9369d<>(this.f7906c, this.f7907d);
    }

    /* renamed from: i */
    public final boolean m10264i(long j10, long j11) {
        return j10 <= j11;
    }

    /* renamed from: j */
    public final void m10265j(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f7904a);
        textInputLayout2.setError(" ");
    }

    /* renamed from: l */
    public final void m10266l(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, AbstractC1738l<C9369d<Long, Long>> abstractC1738l) {
        Long l10 = this.f7908e;
        if (l10 == null || this.f7909f == null) {
            m10262g(textInputLayout, textInputLayout2);
            abstractC1738l.mo10346a();
        } else if (!m10264i(l10.longValue(), this.f7909f.longValue())) {
            m10265j(textInputLayout, textInputLayout2);
            abstractC1738l.mo10346a();
        } else {
            this.f7906c = this.f7908e;
            this.f7907d = this.f7909f;
            abstractC1738l.mo10347b(mo10231i0());
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: q0 */
    public void mo10232q0(long j10) {
        Long l10 = this.f7906c;
        if (l10 == null) {
            this.f7906c = Long.valueOf(j10);
        } else if (this.f7907d == null && m10264i(l10.longValue(), j10)) {
            this.f7907d = Long.valueOf(j10);
        } else {
            this.f7907d = null;
            this.f7906c = Long.valueOf(j10);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: u */
    public Collection<C9369d<Long, Long>> mo10233u() {
        if (this.f7906c == null || this.f7907d == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C9369d(this.f7906c, this.f7907d));
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f7906c);
        parcel.writeValue(this.f7907d);
    }
}
