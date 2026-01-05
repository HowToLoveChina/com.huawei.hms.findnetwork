package p527on;

import com.huawei.hicloud.dnskpr.DnsKprUtil;
import com.huawei.hicloud.okhttp.callback.AbstractC4975a;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hwcloudjs.C6618c;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import mu.C11526c;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.InterfaceC11921g;
import p399jk.AbstractC10896a;
import p429kk.C11060c;
import p584qn.C12380a;
import pn.C12200a;
import tm.C13040c;

/* renamed from: on.a */
/* loaded from: classes6.dex */
public class C11976a {

    /* renamed from: a */
    public static C11912b0 f55744a;

    /* renamed from: b */
    public static C11912b0 f55745b;

    /* renamed from: on.a$a */
    public class a implements DnsKprUtil.InterfaceC4895e {

        /* renamed from: a */
        public final /* synthetic */ List f55746a;

        /* renamed from: b */
        public final /* synthetic */ C11912b0 f55747b;

        /* renamed from: c */
        public final /* synthetic */ AbstractC4975a f55748c;

        public a(List list, C11912b0 c11912b0, AbstractC4975a abstractC4975a) {
            this.f55746a = list;
            this.f55747b = c11912b0;
            this.f55748c = abstractC4975a;
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public void run(HttpRequestBuilder.a aVar, InterfaceC11921g interfaceC11921g) {
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public HttpResponseBuilder run(HttpRequestBuilder.a aVar, String str) throws IOException {
            this.f55746a.add(str);
            return this.f55748c.execute(this.f55747b.m71495z(aVar.m71575b()));
        }
    }

    /* renamed from: a */
    public static C11912b0 m72080a() {
        C11912b0 c11912b0;
        synchronized (C11976a.class) {
            try {
                if (f55744a == null) {
                    f55744a = C12200a.m73347a();
                }
                c11912b0 = f55744a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11912b0;
    }

    /* renamed from: b */
    public static C11912b0 m72081b(int i10) {
        C11912b0 c11912b0;
        synchronized (C11976a.class) {
            try {
                C11912b0 c11912b02 = f55745b;
                if (c11912b02 == null) {
                    f55745b = C12200a.m73348b(i10, i10);
                } else if (i10 * 1000 != c11912b02.m71468G()) {
                    C11912b0.c cVarM71494y = f55745b.m71494y();
                    long j10 = i10;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    f55745b = cVarM71494y.m71507d(j10, timeUnit).m71519p(j10, timeUnit).m71522s(j10, timeUnit).m71504a(new C12380a()).m71505b();
                }
                c11912b0 = f55745b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11912b0;
    }

    /* renamed from: c */
    public static HttpRequestBuilder.a m72082c(String str, AbstractC4975a abstractC4975a, C11060c c11060c) throws C9721b, IOException {
        String strM68805b = C11526c.m68805b(str);
        HttpRequestBuilder.a aVar = new HttpRequestBuilder.a();
        if (c11060c != null) {
            c11060c.m66667w(strM68805b);
            try {
                c11060c.m66639E(InetAddress.getByName(strM68805b).getHostAddress());
            } catch (IOException unused) {
                AbstractC10896a.m65886e("OkHttpTemplate", "getHostAddress IOException:" + strM68805b);
            }
        }
        aVar.m71587n(m72089j(str));
        aVar.m71578e(FeedbackWebConstants.HOST, strM68805b);
        abstractC4975a.prepare(aVar);
        return aVar;
    }

    /* renamed from: d */
    public static void m72083d(String str, boolean z10, boolean z11) {
        if (z10) {
            return;
        }
        if (z11) {
            C13040c.m78609F().m78660m0(str);
        } else {
            C13040c.m78609F().m78658l0(str);
        }
    }

    /* renamed from: e */
    public static <T> T m72084e(String str, AbstractC4975a<T> abstractC4975a, int i10, int i11, C11060c c11060c) throws C9721b {
        C11912b0 c11912b0M72080a;
        if (i10 > 0) {
            c11912b0M72080a = i10 == 50 ? m72080a() : m72081b(i10);
        } else {
            c11912b0M72080a = m72080a();
            i11 = 3;
        }
        return (T) m72087h(c11912b0M72080a, str, abstractC4975a, i11, c11060c);
    }

    /* renamed from: f */
    public static <T> T m72085f(String str, AbstractC4975a<T> abstractC4975a, int i10, C11060c c11060c) throws C9721b {
        return (T) m72084e(str, abstractC4975a, 50, i10, c11060c);
    }

    /* renamed from: g */
    public static <T> T m72086g(String str, AbstractC4975a<T> abstractC4975a, C11060c c11060c) throws C9721b {
        return (T) m72085f(str, abstractC4975a, 3, c11060c);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x00bf A[Catch: all -> 0x009d, TryCatch #5 {all -> 0x009d, blocks: (B:118:0x0079, B:120:0x0080, B:122:0x0089, B:126:0x0097, B:127:0x009c, B:125:0x0093, B:132:0x00a4, B:138:0x00b5, B:140:0x00bf, B:142:0x00e3, B:144:0x010a, B:153:0x011f, B:155:0x0125, B:156:0x0135, B:157:0x013a, B:158:0x013b, B:159:0x0142, B:160:0x0143, B:161:0x014c), top: B:172:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0143 A[SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T m72087h(okhttp3.C11912b0 r16, java.lang.String r17, com.huawei.hicloud.okhttp.callback.AbstractC4975a<T> r18, int r19, p429kk.C11060c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p527on.C11976a.m72087h(okhttp3.b0, java.lang.String, com.huawei.hicloud.okhttp.callback.a, int, kk.c):java.lang.Object");
    }

    /* renamed from: i */
    public static int m72088i(IOException iOException) {
        if (iOException instanceof SocketTimeoutException) {
            return ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        }
        if (iOException instanceof UnknownHostException) {
            return 9003;
        }
        return iOException instanceof SSLException ? ConnectionResult.SERVICE_UPDATING : iOException instanceof NoRouteToHostException ? ConnectionResult.SIGN_IN_FAILED : iOException instanceof SocketException ? C6618c.f30770o : iOException instanceof ProtocolException ? 9007 : 9100;
    }

    /* renamed from: j */
    public static URL m72089j(String str) throws C9721b {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, str + " http failure." + e10.toString());
        }
    }
}
