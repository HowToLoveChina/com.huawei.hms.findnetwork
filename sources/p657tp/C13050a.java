package p657tp;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import p371ik.C10527a;
import p586qp.InterfaceC12382a;
import p639sp.C12820a;
import p686up.InterfaceC13233a;
import p686up.InterfaceC13234b;
import p686up.InterfaceC13235c;

/* renamed from: tp.a */
/* loaded from: classes8.dex */
public class C13050a {

    /* renamed from: a */
    public final ConcurrentHashMap<Class<? extends InterfaceC13233a>, InterfaceC13233a> f59393a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public final Object f59394b = new Object();

    /* renamed from: c */
    public InterfaceC13234b f59395c;

    /* renamed from: a */
    public void m78762a() {
        synchronized (this.f59394b) {
            this.f59393a.clear();
            this.f59395c.clearAll();
        }
    }

    /* renamed from: b */
    public <T extends InterfaceC13233a> void m78763b(Class<T> cls) {
        synchronized (this.f59394b) {
            try {
                if (!cls.isAnnotationPresent(InterfaceC12382a.class)) {
                    throw new C12820a("Input class is not configurable!");
                }
                InterfaceC12382a interfaceC12382a = (InterfaceC12382a) cls.getAnnotation(InterfaceC12382a.class);
                this.f59393a.remove(cls);
                this.f59395c.mo79605a(interfaceC12382a.name());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public <T extends InterfaceC13233a> T m78764c(Class<T> cls) {
        T t10;
        synchronized (this.f59394b) {
            t10 = (T) m78767f(cls).getClone();
        }
        return t10;
    }

    /* renamed from: d */
    public <T extends InterfaceC13233a> void m78765d(Class<T> cls, InterfaceC13235c<T> interfaceC13235c) {
        synchronized (this.f59394b) {
            InterfaceC13233a interfaceC13233aM78767f = m78767f(cls);
            InterfaceC12382a interfaceC12382a = (InterfaceC12382a) cls.getAnnotation(InterfaceC12382a.class);
            interfaceC13235c.mo1517a(interfaceC13233aM78767f);
            this.f59395c.mo79606b(interfaceC12382a.name(), C10527a.m64633k(interfaceC13233aM78767f));
            this.f59393a.put(cls, interfaceC13233aM78767f);
        }
    }

    /* renamed from: e */
    public <T extends InterfaceC13233a> void m78766e(Class<T> cls, String str) {
        if (!cls.isAnnotationPresent(InterfaceC12382a.class)) {
            throw new C12820a("Input class is not configurable!");
        }
        InterfaceC12382a interfaceC12382a = (InterfaceC12382a) cls.getAnnotation(InterfaceC12382a.class);
        synchronized (this.f59394b) {
            this.f59393a.put(cls, (InterfaceC13233a) C10527a.m64631i(str, cls));
            this.f59395c.mo79606b(interfaceC12382a.name(), str);
        }
    }

    /* renamed from: f */
    public final <T extends InterfaceC13233a> T m78767f(Class<T> cls) throws IllegalAccessException, InstantiationException {
        T t10;
        if (!cls.isAnnotationPresent(InterfaceC12382a.class)) {
            throw new C12820a("Input class is not configurable!");
        }
        if (this.f59393a.containsKey(cls)) {
            return (T) this.f59393a.get(cls);
        }
        InterfaceC12382a interfaceC12382a = (InterfaceC12382a) cls.getAnnotation(InterfaceC12382a.class);
        String strMo79607c = this.f59395c.mo79607c(interfaceC12382a.name(), "");
        if (!TextUtils.isEmpty(strMo79607c) && (t10 = (T) C10527a.m64629g(strMo79607c, cls)) != null) {
            if (interfaceC12382a.memoryCache()) {
                this.f59393a.put(cls, t10);
            }
            this.f59395c.mo79606b(interfaceC12382a.name(), C10527a.m64633k(t10));
            return t10;
        }
        try {
            T tNewInstance = cls.newInstance();
            this.f59393a.put(cls, tNewInstance);
            this.f59395c.mo79606b(interfaceC12382a.name(), C10527a.m64633k(tNewInstance));
            return tNewInstance;
        } catch (IllegalAccessException unused) {
            throw new C12820a("IllegalAccessException occurred while creating Class " + cls.getSimpleName());
        } catch (InstantiationException unused2) {
            throw new C12820a("InstantiationException occurred while creating Class " + cls.getSimpleName());
        }
    }
}
