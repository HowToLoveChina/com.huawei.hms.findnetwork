package p301fy;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/* renamed from: fy.k */
/* loaded from: classes9.dex */
public final class C9793k {

    /* renamed from: j */
    public static final C9793k[] f48144j = new C9793k[0];

    /* renamed from: a */
    public C9790h[] f48145a;

    /* renamed from: b */
    public long f48146b;

    /* renamed from: c */
    public long f48147c;

    /* renamed from: d */
    public C9788f[] f48148d;

    /* renamed from: e */
    public long[] f48149e;

    /* renamed from: f */
    public long[] f48150f;

    /* renamed from: g */
    public boolean f48151g;

    /* renamed from: h */
    public long f48152h;

    /* renamed from: i */
    public int f48153i;

    /* renamed from: a */
    public int m60870a(int i10) {
        if (this.f48148d == null) {
            return -1;
        }
        int i11 = 0;
        while (true) {
            C9788f[] c9788fArr = this.f48148d;
            if (i11 >= c9788fArr.length) {
                return -1;
            }
            if (c9788fArr[i11].f48131a == i10) {
                return i11;
            }
            i11++;
        }
    }

    /* renamed from: b */
    public int m60871b(int i10) {
        if (this.f48148d == null) {
            return -1;
        }
        int i11 = 0;
        while (true) {
            C9788f[] c9788fArr = this.f48148d;
            if (i11 >= c9788fArr.length) {
                return -1;
            }
            if (c9788fArr[i11].f48132b == i10) {
                return i11;
            }
            i11++;
        }
    }

    /* renamed from: c */
    public Iterable<C9790h> m60872c() throws IOException {
        C9790h[] c9790hArr;
        int iM60871b;
        long[] jArr = this.f48149e;
        if (jArr == null || (c9790hArr = this.f48145a) == null || jArr.length == 0 || c9790hArr.length == 0) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        long j10 = this.f48149e[0];
        loop0: while (true) {
            for (int i10 = (int) j10; i10 >= 0; i10 = -1) {
                C9790h[] c9790hArr2 = this.f48145a;
                if (i10 >= c9790hArr2.length) {
                    break loop0;
                }
                if (linkedList.contains(c9790hArr2[i10])) {
                    throw new IOException("folder uses the same coder more than once in coder chain");
                }
                linkedList.addLast(this.f48145a[i10]);
                iM60871b = m60871b(i10);
                if (iM60871b != -1) {
                    break;
                }
            }
            j10 = this.f48148d[iM60871b].f48131a;
        }
        return linkedList;
    }

    /* renamed from: d */
    public long m60873d() {
        long j10 = this.f48147c;
        if (j10 == 0) {
            return 0L;
        }
        for (int i10 = ((int) j10) - 1; i10 >= 0; i10--) {
            if (m60871b(i10) < 0) {
                return this.f48150f[i10];
            }
        }
        return 0L;
    }

    /* renamed from: e */
    public long m60874e(C9790h c9790h) {
        if (this.f48145a == null) {
            return 0L;
        }
        int i10 = 0;
        while (true) {
            C9790h[] c9790hArr = this.f48145a;
            if (i10 >= c9790hArr.length) {
                return 0L;
            }
            if (c9790hArr[i10] == c9790h) {
                return this.f48150f[i10];
            }
            i10++;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Folder with ");
        sb2.append(this.f48145a.length);
        sb2.append(" coders, ");
        sb2.append(this.f48146b);
        sb2.append(" input streams, ");
        sb2.append(this.f48147c);
        sb2.append(" output streams, ");
        sb2.append(this.f48148d.length);
        sb2.append(" bind pairs, ");
        sb2.append(this.f48149e.length);
        sb2.append(" packed streams, ");
        sb2.append(this.f48150f.length);
        sb2.append(" unpack sizes, ");
        if (this.f48151g) {
            str = "with CRC " + this.f48152h;
        } else {
            str = "without CRC";
        }
        sb2.append(str);
        sb2.append(" and ");
        sb2.append(this.f48153i);
        sb2.append(" unpack streams");
        return sb2.toString();
    }
}
