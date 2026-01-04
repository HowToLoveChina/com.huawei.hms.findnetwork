package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.manager.C1620r;
import com.bumptech.glide.manager.C1623u;
import com.bumptech.glide.manager.InterfaceC1605c;
import com.bumptech.glide.manager.InterfaceC1606d;
import com.bumptech.glide.manager.InterfaceC1614l;
import com.bumptech.glide.manager.InterfaceC1615m;
import com.bumptech.glide.manager.InterfaceC1619q;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p415k2.C10973b;
import p507o2.InterfaceC11790c;
import p507o2.InterfaceC11792e;
import p542p2.InterfaceC12082i;
import p630s2.C12677l;
import p829z1.AbstractC14071j;

/* renamed from: com.bumptech.glide.k */
/* loaded from: classes.dex */
public class ComponentCallbacks2C1555k implements ComponentCallbacks2, InterfaceC1615m {

    /* renamed from: l */
    public static final RequestOptions f6907l = RequestOptions.decodeTypeOf(Bitmap.class).lock();

    /* renamed from: m */
    public static final RequestOptions f6908m = RequestOptions.decodeTypeOf(C10973b.class).lock();

    /* renamed from: n */
    public static final RequestOptions f6909n = RequestOptions.diskCacheStrategyOf(AbstractC14071j.f62956c).priority(EnumC1551g.LOW).skipMemoryCache(true);

    /* renamed from: a */
    public final ComponentCallbacks2C1546b f6910a;

    /* renamed from: b */
    public final Context f6911b;

    /* renamed from: c */
    public final InterfaceC1614l f6912c;

    /* renamed from: d */
    public final C1620r f6913d;

    /* renamed from: e */
    public final InterfaceC1619q f6914e;

    /* renamed from: f */
    public final C1623u f6915f;

    /* renamed from: g */
    public final Runnable f6916g;

    /* renamed from: h */
    public final InterfaceC1605c f6917h;

    /* renamed from: i */
    public final CopyOnWriteArrayList<InterfaceC11792e<Object>> f6918i;

    /* renamed from: j */
    public RequestOptions f6919j;

    /* renamed from: k */
    public boolean f6920k;

    /* renamed from: com.bumptech.glide.k$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacks2C1555k componentCallbacks2C1555k = ComponentCallbacks2C1555k.this;
            componentCallbacks2C1555k.f6912c.mo9170e(componentCallbacks2C1555k);
        }
    }

    /* renamed from: com.bumptech.glide.k$b */
    public class b implements InterfaceC1605c.a {

        /* renamed from: a */
        public final C1620r f6922a;

        public b(C1620r c1620r) {
            this.f6922a = c1620r;
        }

        @Override // com.bumptech.glide.manager.InterfaceC1605c.a
        /* renamed from: a */
        public void mo8993a(boolean z10) {
            if (z10) {
                synchronized (ComponentCallbacks2C1555k.this) {
                    this.f6922a.m9217e();
                }
            }
        }
    }

    public ComponentCallbacks2C1555k(ComponentCallbacks2C1546b componentCallbacks2C1546b, InterfaceC1614l interfaceC1614l, InterfaceC1619q interfaceC1619q, Context context) {
        this(componentCallbacks2C1546b, interfaceC1614l, interfaceC1619q, new C1620r(), componentCallbacks2C1546b.m8908g(), context);
    }

    /* renamed from: A */
    public final void m8974A(InterfaceC12082i<?> interfaceC12082i) {
        boolean zM8992z = m8992z(interfaceC12082i);
        InterfaceC11790c interfaceC11790cMo72224a = interfaceC12082i.mo72224a();
        if (zM8992z || this.f6910a.m8914p(interfaceC12082i) || interfaceC11790cMo72224a == null) {
            return;
        }
        interfaceC12082i.mo72225e(null);
        interfaceC11790cMo72224a.clear();
    }

    /* renamed from: i */
    public <ResourceType> C1554j<ResourceType> m8975i(Class<ResourceType> cls) {
        return new C1554j<>(this.f6910a, this, cls, this.f6911b);
    }

    /* renamed from: j */
    public C1554j<Bitmap> m8976j() {
        return m8975i(Bitmap.class).apply(f6907l);
    }

    /* renamed from: k */
    public C1554j<Drawable> m8977k() {
        return m8975i(Drawable.class);
    }

