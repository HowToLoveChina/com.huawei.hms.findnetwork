package gy;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiConsumer;
import ly.C11374h;
import ly.C11378l;
import my.C11558a;
import p270ey.AbstractC9574c;
import p350hy.AbstractC10361d;
import p350hy.InterfaceC10359b;
import p595qy.C12431c;

/* renamed from: gy.f */
/* loaded from: classes9.dex */
public class C10067f extends AbstractC9574c<C10064c> {

    /* renamed from: r */
    public static final InterfaceC10359b f49114r = AbstractC10361d.m63786c(StandardCharsets.US_ASCII);

    /* renamed from: b */
    public long f49115b;

    /* renamed from: c */
    public String f49116c;

    /* renamed from: d */
    public long f49117d;

    /* renamed from: e */
    public final byte[] f49118e;

    /* renamed from: f */
    public int f49119f;

    /* renamed from: g */
    public int f49120g;

    /* renamed from: h */
    public long f49121h;

    /* renamed from: i */
    public final int f49122i;

    /* renamed from: j */
    public boolean f49123j;

    /* renamed from: k */
    public boolean f49124k;

    /* renamed from: l */
    public boolean f49125l;

    /* renamed from: m */
    public final C11374h f49126m;

    /* renamed from: n */
    public final C12431c f49127n;

    /* renamed from: o */
    public final InterfaceC10359b f49128o;

    /* renamed from: p */
    public final String f49129p;

    /* renamed from: q */
    public boolean f49130q;

    public C10067f(OutputStream outputStream) {
        this(outputStream, -511);
    }

    /* renamed from: B */
    public static /* synthetic */ void m62636B(StringWriter stringWriter, String str, String str2) {
        int length = str.length() + str2.length() + 5;
        String str3 = length + " " + str + "=" + str2 + "\n";
        int length2 = str3.getBytes(StandardCharsets.UTF_8).length;
        while (length != length2) {
            str3 = length2 + " " + str + "=" + str2 + "\n";
            int i10 = length2;
            length2 = str3.getBytes(StandardCharsets.UTF_8).length;
            length = i10;
        }
        stringWriter.write(str3);
    }

    /* renamed from: A */
    public final boolean m62638A(C10064c c10064c, String str, Map<String, String> map, String str2, byte b10, String str3) throws IOException {
        ByteBuffer byteBufferMo62691b = this.f49128o.mo62691b(str);
        int iLimit = byteBufferMo62691b.limit() - byteBufferMo62691b.position();
        if (iLimit >= 100) {
            int i10 = this.f49119f;
            if (i10 == 3) {
                map.put(str2, str);
                return true;
            }
            if (i10 == 2) {
                C10064c c10064c2 = new C10064c("././@LongLink", b10);
                c10064c2.m62592l0(iLimit + 1);
                m62645I(c10064c, c10064c2);
                m62640D(c10064c2);
                write(byteBufferMo62691b.array(), byteBufferMo62691b.arrayOffset(), iLimit);
                write(0);
                m62654s();
            } else if (i10 != 1) {
                throw new IllegalArgumentException(str3 + " '" + str + "' is too long ( > 100 bytes)");
            }
        }
        return false;
    }

