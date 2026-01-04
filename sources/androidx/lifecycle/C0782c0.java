package androidx.lifecycle;

import android.app.Application;
import com.huawei.android.hicloud.drive.cloudphoto.model.Role;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.lang.reflect.InvocationTargetException;
import p597r0.AbstractC12450a;
import p597r0.C12453d;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: androidx.lifecycle.c0 */
/* loaded from: classes.dex */
public class C0782c0 {

    /* renamed from: a */
    public final C0786e0 f4150a;

    /* renamed from: b */
    public final b f4151b;

    /* renamed from: c */
    public final AbstractC12450a f4152c;

    /* renamed from: androidx.lifecycle.c0$b */
    public interface b {

        /* renamed from: a */
        public static final a f4158a = a.f4159a;

        /* renamed from: androidx.lifecycle.c0$b$a */
        public static final class a {

            /* renamed from: a */
            public static final /* synthetic */ a f4159a = new a();
        }

        /* renamed from: a */
        default <T extends AbstractC0780b0> T mo4828a(Class<T> cls) {
            C13267j.m79677e(cls, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        /* renamed from: b */
        default <T extends AbstractC0780b0> T mo4933b(Class<T> cls, AbstractC12450a abstractC12450a) {
            C13267j.m79677e(cls, "modelClass");
            C13267j.m79677e(abstractC12450a, JsbMapKeyNames.H5_EXTRAS);
            return (T) mo4828a(cls);
        }
    }

    /* renamed from: androidx.lifecycle.c0$c */
    public static class c implements b {

        /* renamed from: c */
        public static c f4161c;

        /* renamed from: b */
        public static final a f4160b = new a(null);

        /* renamed from: d */
        public static final AbstractC12450a.b<String> f4162d = a.C14410a.f4163a;

        /* renamed from: androidx.lifecycle.c0$c$a */
        public static final class a {

            /* renamed from: androidx.lifecycle.c0$c$a$a */
            public static final class C14410a implements AbstractC12450a.b<String> {

                /* renamed from: a */
                public static final C14410a f4163a = new C14410a();
            }

            public /* synthetic */ a(C13264g c13264g) {
                this();
            }

            /* renamed from: a */
            public final c m4939a() {
                if (c.f4161c == null) {
                    c.f4161c = new c();
                }
                c cVar = c.f4161c;
                C13267j.m79674b(cVar);
                return cVar;
            }

            public a() {
            }
        }

        @Override // androidx.lifecycle.C0782c0.b
        /* renamed from: a */
        public <T extends AbstractC0780b0> T mo4828a(Class<T> cls) throws IllegalAccessException, InstantiationException {
            C13267j.m79677e(cls, "modelClass");
            try {
                T tNewInstance = cls.newInstance();
                C13267j.m79676d(tNewInstance, "{\n                modelC…wInstance()\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            }
        }
    }

    /* renamed from: androidx.lifecycle.c0$d */
    public static class d {
        /* renamed from: c */
        public void mo4940c(AbstractC0780b0 abstractC0780b0) {
            C13267j.m79677e(abstractC0780b0, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0782c0(C0786e0 c0786e0, b bVar) {
        this(c0786e0, bVar, null, 4, null);
        C13267j.m79677e(c0786e0, "store");
        C13267j.m79677e(bVar, "factory");
    }

    /* renamed from: a */
    public <T extends AbstractC0780b0> T m4929a(Class<T> cls) {
        C13267j.m79677e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) m4930b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* renamed from: b */
    public <T extends AbstractC0780b0> T m4930b(String str, Class<T> cls) {
        T t10;
        C13267j.m79677e(str, "key");
        C13267j.m79677e(cls, "modelClass");
        T t11 = (T) this.f4150a.m4943b(str);
        if (!cls.isInstance(t11)) {
            C12453d c12453d = new C12453d(this.f4152c);
            c12453d.m74708c(c.f4162d, str);
            try {
                t10 = (T) this.f4151b.mo4933b(cls, c12453d);
            } catch (AbstractMethodError unused) {
                t10 = (T) this.f4151b.mo4828a(cls);
            }
            this.f4150a.m4945d(str, t10);
            return t10;
        }
        Object obj = this.f4151b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            C13267j.m79676d(t11, "viewModel");
            dVar.mo4940c(t11);
        }
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
    }

    /* renamed from: androidx.lifecycle.c0$a */
    public static class a extends c {

        /* renamed from: g */
        public static a f4154g;

        /* renamed from: e */
        public final Application f4156e;

        /* renamed from: f */
        public static final C14408a f4153f = new C14408a(null);

        /* renamed from: h */
        public static final AbstractC12450a.b<Application> f4155h = C14408a.C14409a.f4157a;

        /* renamed from: androidx.lifecycle.c0$a$a */
        public static final class C14408a {

            /* renamed from: androidx.lifecycle.c0$a$a$a */
            public static final class C14409a implements AbstractC12450a.b<Application> {

                /* renamed from: a */
                public static final C14409a f4157a = new C14409a();
            }

            public /* synthetic */ C14408a(C13264g c13264g) {
                this();
            }

            /* renamed from: a */
            public final b m4935a(InterfaceC0788f0 interfaceC0788f0) {
                C13267j.m79677e(interfaceC0788f0, Role.OWNER);
                if (!(interfaceC0788f0 instanceof InterfaceC0789g)) {
                    return c.f4160b.m4939a();
                }
                b bVarMo1917i = ((InterfaceC0789g) interfaceC0788f0).mo1917i();
                C13267j.m79676d(bVarMo1917i, "owner.defaultViewModelProviderFactory");
                return bVarMo1917i;
            }

            /* renamed from: b */
            public final a m4936b(Application application) {
                C13267j.m79677e(application, "application");
                if (a.f4154g == null) {
                    a.f4154g = new a(application);
                }
                a aVar = a.f4154g;
                C13267j.m79674b(aVar);
                return aVar;
            }

            public C14408a() {
            }
        }

        public a(Application application, int i10) {
            this.f4156e = application;
        }

        @Override // androidx.lifecycle.C0782c0.c, androidx.lifecycle.C0782c0.b
        /* renamed from: a */
        public <T extends AbstractC0780b0> T mo4828a(Class<T> cls) {
            C13267j.m79677e(cls, "modelClass");
            Application application = this.f4156e;
            if (application != null) {
                return (T) m4934g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.C0782c0.b
        /* renamed from: b */
        public <T extends AbstractC0780b0> T mo4933b(Class<T> cls, AbstractC12450a abstractC12450a) {
            C13267j.m79677e(cls, "modelClass");
            C13267j.m79677e(abstractC12450a, JsbMapKeyNames.H5_EXTRAS);
            if (this.f4156e != null) {
                return (T) mo4828a(cls);
            }
            Application application = (Application) abstractC12450a.mo74704a(f4155h);
            if (application != null) {
                return (T) m4934g(cls, application);
            }
            if (C0777a.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.mo4828a(cls);
        }

        /* renamed from: g */
        public final <T extends AbstractC0780b0> T m4934g(Class<T> cls, Application application) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (!C0777a.class.isAssignableFrom(cls)) {
                return (T) super.mo4828a(cls);
            }
            try {
                T tNewInstance = cls.getConstructor(Application.class).newInstance(application);
                C13267j.m79676d(tNewInstance, "{\n                try {\n…          }\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            C13267j.m79677e(application, "application");
        }
    }

    public C0782c0(C0786e0 c0786e0, b bVar, AbstractC12450a abstractC12450a) {
        C13267j.m79677e(c0786e0, "store");
        C13267j.m79677e(bVar, "factory");
        C13267j.m79677e(abstractC12450a, "defaultCreationExtras");
        this.f4150a = c0786e0;
        this.f4151b = bVar;
        this.f4152c = abstractC12450a;
    }

    public /* synthetic */ C0782c0(C0786e0 c0786e0, b bVar, AbstractC12450a abstractC12450a, int i10, C13264g c13264g) {
        this(c0786e0, bVar, (i10 & 4) != 0 ? AbstractC12450a.a.f57374b : abstractC12450a);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0782c0(InterfaceC0788f0 interfaceC0788f0) {
        C13267j.m79677e(interfaceC0788f0, Role.OWNER);
        C0786e0 viewModelStore = interfaceC0788f0.getViewModelStore();
        C13267j.m79676d(viewModelStore, "owner.viewModelStore");
        this(viewModelStore, a.f4153f.m4935a(interfaceC0788f0), C0784d0.m4941a(interfaceC0788f0));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0782c0(InterfaceC0788f0 interfaceC0788f0, b bVar) {
        C13267j.m79677e(interfaceC0788f0, Role.OWNER);
        C13267j.m79677e(bVar, "factory");
        C0786e0 viewModelStore = interfaceC0788f0.getViewModelStore();
        C13267j.m79676d(viewModelStore, "owner.viewModelStore");
        this(viewModelStore, bVar, C0784d0.m4941a(interfaceC0788f0));
    }
}
