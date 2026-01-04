package com.huawei.openalliance.p169ad.views.gif;

import android.graphics.Bitmap;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.openalliance.ad.views.gif.a */
/* loaded from: classes2.dex */
public class C8100a {

    /* renamed from: c */
    private static final String f37675c = "a";

    /* renamed from: C */
    private int[] f37678C;

    /* renamed from: D */
    private int f37679D;

    /* renamed from: F */
    private Bitmap f37681F;

    /* renamed from: G */
    private int[] f37682G;

    /* renamed from: I */
    private int f37684I;

    /* renamed from: J */
    private int f37685J;

    /* renamed from: K */
    private int f37686K;

    /* renamed from: L */
    private int f37687L;

    /* renamed from: M */
    private int f37688M;

    /* renamed from: N */
    private int f37689N;

    /* renamed from: O */
    private int f37690O;

    /* renamed from: P */
    private int f37691P;

    /* renamed from: a */
    public int f37694a;

    /* renamed from: b */
    public int f37695b;

    /* renamed from: d */
    private final int f37696d;

    /* renamed from: e */
    private InputStream f37697e;

    /* renamed from: k */
    private boolean f37703k;

    /* renamed from: l */
    private boolean f37704l;

    /* renamed from: m */
    private boolean f37705m;

    /* renamed from: n */
    private short[] f37706n;

    /* renamed from: o */
    private byte[] f37707o;

    /* renamed from: q */
    private byte[] f37709q;

    /* renamed from: r */
    private byte[] f37710r;

    /* renamed from: s */
    private int f37711s;

    /* renamed from: w */
    private int f37715w;

    /* renamed from: x */
    private int f37716x;

    /* renamed from: y */
    private int f37717y;

    /* renamed from: z */
    private int f37718z;

    /* renamed from: f */
    private final Object f37698f = new Object();

    /* renamed from: g */
    private final Object f37699g = new Object();

    /* renamed from: h */
    private boolean f37700h = false;

    /* renamed from: i */
    private boolean f37701i = false;

    /* renamed from: j */
    private boolean f37702j = false;

    /* renamed from: p */
    private byte[] f37708p = new byte[512];

    /* renamed from: t */
    private int f37712t = 100;

    /* renamed from: u */
    private int f37713u = 0;

    /* renamed from: v */
    private int f37714v = 0;

    /* renamed from: A */
    private int[] f37676A = null;

    /* renamed from: B */
    private int[] f37677B = null;

    /* renamed from: E */
    private int f37680E = 0;

    /* renamed from: H */
    private int f37683H = 0;

    /* renamed from: Q */
    private int f37692Q = 0;

    /* renamed from: R */
    private int[] f37693R = null;

    public C8100a(InputStream inputStream, int i10) throws IOException {
        this.f37697e = inputStream;
        this.f37696d = i10;
        m50183d();
    }

