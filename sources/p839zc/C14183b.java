package p839zc;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: zc.b */
/* loaded from: classes3.dex */
public class C14183b extends InputStream {

    /* renamed from: a */
    public InputStream f63342a;

    /* renamed from: b */
    public int[] f63343b;

    /* renamed from: c */
    public int f63344c = 0;

    /* renamed from: d */
    public boolean f63345d = false;

    public C14183b(InputStream inputStream) {
        this.f63342a = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f63342a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int[] iArr = this.f63343b;
        if (iArr == null || this.f63344c == iArr.length) {
            if (this.f63345d) {
                return -1;
            }
            m85054s();
            int[] iArr2 = this.f63343b;
            if (iArr2 == null) {
                return -1;
            }
            if (iArr2.length == 0) {
                this.f63343b = null;
                return -1;
            }
            this.f63344c = 0;
        }
        int[] iArr3 = this.f63343b;
        int i10 = this.f63344c;
        this.f63344c = i10 + 1;
        return iArr3[i10];
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042 A[PHI: r3
  0x0042: PHI (r3v3 int) = (r3v2 int), (r3v9 int) binds: [B:19:0x002d, B:23:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m85054s() throws java.io.IOException {
        /*
            r9 = this;
            r0 = 4
            char[] r1 = new char[r0]
            boolean r2 = r9.m85055t(r1)
            if (r2 == 0) goto La
            return
        La:
            r2 = 0
            r3 = r2
            r4 = r3
        Ld:
            java.lang.String r5 = "Illegal base64 stream"
            r6 = 1
            if (r3 >= r0) goto L28
            char r7 = r1[r3]
            char r8 = p839zc.C14185d.f63352b
            if (r7 == r8) goto L21
            if (r4 != 0) goto L1b
            goto L25
        L1b:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r5)
            throw r9
        L21:
            if (r4 == 0) goto L24
            goto L25
        L24:
            r4 = r6
        L25:
            int r3 = r3 + 1
            goto Ld
        L28:
            r3 = 3
            char r4 = r1[r3]
            char r7 = p839zc.C14185d.f63352b
            if (r4 != r7) goto L42
            java.io.InputStream r3 = r9.f63342a
            int r3 = r3.read()
            r4 = -1
            if (r3 != r4) goto L44
            r9.f63345d = r6
            r3 = 2
            char r4 = r1[r3]
            char r5 = p839zc.C14185d.f63352b
            if (r4 != r5) goto L42
            goto L4a
        L42:
            r6 = r3
            goto L4a
        L44:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r5)
            throw r9
        L4a:
            r3 = r2
            r4 = r3
        L4c:
            if (r3 >= r0) goto L64
            char r5 = r1[r3]
            char r7 = p839zc.C14185d.f63352b
            if (r5 != r7) goto L55
            goto L61
        L55:
            java.lang.String r7 = p839zc.C14185d.f63351a
            int r5 = r7.indexOf(r5)
            int r7 = 3 - r3
            int r7 = r7 * 6
            int r5 = r5 << r7
            r4 = r4 | r5
        L61:
            int r3 = r3 + 1
            goto L4c
        L64:
            int[] r0 = new int[r6]
            r9.f63343b = r0
        L68:
            if (r2 >= r6) goto L79
            int[] r0 = r9.f63343b
            int r1 = 2 - r2
            int r1 = r1 * 8
            int r1 = r4 >>> r1
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0[r2] = r1
            int r2 = r2 + 1
            goto L68
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p839zc.C14183b.m85054s():void");
    }

    /* renamed from: t */
    public final boolean m85055t(char[] cArr) throws IOException {
        int i10 = 0;
        do {
            int i11 = this.f63342a.read();
            if (i11 == -1) {
                if (i10 != 0) {
                    throw new IOException("Illegal base64 stream");
                }
                this.f63343b = new int[0];
                this.f63345d = true;
                return true;
            }
            char c10 = (char) i11;
            if (C14185d.f63351a.indexOf(c10) != -1 || c10 == C14185d.f63352b) {
                cArr[i10] = c10;
                i10++;
            } else if (c10 != '\r' && c10 != '\n') {
                throw new IOException("Illegal base64 stream");
            }
        } while (i10 < 4);
        return false;
    }
}
