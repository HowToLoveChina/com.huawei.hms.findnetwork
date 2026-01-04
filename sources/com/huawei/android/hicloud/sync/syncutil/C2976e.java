package com.huawei.android.hicloud.sync.syncutil;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.e */
/* loaded from: classes3.dex */
public class C2976e {

    /* renamed from: f */
    public static volatile boolean f13012f = false;

    /* renamed from: g */
    public static volatile int f13013g = -1;

    /* renamed from: h */
    public static volatile boolean f13014h = false;

    /* renamed from: a */
    public LocalSocket f13015a;

    /* renamed from: b */
    public OutputStream f13016b;

    /* renamed from: c */
    public InputStream f13017c;

    /* renamed from: d */
    public byte[] f13018d = new byte[8448];

    /* renamed from: e */
    public byte[] f13019e = new byte[256];

    /* renamed from: com.huawei.android.hicloud.sync.syncutil.e$b */
    public static class b implements Callable<Integer> {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Integer call() throws java.lang.Exception {
            /*
                r6 = this;
                java.lang.String r6 = "Close local Socket Error!"
                java.lang.String r0 = "FileSocketUtil"
                r1 = 0
                android.net.LocalSocket r2 = new android.net.LocalSocket     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2c
                r2.<init>()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2c
                android.net.LocalSocketAddress r1 = new android.net.LocalSocketAddress     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
                java.lang.String r3 = "filebackup"
                android.net.LocalSocketAddress$Namespace r4 = android.net.LocalSocketAddress.Namespace.RESERVED     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
                r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
                r2.connect(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
                r2.close()     // Catch: java.io.IOException -> L1a
                goto L1d
            L1a:
                p514o9.C11839m.m70687e(r0, r6)
            L1d:
                r6 = 1
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                return r6
            L23:
                r1 = move-exception
                goto L57
            L25:
                r1 = move-exception
                goto L30
            L27:
                r2 = move-exception
                r5 = r2
                r2 = r1
                r1 = r5
                goto L57
            L2c:
                r2 = move-exception
                r5 = r2
                r2 = r1
                r1 = r5
            L30:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
                r3.<init>()     // Catch: java.lang.Throwable -> L23
                java.lang.String r4 = "local Socket error: "
                r3.append(r4)     // Catch: java.lang.Throwable -> L23
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L23
                r3.append(r1)     // Catch: java.lang.Throwable -> L23
                java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L23
                p514o9.C11839m.m70687e(r0, r1)     // Catch: java.lang.Throwable -> L23
                r1 = 0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L23
                if (r2 == 0) goto L56
                r2.close()     // Catch: java.io.IOException -> L53
                goto L56
            L53:
                p514o9.C11839m.m70687e(r0, r6)
            L56:
                return r1
            L57:
                if (r2 == 0) goto L60
                r2.close()     // Catch: java.io.IOException -> L5d
                goto L60
            L5d:
                p514o9.C11839m.m70687e(r0, r6)
            L60:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.syncutil.C2976e.b.call():java.lang.Integer");
        }
    }

    /* renamed from: a */
    public static int m17841a(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i11; i13++) {
            i12 += (bArr[i13] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << ((i13 - i10) * 8);
        }
        return i12;
    }

    /* renamed from: b */
    public static long m17842b(byte[] bArr, int i10, int i11) {
        long j10 = 0;
        for (int i12 = i10; i12 < i11; i12++) {
            j10 += (bArr[i12] & 255) << ((i12 - i10) * 8);
        }
        return j10;
    }

    /* renamed from: h */
    public static boolean m17843h() {
        return f13012f;
    }

    /* renamed from: m */
    public static void m17844m(boolean z10) {
        f13014h = z10;
    }

    /* renamed from: n */
    public static void m17845n(int i10) {
        f13013g = i10;
    }

    /* renamed from: o */
    public static void m17846o(boolean z10) {
        f13012f = z10;
    }

    /* renamed from: c */
    public boolean m17847c() throws IOException {
        if (!m17853j() || this.f13015a != null) {
            return false;
        }
        try {
            this.f13015a = new LocalSocket();
            this.f13015a.connect(new LocalSocketAddress("filebackup", LocalSocketAddress.Namespace.RESERVED));
            this.f13017c = this.f13015a.getInputStream();
            this.f13016b = this.f13015a.getOutputStream();
            m17846o(true);
            m17844m(m17851g());
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("FileSocketUtil", "connectSocket Exception: " + e10.toString());
            m17848d();
            return false;
        }
    }

    /* renamed from: d */
    public void m17848d() throws IOException {
        C11839m.m70688i("FileSocketUtil", "disconnecting...");
        try {
            InputStream inputStream = this.f13017c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception unused) {
            C11839m.m70687e("FileSocketUtil", "close input error");
        }
        try {
            OutputStream outputStream = this.f13016b;
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Exception unused2) {
            C11839m.m70687e("FileSocketUtil", "close out error");
        }
        try {
            LocalSocket localSocket = this.f13015a;
            if (localSocket != null) {
                localSocket.close();
            }
        } catch (Exception unused3) {
            C11839m.m70687e("FileSocketUtil", "disconnect error");
        }
        m17845n(1);
        this.f13018d = null;
        this.f13019e = null;
        this.f13015a = null;
        this.f13017c = null;
        this.f13016b = null;
        m17844m(false);
        m17846o(false);
    }

