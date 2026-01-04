package gy;

import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hms.network.embedded.C5929g4;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ly.C11367a;
import ly.C11376j;
import ly.C11377k;
import ly.C11378l;
import p270ey.InterfaceC9572a;
import p350hy.InterfaceC10359b;

/* renamed from: gy.c */
/* loaded from: classes9.dex */
public class C10064c implements InterfaceC9572a {

    /* renamed from: D */
    public static final C10064c[] f49069D = new C10064c[0];

    /* renamed from: E */
    public static final Pattern f49070E = Pattern.compile("-?\\d{1,19}(?:\\.\\d{1,19})?");

    /* renamed from: A */
    public final LinkOption[] f49071A;

    /* renamed from: B */
    public final Map<String, String> f49072B;

    /* renamed from: C */
    public long f49073C;

    /* renamed from: a */
    public String f49074a;

    /* renamed from: b */
    public final boolean f49075b;

    /* renamed from: c */
    public int f49076c;

    /* renamed from: d */
    public long f49077d;

    /* renamed from: e */
    public long f49078e;

    /* renamed from: f */
    public long f49079f;

    /* renamed from: g */
    public FileTime f49080g;

    /* renamed from: h */
    public FileTime f49081h;

    /* renamed from: i */
    public FileTime f49082i;

    /* renamed from: j */
    public FileTime f49083j;

    /* renamed from: k */
    public boolean f49084k;

    /* renamed from: l */
    public byte f49085l;

    /* renamed from: m */
    public String f49086m;

    /* renamed from: n */
    public String f49087n;

    /* renamed from: o */
    public String f49088o;

    /* renamed from: p */
    public String f49089p;

    /* renamed from: q */
    public String f49090q;

    /* renamed from: r */
    public int f49091r;

    /* renamed from: s */
    public int f49092s;

    /* renamed from: t */
    public List<C10070i> f49093t;

    /* renamed from: u */
    public boolean f49094u;

    /* renamed from: v */
    public long f49095v;

    /* renamed from: w */
    public boolean f49096w;

    /* renamed from: x */
    public boolean f49097x;

    /* renamed from: y */
    public boolean f49098y;

    /* renamed from: z */
    public final Path f49099z;

    public C10064c(String str) {
        this(str, false);
    }

    /* renamed from: R */
    public static /* synthetic */ boolean m62543R(C10070i c10070i) {
        return c10070i.m62665b() > 0 || c10070i.m62664a() > 0;
    }

