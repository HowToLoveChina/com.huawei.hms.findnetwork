package p507o2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.C1547c;
import com.bumptech.glide.C1548d;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import p355i2.C10416b;
import p542p2.InterfaceC12081h;
import p542p2.InterfaceC12082i;
import p564q2.InterfaceC12276c;
import p630s2.C12672g;
import p630s2.C12677l;
import p645t2.AbstractC12922c;
import p645t2.C12921b;
import p759x1.EnumC13676a;
import p829z1.C14072k;
import p829z1.C14078q;
import p829z1.InterfaceC14083v;

/* renamed from: o2.g */
/* loaded from: classes.dex */
public final class C11794g<R> implements InterfaceC11790c, InterfaceC12081h, InterfaceC11793f {

    /* renamed from: E */
    public static final boolean f54623E = Log.isLoggable("GlideRequest", 2);

    /* renamed from: A */
    public int f54624A;

    /* renamed from: B */
    public int f54625B;

    /* renamed from: C */
    public boolean f54626C;

    /* renamed from: D */
    public RuntimeException f54627D;

    /* renamed from: a */
    public int f54628a;

    /* renamed from: b */
    public final String f54629b;

    /* renamed from: c */
    public final AbstractC12922c f54630c;

    /* renamed from: d */
    public final Object f54631d;

    /* renamed from: e */
    public final InterfaceC11792e<R> f54632e;

    /* renamed from: f */
    public final InterfaceC11791d f54633f;

    /* renamed from: g */
    public final Context f54634g;

    /* renamed from: h */
    public final C1548d f54635h;

    /* renamed from: i */
    public final Object f54636i;

    /* renamed from: j */
    public final Class<R> f54637j;

    /* renamed from: k */
    public final BaseRequestOptions<?> f54638k;

    /* renamed from: l */
    public final int f54639l;

    /* renamed from: m */
    public final int f54640m;

    /* renamed from: n */
    public final EnumC1551g f54641n;

    /* renamed from: o */
    public final InterfaceC12082i<R> f54642o;

    /* renamed from: p */
    public final List<InterfaceC11792e<R>> f54643p;

    /* renamed from: q */
    public final InterfaceC12276c<? super R> f54644q;

    /* renamed from: r */
    public final Executor f54645r;

    /* renamed from: s */
    public InterfaceC14083v<R> f54646s;

    /* renamed from: t */
    public C14072k.d f54647t;

    /* renamed from: u */
    public long f54648u;

    /* renamed from: v */
    public volatile C14072k f54649v;

    /* renamed from: w */
    public a f54650w;

    /* renamed from: x */
    public Drawable f54651x;

    /* renamed from: y */
    public Drawable f54652y;

    /* renamed from: z */
    public Drawable f54653z;

    /* renamed from: o2.g$a */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public C11794g(Context context, C1548d c1548d, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i10, int i11, EnumC1551g enumC1551g, InterfaceC12082i<R> interfaceC12082i, InterfaceC11792e<R> interfaceC11792e, List<InterfaceC11792e<R>> list, InterfaceC11791d interfaceC11791d, C14072k c14072k, InterfaceC12276c<? super R> interfaceC12276c, Executor executor) {
        this.f54629b = f54623E ? String.valueOf(super.hashCode()) : null;
        this.f54630c = AbstractC12922c.m77581a();
        this.f54631d = obj;
        this.f54634g = context;
        this.f54635h = c1548d;
        this.f54636i = obj2;
        this.f54637j = cls;
        this.f54638k = baseRequestOptions;
        this.f54639l = i10;
        this.f54640m = i11;
        this.f54641n = enumC1551g;
        this.f54642o = interfaceC12082i;
        this.f54632e = interfaceC11792e;
        this.f54643p = list;
        this.f54633f = interfaceC11791d;
        this.f54649v = c14072k;
        this.f54644q = interfaceC12276c;
        this.f54645r = executor;
        this.f54650w = a.PENDING;
        if (this.f54627D == null && c1548d.m8925g().m8928a(C1547c.c.class)) {
            this.f54627D = new RuntimeException("Glide request origin trace");
        }
    }

