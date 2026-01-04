package p630s2;

/* renamed from: s2.f */
/* loaded from: classes.dex */
public final class C12671f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: s2.f$a */
    public class a<T> implements b<T> {

        /* renamed from: a */
        public volatile T f58175a;

        /* renamed from: b */
        public final /* synthetic */ b f58176b;

        public a(b bVar) {
            this.f58176b = bVar;
        }

        @Override // p630s2.C12671f.b
        public T get() {
            if (this.f58175a == null) {
                synchronized (this) {
                    try {
                        if (this.f58175a == null) {
                            this.f58175a = (T) C12676k.m76276d(this.f58176b.get());
                        }
                    } finally {
                    }
                }
            }
            return this.f58175a;
        }
    }

    /* renamed from: s2.f$b */
    public interface b<T> {
        T get();
    }

    /* renamed from: a */
    public static <T> b<T> m76261a(b<T> bVar) {
        return new a(bVar);
    }
}
