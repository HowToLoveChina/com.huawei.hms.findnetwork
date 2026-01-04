package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.material.datepicker.p */
/* loaded from: classes.dex */
public class C1742p {

    /* renamed from: a */
    public static AtomicReference<C1741o> f8040a = new AtomicReference<>();

    /* renamed from: a */
    public static long m10374a(long j10) {
        Calendar calendarM10385l = m10385l();
        calendarM10385l.setTimeInMillis(j10);
        return m10378e(calendarM10385l).getTimeInMillis();
    }

    @TargetApi(24)
    /* renamed from: b */
    public static DateFormat m10375b(Locale locale) {
        return m10377d("MMMd", locale);
    }

    @TargetApi(24)
    /* renamed from: c */
    public static DateFormat m10376c(Locale locale) {
        return m10377d("MMMEd", locale);
    }

    @TargetApi(24)
    /* renamed from: d */
    public static DateFormat m10377d(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(m10384k());
        return instanceForSkeleton;
    }

    /* renamed from: e */
    public static Calendar m10378e(Calendar calendar) {
        Calendar calendarM10386m = m10386m(calendar);
        Calendar calendarM10385l = m10385l();
        calendarM10385l.set(calendarM10386m.get(1), calendarM10386m.get(2), calendarM10386m.get(5));
        return calendarM10385l;
    }

    /* renamed from: f */
    public static SimpleDateFormat m10379f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(m10382i());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* renamed from: g */
    public static String m10380g(Resources resources, SimpleDateFormat simpleDateFormat) throws Resources.NotFoundException {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R$string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R$string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R$string.mtrl_picker_text_input_day_abbr);
        if (pattern.replaceAll("[^y]", "").length() == 1) {
            pattern = pattern.replace("y", "yyyy");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    /* renamed from: h */
    public static C1741o m10381h() {
        C1741o c1741o = f8040a.get();
        return c1741o == null ? C1741o.m10371c() : c1741o;
    }

    /* renamed from: i */
    public static TimeZone m10382i() {
        return TimeZone.getTimeZone("UTC");
    }

    /* renamed from: j */
    public static Calendar m10383j() {
        Calendar calendarM10372a = m10381h().m10372a();
        calendarM10372a.set(11, 0);
        calendarM10372a.set(12, 0);
        calendarM10372a.set(13, 0);
        calendarM10372a.set(14, 0);
        calendarM10372a.setTimeZone(m10382i());
        return calendarM10372a;
    }

    @TargetApi(24)
    /* renamed from: k */
    public static android.icu.util.TimeZone m10384k() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    /* renamed from: l */
    public static Calendar m10385l() {
        return m10386m(null);
    }

    /* renamed from: m */
    public static Calendar m10386m(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(m10382i());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    /* renamed from: n */
    public static DateFormat m10387n(Locale locale) {
        return m10377d("yMMMd", locale);
    }

    @TargetApi(24)
    /* renamed from: o */
    public static DateFormat m10388o(Locale locale) {
        return m10377d("yMMMEd", locale);
    }
}
