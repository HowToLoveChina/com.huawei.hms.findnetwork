package com.huawei.hms.framework.network.restclient.dnkeeper;

import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.h */
/* loaded from: classes8.dex */
public class C5487h {

    /* renamed from: c */
    private Future f25122c;

    /* renamed from: a */
    private boolean f25120a = false;

    /* renamed from: b */
    private long f25121b = 0;

    /* renamed from: d */
    private DnsResult f25123d = new DnsResult();

    /* renamed from: a */
    public DnsResult m32401a() {
        return this.f25123d;
    }

    /* renamed from: b */
    public Future m32406b() {
        return this.f25122c;
    }

    /* renamed from: c */
    public long m32407c() {
        return this.f25121b;
    }

    /* renamed from: d */
    public boolean m32408d() {
        return this.f25120a;
    }

    /* renamed from: a */
    public void m32402a(long j10) {
        this.f25121b = j10;
    }

    /* renamed from: a */
    public void m32403a(DnsResult dnsResult) {
        this.f25123d = dnsResult;
    }

    /* renamed from: a */
    public void m32404a(Future future) {
        this.f25122c = future;
    }

    /* renamed from: a */
    public void m32405a(boolean z10) {
        this.f25120a = z10;
    }
}
