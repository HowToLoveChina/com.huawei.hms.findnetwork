package p693ux;

import java.io.IOException;
import java.util.List;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11959z;
import okhttp3.internal.connection.C11932f;
import okhttp3.internal.connection.C11941o;

/* renamed from: ux.g */
/* loaded from: classes9.dex */
public final class C13282g implements InterfaceC11959z.a {

    /* renamed from: a */
    public final List<InterfaceC11959z> f59988a;

    /* renamed from: b */
    public final C11941o f59989b;

    /* renamed from: c */
    public final C11932f f59990c;

    /* renamed from: d */
    public final int f59991d;

    /* renamed from: e */
    public final C11918e0 f59992e;

    /* renamed from: f */
    public final InterfaceC11919f f59993f;

    /* renamed from: g */
    public final int f59994g;

    /* renamed from: h */
    public final int f59995h;

    /* renamed from: i */
    public final int f59996i;

    /* renamed from: j */
    public int f59997j;

    public C13282g(List<InterfaceC11959z> list, C11941o c11941o, C11932f c11932f, int i10, C11918e0 c11918e0, InterfaceC11919f interfaceC11919f, int i11, int i12, int i13) {
        this.f59988a = list;
        this.f59989b = c11941o;
        this.f59990c = c11932f;
        this.f59991d = i10;
        this.f59992e = c11918e0;
        this.f59993f = interfaceC11919f;
        this.f59994g = i11;
        this.f59995h = i12;
        this.f59996i = i13;
    }

    @Override // okhttp3.InterfaceC11959z.a
    /* renamed from: a */
    public int mo71932a() {
        return this.f59995h;
    }

    @Override // okhttp3.InterfaceC11959z.a
    /* renamed from: b */
    public int mo71933b() {
        return this.f59996i;
    }

    @Override // okhttp3.InterfaceC11959z.a
    /* renamed from: c */
    public C11922g0 mo71934c(C11918e0 c11918e0) throws IOException {
        return m79725f(c11918e0, this.f59989b, this.f59990c);
    }

    @Override // okhttp3.InterfaceC11959z.a
    /* renamed from: d */
    public int mo71935d() {
        return this.f59994g;
    }

    /* renamed from: e */
    public C11932f m79724e() {
        C11932f c11932f = this.f59990c;
        if (c11932f != null) {
            return c11932f;
        }
        throw new IllegalStateException();
    }

    /* renamed from: f */
    public C11922g0 m79725f(C11918e0 c11918e0, C11941o c11941o, C11932f c11932f) throws IOException {
        if (this.f59991d >= this.f59988a.size()) {
            throw new AssertionError();
        }
        this.f59997j++;
        C11932f c11932f2 = this.f59990c;
        if (c11932f2 != null && !c11932f2.m71683c().m71733y(c11918e0.m71573m())) {
            throw new IllegalStateException("network interceptor " + this.f59988a.get(this.f59991d - 1) + " must retain the same host and port");
        }
        if (this.f59990c != null && this.f59997j > 1) {
            throw new IllegalStateException("network interceptor " + this.f59988a.get(this.f59991d - 1) + " must call proceed() exactly once");
        }
        C13282g c13282g = new C13282g(this.f59988a, c11941o, c11932f, this.f59991d + 1, c11918e0, this.f59993f, this.f59994g, this.f59995h, this.f59996i);
        InterfaceC11959z interfaceC11959z = this.f59988a.get(this.f59991d);
        C11922g0 c11922g0Mo71677a = interfaceC11959z.mo71677a(c13282g);
        if (c11932f != null && this.f59991d + 1 < this.f59988a.size() && c13282g.f59997j != 1) {
            throw new IllegalStateException("network interceptor " + interfaceC11959z + " must call proceed() exactly once");
        }
        if (c11922g0Mo71677a == null) {
            throw new NullPointerException("interceptor " + interfaceC11959z + " returned null");
        }
        if (c11922g0Mo71677a.m71595s() != null || c11918e0.m71567g()) {
            return c11922g0Mo71677a;
        }
        throw new IllegalStateException("interceptor " + interfaceC11959z + " returned a response with no body");
    }

    /* renamed from: g */
    public C11941o m79726g() {
        return this.f59989b;
    }

    @Override // okhttp3.InterfaceC11959z.a
    public C11918e0 request() {
        return this.f59992e;
    }
}
