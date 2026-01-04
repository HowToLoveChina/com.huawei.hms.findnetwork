package p409jx;

import com.huawei.hms.network.embedded.C6130va;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import mx.C11541a;
import mx.C11548h;
import mx.C11549i;
import mx.C11550j;
import mx.C11552l;
import mx.C11553m;
import mx.C11556p;
import p376ix.C10631a;
import p462lx.C11358d;
import p462lx.C11362h;
import p462lx.InterfaceC11361g;
import p594qx.C12424c;
import p594qx.C12426e;
import p594qx.C12427f;

/* renamed from: jx.e */
/* loaded from: classes9.dex */
public class C10956e {

    /* renamed from: a */
    public final C12426e f51879a = new C12426e();

    /* renamed from: b */
    public final byte[] f51880b = new byte[8];

    /* renamed from: c */
    public final byte[] f51881c = new byte[4];

    /* renamed from: a */
    public final C11553m m66108a(C11556p c11556p, int i10, long j10) throws C10631a {
        C11553m c11553m = new C11553m();
        c11553m.m68966b(EnumC10954c.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
        c11553m.m68952q(44L);
        if (c11556p.m68967c() != null && c11556p.m68967c().m68888a() != null && c11556p.m68967c().m68888a().size() > 0) {
            C11549i c11549i = c11556p.m68967c().m68888a().get(0);
            c11553m.m68955t(c11549i.m68919Q());
            c11553m.m68956u(c11549i.m68876o());
        }
        c11553m.m68948m(c11556p.m68968d().m68894d());
        c11553m.m68949n(c11556p.m68968d().m68895e());
        long size = c11556p.m68967c().m68888a().size();
        c11553m.m68954s(c11556p.m68974l() ? m66110c(c11556p.m68967c().m68888a(), c11556p.m68968d().m68894d()) : size);
        c11553m.m68953r(size);
        c11553m.m68951p(i10);
        c11553m.m68950o(j10);
        return c11553m;
    }

    /* renamed from: b */
    public final int m66109b(C11549i c11549i, boolean z10) {
        int iM68910e = z10 ? 32 : 0;
        if (c11549i.m68864c() != null) {
            iM68910e += 11;
        }
        if (c11549i.m68869h() != null) {
            for (C11548h c11548h : c11549i.m68869h()) {
                if (c11548h.m68909d() != EnumC10954c.AES_EXTRA_DATA_RECORD.m66102b() && c11548h.m68909d() != EnumC10954c.ZIP64_EXTRA_FIELD_SIGNATURE.m66102b()) {
                    iM68910e += c11548h.m68910e() + 4;
                }
            }
        }
        return iM68910e;
    }

    /* renamed from: c */
    public final long m66110c(List<C11549i> list, int i10) throws C10631a {
        if (list == null) {
            throw new C10631a("file headers are null, cannot calculate number of entries on this disk");
        }
        Iterator<C11549i> it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (it.next().m68915M() == i10) {
                i11++;
            }
        }
        return i11;
    }

