package p301fy;

import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import ly.C11369c;
import ly.C11370d;
import ly.C11371e;
import ly.C11376j;
import my.C11562e;
import p241dy.C9360a;

/* renamed from: fy.t */
/* loaded from: classes9.dex */
public class C9802t implements Closeable {

    /* renamed from: n */
    public static final byte[] f48174n = {55, 122, -68, -81, 39, 28};

    /* renamed from: a */
    public final String f48175a;

    /* renamed from: b */
    public SeekableByteChannel f48176b;

    /* renamed from: c */
    public final C9787e f48177c;

    /* renamed from: d */
    public int f48178d;

    /* renamed from: e */
    public int f48179e;

    /* renamed from: f */
    public InputStream f48180f;

    /* renamed from: g */
    public byte[] f48181g;

    /* renamed from: h */
    public long f48182h;

    /* renamed from: i */
    public long f48183i;

    /* renamed from: j */
    public final ArrayList<InputStream> f48184j;

    /* renamed from: k */
    public final int f48185k;

    /* renamed from: l */
    public final boolean f48186l;

    /* renamed from: m */
    public final boolean f48187m;

    /* renamed from: fy.t$b */
    public static final class b {

        /* renamed from: a */
        public int f48189a;

        /* renamed from: b */
        public long f48190b;

        /* renamed from: c */
        public long f48191c;

        /* renamed from: d */
        public long f48192d;

        /* renamed from: e */
        public long f48193e;

        /* renamed from: f */
        public int f48194f;

        /* renamed from: g */
        public BitSet f48195g;

        /* renamed from: h */
        public int f48196h;

        /* renamed from: i */
        public int f48197i;

        public b() {
        }

        /* renamed from: j */
        public static /* synthetic */ long m60965j(b bVar, long j10) {
            long j11 = bVar.f48190b + j10;
            bVar.f48190b = j11;
            return j11;
        }

        /* renamed from: l */
        public static /* synthetic */ long m60967l(b bVar, long j10) {
            long j11 = bVar.f48191c + j10;
            bVar.f48191c = j11;
            return j11;
        }

        /* renamed from: n */
        public static /* synthetic */ long m60969n(b bVar, long j10) {
            long j11 = bVar.f48192d + j10;
            bVar.f48192d = j11;
            return j11;
        }

        /* renamed from: q */
        public void m60972q(int i10) throws IOException {
            int i11 = this.f48197i;
            if (i11 > 0 && this.f48194f == 0) {
                throw new IOException("archive with entries but no folders");
            }
            if (i11 > this.f48193e) {
                throw new IOException("archive doesn't contain enough substreams for entries");
            }
            long jM60976u = m60976u() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
            if (i10 < jM60976u) {
                throw new C9360a(jM60976u, i10);
            }
        }

        /* renamed from: r */
        public final long m60973r() {
            return 16L;
        }

        /* renamed from: s */
        public final long m60974s() {
            return 22L;
        }

        /* renamed from: t */
        public final long m60975t() {
            return 100L;
        }

        public String toString() {
            return "Archive with " + this.f48196h + " entries in " + this.f48194f + " folders. Estimated size " + (m60976u() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + " kB.";
        }

        /* renamed from: u */
        public long m60976u() {
            long jM60977v = (this.f48189a * 16) + (r0 / 8) + (this.f48194f * m60977v()) + (this.f48190b * m60974s()) + ((this.f48191c - this.f48194f) * m60973r());
            long j10 = this.f48192d;
            long j11 = this.f48191c;
            return (jM60977v + (((j10 - j11) + this.f48194f) * 8) + (j11 * 8) + (this.f48196h * m60975t()) + m60978w()) * 2;
        }

        /* renamed from: v */
        public final long m60977v() {
            return 30L;
        }

        /* renamed from: w */
        public final long m60978w() {
            return (this.f48194f * 8) + (this.f48189a * 8) + (this.f48196h * 4);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    @Deprecated
    public C9802t(File file, C9803u c9803u) throws IOException {
        this(file, null, c9803u);
    }

    /* renamed from: B */
    public static /* synthetic */ C9797o m60905B(Integer num) {
        return new C9797o();
    }

    /* renamed from: C */
    public static /* synthetic */ C9797o[] m60906C(int i10) {
        return new C9797o[i10];
    }

    /* renamed from: D */
    public static SeekableByteChannel m60907D(File file) throws IOException {
        return Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]);
    }

    /* renamed from: e */
    public static /* synthetic */ long m60910e(C9802t c9802t, long j10) {
        long j11 = c9802t.f48182h + j10;
        c9802t.f48182h = j11;
        return j11;
    }

    /* renamed from: f */
    public static int m60911f(String str, long j10) throws IOException {
        if (j10 > 2147483647L || j10 < 0) {
            throw new IOException(String.format("Cannot handle % %,d", str, Long.valueOf(j10)));
        }
        return (int) j10;
    }

    /* renamed from: g0 */
    public static long m60912g0(ByteBuffer byteBuffer) throws IOException {
        long jM60919y = m60919y(byteBuffer);
        int i10 = 128;
        long jM60919y2 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            if ((i10 & jM60919y) == 0) {
                return ((jM60919y & (i10 - 1)) << (i11 * 8)) | jM60919y2;
            }
            jM60919y2 |= m60919y(byteBuffer) << (i11 * 8);
            i10 >>>= 1;
        }
        return jM60919y2;
    }

