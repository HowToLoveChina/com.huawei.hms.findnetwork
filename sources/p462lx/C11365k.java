package p462lx;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import mx.C11549i;
import mx.C11550j;
import mx.C11551k;
import mx.C11556p;
import mx.C11557q;
import p376ix.C10631a;
import p409jx.C10952a;
import p409jx.C10956e;
import p409jx.EnumC10954c;
import p502nx.EnumC11762b;
import p502nx.EnumC11764d;
import p502nx.EnumC11765e;
import p594qx.C12424c;
import p594qx.C12426e;
import p594qx.C12427f;

/* renamed from: lx.k */
/* loaded from: classes9.dex */
public class C11365k extends OutputStream {

    /* renamed from: a */
    public C11358d f53079a;

    /* renamed from: b */
    public char[] f53080b;

    /* renamed from: c */
    public C11556p f53081c;

    /* renamed from: d */
    public AbstractC11357c f53082d;

    /* renamed from: e */
    public C11549i f53083e;

    /* renamed from: f */
    public C11550j f53084f;

    /* renamed from: l */
    public C11551k f53090l;

    /* renamed from: m */
    public boolean f53091m;

    /* renamed from: g */
    public C10952a f53085g = new C10952a();

    /* renamed from: h */
    public C10956e f53086h = new C10956e();

    /* renamed from: i */
    public CRC32 f53087i = new CRC32();

    /* renamed from: j */
    public C12426e f53088j = new C12426e();

    /* renamed from: k */
    public long f53089k = 0;

    /* renamed from: n */
    public boolean f53092n = true;

    public C11365k(OutputStream outputStream, char[] cArr, C11551k c11551k, C11556p c11556p) throws IOException {
        if (c11551k.m68929a() < 512) {
            throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        C11358d c11358d = new C11358d(outputStream);
        this.f53079a = c11358d;
        this.f53080b = cArr;
        this.f53090l = c11551k;
        this.f53081c = m68201y(c11556p, c11358d);
        this.f53091m = false;
        m68193D();
    }

    /* renamed from: A */
    public final void m68190A() throws IOException {
        this.f53089k = 0L;
        this.f53087i.reset();
        this.f53082d.close();
    }

    /* renamed from: B */
    public final void m68191B(C11557q c11557q) {
        if (C12427f.m74617g(c11557q.m69000k())) {
            throw new IllegalArgumentException("fileNameInZip is null or empty");
        }
        if (c11557q.m68993d() == EnumC11764d.STORE && c11557q.m68997h() < 0 && !C12424c.m74593u(c11557q.m69000k()) && c11557q.m69010u()) {
            throw new IllegalArgumentException("uncompressed size should be set for zip entries of compression type store");
        }
    }

    /* renamed from: C */
    public final boolean m68192C(C11549i c11549i) {
        if (c11549i.m68879r() && c11549i.m68868g().equals(EnumC11765e.AES)) {
            return c11549i.m68864c().m68844d().equals(EnumC11762b.ONE);
        }
        return true;
    }

    /* renamed from: D */
    public final void m68193D() throws IOException {
        if (this.f53079a.m68178x()) {
            this.f53088j.m74605j(this.f53079a, (int) EnumC10954c.SPLIT_ZIP.m66102b());
        }
    }

    /* renamed from: b */
    public final C11557q m68194b(C11557q c11557q) {
        C11557q c11557q2 = new C11557q(c11557q);
        if (C12424c.m74593u(c11557q.m69000k())) {
            c11557q2.m68989F(false);
            c11557q2.m69012w(EnumC11764d.STORE);
            c11557q2.m69014y(false);
            c11557q2.m68985B(0L);
        }
        if (c11557q.m69001l() <= 0) {
            c11557q2.m68988E(System.currentTimeMillis());
        }
        return c11557q2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f53092n) {
            m68195s();
        }
        this.f53081c.m68968d().m68904n(this.f53079a.m68175u());
        this.f53086h.m66111d(this.f53081c, this.f53079a, this.f53090l.m68930b());
        this.f53079a.close();
        this.f53091m = true;
    }

