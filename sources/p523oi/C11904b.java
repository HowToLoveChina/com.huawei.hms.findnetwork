package p523oi;

import com.huawei.hms.drive.C5250d;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import ni.AbstractC11709d;

/* renamed from: oi.b */
/* loaded from: classes.dex */
public class C11904b extends AbstractC11709d {

    /* renamed from: a */
    public final C5250d f55137a;

    /* renamed from: b */
    public final C11903a f55138b;

    public C11904b(C11903a c11903a, C5250d c5250d) {
        this.f55138b = c11903a;
        this.f55137a = c5250d;
        c5250d.m31503a(true);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: a */
    public void mo69837a() throws IOException {
        this.f55137a.m31502a("  ");
    }

    @Override // ni.AbstractC11709d
    /* renamed from: b */
    public void mo69838b() throws IOException {
        this.f55137a.flush();
    }

    @Override // ni.AbstractC11709d
    /* renamed from: g */
    public void mo69843g(boolean z10) throws IOException {
        this.f55137a.m31506b(z10);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: h */
    public void mo69844h() throws IOException {
        this.f55137a.m31504b();
    }

    @Override // ni.AbstractC11709d
    /* renamed from: i */
    public void mo69845i() throws IOException {
        this.f55137a.m31509d();
    }

    @Override // ni.AbstractC11709d
    /* renamed from: j */
    public void mo69846j(String str) throws IOException {
        this.f55137a.m31505b(str);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: k */
    public void mo69847k() throws IOException {
        this.f55137a.m31510e();
    }

    @Override // ni.AbstractC11709d
    /* renamed from: l */
    public void mo69848l(double d10) throws IOException {
        this.f55137a.m31499a(d10);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: m */
    public void mo69849m(float f10) throws IOException {
        this.f55137a.m31499a(f10);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: n */
    public void mo69850n(int i10) throws IOException {
        this.f55137a.m31500a(i10);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: o */
    public void mo69851o(long j10) throws IOException {
        this.f55137a.m31500a(j10);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: p */
    public void mo69852p(BigDecimal bigDecimal) throws IOException {
        this.f55137a.m31501a(bigDecimal);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: q */
    public void mo69853q(BigInteger bigInteger) throws IOException {
        this.f55137a.m31501a(bigInteger);
    }

    @Override // ni.AbstractC11709d
    /* renamed from: r */
    public void mo69854r() throws IOException {
        this.f55137a.m31498a();
    }

    @Override // ni.AbstractC11709d
    /* renamed from: s */
    public void mo69855s() throws IOException {
        this.f55137a.m31507c();
    }

    @Override // ni.AbstractC11709d
    /* renamed from: t */
    public void mo69856t(String str) throws IOException {
        this.f55137a.m31508c(str);
    }
}
