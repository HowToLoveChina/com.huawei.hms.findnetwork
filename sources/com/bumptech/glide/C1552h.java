package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.C1565f;
import com.bumptech.glide.load.data.InterfaceC1564e;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p214d2.C8995i;
import p214d2.InterfaceC8994h;
import p243e0.InterfaceC9370e;
import p441l2.C11226e;
import p441l2.InterfaceC11225d;
import p482n2.C11604a;
import p482n2.C11605b;
import p482n2.C11606c;
import p482n2.C11607d;
import p482n2.C11608e;
import p482n2.C11609f;
import p645t2.C12920a;
import p759x1.InterfaceC13679d;
import p759x1.InterfaceC13686k;
import p759x1.InterfaceC13687l;
import p829z1.C14070i;
import p829z1.C14081t;
import p829z1.InterfaceC14083v;

/* renamed from: com.bumptech.glide.h */
/* loaded from: classes.dex */
public class C1552h {

    /* renamed from: a */
    public final C8995i f6876a;

    /* renamed from: b */
    public final C11604a f6877b;

    /* renamed from: c */
    public final C11608e f6878c;

    /* renamed from: d */
    public final C11609f f6879d;

    /* renamed from: e */
    public final C1565f f6880e;

    /* renamed from: f */
    public final C11226e f6881f;

    /* renamed from: g */
    public final C11605b f6882g;

    /* renamed from: h */
    public final C11607d f6883h = new C11607d();

    /* renamed from: i */
    public final C11606c f6884i = new C11606c();

    /* renamed from: j */
    public final InterfaceC9370e<List<Throwable>> f6885j;

