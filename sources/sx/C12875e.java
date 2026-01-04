package sx;

import com.huawei.hms.drive.C5283f0;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
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
import okhttp3.AbstractC11920f0;
import okhttp3.AbstractC11924h0;
import okhttp3.C11910a0;
import okhttp3.C11955v;
import okhttp3.C11958y;
import p022ay.C1054d;
import p022ay.C1057g;
import p022ay.C1067q;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1076z;
import p755wx.C13654c;
import p791xx.C13893h;

/* renamed from: sx.e */
/* loaded from: classes9.dex */
public final class C12875e {

    /* renamed from: a */
    public static final byte[] f58640a;

    /* renamed from: d */
    public static final AbstractC11924h0 f58643d;

    /* renamed from: e */
    public static final AbstractC11920f0 f58644e;

    /* renamed from: k */
    public static final Method f58650k;

    /* renamed from: l */
    public static final Pattern f58651l;

    /* renamed from: b */
    public static final String[] f58641b = new String[0];

    /* renamed from: c */
    public static final C11955v f58642c = C11955v.m71852i(new String[0]);

    /* renamed from: f */
    public static final C1067q f58645f = C1067q.m6417h(C1057g.m6363f("efbbbf"), C1057g.m6363f("feff"), C1057g.m6363f("fffe"), C1057g.m6363f("0000ffff"), C1057g.m6363f("ffff0000"));

    /* renamed from: g */
    public static final Charset f58646g = Charset.forName("UTF-32BE");

    /* renamed from: h */
    public static final Charset f58647h = Charset.forName("UTF-32LE");

    /* renamed from: i */
    public static final TimeZone f58648i = TimeZone.getTimeZone("GMT");

    /* renamed from: j */
    public static final Comparator<String> f58649j = new C5283f0();

