package p409jx;

import com.huawei.hms.network.embedded.C6144wb;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mx.AbstractC11542b;
import mx.C11541a;
import mx.C11544d;
import mx.C11545e;
import mx.C11546f;
import mx.C11548h;
import mx.C11549i;
import mx.C11551k;
import mx.C11552l;
import mx.C11553m;
import mx.C11554n;
import mx.C11556p;
import p376ix.C10631a;
import p437kx.C11200a;
import p502nx.EnumC11761a;
import p502nx.EnumC11762b;
import p502nx.EnumC11764d;
import p502nx.EnumC11765e;
import p594qx.C12422a;
import p594qx.C12425d;
import p594qx.C12426e;

/* renamed from: jx.b */
/* loaded from: classes9.dex */
public class C10953b {

    /* renamed from: a */
    public C11556p f51862a;

    /* renamed from: b */
    public final C12426e f51863b = new C12426e();

    /* renamed from: c */
    public final byte[] f51864c = new byte[4];

    /* renamed from: a */
    public final long m66083a(C11556p c11556p) {
        return c11556p.m68975m() ? c11556p.m68972j().m68943h() : c11556p.m68968d().m68898h();
    }

    /* renamed from: b */
    public boolean m66084b(byte[] bArr, String str) {
        byte b10 = bArr[0];
        if (b10 != 0 && C12422a.m74569a(b10, 4)) {
            return true;
        }
        byte b11 = bArr[3];
        if (b11 != 0 && C12422a.m74569a(b11, 6)) {
            return true;
        }
        if (str != null) {
            return str.endsWith("/") || str.endsWith("\\");
        }
        return false;
    }

    /* renamed from: c */
    public final long m66085c(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new C10631a("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j10 = length - 22;
        m66100r(randomAccessFile, j10);
        return ((long) this.f51863b.m74596a(randomAccessFile)) == EnumC10954c.END_OF_CENTRAL_DIRECTORY.m66102b() ? j10 : m66086d(randomAccessFile);
    }

    /* renamed from: d */
    public final long m66086d(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = C6144wb.f28903a;
        if (length2 < C6144wb.f28903a) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            m66100r(randomAccessFile, length);
            if (this.f51863b.m74596a(randomAccessFile) == EnumC10954c.END_OF_CENTRAL_DIRECTORY.m66102b()) {
                return length;
            }
            length3--;
        }
        throw new C10631a("Zip headers not found. Probably not a zip file");
    }

