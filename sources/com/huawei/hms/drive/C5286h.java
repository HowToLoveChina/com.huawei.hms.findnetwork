package com.huawei.hms.drive;

import android.content.Context;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.hms.drive.C5198bc;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.drive.h */
/* loaded from: classes8.dex */
public class C5286h implements InterfaceC5288j {

    /* renamed from: a */
    private static final C4650r f24509a = C4650r.m28485f("DefaultOkHttpClientFactory");

    /* renamed from: b */
    private static Context f24510b;

    /* renamed from: com.huawei.hms.drive.h$a */
    public static class a {

        /* renamed from: a */
        private static C5198bc f24511a;
    }

    public C5286h(Context context) {
        f24510b = context;
    }

    /* renamed from: c */
    private static Context m31722c() {
        return f24510b;
    }

    /* renamed from: a */
    public C5198bc m31724a(int i10, int i11) {
        C5198bc.a aVar = new C5198bc.a();
        aVar.m31088b(true);
        aVar.m31085a(true);
        long j10 = i10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.m31080a(j10, timeUnit);
        long j11 = i11;
        aVar.m31087b(j11, timeUnit);
        aVar.m31089c(j11, timeUnit);
        aVar.m31081a(new C5182ao(8, 5L, TimeUnit.MINUTES));
        aVar.m31090d(59L, timeUnit);
        try {
            aVar.m31084a(m31725a(), m31726b());
            aVar.m31083a(C5300v.f24571b);
        } catch (IOException | IllegalAccessException | GeneralSecurityException e10) {
            f24509a.m28487b(e10.toString());
        }
        C5191ax c5191ax = new C5191ax();
        c5191ax.m30884a(64);
        c5191ax.m30940b(8);
        c5191ax.m30941c(10);
        c5191ax.m30942d(8);
        aVar.m31082a(c5191ax);
        return aVar.m31086a();
    }

    /* renamed from: b */
    public X509TrustManager m31726b() throws GeneralSecurityException, IOException {
        return new C5302x(m31722c());
    }

    /* renamed from: a */
    public SSLSocketFactory m31725a() throws IllegalAccessException, GeneralSecurityException, IOException {
        return C5300v.m31825a(m31722c());
    }

    @Override // com.huawei.hms.drive.InterfaceC5288j
    /* renamed from: a */
    public C5198bc mo31723a(int i10) throws IOException, ClassCastException {
        C5198bc c5198bc;
        synchronized (C5286h.class) {
            try {
                if (a.f24511a == null) {
                    C5198bc unused = a.f24511a = m31724a(i10, i10);
                }
                c5198bc = a.f24511a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c5198bc;
    }
}
