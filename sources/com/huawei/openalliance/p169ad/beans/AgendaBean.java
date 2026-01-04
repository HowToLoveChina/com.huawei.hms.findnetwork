package com.huawei.openalliance.p169ad.beans;

import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;

/* loaded from: classes8.dex */
public class AgendaBean {

    @InterfaceC6932d(m39225a = "allday")
    private int allDay;
    private String description;

    @InterfaceC6932d(m39225a = CalendarConfigTable.CalendarTable.Events.D_TEND)
    private long dtEnd;

    @InterfaceC6932d(m39225a = CalendarConfigTable.CalendarTable.Events.DT_START)
    private long dtStart;
    private String location;
    private Integer minutes;

    @InterfaceC6932d(m39225a = "timezone")
    private String timeZone;
    private String title;

    /* renamed from: a */
    public String m39245a() {
        return this.title;
    }

    /* renamed from: b */
    public String m39247b() {
        return this.location;
    }

    /* renamed from: c */
    public long m39248c() {
        return this.dtStart;
    }

    /* renamed from: d */
    public long m39249d() {
        return this.dtEnd;
    }

    /* renamed from: e */
    public int m39250e() {
        return this.allDay;
    }

    /* renamed from: f */
    public String m39251f() {
        return this.timeZone;
    }

    /* renamed from: g */
    public Integer m39252g() {
        return this.minutes;
    }

    /* renamed from: h */
    public String m39253h() {
        return this.description;
    }

    /* renamed from: a */
    public void m39246a(int i10) {
        this.allDay = i10;
    }
}
