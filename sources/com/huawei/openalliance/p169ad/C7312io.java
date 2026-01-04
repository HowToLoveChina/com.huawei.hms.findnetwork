package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.InterfaceC7320iu;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.openalliance.ad.io */
/* loaded from: classes8.dex */
public class C7312io {

    /* renamed from: a */
    private static final Pattern f33967a = Pattern.compile("(\\d+)-(\\d+)/(\\d+)");

    /* renamed from: b */
    private static final Pattern f33968b = Pattern.compile("(\\d+)/(\\d+)");

    /* renamed from: c */
    private static final Pattern f33969c = Pattern.compile("(\\d+)");

    /* renamed from: d */
    private final C7213ig f33970d;

    /* renamed from: e */
    private final InterfaceC7320iu f33971e;

    /* renamed from: f */
    private final InterfaceC7207ia f33972f;

    /* renamed from: g */
    private Map<String, Long> f33973g;

    /* renamed from: h */
    private C7313ip f33974h;

    /* renamed from: i */
    private InterfaceC7316iq f33975i;

    /* renamed from: j */
    private C7211ie f33976j;

    /* renamed from: k */
    private long f33977k = 157286400;

    /* renamed from: l */
    private InterfaceC7214ih f33978l;

    /* renamed from: m */
    private Context f33979m;

    /* renamed from: com.huawei.openalliance.ad.io$1 */
    public class AnonymousClass1 implements InterfaceC7320iu.a {

        /* renamed from: a */
        final /* synthetic */ Socket f33980a;

