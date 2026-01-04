package com.google.android.material.datepicker;

import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import p243e0.C9369d;

/* renamed from: com.google.android.material.datepicker.d */
/* loaded from: classes.dex */
public class C1730d {
    /* renamed from: a */
    public static C9369d<String, String> m10286a(Long l10, Long l11) {
        return m10287b(l10, l11, null);
    }

    /* renamed from: b */
    public static C9369d<String, String> m10287b(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return C9369d.m58736a(null, null);
        }
        if (l10 == null) {
            return C9369d.m58736a(null, m10289d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return C9369d.m58736a(m10289d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar calendarM10383j = C1742p.m10383j();
        Calendar calendarM10385l = C1742p.m10385l();
        calendarM10385l.setTimeInMillis(l10.longValue());
        Calendar calendarM10385l2 = C1742p.m10385l();
        calendarM10385l2.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return C9369d.m58736a(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        }
        return calendarM10385l.get(1) == calendarM10385l2.get(1) ? calendarM10385l.get(1) == calendarM10383j.get(1) ? C9369d.m58736a(m10291f(l10.longValue(), Locale.getDefault()), m10291f(l11.longValue(), Locale.getDefault())) : C9369d.m58736a(m10291f(l10.longValue(), Locale.getDefault()), m10296k(l11.longValue(), Locale.getDefault())) : C9369d.m58736a(m10296k(l10.longValue(), Locale.getDefault()), m10296k(l11.longValue(), Locale.getDefault()));
    }

    /* renamed from: c */
    public static String m10288c(long j10) {
        return m10289d(j10, null);
    }

    /* renamed from: d */
    public static String m10289d(long j10, SimpleDateFormat simpleDateFormat) {
        Calendar calendarM10383j = C1742p.m10383j();
        Calendar calendarM10385l = C1742p.m10385l();
        calendarM10385l.setTimeInMillis(j10);
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j10)) : calendarM10383j.get(1) == calendarM10385l.get(1) ? m10290e(j10) : m10295j(j10);
    }

    /* renamed from: e */
    public static String m10290e(long j10) {
        return m10291f(j10, Locale.getDefault());
    }

    /* renamed from: f */
    public static String m10291f(long j10, Locale locale) {
        return C1742p.m10375b(locale).format(new Date(j10));
    }

    /* renamed from: g */
    public static String m10292g(long j10) {
        return m10293h(j10, Locale.getDefault());
    }

    /* renamed from: h */
    public static String m10293h(long j10, Locale locale) {
        return C1742p.m10376c(locale).format(new Date(j10));
    }

    /* renamed from: i */
    public static String m10294i(long j10) {
        return DateUtils.formatDateTime(null, j10, 8228);
    }

    /* renamed from: j */
    public static String m10295j(long j10) {
        return m10296k(j10, Locale.getDefault());
    }

    /* renamed from: k */
    public static String m10296k(long j10, Locale locale) {
        return C1742p.m10387n(locale).format(new Date(j10));
    }

    /* renamed from: l */
    public static String m10297l(long j10) {
        return m10298m(j10, Locale.getDefault());
    }

    /* renamed from: m */
    public static String m10298m(long j10, Locale locale) {
        return C1742p.m10388o(locale).format(new Date(j10));
    }
}
