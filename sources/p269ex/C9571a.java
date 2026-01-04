package p269ex;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import mx.C11551k;
import mx.C11556p;
import mx.C11557q;
import p376ix.C10631a;
import p409jx.C10953b;
import p409jx.C10956e;
import p437kx.C11200a;
import p502nx.EnumC11766f;
import p537ox.C12056a;
import p560px.AbstractC12246e;
import p560px.C12245d;
import p594qx.C12424c;

/* renamed from: ex.a */
/* loaded from: classes9.dex */
public class C9571a implements Closeable {

    /* renamed from: a */
    public File f47655a;

    /* renamed from: b */
    public C11556p f47656b;

    /* renamed from: c */
    public C12056a f47657c;

    /* renamed from: d */
    public boolean f47658d;

    /* renamed from: e */
    public char[] f47659e;

    /* renamed from: f */
    public C10956e f47660f;

    /* renamed from: g */
    public Charset f47661g;

    /* renamed from: h */
    public ThreadFactory f47662h;

    /* renamed from: i */
    public ExecutorService f47663i;

    /* renamed from: j */
    public int f47664j;

    /* renamed from: k */
    public List<InputStream> f47665k;

    /* renamed from: l */
    public boolean f47666l;

    public C9571a(File file) {
        this(file, null);
    }

    /* renamed from: b */
    public final void m59747b(File file, C11557q c11557q, boolean z10) throws IOException {
        m59753x();
        C11556p c11556p = this.f47656b;
        if (c11556p == null) {
            throw new C10631a("internal error: zip model is null");
        }
        if (z10 && c11556p.m68974l()) {
            throw new C10631a("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        new C12245d(this.f47656b, this.f47659e, this.f47660f, m59748s()).m73481e(new C12245d.a(file, c11557q, m59749t()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<InputStream> it = this.f47665k.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.f47665k.clear();
    }

    /* renamed from: s */
    public final AbstractC12246e.b m59748s() {
        if (this.f47658d) {
            if (this.f47662h == null) {
                this.f47662h = Executors.defaultThreadFactory();
            }
            this.f47663i = Executors.newSingleThreadExecutor(this.f47662h);
        }
        return new AbstractC12246e.b(this.f47663i, this.f47658d, this.f47657c);
    }

    /* renamed from: t */
    public final C11551k m59749t() {
        return new C11551k(this.f47661g, this.f47664j, this.f47666l);
    }

    public String toString() {
        return this.f47655a.toString();
    }

    /* renamed from: u */
    public final void m59750u() {
        C11556p c11556p = new C11556p();
        this.f47656b = c11556p;
        c11556p.m68983u(this.f47655a);
    }

    /* renamed from: v */
    public void m59751v(File file, C11557q c11557q, boolean z10, long j10) throws C10631a {
        if (file == null) {
            throw new C10631a("folderToAdd is null, cannot create zip file from folder");
        }
        if (c11557q == null) {
            throw new C10631a("input parameters are null, cannot create zip file from folder");
        }
        if (this.f47655a.exists()) {
            throw new C10631a("zip file: " + this.f47655a + " already exists. To add files to existing zip file use addFolder method");
        }
        m59750u();
        this.f47656b.m68978p(z10);
        if (z10) {
            this.f47656b.m68979q(j10);
        }
        m59747b(file, c11557q, false);
    }

    /* renamed from: w */
    public final RandomAccessFile m59752w() throws IOException {
        if (!C12424c.m74589q(this.f47655a)) {
            return new RandomAccessFile(this.f47655a, EnumC11766f.READ.m70095b());
        }
        C11200a c11200a = new C11200a(this.f47655a, EnumC11766f.READ.m70095b(), C12424c.m74577e(this.f47655a));
        c11200a.m67210s();
        return c11200a;
    }

    /* renamed from: x */
    public final void m59753x() throws IOException {
        if (this.f47656b != null) {
            return;
        }
        if (!this.f47655a.exists()) {
            m59750u();
            return;
        }
        if (!this.f47655a.canRead()) {
            throw new C10631a("no read access for the input zip file");
        }
        try {
            RandomAccessFile randomAccessFileM59752w = m59752w();
            try {
                C11556p c11556pM66090h = new C10953b().m66090h(randomAccessFileM59752w, m59749t());
                this.f47656b = c11556pM66090h;
                c11556pM66090h.m68983u(this.f47655a);
                if (randomAccessFileM59752w != null) {
                    randomAccessFileM59752w.close();
                }
            } finally {
            }
        } catch (C10631a e10) {
            throw e10;
        } catch (IOException e11) {
            throw new C10631a(e11);
        }
    }

    public C9571a(File file, char[] cArr) {
        this.f47660f = new C10956e();
        this.f47661g = null;
        this.f47664j = 4096;
        this.f47665k = new ArrayList();
        this.f47666l = true;
        if (file != null) {
            this.f47655a = file;
            this.f47659e = cArr;
            this.f47658d = false;
            this.f47657c = new C12056a();
            return;
        }
        throw new IllegalArgumentException("input zip file parameter is null");
    }
}
