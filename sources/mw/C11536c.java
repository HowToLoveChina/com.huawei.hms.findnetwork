package mw;

import java.io.Serializable;
import mw.InterfaceC11539f;
import p408jw.C10951q;
import p692uw.AbstractC13268k;
import p692uw.C13264g;
import p692uw.C13267j;
import p692uw.C13273p;
import tw.InterfaceC13090p;

/* renamed from: mw.c */
/* loaded from: classes9.dex */
public final class C11536c implements InterfaceC11539f, Serializable {

    /* renamed from: a */
    public final InterfaceC11539f f53487a;

    /* renamed from: b */
    public final InterfaceC11539f.b f53488b;

    /* renamed from: mw.c$a */
    public static final class a implements Serializable {

        /* renamed from: b */
        public static final C14507a f53489b = new C14507a(null);
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        public final InterfaceC11539f[] f53490a;

        /* renamed from: mw.c$a$a, reason: collision with other inner class name */
        public static final class C14507a {
            public /* synthetic */ C14507a(C13264g c13264g) {
                this();
            }

            public C14507a() {
            }
        }

        public a(InterfaceC11539f[] interfaceC11539fArr) {
            C13267j.m79677e(interfaceC11539fArr, "elements");
            this.f53490a = interfaceC11539fArr;
        }

        private final Object readResolve() {
            InterfaceC11539f[] interfaceC11539fArr = this.f53490a;
            InterfaceC11539f interfaceC11539fPlus = C11540g.f53497a;
            for (InterfaceC11539f interfaceC11539f : interfaceC11539fArr) {
                interfaceC11539fPlus = interfaceC11539fPlus.plus(interfaceC11539f);
            }
            return interfaceC11539fPlus;
        }
    }

    /* renamed from: mw.c$b */
    public static final class b extends AbstractC13268k implements InterfaceC13090p<String, InterfaceC11539f.b, String> {

        /* renamed from: b */
        public static final b f53491b = new b();

        public b() {
            super(2);
        }

        @Override // tw.InterfaceC13090p
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final String mo6288d(String str, InterfaceC11539f.b bVar) {
            C13267j.m79677e(str, "acc");
            C13267j.m79677e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    /* renamed from: mw.c$c */
    public static final class c extends AbstractC13268k implements InterfaceC13090p<C10951q, InterfaceC11539f.b, C10951q> {

        /* renamed from: b */
        public final /* synthetic */ InterfaceC11539f[] f53492b;

        /* renamed from: c */
        public final /* synthetic */ C13273p f53493c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC11539f[] interfaceC11539fArr, C13273p c13273p) {
            super(2);
            this.f53492b = interfaceC11539fArr;
            this.f53493c = c13273p;
        }

        @Override // tw.InterfaceC13090p
        /* renamed from: d */
        public /* bridge */ /* synthetic */ C10951q mo6288d(C10951q c10951q, InterfaceC11539f.b bVar) {
            m68834e(c10951q, bVar);
            return C10951q.f51861a;
        }

        /* renamed from: e */
        public final void m68834e(C10951q c10951q, InterfaceC11539f.b bVar) {
            C13267j.m79677e(c10951q, "<anonymous parameter 0>");
            C13267j.m79677e(bVar, "element");
            InterfaceC11539f[] interfaceC11539fArr = this.f53492b;
            C13273p c13273p = this.f53493c;
            int i10 = c13273p.f59978a;
            c13273p.f59978a = i10 + 1;
            interfaceC11539fArr[i10] = bVar;
        }
    }

    public C11536c(InterfaceC11539f interfaceC11539f, InterfaceC11539f.b bVar) {
        C13267j.m79677e(interfaceC11539f, "left");
        C13267j.m79677e(bVar, "element");
        this.f53487a = interfaceC11539f;
        this.f53488b = bVar;
    }

    private final Object writeReplace() {
        int iM68832d = m68832d();
        InterfaceC11539f[] interfaceC11539fArr = new InterfaceC11539f[iM68832d];
        C13273p c13273p = new C13273p();
        fold(C10951q.f51861a, new c(interfaceC11539fArr, c13273p));
        if (c13273p.f59978a == iM68832d) {
            return new a(interfaceC11539fArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: b */
    public final boolean m68830b(InterfaceC11539f.b bVar) {
        return C13267j.m79673a(get(bVar.getKey()), bVar);
    }

    /* renamed from: c */
    public final boolean m68831c(C11536c c11536c) {
        while (m68830b(c11536c.f53488b)) {
            InterfaceC11539f interfaceC11539f = c11536c.f53487a;
            if (!(interfaceC11539f instanceof C11536c)) {
                C13267j.m79675c(interfaceC11539f, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return m68830b((InterfaceC11539f.b) interfaceC11539f);
            }
            c11536c = (C11536c) interfaceC11539f;
        }
        return false;
    }

    /* renamed from: d */
    public final int m68832d() {
        int i10 = 2;
        while (true) {
            InterfaceC11539f interfaceC11539f = this.f53487a;
            this = interfaceC11539f instanceof C11536c ? (C11536c) interfaceC11539f : null;
            if (this == null) {
                return i10;
            }
            i10++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C11536c) {
                C11536c c11536c = (C11536c) obj;
                if (c11536c.m68832d() != m68832d() || !c11536c.m68831c(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // mw.InterfaceC11539f
    public <R> R fold(R r10, InterfaceC13090p<? super R, ? super InterfaceC11539f.b, ? extends R> interfaceC13090p) {
        C13267j.m79677e(interfaceC13090p, "operation");
        return interfaceC13090p.mo6288d((Object) this.f53487a.fold(r10, interfaceC13090p), this.f53488b);
    }

    @Override // mw.InterfaceC11539f
    public <E extends InterfaceC11539f.b> E get(InterfaceC11539f.c<E> cVar) {
        C13267j.m79677e(cVar, "key");
        while (true) {
            E e10 = (E) this.f53488b.get(cVar);
            if (e10 != null) {
                return e10;
            }
            InterfaceC11539f interfaceC11539f = this.f53487a;
            if (!(interfaceC11539f instanceof C11536c)) {
                return (E) interfaceC11539f.get(cVar);
            }
            this = (C11536c) interfaceC11539f;
        }
    }

    public int hashCode() {
        return this.f53487a.hashCode() + this.f53488b.hashCode();
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f minusKey(InterfaceC11539f.c<?> cVar) {
        C13267j.m79677e(cVar, "key");
        if (this.f53488b.get(cVar) != null) {
            return this.f53487a;
        }
        InterfaceC11539f interfaceC11539fMinusKey = this.f53487a.minusKey(cVar);
        return interfaceC11539fMinusKey == this.f53487a ? this : interfaceC11539fMinusKey == C11540g.f53497a ? this.f53488b : new C11536c(interfaceC11539fMinusKey, this.f53488b);
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f plus(InterfaceC11539f interfaceC11539f) {
        return InterfaceC11539f.a.m68837a(this, interfaceC11539f);
    }

    public String toString() {
        return '[' + ((String) fold("", b.f53491b)) + ']';
    }
}