    /* renamed from: s */
    public C11549i m68195s() throws IOException {
        this.f53082d.mo68170s();
        long jM68171t = this.f53082d.m68171t();
        this.f53083e.m68882u(jM68171t);
        this.f53084f.m68882u(jM68171t);
        this.f53083e.m68861I(this.f53089k);
        this.f53084f.m68861I(this.f53089k);
        if (m68192C(this.f53083e)) {
            this.f53083e.m68884w(this.f53087i.getValue());
            this.f53084f.m68884w(this.f53087i.getValue());
        }
        this.f53081c.m68969f().add(this.f53084f);
        this.f53081c.m68967c().m68888a().add(this.f53083e);
        if (this.f53084f.m68878q()) {
            this.f53086h.m66121n(this.f53084f, this.f53079a);
        }
        m68190A();
        this.f53092n = true;
        return this.f53083e;
    }

    /* renamed from: t */
    public final void m68196t() throws IOException {
        if (this.f53091m) {
            throw new IOException("Stream is closed");
        }
    }

    /* renamed from: u */
    public final void m68197u(C11557q c11557q) throws IOException {
        C11549i c11549iM66079d = this.f53085g.m66079d(c11557q, this.f53079a.m68178x(), this.f53079a.mo68173s(), this.f53090l.m68930b(), this.f53088j);
        this.f53083e = c11549iM66079d;
        c11549iM66079d.m68925W(this.f53079a.m68176v());
        C11550j c11550jM66081f = this.f53085g.m66081f(this.f53083e);
        this.f53084f = c11550jM66081f;
        this.f53086h.m66123p(this.f53081c, c11550jM66081f, this.f53079a, this.f53090l.m68930b());
    }

    /* renamed from: v */
    public final AbstractC11356b<?> m68198v(C11364j c11364j, C11557q c11557q) throws IOException {
        if (!c11557q.m69004o()) {
            return new C11360f(c11364j, c11557q, null);
        }
        char[] cArr = this.f53080b;
        if (cArr == null || cArr.length == 0) {
            throw new C10631a("password not set");
        }
        if (c11557q.m68995f() == EnumC11765e.AES) {
            return new C11355a(c11364j, c11557q, this.f53080b, this.f53090l.m68931c());
        }
        if (c11557q.m68995f() == EnumC11765e.ZIP_STANDARD) {
            return new C11366l(c11364j, c11557q, this.f53080b, this.f53090l.m68931c());
        }
        EnumC11765e enumC11765eM68995f = c11557q.m68995f();
        EnumC11765e enumC11765e = EnumC11765e.ZIP_STANDARD_VARIANT_STRONG;
        if (enumC11765eM68995f != enumC11765e) {
            throw new C10631a("Invalid encryption method");
        }
        throw new C10631a(enumC11765e + " encryption method is not supported");
    }

    /* renamed from: w */
    public final AbstractC11357c m68199w(AbstractC11356b<?> abstractC11356b, C11557q c11557q) {
        return c11557q.m68993d() == EnumC11764d.DEFLATE ? new C11359e(abstractC11356b, c11557q.m68992c(), this.f53090l.m68929a()) : new C11363i(abstractC11356b);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10});
    }

    /* renamed from: x */
    public final AbstractC11357c m68200x(C11557q c11557q) throws IOException {
        return m68199w(m68198v(new C11364j(this.f53079a), c11557q), c11557q);
    }

    /* renamed from: y */
    public final C11556p m68201y(C11556p c11556p, C11358d c11358d) {
        if (c11556p == null) {
            c11556p = new C11556p();
        }
        if (c11358d.m68178x()) {
            c11556p.m68978p(true);
            c11556p.m68979q(c11358d.m68177w());
        }
        return c11556p;
    }

    /* renamed from: z */
    public void m68202z(C11557q c11557q) throws IOException {
        m68191B(c11557q);
        C11557q c11557qM68194b = m68194b(c11557q);
        m68197u(c11557qM68194b);
        this.f53082d = m68200x(c11557qM68194b);
        this.f53092n = false;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        m68196t();
        this.f53087i.update(bArr, i10, i11);
        this.f53082d.write(bArr, i10, i11);
        this.f53089k += i11;
    }
}
