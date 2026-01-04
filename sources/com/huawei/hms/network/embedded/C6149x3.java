package com.huawei.hms.network.embedded;

import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.x3 */
/* loaded from: classes8.dex */
public class C6149x3 {

    /* renamed from: a */
    public boolean f28915a;

    /* renamed from: b */
    public long f28916b;

    /* renamed from: c */
    public long f28917c;

    public C6149x3 clearDeadline() {
        this.f28915a = false;
        return this;
    }

    public C6149x3 clearTimeout() {
        this.f28917c = 0L;
        return this;
    }

    public final C6149x3 deadline(long j10, TimeUnit timeUnit) {
        if (j10 > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j10));
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("duration <= 0: " + j10);
    }

    public long deadlineNanoTime() {
        if (this.f28915a) {
            return this.f28916b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.f28915a;
    }

    public C6149x3 timeout(long j10, TimeUnit timeUnit) {
        if (j10 >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f28917c = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j10);
    }

    public long timeoutNanos() {
        return this.f28917c;
    }

    public C6149x3 deadlineNanoTime(long j10) {
        this.f28915a = true;
        this.f28916b = j10;
        return this;
    }
}
