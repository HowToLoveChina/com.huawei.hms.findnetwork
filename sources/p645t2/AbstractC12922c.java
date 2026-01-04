package p645t2;

/* renamed from: t2.c */
/* loaded from: classes.dex */
public abstract class AbstractC12922c {

    /* renamed from: t2.c$b */
    public static class b extends AbstractC12922c {

        /* renamed from: a */
        public volatile boolean f58942a;

        public b() {
            super();
        }

        @Override // p645t2.AbstractC12922c
        /* renamed from: b */
        public void mo77582b(boolean z10) {
            this.f58942a = z10;
        }

        @Override // p645t2.AbstractC12922c
        /* renamed from: c */
        public void mo77583c() {
            if (this.f58942a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    /* renamed from: a */
    public static AbstractC12922c m77581a() {
        return new b();
    }

    /* renamed from: b */
    public abstract void mo77582b(boolean z10);

    /* renamed from: c */
    public abstract void mo77583c();

    public AbstractC12922c() {
    }
}
