package p560px;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import mx.C11546f;
import mx.C11549i;
import mx.C11551k;
import mx.C11556p;
import p376ix.C10631a;
import p409jx.C10955d;
import p409jx.C10956e;
import p462lx.C11362h;
import p502nx.EnumC11766f;
import p537ox.C12056a;
import p560px.AbstractC12246e;

/* renamed from: px.f */
/* loaded from: classes9.dex */
public class C12247f extends AbstractC12243b<a> {

    /* renamed from: d */
    public final C11556p f56645d;

    /* renamed from: e */
    public final C10956e f56646e;

    /* renamed from: px.f$a */
    public static class a extends AbstractC12244c {

        /* renamed from: b */
        public final List<String> f56647b;

        public a(List<String> list, C11551k c11551k) {
            super(c11551k);
            this.f56647b = list;
        }
    }

    public C12247f(C11556p c11556p, C10956e c10956e, AbstractC12246e.b bVar) {
        super(bVar);
        this.f56645d = c11556p;
        this.f56646e = c10956e;
    }

    @Override // p560px.AbstractC12246e
    /* renamed from: g */
    public C12056a.c mo73447g() {
        return C12056a.c.REMOVE_ENTRY;
    }

    @Override // p560px.AbstractC12246e
    /* renamed from: s */
    public long mo73471d(a aVar) {
        return this.f56645d.m68973k().length();
    }

    @Override // p560px.AbstractC12246e
    /* renamed from: t */
    public void mo73472f(a aVar, C12056a c12056a) throws IOException {
        List<C11549i> list;
        if (this.f56645d.m68974l()) {
            throw new C10631a("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        List<String> listM73490u = m73490u(aVar.f56647b);
        if (listM73490u.isEmpty()) {
            return;
        }
        File fileM73466p = m73466p(this.f56645d.m68973k().getPath());
        try {
            C11362h c11362h = new C11362h(fileM73466p);
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f56645d.m68973k(), EnumC11766f.READ.m70095b());
                try {
                    List<C11549i> listM73462l = m73462l(this.f56645d.m68967c().m68888a());
                    long jM73463m = 0;
                    for (C11549i c11549i : listM73462l) {
                        long jM73465o = m73465o(listM73462l, c11549i, this.f56645d) - c11362h.mo68174t();
                        if (m73492w(c11549i, listM73490u)) {
                            m73493x(listM73462l, c11549i, jM73465o);
                            if (!this.f56645d.m68967c().m68888a().remove(c11549i)) {
                                throw new C10631a("Could not remove entry from list of central directory headers");
                            }
                            jM73463m += jM73465o;
                            list = listM73462l;
                        } else {
                            list = listM73462l;
                            jM73463m += super.m73463m(randomAccessFile, c11362h, jM73463m, jM73465o, c12056a, aVar.f56634a.m68929a());
                        }
                        m73484j();
                        listM73462l = list;
                    }
                    this.f56646e.m66111d(this.f56645d, c11362h, aVar.f56634a.m68930b());
                    randomAccessFile.close();
                    c11362h.close();
                    m73461k(true, this.f56645d.m68973k(), fileM73466p);
                } finally {
                }
            } finally {
            }
        } catch (Throwable th2) {
            m73461k(false, this.f56645d.m68973k(), fileM73466p);
            throw th2;
        }
    }

    /* renamed from: u */
    public final List<String> m73490u(List<String> list) throws C10631a {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (C10955d.m66105c(this.f56645d, str) != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: v */
    public final long m73491v(long j10) {
        if (j10 != Long.MIN_VALUE) {
            return -j10;
        }
        throw new ArithmeticException("long overflow");
    }

    /* renamed from: w */
    public final boolean m73492w(C11549i c11549i, List<String> list) {
        for (String str : list) {
            if ((str.endsWith("/") && c11549i.m68871j().startsWith(str)) || c11549i.m68871j().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: x */
    public final void m73493x(List<C11549i> list, C11549i c11549i, long j10) throws C10631a {
        m73468r(list, this.f56645d, c11549i, m73491v(j10));
        C11546f c11546fM68968d = this.f56645d.m68968d();
        c11546fM68968d.m68904n(c11546fM68968d.m68897g() - j10);
        c11546fM68968d.m68906p(c11546fM68968d.m68898h() - 1);
        if (c11546fM68968d.m68899i() > 0) {
            c11546fM68968d.m68907q(c11546fM68968d.m68899i() - 1);
        }
        if (this.f56645d.m68975m()) {
            this.f56645d.m68972j().m68950o(this.f56645d.m68972j().m68940e() - j10);
            this.f56645d.m68972j().m68954s(this.f56645d.m68972j().m68943h() - 1);
            this.f56645d.m68971i().m68936g(this.f56645d.m68971i().m68933d() - j10);
        }
    }
}
