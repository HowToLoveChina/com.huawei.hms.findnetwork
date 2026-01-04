package p022ay;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p692uw.C13267j;

/* renamed from: ay.j */
/* loaded from: classes9.dex */
public class C1060j extends C1050a0 {

    /* renamed from: b */
    public C1050a0 f5140b;

    public C1060j(C1050a0 c1050a0) {
        C13267j.m79677e(c1050a0, "delegate");
        this.f5140b = c1050a0;
    }

    /* renamed from: b */
    public final C1050a0 m6393b() {
        return this.f5140b;
    }

    /* renamed from: c */
    public final C1060j m6394c(C1050a0 c1050a0) {
        C13267j.m79677e(c1050a0, "delegate");
        this.f5140b = c1050a0;
        return this;
    }

    @Override // p022ay.C1050a0
    public C1050a0 clearDeadline() {
        return this.f5140b.clearDeadline();
    }

    @Override // p022ay.C1050a0
    public C1050a0 clearTimeout() {
        return this.f5140b.clearTimeout();
    }

    @Override // p022ay.C1050a0
    public long deadlineNanoTime() {
        return this.f5140b.deadlineNanoTime();
    }

    @Override // p022ay.C1050a0
    public boolean hasDeadline() {
        return this.f5140b.hasDeadline();
    }

    @Override // p022ay.C1050a0
    public void throwIfReached() throws IOException {
        this.f5140b.throwIfReached();
    }

    @Override // p022ay.C1050a0
    public C1050a0 timeout(long j10, TimeUnit timeUnit) {
        C13267j.m79677e(timeUnit, "unit");
        return this.f5140b.timeout(j10, timeUnit);
    }

    @Override // p022ay.C1050a0
    public long timeoutNanos() {
        return this.f5140b.timeoutNanos();
    }

    @Override // p022ay.C1050a0
    public C1050a0 deadlineNanoTime(long j10) {
        return this.f5140b.deadlineNanoTime(j10);
    }
}
