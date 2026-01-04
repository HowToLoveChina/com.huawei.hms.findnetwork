package p645t2;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import p243e0.C9372g;
import p243e0.InterfaceC9370e;

/* renamed from: t2.a */
/* loaded from: classes.dex */
public final class C12920a {

    /* renamed from: a */
    public static final g<Object> f58938a = new a();

    /* renamed from: t2.a$a */
    public class a implements g<Object> {
        @Override // p645t2.C12920a.g
        /* renamed from: a */
        public void mo77572a(Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: t2.a$b */
    public class b<T> implements d<List<T>> {
        @Override // p645t2.C12920a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> mo6551a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: t2.a$c */
    public class c<T> implements g<List<T>> {
        @Override // p645t2.C12920a.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo77572a(List<T> list) {
            list.clear();
        }
    }

    /* renamed from: t2.a$d */
    public interface d<T> {
        /* renamed from: a */
        T mo6551a();
    }

    /* renamed from: t2.a$e */
    public static final class e<T> implements InterfaceC9370e<T> {

        /* renamed from: a */
        public final d<T> f58939a;

        /* renamed from: b */
        public final g<T> f58940b;

        /* renamed from: c */
        public final InterfaceC9370e<T> f58941c;

        public e(InterfaceC9370e<T> interfaceC9370e, d<T> dVar, g<T> gVar) {
            this.f58941c = interfaceC9370e;
            this.f58939a = dVar;
            this.f58940b = gVar;
        }

        @Override // p243e0.InterfaceC9370e
        /* renamed from: a */
        public boolean mo58737a(T t10) {
            if (t10 instanceof f) {
                ((f) t10).mo6553i().mo77582b(true);
            }
            this.f58940b.mo77572a(t10);
            return this.f58941c.mo58737a(t10);
        }

        @Override // p243e0.InterfaceC9370e
        /* renamed from: b */
        public T mo58738b() {
            T tMo58738b = this.f58941c.mo58738b();
            if (tMo58738b == null) {
                tMo58738b = this.f58939a.mo6551a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tMo58738b.getClass());
                }
            }
            if (tMo58738b instanceof f) {
                tMo58738b.mo6553i().mo77582b(false);
            }
            return (T) tMo58738b;
        }
    }

    /* renamed from: t2.a$f */
    public interface f {
        /* renamed from: i */
        AbstractC12922c mo6553i();
    }

    /* renamed from: t2.a$g */
    public interface g<T> {
        /* renamed from: a */
        void mo77572a(T t10);
    }

    /* renamed from: a */
    public static <T extends f> InterfaceC9370e<T> m77566a(InterfaceC9370e<T> interfaceC9370e, d<T> dVar) {
        return m77567b(interfaceC9370e, dVar, m77568c());
    }

    /* renamed from: b */
    public static <T> InterfaceC9370e<T> m77567b(InterfaceC9370e<T> interfaceC9370e, d<T> dVar, g<T> gVar) {
        return new e(interfaceC9370e, dVar, gVar);
    }

    /* renamed from: c */
    public static <T> g<T> m77568c() {
        return (g<T>) f58938a;
    }

    /* renamed from: d */
    public static <T extends f> InterfaceC9370e<T> m77569d(int i10, d<T> dVar) {
        return m77566a(new C9372g(i10), dVar);
    }

    /* renamed from: e */
    public static <T> InterfaceC9370e<List<T>> m77570e() {
        return m77571f(20);
    }

    /* renamed from: f */
    public static <T> InterfaceC9370e<List<T>> m77571f(int i10) {
        return m77567b(new C9372g(i10), new b(), new c());
    }
}
