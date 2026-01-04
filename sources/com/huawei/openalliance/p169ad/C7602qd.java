package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.ClickEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.utils.ThreadFactoryC7835n;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.qd */
/* loaded from: classes8.dex */
class C7602qd extends AbstractC7601qc {

    /* renamed from: a */
    private static final Executor f35470a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC7835n("Click-Event"));

    /* renamed from: b */
    private long f35471b;

    public C7602qd(Context context, InterfaceC7671st interfaceC7671st) {
        super(context, interfaceC7671st);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: a */
    public Class<? extends EventRecord> mo46979a() {
        return ClickEventRecord.class;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: b */
    public Executor mo46981b() {
        return f35470a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: c */
    public String mo46982c() {
        return "ClickEventReporter";
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: d */
    public long mo46983d() {
        long j10;
        synchronized (C7602qd.class) {
            j10 = this.f35471b;
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: a */
    public void mo46980a(long j10) {
        synchronized (C7602qd.class) {
            this.f35471b = j10;
        }
    }
}
