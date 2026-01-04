package p731w7;

import com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;

/* renamed from: w7.d */
/* loaded from: classes2.dex */
public class C13537d<T> {

    /* renamed from: a */
    public final int f60908a;

    /* renamed from: b */
    public final OnResponseListener<T> f60909b;

    /* renamed from: c */
    public int f60910c;

    /* renamed from: d */
    public Response<T> f60911d;

    /* renamed from: w7.d$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = C13537d.this.f60910c;
            if (i10 == -3) {
                C13537d.this.f60909b.mo15146c(C13537d.this.f60908a);
                return;
            }
            if (i10 != -2) {
                if (i10 != -1) {
                    return;
                }
                C13537d.this.f60909b.mo15145b(C13537d.this.f60908a);
            } else {
                if (C13537d.this.f60911d.mo15151c()) {
                    C13537d.this.f60909b.mo15148e(C13537d.this.f60908a, C13537d.this.f60911d);
                } else {
                    C13537d.this.f60909b.mo15144a(C13537d.this.f60908a, C13537d.this.f60911d);
                }
                C13537d.this.f60909b.mo15147d(C13537d.this.f60908a, C13537d.this.f60911d);
            }
        }
    }

    public C13537d(int i10, OnResponseListener<T> onResponseListener) {
        this.f60908a = i10;
        this.f60909b = onResponseListener;
    }

    /* renamed from: h */
    public static <T> C13537d<T> m81446h(int i10, OnResponseListener<T> onResponseListener) {
        return new C13537d<>(i10, onResponseListener);
    }

    /* renamed from: e */
    public C13537d<T> m81447e() {
        this.f60910c = -3;
        return this;
    }

    /* renamed from: f */
    public C13537d<T> m81448f(Response<T> response) {
        this.f60910c = -2;
        this.f60911d = response;
        return this;
    }

    /* renamed from: g */
    public void m81449g() {
        if (this.f60909b == null) {
            return;
        }
        C13535b.m81436a().m81437b(new a());
    }

    /* renamed from: i */
    public C13537d<T> m81450i() {
        this.f60910c = -1;
        return this;
    }
}
