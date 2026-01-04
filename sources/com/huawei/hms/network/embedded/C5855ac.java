package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.ac */
/* loaded from: classes8.dex */
public class C5855ac {

    /* renamed from: d */
    public static final C5855ac f26380d = new a();

    /* renamed from: a */
    public boolean f26381a;

    /* renamed from: b */
    public long f26382b;

    /* renamed from: c */
    public long f26383c;

    /* renamed from: com.huawei.hms.network.embedded.ac$a */
    public class a extends C5855ac {
        @Override // com.huawei.hms.network.embedded.C5855ac
        public C5855ac deadlineNanoTime(long j10) {
            return this;
        }

        @Override // com.huawei.hms.network.embedded.C5855ac
        public void throwIfReached() throws IOException {
        }

        @Override // com.huawei.hms.network.embedded.C5855ac
        public C5855ac timeout(long j10, TimeUnit timeUnit) {
            return this;
        }
    }

    /* renamed from: a */
    public static long m33840a(long j10, long j11) {
        return j10 == 0 ? j11 : (j11 != 0 && j10 >= j11) ? j11 : j10;
    }

    /* renamed from: b */
    public C5855ac mo33844b() {
        this.f26383c = 0L;
        return this;
    }

    /* renamed from: c */
    public long mo33845c() {
        if (this.f26381a) {
            return this.f26382b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: d */
    public boolean mo33846d() {
        return this.f26381a;
    }

    public C5855ac deadlineNanoTime(long j10) {
        this.f26381a = true;
        this.f26382b = j10;
        return this;
    }

    /* renamed from: e */
    public long mo33847e() {
        return this.f26383c;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f26381a && this.f26382b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public C5855ac timeout(long j10, TimeUnit timeUnit) {
        if (j10 >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f26383c = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j10);
    }

    /* renamed from: a */
    public C5855ac mo33841a() {
        this.f26381a = false;
        return this;
    }

    /* renamed from: a */
    public final C5855ac m33842a(long j10, TimeUnit timeUnit) {
        if (j10 > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j10));
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("duration <= 0: " + j10);
    }

    /* renamed from: a */
    public final void m33843a(Object obj) throws InterruptedException, InterruptedIOException {
        try {
            boolean zMo33846d = mo33846d();
            long jMo33847e = mo33847e();
            long jNanoTime = 0;
            if (!zMo33846d && jMo33847e == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zMo33846d && jMo33847e != 0) {
                jMo33847e = Math.min(jMo33847e, mo33845c() - jNanoTime2);
            } else if (zMo33846d) {
                jMo33847e = mo33845c() - jNanoTime2;
            }
            if (jMo33847e > 0) {
                long j10 = jMo33847e / 1000000;
                obj.wait(j10, (int) (jMo33847e - (1000000 * j10)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jMo33847e) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
