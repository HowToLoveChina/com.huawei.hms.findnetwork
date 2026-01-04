package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4636f;
import com.huawei.cloud.base.util.C4647o;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.base.util.C4652t;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

/* renamed from: com.huawei.cloud.base.http.r */
/* loaded from: classes.dex */
public final class C4615r {

    /* renamed from: a */
    public AbstractC4623z f21217a;

    /* renamed from: b */
    public final String f21218b;

    /* renamed from: c */
    public final String f21219c;

    /* renamed from: d */
    public final C4611n f21220d;

    /* renamed from: e */
    public final int f21221e;

    /* renamed from: f */
    public final String f21222f;

    /* renamed from: g */
    public final C4612o f21223g;

    /* renamed from: h */
    public InputStream f21224h;

    /* renamed from: i */
    public int f21225i;

    /* renamed from: j */
    public boolean f21226j;

    public C4615r(C4612o c4612o, AbstractC4623z abstractC4623z) throws IOException {
        this.f21223g = c4612o;
        this.f21225i = c4612o.m28275g();
        this.f21217a = abstractC4623z;
        this.f21218b = abstractC4623z.mo28354c();
        int iMo28360i = abstractC4623z.mo28360i();
        iMo28360i = iMo28360i < 0 ? 0 : iMo28360i;
        this.f21221e = iMo28360i;
        String strMo28359h = abstractC4623z.mo28359h();
        this.f21222f = strMo28359h;
        C4650r c4650r = AbstractC4619v.LOGGER;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("-------------- RESPONSE --------------");
        String str = C4633d0.f21267b;
        sb2.append(str);
        String strMo28361j = abstractC4623z.mo28361j();
        if (strMo28361j != null) {
            sb2.append(strMo28361j);
        } else {
            sb2.append(iMo28360i);
            if (strMo28359h != null) {
                sb2.append(' ');
                sb2.append(strMo28359h);
            }
        }
        sb2.append(str);
        c4612o.m28283o().m28231p(abstractC4623z, sb2);
        String strMo28355d = abstractC4623z.mo28355d();
        strMo28355d = strMo28355d == null ? c4612o.m28283o().m28236u() : strMo28355d;
        this.f21219c = strMo28355d;
        this.f21220d = strMo28355d == null ? null : new C4611n(strMo28355d);
        c4650r.m28488c(sb2.toString(), true);
    }

    /* renamed from: a */
    public void m28304a() throws IOException {
        m28314k();
        this.f21217a.mo28352a();
    }

    /* renamed from: b */
    public void m28305b(OutputStream outputStream) throws IOException {
        C4647o.m28475b(m28306c(), outputStream);
    }

    /* renamed from: c */
    public InputStream m28306c() throws Throwable {
        if (!this.f21226j) {
            InputStream inputStreamMo28353b = this.f21217a.mo28353b();
            if (inputStreamMo28353b != null) {
                C4650r c4650r = AbstractC4619v.LOGGER;
                try {
                    try {
                        String str = this.f21218b;
                        if (str != null && str.contains(Constants.GZIP)) {
                            inputStreamMo28353b = new GZIPInputStream(inputStreamMo28353b);
                        }
                        C4652t c4652t = new C4652t(inputStreamMo28353b, c4650r, this.f21225i);
                        try {
                            this.f21224h = c4652t;
                        } catch (EOFException e10) {
                            e = e10;
                            inputStreamMo28353b = c4652t;
                            c4650r.m28487b(e.toString());
                            inputStreamMo28353b.close();
                            this.f21226j = true;
                            return this.f21224h;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStreamMo28353b = c4652t;
                            inputStreamMo28353b.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (EOFException e11) {
                    e = e11;
                }
            }
            this.f21226j = true;
        }
        return this.f21224h;
    }

    /* renamed from: d */
    public Charset m28307d() {
        C4611n c4611n = this.f21220d;
        return (c4611n == null || c4611n.m28251d() == null) ? C4636f.f21271a : this.f21220d.m28251d();
    }

    /* renamed from: e */
    public C4609l m28308e() {
        return this.f21223g.m28283o();
    }

    /* renamed from: f */
    public C4611n m28309f() {
        return this.f21220d;
    }

    /* renamed from: g */
    public C4612o m28310g() {
        return this.f21223g;
    }

    /* renamed from: h */
    public int m28311h() {
        return this.f21221e;
    }

    /* renamed from: i */
    public String m28312i() {
        return this.f21222f;
    }

    /* renamed from: j */
    public final boolean m28313j() throws IOException {
        int iM28311h = m28311h();
        if (!m28310g().m28282n().equals("HEAD") && iM28311h / 100 != 1 && iM28311h != 204 && iM28311h != 304) {
            return true;
        }
        m28314k();
        return false;
    }

    /* renamed from: k */
    public void m28314k() throws IOException {
        InputStream inputStreamM28306c = m28306c();
        if (inputStreamM28306c != null) {
            inputStreamM28306c.close();
        }
    }

    /* renamed from: l */
    public boolean m28315l() {
        return C4618u.m28333b(this.f21221e);
    }

    /* renamed from: m */
    public <T> T m28316m(Class<T> cls) throws IOException {
        if (m28313j()) {
            return (T) this.f21223g.m28281m().mo28364a(m28306c(), m28307d(), cls);
        }
        return null;
    }

    /* renamed from: n */
    public String m28317n() throws Throwable {
        InputStream inputStreamM28306c = m28306c();
        if (inputStreamM28306c == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C4647o.m28475b(inputStreamM28306c, byteArrayOutputStream);
        return byteArrayOutputStream.toString(m28307d().name());
    }
}
