package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: androidx.lifecycle.b0 */
/* loaded from: classes.dex */
public abstract class AbstractC0780b0 {

    /* renamed from: a */
    public final Map<String, Object> f4147a = new HashMap();

    /* renamed from: b */
    public final Set<Closeable> f4148b = new LinkedHashSet();

    /* renamed from: c */
    public volatile boolean f4149c = false;

    /* renamed from: b */
    public static void m4923b(Object obj) throws IOException {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* renamed from: a */
    public final void m4924a() {
        this.f4149c = true;
        Map<String, Object> map = this.f4147a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator<Object> it = this.f4147a.values().iterator();
                    while (it.hasNext()) {
                        m4923b(it.next());
                    }
                } finally {
                }
            }
        }
        Set<Closeable> set = this.f4148b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator<Closeable> it2 = this.f4148b.iterator();
                    while (it2.hasNext()) {
                        m4923b(it2.next());
                    }
                } finally {
                }
            }
        }
        mo4815d();
    }

    /* renamed from: c */
    public <T> T m4925c(String str) {
        T t10;
        Map<String, Object> map = this.f4147a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t10 = (T) this.f4147a.get(str);
        }
        return t10;
    }

    /* renamed from: d */
    public void mo4815d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public <T> T m4926e(String str, T t10) throws IOException {
        Object obj;
        synchronized (this.f4147a) {
            try {
                obj = this.f4147a.get(str);
                if (obj == 0) {
                    this.f4147a.put(str, t10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (obj != 0) {
            t10 = obj;
        }
        if (this.f4149c) {
            m4923b(t10);
        }
        return t10;
    }
}