    /* renamed from: e */
    public long m17849e(byte[] bArr) {
        int iM17856p;
        try {
            iM17856p = m17856p(bArr, this.f13018d);
        } catch (IOException unused) {
            C11839m.m70687e("FileSocketUtil", "getHandle socket write error Exception");
            iM17856p = -100;
        }
        long jM17842b = -100;
        if (iM17856p >= 4 && m17841a(this.f13018d, 0, 4) != 0) {
            C11839m.m70689w("FileSocketUtil", "getHandle socket replay Exception");
            return -100L;
        }
        if (iM17856p >= 8) {
            jM17842b = f13014h ? m17842b(this.f13018d, 4, 12) : m17841a(this.f13018d, 4, 8);
        } else {
            C11839m.m70689w("FileSocketUtil", "buflen < ONEINTLENGTH * 2");
        }
        Arrays.fill(this.f13018d, 0, iM17856p, (byte) 0);
        return jM17842b;
    }

    /* renamed from: f */
    public byte[] m17850f() {
        return (byte[]) this.f13018d.clone();
    }

    /* renamed from: g */
    public final boolean m17851g() {
        try {
            if (m17856p("getbytelenofptr 0".getBytes(Constants.UTF_8), this.f13018d) < 8 || m17841a(this.f13018d, 0, 4) != 0) {
                return false;
            }
            return m17841a(this.f13018d, 4, 8) == 8;
        } catch (IOException unused) {
            C11839m.m70687e("FileSocketUtil", "GET_SYSTEM_BIT_CMD error ");
            return false;
        }
    }

    /* renamed from: i */
    public final int m17852i() {
        int iIntValue;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(1);
        try {
            iIntValue = ((Integer) executorServiceNewFixedThreadPool.submit(new b()).get(1000L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException unused) {
            C11839m.m70687e("FileSocketUtil", "query local Socket TimeOut!");
            iIntValue = -2;
        } catch (Exception unused2) {
            C11839m.m70687e("FileSocketUtil", "local Socket is not exist!");
            iIntValue = 0;
        }
        executorServiceNewFixedThreadPool.shutdown();
        return iIntValue;
    }

    /* renamed from: j */
    public final boolean m17853j() {
        if (-1 == f13013g) {
            m17845n(m17852i());
        }
        return 1 == f13013g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        p514o9.C11839m.m70687e("FileSocketUtil", "read error ");
     */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m17854k(byte[] r6, int r7) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "FileSocketUtil"
            java.io.InputStream r1 = r5.f13017c
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            if (r7 <= 0) goto L27
            r1 = r2
        Lb:
            if (r1 == r7) goto L24
            java.io.InputStream r3 = r5.f13017c     // Catch: java.io.IOException -> L1f
            int r4 = r7 - r1
            int r3 = r3.read(r6, r1, r4)     // Catch: java.io.IOException -> L1f
            if (r3 > 0) goto L1d
            java.lang.String r5 = "read error "
            p514o9.C11839m.m70687e(r0, r5)     // Catch: java.io.IOException -> L1f
            goto L24
        L1d:
            int r1 = r1 + r3
            goto Lb
        L1f:
            java.lang.String r5 = "readBytes exception"
            p514o9.C11839m.m70687e(r0, r5)
        L24:
            if (r1 != r7) goto L27
            r2 = 1
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.syncutil.C2976e.m17854k(byte[], int):boolean");
    }

    /* renamed from: l */
    public final int m17855l(byte[] bArr) {
        if (!m17854k(bArr, 2)) {
            C11839m.m70689w("FileSocketUtil", "!readReply() lenth  error");
            return -100;
        }
        int i10 = (bArr[0] & 255) | ((bArr[1] & 255) << 8);
        if (i10 < 1 || i10 > 8448) {
            C11839m.m70689w("FileSocketUtil", "readReply() invalid reply length ");
            return -100;
        }
        Arrays.fill(bArr, 0, 2, (byte) 0);
        if (m17854k(bArr, i10)) {
            return i10;
        }
        C11839m.m70687e("FileSocketUtil", "!readBytes(buf, buflen) error");
        return -100;
    }

    /* renamed from: p */
    public int m17856p(byte[] bArr, byte[] bArr2) throws IOException {
        if (bArr == null) {
            throw new IOException("command is null!");
        }
        int length = bArr.length;
        if (length < 1 || length > 8448) {
            return -100;
        }
        bArr2[0] = (byte) (length & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr2[1] = (byte) ((length >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        OutputStream outputStream = this.f13016b;
        if (outputStream != null) {
            outputStream.write(bArr2, 0, 2);
            this.f13016b.write(bArr, 0, length);
        }
        Arrays.fill(bArr2, 0, 2, (byte) 0);
        return m17855l(bArr2);
    }
}
