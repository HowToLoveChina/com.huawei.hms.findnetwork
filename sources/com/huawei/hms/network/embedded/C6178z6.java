package com.huawei.hms.network.embedded;

import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.z6 */
/* loaded from: classes8.dex */
public final class C6178z6 {
    public final C6180z8 delegate;

    /* renamed from: com.huawei.hms.network.embedded.z6$a */
    public interface a {
        /* renamed from: a */
        void mo35142a(String str, int i10, String str2);
    }

    public C6178z6() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* renamed from: a */
    public int m35909a() {
        return this.delegate.m35923a();
    }

    /* renamed from: b */
    public void m35912b() {
        this.delegate.m35931b();
    }

    /* renamed from: c */
    public int m35915c() {
        return this.delegate.m35935c();
    }

    public C6178z6(int i10, long j10, TimeUnit timeUnit) {
        this.delegate = new C6180z8(i10, j10, timeUnit);
    }

    /* renamed from: a */
    public int m35910a(String str, int i10, String str2) {
        return this.delegate.m35925a(str, i10, str2);
    }

    /* renamed from: b */
    public void m35913b(a aVar) {
        this.delegate.m35932b(aVar);
    }

    /* renamed from: a */
    public void m35911a(a aVar) {
        this.delegate.m35929a(aVar);
    }

    /* renamed from: b */
    public boolean m35914b(String str, int i10, String str2) {
        return this.delegate.m35934b(str, i10, str2);
    }
}
