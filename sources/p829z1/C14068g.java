package p829z1;

import com.bumptech.glide.C1548d;
import com.bumptech.glide.C1552h;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1564e;
import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p003a2.InterfaceC0007b;
import p275f2.C9646c;
import p759x1.C13684i;
import p759x1.InterfaceC13679d;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13687l;
import p759x1.InterfaceC13688m;
import p829z1.RunnableC14069h;

/* renamed from: z1.g */
/* loaded from: classes.dex */
public final class C14068g<Transcode> {

    /* renamed from: a */
    public final List<InterfaceC1589f.a<?>> f62877a = new ArrayList();

    /* renamed from: b */
    public final List<InterfaceC13681f> f62878b = new ArrayList();

    /* renamed from: c */
    public C1548d f62879c;

    /* renamed from: d */
    public Object f62880d;

    /* renamed from: e */
    public int f62881e;

    /* renamed from: f */
    public int f62882f;

    /* renamed from: g */
    public Class<?> f62883g;

    /* renamed from: h */
    public RunnableC14069h.e f62884h;

    /* renamed from: i */
    public C13684i f62885i;

    /* renamed from: j */
    public Map<Class<?>, InterfaceC13688m<?>> f62886j;

    /* renamed from: k */
    public Class<Transcode> f62887k;

    /* renamed from: l */
    public boolean f62888l;

    /* renamed from: m */
    public boolean f62889m;

    /* renamed from: n */
    public InterfaceC13681f f62890n;

    /* renamed from: o */
    public EnumC1551g f62891o;

    /* renamed from: p */
    public AbstractC14071j f62892p;

    /* renamed from: q */
    public boolean f62893q;

    /* renamed from: r */
    public boolean f62894r;

    /* renamed from: a */
    public void m84284a() {
        this.f62879c = null;
        this.f62880d = null;
        this.f62890n = null;
        this.f62883g = null;
        this.f62887k = null;
        this.f62885i = null;
        this.f62891o = null;
        this.f62886j = null;
        this.f62892p = null;
        this.f62877a.clear();
        this.f62888l = false;
        this.f62878b.clear();
        this.f62889m = false;
    }

    /* renamed from: b */
    public InterfaceC0007b m84285b() {
        return this.f62879c.m8920b();
    }

    /* renamed from: c */
    public List<InterfaceC13681f> m84286c() {
        if (!this.f62889m) {
            this.f62889m = true;
            this.f62878b.clear();
            List<InterfaceC1589f.a<?>> listM84290g = m84290g();
            int size = listM84290g.size();
            for (int i10 = 0; i10 < size; i10++) {
                InterfaceC1589f.a<?> aVar = listM84290g.get(i10);
                if (!this.f62878b.contains(aVar.f7021a)) {
                    this.f62878b.add(aVar.f7021a);
                }
                for (int i11 = 0; i11 < aVar.f7022b.size(); i11++) {
                    if (!this.f62878b.contains(aVar.f7022b.get(i11))) {
                        this.f62878b.add(aVar.f7022b.get(i11));
                    }
                }
            }
        }
        return this.f62878b;
    }

    /* renamed from: d */
    public InterfaceC1579a m84287d() {
        return this.f62884h.mo84343a();
    }

    /* renamed from: e */
    public AbstractC14071j m84288e() {
        return this.f62892p;
    }

    /* renamed from: f */
    public int m84289f() {
        return this.f62882f;
    }

    /* renamed from: g */
    public List<InterfaceC1589f.a<?>> m84290g() {
        if (!this.f62888l) {
            this.f62888l = true;
            this.f62877a.clear();
            List listM8939i = this.f62879c.m8927i().m8939i(this.f62880d);
            int size = listM8939i.size();
            for (int i10 = 0; i10 < size; i10++) {
                InterfaceC1589f.a<?> aVarMo9071b = ((InterfaceC1589f) listM8939i.get(i10)).mo9071b(this.f62880d, this.f62881e, this.f62882f, this.f62885i);
                if (aVarMo9071b != null) {
                    this.f62877a.add(aVarMo9071b);
                }
            }
        }
        return this.f62877a;
    }