        public AnonymousClass1(Socket socket) {
            socket = socket;
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7320iu.a
        /* renamed from: a */
        public void mo45055a(C7322iw c7322iw) {
            AbstractC7185ho.m43818a("ProxyRequestProcessor", "request remote server success:%s,", AbstractC7819dl.m48375a(C7312io.this.f33970d.m43933b()));
            C7312io c7312io = C7312io.this;
            c7312io.m45041a(socket, c7322iw, c7312io.f33970d.m43934c());
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7320iu.a
        /* renamed from: a */
        public void mo45056a(Throwable th2) {
            AbstractC7185ho.m43821b("ProxyRequestProcessor", "request remote server failed:%s, info:%s", AbstractC7819dl.m48375a(C7312io.this.f33970d.m43933b()), th2.getClass().getSimpleName());
            C7312io.this.m45048b(socket);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.io$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f33982a;

        /* renamed from: com.huawei.openalliance.ad.io$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7211ie.m43919a().m43925b(true);
                C7312io.this.f33975i.mo30558a(-3);
            }
        }

        public AnonymousClass2(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zM45057a = C7312io.this.f33974h.m45057a(C7312io.this.f33970d.m43933b(), str);
            AbstractC7185ho.m43821b("ProxyRequestProcessor", "check file valid: %s", Boolean.valueOf(zM45057a));
            if (zM45057a || C7312io.this.f33975i == null) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.io.2.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7211ie.m43919a().m43925b(true);
                    C7312io.this.f33975i.mo30558a(-3);
                }
            });
        }
    }

    public C7312io(Context context, C7213ig c7213ig, InterfaceC7320iu interfaceC7320iu, InterfaceC7207ia interfaceC7207ia, Map<String, Long> map) {
        this.f33970d = c7213ig;
        this.f33971e = interfaceC7320iu;
        this.f33972f = interfaceC7207ia;
        this.f33973g = map;
        Context applicationContext = context.getApplicationContext();
        this.f33979m = applicationContext;
        m45031a(applicationContext);
    }

    /* renamed from: a */
    private long m45028a(String str) {
        String strGroup;
        if (str != null && !str.isEmpty()) {
            Matcher matcher = f33967a.matcher(str);
            if (matcher.find()) {
                return Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1));
            }
            Matcher matcher2 = f33968b.matcher(str);
            if (matcher2.find()) {
                strGroup = matcher2.group(2);
            } else {
                Matcher matcher3 = f33969c.matcher(str);
                if (matcher3.find()) {
                    strGroup = matcher3.group(1);
                }
            }
            return Long.parseLong(strGroup);
        }
        return 0L;
    }

    /* renamed from: b */
    private long m45045b(C7322iw c7322iw) {
        if (c7322iw == null) {
            return 0L;
        }
        String strM45099a = c7322iw.m45104a().m45099a(C5966j2.f27081w);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("ProxyRequestProcessor", "lengthStr: %s", strM45099a);
        }
        if (!TextUtils.isEmpty(strM45099a) && strM45099a.length() >= 3) {
            try {
                return Long.parseLong(strM45099a.substring(1, strM45099a.length() - 1));
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* renamed from: c */
    private boolean m45051c(int i10) {
        return (i10 == 200 || i10 == 206) ? false : true;
    }

    /* renamed from: a */
    private String m45030a(C7322iw c7322iw) {
        String str = String.format(Locale.ENGLISH, "HTTP/1.1 %d %s", Integer.valueOf(c7322iw.m45105b()), c7322iw.m45107d());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        C7319it c7319itM45104a = c7322iw.m45104a();
        for (String str2 : c7319itM45104a.m45098a()) {
            sb2.append(String.format(Locale.ENGLISH, "%s: %s%n", str2, c7319itM45104a.m45099a(str2)));
        }
        sb2.append("\n");
        String string = sb2.toString();
        AbstractC7185ho.m43817a("ProxyRequestProcessor", "headers: " + string);
        return string;
    }

    /* renamed from: b */
    private void m45047b(String str) {
        if (AbstractC7806cz.m48165b(this.f33970d.m43936e())) {
            return;
        }
        this.f33974h = new C7313ip(this.f33979m, this.f33970d.m43936e(), this.f33972f, this.f33970d.m43937f());
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.io.2

            /* renamed from: a */
            final /* synthetic */ String f33982a;

            /* renamed from: com.huawei.openalliance.ad.io$2$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7211ie.m43919a().m43925b(true);
                    C7312io.this.f33975i.mo30558a(-3);
                }
            }

            public AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zM45057a = C7312io.this.f33974h.m45057a(C7312io.this.f33970d.m43933b(), str);
                AbstractC7185ho.m43821b("ProxyRequestProcessor", "check file valid: %s", Boolean.valueOf(zM45057a));
                if (zM45057a || C7312io.this.f33975i == null) {
                    return;
                }
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.io.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7211ie.m43919a().m43925b(true);
                        C7312io.this.f33975i.mo30558a(-3);
                    }
                });
            }
        });
    }

    /* renamed from: a */
    private void m45031a(Context context) {
        this.f33976j = C7211ie.m43919a();
        long jMo43083q = C7124fh.m43316b(context.getApplicationContext()).mo43083q();
        this.f33977k = jMo43083q;
        AbstractC7185ho.m43821b("ProxyRequestProcessor", "init, max data consume is: %s", Long.valueOf(jMo43083q));
    }

    /* renamed from: b */
    public void m45048b(Socket socket) {
        try {
            AbstractC7185ho.m43817a("ProxyRequestProcessor", "close socket");
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
            socket.close();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ProxyRequestProcessor", "close socket failed, %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    private boolean m45049b(int i10) {
        int i11 = i10 / 100;
        return i11 == 4 || i11 == 5;
    }

    /* renamed from: a */
    public void m45052a(InterfaceC7214ih interfaceC7214ih) {
        this.f33978l = interfaceC7214ih;
    }

    /* renamed from: a */
    public void m45053a(InterfaceC7316iq interfaceC7316iq) {
        this.f33975i = interfaceC7316iq;
    }

    /* renamed from: a */
    private void m45034a(C7317ir c7317ir, long j10) {
        this.f33972f.mo43904a(c7317ir);
    }

    /* renamed from: a */
    private void m45035a(C7317ir c7317ir, OutputStream outputStream, long j10, int i10) {
        if (outputStream == null || !m45044a(i10, j10)) {
            return;
        }
        AbstractC7185ho.m43818a("ProxyRequestProcessor", "Get complete resource, %s", c7317ir.m45093a());
        this.f33972f.mo43903a(j10, c7317ir);
        m45047b(AbstractC7731ae.m47469h(this.f33972f.mo43901a(this.f33970d.m43933b(), c7317ir)));
    }

    /* renamed from: a */
    private void m45036a(C7317ir c7317ir, OutputStream outputStream, long j10, byte[] bArr, int i10) throws IOException {
        int iM45095c;
        if (outputStream != null) {
            if (j10 < c7317ir.m45095c()) {
                if (i10 + j10 > c7317ir.m45095c()) {
                    iM45095c = (int) (c7317ir.m45095c() - j10);
                    i10 -= iM45095c;
                    AbstractC7185ho.m43818a("ProxyRequestProcessor", "start: %d, count: %d", Integer.valueOf(iM45095c), Integer.valueOf(i10));
                }
                outputStream.flush();
            }
            iM45095c = 0;
            outputStream.write(bArr, iM45095c, i10);
            outputStream.flush();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(3:151|101|(6:(3:104|161|105)(1:112)|113|(4:115|155|116|117)(1:122)|123|153|124)(1:168))|99|157) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0066, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0067, code lost:
    
        r1 = r11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m45037a(com.huawei.openalliance.p169ad.C7322iw r23, java.io.BufferedOutputStream r24, com.huawei.openalliance.p169ad.C7317ir r25, java.io.OutputStream r26, long r27, long r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7312io.m45037a(com.huawei.openalliance.ad.iw, java.io.BufferedOutputStream, com.huawei.openalliance.ad.ir, java.io.OutputStream, long, long):void");
    }

    /* renamed from: a */
    private void m45038a(C7322iw c7322iw, BufferedOutputStream bufferedOutputStream, String str) {
        long jLongValue;
        long j10;
        long j11;
        long jM45045b;
        int iM45105b = c7322iw.m45105b();
        OutputStream outputStream = null;
        try {
            if (!m45051c(iM45105b)) {
                C7317ir c7317irMo43900a = this.f33972f.mo43900a(this.f33970d.m43933b(), str);
                if (c7317irMo43900a == null) {
                    return;
                }
                OutputStream outputStreamM45094b = c7317irMo43900a.m45094b();
                try {
                    if (iM45105b == 206) {
                        AbstractC7185ho.m43817a("ProxyRequestProcessor", "http status code = 200, request uri:" + this.f33970d.m43933b());
                        jM45045b = m45028a(c7322iw.m45104a().m45099a("Content-Range"));
                        AbstractC7185ho.m43817a("ProxyRequestProcessor", "totalLength:" + jM45045b);
                        jLongValue = this.f33970d.m43935d().longValue();
                    } else {
                        jLongValue = 0;
                        if (iM45105b == 200) {
                            jM45045b = m45045b(c7322iw);
                        } else {
                            j10 = 0;
                            j11 = 0;
                            AbstractC7185ho.m43821b("ProxyRequestProcessor", "totalLength: %s, cost: %s", Long.valueOf(j10), Long.valueOf(C7211ie.m43919a().m43922a(this.f33970d.m43933b())));
                            m45037a(c7322iw, bufferedOutputStream, c7317irMo43900a, outputStreamM45094b, j10, j11);
                            outputStream = outputStreamM45094b;
                        }
                    }
                    j10 = jM45045b;
                    j11 = jLongValue;
                    AbstractC7185ho.m43821b("ProxyRequestProcessor", "totalLength: %s, cost: %s", Long.valueOf(j10), Long.valueOf(C7211ie.m43919a().m43922a(this.f33970d.m43933b())));
                    m45037a(c7322iw, bufferedOutputStream, c7317irMo43900a, outputStreamM45094b, j10, j11);
                    outputStream = outputStreamM45094b;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStreamM45094b;
                    try {
                        AbstractC7185ho.m43821b("ProxyRequestProcessor", "write err: %s", th.getClass().getSimpleName());
                    } finally {
                        AbstractC7805cy.m48142a(outputStream);
                    }
                }
            } else if (m45049b(iM45105b)) {
                m45040a(str, iM45105b);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    private void m45039a(BufferedOutputStream bufferedOutputStream, byte[] bArr, int i10) throws IOException {
        bufferedOutputStream.write(bArr, 0, i10);
        bufferedOutputStream.flush();
    }

    /* renamed from: a */
    private void m45040a(String str, int i10) {
        if (this.f33973g.get(this.f33970d.m43933b() + str) == null) {
            this.f33973g.put(this.f33970d.m43933b() + str, Long.valueOf(System.currentTimeMillis() + 60000));
        }
        for (Map.Entry<String, Long> entry : this.f33973g.entrySet()) {
            Long l10 = this.f33973g.get(entry.getKey());
            if (l10 != null && l10.longValue() < System.currentTimeMillis()) {
                this.f33973g.remove(entry.getKey());
            }
        }
    }

    /* renamed from: a */
    public void m45054a(Socket socket) {
        if (!m45042a()) {
            C7319it c7319it = new C7319it();
            C7213ig c7213ig = this.f33970d;
            if (c7213ig != null && !TextUtils.isEmpty(c7213ig.m43932a())) {
                c7319it.m45100a("Range", this.f33970d.m43932a());
            }
            this.f33971e.mo43952a(new C7321iv(this.f33970d.m43933b(), c7319it, null), new InterfaceC7320iu.a() { // from class: com.huawei.openalliance.ad.io.1

                /* renamed from: a */
                final /* synthetic */ Socket f33980a;

                public AnonymousClass1(Socket socket2) {
                    socket = socket2;
                }

                @Override // com.huawei.openalliance.p169ad.InterfaceC7320iu.a
                /* renamed from: a */
                public void mo45055a(C7322iw c7322iw) {
                    AbstractC7185ho.m43818a("ProxyRequestProcessor", "request remote server success:%s,", AbstractC7819dl.m48375a(C7312io.this.f33970d.m43933b()));
                    C7312io c7312io = C7312io.this;
                    c7312io.m45041a(socket, c7322iw, c7312io.f33970d.m43934c());
                }

                @Override // com.huawei.openalliance.p169ad.InterfaceC7320iu.a
                /* renamed from: a */
                public void mo45056a(Throwable th2) {
                    AbstractC7185ho.m43821b("ProxyRequestProcessor", "request remote server failed:%s, info:%s", AbstractC7819dl.m48375a(C7312io.this.f33970d.m43933b()), th2.getClass().getSimpleName());
                    C7312io.this.m45048b(socket);
                }
            });
            return;
        }
        AbstractC7185ho.m43820b("ProxyRequestProcessor", "max limit, skip.");
        InterfaceC7316iq interfaceC7316iq = this.f33975i;
        if (interfaceC7316iq != null) {
            interfaceC7316iq.mo30558a(-2);
        }
        InterfaceC7214ih interfaceC7214ih = this.f33978l;
        if (interfaceC7214ih != null) {
            interfaceC7214ih.mo43916a();
        }
        m45048b(socket2);
    }

    /* renamed from: a */
    public void m45041a(Socket socket, C7322iw c7322iw, String str) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            AbstractC7185ho.m43817a("ProxyRequestProcessor", "write header to client");
            bufferedOutputStream.write(m45030a(c7322iw).getBytes(Constants.UTF_8));
            m45038a(c7322iw, bufferedOutputStream, str);
            m45048b(socket);
            AbstractC7805cy.m48142a(bufferedOutputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                AbstractC7185ho.m43827d("ProxyRequestProcessor", "write header failed: %s", th.getClass().getSimpleName());
            } finally {
                m45048b(socket);
                AbstractC7805cy.m48142a(bufferedOutputStream2);
            }
        }
    }

    /* renamed from: a */
    private boolean m45042a() {
        return this.f33976j.m43922a(this.f33970d.m43933b()) > this.f33977k;
    }

    /* renamed from: a */
    private boolean m45043a(int i10) {
        return i10 != -1;
    }

    /* renamed from: a */
    private boolean m45044a(int i10, long j10) {
        long j11 = i10;
        if (j11 == j10) {
            return true;
        }
        AbstractC7185ho.m43818a("ProxyRequestProcessor", "isCompleteLocalResource Range bytes: %d", this.f33970d.m43935d());
        Long lM43935d = this.f33970d.m43935d();
        return lM43935d != null && lM43935d.longValue() + j11 == j10;
    }
}