    /* renamed from: com.bumptech.glide.h$a */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: com.bumptech.glide.h$b */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* renamed from: com.bumptech.glide.h$c */
    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> c(M m10, List<InterfaceC1589f<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m10);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* renamed from: com.bumptech.glide.h$d */
    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* renamed from: com.bumptech.glide.h$e */
    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public C1552h() {
        InterfaceC9370e<List<Throwable>> interfaceC9370eM77570e = C12920a.m77570e();
        this.f6885j = interfaceC9370eM77570e;
        this.f6876a = new C8995i(interfaceC9370eM77570e);
        this.f6877b = new C11604a();
        this.f6878c = new C11608e();
        this.f6879d = new C11609f();
        this.f6880e = new C1565f();
        this.f6881f = new C11226e();
        this.f6882g = new C11605b();
        m8948r(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    /* renamed from: a */
    public <Model, Data> C1552h m8931a(Class<Model> cls, Class<Data> cls2, InterfaceC8994h<Model, Data> interfaceC8994h) {
        this.f6876a.m56844a(cls, cls2, interfaceC8994h);
        return this;
    }

    /* renamed from: b */
    public <Data, TResource> C1552h m8932b(Class<Data> cls, Class<TResource> cls2, InterfaceC13686k<Data, TResource> interfaceC13686k) {
        m8935e("legacy_append", cls, cls2, interfaceC13686k);
        return this;
    }

    /* renamed from: c */
    public <Data> C1552h m8933c(Class<Data> cls, InterfaceC13679d<Data> interfaceC13679d) {
        this.f6877b.m69338a(cls, interfaceC13679d);
        return this;
    }

    /* renamed from: d */
    public <TResource> C1552h m8934d(Class<TResource> cls, InterfaceC13687l<TResource> interfaceC13687l) {
        this.f6879d.m69355a(cls, interfaceC13687l);
        return this;
    }

    /* renamed from: e */
    public <Data, TResource> C1552h m8935e(String str, Class<Data> cls, Class<TResource> cls2, InterfaceC13686k<Data, TResource> interfaceC13686k) {
        this.f6878c.m69349a(str, interfaceC13686k, cls, cls2);
        return this;
    }

    /* renamed from: f */
    public final <Data, TResource, Transcode> List<C14070i<Data, TResource, Transcode>> m8936f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f6878c.m69352d(cls, cls2)) {
            for (Class cls5 : this.f6881f.m67417b(cls4, cls3)) {
                arrayList.add(new C14070i(cls, cls4, cls5, this.f6878c.m69350b(cls, cls4), this.f6881f.m67416a(cls4, cls5), this.f6885j));
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    public List<ImageHeaderParser> m8937g() {
        List<ImageHeaderParser> listM69342b = this.f6882g.m69342b();
        if (listM69342b.isEmpty()) {
            throw new b();
        }
        return listM69342b;
    }

    /* renamed from: h */
    public <Data, TResource, Transcode> C14081t<Data, TResource, Transcode> m8938h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        C14081t<Data, TResource, Transcode> c14081tM69343a = this.f6884i.m69343a(cls, cls2, cls3);
        if (this.f6884i.m69345c(c14081tM69343a)) {
            return null;
        }
        if (c14081tM69343a == null) {
            List<C14070i<Data, TResource, Transcode>> listM8936f = m8936f(cls, cls2, cls3);
            c14081tM69343a = listM8936f.isEmpty() ? null : new C14081t<>(cls, cls2, cls3, listM8936f, this.f6885j);
            this.f6884i.m69346d(cls, cls2, cls3, c14081tM69343a);
        }
        return c14081tM69343a;
    }

    /* renamed from: i */
    public <Model> List<InterfaceC1589f<Model, ?>> m8939i(Model model) {
        return this.f6876a.m56846d(model);
    }

    /* renamed from: j */
    public <Model, TResource, Transcode> List<Class<?>> m8940j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listM69347a = this.f6883h.m69347a(cls, cls2, cls3);
        if (listM69347a == null) {
            listM69347a = new ArrayList<>();
            Iterator<Class<?>> it = this.f6876a.m56845c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f6878c.m69352d(it.next(), cls2)) {
                    if (!this.f6881f.m67417b(cls4, cls3).isEmpty() && !listM69347a.contains(cls4)) {
                        listM69347a.add(cls4);
                    }
                }
            }
            this.f6883h.m69348b(cls, cls2, cls3, Collections.unmodifiableList(listM69347a));
        }
        return listM69347a;
    }

    /* renamed from: k */
    public <X> InterfaceC13687l<X> m8941k(InterfaceC14083v<X> interfaceC14083v) throws d {
        InterfaceC13687l<X> interfaceC13687lM69356b = this.f6879d.m69356b(interfaceC14083v.mo60255c());
        if (interfaceC13687lM69356b != null) {
            return interfaceC13687lM69356b;
        }
        throw new d(interfaceC14083v.mo60255c());
    }

    /* renamed from: l */
    public <X> InterfaceC1564e<X> m8942l(X x10) {
        return this.f6880e.m9032a(x10);
    }

    /* renamed from: m */
    public <X> InterfaceC13679d<X> m8943m(X x10) throws e {
        InterfaceC13679d<X> interfaceC13679dM69339b = this.f6877b.m69339b(x10.getClass());
        if (interfaceC13679dM69339b != null) {
            return interfaceC13679dM69339b;
        }
        throw new e(x10.getClass());
    }

    /* renamed from: n */
    public boolean m8944n(InterfaceC14083v<?> interfaceC14083v) {
        return this.f6879d.m69356b(interfaceC14083v.mo60255c()) != null;
    }

    /* renamed from: o */
    public C1552h m8945o(ImageHeaderParser imageHeaderParser) {
        this.f6882g.m69341a(imageHeaderParser);
        return this;
    }

    /* renamed from: p */
    public C1552h m8946p(InterfaceC1564e.a<?> aVar) {
        this.f6880e.m9033b(aVar);
        return this;
    }

    /* renamed from: q */
    public <TResource, Transcode> C1552h m8947q(Class<TResource> cls, Class<Transcode> cls2, InterfaceC11225d<TResource, Transcode> interfaceC11225d) {
        this.f6881f.m67418c(cls, cls2, interfaceC11225d);
        return this;
    }

    /* renamed from: r */
    public final C1552h m8948r(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.f6878c.m69353e(arrayList);
        return this;
    }
}
