package mz;

/* renamed from: mz.c */
/* loaded from: classes9.dex */
public final class C11566c implements InterfaceC11569f {

    /* renamed from: c */
    public static final int[] f53626c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 6, 6, 0, 0, 7, 7, 4, 4, 0, 0, 4, 4, 0, 0};

    /* renamed from: a */
    public final boolean f53627a;

    /* renamed from: b */
    public int f53628b;

    public C11566c(boolean z10, int i10) {
        this.f53627a = z10;
        this.f53628b = i10;
    }

    @Override // mz.InterfaceC11569f
    /* renamed from: a */
    public int mo69042a(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        char c10;
        char c11 = 16;
        int i14 = (i10 + i11) - 16;
        int i15 = i10;
        while (i15 <= i14) {
            int i16 = f53626c[bArr[i15] & 31];
            int i17 = 5;
            int i18 = 0;
            while (i18 < 3) {
                if (((i16 >>> i18) & 1) == 0) {
                    c10 = c11;
                    i12 = i15;
                    i13 = i17;
                } else {
                    int i19 = i17 >>> 3;
                    int i20 = i17 & 7;
                    long j10 = 0;
                    int i21 = 0;
                    while (i21 < 6) {
                        j10 |= (bArr[(i15 + i19) + i21] & 255) << (i21 * 8);
                        i21++;
                        i15 = i15;
                    }
                    i12 = i15;
                    long j11 = j10 >>> i20;
                    if (((j11 >>> 37) & 15) == 5 && ((j11 >>> 9) & 7) == 0) {
                        i13 = i17;
                        int i22 = (((((int) (j11 >>> 36)) & 1) << 20) | ((int) ((j11 >>> 13) & 1048575))) << 4;
                        long j12 = (this.f53627a ? i22 + ((this.f53628b + i12) - i10) : i22 - ((this.f53628b + i12) - i10)) >>> 4;
                        c10 = 16;
                        long j13 = ((((j11 & (-77309403137L)) | ((j12 & 1048575) << 13)) | ((j12 & 1048576) << 16)) << i20) | (((1 << i20) - 1) & j10);
                        for (int i23 = 0; i23 < 6; i23++) {
                            bArr[i12 + i19 + i23] = (byte) (j13 >>> (i23 * 8));
                        }
                    } else {
                        i13 = i17;
                        c10 = 16;
                    }
                }
                i18++;
                i17 = i13 + 41;
                c11 = c10;
                i15 = i12;
            }
            i15 += 16;
        }
        int i24 = i15 - i10;
        this.f53628b += i24;
        return i24;
    }
}
