package com.huawei.android.backup.filelogic.utils;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p699v4.C13339h;

/* renamed from: com.huawei.android.backup.filelogic.utils.c */
/* loaded from: classes.dex */
public class C2110c {

    /* renamed from: f */
    public static volatile boolean f9531f = false;

    /* renamed from: g */
    public static volatile int f9532g = -1;

    /* renamed from: h */
    public static volatile boolean f9533h = false;

    /* renamed from: a */
    public LocalSocket f9534a;

    /* renamed from: b */
    public OutputStream f9535b;

    /* renamed from: c */
    public InputStream f9536c;

    /* renamed from: d */
    public byte[] f9537d;

    /* renamed from: e */
    public byte[] f9538e;

    /* renamed from: a */
    public static int m12626a(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i11; i13++) {
            i12 += (bArr[i13] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << ((i13 - i10) * 8);
        }
        return i12;
    }

    /* renamed from: b */
    public static long m12627b(byte[] bArr, int i10, int i11) {
        long j10 = 0;
        for (int i12 = i10; i12 < i11; i12++) {
            j10 += (bArr[i12] & 255) << ((i12 - i10) * 8);
        }
        return j10;
    }

    /* renamed from: i */
    public static boolean m12628i() {
        return f9531f;
    }

    /* renamed from: n */
    public static void m12629n(boolean z10) {
        f9533h = z10;
    }

    /* renamed from: o */
    public static void m12630o(int i10) {
        f9532g = i10;
    }

    /* renamed from: p */
    public static void m12631p(boolean z10) {
        f9531f = z10;
    }

    /* renamed from: c */
    public boolean m12632c() throws IOException {
        C2111d.m12653i("FileSocketUtil", "connectSocket start");
        if (!m12639k() || this.f9534a != null) {
            return false;
        }
        try {
            this.f9534a = new LocalSocket();
            this.f9534a.connect(new LocalSocketAddress("filebackup", LocalSocketAddress.Namespace.RESERVED));
            this.f9536c = this.f9534a.getInputStream();
            this.f9535b = this.f9534a.getOutputStream();
            this.f9537d = new byte[8448];
            this.f9538e = new byte[256];
            m12631p(true);
            m12629n(m12637h());
            C2111d.m12653i("FileSocketUtil", "connectSocket success");
            return true;
        } catch (IOException unused) {
            C2111d.m12648d("FileSocketUtil", "connectSocket fail");
            m12633d();
            return false;
        } catch (Exception unused2) {
            C2111d.m12648d("FileSocketUtil", "connectSocket Exception");
            m12633d();
            return false;
        }
    }

    /* renamed from: d */
    public void m12633d() throws IOException {
        C2111d.m12653i("FileSocketUtil", "disconnecting...");
        C13339h.m80014a(this.f9536c);
        C13339h.m80014a(this.f9535b);
        try {
            LocalSocket localSocket = this.f9534a;
            if (localSocket != null) {
                localSocket.close();
            }
        } catch (IOException unused) {
            C2111d.m12648d("FileSocketUtil", "disconnect error， IOException");
        } catch (Exception unused2) {
            C2111d.m12648d("FileSocketUtil", "disconnect error");
        }
        m12630o(1);
        this.f9537d = null;
        this.f9538e = null;
        this.f9534a = null;
        this.f9536c = null;
        this.f9535b = null;
        m12629n(false);
        m12631p(false);
    }

