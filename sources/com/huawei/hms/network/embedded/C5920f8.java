package com.huawei.hms.network.embedded;

import com.huawei.hms.drive.C5283f0;
import com.huawei.hms.network.embedded.C5920f8;
import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.AccessControlException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.network.embedded.f8 */
/* loaded from: classes8.dex */
public final class C5920f8 {

    /* renamed from: a */
    public static final byte[] f26769a;

    /* renamed from: d */
    public static final AbstractC6140w7 f26772d;

    /* renamed from: e */
    public static final AbstractC6114u7 f26773e;

    /* renamed from: k */
    public static final Method f26779k;

    /* renamed from: l */
    public static final Pattern f26780l;

    /* renamed from: b */
    public static final String[] f26770b = new String[0];

    /* renamed from: c */
    public static final C5971j7 f26771c = C5971j7.m34515a(new String[0]);

    /* renamed from: f */
    public static final C6053pb f26774f = C6053pb.m35043a(C5910eb.m34155b("efbbbf"), C5910eb.m34155b("feff"), C5910eb.m34155b("fffe"), C5910eb.m34155b("0000ffff"), C5910eb.m34155b("ffff0000"));

    /* renamed from: g */
    public static final Charset f26775g = Charset.forName("UTF-32BE");

    /* renamed from: h */
    public static final Charset f26776h = Charset.forName("UTF-32LE");

    /* renamed from: i */
    public static final TimeZone f26777i = TimeZone.getTimeZone("GMT");

    /* renamed from: j */
    public static final Comparator<String> f26778j = new C5283f0();

    static {
        byte[] bArr = new byte[0];
        f26769a = bArr;
        Method declaredMethod = null;
        f26772d = AbstractC6140w7.m35734a((C6036o7) null, bArr);
        f26773e = AbstractC6114u7.create((C6036o7) null, bArr);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f26779k = declaredMethod;
        f26780l = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* renamed from: a */
    public static int m34228a(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 >= 'a' && c10 <= 'f') {
            return c10 - 'W';
        }
        if (c10 < 'A' || c10 > 'F') {
            return -1;
        }
        return c10 - '7';
    }

