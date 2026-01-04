package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4647o;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.base.util.C4654v;
import com.huawei.cloud.base.util.InterfaceC4631c0;
import com.huawei.cloud.base.util.InterfaceC4657y;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* renamed from: com.huawei.cloud.base.http.o */
/* loaded from: classes.dex */
public final class C4612o {

    /* renamed from: a */
    public final AbstractC4619v f21193a;

    /* renamed from: b */
    public InterfaceC4608k f21194b;

    /* renamed from: d */
    public InterfaceC4614q f21196d;

    /* renamed from: e */
    public AbstractC4622y f21197e;

    /* renamed from: j */
    public InterfaceC4605h f21202j;

    /* renamed from: k */
    public String f21203k;

    /* renamed from: l */
    public C4604g f21204l;

    /* renamed from: o */
    public InterfaceC4620w f21207o;

    /* renamed from: p */
    public InterfaceC4610m f21208p;

    /* renamed from: q */
    public InterfaceC4617t f21209q;

    /* renamed from: r */
    public InterfaceC4657y f21210r;

    /* renamed from: s */
    public InterfaceC4606i f21211s;

    /* renamed from: v */
    public a f21214v;

    /* renamed from: c */
    public C4609l f21195c = new C4609l();

    /* renamed from: f */
    public boolean f21198f = false;

    /* renamed from: g */
    public C4609l f21199g = new C4609l();

    /* renamed from: h */
    public int f21200h = 3;

    /* renamed from: i */
    public int f21201i = 16384;

    /* renamed from: m */
    public int f21205m = 20000;

    /* renamed from: n */
    public int f21206n = 20000;

    /* renamed from: t */
    public boolean f21212t = true;

    /* renamed from: u */
    public boolean f21213u = true;

    /* renamed from: com.huawei.cloud.base.http.o$a */
    public interface a {
        /* renamed from: a */
        void mo28295a() throws IOException;

        /* renamed from: b */
        void mo28296b(long j10);
    }

    public C4612o(AbstractC4619v abstractC4619v, String str) {
        this.f21193a = abstractC4619v;
        m28264E(str);
    }

    /* renamed from: A */
    public void m28260A(InterfaceC4614q interfaceC4614q) {
        this.f21196d = interfaceC4614q;
    }

    /* renamed from: B */
    public C4612o m28261B(InterfaceC4608k interfaceC4608k) {
        this.f21194b = interfaceC4608k;
        return this;
    }

    /* renamed from: C */
    public C4612o m28262C(InterfaceC4657y interfaceC4657y) {
        this.f21210r = interfaceC4657y;
        return this;
    }

    /* renamed from: D */
    public void m28263D(a aVar) {
        this.f21214v = aVar;
    }

    /* renamed from: E */
    public C4612o m28264E(String str) {
        C4627a0.m28388a(str == null || C4611n.m28246h(str));
        this.f21203k = str;
        return this;
    }

    /* renamed from: F */
    public C4612o m28265F(InterfaceC4617t interfaceC4617t) {
        this.f21209q = interfaceC4617t;
        return this;
    }

    /* renamed from: G */
    public C4612o m28266G(boolean z10) {
        this.f21213u = z10;
        return this;
    }

    /* renamed from: H */
    public C4612o m28267H(InterfaceC4620w interfaceC4620w) {
        this.f21207o = interfaceC4620w;
        return this;
    }

    /* renamed from: I */
    public C4612o m28268I(C4604g c4604g) {
        this.f21204l = (C4604g) C4627a0.m28391d(c4604g);
        return this;
    }

    /* renamed from: a */
    public void m28269a() {
        this.f21198f = true;
        AbstractC4622y abstractC4622y = this.f21197e;
        if (abstractC4622y != null) {
            abstractC4622y.mo28339b();
        }
    }

    /* renamed from: b */
    public final void m28270b(C4609l c4609l, StringBuilder sb2, C4650r c4650r, AbstractC4622y abstractC4622y) throws IOException {
        String strM28240y = c4609l.m28240y();
        String str = "Huawei-Drive-API";
        if (strM28240y != null) {
            str = strM28240y + " Huawei-Drive-API";
        }
        c4609l.m28228T(str);
        C4609l.m28209B(c4609l, sb2, c4650r, abstractC4622y);
        if (c4609l.get("x-hw-trace-id") != null) {
            sb2.append(" -H '");
            sb2.append(c4609l.get("x-hw-trace-id"));
            sb2.append("'");
        }
        c4609l.m28228T(strM28240y);
    }

