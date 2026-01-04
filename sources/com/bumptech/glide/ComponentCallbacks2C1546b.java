package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.bumptech.glide.manager.C1618p;
import com.bumptech.glide.manager.InterfaceC1606d;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p003a2.InterfaceC0007b;
import p003a2.InterfaceC0009d;
import p026b2.InterfaceC1101c;
import p467m2.AbstractC11392a;
import p467m2.InterfaceC11393b;
import p507o2.InterfaceC11792e;
import p542p2.C12079f;
import p542p2.InterfaceC12082i;
import p630s2.C12676k;
import p630s2.C12677l;
import p829z1.C14072k;

/* renamed from: com.bumptech.glide.b */
/* loaded from: classes.dex */
public class ComponentCallbacks2C1546b implements ComponentCallbacks2 {

    /* renamed from: k */
    public static volatile ComponentCallbacks2C1546b f6823k;

    /* renamed from: l */
    public static volatile boolean f6824l;

    /* renamed from: a */
    public final C14072k f6825a;

    /* renamed from: b */
    public final InterfaceC0009d f6826b;

    /* renamed from: c */
    public final InterfaceC1101c f6827c;

    /* renamed from: d */
    public final C1548d f6828d;

    /* renamed from: e */
    public final InterfaceC0007b f6829e;

    /* renamed from: f */
    public final C1618p f6830f;

    /* renamed from: g */
    public final InterfaceC1606d f6831g;

    /* renamed from: i */
    public final a f6833i;

    /* renamed from: h */
    public final List<ComponentCallbacks2C1555k> f6832h = new ArrayList();

    /* renamed from: j */
    public EnumC1550f f6834j = EnumC1550f.NORMAL;

    /* renamed from: com.bumptech.glide.b$a */
    public interface a {
        RequestOptions build();
    }

    public ComponentCallbacks2C1546b(Context context, C14072k c14072k, InterfaceC1101c interfaceC1101c, InterfaceC0009d interfaceC0009d, InterfaceC0007b interfaceC0007b, C1618p c1618p, InterfaceC1606d interfaceC1606d, int i10, a aVar, Map<Class<?>, AbstractC1556l<?, ?>> map, List<InterfaceC11792e<Object>> list, List<InterfaceC11393b> list2, AbstractC11392a abstractC11392a, C1549e c1549e) {
        this.f6825a = c14072k;
        this.f6826b = interfaceC0009d;
        this.f6829e = interfaceC0007b;
        this.f6827c = interfaceC1101c;
        this.f6830f = c1618p;
        this.f6831g = interfaceC1606d;
        this.f6833i = aVar;
        this.f6828d = new C1548d(context, interfaceC0007b, C1553i.m8952d(this, list2, abstractC11392a), new C12079f(), aVar, map, list, c14072k, c1549e, i10);
    }

    /* renamed from: a */
    public static void m8897a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (f6824l) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f6824l = true;
        m8901m(context, generatedAppGlideModule);
        f6824l = false;
    }

    /* renamed from: c */
    public static ComponentCallbacks2C1546b m8898c(Context context) {
        if (f6823k == null) {
            GeneratedAppGlideModule generatedAppGlideModuleM8899d = m8899d(context.getApplicationContext());
            synchronized (ComponentCallbacks2C1546b.class) {
                try {
                    if (f6823k == null) {
                        m8897a(context, generatedAppGlideModuleM8899d);
                    }
                } finally {
                }
            }
        }
        return f6823k;
    }

    /* renamed from: d */
    public static GeneratedAppGlideModule m8899d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e10) {
            m8903q(e10);
            return null;
        } catch (InstantiationException e11) {
            m8903q(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            m8903q(e12);
            return null;
        } catch (InvocationTargetException e13) {
            m8903q(e13);
            return null;
        }
    }

    /* renamed from: l */
    public static C1618p m8900l(Context context) {
        C12676k.m76277e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m8898c(context).m8912k();
    }

    /* renamed from: m */
    public static void m8901m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        m8902n(context, new C1547c(), generatedAppGlideModule);
    }

    /* renamed from: n */
    public static void m8902n(Context context, C1547c c1547c, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<InterfaceC11393b> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.m68298c()) {
            listEmptyList = new ManifestParser(applicationContext).m9249a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.m8895d().isEmpty()) {
            Set<Class<?>> setM8895d = generatedAppGlideModule.m8895d();
            Iterator<InterfaceC11393b> it = listEmptyList.iterator();
            while (it.hasNext()) {
                InterfaceC11393b next = it.next();
                if (setM8895d.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<InterfaceC11393b> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        c1547c.m8918b(generatedAppGlideModule != null ? generatedAppGlideModule.m8896e() : null);
        Iterator<InterfaceC11393b> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().m68299a(applicationContext, c1547c);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.m68297b(applicationContext, c1547c);
        }
        ComponentCallbacks2C1546b componentCallbacks2C1546bM8917a = c1547c.m8917a(applicationContext, listEmptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(componentCallbacks2C1546bM8917a);
        f6823k = componentCallbacks2C1546bM8917a;
    }

    /* renamed from: q */
    public static void m8903q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    /* renamed from: t */
    public static ComponentCallbacks2C1555k m8904t(Context context) {
        return m8900l(context).m9201f(context);
    }

    /* renamed from: b */
    public void m8905b() {
        C12677l.m76278a();
        this.f6827c.clearMemory();
        this.f6826b.clearMemory();
        this.f6829e.clearMemory();
    }

    /* renamed from: e */
    public InterfaceC0007b m8906e() {
        return this.f6829e;
    }

    /* renamed from: f */
    public InterfaceC0009d m8907f() {
        return this.f6826b;
    }

    /* renamed from: g */
    public InterfaceC1606d m8908g() {
        return this.f6831g;
    }

    /* renamed from: h */
    public Context m8909h() {
        return this.f6828d.getBaseContext();
    }

    /* renamed from: i */
    public C1548d m8910i() {
        return this.f6828d;
    }

    /* renamed from: j */
    public C1552h m8911j() {
        return this.f6828d.m8927i();
    }

    /* renamed from: k */
    public C1618p m8912k() {
        return this.f6830f;
    }

    /* renamed from: o */
    public void m8913o(ComponentCallbacks2C1555k componentCallbacks2C1555k) {
        synchronized (this.f6832h) {
            try {
                if (this.f6832h.contains(componentCallbacks2C1555k)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f6832h.add(componentCallbacks2C1555k);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        m8905b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        m8915r(i10);
    }

    /* renamed from: p */
    public boolean m8914p(InterfaceC12082i<?> interfaceC12082i) {
        synchronized (this.f6832h) {
            try {
                Iterator<ComponentCallbacks2C1555k> it = this.f6832h.iterator();
                while (it.hasNext()) {
                    if (it.next().m8992z(interfaceC12082i)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: r */
    public void m8915r(int i10) {
        C12677l.m76278a();
        synchronized (this.f6832h) {
            try {
                Iterator<ComponentCallbacks2C1555k> it = this.f6832h.iterator();
                while (it.hasNext()) {
                    it.next().onTrimMemory(i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f6827c.mo6540a(i10);
        this.f6826b.mo14a(i10);
        this.f6829e.mo8a(i10);
    }

    /* renamed from: s */
    public void m8916s(ComponentCallbacks2C1555k componentCallbacks2C1555k) {
        synchronized (this.f6832h) {
            try {
                if (!this.f6832h.contains(componentCallbacks2C1555k)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f6832h.remove(componentCallbacks2C1555k);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
