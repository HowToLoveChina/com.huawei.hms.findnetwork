package p637s9;

import com.huawei.hicloud.request.opengw.bean.UploadCer;
import com.huawei.hms.network.embedded.C5863b6;
import fk.C9721b;
import java.util.concurrent.ExecutionException;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: s9.a */
/* loaded from: classes3.dex */
public class C12765a {

    /* renamed from: e */
    public static C12765a f58415e = new C12765a();

    /* renamed from: a */
    public final Object f58416a = new Object();

    /* renamed from: b */
    public long f58417b;

    /* renamed from: c */
    public UploadCer f58418c;

    /* renamed from: d */
    public C9721b f58419d;

    /* renamed from: s9.a$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public EnumC12999a f58420a;

        /* renamed from: b */
        public String f58421b;

        public a(EnumC12999a enumC12999a, String str) {
            this.f58420a = enumC12999a;
            this.f58421b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C11839m.m70686d("UploadCerCache", "refresh php upload auth. traceID is : " + this.f58421b);
                C12765a.this.m76611h(new C13049a(this.f58420a, this.f58421b).m78745k0());
            } catch (C9721b e10) {
                C11839m.m70687e("UploadCerCache", "get upload auth error." + e10);
                C12765a.this.m76609e(e10);
            }
        }
    }

    /* renamed from: f */
    public static C12765a m76606f() {
        return f58415e;
    }

    /* renamed from: c */
    public UploadCer m76607c(EnumC12999a enumC12999a, String str) throws C9721b {
        UploadCer uploadCerCopy;
        C11839m.m70686d("UploadCerCache", "get upload auth begin.");
        synchronized (this.f58416a) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.f58418c == null || jCurrentTimeMillis - this.f58417b > C5863b6.g.f26453g) {
                    C11839m.m70686d("UploadCerCache", "refresh upload auth.");
                    m76610g(enumC12999a, str);
                    C11839m.m70686d("UploadCerCache", "refresh upload auth end.");
                } else {
                    C11839m.m70686d("UploadCerCache", "get upload auth from cache.");
                }
                uploadCerCopy = this.f58418c.copy();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return uploadCerCopy;
    }

    /* renamed from: d */
    public void m76608d() {
        synchronized (this.f58416a) {
            this.f58417b = 0L;
            this.f58418c = null;
            this.f58419d = null;
        }
    }

    /* renamed from: e */
    public final void m76609e(C9721b c9721b) {
        if (this.f58419d == null) {
            this.f58419d = c9721b;
        }
    }

    /* renamed from: g */
    public final void m76610g(EnumC12999a enumC12999a, String str) throws ExecutionException, InterruptedException, C9721b {
        a aVar = new a(enumC12999a, str);
        C12515a.m75110o().m75172d(aVar);
        try {
            aVar.getFuture().get();
            if (this.f58419d == null) {
                if (this.f58418c == null) {
                    throw new C9721b(4001, "refresh cer is empty, need retry.");
                }
            } else {
                C11839m.m70686d("UploadCerCache", "refresh throw error. traceID is : " + str);
                throw this.f58419d;
            }
        } catch (Exception e10) {
            C11839m.m70689w("UploadCerCache", "wait result error." + e10);
            throw new C9721b(4001, "refresh wait result error." + e10, "refresh");
        }
    }

    /* renamed from: h */
    public final void m76611h(UploadCer uploadCer) {
        this.f58418c = uploadCer;
        this.f58417b = System.currentTimeMillis();
    }
}