    /* renamed from: b */
    public static int m34258b(String str, int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: c */
    public static int m34263c(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: d */
    public static String m34265d(String str, int i10, int i11) {
        int iM34258b = m34258b(str, i10, i11);
        return str.substring(iM34258b, m34264c(str, iM34258b, i11));
    }

    /* renamed from: e */
    public static boolean m34267e(String str) {
        return f26780l.matcher(str).matches();
    }

    /* renamed from: a */
    public static int m34229a(String str, int i10, int i11, char c10) {
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: b */
    public static C5971j7 m34259b(List<C6090s9> list) {
        C5971j7.a aVar = new C5971j7.a();
        for (C6090s9 c6090s9 : list) {
            AbstractC5879c8.f26567a.mo34048a(aVar, c6090s9.f28243a.mo34196n(), c6090s9.f28244b.mo34196n());
        }
        return aVar.m34535a();
    }

    /* renamed from: c */
    public static int m34264c(String str, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            char cCharAt = str.charAt(i12);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i12 + 1;
            }
        }
        return i10;
    }

    /* renamed from: d */
    public static boolean m34266d(String str) {
        return str.equalsIgnoreCase(FeedbackWebConstants.AUTHORIZATION) || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    /* renamed from: a */
    public static int m34230a(String str, int i10, int i11, String str2) {
        while (i10 < i11) {
            if (str2.indexOf(str.charAt(i10)) != -1) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: b */
    public static boolean m34260b(InterfaceC6183zb interfaceC6183zb, int i10, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jMo33845c = interfaceC6183zb.timeout().mo33846d() ? interfaceC6183zb.timeout().mo33845c() - jNanoTime : Long.MAX_VALUE;
        interfaceC6183zb.timeout().deadlineNanoTime(Math.min(jMo33845c, timeUnit.toNanos(i10)) + jNanoTime);
        try {
            C5868bb c5868bb = new C5868bb();
            while (interfaceC6183zb.read(c5868bb, 8192L) != -1) {
                c5868bb.m33983s();
            }
            C5855ac c5855acTimeout = interfaceC6183zb.timeout();
            if (jMo33845c == Long.MAX_VALUE) {
                c5855acTimeout.mo33841a();
                return true;
            }
            c5855acTimeout.deadlineNanoTime(jNanoTime + jMo33845c);
            return true;
        } catch (InterruptedIOException unused) {
            C5855ac c5855acTimeout2 = interfaceC6183zb.timeout();
            if (jMo33845c == Long.MAX_VALUE) {
                c5855acTimeout2.mo33841a();
                return false;
            }
            c5855acTimeout2.deadlineNanoTime(jNanoTime + jMo33845c);
            return false;
        } catch (Throwable th2) {
            C5855ac c5855acTimeout3 = interfaceC6183zb.timeout();
            if (jMo33845c == Long.MAX_VALUE) {
                c5855acTimeout3.mo33841a();
            } else {
                c5855acTimeout3.deadlineNanoTime(jNanoTime + jMo33845c);
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public static int m34231a(String str, long j10, TimeUnit timeUnit) {
        if (j10 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    /* renamed from: b */
    public static boolean m34261b(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m34232a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static boolean m34262b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m34233a(C6010m7 c6010m7, boolean z10) {
        String strM34797h;
        if (c6010m7.m34797h().contains(":")) {
            strM34797h = "[" + c6010m7.m34797h() + "]";
        } else {
            strM34797h = c6010m7.m34797h();
        }
        if (!z10 && c6010m7.m34803n() == C6010m7.m34780e(c6010m7.m34808s())) {
            return strM34797h;
        }
        return strM34797h + ":" + c6010m7.m34803n();
    }

    /* renamed from: a */
    public static String m34234a(String str) {
        int length;
        int i10;
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (m34261b(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            i10 = 1;
            length = str.length() - 1;
        } else {
            length = str.length();
            i10 = 0;
        }
        InetAddress inetAddressM34239a = m34239a(str, i10, length);
        if (inetAddressM34239a == null) {
            return null;
        }
        byte[] address = inetAddressM34239a.getAddress();
        if (address.length == 16) {
            return m34237a(address);
        }
        if (address.length == 4) {
            return inetAddressM34239a.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    /* renamed from: a */
    public static String m34235a(String str, String str2) {
        try {
            String property = System.getProperty(str);
            return property != null ? property : str2;
        } catch (AccessControlException unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public static String m34236a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static String m34237a(byte[] bArr) {
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i12;
            while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        C5868bb c5868bb = new C5868bb();
        while (i11 < bArr.length) {
            if (i11 == i10) {
                c5868bb.writeByte(58);
                i11 += i13;
                if (i11 == 16) {
                    c5868bb.writeByte(58);
                }
            } else {
                if (i11 > 0) {
                    c5868bb.writeByte(58);
                }
                c5868bb.mo33953c(((bArr[i11] & 255) << 8) | (bArr[i11 + 1] & 255));
                i11 += 2;
            }
        }
        return c5868bb.mo33979o();
    }

    /* renamed from: a */
    public static /* synthetic */ Thread m34238a(String str, boolean z10, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z10);
        return thread;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0079, code lost:
    
        if (r4 == 16) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x007b, code lost:
    
        if (r5 != (-1)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x007e, code lost:
    
        r12 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0094, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x004f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.InetAddress m34239a(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            r7 = 0
            if (r13 >= r14) goto L79
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L79
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = m34255a(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L79
        L4a:
            return r7
        L4b:
            r8 = r2
            r13 = r6
        L4d:
            if (r13 >= r14) goto L60
            char r10 = r12.charAt(r13)
            int r10 = m34228a(r10)
            if (r10 != r3) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L60:
            int r10 = r13 - r6
            if (r10 == 0) goto L78
            r11 = 4
            if (r10 <= r11) goto L68
            goto L78
        L68:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7e
            return r7
        L7e:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8a:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r12
        L8f:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5920f8.m34239a(java.lang.String, int, int):java.net.InetAddress");
    }

    /* renamed from: a */
    public static Charset m34240a(InterfaceC5896db interfaceC5896db, Charset charset) throws IOException {
        int iMo33915a = interfaceC5896db.mo33915a(f26774f);
        if (iMo33915a == -1) {
            return charset;
        }
        if (iMo33915a == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iMo33915a == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iMo33915a == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iMo33915a == 3) {
            return f26775g;
        }
        if (iMo33915a == 4) {
            return f26776h;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static List<C6090s9> m34241a(C5971j7 c5971j7) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < c5971j7.m34527d(); i10++) {
            arrayList.add(new C6090s9(c5971j7.m34520a(i10), c5971j7.m34522b(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <T> List<T> m34242a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    @SafeVarargs
    /* renamed from: a */
    public static <T> List<T> m34243a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m34244a(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: a */
    public static ThreadFactory m34245a(final String str, final boolean z10) {
        return new ThreadFactory() { // from class: gq.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C5920f8.m34238a(str, z10, runnable);
            }
        };
    }

    /* renamed from: a */
    public static X509TrustManager m34246a() throws NoSuchAlgorithmException, KeyStoreException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS", e10);
        }
    }

    /* renamed from: a */
    public static void m34247a(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static void m34248a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (AssertionError | RuntimeException e10) {
                C6013ma.m34863f().mo34331a(5, e10.getMessage(), e10);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m34249a(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f26779k;
        if (method != null) {
            try {
                method.invoke(th2, th3);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m34250a(ServerSocket serverSocket) throws IOException {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m34251a(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e10) {
                if (!m34254a(e10)) {
                    throw e10;
                }
            } catch (RuntimeException e11) {
                if (!"bio == null".equals(e11.getMessage())) {
                    throw e11;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m34252a(C6010m7 c6010m7, C6010m7 c6010m72) {
        return c6010m7.m34797h().equals(c6010m72.m34797h()) && c6010m7.m34803n() == c6010m72.m34803n() && c6010m7.m34808s().equals(c6010m72.m34808s());
    }

    /* renamed from: a */
    public static boolean m34253a(InterfaceC6183zb interfaceC6183zb, int i10, TimeUnit timeUnit) {
        try {
            return m34260b(interfaceC6183zb, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m34254a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static boolean m34255a(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13 = i12;
        while (i10 < i11) {
            if (i13 == bArr.length) {
                return false;
            }
            if (i13 != i12) {
                if (str.charAt(i10) != '.') {
                    return false;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = 0;
            while (i14 < i11) {
                char cCharAt = str.charAt(i14);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i14++;
            }
            if (i14 - i10 == 0) {
                return false;
            }
            bArr[i13] = (byte) i15;
            i13++;
            i10 = i14;
        }
        return i13 == i12 + 4;
    }

    /* renamed from: a */
    public static String[] m34256a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i10]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i10++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public static String[] m34257a(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }
}
