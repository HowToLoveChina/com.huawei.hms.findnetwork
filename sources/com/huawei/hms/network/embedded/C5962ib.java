package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.ib */
/* loaded from: classes8.dex */
public class C5962ib extends C5855ac {

    /* renamed from: e */
    public C5855ac f27038e;

    public C5962ib(C5855ac c5855ac) {
        if (c5855ac == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f27038e = c5855ac;
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    /* renamed from: a */
    public C5855ac mo33841a() {
        return this.f27038e.mo33841a();
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    /* renamed from: b */
    public C5855ac mo33844b() {
        return this.f27038e.mo33844b();
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    /* renamed from: c */
    public long mo33845c() {
        return this.f27038e.mo33845c();
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    /* renamed from: d */
    public boolean mo33846d() {
        return this.f27038e.mo33846d();
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    public C5855ac deadlineNanoTime(long j10) {
        return this.f27038e.deadlineNanoTime(j10);
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    /* renamed from: e */
    public long mo33847e() {
        return this.f27038e.mo33847e();
    }

    /* renamed from: f */
    public final C5855ac m34425f() {
        return this.f27038e;
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    public void throwIfReached() throws IOException {
        this.f27038e.throwIfReached();
    }

    @Override // com.huawei.hms.network.embedded.C5855ac
    public C5855ac timeout(long j10, TimeUnit timeUnit) {
        return this.f27038e.timeout(j10, timeUnit);
    }

    /* renamed from: a */
    public final C5962ib m34424a(C5855ac c5855ac) {
        if (c5855ac == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f27038e = c5855ac;
        return this;
    }
}
