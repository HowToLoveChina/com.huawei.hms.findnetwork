package p829z1;

import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.File;
import java.util.List;
import p759x1.EnumC13676a;
import p759x1.InterfaceC13681f;
import p829z1.InterfaceC14067f;

/* renamed from: z1.c */
/* loaded from: classes.dex */
public class C14064c implements InterfaceC14067f, InterfaceC1563d.a<Object> {

    /* renamed from: a */
    public final List<InterfaceC13681f> f62863a;

    /* renamed from: b */
    public final C14068g<?> f62864b;

    /* renamed from: c */
    public final InterfaceC14067f.a f62865c;

    /* renamed from: d */
    public int f62866d;

    /* renamed from: e */
    public InterfaceC13681f f62867e;

    /* renamed from: f */
    public List<InterfaceC1589f<File, ?>> f62868f;

    /* renamed from: g */
    public int f62869g;

    /* renamed from: h */
    public volatile InterfaceC1589f.a<?> f62870h;

    /* renamed from: i */
    public File f62871i;

    public C14064c(C14068g<?> c14068g, InterfaceC14067f.a aVar) {
        this(c14068g.m84286c(), c14068g, aVar);
    }

    /* renamed from: b */
    private boolean m84279b() {
        return this.f62869g < this.f62868f.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (m84279b() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.f62868f;
        r3 = r7.f62869g;
        r7.f62869g = r3 + 1;
        r7.f62870h = r0.get(r3).mo9071b(r7.f62871i, r7.f62864b.m84303t(), r7.f62864b.m84289f(), r7.f62864b.m84294k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.f62870h == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.f62864b.m84304u(r7.f62870h.f7023c.mo9017a()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.f62870h.f7023c.mo9025e(r7.f62864b.m84295l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.f62870h = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2 != false) goto L40;
     */
    @Override // p829z1.InterfaceC14067f
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo84280a() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            p645t2.C12921b.m77575a(r0)
        L5:
            java.util.List<com.bumptech.glide.load.model.f<java.io.File, ?>> r0 = r7.f62868f     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.m84279b()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.f62870h = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.m84279b()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List<com.bumptech.glide.load.model.f<java.io.File, ?>> r0 = r7.f62868f     // Catch: java.lang.Throwable -> L68
            int r3 = r7.f62869g     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.f62869g = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.f r0 = (com.bumptech.glide.load.model.InterfaceC1589f) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.f62871i     // Catch: java.lang.Throwable -> L68
            z1.g<?> r4 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            int r4 = r4.m84303t()     // Catch: java.lang.Throwable -> L68
            z1.g<?> r5 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            int r5 = r5.m84289f()     // Catch: java.lang.Throwable -> L68
            z1.g<?> r6 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            x1.i r6 = r6.m84294k()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.f$a r0 = r0.mo9071b(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.f62870h = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.f$a<?> r0 = r7.f62870h     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            z1.g<?> r0 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.f$a<?> r3 = r7.f62870h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d<Data> r3 = r3.f7023c     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.mo9017a()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.m84304u(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.model.f$a<?> r0 = r7.f62870h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d<Data> r0 = r0.f7023c     // Catch: java.lang.Throwable -> L68
            z1.g<?> r2 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.g r2 = r2.m84295l()     // Catch: java.lang.Throwable -> L68
            r0.mo9025e(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = r1
            goto L15
        L68:
            r7 = move-exception
            goto Lb0
        L6a:
            p645t2.C12921b.m77579e()
            return r2
        L6e:
            int r0 = r7.f62866d     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.f62866d = r0     // Catch: java.lang.Throwable -> L68
            java.util.List<x1.f> r1 = r7.f62863a     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            p645t2.C12921b.m77579e()
            return r2
        L7f:
            java.util.List<x1.f> r0 = r7.f62863a     // Catch: java.lang.Throwable -> L68
            int r1 = r7.f62866d     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            x1.f r0 = (p759x1.InterfaceC13681f) r0     // Catch: java.lang.Throwable -> L68
            z1.d r1 = new z1.d     // Catch: java.lang.Throwable -> L68
            z1.g<?> r3 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            x1.f r3 = r3.m84299p()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            z1.g<?> r3 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.cache.a r3 = r3.m84287d()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.mo9065a(r1)     // Catch: java.lang.Throwable -> L68
            r7.f62871i = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.f62867e = r0     // Catch: java.lang.Throwable -> L68
            z1.g<?> r0 = r7.f62864b     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.m84293j(r1)     // Catch: java.lang.Throwable -> L68
            r7.f62868f = r0     // Catch: java.lang.Throwable -> L68
            r7.f62869g = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            p645t2.C12921b.m77579e()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p829z1.C14064c.mo84280a():boolean");
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
    /* renamed from: c */
    public void mo9030c(Exception exc) {
        this.f62865c.mo84282f(this.f62867e, exc, this.f62870h.f7023c, EnumC13676a.DATA_DISK_CACHE);
    }

    @Override // p829z1.InterfaceC14067f
    public void cancel() {
        InterfaceC1589f.a<?> aVar = this.f62870h;
        if (aVar != null) {
            aVar.f7023c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d.a
    /* renamed from: f */
    public void mo9031f(Object obj) {
        this.f62865c.mo84281e(this.f62867e, obj, this.f62870h.f7023c, EnumC13676a.DATA_DISK_CACHE, this.f62867e);
    }

    public C14064c(List<InterfaceC13681f> list, C14068g<?> c14068g, InterfaceC14067f.a aVar) {
        this.f62866d = -1;
        this.f62863a = list;
        this.f62864b = c14068g;
        this.f62865c = aVar;
    }
}