    /* renamed from: j */
    public static ByteBuffer m60913j(ByteBuffer byteBuffer, int i10) throws EOFException {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining >= i10) {
            return byteBuffer;
        }
        throw new EOFException(String.format("remaining %,d < expectRemaining %,d", Integer.valueOf(iRemaining), Integer.valueOf(i10)));
    }

    /* renamed from: m */
    public static void m60914m(ByteBuffer byteBuffer, byte[] bArr) throws EOFException {
        m60913j(byteBuffer, bArr.length).get(bArr);
    }

    /* renamed from: n */
    public static char m60915n(ByteBuffer byteBuffer) throws EOFException {
        return m60913j(byteBuffer, 2).getChar();
    }

    /* renamed from: v */
    public static int m60916v(ByteBuffer byteBuffer) throws EOFException {
        return m60913j(byteBuffer, 4).getInt();
    }

    /* renamed from: w */
    public static long m60917w(ByteBuffer byteBuffer) throws EOFException {
        return m60913j(byteBuffer, 8).getLong();
    }

    /* renamed from: x0 */
    public static long m60918x0(ByteBuffer byteBuffer, long j10) {
        if (j10 < 1) {
            return 0L;
        }
        int iPosition = byteBuffer.position();
        long jRemaining = byteBuffer.remaining();
        if (jRemaining < j10) {
            j10 = jRemaining;
        }
        byteBuffer.position(iPosition + ((int) j10));
        return j10;
    }

    /* renamed from: y */
    public static int m60919y(ByteBuffer byteBuffer) throws EOFException {
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        throw new EOFException();
    }

    /* renamed from: A */
    public final C9787e m60920A(C9806x c9806x, byte[] bArr, boolean z10) throws IOException {
        m60911f("nextHeaderSize", c9806x.f48221b);
        int i10 = (int) c9806x.f48221b;
        this.f48176b.position(c9806x.f48220a + 32);
        if (z10) {
            long jPosition = this.f48176b.position();
            CheckedInputStream checkedInputStream = new CheckedInputStream(Channels.newInputStream(this.f48176b), new CRC32());
            long j10 = i10;
            if (checkedInputStream.skip(j10) != j10) {
                throw new IOException("Problem computing NextHeader CRC-32");
            }
            if (c9806x.f48222c != checkedInputStream.getChecksum().getValue()) {
                throw new IOException("NextHeader CRC-32 mismatch");
            }
            this.f48176b.position(jPosition);
        }
        C9787e c9787e = new C9787e();
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
        m60928V(byteBufferOrder);
        int iM60919y = m60919y(byteBufferOrder);
        if (iM60919y == 23) {
            byteBufferOrder = m60925H(byteBufferOrder, c9787e, bArr);
            c9787e = new C9787e();
            iM60919y = m60919y(byteBufferOrder);
        }
        if (iM60919y != 1) {
            throw new IOException("Broken or unsupported archive: no Header");
        }
        m60929X(byteBufferOrder, c9787e);
        c9787e.f48128f = null;
        return c9787e;
    }

    /* renamed from: B0 */
    public final C9787e m60921B0(byte[] bArr) throws IOException {
        C9787e c9787eM60920A;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1);
        long jPosition = this.f48176b.position() + 20;
        long jPosition2 = this.f48176b.position() + 1048576 > this.f48176b.size() ? this.f48176b.position() : this.f48176b.size() - 1048576;
        long size = this.f48176b.size() - 1;
        while (size > jPosition2) {
            size--;
            this.f48176b.position(size);
            byteBufferAllocate.rewind();
            if (this.f48176b.read(byteBufferAllocate) < 1) {
                throw new EOFException();
            }
            byte b10 = byteBufferAllocate.array()[0];
            if (b10 == 23 || b10 == 1) {
                try {
                    try {
                        c9787eM60920A = m60920A(new C9806x(size - jPosition, this.f48176b.size() - size, 0L), bArr, false);
                    } catch (Exception unused) {
                        continue;
                    }
                } catch (Exception unused2) {
                }
                if (c9787eM60920A.f48124b.length > 0 && c9787eM60920A.f48129g.length > 0) {
                    return c9787eM60920A;
                }
            }
        }
        throw new IOException("Start header corrupt and unable to guess end header");
    }

    /* renamed from: E */
    public final BitSet m60922E(ByteBuffer byteBuffer, int i10) throws IOException {
        if (m60919y(byteBuffer) == 0) {
            return m60924G(byteBuffer, i10);
        }
        BitSet bitSet = new BitSet(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            bitSet.set(i11, true);
        }
        return bitSet;
    }

    /* renamed from: F */
    public final void m60923F(ByteBuffer byteBuffer) throws IOException {
        int iM60919y = m60919y(byteBuffer);
        while (iM60919y != 0) {
            m60914m(byteBuffer, new byte[(int) m60912g0(byteBuffer)]);
            iM60919y = m60919y(byteBuffer);
        }
    }

    /* renamed from: G */
    public final BitSet m60924G(ByteBuffer byteBuffer, int i10) throws IOException {
        BitSet bitSet = new BitSet(i10);
        int i11 = 0;
        int iM60919y = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (i11 == 0) {
                iM60919y = m60919y(byteBuffer);
                i11 = 128;
            }
            bitSet.set(i12, (iM60919y & i11) != 0);
            i11 >>>= 1;
        }
        return bitSet;
    }

    /* renamed from: H */
    public final ByteBuffer m60925H(ByteBuffer byteBuffer, C9787e c9787e, byte[] bArr) throws IOException {
        int iPosition = byteBuffer.position();
        b bVar = new b(null);
        m60947s0(byteBuffer, bVar);
        bVar.m60972q(this.f48185k);
        byteBuffer.position(iPosition);
        m60933b0(byteBuffer, c9787e);
        C9793k[] c9793kArr = c9787e.f48127e;
        if (c9793kArr == null || c9793kArr.length == 0) {
            throw new IOException("no folders, can't read encoded header");
        }
        long[] jArr = c9787e.f48124b;
        if (jArr == null || jArr.length == 0) {
            throw new IOException("no packed streams, can't read encoded header");
        }
        C9793k c9793k = c9793kArr[0];
        this.f48176b.position(c9787e.f48123a + 32);
        C9789g c9789g = new C9789g(this.f48176b, c9787e.f48124b[0]);
        InputStream c11371e = c9789g;
        for (C9790h c9790h : c9793k.m60872c()) {
            if (c9790h.f48137b != 1 || c9790h.f48138c != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            c11371e = C9791i.m60867a(this.f48175a, c11371e, c9793k.m60874e(c9790h), c9790h, bArr, this.f48185k);
        }
        if (c9793k.f48151g) {
            c11371e = new C11371e(c11371e, c9793k.m60873d(), c9793k.f48152h);
        }
        int iM60911f = m60911f("unpackSize", c9793k.m60873d());
        byte[] bArrM68231e = C11376j.m68231e(c11371e, iM60911f);
        if (bArrM68231e.length < iM60911f) {
            throw new IOException("premature end of stream");
        }
        c11371e.close();
        return ByteBuffer.wrap(bArrM68231e).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: I */
    public final void m60926I(ByteBuffer byteBuffer, C9787e c9787e) throws IOException {
        C9787e c9787e2 = c9787e;
        int iM60912g0 = (int) m60912g0(byteBuffer);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        BitSet bitSetM60924G = null;
        BitSet bitSetM60924G2 = null;
        BitSet bitSetM60924G3 = null;
        while (true) {
            int iM60919y = m60919y(byteBuffer);
            int i10 = 0;
            if (iM60919y == 0) {
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < iM60912g0; i13++) {
                    C9797o c9797o = linkedHashMap.get(Integer.valueOf(i13));
                    if (c9797o != null) {
                        c9797o.m60901w(bitSetM60924G == null || !bitSetM60924G.get(i13));
                        if (!c9797o.m60889k()) {
                            c9797o.m60896r(bitSetM60924G2 == null || !bitSetM60924G2.get(i11));
                            c9797o.m60892n(bitSetM60924G3 != null && bitSetM60924G3.get(i11));
                            c9797o.m60898t(false);
                            c9797o.m60877A(0L);
                            i11++;
                        } else {
                            if (c9787e2.f48128f == null) {
                                throw new IOException("Archive contains file with streams but no subStreamsInfo");
                            }
                            c9797o.m60896r(false);
                            c9797o.m60892n(false);
                            c9797o.m60898t(c9787e2.f48128f.f48228b.get(i12));
                            c9797o.m60894p(c9787e2.f48128f.f48229c[i12]);
                            c9797o.m60877A(c9787e2.f48128f.f48227a[i12]);
                            if (c9797o.m60888j() < 0) {
                                throw new IOException("broken archive, entry with negative size");
                            }
                            i12++;
                        }
                    }
                }
                c9787e2.f48129g = (C9797o[]) linkedHashMap.values().stream().filter(new Predicate() { // from class: fy.p
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return Objects.nonNull((C9797o) obj);
                    }
                }).toArray(new IntFunction() { // from class: fy.q
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i14) {
                        return C9802t.m60906C(i14);
                    }
                });
                m60937i(c9787e2);
                return;
            }
            long jM60912g0 = m60912g0(byteBuffer);
            if (iM60919y != 25) {
                switch (iM60919y) {
                    case 14:
                        bitSetM60924G = m60924G(byteBuffer, iM60912g0);
                        break;
                    case 15:
                        bitSetM60924G2 = m60924G(byteBuffer, bitSetM60924G.cardinality());
                        break;
                    case 16:
                        bitSetM60924G3 = m60924G(byteBuffer, bitSetM60924G.cardinality());
                        break;
                    case 17:
                        m60919y(byteBuffer);
                        int i14 = (int) (jM60912g0 - 1);
                        byte[] bArr = new byte[i14];
                        m60914m(byteBuffer, bArr);
                        int i15 = 0;
                        int i16 = 0;
                        while (i10 < i14) {
                            if (bArr[i10] == 0 && bArr[i10 + 1] == 0) {
                                m60940k(linkedHashMap, i16);
                                linkedHashMap.get(Integer.valueOf(i16)).m60904z(new String(bArr, i15, i10 - i15, StandardCharsets.UTF_16LE));
                                i16++;
                                i15 = i10 + 2;
                            }
                            i10 += 2;
                        }
                        if (i15 != i14 || i16 != iM60912g0) {
                            break;
                        } else {
                            break;
                        }
                        break;
                    case 18:
                        BitSet bitSetM60922E = m60922E(byteBuffer, iM60912g0);
                        m60919y(byteBuffer);
                        while (i10 < iM60912g0) {
                            m60940k(linkedHashMap, i10);
                            C9797o c9797o2 = linkedHashMap.get(Integer.valueOf(i10));
                            c9797o2.m60899u(bitSetM60922E.get(i10));
                            if (c9797o2.m60884f()) {
                                c9797o2.m60895q(m60917w(byteBuffer));
                            }
                            i10++;
                        }
                        break;
                    case 19:
                        BitSet bitSetM60922E2 = m60922E(byteBuffer, iM60912g0);
                        m60919y(byteBuffer);
                        while (i10 < iM60912g0) {
                            m60940k(linkedHashMap, i10);
                            C9797o c9797o3 = linkedHashMap.get(Integer.valueOf(i10));
                            c9797o3.m60897s(bitSetM60922E2.get(i10));
                            if (c9797o3.m60882d()) {
                                c9797o3.m60891m(m60917w(byteBuffer));
                            }
                            i10++;
                        }
                        break;
                    case 20:
                        BitSet bitSetM60922E3 = m60922E(byteBuffer, iM60912g0);
                        m60919y(byteBuffer);
                        while (i10 < iM60912g0) {
                            m60940k(linkedHashMap, i10);
                            C9797o c9797o4 = linkedHashMap.get(Integer.valueOf(i10));
                            c9797o4.m60900v(bitSetM60922E3.get(i10));
                            if (c9797o4.m60885g()) {
                                c9797o4.m60903y(m60917w(byteBuffer));
                            }
                            i10++;
                        }
                        break;
                    case 21:
                        BitSet bitSetM60922E4 = m60922E(byteBuffer, iM60912g0);
                        m60919y(byteBuffer);
                        while (i10 < iM60912g0) {
                            m60940k(linkedHashMap, i10);
                            C9797o c9797o5 = linkedHashMap.get(Integer.valueOf(i10));
                            c9797o5.m60902x(bitSetM60922E4.get(i10));
                            if (c9797o5.m60886h()) {
                                c9797o5.m60878B(m60916v(byteBuffer));
                            }
                            i10++;
                        }
                        break;
                    default:
                        m60918x0(byteBuffer, jM60912g0);
                        break;
                }
            } else {
                m60918x0(byteBuffer, jM60912g0);
            }
            c9787e2 = c9787e;
        }
        throw new IOException("Error parsing file names");
    }

    /* renamed from: J */
    public final C9793k m60927J(ByteBuffer byteBuffer) throws IOException {
        long jM60912g0;
        long jM60912g02;
        byte[] bArr;
        C9793k c9793k = new C9793k();
        int iM60912g0 = (int) m60912g0(byteBuffer);
        C9790h[] c9790hArr = new C9790h[iM60912g0];
        long j10 = 0;
        long j11 = 0;
        for (int i10 = 0; i10 < iM60912g0; i10++) {
            int iM60919y = m60919y(byteBuffer);
            int i11 = iM60919y & 15;
            boolean z10 = (iM60919y & 16) == 0;
            boolean z11 = (iM60919y & 32) != 0;
            boolean z12 = (iM60919y & 128) != 0;
            byte[] bArr2 = new byte[i11];
            m60914m(byteBuffer, bArr2);
            if (z10) {
                jM60912g0 = 1;
                jM60912g02 = 1;
            } else {
                jM60912g0 = m60912g0(byteBuffer);
                jM60912g02 = m60912g0(byteBuffer);
            }
            j10 += jM60912g0;
            j11 += jM60912g02;
            if (z11) {
                bArr = new byte[(int) m60912g0(byteBuffer)];
                m60914m(byteBuffer, bArr);
            } else {
                bArr = null;
            }
            byte[] bArr3 = bArr;
            if (z12) {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
            c9790hArr[i10] = new C9790h(bArr2, jM60912g0, jM60912g02, bArr3);
        }
        c9793k.f48145a = c9790hArr;
        c9793k.f48146b = j10;
        c9793k.f48147c = j11;
        long j12 = j11 - 1;
        int i12 = (int) j12;
        C9788f[] c9788fArr = new C9788f[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            c9788fArr[i13] = new C9788f(m60912g0(byteBuffer), m60912g0(byteBuffer));
        }
        c9793k.f48148d = c9788fArr;
        long j13 = j10 - j12;
        int i14 = (int) j13;
        long[] jArr = new long[i14];
        if (j13 == 1) {
            int i15 = 0;
            while (i15 < ((int) j10) && c9793k.m60870a(i15) >= 0) {
                i15++;
            }
            jArr[0] = i15;
        } else {
            for (int i16 = 0; i16 < i14; i16++) {
                jArr[i16] = m60912g0(byteBuffer);
            }
        }
        c9793k.f48149e = jArr;
        return c9793k;
    }

    /* renamed from: V */
    public final void m60928V(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.rewind();
        C11376j.m68230d(this.f48176b, byteBuffer);
        byteBuffer.flip();
    }

    /* renamed from: X */
    public final void m60929X(ByteBuffer byteBuffer, C9787e c9787e) throws IOException {
        int iPosition = byteBuffer.position();
        m60941m0(byteBuffer).m60972q(this.f48185k);
        byteBuffer.position(iPosition);
        int iM60919y = m60919y(byteBuffer);
        if (iM60919y == 2) {
            m60923F(byteBuffer);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 3) {
            throw new IOException("Additional streams unsupported");
        }
        if (iM60919y == 4) {
            m60933b0(byteBuffer, c9787e);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 5) {
            m60926I(byteBuffer, c9787e);
            m60919y(byteBuffer);
        }
    }

    /* renamed from: Y */
    public final C9787e m60930Y(byte[] bArr) throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        m60928V(byteBufferOrder);
        byte[] bArr2 = new byte[6];
        byteBufferOrder.get(bArr2);
        if (!Arrays.equals(bArr2, f48174n)) {
            throw new IOException("Bad 7z signature");
        }
        byte b10 = byteBufferOrder.get();
        byte b11 = byteBufferOrder.get();
        if (b10 != 0) {
            throw new IOException(String.format("Unsupported 7z version (%d,%d)", Byte.valueOf(b10), Byte.valueOf(b11)));
        }
        long j10 = byteBufferOrder.getInt() & 4294967295L;
        if (j10 == 0) {
            long jPosition = this.f48176b.position();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
            m60928V(byteBufferAllocate);
            this.f48176b.position(jPosition);
            while (byteBufferAllocate.hasRemaining()) {
                if (byteBufferAllocate.get() != 0) {
                }
            }
            if (this.f48187m) {
                return m60921B0(bArr);
            }
            throw new IOException("archive seems to be invalid.\nYou may want to retry and enable the tryToRecoverBrokenArchives if the archive could be a multi volume archive that has been closed prematurely.");
        }
        return m60920A(m60932a0(j10), bArr, true);
    }

    /* renamed from: Z */
    public final void m60931Z(ByteBuffer byteBuffer, C9787e c9787e) throws IOException {
        c9787e.f48123a = m60912g0(byteBuffer);
        int iM60912g0 = (int) m60912g0(byteBuffer);
        int iM60919y = m60919y(byteBuffer);
        if (iM60919y == 9) {
            c9787e.f48124b = new long[iM60912g0];
            int i10 = 0;
            while (true) {
                long[] jArr = c9787e.f48124b;
                if (i10 >= jArr.length) {
                    break;
                }
                jArr[i10] = m60912g0(byteBuffer);
                i10++;
            }
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 10) {
            c9787e.f48125c = m60922E(byteBuffer, iM60912g0);
            c9787e.f48126d = new long[iM60912g0];
            for (int i11 = 0; i11 < iM60912g0; i11++) {
                if (c9787e.f48125c.get(i11)) {
                    c9787e.f48126d[i11] = m60916v(byteBuffer) & 4294967295L;
                }
            }
            m60919y(byteBuffer);
        }
    }

    /* renamed from: a0 */
    public final C9806x m60932a0(long j10) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new C11371e(new C9789g(this.f48176b, 20L), 20L, j10));
        try {
            long jReverseBytes = Long.reverseBytes(dataInputStream.readLong());
            if (jReverseBytes < 0 || jReverseBytes + 32 > this.f48176b.size()) {
                throw new IOException("nextHeaderOffset is out of bounds");
            }
            long jReverseBytes2 = Long.reverseBytes(dataInputStream.readLong());
            long j11 = jReverseBytes + jReverseBytes2;
            if (j11 < jReverseBytes || j11 + 32 > this.f48176b.size()) {
                throw new IOException("nextHeaderSize is out of bounds");
            }
            C9806x c9806x = new C9806x(jReverseBytes, jReverseBytes2, 4294967295L & Integer.reverseBytes(dataInputStream.readInt()));
            dataInputStream.close();
            return c9806x;
        } catch (Throwable th2) {
            try {
                dataInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: b0 */
    public final void m60933b0(ByteBuffer byteBuffer, C9787e c9787e) throws IOException {
        int iM60919y = m60919y(byteBuffer);
        if (iM60919y == 6) {
            m60931Z(byteBuffer, c9787e);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 7) {
            m60938i0(byteBuffer, c9787e);
            iM60919y = m60919y(byteBuffer);
        } else {
            c9787e.f48127e = C9793k.f48144j;
        }
        if (iM60919y == 8) {
            m60934c0(byteBuffer, c9787e);
            m60919y(byteBuffer);
        }
    }

    /* renamed from: c0 */
    public final void m60934c0(ByteBuffer byteBuffer, C9787e c9787e) throws IOException {
        for (C9793k c9793k : c9787e.f48127e) {
            c9793k.f48153i = 1;
        }
        long length = c9787e.f48127e.length;
        int iM60919y = m60919y(byteBuffer);
        if (iM60919y == 13) {
            long j10 = 0;
            for (C9793k c9793k2 : c9787e.f48127e) {
                long jM60912g0 = m60912g0(byteBuffer);
                c9793k2.f48153i = (int) jM60912g0;
                j10 += jM60912g0;
            }
            iM60919y = m60919y(byteBuffer);
            length = j10;
        }
        C9808z c9808z = new C9808z((int) length);
        int i10 = 0;
        for (C9793k c9793k3 : c9787e.f48127e) {
            if (c9793k3.f48153i != 0) {
                long j11 = 0;
                if (iM60919y == 9) {
                    int i11 = 0;
                    while (i11 < c9793k3.f48153i - 1) {
                        long jM60912g02 = m60912g0(byteBuffer);
                        c9808z.f48227a[i10] = jM60912g02;
                        j11 += jM60912g02;
                        i11++;
                        i10++;
                    }
                }
                if (j11 > c9793k3.m60873d()) {
                    throw new IOException("sum of unpack sizes of folder exceeds total unpack size");
                }
                c9808z.f48227a[i10] = c9793k3.m60873d() - j11;
                i10++;
            }
        }
        if (iM60919y == 9) {
            iM60919y = m60919y(byteBuffer);
        }
        int i12 = 0;
        for (C9793k c9793k4 : c9787e.f48127e) {
            int i13 = c9793k4.f48153i;
            if (i13 != 1 || !c9793k4.f48151g) {
                i12 += i13;
            }
        }
        if (iM60919y == 10) {
            BitSet bitSetM60922E = m60922E(byteBuffer, i12);
            long[] jArr = new long[i12];
            for (int i14 = 0; i14 < i12; i14++) {
                if (bitSetM60922E.get(i14)) {
                    jArr[i14] = m60916v(byteBuffer) & 4294967295L;
                }
            }
            int i15 = 0;
            int i16 = 0;
            for (C9793k c9793k5 : c9787e.f48127e) {
                if (c9793k5.f48153i == 1 && c9793k5.f48151g) {
                    c9808z.f48228b.set(i15, true);
                    c9808z.f48229c[i15] = c9793k5.f48152h;
                    i15++;
                } else {
                    for (int i17 = 0; i17 < c9793k5.f48153i; i17++) {
                        c9808z.f48228b.set(i15, bitSetM60922E.get(i16));
                        c9808z.f48229c[i15] = jArr[i16];
                        i15++;
                        i16++;
                    }
                }
            }
            m60919y(byteBuffer);
        }
        c9787e.f48128f = c9808z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SeekableByteChannel seekableByteChannel = this.f48176b;
        if (seekableByteChannel != null) {
            try {
                seekableByteChannel.close();
            } finally {
                this.f48176b = null;
                byte[] bArr = this.f48181g;
                if (bArr != null) {
                    Arrays.fill(bArr, (byte) 0);
                }
                this.f48181g = null;
            }
        }
    }

    /* renamed from: g */
    public final InputStream m60935g(C9793k c9793k, long j10, int i10, C9797o c9797o) throws IOException {
        this.f48176b.position(j10);
        a aVar = new a(new BufferedInputStream(new C9789g(this.f48176b, this.f48177c.f48124b[i10])));
        LinkedList linkedList = new LinkedList();
        InputStream inputStreamM60867a = aVar;
        for (C9790h c9790h : c9793k.m60872c()) {
            if (c9790h.f48137b != 1 || c9790h.f48138c != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            EnumC9804v enumC9804vM60983e = EnumC9804v.m60983e(c9790h.f48136a);
            inputStreamM60867a = C9791i.m60867a(this.f48175a, inputStreamM60867a, c9793k.m60874e(c9790h), c9790h, this.f48181g, this.f48185k);
            linkedList.addFirst(new C9805w(enumC9804vM60983e, C9791i.m60868b(enumC9804vM60983e).mo60862c(c9790h, inputStreamM60867a)));
        }
        c9797o.m60893o(linkedList);
        return c9793k.f48151g ? new C11371e(inputStreamM60867a, c9793k.m60873d(), c9793k.f48152h) : inputStreamM60867a;
    }

    /* renamed from: h */
    public final void m60936h(int i10, boolean z10) throws IOException {
        boolean z11;
        C9787e c9787e = this.f48177c;
        C9807y c9807y = c9787e.f48130h;
        if (c9807y == null) {
            throw new IOException("Archive doesn't contain stream information to read entries");
        }
        int i11 = c9807y.f48226d[i10];
        if (i11 < 0) {
            this.f48184j.clear();
            return;
        }
        C9797o[] c9797oArr = c9787e.f48129g;
        C9797o c9797o = c9797oArr[i10];
        if (this.f48179e == i11) {
            if (i10 > 0) {
                c9797o.m60893o(c9797oArr[i10 - 1].m60880b());
            }
            if (z10 && c9797o.m60880b() == null) {
                C9787e c9787e2 = this.f48177c;
                c9797o.m60893o(c9787e2.f48129g[c9787e2.f48130h.f48225c[i11]].m60880b());
            }
            z11 = true;
        } else {
            this.f48179e = i11;
            m60939j0(i11, c9797o);
            z11 = false;
        }
        boolean zM60954z0 = z10 ? m60954z0(i10, z11, i11) : false;
        if (z10 && this.f48178d == i10 && !zM60954z0) {
            return;
        }
        FilterInputStream c11369c = new C11369c(this.f48180f, c9797o.m60888j());
        if (c9797o.m60883e()) {
            c11369c = new C11371e(c11369c, c9797o.m60888j(), c9797o.m60881c());
        }
        this.f48184j.add(c11369c);
    }

    /* renamed from: i */
    public final void m60937i(C9787e c9787e) throws IOException {
        C9793k[] c9793kArr;
        C9793k[] c9793kArr2 = c9787e.f48127e;
        int length = c9793kArr2 != null ? c9793kArr2.length : 0;
        int[] iArr = new int[length];
        int length2 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = length2;
            length2 += c9787e.f48127e[i10].f48149e.length;
        }
        int length3 = c9787e.f48124b.length;
        long[] jArr = new long[length3];
        long j10 = 0;
        for (int i11 = 0; i11 < length3; i11++) {
            jArr[i11] = j10;
            j10 += c9787e.f48124b[i11];
        }
        int[] iArr2 = new int[length];
        int[] iArr3 = new int[c9787e.f48129g.length];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            C9797o[] c9797oArr = c9787e.f48129g;
            if (i12 >= c9797oArr.length) {
                c9787e.f48130h = new C9807y(iArr, jArr, iArr2, iArr3);
                return;
            }
            if (c9797oArr[i12].m60889k() || i13 != 0) {
                if (i13 == 0) {
                    while (true) {
                        c9793kArr = c9787e.f48127e;
                        if (i14 >= c9793kArr.length) {
                            break;
                        }
                        iArr2[i14] = i12;
                        if (c9793kArr[i14].f48153i > 0) {
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (i14 >= c9793kArr.length) {
                        throw new IOException("Too few folders in archive");
                    }
                }
                iArr3[i12] = i14;
                if (c9787e.f48129g[i12].m60889k() && (i13 = i13 + 1) >= c9787e.f48127e[i14].f48153i) {
                    i14++;
                    i13 = 0;
                }
            } else {
                iArr3[i12] = -1;
            }
            i12++;
        }
    }

    /* renamed from: i0 */
    public final void m60938i0(ByteBuffer byteBuffer, C9787e c9787e) throws IOException {
        m60919y(byteBuffer);
        int iM60912g0 = (int) m60912g0(byteBuffer);
        C9793k[] c9793kArr = new C9793k[iM60912g0];
        c9787e.f48127e = c9793kArr;
        m60919y(byteBuffer);
        for (int i10 = 0; i10 < iM60912g0; i10++) {
            c9793kArr[i10] = m60927J(byteBuffer);
        }
        m60919y(byteBuffer);
        for (int i11 = 0; i11 < iM60912g0; i11++) {
            C9793k c9793k = c9793kArr[i11];
            m60911f("totalOutputStreams", c9793k.f48147c);
            c9793k.f48150f = new long[(int) c9793k.f48147c];
            for (int i12 = 0; i12 < c9793k.f48147c; i12++) {
                c9793k.f48150f[i12] = m60912g0(byteBuffer);
            }
        }
        if (m60919y(byteBuffer) == 10) {
            BitSet bitSetM60922E = m60922E(byteBuffer, iM60912g0);
            for (int i13 = 0; i13 < iM60912g0; i13++) {
                if (bitSetM60922E.get(i13)) {
                    C9793k c9793k2 = c9793kArr[i13];
                    c9793k2.f48151g = true;
                    c9793k2.f48152h = m60916v(byteBuffer) & 4294967295L;
                } else {
                    c9793kArr[i13].f48151g = false;
                }
            }
            m60919y(byteBuffer);
        }
    }

    /* renamed from: j0 */
    public final void m60939j0(int i10, C9797o c9797o) throws IOException {
        this.f48184j.clear();
        InputStream inputStream = this.f48180f;
        if (inputStream != null) {
            inputStream.close();
            this.f48180f = null;
        }
        C9787e c9787e = this.f48177c;
        C9793k c9793k = c9787e.f48127e[i10];
        C9807y c9807y = c9787e.f48130h;
        int i11 = c9807y.f48223a[i10];
        this.f48180f = m60935g(c9793k, c9787e.f48123a + 32 + c9807y.f48224b[i11], i11, c9797o);
    }

    /* renamed from: k */
    public final void m60940k(Map<Integer, C9797o> map, int i10) {
        map.computeIfAbsent(Integer.valueOf(i10), new Function() { // from class: fy.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C9802t.m60905B((Integer) obj);
            }
        });
    }

    /* renamed from: m0 */
    public final b m60941m0(ByteBuffer byteBuffer) throws IOException {
        b bVar = new b(null);
        int iM60919y = m60919y(byteBuffer);
        if (iM60919y == 2) {
            m60942n0(byteBuffer);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 3) {
            throw new IOException("Additional streams unsupported");
        }
        if (iM60919y == 4) {
            m60947s0(byteBuffer, bVar);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 5) {
            m60943o0(byteBuffer, bVar);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 0) {
            return bVar;
        }
        throw new IOException("Badly terminated header, found " + iM60919y);
    }

    /* renamed from: n0 */
    public final void m60942n0(ByteBuffer byteBuffer) throws IOException {
        int iM60919y = m60919y(byteBuffer);
        while (iM60919y != 0) {
            long jM60911f = m60911f("propertySize", m60912g0(byteBuffer));
            if (m60918x0(byteBuffer, jM60911f) < jM60911f) {
                throw new IOException("invalid property size");
            }
            iM60919y = m60919y(byteBuffer);
        }
    }

    /* renamed from: o0 */
    public final void m60943o0(ByteBuffer byteBuffer, b bVar) throws IOException {
        bVar.f48196h = m60911f("numFiles", m60912g0(byteBuffer));
        int iCardinality = -1;
        while (true) {
            int iM60919y = m60919y(byteBuffer);
            if (iM60919y == 0) {
                bVar.f48197i = bVar.f48196h - Math.max(iCardinality, 0);
                return;
            }
            long jM60912g0 = m60912g0(byteBuffer);
            switch (iM60919y) {
                case 14:
                    iCardinality = m60924G(byteBuffer, bVar.f48196h).cardinality();
                    break;
                case 15:
                    if (iCardinality == -1) {
                        throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
                    }
                    m60924G(byteBuffer, iCardinality);
                    break;
                case 16:
                    if (iCardinality == -1) {
                        throw new IOException("Header format error: kEmptyStream must appear before kAnti");
                    }
                    m60924G(byteBuffer, iCardinality);
                    break;
                case 17:
                    if (m60919y(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    int iM60911f = m60911f("file names length", jM60912g0 - 1);
                    if ((iM60911f & 1) != 0) {
                        throw new IOException("File names length invalid");
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < iM60911f; i11 += 2) {
                        if (m60915n(byteBuffer) == 0) {
                            i10++;
                        }
                    }
                    if (i10 != bVar.f48196h) {
                        throw new IOException("Invalid number of file names (" + i10 + " instead of " + bVar.f48196h + ")");
                    }
                    break;
                case 18:
                    int iCardinality2 = m60922E(byteBuffer, bVar.f48196h).cardinality();
                    if (m60919y(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j10 = iCardinality2 * 8;
                    if (m60918x0(byteBuffer, j10) < j10) {
                        throw new IOException("invalid creation dates size");
                    }
                    break;
                case 19:
                    int iCardinality3 = m60922E(byteBuffer, bVar.f48196h).cardinality();
                    if (m60919y(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j11 = iCardinality3 * 8;
                    if (m60918x0(byteBuffer, j11) < j11) {
                        throw new IOException("invalid access dates size");
                    }
                    break;
                case 20:
                    int iCardinality4 = m60922E(byteBuffer, bVar.f48196h).cardinality();
                    if (m60919y(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j12 = iCardinality4 * 8;
                    if (m60918x0(byteBuffer, j12) < j12) {
                        throw new IOException("invalid modification dates size");
                    }
                    break;
                case 21:
                    int iCardinality5 = m60922E(byteBuffer, bVar.f48196h).cardinality();
                    if (m60919y(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j13 = iCardinality5 * 4;
                    if (m60918x0(byteBuffer, j13) < j13) {
                        throw new IOException("invalid windows attributes size");
                    }
                    break;
                case 22:
                case 23:
                default:
                    if (m60918x0(byteBuffer, jM60912g0) < jM60912g0) {
                        throw new IOException("Incomplete property of type " + iM60919y);
                    }
                    break;
                case 24:
                    throw new IOException("kStartPos is unsupported, please report");
                case 25:
                    if (m60918x0(byteBuffer, jM60912g0) < jM60912g0) {
                        throw new IOException("Incomplete kDummy property");
                    }
                    break;
            }
        }
    }

    /* renamed from: q0 */
    public final int m60944q0(ByteBuffer byteBuffer, b bVar) throws IOException {
        int iM60911f = m60911f("numCoders", m60912g0(byteBuffer));
        if (iM60911f == 0) {
            throw new IOException("Folder without coders");
        }
        b.m60965j(bVar, iM60911f);
        long jM60911f = 0;
        long j10 = 0;
        int i10 = 0;
        while (true) {
            long jM60911f2 = 1;
            if (i10 >= iM60911f) {
                m60911f("totalInStreams", jM60911f);
                m60911f("totalOutStreams", j10);
                b.m60967l(bVar, j10);
                b.m60969n(bVar, jM60911f);
                if (j10 == 0) {
                    throw new IOException("Total output streams can't be 0");
                }
                int iM60911f2 = m60911f("numBindPairs", j10 - 1);
                long j11 = iM60911f2;
                if (jM60911f < j11) {
                    throw new IOException("Total input streams can't be less than the number of bind pairs");
                }
                BitSet bitSet = new BitSet((int) jM60911f);
                for (int i11 = 0; i11 < iM60911f2; i11++) {
                    int iM60911f3 = m60911f("inIndex", m60912g0(byteBuffer));
                    if (jM60911f <= iM60911f3) {
                        throw new IOException("inIndex is bigger than number of inStreams");
                    }
                    bitSet.set(iM60911f3);
                    if (j10 <= m60911f("outIndex", m60912g0(byteBuffer))) {
                        throw new IOException("outIndex is bigger than number of outStreams");
                    }
                }
                int iM60911f4 = m60911f("numPackedStreams", jM60911f - j11);
                if (iM60911f4 != 1) {
                    for (int i12 = 0; i12 < iM60911f4; i12++) {
                        if (m60911f("packedStreamIndex", m60912g0(byteBuffer)) >= jM60911f) {
                            throw new IOException("packedStreamIndex is bigger than number of totalInStreams");
                        }
                    }
                } else if (bitSet.nextClearBit(0) == -1) {
                    throw new IOException("Couldn't find stream's bind pair index");
                }
                return (int) j10;
            }
            int iM60919y = m60919y(byteBuffer);
            m60914m(byteBuffer, new byte[iM60919y & 15]);
            boolean z10 = (iM60919y & 16) == 0;
            boolean z11 = (iM60919y & 32) != 0;
            if ((iM60919y & 128) != 0) {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
            if (z10) {
                jM60911f++;
            } else {
                jM60911f += m60911f("numInStreams", m60912g0(byteBuffer));
                jM60911f2 = m60911f("numOutStreams", m60912g0(byteBuffer));
            }
            j10 += jM60911f2;
            if (z11) {
                long jM60911f3 = m60911f("propertiesSize", m60912g0(byteBuffer));
                if (m60918x0(byteBuffer, jM60911f3) < jM60911f3) {
                    throw new IOException("invalid propertiesSize in folder");
                }
            }
            i10++;
        }
    }

    /* renamed from: r0 */
    public final void m60945r0(ByteBuffer byteBuffer, b bVar) throws IOException {
        long jM60912g0 = m60912g0(byteBuffer);
        long j10 = 0;
        if (jM60912g0 >= 0) {
            long j11 = 32 + jM60912g0;
            if (j11 <= this.f48176b.size() && j11 >= 0) {
                bVar.f48189a = m60911f("numPackStreams", m60912g0(byteBuffer));
                int iM60919y = m60919y(byteBuffer);
                if (iM60919y == 9) {
                    int i10 = 0;
                    long j12 = 0;
                    while (i10 < bVar.f48189a) {
                        long jM60912g02 = m60912g0(byteBuffer);
                        j12 += jM60912g02;
                        long j13 = j11 + j12;
                        if (jM60912g02 < j10 || j13 > this.f48176b.size() || j13 < jM60912g0) {
                            throw new IOException("packSize (" + jM60912g02 + ") is out of range");
                        }
                        i10++;
                        j10 = 0;
                    }
                    iM60919y = m60919y(byteBuffer);
                }
                if (iM60919y == 10) {
                    long jCardinality = m60922E(byteBuffer, bVar.f48189a).cardinality() * 4;
                    if (m60918x0(byteBuffer, jCardinality) < jCardinality) {
                        throw new IOException("invalid number of CRCs in PackInfo");
                    }
                    iM60919y = m60919y(byteBuffer);
                }
                if (iM60919y == 0) {
                    return;
                }
                throw new IOException("Badly terminated PackInfo (" + iM60919y + ")");
            }
        }
        throw new IOException("packPos (" + jM60912g0 + ") is out of range");
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        int i12 = m60946s().read(bArr, i10, i11);
        if (i12 > 0) {
            this.f48183i += i12;
        }
        return i12;
    }

    /* renamed from: s */
    public final InputStream m60946s() throws IOException {
        if (this.f48177c.f48129g[this.f48178d].m60888j() == 0) {
            return new ByteArrayInputStream(C11370d.f53098a);
        }
        if (this.f48184j.isEmpty()) {
            throw new IllegalStateException("No current 7z entry (call getNextEntry() first).");
        }
        while (this.f48184j.size() > 1) {
            InputStream inputStreamRemove = this.f48184j.remove(0);
            try {
                C11562e.m69037r(inputStreamRemove, Long.MAX_VALUE);
                if (inputStreamRemove != null) {
                    inputStreamRemove.close();
                }
                this.f48182h = 0L;
            } catch (Throwable th2) {
                if (inputStreamRemove != null) {
                    try {
                        inputStreamRemove.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        return this.f48184j.get(0);
    }

    /* renamed from: s0 */
    public final void m60947s0(ByteBuffer byteBuffer, b bVar) throws IOException {
        int iM60919y = m60919y(byteBuffer);
        if (iM60919y == 6) {
            m60945r0(byteBuffer, bVar);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 7) {
            m60951u0(byteBuffer, bVar);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y == 8) {
            m60949t0(byteBuffer, bVar);
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y != 0) {
            throw new IOException("Badly terminated StreamsInfo");
        }
    }

    /* renamed from: t */
    public String m60948t() {
        if ("unknown archive".equals(this.f48175a) || this.f48175a == null) {
            return null;
        }
        String name = new File(this.f48175a).getName();
        int iLastIndexOf = name.lastIndexOf(".");
        if (iLastIndexOf > 0) {
            return name.substring(0, iLastIndexOf);
        }
        return name + "~";
    }

    /* renamed from: t0 */
    public final void m60949t0(ByteBuffer byteBuffer, b bVar) throws IOException {
        int iCardinality;
        int iM60919y = m60919y(byteBuffer);
        LinkedList linkedList = new LinkedList();
        int i10 = 0;
        if (iM60919y == 13) {
            for (int i11 = 0; i11 < bVar.f48194f; i11++) {
                linkedList.add(Integer.valueOf(m60911f("numStreams", m60912g0(byteBuffer))));
            }
            bVar.f48193e = linkedList.stream().mapToLong(new ToLongFunction() { // from class: fy.r
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((Integer) obj).longValue();
                }
            }).sum();
            iM60919y = m60919y(byteBuffer);
        } else {
            bVar.f48193e = bVar.f48194f;
        }
        m60911f("totalUnpackStreams", bVar.f48193e);
        if (iM60919y == 9) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (iIntValue != 0) {
                    for (int i12 = 0; i12 < iIntValue - 1; i12++) {
                        if (m60912g0(byteBuffer) < 0) {
                            throw new IOException("negative unpackSize");
                        }
                    }
                }
            }
            iM60919y = m60919y(byteBuffer);
        }
        if (linkedList.isEmpty()) {
            iCardinality = bVar.f48195g == null ? bVar.f48194f : bVar.f48194f - bVar.f48195g.cardinality();
        } else {
            Iterator it2 = linkedList.iterator();
            int i13 = 0;
            while (it2.hasNext()) {
                int iIntValue2 = ((Integer) it2.next()).intValue();
                if (iIntValue2 == 1 && bVar.f48195g != null) {
                    int i14 = i13 + 1;
                    if (bVar.f48195g.get(i13)) {
                        i13 = i14;
                    } else {
                        i13 = i14;
                    }
                }
                i10 += iIntValue2;
            }
            iCardinality = i10;
        }
        if (iM60919y == 10) {
            m60911f("numDigests", iCardinality);
            long jCardinality = m60922E(byteBuffer, iCardinality).cardinality() * 4;
            if (m60918x0(byteBuffer, jCardinality) < jCardinality) {
                throw new IOException("invalid number of missing CRCs in SubStreamInfo");
            }
            iM60919y = m60919y(byteBuffer);
        }
        if (iM60919y != 0) {
            throw new IOException("Badly terminated SubStreamsInfo");
        }
    }

    public String toString() {
        return this.f48177c.toString();
    }

    /* renamed from: u */
    public Iterable<C9797o> m60950u() {
        return new ArrayList(Arrays.asList(this.f48177c.f48129g));
    }

    /* renamed from: u0 */
    public final void m60951u0(ByteBuffer byteBuffer, b bVar) throws IOException {
        int iM60919y = m60919y(byteBuffer);
        if (iM60919y != 11) {
            throw new IOException("Expected kFolder, got " + iM60919y);
        }
        bVar.f48194f = m60911f("numFolders", m60912g0(byteBuffer));
        if (m60919y(byteBuffer) != 0) {
            throw new IOException("External unsupported");
        }
        LinkedList linkedList = new LinkedList();
        for (int i10 = 0; i10 < bVar.f48194f; i10++) {
            linkedList.add(Integer.valueOf(m60944q0(byteBuffer, bVar)));
        }
        if (bVar.f48192d - (bVar.f48191c - bVar.f48194f) < bVar.f48189a) {
            throw new IOException("archive doesn't contain enough packed streams");
        }
        int iM60919y2 = m60919y(byteBuffer);
        if (iM60919y2 != 12) {
            throw new IOException("Expected kCodersUnpackSize, got " + iM60919y2);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            for (int i11 = 0; i11 < iIntValue; i11++) {
                if (m60912g0(byteBuffer) < 0) {
                    throw new IllegalArgumentException("negative unpackSize");
                }
            }
        }
        int iM60919y3 = m60919y(byteBuffer);
        if (iM60919y3 == 10) {
            bVar.f48195g = m60922E(byteBuffer, bVar.f48194f);
            long jCardinality = bVar.f48195g.cardinality() * 4;
            if (m60918x0(byteBuffer, jCardinality) < jCardinality) {
                throw new IOException("invalid number of CRCs in UnpackInfo");
            }
            iM60919y3 = m60919y(byteBuffer);
        }
        if (iM60919y3 != 0) {
            throw new IOException("Badly terminated UnpackInfo");
        }
    }

    /* renamed from: x */
    public C9797o m60952x() throws IOException {
        int i10 = this.f48178d;
        C9797o[] c9797oArr = this.f48177c.f48129g;
        if (i10 >= c9797oArr.length - 1) {
            return null;
        }
        int i11 = i10 + 1;
        this.f48178d = i11;
        C9797o c9797o = c9797oArr[i11];
        if (c9797o.m60887i() == null && this.f48186l) {
            c9797o.m60904z(m60948t());
        }
        m60936h(this.f48178d, false);
        this.f48182h = 0L;
        this.f48183i = 0L;
        return c9797o;
    }

    /* renamed from: z */
    public final boolean m60953z() {
        if (this.f48184j.isEmpty()) {
            return false;
        }
        ArrayList<InputStream> arrayList = this.f48184j;
        InputStream inputStream = arrayList.get(arrayList.size() - 1);
        return inputStream instanceof C11369c ? ((C11369c) inputStream).m68217x() != this.f48177c.f48129g[this.f48178d].m60888j() : (inputStream instanceof C11371e) && ((C11371e) inputStream).m68220s() != this.f48177c.f48129g[this.f48178d].m60888j();
    }

    /* renamed from: z0 */
    public final boolean m60954z0(int i10, boolean z10, int i11) throws IOException {
        C9797o c9797o = this.f48177c.f48129g[i10];
        if (this.f48178d == i10 && !m60953z()) {
            return false;
        }
        int i12 = this.f48177c.f48130h.f48225c[this.f48179e];
        if (z10) {
            int i13 = this.f48178d;
            if (i13 < i10) {
                i12 = i13 + 1;
            } else {
                m60939j0(i11, c9797o);
            }
        }
        while (i12 < i10) {
            C9797o c9797o2 = this.f48177c.f48129g[i12];
            FilterInputStream c11369c = new C11369c(this.f48180f, c9797o2.m60888j());
            if (c9797o2.m60883e()) {
                c11369c = new C11371e(c11369c, c9797o2.m60888j(), c9797o2.m60881c());
            }
            this.f48184j.add(c11369c);
            c9797o2.m60893o(c9797o.m60880b());
            i12++;
        }
        return true;
    }

    /* renamed from: fy.t$a */
    public class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        /* renamed from: d */
        public final void m60955d(int i10) {
            C9802t.m60910e(C9802t.this, i10);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (i12 >= 0) {
                m60955d(i12);
            }
            return i12;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 >= 0) {
                m60955d(1);
            }
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }
    }

    @Deprecated
    public C9802t(File file) throws IOException {
        this(file, C9803u.f48198d);
    }

    @Deprecated
    public C9802t(File file, char[] cArr, C9803u c9803u) throws IOException {
        this(m60907D(file), file.getAbsolutePath(), C9784b.m60857g(cArr), true, c9803u);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public C9802t(SeekableByteChannel seekableByteChannel, String str, byte[] bArr, boolean z10, int i10, boolean z11, boolean z12) throws IOException {
        this.f48178d = -1;
        this.f48179e = -1;
        this.f48184j = new ArrayList<>();
        this.f48176b = seekableByteChannel;
        this.f48175a = str;
        this.f48185k = i10;
        this.f48186l = z11;
        this.f48187m = z12;
        try {
            this.f48177c = m60930Y(bArr);
            if (bArr != null) {
                this.f48181g = Arrays.copyOf(bArr, bArr.length);
            } else {
                this.f48181g = null;
            }
        } catch (Throwable th2) {
            if (z10) {
                this.f48176b.close();
            }
            throw th2;
        }
    }

    @Deprecated
    public C9802t(SeekableByteChannel seekableByteChannel, String str, byte[] bArr, boolean z10, C9803u c9803u) throws IOException {
        this(seekableByteChannel, str, bArr, z10, c9803u.m60979a(), c9803u.m60981c(), c9803u.m60980b());
    }
}
