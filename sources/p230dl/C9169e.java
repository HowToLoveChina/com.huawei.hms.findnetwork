package p230dl;

import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: dl.e */
/* loaded from: classes6.dex */
public class C9169e {

    /* renamed from: e */
    public static volatile C9169e f45979e;

    /* renamed from: a */
    public final ConcurrentHashMap<String, INativeAd> f45980a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public final ConcurrentHashMap<String, a> f45981b = new ConcurrentHashMap<>();

    /* renamed from: c */
    public String f45982c;

    /* renamed from: d */
    public long f45983d;

    /* renamed from: dl.e$a */
    public static class a {

        /* renamed from: a */
        public boolean f45984a;

        /* renamed from: b */
        public boolean f45985b;

        /* renamed from: c */
        public boolean f45986c;

        /* renamed from: d */
        public INativeAd f45987d;

        /* renamed from: e */
        public boolean f45988e;

        /* renamed from: a */
        public INativeAd m57606a() {
            return this.f45987d;
        }

        /* renamed from: b */
        public boolean m57607b() {
            return this.f45986c;
        }

        /* renamed from: c */
        public boolean m57608c() {
            return this.f45985b;
        }

        /* renamed from: d */
        public boolean m57609d() {
            return this.f45984a;
        }

        /* renamed from: e */
        public void m57610e(boolean z10) {
            this.f45986c = z10;
        }

        /* renamed from: f */
        public void m57611f(boolean z10) {
            this.f45988e = z10;
        }

        /* renamed from: g */
        public void m57612g(INativeAd iNativeAd) {
            this.f45987d = iNativeAd;
        }

        /* renamed from: h */
        public void m57613h(boolean z10) {
            this.f45985b = z10;
        }

        /* renamed from: i */
        public void m57614i(boolean z10) {
            this.f45984a = z10;
        }
    }

    /* renamed from: e */
    public static C9169e m57596e() {
        if (f45979e == null) {
            synchronized (C9169e.class) {
                try {
                    if (f45979e == null) {
                        f45979e = new C9169e();
                    }
                } finally {
                }
            }
        }
        return f45979e;
    }

    /* renamed from: a */
    public void m57597a() {
        this.f45980a.clear();
        this.f45981b.clear();
        this.f45982c = null;
        this.f45983d = 0L;
    }

    /* renamed from: b */
    public ConcurrentHashMap<String, INativeAd> m57598b() {
        return this.f45980a;
    }

    /* renamed from: c */
    public String m57599c() {
        return this.f45982c;
    }

    /* renamed from: d */
    public ConcurrentHashMap<String, a> m57600d() {
        return this.f45981b;
    }

    /* renamed from: f */
    public long m57601f() {
        return this.f45983d;
    }

    /* renamed from: g */
    public void m57602g(String str, INativeAd iNativeAd) {
        this.f45980a.put(str, iNativeAd);
    }

    /* renamed from: h */
    public void m57603h(String str, a aVar) {
        this.f45981b.put(str, aVar);
    }

    /* renamed from: i */
    public void m57604i(String str) {
        this.f45982c = str;
    }

    /* renamed from: j */
    public void m57605j(long j10) {
        this.f45983d = j10;
    }
}