    /* renamed from: v */
    public static int m70285v(int i10, float f10) {
        return i10 == Integer.MIN_VALUE ? i10 : Math.round(f10 * i10);
    }

    /* renamed from: y */
    public static <R> C11794g<R> m70286y(Context context, C1548d c1548d, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i10, int i11, EnumC1551g enumC1551g, InterfaceC12082i<R> interfaceC12082i, InterfaceC11792e<R> interfaceC11792e, List<InterfaceC11792e<R>> list, InterfaceC11791d interfaceC11791d, C14072k c14072k, InterfaceC12276c<? super R> interfaceC12276c, Executor executor) {
        return new C11794g<>(context, c1548d, obj, obj2, cls, baseRequestOptions, i10, i11, enumC1551g, interfaceC12082i, interfaceC11792e, list, interfaceC11791d, c14072k, interfaceC12276c, executor);
    }

    /* renamed from: A */
    public final void m70287A(InterfaceC14083v<R> interfaceC14083v, R r10, EnumC13676a enumC13676a, boolean z10) {
        boolean zMo51695b;
        boolean zM70299s = m70299s();
        this.f54650w = a.COMPLETE;
        this.f54646s = interfaceC14083v;
        if (this.f54635h.m8926h() <= 3) {
            Log.d("Glide", "Finished loading " + r10.getClass().getSimpleName() + " from " + enumC13676a + " for " + this.f54636i + " with size [" + this.f54624A + Constants.MULTIPLE_SIGN + this.f54625B + "] in " + C12672g.m76262a(this.f54648u) + " ms");
        }
        m70303x();
        boolean z11 = true;
        this.f54626C = true;
        try {
            List<InterfaceC11792e<R>> list = this.f54643p;
            if (list != null) {
                Iterator<InterfaceC11792e<R>> it = list.iterator();
                zMo51695b = false;
                while (it.hasNext()) {
                    zMo51695b |= it.next().mo51695b(r10, this.f54636i, this.f54642o, enumC13676a, zM70299s);
                }
            } else {
                zMo51695b = false;
            }
            InterfaceC11792e<R> interfaceC11792e = this.f54632e;
            if (interfaceC11792e == null || !interfaceC11792e.mo51695b(r10, this.f54636i, this.f54642o, enumC13676a, zM70299s)) {
                z11 = false;
            }
            if (!(z11 | zMo51695b)) {
                this.f54642o.mo53348c(r10, this.f54644q.mo73800a(enumC13676a, zM70299s));
            }
            this.f54626C = false;
            C12921b.m77580f("GlideRequest", this.f54628a);
        } catch (Throwable th2) {
            this.f54626C = false;
            throw th2;
        }
    }

