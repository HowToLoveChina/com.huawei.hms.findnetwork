package p630s2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: s2.h */
/* loaded from: classes.dex */
public class C12673h<T, Y> {

    /* renamed from: a */
    public final Map<T, a<Y>> f58178a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    public final long f58179b;

    /* renamed from: c */
    public long f58180c;

    /* renamed from: d */
    public long f58181d;

    /* renamed from: s2.h$a */
    public static final class a<Y> {

        /* renamed from: a */
        public final Y f58182a;

        /* renamed from: b */
        public final int f58183b;

        public a(Y y10, int i10) {
            this.f58182a = y10;
            this.f58183b = i10;
        }
    }

    public C12673h(long j10) {
        this.f58179b = j10;
        this.f58180c = j10;
    }

    public void clearMemory() {
        m76269l(0L);
    }

    /* renamed from: e */
    public final void m76264e() {
        m76269l(this.f58180c);
    }

    /* renamed from: f */
    public synchronized Y m76265f(T t10) {
        a<Y> aVar;
        aVar = this.f58178a.get(t10);
        return aVar != null ? aVar.f58182a : null;
    }

    /* renamed from: g */
    public synchronized long m76266g() {
        return this.f58180c;
    }

    /* renamed from: h */
    public int mo6544h(Y y10) {
        return 1;
    }

    /* renamed from: i */
    public void mo6545i(T t10, Y y10) {
    }

    /* renamed from: j */
    public synchronized Y m76267j(T t10, Y y10) {
        int iMo6544h = mo6544h(y10);
        long j10 = iMo6544h;
        if (j10 >= this.f58180c) {
            mo6545i(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.f58181d += j10;
        }
        a<Y> aVarPut = this.f58178a.put(t10, y10 == null ? null : new a<>(y10, iMo6544h));
        if (aVarPut != null) {
            this.f58181d -= aVarPut.f58183b;
            if (!aVarPut.f58182a.equals(y10)) {
                mo6545i(t10, aVarPut.f58182a);
            }
        }
        m76264e();
        return aVarPut != null ? aVarPut.f58182a : null;
    }

    /* renamed from: k */
    public synchronized Y m76268k(T t10) {
        a<Y> aVarRemove = this.f58178a.remove(t10);
        if (aVarRemove == null) {
            return null;
        }
        this.f58181d -= aVarRemove.f58183b;
        return aVarRemove.f58182a;
    }

    /* renamed from: l */
    public synchronized void m76269l(long j10) {
        while (this.f58181d > j10) {
            Iterator<Map.Entry<T, a<Y>>> it = this.f58178a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f58181d -= value.f58183b;
            T key = next.getKey();
            it.remove();
            mo6545i(key, value.f58182a);
        }
    }
}
