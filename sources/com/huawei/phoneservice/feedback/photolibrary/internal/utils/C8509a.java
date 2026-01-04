package com.huawei.phoneservice.feedback.photolibrary.internal.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p692uw.C13267j;

/* renamed from: com.huawei.phoneservice.feedback.photolibrary.internal.utils.a */
/* loaded from: classes5.dex */
public final class C8509a {

    /* renamed from: a */
    public static final C8509a f39689a = new C8509a();

    /* renamed from: b */
    public static final ThreadLocal<SimpleDateFormat> f39690b = new ThreadLocal<>();

    /* renamed from: a */
    public static final String m52861a(String str, String str2, Context context) throws Throwable {
        if (!TextUtils.isEmpty(str)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                Date date = simpleDateFormat.parse(str);
                C13267j.m79676d(date, "utcFormater.parse(utcTime)");
                if (!TextUtils.isEmpty(str2)) {
                    simpleDateFormat = new SimpleDateFormat(str2);
                }
                simpleDateFormat.setTimeZone(TimeZone.getDefault());
                String str3 = simpleDateFormat.format(Long.valueOf(date.getTime()));
                C13267j.m79676d(str3, "localFormater.format(gpsUTCDate.time)");
                return str3;
            } catch (ParseException e10) {
                FaqLogger.m51841e("FeedbackTimeUtils", "utc2Local failed. " + e10.getMessage(), new Object[0]);
            }
        }
        return "";
    }

    /* renamed from: c */
    public static final boolean m52862c(String str, Context context) throws Throwable {
        C8509a c8509a = f39689a;
        String strM52861a = m52861a(str, "yyyy-MM-dd HH:mm", context);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        Calendar calendar2 = Calendar.getInstance();
        try {
            SimpleDateFormat simpleDateFormatM52863b = c8509a.m52863b();
            C13267j.m79674b(simpleDateFormatM52863b);
            calendar2.setTime(simpleDateFormatM52863b.parse(strM52861a));
            return calendar2.get(1) == calendar.get(1) && calendar2.get(6) - calendar.get(6) == 0;
        } catch (ParseException e10) {
            FaqLogger.m51840e("FeedbackTimeUtils", e10.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public final SimpleDateFormat m52863b() {
        ThreadLocal<SimpleDateFormat> threadLocal = f39690b;
        if (threadLocal.get() == null) {
            threadLocal.set(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA));
        }
        return threadLocal.get();
    }
}
