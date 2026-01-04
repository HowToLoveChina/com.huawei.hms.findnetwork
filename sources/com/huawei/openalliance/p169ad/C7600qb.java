package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.AnalysisEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.utils.ThreadFactoryC7835n;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.qb */
/* loaded from: classes8.dex */
class C7600qb extends AbstractC7601qc {

    /* renamed from: a */
    private static final Executor f35453a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC7835n("Analysis-Event"));

    /* renamed from: b */
    private static long f35454b;

    public C7600qb(Context context, InterfaceC7671st interfaceC7671st) {
        super(context, interfaceC7671st);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: a */
    public Class<? extends EventRecord> mo46979a() {
        return AnalysisEventRecord.class;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: b */
    public Executor mo46981b() {
        return f35453a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: c */
    public String mo46982c() {
        return "AnalysisEventReporter";
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: d */
    public long mo46983d() {
        long j10;
        synchronized (C7600qb.class) {
            j10 = f35454b;
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7601qc
    /* renamed from: a */
    public void mo46980a(long j10) {
        synchronized (C7600qb.class) {
            f35454b = j10;
        }
    }
}
