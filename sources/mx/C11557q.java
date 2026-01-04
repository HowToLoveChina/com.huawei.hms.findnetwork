package mx;

import p502nx.EnumC11761a;
import p502nx.EnumC11762b;
import p502nx.EnumC11763c;
import p502nx.EnumC11764d;
import p502nx.EnumC11765e;

/* renamed from: mx.q */
/* loaded from: classes9.dex */
public class C11557q {

    /* renamed from: a */
    public EnumC11764d f53576a;

    /* renamed from: b */
    public EnumC11763c f53577b;

    /* renamed from: c */
    public boolean f53578c;

    /* renamed from: d */
    public EnumC11765e f53579d;

    /* renamed from: e */
    public boolean f53580e;

    /* renamed from: f */
    public boolean f53581f;

    /* renamed from: g */
    public EnumC11761a f53582g;

    /* renamed from: h */
    public EnumC11762b f53583h;

    /* renamed from: i */
    public boolean f53584i;

    /* renamed from: j */
    public long f53585j;

    /* renamed from: k */
    public String f53586k;

    /* renamed from: l */
    public String f53587l;

    /* renamed from: m */
    public long f53588m;

    /* renamed from: n */
    public long f53589n;

    /* renamed from: o */
    public boolean f53590o;

    /* renamed from: p */
    public boolean f53591p;

    /* renamed from: q */
    public String f53592q;

    /* renamed from: r */
    public String f53593r;

    /* renamed from: s */
    public a f53594s;

    /* renamed from: t */
    public boolean f53595t;

    /* renamed from: mx.q$a */
    public enum a {
        INCLUDE_LINK_ONLY,
        INCLUDE_LINKED_FILE_ONLY,
        INCLUDE_LINK_AND_LINKED_FILE
    }

    public C11557q() {
        this.f53576a = EnumC11764d.DEFLATE;
        this.f53577b = EnumC11763c.NORMAL;
        this.f53578c = false;
        this.f53579d = EnumC11765e.NONE;
        this.f53580e = true;
        this.f53581f = true;
        this.f53582g = EnumC11761a.KEY_STRENGTH_256;
        this.f53583h = EnumC11762b.TWO;
        this.f53584i = true;
        this.f53588m = 0L;
        this.f53589n = -1L;
        this.f53590o = true;
        this.f53591p = true;
        this.f53594s = a.INCLUDE_LINKED_FILE_ONLY;
    }

    /* renamed from: A */
    public void m68984A(long j10) {
        this.f53585j = j10;
    }

    /* renamed from: B */
    public void m68985B(long j10) {
        this.f53589n = j10;
    }

    /* renamed from: C */
    public void m68986C(String str) {
        this.f53587l = str;
    }

    /* renamed from: D */
    public void m68987D(boolean z10) {
        this.f53584i = z10;
    }

    /* renamed from: E */
    public void m68988E(long j10) {
        if (j10 < 0) {
            this.f53588m = 0L;
        } else {
            this.f53588m = j10;
        }
    }

    /* renamed from: F */
    public void m68989F(boolean z10) {
        this.f53590o = z10;
    }

    /* renamed from: a */
    public EnumC11761a m68990a() {
        return this.f53582g;
    }

    /* renamed from: b */
    public EnumC11762b m68991b() {
        return this.f53583h;
    }

    /* renamed from: c */
    public EnumC11763c m68992c() {
        return this.f53577b;
    }

    /* renamed from: d */
    public EnumC11764d m68993d() {
        return this.f53576a;
    }

    /* renamed from: e */
    public String m68994e() {
        return this.f53586k;
    }

    /* renamed from: f */
    public EnumC11765e m68995f() {
        return this.f53579d;
    }

    /* renamed from: g */
    public long m68996g() {
        return this.f53585j;
    }

    /* renamed from: h */
    public long m68997h() {
        return this.f53589n;
    }

    /* renamed from: i */
    public InterfaceC11547g m68998i() {
        return null;
    }

    /* renamed from: j */
    public String m68999j() {
        return this.f53593r;
    }

    /* renamed from: k */
    public String m69000k() {
        return this.f53587l;
    }

    /* renamed from: l */
    public long m69001l() {
        return this.f53588m;
    }

    /* renamed from: m */
    public String m69002m() {
        return this.f53592q;
    }

    /* renamed from: n */
    public a m69003n() {
        return this.f53594s;
    }

    /* renamed from: o */
    public boolean m69004o() {
        return this.f53578c;
    }

    /* renamed from: p */
    public boolean m69005p() {
        return this.f53584i;
    }

    /* renamed from: q */
    public boolean m69006q() {
        return this.f53591p;
    }

    /* renamed from: r */
    public boolean m69007r() {
        return this.f53580e;
    }

    /* renamed from: s */
    public boolean m69008s() {
        return this.f53581f;
    }

    /* renamed from: t */
    public boolean m69009t() {
        return this.f53595t;
    }

    /* renamed from: u */
    public boolean m69010u() {
        return this.f53590o;
    }

    /* renamed from: v */
    public void m69011v(EnumC11763c enumC11763c) {
        this.f53577b = enumC11763c;
    }

    /* renamed from: w */
    public void m69012w(EnumC11764d enumC11764d) {
        this.f53576a = enumC11764d;
    }

    /* renamed from: x */
    public void m69013x(String str) {
        this.f53586k = str;
    }

    /* renamed from: y */
    public void m69014y(boolean z10) {
        this.f53578c = z10;
    }

    /* renamed from: z */
    public void m69015z(EnumC11765e enumC11765e) {
        this.f53579d = enumC11765e;
    }

    public C11557q(C11557q c11557q) {
        this.f53576a = EnumC11764d.DEFLATE;
        this.f53577b = EnumC11763c.NORMAL;
        this.f53578c = false;
        this.f53579d = EnumC11765e.NONE;
        this.f53580e = true;
        this.f53581f = true;
        this.f53582g = EnumC11761a.KEY_STRENGTH_256;
        this.f53583h = EnumC11762b.TWO;
        this.f53584i = true;
        this.f53588m = 0L;
        this.f53589n = -1L;
        this.f53590o = true;
        this.f53591p = true;
        this.f53594s = a.INCLUDE_LINKED_FILE_ONLY;
        this.f53576a = c11557q.m68993d();
        this.f53577b = c11557q.m68992c();
        this.f53578c = c11557q.m69004o();
        this.f53579d = c11557q.m68995f();
        this.f53580e = c11557q.m69007r();
        this.f53581f = c11557q.m69008s();
        this.f53582g = c11557q.m68990a();
        this.f53583h = c11557q.m68991b();
        this.f53584i = c11557q.m69005p();
        this.f53585j = c11557q.m68996g();
        this.f53586k = c11557q.m68994e();
        this.f53587l = c11557q.m69000k();
        this.f53588m = c11557q.m69001l();
        this.f53589n = c11557q.m68997h();
        this.f53590o = c11557q.m69010u();
        this.f53591p = c11557q.m69006q();
        this.f53592q = c11557q.m69002m();
        this.f53593r = c11557q.m68999j();
        this.f53594s = c11557q.m69003n();
        c11557q.m68998i();
        this.f53595t = c11557q.m69009t();
    }
}
