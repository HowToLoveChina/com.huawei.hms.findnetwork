package p720vw;

import java.util.Random;
import p692uw.C13267j;

/* renamed from: vw.b */
/* loaded from: classes9.dex */
public final class C13498b extends AbstractC13497a {

    /* renamed from: c */
    public final a f60736c = new a();

    /* renamed from: vw.b$a */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // p720vw.AbstractC13497a
    /* renamed from: d */
    public Random mo81190d() {
        Random random = this.f60736c.get();
        C13267j.m79676d(random, "implStorage.get()");
        return random;
    }
}
