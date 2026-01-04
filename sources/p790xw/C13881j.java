package p790xw;

import java.util.NoSuchElementException;
import kw.AbstractC11164a0;

/* renamed from: xw.j */
/* loaded from: classes9.dex */
public final class C13881j extends AbstractC11164a0 {

    /* renamed from: a */
    public final long f62184a;

    /* renamed from: b */
    public final long f62185b;

    /* renamed from: c */
    public boolean f62186c;

    /* renamed from: d */
    public long f62187d;

    public C13881j(long j10, long j11, long j12) {
        this.f62184a = j12;
        this.f62185b = j11;
        boolean z10 = true;
        if (j12 <= 0 ? j10 < j11 : j10 > j11) {
            z10 = false;
        }
        this.f62186c = z10;
        this.f62187d = z10 ? j10 : j11;
    }

    @Override // kw.AbstractC11164a0
    /* renamed from: b */
    public long mo67107b() {
        long j10 = this.f62187d;
        if (j10 != this.f62185b) {
            this.f62187d = this.f62184a + j10;
        } else {
            if (!this.f62186c) {
                throw new NoSuchElementException();
            }
            this.f62186c = false;
        }
        return j10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f62186c;
    }
}
