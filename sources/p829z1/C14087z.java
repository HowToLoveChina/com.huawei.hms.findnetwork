package p829z1;

import android.util.Log;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.data.InterfaceC1564e;
import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import p630s2.C12672g;
import p759x1.EnumC13676a;
import p759x1.InterfaceC13679d;
import p759x1.InterfaceC13681f;
import p829z1.InterfaceC14067f;

/* renamed from: z1.z */
/* loaded from: classes.dex */
public class C14087z implements InterfaceC14067f, InterfaceC14067f.a {

    /* renamed from: a */
    public final C14068g<?> f63075a;

    /* renamed from: b */
    public final InterfaceC14067f.a f63076b;

    /* renamed from: c */
    public volatile int f63077c;

    /* renamed from: d */
    public volatile C14064c f63078d;

    /* renamed from: e */
    public volatile Object f63079e;

    /* renamed from: f */
    public volatile InterfaceC1589f.a<?> f63080f;

    /* renamed from: g */
    public volatile C14065d f63081g;

    /* renamed from: z1.z$a */
    public class a implements InterfaceC1563d.a<Object> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC1589f.a f63082a;

        public a(InterfaceC1589f.a aVar) {
            this.f63082a = aVar;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
        /* renamed from: c */
        public void mo9030c(Exception exc) {
            if (C14087z.this.m84426d(this.f63082a)) {
                C14087z.this.m84428i(this.f63082a, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
        /* renamed from: f */
        public void mo9031f(Object obj) {
            if (C14087z.this.m84426d(this.f63082a)) {
                C14087z.this.m84427g(this.f63082a, obj);
            }
        }
    }

    public C14087z(C14068g<?> c14068g, InterfaceC14067f.a aVar) {
        this.f63075a = c14068g;
        this.f63076b = aVar;
    }

    @Override // p829z1.InterfaceC14067f
    /* renamed from: a */
    public boolean mo84280a() {
        if (this.f63079e != null) {
            Object obj = this.f63079e;
            this.f63079e = null;
            try {
                if (!m84424b(obj)) {
                    return true;
                }
            } catch (IOException e10) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e10);
                }
            }
        }
        if (this.f63078d != null && this.f63078d.mo84280a()) {
            return true;
        }
        this.f63078d = null;
        this.f63080f = null;
        boolean z10 = false;
        while (!z10 && m84425c()) {
            List<InterfaceC1589f.a<?>> listM84290g = this.f63075a.m84290g();
            int i10 = this.f63077c;
            this.f63077c = i10 + 1;
            this.f63080f = listM84290g.get(i10);
            if (this.f63080f != null && (this.f63075a.m84288e().mo84354c(this.f63080f.f7023c.mo9024d()) || this.f63075a.m84304u(this.f63080f.f7023c.mo9017a()))) {
                m84429j(this.f63080f);
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: b */
    public final boolean m84424b(Object obj) throws Throwable {
        long jM76263b = C12672g.m76263b();
        boolean z10 = false;
        try {
            InterfaceC1564e<T> interfaceC1564eM84298o = this.f63075a.m84298o(obj);
            Object objMo9011a = interfaceC1564eM84298o.mo9011a();
            InterfaceC13679d<X> interfaceC13679dM84300q = this.f63075a.m84300q(objMo9011a);
            C14066e c14066e = new C14066e(interfaceC13679dM84300q, objMo9011a, this.f63075a.m84294k());
            C14065d c14065d = new C14065d(this.f63080f.f7021a, this.f63075a.m84299p());
            InterfaceC1579a interfaceC1579aM84287d = this.f63075a.m84287d();
            interfaceC1579aM84287d.mo9066b(c14065d, c14066e);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + c14065d + ", data: " + obj + ", encoder: " + interfaceC13679dM84300q + ", duration: " + C12672g.m76262a(jM76263b));
            }
            if (interfaceC1579aM84287d.mo9065a(c14065d) != null) {
                this.f63081g = c14065d;
                this.f63078d = new C14064c(Collections.singletonList(this.f63080f.f7021a), this.f63075a, this);
                this.f63080f.f7023c.mo9022b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f63081g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f63076b.mo84281e(this.f63080f.f7021a, interfaceC1564eM84298o.mo9011a(), this.f63080f.f7023c, this.f63080f.f7023c.mo9024d(), this.f63080f.f7021a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                if (!z10) {
                    this.f63080f.f7023c.mo9022b();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: c */
    public final boolean m84425c() {
        return this.f63077c < this.f63075a.m84290g().size();
    }

    @Override // p829z1.InterfaceC14067f
    public void cancel() {
        InterfaceC1589f.a<?> aVar = this.f63080f;
        if (aVar != null) {
            aVar.f7023c.cancel();
        }
    }

    /* renamed from: d */
    public boolean m84426d(InterfaceC1589f.a<?> aVar) {
        InterfaceC1589f.a<?> aVar2 = this.f63080f;
        return aVar2 != null && aVar2 == aVar;
    }

    @Override // p829z1.InterfaceC14067f.a
    /* renamed from: e */
    public void mo84281e(InterfaceC13681f interfaceC13681f, Object obj, InterfaceC1563d<?> interfaceC1563d, EnumC13676a enumC13676a, InterfaceC13681f interfaceC13681f2) {
        this.f63076b.mo84281e(interfaceC13681f, obj, interfaceC1563d, this.f63080f.f7023c.mo9024d(), interfaceC13681f);
    }

    @Override // p829z1.InterfaceC14067f.a
    /* renamed from: f */
    public void mo84282f(InterfaceC13681f interfaceC13681f, Exception exc, InterfaceC1563d<?> interfaceC1563d, EnumC13676a enumC13676a) {
        this.f63076b.mo84282f(interfaceC13681f, exc, interfaceC1563d, this.f63080f.f7023c.mo9024d());
    }

    /* renamed from: g */
    public void m84427g(InterfaceC1589f.a<?> aVar, Object obj) {
        AbstractC14071j abstractC14071jM84288e = this.f63075a.m84288e();
        if (obj != null && abstractC14071jM84288e.mo84354c(aVar.f7023c.mo9024d())) {
            this.f63079e = obj;
            this.f63076b.mo84283h();
        } else {
            InterfaceC14067f.a aVar2 = this.f63076b;
            InterfaceC13681f interfaceC13681f = aVar.f7021a;
            InterfaceC1563d<?> interfaceC1563d = aVar.f7023c;
            aVar2.mo84281e(interfaceC13681f, obj, interfaceC1563d, interfaceC1563d.mo9024d(), this.f63081g);
        }
    }

    @Override // p829z1.InterfaceC14067f.a
    /* renamed from: h */
    public void mo84283h() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: i */
    public void m84428i(InterfaceC1589f.a<?> aVar, Exception exc) {
        InterfaceC14067f.a aVar2 = this.f63076b;
        C14065d c14065d = this.f63081g;
        InterfaceC1563d<?> interfaceC1563d = aVar.f7023c;
        aVar2.mo84282f(c14065d, exc, interfaceC1563d, interfaceC1563d.mo9024d());
    }

    /* renamed from: j */
    public final void m84429j(InterfaceC1589f.a<?> aVar) {
        this.f63080f.f7023c.mo9025e(this.f63075a.m84295l(), new a(aVar));
    }
}