    /* renamed from: e */
    public byte[] m12634e() {
        byte[] bArr = this.f9538e;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    /* renamed from: f */
    public long m12635f(byte[] bArr) {
        int iM12644s;
        try {
            iM12644s = m12644s(bArr, this.f9537d);
        } catch (IOException unused) {
            C2111d.m12648d("FileSocketUtil", "getHandle socket write error Exception");
            iM12644s = -100;
        }
        long jM12627b = -100;
        if (iM12644s >= 4 && m12626a(this.f9537d, 0, 4) != 0) {
            C2111d.m12657m("FileSocketUtil", "getHandle socket replay Exception");
            return -100L;
        }
        if (iM12644s >= 8) {
            jM12627b = f9533h ? m12627b(this.f9537d, 4, 12) : m12626a(this.f9537d, 4, 8);
        } else {
            C2111d.m12657m("FileSocketUtil", "buflen < ONE_INT_LENGTH * 2");
        }
        Arrays.fill(this.f9537d, 0, iM12644s, (byte) 0);
        return jM12627b;
    }

    /* renamed from: g */
    public byte[] m12636g() {
        byte[] bArr = this.f9537d;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    /* renamed from: h */
    public final boolean m12637h() {
        try {
            if (m12644s("getbytelenofptr 0".getBytes(Constants.UTF_8), this.f9537d) < 8 || m12626a(this.f9537d, 0, 4) != 0) {
                return false;
            }
            return m12626a(this.f9537d, 4, 8) == 8;
        } catch (IOException unused) {
            C2111d.m12648d("FileSocketUtil", "GET_SYSTEM_BIT_CMD error ");
            return false;
        }
    }

    /* renamed from: j */
    public final int m12638j() {
        Future futureSubmit;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(1);
        int i10 = 0;
        try {
            futureSubmit = executorServiceNewFixedThreadPool.submit(new CallableC2112e());
        } catch (TimeoutException unused) {
            C2111d.m12648d("FileSocketUtil", "query local Socket TimeOut!");
            i10 = -2;
        } catch (Exception unused2) {
            C2111d.m12648d("FileSocketUtil", "local Socket is not exist!");
        }
        if (futureSubmit == null) {
            return 0;
        }
        int iIntValue = ((Integer) futureSubmit.get(1000L, TimeUnit.MILLISECONDS)).intValue();
        C2111d.m12653i("FileSocketUtil", "retState = " + iIntValue);
        i10 = iIntValue;
        executorServiceNewFixedThreadPool.shutdown();
        return i10;
    }

    /* renamed from: k */
    public final boolean m12639k() {
        if (f9532g == -1) {
            m12630o(m12638j());
        }
        return f9532g == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        com.huawei.android.backup.filelogic.utils.C2111d.m12648d("FileSocketUtil", "read error ");
     */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m12640l(byte[] r6, int r7) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "FileSocketUtil"
            java.io.InputStream r1 = r5.f9536c
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            if (r7 <= 0) goto L27
            r1 = r2
        Lb:
            if (r1 == r7) goto L24
            java.io.InputStream r3 = r5.f9536c     // Catch: java.io.IOException -> L1f
            int r4 = r7 - r1
            int r3 = r3.read(r6, r1, r4)     // Catch: java.io.IOException -> L1f
            if (r3 > 0) goto L1d
            java.lang.String r5 = "read error "
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r5)     // Catch: java.io.IOException -> L1f
            goto L24
        L1d:
            int r1 = r1 + r3
            goto Lb
        L1f:
            java.lang.String r5 = "readBytes exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r5)
        L24:
            if (r1 != r7) goto L27
            r2 = 1
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.filelogic.utils.C2110c.m12640l(byte[], int):boolean");
    }

    /* renamed from: m */
    public final int m12641m(byte[] bArr) {
        if (!m12640l(bArr, 2)) {
            C2111d.m12648d("FileSocketUtil", "!readReply() lenth  error");
            return -100;
        }
        int i10 = (bArr[0] & 255) | ((bArr[1] & 255) << 8);
        if (i10 < 1 || i10 > 8448) {
            C2111d.m12648d("FileSocketUtil", "readReply() invalid reply length ");
            return -100;
        }
        Arrays.fill(bArr, 0, 2, (byte) 0);
        if (m12640l(bArr, i10)) {
            return i10;
        }
        C2111d.m12648d("FileSocketUtil", "!readBytes(buf, buflen) error");
        return -100;
    }

    /* renamed from: q */
    public final boolean m12642q(int i10) {
        return i10 >= 1 && i10 <= 8448;
    }

    /* renamed from: r */
    public int m12643r(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IOException {
        OutputStream outputStream;
        int length;
        if (bArr == null || bArr3 == null || (outputStream = this.f9535b) == null || (length = bArr.length + bArr2.length) < 1 || length > 8448) {
            return -100;
        }
        bArr3[0] = (byte) (length & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr3[1] = (byte) ((length >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        outputStream.write(bArr3, 0, 2);
        this.f9535b.write(bArr, 0, bArr.length);
        this.f9535b.write(bArr2, 0, bArr2.length);
        this.f9535b.flush();
        Arrays.fill(bArr3, 0, 2, (byte) 0);
        return m12641m(bArr3);
    }

    /* renamed from: s */
    public int m12644s(byte[] bArr, byte[] bArr2) throws IOException {
        if (bArr == null) {
            throw new IOException("command is null!");
        }
        int length = bArr.length;
        if (this.f9535b == null || !m12642q(length)) {
            return -100;
        }
        bArr2[0] = (byte) (length & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr2[1] = (byte) ((length >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        this.f9535b.write(bArr2, 0, 2);
        this.f9535b.write(bArr, 0, length);
        Arrays.fill(bArr2, 0, 2, (byte) 0);
        return m12641m(bArr2);
    }
}
