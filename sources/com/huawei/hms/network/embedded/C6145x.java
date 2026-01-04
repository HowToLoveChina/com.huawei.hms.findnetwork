package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Utils;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.huawei.hms.network.embedded.x */
/* loaded from: classes8.dex */
public class C6145x {

    /* renamed from: e */
    public static final String f28906e = "DnsInfo";

    /* renamed from: a */
    public int f28907a;

    /* renamed from: b */
    public long f28908b = 0;

    /* renamed from: c */
    public long f28909c = 0;

    /* renamed from: d */
    public final AtomicLong f28910d = new AtomicLong(0);

    /* renamed from: a */
    public void m35762a() {
        this.f28910d.set(0L);
        this.f28909c = 0L;
    }

    /* renamed from: b */
    public long m35765b() {
        return this.f28908b;
    }

    /* renamed from: c */
    public long m35766c() {
        if (this.f28909c == 0) {
            this.f28909c = Utils.getCurrentTime(true);
        }
        return this.f28909c;
    }

    /* renamed from: d */
    public int m35767d() {
        return this.f28907a;
    }

    /* renamed from: e */
    public long m35768e() {
        return this.f28910d.incrementAndGet();
    }

    /* renamed from: a */
    public void m35763a(int i10) {
        this.f28907a = i10;
    }

    /* renamed from: a */
    public void m35764a(long j10) {
        this.f28908b = j10;
    }
}
