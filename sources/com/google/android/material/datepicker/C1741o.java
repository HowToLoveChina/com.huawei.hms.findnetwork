package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: com.google.android.material.datepicker.o */
/* loaded from: classes.dex */
public class C1741o {

    /* renamed from: c */
    public static final C1741o f8037c = new C1741o(null, null);

    /* renamed from: a */
    public final Long f8038a;

    /* renamed from: b */
    public final TimeZone f8039b;

    public C1741o(Long l10, TimeZone timeZone) {
        this.f8038a = l10;
        this.f8039b = timeZone;
    }

    /* renamed from: c */
    public static C1741o m10371c() {
        return f8037c;
    }

    /* renamed from: a */
    public Calendar m10372a() {
        return m10373b(this.f8039b);
    }

    /* renamed from: b */
    public Calendar m10373b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l10 = this.f8038a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