    /* renamed from: C */
    public final void m62639C() throws IOException {
        int intExact = Math.toIntExact(this.f49121h % this.f49122i);
        if (intExact != 0) {
            while (intExact < this.f49122i) {
                m62646J();
                intExact++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m62640D(gy.C10064c r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gy.C10067f.m62640D(gy.c):void");
    }

    /* renamed from: E */
    public void m62641E(int i10) {
        this.f49120g = i10;
    }

    /* renamed from: F */
    public void m62642F(int i10) {
        this.f49119f = i10;
    }

    /* renamed from: G */
    public final boolean m62643G(char c10) {
        return c10 == 0 || c10 == '/' || c10 == '\\';
    }

    /* renamed from: H */
    public final String m62644H(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = (char) (str.charAt(i10) & 127);
            if (m62643G(cCharAt)) {
                sb2.append("_");
            } else {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString();
    }

    /* renamed from: I */
    public final void m62645I(C10064c c10064c, C10064c c10064c2) {
        long jM68237a = C11378l.m68237a(c10064c.m62597o());
        if (jM68237a < 0 || jM68237a > 8589934591L) {
            jM68237a = 0;
        }
        c10064c2.m62582g0(C11378l.m68238b(jM68237a));
    }

    /* renamed from: J */
    public final void m62646J() throws IOException {
        Arrays.fill(this.f49118e, (byte) 0);
        m62648X(this.f49118e);
    }

    /* renamed from: V */
    public void m62647V(C10064c c10064c, String str, Map<String, String> map) throws IOException {
        String strSubstring = "./PaxHeaders.X/" + m62644H(str);
        if (strSubstring.length() >= 100) {
            strSubstring = strSubstring.substring(0, 99);
        }
        C10064c c10064c2 = new C10064c(strSubstring, (byte) 120);
        m62645I(c10064c, c10064c2);
        byte[] bArrM62656u = m62656u(map);
        c10064c2.m62592l0(bArrM62656u.length);
        m62640D(c10064c2);
        write(bArrM62656u);
        m62654s();
    }

    /* renamed from: X */
    public final void m62648X(byte[] bArr) throws IOException {
        if (bArr.length == 512) {
            this.f49126m.write(bArr);
            this.f49121h++;
            return;
        }
        throw new IOException("Record to write has length '" + bArr.length + "' which is not the record size of '512'");
    }

    /* renamed from: c */
    public final void m62649c(Map<String, String> map, String str, FileTime fileTime) {
        if (fileTime != null) {
            Instant instant = fileTime.toInstant();
            long epochSecond = instant.getEpochSecond();
            int nano = instant.getNano();
            if (nano == 0) {
                map.put(str, String.valueOf(epochSecond));
            } else {
                m62651e(map, str, epochSecond, nano);
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (!this.f49125l) {
                m62661z();
            }
        } finally {
            if (!this.f49123j) {
                this.f49126m.close();
                this.f49123j = true;
            }
        }
    }

    /* renamed from: d */
    public final void m62650d(Map<String, String> map, String str, FileTime fileTime, long j10) {
        if (fileTime != null) {
            Instant instant = fileTime.toInstant();
            long epochSecond = instant.getEpochSecond();
            int nano = instant.getNano();
            if (nano == 0) {
                m62652f(map, str, epochSecond, j10);
            } else {
                m62651e(map, str, epochSecond, nano);
            }
        }
    }

    /* renamed from: e */
    public final void m62651e(Map<String, String> map, String str, long j10, int i10) {
        map.put(str, BigDecimal.valueOf(j10).add(BigDecimal.valueOf(i10).movePointLeft(9).setScale(7, RoundingMode.DOWN)).toPlainString());
    }

    /* renamed from: f */
    public final void m62652f(Map<String, String> map, String str, long j10, long j11) {
        if (j10 < 0 || j10 > j11) {
            map.put(str, String.valueOf(j10));
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f49126m.flush();
    }

    /* renamed from: g */
    public final void m62653g(Map<String, String> map, C10064c c10064c) {
        m62652f(map, "size", c10064c.m62611w(), 8589934591L);
        m62652f(map, "gid", c10064c.m62601q(), 2097151L);
        m62650d(map, "mtime", c10064c.m62597o(), 8589934591L);
        m62649c(map, "atime", c10064c.m62595n());
        if (c10064c.m62613y() != null) {
            m62649c(map, "ctime", c10064c.m62613y());
        } else {
            m62649c(map, "ctime", c10064c.m62587j());
        }
        m62652f(map, "uid", c10064c.m62603r(), 2097151L);
        m62649c(map, "LIBARCHIVE.creationtime", c10064c.m62587j());
        m62652f(map, "SCHILY.devmajor", c10064c.m62589k(), 2097151L);
        m62652f(map, "SCHILY.devminor", c10064c.m62591l(), 2097151L);
        m62657v("mode", c10064c.m62605s(), 2097151L);
    }

    /* renamed from: s */
    public void m62654s() throws IOException {
        if (this.f49125l) {
            throw new IOException("Stream has already been finished");
        }
        if (!this.f49124k) {
            throw new IOException("No current entry to close");
        }
        this.f49126m.m68223s();
        long j10 = this.f49117d;
        long j11 = this.f49115b;
        if (j10 >= j11) {
            long j12 = this.f49121h + (j11 / 512);
            this.f49121h = j12;
            if (0 != j11 % 512) {
                this.f49121h = j12 + 1;
            }
            this.f49124k = false;
            return;
        }
        throw new IOException("Entry '" + this.f49116c + "' closed at '" + this.f49117d + "' before the '" + this.f49115b + "' bytes specified in the header were written");
    }

    /* renamed from: t */
    public C10064c m62655t(File file, String str) throws IOException {
        if (this.f49125l) {
            throw new IOException("Stream has already been finished");
        }
        return new C10064c(file, str);
    }

    /* renamed from: u */
    public final byte[] m62656u(Map<String, String> map) {
        final StringWriter stringWriter = new StringWriter();
        map.forEach(new BiConsumer() { // from class: gy.e
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                C10067f.m62636B(stringWriter, (String) obj, (String) obj2);
            }
        });
        return stringWriter.toString().getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: v */
    public final void m62657v(String str, long j10, long j11) {
        m62658w(str, j10, j11, "");
    }

    /* renamed from: w */
    public final void m62658w(String str, long j10, long j11, String str2) {
        if (j10 < 0 || j10 > j11) {
            throw new IllegalArgumentException(str + " '" + j10 + "' is too big ( > " + j11 + " )." + str2);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.f49124k) {
            throw new IllegalStateException("No current tar entry");
        }
        long j10 = i11;
        if (this.f49117d + j10 <= this.f49115b) {
            this.f49126m.write(bArr, i10, i11);
            this.f49117d += j10;
            return;
        }
        throw new IOException("Request to write '" + i11 + "' bytes exceeds size in header of '" + this.f49115b + "' bytes for entry '" + this.f49116c + "'");
    }

    /* renamed from: x */
    public final void m62659x(String str, long j10, long j11) {
        m62658w(str, j10, j11, " Use STAR or POSIX extensions to overcome this limit");
    }

    /* renamed from: y */
    public final void m62660y(C10064c c10064c) {
        m62657v("entry size", c10064c.m62611w(), 8589934591L);
        m62659x("group id", c10064c.m62601q(), 2097151L);
        m62657v("last modification time", C11378l.m68237a(c10064c.m62597o()), 8589934591L);
        m62657v("user id", c10064c.m62603r(), 2097151L);
        m62657v("mode", c10064c.m62605s(), 2097151L);
        m62657v("major device number", c10064c.m62589k(), 2097151L);
        m62657v("minor device number", c10064c.m62591l(), 2097151L);
    }

    /* renamed from: z */
    public void m62661z() throws IOException {
        if (this.f49125l) {
            throw new IOException("This archive has already been finished");
        }
        if (this.f49124k) {
            throw new IOException("This archive contains unclosed entries.");
        }
        m62646J();
        m62646J();
        m62639C();
        this.f49126m.flush();
        this.f49125l = true;
    }

    public C10067f(OutputStream outputStream, int i10) {
        this(outputStream, i10, null);
    }

    public C10067f(OutputStream outputStream, int i10, String str) {
        this.f49119f = 0;
        this.f49120g = 0;
        int i11 = -511 == i10 ? 512 : i10;
        if (i11 > 0 && i11 % 512 == 0) {
            C12431c c12431c = new C12431c(outputStream);
            this.f49127n = c12431c;
            this.f49126m = new C11374h(c12431c, 512);
            this.f49129p = C11558a.m69016a(str).name();
            this.f49128o = AbstractC10361d.m63785b(str);
            this.f49118e = new byte[512];
            this.f49122i = i11 / 512;
            return;
        }
        throw new IllegalArgumentException("Block size must be a multiple of 512 bytes. Attempt to use set size of " + i10);
    }
}
