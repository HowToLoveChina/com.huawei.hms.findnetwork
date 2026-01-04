package com.huawei.cloud.base.json;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4657y;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import ni.AbstractC11708c;
import ni.AbstractC11710e;
import ni.EnumC11713h;

/* renamed from: com.huawei.cloud.base.json.a */
/* loaded from: classes.dex */
public class C4625a implements InterfaceC4657y {

    /* renamed from: a */
    public final AbstractC11708c f21247a;

    /* renamed from: b */
    public final Set<String> f21248b;

    /* renamed from: com.huawei.cloud.base.json.a$a */
    public static class a {

        /* renamed from: a */
        public final AbstractC11708c f21249a;

        /* renamed from: b */
        public Collection<String> f21250b = new HashSet();

        public a(AbstractC11708c abstractC11708c) {
            this.f21249a = (AbstractC11708c) C4627a0.m28391d(abstractC11708c);
        }

        /* renamed from: a */
        public C4625a m28371a() {
            return new C4625a(this);
        }

        /* renamed from: b */
        public a m28372b(Collection<String> collection) {
            this.f21250b = collection;
            return this;
        }
    }

    public C4625a(AbstractC11708c abstractC11708c) {
        this(new a(abstractC11708c));
    }

    @Override // com.huawei.cloud.base.util.InterfaceC4657y
    /* renamed from: a */
    public <T> T mo28364a(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) m28369f(inputStream, charset, cls);
    }

    @Override // com.huawei.cloud.base.util.InterfaceC4657y
    /* renamed from: b */
    public <T> T mo28365b(Reader reader, Class<T> cls) throws IOException {
        return (T) m28370g(reader, cls);
    }

    /* renamed from: c */
    public final AbstractC11708c m28366c() {
        return this.f21247a;
    }

    /* renamed from: d */
    public Set<String> m28367d() {
        return Collections.unmodifiableSet(this.f21248b);
    }

    /* renamed from: e */
    public final void m28368e(AbstractC11710e abstractC11710e) throws IOException {
        if (this.f21248b.isEmpty()) {
            return;
        }
        try {
            C4627a0.m28390c((abstractC11710e.m69864G(this.f21248b) == null || abstractC11710e.mo69871f() == EnumC11713h.END_OBJECT) ? false : true, "wrapper key(s) not found: %s", this.f21248b);
        } catch (Throwable th2) {
            abstractC11710e.mo69867a();
            throw th2;
        }
    }

    /* renamed from: f */
    public Object m28369f(InputStream inputStream, Charset charset, Type type) throws IOException {
        AbstractC11710e abstractC11710eMo69830c = this.f21247a.mo69830c(inputStream, charset);
        m28368e(abstractC11710eMo69830c);
        return abstractC11710eMo69830c.m69883r(type, true);
    }

    /* renamed from: g */
    public Object m28370g(Reader reader, Type type) throws IOException {
        AbstractC11710e abstractC11710eMo69831d = this.f21247a.mo69831d(reader);
        m28368e(abstractC11710eMo69831d);
        return abstractC11710eMo69831d.m69883r(type, true);
    }

    public C4625a(a aVar) {
        this.f21247a = aVar.f21249a;
        this.f21248b = new HashSet(aVar.f21250b);
    }
}
