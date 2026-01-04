package p725w1;

import android.graphics.Bitmap;
import android.util.Log;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import p725w1.InterfaceC13516a;

/* renamed from: w1.e */
/* loaded from: classes.dex */
public class C13520e implements InterfaceC13516a {

    /* renamed from: u */
    public static final String f60823u = "e";

    /* renamed from: a */
    public int[] f60824a;

    /* renamed from: b */
    public final int[] f60825b;

    /* renamed from: c */
    public final InterfaceC13516a.a f60826c;

    /* renamed from: d */
    public ByteBuffer f60827d;

    /* renamed from: e */
    public byte[] f60828e;

    /* renamed from: f */
    public short[] f60829f;

    /* renamed from: g */
    public byte[] f60830g;

    /* renamed from: h */
    public byte[] f60831h;

    /* renamed from: i */
    public byte[] f60832i;

    /* renamed from: j */
    public int[] f60833j;

    /* renamed from: k */
    public int f60834k;

    /* renamed from: l */
    public C13518c f60835l;

    /* renamed from: m */
    public Bitmap f60836m;

    /* renamed from: n */
    public boolean f60837n;

    /* renamed from: o */
    public int f60838o;

    /* renamed from: p */
    public int f60839p;

    /* renamed from: q */
    public int f60840q;

    /* renamed from: r */
    public int f60841r;

    /* renamed from: s */
    public Boolean f60842s;

    /* renamed from: t */
    public Bitmap.Config f60843t;

