package com.huawei.hms.videokit.player;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.videokit.player.e0 */
/* loaded from: classes8.dex */
public final class C6555e0 extends C6544b0 {

    /* renamed from: b */
    private Context f30441b;

    /* renamed from: c */
    private AtomicBoolean f30442c;

    /* renamed from: d */
    private String f30443d;

    /* renamed from: e */
    private String f30444e;

    /* renamed from: f */
    private long f30445f;

    /* renamed from: g */
    private long f30446g;

    /* renamed from: h */
    private String f30447h;

    /* renamed from: i */
    private String f30448i;

    /* renamed from: j */
    private String f30449j;

    /* renamed from: k */
    private int f30450k;

    /* renamed from: l */
    private long f30451l;

    /* renamed from: m */
    private long f30452m;

    /* renamed from: n */
    private String f30453n;

    /* renamed from: o */
    private C6609y f30454o;

    public C6555e0(Context context) {
        super(context);
        this.f30442c = new AtomicBoolean(false);
        this.f30443d = "";
        this.f30444e = "";
        this.f30445f = 0L;
        this.f30446g = 0L;
        this.f30447h = "";
        this.f30448i = "";
        this.f30449j = "";
        this.f30450k = 0;
        this.f30451l = 0L;
        this.f30452m = 0L;
        this.f30453n = "";
        this.f30441b = context;
        this.f30454o = C6609y.m37724b();
    }

    /* renamed from: g */
    private void m37345g() {
        if (this.f30454o == null) {
            this.f30454o = C6609y.m37724b();
        }
        if (this.f30442c.get()) {
            return;
        }
        C6550c1.m37256a("HttpDataReporter", "HttpProtocol:" + this.f30453n + ", HttpCode:" + this.f30449j);
        C6592p c6592p = new C6592p();
        m37218a(c6592p);
        c6592p.m37591a("NET", C6589n0.m37566b(this.f30441b));
        c6592p.m37591a("X-TRACEID", this.f30443d);
        c6592p.m37591a("IFTYPE", this.f30444e);
        c6592p.m37590a("GRS_STARTTS", this.f30451l);
        c6592p.m37590a("GRS_ENDTS", this.f30452m);
        c6592p.m37590a("STARTTS", this.f30445f);
        c6592p.m37590a("ENDTS", this.f30446g);
        c6592p.m37591a("DOMAINNAME", this.f30447h);
        c6592p.m37591a("CLIENTCODE", this.f30448i);
        c6592p.m37591a("HTTPCODE", this.f30449j);
        c6592p.m37590a("ERRORCODE", this.f30450k);
        c6592p.m37591a("PROTOCOL", this.f30453n);
        this.f30454o.m37725a(1, "VideoKitOM100", c6592p);
    }

    /* renamed from: a */
    public void m37346a(int i10) {
        this.f30450k = i10;
    }

    /* renamed from: b */
    public void m37349b(long j10) {
        this.f30452m = j10;
    }

    /* renamed from: c */
    public void m37351c(long j10) {
        this.f30451l = j10;
    }

    /* renamed from: d */
    public void m37353d(long j10) {
        if (this.f30445f == 0) {
            this.f30445f = j10;
        }
    }

    /* renamed from: e */
    public void m37355e(String str) {
        if (str == null) {
            return;
        }
        this.f30444e = str;
    }

    /* renamed from: f */
    public void m37356f(String str) {
        if (str == null) {
            return;
        }
        this.f30443d = str;
    }

    /* renamed from: h */
    public void m37357h() {
        if (C6609y.m37724b().m37727c()) {
            m37345g();
        } else {
            C6550c1.m37256a("HttpDataReporter", "VideoPlayer reporting channel is off ");
        }
    }

    /* renamed from: i */
    public void m37358i() {
        this.f30443d = "";
        this.f30444e = "";
        this.f30445f = 0L;
        this.f30446g = 0L;
        this.f30447h = "";
        this.f30448i = "";
        this.f30449j = "";
        this.f30450k = 0;
        this.f30453n = "";
        this.f30451l = 0L;
        this.f30452m = 0L;
    }

    /* renamed from: a */
    public void m37347a(long j10) {
        if (this.f30446g == 0) {
            this.f30446g = j10;
        }
    }

    /* renamed from: b */
    public void m37350b(String str) {
        if (str == null) {
            return;
        }
        this.f30447h = str;
    }

    /* renamed from: c */
    public void m37352c(String str) {
        if (str == null) {
            return;
        }
        this.f30449j = str;
    }

    /* renamed from: d */
    public void m37354d(String str) {
        if (str == null) {
            return;
        }
        this.f30453n = str;
    }

    /* renamed from: a */
    public void m37348a(String str) {
        this.f30448i = str;
    }
}
