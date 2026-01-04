package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import java.io.InputStream;

/* renamed from: com.huawei.cloud.base.http.x */
/* loaded from: classes.dex */
public final class C4621x extends AbstractC4596b {

    /* renamed from: c */
    public final InputStream f21238c;

    /* renamed from: d */
    public long f21239d;

    /* renamed from: e */
    public boolean f21240e;

    public C4621x(String str, InputStream inputStream) {
        super(str);
        this.f21239d = -1L;
        this.f21238c = (InputStream) C4627a0.m28391d(inputStream);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    /* renamed from: b */
    public boolean mo28153b() {
        return this.f21240e;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4596b
    /* renamed from: c */
    public InputStream mo28163c() {
        return this.f21238c;
    }

    /* renamed from: f */
    public C4621x m28335f(boolean z10) {
        return (C4621x) super.m28164d(z10);
    }

    /* renamed from: g */
    public C4621x m28336g(long j10) {
        this.f21239d = j10;
        return this;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public long getLength() {
        return this.f21239d;
    }

    /* renamed from: h */
    public C4621x m28337h(boolean z10) {
        this.f21240e = z10;
        return this;
    }

    @Override // com.huawei.cloud.base.http.AbstractC4596b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C4621x mo28165e(String str) {
        return (C4621x) super.mo28165e(str);
    }
}
