package com.huawei.hms.network.file.p130a;

import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.core.util.C6251a;
import com.huawei.hms.network.file.core.util.FLogger;

/* renamed from: com.huawei.hms.network.file.a.g */
/* loaded from: classes8.dex */
public class C6191g {

    /* renamed from: a */
    private Long f29282a;

    /* renamed from: b */
    private Long f29283b;

    /* renamed from: c */
    private int f29284c;

    /* renamed from: d */
    private int f29285d;

    /* renamed from: e */
    private volatile boolean f29286e;

    /* renamed from: f */
    private volatile boolean f29287f;

    /* renamed from: a */
    public Long m36037a() {
        return this.f29283b;
    }

    /* renamed from: b */
    public Long m36041b() {
        return this.f29282a;
    }

    /* renamed from: c */
    public int m36044c() {
        return this.f29285d;
    }

    /* renamed from: d */
    public int m36045d() {
        return this.f29284c;
    }

    public String toString() {
        return "PerformanceInfo{availableRamStart=" + this.f29282a + ", availableRamMid=" + this.f29283b + ", cpuFreqStart=" + this.f29284c + ", cpuFreqMid=" + this.f29285d + super.toString() + '}';
    }

    /* renamed from: a */
    public void m36038a(int i10) {
        this.f29285d = i10;
    }

    /* renamed from: b */
    public void m36042b(int i10) {
        this.f29284c = i10;
    }

    /* renamed from: a */
    public void m36039a(long j10, long j11, int i10) {
        if (!this.f29286e) {
            m36043b(Long.valueOf(C6251a.m36357a(RequestManager.getAppContext())));
            m36042b(C6251a.m36356a());
            this.f29286e = true;
            FLogger.m36350d("PerformanceInfoCollect", "first data collect:availableRamStart_" + this.f29282a + ";cpuFreqStart_" + this.f29284c, new Object[0]);
        }
        if (j10 + i10 < j11 / 2 || this.f29287f) {
            return;
        }
        m36040a(Long.valueOf(C6251a.m36357a(RequestManager.getAppContext())));
        m36038a(C6251a.m36356a());
        this.f29287f = true;
        FLogger.m36350d("PerformanceInfoCollect", "middle data collect：availableRamMid_" + this.f29283b + ";cpuFreqMid_" + this.f29285d, new Object[0]);
    }

    /* renamed from: b */
    public void m36043b(Long l10) {
        this.f29282a = l10;
    }

    /* renamed from: a */
    public void m36040a(Long l10) {
        this.f29283b = l10;
    }
}
