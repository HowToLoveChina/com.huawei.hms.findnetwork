package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import java.util.Arrays;
import p243e0.C9368c;

/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new C1712a();

    /* renamed from: a */
    public final Month f7873a;

    /* renamed from: b */
    public final Month f7874b;

    /* renamed from: c */
    public final DateValidator f7875c;

    /* renamed from: d */
    public Month f7876d;

    /* renamed from: e */
    public final int f7877e;

    /* renamed from: f */
    public final int f7878f;

    public interface DateValidator extends Parcelable {
        /* renamed from: k */
        boolean mo10216k(long j10);
    }

    /* renamed from: com.google.android.material.datepicker.CalendarConstraints$a */
    public class C1712a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i10) {
            return new CalendarConstraints[i10];
        }
    }

    /* renamed from: com.google.android.material.datepicker.CalendarConstraints$b */
    public static final class C1713b {

        /* renamed from: e */
        public static final long f7879e = C1742p.m10374a(Month.m10244e(HwConstants.LUNAR_YEAR_MIN, 0).f7902f);

        /* renamed from: f */
        public static final long f7880f = C1742p.m10374a(Month.m10244e(HwConstants.LUNAR_YEAR_MAX, 11).f7902f);

        /* renamed from: a */
        public long f7881a;

        /* renamed from: b */
        public long f7882b;

        /* renamed from: c */
        public Long f7883c;

        /* renamed from: d */
        public DateValidator f7884d;

        public C1713b(CalendarConstraints calendarConstraints) {
            this.f7881a = f7879e;
            this.f7882b = f7880f;
            this.f7884d = DateValidatorPointForward.m10236a(Long.MIN_VALUE);
            this.f7881a = calendarConstraints.f7873a.f7902f;
            this.f7882b = calendarConstraints.f7874b.f7902f;
            this.f7883c = Long.valueOf(calendarConstraints.f7876d.f7902f);
            this.f7884d = calendarConstraints.f7875c;
        }

        /* renamed from: a */
        public CalendarConstraints m10219a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f7884d);
            Month monthM10245f = Month.m10245f(this.f7881a);
            Month monthM10245f2 = Month.m10245f(this.f7882b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l10 = this.f7883c;
            return new CalendarConstraints(monthM10245f, monthM10245f2, dateValidator, l10 == null ? null : Month.m10245f(l10.longValue()), null);
        }

        /* renamed from: b */
        public C1713b m10220b(long j10) {
            this.f7883c = Long.valueOf(j10);
            return this;
        }
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, C1712a c1712a) {
        this(month, month2, dateValidator, month3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f7873a.equals(calendarConstraints.f7873a) && this.f7874b.equals(calendarConstraints.f7874b) && C9368c.m58729a(this.f7876d, calendarConstraints.f7876d) && this.f7875c.equals(calendarConstraints.f7875c);
    }

    /* renamed from: f */
    public Month m10208f(Month month) {
        return month.compareTo(this.f7873a) < 0 ? this.f7873a : month.compareTo(this.f7874b) > 0 ? this.f7874b : month;
    }

    /* renamed from: g */
    public DateValidator m10209g() {
        return this.f7875c;
    }

    /* renamed from: h */
    public Month m10210h() {
        return this.f7874b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7873a, this.f7874b, this.f7876d, this.f7875c});
    }

    /* renamed from: i */
    public int m10211i() {
        return this.f7878f;
    }

    /* renamed from: j */
    public Month m10212j() {
        return this.f7876d;
    }

    /* renamed from: l */
    public Month m10213l() {
        return this.f7873a;
    }

    /* renamed from: m */
    public int m10214m() {
        return this.f7877e;
    }

    /* renamed from: n */
    public boolean m10215n(long j10) {
        if (this.f7873a.m10249p(1) <= j10) {
            Month month = this.f7874b;
            if (j10 <= month.m10249p(month.f7901e)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7873a, 0);
        parcel.writeParcelable(this.f7874b, 0);
        parcel.writeParcelable(this.f7876d, 0);
        parcel.writeParcelable(this.f7875c, 0);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.f7873a = month;
        this.f7874b = month2;
        this.f7876d = month3;
        this.f7875c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f7878f = month.m10254v(month2) + 1;
        this.f7877e = (month2.f7899c - month.f7899c) + 1;
    }
}
