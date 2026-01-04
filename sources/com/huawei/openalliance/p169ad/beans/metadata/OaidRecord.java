package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class OaidRecord {
    public static final String LIMIT_OAID_CLOSE_KEY = "limit_oaid_close";
    public static final String LIMIT_OAID_OPEN_KEY = "limit_oaid_open";
    public static final String OPEN_OAID_SETTING_KEY = "open_oaid_setting";
    public static final String RESET_OAID_KEY = "reset_oaid";
    private int readTimes = 0;
    private long lastReportTime = 0;

    /* renamed from: a */
    public int m40361a() {
        return this.readTimes;
    }

    /* renamed from: b */
    public long m40364b() {
        return this.lastReportTime;
    }

    /* renamed from: c */
    public void m40365c() {
        this.readTimes++;
    }

    /* renamed from: a */
    public void m40362a(int i10) {
        this.readTimes = i10;
    }

    /* renamed from: a */
    public void m40363a(long j10) {
        this.lastReportTime = j10;
    }
}
