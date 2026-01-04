package p789xv;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p374iv.C10626e;
import p535ov.InterfaceC12035b;
import p535ov.InterfaceC12036c;
import p535ov.InterfaceC12037d;
import p535ov.InterfaceC12038e;
import p535ov.InterfaceC12039f;
import p535ov.InterfaceC12040g;
import p535ov.InterfaceC12041h;
import p535ov.InterfaceC12042i;
import p535ov.InterfaceC12043j;
import p535ov.InterfaceC12044k;
import p535ov.InterfaceC12045l;
import p535ov.InterfaceC12046m;
import p559pv.C12232b;
import p559pv.C12233c;
import p559pv.C12234d;
import p559pv.C12235e;
import p559pv.C12236f;
import p559pv.C12237g;
import p559pv.C12238h;
import p559pv.InterfaceC12231a;
import p592qv.C12417a;
import p592qv.C12418b;
import p592qv.C12419c;
import p592qv.C12420d;
import p624rv.C12630a;
import p624rv.C12631b;
import p624rv.C12632c;
import p691uv.C13256a;
import p691uv.C13257b;
import p719vv.C13494a;
import p719vv.C13495b;
import p719vv.C13496c;
import p753wv.C13642a;
import p753wv.C13643b;
import p753wv.C13644c;
import p753wv.C13645d;
import p753wv.C13646e;
import p753wv.C13647f;
import p753wv.C13648g;
import p753wv.C13649h;
import p753wv.C13650i;
import sv.C12861a;
import sv.C12862b;
import sv.C12863c;
import sv.C12864d;
import sv.C12865e;
import sv.C12866f;
import sv.C12867g;
import sv.C12868h;
import sv.C12869i;
import tv.C13073a;
import tv.C13074b;

/* renamed from: xv.a */
/* loaded from: classes9.dex */
public class C13867a {

    /* renamed from: a */
    public static final Map<Class<? extends Annotation>, InterfaceC13870d<?>> f62149a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f62149a = concurrentHashMap;
        concurrentHashMap.put(InterfaceC12042i.class, new C13871e(C12235e.class));
        concurrentHashMap.put(InterfaceC12041h.class, new C13871e(C12630a.class, C12631b.class, C12632c.class, C12861a.class, C12862b.class, C12863c.class, C12864d.class, C12865e.class, C12866f.class, C12867g.class, C12869i.class, C12868h.class));
        concurrentHashMap.put(InterfaceC12035b.class, new C13871e(C12420d.class, C12417a.class, C12418b.class, C12419c.class));
        concurrentHashMap.put(InterfaceC12043j.class, new C13871e(C13494a.class, C13495b.class, C13496c.class, C13642a.class, C13643b.class, C13644c.class, C13645d.class, C13646e.class, C13647f.class, C13648g.class, C13650i.class, C13649h.class));
        concurrentHashMap.put(InterfaceC12040g.class, new C13871e(C12234d.class));
        concurrentHashMap.put(InterfaceC12039f.class, new C13871e(C13256a.class, C13257b.class));
        concurrentHashMap.put(InterfaceC12038e.class, new C13871e(C13073a.class, C13074b.class));
        concurrentHashMap.put(InterfaceC12036c.class, new C13871e(C12232b.class));
        concurrentHashMap.put(InterfaceC12037d.class, new C13871e(C12233c.class));
        concurrentHashMap.put(InterfaceC12045l.class, new C13871e(C12237g.class));
        concurrentHashMap.put(InterfaceC12044k.class, new C13871e(C12236f.class));
        concurrentHashMap.put(InterfaceC12046m.class, new C13871e(C12238h.class));
    }

    /* renamed from: a */
    public static <A extends Annotation> Class<? extends InterfaceC12231a<A, ?>> m83203a(Class<A> cls, Class<?> cls2) throws C10626e {
        Class<? extends InterfaceC12231a<A, ?>> clsMo83206a = f62149a.get(cls).mo83206a(cls2);
        if (clsMo83206a != null) {
            return clsMo83206a;
        }
        throw new C10626e("unsupported target class:" + cls2.getSimpleName() + " for constraint:" + cls.getSimpleName());
    }
}
