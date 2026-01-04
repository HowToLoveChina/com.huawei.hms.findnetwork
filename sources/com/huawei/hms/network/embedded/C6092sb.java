package com.huawei.hms.network.embedded;

import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.sb */
/* loaded from: classes8.dex */
public final class C6092sb extends C5855ac {

    /* renamed from: e */
    public C5855ac f28249e;

    /* renamed from: f */
    public boolean f28250f;

    /* renamed from: g */
    public long f28251g;

    /* renamed from: h */
    public long f28252h;

    /* renamed from: a */
    public void m35311a(C5855ac c5855ac) {
        long jMo33845c;
        this.f28249e = c5855ac;
        boolean zMo33846d = c5855ac.mo33846d();
        this.f28250f = zMo33846d;
        this.f28251g = zMo33846d ? c5855ac.mo33845c() : -1L;
        long jMo33847e = c5855ac.mo33847e();
        this.f28252h = jMo33847e;
        c5855ac.timeout(C5855ac.m33840a(jMo33847e, mo33847e()), TimeUnit.NANOSECONDS);
        if (this.f28250f && mo33846d()) {
            jMo33845c = Math.min(mo33845c(), this.f28251g);
        } else if (!mo33846d()) {
            return;
        } else {
            jMo33845c = mo33845c();
        }
        c5855ac.deadlineNanoTime(jMo33845c);
    }

    /* renamed from: f */
    public void m35312f() {
        this.f28249e.timeout(this.f28252h, TimeUnit.NANOSECONDS);
        if (this.f28250f) {
            this.f28249e.deadlineNanoTime(this.f28251g);
        } else {
            this.f28249e.mo33841a();
        }
    }
}
