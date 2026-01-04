package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.i */
/* loaded from: classes.dex */
public abstract class AbstractC1920i implements Iterable<Byte>, Serializable {

    /* renamed from: b */
    public static final AbstractC1920i f9147b = new j(C1900b0.f9087c);

    /* renamed from: c */
    public static final f f9148c;

    /* renamed from: d */
    public static final Comparator<AbstractC1920i> f9149d;

    /* renamed from: a */
    public int f9150a = 0;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$a */
    public class a extends c {

        /* renamed from: a */
        public int f9151a = 0;

        /* renamed from: b */
        public final int f9152b;

        public a() {
            this.f9152b = AbstractC1920i.this.size();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.g
        /* renamed from: a */
        public byte mo11702a() {
            int i10 = this.f9151a;
            if (i10 >= this.f9152b) {
                throw new NoSuchElementException();
            }
            this.f9151a = i10 + 1;
            return AbstractC1920i.this.mo11691k(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9151a < this.f9152b;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$b */
    public class b implements Comparator<AbstractC1920i> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AbstractC1920i abstractC1920i, AbstractC1920i abstractC1920i2) {
            g it = abstractC1920i.iterator();
            g it2 = abstractC1920i2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int iCompare = Integer.compare(AbstractC1920i.m11686w(it.mo11702a()), AbstractC1920i.m11686w(it2.mo11702a()));
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return Integer.compare(abstractC1920i.size(), abstractC1920i2.size());
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$c */
    public static abstract class c implements g {
        @Override // java.util.Iterator
        /* renamed from: b */
        public final Byte next() {
            return Byte.valueOf(mo11702a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$d */
    public static final class d implements f {
        public d() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.f
        /* renamed from: a */
        public byte[] mo11705a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$e */
    public static final class e extends j {
        private static final long serialVersionUID = 1;

        /* renamed from: f */
        public final int f9154f;

        /* renamed from: g */
        public final int f9155g;

        public e(byte[] bArr, int i10, int i11) {
            super(bArr);
            AbstractC1920i.m11681e(i10, i10 + i11, bArr.length);
            this.f9154f = i10;
            this.f9155g = i11;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.j
        /* renamed from: G */
        public int mo11706G() {
            return this.f9154f;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.j, com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: c */
        public byte mo11689c(int i10) {
            AbstractC1920i.m11680d(i10, size());
            return this.f9158e[this.f9154f + i10];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.j, com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: j */
        public void mo11690j(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f9158e, mo11706G() + i10, bArr, i11, i12);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.j, com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: k */
        public byte mo11691k(int i10) {
            return this.f9158e[this.f9154f + i10];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.j, com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        public int size() {
            return this.f9155g;
        }

        public Object writeReplace() {
            return AbstractC1920i.m11677C(m11698u());
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$f */
    public interface f {
        /* renamed from: a */
        byte[] mo11705a(byte[] bArr, int i10, int i11);
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$g */
    public interface g extends Iterator<Byte> {
        /* renamed from: a */
        byte mo11702a();
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$h */
    public static final class h {

        /* renamed from: a */
        public final AbstractC1929l f9156a;

        /* renamed from: b */
        public final byte[] f9157b;

        public /* synthetic */ h(int i10, a aVar) {
            this(i10);
        }

        /* renamed from: a */
        public AbstractC1920i m11707a() {
            this.f9156a.m11944c();
            return new j(this.f9157b);
        }

        /* renamed from: b */
        public AbstractC1929l m11708b() {
            return this.f9156a;
        }

        public h(int i10) {
            byte[] bArr = new byte[i10];
            this.f9157b = bArr;
            this.f9156a = AbstractC1929l.m11902d0(bArr);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$i */
    public static abstract class i extends AbstractC1920i {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$j */
    public static class j extends i {
        private static final long serialVersionUID = 1;

        /* renamed from: e */
        public final byte[] f9158e;

        public j(byte[] bArr) {
            bArr.getClass();
            this.f9158e = bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: E */
        public final void mo11688E(AbstractC1917h abstractC1917h) throws IOException {
            abstractC1917h.mo11666a(this.f9158e, mo11706G(), size());
        }

        /* renamed from: F */
        public final boolean m11709F(AbstractC1920i abstractC1920i, int i10, int i11) {
            if (i11 > abstractC1920i.size()) {
                throw new IllegalArgumentException("Length too large: " + i11 + size());
            }
            int i12 = i10 + i11;
            if (i12 > abstractC1920i.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + abstractC1920i.size());
            }
            if (!(abstractC1920i instanceof j)) {
                return abstractC1920i.mo11697r(i10, i12).equals(mo11697r(0, i11));
            }
            j jVar = (j) abstractC1920i;
            byte[] bArr = this.f9158e;
            byte[] bArr2 = jVar.f9158e;
            int iMo11706G = mo11706G() + i11;
            int iMo11706G2 = mo11706G();
            int iMo11706G3 = jVar.mo11706G() + i10;
            while (iMo11706G2 < iMo11706G) {
                if (bArr[iMo11706G2] != bArr2[iMo11706G3]) {
                    return false;
                }
                iMo11706G2++;
                iMo11706G3++;
            }
            return true;
        }

        /* renamed from: G */
        public int mo11706G() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: c */
        public byte mo11689c(int i10) {
            return this.f9158e[i10];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC1920i) || size() != ((AbstractC1920i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iM11696q = m11696q();
            int iM11696q2 = jVar.m11696q();
            if (iM11696q == 0 || iM11696q2 == 0 || iM11696q == iM11696q2) {
                return m11709F(jVar, 0, size());
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: j */
        public void mo11690j(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f9158e, i10, bArr, i11, i12);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: k */
        public byte mo11691k(int i10) {
            return this.f9158e[i10];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: l */
        public final boolean mo11692l() {
            int iMo11706G = mo11706G();
            return C1955t1.m12223n(this.f9158e, iMo11706G, size() + iMo11706G);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: o */
        public final AbstractC1923j mo11694o() {
            return AbstractC1923j.m11723h(this.f9158e, mo11706G(), size(), true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: p */
        public final int mo11695p(int i10, int i11, int i12) {
            return C1900b0.m11494i(i10, this.f9158e, mo11706G() + i11, i12);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: r */
        public final AbstractC1920i mo11697r(int i10, int i11) {
            int iM11681e = AbstractC1920i.m11681e(i10, i11, size());
            return iM11681e == 0 ? AbstractC1920i.f9147b : new e(this.f9158e, mo11706G() + i10, iM11681e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        public int size() {
            return this.f9158e.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i
        /* renamed from: y */
        public final String mo11700y(Charset charset) {
            return new String(this.f9158e, mo11706G(), size(), charset);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i$k */
    public static final class k implements f {
        public k() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1920i.f
        /* renamed from: a */
        public byte[] mo11705a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        f9148c = C1905d.m11514c() ? new k(null) : new d(null);
        f9149d = new b();
    }

    /* renamed from: C */
    public static AbstractC1920i m11677C(byte[] bArr) {
        return new j(bArr);
    }

    /* renamed from: D */
    public static AbstractC1920i m11678D(byte[] bArr, int i10, int i11) {
        return new e(bArr, i10, i11);
    }

    /* renamed from: d */
    public static void m11680d(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    /* renamed from: e */
    public static int m11681e(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        }
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        }
        throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
    }

    /* renamed from: f */
    public static AbstractC1920i m11682f(byte[] bArr) {
        return m11683g(bArr, 0, bArr.length);
    }

    /* renamed from: g */
    public static AbstractC1920i m11683g(byte[] bArr, int i10, int i11) {
        m11681e(i10, i10 + i11, bArr.length);
        return new j(f9148c.mo11705a(bArr, i10, i11));
    }

    /* renamed from: h */
    public static AbstractC1920i m11684h(String str) {
        return new j(str.getBytes(C1900b0.f9085a));
    }

    /* renamed from: n */
    public static h m11685n(int i10) {
        return new h(i10, null);
    }

    /* renamed from: w */
    public static int m11686w(byte b10) {
        return b10 & 255;
    }

    /* renamed from: B */
    public final String m11687B() {
        if (size() <= 50) {
            return C1934m1.m12033a(this);
        }
        return C1934m1.m12033a(mo11697r(0, 47)) + "...";
    }

    /* renamed from: E */
    public abstract void mo11688E(AbstractC1917h abstractC1917h) throws IOException;

    /* renamed from: c */
    public abstract byte mo11689c(int i10);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iMo11695p = this.f9150a;
        if (iMo11695p == 0) {
            int size = size();
            iMo11695p = mo11695p(size, 0, size);
            if (iMo11695p == 0) {
                iMo11695p = 1;
            }
            this.f9150a = iMo11695p;
        }
        return iMo11695p;
    }

    /* renamed from: j */
    public abstract void mo11690j(byte[] bArr, int i10, int i11, int i12);

    /* renamed from: k */
    public abstract byte mo11691k(int i10);

    /* renamed from: l */
    public abstract boolean mo11692l();

    @Override // java.lang.Iterable
    /* renamed from: m */
    public g iterator() {
        return new a();
    }

    /* renamed from: o */
    public abstract AbstractC1923j mo11694o();

    /* renamed from: p */
    public abstract int mo11695p(int i10, int i11, int i12);

    /* renamed from: q */
    public final int m11696q() {
        return this.f9150a;
    }

    /* renamed from: r */
    public abstract AbstractC1920i mo11697r(int i10, int i11);

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), m11687B());
    }

    /* renamed from: u */
    public final byte[] m11698u() {
        int size = size();
        if (size == 0) {
            return C1900b0.f9087c;
        }
        byte[] bArr = new byte[size];
        mo11690j(bArr, 0, 0, size);
        return bArr;
    }

    /* renamed from: x */
    public final String m11699x(Charset charset) {
        return size() == 0 ? "" : mo11700y(charset);
    }

    /* renamed from: y */
    public abstract String mo11700y(Charset charset);

    /* renamed from: z */
    public final String m11701z() {
        return m11699x(C1900b0.f9085a);
    }
}
