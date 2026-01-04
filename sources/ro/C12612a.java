package ro;

import com.huawei.hicloud.dnskpr.DnsKprUtil;
import com.huawei.hicloud.request.okhttp.callback.AbstractC4992a;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hwcloudjs.C6618c;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import mu.C11526c;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.InterfaceC11921g;
import p429kk.C11060c;
import p514o9.C11839m;
import so.C12819a;
import tm.C13040c;

/* renamed from: ro.a */
/* loaded from: classes6.dex */
public class C12612a {

    /* renamed from: a */
    public static C11912b0 f58026a;

    /* renamed from: b */
    public static C11912b0 f58027b;

    /* renamed from: ro.a$a */
    public class a implements DnsKprUtil.InterfaceC4895e {

        /* renamed from: a */
        public final /* synthetic */ List f58028a;

        /* renamed from: b */
        public final /* synthetic */ C11912b0 f58029b;

        /* renamed from: c */
        public final /* synthetic */ AbstractC4992a f58030c;

        public a(List list, C11912b0 c11912b0, AbstractC4992a abstractC4992a) {
            this.f58028a = list;
            this.f58029b = c11912b0;
            this.f58030c = abstractC4992a;
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public void run(C11918e0.a aVar, InterfaceC11921g interfaceC11921g) {
        }

        @Override // com.huawei.hicloud.dnskpr.DnsKprUtil.InterfaceC4895e
        public C11922g0 run(C11918e0.a aVar, String str) throws IOException {
            this.f58028a.add(str);
            return this.f58030c.execute(this.f58029b.m71495z(aVar.m71575b()));
        }
    }

    /* renamed from: a */
    public static C11912b0 m76101a() {
        C11912b0 c11912b0;
        synchronized (C12612a.class) {
            try {
                if (f58026a == null) {
                    f58026a = C12819a.m76964a();
                }
                c11912b0 = f58026a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11912b0;
    }

    /* renamed from: b */
    public static C11912b0 m76102b(int i10) {
        C11912b0 c11912b0;
        synchronized (C12612a.class) {
            try {
                C11912b0 c11912b02 = f58027b;
                if (c11912b02 == null) {
                    f58027b = C12819a.m76965b(i10, i10);
                } else if (i10 * 1000 != c11912b02.m71468G()) {
                    C11912b0.c cVarM71494y = f58027b.m71494y();
                    long j10 = i10;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    f58027b = cVarM71494y.m71507d(j10, timeUnit).m71519p(j10, timeUnit).m71522s(j10, timeUnit).m71505b();
                }
                c11912b0 = f58027b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11912b0;
    }

    /* renamed from: c */
    public static C11918e0.a m76103c(String str, AbstractC4992a abstractC4992a, C11060c c11060c) throws C9721b, IOException {
        String strM68805b = C11526c.m68805b(str);
        C11918e0.a aVar = new C11918e0.a();
        if (c11060c != null) {
            c11060c.m66667w(strM68805b);
            try {
                c11060c.m66639E(InetAddress.getByName(strM68805b).getHostAddress());
            } catch (IOException unused) {
                C11839m.m70687e("OkHttpTemplate", "getHostAddress IOException:" + strM68805b);
            }
        }
        aVar.m71586m(str);
        aVar.m71578e(FeedbackWebConstants.HOST, strM68805b);
        abstractC4992a.prepare(aVar);
        return aVar;
    }

    /* renamed from: d */
    public static void m76104d(String str, boolean z10, boolean z11) {
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
    public static <T> T m76105e(String str, AbstractC4992a<T> abstractC4992a, int i10, int i11, C11060c c11060c) throws C9721b {
        C11912b0 c11912b0M76101a;
        if (i10 > 0) {
            c11912b0M76101a = i10 == 50 ? m76101a() : m76102b(i10);
        } else {
            c11912b0M76101a = m76101a();
            i11 = 3;
        }
        return (T) m76109i(c11912b0M76101a, str, abstractC4992a, i11, c11060c, false);
    }

    /* renamed from: f */
    public static <T> T m76106f(String str, AbstractC4992a<T> abstractC4992a, int i10, C11060c c11060c) throws C9721b {
        return (T) m76105e(str, abstractC4992a, 50, i10, c11060c);
    }

    /* renamed from: g */
    public static <T> T m76107g(String str, AbstractC4992a<T> abstractC4992a, C11060c c11060c) throws C9721b {
        return (T) m76106f(str, abstractC4992a, 3, c11060c);
    }

    /* renamed from: h */
    public static <T> T m76108h(String str, AbstractC4992a<T> abstractC4992a, C11060c c11060c, int i10) throws C9721b {
        return (T) m76105e(str, abstractC4992a, i10, 3, c11060c);
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x00c0 A[Catch: all -> 0x0082, TryCatch #1 {all -> 0x0082, blocks: (B:111:0x007e, B:116:0x0089, B:118:0x0097, B:122:0x00a5, B:123:0x00aa, B:121:0x00a1, B:124:0x00ab, B:127:0x00b6, B:129:0x00c0, B:131:0x00e4, B:133:0x010b, B:142:0x0120, B:144:0x0126, B:145:0x013d, B:146:0x015a, B:147:0x015b, B:148:0x0162, B:149:0x0163, B:150:0x016c), top: B:156:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0163 A[SYNTHETIC] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T m76109i(okhttp3.C11912b0 r17, java.lang.String r18, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a<T> r19, int r20, p429kk.C11060c r21, boolean r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ro.C12612a.m76109i(okhttp3.b0, java.lang.String, com.huawei.hicloud.request.okhttp.callback.a, int, kk.c, boolean):java.lang.Object");
    }

    /* renamed from: j */
    public static <T> T m76110j(String str, AbstractC4992a<T> abstractC4992a, int i10, int i11, C11060c c11060c, boolean z10) throws C9721b {
        C11912b0 c11912b0M76101a;
        if (i10 > 0) {
            c11912b0M76101a = i10 == 50 ? m76101a() : m76102b(i10);
        } else {
            c11912b0M76101a = m76101a();
            i11 = 3;
        }
        return (T) m76109i(c11912b0M76101a, str, abstractC4992a, i11, c11060c, z10);
    }

    /* renamed from: k */
    public static int m76111k(IOException iOException) {
        if (iOException instanceof SocketTimeoutException) {
            return ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        }
        if (iOException instanceof UnknownHostException) {
            return 9003;
        }
        return iOException instanceof SSLException ? ConnectionResult.SERVICE_UPDATING : iOException instanceof NoRouteToHostException ? ConnectionResult.SIGN_IN_FAILED : iOException instanceof SocketException ? C6618c.f30770o : iOException instanceof ProtocolException ? 9007 : 9100;
    }
}