    /* renamed from: d */
    public void m66111d(C11556p c11556p, OutputStream outputStream, Charset charset) throws IOException {
        if (c11556p == null || outputStream == null) {
            throw new C10631a("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m66116i(c11556p, outputStream);
            long jM66113f = m66113f(c11556p);
            m66119l(c11556p, byteArrayOutputStream, this.f51879a, charset);
            int size = byteArrayOutputStream.size();
            if (c11556p.m68975m() || jM66113f >= 4294967295L || c11556p.m68967c().m68888a().size() >= 65535) {
                if (c11556p.m68972j() == null) {
                    c11556p.m68981s(new C11553m());
                }
                if (c11556p.m68971i() == null) {
                    c11556p.m68980r(new C11552l());
                }
                c11556p.m68971i().m68936g(size + jM66113f);
                if (m66114g(outputStream)) {
                    int iM66112e = m66112e(outputStream);
                    c11556p.m68971i().m68935f(iM66112e);
                    c11556p.m68971i().m68937h(iM66112e + 1);
                } else {
                    c11556p.m68971i().m68935f(0);
                    c11556p.m68971i().m68937h(1);
                }
                C11553m c11553mM66108a = m66108a(c11556p, size, jM66113f);
                c11556p.m68981s(c11553mM66108a);
                m66126s(c11553mM66108a, byteArrayOutputStream, this.f51879a);
                m66125r(c11556p.m68971i(), byteArrayOutputStream, this.f51879a);
            }
            m66120m(c11556p, size, jM66113f, byteArrayOutputStream, this.f51879a, charset);
            m66127t(c11556p, outputStream, byteArrayOutputStream.toByteArray(), charset);
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: e */
    public final int m66112e(OutputStream outputStream) {
        return outputStream instanceof C11362h ? ((C11362h) outputStream).mo68173s() : ((C11358d) outputStream).mo68173s();
    }

    /* renamed from: f */
    public final long m66113f(C11556p c11556p) {
        return (!c11556p.m68975m() || c11556p.m68972j() == null || c11556p.m68972j().m68940e() == -1) ? c11556p.m68968d().m68897g() : c11556p.m68972j().m68940e();
    }

    /* renamed from: g */
    public final boolean m66114g(OutputStream outputStream) {
        if (outputStream instanceof C11362h) {
            return ((C11362h) outputStream).m68185x();
        }
        if (outputStream instanceof C11358d) {
            return ((C11358d) outputStream).m68178x();
        }
        return false;
    }

    /* renamed from: h */
    public final boolean m66115h(C11549i c11549i) {
        return c11549i.m68865d() >= 4294967295L || c11549i.m68875n() >= 4294967295L || c11549i.m68918P() >= 4294967295L || c11549i.m68915M() >= 65535;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public final void m66116i(C11556p c11556p, OutputStream outputStream) throws IOException {
        int iMo68173s;
        if (outputStream instanceof InterfaceC11361g) {
            InterfaceC11361g interfaceC11361g = (InterfaceC11361g) outputStream;
            c11556p.m68968d().m68904n(interfaceC11361g.mo68174t());
            iMo68173s = interfaceC11361g.mo68173s();
        } else {
            iMo68173s = 0;
        }
        if (c11556p.m68975m()) {
            if (c11556p.m68972j() == null) {
                c11556p.m68981s(new C11553m());
            }
            if (c11556p.m68971i() == null) {
                c11556p.m68980r(new C11552l());
            }
            c11556p.m68972j().m68950o(c11556p.m68968d().m68897g());
            c11556p.m68971i().m68935f(iMo68173s);
            c11556p.m68971i().m68937h(iMo68173s + 1);
        }
        c11556p.m68968d().m68901k(iMo68173s);
        c11556p.m68968d().m68902l(iMo68173s);
    }

    /* renamed from: j */
    public final void m66117j(C11362h c11362h, C11549i c11549i) throws IOException {
        if (c11549i.m68875n() < 4294967295L) {
            this.f51879a.m74608m(this.f51880b, 0, c11549i.m68865d());
            c11362h.write(this.f51880b, 0, 4);
            this.f51879a.m74608m(this.f51880b, 0, c11549i.m68875n());
            c11362h.write(this.f51880b, 0, 4);
            return;
        }
        this.f51879a.m74608m(this.f51880b, 0, 4294967295L);
        c11362h.write(this.f51880b, 0, 4);
        c11362h.write(this.f51880b, 0, 4);
        int iM68872k = c11549i.m68872k() + 8;
        if (c11362h.m68186y(iM68872k) == iM68872k) {
            this.f51879a.m74607l(c11362h, c11549i.m68875n());
            this.f51879a.m74607l(c11362h, c11549i.m68865d());
        } else {
            throw new C10631a("Unable to skip " + iM68872k + " bytes to update LFH");
        }
    }

    /* renamed from: k */
    public void m66118k(C11549i c11549i, C11556p c11556p, C11362h c11362h) throws IOException {
        C11362h c11362h2;
        boolean z10;
        String str;
        String str2;
        if (c11549i == null || c11556p == null) {
            throw new C10631a("invalid input parameters, cannot update local file header");
        }
        if (c11549i.m68915M() != c11362h.mo68173s()) {
            String parent = c11556p.m68973k().getParent();
            String strM74587o = C12424c.m74587o(c11556p.m68973k().getName());
            if (parent != null) {
                str = parent + System.getProperty("file.separator");
            } else {
                str = "";
            }
            z10 = true;
            if (c11549i.m68915M() < 9) {
                str2 = str + strM74587o + ".z0" + (c11549i.m68915M() + 1);
            } else {
                str2 = str + strM74587o + ".z" + (c11549i.m68915M() + 1);
            }
            c11362h2 = new C11362h(new File(str2));
        } else {
            c11362h2 = c11362h;
            z10 = false;
        }
        long jMo68174t = c11362h2.mo68174t();
        c11362h2.seek(c11549i.m68918P() + 14);
        this.f51879a.m74608m(this.f51880b, 0, c11549i.m68867f());
        c11362h2.write(this.f51880b, 0, 4);
        m66117j(c11362h2, c11549i);
        if (z10) {
            c11362h2.close();
        } else {
            c11362h.seek(jMo68174t);
        }
    }

    /* renamed from: l */
    public final void m66119l(C11556p c11556p, ByteArrayOutputStream byteArrayOutputStream, C12426e c12426e, Charset charset) throws IOException {
        if (c11556p.m68967c() == null || c11556p.m68967c().m68888a() == null || c11556p.m68967c().m68888a().size() <= 0) {
            return;
        }
        Iterator<C11549i> it = c11556p.m68967c().m68888a().iterator();
        while (it.hasNext()) {
            m66122o(c11556p, it.next(), byteArrayOutputStream, c12426e, charset);
        }
    }

    /* renamed from: m */
    public final void m66120m(C11556p c11556p, int i10, long j10, ByteArrayOutputStream byteArrayOutputStream, C12426e c12426e, Charset charset) throws IOException {
        byte[] bArr = new byte[8];
        c12426e.m74605j(byteArrayOutputStream, (int) EnumC10954c.END_OF_CENTRAL_DIRECTORY.m66102b());
        c12426e.m74609n(byteArrayOutputStream, c11556p.m68968d().m68894d());
        c12426e.m74609n(byteArrayOutputStream, c11556p.m68968d().m68895e());
        long size = c11556p.m68967c().m68888a().size();
        long jM66110c = c11556p.m68974l() ? m66110c(c11556p.m68967c().m68888a(), c11556p.m68968d().m68894d()) : size;
        if (jM66110c > C6130va.f28792s) {
            jM66110c = 65535;
        }
        c12426e.m74609n(byteArrayOutputStream, (int) jM66110c);
        if (size > C6130va.f28792s) {
            size = 65535;
        }
        c12426e.m74609n(byteArrayOutputStream, (int) size);
        c12426e.m74605j(byteArrayOutputStream, i10);
        if (j10 > 4294967295L) {
            c12426e.m74608m(bArr, 0, 4294967295L);
            byteArrayOutputStream.write(bArr, 0, 4);
        } else {
            c12426e.m74608m(bArr, 0, j10);
            byteArrayOutputStream.write(bArr, 0, 4);
        }
        String strM68893c = c11556p.m68968d().m68893c();
        if (!C12427f.m74616f(strM68893c)) {
            c12426e.m74609n(byteArrayOutputStream, 0);
            return;
        }
        byte[] bArrM66104b = C10955d.m66104b(strM68893c, charset);
        c12426e.m74609n(byteArrayOutputStream, bArrM66104b.length);
        byteArrayOutputStream.write(bArrM66104b);
    }

    /* renamed from: n */
    public void m66121n(C11550j c11550j, OutputStream outputStream) throws IOException {
        if (c11550j == null || outputStream == null) {
            throw new C10631a("input parameters is null, cannot write extended local header");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f51879a.m74605j(byteArrayOutputStream, (int) EnumC10954c.EXTRA_DATA_RECORD.m66102b());
            this.f51879a.m74608m(this.f51880b, 0, c11550j.m68867f());
            byteArrayOutputStream.write(this.f51880b, 0, 4);
            if (c11550j.m68927L()) {
                this.f51879a.m74607l(byteArrayOutputStream, c11550j.m68865d());
                this.f51879a.m74607l(byteArrayOutputStream, c11550j.m68875n());
            } else {
                this.f51879a.m74608m(this.f51880b, 0, c11550j.m68865d());
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                this.f51879a.m74608m(this.f51880b, 0, c11550j.m68875n());
                byteArrayOutputStream.write(this.f51880b, 0, 4);
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: o */
    public final void m66122o(C11556p c11556p, C11549i c11549i, ByteArrayOutputStream byteArrayOutputStream, C12426e c12426e, Charset charset) throws IOException {
        if (c11549i == null) {
            throw new C10631a("input parameters is null, cannot write local file header");
        }
        try {
            byte[] bArr = {0, 0};
            boolean zM66115h = m66115h(c11549i);
            c12426e.m74605j(byteArrayOutputStream, (int) c11549i.m68965a().m66102b());
            c12426e.m74609n(byteArrayOutputStream, c11549i.m68919Q());
            c12426e.m74609n(byteArrayOutputStream, c11549i.m68876o());
            byteArrayOutputStream.write(c11549i.m68873l());
            c12426e.m74609n(byteArrayOutputStream, c11549i.m68866e().m70094b());
            c12426e.m74608m(this.f51880b, 0, c11549i.m68874m());
            byteArrayOutputStream.write(this.f51880b, 0, 4);
            c12426e.m74608m(this.f51880b, 0, c11549i.m68867f());
            byteArrayOutputStream.write(this.f51880b, 0, 4);
            if (zM66115h) {
                c12426e.m74608m(this.f51880b, 0, 4294967295L);
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                c11556p.m68982t(true);
            } else {
                c12426e.m74608m(this.f51880b, 0, c11549i.m68865d());
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                c12426e.m74608m(this.f51880b, 0, c11549i.m68875n());
                byteArrayOutputStream.write(this.f51880b, 0, 4);
            }
            byte[] bArrM66104b = new byte[0];
            if (C12427f.m74616f(c11549i.m68871j())) {
                bArrM66104b = C10955d.m66104b(c11549i.m68871j(), charset);
            }
            c12426e.m74609n(byteArrayOutputStream, bArrM66104b.length);
            byte[] bArr2 = new byte[4];
            if (zM66115h) {
                c12426e.m74608m(this.f51880b, 0, 4294967295L);
                System.arraycopy(this.f51880b, 0, bArr2, 0, 4);
            } else {
                c12426e.m74608m(this.f51880b, 0, c11549i.m68918P());
                System.arraycopy(this.f51880b, 0, bArr2, 0, 4);
            }
            c12426e.m74609n(byteArrayOutputStream, m66109b(c11549i, zM66115h));
            String strM68917O = c11549i.m68917O();
            byte[] bArrM66104b2 = new byte[0];
            if (C12427f.m74616f(strM68917O)) {
                bArrM66104b2 = C10955d.m66104b(strM68917O, charset);
            }
            c12426e.m74609n(byteArrayOutputStream, bArrM66104b2.length);
            if (zM66115h) {
                c12426e.m74606k(this.f51881c, 0, 65535);
                byteArrayOutputStream.write(this.f51881c, 0, 2);
            } else {
                c12426e.m74609n(byteArrayOutputStream, c11549i.m68915M());
            }
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(c11549i.m68916N());
            byteArrayOutputStream.write(bArr2);
            if (bArrM66104b.length > 0) {
                byteArrayOutputStream.write(bArrM66104b);
            }
            if (zM66115h) {
                c11556p.m68982t(true);
                c12426e.m74609n(byteArrayOutputStream, (int) EnumC10954c.ZIP64_EXTRA_FIELD_SIGNATURE.m66102b());
                c12426e.m74609n(byteArrayOutputStream, 28);
                c12426e.m74607l(byteArrayOutputStream, c11549i.m68875n());
                c12426e.m74607l(byteArrayOutputStream, c11549i.m68865d());
                c12426e.m74607l(byteArrayOutputStream, c11549i.m68918P());
                c12426e.m74605j(byteArrayOutputStream, c11549i.m68915M());
            }
            if (c11549i.m68864c() != null) {
                C11541a c11541aM68864c = c11549i.m68864c();
                c12426e.m74609n(byteArrayOutputStream, (int) c11541aM68864c.m68965a().m66102b());
                c12426e.m74609n(byteArrayOutputStream, c11541aM68864c.m68846f());
                c12426e.m74609n(byteArrayOutputStream, c11541aM68864c.m68844d().m70091e());
                byteArrayOutputStream.write(C10955d.m66104b(c11541aM68864c.m68847g(), charset));
                byteArrayOutputStream.write(new byte[]{(byte) c11541aM68864c.m68843c().m70088h()});
                c12426e.m74609n(byteArrayOutputStream, c11541aM68864c.m68845e().m70094b());
            }
            m66124q(c11549i, byteArrayOutputStream);
            if (bArrM66104b2.length > 0) {
                byteArrayOutputStream.write(bArrM66104b2);
            }
        } catch (Exception e10) {
            throw new C10631a(e10);
        }
    }

    /* renamed from: p */
    public void m66123p(C11556p c11556p, C11550j c11550j, OutputStream outputStream, Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f51879a.m74605j(byteArrayOutputStream, (int) c11550j.m68965a().m66102b());
            this.f51879a.m74609n(byteArrayOutputStream, c11550j.m68876o());
            byteArrayOutputStream.write(c11550j.m68873l());
            this.f51879a.m74609n(byteArrayOutputStream, c11550j.m68866e().m70094b());
            this.f51879a.m74608m(this.f51880b, 0, c11550j.m68874m());
            byteArrayOutputStream.write(this.f51880b, 0, 4);
            this.f51879a.m74608m(this.f51880b, 0, c11550j.m68867f());
            byteArrayOutputStream.write(this.f51880b, 0, 4);
            boolean z10 = c11550j.m68865d() >= 4294967295L || c11550j.m68875n() >= 4294967295L;
            if (z10) {
                this.f51879a.m74608m(this.f51880b, 0, 4294967295L);
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                c11556p.m68982t(true);
                c11550j.m68928M(true);
            } else {
                this.f51879a.m74608m(this.f51880b, 0, c11550j.m68865d());
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                this.f51879a.m74608m(this.f51880b, 0, c11550j.m68875n());
                byteArrayOutputStream.write(this.f51880b, 0, 4);
                c11550j.m68928M(false);
            }
            byte[] bArrM66104b = new byte[0];
            if (C12427f.m74616f(c11550j.m68871j())) {
                bArrM66104b = C10955d.m66104b(c11550j.m68871j(), charset);
            }
            this.f51879a.m74609n(byteArrayOutputStream, bArrM66104b.length);
            int i10 = z10 ? 20 : 0;
            if (c11550j.m68864c() != null) {
                i10 += 11;
            }
            this.f51879a.m74609n(byteArrayOutputStream, i10);
            if (bArrM66104b.length > 0) {
                byteArrayOutputStream.write(bArrM66104b);
            }
            if (z10) {
                this.f51879a.m74609n(byteArrayOutputStream, (int) EnumC10954c.ZIP64_EXTRA_FIELD_SIGNATURE.m66102b());
                this.f51879a.m74609n(byteArrayOutputStream, 16);
                this.f51879a.m74607l(byteArrayOutputStream, c11550j.m68875n());
                this.f51879a.m74607l(byteArrayOutputStream, c11550j.m68865d());
            }
            if (c11550j.m68864c() != null) {
                C11541a c11541aM68864c = c11550j.m68864c();
                this.f51879a.m74609n(byteArrayOutputStream, (int) c11541aM68864c.m68965a().m66102b());
                this.f51879a.m74609n(byteArrayOutputStream, c11541aM68864c.m68846f());
                this.f51879a.m74609n(byteArrayOutputStream, c11541aM68864c.m68844d().m70091e());
                byteArrayOutputStream.write(C10955d.m66104b(c11541aM68864c.m68847g(), charset));
                byteArrayOutputStream.write(new byte[]{(byte) c11541aM68864c.m68843c().m70088h()});
                this.f51879a.m74609n(byteArrayOutputStream, c11541aM68864c.m68845e().m70094b());
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: q */
    public final void m66124q(C11549i c11549i, OutputStream outputStream) throws IOException {
        if (c11549i.m68869h() == null || c11549i.m68869h().size() == 0) {
            return;
        }
        for (C11548h c11548h : c11549i.m68869h()) {
            if (c11548h.m68909d() != EnumC10954c.AES_EXTRA_DATA_RECORD.m66102b() && c11548h.m68909d() != EnumC10954c.ZIP64_EXTRA_FIELD_SIGNATURE.m66102b()) {
                this.f51879a.m74609n(outputStream, (int) c11548h.m68909d());
                this.f51879a.m74609n(outputStream, c11548h.m68910e());
                if (c11548h.m68910e() > 0 && c11548h.m68908c() != null) {
                    outputStream.write(c11548h.m68908c());
                }
            }
        }
    }

    /* renamed from: r */
    public final void m66125r(C11552l c11552l, ByteArrayOutputStream byteArrayOutputStream, C12426e c12426e) throws IOException {
        c12426e.m74605j(byteArrayOutputStream, (int) EnumC10954c.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.m66102b());
        c12426e.m74605j(byteArrayOutputStream, c11552l.m68932c());
        c12426e.m74607l(byteArrayOutputStream, c11552l.m68933d());
        c12426e.m74605j(byteArrayOutputStream, c11552l.m68934e());
    }

    /* renamed from: s */
    public final void m66126s(C11553m c11553m, ByteArrayOutputStream byteArrayOutputStream, C12426e c12426e) throws IOException {
        c12426e.m74605j(byteArrayOutputStream, (int) c11553m.m68965a().m66102b());
        c12426e.m74607l(byteArrayOutputStream, c11553m.m68942g());
        c12426e.m74609n(byteArrayOutputStream, c11553m.m68945j());
        c12426e.m74609n(byteArrayOutputStream, c11553m.m68946k());
        c12426e.m74605j(byteArrayOutputStream, c11553m.m68938c());
        c12426e.m74605j(byteArrayOutputStream, c11553m.m68939d());
        c12426e.m74607l(byteArrayOutputStream, c11553m.m68944i());
        c12426e.m74607l(byteArrayOutputStream, c11553m.m68943h());
        c12426e.m74607l(byteArrayOutputStream, c11553m.m68941f());
        c12426e.m74607l(byteArrayOutputStream, c11553m.m68940e());
    }

    /* renamed from: t */
    public final void m66127t(C11556p c11556p, OutputStream outputStream, byte[] bArr, Charset charset) throws IOException {
        if (bArr == null) {
            throw new C10631a("invalid buff to write as zip headers");
        }
        if ((outputStream instanceof C11358d) && ((C11358d) outputStream).m68172d(bArr.length)) {
            m66111d(c11556p, outputStream, charset);
        } else {
            outputStream.write(bArr);
        }
    }
}
