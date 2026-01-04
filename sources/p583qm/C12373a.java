package p583qm;

import android.content.Context;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import gu.C10048b;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C11912b0;
import okhttp3.C11945l;
import okhttp3.C11949p;
import p015ak.C0213f;
import p373iu.C10617e;
import p373iu.C10618f;

/* renamed from: qm.a */
/* loaded from: classes6.dex */
public class C12373a {

    /* renamed from: a */
    public static final C4650r f57179a = C4650r.m28485f("HttpClientFactory");

    /* renamed from: qm.a$a */
    public static class a {

        /* renamed from: a */
        public static C11912b0 f57180a;
    }

    /* renamed from: c */
    public static Context m74423c() {
        return C0213f.m1377a();
    }

    /* renamed from: a */
    public C11912b0 m74424a(int i10, int i11) {
        C11912b0.c cVar = new C11912b0.c();
        cVar.m71513j(true);
        cVar.m71514k(true);
        long j10 = i10 == 0 ? 20L : i11;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        cVar.m71507d(j10, timeUnit);
        cVar.m71519p(i11 == 0 ? 50L : i11, timeUnit);
        cVar.m71522s(i11 != 0 ? i11 : 50L, timeUnit);
        cVar.m71508e(new C11945l(8, 5L, TimeUnit.MINUTES));
        cVar.m71516m(59L, timeUnit);
        try {
            cVar.m71521r(m74426d(), m74427e());
            cVar.m71515l(C10617e.f51042j);
        } catch (IOException | IllegalAccessException | GeneralSecurityException e10) {
            f57179a.m28487b(e10.toString());
        }
        C11949p c11949p = new C11949p();
        c11949p.m71838o(64);
        cVar.m71510g(c11949p);
        return cVar.m71505b();
    }

    /* renamed from: b */
    public C11912b0 m74425b(int i10) throws IOException, ClassCastException {
        C11912b0 c11912b0;
        synchronized (C12373a.class) {
            try {
                if (a.f57180a == null) {
                    C11912b0 unused = a.f57180a = m74424a(i10, i10);
                }
                c11912b0 = a.f57180a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11912b0;
    }

    /* renamed from: d */
    public SSLSocketFactory m74426d() throws IllegalAccessException, GeneralSecurityException, IOException {
        return C10618f.m65076c(m74423c(), C10048b.m62471c());
    }

    /* renamed from: e */
    public X509TrustManager m74427e() throws GeneralSecurityException, IOException {
        return new SecureX509TrustManager(m74423c());
    }
}