    public C13520e(InterfaceC13516a.a aVar, C13518c c13518c, ByteBuffer byteBuffer, int i10) {
        this(aVar);
        m81314q(c13518c, byteBuffer, i10);
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: a */
    public synchronized Bitmap mo81276a() {
        try {
            if (this.f60835l.f60808c <= 0 || this.f60834k < 0) {
                String str = f60823u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.f60835l.f60808c + ", framePointer=" + this.f60834k);
                }
                this.f60838o = 1;
            }
            int i10 = this.f60838o;
            if (i10 != 1 && i10 != 2) {
                this.f60838o = 0;
                if (this.f60828e == null) {
                    this.f60828e = this.f60826c.mo66301e(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                }
                C13517b c13517b = this.f60835l.f60810e.get(this.f60834k);
                int i11 = this.f60834k - 1;
                C13517b c13517b2 = i11 >= 0 ? this.f60835l.f60810e.get(i11) : null;
                int[] iArr = c13517b.f60805k;
                if (iArr == null) {
                    iArr = this.f60835l.f60806a;
                }
                this.f60824a = iArr;
                if (iArr == null) {
                    String str2 = f60823u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.f60834k);
                    }
                    this.f60838o = 1;
                    return null;
                }
                if (c13517b.f60800f) {
                    System.arraycopy(iArr, 0, this.f60825b, 0, iArr.length);
                    int[] iArr2 = this.f60825b;
                    this.f60824a = iArr2;
                    iArr2[c13517b.f60802h] = 0;
                    if (c13517b.f60801g == 2 && this.f60834k == 0) {
                        this.f60842s = Boolean.TRUE;
                    }
                }
                return m81315r(c13517b, c13517b2);
            }
            String str3 = f60823u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.f60838o);
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: b */
    public void mo81277b() {
        this.f60834k = (this.f60834k + 1) % this.f60835l.f60808c;
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: c */
    public int mo81278c() {
        return this.f60835l.f60808c;
    }

    @Override // p725w1.InterfaceC13516a
    public void clear() {
        this.f60835l = null;
        byte[] bArr = this.f60832i;
        if (bArr != null) {
            this.f60826c.mo66300d(bArr);
        }
        int[] iArr = this.f60833j;
        if (iArr != null) {
            this.f60826c.mo66302f(iArr);
        }
        Bitmap bitmap = this.f60836m;
        if (bitmap != null) {
            this.f60826c.mo66299c(bitmap);
        }
        this.f60836m = null;
        this.f60827d = null;
        this.f60842s = null;
        byte[] bArr2 = this.f60828e;
        if (bArr2 != null) {
            this.f60826c.mo66300d(bArr2);
        }
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: d */
    public int mo81279d() {
        int i10;
        if (this.f60835l.f60808c <= 0 || (i10 = this.f60834k) < 0) {
            return 0;
        }
        return m81310m(i10);
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: e */
    public void mo81280e(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f60843t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: f */
    public void mo81281f() {
        this.f60834k = -1;
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: g */
    public int mo81282g() {
        return this.f60834k;
    }

    @Override // p725w1.InterfaceC13516a
    public ByteBuffer getData() {
        return this.f60827d;
    }

    @Override // p725w1.InterfaceC13516a
    /* renamed from: h */
    public int mo81283h() {
        return this.f60827d.limit() + this.f60832i.length + (this.f60833j.length * 4);
    }

    /* renamed from: i */
    public final int m81306i(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f60839p + i10; i18++) {
            byte[] bArr = this.f60832i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f60824a[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i14 += (i19 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i15 += (i19 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i16 += i19 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f60839p + i20; i21++) {
            byte[] bArr2 = this.f60832i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f60824a[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i14 += (i22 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i15 += (i22 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i16 += i22 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    /* renamed from: j */
    public final void m81307j(C13517b c13517b) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.f60833j;
        int i15 = c13517b.f60798d;
        int i16 = this.f60839p;
        int i17 = i15 / i16;
        int i18 = c13517b.f60796b / i16;
        int i19 = c13517b.f60797c / i16;
        int i20 = c13517b.f60795a / i16;
        boolean z10 = this.f60834k == 0;
        int i21 = this.f60841r;
        int i22 = this.f60840q;
        byte[] bArr = this.f60832i;
        int[] iArr2 = this.f60824a;
        Boolean bool = this.f60842s;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i25 < i17) {
            Boolean bool2 = bool;
            if (c13517b.f60799e) {
                if (i24 >= i17) {
                    int i27 = i26 + 1;
                    i10 = i17;
                    if (i27 == 2) {
                        i24 = 4;
                    } else if (i27 == 3) {
                        i23 = 4;
                        i26 = i27;
                        i24 = 2;
                    } else if (i27 == 4) {
                        i26 = i27;
                        i24 = 1;
                        i23 = 2;
                    }
                    i26 = i27;
                } else {
                    i10 = i17;
                }
                i11 = i24 + i23;
            } else {
                i10 = i17;
                i11 = i24;
                i24 = i25;
            }
            int i28 = i24 + i18;
            boolean z11 = i16 == 1;
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i25 * i16 * c13517b.f60797c;
                if (z11) {
                    int i34 = i30;
                    while (i34 < i31) {
                        int i35 = i18;
                        int i36 = iArr2[bArr[i33] & 255];
                        if (i36 != 0) {
                            iArr[i34] = i36;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i34++;
                        i18 = i35;
                    }
                } else {
                    i14 = i18;
                    int i37 = ((i31 - i30) * i16) + i33;
                    int i38 = i30;
                    while (true) {
                        i13 = i19;
                        if (i38 >= i31) {
                            break;
                        }
                        int iM81306i = m81306i(i33, i37, c13517b.f60797c);
                        if (iM81306i != 0) {
                            iArr[i38] = iM81306i;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i38++;
                        i19 = i13;
                    }
                    bool = bool2;
                    i25++;
                    i18 = i14;
                    i17 = i10;
                    i19 = i13;
                    i24 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i25++;
            i18 = i14;
            i17 = i10;
            i19 = i13;
            i24 = i12;
        }
        Boolean bool3 = bool;
        if (this.f60842s == null) {
            this.f60842s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    /* renamed from: k */
    public final void m81308k(C13517b c13517b) {
        C13517b c13517b2 = c13517b;
        int[] iArr = this.f60833j;
        int i10 = c13517b2.f60798d;
        int i11 = c13517b2.f60796b;
        int i12 = c13517b2.f60797c;
        int i13 = c13517b2.f60795a;
        boolean z10 = this.f60834k == 0;
        int i14 = this.f60841r;
        byte[] bArr = this.f60832i;
        int[] iArr2 = this.f60824a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = c13517b2.f60797c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int i22 = i10;
                int i23 = b11 & 255;
                if (i23 != b10) {
                    int i24 = iArr2[i23];
                    if (i24 != 0) {
                        iArr[i21] = i24;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                i10 = i22;
            }
            i15++;
            c13517b2 = c13517b;
        }
        Boolean bool = this.f60842s;
        this.f60842s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f60842s == null && z10 && b10 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* renamed from: l */
    public final void m81309l(C13517b c13517b) {
        int i10;
        int i11;
        short s10;
        C13520e c13520e = this;
        if (c13517b != null) {
            c13520e.f60827d.position(c13517b.f60804j);
        }
        if (c13517b == null) {
            C13518c c13518c = c13520e.f60835l;
            i10 = c13518c.f60811f;
            i11 = c13518c.f60812g;
        } else {
            i10 = c13517b.f60797c;
            i11 = c13517b.f60798d;
        }
        int i12 = i10 * i11;
        byte[] bArr = c13520e.f60832i;
        if (bArr == null || bArr.length < i12) {
            c13520e.f60832i = c13520e.f60826c.mo66301e(i12);
        }
        byte[] bArr2 = c13520e.f60832i;
        if (c13520e.f60829f == null) {
            c13520e.f60829f = new short[4096];
        }
        short[] sArr = c13520e.f60829f;
        if (c13520e.f60830g == null) {
            c13520e.f60830g = new byte[4096];
        }
        byte[] bArr3 = c13520e.f60830g;
        if (c13520e.f60831h == null) {
            c13520e.f60831h = new byte[4097];
        }
        byte[] bArr4 = c13520e.f60831h;
        int iM81313p = m81313p();
        int i13 = 1 << iM81313p;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = iM81313p + 1;
        int i17 = (1 << i16) - 1;
        int i18 = 0;
        for (int i19 = 0; i19 < i13; i19++) {
            sArr[i19] = 0;
            bArr3[i19] = (byte) i19;
        }
        byte[] bArr5 = c13520e.f60828e;
        int i20 = i16;
        int i21 = i15;
        int i22 = i17;
        int iM81312o = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        while (true) {
            if (i18 >= i12) {
                break;
            }
            if (iM81312o == 0) {
                iM81312o = m81312o();
                if (iM81312o <= 0) {
                    c13520e.f60838o = 3;
                    break;
                }
                i23 = 0;
            }
            i25 += (bArr5[i23] & 255) << i24;
            i23++;
            iM81312o--;
            int i30 = i24 + 8;
            int i31 = i21;
            int i32 = i20;
            int i33 = i29;
            int i34 = i16;
            int i35 = i27;
            while (true) {
                if (i30 < i32) {
                    i29 = i33;
                    i21 = i31;
                    i24 = i30;
                    c13520e = this;
                    i27 = i35;
                    i16 = i34;
                    i20 = i32;
                    break;
                }
                int i36 = i15;
                int i37 = i25 & i22;
                i25 >>= i32;
                i30 -= i32;
                if (i37 == i13) {
                    i22 = i17;
                    i32 = i34;
                    i31 = i36;
                    i15 = i31;
                    i33 = -1;
                } else {
                    if (i37 == i14) {
                        i24 = i30;
                        i27 = i35;
                        i21 = i31;
                        i16 = i34;
                        i15 = i36;
                        i29 = i33;
                        i20 = i32;
                        c13520e = this;
                        break;
                    }
                    if (i33 == -1) {
                        bArr2[i26] = bArr3[i37];
                        i26++;
                        i18++;
                        i33 = i37;
                        i35 = i33;
                        i15 = i36;
                        i30 = i30;
                    } else {
                        if (i37 >= i31) {
                            bArr4[i28] = (byte) i35;
                            i28++;
                            s10 = i33;
                        } else {
                            s10 = i37;
                        }
                        while (s10 >= i13) {
                            bArr4[i28] = bArr3[s10];
                            i28++;
                            s10 = sArr[s10];
                        }
                        i35 = bArr3[s10] & 255;
                        byte b10 = (byte) i35;
                        bArr2[i26] = b10;
                        while (true) {
                            i26++;
                            i18++;
                            if (i28 <= 0) {
                                break;
                            }
                            i28--;
                            bArr2[i26] = bArr4[i28];
                        }
                        byte[] bArr6 = bArr4;
                        if (i31 < 4096) {
                            sArr[i31] = (short) i33;
                            bArr3[i31] = b10;
                            i31++;
                            if ((i31 & i22) == 0 && i31 < 4096) {
                                i32++;
                                i22 += i31;
                            }
                        }
                        i33 = i37;
                        i15 = i36;
                        i30 = i30;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i26, i12, (byte) 0);
    }

    /* renamed from: m */
    public int m81310m(int i10) {
        if (i10 >= 0) {
            C13518c c13518c = this.f60835l;
            if (i10 < c13518c.f60808c) {
                return c13518c.f60810e.get(i10).f60803i;
            }
        }
        return -1;
    }

    /* renamed from: n */
    public final Bitmap m81311n() {
        Boolean bool = this.f60842s;
        Bitmap bitmapMo66297a = this.f60826c.mo66297a(this.f60841r, this.f60840q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f60843t);
        bitmapMo66297a.setHasAlpha(true);
        return bitmapMo66297a;
    }

    /* renamed from: o */
    public final int m81312o() {
        int iM81313p = m81313p();
        if (iM81313p <= 0) {
            return iM81313p;
        }
        ByteBuffer byteBuffer = this.f60827d;
        byteBuffer.get(this.f60828e, 0, Math.min(iM81313p, byteBuffer.remaining()));
        return iM81313p;
    }

    /* renamed from: p */
    public final int m81313p() {
        return this.f60827d.get() & 255;
    }

    /* renamed from: q */
    public synchronized void m81314q(C13518c c13518c, ByteBuffer byteBuffer, int i10) {
        try {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
            }
            int iHighestOneBit = Integer.highestOneBit(i10);
            this.f60838o = 0;
            this.f60835l = c13518c;
            this.f60834k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f60827d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f60827d.order(ByteOrder.LITTLE_ENDIAN);
            this.f60837n = false;
            Iterator<C13517b> it = c13518c.f60810e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f60801g == 3) {
                    this.f60837n = true;
                    break;
                }
            }
            this.f60839p = iHighestOneBit;
            int i11 = c13518c.f60811f;
            this.f60841r = i11 / iHighestOneBit;
            int i12 = c13518c.f60812g;
            this.f60840q = i12 / iHighestOneBit;
            this.f60832i = this.f60826c.mo66301e(i11 * i12);
            this.f60833j = this.f60826c.mo66298b(this.f60841r * this.f60840q);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: r */
    public final Bitmap m81315r(C13517b c13517b, C13517b c13517b2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f60833j;
        int i12 = 0;
        if (c13517b2 == null) {
            Bitmap bitmap2 = this.f60836m;
            if (bitmap2 != null) {
                this.f60826c.mo66299c(bitmap2);
            }
            this.f60836m = null;
            Arrays.fill(iArr, 0);
        }
        if (c13517b2 != null && c13517b2.f60801g == 3 && this.f60836m == null) {
            Arrays.fill(iArr, 0);
        }
        if (c13517b2 != null && (i11 = c13517b2.f60801g) > 0) {
            if (i11 == 2) {
                if (!c13517b.f60800f) {
                    C13518c c13518c = this.f60835l;
                    int i13 = c13518c.f60817l;
                    if (c13517b.f60805k == null || c13518c.f60815j != c13517b.f60802h) {
                        i12 = i13;
                    }
                }
                int i14 = c13517b2.f60798d;
                int i15 = this.f60839p;
                int i16 = i14 / i15;
                int i17 = c13517b2.f60796b / i15;
                int i18 = c13517b2.f60797c / i15;
                int i19 = c13517b2.f60795a / i15;
                int i20 = this.f60841r;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f60841r;
                }
            } else if (i11 == 3 && (bitmap = this.f60836m) != null) {
                int i25 = this.f60841r;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f60840q);
            }
        }
        m81309l(c13517b);
        if (c13517b.f60799e || this.f60839p != 1) {
            m81307j(c13517b);
        } else {
            m81308k(c13517b);
        }
        if (this.f60837n && ((i10 = c13517b.f60801g) == 0 || i10 == 1)) {
            if (this.f60836m == null) {
                this.f60836m = m81311n();
            }
            Bitmap bitmap3 = this.f60836m;
            int i26 = this.f60841r;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f60840q);
        }
        Bitmap bitmapM81311n = m81311n();
        int i27 = this.f60841r;
        bitmapM81311n.setPixels(iArr, 0, i27, 0, 0, i27, this.f60840q);
        return bitmapM81311n;
    }

    public C13520e(InterfaceC13516a.a aVar) {
        this.f60825b = new int[256];
        this.f60843t = Bitmap.Config.ARGB_8888;
        this.f60826c = aVar;
        this.f60835l = new C13518c();
    }
}