    static {
        byte[] bArr = new byte[0];
        f58640a = bArr;
        Method declaredMethod = null;
        f58643d = AbstractC11924h0.m71631x(null, bArr);
        f58644e = AbstractC11920f0.create((C11910a0) null, bArr);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f58650k = declaredMethod;
        f58651l = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* renamed from: A */
    public static boolean m77230A(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: B */
    public static boolean m77231B(String str) {
        return str.equalsIgnoreCase(FeedbackWebConstants.AUTHORIZATION) || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    /* renamed from: C */
    public static /* synthetic */ Thread m77232C(String str, boolean z10, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z10);
        return thread;
    }

    /* renamed from: D */
    public static boolean m77233D(Comparator<String> comparator, String[] strArr, String[] strArr2) {
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

    /* renamed from: E */
    public static X509TrustManager m77234E() throws NoSuchAlgorithmException, KeyStoreException {
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

    /* renamed from: F */
    public static boolean m77235F(C11958y c11958y, C11958y c11958y2) {
        return c11958y.m71904l().equals(c11958y2.m71904l()) && c11958y.m71909w() == c11958y2.m71909w() && c11958y.m71896B().equals(c11958y2.m71896B());
    }

    /* renamed from: G */
    public static boolean m77236G(InterfaceC1076z interfaceC1076z, int i10, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = interfaceC1076z.timeout().hasDeadline() ? interfaceC1076z.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        interfaceC1076z.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i10)) + jNanoTime);
        try {
            C1054d c1054d = new C1054d();
            while (interfaceC1076z.read(c1054d, 8192L) != -1) {
                c1054d.m6352s();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                interfaceC1076z.timeout().clearDeadline();
                return true;
            }
            interfaceC1076z.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                interfaceC1076z.timeout().clearDeadline();
                return false;
            }
            interfaceC1076z.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return false;
        } catch (Throwable th2) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                interfaceC1076z.timeout().clearDeadline();
            } else {
                interfaceC1076z.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th2;
        }
    }

    /* renamed from: H */
    public static int m77237H(String str, int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: I */
    public static int m77238I(String str, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            char cCharAt = str.charAt(i12);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i12 + 1;
            }
        }
        return i10;
    }

    /* renamed from: J */
    public static ThreadFactory m77239J(final String str, final boolean z10) {
        return new ThreadFactory() { // from class: sx.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C12875e.m77232C(str, z10, runnable);
            }
        };
    }

    /* renamed from: K */
    public static List<C13654c> m77240K(C11955v c11955v) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < c11955v.m71857j(); i10++) {
            arrayList.add(new C13654c(c11955v.m71854e(i10), c11955v.m71859l(i10)));
        }
        return arrayList;
    }

    /* renamed from: L */
    public static C11955v m77241L(List<C13654c> list) {
        C11955v.a aVar = new C11955v.a();
        for (C13654c c13654c : list) {
            AbstractC12871a.f58633a.mo71497b(aVar, c13654c.f61383a.m6374I(), c13654c.f61384b.m6374I());
        }
        return aVar.m71864d();
    }

    /* renamed from: M */
    public static String m77242M(String str, int i10, int i11) {
        int iM77237H = m77237H(str, i10, i11);
        return str.substring(iM77237H, m77238I(str, iM77237H, i11));
    }

    /* renamed from: N */
    public static boolean m77243N(String str) {
        return f58651l.matcher(str).matches();
    }

    /* renamed from: b */
    public static void m77245b(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f58650k;
        if (method != null) {
            try {
                method.invoke(th2, th3);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: c */
    public static Charset m77246c(InterfaceC1056f interfaceC1056f, Charset charset) throws IOException {
        int iMo6330S = interfaceC1056f.mo6330S(f58645f);
        if (iMo6330S == -1) {
            return charset;
        }
        if (iMo6330S == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iMo6330S == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iMo6330S == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iMo6330S == 3) {
            return f58646g;
        }
        if (iMo6330S == 4) {
            return f58647h;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public static String m77247d(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (m77253j(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressM77256m = (str.startsWith("[") && str.endsWith("]")) ? m77256m(str, 1, str.length() - 1) : m77256m(str, 0, str.length());
        if (inetAddressM77256m == null) {
            return null;
        }
        byte[] address = inetAddressM77256m.getAddress();
        if (address.length == 16) {
            return m77268y(address);
        }
        if (address.length == 4) {
            return inetAddressM77256m.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    /* renamed from: e */
    public static int m77248e(String str, long j10, TimeUnit timeUnit) {
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

    /* renamed from: f */
    public static void m77249f(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: g */
    public static void m77250g(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (AssertionError | RuntimeException e10) {
                C13893h.m83291l().mo83257s(5, e10.getMessage(), e10);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: h */
    public static void m77251h(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e10) {
                if (!m77230A(e10)) {
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

    /* renamed from: i */
    public static String[] m77252i(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    /* renamed from: j */
    public static boolean m77253j(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public static int m77254k(char c10) {
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

    /* renamed from: l */
    public static boolean m77255l(String str, int i10, int i11, byte[] bArr, int i12) {
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
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.InetAddress m77256m(java.lang.String r12, int r13, int r14) {
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
            boolean r12 = m77255l(r12, r6, r14, r1, r13)
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
            int r10 = m77254k(r10)
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
        throw new UnsupportedOperationException("Method not decompiled: sx.C12875e.m77256m(java.lang.String, int, int):java.net.InetAddress");
    }

    /* renamed from: n */
    public static int m77257n(String str, int i10, int i11, char c10) {
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: o */
    public static int m77258o(String str, int i10, int i11, String str2) {
        while (i10 < i11) {
            if (str2.indexOf(str.charAt(i10)) != -1) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: p */
    public static boolean m77259p(InterfaceC1076z interfaceC1076z, int i10, TimeUnit timeUnit) {
        try {
            return m77236G(interfaceC1076z, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: q */
    public static String m77260q(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: r */
    public static String m77261r(String str, String str2) {
        try {
            String property = System.getProperty(str);
            return property != null ? property : str2;
        } catch (AccessControlException unused) {
            return str2;
        }
    }

    /* renamed from: s */
    public static String m77262s(C11958y c11958y, boolean z10) {
        String strM71904l;
        if (c11958y.m71904l().contains(":")) {
            strM71904l = "[" + c11958y.m71904l() + "]";
        } else {
            strM71904l = c11958y.m71904l();
        }
        if (!z10 && c11958y.m71909w() == C11958y.m71886d(c11958y.m71896B())) {
            return strM71904l;
        }
        return strM71904l + ":" + c11958y.m71909w();
    }

    /* renamed from: t */
    public static <T> List<T> m77263t(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    @SafeVarargs
    /* renamed from: u */
    public static <T> List<T> m77264u(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: v */
    public static <K, V> Map<K, V> m77265v(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: w */
    public static int m77266w(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: x */
    public static int m77267x(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: y */
    public static String m77268y(byte[] bArr) {
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
        C1054d c1054d = new C1054d();
        while (i11 < bArr.length) {
            if (i11 == i10) {
                c1054d.writeByte(58);
                i11 += i13;
                if (i11 == 16) {
                    c1054d.writeByte(58);
                }
            } else {
                if (i11 > 0) {
                    c1054d.writeByte(58);
                }
                c1054d.mo6333W(((bArr[i11] & 255) << 8) | (bArr[i11 + 1] & 255));
                i11 += 2;
            }
        }
        return c1054d.m6319F();
    }

    /* renamed from: z */
    public static String[] m77269z(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
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
}
