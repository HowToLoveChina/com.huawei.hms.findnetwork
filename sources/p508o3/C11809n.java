package p508o3;

import java.util.concurrent.atomic.AtomicLong;
import p468m3.InterfaceC11399e;

/* renamed from: o3.n */
/* loaded from: classes.dex */
public final class C11809n {

    /* renamed from: a */
    public static final InterfaceC11399e<InterfaceC11808m> f54689a;

    /* renamed from: o3.n$a */
    public class a implements InterfaceC11399e<InterfaceC11808m> {
        @Override // p468m3.InterfaceC11399e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC11808m get() {
            return new C11810o();
        }
    }

    /* renamed from: o3.n$b */
    public class b implements InterfaceC11399e<InterfaceC11808m> {
        @Override // p468m3.InterfaceC11399e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC11808m get() {
            return new c(null);
        }
    }

    /* renamed from: o3.n$c */
    public static final class c extends AtomicLong implements InterfaceC11808m {
        public c() {
        }

        @Override // p508o3.InterfaceC11808m
        /* renamed from: b */
        public void mo70356b() {
            getAndIncrement();
        }

        @Override // p508o3.InterfaceC11808m
        /* renamed from: c */
        public void mo70357c(long j10) {
            getAndAdd(j10);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterfaceC11399e<InterfaceC11808m> bVar;
        try {
            new C11810o();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f54689a = bVar;
    }

    /* renamed from: a */
    public static InterfaceC11808m m70358a() {
        return f54689a.get();
    }
}
