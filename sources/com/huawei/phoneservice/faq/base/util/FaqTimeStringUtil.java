package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.text.format.DateUtils;
import androidx.annotation.Keep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
public class FaqTimeStringUtil {
    /* renamed from: a */
    public static String m51882a(Calendar calendar, Context context) {
        return m51883b(calendar, context, 196628);
    }

    /* renamed from: b */
    public static String m51883b(Calendar calendar, Context context, int i10) throws Throwable {
        if (context == null || calendar == null) {
            FaqLogger.m51836d("TimeStringUtil", "convertCalendarToString::context or calendar is null");
            return null;
        }
        try {
            return DateUtils.formatDateTime(context, calendar.getTimeInMillis(), i10);
        } catch (IllegalArgumentException unused) {
            FaqLogger.m51840e("TimeStringUtil", "get formatTime error");
            return null;
        }
    }

    /* renamed from: c */
    public static Calendar m51884c(Date date) throws Throwable {
        if (date == null) {
            FaqLogger.m51836d("TimeStringUtil", "convertDateToCalendar::date is null");
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /* renamed from: d */
    public static Date m51885d(String str) throws Throwable {
        Date dateM51886e = m51886e(str, "yyyy-M-d");
        return dateM51886e == null ? m51886e(str, "yyyy/M/d") : dateM51886e;
    }

    /* renamed from: e */
    public static Date m51886e(String str, String str2) throws Throwable {
        if (str2 == null || str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException unused) {
            FaqLogger.m51840e("TimeStringUtil", "convertStringToDate ParseException Exception ...");
            return null;
        }
    }

    /* renamed from: f */
    public static long m51887f(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str).getTime();
    }

    @Keep
    public static String formatDateString(String str, Context context) {
        String strM51882a = !FaqStringUtil.isEmpty(str) ? m51882a(m51884c(m51885d(str)), context) : "";
        return FaqStringUtil.isEmpty(strM51882a) ? "" : strM51882a;
    }
}