    /* renamed from: a */
    private Bitmap m50179a(int[] iArr, int i10, int i11, Bitmap bitmap) {
        if (bitmap == null) {
            Bitmap.Config config = AbstractC7741ao.m47559b() > 62914560 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a(f37675c, "create image with config %s", config);
            }
            bitmap = Bitmap.createBitmap(i10, i11, config);
        }
        bitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        return bitmap;
    }

    /* renamed from: d */
    private void m50183d() throws IOException {
        if (this.f37697e == null) {
            m50180a(true);
            return;
        }
        m50184e();
        if (m50188i()) {
            m50180a(true);
            m50201b();
        }
    }

    /* renamed from: e */
    private void m50184e() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < 6; i10++) {
            stringBuffer.append((char) m50185f());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.f37714v = 1;
            return;
        }
        m50186g();
        if (!this.f37703k || m50188i()) {
            return;
        }
        int[] iArrM50181a = m50181a(this.f37715w);
        this.f37676A = iArrM50181a;
        this.f37718z = iArrM50181a[this.f37717y];
    }

    /* renamed from: f */
    private int m50185f() {
        try {
            return this.f37697e.read();
        } catch (Exception unused) {
            this.f37714v = 1;
            return 0;
        }
    }

    /* renamed from: g */
    private void m50186g() {
        this.f37694a = m50187h();
        this.f37695b = m50187h();
        this.f37703k = (m50185f() & 128) != 0;
        this.f37715w = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f37717y = m50185f();
        m50185f();
    }

    /* renamed from: h */
    private int m50187h() {
        return (m50185f() << 8) | m50185f();
    }

    /* renamed from: i */
    private boolean m50188i() {
        return this.f37714v != 0;
    }

    /* renamed from: j */
    private C8102c m50189j() {
        int iM50190k;
        C8102c c8102c = null;
        try {
            iM50190k = m50190k();
        } catch (Exception | StackOverflowError unused) {
            this.f37714v = 1;
            AbstractC7185ho.m43823c(f37675c, "read image error");
        } catch (OutOfMemoryError unused2) {
            this.f37714v = 1;
            AbstractC7185ho.m43823c(f37675c, "run out of memory");
            m50195p();
        }
        if (m50188i()) {
            return null;
        }
        m50191l();
        m50193n();
        if (m50188i()) {
            return null;
        }
        m50194o();
        if (m50188i()) {
            return null;
        }
        Bitmap bitmap = this.f37681F;
        if (bitmap != null) {
            int i10 = this.f37683H + 1;
            this.f37683H = i10;
            c8102c = new C8102c(i10, bitmap, this.f37712t);
        }
        if (this.f37702j) {
            this.f37678C[this.f37679D] = iM50190k;
        }
        m50196q();
        return c8102c;
    }

    /* renamed from: k */
    private int m50190k() throws IOException {
        int[] iArr;
        this.f37684I = m50187h();
        this.f37685J = m50187h();
        this.f37686K = m50187h();
        this.f37687L = m50187h();
        int iM50185f = m50185f();
        int i10 = 0;
        this.f37704l = (iM50185f & 128) != 0;
        this.f37705m = (iM50185f & 64) != 0;
        int iPow = (int) Math.pow(2.0d, (iM50185f & 7) + 1);
        this.f37716x = iPow;
        if (this.f37704l) {
            int[] iArrM50181a = m50181a(iPow);
            this.f37677B = iArrM50181a;
            this.f37678C = iArrM50181a;
        } else {
            this.f37678C = this.f37676A;
            if (this.f37717y == this.f37679D) {
                this.f37718z = 0;
            }
        }
        if (this.f37702j && (iArr = this.f37678C) != null && iArr.length > 0) {
            int length = iArr.length;
            int i11 = this.f37679D;
            if (length > i11) {
                int i12 = iArr[i11];
                iArr[i11] = 0;
                i10 = i12;
            }
        }
        if (this.f37678C == null) {
            this.f37714v = 1;
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [short] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* renamed from: l */
    private void m50191l() throws IOException {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        short s10;
        int i16 = this.f37686K * this.f37687L;
        m50182b(i16);
        int iM50185f = m50185f();
        int i17 = 1 << iM50185f;
        int i18 = i17 + 1;
        int i19 = i17 + 2;
        int i20 = iM50185f + 1;
        int i21 = (1 << i20) - 1;
        for (int i22 = 0; i22 < i17; i22++) {
            this.f37706n[i22] = 0;
            this.f37707o[i22] = (byte) i22;
        }
        int i23 = i20;
        int i24 = i21;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int iM50197r = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = -1;
        int i33 = i19;
        while (i25 < i16) {
            if (i26 != 0) {
                i10 = i18;
                i11 = i30;
                i12 = i17;
                int i34 = i32;
                i13 = i20;
                i14 = i34;
            } else if (i27 < i23) {
                if (iM50197r == 0) {
                    iM50197r = m50197r();
                    if (iM50197r <= 0) {
                        break;
                    } else {
                        i29 = 0;
                    }
                }
                i28 += (this.f37708p[i29] & 255) << i27;
                i27 += 8;
                i29++;
                iM50197r--;
            } else {
                int i35 = i28 & i24;
                i28 >>= i23;
                i27 -= i23;
                if (i35 > i33 || i35 == i18) {
                    break;
                }
                if (i35 == i17) {
                    i23 = i20;
                    i33 = i19;
                    i24 = i21;
                    i32 = -1;
                } else {
                    int i36 = i32;
                    i13 = i20;
                    if (i36 == -1) {
                        this.f37709q[i26] = this.f37707o[i35 == true ? 1 : 0];
                        i30 = i35 == true ? 1 : 0;
                        i26++;
                        i20 = i13;
                        i18 = i18;
                        i32 = i30;
                    } else {
                        i10 = i18;
                        if (i35 == i33) {
                            byte[] bArr = this.f37709q;
                            i15 = i35 == true ? 1 : 0;
                            bArr[i26] = (byte) i30;
                            s10 = i36;
                            i26++;
                        } else {
                            i15 = i35 == true ? 1 : 0;
                            s10 = i35;
                        }
                        while (s10 > i17) {
                            this.f37709q[i26] = this.f37707o[s10];
                            s10 = this.f37706n[s10];
                            i26++;
                            i17 = i17;
                        }
                        i12 = i17;
                        byte[] bArr2 = this.f37707o;
                        i11 = bArr2[s10] & 255;
                        if (i33 >= 4096) {
                            break;
                        }
                        int i37 = i26 + 1;
                        byte b10 = (byte) i11;
                        this.f37709q[i26] = b10;
                        this.f37706n[i33] = (short) i36;
                        bArr2[i33] = b10;
                        i33++;
                        if ((i33 & i24) == 0 && i33 < 4096) {
                            i23++;
                            i24 += i33;
                        }
                        i14 = i15;
                        i26 = i37;
                    }
                }
            }
            i26--;
            this.f37710r[i31] = this.f37709q[i26];
            i25++;
            i31++;
            i17 = i12;
            i18 = i10;
            i30 = i11;
            int i38 = i13;
            i32 = i14;
            i20 = i38;
        }
        for (int i39 = i31; i39 < i16; i39++) {
            this.f37710r[i39] = 0;
        }
    }

    /* renamed from: m */
    private void m50192m() {
        m50185f();
        int iM50185f = m50185f();
        int i10 = (iM50185f & 28) >> 2;
        this.f37713u = i10;
        if (i10 == 0) {
            this.f37713u = 1;
        }
        this.f37702j = (iM50185f & 1) != 0;
        int iM50187h = m50187h() * 10;
        this.f37712t = iM50187h;
        int i11 = this.f37696d;
        if (i11 > iM50187h) {
            this.f37712t = i11;
        }
        this.f37679D = m50185f();
        m50185f();
    }

    /* renamed from: n */
    private void m50193n() throws IOException {
        do {
            m50197r();
            if (this.f37692Q <= 0) {
                return;
            }
        } while (!m50188i());
    }

    /* renamed from: o */
    private void m50194o() {
        int i10;
        try {
            m50198s();
            int i11 = 0;
            int i12 = 1;
            int i13 = 8;
            int i14 = 0;
            while (true) {
                int i15 = this.f37687L;
                if (i11 >= i15) {
                    this.f37681F = m50179a(this.f37693R, this.f37694a, this.f37695b, this.f37681F);
                    return;
                }
                if (this.f37705m) {
                    if (i14 >= i15) {
                        i12++;
                        if (i12 == 2) {
                            i14 = 4;
                        } else if (i12 == 3) {
                            i13 = 4;
                            i14 = 2;
                        } else if (i12 == 4) {
                            i14 = 1;
                            i13 = 2;
                        }
                    }
                    i10 = i14 + i13;
                } else {
                    i10 = i14;
                    i14 = i11;
                }
                int i16 = i14 + this.f37685J;
                if (i16 < this.f37695b) {
                    int i17 = this.f37694a;
                    int i18 = i16 * i17;
                    int i19 = this.f37684I + i18;
                    int i20 = this.f37686K;
                    int i21 = i19 + i20;
                    if (i18 + i17 < i21) {
                        i21 = i18 + i17;
                    }
                    int i22 = i20 * i11;
                    while (i19 < i21) {
                        int i23 = i22 + 1;
                        int i24 = this.f37678C[this.f37710r[i22] & 255];
                        if (i24 != 0) {
                            this.f37693R[i19] = i24;
                        }
                        i19++;
                        i22 = i23;
                    }
                }
                i11++;
                i14 = i10;
            }
        } catch (Exception | StackOverflowError unused) {
            this.f37714v = 1;
            AbstractC7185ho.m43823c(f37675c, "set pixel error");
        }
    }

    /* renamed from: p */
    private void m50195p() {
        this.f37714v = 3;
    }

    /* renamed from: q */
    private void m50196q() {
        this.f37680E = this.f37713u;
        this.f37688M = this.f37684I;
        this.f37689N = this.f37685J;
        this.f37690O = this.f37686K;
        this.f37691P = this.f37687L;
        this.f37711s = this.f37718z;
        this.f37682G = this.f37693R;
        this.f37702j = false;
        this.f37713u = 0;
        this.f37677B = null;
        this.f37712t = this.f37696d;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x002d  */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m50197r() throws java.io.IOException {
        /*
            r4 = this;
            int r0 = r4.m50185f()
            r4.f37692Q = r0
            r1 = 0
            if (r0 <= 0) goto L30
        L9:
            int r0 = r4.f37692Q     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            if (r1 >= r0) goto L29
            java.io.InputStream r2 = r4.f37697e     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            byte[] r3 = r4.f37708p     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            int r0 = r0 - r1
            int r0 = r2.read(r3, r1, r0)     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            r2 = -1
            if (r0 != r2) goto L1a
            goto L29
        L1a:
            int r1 = r1 + r0
            goto L9
        L1c:
            java.lang.String r0 = com.huawei.openalliance.p169ad.views.gif.C8100a.f37675c
            java.lang.String r2 = "read block fail"
        L20:
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r0, r2)
            goto L29
        L24:
            java.lang.String r0 = com.huawei.openalliance.p169ad.views.gif.C8100a.f37675c
            java.lang.String r2 = "read block IOException"
            goto L20
        L29:
            int r0 = r4.f37692Q
            if (r1 >= r0) goto L30
            r0 = 1
            r4.f37714v = r0
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.gif.C8100a.m50197r():int");
    }

    /* renamed from: s */
    private void m50198s() {
        if (this.f37693R == null) {
            this.f37693R = new int[this.f37694a * this.f37695b];
        }
        int i10 = this.f37680E;
        if (i10 > 0) {
            if (3 == i10) {
                this.f37682G = null;
            }
            int[] iArr = this.f37682G;
            if (iArr != null) {
                this.f37693R = iArr;
                if (2 == i10) {
                    int i11 = !this.f37702j ? this.f37711s : 0;
                    for (int i12 = 0; i12 < this.f37691P; i12++) {
                        int i13 = ((this.f37689N + i12) * this.f37694a) + this.f37688M;
                        int i14 = this.f37690O + i13;
                        while (i13 < i14) {
                            this.f37693R[i13] = i11;
                            i13++;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: t */
    private boolean m50199t() {
        boolean z10;
        synchronized (this.f37699g) {
            z10 = this.f37701i;
        }
        return z10;
    }

    /* renamed from: b */
    public void m50201b() {
        synchronized (this.f37698f) {
            try {
                if (!this.f37700h) {
                    this.f37700h = true;
                    AbstractC7805cy.m48142a((Closeable) this.f37697e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public boolean m50202c() {
        boolean z10;
        synchronized (this.f37698f) {
            z10 = this.f37700h;
        }
        return z10;
    }

    /* renamed from: b */
    private void m50182b(int i10) {
        byte[] bArr = this.f37710r;
        if (bArr == null || bArr.length < i10) {
            this.f37710r = new byte[i10];
        }
        if (this.f37706n == null) {
            this.f37706n = new short[4096];
        }
        if (this.f37707o == null) {
            this.f37707o = new byte[4096];
        }
        if (this.f37709q == null) {
            this.f37709q = new byte[4097];
        }
    }

    /* renamed from: a */
    public C8102c m50200a() throws IOException {
        if (m50202c()) {
            m50180a(true);
            return null;
        }
        while (true) {
            if (m50199t()) {
                break;
            }
            if (m50188i()) {
                m50180a(true);
                break;
            }
            int iM50185f = m50185f();
            if (iM50185f != 0) {
                if (iM50185f != 33) {
                    if (iM50185f == 44) {
                        C8102c c8102cM50189j = m50189j();
                        if (c8102cM50189j != null) {
                            return c8102cM50189j;
                        }
                    } else if (iM50185f != 59) {
                        this.f37714v = 1;
                    } else {
                        m50180a(true);
                    }
                } else if (249 == m50185f()) {
                    m50192m();
                } else {
                    m50193n();
                }
            }
        }
        if (m50199t()) {
            m50201b();
        }
        return null;
    }

    /* renamed from: a */
    private void m50180a(boolean z10) {
        synchronized (this.f37699g) {
            this.f37701i = z10;
        }
    }

    /* renamed from: a */
    private int[] m50181a(int i10) throws IOException {
        int i11;
        int[] iArr = new int[256];
        int i12 = i10 * 3;
        byte[] bArr = new byte[i12];
        try {
            i11 = this.f37697e.read(bArr);
        } catch (Exception unused) {
            AbstractC7185ho.m43823c(f37675c, "read color table fail");
            i11 = 0;
        }
        if (i11 < i12) {
            this.f37714v = 1;
        } else {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = bArr[i13] & 255;
                int i16 = i13 + 2;
                int i17 = bArr[i13 + 1] & 255;
                i13 += 3;
                iArr[i14] = (i17 << 8) | (i15 << 16) | (-16777216) | (bArr[i16] & 255);
            }
        }
        return iArr;
    }
}
