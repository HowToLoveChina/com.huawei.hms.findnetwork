package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import p022ay.C1061k;
import p022ay.C1064n;
import p022ay.InterfaceC1056f;
import p791xx.C13893h;

/* loaded from: classes9.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e */
    public static final byte[] f55471e = {42};

    /* renamed from: f */
    public static final String[] f55472f = new String[0];

    /* renamed from: g */
    public static final String[] f55473g = {"*"};

    /* renamed from: h */
    public static final PublicSuffixDatabase f55474h = new PublicSuffixDatabase();

    /* renamed from: a */
    public final AtomicBoolean f55475a = new AtomicBoolean(false);

    /* renamed from: b */
    public final CountDownLatch f55476b = new CountDownLatch(1);

    /* renamed from: c */
    public byte[] f55477c;

    /* renamed from: d */
    public byte[] f55478d;

    /* renamed from: a */
    public static String m71779a(byte[] bArr, byte[][] bArr2, int i10) {
        int i11;
        boolean z10;
        int i12;
        int i13;
        int length = bArr.length;
        int i14 = 0;
        while (i14 < length) {
            int i15 = (i14 + length) / 2;
            while (i15 > -1 && bArr[i15] != 10) {
                i15--;
            }
            int i16 = i15 + 1;
            int i17 = 1;
            while (true) {
                i11 = i16 + i17;
                if (bArr[i11] == 10) {
                    break;
                }
                i17++;
            }
            int i18 = i11 - i16;
            int i19 = i10;
            boolean z11 = false;
            int i20 = 0;
            int i21 = 0;
            while (true) {
                if (z11) {
                    i12 = 46;
                    z10 = false;
                } else {
                    z10 = z11;
                    i12 = bArr2[i19][i20] & 255;
                }
                i13 = i12 - (bArr[i16 + i21] & 255);
                if (i13 == 0) {
                    i21++;
                    i20++;
                    if (i21 == i18) {
                        break;
                    }
                    if (bArr2[i19].length != i20) {
                        z11 = z10;
                    } else {
                        if (i19 == bArr2.length - 1) {
                            break;
                        }
                        i19++;
                        i20 = -1;
                        z11 = true;
                    }
                } else {
                    break;
                }
            }
            if (i13 >= 0) {
                if (i13 <= 0) {
                    int i22 = i18 - i21;
                    int length2 = bArr2[i19].length - i20;
                    while (true) {
                        i19++;
                        if (i19 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i19].length;
                    }
                    if (length2 >= i22) {
                        if (length2 <= i22) {
                            return new String(bArr, i16, i18, StandardCharsets.UTF_8);
                        }
                    }
                }
                i14 = i11 + 1;
            }
            length = i15;
        }
        return null;
    }

    /* renamed from: c */
    public static PublicSuffixDatabase m71780c() {
        return f55474h;
    }

    /* renamed from: b */
    public final String[] m71781b(String[] strArr) throws InterruptedException {
        String str;
        String strM71779a;
        String strM71779a2;
        int i10 = 0;
        if (this.f55475a.get() || !this.f55475a.compareAndSet(false, true)) {
            try {
                this.f55476b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            m71784f();
        }
        synchronized (this) {
            if (this.f55477c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            bArr[i11] = strArr[i11].getBytes(StandardCharsets.UTF_8);
        }
        int i12 = 0;
        while (true) {
            str = null;
            if (i12 >= length) {
                strM71779a = null;
                break;
            }
            strM71779a = m71779a(this.f55477c, bArr, i12);
            if (strM71779a != null) {
                break;
            }
            i12++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i13 = 0; i13 < bArr2.length - 1; i13++) {
                bArr2[i13] = f55471e;
                strM71779a2 = m71779a(this.f55477c, bArr2, i13);
                if (strM71779a2 != null) {
                    break;
                }
            }
            strM71779a2 = null;
        } else {
            strM71779a2 = null;
        }
        if (strM71779a2 != null) {
            while (true) {
                if (i10 >= length - 1) {
                    break;
                }
                String strM71779a3 = m71779a(this.f55478d, bArr, i10);
                if (strM71779a3 != null) {
                    str = strM71779a3;
                    break;
                }
                i10++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strM71779a == null && strM71779a2 == null) {
            return f55473g;
        }
        String[] strArrSplit = strM71779a != null ? strM71779a.split("\\.") : f55472f;
        String[] strArrSplit2 = strM71779a2 != null ? strM71779a2.split("\\.") : f55472f;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    /* renamed from: d */
    public String m71782d(String str) throws InterruptedException {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrM71781b = m71781b(strArrSplit);
        if (strArrSplit.length == strArrM71781b.length && strArrM71781b[0].charAt(0) != '!') {
            return null;
        }
        if (strArrM71781b[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrM71781b.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrM71781b.length + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i10 = length - length2; i10 < strArrSplit2.length; i10++) {
            sb2.append(strArrSplit2[i10]);
            sb2.append('.');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

    /* renamed from: e */
    public final void m71783e() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(com.huawei.hms.network.okhttp.PublicSuffixDatabase.f29561e);
        if (resourceAsStream == null) {
            return;
        }
        InterfaceC1056f interfaceC1056fM6403b = C1064n.m6403b(new C1061k(C1064n.m6407f(resourceAsStream)));
        try {
            byte[] bArr = new byte[interfaceC1056fM6403b.readInt()];
            interfaceC1056fM6403b.readFully(bArr);
            byte[] bArr2 = new byte[interfaceC1056fM6403b.readInt()];
            interfaceC1056fM6403b.readFully(bArr2);
            interfaceC1056fM6403b.close();
            synchronized (this) {
                this.f55477c = bArr;
                this.f55478d = bArr2;
            }
            this.f55476b.countDown();
        } catch (Throwable th2) {
            if (interfaceC1056fM6403b != null) {
                try {
                    interfaceC1056fM6403b.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: f */
    public final void m71784f() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    m71783e();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    C13893h.m83291l().mo83257s(5, "Failed to read public suffix list", e10);
                    if (z10) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }
}