    /* renamed from: l */
    public C1554j<File> m8978l() {
        return m8975i(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    /* renamed from: m */
    public void m8979m(InterfaceC12082i<?> interfaceC12082i) {
        if (interfaceC12082i == null) {
            return;
        }
        m8974A(interfaceC12082i);
    }

    /* renamed from: n */
    public List<InterfaceC11792e<Object>> m8980n() {
        return this.f6918i;
    }

    /* renamed from: o */
    public synchronized RequestOptions m8981o() {
        return this.f6919j;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public synchronized void onDestroy() {
        try {
            this.f6915f.onDestroy();
            Iterator<InterfaceC12082i<?>> it = this.f6915f.m9244j().iterator();
            while (it.hasNext()) {
                m8979m(it.next());
            }
            this.f6915f.m9243i();
            this.f6913d.m9214b();
            this.f6912c.mo9171f(this);
            this.f6912c.mo9171f(this.f6917h);
            C12677l.m76298u(this.f6916g);
            this.f6910a.m8916s(this);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public synchronized void onStart() {
        m8989w();
        this.f6915f.onStart();
    }

    @Override // com.bumptech.glide.manager.InterfaceC1615m
    public synchronized void onStop() {
        m8988v();
        this.f6915f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f6920k) {
            m8987u();
        }
    }

    /* renamed from: p */
    public <T> AbstractC1556l<?, T> m8982p(Class<T> cls) {
        return this.f6910a.m8910i().m8923e(cls);
    }

    /* renamed from: q */
    public C1554j<Drawable> m8983q(Uri uri) {
        return m8977k().m8968q(uri);
    }

    /* renamed from: r */
    public C1554j<Drawable> m8984r(File file) {
        return m8977k().m8969r(file);
    }

    /* renamed from: s */
    public C1554j<Drawable> m8985s(String str) {
        return m8977k().m8971t(str);
    }

    /* renamed from: t */
    public synchronized void m8986t() {
        this.f6913d.m9215c();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f6913d + ", treeNode=" + this.f6914e + "}";
    }

    /* renamed from: u */
    public synchronized void m8987u() {
        m8986t();
        Iterator<ComponentCallbacks2C1555k> it = this.f6914e.mo9184a().iterator();
        while (it.hasNext()) {
            it.next().m8986t();
        }
    }

    /* renamed from: v */
    public synchronized void m8988v() {
        this.f6913d.m9216d();
    }

    /* renamed from: w */
    public synchronized void m8989w() {
        this.f6913d.m9218f();
    }

    /* renamed from: x */
    public synchronized void m8990x(RequestOptions requestOptions) {
        this.f6919j = requestOptions.mo85641clone().autoClone();
    }

    /* renamed from: y */
    public synchronized void m8991y(InterfaceC12082i<?> interfaceC12082i, InterfaceC11790c interfaceC11790c) {
        this.f6915f.m9245k(interfaceC12082i);
        this.f6913d.m9219g(interfaceC11790c);
    }

    /* renamed from: z */
    public synchronized boolean m8992z(InterfaceC12082i<?> interfaceC12082i) {
        InterfaceC11790c interfaceC11790cMo72224a = interfaceC12082i.mo72224a();
        if (interfaceC11790cMo72224a == null) {
            return true;
        }
        if (!this.f6913d.m9213a(interfaceC11790cMo72224a)) {
            return false;
        }
        this.f6915f.m9246l(interfaceC12082i);
        interfaceC12082i.mo72225e(null);
        return true;
    }

    public ComponentCallbacks2C1555k(ComponentCallbacks2C1546b componentCallbacks2C1546b, InterfaceC1614l interfaceC1614l, InterfaceC1619q interfaceC1619q, C1620r c1620r, InterfaceC1606d interfaceC1606d, Context context) {
        this.f6915f = new C1623u();
        a aVar = new a();
        this.f6916g = aVar;
        this.f6910a = componentCallbacks2C1546b;
        this.f6912c = interfaceC1614l;
        this.f6914e = interfaceC1619q;
        this.f6913d = c1620r;
        this.f6911b = context;
        InterfaceC1605c interfaceC1605cMo9188a = interfaceC1606d.mo9188a(context.getApplicationContext(), new b(c1620r));
        this.f6917h = interfaceC1605cMo9188a;
        if (C12677l.m76293p()) {
            C12677l.m76297t(aVar);
        } else {
            interfaceC1614l.mo9170e(this);
        }
        interfaceC1614l.mo9170e(interfaceC1605cMo9188a);
        this.f6918i = new CopyOnWriteArrayList<>(componentCallbacks2C1546b.m8910i().m8921c());
        m8990x(componentCallbacks2C1546b.m8910i().m8922d());
        componentCallbacks2C1546b.m8913o(this);
    }
}
