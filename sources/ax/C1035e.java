package ax;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p408jw.C10944j;
import p692uw.C13267j;
import p790xw.C13879h;
import p790xw.C13885n;
import tw.InterfaceC13090p;
import zw.InterfaceC14393b;

/* renamed from: ax.e */
/* loaded from: classes9.dex */
public final class C1035e implements InterfaceC14393b<C13879h> {

    /* renamed from: a */
    public final CharSequence f5105a;

    /* renamed from: b */
    public final int f5106b;

    /* renamed from: c */
    public final int f5107c;

    /* renamed from: d */
    public final InterfaceC13090p<CharSequence, Integer, C10944j<Integer, Integer>> f5108d;

    /* renamed from: ax.e$a */
    public static final class a implements Iterator<C13879h> {

        /* renamed from: a */
        public int f5109a = -1;

        /* renamed from: b */
        public int f5110b;

        /* renamed from: c */
        public int f5111c;

        /* renamed from: d */
        public C13879h f5112d;

        /* renamed from: e */
        public int f5113e;

        public a() {
            int iM83240e = C13885n.m83240e(C1035e.this.f5106b, 0, C1035e.this.f5105a.length());
            this.f5110b = iM83240e;
            this.f5111c = iM83240e;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m6245b() {
            /*
                r6 = this;
                int r0 = r6.f5111c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f5109a = r1
                r0 = 0
                r6.f5112d = r0
                goto L9e
            Lc:
                ax.e r0 = ax.C1035e.this
                int r0 = ax.C1035e.m6243c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f5113e
                int r0 = r0 + r3
                r6.f5113e = r0
                ax.e r4 = ax.C1035e.this
                int r4 = ax.C1035e.m6243c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f5111c
                ax.e r4 = ax.C1035e.this
                java.lang.CharSequence r4 = ax.C1035e.m6242b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                xw.h r0 = new xw.h
                int r1 = r6.f5110b
                ax.e r4 = ax.C1035e.this
                java.lang.CharSequence r4 = ax.C1035e.m6242b(r4)
                int r4 = ax.C1046p.m6274m(r4)
                r0.<init>(r1, r4)
                r6.f5112d = r0
                r6.f5111c = r2
                goto L9c
            L47:
                ax.e r0 = ax.C1035e.this
                tw.p r0 = ax.C1035e.m6241a(r0)
                ax.e r4 = ax.C1035e.this
                java.lang.CharSequence r4 = ax.C1035e.m6242b(r4)
                int r5 = r6.f5111c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.mo6288d(r4, r5)
                jw.j r0 = (p408jw.C10944j) r0
                if (r0 != 0) goto L77
                xw.h r0 = new xw.h
                int r1 = r6.f5110b
                ax.e r4 = ax.C1035e.this
                java.lang.CharSequence r4 = ax.C1035e.m6242b(r4)
                int r4 = ax.C1046p.m6274m(r4)
                r0.<init>(r1, r4)
                r6.f5112d = r0
                r6.f5111c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.m66066b()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.m66067c()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f5110b
                xw.h r4 = p790xw.C13883l.m83235g(r4, r2)
                r6.f5112d = r4
                int r2 = r2 + r0
                r6.f5110b = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.f5111c = r2
            L9c:
                r6.f5109a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ax.C1035e.a.m6245b():void");
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C13879h next() {
            if (this.f5109a == -1) {
                m6245b();
            }
            if (this.f5109a == 0) {
                throw new NoSuchElementException();
            }
            C13879h c13879h = this.f5112d;
            C13267j.m79675c(c13879h, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f5112d = null;
            this.f5109a = -1;
            return c13879h;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5109a == -1) {
                m6245b();
            }
            return this.f5109a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1035e(CharSequence charSequence, int i10, int i11, InterfaceC13090p<? super CharSequence, ? super Integer, C10944j<Integer, Integer>> interfaceC13090p) {
        C13267j.m79677e(charSequence, "input");
        C13267j.m79677e(interfaceC13090p, "getNextMatch");
        this.f5105a = charSequence;
        this.f5106b = i10;
        this.f5107c = i11;
        this.f5108d = interfaceC13090p;
    }

    @Override // zw.InterfaceC14393b
    public Iterator<C13879h> iterator() {
        return new a();
    }
}
