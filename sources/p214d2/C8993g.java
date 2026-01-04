package p214d2;

import java.util.Queue;
import p630s2.C12673h;
import p630s2.C12677l;

/* renamed from: d2.g */
/* loaded from: classes.dex */
public class C8993g<A, B> {

    /* renamed from: a */
    public final C12673h<b<A>, B> f45604a;

    /* renamed from: d2.g$a */
    public class a extends C12673h<b<A>, B> {
        public a(long j10) {
            super(j10);
        }

        @Override // p630s2.C12673h
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void mo6545i(b<A> bVar, B b10) {
            bVar.m56842c();
        }
    }

    /* renamed from: d2.g$b */
    public static final class b<A> {

        /* renamed from: d */
        public static final Queue<b<?>> f45606d = C12677l.m76282e(0);

        /* renamed from: a */
        public int f45607a;

        /* renamed from: b */
        public int f45608b;

        /* renamed from: c */
        public A f45609c;

        /* renamed from: a */
        public static <A> b<A> m56840a(A a10, int i10, int i11) {
            b<A> bVar;
            Queue<b<?>> queue = f45606d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.m56841b(a10, i10, i11);
            return bVar;
        }

        /* renamed from: b */
        public final void m56841b(A a10, int i10, int i11) {
            this.f45609c = a10;
            this.f45608b = i10;
            this.f45607a = i11;
        }

        /* renamed from: c */
        public void m56842c() {
            Queue<b<?>> queue = f45606d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f45608b == bVar.f45608b && this.f45607a == bVar.f45607a && this.f45609c.equals(bVar.f45609c);
        }

        public int hashCode() {
            return (((this.f45607a * 31) + this.f45608b) * 31) + this.f45609c.hashCode();
        }
    }

    public C8993g(long j10) {
        this.f45604a = new a(j10);
    }

    /* renamed from: a */
    public B m56837a(A a10, int i10, int i11) {
        b<A> bVarM56840a = b.m56840a(a10, i10, i11);
        B bM76265f = this.f45604a.m76265f(bVarM56840a);
        bVarM56840a.m56842c();
        return bM76265f;
    }

    /* renamed from: b */
    public void m56838b(A a10, int i10, int i11, B b10) {
        this.f45604a.m76267j(b.m56840a(a10, i10, i11), b10);
    }
}