    /* renamed from: c */
    public final void m28271c(InterfaceC4631c0 interfaceC4631c0, boolean z10, AbstractC4622y abstractC4622y) throws IOException {
        String str;
        long length;
        if (interfaceC4631c0 != null) {
            String type = this.f21202j.getType();
            InterfaceC4631c0 c4654v = new C4654v(interfaceC4631c0, AbstractC4619v.LOGGER, this.f21201i);
            InterfaceC4606i interfaceC4606i = this.f21211s;
            if (interfaceC4606i == null) {
                length = this.f21202j.getLength();
                str = null;
            } else {
                String name = interfaceC4606i.getName();
                C4607j c4607j = new C4607j(c4654v, this.f21211s);
                long jM28474a = z10 ? C4647o.m28474a(c4607j) : -1L;
                str = name;
                c4654v = c4607j;
                length = jM28474a;
            }
            abstractC4622y.m28347k(type);
            abstractC4622y.m28345i(str);
            abstractC4622y.m28346j(length);
            abstractC4622y.m28350n(c4654v);
        }
    }

    /* renamed from: d */
    public C4615r m28272d() throws IOException {
        C4615r c4615rM28273e;
        C4627a0.m28388a(this.f21200h >= 0);
        int i10 = this.f21200h;
        C4627a0.m28391d(this.f21203k);
        C4627a0.m28391d(this.f21204l);
        C4615r c4615r = null;
        while (true) {
            if (c4615r != null) {
                c4615r.m28314k();
            }
            InterfaceC4608k interfaceC4608k = this.f21194b;
            if (interfaceC4608k != null) {
                interfaceC4608k.mo28207c(this);
            }
            String strM28198p = this.f21204l.m28198p();
            AbstractC4622y abstractC4622yBuildRequest = this.f21193a.buildRequest(this.f21203k, strM28198p);
            this.f21197e = abstractC4622yBuildRequest;
            abstractC4622yBuildRequest.m28348l(this.f21196d);
            this.f21197e.m28349m(this.f21214v);
            C4650r c4650r = AbstractC4619v.LOGGER;
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder("curl");
            sb2.append("-------------- REQUEST  --------------");
            String str = C4633d0.f21267b;
            sb2.append(str);
            sb2.append(this.f21203k);
            sb2.append(' ');
            sb2.append(strM28198p);
            sb2.append(str);
            if (!this.f21203k.equals("GET")) {
                sb3.append(" -X ");
                sb3.append(this.f21203k);
            }
            InterfaceC4605h interfaceC4605h = this.f21202j;
            boolean z10 = interfaceC4605h == null || interfaceC4605h.mo28153b();
            m28270b(this.f21195c, sb2, c4650r, this.f21197e);
            m28271c(this.f21202j, z10, this.f21197e);
            c4650r.m28488c(sb2.toString(), true);
            sb3.append(" -- '");
            sb3.append(this.f21204l.m28195A().getAuthority());
            sb3.append(this.f21204l.m28195A().getPath());
            sb3.append("'");
            if (this.f21195c.get("x-hw-trace-id") != null) {
                sb3.append(" -H '");
                sb3.append(this.f21195c.get("x-hw-trace-id"));
                sb3.append("'");
            }
            sb3.append(" << $$$");
            c4650r.m28490g(sb3.toString());
            boolean z11 = z10 && i10 > 0;
            this.f21197e.mo28351o(this.f21205m, this.f21206n);
            if (Thread.interrupted()) {
                throw new InterruptedIOException("Thread has been interrupted.");
            }
            try {
                c4615rM28273e = m28273e(this.f21197e);
                e = null;
            } catch (IOException e10) {
                e = e10;
                if (this.f21198f) {
                    throw e;
                }
                if ((e instanceof InterruptedIOException) && !(e instanceof SocketTimeoutException)) {
                    throw e;
                }
                InterfaceC4610m interfaceC4610m = this.f21208p;
                if (interfaceC4610m == null || !interfaceC4610m.mo28245a(this, z11)) {
                    throw e;
                }
                c4650r.m28492j("exception thrown while executing request:" + e.getMessage());
                c4615rM28273e = null;
            }
            i10--;
            if (!m28290v(c4615rM28273e, z11)) {
                return m28291w(c4615rM28273e, e);
            }
            c4615r = c4615rM28273e;
        }
    }

