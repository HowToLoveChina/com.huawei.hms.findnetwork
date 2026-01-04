package p508o3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import p468m3.C11396b;
import p468m3.C11397c;
import p508o3.EnumC11800e;
import p565q3.C12280d;
import p565q3.C12281e;

/* renamed from: o3.d */
/* loaded from: classes.dex */
public final class C11799d<T> implements Serializable {

    /* renamed from: a */
    public final EnumC11800e.c f54671a;

    /* renamed from: b */
    public final int f54672b;

    /* renamed from: c */
    public final InterfaceC11801f<? super T> f54673c;

    /* renamed from: d */
    public final c f54674d;

    /* renamed from: o3.d$b */
    public static class b<T> implements Serializable {
        private static final long serialVersionUID = 1;

        /* renamed from: a */
        public final long[] f54675a;

        /* renamed from: b */
        public final int f54676b;

        /* renamed from: c */
        public final InterfaceC11801f<? super T> f54677c;

        /* renamed from: d */
        public final c f54678d;

        public b(C11799d<T> c11799d) {
            this.f54675a = EnumC11800e.c.m70337d(c11799d.f54671a.f54682a);
            this.f54676b = c11799d.f54672b;
            this.f54677c = c11799d.f54673c;
            this.f54678d = c11799d.f54674d;
        }

        public Object readResolve() {
            return new C11799d(new EnumC11800e.c(this.f54675a), this.f54676b, this.f54677c, this.f54678d);
        }
    }

    /* renamed from: o3.d$c */
    public interface c extends Serializable {
        /* renamed from: a */
        <T> boolean mo70333a(T t10, InterfaceC11801f<? super T> interfaceC11801f, int i10, EnumC11800e.c cVar);

        int ordinal();
    }

    /* renamed from: f */
    public static <T> C11799d<T> m70326f(InterfaceC11801f<? super T> interfaceC11801f, int i10, double d10) {
        return m70327g(interfaceC11801f, i10, d10);
    }

    /* renamed from: g */
    public static <T> C11799d<T> m70327g(InterfaceC11801f<? super T> interfaceC11801f, long j10, double d10) {
        return m70328h(interfaceC11801f, j10, d10, EnumC11800e.f54680b);
    }

    /* renamed from: h */
    public static <T> C11799d<T> m70328h(InterfaceC11801f<? super T> interfaceC11801f, long j10, double d10, c cVar) {
        C11397c.m68310g(interfaceC11801f);
        C11397c.m68308e(j10 >= 0, "Expected insertions (%s) must be >= 0", j10);
        C11397c.m68309f(d10 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d10));
        C11397c.m68309f(d10 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d10));
        C11397c.m68310g(cVar);
        if (j10 == 0) {
            j10 = 1;
        }
        long jM70329j = m70329j(j10, d10);
        try {
            return new C11799d<>(new EnumC11800e.c(jM70329j), m70330k(j10, jM70329j), interfaceC11801f, cVar);
        } catch (IllegalArgumentException e10) {
            StringBuilder sb2 = new StringBuilder(57);
            sb2.append("Could not create BloomFilter of ");
            sb2.append(jM70329j);
            sb2.append(" bits");
            throw new IllegalArgumentException(sb2.toString(), e10);
        }
    }

    /* renamed from: j */
    public static long m70329j(long j10, double d10) {
        if (d10 == 0.0d) {
            d10 = Double.MIN_VALUE;
        }
        return (long) (((-j10) * Math.log(d10)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    /* renamed from: k */
    public static int m70330k(long j10, long j11) {
        return Math.max(1, (int) Math.round((j11 / j10) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new b(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C11799d)) {
            return false;
        }
        C11799d c11799d = (C11799d) obj;
        return this.f54672b == c11799d.f54672b && this.f54673c.equals(c11799d.f54673c) && this.f54671a.equals(c11799d.f54671a) && this.f54674d.equals(c11799d.f54674d);
    }

    public int hashCode() {
        return C11396b.m68303b(Integer.valueOf(this.f54672b), this.f54673c, this.f54674d, this.f54671a);
    }

    /* renamed from: l */
    public boolean m70331l(T t10) {
        return this.f54674d.mo70333a(t10, this.f54673c, this.f54672b, this.f54671a);
    }

    /* renamed from: m */
    public void m70332m(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(C12280d.m73804a(this.f54674d.ordinal()));
        dataOutputStream.writeByte(C12281e.m73805a(this.f54672b));
        dataOutputStream.writeInt(this.f54671a.f54682a.length());
        for (int i10 = 0; i10 < this.f54671a.f54682a.length(); i10++) {
            dataOutputStream.writeLong(this.f54671a.f54682a.get(i10));
        }
    }

    public C11799d(EnumC11800e.c cVar, int i10, InterfaceC11801f<? super T> interfaceC11801f, c cVar2) {
        C11397c.m68306c(i10 > 0, "numHashFunctions (%s) must be > 0", i10);
        C11397c.m68306c(i10 <= 255, "numHashFunctions (%s) must be <= 255", i10);
        this.f54671a = (EnumC11800e.c) C11397c.m68310g(cVar);
        this.f54672b = i10;
        this.f54673c = (InterfaceC11801f) C11397c.m68310g(interfaceC11801f);
        this.f54674d = (c) C11397c.m68310g(cVar2);
    }
}
