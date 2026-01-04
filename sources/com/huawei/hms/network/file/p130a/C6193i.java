package com.huawei.hms.network.file.p130a;

import android.os.SystemClock;
import com.huawei.hms.network.file.core.util.FLogger;

/* renamed from: com.huawei.hms.network.file.a.i */
/* loaded from: classes8.dex */
public class C6193i {

    /* renamed from: a */
    int f29296a;

    /* renamed from: b */
    long f29297b;

    /* renamed from: c */
    long f29298c;

    /* renamed from: d */
    long f29299d;

    public C6193i(int i10) {
        this.f29296a = i10;
        this.f29299d = i10 * 2;
    }

    /* renamed from: a */
    public int m36058a(int i10) throws InterruptedException {
        if (i10 < 0) {
            return 0;
        }
        if (this.f29298c == 0) {
            this.f29298c = SystemClock.elapsedRealtime();
        }
        long j10 = i10;
        if (j10 > this.f29297b) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = (int) (((jElapsedRealtime - this.f29298c) / 1000.0d) * this.f29296a);
            if (j11 < 0) {
                j11 = this.f29299d;
            }
            if (j11 > 0) {
                long j12 = this.f29297b + j11;
                this.f29297b = j12 < 0 ? this.f29299d : Math.min(j12, this.f29299d);
                this.f29298c = jElapsedRealtime;
            }
            long j13 = this.f29297b;
            if (j10 > j13) {
                long j14 = (j10 - j13) + 1;
                long j15 = (long) ((j14 * 1000.0d) / this.f29296a);
                if (j15 <= 0) {
                    j15 = 10;
                }
                try {
                    Thread.sleep(j15);
                    this.f29297b += j14;
                    this.f29298c = SystemClock.elapsedRealtime();
                } catch (InterruptedException unused) {
                    FLogger.m36351e("TokenBucketSpeedLimiter", "acquireSync InterruptedException");
                    return 0;
                }
            }
        }
        this.f29297b -= j10;
        return i10;
    }
}
