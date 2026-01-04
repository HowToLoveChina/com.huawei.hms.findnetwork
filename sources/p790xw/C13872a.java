package p790xw;

import kw.AbstractC11181j;
import p692uw.C13264g;
import pw.C12241c;

/* renamed from: xw.a */
/* loaded from: classes9.dex */
public class C13872a implements Iterable<Character> {

    /* renamed from: d */
    public static final a f62156d = new a(null);

    /* renamed from: a */
    public final char f62157a;

    /* renamed from: b */
    public final char f62158b;

    /* renamed from: c */
    public final int f62159c;

    /* renamed from: xw.a$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    public C13872a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f62157a = c10;
        this.f62158b = (char) C12241c.m73443c(c10, c11, i10);
        this.f62159c = i10;
    }

    /* renamed from: a */
    public final char m83211a() {
        return this.f62157a;
    }

    /* renamed from: b */
    public final char m83212b() {
        return this.f62158b;
    }

    @Override // java.lang.Iterable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC11181j iterator() {
        return new C13873b(this.f62157a, this.f62158b, this.f62159c);
    }
}
