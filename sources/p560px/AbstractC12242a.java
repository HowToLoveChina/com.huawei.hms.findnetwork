package p560px;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mx.C11549i;
import mx.C11551k;
import mx.C11556p;
import mx.C11557q;
import p376ix.C10631a;
import p409jx.C10955d;
import p409jx.C10956e;
import p462lx.C11362h;
import p462lx.C11365k;
import p502nx.EnumC11764d;
import p502nx.EnumC11765e;
import p537ox.C12056a;
import p560px.AbstractC12246e;
import p560px.C12247f;
import p594qx.C12422a;
import p594qx.C12423b;
import p594qx.C12424c;
import p594qx.C12427f;

/* renamed from: px.a */
/* loaded from: classes9.dex */
public abstract class AbstractC12242a<T> extends AbstractC12246e<T> {

    /* renamed from: d */
    public final C11556p f56630d;

    /* renamed from: e */
    public final char[] f56631e;

    /* renamed from: f */
    public final C10956e f56632f;

    public AbstractC12242a(C11556p c11556p, char[] cArr, C10956e c10956e, AbstractC12246e.b bVar) {
        super(bVar);
        this.f56630d = c11556p;
        this.f56631e = cArr;
        this.f56632f = c10956e;
    }

    @Override // p560px.AbstractC12246e
    /* renamed from: g */
    public C12056a.c mo73447g() {
        return C12056a.c.ADD_ENTRY;
    }

    /* renamed from: k */
    public final void m73448k(File file, C11365k c11365k, C11557q c11557q, C11362h c11362h, C12056a c12056a, byte[] bArr) throws IOException {
        c11365k.m68202z(c11557q);
        if (file.exists() && !file.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    c11365k.write(bArr, 0, i10);
                    c12056a.m72204l(i10);
                    m73484j();
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
            fileInputStream.close();
        }
        m73454q(c11365k, c11362h, file, false);
    }

