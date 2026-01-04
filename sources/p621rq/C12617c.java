package p621rq;

/* renamed from: rq.c */
/* loaded from: classes8.dex */
public final class C12617c extends AbstractC12616b {

    /* renamed from: u */
    public static C12617c f58052u;

    /* renamed from: p */
    public static synchronized C12617c m76132p() {
        try {
            if (f58052u == null) {
                f58052u = new C12617c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f58052u;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: b */
    public void mo76118b(String str, String str2, String str3) {
        this.f58036e = str;
        this.f58041j = str2;
        this.f58037f = str3;
        m76134r();
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: c */
    public String mo76119c() {
        return this.f58032a;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: d */
    public String mo76120d() {
        return this.f58034c;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: e */
    public String mo76121e() {
        return this.f58035d;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: f */
    public String mo76122f() {
        return this.f58039h;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: g */
    public String mo76123g() {
        return this.f58038g;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: h */
    public String mo76124h() {
        return this.f58040i;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: i */
    public String mo76125i() {
        return this.f58042k;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: j */
    public String mo76126j() {
        return this.f58043l;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: k */
    public String mo76127k() {
        return this.f58045n;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: l */
    public String mo76128l() {
        return this.f58049r;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: m */
    public String mo76129m() {
        return this.f58050s;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: n */
    public String mo76130n() {
        return this.f58046o;
    }

    @Override // p621rq.AbstractC12616b
    /* renamed from: o */
    public String mo76131o() {
        return this.f58047p;
    }

    /* renamed from: q */
    public String m76133q() {
        return this.f58041j;
    }

    /* renamed from: r */
    public final void m76134r() {
        this.f58048q = this.f58036e + "/CAS/remoteLogin";
        this.f58033b = this.f58036e + "/CAS/mobile/standard/welcome.html";
        this.f58032a = this.f58036e + "/CAS/mobile/standard/wapLogin.html";
        this.f58034c = this.f58036e + "/AMW/portal/userCenter/index.html";
        this.f58035d = this.f58036e + "/AMW/mobile/userCenter/oauth/appList.html";
        this.f58039h = this.f58036e + "/CAS/atRemoteLogin";
        this.f58040i = this.f58036e + "/CAS/weixin/codeAuthorize";
        this.f58042k = this.f58036e + "/CAS/mobile/qrLogin.html?";
        this.f58038g = this.f58037f + "/oauth2/v3/authorize?";
        this.f58043l = this.f58036e + "/CAS/mobile/chkUserPwd.html?";
        this.f58044m = this.f58041j + "/AccountServer/IUserDeviceMng/getDevAuthCode";
        this.f58045n = this.f58036e + "/CAS/mobile/atRemoteLogin.html?";
        this.f58046o = this.f58036e + "/AMW/portal/userCenter/wap_userinfo.html";
        this.f58047p = this.f58036e + "/AMW/mobile/userCenter/privacyCenter/index.html";
        this.f58049r = this.f58036e + "/RealNameW/userCenter/realNameStatus.html";
        this.f58050s = this.f58036e + "/AMW/mobile/children/childInfo.html";
    }
}
