package p560px;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mx.C11549i;
import mx.C11556p;
import p376ix.C10631a;
import p409jx.C10955d;
import p537ox.C12056a;
import p560px.AbstractC12246e;
import p594qx.C12424c;

/* renamed from: px.b */
/* loaded from: classes9.dex */
public abstract class AbstractC12243b<T> extends AbstractC12246e<T> {

    /* renamed from: px.b$a */
    public class a implements Comparator<C11549i> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C11549i c11549i, C11549i c11549i2) {
            if (c11549i.m68871j().equals(c11549i2.m68871j())) {
                return 0;
            }
            return c11549i.m68918P() < c11549i2.m68918P() ? -1 : 1;
        }
    }

    public AbstractC12243b(AbstractC12246e.b bVar) {
        super(bVar);
    }

    /* renamed from: k */
    public void m73461k(boolean z10, File file, File file2) throws C10631a {
        if (z10) {
            m73467q(file, file2);
        } else if (!file2.delete()) {
            throw new C10631a("Could not delete temporary file");
        }
    }

    /* renamed from: l */
    public List<C11549i> m73462l(List<C11549i> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    /* renamed from: m */
    public long m73463m(RandomAccessFile randomAccessFile, OutputStream outputStream, long j10, long j11, C12056a c12056a, int i10) throws InterruptedException, IOException {
        C12424c.m74576d(randomAccessFile, outputStream, j10, j10 + j11, c12056a, i10);
        return j11;
    }

    /* renamed from: n */
    public final int m73464n(List<C11549i> list, C11549i c11549i) throws C10631a {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10).equals(c11549i)) {
                return i10;
            }
        }
        throw new C10631a("Could not find file header in list of central directory file headers");
    }

    /* renamed from: o */
    public long m73465o(List<C11549i> list, C11549i c11549i, C11556p c11556p) throws C10631a {
        int iM73464n = m73464n(list, c11549i);
        return iM73464n == list.size() + (-1) ? C10955d.m66107e(c11556p) : list.get(iM73464n + 1).m68918P();
    }

    /* renamed from: p */
    public File m73466p(String str) {
        SecureRandom secureRandom = new SecureRandom();
        File file = new File(str + secureRandom.nextInt(10000));
        while (file.exists()) {
            file = new File(str + secureRandom.nextInt(10000));
        }
        return file;
    }

    /* renamed from: q */
    public final void m73467q(File file, File file2) throws C10631a {
        if (!file.delete()) {
            throw new C10631a("cannot delete old zip file");
        }
        if (!file2.renameTo(file)) {
            throw new C10631a("cannot rename modified zip file");
        }
    }

    /* renamed from: r */
    public void m73468r(List<C11549i> list, C11556p c11556p, C11549i c11549i, long j10) throws C10631a {
        int iM73464n = m73464n(list, c11549i);
        if (iM73464n == -1) {
            throw new C10631a("Could not locate modified file header in zipModel");
        }
        while (true) {
            iM73464n++;
            if (iM73464n >= list.size()) {
                return;
            }
            C11549i c11549i2 = list.get(iM73464n);
            c11549i2.m68925W(c11549i2.m68918P() + j10);
            if (c11556p.m68975m() && c11549i2.m68877p() != null && c11549i2.m68877p().m68959e() != -1) {
                c11549i2.m68877p().m68963i(c11549i2.m68877p().m68959e() + j10);
            }
        }
    }
}