    /* renamed from: l */
    public void m73449l(List<File> list, C12056a c12056a, C11557q c11557q, C11551k c11551k) throws IOException {
        C12424c.m74574b(list, c11557q.m69003n());
        byte[] bArr = new byte[c11551k.m68929a()];
        List<File> listM73458u = m73458u(list, c11557q, c12056a, c11551k);
        C11362h c11362h = new C11362h(this.f56630d.m68973k(), this.f56630d.m68970g());
        try {
            C11365k c11365kM73456s = m73456s(c11362h, c11551k);
            try {
                for (File file : listM73458u) {
                    m73484j();
                    C11557q c11557qM73453p = m73453p(c11557q, file, c12056a);
                    c12056a.m72200h(file.getAbsolutePath());
                    if (C12424c.m74590r(file) && m73450m(c11557qM73453p)) {
                        m73451n(file, c11365kM73456s, c11557qM73453p, c11362h);
                        if (C11557q.a.INCLUDE_LINK_ONLY.equals(c11557qM73453p.m69003n())) {
                        }
                    }
                    m73448k(file, c11365kM73456s, c11557qM73453p, c11362h, c12056a, bArr);
                }
                if (c11365kM73456s != null) {
                    c11365kM73456s.close();
                }
                c11362h.close();
            } finally {
            }
        } catch (Throwable th2) {
            try {
                c11362h.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: m */
    public final boolean m73450m(C11557q c11557q) {
        return C11557q.a.INCLUDE_LINK_ONLY.equals(c11557q.m69003n()) || C11557q.a.INCLUDE_LINK_AND_LINKED_FILE.equals(c11557q.m69003n());
    }

    /* renamed from: n */
    public final void m73451n(File file, C11365k c11365k, C11557q c11557q, C11362h c11362h) throws IOException {
        C11557q c11557q2 = new C11557q(c11557q);
        c11557q2.m68986C(m73459v(c11557q.m69000k(), file.getName()));
        c11557q2.m69014y(false);
        c11557q2.m69012w(EnumC11764d.STORE);
        c11365k.m68202z(c11557q2);
        c11365k.write(C12424c.m74594v(file).getBytes());
        m73454q(c11365k, c11362h, file, true);
    }

    /* renamed from: o */
    public long m73452o(List<File> list, C11557q c11557q) throws C10631a {
        long length = 0;
        for (File file : list) {
            if (file.exists()) {
                length += (c11557q.m69004o() && c11557q.m68995f() == EnumC11765e.ZIP_STANDARD) ? file.length() * 2 : file.length();
                C11549i c11549iM66105c = C10955d.m66105c(m73455r(), C12424c.m74585m(file, c11557q));
                if (c11549iM66105c != null) {
                    length += m73455r().m68973k().length() - c11549iM66105c.m68865d();
                }
            }
        }
        return length;
    }

    /* renamed from: p */
    public final C11557q m73453p(C11557q c11557q, File file, C12056a c12056a) throws IOException {
        C11557q c11557q2 = new C11557q(c11557q);
        if (file.isDirectory()) {
            c11557q2.m68985B(0L);
        } else {
            c11557q2.m68985B(file.length());
        }
        if (c11557q.m69001l() <= 0) {
            c11557q2.m68988E(file.lastModified());
        }
        c11557q2.m68989F(false);
        if (!C12427f.m74616f(c11557q.m69000k())) {
            c11557q2.m68986C(C12424c.m74585m(file, c11557q));
        }
        if (file.isDirectory()) {
            c11557q2.m69012w(EnumC11764d.STORE);
            c11557q2.m69015z(EnumC11765e.NONE);
            c11557q2.m69014y(false);
        } else {
            if (c11557q2.m69004o() && c11557q2.m68995f() == EnumC11765e.ZIP_STANDARD) {
                c12056a.m72199g(C12056a.c.CALCULATE_CRC);
                c11557q2.m68984A(C12423b.m74572a(file, c12056a));
                c12056a.m72199g(C12056a.c.ADD_ENTRY);
            }
            if (file.length() == 0) {
                c11557q2.m69012w(EnumC11764d.STORE);
            }
        }
        return c11557q2;
    }

    /* renamed from: q */
    public final void m73454q(C11365k c11365k, C11362h c11362h, File file, boolean z10) throws IOException {
        C11549i c11549iM68195s = c11365k.m68195s();
        byte[] bArrM74579g = C12424c.m74579g(file);
        if (!z10) {
            bArrM74579g[3] = C12422a.m74571c(bArrM74579g[3], 5);
        }
        c11549iM68195s.m68921S(bArrM74579g);
        m73460w(c11549iM68195s, c11362h);
    }

    /* renamed from: r */
    public C11556p m73455r() {
        return this.f56630d;
    }

    /* renamed from: s */
    public C11365k m73456s(C11362h c11362h, C11551k c11551k) throws IOException {
        if (this.f56630d.m68973k().exists()) {
            c11362h.seek(C10955d.m66107e(this.f56630d));
        }
        return new C11365k(c11362h, this.f56631e, c11551k, this.f56630d);
    }

    /* renamed from: t */
    public void m73457t(C11549i c11549i, C12056a c12056a, C11551k c11551k) throws C10631a {
        new C12247f(this.f56630d, this.f56632f, new AbstractC12246e.b(null, false, c12056a)).m73481e(new C12247f.a(Collections.singletonList(c11549i.m68871j()), c11551k));
    }

    /* renamed from: u */
    public final List<File> m73458u(List<File> list, C11557q c11557q, C12056a c12056a, C11551k c11551k) throws IOException {
        ArrayList arrayList = new ArrayList(list);
        if (!this.f56630d.m68973k().exists()) {
            return arrayList;
        }
        for (File file : list) {
            if (!C12427f.m74616f(file.getName())) {
                arrayList.remove(file);
            }
            C11549i c11549iM66105c = C10955d.m66105c(this.f56630d, C12424c.m74585m(file, c11557q));
            if (c11549iM66105c != null) {
                if (c11557q.m69006q()) {
                    c12056a.m72199g(C12056a.c.REMOVE_ENTRY);
                    m73457t(c11549iM66105c, c12056a, c11551k);
                    m73484j();
                    c12056a.m72199g(C12056a.c.ADD_ENTRY);
                } else {
                    arrayList.remove(file);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: v */
    public final String m73459v(String str, String str2) {
        if (!str.contains("/")) {
            return str2;
        }
        return str.substring(0, str.lastIndexOf("/") + 1) + str2;
    }

    /* renamed from: w */
    public void m73460w(C11549i c11549i, C11362h c11362h) throws IOException {
        this.f56632f.m66118k(c11549i, m73455r(), c11362h);
    }
}
