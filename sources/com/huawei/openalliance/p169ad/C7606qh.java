package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.utils.ThreadFactoryC7835n;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.qh */
/* loaded from: classes8.dex */
class C7606qh extends AbstractC7601qc {

    /* renamed from: a */
    private static final Executor f35474a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC7835n("Normal-Event"));

    /* renamed from: b */
    private long f35475b;

    public C7606qh(Context context, InterfaceC7671st interfaceC7671st) {
        super(context, interfaceC7671st);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: a */
    public Class<? extends EventRecord> mo46979a() {
        return EventRecord.class;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: b */
    public Executor mo46981b() {
        return f35474a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: c */
    public String mo46982c() {
        return "NormalEventReporter";
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: d */
    public long mo46983d() {
        long j10;
        synchronized (C7606qh.class) {
            j10 = this.f35475b;
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: a */
    public void mo46980a(long j10) {
        synchronized (C7606qh.class) {
            this.f35475b = j10;
        }
    }
}