    /* renamed from: B */
    public final void m70288B() {
        if (m70292l()) {
            Drawable drawableM70297q = this.f54636i == null ? m70297q() : null;
            if (drawableM70297q == null) {
                drawableM70297q = m70296p();
            }
            if (drawableM70297q == null) {
                drawableM70297q = m70298r();
            }
            this.f54642o.mo72226f(drawableM70297q);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507o2.InterfaceC11793f
    /* renamed from: a */
    public void mo70282a(InterfaceC14083v<?> interfaceC14083v, EnumC13676a enumC13676a, boolean z10) {
        this.f54630c.mo77583c();
        InterfaceC14083v<?> interfaceC14083v2 = null;
        try {
            synchronized (this.f54631d) {
                try {
                    this.f54647t = null;
                    if (interfaceC14083v == null) {
                        mo70283c(new C14078q("Expected to receive a Resource<R> with an object of " + this.f54637j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = interfaceC14083v.get();
                    try {
                        if (obj != null && this.f54637j.isAssignableFrom(obj.getClass())) {
                            if (m70293m()) {
                                m70287A(interfaceC14083v, obj, enumC13676a, z10);
                                return;
                            }
                            this.f54646s = null;
                            this.f54650w = a.COMPLETE;
                            C12921b.m77580f("GlideRequest", this.f54628a);
                            this.f54649v.m84365k(interfaceC14083v);
                            return;
                        }
                        this.f54646s = null;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected to receive an object of ");
                        sb2.append(this.f54637j);
                        sb2.append(" but instead got ");
                        sb2.append(obj != null ? obj.getClass() : "");
                        sb2.append("{");
                        sb2.append(obj);
                        sb2.append("} inside Resource{");
                        sb2.append(interfaceC14083v);
                        sb2.append("}.");
                        sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        mo70283c(new C14078q(sb2.toString()));
                        this.f54649v.m84365k(interfaceC14083v);
                    } catch (Throwable th2) {
                        interfaceC14083v2 = interfaceC14083v;
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            if (interfaceC14083v2 != null) {
                this.f54649v.m84365k(interfaceC14083v2);
            }
            throw th4;
        }
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: b */
    public boolean mo70265b() {
        boolean z10;
        synchronized (this.f54631d) {
            z10 = this.f54650w == a.COMPLETE;
        }
        return z10;
    }

    @Override // p507o2.InterfaceC11793f
    /* renamed from: c */
    public void mo70283c(C14078q c14078q) {
        m70304z(c14078q, 5);
    }

    @Override // p507o2.InterfaceC11790c
    public void clear() {
        synchronized (this.f54631d) {
            try {
                m70290g();
                this.f54630c.mo77583c();
                a aVar = this.f54650w;
                a aVar2 = a.CLEARED;
                if (aVar == aVar2) {
                    return;
                }
                m70294n();
                InterfaceC14083v<R> interfaceC14083v = this.f54646s;
                if (interfaceC14083v != null) {
                    this.f54646s = null;
                } else {
                    interfaceC14083v = null;
                }
                if (m70291j()) {
                    this.f54642o.mo66338h(m70298r());
                }
                C12921b.m77580f("GlideRequest", this.f54628a);
                this.f54650w = aVar2;
                if (interfaceC14083v != null) {
                    this.f54649v.m84365k(interfaceC14083v);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p542p2.InterfaceC12081h
    /* renamed from: d */
    public void mo70289d(int i10, int i11) throws Throwable {
        this.f54630c.mo77583c();
        synchronized (this.f54631d) {
            try {
                try {
                    boolean z10 = f54623E;
                    if (z10) {
                        m70301u("Got onSizeReady in " + C12672g.m76262a(this.f54648u));
                    }
                    if (this.f54650w != a.WAITING_FOR_SIZE) {
                        return;
                    }
                    a aVar = a.RUNNING;
                    this.f54650w = aVar;
                    float sizeMultiplier = this.f54638k.getSizeMultiplier();
                    this.f54624A = m70285v(i10, sizeMultiplier);
                    this.f54625B = m70285v(i11, sizeMultiplier);
                    if (z10) {
                        m70301u("finished setup for calling load in " + C12672g.m76262a(this.f54648u));
                    }
                    this.f54647t = this.f54649v.m84361f(this.f54635h, this.f54636i, this.f54638k.getSignature(), this.f54624A, this.f54625B, this.f54638k.getResourceClass(), this.f54637j, this.f54641n, this.f54638k.getDiskCacheStrategy(), this.f54638k.getTransformations(), this.f54638k.isTransformationRequired(), this.f54638k.isScaleOnlyOrNoTransform(), this.f54638k.getOptions(), this.f54638k.isMemoryCacheable(), this.f54638k.getUseUnlimitedSourceGeneratorsPool(), this.f54638k.getUseAnimationPool(), this.f54638k.getOnlyRetrieveFromCache(), this, this.f54645r);
                    if (this.f54650w != aVar) {
                        this.f54647t = null;
                    }
                    if (z10) {
                        m70301u("finished onSizeReady in " + C12672g.m76262a(this.f54648u));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    @Override // p507o2.InterfaceC11793f
    /* renamed from: e */
    public Object mo70284e() {
        this.f54630c.mo77583c();
        return this.f54631d;
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: f */
    public boolean mo70269f() {
        boolean z10;
        synchronized (this.f54631d) {
            z10 = this.f54650w == a.CLEARED;
        }
        return z10;
    }

    /* renamed from: g */
    public final void m70290g() {
        if (this.f54626C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: h */
    public boolean mo70271h(InterfaceC11790c interfaceC11790c) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        EnumC1551g enumC1551g;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        EnumC1551g enumC1551g2;
        int size2;
        if (!(interfaceC11790c instanceof C11794g)) {
            return false;
        }
        synchronized (this.f54631d) {
            try {
                i10 = this.f54639l;
                i11 = this.f54640m;
                obj = this.f54636i;
                cls = this.f54637j;
                baseRequestOptions = this.f54638k;
                enumC1551g = this.f54641n;
                List<InterfaceC11792e<R>> list = this.f54643p;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        C11794g c11794g = (C11794g) interfaceC11790c;
        synchronized (c11794g.f54631d) {
            try {
                i12 = c11794g.f54639l;
                i13 = c11794g.f54640m;
                obj2 = c11794g.f54636i;
                cls2 = c11794g.f54637j;
                baseRequestOptions2 = c11794g.f54638k;
                enumC1551g2 = c11794g.f54641n;
                List<InterfaceC11792e<R>> list2 = c11794g.f54643p;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        return i10 == i12 && i11 == i13 && C12677l.m76279b(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && enumC1551g == enumC1551g2 && size == size2;
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: i */
    public void mo70272i() {
        synchronized (this.f54631d) {
            try {
                m70290g();
                this.f54630c.mo77583c();
                this.f54648u = C12672g.m76263b();
                Object obj = this.f54636i;
                if (obj == null) {
                    if (C12677l.m76296s(this.f54639l, this.f54640m)) {
                        this.f54624A = this.f54639l;
                        this.f54625B = this.f54640m;
                    }
                    m70304z(new C14078q("Received null model"), m70297q() == null ? 5 : 3);
                    return;
                }
                a aVar = this.f54650w;
                a aVar2 = a.RUNNING;
                if (aVar == aVar2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (aVar == a.COMPLETE) {
                    mo70282a(this.f54646s, EnumC13676a.MEMORY_CACHE, false);
                    return;
                }
                m70295o(obj);
                this.f54628a = C12921b.m77576b("GlideRequest");
                a aVar3 = a.WAITING_FOR_SIZE;
                this.f54650w = aVar3;
                if (C12677l.m76296s(this.f54639l, this.f54640m)) {
                    mo70289d(this.f54639l, this.f54640m);
                } else {
                    this.f54642o.mo72230b(this);
                }
                a aVar4 = this.f54650w;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && m70292l()) {
                    this.f54642o.mo72227g(m70298r());
                }
                if (f54623E) {
                    m70301u("finished run method in " + C12672g.m76262a(this.f54648u));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p507o2.InterfaceC11790c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f54631d) {
            try {
                a aVar = this.f54650w;
                z10 = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
            } finally {
            }
        }
        return z10;
    }

    /* renamed from: j */
    public final boolean m70291j() {
        InterfaceC11791d interfaceC11791d = this.f54633f;
        return interfaceC11791d == null || interfaceC11791d.mo70266c(this);
    }

    @Override // p507o2.InterfaceC11790c
    /* renamed from: k */
    public boolean mo70274k() {
        boolean z10;
        synchronized (this.f54631d) {
            z10 = this.f54650w == a.COMPLETE;
        }
        return z10;
    }

    /* renamed from: l */
    public final boolean m70292l() {
        InterfaceC11791d interfaceC11791d = this.f54633f;
        return interfaceC11791d == null || interfaceC11791d.mo70270g(this);
    }

    /* renamed from: m */
    public final boolean m70293m() {
        InterfaceC11791d interfaceC11791d = this.f54633f;
        return interfaceC11791d == null || interfaceC11791d.mo70268e(this);
    }

    /* renamed from: n */
    public final void m70294n() {
        m70290g();
        this.f54630c.mo77583c();
        this.f54642o.mo72231d(this);
        C14072k.d dVar = this.f54647t;
        if (dVar != null) {
            dVar.m84371a();
            this.f54647t = null;
        }
    }

    /* renamed from: o */
    public final void m70295o(Object obj) {
        List<InterfaceC11792e<R>> list = this.f54643p;
        if (list == null) {
            return;
        }
        for (InterfaceC11792e<R> interfaceC11792e : list) {
            if (interfaceC11792e instanceof AbstractC11789b) {
                ((AbstractC11789b) interfaceC11792e).m70280c(obj);
            }
        }
    }

    /* renamed from: p */
    public final Drawable m70296p() {
        if (this.f54651x == null) {
            Drawable errorPlaceholder = this.f54638k.getErrorPlaceholder();
            this.f54651x = errorPlaceholder;
            if (errorPlaceholder == null && this.f54638k.getErrorId() > 0) {
                this.f54651x = m70300t(this.f54638k.getErrorId());
            }
        }
        return this.f54651x;
    }

    @Override // p507o2.InterfaceC11790c
    public void pause() {
        synchronized (this.f54631d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: q */
    public final Drawable m70297q() {
        if (this.f54653z == null) {
            Drawable fallbackDrawable = this.f54638k.getFallbackDrawable();
            this.f54653z = fallbackDrawable;
            if (fallbackDrawable == null && this.f54638k.getFallbackId() > 0) {
                this.f54653z = m70300t(this.f54638k.getFallbackId());
            }
        }
        return this.f54653z;
    }

    /* renamed from: r */
    public final Drawable m70298r() {
        if (this.f54652y == null) {
            Drawable placeholderDrawable = this.f54638k.getPlaceholderDrawable();
            this.f54652y = placeholderDrawable;
            if (placeholderDrawable == null && this.f54638k.getPlaceholderId() > 0) {
                this.f54652y = m70300t(this.f54638k.getPlaceholderId());
            }
        }
        return this.f54652y;
    }

    /* renamed from: s */
    public final boolean m70299s() {
        InterfaceC11791d interfaceC11791d = this.f54633f;
        return interfaceC11791d == null || !interfaceC11791d.mo70267d().mo70265b();
    }

    /* renamed from: t */
    public final Drawable m70300t(int i10) {
        return C10416b.m63957a(this.f54635h, i10, this.f54638k.getTheme() != null ? this.f54638k.getTheme() : this.f54634g.getTheme());
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.f54631d) {
            obj = this.f54636i;
            cls = this.f54637j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    /* renamed from: u */
    public final void m70301u(String str) {
        Log.v("GlideRequest", str + " this: " + this.f54629b);
    }

    /* renamed from: w */
    public final void m70302w() {
        InterfaceC11791d interfaceC11791d = this.f54633f;
        if (interfaceC11791d != null) {
            interfaceC11791d.mo70273j(this);
        }
    }

    /* renamed from: x */
    public final void m70303x() {
        InterfaceC11791d interfaceC11791d = this.f54633f;
        if (interfaceC11791d != null) {
            interfaceC11791d.mo70264a(this);
        }
    }

    /* renamed from: z */
    public final void m70304z(C14078q c14078q, int i10) {
        boolean zMo51694a;
        this.f54630c.mo77583c();
        synchronized (this.f54631d) {
            try {
                c14078q.m84408m(this.f54627D);
                int iM8926h = this.f54635h.m8926h();
                if (iM8926h <= i10) {
                    Log.w("Glide", "Load failed for [" + this.f54636i + "] with dimensions [" + this.f54624A + Constants.MULTIPLE_SIGN + this.f54625B + "]", c14078q);
                    if (iM8926h <= 4) {
                        c14078q.m84404h("Glide");
                    }
                }
                this.f54647t = null;
                this.f54650w = a.FAILED;
                m70302w();
                boolean z10 = true;
                this.f54626C = true;
                try {
                    List<InterfaceC11792e<R>> list = this.f54643p;
                    if (list != null) {
                        Iterator<InterfaceC11792e<R>> it = list.iterator();
                        zMo51694a = false;
                        while (it.hasNext()) {
                            zMo51694a |= it.next().mo51694a(c14078q, this.f54636i, this.f54642o, m70299s());
                        }
                    } else {
                        zMo51694a = false;
                    }
                    InterfaceC11792e<R> interfaceC11792e = this.f54632e;
                    if (interfaceC11792e == null || !interfaceC11792e.mo51694a(c14078q, this.f54636i, this.f54642o, m70299s())) {
                        z10 = false;
                    }
                    if (!(zMo51694a | z10)) {
                        m70288B();
                    }
                    this.f54626C = false;
                    C12921b.m77580f("GlideRequest", this.f54628a);
                } catch (Throwable th2) {
                    this.f54626C = false;
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
