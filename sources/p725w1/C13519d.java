package p725w1;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: w1.d */
/* loaded from: classes.dex */
public class C13519d {

    /* renamed from: b */
    public ByteBuffer f60820b;

    /* renamed from: c */
    public C13518c f60821c;

    /* renamed from: a */
    public final byte[] f60819a = new byte[256];

    /* renamed from: d */
    public int f60822d = 0;

    /* renamed from: a */
    public void m81288a() {
        this.f60820b = null;
        this.f60821c = null;
    }

    /* renamed from: b */
    public final boolean m81289b() {
        return this.f60821c.f60807b != 0;
    }

    /* renamed from: c */
    public C13518c m81290c() {
        if (this.f60820b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (m81289b()) {
            return this.f60821c;
        }
        m81298k();
        if (!m81289b()) {
            m81295h();
            C13518c c13518c = this.f60821c;
            if (c13518c.f60808c < 0) {
                c13518c.f60807b = 1;
            }
        }
        return this.f60821c;
    }

    /* renamed from: d */
    public final int m81291d() {
        try {
            return this.f60820b.get() & 255;
        } catch (Exception unused) {
            this.f60821c.f60807b = 1;
            return 0;
        }
    }

    /* renamed from: e */
    public final void m81292e() {
        this.f60821c.f60809d.f60795a = m81301n();
        this.f60821c.f60809d.f60796b = m81301n();
        this.f60821c.f60809d.f60797c = m81301n();
        this.f60821c.f60809d.f60798d = m81301n();
        int iM81291d = m81291d();
        boolean z10 = (iM81291d & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iM81291d & 7) + 1);
        C13517b c13517b = this.f60821c.f60809d;
        c13517b.f60799e = (iM81291d & 64) != 0;
        if (z10) {
            c13517b.f60805k = m81294g(iPow);
        } else {
            c13517b.f60805k = null;
        }
        this.f60821c.f60809d.f60804j = this.f60820b.position();
        m81305r();
        if (m81289b()) {
            return;
        }
        C13518c c13518c = this.f60821c;
        c13518c.f60808c++;
        c13518c.f60810e.add(c13518c.f60809d);
    }

    /* renamed from: f */
    public final void m81293f() {
        int iM81291d = m81291d();
        this.f60822d = iM81291d;
        if (iM81291d <= 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            try {
                i11 = this.f60822d;
                if (i10 >= i11) {
                    return;
                }
                i11 -= i10;
                this.f60820b.get(this.f60819a, i10, i11);
                i10 += i11;
            } catch (Exception e10) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.f60822d, e10);
                }
                this.f60821c.f60807b = 1;
                return;
            }
        }
    }

    /* renamed from: g */
    public final int[] m81294g(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f60820b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = bArr[i12] & 255;
                int i14 = i12 + 2;
                int i15 = bArr[i12 + 1] & 255;
                i12 += 3;
                int i16 = i11 + 1;
                iArr[i11] = (i15 << 8) | (i13 << 16) | (-16777216) | (bArr[i14] & 255);
                i11 = i16;
            }
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f60821c.f60807b = 1;
        }
        return iArr;
    }

    /* renamed from: h */
    public final void m81295h() {
        m81296i(Integer.MAX_VALUE);
    }

    /* renamed from: i */
    public final void m81296i(int i10) {
        boolean z10 = false;
        while (!z10 && !m81289b() && this.f60821c.f60808c <= i10) {
            int iM81291d = m81291d();
            if (iM81291d == 33) {
                int iM81291d2 = m81291d();
                if (iM81291d2 == 1) {
                    m81304q();
                } else if (iM81291d2 == 249) {
                    this.f60821c.f60809d = new C13517b();
                    m81297j();
                } else if (iM81291d2 == 254) {
                    m81304q();
                } else if (iM81291d2 != 255) {
                    m81304q();
                } else {
                    m81293f();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i11 = 0; i11 < 11; i11++) {
                        sb2.append((char) this.f60819a[i11]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        m81300m();
                    } else {
                        m81304q();
                    }
                }
            } else if (iM81291d == 44) {
                C13518c c13518c = this.f60821c;
                if (c13518c.f60809d == null) {
                    c13518c.f60809d = new C13517b();
                }
                m81292e();
            } else if (iM81291d != 59) {
                this.f60821c.f60807b = 1;
            } else {
                z10 = true;
            }
        }
    }

    /* renamed from: j */
    public final void m81297j() {
        m81291d();
        int iM81291d = m81291d();
        C13517b c13517b = this.f60821c.f60809d;
        int i10 = (iM81291d & 28) >> 2;
        c13517b.f60801g = i10;
        if (i10 == 0) {
            c13517b.f60801g = 1;
        }
        c13517b.f60800f = (iM81291d & 1) != 0;
        int iM81301n = m81301n();
        if (iM81301n < 2) {
            iM81301n = 10;
        }
        C13517b c13517b2 = this.f60821c.f60809d;
        c13517b2.f60803i = iM81301n * 10;
        c13517b2.f60802h = m81291d();
        m81291d();
    }

    /* renamed from: k */
    public final void m81298k() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) m81291d());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.f60821c.f60807b = 1;
            return;
        }
        m81299l();
        if (!this.f60821c.f60813h || m81289b()) {
            return;
        }
        C13518c c13518c = this.f60821c;
        c13518c.f60806a = m81294g(c13518c.f60814i);
        C13518c c13518c2 = this.f60821c;
        c13518c2.f60817l = c13518c2.f60806a[c13518c2.f60815j];
    }

    /* renamed from: l */
    public final void m81299l() {
        this.f60821c.f60811f = m81301n();
        this.f60821c.f60812g = m81301n();
        int iM81291d = m81291d();
        C13518c c13518c = this.f60821c;
        c13518c.f60813h = (iM81291d & 128) != 0;
        c13518c.f60814i = (int) Math.pow(2.0d, (iM81291d & 7) + 1);
        this.f60821c.f60815j = m81291d();
        this.f60821c.f60816k = m81291d();
    }

    /* renamed from: m */
    public final void m81300m() {
        do {
            m81293f();
            byte[] bArr = this.f60819a;
            if (bArr[0] == 1) {
                this.f60821c.f60818m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f60822d <= 0) {
                return;
            }
        } while (!m81289b());
    }

    /* renamed from: n */
    public final int m81301n() {
        return this.f60820b.getShort();
    }

    /* renamed from: o */
    public final void m81302o() {
        this.f60820b = null;
        Arrays.fill(this.f60819a, (byte) 0);
        this.f60821c = new C13518c();
        this.f60822d = 0;
    }

    /* renamed from: p */
    public C13519d m81303p(ByteBuffer byteBuffer) {
        m81302o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f60820b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f60820b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    /* renamed from: q */
    public final void m81304q() {
        int iM81291d;
        do {
            iM81291d = m81291d();
            this.f60820b.position(Math.min(this.f60820b.position() + iM81291d, this.f60820b.limit()));
        } while (iM81291d > 0);
    }

    /* renamed from: r */
    public final void m81305r() {
        m81291d();
        m81304q();
    }
}
