package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.k9 */
/* loaded from: classes8.dex */
public final class C5986k9 implements InterfaceC6023n7.a {

    /* renamed from: a */
    public final List<InterfaceC6023n7> f27312a;

    /* renamed from: b */
    public final C5894d9 f27313b;

    /* renamed from: c */
    public final C6128v8 f27314c;

    /* renamed from: d */
    public final int f27315d;

    /* renamed from: e */
    public final C6101t7 f27316e;

    /* renamed from: f */
    public final InterfaceC6100t6 f27317f;

    /* renamed from: g */
    public final int f27318g;

    /* renamed from: h */
    public final int f27319h;

    /* renamed from: i */
    public final int f27320i;

    /* renamed from: j */
    public int f27321j;

    public C5986k9(List<InterfaceC6023n7> list, C5894d9 c5894d9, C6128v8 c6128v8, int i10, C6101t7 c6101t7, InterfaceC6100t6 interfaceC6100t6, int i11, int i12, int i13) {
        this.f27312a = list;
        this.f27313b = c5894d9;
        this.f27314c = c6128v8;
        this.f27315d = i10;
        this.f27316e = c6101t7;
        this.f27317f = interfaceC6100t6;
        this.f27318g = i11;
        this.f27319h = i12;
        this.f27320i = i13;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: a */
    public InterfaceC6023n7.a mo34619a(int i10, TimeUnit timeUnit) {
        return new C5986k9(this.f27312a, this.f27313b, this.f27314c, this.f27315d, this.f27316e, this.f27317f, this.f27318g, C5920f8.m34231a("timeout", i10, timeUnit), this.f27320i);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: b */
    public int mo34623b() {
        return this.f27320i;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: c */
    public int mo34625c() {
        return this.f27319h;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    public InterfaceC6100t6 call() {
        return this.f27317f;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: d */
    public int mo34627d() {
        return this.f27318g;
    }

    /* renamed from: e */
    public C6128v8 m34628e() {
        C6128v8 c6128v8 = this.f27314c;
        if (c6128v8 != null) {
            return c6128v8;
        }
        throw new IllegalStateException();
    }

    /* renamed from: f */
    public C5894d9 m34629f() {
        return this.f27313b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    public C6101t7 request() {
        return this.f27316e;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: a */
    public C6127v7 mo34620a(C6101t7 c6101t7) throws IOException {
        return m34621a(c6101t7, this.f27313b, this.f27314c);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: b */
    public InterfaceC6023n7.a mo34624b(int i10, TimeUnit timeUnit) {
        return new C5986k9(this.f27312a, this.f27313b, this.f27314c, this.f27315d, this.f27316e, this.f27317f, this.f27318g, this.f27319h, C5920f8.m34231a("timeout", i10, timeUnit));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: c */
    public InterfaceC6023n7.a mo34626c(int i10, TimeUnit timeUnit) {
        return new C5986k9(this.f27312a, this.f27313b, this.f27314c, this.f27315d, this.f27316e, this.f27317f, C5920f8.m34231a("timeout", i10, timeUnit), this.f27319h, this.f27320i);
    }

    /* renamed from: a */
    public C6127v7 m34621a(C6101t7 c6101t7, C5894d9 c5894d9, C6128v8 c6128v8) throws IOException {
        if (this.f27315d >= this.f27312a.size()) {
            throw new AssertionError();
        }
        this.f27321j++;
        C6128v8 c6128v82 = this.f27314c;
        if (c6128v82 == null || c6128v82.m35619b().m35858a(c6101t7.m35423k())) {
            if (this.f27314c == null || this.f27321j <= 1) {
                C5986k9 c5986k9 = new C5986k9(this.f27312a, c5894d9, c6128v8, this.f27315d + 1, c6101t7, this.f27317f, this.f27318g, this.f27319h, this.f27320i);
                InterfaceC6023n7 interfaceC6023n7 = this.f27312a.get(this.f27315d);
                C6127v7 c6127v7Intercept = interfaceC6023n7.intercept(c5986k9);
                if (c6128v8 != null && this.f27315d + 1 < this.f27312a.size() && c5986k9.f27321j != 1) {
                    throw new IllegalStateException("network interceptor " + interfaceC6023n7 + " must call proceed() exactly once");
                }
                if (c6127v7Intercept == null) {
                    throw new NullPointerException("interceptor " + interfaceC6023n7 + " returned null");
                }
                if (c6127v7Intercept.m35585s() != null || c6101t7.m35418f()) {
                    return c6127v7Intercept;
                }
                throw new IllegalStateException("interceptor " + interfaceC6023n7 + " returned a response with no body");
            }
            throw new IllegalStateException("network interceptor " + this.f27312a.get(this.f27315d - 1) + " must call proceed() exactly once");
        }
        throw new IllegalStateException("network interceptor " + this.f27312a.get(this.f27315d - 1) + " must retain the same host and port");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7.a
    /* renamed from: a */
    public InterfaceC6165y6 mo34622a() {
        C6128v8 c6128v8 = this.f27314c;
        if (c6128v8 != null) {
            return c6128v8.m35619b();
        }
        return null;
    }
}