    /* renamed from: S */
    public static String m62544S(String str, boolean z10) {
        String property;
        int iIndexOf;
        if (!z10 && (property = System.getProperty("os.name")) != null) {
            String lowerCase = property.toLowerCase(Locale.ROOT);
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char cCharAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (iIndexOf = str.indexOf(58)) != -1) {
                str = str.substring(iIndexOf + 1);
            }
        }
        String strReplace = str.replace(File.separatorChar, C5929g4.f26852n);
        while (!z10 && strReplace.startsWith("/")) {
            strReplace = strReplace.substring(1);
        }
        return strReplace;
    }

    /* renamed from: T */
    public static Instant m62545T(String str) throws IOException {
        if (!f49070E.matcher(str).matches()) {
            throw new IOException("Corrupted PAX header. Time field value is invalid '" + str + "'");
        }
        BigDecimal bigDecimal = new BigDecimal(str);
        try {
            return Instant.ofEpochSecond(bigDecimal.longValue(), bigDecimal.remainder(BigDecimal.ONE).movePointRight(9).longValue());
        } catch (ArithmeticException | DateTimeException e10) {
            throw new IOException("Corrupted PAX header. Time field value is invalid '" + str + "'", e10);
        }
    }

    /* renamed from: d */
    public static FileTime m62547d(long j10) {
        if (j10 <= 0) {
            return null;
        }
        return C11378l.m68238b(j10);
    }

    /* renamed from: A */
    public boolean m62548A() {
        return this.f49094u;
    }

    /* renamed from: B */
    public boolean m62549B() {
        Path path = this.f49099z;
        if (path != null) {
            return Files.isRegularFile(path, this.f49071A);
        }
        byte b10 = this.f49085l;
        if (b10 == 0 || b10 == 48) {
            return true;
        }
        return (b10 == 53 || m62607t().endsWith("/")) ? false : true;
    }

    /* renamed from: C */
    public boolean m62550C() {
        return this.f49085l == 75;
    }

    /* renamed from: D */
    public boolean m62551D() {
        return this.f49085l == 76;
    }

    /* renamed from: E */
    public boolean m62552E() {
        return m62557J() || m62559L();
    }

    /* renamed from: F */
    public boolean m62553F() {
        return this.f49085l == 103;
    }

    /* renamed from: G */
    public final boolean m62554G(byte[] bArr) {
        byte b10 = bArr[475];
        if (b10 == 0) {
            return false;
        }
        if (bArr[156] != 77) {
            return true;
        }
        return (bArr[464] & 128) == 0 && b10 != 32;
    }

    /* renamed from: H */
    public final boolean m62555H(byte[] bArr, int i10, int i11) {
        if ((bArr[i10] & 128) == 0) {
            int i12 = i11 - 1;
            for (int i13 = 0; i13 < i12; i13++) {
                byte b10 = bArr[i10 + i13];
                if (b10 < 48 || b10 > 55) {
                    return true;
                }
            }
            byte b11 = bArr[i10 + i12];
            if (b11 != 32 && b11 != 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: I */
    public boolean m62556I() {
        return this.f49085l == 49;
    }

    /* renamed from: J */
    public boolean m62557J() {
        return this.f49085l == 83;
    }

    /* renamed from: K */
    public boolean m62558K() {
        return this.f49097x;
    }

    /* renamed from: L */
    public boolean m62559L() {
        return this.f49096w;
    }

    /* renamed from: M */
    public boolean m62560M() {
        byte b10 = this.f49085l;
        return b10 == 120 || b10 == 88;
    }

    /* renamed from: N */
    public boolean m62561N() {
        return m62552E() || m62562O();
    }

    /* renamed from: O */
    public boolean m62562O() {
        return this.f49098y;
    }

    /* renamed from: P */
    public boolean m62563P() {
        return this.f49085l == 50;
    }

    /* renamed from: Q */
    public final boolean m62564Q(Map<String, String> map, byte[] bArr) {
        if (C11367a.m68207c("tar\u0000", bArr, 508, 4)) {
            return true;
        }
        String str = map.get("SCHILY.archtype");
        return str != null ? "xustar".equals(str) || "exustar".equals(str) : (m62554G(bArr) || m62555H(bArr, 476, 12) || m62555H(bArr, 488, 12)) ? false : true;
    }

    /* renamed from: U */
    public final long m62565U(byte[] bArr, int i10, int i11, boolean z10) {
        if (!z10) {
            return C10071j.m62683r(bArr, i10, i11);
        }
        try {
            return C10071j.m62683r(bArr, i10, i11);
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    /* renamed from: V */
    public final void m62566V(Map<String, String> map, byte[] bArr, InterfaceC10359b interfaceC10359b, boolean z10, boolean z11) throws IOException {
        try {
            m62567W(map, bArr, interfaceC10359b, z10, z11);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Corrupted TAR archive.", e10);
        }
    }

    /* renamed from: W */
    public final void m62567W(Map<String, String> map, byte[] bArr, InterfaceC10359b interfaceC10359b, boolean z10, boolean z11) throws IOException {
        this.f49074a = z10 ? C10071j.m62680o(bArr, 0, 100) : C10071j.m62681p(bArr, 0, 100, interfaceC10359b);
        this.f49076c = (int) m62565U(bArr, 100, 8, z11);
        this.f49077d = (int) m62565U(bArr, 108, 8, z11);
        this.f49078e = (int) m62565U(bArr, 116, 8, z11);
        long jM62683r = C10071j.m62683r(bArr, 124, 12);
        this.f49079f = jM62683r;
        if (jM62683r < 0) {
            throw new IOException("broken archive, entry with negative size");
        }
        this.f49080g = C11378l.m68238b(m62565U(bArr, SyncType.AUTO_SYNC_PHONE_MANAGER, 12, z11));
        this.f49084k = C10071j.m62689x(bArr);
        this.f49085l = bArr[156];
        this.f49086m = z10 ? C10071j.m62680o(bArr, 157, 100) : C10071j.m62681p(bArr, 157, 100, interfaceC10359b);
        this.f49087n = C10071j.m62680o(bArr, 257, 6);
        this.f49088o = C10071j.m62680o(bArr, 263, 2);
        this.f49089p = z10 ? C10071j.m62680o(bArr, 265, 32) : C10071j.m62681p(bArr, 265, 32, interfaceC10359b);
        this.f49090q = z10 ? C10071j.m62680o(bArr, 297, 32) : C10071j.m62681p(bArr, 297, 32, interfaceC10359b);
        byte b10 = this.f49085l;
        if (b10 == 51 || b10 == 52) {
            this.f49091r = (int) m62565U(bArr, 329, 8, z11);
            this.f49092s = (int) m62565U(bArr, 337, 8, z11);
        }
        int iM62574c = m62574c(map, bArr);
        if (iM62574c == 2) {
            this.f49082i = m62547d(m62565U(bArr, 345, 12, z11));
            this.f49081h = m62547d(m62565U(bArr, 357, 12, z11));
            this.f49093t = new ArrayList(C10071j.m62688w(bArr, 386, 4));
            this.f49094u = C10071j.m62678m(bArr, 482);
            this.f49095v = C10071j.m62682q(bArr, 483, 12);
            return;
        }
        if (iM62574c == 4) {
            String strM62680o = z10 ? C10071j.m62680o(bArr, 345, SyncType.AUTO_SYNC_CALLLOG) : C10071j.m62681p(bArr, 345, SyncType.AUTO_SYNC_CALLLOG, interfaceC10359b);
            if (!strM62680o.isEmpty()) {
                this.f49074a = strM62680o + "/" + this.f49074a;
            }
            this.f49082i = m62547d(m62565U(bArr, 476, 12, z11));
            this.f49081h = m62547d(m62565U(bArr, 488, 12, z11));
            return;
        }
        String strM62680o2 = z10 ? C10071j.m62680o(bArr, 345, 155) : C10071j.m62681p(bArr, 345, 155, interfaceC10359b);
        if (m62614z() && !this.f49074a.endsWith("/")) {
            this.f49074a += "/";
        }
        if (strM62680o2.isEmpty()) {
            return;
        }
        this.f49074a = strM62680o2 + "/" + this.f49074a;
    }

    /* renamed from: X */
    public final void m62568X(String str, String str2, Map<String, String> map) throws IOException {
        str.hashCode();
        switch (str) {
            case "SCHILY.devmajor":
                int iM68233a = C11377k.m68233a(str2);
                if (iM68233a < 0) {
                    throw new IOException("Corrupted TAR archive. Dev-Major is negative");
                }
                m62573b0(iM68233a);
                return;
            case "SCHILY.devminor":
                int iM68233a2 = C11377k.m68233a(str2);
                if (iM68233a2 < 0) {
                    throw new IOException("Corrupted TAR archive. Dev-Minor is negative");
                }
                m62575c0(iM68233a2);
                return;
            case "GNU.sparse.realsize":
                m62583h(map);
                return;
            case "GNU.sparse.size":
                m62581g(map);
                return;
            case "gid":
                m62576d0(C11377k.m68235c(str2));
                return;
            case "uid":
                m62598o0(C11377k.m68235c(str2));
                return;
            case "path":
                m62590k0(str2);
                return;
            case "size":
                long jM68235c = C11377k.m68235c(str2);
                if (jM68235c < 0) {
                    throw new IOException("Corrupted TAR archive. Entry size is negative");
                }
                m62592l0(jM68235c);
                return;
            case "atime":
                m62580f0(FileTime.from(m62545T(str2)));
                return;
            case "ctime":
                m62596n0(FileTime.from(m62545T(str2)));
                return;
            case "gname":
                m62578e0(str2);
                return;
            case "mtime":
                m62582g0(FileTime.from(m62545T(str2)));
                return;
            case "uname":
                m62600p0(str2);
                return;
            case "LIBARCHIVE.creationtime":
                m62571a0(FileTime.from(m62545T(str2)));
                return;
            case "SCHILY.filetype":
                if ("sparse".equals(str2)) {
                    m62585i(map);
                    return;
                }
                return;
            case "linkpath":
                m62584h0(str2);
                return;
            default:
                this.f49072B.put(str, str2);
                return;
        }
    }

    /* renamed from: Y */
    public final void m62569Y(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        if (!Files.isDirectory(path, linkOptionArr)) {
            this.f49076c = 33188;
            this.f49085l = (byte) 48;
            this.f49074a = str;
            this.f49079f = Files.size(path);
            return;
        }
        this.f49076c = 16877;
        this.f49085l = (byte) 53;
        int length = str.length();
        if (length != 0 && str.charAt(length - 1) == '/') {
            this.f49074a = str;
            return;
        }
        this.f49074a = str + "/";
    }

    /* renamed from: Z */
    public final void m62570Z(Path path, LinkOption... linkOptionArr) throws IOException {
        Set<String> setSupportedFileAttributeViews = path.getFileSystem().supportedFileAttributeViews();
        if (!setSupportedFileAttributeViews.contains("posix")) {
            if (setSupportedFileAttributeViews.contains("dos")) {
                DosFileAttributes dosFileAttributes = (DosFileAttributes) Files.readAttributes(path, DosFileAttributes.class, linkOptionArr);
                m62582g0(dosFileAttributes.lastModifiedTime());
                m62571a0(dosFileAttributes.creationTime());
                m62580f0(dosFileAttributes.lastAccessTime());
            } else {
                BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, linkOptionArr);
                m62582g0(attributes.lastModifiedTime());
                m62571a0(attributes.creationTime());
                m62580f0(attributes.lastAccessTime());
            }
            this.f49089p = Files.getOwner(path, linkOptionArr).getName();
            return;
        }
        PosixFileAttributes posixFileAttributes = (PosixFileAttributes) Files.readAttributes(path, PosixFileAttributes.class, linkOptionArr);
        m62582g0(posixFileAttributes.lastModifiedTime());
        m62571a0(posixFileAttributes.creationTime());
        m62580f0(posixFileAttributes.lastAccessTime());
        this.f49089p = posixFileAttributes.owner().getName();
        this.f49090q = posixFileAttributes.group().getName();
        if (setSupportedFileAttributeViews.contains("unix")) {
            this.f49077d = ((Number) Files.getAttribute(path, "unix:uid", linkOptionArr)).longValue();
            this.f49078e = ((Number) Files.getAttribute(path, "unix:gid", linkOptionArr)).longValue();
            try {
                m62596n0((FileTime) Files.getAttribute(path, "unix:ctime", linkOptionArr));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* renamed from: a0 */
    public void m62571a0(FileTime fileTime) {
        this.f49083j = fileTime;
    }

    /* renamed from: b */
    public boolean m62572b(C10064c c10064c) {
        return c10064c != null && m62607t().equals(c10064c.m62607t());
    }

    /* renamed from: b0 */
    public void m62573b0(int i10) {
        if (i10 >= 0) {
            this.f49091r = i10;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i10);
    }

    /* renamed from: c */
    public final int m62574c(Map<String, String> map, byte[] bArr) {
        if (C11367a.m68207c("ustar ", bArr, 257, 6)) {
            return 2;
        }
        if (C11367a.m68207c("ustar\u0000", bArr, 257, 6)) {
            return m62564Q(map, bArr) ? 4 : 3;
        }
        return 0;
    }

    /* renamed from: c0 */
    public void m62575c0(int i10) {
        if (i10 >= 0) {
            this.f49092s = i10;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i10);
    }

    /* renamed from: d0 */
    public void m62576d0(long j10) {
        this.f49078e = j10;
    }

    /* renamed from: e */
    public final int m62577e(byte b10, int i10, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i10 + i12] = b10;
        }
        return i10 + i11;
    }

    /* renamed from: e0 */
    public void m62578e0(String str) {
        this.f49090q = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return m62572b((C10064c) obj);
    }

    /* renamed from: f */
    public final int m62579f(int i10, int i11, byte[] bArr, int i12) {
        return m62577e((byte) i10, i11, bArr, i12);
    }

    /* renamed from: f0 */
    public void m62580f0(FileTime fileTime) {
        this.f49082i = fileTime;
    }

    /* renamed from: g */
    public void m62581g(Map<String, String> map) throws IOException {
        this.f49096w = true;
        this.f49095v = C11377k.m68233a(map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.f49074a = map.get("GNU.sparse.name");
        }
    }

    /* renamed from: g0 */
    public void m62582g0(FileTime fileTime) {
        Objects.requireNonNull(fileTime, "Time must not be null");
        this.f49080g = fileTime;
    }

    /* renamed from: h */
    public void m62583h(Map<String, String> map) throws IOException {
        this.f49096w = true;
        this.f49097x = true;
        if (map.containsKey("GNU.sparse.name")) {
            this.f49074a = map.get("GNU.sparse.name");
        }
        if (map.containsKey("GNU.sparse.realsize")) {
            this.f49095v = C11377k.m68233a(map.get("GNU.sparse.realsize"));
        }
    }

    /* renamed from: h0 */
    public void m62584h0(String str) {
        this.f49086m = str;
    }

    public int hashCode() {
        return m62607t().hashCode();
    }

    /* renamed from: i */
    public void m62585i(Map<String, String> map) throws IOException {
        this.f49098y = true;
        if (map.containsKey("SCHILY.realsize")) {
            this.f49095v = C11377k.m68235c(map.get("SCHILY.realsize"));
        }
    }

    /* renamed from: i0 */
    public void m62586i0(long j10) {
        m62582g0(FileTime.fromMillis(j10));
    }

    /* renamed from: j */
    public FileTime m62587j() {
        return this.f49083j;
    }

    /* renamed from: j0 */
    public void m62588j0(int i10) {
        this.f49076c = i10;
    }

    /* renamed from: k */
    public int m62589k() {
        return this.f49091r;
    }

    /* renamed from: k0 */
    public void m62590k0(String str) {
        this.f49074a = m62544S(str, this.f49075b);
    }

    /* renamed from: l */
    public int m62591l() {
        return this.f49092s;
    }

    /* renamed from: l0 */
    public void m62592l0(long j10) {
        if (j10 >= 0) {
            this.f49079f = j10;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j10);
    }

    /* renamed from: m */
    public Map<String, String> m62593m() {
        return Collections.unmodifiableMap(this.f49072B);
    }

    /* renamed from: m0 */
    public void m62594m0(List<C10070i> list) {
        this.f49093t = list;
    }

    /* renamed from: n */
    public FileTime m62595n() {
        return this.f49082i;
    }

    /* renamed from: n0 */
    public void m62596n0(FileTime fileTime) {
        this.f49081h = fileTime;
    }

    /* renamed from: o */
    public FileTime m62597o() {
        return this.f49080g;
    }

    /* renamed from: o0 */
    public void m62598o0(long j10) {
        this.f49077d = j10;
    }

    /* renamed from: p */
    public String m62599p() {
        return this.f49086m;
    }

    /* renamed from: p0 */
    public void m62600p0(String str) {
        this.f49089p = str;
    }

    /* renamed from: q */
    public long m62601q() {
        return this.f49078e;
    }

    /* renamed from: q0 */
    public void m62602q0(Map<String, String> map) throws IOException {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            m62568X(entry.getKey(), entry.getValue(), map);
        }
    }

    /* renamed from: r */
    public long m62603r() {
        return this.f49077d;
    }

    /* renamed from: r0 */
    public void m62604r0(byte[] bArr, InterfaceC10359b interfaceC10359b, boolean z10) throws IOException {
        int iM62606s0 = m62606s0(C11378l.m68237a(this.f49080g), bArr, m62606s0(this.f49079f, bArr, m62606s0(this.f49078e, bArr, m62606s0(this.f49077d, bArr, m62606s0(this.f49076c, bArr, C10071j.m62674i(this.f49074a, bArr, 0, 100, interfaceC10359b), 8, z10), 8, z10), 8, z10), 12, z10), 12, z10);
        int iM62577e = m62577e((byte) 32, iM62606s0, bArr, 8);
        bArr[iM62577e] = this.f49085l;
        int iM62606s02 = m62606s0(this.f49092s, bArr, m62606s0(this.f49091r, bArr, C10071j.m62674i(this.f49090q, bArr, C10071j.m62674i(this.f49089p, bArr, C10071j.m62673h(this.f49088o, bArr, C10071j.m62673h(this.f49087n, bArr, C10071j.m62674i(this.f49086m, bArr, iM62577e + 1, 100, interfaceC10359b), 6), 2), 32, interfaceC10359b), 32, interfaceC10359b), 8, z10), 8, z10);
        if (z10) {
            iM62606s02 = m62579f(0, m62579f(0, m62608t0(this.f49081h, m62608t0(this.f49082i, m62579f(0, iM62606s02, bArr, SyncType.AUTO_SYNC_CALLLOG), bArr, 12), bArr, 12), bArr, 8), bArr, 4);
        }
        m62579f(0, iM62606s02, bArr, bArr.length - iM62606s02);
        C10071j.m62669d(C10071j.m62666a(bArr), bArr, iM62606s0, 8);
    }

    /* renamed from: s */
    public int m62605s() {
        return this.f49076c;
    }

    /* renamed from: s0 */
    public final int m62606s0(long j10, byte[] bArr, int i10, int i11, boolean z10) {
        return (z10 || (j10 >= 0 && j10 < (1 << ((i11 + (-1)) * 3)))) ? C10071j.m62672g(j10, bArr, i10, i11) : C10071j.m62671f(0L, bArr, i10, i11);
    }

    /* renamed from: t */
    public String m62607t() {
        return this.f49074a;
    }

    /* renamed from: t0 */
    public final int m62608t0(FileTime fileTime, int i10, byte[] bArr, int i11) {
        return fileTime != null ? m62606s0(C11378l.m68237a(fileTime), bArr, i10, i11, true) : m62579f(0, i10, bArr, i11);
    }

    /* renamed from: u */
    public List<C10070i> m62609u() throws IOException {
        List<C10070i> list = this.f49093t;
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        List<C10070i> list2 = (List) this.f49093t.stream().filter(new Predicate() { // from class: gy.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10064c.m62543R((C10070i) obj);
            }
        }).sorted(Comparator.comparingLong(new ToLongFunction() { // from class: gy.b
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((C10070i) obj).m62665b();
            }
        })).collect(Collectors.toList());
        int size = list2.size();
        int i10 = 0;
        while (i10 < size) {
            C10070i c10070i = list2.get(i10);
            i10++;
            if (i10 < size && c10070i.m62665b() + c10070i.m62664a() > list2.get(i10).m62665b()) {
                throw new IOException("Corrupted TAR archive. Sparse blocks for " + m62607t() + " overlap each other.");
            }
            if (c10070i.m62665b() + c10070i.m62664a() < 0) {
                throw new IOException("Unreadable TAR archive. Offset and numbytes for sparse block in " + m62607t() + " too large.");
            }
        }
        if (!list2.isEmpty()) {
            C10070i c10070i2 = list2.get(size - 1);
            if (c10070i2.m62665b() + c10070i2.m62664a() > m62610v()) {
                throw new IOException("Corrupted TAR archive. Sparse block extends beyond real size of the entry");
            }
        }
        return list2;
    }

    /* renamed from: v */
    public long m62610v() {
        return !m62561N() ? m62611w() : this.f49095v;
    }

    /* renamed from: w */
    public long m62611w() {
        return this.f49079f;
    }

    /* renamed from: x */
    public List<C10070i> m62612x() {
        return this.f49093t;
    }

    /* renamed from: y */
    public FileTime m62613y() {
        return this.f49081h;
    }

    /* renamed from: z */
    public boolean m62614z() {
        Path path = this.f49099z;
        if (path != null) {
            return Files.isDirectory(path, this.f49071A);
        }
        if (this.f49085l == 53) {
            return true;
        }
        return (m62560M() || m62553F() || !m62607t().endsWith("/")) ? false : true;
    }

    public C10064c(String str, byte b10) {
        this(str, b10, false);
    }

    public C10064c(Map<String, String> map, byte[] bArr, InterfaceC10359b interfaceC10359b, boolean z10) throws IOException {
        this(false);
        m62566V(map, bArr, interfaceC10359b, false, z10);
    }

    public C10064c(boolean z10) {
        this.f49074a = "";
        this.f49086m = "";
        this.f49087n = "ustar\u0000";
        this.f49088o = "00";
        this.f49090q = "";
        this.f49072B = new HashMap();
        this.f49073C = -1L;
        String property = System.getProperty("user.name", "");
        this.f49089p = property.length() > 31 ? property.substring(0, 31) : property;
        this.f49099z = null;
        this.f49071A = C11376j.f53107a;
        this.f49075b = z10;
    }

    public C10064c(File file, String str) {
        this.f49074a = "";
        this.f49086m = "";
        this.f49087n = "ustar\u0000";
        this.f49088o = "00";
        this.f49090q = "";
        this.f49072B = new HashMap();
        this.f49073C = -1L;
        String strM62544S = m62544S(str, false);
        Path path = file.toPath();
        this.f49099z = path;
        this.f49071A = C11376j.f53107a;
        try {
            m62569Y(path, strM62544S, new LinkOption[0]);
        } catch (IOException unused) {
            if (!file.isDirectory()) {
                this.f49079f = file.length();
            }
        }
        this.f49089p = "";
        try {
            m62570Z(this.f49099z, new LinkOption[0]);
        } catch (IOException unused2) {
            this.f49080g = FileTime.fromMillis(file.lastModified());
        }
        this.f49075b = false;
    }

    public C10064c(String str, boolean z10) {
        this(z10);
        String strM62544S = m62544S(str, z10);
        boolean zEndsWith = strM62544S.endsWith("/");
        this.f49074a = strM62544S;
        this.f49076c = zEndsWith ? 16877 : 33188;
        this.f49085l = zEndsWith ? (byte) 53 : (byte) 48;
        this.f49080g = FileTime.from(Instant.now());
        this.f49089p = "";
    }

    public C10064c(String str, byte b10, boolean z10) {
        this(str, z10);
        this.f49085l = b10;
        if (b10 == 76) {
            this.f49087n = "ustar ";
            this.f49088o = " \u0000";
        }
    }
}
