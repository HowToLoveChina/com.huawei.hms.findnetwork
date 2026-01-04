package nu;

import com.huawei.skytone.servicehub.core.ServiceHubRegistry;
import com.huawei.skytone.servicehub.model.schema.C8689a;
import com.huawei.skytone.servicehub.model.schema.C8690b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import p534ou.C12033a;

/* renamed from: nu.g */
/* loaded from: classes5.dex */
public final class C11754g {

    /* renamed from: a */
    public static Map<Class<?>, List<C8690b>> f54318a = new ConcurrentHashMap();

    /* renamed from: b */
    public static Map<Class<?>, Object> f54319b = new ConcurrentHashMap();

    /* renamed from: c */
    public static final Function<C8690b, Object> f54320c = new Function() { // from class: nu.a
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return C11754g.m70073h((C8690b) obj);
        }
    };

    static {
        try {
            Object objNewInstance = ServiceHubRegistry.class.newInstance();
            ServiceHubRegistry.class.getDeclaredMethod("register", null).invoke(objNewInstance, null);
            ((C11755h) Optional.ofNullable((C11755h) ServiceHubRegistry.class.getField("infoList").get(objNewInstance)).orElseThrow(new Supplier() { // from class: nu.b
                @Override // java.util.function.Supplier
                public final Object get() {
                    return C11754g.m70074i();
                }
            })).forEach(new Consumer() { // from class: nu.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C11754g.m70075j((Class) obj);
                }
            });
        } catch (Throwable th2) {
            throw new C12033a(th2.getMessage());
        }
    }

    /* renamed from: f */
    public static /* synthetic */ void m70071f(Class cls, List list, Class cls2, Object obj) {
        if (cls.isAssignableFrom(cls2)) {
            list.add(obj);
        }
    }

    /* renamed from: g */
    public static /* synthetic */ void m70072g(Class cls, List list, C8690b c8690b) {
        if (!cls.equals(c8690b.getGroup()) || f54319b.containsKey(c8690b.getImpl())) {
            return;
        }
        Object objApply = f54320c.apply(c8690b);
        list.add(objApply);
        if (c8690b.isSingleton()) {
            f54319b.put(c8690b.getImpl(), objApply);
        }
    }

    /* renamed from: h */
    public static /* synthetic */ Object m70073h(C8690b c8690b) {
        try {
            return c8690b.getCreator().equals(C8689a.class) ? c8690b.getImpl().newInstance() : c8690b.getCreator().newInstance().get();
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new C12033a(e10.getMessage());
        }
    }

    /* renamed from: i */
    public static /* synthetic */ Throwable m70074i() {
        return new C12033a("Get field infoList from ServiceHubRegistry is null!");
    }

    /* renamed from: j */
    public static /* synthetic */ void m70075j(Class cls) {
        if (C8690b.class.isAssignableFrom(cls)) {
            try {
                C8690b c8690b = (C8690b) cls.newInstance();
                if (!c8690b.getGroup().isAssignableFrom(c8690b.getImpl())) {
                    throw new C12033a(String.format(Locale.ENGLISH, "Impl class %s is not a Group class %s!", c8690b.getImpl().getCanonicalName(), c8690b.getGroup().getCanonicalName()));
                }
                List<C8690b> list = f54318a.get(c8690b.getGroup());
                if (list != null) {
                    list.add(c8690b);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(c8690b);
                f54318a.put(c8690b.getGroup(), arrayList);
            } catch (IllegalAccessException | InstantiationException e10) {
                throw new C12033a(e10.getMessage());
            }
        }
    }

    /* renamed from: k */
    public static <T> Stream<T> m70076k(final Class<T> cls) {
        synchronized (cls) {
            try {
                final ArrayList arrayList = new ArrayList();
                if (!f54318a.containsKey(cls)) {
                    return arrayList.stream();
                }
                f54319b.forEach(new BiConsumer() { // from class: nu.d
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        C11754g.m70071f(cls, arrayList, (Class) obj, obj2);
                    }
                });
                f54318a.get(cls).forEach(new Consumer() { // from class: nu.e
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C11754g.m70072g(cls, arrayList, (C8690b) obj);
                    }
                });
                return arrayList.stream().filter(new Predicate() { // from class: nu.f
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return Objects.nonNull(obj);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public static <T> Optional<T> m70077l(Class<T> cls) {
        return m70076k(cls).findFirst();
    }
}
