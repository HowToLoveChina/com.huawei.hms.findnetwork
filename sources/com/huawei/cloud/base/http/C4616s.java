package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4650r;
import java.io.IOException;
import java.io.StringReader;
import p477mi.C11472a;

/* renamed from: com.huawei.cloud.base.http.s */
/* loaded from: classes.dex */
public class C4616s extends IOException {
    private static final long serialVersionUID = -1875819453475890043L;

    /* renamed from: a */
    public final int f21227a;

    /* renamed from: b */
    public final String f21228b;

    /* renamed from: c */
    public final transient C4609l f21229c;

    /* renamed from: d */
    public final String f21230d;

    /* renamed from: e */
    public final C11472a f21231e;

    public C4616s(C4615r c4615r) {
        this(new a(c4615r));
    }

    /* renamed from: b */
    public static StringBuilder m28318b(C4615r c4615r) {
        StringBuilder sb2 = new StringBuilder();
        int iM28311h = c4615r.m28311h();
        if (iM28311h != 0) {
            sb2.append(iM28311h);
        }
        String strM28312i = c4615r.m28312i();
        if (strM28312i != null) {
            if (iM28311h != 0) {
                sb2.append(' ');
            }
            sb2.append(strM28312i);
        }
        return sb2;
    }

    /* renamed from: c */
    public final String m28319c() {
        return this.f21230d;
    }

    /* renamed from: d */
    public final C11472a m28320d() {
        return this.f21231e;
    }

    /* renamed from: e */
    public C4609l m28321e() {
        return this.f21229c;
    }

    /* renamed from: f */
    public final int m28322f() {
        return this.f21227a;
    }

    /* renamed from: g */
    public final String m28323g() {
        return this.f21228b;
    }

    public C4616s(a aVar) {
        super(aVar.f21236e);
        this.f21227a = aVar.f21232a;
        this.f21228b = aVar.f21233b;
        this.f21229c = aVar.f21234c;
        this.f21230d = aVar.f21235d;
        this.f21231e = aVar.f21237f;
    }

    /* renamed from: com.huawei.cloud.base.http.s$a */
    public static class a {

        /* renamed from: a */
        public int f21232a;

        /* renamed from: b */
        public String f21233b;

        /* renamed from: c */
        public C4609l f21234c;

        /* renamed from: d */
        public String f21235d;

        /* renamed from: e */
        public String f21236e;

        /* renamed from: f */
        public C11472a f21237f;

        public a(int i10, String str, C4609l c4609l) {
            m28329f(i10);
            m28330g(str);
            m28327d(c4609l);
        }

        /* renamed from: a */
        public C4616s m28324a() {
            return new C4616s(this);
        }

        /* renamed from: b */
        public a m28325b(String str) {
            this.f21235d = str;
            return this;
        }

        /* renamed from: c */
        public a m28326c(C11472a c11472a) {
            this.f21237f = c11472a;
            return this;
        }

        /* renamed from: d */
        public a m28327d(C4609l c4609l) {
            this.f21234c = (C4609l) C4627a0.m28391d(c4609l);
            return this;
        }

        /* renamed from: e */
        public a m28328e(String str) {
            this.f21236e = str;
            return this;
        }

        /* renamed from: f */
        public a m28329f(int i10) {
            C4627a0.m28388a(i10 >= 0);
            this.f21232a = i10;
            return this;
        }

        /* renamed from: g */
        public a m28330g(String str) {
            this.f21233b = str;
            return this;
        }

        public a(C4615r c4615r) {
            this(c4615r.m28311h(), c4615r.m28312i(), c4615r.m28308e());
            try {
                this.f21235d = c4615r.m28317n();
                this.f21237f = (C11472a) c4615r.m28310g().m28281m().mo28365b(new StringReader(this.f21235d), C11472a.class);
            } catch (IOException e10) {
                C4650r.m28485f("HttpResponseException").m28489d(e10.toString());
            } catch (IllegalArgumentException unused) {
                C4650r.m28485f("HttpResponseException").m28489d(this.f21235d);
            }
            StringBuilder sbM28318b = C4616s.m28318b(c4615r);
            if (this.f21235d != null) {
                sbM28318b.append(C4633d0.f21267b);
                sbM28318b.append(this.f21235d);
            }
            this.f21236e = sbM28318b.toString();
        }
    }
}