    /* renamed from: h */
    public <Data> C14081t<Data, ?, Transcode> m84291h(Class<Data> cls) {
        return this.f62879c.m8927i().m8938h(cls, this.f62883g, this.f62887k);
    }

    /* renamed from: i */
    public Class<?> m84292i() {
        return this.f62880d.getClass();
    }

    /* renamed from: j */
    public List<InterfaceC1589f<File, ?>> m84293j(File file) throws C1552h.c {
        return this.f62879c.m8927i().m8939i(file);
    }

    /* renamed from: k */
    public C13684i m84294k() {
        return this.f62885i;
    }

    /* renamed from: l */
    public EnumC1551g m84295l() {
        return this.f62891o;
    }

    /* renamed from: m */
    public List<Class<?>> m84296m() {
        return this.f62879c.m8927i().m8940j(this.f62880d.getClass(), this.f62883g, this.f62887k);
    }

    /* renamed from: n */
    public <Z> InterfaceC13687l<Z> m84297n(InterfaceC14083v<Z> interfaceC14083v) {
        return this.f62879c.m8927i().m8941k(interfaceC14083v);
    }

    /* renamed from: o */
    public <T> InterfaceC1564e<T> m84298o(T t10) {
        return this.f62879c.m8927i().m8942l(t10);
    }

    /* renamed from: p */
    public InterfaceC13681f m84299p() {
        return this.f62890n;
    }

    /* renamed from: q */
    public <X> InterfaceC13679d<X> m84300q(X x10) throws C1552h.e {
        return this.f62879c.m8927i().m8943m(x10);
    }

    /* renamed from: r */
    public Class<?> m84301r() {
        return this.f62887k;
    }

    /* renamed from: s */
    public <Z> InterfaceC13688m<Z> m84302s(Class<Z> cls) {
        InterfaceC13688m<Z> interfaceC13688m = (InterfaceC13688m) this.f62886j.get(cls);
        if (interfaceC13688m == null) {
            Iterator<Map.Entry<Class<?>, InterfaceC13688m<?>>> it = this.f62886j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, InterfaceC13688m<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    interfaceC13688m = (InterfaceC13688m) next.getValue();
                    break;
                }
            }
        }
        if (interfaceC13688m != null) {
            return interfaceC13688m;
        }
        if (!this.f62886j.isEmpty() || !this.f62893q) {
            return C9646c.m60256c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* renamed from: t */
    public int m84303t() {
        return this.f62881e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    public boolean m84304u(Class<?> cls) {
        return m84291h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: v */
    public <R> void m84305v(C1548d c1548d, Object obj, InterfaceC13681f interfaceC13681f, int i10, int i11, AbstractC14071j abstractC14071j, Class<?> cls, Class<R> cls2, EnumC1551g enumC1551g, C13684i c13684i, Map<Class<?>, InterfaceC13688m<?>> map, boolean z10, boolean z11, RunnableC14069h.e eVar) {
        this.f62879c = c1548d;
        this.f62880d = obj;
        this.f62890n = interfaceC13681f;
        this.f62881e = i10;
        this.f62882f = i11;
        this.f62892p = abstractC14071j;
        this.f62883g = cls;
        this.f62884h = eVar;
        this.f62887k = cls2;
        this.f62891o = enumC1551g;
        this.f62885i = c13684i;
        this.f62886j = map;
        this.f62893q = z10;
        this.f62894r = z11;
    }

    /* renamed from: w */
    public boolean m84306w(InterfaceC14083v<?> interfaceC14083v) {
        return this.f62879c.m8927i().m8944n(interfaceC14083v);
    }

    /* renamed from: x */
    public boolean m84307x() {
        return this.f62894r;
    }

    /* renamed from: y */
    public boolean m84308y(InterfaceC13681f interfaceC13681f) {
        List<InterfaceC1589f.a<?>> listM84290g = m84290g();
        int size = listM84290g.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (listM84290g.get(i10).f7021a.equals(interfaceC13681f)) {
                return true;
            }
        }
        return false;
    }
}
