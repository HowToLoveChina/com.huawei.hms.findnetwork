package com.huawei.android.backup.service.logic.calendar;

import android.content.ContentValues;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: classes.dex */
public class CalendarTableSet {
    private Map<Long, LinkedHashSet<ContentValues>> attendeesMap;
    private Map<Long, LinkedHashSet<ContentValues>> eventMap;
    private Map<Long, ContentValues> eventMapValues;
    private Map<Long, LinkedHashSet<ContentValues>> extendedMap;
    private Map<Long, LinkedHashSet<ContentValues>> remindMap;

    public CalendarTableSet(Map<Long, ContentValues> map, Map<Long, LinkedHashSet<ContentValues>> map2, Map<Long, LinkedHashSet<ContentValues>> map3, Map<Long, LinkedHashSet<ContentValues>> map4, Map<Long, LinkedHashSet<ContentValues>> map5) {
        this.attendeesMap = map5;
        this.eventMapValues = map;
        this.extendedMap = map3;
        this.remindMap = map4;
        this.eventMap = map2;
    }

    public Map<Long, LinkedHashSet<ContentValues>> getAttendeesMap() {
        return this.attendeesMap;
    }

    public Map<Long, LinkedHashSet<ContentValues>> getEventMap() {
        return this.eventMap;
    }

    public Map<Long, ContentValues> getEventMapValues() {
        return this.eventMapValues;
    }

    public Map<Long, LinkedHashSet<ContentValues>> getExtendedMap() {
        return this.extendedMap;
    }

    public Map<Long, LinkedHashSet<ContentValues>> getRemindMap() {
        return this.remindMap;
    }
}
