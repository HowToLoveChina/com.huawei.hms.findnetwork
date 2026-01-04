package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;
import p243e0.C9373h;

/* loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* renamed from: a */
    public final InterfaceC1717d f7887a;

    /* renamed from: b */
    public final List<CalendarConstraints.DateValidator> f7888b;

    /* renamed from: c */
    public static final InterfaceC1717d f7885c = new C1714a();

    /* renamed from: d */
    public static final InterfaceC1717d f7886d = new C1715b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new C1716c();

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$a */
    public class C1714a implements InterfaceC1717d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC1717d
        /* renamed from: a */
        public boolean mo10223a(List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.mo10216k(j10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC1717d
        public int getId() {
            return 1;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$b */
    public class C1715b implements InterfaceC1717d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC1717d
        /* renamed from: a */
        public boolean mo10223a(List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.mo10216k(j10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.InterfaceC1717d
        public int getId() {
            return 2;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$c */
    public class C1716c implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i10 = parcel.readInt();
            InterfaceC1717d interfaceC1717d = (i10 != 2 && i10 == 1) ? CompositeDateValidator.f7885c : CompositeDateValidator.f7886d;
            return new CompositeDateValidator((List) C9373h.m58745f(arrayList), interfaceC1717d, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator[] newArray(int i10) {
            return new CompositeDateValidator[i10];
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$d */
    public interface InterfaceC1717d {
        /* renamed from: a */
        boolean mo10223a(List<CalendarConstraints.DateValidator> list, long j10);

        int getId();
    }

    public /* synthetic */ CompositeDateValidator(List list, InterfaceC1717d interfaceC1717d, C1714a c1714a) {
        this(list, interfaceC1717d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f7888b.equals(compositeDateValidator.f7888b) && this.f7887a.getId() == compositeDateValidator.f7887a.getId();
    }

    public int hashCode() {
        return this.f7888b.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    /* renamed from: k */
    public boolean mo10216k(long j10) {
        return this.f7887a.mo10223a(this.f7888b, j10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f7888b);
        parcel.writeInt(this.f7887a.getId());
    }

    public CompositeDateValidator(List<CalendarConstraints.DateValidator> list, InterfaceC1717d interfaceC1717d) {
        this.f7888b = list;
        this.f7887a = interfaceC1717d;
    }
}
