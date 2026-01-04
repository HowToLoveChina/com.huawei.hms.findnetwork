package p829z1;

import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.File;
import java.util.List;
import p645t2.C12921b;
import p759x1.EnumC13676a;
import p759x1.InterfaceC13681f;
import p829z1.InterfaceC14067f;

/* renamed from: z1.w */
/* loaded from: classes.dex */
public class C14084w implements InterfaceC14067f, InterfaceC1563d.a<Object> {

    /* renamed from: a */
    public final InterfaceC14067f.a f63054a;

    /* renamed from: b */
    public final C14068g<?> f63055b;

    /* renamed from: c */
    public int f63056c;

    /* renamed from: d */
    public int f63057d = -1;

    /* renamed from: e */
    public InterfaceC13681f f63058e;

    /* renamed from: f */
    public List<InterfaceC1589f<File, ?>> f63059f;

    /* renamed from: g */
    public int f63060g;

    /* renamed from: h */
    public volatile InterfaceC1589f.a<?> f63061h;

    /* renamed from: i */
    public File f63062i;

    /* renamed from: j */
    public C14085x f63063j;

    public C14084w(C14068g<?> c14068g, InterfaceC14067f.a aVar) {
        this.f63055b = c14068g;
        this.f63054a = aVar;
    }

    /* renamed from: b */
    private boolean m84421b() {
        return this.f63060g < this.f63059f.size();
    }

    @Override // p829z1.InterfaceC14067f
    /* renamed from: a */
    public boolean mo84280a() {
        C12921b.m77575a("ResourceCacheGenerator.startNext");
        try {
            List<InterfaceC13681f> listM84286c = this.f63055b.m84286c();
            boolean z10 = false;
            if (listM84286c.isEmpty()) {
                C12921b.m77579e();
                return false;
            }
            List<Class<?>> listM84296m = this.f63055b.m84296m();
            if (listM84296m.isEmpty()) {
                if (File.class.equals(this.f63055b.m84301r())) {
                    C12921b.m77579e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f63055b.m84292i() + " to " + this.f63055b.m84301r());
            }
            while (true) {
                if (this.f63059f != null && m84421b()) {
                    this.f63061h = null;
                    while (!z10 && m84421b()) {
                        List<InterfaceC1589f<File, ?>> list = this.f63059f;
                        int i10 = this.f63060g;
                        this.f63060g = i10 + 1;
                        this.f63061h = list.get(i10).mo9071b(this.f63062i, this.f63055b.m84303t(), this.f63055b.m84289f(), this.f63055b.m84294k());
                        if (this.f63061h != null && this.f63055b.m84304u(this.f63061h.f7023c.mo9017a())) {
                            this.f63061h.f7023c.mo9025e(this.f63055b.m84295l(), this);
                            z10 = true;
                        }
                    }
                    C12921b.m77579e();
                    return z10;
                }
                int i11 = this.f63057d + 1;
                this.f63057d = i11;
                if (i11 >= listM84296m.size()) {
                    int i12 = this.f63056c + 1;
                    this.f63056c = i12;
                    if (i12 >= listM84286c.size()) {
                        C12921b.m77579e();
                        return false;
                    }
                    this.f63057d = 0;
                }
                InterfaceC13681f interfaceC13681f = listM84286c.get(this.f63056c);
                Class<?> cls = listM84296m.get(this.f63057d);
                this.f63063j = new C14085x(this.f63055b.m84285b(), interfaceC13681f, this.f63055b.m84299p(), this.f63055b.m84303t(), this.f63055b.m84289f(), this.f63055b.m84302s(cls), cls, this.f63055b.m84294k());
                File fileMo9065a = this.f63055b.m84287d().mo9065a(this.f63063j);
                this.f63062i = fileMo9065a;
                if (fileMo9065a != null) {
                    this.f63058e = interfaceC13681f;
                    this.f63059f = this.f63055b.m84293j(fileMo9065a);
                    this.f63060g = 0;
                }
            }
        } catch (Throwable th2) {
            C12921b.m77579e();
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
    /* renamed from: c */
    public void mo9030c(Exception exc) {
        this.f63054a.mo84282f(this.f63063j, exc, this.f63061h.f7023c, EnumC13676a.RESOURCE_DISK_CACHE);
    }

    @Override // p829z1.InterfaceC14067f
    public void cancel() {
        InterfaceC1589f.a<?> aVar = this.f63061h;
        if (aVar != null) {
            aVar.f7023c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
    /* renamed from: f */
    public void mo9031f(Object obj) {
        this.f63054a.mo84281e(this.f63058e, obj, this.f63061h.f7023c, EnumC13676a.RESOURCE_DISK_CACHE, this.f63063j);
    }
}
