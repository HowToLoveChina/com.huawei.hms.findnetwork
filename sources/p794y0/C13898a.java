package p794y0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.R$string;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p828z0.C14060a;

/* renamed from: y0.a */
/* loaded from: classes.dex */
public final class C13898a {

    /* renamed from: d */
    public static volatile C13898a f62241d;

    /* renamed from: e */
    public static final Object f62242e = new Object();

    /* renamed from: c */
    public final Context f62245c;

    /* renamed from: b */
    public final Set<Class<? extends InterfaceC13899b<?>>> f62244b = new HashSet();

    /* renamed from: a */
    public final Map<Class<?>, Object> f62243a = new HashMap();

    public C13898a(Context context) {
        this.f62245c = context.getApplicationContext();
    }

    /* renamed from: e */
    public static C13898a m83303e(Context context) {
        if (f62241d == null) {
            synchronized (f62242e) {
                try {
                    if (f62241d == null) {
                        f62241d = new C13898a(context);
                    }
                } finally {
                }
            }
        }
        return f62241d;
    }

    /* renamed from: a */
    public void m83304a() {
        try {
            try {
                C14060a.m84265a("Startup");
                m83305b(this.f62245c.getPackageManager().getProviderInfo(new ComponentName(this.f62245c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new C13900c(e10);
            }
        } finally {
            C14060a.m84266b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public void m83305b(Bundle bundle) throws ClassNotFoundException {
        String string = this.f62245c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (InterfaceC13899b.class.isAssignableFrom(cls)) {
                            this.f62244b.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends InterfaceC13899b<?>>> it = this.f62244b.iterator();
                while (it.hasNext()) {
                    m83307d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new C13900c(e10);
            }
        }
    }

    /* renamed from: c */
    public <T> T m83306c(Class<? extends InterfaceC13899b<?>> cls) {
        T t10;
        synchronized (f62242e) {
            try {
                t10 = (T) this.f62243a.get(cls);
                if (t10 == null) {
                    t10 = (T) m83307d(cls, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t10;
    }

    /* renamed from: d */
    public final <T> T m83307d(Class<? extends InterfaceC13899b<?>> cls, Set<Class<?>> set) {
        T t10;
        if (C14060a.m84268d()) {
            try {
                C14060a.m84265a(cls.getSimpleName());
            } catch (Throwable th2) {
                C14060a.m84266b();
                throw th2;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f62243a.containsKey(cls)) {
            t10 = (T) this.f62243a.get(cls);
        } else {
            set.add(cls);
            try {
                InterfaceC13899b<?> interfaceC13899bNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends InterfaceC13899b<?>>> listMo4189a = interfaceC13899bNewInstance.mo4189a();
                if (!listMo4189a.isEmpty()) {
                    for (Class<? extends InterfaceC13899b<?>> cls2 : listMo4189a) {
                        if (!this.f62243a.containsKey(cls2)) {
                            m83307d(cls2, set);
                        }
                    }
                }
                t10 = (T) interfaceC13899bNewInstance.mo4190b(this.f62245c);
                set.remove(cls);
                this.f62243a.put(cls, t10);
            } catch (Throwable th3) {
                throw new C13900c(th3);
            }
        }
        C14060a.m84266b();
        return t10;
    }

    /* renamed from: f */
    public <T> T m83308f(Class<? extends InterfaceC13899b<T>> cls) {
        return (T) m83306c(cls);
    }

    /* renamed from: g */
    public boolean m83309g(Class<? extends InterfaceC13899b<?>> cls) {
        return this.f62244b.contains(cls);
    }
}
