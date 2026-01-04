package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import java.util.Map;
import p003a2.InterfaceC0007b;
import p507o2.InterfaceC11792e;
import p542p2.AbstractC12083j;
import p542p2.C12079f;
import p630s2.C12671f;
import p829z1.C14072k;

/* renamed from: com.bumptech.glide.d */
/* loaded from: classes.dex */
public class C1548d extends ContextWrapper {

    /* renamed from: k */
    public static final AbstractC1556l<?, ?> f6853k = new C1545a();

    /* renamed from: a */
    public final InterfaceC0007b f6854a;

    /* renamed from: b */
    public final C12671f.b<C1552h> f6855b;

    /* renamed from: c */
    public final C12079f f6856c;

    /* renamed from: d */
    public final ComponentCallbacks2C1546b.a f6857d;

    /* renamed from: e */
    public final List<InterfaceC11792e<Object>> f6858e;

    /* renamed from: f */
    public final Map<Class<?>, AbstractC1556l<?, ?>> f6859f;

    /* renamed from: g */
    public final C14072k f6860g;

    /* renamed from: h */
    public final C1549e f6861h;

    /* renamed from: i */
    public final int f6862i;

    /* renamed from: j */
    public RequestOptions f6863j;

    public C1548d(Context context, InterfaceC0007b interfaceC0007b, C12671f.b<C1552h> bVar, C12079f c12079f, ComponentCallbacks2C1546b.a aVar, Map<Class<?>, AbstractC1556l<?, ?>> map, List<InterfaceC11792e<Object>> list, C14072k c14072k, C1549e c1549e, int i10) {
        super(context.getApplicationContext());
        this.f6854a = interfaceC0007b;
        this.f6856c = c12079f;
        this.f6857d = aVar;
        this.f6858e = list;
        this.f6859f = map;
        this.f6860g = c14072k;
        this.f6861h = c1549e;
        this.f6862i = i10;
        this.f6855b = C12671f.m76261a(bVar);
    }

    /* renamed from: a */
    public <X> AbstractC12083j<ImageView, X> m8919a(ImageView imageView, Class<X> cls) {
        return this.f6856c.m72236a(imageView, cls);
    }

    /* renamed from: b */
    public InterfaceC0007b m8920b() {
        return this.f6854a;
    }

    /* renamed from: c */
    public List<InterfaceC11792e<Object>> m8921c() {
        return this.f6858e;
    }

    /* renamed from: d */
    public synchronized RequestOptions m8922d() {
        try {
            if (this.f6863j == null) {
                this.f6863j = this.f6857d.build().lock();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f6863j;
    }

    /* renamed from: e */
    public <T> AbstractC1556l<?, T> m8923e(Class<T> cls) {
        AbstractC1556l<?, T> abstractC1556l = (AbstractC1556l) this.f6859f.get(cls);
        if (abstractC1556l == null) {
            for (Map.Entry<Class<?>, AbstractC1556l<?, ?>> entry : this.f6859f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    abstractC1556l = (AbstractC1556l) entry.getValue();
                }
            }
        }
        return abstractC1556l == null ? (AbstractC1556l<?, T>) f6853k : abstractC1556l;
    }

    /* renamed from: f */
    public C14072k m8924f() {
        return this.f6860g;
    }

    /* renamed from: g */
    public C1549e m8925g() {
        return this.f6861h;
    }

    /* renamed from: h */
    public int m8926h() {
        return this.f6862i;
    }

    /* renamed from: i */
    public C1552h m8927i() {
        return this.f6855b.get();
    }
}
