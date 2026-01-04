package p560px;

import java.io.File;
import java.io.IOException;
import java.util.List;
import mx.C11551k;
import mx.C11556p;
import mx.C11557q;
import p376ix.C10631a;
import p409jx.C10956e;
import p537ox.C12056a;
import p560px.AbstractC12246e;
import p594qx.C12424c;

/* renamed from: px.d */
/* loaded from: classes9.dex */
public class C12245d extends AbstractC12242a<a> {

    /* renamed from: px.d$a */
    public static class a extends AbstractC12244c {

        /* renamed from: b */
        public final File f56635b;

        /* renamed from: c */
        public final C11557q f56636c;

        public a(File file, C11557q c11557q, C11551k c11551k) {
            super(c11551k);
            this.f56635b = file;
            this.f56636c = c11557q;
        }
    }

    public C12245d(C11556p c11556p, char[] cArr, C10956e c10956e, AbstractC12246e.b bVar) {
        super(c11556p, cArr, c10956e, bVar);
    }

    /* renamed from: A */
    public final void m73470A(a aVar) throws IOException {
        File file = aVar.f56635b;
        String canonicalPath = (!aVar.f56636c.m69005p() || file.getCanonicalFile().getParentFile() == null) ? file.getCanonicalPath() : file.getCanonicalFile().getParentFile().getCanonicalPath();
        aVar.f56636c.m69013x(canonicalPath);
    }

    @Override // p560px.AbstractC12246e
    /* renamed from: x */
    public long mo73471d(a aVar) throws C10631a {
        List<File> listM73475z = m73475z(aVar);
        if (aVar.f56636c.m69005p()) {
            listM73475z.add(aVar.f56635b);
        }
        return m73452o(listM73475z, aVar.f56636c);
    }

    @Override // p560px.AbstractC12246e
    /* renamed from: y */
    public void mo73472f(a aVar, C12056a c12056a) throws IOException {
        List<File> listM73475z = m73475z(aVar);
        m73470A(aVar);
        m73449l(listM73475z, c12056a, aVar.f56636c, aVar.f56634a);
    }

    /* renamed from: z */
    public final List<File> m73475z(a aVar) throws C10631a {
        List<File> listM74582j = C12424c.m74582j(aVar.f56635b, aVar.f56636c);
        if (aVar.f56636c.m69005p()) {
            listM74582j.add(aVar.f56635b);
        }
        return listM74582j;
    }
}
