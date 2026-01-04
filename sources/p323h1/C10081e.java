package p323h1;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.MathContext;
import p244e1.C9380d;
import p481n1.C11595g;

/* renamed from: h1.e */
/* loaded from: classes.dex */
public final class C10081e extends AbstractC10080d {

    /* renamed from: w */
    public static final ThreadLocal<char[]> f49216w = new ThreadLocal<>();

    /* renamed from: t */
    public Reader f49217t;

    /* renamed from: u */
    public char[] f49218u;

    /* renamed from: v */
    public int f49219v;

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: D0 */
    public final String mo62757D0() throws IOException {
        int i10 = this.f49208i;
        if (i10 == -1) {
            i10 = 0;
        }
        char cMo62820e = mo62820e((this.f49207h + i10) - 1);
        int i11 = this.f49207h;
        if (cMo62820e == 'L' || cMo62820e == 'S' || cMo62820e == 'B' || cMo62820e == 'F' || cMo62820e == 'D') {
            i11--;
        }
        return new String(this.f49218u, i10, i11);
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: F */
    public final BigDecimal mo62759F() throws IOException {
        int i10 = this.f49208i;
        if (i10 == -1) {
            i10 = 0;
        }
        char cMo62820e = mo62820e((this.f49207h + i10) - 1);
        int i11 = this.f49207h;
        if (cMo62820e == 'L' || cMo62820e == 'S' || cMo62820e == 'B' || cMo62820e == 'F' || cMo62820e == 'D') {
            i11--;
        }
        if (i11 <= 65535) {
            return new BigDecimal(this.f49218u, i10, i11, MathContext.UNLIMITED);
        }
        throw new C9380d("decimal overflow");
    }

    @Override // p323h1.InterfaceC10079c
    /* renamed from: H */
    public byte[] mo62761H() {
        if (this.f49200a != 26) {
            return C11595g.m69209d(this.f49218u, this.f49208i + 1, this.f49207h);
        }
        throw new C9380d("TODO");
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: H0 */
    public final int mo62796H0(char c10, int i10) throws IOException {
        int i11 = i10 - this.f49204e;
        while (true) {
            char cMo62820e = mo62820e(this.f49204e + i11);
            if (c10 == cMo62820e) {
                return i11 + this.f49204e;
            }
            if (cMo62820e == 26) {
                return -1;
            }
            i11++;
        }
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: I0 */
    public boolean mo62797I0() {
        if (this.f49219v == -1) {
            return true;
        }
        int i10 = this.f49204e;
        char[] cArr = this.f49218u;
        if (i10 != cArr.length) {
            return this.f49203d == 26 && i10 + 1 >= cArr.length;
        }
        return true;
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: J */
    public final String mo62763J() {
        if (this.f49209j) {
            return new String(this.f49206g, 0, this.f49207h);
        }
        int i10 = this.f49208i + 1;
        if (i10 < 0) {
            throw new IllegalStateException();
        }
        char[] cArr = this.f49218u;
        int length = cArr.length;
        int i11 = this.f49207h;
        if (i10 <= length - i11) {
            return new String(cArr, i10, i11);
        }
        throw new IllegalStateException();
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: b */
    public final String mo62814b(int i10, int i11, int i12, C10086j c10086j) {
        return c10086j.m62879c(this.f49218u, i10, i11, i12);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: c */
    public final void mo62816c(int i10, char[] cArr, int i11, int i12) {
        System.arraycopy(this.f49218u, i10, cArr, i11, i12);
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        char[] cArr = this.f49218u;
        if (cArr.length <= 65536) {
            f49216w.set(cArr);
        }
        this.f49218u = null;
        C11595g.m69206a(this.f49217t);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: d */
    public final boolean mo62818d(char[] cArr) {
        for (int i10 = 0; i10 < cArr.length; i10++) {
            if (mo62820e(this.f49204e + i10) != cArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: e */
    public final char mo62820e(int i10) throws IOException {
        int i11 = this.f49219v;
        if (i10 >= i11) {
            if (i11 == -1) {
                if (i10 < this.f49207h) {
                    return this.f49218u[i10];
                }
                return (char) 26;
            }
            int i12 = this.f49204e;
            if (i12 == 0) {
                char[] cArr = this.f49218u;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i12, cArr2, 0, i11);
                int i13 = this.f49219v;
                try {
                    this.f49219v += this.f49217t.read(cArr2, i13, length - i13);
                    this.f49218u = cArr2;
                } catch (IOException e10) {
                    throw new C9380d(e10.getMessage(), e10);
                }
            } else {
                int i14 = i11 - i12;
                if (i14 > 0) {
                    char[] cArr3 = this.f49218u;
                    System.arraycopy(cArr3, i12, cArr3, 0, i14);
                }
                try {
                    Reader reader = this.f49217t;
                    char[] cArr4 = this.f49218u;
                    int i15 = reader.read(cArr4, i14, cArr4.length - i14);
                    this.f49219v = i15;
                    if (i15 == 0) {
                        throw new C9380d("illegal state, textLength is zero");
                    }
                    if (i15 == -1) {
                        return (char) 26;
                    }
                    this.f49219v = i15 + i14;
                    int i16 = this.f49204e;
                    i10 -= i16;
                    this.f49208i -= i16;
                    this.f49204e = 0;
                } catch (IOException e11) {
                    throw new C9380d(e11.getMessage(), e11);
                }
            }
        }
        return this.f49218u[i10];
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: f */
    public final void mo62822f(int i10, int i11, char[] cArr) {
        System.arraycopy(this.f49218u, i10, cArr, 0, i11);
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    public final char next() throws IOException {
        int i10 = this.f49204e + 1;
        this.f49204e = i10;
        int i11 = this.f49219v;
        if (i10 >= i11) {
            if (i11 == -1) {
                return (char) 26;
            }
            int i12 = this.f49207h;
            if (i12 > 0) {
                int i13 = i11 - i12;
                if (this.f49203d == '\"' && i13 > 0) {
                    i13--;
                }
                char[] cArr = this.f49218u;
                System.arraycopy(cArr, i13, cArr, 0, i12);
            }
            this.f49208i = -1;
            int i14 = this.f49207h;
            this.f49204e = i14;
            try {
                char[] cArr2 = this.f49218u;
                int length = cArr2.length - i14;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.f49218u = cArr3;
                    length = cArr3.length - i14;
                }
                int i15 = this.f49217t.read(this.f49218u, this.f49204e, length);
                this.f49219v = i15;
                if (i15 == 0) {
                    throw new C9380d("illegal stat, textLength is zero");
                }
                if (i15 == -1) {
                    this.f49203d = (char) 26;
                    return (char) 26;
                }
                this.f49219v = i15 + this.f49204e;
                i10 = i14;
            } catch (IOException e10) {
                throw new C9380d(e10.getMessage(), e10);
            }
        }
        char c10 = this.f49218u[i10];
        this.f49203d = c10;
        return c10;
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: o1 */
    public final String mo62832o1(int i10, int i11) {
        if (i11 >= 0) {
            return new String(this.f49218u, i10, i11);
        }
        throw new StringIndexOutOfBoundsException(i11);
    }

    @Override // p323h1.AbstractC10080d
    /* renamed from: p1 */
    public final char[] mo62833p1(int i10, int i11) {
        if (i11 < 0) {
            throw new StringIndexOutOfBoundsException(i11);
        }
        if (i10 == 0) {
            return this.f49218u;
        }
        char[] cArr = new char[i11];
        System.arraycopy(this.f49218u, i10, cArr, 0, i11);
        return cArr;
    }

    @Override // p323h1.AbstractC10080d, p323h1.InterfaceC10079c
    /* renamed from: w */
    public final boolean mo62786w() {
        int i10 = 0;
        while (true) {
            char c10 = this.f49218u[i10];
            if (c10 == 26) {
                this.f49200a = 20;
                return true;
            }
            if (!AbstractC10080d.m62792J0(c10)) {
                return false;
            }
            i10++;
        }
    }
}
