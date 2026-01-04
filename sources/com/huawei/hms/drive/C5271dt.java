package com.huawei.hms.drive;

import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
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

/* renamed from: com.huawei.hms.drive.dt */
/* loaded from: classes8.dex */
public final class C5271dt {

    /* renamed from: a */
    private static final byte[] f24493a = {42};

    /* renamed from: b */
    private static final String[] f24494b = new String[0];

    /* renamed from: c */
    private static final String[] f24495c = {"*"};

    /* renamed from: d */
    private static final C5271dt f24496d = new C5271dt();

    /* renamed from: e */
    private final AtomicBoolean f24497e = new AtomicBoolean(false);

    /* renamed from: f */
    private final CountDownLatch f24498f = new CountDownLatch(1);

    /* renamed from: g */
    private byte[] f24499g;

    /* renamed from: h */
    private byte[] f24500h;

    /* renamed from: a */
    public static C5271dt m31695a() {
        return f24496d;
    }

    /* renamed from: b */
    private void m31698b() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    m31699c();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    C5269dr.m31692e().mo31656a(5, "Failed to read public suffix list", e10);
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

    /* renamed from: c */
    private void m31699c() throws IOException {
        InputStream resourceAsStream = C5271dt.class.getResourceAsStream(PublicSuffixDatabase.f29561e);
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
                this.f24499g = bArr;
                this.f24500h = bArr2;
            }
            this.f24498f.countDown();
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

    /* renamed from: a */
    public String m31700a(String str) throws InterruptedException {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrM31697a = m31697a(strArrSplit);
        if (strArrSplit.length == strArrM31697a.length && strArrM31697a[0].charAt(0) != '!') {
            return null;
        }
        if (strArrM31697a[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrM31697a.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrM31697a.length + 1;
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

    /* renamed from: a */
    private String[] m31697a(String[] strArr) throws InterruptedException {
        String str;
        String strM31696a;
        String strM31696a2;
        String[] strArrSplit;
        String[] strArrSplit2;
        int i10 = 0;
        if (!this.f24497e.get() && this.f24497e.compareAndSet(false, true)) {
            m31698b();
        } else {
            try {
                this.f24498f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.f24499g == null) {
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
                strM31696a = null;
                break;
            }
            strM31696a = m31696a(this.f24499g, bArr, i12);
            if (strM31696a != null) {
                break;
            }
            i12++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i13 = 0; i13 < bArr2.length - 1; i13++) {
                bArr2[i13] = f24493a;
                strM31696a2 = m31696a(this.f24499g, bArr2, i13);
                if (strM31696a2 != null) {
                    break;
                }
            }
            strM31696a2 = null;
        } else {
            strM31696a2 = null;
        }
        if (strM31696a2 != null) {
            while (true) {
                if (i10 >= length - 1) {
                    break;
                }
                String strM31696a3 = m31696a(this.f24500h, bArr, i10);
                if (strM31696a3 != null) {
                    str = strM31696a3;
                    break;
                }
                i10++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strM31696a == null && strM31696a2 == null) {
            return f24495c;
        }
        if (strM31696a != null) {
            strArrSplit = strM31696a.split("\\.");
        } else {
            strArrSplit = f24494b;
        }
        if (strM31696a2 != null) {
            strArrSplit2 = strM31696a2.split("\\.");
        } else {
            strArrSplit2 = f24494b;
        }
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    /* renamed from: a */
    private static String m31696a(byte[] bArr, byte[][] bArr2, int i10) {
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
}
