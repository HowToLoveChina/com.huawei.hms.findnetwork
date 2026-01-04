package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new C1721a();

    /* renamed from: a */
    public final Calendar f7897a;

    /* renamed from: b */
    public final int f7898b;

    /* renamed from: c */
    public final int f7899c;

    /* renamed from: d */
    public final int f7900d;

    /* renamed from: e */
    public final int f7901e;

    /* renamed from: f */
    public final long f7902f;

    /* renamed from: g */
    public String f7903g;

    /* renamed from: com.google.android.material.datepicker.Month$a */
    public class C1721a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Month createFromParcel(Parcel parcel) {
            return Month.m10244e(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarM10378e = C1742p.m10378e(calendar);
        this.f7897a = calendarM10378e;
        this.f7898b = calendarM10378e.get(2);
        this.f7899c = calendarM10378e.get(1);
        this.f7900d = calendarM10378e.getMaximum(7);
        this.f7901e = calendarM10378e.getActualMaximum(5);
        this.f7902f = calendarM10378e.getTimeInMillis();
    }

    /* renamed from: e */
    public static Month m10244e(int i10, int i11) {
        Calendar calendarM10385l = C1742p.m10385l();
        calendarM10385l.set(1, i10);
        calendarM10385l.set(2, i11);
        return new Month(calendarM10385l);
    }

    /* renamed from: f */
    public static Month m10245f(long j10) {
        Calendar calendarM10385l = C1742p.m10385l();
        calendarM10385l.setTimeInMillis(j10);
        return new Month(calendarM10385l);
    }

    /* renamed from: h */
    public static Month m10246h() {
        return new Month(C1742p.m10383j());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Month month) {
        return this.f7897a.compareTo(month.f7897a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f7898b == month.f7898b && this.f7899c == month.f7899c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7898b), Integer.valueOf(this.f7899c)});
    }

    /* renamed from: i */
    public int m10248i() {
        int firstDayOfWeek = this.f7897a.get(7) - this.f7897a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f7900d : firstDayOfWeek;
    }

    /* renamed from: p */
    public long m10249p(int i10) {
        Calendar calendarM10378e = C1742p.m10378e(this.f7897a);
        calendarM10378e.set(5, i10);
        return calendarM10378e.getTimeInMillis();
    }

    /* renamed from: q */
    public int m10250q(long j10) {
        Calendar calendarM10378e = C1742p.m10378e(this.f7897a);
        calendarM10378e.setTimeInMillis(j10);
        return calendarM10378e.get(5);
    }

    /* renamed from: r */
    public String m10251r() {
        if (this.f7903g == null) {
            this.f7903g = C1730d.m10294i(this.f7897a.getTimeInMillis());
        }
        return this.f7903g;
    }

    /* renamed from: s */
    public long m10252s() {
        return this.f7897a.getTimeInMillis();
    }

    /* renamed from: t */
    public Month m10253t(int i10) {
        Calendar calendarM10378e = C1742p.m10378e(this.f7897a);
        calendarM10378e.add(2, i10);
        return new Month(calendarM10378e);
    }

    /* renamed from: v */
    public int m10254v(Month month) {
        if (this.f7897a instanceof GregorianCalendar) {
            return ((month.f7899c - this.f7899c) * 12) + (month.f7898b - this.f7898b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7899c);
        parcel.writeInt(this.f7898b);
    }
}