    /* renamed from: e */
    public final C4615r m28273e(AbstractC4622y abstractC4622y) throws IOException {
        AbstractC4623z abstractC4623zMo28243c = abstractC4622y.mo28243c();
        try {
            return new C4615r(this, abstractC4623zMo28243c);
        } catch (Throwable th2) {
            InputStream inputStreamMo28353b = abstractC4623zMo28243c.mo28353b();
            if (inputStreamMo28353b != null) {
                inputStreamMo28353b.close();
            }
            throw th2;
        }
    }

    /* renamed from: f */
    public InterfaceC4605h m28274f() {
        return this.f21202j;
    }

    /* renamed from: g */
    public int m28275g() {
        return this.f21201i;
    }

    /* renamed from: h */
    public boolean m28276h() {
        return this.f21212t;
    }

    /* renamed from: i */
    public C4609l m28277i() {
        return this.f21195c;
    }

    /* renamed from: j */
    public InterfaceC4610m m28278j() {
        return this.f21208p;
    }

    /* renamed from: k */
    public InterfaceC4608k m28279k() {
        return this.f21194b;
    }

    /* renamed from: l */
    public int m28280l() {
        return this.f21200h;
    }

    /* renamed from: m */
    public final InterfaceC4657y m28281m() {
        return this.f21210r;
    }

    /* renamed from: n */
    public String m28282n() {
        return this.f21203k;
    }

    /* renamed from: o */
    public C4609l m28283o() {
        return this.f21199g;
    }

    /* renamed from: p */
    public InterfaceC4617t m28284p() {
        return this.f21209q;
    }

    /* renamed from: q */
    public boolean m28285q() {
        return this.f21213u;
    }

    /* renamed from: r */
    public AbstractC4619v m28286r() {
        return this.f21193a;
    }

    /* renamed from: s */
    public InterfaceC4620w m28287s() {
        return this.f21207o;
    }

    /* renamed from: t */
    public C4604g m28288t() {
        return this.f21204l;
    }

    /* renamed from: u */
    public boolean m28289u(int i10, C4609l c4609l) {
        String strM28239x = c4609l.m28239x();
        if (!m28276h() || !C4618u.m28332a(i10) || strM28239x == null) {
            return false;
        }
        m28268I(new C4604g(this.f21204l.m28196B(strM28239x)));
        if (i10 == 303) {
            m28264E("GET");
            m28292x(null);
        }
        this.f21195c.m28216G(null);
        this.f21195c.m28222N(null);
        this.f21195c.m28224P(null);
        this.f21195c.m28223O(null);
        this.f21195c.m28226R(null);
        this.f21195c.m28225Q(null);
        return true;
    }

    /* renamed from: v */
    public final boolean m28290v(C4615r c4615r, boolean z10) throws IOException {
        if (c4615r != null) {
            try {
                if (!c4615r.m28315l()) {
                    InterfaceC4620w interfaceC4620w = this.f21207o;
                    boolean zMo28334b = interfaceC4620w != null ? interfaceC4620w.mo28334b(this, c4615r, z10) : false;
                    if (zMo28334b || !m28289u(c4615r.m28311h(), c4615r.m28308e())) {
                        z = zMo28334b;
                    }
                    boolean z11 = z10 & z;
                    if (!z11) {
                        return z11;
                    }
                    c4615r.m28314k();
                    return z11;
                }
            } catch (Throwable th2) {
                c4615r.m28304a();
                throw th2;
            }
        }
        return z10 & (c4615r == null);
    }

    /* renamed from: w */
    public final C4615r m28291w(C4615r c4615r, IOException iOException) throws IOException {
        if (c4615r == null) {
            throw iOException;
        }
        InterfaceC4617t interfaceC4617t = this.f21209q;
        if (interfaceC4617t != null) {
            interfaceC4617t.mo28331a(c4615r);
        }
        if (!this.f21213u || c4615r.m28315l()) {
            return c4615r;
        }
        try {
            throw new C4616s(c4615r);
        } catch (Throwable th2) {
            c4615r.m28304a();
            throw th2;
        }
    }

    /* renamed from: x */
    public C4612o m28292x(InterfaceC4605h interfaceC4605h) {
        this.f21202j = interfaceC4605h;
        return this;
    }

    /* renamed from: y */
    public C4612o m28293y(InterfaceC4606i interfaceC4606i) {
        this.f21211s = interfaceC4606i;
        return this;
    }

    /* renamed from: z */
    public C4612o m28294z(InterfaceC4610m interfaceC4610m) {
        this.f21208p = interfaceC4610m;
        return this;
    }
}
