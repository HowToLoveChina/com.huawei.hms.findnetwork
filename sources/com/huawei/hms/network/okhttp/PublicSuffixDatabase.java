package com.huawei.hms.network.okhttp;

import com.huawei.hms.network.embedded.C5988kb;
import com.huawei.hms.network.embedded.C6013ma;
import com.huawei.hms.network.embedded.C6040ob;
import com.huawei.hms.network.embedded.InterfaceC5896db;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e */
    public static final String f29561e = "publicsuffixes.gz";

    /* renamed from: i */
    public static final byte f29565i = 33;

    /* renamed from: a */
    public final AtomicBoolean f29567a = new AtomicBoolean(false);

    /* renamed from: b */
    public final CountDownLatch f29568b = new CountDownLatch(1);

    /* renamed from: c */
    public byte[] f29569c;

    /* renamed from: d */
    public byte[] f29570d;

    /* renamed from: f */
    public static final byte[] f29562f = {42};

    /* renamed from: g */
    public static final String[] f29563g = new String[0];

    /* renamed from: h */
    public static final String[] f29564h = {"*"};

    /* renamed from: j */
    public static final PublicSuffixDatabase f29566j = new PublicSuffixDatabase();

    /* renamed from: a */
    public static PublicSuffixDatabase m36398a() {
        return f29566j;
    }

    /* renamed from: b */
    private void m36401b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(f29561e);
        if (resourceAsStream == null) {
            return;
        }
        InterfaceC5896db interfaceC5896dbM34934a = C6040ob.m34934a(new C5988kb(C6040ob.m34941a(resourceAsStream)));
        try {
            byte[] bArr = new byte[interfaceC5896dbM34934a.readInt()];
            interfaceC5896dbM34934a.readFully(bArr);
            byte[] bArr2 = new byte[interfaceC5896dbM34934a.readInt()];
            interfaceC5896dbM34934a.readFully(bArr2);
            interfaceC5896dbM34934a.close();
            synchronized (this) {
                this.f29569c = bArr;
                this.f29570d = bArr2;
            }
            this.f29568b.countDown();
        } catch (Throwable th2) {
            if (interfaceC5896dbM34934a != null) {
                try {
                    interfaceC5896dbM34934a.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: c */
    private void m36402c() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    m36401b();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    C6013ma.m34863f().mo34331a(5, "Failed to read public suffix list", e10);
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

    /* renamed from: a */
    public String m36403a(String str) throws InterruptedException {
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrM36400a = m36400a(strArrSplit);
        if (strArrSplit.length == strArrM36400a.length && strArrM36400a[0].charAt(0) != '!') {
            return null;
        }
        char cCharAt = strArrM36400a[0].charAt(0);
        int length = strArrSplit.length;
        int length2 = strArrM36400a.length;
        if (cCharAt != '!') {
            length2++;
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
    public static String m36399a(byte[] bArr, byte[][] bArr2, int i10) {
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

    /* renamed from: a */
    public void m36404a(byte[] bArr, byte[] bArr2) {
        this.f29569c = bArr;
        this.f29570d = bArr2;
        this.f29567a.set(true);
        this.f29568b.countDown();
    }

    /* renamed from: a */
    private String[] m36400a(String[] strArr) throws InterruptedException {
        String str;
        String strM36399a;
        String strM36399a2;
        int i10 = 0;
        if (this.f29567a.get() || !this.f29567a.compareAndSet(false, true)) {
            try {
                this.f29568b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            m36402c();
        }
        synchronized (this) {
            if (this.f29569c == null) {
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
                strM36399a = null;
                break;
            }
            strM36399a = m36399a(this.f29569c, bArr, i12);
            if (strM36399a != null) {
                break;
            }
            i12++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i13 = 0; i13 < bArr2.length - 1; i13++) {
                bArr2[i13] = f29562f;
                strM36399a2 = m36399a(this.f29569c, bArr2, i13);
                if (strM36399a2 != null) {
                    break;
                }
            }
            strM36399a2 = null;
        } else {
            strM36399a2 = null;
        }
        if (strM36399a2 != null) {
            while (true) {
                if (i10 >= length - 1) {
                    break;
                }
                String strM36399a3 = m36399a(this.f29570d, bArr, i10);
                if (strM36399a3 != null) {
                    str = strM36399a3;
                    break;
                }
                i10++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strM36399a == null && strM36399a2 == null) {
            return f29564h;
        }
        String[] strArrSplit = strM36399a != null ? strM36399a.split("\\.") : f29563g;
        String[] strArrSplit2 = strM36399a2 != null ? strM36399a2.split("\\.") : f29563g;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }
}
