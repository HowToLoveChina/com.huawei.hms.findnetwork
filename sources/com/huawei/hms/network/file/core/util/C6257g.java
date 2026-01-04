package com.huawei.hms.network.file.core.util;

/* renamed from: com.huawei.hms.network.file.core.util.g */
/* loaded from: classes8.dex */
public class C6257g {

    /* renamed from: a */
    private long f29523a;

    /* renamed from: b */
    private long f29524b;

    /* renamed from: c */
    private long f29525c = 0;

    /* renamed from: d */
    private long f29526d = -1;

    public C6257g(long j10, long j11) {
        this.f29523a = j10 & 31;
        this.f29524b = j11 & 31;
    }

    /* renamed from: b */
    private long m36381b() {
        return System.currentTimeMillis();
    }

    /* renamed from: c */
    private long m36382c() {
        long jM36381b;
        do {
            jM36381b = m36381b();
        } while (jM36381b <= this.f29526d);
        return jM36381b;
    }

    /* renamed from: a */
    public synchronized long m36383a() {
        long jM36381b;
        try {
            jM36381b = m36381b();
            if (jM36381b < this.f29526d || jM36381b < 1418357532000L) {
                FLogger.m36355w("SnowFlakeGen", "time changed ,nextId may conflicted. currTimeStamp:" + jM36381b + ", lastTimeStamp:" + this.f29526d + ",START_TIMESTAMP:1418357532000", new Object[0]);
            }
            long j10 = (this.f29525c + 1) & 4095;
            this.f29525c = j10;
            if (j10 == 0 && this.f29526d == jM36381b) {
                FLogger.m36355w("SnowFlakeGen", "nextId for nextMill, currTimeStamp :" + jM36381b, new Object[0]);
                jM36381b = m36382c();
            }
            this.f29526d = jM36381b;
            FLogger.m36354v("SnowFlakeGen", "nextId, processId:" + this.f29523a + ",randomId:" + this.f29524b + ",sequence:" + this.f29525c);
        } catch (Throwable th2) {
            throw th2;
        }
        return ((jM36381b - 1418357532000L) << 22) | (this.f29523a << 17) | (this.f29524b << 12) | this.f29525c;
    }
}
