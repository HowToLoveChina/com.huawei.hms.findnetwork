package p438l;

import java.util.LinkedHashMap;
import java.util.Locale;

/* renamed from: l.e */
/* loaded from: classes.dex */
public class C11211e<K, V> {

    /* renamed from: a */
    public final LinkedHashMap<K, V> f52616a;

    /* renamed from: b */
    public int f52617b;

    /* renamed from: c */
    public int f52618c;

    /* renamed from: d */
    public int f52619d;

    /* renamed from: e */
    public int f52620e;

    /* renamed from: f */
    public int f52621f;

    /* renamed from: g */
    public int f52622g;

    /* renamed from: h */
    public int f52623h;

    public C11211e(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f52618c = i10;
        this.f52616a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: a */
    public V m67305a(K k10) {
        return null;
    }

    /* renamed from: b */
    public void m67306b(boolean z10, K k10, V v10, V v11) {
    }

    /* renamed from: c */
    public final V m67307c(K k10) {
        V v10;
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                V v11 = this.f52616a.get(k10);
                if (v11 != null) {
                    this.f52622g++;
                    return v11;
                }
                this.f52623h++;
                V vM67305a = m67305a(k10);
                if (vM67305a == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.f52620e++;
                        v10 = (V) this.f52616a.put(k10, vM67305a);
                        if (v10 != null) {
                            this.f52616a.put(k10, v10);
                        } else {
                            this.f52617b += m67309e(k10, vM67305a);
                        }
                    } finally {
                    }
                }
                if (v10 != null) {
                    m67306b(false, k10, vM67305a, v10);
                    return v10;
                }
                m67311g(this.f52618c);
                return vM67305a;
            } finally {
            }
        }
    }

    /* renamed from: d */
    public final V m67308d(K k10, V v10) {
        V vPut;
        if (k10 == null || v10 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f52619d++;
                this.f52617b += m67309e(k10, v10);
                vPut = this.f52616a.put(k10, v10);
                if (vPut != null) {
                    this.f52617b -= m67309e(k10, vPut);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (vPut != null) {
            m67306b(false, k10, vPut, v10);
        }
        m67311g(this.f52618c);
        return vPut;
    }

    /* renamed from: e */
    public final int m67309e(K k10, V v10) {
        int iM67310f = m67310f(k10, v10);
        if (iM67310f >= 0) {
            return iM67310f;
        }
        throw new IllegalStateException("Negative size: " + k10 + "=" + v10);
    }

    /* renamed from: f */
    public int m67310f(K k10, V v10) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m67311g(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f52617b     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L55
            java.util.LinkedHashMap<K, V> r0 = r4.f52616a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r4.f52617b     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L55
            goto L14
        L12:
            r5 = move-exception
            goto L74
        L14:
            int r0 = r4.f52617b     // Catch: java.lang.Throwable -> L12
            if (r0 <= r5) goto L53
            java.util.LinkedHashMap<K, V> r0 = r4.f52616a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L53
        L21:
            java.util.LinkedHashMap<K, V> r0 = r4.f52616a     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, V> r2 = r4.f52616a     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r2 = r4.f52617b     // Catch: java.lang.Throwable -> L12
            int r3 = r4.m67309e(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r3
            r4.f52617b = r2     // Catch: java.lang.Throwable -> L12
            int r2 = r4.f52621f     // Catch: java.lang.Throwable -> L12
            r3 = 1
            int r2 = r2 + r3
            r4.f52621f = r2     // Catch: java.lang.Throwable -> L12
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            r2 = 0
            r4.m67306b(r3, r1, r0, r2)
            goto L0
        L53:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            return
        L55:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r5     // Catch: java.lang.Throwable -> L12
        L74:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p438l.C11211e.m67311g(int):void");
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        try {
            i10 = this.f52622g;
            i11 = this.f52623h + i10;
        } catch (Throwable th2) {
            throw th2;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f52618c), Integer.valueOf(this.f52622g), Integer.valueOf(this.f52623h), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }
}
