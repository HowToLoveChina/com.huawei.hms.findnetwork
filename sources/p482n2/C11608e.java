package p482n2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p759x1.InterfaceC13686k;

/* renamed from: n2.e */
/* loaded from: classes.dex */
public class C11608e {

    /* renamed from: a */
    public final List<String> f53900a = new ArrayList();

    /* renamed from: b */
    public final Map<String, List<a<?, ?>>> f53901b = new HashMap();

    /* renamed from: n2.e$a */
    public static class a<T, R> {

        /* renamed from: a */
        public final Class<T> f53902a;

        /* renamed from: b */
        public final Class<R> f53903b;

        /* renamed from: c */
        public final InterfaceC13686k<T, R> f53904c;

        public a(Class<T> cls, Class<R> cls2, InterfaceC13686k<T, R> interfaceC13686k) {
            this.f53902a = cls;
            this.f53903b = cls2;
            this.f53904c = interfaceC13686k;
        }

        /* renamed from: a */
        public boolean m69354a(Class<?> cls, Class<?> cls2) {
            return this.f53902a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f53903b);
        }
    }

    /* renamed from: a */
    public synchronized <T, R> void m69349a(String str, InterfaceC13686k<T, R> interfaceC13686k, Class<T> cls, Class<R> cls2) {
        m69351c(str).add(new a<>(cls, cls2, interfaceC13686k));
    }

    /* renamed from: b */
    public synchronized <T, R> List<InterfaceC13686k<T, R>> m69350b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f53900a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f53901b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.m69354a(cls, cls2)) {
                        arrayList.add(aVar.f53904c);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final synchronized List<a<?, ?>> m69351c(String str) {
        List<a<?, ?>> arrayList;
        try {
            if (!this.f53900a.contains(str)) {
                this.f53900a.add(str);
            }
            arrayList = this.f53901b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f53901b.put(str, arrayList);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    /* renamed from: d */
    public synchronized <T, R> List<Class<R>> m69352d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f53900a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f53901b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.m69354a(cls, cls2) && !arrayList.contains(aVar.f53903b)) {
                        arrayList.add(aVar.f53903b);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public synchronized void m69353e(List<String> list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.f53900a);
            this.f53900a.clear();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f53900a.add(it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f53900a.add(str);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
