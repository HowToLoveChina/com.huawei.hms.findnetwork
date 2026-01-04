package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.Iterator;
import java.util.List;
import p292fn.C9733f;

/* loaded from: classes2.dex */
public class ThermalPolicy {
    protected static final int DEFAULT_VALUE = -1;
    public static final int SWITCH_OPEN = 1;

    /* renamed from: id */
    int f11660id;
    List<TimeScope> priorityTimeScope;
    int startLevel = -1;
    int stopLevel = -1;
    int priorityStartLevel = -1;
    int priorityStopLevel = -1;

    private boolean isLevelInvalid(int i10, int i11) {
        return i10 < 0 || i11 < 0 || i10 > i11;
    }

    private boolean isThermalControlGroupParamsInvalid() {
        List<TimeScope> list = this.priorityTimeScope;
        if (list == null) {
            return true;
        }
        Iterator<TimeScope> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isArgumentInvalid()) {
                return true;
            }
        }
        return isLevelInvalid(this.priorityStartLevel, this.priorityStopLevel) || isLevelInvalid(this.startLevel, this.stopLevel);
    }

    public int getId() {
        return this.f11660id;
    }

    public int getPriorityStartLevel() {
        return this.priorityStartLevel;
    }

    public int getPriorityStopLevel() {
        return this.priorityStopLevel;
    }

    public List<TimeScope> getPriorityTimeScope() {
        return this.priorityTimeScope;
    }

    public int getStartLevel() {
        return this.startLevel;
    }

    public int getStopLevel() {
        return this.stopLevel;
    }

    public boolean isArgumentInvalid() {
        return C9733f.m60705z().m60720O("cloudBackupPriorityThermalControl") ? isThermalControlGroupParamsInvalid() : isLevelInvalid(this.startLevel, this.stopLevel);
    }

    public void setId(int i10) {
        this.f11660id = i10;
    }
}
