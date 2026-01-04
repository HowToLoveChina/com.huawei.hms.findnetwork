package p481n1;

/* renamed from: n1.h */
/* loaded from: classes.dex */
public class C11596h<K, V> {

    /* renamed from: a */
    public final a<K, V>[] f53808a;

    /* renamed from: b */
    public final int f53809b;

    /* renamed from: n1.h$a */
    public static final class a<K, V> {

        /* renamed from: a */
        public final int f53810a;

        /* renamed from: b */
        public final K f53811b;

        /* renamed from: c */
        public V f53812c;

        /* renamed from: d */
        public final a<K, V> f53813d;

        public a(K k10, V v10, int i10, a<K, V> aVar) {
            this.f53811b = k10;
            this.f53812c = v10;
            this.f53813d = aVar;
            this.f53810a = i10;
        }
    }

    public C11596h() {
        this(8192);
    }

    /* renamed from: a */
    public Class m69219a(String str) {
        int i10 = 0;
        while (true) {
            a<K, V>[] aVarArr = this.f53808a;
            if (i10 >= aVarArr.length) {
                return null;
            }
            a<K, V> aVar = aVarArr[i10];
            if (aVar != null) {
                for (a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f53813d) {
                    K k10 = aVar.f53811b;
                    if (k10 instanceof Class) {
                        Class cls = (Class) k10;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i10++;
        }
    }

    /* renamed from: b */
    public final V m69220b(K k10) {
        for (a<K, V> aVar = this.f53808a[System.identityHashCode(k10) & this.f53809b]; aVar != null; aVar = aVar.f53813d) {
            if (k10 == aVar.f53811b) {
                return aVar.f53812c;
            }
        }
        return null;
    }

    /* renamed from: c */
    public boolean m69221c(K k10, V v10) {
        int iIdentityHashCode = System.identityHashCode(k10);
        int i10 = this.f53809b & iIdentityHashCode;
        for (a<K, V> aVar = this.f53808a[i10]; aVar != null; aVar = aVar.f53813d) {
            if (k10 == aVar.f53811b) {
                aVar.f53812c = v10;
                return true;
            }
        }
        this.f53808a[i10] = new a<>(k10, v10, iIdentityHashCode, this.f53808a[i10]);
        return false;
    }

    public C11596h(int i10) {
        this.f53809b = i10 - 1;
        this.f53808a = new a[i10];
    }
}
