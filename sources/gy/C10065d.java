package gy;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ly.C11367a;
import ly.C11369c;
import ly.C11376j;
import p270ey.AbstractC9573b;
import p350hy.AbstractC10361d;
import p350hy.InterfaceC10359b;

/* renamed from: gy.d */
/* loaded from: classes9.dex */
public class C10065d extends AbstractC9573b<C10064c> {

    /* renamed from: d */
    public final byte[] f49100d;

    /* renamed from: e */
    public final byte[] f49101e;

    /* renamed from: f */
    public final int f49102f;

    /* renamed from: g */
    public boolean f49103g;

    /* renamed from: h */
    public long f49104h;

    /* renamed from: i */
    public long f49105i;

    /* renamed from: j */
    public List<InputStream> f49106j;

    /* renamed from: k */
    public int f49107k;

    /* renamed from: l */
    public C10064c f49108l;

    /* renamed from: m */
    public final InterfaceC10359b f49109m;

    /* renamed from: n */
    public Map<String, String> f49110n;

    /* renamed from: o */
    public final List<C10070i> f49111o;

    /* renamed from: p */
    public final boolean f49112p;

    public C10065d(InputStream inputStream) {
        this(inputStream, 10240, 512);
    }

    @Deprecated
    /* renamed from: A */
    public C10064c m62615A() throws IOException {
        if (m62618D()) {
            return null;
        }
        if (this.f49108l != null) {
            C11376j.m68232f(this, Long.MAX_VALUE);
            m62627Y();
        }
        byte[] bArrM62616B = m62616B();
        if (bArrM62616B == null) {
            this.f49108l = null;
            return null;
        }
        try {
            C10064c c10064c = new C10064c(this.f49110n, bArrM62616B, this.f49109m, this.f49112p);
            this.f49108l = c10064c;
            this.f49105i = 0L;
            this.f49104h = c10064c.m62611w();
            if (this.f49108l.m62550C()) {
                byte[] bArrM62634y = m62634y();
                if (bArrM62634y == null) {
                    return null;
                }
                this.f49108l.m62584h0(this.f49109m.mo62690a(bArrM62634y));
            }
            if (this.f49108l.m62551D()) {
                byte[] bArrM62634y2 = m62634y();
                if (bArrM62634y2 == null) {
                    return null;
                }
                String strMo62690a = this.f49109m.mo62690a(bArrM62634y2);
                this.f49108l.m62590k0(strMo62690a);
                if (this.f49108l.m62614z() && !strMo62690a.endsWith("/")) {
                    this.f49108l.m62590k0(strMo62690a + "/");
                }
            }
            if (this.f49108l.m62553F()) {
                m62622H();
            }
            try {
                if (this.f49108l.m62560M()) {
                    m62621G();
                } else if (!this.f49110n.isEmpty()) {
                    m62630u(this.f49110n, this.f49111o);
                }
                if (this.f49108l.m62557J()) {
                    m62623I();
                }
                this.f49104h = this.f49108l.m62611w();
                return this.f49108l;
            } catch (NumberFormatException e10) {
                throw new IOException("Error detected parsing the pax header", e10);
            }
        } catch (IllegalArgumentException e11) {
            throw new IOException("Error detected parsing the header", e11);
        }
    }

    /* renamed from: B */
    public final byte[] m62616B() throws IOException {
        byte[] bArrM62624J = m62624J();
        m62626X(m62620F(bArrM62624J));
        if (!m62618D() || bArrM62624J == null) {
            return bArrM62624J;
        }
        m62629a0();
        m62632w();
        return null;
    }

    /* renamed from: C */
    public int m62617C() {
        return this.f49101e.length;
    }

    /* renamed from: D */
    public final boolean m62618D() {
        return this.f49103g;
    }

    /* renamed from: E */
    public final boolean m62619E() {
        C10064c c10064c = this.f49108l;
        return c10064c != null && c10064c.m62614z();
    }

    /* renamed from: F */
    public boolean m62620F(byte[] bArr) {
        return bArr == null || C11367a.m68205a(bArr, m62617C());
    }

