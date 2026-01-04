package p701v6;

import com.huawei.android.p069cg.event.C2277a;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;
import okhttp3.C11912b0;
import okhttp3.C11945l;
import okhttp3.C11949p;
import p031b7.C1120a;
import p373iu.C10617e;
import so.C12819a;

/* renamed from: v6.e */
/* loaded from: classes2.dex */
public class C13358e {

    /* renamed from: v6.e$a */
    public static class a {

        /* renamed from: a */
        public static C11912b0 f60225a;

        /* renamed from: b */
        public static C11912b0 f60226b;

        /* renamed from: c */
        public static C11912b0 f60227c;
    }

    /* renamed from: a */
    public static C11912b0.c m80138a() {
        C11912b0.c cVar = new C11912b0.c();
        C11912b0.c cVarM71508e = cVar.m71508e(new C11945l(8, 10L, TimeUnit.MINUTES));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long j10 = 60;
        cVarM71508e.m71507d(20L, timeUnit).m71522s(j10, timeUnit).m71519p(j10, timeUnit).m71516m(60L, timeUnit);
        try {
            cVar.m71521r(C12819a.m76967d(), C12819a.m76968e()).m71515l(C10617e.f51042j);
        } catch (IOException | IllegalAccessException | GeneralSecurityException unused) {
            C1120a.m6678w("OkHttpClientRequest", "Use Default Dispatcher OkHttpClient");
        }
        return cVar;
    }

    /* renamed from: b */
    public static C11949p m80139b(int i10) {
        C11949p c11949p = new C11949p();
        c11949p.m71838o(i10 == 2 ? 10 : 32);
        return c11949p;
    }

    /* renamed from: c */
    public static C11912b0 m80140c(int i10) {
        C11912b0.c cVarM80138a = m80138a();
        cVarM80138a.m71510g(m80139b(i10));
        if (i10 == 2) {
            cVarM80138a.m71512i(new C2277a());
        }
        return cVarM80138a.m71505b();
    }

    /* renamed from: d */
    public static C11912b0 m80141d(int i10) {
        synchronized (C13358e.class) {
            try {
                if (i10 == 2) {
                    if (a.f60227c == null) {
                        C11912b0 unused = a.f60227c = m80140c(i10);
                    }
                    return a.f60227c;
                }
                if (i10 == 3) {
                    if (a.f60226b == null) {
                        C11912b0 unused2 = a.f60226b = m80140c(i10);
                    }
                    return a.f60226b;
                }
                if (a.f60225a == null) {
                    C11912b0 unused3 = a.f60225a = m80140c(i10);
                }
                return a.f60225a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public static void m80142e() {
        synchronized (C13358e.class) {
            C11912b0 unused = a.f60225a = null;
            C11912b0 unused2 = a.f60227c = null;
            C11912b0 unused3 = a.f60226b = null;
        }
    }
}