    /* renamed from: e */
    public final List<C11548h> m66087e(byte[] bArr, int i10) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < i10) {
            C11548h c11548h = new C11548h();
            c11548h.m68912g(this.f51863b.m74603h(bArr, i11));
            int iM74603h = this.f51863b.m74603h(bArr, i11 + 2);
            c11548h.m68913h(iM74603h);
            int i12 = i11 + 4;
            if (iM74603h > 0) {
                byte[] bArr2 = new byte[iM74603h];
                System.arraycopy(bArr, i12, bArr2, 0, iM74603h);
                c11548h.m68911f(bArr2);
            }
            i11 = i12 + iM74603h;
            arrayList.add(c11548h);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    /* renamed from: f */
    public final C11541a m66088f(List<C11548h> list, C12426e c12426e) throws C10631a {
        if (list == null) {
            return null;
        }
        for (C11548h c11548h : list) {
            if (c11548h != null) {
                long jM68909d = c11548h.m68909d();
                EnumC10954c enumC10954c = EnumC10954c.AES_EXTRA_DATA_RECORD;
                if (jM68909d == enumC10954c.m66102b()) {
                    byte[] bArrM68908c = c11548h.m68908c();
                    if (bArrM68908c == null || bArrM68908c.length != 7) {
                        throw new C10631a("corrupt AES extra data records");
                    }
                    C11541a c11541a = new C11541a();
                    c11541a.m68966b(enumC10954c);
                    c11541a.m68851k(c11548h.m68910e());
                    byte[] bArrM68908c2 = c11548h.m68908c();
                    c11541a.m68849i(EnumC11762b.m70090b(c12426e.m74603h(bArrM68908c2, 0)));
                    byte[] bArr = new byte[2];
                    System.arraycopy(bArrM68908c2, 2, bArr, 0, 2);
                    c11541a.m68852l(new String(bArr));
                    c11541a.m68848h(EnumC11761a.m70085b(bArrM68908c2[4] & 255));
                    c11541a.m68850j(EnumC11764d.m70093e(c12426e.m74603h(bArrM68908c2, 5)));
                    return c11541a;
                }
            }
        }
        return null;
    }

    /* renamed from: g */
    public final void m66089g(AbstractC11542b abstractC11542b, C12426e c12426e) throws C10631a {
        C11541a c11541aM66088f;
        if (abstractC11542b.m68869h() == null || abstractC11542b.m68869h().size() <= 0 || (c11541aM66088f = m66088f(abstractC11542b.m68869h(), c12426e)) == null) {
            return;
        }
        abstractC11542b.m68881t(c11541aM66088f);
        abstractC11542b.m68853A(EnumC11765e.AES);
    }

    /* renamed from: h */
    public C11556p m66090h(RandomAccessFile randomAccessFile, C11551k c11551k) throws IOException {
        if (randomAccessFile.length() == 0) {
            return new C11556p();
        }
        if (randomAccessFile.length() < 22) {
            throw new C10631a("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
        C11556p c11556p = new C11556p();
        this.f51862a = c11556p;
        try {
            c11556p.m68977o(m66092j(randomAccessFile, this.f51863b, c11551k));
            if (this.f51862a.m68968d().m68898h() == 0) {
                return this.f51862a;
            }
            C11556p c11556p2 = this.f51862a;
            c11556p2.m68980r(m66096n(randomAccessFile, this.f51863b, c11556p2.m68968d().m68896f()));
            if (this.f51862a.m68975m()) {
                this.f51862a.m68981s(m66095m(randomAccessFile, this.f51863b));
                if (this.f51862a.m68972j() == null || this.f51862a.m68972j().m68938c() <= 0) {
                    this.f51862a.m68978p(false);
                } else {
                    this.f51862a.m68978p(true);
                }
            }
            this.f51862a.m68976n(m66091i(randomAccessFile, this.f51863b, c11551k.m68930b()));
            return this.f51862a;
        } catch (C10631a e10) {
            throw e10;
        } catch (IOException e11) {
            e11.printStackTrace();
            throw new C10631a("Zip headers not found. Probably not a zip file or a corrupted zip file", e11);
        }
    }

    /* renamed from: i */
    public final C11544d m66091i(RandomAccessFile randomAccessFile, C12426e c12426e, Charset charset) throws IOException {
        C11544d c11544d = new C11544d();
        ArrayList arrayList = new ArrayList();
        long jM66107e = C10955d.m66107e(this.f51862a);
        long jM66083a = m66083a(this.f51862a);
        randomAccessFile.seek(jM66107e);
        int i10 = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i11 = 0;
        int i12 = 0;
        while (i12 < jM66083a) {
            C11549i c11549i = new C11549i();
            byte[] bArr3 = bArr2;
            long jM74596a = c12426e.m74596a(randomAccessFile);
            EnumC10954c enumC10954c = EnumC10954c.CENTRAL_DIRECTORY;
            if (jM74596a != enumC10954c.m66102b()) {
                throw new C10631a("Expected central directory entry not found (#" + (i12 + 1) + ")");
            }
            c11549i.m68966b(enumC10954c);
            c11549i.m68926X(c12426e.m74602g(randomAccessFile));
            c11549i.m68862J(c12426e.m74602g(randomAccessFile));
            byte[] bArr4 = new byte[i10];
            randomAccessFile.readFully(bArr4);
            c11549i.m68887z(C12422a.m74569a(bArr4[i11], i11));
            c11549i.m68885x(C12422a.m74569a(bArr4[i11], 3));
            c11549i.m68858F(C12422a.m74569a(bArr4[1], 3));
            c11549i.m68859G((byte[]) bArr4.clone());
            c11549i.m68883v(EnumC11764d.m70093e(c12426e.m74602g(randomAccessFile)));
            c11549i.m68860H(c12426e.m74596a(randomAccessFile));
            randomAccessFile.readFully(bArr3);
            c11549i.m68884w(c12426e.m74601f(bArr3, i11));
            int i13 = i12;
            c11549i.m68882u(c12426e.m74600e(randomAccessFile, 4));
            c11549i.m68861I(c12426e.m74600e(randomAccessFile, 4));
            int iM74602g = c12426e.m74602g(randomAccessFile);
            c11549i.m68857E(iM74602g);
            c11549i.m68855C(c12426e.m74602g(randomAccessFile));
            int iM74602g2 = c12426e.m74602g(randomAccessFile);
            c11549i.m68923U(iM74602g2);
            c11549i.m68920R(c12426e.m74602g(randomAccessFile));
            randomAccessFile.readFully(bArr);
            c11549i.m68924V((byte[]) bArr.clone());
            randomAccessFile.readFully(bArr3);
            c11549i.m68921S((byte[]) bArr3.clone());
            randomAccessFile.readFully(bArr3);
            long j10 = jM66083a;
            byte[] bArr5 = bArr;
            c11549i.m68925W(c12426e.m74601f(bArr3, 0));
            if (iM74602g <= 0) {
                throw new C10631a("Invalid entry name in file header");
            }
            byte[] bArr6 = new byte[iM74602g];
            randomAccessFile.readFully(bArr6);
            c11549i.m68856D(C10955d.m66103a(bArr6, c11549i.m68880s(), charset));
            c11549i.m68886y(m66084b(c11549i.m68916N(), c11549i.m68871j()));
            m66094l(randomAccessFile, c11549i);
            m66098p(c11549i, c12426e);
            m66089g(c11549i, c12426e);
            if (iM74602g2 > 0) {
                byte[] bArr7 = new byte[iM74602g2];
                randomAccessFile.readFully(bArr7);
                c11549i.m68922T(C10955d.m66103a(bArr7, c11549i.m68880s(), charset));
            }
            if (c11549i.m68879r()) {
                if (c11549i.m68864c() != null) {
                    c11549i.m68853A(EnumC11765e.AES);
                } else {
                    c11549i.m68853A(EnumC11765e.ZIP_STANDARD);
                }
            }
            arrayList.add(c11549i);
            bArr2 = bArr3;
            i11 = 0;
            i10 = 2;
            i12 = i13 + 1;
            bArr = bArr5;
            jM66083a = j10;
        }
        c11544d.m68889b(arrayList);
        C11545e c11545e = new C11545e();
        long jM74596a2 = c12426e.m74596a(randomAccessFile);
        EnumC10954c enumC10954c2 = EnumC10954c.DIGITAL_SIGNATURE;
        if (jM74596a2 == enumC10954c2.m66102b()) {
            c11545e.m68966b(enumC10954c2);
            c11545e.m68892e(c12426e.m74602g(randomAccessFile));
            if (c11545e.m68890c() > 0) {
                byte[] bArr8 = new byte[c11545e.m68890c()];
                randomAccessFile.readFully(bArr8);
                c11545e.m68891d(new String(bArr8));
            }
        }
        return c11544d;
    }

    /* renamed from: j */
    public final C11546f m66092j(RandomAccessFile randomAccessFile, C12426e c12426e, C11551k c11551k) throws IOException {
        long jM66085c = m66085c(randomAccessFile);
        m66100r(randomAccessFile, 4 + jM66085c);
        C11546f c11546f = new C11546f();
        c11546f.m68966b(EnumC10954c.END_OF_CENTRAL_DIRECTORY);
        c11546f.m68901k(c12426e.m74602g(randomAccessFile));
        c11546f.m68902l(c12426e.m74602g(randomAccessFile));
        c11546f.m68907q(c12426e.m74602g(randomAccessFile));
        c11546f.m68906p(c12426e.m74602g(randomAccessFile));
        c11546f.m68905o(c12426e.m74596a(randomAccessFile));
        c11546f.m68903m(jM66085c);
        randomAccessFile.readFully(this.f51864c);
        c11546f.m68904n(c12426e.m74601f(this.f51864c, 0));
        c11546f.m68900j(m66099q(randomAccessFile, c12426e.m74602g(randomAccessFile), c11551k.m68930b()));
        this.f51862a.m68978p(c11546f.m68894d() > 0);
        return c11546f;
    }

    /* renamed from: k */
    public final List<C11548h> m66093k(RandomAccessFile randomAccessFile, int i10) throws IOException {
        if (i10 < 4) {
            if (i10 <= 0) {
                return null;
            }
            randomAccessFile.skipBytes(i10);
            return null;
        }
        byte[] bArr = new byte[i10];
        randomAccessFile.read(bArr);
        try {
            return m66087e(bArr, i10);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: l */
    public final void m66094l(RandomAccessFile randomAccessFile, C11549i c11549i) throws IOException {
        int iM68870i = c11549i.m68870i();
        if (iM68870i <= 0) {
            return;
        }
        c11549i.m68854B(m66093k(randomAccessFile, iM68870i));
    }

    /* renamed from: m */
    public final C11553m m66095m(RandomAccessFile randomAccessFile, C12426e c12426e) throws IOException {
        if (this.f51862a.m68971i() == null) {
            throw new C10631a("invalid zip64 end of central directory locator");
        }
        long jM68933d = this.f51862a.m68971i().m68933d();
        if (jM68933d < 0) {
            throw new C10631a("invalid offset for start of end of central directory record");
        }
        randomAccessFile.seek(jM68933d);
        C11553m c11553m = new C11553m();
        long jM74596a = c12426e.m74596a(randomAccessFile);
        EnumC10954c enumC10954c = EnumC10954c.ZIP64_END_CENTRAL_DIRECTORY_RECORD;
        if (jM74596a != enumC10954c.m66102b()) {
            throw new C10631a("invalid signature for zip64 end of central directory record");
        }
        c11553m.m68966b(enumC10954c);
        c11553m.m68952q(c12426e.m74599d(randomAccessFile));
        c11553m.m68955t(c12426e.m74602g(randomAccessFile));
        c11553m.m68956u(c12426e.m74602g(randomAccessFile));
        c11553m.m68948m(c12426e.m74596a(randomAccessFile));
        c11553m.m68949n(c12426e.m74596a(randomAccessFile));
        c11553m.m68954s(c12426e.m74599d(randomAccessFile));
        c11553m.m68953r(c12426e.m74599d(randomAccessFile));
        c11553m.m68951p(c12426e.m74599d(randomAccessFile));
        c11553m.m68950o(c12426e.m74599d(randomAccessFile));
        long jM68942g = c11553m.m68942g() - 44;
        if (jM68942g > 0) {
            byte[] bArr = new byte[(int) jM68942g];
            randomAccessFile.readFully(bArr);
            c11553m.m68947l(bArr);
        }
        return c11553m;
    }

    /* renamed from: n */
    public final C11552l m66096n(RandomAccessFile randomAccessFile, C12426e c12426e, long j10) throws IOException {
        C11552l c11552l = new C11552l();
        m66101s(randomAccessFile, j10);
        long jM74596a = c12426e.m74596a(randomAccessFile);
        EnumC10954c enumC10954c = EnumC10954c.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR;
        if (jM74596a != enumC10954c.m66102b()) {
            this.f51862a.m68982t(false);
            return null;
        }
        this.f51862a.m68982t(true);
        c11552l.m68966b(enumC10954c);
        c11552l.m68935f(c12426e.m74596a(randomAccessFile));
        c11552l.m68936g(c12426e.m74599d(randomAccessFile));
        c11552l.m68937h(c12426e.m74596a(randomAccessFile));
        return c11552l;
    }

    /* renamed from: o */
    public final C11554n m66097o(List<C11548h> list, C12426e c12426e, long j10, long j11, long j12, int i10) {
        for (C11548h c11548h : list) {
            if (c11548h != null && EnumC10954c.ZIP64_EXTRA_FIELD_SIGNATURE.m66102b() == c11548h.m68909d()) {
                C11554n c11554n = new C11554n();
                byte[] bArrM68908c = c11548h.m68908c();
                if (c11548h.m68910e() <= 0) {
                    return null;
                }
                int i11 = 0;
                if (c11548h.m68910e() > 0 && j10 == 4294967295L) {
                    c11554n.m68964j(c12426e.m74601f(bArrM68908c, 0));
                    i11 = 8;
                }
                if (i11 < c11548h.m68910e() && j11 == 4294967295L) {
                    c11554n.m68961g(c12426e.m74601f(bArrM68908c, i11));
                    i11 += 8;
                }
                if (i11 < c11548h.m68910e() && j12 == 4294967295L) {
                    c11554n.m68963i(c12426e.m74601f(bArrM68908c, i11));
                    i11 += 8;
                }
                if (i11 < c11548h.m68910e() && i10 == 65535) {
                    c11554n.m68962h(c12426e.m74598c(bArrM68908c, i11));
                }
                return c11554n;
            }
        }
        return null;
    }

    /* renamed from: p */
    public final void m66098p(C11549i c11549i, C12426e c12426e) {
        C11554n c11554nM66097o;
        if (c11549i.m68869h() == null || c11549i.m68869h().size() <= 0 || (c11554nM66097o = m66097o(c11549i.m68869h(), c12426e, c11549i.m68875n(), c11549i.m68865d(), c11549i.m68918P(), c11549i.m68915M())) == null) {
            return;
        }
        c11549i.m68863K(c11554nM66097o);
        if (c11554nM66097o.m68960f() != -1) {
            c11549i.m68861I(c11554nM66097o.m68960f());
        }
        if (c11554nM66097o.m68957c() != -1) {
            c11549i.m68882u(c11554nM66097o.m68957c());
        }
        if (c11554nM66097o.m68959e() != -1) {
            c11549i.m68925W(c11554nM66097o.m68959e());
        }
        if (c11554nM66097o.m68958d() != -1) {
            c11549i.m68920R(c11554nM66097o.m68958d());
        }
    }

    /* renamed from: q */
    public final String m66099q(RandomAccessFile randomAccessFile, int i10, Charset charset) throws IOException {
        if (i10 <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i10];
            randomAccessFile.readFully(bArr);
            if (charset == null) {
                charset = C12425d.f57266c;
            }
            return C10955d.m66103a(bArr, false, charset);
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: r */
    public final void m66100r(RandomAccessFile randomAccessFile, long j10) throws IOException {
        if (randomAccessFile instanceof C11200a) {
            ((C11200a) randomAccessFile).m67212u(j10);
        } else {
            randomAccessFile.seek(j10);
        }
    }

    /* renamed from: s */
    public final void m66101s(RandomAccessFile randomAccessFile, long j10) throws IOException {
        m66100r(randomAccessFile, j10 - 20);
    }
}
