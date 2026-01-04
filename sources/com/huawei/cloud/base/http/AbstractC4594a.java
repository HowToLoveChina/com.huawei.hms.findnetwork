package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4636f;
import com.huawei.cloud.base.util.C4647o;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.huawei.cloud.base.http.a */
/* loaded from: classes.dex */
public abstract class AbstractC4594a implements InterfaceC4605h {

    /* renamed from: a */
    public C4611n f21125a;

    /* renamed from: b */
    public long f21126b;

    public AbstractC4594a(String str) {
        this(str == null ? null : new C4611n(str));
    }

    /* renamed from: d */
    public static long m28152d(InterfaceC4605h interfaceC4605h) throws IOException {
        if (interfaceC4605h.mo28153b()) {
            return C4647o.m28474a(interfaceC4605h);
        }
        return -1L;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    /* renamed from: b */
    public boolean mo28153b() {
        return true;
    }

    /* renamed from: c */
    public long m28154c() throws IOException {
        return m28152d(this);
    }

    /* renamed from: e */
    public final Charset m28155e() {
        C4611n c4611n = this.f21125a;
        return (c4611n == null || c4611n.m28251d() == null) ? C4636f.f21271a : this.f21125a.m28251d();
    }

    /* renamed from: f */
    public final C4611n m28156f() {
        return this.f21125a;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public long getLength() throws IOException {
        if (this.f21126b == -1) {
            this.f21126b = m28154c();
        }
        return this.f21126b;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public String getType() {
        C4611n c4611n = this.f21125a;
        if (c4611n == null) {
            return null;
        }
        return c4611n.m28248a();
    }

    public AbstractC4594a(C4611n c4611n) {
        this.f21126b = -1L;
        this.f21125a = c4611n;
    }
}
