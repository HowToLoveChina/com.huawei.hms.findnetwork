package so;

import android.content.Context;
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
import p514o9.C11839m;

/* renamed from: so.a */
/* loaded from: classes6.dex */
public class C12819a {
    /* renamed from: a */
    public static C11912b0 m76964a() {
        return m76965b(20, 50);
    }

    /* renamed from: b */
    public static C11912b0 m76965b(int i10, int i11) {
        C11912b0.c cVar = new C11912b0.c();
        cVar.m71513j(true);
        cVar.m71514k(true);
        long j10 = i10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        cVar.m71507d(j10, timeUnit);
        long j11 = i11;
        cVar.m71519p(j11, timeUnit);
        cVar.m71522s(j11, timeUnit);
        cVar.m71508e(new C11945l(8, 5L, TimeUnit.MINUTES));
        cVar.m71516m(59L, timeUnit);
        try {
            cVar.m71521r(m76967d(), m76968e());
            cVar.m71515l(C10617e.f51042j);
        } catch (IOException | IllegalAccessException | GeneralSecurityException unused) {
            C11839m.m70689w("OkHttpClientBuilder", "Use Default Dispatcher OkHttpClient");
        }
        C11949p c11949p = new C11949p();
        c11949p.m71838o(64);
        cVar.m71510g(c11949p);
        return cVar.m71505b();
    }

    /* renamed from: c */
    public static Context m76966c() {
        return C0213f.m1377a();
    }

    /* renamed from: d */
    public static SSLSocketFactory m76967d() throws IllegalAccessException, GeneralSecurityException, IOException {
        return C10618f.m65076c(m76966c(), C10048b.m62471c());
    }

    /* renamed from: e */
    public static X509TrustManager m76968e() throws GeneralSecurityException, IOException {
        return new SecureX509TrustManager(m76966c());
    }
}