    /* renamed from: G */
    public final void m62621G() throws IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        Map<String, String> mapM62685t = C10071j.m62685t(this, arrayList, this.f49110n, this.f49104h);
        if (mapM62685t.containsKey("GNU.sparse.map")) {
            arrayList = new ArrayList(C10071j.m62679n(mapM62685t.get("GNU.sparse.map")));
        }
        m62635z();
        if (this.f49108l == null) {
            throw new IOException("premature end of tar archive. Didn't find any entry after PAX header.");
        }
        m62630u(mapM62685t, arrayList);
        if (this.f49108l.m62558K()) {
            this.f49108l.m62594m0(C10071j.m62684s(((FilterInputStream) this).in, m62617C()));
        }
        m62631v();
    }

    /* renamed from: H */
    public final void m62622H() throws IOException {
        this.f49110n = C10071j.m62685t(this, this.f49111o, this.f49110n, this.f49104h);
        m62635z();
        if (this.f49108l == null) {
            throw new IOException("Error detected parsing the pax header");
        }
    }

    /* renamed from: I */
    public final void m62623I() throws IOException {
        C10068g c10068g;
        if (this.f49108l.m62548A()) {
            do {
                byte[] bArrM62616B = m62616B();
                if (bArrM62616B == null) {
                    throw new IOException("premature end of tar archive. Didn't find extended_header after header with extended flag.");
                }
                c10068g = new C10068g(bArrM62616B);
                this.f49108l.m62612x().addAll(c10068g.m62662a());
            } while (c10068g.m62663b());
        }
        m62631v();
    }

    /* renamed from: J */
    public byte[] m62624J() throws IOException {
        int iM68228b = C11376j.m68228b(((FilterInputStream) this).in, this.f49101e);
        m59754d(iM68228b);
        if (iM68228b != m62617C()) {
            return null;
        }
        return this.f49101e;
    }

    /* renamed from: V */
    public final int m62625V(byte[] bArr, int i10, int i11) throws IOException {
        List<InputStream> list = this.f49106j;
        if (list == null || list.isEmpty()) {
            return ((FilterInputStream) this).in.read(bArr, i10, i11);
        }
        if (this.f49107k >= this.f49106j.size()) {
            return -1;
        }
        int i12 = this.f49106j.get(this.f49107k).read(bArr, i10, i11);
        if (this.f49107k == this.f49106j.size() - 1) {
            return i12;
        }
        if (i12 == -1) {
            this.f49107k++;
            return m62625V(bArr, i10, i11);
        }
        if (i12 >= i11) {
            return i12;
        }
        this.f49107k++;
        int iM62625V = m62625V(bArr, i10 + i12, i11 - i12);
        return iM62625V == -1 ? i12 : i12 + iM62625V;
    }

    /* renamed from: X */
    public final void m62626X(boolean z10) {
        this.f49103g = z10;
    }

    /* renamed from: Y */
    public final void m62627Y() throws IOException {
        if (m62619E()) {
            return;
        }
        long j10 = this.f49104h;
        if (j10 <= 0 || j10 % m62617C() == 0) {
            return;
        }
        long jAvailable = ((FilterInputStream) this).in.available();
        long jM62617C = (((this.f49104h / m62617C()) + 1) * m62617C()) - this.f49104h;
        m59755j(m62633x(jAvailable, C11376j.m68232f(((FilterInputStream) this).in, jM62617C), jM62617C));
    }

    /* renamed from: Z */
    public final long m62628Z(long j10) throws IOException {
        List<InputStream> list = this.f49106j;
        if (list == null || list.isEmpty()) {
            return ((FilterInputStream) this).in.skip(j10);
        }
        long jSkip = 0;
        while (jSkip < j10 && this.f49107k < this.f49106j.size()) {
            jSkip += this.f49106j.get(this.f49107k).skip(j10 - jSkip);
            if (jSkip < j10) {
                this.f49107k++;
            }
        }
        return jSkip;
    }

    /* renamed from: a0 */
    public final void m62629a0() throws IOException {
        boolean zMarkSupported = ((FilterInputStream) this).in.markSupported();
        if (zMarkSupported) {
            ((FilterInputStream) this).in.mark(m62617C());
        }
        try {
            if ((!m62620F(m62624J())) && zMarkSupported) {
            }
        } finally {
            if (zMarkSupported) {
                m59757t(m62617C());
                ((FilterInputStream) this).in.reset();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (m62619E()) {
            return 0;
        }
        long jM62610v = this.f49108l.m62610v() - this.f49105i;
        if (jM62610v > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jM62610v;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        List<InputStream> list = this.f49106j;
        if (list != null) {
            Iterator<InputStream> it = list.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
        ((FilterInputStream) this).in.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        if (m62618D() || m62619E()) {
            return -1;
        }
        C10064c c10064c = this.f49108l;
        if (c10064c == null) {
            throw new IllegalStateException("No current tar entry");
        }
        if (this.f49105i >= c10064c.m62610v()) {
            return -1;
        }
        int iMin = Math.min(i11, available());
        int iM62625V = this.f49108l.m62561N() ? m62625V(bArr, i10, iMin) : ((FilterInputStream) this).in.read(bArr, i10, iMin);
        if (iM62625V != -1) {
            m59754d(iM62625V);
            this.f49105i += iM62625V;
        } else {
            if (iMin > 0) {
                throw new IOException("Truncated TAR archive");
            }
            m62626X(true);
        }
        return iM62625V;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        if (j10 <= 0 || m62619E()) {
            return 0L;
        }
        long jAvailable = ((FilterInputStream) this).in.available();
        long jMin = Math.min(j10, this.f49108l.m62610v() - this.f49105i);
        long jM62633x = !this.f49108l.m62561N() ? m62633x(jAvailable, C11376j.m68232f(((FilterInputStream) this).in, jMin), jMin) : m62628Z(jMin);
        m59755j(jM62633x);
        this.f49105i += jM62633x;
        return jM62633x;
    }

    /* renamed from: u */
    public final void m62630u(Map<String, String> map, List<C10070i> list) throws IOException {
        this.f49108l.m62602q0(map);
        this.f49108l.m62594m0(list);
    }

    /* renamed from: v */
    public final void m62631v() throws IOException {
        this.f49107k = -1;
        this.f49106j = new ArrayList();
        List<C10070i> listM62609u = this.f49108l.m62609u();
        C10069h c10069h = new C10069h();
        long jM62665b = 0;
        for (C10070i c10070i : listM62609u) {
            long jM62665b2 = c10070i.m62665b() - jM62665b;
            if (jM62665b2 < 0) {
                throw new IOException("Corrupted struct sparse detected");
            }
            if (jM62665b2 > 0) {
                this.f49106j.add(new C11369c(c10069h, c10070i.m62665b() - jM62665b));
            }
            if (c10070i.m62664a() > 0) {
                this.f49106j.add(new C11369c(((FilterInputStream) this).in, c10070i.m62664a()));
            }
            jM62665b = c10070i.m62665b() + c10070i.m62664a();
        }
        if (this.f49106j.isEmpty()) {
            return;
        }
        this.f49107k = 0;
    }

    /* renamed from: w */
    public final void m62632w() throws IOException {
        long jM59756s = m59756s() % this.f49102f;
        if (jM59756s > 0) {
            m59755j(C11376j.m68232f(((FilterInputStream) this).in, this.f49102f - jM59756s));
        }
    }

    /* renamed from: x */
    public final long m62633x(long j10, long j11, long j12) throws IOException {
        if (((FilterInputStream) this).in instanceof FileInputStream) {
            j11 = Math.min(j11, j10);
        }
        if (j11 == j12) {
            return j11;
        }
        throw new IOException("Truncated TAR archive");
    }

    /* renamed from: y */
    public byte[] m62634y() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i10 = read(this.f49100d);
            if (i10 < 0) {
                break;
            }
            byteArrayOutputStream.write(this.f49100d, 0, i10);
        }
        m62635z();
        if (this.f49108l == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        return length != byteArray.length ? Arrays.copyOf(byteArray, length) : byteArray;
    }

    /* renamed from: z */
    public C10064c m62635z() throws IOException {
        return m62615A();
    }

    public C10065d(InputStream inputStream, int i10, int i11) {
        this(inputStream, i10, i11, null);
    }

    public C10065d(InputStream inputStream, int i10, int i11, String str) {
        this(inputStream, i10, i11, str, false);
    }

    public C10065d(InputStream inputStream, int i10, int i11, String str, boolean z10) {
        super(inputStream, str);
        this.f49100d = new byte[256];
        this.f49110n = new HashMap();
        this.f49111o = new ArrayList();
        this.f49109m = AbstractC10361d.m63785b(str);
        this.f49101e = new byte[i11];
        this.f49102f = i10;
        this.f49112p = z10;
    }
}
