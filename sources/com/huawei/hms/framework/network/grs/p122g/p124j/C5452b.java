package com.huawei.hms.framework.network.grs.p122g.p124j;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.p122g.C5445d;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.framework.network.grs.g.j.b */
/* loaded from: classes8.dex */
public class C5452b {

    /* renamed from: a */
    private final Future<C5445d> f24993a;

    /* renamed from: b */
    private final long f24994b = SystemClock.elapsedRealtime();

    public C5452b(Future<C5445d> future) {
        this.f24993a = future;
    }

    /* renamed from: a */
    public Future<C5445d> m32304a() {
        return this.f24993a;
    }

    /* renamed from: b */
    public boolean m32305b() {
        return SystemClock.elapsedRealtime() - this.f24994b <= 300000;
    }
}
