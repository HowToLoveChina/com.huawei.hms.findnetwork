package p720vw;

import java.io.Serializable;
import p692uw.C13264g;
import pw.C12240b;

/* renamed from: vw.c */
/* loaded from: classes9.dex */
public abstract class AbstractC13499c {

    /* renamed from: a */
    public static final a f60737a = new a(null);

    /* renamed from: b */
    public static final AbstractC13499c f60738b = C12240b.f56629a.mo73440b();

    /* renamed from: vw.c$a */
    public static final class a extends AbstractC13499c implements Serializable {

        /* renamed from: vw.c$a$a, reason: collision with other inner class name */
        public static final class C14513a implements Serializable {

            /* renamed from: a */
            public static final C14513a f60739a = new C14513a();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return AbstractC13499c.f60737a;
            }
        }

        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        private final Object writeReplace() {
            return C14513a.f60739a;
        }

        @Override // p720vw.AbstractC13499c
        /* renamed from: c */
        public int mo81189c() {
            return AbstractC13499c.f60738b.mo81189c();
        }

        public a() {
        }
    }

    /* renamed from: c */
    public abstract int mo81189c();
}
