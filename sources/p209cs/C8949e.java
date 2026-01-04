package p209cs;

import as.C1016d;
import com.huawei.location.lite.common.plug.ProductId;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/* renamed from: cs.e */
/* loaded from: classes8.dex */
public class C8949e<S> {

    /* renamed from: a */
    public final Class<S> f45450a;

    /* renamed from: b */
    public LinkedHashMap<String, S> f45451b = new LinkedHashMap<>();

    /* renamed from: c */
    public LinkedHashMap<Integer, List<String>> f45452c = new LinkedHashMap<>();

    public C8949e(Class<S> cls) {
        Objects.requireNonNull(cls, "Service interface cannot be null");
        this.f45450a = cls;
        m56678f();
    }

    /* renamed from: a */
    public static <S> C8949e<S> m56673a(Class<S> cls) {
        return new C8949e<>(cls);
    }

    /* renamed from: b */
    public List<S> m56674b(int i10) {
        m56677e();
        return m56676d(i10);
    }

    /* renamed from: c */
    public final S m56675c(String str) throws ClassNotFoundException {
        Class<?> cls;
        StringBuilder sb2;
        String str2;
        S s10 = this.f45451b.get(str);
        if (s10 != null) {
            return s10;
        }
        S sCast = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
            C1016d.m6183c("PluginServiceLoader", "Provider " + str + " not found");
            cls = null;
        }
        if (!this.f45450a.isAssignableFrom(cls)) {
            C1016d.m6183c("PluginServiceLoader", "Provider " + str + " not a subtype");
        }
        if (cls != null) {
            try {
                sCast = this.f45450a.cast(cls.newInstance());
            } catch (IllegalAccessException unused2) {
                sb2 = new StringBuilder("Provider");
                sb2.append(str);
                str2 = " IllegalAccessException ";
                sb2.append(str2);
                C1016d.m6183c("PluginServiceLoader", sb2.toString());
                this.f45451b.put(str, sCast);
                return sCast;
            } catch (InstantiationException unused3) {
                sb2 = new StringBuilder("Provider");
                sb2.append(str);
                str2 = " InstantiationException ";
                sb2.append(str2);
                C1016d.m6183c("PluginServiceLoader", sb2.toString());
                this.f45451b.put(str, sCast);
                return sCast;
            }
        }
        this.f45451b.put(str, sCast);
        return sCast;
    }

    /* renamed from: d */
    public final List<S> m56676d(int i10) {
        ArrayList arrayList = new ArrayList();
        List<String> list = this.f45452c.get(Integer.valueOf(i10));
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(m56675c(it.next()));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public final void m56677e() {
        String[] strArrPaths;
        if (this.f45452c.isEmpty()) {
            try {
                for (Field field : ProductId.class.getDeclaredFields()) {
                    InterfaceC8950f interfaceC8950f = (InterfaceC8950f) field.getAnnotation(InterfaceC8950f.class);
                    String name = field.getName();
                    if ((field.get(name) instanceof Integer) && interfaceC8950f != null && (strArrPaths = interfaceC8950f.paths()) != null && strArrPaths.length != 0) {
                        if (field.get(name) instanceof Integer) {
                            this.f45452c.put((Integer) field.get(name), Arrays.asList(strArrPaths));
                        }
                    }
                    return;
                }
            } catch (IllegalAccessException unused) {
                C1016d.m6183c("PluginServiceLoader", "parserProductId");
            }
        }
    }

    /* renamed from: f */
    public final void m56678f() {
        this.f45451b.clear();
        this.f45452c.clear();
    }
}
