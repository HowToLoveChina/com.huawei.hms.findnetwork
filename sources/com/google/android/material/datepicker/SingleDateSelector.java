package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R$attr;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new C1726b();

    /* renamed from: a */
    public Long f7918a;

    /* renamed from: com.google.android.material.datepicker.SingleDateSelector$a */
    public class C1725a extends AbstractC1729c {

        /* renamed from: g */
        public final /* synthetic */ AbstractC1738l f7919g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1725a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, AbstractC1738l abstractC1738l) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f7919g = abstractC1738l;
        }

        @Override // com.google.android.material.datepicker.AbstractC1729c
        /* renamed from: e */
        public void mo10267e() {
            this.f7919g.mo10346a();
        }

        @Override // com.google.android.material.datepicker.AbstractC1729c
        /* renamed from: f */
        public void mo10268f(Long l10) {
            if (l10 == null) {
                SingleDateSelector.this.m10273d();
            } else {
                SingleDateSelector.this.mo10232q0(l10.longValue());
            }
            this.f7919g.mo10347b(SingleDateSelector.this.mo10231i0());
        }
    }

    /* renamed from: com.google.android.material.datepicker.SingleDateSelector$b */
    public class C1726b implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f7918a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: C */
    public View mo10226C(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, AbstractC1738l<Long> abstractC1738l) throws Resources.NotFoundException {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (C1775f.m10684a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatM10379f = C1742p.m10379f();
        String strM10380g = C1742p.m10380g(viewInflate.getResources(), simpleDateFormatM10379f);
        textInputLayout.setPlaceholderText(strM10380g);
        Long l10 = this.f7918a;
        if (l10 != null) {
            editText.setText(simpleDateFormatM10379f.format(l10));
        }
        editText.addTextChangedListener(new C1725a(strM10380g, simpleDateFormatM10379f, textInputLayout, calendarConstraints, abstractC1738l));
        C1788s.m10791l(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: G */
    public int mo10227G(Context context) {
        return C9648b.m60263d(context, R$attr.materialCalendarTheme, C1733g.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: J */
    public boolean mo10228J() {
        return this.f7918a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: X */
    public Collection<Long> mo10229X() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f7918a;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: b */
    public String mo10230b(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f7918a;
        if (l10 == null) {
            return resources.getString(R$string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R$string.mtrl_picker_date_header_selected, C1730d.m10295j(l10.longValue()));
    }

    /* renamed from: d */
    public final void m10273d() {
        this.f7918a = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long mo10231i0() {
        return this.f7918a;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: q0 */
    public void mo10232q0(long j10) {
        this.f7918a = Long.valueOf(j10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: u */
    public Collection<C9369d<Long, Long>> mo10233u() {
        return new ArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f7918a);
    }
}
