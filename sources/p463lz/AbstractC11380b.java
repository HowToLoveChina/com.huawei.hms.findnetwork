package p463lz;

import java.io.IOException;

/* renamed from: lz.b */
/* loaded from: classes9.dex */
public abstract class AbstractC11380b extends AbstractC11379a {

    /* renamed from: a */
    public int f53109a = 0;

    /* renamed from: b */
    public int f53110b = 0;

    /* renamed from: b */
    public int m68240b(short[] sArr, int i10) throws IOException {
        mo68244f();
        short s10 = sArr[i10];
        int i11 = this.f53109a;
        int i12 = (i11 >>> 11) * s10;
        int i13 = this.f53110b;
        if ((i13 ^ Integer.MIN_VALUE) < (Integer.MIN_VALUE ^ i12)) {
            this.f53109a = i12;
            sArr[i10] = (short) (s10 + ((2048 - s10) >>> 5));
            return 0;
        }
        this.f53109a = i11 - i12;
        this.f53110b = i13 - i12;
        sArr[i10] = (short) (s10 - (s10 >>> 5));
        return 1;
    }

    /* renamed from: c */
    public int m68241c(short[] sArr) throws IOException {
        int iM68240b = 1;
        do {
            iM68240b = m68240b(sArr, iM68240b) | (iM68240b << 1);
        } while (iM68240b < sArr.length);
        return iM68240b - sArr.length;
    }

    /* renamed from: d */
    public int m68242d(int i10) throws IOException {
        int i11 = 0;
        do {
            mo68244f();
            int i12 = this.f53109a >>> 1;
            this.f53109a = i12;
            int i13 = this.f53110b;
            int i14 = (i13 - i12) >>> 31;
            this.f53110b = i13 - (i12 & (i14 - 1));
            i11 = (i11 << 1) | (1 - i14);
            i10--;
        } while (i10 != 0);
        return i11;
    }

    /* renamed from: e */
    public int m68243e(short[] sArr) throws IOException {
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (true) {
            int iM68240b = m68240b(sArr, i11);
            i11 = (i11 << 1) | iM68240b;
            int i13 = i12 + 1;
            i10 |= iM68240b << i12;
            if (i11 >= sArr.length) {
                return i10;
            }
            i12 = i13;
        }
    }

    /* renamed from: f */
    public abstract void mo68244f() throws IOException;
}
