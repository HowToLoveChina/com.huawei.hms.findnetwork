package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.C1549e;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.manager.C1608f;
import com.bumptech.glide.manager.C1618p;
import com.bumptech.glide.manager.InterfaceC1606d;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p003a2.C0010e;
import p003a2.C0014i;
import p003a2.C0015j;
import p003a2.InterfaceC0007b;
import p003a2.InterfaceC0009d;
import p026b2.C1100b;
import p026b2.InterfaceC1101c;
import p044c2.ExecutorServiceC1380a;
import p438l.C11207a;
import p467m2.AbstractC11392a;
import p467m2.InterfaceC11393b;
import p507o2.InterfaceC11792e;
import p829z1.C14072k;

/* renamed from: com.bumptech.glide.c */
/* loaded from: classes.dex */
public final class C1547c {

    /* renamed from: c */
    public C14072k f6837c;

    /* renamed from: d */
    public InterfaceC0009d f6838d;

    /* renamed from: e */
    public InterfaceC0007b f6839e;

    /* renamed from: f */
    public InterfaceC1101c f6840f;

    /* renamed from: g */
    public ExecutorServiceC1380a f6841g;

    /* renamed from: h */
    public ExecutorServiceC1380a f6842h;

    /* renamed from: i */
    public InterfaceC1579a.a f6843i;

    /* renamed from: j */
    public MemorySizeCalculator f6844j;

    /* renamed from: k */
    public InterfaceC1606d f6845k;

    /* renamed from: n */
    public C1618p.b f6848n;

    /* renamed from: o */
    public ExecutorServiceC1380a f6849o;

    /* renamed from: p */
    public boolean f6850p;

    /* renamed from: q */
    public List<InterfaceC11792e<Object>> f6851q;

    /* renamed from: a */
    public final Map<Class<?>, AbstractC1556l<?, ?>> f6835a = new C11207a();

    /* renamed from: b */
    public final C1549e.a f6836b = new C1549e.a();

    /* renamed from: l */
    public int f6846l = 4;

    /* renamed from: m */
    public ComponentCallbacks2C1546b.a f6847m = new a();

    /* renamed from: com.bumptech.glide.c$a */
    public class a implements ComponentCallbacks2C1546b.a {
        public a() {
        }

        @Override // com.bumptech.glide.ComponentCallbacks2C1546b.a
        public RequestOptions build() {
            return new RequestOptions();
        }
    }

    /* renamed from: com.bumptech.glide.c$b */
    public static final class b {
    }

    /* renamed from: com.bumptech.glide.c$c */
    public static final class c {
    }

    /* renamed from: com.bumptech.glide.c$d */
    public static final class d {
    }

    /* renamed from: com.bumptech.glide.c$e */
    public static final class e {
    }

    /* renamed from: a */
    public ComponentCallbacks2C1546b m8917a(Context context, List<InterfaceC11393b> list, AbstractC11392a abstractC11392a) {
        if (this.f6841g == null) {
            this.f6841g = ExecutorServiceC1380a.m7922g();
        }
        if (this.f6842h == null) {
            this.f6842h = ExecutorServiceC1380a.m7920e();
        }
        if (this.f6849o == null) {
            this.f6849o = ExecutorServiceC1380a.m7918c();
        }
        if (this.f6844j == null) {
            this.f6844j = new MemorySizeCalculator.Builder(context).m9062a();
        }
        if (this.f6845k == null) {
            this.f6845k = new C1608f();
        }
        if (this.f6838d == null) {
            int iM9059b = this.f6844j.m9059b();
            if (iM9059b > 0) {
                this.f6838d = new C0015j(iM9059b);
            } else {
                this.f6838d = new C0010e();
            }
        }
        if (this.f6839e == null) {
            this.f6839e = new C0014i(this.f6844j.m9058a());
        }
        if (this.f6840f == null) {
            this.f6840f = new C1100b(this.f6844j.m9060d());
        }
        if (this.f6843i == null) {
            this.f6843i = new InternalCacheDiskCacheFactory(context);
        }
        if (this.f6837c == null) {
            this.f6837c = new C14072k(this.f6840f, this.f6843i, this.f6842h, this.f6841g, ExecutorServiceC1380a.m7923h(), this.f6849o, this.f6850p);
        }
        List<InterfaceC11792e<Object>> list2 = this.f6851q;
        if (list2 == null) {
            this.f6851q = Collections.emptyList();
        } else {
            this.f6851q = Collections.unmodifiableList(list2);
        }
        C1549e c1549eM8930b = this.f6836b.m8930b();
        return new ComponentCallbacks2C1546b(context, this.f6837c, this.f6840f, this.f6838d, this.f6839e, new C1618p(this.f6848n, c1549eM8930b), this.f6845k, this.f6846l, this.f6847m, this.f6835a, this.f6851q, list, abstractC11392a, c1549eM8930b);
    }

    /* renamed from: b */
    public void m8918b(C1618p.b bVar) {
        this.f6848n = bVar;
    }
}
