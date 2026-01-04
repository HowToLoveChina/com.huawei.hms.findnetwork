package com.huawei.hms.network.file.p136b;

import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p130a.C6191g;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import java.util.Map;

/* renamed from: com.huawei.hms.network.file.b.f */
/* loaded from: classes8.dex */
public class C6219f extends AbstractC6240k<BodyRequest> {

    /* renamed from: v */
    long f29354v;

    /* renamed from: w */
    public long f29355w;

    /* renamed from: x */
    public long f29356x;

    /* renamed from: y */
    public long f29357y;

    /* renamed from: z */
    public long f29358z;

    public C6219f(BodyRequest bodyRequest) {
        super(bodyRequest, 0L);
    }

    /* renamed from: A */
    public long m36155A() {
        return this.f29357y;
    }

    /* renamed from: B */
    public long m36156B() {
        return this.f29358z;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: a */
    public long mo36022a() {
        return this.f29354v;
    }

    /* renamed from: b */
    public void m36158b(long j10) {
        this.f29355w = j10;
    }

    /* renamed from: c */
    public void m36159c(long j10) {
        this.f29356x = j10;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6234e
    /* renamed from: d */
    public InterfaceC6234e.b mo36026d() {
        return InterfaceC6234e.b.UPLOAD;
    }

    /* renamed from: e */
    public void m36161e(long j10) {
        this.f29354v = j10;
    }

    /* renamed from: f */
    public void m36162f(long j10) {
        this.f29358z = j10;
    }

    @Override // com.huawei.hms.network.file.core.task.AbstractC6240k
    /* renamed from: m */
    public C6191g mo36029m() {
        return null;
    }

    @Override // com.huawei.hms.network.file.core.task.AbstractC6240k
    /* renamed from: x */
    public AbstractC6240k mo36030x() {
        return new C6219f(m36341p(), mo36241f());
    }

    /* renamed from: y */
    public long m36163y() {
        return this.f29355w;
    }

    /* renamed from: z */
    public long m36164z() {
        return this.f29356x;
    }

    public C6219f(BodyRequest bodyRequest, long j10) {
        super(bodyRequest, 0L, j10);
    }

    /* renamed from: a */
    public void m36157a(Map<String, Object> map) {
        map.put(Utils.REQUEST_TIME, String.valueOf(m36164z()));
        map.put(Utils.RESPONSE_TIME, String.valueOf(m36155A()));
        map.put(Utils.TOTAL_TIME, String.valueOf(m36156B()));
        FLogger.m36350d("UploadTask", "timeinfo, requestTime:" + m36164z() + ",responseTime:" + m36155A() + ",totalTime:" + m36156B(), new Object[0]);
    }

    /* renamed from: d */
    public void m36160d(long j10) {
        this.f29357y = j10;
    }
}
