package com.huawei.hms.videokit.player;

import com.huawei.hms.videokit.player.bean.C6546a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.videokit.player.c */
/* loaded from: classes8.dex */
class C6548c {

    /* renamed from: a */
    private int f30340a;

    /* renamed from: b */
    private int f30341b;

    /* renamed from: c */
    private long f30342c;

    /* renamed from: d */
    private int f30343d;

    /* renamed from: e */
    private long f30344e;

    /* renamed from: f */
    private Map<String, C6546a> f30345f = new HashMap();

    /* renamed from: a */
    private void m37242a() {
        Map<String, C6546a> map = this.f30345f;
        if (map != null) {
            map.clear();
        }
        this.f30342c = 0L;
        this.f30340a = 0;
        this.f30341b = 0;
        this.f30343d = 0;
    }

    /* renamed from: b */
    public synchronized String m37245b() {
        StringBuffer stringBuffer;
        Map<String, C6546a> map;
        stringBuffer = new StringBuffer();
        try {
            map = this.f30345f;
        } catch (Exception e10) {
            C6550c1.m37258a("BitrateRecordManager", "getBitrateRecords e:", e10);
        }
        if (map != null) {
            for (Map.Entry<String, C6546a> entry : map.entrySet()) {
                C6550c1.m37256a("BitrateRecordManager", entry.getKey() + ":" + entry.getValue());
                C6546a value = entry.getValue();
                if (value != null) {
                    stringBuffer.append(entry.getKey() + "," + value.m37229b() + "," + value.m37226a() + "," + value.m37231c() + ";");
                }
            }
            C6550c1.m37256a("BitrateRecordManager", "data:" + ((Object) stringBuffer));
            m37242a();
        } else {
            C6550c1.m37256a("BitrateRecordManager", "data:" + ((Object) stringBuffer));
            m37242a();
        }
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public synchronized void m37247c(long j10) {
        C6550c1.m37256a("BitrateRecordManager", "setValidPlayStartTime endTime:" + j10 + " validPlayEndTime:" + this.f30344e);
        long j11 = this.f30344e;
        if (j11 != 0) {
            this.f30343d += (int) (j10 - j11);
            this.f30344e = 0L;
        }
    }

    /* renamed from: d */
    public synchronized void m37248d(long j10) {
        C6550c1.m37256a("BitrateRecordManager", "setValidPlayStartTime startTime:" + j10 + " validPlayStartTime:" + this.f30344e);
        if (this.f30344e == 0) {
            this.f30344e = j10;
        }
    }

    /* renamed from: a */
    public synchronized void m37243a(long j10) {
        C6550c1.m37256a("BitrateRecordManager", "setStalingEndTime endTime:" + j10 + " stallingStartTime:" + this.f30342c);
        long j11 = this.f30342c;
        if (j11 != 0) {
            this.f30341b += (int) (j10 - j11);
            this.f30342c = 0L;
        }
    }

    /* renamed from: b */
    public synchronized void m37246b(long j10) {
        C6550c1.m37256a("BitrateRecordManager", "setStallingStartTime startTime:" + j10 + " stallingStartTime:" + this.f30342c);
        if (this.f30342c == 0) {
            this.f30342c = j10;
            this.f30340a++;
        }
    }

    /* renamed from: a */
    public synchronized void m37244a(String str) {
        C6546a c6546a;
        try {
            if (this.f30345f.containsKey(str)) {
                c6546a = this.f30345f.get(str);
                c6546a.m37230b(c6546a.m37229b() + this.f30341b);
                c6546a.m37227a(c6546a.m37226a() + this.f30340a);
                c6546a.m37232c(c6546a.m37231c() + this.f30343d);
            } else {
                c6546a = new C6546a();
                c6546a.m37228a(str);
                c6546a.m37230b(this.f30341b);
                c6546a.m37227a(this.f30340a);
                c6546a.m37232c(this.f30343d);
            }
            this.f30345f.put(str, c6546a);
            C6550c1.m37256a("BitrateRecordManager", c6546a.toString());
            this.f30342c = 0L;
            this.f30340a = 0;
            this.f30341b = 0;
            this.f30343d = 0;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
