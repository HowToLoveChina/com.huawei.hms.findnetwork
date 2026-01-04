package com.huawei.uikit.hwlunar.utils;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class HwCustTime {

    /* renamed from: b */
    private static final int f42859b = -1;

    /* renamed from: a */
    GregorianCalendar f42860a;

    public HwCustTime() {
        this(TimeZone.getDefault());
    }

    /* renamed from: a */
    private int m54696a() {
        return this.f42860a.get(11);
    }

    /* renamed from: b */
    private int m54697b() {
        return this.f42860a.get(12);
    }

    /* renamed from: c */
    private int m54698c() {
        return this.f42860a.get(13);
    }

    public static long getCurrentMillis() {
        return new GregorianCalendar().getTimeInMillis();
    }

    public int getMonth() {
        return this.f42860a.get(2);
    }

    public int getMonthDay() {
        return this.f42860a.get(5);
    }

    public int getYear() {
        if (this.f42860a.get(0) == 0) {
            return 0;
        }
        return this.f42860a.get(1);
    }

    public void set(long j10) {
        if (j10 == -1) {
            return;
        }
        this.f42860a.setTimeInMillis(j10);
    }

    public String toString() {
        return " year:" + getYear() + " month:" + getMonth() + " monthDay:" + getMonthDay() + " hour:" + m54696a() + " minute:" + m54697b() + " second:" + m54698c();
    }

    public HwCustTime(String str) {
        this.f42860a = null;
        this.f42860a = new GregorianCalendar(TimeZone.getTimeZone(str));
    }

    public HwCustTime(TimeZone timeZone) {
        this.f42860a = null;
        this.f42860a = new GregorianCalendar(timeZone);
    }

    public HwCustTime(TimeZone timeZone, Locale locale) {
        this.f42860a = null;
        this.f42860a = new GregorianCalendar(timeZone, locale);
    }
}
