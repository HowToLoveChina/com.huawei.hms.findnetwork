package com.huawei.fastengine.fastview.download.utils.log;

import com.huawei.openalliance.p169ad.constant.VastAttribute;

/* loaded from: classes5.dex */
public enum LogLevel {
    ERROR(VastAttribute.ERROR, 0, 6),
    WARN("warn", 1, 5),
    INFO("info", 2, 4),
    DEBUG("debug", 3, 3),
    VERBOSE("verbose", 4, 2),
    ALL("debug", 5, 3),
    OFF("off", 6, 3);

    String name;
    int priority;
    int value;

    LogLevel(String str, int i10, int i11) {
        this.name = str;
        this.value = i10;
        this.priority = i11;
    }

    public int compare(LogLevel logLevel) {
        return this.value - logLevel.value;
    }

    public int getPriority() {
        return this.priority;
    }
}
