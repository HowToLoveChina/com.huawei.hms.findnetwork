package com.huawei.openalliance.p169ad.download;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;

/* renamed from: com.huawei.openalliance.ad.download.n */
/* loaded from: classes2.dex */
class C7071n {

    /* renamed from: a */
    private final a f32551a;

    /* renamed from: b */
    private final int f32552b;

    /* renamed from: com.huawei.openalliance.ad.download.n$a */
    public static class a {

        /* renamed from: a */
        int f32553a;

        /* renamed from: b */
        boolean f32554b;

        /* renamed from: c */
        int f32555c;

        /* renamed from: d */
        long f32556d;

        /* renamed from: e */
        long f32557e;
    }

    public C7071n(C7059b c7059b, int i10) {
        this.f32552b = i10;
        a aVar = new a();
        this.f32551a = aVar;
        boolean zM42569f = c7059b.m42569f();
        aVar.f32554b = zM42569f;
        aVar.f32553a = zM42569f ? 100 : i10;
        aVar.f32555c = c7059b.m42570g();
        aVar.f32556d = System.currentTimeMillis();
        aVar.f32557e = 0L;
    }

    /* renamed from: a */
    public a m42631a() {
        return this.f32551a;
    }

    /* renamed from: a */
    public void m42632a(int i10) throws InterruptedException {
        a aVar = this.f32551a;
        aVar.f32557e += i10;
        if (aVar.f32554b) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            a aVar2 = this.f32551a;
            long j10 = jCurrentTimeMillis - aVar2.f32556d;
            if (j10 >= 10) {
                AbstractC7185ho.m43818a("DownloadWorker.SpeedAdjuster", "totalReadLengthDuringCheckPoints: %d checkDuration: %d", Long.valueOf(aVar2.f32557e), Long.valueOf(j10));
                a aVar3 = this.f32551a;
                aVar3.f32556d = jCurrentTimeMillis;
                long j11 = ((aVar3.f32557e * 100000) / j10) / 100;
                long jAbs = Math.abs(j11 - aVar3.f32555c);
                AbstractC7185ho.m43818a("DownloadWorker.SpeedAdjuster", "current speed: %d target speed: %d diff: %d maxReadDSize: %d", Long.valueOf(j11), Integer.valueOf(this.f32551a.f32555c), Long.valueOf(jAbs), Integer.valueOf(this.f32551a.f32553a));
                if (jAbs > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                    a aVar4 = this.f32551a;
                    if (j11 > aVar4.f32555c) {
                        int i11 = aVar4.f32553a;
                        if (i11 <= 1) {
                            long j12 = (((j10 * jAbs) * 100) / j11) / 100;
                            if (j12 > 120000) {
                                j12 = 120000;
                            }
                            AbstractC7185ho.m43818a("DownloadWorker.SpeedAdjuster", "sleep time: %d", Long.valueOf(j12));
                            try {
                                Thread.sleep(j12);
                            } catch (InterruptedException e10) {
                                AbstractC7185ho.m43818a("DownloadWorker.SpeedAdjuster", "adjustSpeedDynamically occur error %s", e10.getClass().getSimpleName());
                            }
                        } else {
                            int i12 = i11 - 30;
                            aVar4.f32553a = i12;
                            aVar4.f32553a = i12 >= 1 ? i12 : 1;
                        }
                    } else {
                        int i13 = aVar4.f32553a + 30;
                        aVar4.f32553a = i13;
                        int i14 = this.f32552b;
                        if (i13 > i14) {
                            i13 = i14;
                        }
                        aVar4.f32553a = i13;
                    }
                }
                AbstractC7185ho.m43818a("DownloadWorker.SpeedAdjuster", "max read size: %d", Integer.valueOf(this.f32551a.f32553a));
                this.f32551a.f32557e = 0L;
            }
        }
    }
}
