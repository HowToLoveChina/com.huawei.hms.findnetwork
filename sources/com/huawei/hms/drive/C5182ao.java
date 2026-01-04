package com.huawei.hms.drive;

import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.drive.ao */
/* loaded from: classes8.dex */
public final class C5182ao {

    /* renamed from: a */
    final C5228ce f23737a;

    /* renamed from: com.huawei.hms.drive.ao$a */
    public interface a {
        /* renamed from: a */
        void mo30854a(String str, int i10, String str2);
    }

    public C5182ao() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* renamed from: a */
    public int m30852a(String str, int i10, String str2) {
        return this.f23737a.m31340a(str, i10, str2);
    }

    public C5182ao(int i10, long j10, TimeUnit timeUnit) {
        this.f23737a = new C5228ce(i10, j10, timeUnit);
    }

    /* renamed from: a */
    public void m30853a(a aVar) {
        this.f23737a.m31342a(aVar);
    }
}
