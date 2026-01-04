package p790xw;

import kw.AbstractC11164a0;
import p692uw.C13264g;
import pw.C12241c;

/* renamed from: xw.i */
/* loaded from: classes9.dex */
public class C13880i implements Iterable<Long> {

    /* renamed from: d */
    public static final a f62180d = new a(null);

    /* renamed from: a */
    public final long f62181a;

    /* renamed from: b */
    public final long f62182b;

    /* renamed from: c */
    public final long f62183c;

    /* renamed from: xw.i$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    public C13880i(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f62181a = j10;
        this.f62182b = C12241c.m73444d(j10, j11, j12);
        this.f62183c = j12;
    }

    /* renamed from: a */
    public final long m83226a() {
        return this.f62181a;
    }

    /* renamed from: b */
    public final long m83227b() {
        return this.f62182b;
    }

    @Override // java.lang.Iterable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC11164a0 iterator() {
        return new C13881j(this.f62181a, this.f62182b, this.f62183c);
    }
}
