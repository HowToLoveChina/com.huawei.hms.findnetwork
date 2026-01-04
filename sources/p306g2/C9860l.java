package p306g2;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import p003a2.InterfaceC0007b;
import p630s2.C12676k;

/* renamed from: g2.l */
/* loaded from: classes.dex */
public final class C9860l implements ImageHeaderParser {

    /* renamed from: a */
    public static final byte[] f48425a = "Exif\u0000\u0000".getBytes(Charset.forName(Constants.UTF_8));

    /* renamed from: b */
    public static final int[] f48426b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: g2.l$a */
    public static final class a implements c {

        /* renamed from: a */
        public final ByteBuffer f48427a;

        public a(ByteBuffer byteBuffer) {
            this.f48427a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // p306g2.C9860l.c
        /* renamed from: a */
        public int mo61249a() throws c.a {
            return mo61251c() | (mo61251c() << 8);
        }

        @Override // p306g2.C9860l.c
        /* renamed from: b */
        public int mo61250b(byte[] bArr, int i10) {
            int iMin = Math.min(i10, this.f48427a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f48427a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // p306g2.C9860l.c
        /* renamed from: c */
        public short mo61251c() throws c.a {
            if (this.f48427a.remaining() >= 1) {
                return (short) (this.f48427a.get() & 255);
            }
            throw new c.a();
        }

        @Override // p306g2.C9860l.c
        public long skip(long j10) {
            int iMin = (int) Math.min(this.f48427a.remaining(), j10);
            ByteBuffer byteBuffer = this.f48427a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* renamed from: g2.l$b */
    public static final class b {

        /* renamed from: a */
        public final ByteBuffer f48428a;

        public b(byte[] bArr, int i10) {
            this.f48428a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        /* renamed from: a */
        public short m61252a(int i10) {
            if (m61254c(i10, 2)) {
                return this.f48428a.getShort(i10);
            }
            return (short) -1;
        }

        /* renamed from: b */
        public int m61253b(int i10) {
            if (m61254c(i10, 4)) {
                return this.f48428a.getInt(i10);
            }
            return -1;
        }

        /* renamed from: c */
        public final boolean m61254c(int i10, int i11) {
            return this.f48428a.remaining() - i10 >= i11;
        }

        /* renamed from: d */
        public int m61255d() {
            return this.f48428a.remaining();
        }

        /* renamed from: e */
        public void m61256e(ByteOrder byteOrder) {
            this.f48428a.order(byteOrder);
        }
    }

    /* renamed from: g2.l$c */
    public interface c {

        /* renamed from: g2.l$c$a */
        public static final class a extends IOException {
            private static final long serialVersionUID = 1;

            public a() {
                super("Unexpectedly reached end of a file");
            }
        }

        /* renamed from: a */
        int mo61249a() throws IOException;

        /* renamed from: b */
        int mo61250b(byte[] bArr, int i10) throws IOException;

        /* renamed from: c */
        short mo61251c() throws IOException;

        long skip(long j10) throws IOException;
    }

    /* renamed from: g2.l$d */
    public static final class d implements c {

        /* renamed from: a */
        public final InputStream f48429a;

        public d(InputStream inputStream) {
            this.f48429a = inputStream;
        }

        @Override // p306g2.C9860l.c
        /* renamed from: a */
        public int mo61249a() throws IOException {
            return mo61251c() | (mo61251c() << 8);
        }

        @Override // p306g2.C9860l.c
        /* renamed from: b */
        public int mo61250b(byte[] bArr, int i10) throws IOException {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10 && (i12 = this.f48429a.read(bArr, i11, i10 - i11)) != -1) {
                i11 += i12;
            }
            if (i11 == 0 && i12 == -1) {
                throw new c.a();
            }
            return i11;
        }

        @Override // p306g2.C9860l.c
        /* renamed from: c */
        public short mo61251c() throws IOException {
            int i10 = this.f48429a.read();
            if (i10 != -1) {
                return (short) i10;
            }
            throw new c.a();
        }

        @Override // p306g2.C9860l.c
        public long skip(long j10) throws IOException {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long jSkip = this.f48429a.skip(j11);
                if (jSkip <= 0) {
                    if (this.f48429a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j11 -= jSkip;
            }
            return j10 - j11;
        }
    }

    /* renamed from: e */
    public static int m61240e(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    /* renamed from: h */
    public static boolean m61241h(int i10) {
        return (i10 & 65496) == 65496 || i10 == 19789 || i10 == 18761;
    }

    /* renamed from: k */
    public static int m61242k(b bVar) {
        ByteOrder byteOrder;
        short sM61252a = bVar.m61252a(6);
        if (sM61252a != 18761) {
            if (sM61252a != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sM61252a));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.m61256e(byteOrder);
        int iM61253b = bVar.m61253b(10) + 6;
        short sM61252a2 = bVar.m61252a(iM61253b);
        for (int i10 = 0; i10 < sM61252a2; i10++) {
            int iM61240e = m61240e(iM61253b, i10);
            short sM61252a3 = bVar.m61252a(iM61240e);
            if (sM61252a3 == 274) {
                short sM61252a4 = bVar.m61252a(iM61240e + 2);
                if (sM61252a4 >= 1 && sM61252a4 <= 12) {
                    int iM61253b2 = bVar.m61253b(iM61240e + 4);
                    if (iM61253b2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i10 + " tagType=" + ((int) sM61252a3) + " formatCode=" + ((int) sM61252a4) + " componentCount=" + iM61253b2);
                        }
                        int i11 = iM61253b2 + f48426b[sM61252a4];
                        if (i11 <= 4) {
                            int i12 = iM61240e + 8;
                            if (i12 >= 0 && i12 <= bVar.m61255d()) {
                                if (i11 >= 0 && i11 + i12 <= bVar.m61255d()) {
                                    return bVar.m61252a(i12);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sM61252a3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i12 + " tagType=" + ((int) sM61252a3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sM61252a4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sM61252a4));
                }
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo8996a(ByteBuffer byteBuffer) throws IOException {
        return m61244g(new a((ByteBuffer) C12676k.m76276d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: b */
    public ImageHeaderParser.ImageType mo8997b(InputStream inputStream) throws IOException {
        return m61244g(new d((InputStream) C12676k.m76276d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: c */
    public int mo8998c(InputStream inputStream, InterfaceC0007b interfaceC0007b) throws IOException {
        return m61243f(new d((InputStream) C12676k.m76276d(inputStream)), (InterfaceC0007b) C12676k.m76276d(interfaceC0007b));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: d */
    public int mo8999d(ByteBuffer byteBuffer, InterfaceC0007b interfaceC0007b) throws IOException {
        return m61243f(new a((ByteBuffer) C12676k.m76276d(byteBuffer)), (InterfaceC0007b) C12676k.m76276d(interfaceC0007b));
    }

    /* renamed from: f */
    public final int m61243f(c cVar, InterfaceC0007b interfaceC0007b) throws IOException {
        try {
            int iMo61249a = cVar.mo61249a();
            if (!m61241h(iMo61249a)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iMo61249a);
                }
                return -1;
            }
            int iM61246j = m61246j(cVar);
            if (iM61246j == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) interfaceC0007b.mo10c(iM61246j, byte[].class);
            try {
                return m61247l(cVar, bArr, iM61246j);
            } finally {
                interfaceC0007b.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    /* renamed from: g */
    public final ImageHeaderParser.ImageType m61244g(c cVar) throws IOException {
        try {
            int iMo61249a = cVar.mo61249a();
            if (iMo61249a == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iMo61251c = (iMo61249a << 8) | cVar.mo61251c();
            if (iMo61251c == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iMo61251c2 = (iMo61251c << 8) | cVar.mo61251c();
            if (iMo61251c2 == -1991225785) {
                cVar.skip(21L);
                try {
                    return cVar.mo61251c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iMo61251c2 != 1380533830) {
                return m61248m(cVar, iMo61251c2) ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if (((cVar.mo61249a() << 16) | cVar.mo61249a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iMo61249a2 = (cVar.mo61249a() << 16) | cVar.mo61249a();
            if ((iMo61249a2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i10 = iMo61249a2 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            if (i10 == 88) {
                cVar.skip(4L);
                short sMo61251c = cVar.mo61251c();
                return (sMo61251c & 2) != 0 ? ImageHeaderParser.ImageType.ANIMATED_WEBP : (sMo61251c & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i10 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            cVar.skip(4L);
            return (cVar.mo61251c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    /* renamed from: i */
    public final boolean m61245i(byte[] bArr, int i10) {
        boolean z10 = bArr != null && i10 > f48425a.length;
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f48425a;
                if (i11 >= bArr2.length) {
                    break;
                }
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
                i11++;
            }
        }
        return z10;
    }

    /* renamed from: j */
    public final int m61246j(c cVar) throws IOException {
        short sMo61251c;
        int iMo61249a;
        long j10;
        long jSkip;
        do {
            short sMo61251c2 = cVar.mo61251c();
            if (sMo61251c2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sMo61251c2));
                }
                return -1;
            }
            sMo61251c = cVar.mo61251c();
            if (sMo61251c == 218) {
                return -1;
            }
            if (sMo61251c == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iMo61249a = cVar.mo61249a() - 2;
            if (sMo61251c == 225) {
                return iMo61249a;
            }
            j10 = iMo61249a;
            jSkip = cVar.skip(j10);
        } while (jSkip == j10);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sMo61251c) + ", wanted to skip: " + iMo61249a + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    /* renamed from: l */
    public final int m61247l(c cVar, byte[] bArr, int i10) throws IOException {
        int iMo61250b = cVar.mo61250b(bArr, i10);
        if (iMo61250b == i10) {
            if (m61245i(bArr, i10)) {
                return m61242k(new b(bArr, i10));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i10 + ", actually read: " + iMo61250b);
        }
        return -1;
    }

    /* renamed from: m */
    public final boolean m61248m(c cVar, int i10) throws IOException {
        if (((cVar.mo61249a() << 16) | cVar.mo61249a()) != 1718909296) {
            return false;
        }
        int iMo61249a = (cVar.mo61249a() << 16) | cVar.mo61249a();
        if (iMo61249a == 1635150182 || iMo61249a == 1635150195) {
            return true;
        }
        cVar.skip(4L);
        int i11 = i10 - 16;
        if (i11 % 4 != 0) {
            return false;
        }
        int i12 = 0;
        while (i12 < 5 && i11 > 0) {
            int iMo61249a2 = (cVar.mo61249a() << 16) | cVar.mo61249a();
            if (iMo61249a2 == 1635150182 || iMo61249a2 == 1635150195) {
                return true;
            }
            i12++;
            i11 -= 4;
        }
        return false;
    }
}
